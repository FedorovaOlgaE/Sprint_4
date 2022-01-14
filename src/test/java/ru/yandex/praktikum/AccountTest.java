package ru.yandex.praktikum;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountTest {

    private final String name;
    private final boolean checkName;

    public AccountTest(String name, boolean checkName) {
        this.name = name;
        this.checkName = checkName;
    }

    @Parameterized.Parameters
    public static Object[][] dataForTest() {
        return new Object[][]{
                {"Тимоти Шаломе", true},
                {"ТимотиШаломе", false},
                {" ТимотиШаломе", false},
                {"ТимотиШаломе ", false},
                {" Тимоти Шаломе ", false},
                {"Т", false},
                {"Тимоти ШаломеШаломеШаломе", false},
                {null, false}
        };
    }

    @Test
    public void isTheNameValid() {
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        assertEquals(checkName, actual);
    }
}
