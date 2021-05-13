package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {

    // 추상화에만 의존. DIP를 지켜냈다.
    private final MemberRepository memberRepository;

    /**
     * 생성자를 통해서 구현체를 주입!
     */
    @Autowired
    // @Autowired 의존관계 자동 주입. 스프링 컨테이너가 자동으로 해당 스프링 빈을 찾아서 주입
    // ac.getBean(MemberRepository.class) 와 같은 효과
    // 기본 조회 전략은 타입이 같은 빈을 찾아서 주입
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도!
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}