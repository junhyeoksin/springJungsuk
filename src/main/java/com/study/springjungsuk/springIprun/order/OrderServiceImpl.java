package com.study.springjungsuk.springIprun.order;


import com.study.springjungsuk.springIprun.discount.DiscountPolicy;
import com.study.springjungsuk.springIprun.discount.FixDiscountPolicy;
import com.study.springjungsuk.springIprun.member.Member;
import com.study.springjungsuk.springIprun.member.MemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    /**
     * 주문생성 !
     * @param memberId
     * @param itemName
     * @param itemPrice
     * @return
     */
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);  //최종 할인된 가격을 반환

    }
}
