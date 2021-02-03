package com.pascal.javabasic.differentclass.abstractclass;

/**
 * @auther Pascal
 * @date 2020/11/4 10:39
 */
public abstract class AbstractClass {
    /**
     * 1. 抽象类不能被实例化(初学者很容易犯的错)，如果被实例化，就会报错，编译无法通过。只有抽象类的非抽象子类可以创建对象。
     * <p>
     * 2. 抽象类中不一定包含抽象方法，但是有抽象方法的类必定是抽象类。
     * <p>
     * 3. 抽象类中的抽象方法只是声明，不包含方法体，就是不给出方法的具体实现也就是方法的具体功能。
     * <p>
     * 4. 构造方法，类方法（用 static 修饰的方法）不能声明为抽象方法。
     * <p>
     * 5. 抽象类的子类必须给出抽象类中的抽象方法的具体实现，除非该子类也是抽象类。
     */

    public AbstractClass(int age, String name, long salary) {
        this.age = age;
        this.name = name;
        this.salary = salary;
    }

    int age;
    String name;
    long salary;

    abstract void userPicture();

}
