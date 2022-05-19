package com.eason.magictriangle;

import static org.easymock.EasyMock.anyString;
import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertEquals;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;
import static org.powermock.api.easymock.PowerMock.*;

import org.javatuples.Triplet;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({TriangleApp.class, ParseUtils.class})
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
        final String input = "1,2,3";
        final Triplet<Integer, Integer, Integer> params = new Triplet<>(1, 2, 3);
        mockStatic(ParseUtils.class);
        expect(ParseUtils.parseInput(anyString())).andReturn(params);
        replay(ParseUtils.class);
// 如果实现了，请打开这个注释
//        Triangle triangle = createMock(Triangle.class);
//        expectNew(Triangle.class, params).andThrow(new ExceptionTriangle());
//        replay(triangle, Triangle.class);

        systemInMock.provideLines(input);
        TriangleApp.main(null);
        assertEquals(String.format(OUTPUT, input, NOT_TRIANGLE),
                systemOutRule.getLog().trim());
    }

    @Test
    public void should_print_be_a_triangle() throws Exception {
        final String input = "2,3,4";
        final Triplet<Integer, Integer, Integer> params = new Triplet<>(2, 3, 4);
        mockStatic(ParseUtils.class);
        expect(ParseUtils.parseInput(anyString())).andReturn(params);
        replay(ParseUtils.class);
// 如果实现了，请打开这个注释
//        Triangle triangle = createMock(Triangle.class);
//        expectNew(Triangle.class, params).andReturn(triangle);
//        expect(triangle.getType()).andReturn(TriangleType.NORMAL);
//        replay(triangle, Triangle.class);

        systemInMock.provideLines(input);
        TriangleApp.main(null);
        assertEquals(String.format(OUTPUT, input, NORMAL_TRIANGLE),
                systemOutRule.getLog().trim());
    }
}
