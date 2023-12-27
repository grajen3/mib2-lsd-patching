/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.locale;

import com.ibm.oti.locale.Locale;
import com.ibm.oti.util.ExtendedResourceBundle;

public class Locale_nl
extends ExtendedResourceBundle {
    @Override
    protected Object[][] getContents() {
        Object[][] objectArray = new Object[][]{{Locale.FIRST_DAY, new Integer(2)}, {Locale.MINIMAL_DAYS, new Integer(4)}, {Locale.MONTHS, new String[]{"januari", "februari", "maart", "april", "mei", "juni", "juli", "augustus", "september", "oktober", "november", "december", ""}}, {Locale.SHORT_MONTHS, new String[]{"jan", "feb", "mrt", "apr", "mei", "jun", "jul", "aug", "sep", "okt", "nov", "dec", ""}}, {Locale.WEEK_DAYS, new String[]{"", "zondag", "maandag", "dinsdag", "woensdag", "donderdag", "vrijdag", "zaterdag"}}, {Locale.SHORT_WEEK_DAYS, new String[]{"", "zo", "ma", "di", "wo", "do", "vr", "za"}}, {Locale.DATE_SHORT, "d-M-yy"}, {Locale.DATE_MEDIUM, "d-MMM-yyyy"}, {Locale.DATE_LONG, "d MMMM yyyy"}, {Locale.DATE_FULL, "EEEE d MMMM yyyy"}, {Locale.TIME_SHORT, "H:mm"}, {Locale.TIME_MEDIUM, "H:mm:ss"}, {Locale.TIME_LONG, "H:mm:ss z"}, {Locale.TIME_FULL, "H:mm:ss' uur' z"}, {Locale.DECIMAL_PATTERN_CHARS, "0#,.;%\u2030E,-"}};
        return objectArray;
    }
}

