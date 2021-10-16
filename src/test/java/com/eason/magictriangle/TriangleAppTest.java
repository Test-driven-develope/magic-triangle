package com.eason.magictriangle;

import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static com.github.stefanbirkner.systemlambda.SystemLambda.withTextFromSystemIn;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TriangleAppTest {
    
    @Test
    void should_print_normal_triangle_when_input_2_3_4() throws Exception {
        withTextFromSystemIn("2,3,4").execute(() -> {
            final String txt = tapSystemOut(() -> TriangleApp.main(null));
    
            assertEquals("欢迎使用魔幻三角小程序！\n" +
                    "请您需要判断的三角形的三条整数边长(如2,3,4):\n" +
                    "您输入的三条边长为[2,3,4], 可构成常规三角形",
                txt.trim());
        });
    }
    
    @Test
    void should_print_normal_triangle_when_input_4_5_6() throws Exception {
        withTextFromSystemIn("4,5,6").execute(() -> {
            final String txt = tapSystemOut(() -> TriangleApp.main(null));
            
            assertEquals("欢迎使用魔幻三角小程序！\n" +
                    "请您需要判断的三角形的三条整数边长(如2,3,4):\n" +
                    "您输入的三条边长为[4,5,6], 可构成常规三角形",
                txt.trim());
        });
    }
    
    @Test
    void should_not_print_normal_triangle_when_input_1_2_3() throws Exception {
        withTextFromSystemIn("1,2,3").execute(() -> {
            final String txt = tapSystemOut(() -> TriangleApp.main(null));
            
            assertEquals("欢迎使用魔幻三角小程序！\n" +
                    "请您需要判断的三角形的三条整数边长(如2,3,4):\n" +
                    "您输入的三条边长为[1,2,3], 不能构成三角形",
                txt.trim());
        });
    }
    
    @Test
    void should_not_print_normal_triangle_when_input_2_3() throws Exception {
        withTextFromSystemIn("2,3").execute(() -> {
            final String txt = tapSystemOut(() -> TriangleApp.main(null));
            
            assertEquals("欢迎使用魔幻三角小程序！\n" +
                    "请您需要判断的三角形的三条整数边长(如2,3,4):\n" +
                    "您输入的三条边长为[2,3], 不能构成三角形",
                txt.trim());
        });
    }
    
    @Test
    void should_not_print_normal_triangle_when_input_2_3_4_5() throws Exception {
        withTextFromSystemIn("2,3,4,5").execute(() -> {
            final String txt = tapSystemOut(() -> TriangleApp.main(null));
            
            assertEquals("欢迎使用魔幻三角小程序！\n" +
                    "请您需要判断的三角形的三条整数边长(如2,3,4):\n" +
                    "您输入的三条边长为[2,3,4,5], 不能构成三角形",
                txt.trim());
        });
    }
    
    @Test
    void should_not_print_normal_triangle_when_input_2_3_4_with_underline() throws Exception {
        withTextFromSystemIn("2_3_4").execute(() -> {
            final String txt = tapSystemOut(() -> TriangleApp.main(null));
            
            assertEquals("欢迎使用魔幻三角小程序！\n" +
                    "请您需要判断的三角形的三条整数边长(如2,3,4):\n" +
                    "您输入的三条边长为[2_3_4], 不能构成三角形",
                txt.trim());
        });
    }
    
    @Test
    void should_not_print_normal_triangle_when_input_$$$() throws Exception {
        withTextFromSystemIn("$$$").execute(() -> {
            final String txt = tapSystemOut(() -> TriangleApp.main(null));
            
            assertEquals("欢迎使用魔幻三角小程序！\n" +
                    "请您需要判断的三角形的三条整数边长(如2,3,4):\n" +
                    "您输入的三条边长为[$$$], 不能构成三角形",
                txt.trim());
        });
    }
    
    @Test
    void should_not_print_normal_triangle_when_input_negative() throws Exception {
        withTextFromSystemIn("-2,-3,-4").execute(() -> {
            final String txt = tapSystemOut(() -> TriangleApp.main(null));
            
            assertEquals("欢迎使用魔幻三角小程序！\n" +
                    "请您需要判断的三角形的三条整数边长(如2,3,4):\n" +
                    "您输入的三条边长为[-2,-3,-4], 不能构成三角形",
                txt.trim());
        });
    }
    
    @Test
    void should_not_print_normal_triangle_when_input_float() throws Exception {
        withTextFromSystemIn("2.1,3.2,4").execute(() -> {
            final String txt = tapSystemOut(() -> TriangleApp.main(null));
            
            assertEquals("欢迎使用魔幻三角小程序！\n" +
                    "请您需要判断的三角形的三条整数边长(如2,3,4):\n" +
                    "您输入的三条边长为[2.1,3.2,4], 不能构成三角形",
                txt.trim());
        });
    }
}