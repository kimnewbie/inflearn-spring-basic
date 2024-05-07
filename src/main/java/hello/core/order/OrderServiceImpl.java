package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 주문 서비스 구현체
 */
@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    // 오직 생성자 주입 방식만 'final'
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    /**
     * @RequiredArgsConstructor 이걸 사용해서 얘는 필요 없어짐
     */
    // public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
    //     this.memberRepository = memberRepository;
    //     this.discountPolicy = discountPolicy;
    // }

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
