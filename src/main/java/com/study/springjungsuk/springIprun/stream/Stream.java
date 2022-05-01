package com.study.springjungsuk.springIprun.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {
        impossibleNewStream();
        java8Code();
        ExCosumerNewStream();

    }

    static void java8Code() {
        List<SampleDto> sampleDtoList = new ArrayList<>();

/** 람다를 인수로 받아, 스트림에서 특정 요소를 제외시킨다. 아래는 idx가 10 이상인 데이터를 선택한다. */


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
     * 스트림은 한번만 소비가 가능하다.
     */
    static void impossibleNewStream(){
        List<String> title = Arrays.asList("a", "b", "c", "d", "e", "f");


        java.util.stream.Stream<String> stream = title.stream();
//      stream.forEach(System.out::println);
        stream.forEach(name -> System.out.println("name = " + name));  // Lambda 로 표현

    }

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
}