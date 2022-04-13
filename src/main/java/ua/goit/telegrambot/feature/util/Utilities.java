package ua.goit.telegrambot.feature.util;

import org.jsoup.Jsoup;

import java.io.IOException;

public final class Utilities {

    //Get request from API
    public static String getAPIRequest(String url){
        String json;
        try {
            json = Jsoup
                    .connect(url)
                    .ignoreContentType(true)
                    .get()
                    .body()
                    .text();
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalStateException("Can't connect to API");
        }
        return json;
    }

}
