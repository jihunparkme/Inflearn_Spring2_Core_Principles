package hello.core.member;

public class MemberServiceImpl implements MemberService {

    // 추상화에만 의존. DIP를 지켜냈다.
    private final MemberRepository memberRepository;

    /**
     * 생성자를 통해서 구현체를 주입!
     */
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void join(Member member) {
        memberRepository.save(member);
    }

    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}