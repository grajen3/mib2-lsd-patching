/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.locale;

import com.ibm.oti.locale.Locale;
import com.ibm.oti.util.ExtendedResourceBundle;

public class Locale_is
extends ExtendedResourceBundle {
    @Override
    protected Object[][] getContents() {
        Object[][] objectArray = new Object[][]{{Locale.MONTHS, new String[]{"jan\u00faar", "febr\u00faar", "mars", "apr\u00edl", "ma\u00ed", "j\u00fan\u00ed", "j\u00fal\u00ed", "\u00e1g\u00fast", "september", "okt\u00f3ber", "n\u00f3vember", "desember", ""}}, {Locale.SHORT_MONTHS, new String[]{"jan.", "feb.", "mar.", "apr.", "ma\u00ed", "j\u00fan.", "j\u00fal.", "\u00e1g\u00fa.", "sep.", "okt.", "n\u00f3v.", "des.", ""}}, {Locale.WEEK_DAYS, new String[]{"", "sunnudagur", "m\u00e1nudagur", "\u00feri\u00f0judagur", "mi\u00f0vikudagur", "fimmtudagur", "f\u00f6studagur", "laugardagur"}}, {Locale.SHORT_WEEK_DAYS, new String[]{"", "sun.", "m\u00e1n.", "\u00feri.", "mi\u00f0.", "fim.", "f\u00f6s.", "lau."}}, {Locale.DATE_SHORT, "d.M.yyyy"}, {Locale.DATE_MEDIUM, "d.M.yyyy"}, {Locale.DATE_LONG, "d. MMMM yyyy"}, {Locale.DATE_FULL, "d. MMMM yyyy"}, {Locale.TIME_SHORT, "HH:mm"}, {Locale.TIME_MEDIUM, "HH:mm:ss"}, {Locale.TIME_LONG, "HH:mm:ss z"}, {Locale.TIME_FULL, "HH:mm:ss z"}, {Locale.DECIMAL_PATTERN_CHARS, "0#,.;%\u2030E,-"}};
        return objectArray;
    }
}

