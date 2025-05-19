package inheritancePrac;

class Animal{
    private String name;

    //생성자
    public Animal(String name){
        this.name = name;
    }

    //getter
    public String getName(){
        return name;
    }
}

class Dog extends Animal{
    private int leg;

    public Dog(String name, int leg){
        super(name);
        this.leg = leg;
    }

    public void introduce(){
        System.out.println(getName() + "의 다리 수는" + leg + "개입니다.");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("강아지", 4);
        dog.introduce();
    }
}
