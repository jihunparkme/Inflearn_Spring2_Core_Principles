package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * AppConfig를 통해 관심사를 확실하게 분리 !
 *
 * 애플리케이션의 전체 동작 방식을 구성하기 위해,
 * 구현 객체를 생성하고, 연결하는 책임을 가진 별도의 Config Class
 *
 * 공연의 기획자가 배우를 섭외한다는 느낌!
 *
 * 관심사의 분리 : 객체를 생성하고 연결하는 역할과 실행하는 역할이 명확히 분리되었다 !@
 */
@Configuration // 설정 Clss임을 Spring에게 알려주자
public class AppConfig {

    /**
     * 생성한 객체 인스턴스의 참조(reference)를 생성자를 통해 주입 (생성자 주입)
     * DI, 의존관계 주입 : 의존관계를 외부에서 주입해주는 동작
     */
    @Bean // Spring Container에 등록
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    /**
     * 메서드명을 보고 역할이 드러나도록 리팩터링
     * 애플리케이션 전체 구성이 어떻게 되어있는지 빠르게 파악
     */
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        /*
         * 어플리케이션의 구성 영역이 변경되더라도,
         * 구성 역할을 담당하는 AppConfig만 변경하면 된다.
         * '사용영역'의 어떤 코드도 변경할 필요가 없다.
         */
        return new RateDiscountPolicy();
    }
}
