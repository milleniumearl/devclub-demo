package com.propellerads.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.propellerads.page.YandexMainPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FirstTest {
    

        @Test
        void firstTest() {
            Selenide.open("http://ya.ru");
            $("#text").setValue("PropellerAds");
            $("div.search2__button button").click();
            assertTrue(Selenide.$$("li.serp-item").size() > 10);
        }

        @Test
        void checkResultCount() {
            Selenide.open("http://ya.ru", YandexMainPage.class)
                    .setSearchQuery("PropellerAds")
                    .search()
                    .checkResultCount(10);
        }
    }

