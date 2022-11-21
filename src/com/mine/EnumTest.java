package com.mine;

/**
 * @author CaoY
 * @date 2022-11-19 3:22
 * @description 测试类
 *
 */
public class EnumTest {

    public static void main(String[] args) {

        Season spring = Season.SPRING;
        System.out.println(spring.getLabel());
        System.out.println(spring.ordinal());
    }

}

enum Season {
    SPRING("SP"),
    SUMMER("SU"),
    AUTUMN("A"),
    WINTER("W");

    private String label;

    private Season(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}


