package com.nick.mockito.mockitodemo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SomeBusinessMockTest {

    @Test
    public void testFindTheGreatestAllData() {

        DataService dataServiceMock = mock(DataService.class);
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 27, 15, 3});

        SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
        int result = businessImpl.findTheGreatestFromAllData();

        assertEquals(27, result);
    }

    @Test
    public void testFindTheGreatestAllData_forOneValue() {

        DataService dataServiceMock = mock(DataService.class);
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 9 });

        SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
        int result = businessImpl.findTheGreatestFromAllData();

        assertEquals(9, result);
    }
}
