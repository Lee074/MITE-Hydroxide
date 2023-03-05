package net.lee.hydroxide.module;

public class Module {
    private final String name;
    private boolean enable;
    private int key;

    //, boolean enable
    public Module(String name) {
        this.name = name;
        //this.enable = enable;
    }

    public String getName() {
        return name;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }


    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }


    public void draw() {

    }

    public void render(float partialTicks) {

    }

    //ok
    public void update() {

    }

    public void key(int key) {

    }
}
