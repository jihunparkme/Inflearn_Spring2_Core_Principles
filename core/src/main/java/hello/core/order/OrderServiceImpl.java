package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor // final이 붙은 필드를 모아서 생성자를 자동으로 만들어줌
public class OrderServiceImpl implements OrderService {
    
    /*
        private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
        추상화(인터페이스)에 의존해야지, 구체화(구현 클래스)에 의존하면 안된다는 DIP(의존관계 역전원칙) 위반 !!

        만일 구현 클래스를 아래와 같이 바꾸는 순간..!
        private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
        확장에서는 열려 있으나 변경에는 닫혀 있어야 한다는 OCP(개방-폐쇄 원칙) 위반!!

        DIP와 OCP를 지키기 위해 인터페이스에만 의존
        private final DiscountPolicy discountPolicy;
        여기서 누군가가 클라이언트에 구현 객체를 대신 생성하고 주입해주어야 하는 문제 발생! -> 생성자를 사용

        의존관계에 대한 고민은 외부에 맡기고 실행에만 집중!
     */

    // 추상화에만 의존. DIP를 지켜냈다.
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
