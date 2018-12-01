package muyi.spring.simple;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author: Jimu Yang
 * @date: 2018/11/25 1:52 PM
 * @descricption: want more.
 */
public class Student {

    private String name;

    private int age;

    @Value("${class.name}")
    private String className;

    public void init() {
        this.name = "xiaoming";
        this.age = 18;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", className='" + className + '\'' +
                '}';
    }
}
