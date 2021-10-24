package com.eason.magictriangle;

import com.eason.magictriangle.domain.ExceptionTriangle;
import com.eason.magictriangle.domain.Triangle;
import com.eason.magictriangle.domain.TriangleType;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Arrays;

import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertEquals;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;
import static org.powermock.api.easymock.PowerMock.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest( { TriangleApp.class })
public class TriangleAppTest {
    
    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();
    
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
    
    @Test
    public void should_print_not_be_a_triangle() throws Exception {
        Triangle triangle = createMock(Triangle.class);
        expectNew(Triangle.class, Arrays.asList("1", "2", "3")).andThrow(new ExceptionTriangle());
        replay(triangle, Triangle.class);
        
        systemInMock.provideLines("1,2,3");
        TriangleApp.main(null);
        assertEquals("欢迎使用魔幻三角小程序！\n" +
                "请您需要判断的三角形的三条整数边长(如2,3,4):\n" +
                "您输入的三条边长为[1,2,3], 不能构成三角形",
            systemOutRule.getLog().trim());
    }
    
    @Test
    public void should_print_be_a_triangle() throws Exception {
        Triangle triangle = createMock(Triangle.class);
        expectNew(Triangle.class, Arrays.asList("2", "3", "4")).andReturn(triangle);
        expect(triangle.getType()).andReturn(TriangleType.NORMAL);
        replay(triangle, Triangle.class);
        
        systemInMock.provideLines("2,3,4");
        TriangleApp.main(null);
        assertEquals("欢迎使用魔幻三角小程序！\n" +
                    "请您需要判断的三角形的三条整数边长(如2,3,4):\n" +
                    "您输入的三条边长为[2,3,4], 可构成常规三角形",
                systemOutRule.getLog().trim());
    }
}