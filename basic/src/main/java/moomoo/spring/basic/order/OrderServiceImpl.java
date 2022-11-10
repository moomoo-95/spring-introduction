package moomoo.spring.basic.order;

import moomoo.spring.basic.discount.FIxDiscountPolicy;
import moomoo.spring.basic.discount.base.DiscountPolicy;
import moomoo.spring.basic.member.Member;
import moomoo.spring.basic.order.base.OrderService;
import moomoo.spring.basic.repository.MemoryMemberRepository;
import moomoo.spring.basic.repository.base.MemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FIxDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
