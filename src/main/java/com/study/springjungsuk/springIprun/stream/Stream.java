package com.study.springjungsuk.springIprun.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {
        java8Code();
    }

    static void java8Code() {
        List<SampleDto> sampleDtoList = new ArrayList<>();

/** 람다를 인수로 받아, 스트림에서 특정 요소를 제외시킨다. 아래는 idx가 10 이상인 데이터를 선택한다. */
        List<String> list = sampleDtoList.stream()
                .filter(d -> d.getIdx() < 10)           //10 이상인 데이터 선택
                .sorted(Comparator.comparing(SampleDto::getIdx))  //idx 순서대로 정렬
                .map(SampleDto::getName)  //이름 추출
                .collect(Collectors.toList()); // 리스트로 저장

        //병렬
        List<String> paralleStream = sampleDtoList.parallelStream()
                .filter(d -> d.getIdx() < 10)
                .sorted(Comparator.comparing(SampleDto::getIdx)) //idx 순서대로 정렬
                .map(SampleDto::getName)//추출
                .collect(Collectors.toList()); //리스트 저장
    }



    }
