JAVA, JVM, JDK, JRE

JVM: 자바 가상 머신
자바 바이트 코드란? javac로 컴파일 후 만들어진 코드
    JRE: JVM + Library
    JDK: JRE + Development Tool
    JAVA11부터는 JRE만 따로 제공하지 않음

여러 JDK 중에서 오라클에서 만든 Oracle JDK 11버전부터 사용으로  사용할 떄 유료.

JVM 언어:
    꼭 JAVA언어가 아니더라도 JVM에서 구동가능한 형태의 Class(자바바이트코드?)가 나온다면 그건 구동 가능.
    근데 그냥 java로 구동 안됨.
    Compiled from "Hello.java"
--- 바이트 코드 예시: javap -c Hello 로 확인 가능.
public class Hello {
  public Hello();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
       3: ldc           #3                  // String Hello JAVA      
       5: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
       8: return
}
------

JVM 구조

클래스 로더 시스템 {
    로딩, 링크, 초기화
    # .class에서 바이트코드를 읽고 메모리에 저장
    로딩: 클래스를 읽어오는 과정
    링크: 레퍼런스를 연결하는 과정
    초기화: static 값들 초기화 및 변수에 할당
}

메모리 {
    스택, PC레지스터, 네이티브 메소드 스택, 힙, 메소드
    pc레지스터: 프로그램 카운터 레지스터
    네이티브 메소드란? native란 키워드가 붙어있고 java가 아닌 c나 c++로 구현된 메소드를 이야기함.
    public static native Thread currentThread();
}

실행 엔진 {
    인터프리터: 바이트 코드 한줄씩 실행
    JIT 컴파일러: 인터프리터 효율을 높이기 위해, 
    GC(가비지 컬렉터): 더 이상 참조되지 않는 객체를 모아서 정리 한다.
}

흐름 정리: 클래스 로더가 읽어서 메모리에다가 적절하게 배치를 하고 실행할때 실행엔진이 바이트 코드를 한줄씩 실행함. 

------
클래스 로더   

 Hello JAVA
 class java.lang.Object
 sun.misc.Launcher$AppClassLoader@75b84c92
 sun.misc.Launcher$ExtClassLoader@4aa298b7
 Bootstrap 클래스로더가 부모로 있지만 native 메소드로 구현되어 있기 때문에 JAVA 코드로는 확인이 안됨.
 null
 의존성 추가 제대로 안되엇 Class not found exception 뜨는 경우는 클래스 로더가 못읽었을 경우를 말함.