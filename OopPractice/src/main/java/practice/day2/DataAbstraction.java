package practice.day2;

/*
 데이터 추상화 - 캡슐화
 > 멤버변수 접근은 메서드를 통해서만 가능하게 하자!

 개체는 자신의 상태를 스스로 책임져야 함. -> 접근 제어자 사용
 */
public class DataAbstraction {
    public static int count;
    private int field;
    private String memberValue;

    /*
    생성자 코드 중복 피하기
    */
    public DataAbstraction() {
        this(1, "value");
    }

    public DataAbstraction(int field) {
        this(field, "value");
    }

    public DataAbstraction(int field, String memberValue) {
        this.field = field;
        this.memberValue = memberValue;
    }

    public int getField() {
        return field;
    }

    public void setField(int field) {
        this.field = field;
    }

    public String getMemberValue() {
        return memberValue;
    }

    public void setMemberValue(String memberValue) {
        this.memberValue = memberValue;
    }

    /*
    private 사용 용도
    -> 클래스 내부에서 중복되는 코드를 막기 위해 쓰는 방식이라고 보면 된다.
     */

}
