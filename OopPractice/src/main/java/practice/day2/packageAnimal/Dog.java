package practice.day2.packageAnimal;

/*
접근 제어자를 주지 않으면 package 접근 제어자
 */
public class Dog {
    String dogSound;

    public void setDogSound(String dogSound) {
        this.dogSound = dogSound;
    }

    public void talkAnimal(Cat cat) {
        cat.catSound  = "mmmm";
        //dog.setDogSound("bowbow");
    }
}
