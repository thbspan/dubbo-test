package com.test.entity;

import java.io.Serializable;
import java.util.StringJoiner;

public class TestBean implements Serializable {

    private static final long serialVersionUID = 4751413417247538777L;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TestBean.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .toString();
    }
}
