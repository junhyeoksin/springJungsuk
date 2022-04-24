package com.study.springjungsuk.springIprun.order;


import com.study.springjungsuk.springIprun.discount.DiscountPolicy;
import com.study.springjungsuk.springIprun.discount.FixDiscountPolicy;
import com.study.springjungsuk.springIprun.member.Member;
import com.study.springjungsuk.springIprun.member.MemberRepository;
import com.study.springjungsuk.springIprun.member.MemoryMeberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMeberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

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
