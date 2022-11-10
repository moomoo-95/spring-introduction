package moomoo.spring.basic.order;

import moomoo.spring.basic.member.Grade;
import moomoo.spring.basic.member.Member;
import moomoo.spring.basic.order.base.OrderService;
import moomoo.spring.basic.service.MemberService;
import moomoo.spring.basic.service.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void join() {
        // given
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        // when
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemK", 10000);
        // then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
