package abstractPrac;

abstract class Animal{
    String name;

    public void sleep(){
        System.out.println(name + "가 자고 있습니다.");
    }

    public abstract void sound();
}

class Dog extends Animal{
    Dog(String name){
        this.name = name;
    }

    @Override
    public void sound(){
        System.out.println(name + "가 멍멍 소리를 냅니다.");
    }
}



class Main {
    public static void main(String[] args) {
        Animal dog = new Dog("강아지");
        dog.sleep();
        dog.sound();
    }
}
