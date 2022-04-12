package com.example;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import io.qameta.allure.junit4.DisplayName;

@RunWith(Parameterized.class)
public class AccountTest {
    private final String name;
    private final boolean expected;

    public AccountTest(String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Name value: {0}")
    public static Object[][] getAccountData() {
        return new Object[][]{
                {"Андрей Иванов", true},  // значение внутри класса
                {"А И", true},  // граничное значение 3 символа
                {"Андрей Ивановвввввв", true},   // граничное значение 19 символов
                {"Ан И", true},    // 4 символа
                {"Андрей Ивановввввв", true},   // 18 символов
                {"АИ", false},  // 2 символа
                {"Андрей Ивановввввввв", false},   // 20 символов
                {"АндрейИванов", false},   // без пробелов
                {"Андрей Ива нов", false},   // пробелов больше чем 1
                {" АндрейИванов", false},   // пробел в начале
                {"АндрейИванов ", false},   // пробел в конце
                {"", false},    // пустая строка
                {null, false},    // null
        };
    }

    @Test
    @DisplayName("Check name is correct or incorrect")
    public void checkNameToEmbossReturnsCorrectValue() {
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        Assert.assertEquals(expected, actual);
    }
}
