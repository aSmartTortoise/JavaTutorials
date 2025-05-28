package com.wyj.java.date;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class DateStudy {

    public static void main(String[] args) {
        long now = DateUtil.getNow();
//        System.out.println(DateUtil.getDate(now));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        System.out.println(sdf.format(1730692241746L));

        Locale defaultLocale = Locale.getDefault(Locale.Category.FORMAT);
        System.out.println(defaultLocale.getCountry());
    }
}
