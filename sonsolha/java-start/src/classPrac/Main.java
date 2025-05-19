package classPrac;

class Animal {
    String name;
    int leg;
}

public class Main {
    public static void main(String[] args) {
        Animal animal;
        animal = new Animal();
        animal.name = "강아지";
        animal.leg = 4;

        Animal animal2 = new Animal();
        animal2.name = "고양이";
        animal2.leg = 4;

        //배열과 클래스
        Animal[] animals = new Animal[2];
        animals[0] = animal;
        animals[1] = animal2;

        System.out.println(animals[0].name + "의 다리수는" + animals[0].leg + "개");
        System.out.println(animals[1].name + "의 다리수는" + animals[1].leg + "개");

    }
    }
