package practice.day1;
/*
[패키지의 종류]
자바 기본(built-in) vozlwl
이름이 java로 시작하는 패키지들 예) java.lang, java.util

프로그래머가 직접 만든(user-defined)패키지
패지키의 목적 - 이름 충돌 문제를 피할 수 있게 해줌.
 */

/*
[패키지 이름 짓기]
패키지 이름의 중복을 최소화 해야 함.
보통 회사의 도메인명을 패키지 이름에 사용(단, 역순으로)
com.korea.<패키지 이름>

package명과 똑같은 폴더 구조를 만들어야 함. - c# namespace와 유사
*/

/*
[빌드 및 실행]
[- 빌드]
javac -d <결과물 저장할 폴더> <컴파일 할 java 파일>
.class 파일에는 바이트 코드가 들어 있음.

[- 실행]
java -classpath .\class\ practice.HelloPractice
 .java 파일에는 최고 레벨 public 클래스가 하나만 있어야 함.
 둘 이상일 경우 컴파일 안됨.
 */

/*
[내가 만든 라이브러리나 프로그램을 배포하는 방법]
[- C#의 경우]
라이브러리: .dll 파일
프로그램: .exe

[- JAVA의 경우]
.jar파일을 만듦
jar -cf .\HelloPractice.jar .\target\classes\practice
jar는 사실상 .zip 파일

[-- 만든 jar파일 실행]
java -jar lib\HelloPractice.jar => no main manifest attribute, in HelloPractice.jar
 */

public class PrintObject {
    public void variadicArgumentsPrint(int... nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
