public class Hello {
	public static void main(String args[]) {
		System.out.println("Hello JAVA");
		System.out.println(Hello.class.getSuperclass());
		// 클래스 로더 -> 계층형 구조
		ClassLoader classLoader = Hello.class.getClassLoader();
		System.out.println(classLoader);
		System.out.println(classLoader.getParent());
		System.out.println(classLoader.getParent().getParent());
		OuterClass outerClass = new OuterClass();
	}
}
