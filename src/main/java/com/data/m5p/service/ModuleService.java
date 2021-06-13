package com.data.m5p.service;

import com.data.m5p.ao.ModuleTagAO;
import com.data.m5p.common.IdWorker;
import com.data.m5p.idworker.DatacenterId;
import com.data.m5p.mapper.ModuleMapper;
import com.data.m5p.mapper.ModuleTagRelationMapper;
import com.data.m5p.mapper.StudentModuleRelationMapper;
import com.data.m5p.mapper.TagMapper;
import com.data.m5p.pojo.*;
import com.data.m5p.pojo.Module;
import com.data.m5p.vo.ModuleTagVO;
import com.data.m5p.vo.ModuleVO;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ModuleService {
    @Resource
    private ModuleMapper moduleMapper;
    @Resource
    private TagMapper tagMapper;
    @Resource
    private ModuleTagRelationMapper moduleTagRelationMapper;
    @Resource
    private StudentModuleRelationMapper studentModuleRelationMapper;

    private IdWorker idWorker1 = new IdWorker(1, DatacenterId.Module.getValue(), 1);
    private IdWorker idWorker2 = new IdWorker(1, DatacenterId.Tag.getValue(), 1);
    private IdWorker idWorker3 = new IdWorker(1, DatacenterId.ModuleTag.getValue(), 1);

    @Transactional
    public void createModule(ModuleTagAO moduleTagAO) {

        Module module = new Module();
        Long moduleId = idWorker1.nextId();
        module.setId(moduleId);
        module.setStatus(1);
        module.setCreateDate(new Date());
        module.setModifiedDate(new Date());
        module.setName(moduleTagAO.getName());
        module.setTime(moduleTagAO.getTime());
        module.setRequirement(moduleTagAO.getRequirement());
        module.setBriefing(moduleTagAO.getBriefing());
        module.setIcon(moduleTagAO.getIcon());
        module.setExtra(moduleTagAO.getExtra());
        moduleMapper.insert(module);

        Long tagId;
        List<Tag> tags = moduleTagAO.getTags();
        for (Tag tag:tags) {
            Tag sameTag = this.findTag(tag.getName());
            if(sameTag==null) {
                tagId = idWorker2.nextId();
                tag.setId(tagId);
                tag.setStatus(1);
                tag.setCreateDate(new Date());
                tag.setModifiedDate(new Date());
                tagMapper.insert(tag);

                ModuleTagRelation moduleTagRelation = new ModuleTagRelation();
                moduleTagRelation.setId(idWorker3.nextId());
                moduleTagRelation.setModuleId(moduleId);
                moduleTagRelation.setTagId(tagId);
                moduleTagRelation.setCreateDate(new Date());
                moduleTagRelation.setModifiedDate(new Date());
                moduleTagRelation.setStatus(1);
                moduleTagRelationMapper.insert(moduleTagRelation);
            }

        }
        System.out.println(module.getName());
    }

    public Module getModuleById(Long id) throws NotFoundException {
        Module module = moduleMapper.selectByPrimaryKey(id);
        if (module==null) {
            throw new NotFoundException("Module not found");
        }
        return module;
    }

    public List<ModuleTagAO> getModule() {

        List<Module> modules = moduleMapper.selectAll();
        List<ModuleTagAO> moduleTagAOS = new ArrayList<>();
        for (Module module:modules) {
            ModuleTagAO moduleTagAO = new ModuleTagAO();
            List<Tag> tags = findTag(module);
            moduleTagAO.setTags(tags);
            moduleTagAO.setId(module.getId());
            moduleTagAO.setName(module.getName());
            moduleTagAO.setTime(module.getTime());
            moduleTagAO.setRequirement(module.getRequirement());
            moduleTagAO.setBriefing(module.getBriefing());
            moduleTagAO.setExtra(module.getExtra());
            moduleTagAOS.add(moduleTagAO);
        }
        return moduleTagAOS;
    }

    public List<ModuleTagAO> getModuleByStudent(Long id) {
        List<Module> modules = this.findModule(id);
        List<ModuleTagAO> moduleTagAOS = new ArrayList<>();
        for (Module module:modules) {
            ModuleTagAO moduleTagAO = new ModuleTagAO();
            List<Tag> tags = findTag(module);
            moduleTagAO.setTags(tags);
            moduleTagAO.setId(module.getId());
            moduleTagAO.setName(module.getName());
            moduleTagAO.setTime(module.getTime());
            moduleTagAO.setRequirement(module.getRequirement());
            moduleTagAO.setBriefing(module.getIcon());
            moduleTagAO.setExtra(module.getExtra());
            moduleTagAOS.add(moduleTagAO);
        }
        return moduleTagAOS;
    }

    public List<Module> findModule(Long id) {
        Example studentModuleExample = new Example(StudentModuleRelation.class);
        Example.Criteria studentModuleCriteria = studentModuleExample.createCriteria();
        studentModuleCriteria.andEqualTo("studentId", id);
        List<Long> ids = new ArrayList<>();
        for (StudentModuleRelation studentModuleRelation:studentModuleRelationMapper.selectByExample(studentModuleExample)) {
            ids.add(studentModuleRelation.getModuleId());
        }

        List<Module> modules = new ArrayList<>();
        for (Long stuId:ids) {
            modules.add(moduleMapper.selectByPrimaryKey(stuId));
        }
        return modules;
    }

    public void updateModule(Module module) {
        module.setModifiedDate(new Date());
        moduleMapper.updateByPrimaryKeySelective(module);

    }

    public void deleteModule(Long id) {

        Module module = this.existModule(id);
        if (module!=null) {
            module.setStatus(0);
        }
        moduleMapper.updateByPrimaryKeySelective(module);
    }

    public Module existModule(Long id) {
        if(moduleMapper.existsWithPrimaryKey(id)) {
            Module module = moduleMapper.selectByPrimaryKey(id);
            if (module.getStatus()==1) {
                return module;
            }
            return null;
        }
        return null;
    }

    public Tag findTag(String name) {
        Example tagExample = new Example(Tag.class);
        Example.Criteria tagCriteria = tagExample.createCriteria();
        tagCriteria.andEqualTo("name", name);
        return tagMapper.selectOneByExample(tagExample);
    }

    public List<Tag> findTag(Module module) {
        Example moduleTagExample = new Example(ModuleTagRelation.class);
        Example.Criteria moduleTagCriteria = moduleTagExample.createCriteria();
        moduleTagCriteria.andEqualTo("moduleId", module.getId());
        List<Long> ids = new ArrayList<>();
        for (ModuleTagRelation moduleTagRelation: moduleTagRelationMapper.selectByExample(moduleTagExample)) {
            ids.add(moduleTagRelation.getTagId());
        }

        List<Tag> tags = new ArrayList<>();
        for (Long id:ids) {
            tags.add(tagMapper.selectByPrimaryKey(id));
        }

        return tags;
    }



    public static ModuleVO ModuleToModuleVO(Module module){
        ModuleVO moduleVO = new ModuleVO();
        moduleVO.setId(module.getId());
        moduleVO.setName(module.getName());
        moduleVO.setTime(module.getTime());
        moduleVO.setRequirement(module.getRequirement());
        moduleVO.setBriefing(module.getBriefing());
        moduleVO.setIcon(module.getIcon());
        moduleVO.setExtra(module.getExtra());
        return moduleVO;
    }

    public static List<ModuleVO> ModulesToModuleVOS(List<Module> modules) {
        List<ModuleVO> moduleVOS = new ArrayList<>();
        for(Module module:modules){
            ModuleVO moduleVO = new ModuleVO();
            moduleVO.setId(module.getId());
            moduleVO.setName(module.getName());
            moduleVO.setTime(module.getTime());
            moduleVO.setRequirement(module.getRequirement());
            moduleVO.setBriefing(module.getBriefing());
            moduleVO.setIcon(module.getIcon());
            moduleVO.setExtra(module.getExtra());
            moduleVOS.add(moduleVO);
        }
        return moduleVOS;
    }

}
