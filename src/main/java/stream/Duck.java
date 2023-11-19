package stream;

public class Duck implements Comparable<Duck> {

    String name;
    String color;
    int age;

    public Duck(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Duck{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Duck o) {
        return this.getName().compareTo(o.getName());
    }
}

