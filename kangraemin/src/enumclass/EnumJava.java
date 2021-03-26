package enumclass;

import java.util.Random;

public class EnumJava {
    public static void main(String[] args) {
        Animal.DOG.name();
        Animal.DOG.ordinal();

        int randomIndex = new Random().nextInt(4);
        System.out.println("random index = " + randomIndex);
        Animal animal = Animal.values()[randomIndex];
        System.out.println("animal = " + animal.name());
        switch (animal) {
            case CAT -> System.out.println("CAT !");
            case DOG -> System.out.println("DOG !");
            case DUCK -> System.out.println("DUCK !");
        }
    }


    enum Animal {
        DOG, CAT, PENGUIN, DUCK
    }
}

