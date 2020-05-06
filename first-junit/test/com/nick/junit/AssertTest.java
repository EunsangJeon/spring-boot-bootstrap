package com.nick.junit;

import org.junit.*;

import static org.junit.Assert.*;

public class AssertTest {

    // Junit does not guarantee the order of tests
    @Before
    public void before() {
        // but @Before will be performed before every test
    }

    @After
    public void after() {
        // but @Before will be performed after every test
    }

    @BeforeClass
    static public void beforeClass() {
        // but @Before will be performed once before entire tests
    }

    @AfterClass
    static public void afterClass() {
        // but @Before will be performed once after entire tests
    }

    @Test
    public void test() {
        assertEquals(1, 1);
        assertTrue(true);
        assertFalse(false);
        assertNotNull(true);
        assertArrayEquals(new int[] { 1, 2, 3 }, new int[] { 1, 2, 3 });
    }
}
