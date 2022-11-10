package moomoo.spring.basic.discount.base;

import moomoo.spring.basic.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
