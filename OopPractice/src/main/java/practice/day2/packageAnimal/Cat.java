package practice.day2.packageAnimal;

/*
접근 제어자를 주지 않으면 package 접근 제어자
 */
public class Cat {
    String catSound;

    public void talkAnimal(Dog dog) {
        dog.dogSound  = "bowbow";
        // dog.setDogSound("bowbow");
    }
}
