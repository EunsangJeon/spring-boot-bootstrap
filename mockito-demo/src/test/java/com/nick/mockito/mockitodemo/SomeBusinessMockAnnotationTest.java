package com.nick.mockito.mockitodemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockAnnotationTest {

    @Mock
    DataService dataServiceMock;

    @InjectMocks
    SomeBusinessImpl businessImpl;

    @Test
    public void testFindTheGreatestAllData() {

        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 27, 15, 3});
        assertEquals(27, businessImpl.findTheGreatestFromAllData());
    }

    @Test
    public void testFindTheGreatestAllData_forOneValue() {

        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 9 });
        assertEquals(9, businessImpl.findTheGreatestFromAllData());
    }

    @Test
    public void testFindTheGreatestAllData_NoValue() {

        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { });
        assertEquals(Integer.MIN_VALUE, businessImpl.findTheGreatestFromAllData());
    }
}
