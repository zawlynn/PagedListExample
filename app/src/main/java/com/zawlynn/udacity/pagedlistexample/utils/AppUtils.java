package com.zawlynn.udacity.pagedlistexample.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AppUtils {
    static AppUtils instance;

    public static AppUtils getInstance() {
        if (instance == null) {
            instance = new AppUtils();
        }
        return instance;
    }

    public String getDate(String dateString) {

        try {
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'");
            Date date = format1.parse(dateString);
            DateFormat sdf = new SimpleDateFormat("MMM d, yyyy");
            return sdf.format(date);
        } catch (Exception ex) {
            ex.printStackTrace();
            return "xx";
        }
    }

    public String getTime(String dateString) {

        try {
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'");
            Date date = format1.parse(dateString);
            DateFormat sdf = new SimpleDateFormat("h:mm a");
            Date netDate = (date);
            return sdf.format(netDate);
        } catch (Exception ex) {
            ex.printStackTrace();
            return "xx";
        }
    }


    public long getRandomNumber() {
        long x = (long) ((Math.random() * ((100000 - 0) + 1)) + 0);
        return x;
    }
}

