import com.ygunna.tpc.tpcclass.Cat;
import com.ygunna.tpc.tpcclass.Dog;
import com.ygunna.tpc.tpcinterface.Animal;

public class Main {
    public Main() {
    }

    // Animal은 다형성 인수.
    public static void display(Animal r){
        r.eat();
    }
    public static void tpcTotal() {
        Animal dog = new Dog();
        dog.eat();
        display(dog);
        // Up Casting
        Animal cat = new Cat();
        cat.eat();
        display(cat);
        // Down Casting
        ((Cat) cat).night();

        // 다형성 배열
        Animal[] animals = new Animal[2];
        animals[0] = dog;//new com.ygunna.tpc.tpcclass.Dog();
        animals[1] = cat;//new com.ygunna.tpc.tpcclass.Cat();
        System.out.println("com.ygunna.tpc.tpcinterface.Animal List");
        for (Animal animal: animals) {
            animal.eat();
            animal.move();
            if (animal instanceof Cat) {
                ((Cat) animal).night(); //Down Casting
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("====  JavaTPC Total  ====");
        tpcTotal();
    }
}
