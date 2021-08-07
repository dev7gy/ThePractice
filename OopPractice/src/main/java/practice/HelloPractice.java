package practice;
import practice.day1.PrintObject;

public class HelloPractice {
    public static void main(String[] args) {
        System.out.println("Hello OOP Practice using Java 11");
        // 개행시 \n 대신 System.lineSeparator() 권장
        String oop = "oop";
        String practice = "practice";
        System.out.printf("%s %s%s", oop, practice, System.lineSeparator());

        PrintObject pobj = new PrintObject();
        pobj.variadicArgumentsPrint(1,2,3,5, 8);
    }
    /*
    내포, 중첩 클래스
     */
    public class nestedClass{
    }
}
