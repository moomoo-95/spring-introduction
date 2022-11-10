package moomoo.spring.basic.discount;

import moomoo.spring.basic.discount.base.DiscountPolicy;
import moomoo.spring.basic.member.Grade;
import moomoo.spring.basic.member.Member;

public class FIxDiscountPolicy implements DiscountPolicy {
    private static final int DISCOUNT_FIX_AMOUNT = 1000;
    @Override
    public int discount(Member member, int price) {
        return member.getGrade().equals(Grade.VIP) ? DISCOUNT_FIX_AMOUNT : 0;
    }
}
