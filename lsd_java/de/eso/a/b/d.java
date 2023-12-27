/*
 * Decompiled with CFR 0.152.
 */
package de.eso.a.b;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class d {
    static final String[] a = new String[]{"yy-MM-dd", "yyyy-MM-dd", "yyyy-MM", "yyyyMMdd", "yyyyMM", "yy", "yyyy"};
    private static SimpleDateFormat[] b = new SimpleDateFormat[a.length];

    public static synchronized Date a(String string) {
        if (string == null || string.length() < 1) {
            return null;
        }
        Date date = null;
        for (int i2 = 0; i2 < b.length; ++i2) {
            SimpleDateFormat simpleDateFormat = b[i2];
            try {
                date = simpleDateFormat.parse(string);
                break;
            }
            catch (ParseException parseException) {
                continue;
            }
        }
        return date;
    }

    static {
        for (int i2 = 0; i2 < a.length; ++i2) {
            d.b[i2] = new SimpleDateFormat(a[i2]);
        }
    }
}

