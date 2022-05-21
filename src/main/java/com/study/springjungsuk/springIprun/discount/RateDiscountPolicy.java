package com.study.springjungsuk.springIprun.discount;

import com.study.springjungsuk.springIprun.member.Grade;
import com.study.springjungsuk.springIprun.member.Member;
import org.springframework.stereotype.Component;

@Component
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;
    /**
     * 고정할인 금액이 아니라 정률 할인 ex) 10000원 구매시 1000원 할인
     *
     * @param member
     * @param price
     * @return
     */

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
