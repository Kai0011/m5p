package com.data.m5p.idworker;

public enum DatacenterId {
    User(1), Module(2), Post(3), Student(4), Bg(5), Tag(6), Relation(7), Comment(8), PostContent(9), Offer(10), Like(11), Collection(12);
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
