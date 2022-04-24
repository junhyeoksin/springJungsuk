package com.study.springjungsuk.springIprun.discount;

import com.study.springjungsuk.springIprun.member.Grade;
import com.study.springjungsuk.springIprun.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{
    
    private int discountFixAmount = 1000; //1000원 할인

    /**
     * VIP  할인 1000 원 적용
     * @param member
     * @param price
     * @return
     */
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){  //enum 일때 == 사용
            return discountFixAmount;
        }
        return 0;
    }
}
