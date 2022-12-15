package com.mine.domain;

/**
 * @author CaoY
 * @date 2022-11-30 1:30
 * @description 泛型类练习
 */
public class Pair<T, U> {
    private T first;
    private U second;

    public Pair() {

    }

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public U getSecond() {
        return second;
    }

    public void setSecond(U second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }


}
