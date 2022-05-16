package com.eason.magictriangle;

import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertEquals;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;
import static org.powermock.api.easymock.PowerMock.*;

import com.eason.magictriangle.domain.ExceptionTriangle;
import com.eason.magictriangle.domain.Triangle;
import com.eason.magictriangle.domain.TriangleType;
import org.javatuples.Triplet;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest( { TriangleApp.class })
public class TriangleAppTest {
    
    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();
    
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    private static final String OUTPUT = "欢迎使用魔幻三角小程序！\n" +
            "请您需要判断的三角形的三条整数边长(如2,3,4):\n" +
            "您输入的三条边长为[%s], %s";
    private static final String NOT_TRIANGLE = "不能构成三角形";
    private static final String NORMAL_TRIANGLE = "可构成常规三角形";

    @Test
    public void should_print_not_be_a_triangle_given_1_2_3() throws Exception {
        Triangle triangle = createMock(Triangle.class);
        expectNew(Triangle.class, new Triplet<>(1, 2, 3)).andThrow(new ExceptionTriangle());
        replay(triangle, Triangle.class);

        final String input = "1,2,3";
        systemInMock.provideLines(input);
        TriangleApp.main(null);
        assertEquals(String.format(OUTPUT, input, NOT_TRIANGLE),
            systemOutRule.getLog().trim());
    }

    @Test
    public void should_print_be_a_triangle() throws Exception {
        Triangle triangle = createMock(Triangle.class);
        expectNew(Triangle.class, new Triplet<>(2, 3, 4)).andReturn(triangle);
        expect(triangle.getType()).andReturn(TriangleType.NORMAL);
        replay(triangle, Triangle.class);

        final String input = "2,3,4";
        systemInMock.provideLines(input);
        TriangleApp.main(null);
        assertEquals(String.format(OUTPUT, input, NORMAL_TRIANGLE),
                systemOutRule.getLog().trim());
    }

    @Test
    public void should_return_triplet_when_input_1_2_3() throws InputException {
        final Triplet<Integer, Integer, Integer> sides = TriangleApp.parseInput("1,2,3");
        assertEquals(sides, new Triplet<>(1, 2, 3));
    }

    @Test(expected = InputException.class)
    public void should_throw_input_exception_when_input_1_2() throws InputException {
        TriangleApp.parseInput("1,2");
    }

    @Test(expected = InputException.class)
    public void should_throw_input_exception_when_input_1_2_4_5() throws InputException {
        TriangleApp.parseInput("1,2,4,5");
    }

    @Test(expected = NumberFormatException.class)
    public void should_throw_input_exception_when_input_s_2_3() throws InputException {
        TriangleApp.parseInput("s,2,3");
    }

    @Test(expected = InputException.class)
    public void should_throw_input_exception_when_input_sides_contains_negative() throws InputException {
        TriangleApp.parseInput("2,3,-4");
    }

    @Test(expected = NumberFormatException.class)
    public void should_throw_input_exception_when_input_sides_contains_float() throws InputException {
        TriangleApp.parseInput("2,3,0.4");
    }
}
