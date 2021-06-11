package com.data.m5p.idworker;

public enum DatacenterId {
    User(1), Module(2), Post(3);
    private long value;

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    private DatacenterId(long value){
        this.value = value;
    }
}
