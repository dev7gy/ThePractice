package practice;
/*
패키지 이름 짓기
패키지 이름의 중복을 최소화 해야 함.
보통 회사의 도메인명을 패키지 이름에 사용(단, 역순으로)
com.korea.<패키지 이름>

package명과 똑같은 폴더 구조를 만들어야 함. - c# namespace와 유사
*/

/*
javac -d <결과물 저장할 폴더> <컴파일 할 java 파일>
.class 파일에는 바이트 코드가 들어 있음.
java -classpath .\class\ practice.HelloPractice

 .java 파일에는 최고 레벨 public 클래스가 하나만 있어야 함.
 둘 이상일 경우 컴파일 안됨.
 */

/*
내가 만든 라이브러리나 프로그램을 배포하는 방법
C#의 경우 
라이브러리: .dll 파일
프로그램: .exe

JAVA의 경우
.jar파일을 만듦
jar -cf .\HelloPractice.jar .\target\classes\practice
jar는 사실상 .zip 파일

 */

public class HelloPractice {
    public static void main(String[] args) {
        System.out.println("Hello OOP Practice using Java 11");
        // 개행시 \n 대신 System.lineSeparator() 권장
        String oop = "oop";
        String practice = "practice";
        System.out.printf("%s %s%s", oop, practice, System.lineSeparator());
    }
    /*
    내포, 중첩 클래스
     */
    public class nestedClass{

    }
}
