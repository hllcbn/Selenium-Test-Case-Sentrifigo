package com.sentrifugo.test;

import org.testng.annotations.DataProvider;

public class LoginTestProvider {
    @DataProvider(name = "fullLogin")
    public Object[][] logindata(){
        return new Object[][]{
                {"EM01", "sentrifugo"},
                {"EM02", "sentrifugo"},
                {"EM03", "sentrifugo"},
                {"EM04", "sentrifugo"},
                {"EM05", "sentrifugo"},
                {"EM06", "sentrifugo"},
                {"EM07", "sentrifugo"},
                {"AGCY8", "sentrifugo"},
                {"US09", "sentrifugo"},

        };
    }
}