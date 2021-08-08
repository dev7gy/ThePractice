package hello.core.singleton;

public class SingletonService {

    /**
     * singleton은 다른 방식으로도 만들 수 있음.
     */
    // static 영역에 class로 하나만 올라감.
    private static final SingletonService instance = new SingletonService();

    /*
    getInstance를 통해 불러서 쓰면, 구체 클래스에 의존하게됨. AppConfig 클래스 안에서 getInstance를 하나씩 호출해야겠지?
     */
    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {
    }

    public void logic() {
        System.out.println("instance  = " + instance + " 싱글톤 객체 로직 호출\n");
    }
}
