package hello.core.singleton;

/*
 * 싱글톤 객체(스프링 빈)는 상태를 무상태(stateless)로 설계해야 한다.
 * 
 * 특정 클라이언트에 의존적인 필드가 있으면 안된다.
 * 특정 클라이언트가 값을 변경할 수 있는 필드가 있으면 안된다!
 * 가급적 읽기만 가능해야 한다.
 * 필드 대신에 자바에서 공유되지 않는, 지역변수, 파라미터, ThreadLocal 등을 사용해야 한다.
 */
public class StatefulService {

    /* stateful 한 경우
    private int price; //상태를 유지하는 필드

    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price; //여기가 문제!
    }

    public int getPrice() {
        return price;
    }
    */

    /* stateless 한 경우 */
    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        return price;
    }
}