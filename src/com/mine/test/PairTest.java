package com.mine.test;

import com.mine.domain.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CaoY
 * @date 2022-11-30 1:33
 * @description 泛型类练习
 */
public class PairTest {
    public static void main(String[] args) {

        List<Pair<String, Integer> > list = new ArrayList<>();
        Pair<String, Integer> pair1 = new Pair<>("小明", 12);
        Pair<String, Integer> pair2 = new Pair<>("小刘", 22);
        Pair<String, Integer> pair3 = new Pair<>("小强", 18);
        list.add(pair1);
        list.add(pair2);
        list.add(pair3);
        list.forEach(System.out::println);
    }
}
