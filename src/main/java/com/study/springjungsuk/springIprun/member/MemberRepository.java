package com.study.springjungsuk.springIprun.member;

public interface MemberRepository {
    /**
     * member 저장
     * @param member
     */
    void save(Member member);


    /**
     *  아이디 조회
     * @param memberId
     * @return
     */
    Member findById(Long memberId);
}
