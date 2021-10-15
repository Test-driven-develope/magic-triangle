package com.eason.magictriangle;

import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TriangleAppTest {
    
    @Test
    void should_could_print_normal_triangle() throws Exception {
        final String txt = tapSystemOut(() -> {
            TriangleApp.main(null);
        });
    
        assertEquals("欢迎使用魔幻三角小程序！\n" +
                "请您需要判断的三角形的三条整数边长(如1,2,3):",
            txt.trim());
    }
}