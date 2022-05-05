package com.study.springjungsuk.springIprun.stream;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Hashset {
    public static void main(String[] args) {
        AddHashSet();
        ExIterator();
    }
    

    /**
     * 중복된 값을 허용하지 않습니다.
     * 순서를 보장하지 않습니다.
     * null 값을 저장할 수 있습니다.
     * 내부적으로 HashMap을 사용하여 데이터를 저장합니다.
     */

    static void AddHashSet(){
        Set<String> set = new HashSet<>();

        set.add("name1");
        set.add("name2");
        set.add("name3");
        System.out.println("set === " + set);
        //결과값:  [name3, name2, name1]      --> 순서가 보장 x

        set.remove("name3");
        System.out.println("set === " + set);
        //결과 값: [name2, name1]

    }

    /**
     * Iterator 객체를 리턴  :  이 객체로 Set의 모든 아이템을 순회할 수 있음
     */
    static void ExIterator(){
        Set<String> fruits = new HashSet<String>();
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("kiwi");

        //  HashSet의 모든 객체를 순회하면서 출력하는 코드

        Iterator<String> it = fruits.iterator();
        while (it.hasNext())
            System.out.println("fruits-hasNext: " + it.next());

        for (String fruit : fruits) {
            System.out.println("fruits-for: " + fruit);
        }
    }
}
