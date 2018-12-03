package muyi.spring.pure;

/**
 * @author: Jimu Yang
 * @date: 2018/11/25 1:52 PM
 * @descricption: want more.
 */
public class Student {

    private String name;

    private int age;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
