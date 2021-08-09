package practice.day2;

import practice.day2.packageAnimal.Dog;

/*
 데이터 추상화 - 캡슐화
 > 멤버변수 접근은 메서드를 통해서만 가능하게 하자!

 개체는 자신의 상태를 스스로 책임져야 함. -> 접근 제어자 사용
 <best practice>
 1. 개체의 멤버변수는 private으로
 2. 새 개체는 유효하도록 -> 생성자로 생성되게 하자
 3. getter는 자유롭게 추가 -> 어떤 개체의 레퍼런스를 반환할때는 주의할 것
 4. setter는 고민 후 추가 -> 개체가 스스로 데이터 상태를 변경하게 해야 함.
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

    /*
    getter-setter
    함수를 통한 데이터 접근의 장점
    1. 멤버 변수를 저장하지 않고 필요할 때마다 getter에서 계산 가능 -> 질량과 중력 멤버 변수로부터 무게를 계산
    2. setter에서 추가적인 로직을 실행할 수 있음 -> 음수의 나이가 인자로 들어올 때 무시
    3. 상속을 통한 다형성 구현 가능 ->  
     */
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
    내부란 개체 내부가 아니라 클래스 내부를 의미함.
     */
    public void privateObject(DataAbstraction da) {
        da.field += 1000;
        this.field += 2000;
    }

    /*
    패키지 접근 제어자 용도
    1. public 대신 패키지 접근 제어자를 사용할 수 있다면 그리 할 것. -> 어떤 패키지 안에서만 사용되는 클래스
    2. 'pubic이 아닌 내포 클래스'를 최상위 클래스로 바꿀때 쓸 것
        - 내포 클래스는 가독성 문제가 생길 수 있음.
        - 따라서 별도의 클래스로 분리시키는 것이 요즘 트렌드
        - 이때 접근 권한을 패키지 내로 제한하는 것이 public 보다 나음.
     */
    public void usePackageDA(Dog dog) {
        // dog.dogSound =
    }
}
