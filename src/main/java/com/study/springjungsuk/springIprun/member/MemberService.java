package com.study.springjungsuk.springIprun.member;

public interface MemberService {
    /**
     *  회원가입
     * @param member
     */
    void join(Member member);

    /**
     * 회원 조회
     * @param memberId
     * @return
     */
    Member findMember(Long memberId);
}
