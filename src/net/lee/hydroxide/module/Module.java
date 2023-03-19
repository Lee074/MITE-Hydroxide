package net.lee.hydroxide.module;

public class Module {
    protected final String name;
    protected boolean enable;
    protected Category category;
    protected int key;

    public Module(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;

        if (enable) {
            enable();
        } else {
            disable();
        }
    }
    public void enable() {

    }

    public void disable() {

    }

    //ok
    public void draw() {

    }
    //OK
    public void render(float partialTicks) {

    }
    //ok
    public void update() {

    }
}
