package com.tp.builder;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MenuDirectorTest {




    @Before
    void setUp() {
         System.out.println("Before");
    }

    @After
    void after(){
        System.out.println("After");
    }

    @Test
    void constructById() {
        int var1 = 1;
        int var2 = 2;



        Assertions.assertFalse(var1 != var2, "为假");
    }

    @Test
    void constructByName() {
    }
    @Test
    void aaaa(){
        String obj1 = "junit";
        String obj2 = "junit";
        String obj3 = "test";
        String obj4 = "test";
        String obj5 = null;
        int var1 = 1;
        int var2 = 2;
        int[] arithmetic1 = {1, 2, 3};
        int[] arithmetic2 = {1, 2, 3};

        Assertions.assertEquals(obj1, obj2);

        Assertions.assertSame(obj3, obj4);

        Assertions.assertNotSame(obj2, obj4);

        Assertions.assertNotNull(obj1);

        Assertions.assertNull(obj5);

        Assertions.assertTrue(var1 == var2, "为真");


        Assertions.assertTrue(var1 == var2, "为真");

        Assertions.assertArrayEquals(arithmetic1, arithmetic2);

    }
}