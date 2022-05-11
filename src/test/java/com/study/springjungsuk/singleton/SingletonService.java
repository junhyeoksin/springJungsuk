package com.study.springjungsuk.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    // getInstance 메서드를 통해서만 조회할 수 있다.
    public static SingletonService getInstance() {
        return instance;
    }

    // 생성자 막아두었다. 컴파일 오류가 발생한다.
    // new SingletonService();
    private SingletonService(){}

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
