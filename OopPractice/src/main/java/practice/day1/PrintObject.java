package practice.day1;
// import java.lang.*은 자동으로 import됨.
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
예시) javac -d .\target\classes\ .\src\main\java\practice\*.java .\src\main\java\practice\day1\*.java
.class 파일에는 바이트 코드가 들어 있음.

[- 실행]
예시) java -classpath .\target\classes\ practice.HelloPractice
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
java -jar .\HelloPractice.jar => no main manifest attribute, in HelloPractice.jar(오류 생성)
[--- 이유 확인]
jar xvf .\HelloPractice.jar 명령어를 통해 jar 파일 압축 풀기
META-INF\MANIFEST.MF 파일 존재

[---- Manifest 파일이란?]
자바 애플리케이션의 정보를 담고 있는 메타데이터 파일
.jar파일을 만들 떄 이 파일을 같이 넣어줄 수 있음.
.jar파일의 시작점(메인함수에 대한 정보를 넣어야 함.)
그 밖에도 여러 정보를 담을 수 있음.

[- JAVA의 경우 2]
.jar파일을 만듦
jar -cf .\HelloPractice.jar .\target\classes\practice
jar xvf .\HelloPractice.jar 로 jar파일 압축을 풀고

Manifest.mf 파일에 main 함수 위치를 알려줌
cat .\META-INF\MANIFEST.mf
{
    Manifest-Version: 1.0
    Created-By: 11.0.11 (AdoptOpenJDK)
    Main-Class: practice.HelloPractice <-- 추가된 줄
}

변경한 MANIFEST.mf 를 적용
jar umf .\META-INF\MANIFEST.MF .\practice.jar

[-- 만든 jar파일 실행 2]
java -jar .\HelloPractice.jar
 */

/*
[JAVA의 실행 모델]
Java는 크로스 플랫폼인가?  - 운영체제나 디바이스의 영향을 받지 않으나, jvm이 없이 돌 수 없다.
JAVA 코드를 컴파일 한 결과는 바이트 코드 - 실행 파일이 아님

바이트(Byte)코드란?
JVM이 이해하는 명령어
JVM이 실행 중에 최종 플랫폼에 맞는 명령어로 바꿔서 실행해 줌.
 */
public class PrintObject {
    public void variadicArgumentsPrint(int... nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
