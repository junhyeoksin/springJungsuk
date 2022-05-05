package com.study.springjungsuk.springIprun.stream;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamList {
    public static void main(String[] args) {
        impossibleNewStream();
        java8Code();
        ExCosumerNewStream();

    }

    static void java8Code() {
        List<SampleDto> sampleDtoList = new ArrayList<>();

/**
 *   람다를 인수로 받아, 스트림에서 특정 요소를 제외시킨다. 아래는 idx가 10 이상인 데이터를 선택한다.
 * */

        List<String> list = sampleDtoList.stream()
                .filter(d -> d.getIdx() < 10)           //10 이상인 데이터 선택
                .sorted(Comparator.comparing(SampleDto::getIdx))  //idx 순서대로 정렬
                .map(SampleDto::getName)  //이름
                //.limit(3) // 선착순 3개만 선택
                .collect(Collectors.toList()); // 리스트로 저장
        System.out.println("list === " + list);
        //병렬
        List<String> paralleStream = sampleDtoList.parallelStream()
                .filter(d -> d.getIdx() < 10)
                .sorted(Comparator.comparing(SampleDto::getIdx)) //idx 순서대로 정렬
                .map(SampleDto::getName)//추출
                .collect(Collectors.toList()); //리스트 저장
        System.out.println("paralleStream === " + paralleStream);
    }



    
    /**
     *  
     */
    static void ExCosumerNewStream(){
        List<String> s = new ArrayList<>();
        s.add("one");
        s.add("one1");
        s.add("one2");
        s.add("one3");
        s.add("one4");

        s.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }
    /**
     * 리스트 인덱스로 꺼내기  list: List는 중복을 허용 즉, 중복된 아이템을 List에 추가할 수 있습니다.
     *
     * 스트림은 한번만 소비가 가능하다.
     * 1. Lambda 사용으로 간결하게 사용
     * 2. 메소드 레퍼런스 사용 
     */
    static void impossibleNewStream(){
        List<String> list = Arrays.asList("a", "b", "c", "d", "e", "f");

        String s = list.get(0);
        String s1 = list.get(1);
        String s2 = list.get(2);
        System.out.println("s = " + s);
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
        System.out.println("s -- "+ s +  ", s1----" +  s1 +  ", s2----" +  s2);

        java.util.stream.Stream<String> stream = list.stream();
        stream.forEach(name -> System.out.println("name = " + name));  // Lambda 로 표현
        //      stream.forEach(System.out::println);   // 메소드 레퍼런스 사용
    }

    /**
     * 저장되는 데이터의 순서를 보장해야한다면 List를 사용
     * contains(element)는 Collection에 데이터가 존재하는지 확인하는 메소드. List의 contains 실행 속도는 O(n)이지만, Set는 O(1)으로 매우 빠름. 탐색이 잦다면 Set를 고려.
     * 데이터가 많지 않다면 성능보다, 구조가 간단한 List를 고려.
     * 중복을 허용하지 않는 Collection이 필요하다면 Set를 고려.
     */


    /**
     * 스트림의 연산
     */
    static void streamkind(){
    String[] strArr = {"dd" ,  "aaa", "ccc", "ff" };
    List<String> list1 =  new ArrayList<>();
        list1.add("list1");
        list1.add("list2");
        list1.add("list3");
        list1.add("list4");
        list1.add("list5");
        Stream<String> stream = Stream.of(strArr);       //문자열 배열! 이 소스인 스트림

//        Stream<String> filteredStream = stream.filter();     // 걸러내기 ( 중간 연산)
//        Stream<String> distinctedStream = stream.distinct(); // 중복제거 ( 중간연산)
//        Stream<String> sortedStream = stream.sorted();      //정렬 ( 중간연산)
//        Stream<String> limitedStream = stream.limit(5); //스트림 자르기 (중간연산)

    }
}