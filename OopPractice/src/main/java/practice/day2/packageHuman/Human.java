package practice.day2.packageHuman;

import practice.day2.packageAnimal.Dog;

/*
접근 제어자를 주지 않으면 package 접근 제어자
 */
public class Human {
    String humanSound;

    public void talkAnimal(Dog dog) {
        // dog.dogSound  = "bowbow";
        dog.setDogSound("bowbow");
    }
}
