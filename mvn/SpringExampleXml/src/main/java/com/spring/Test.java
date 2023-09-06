package com.spring;

public class Test {

    private String name;
    private Long time = System.nanoTime();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    void print(){
        System.out.println("class:Test, method:print()  >>>> " + time);
        System.out.println(this.hashCode());
    }

    void init(){
        System.out.println("init method...");
    }

    public Long getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Test{" +
                "name='" + name + '\'' +
                ", time=" + time +
                '}';
    }
}
