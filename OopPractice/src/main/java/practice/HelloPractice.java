package practice;
import practice.day1.PrintObject;
import practice.day2.DataAbstraction;

public class HelloPractice {
    public static void main(String[] args) {
        System.out.println("Hello OOP Practice using Java 11");
        // 개행시 \n 대신 System.lineSeparator() 권장
        String oop = "oop";
        String practice = "practice";
        System.out.printf("%s %s%s", oop, practice, System.lineSeparator());

        PrintObject pobj = new PrintObject();
        pobj.variadicArgumentsPrint(1,2,3,5, 8);

        DataAbstraction dAbstraction1 =  new DataAbstraction();
        DataAbstraction dAbstraction2 =  new DataAbstraction(2);
        DataAbstraction dAbstraction3 = new DataAbstraction(3, "Hello");
        System.out.printf("dAbstraction1 field: %d%s", dAbstraction1.getField(), System.lineSeparator());
        System.out.printf("dAbstraction2 field: %d%s", dAbstraction2.getField(), System.lineSeparator());
        System.out.printf("dAbstraction3 field: %d%s", dAbstraction3.getField(), System.lineSeparator());
        dAbstraction1.privateObject(dAbstraction2);
        System.out.println("using privateObject function");
        System.out.printf("dAbstraction1 field: %d%s", dAbstraction1.getField(), System.lineSeparator());
        System.out.printf("dAbstraction2 field: %d%s", dAbstraction2.getField(), System.lineSeparator());
    }
    /*
    내포, 중첩 클래스 - class지만 private으로 쓸 수 있음.
     */
    private class nestedClass{
    }
}
