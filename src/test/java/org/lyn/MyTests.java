package org.lyn;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

/**
 * @author Yanni
 */
public class MyTests {
    @Test
    @DisplayName("Human-readable test name")
    public void testSomething() throws Exception {
        //...
        System.out.println("?");
    }
}
