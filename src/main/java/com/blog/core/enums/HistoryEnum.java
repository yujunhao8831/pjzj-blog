package com.blog.core.enums;

/**
 * Created by apple on 15/10/22.
 */
public enum HistoryEnum {

    USER(1000,"用户表");


    private final Integer type;
    private final String name;

    @Override
    public String toString () {
        return "HistoryEnum{" +
                "type=" + type +
                ", name='" + name + '\'' +
                '}';
    }

    //构造器默认也只能是private, 从而保证构造函数只能在内部使用
    private HistoryEnum(Integer type,String name) {
        this.type = type;
        this.name = name;
    }

    public HistoryEnum typeOf(int type) {
        for (HistoryEnum historyEnum : HistoryEnum.values()) {
            if (historyEnum.getType() == type) {
                return historyEnum;
            }
        }
        return null;
    }


    public Integer getType() {
        return type;
    }
    public String getName() {
        return name;
    }

}
