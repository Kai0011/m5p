package com.data.m5p.service;

import com.data.m5p.common.IdWorker;
import com.data.m5p.idworker.DatacenterId;
import com.data.m5p.mapper.ModuleMapper;
import com.data.m5p.pojo.Module;
import com.data.m5p.vo.ModuleVO;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ModuleService {
    @Resource
    private ModuleMapper moduleMapper;

    private IdWorker idWorker = new IdWorker(1, DatacenterId.Module.getValue(), 1);

    public void createModule(Module module) {

        module.setId(idWorker.nextId());
        module.setStatus(1);
        module.setCreateDate(new Date());
        module.setModifiedDate(new Date());
        moduleMapper.insert(module);

        System.out.println(module.getName());
    }

    public Module getModuleById(Long id) throws NotFoundException {
        Module module = moduleMapper.selectByPrimaryKey(id);
        if (module==null) {
            throw new NotFoundException("Module not found");
        }
        return module;
    }

    public List<Module> getModule() {
        return moduleMapper.selectAll();
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

    public static ModuleVO ModuleToModuleVO(Module module){
        ModuleVO moduleVO = new ModuleVO();
        moduleVO.setId(module.getId());
        moduleVO.setName(module.getName());
        moduleVO.setBriefing(module.getBriefing());
        return moduleVO;
    }

    public static List<ModuleVO> ModulesToModuleVOS(List<Module> modules) {
        List<ModuleVO> moduleVOS = new ArrayList<>();
        for(Module module:modules){
            ModuleVO moduleVO = new ModuleVO();
            moduleVO.setId(module.getId());
            moduleVO.setName(module.getName());
            moduleVO.setBriefing(module.getBriefing());
            moduleVOS.add(moduleVO);
        }
        return moduleVOS;
    }
}
