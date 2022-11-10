package moomoo.spring.basic.discount;

import moomoo.spring.basic.discount.base.DiscountPolicy;
import moomoo.spring.basic.member.Grade;
import moomoo.spring.basic.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private static final int DISCOUNT_PERCENT = 10;
    @Override
    public int discount(Member member, int price) {
        return member.getGrade().equals(Grade.VIP) ? (price * DISCOUNT_PERCENT) / 100 : 0;
    }
}
