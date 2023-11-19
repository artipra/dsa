package stream;

public class Dog {
    private String name;
    private int age;
    private int weight;

    public Dog(String name, int weight, int age){
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public String toString(){
        return "name: "+this.name+" age: "+this.age+" weight: "+this.weight;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return this.age;
    }

    public void setWeight(int weight){
       this.weight = weight;
    }

    public int getWeight(){
        return this.weight;
    }
}
