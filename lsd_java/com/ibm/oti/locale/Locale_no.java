/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.locale;

import com.ibm.oti.locale.Locale;
import com.ibm.oti.util.ExtendedResourceBundle;

public class Locale_no
extends ExtendedResourceBundle {
    @Override
    protected Object[][] getContents() {
        Object[][] objectArray = new Object[][]{{Locale.FIRST_DAY, new Integer(2)}, {Locale.MINIMAL_DAYS, new Integer(4)}, {Locale.MONTHS, new String[]{"januar", "februar", "mars", "april", "mai", "juni", "juli", "august", "september", "oktober", "november", "desember", ""}}, {Locale.SHORT_MONTHS, new String[]{"jan", "feb", "mar", "apr", "mai", "jun", "jul", "aug", "sep", "okt", "nov", "des", ""}}, {Locale.WEEK_DAYS, new String[]{"", "s\u00f8ndag", "mandag", "tirsdag", "onsdag", "torsdag", "fredag", "l\u00f8rdag"}}, {Locale.SHORT_WEEK_DAYS, new String[]{"", "s\u00f8", "ma", "ti", "on", "to", "fr", "l\u00f8"}}, {Locale.DATE_SHORT, "dd.MM.yy"}, {Locale.DATE_MEDIUM, "dd.MMM.yyyy"}, {Locale.DATE_LONG, "d. MMMM yyyy"}, {Locale.DATE_FULL, "d. MMMM yyyy"}, {Locale.TIME_SHORT, "HH:mm"}, {Locale.TIME_MEDIUM, "HH:mm:ss"}, {Locale.TIME_LONG, "HH:mm:ss z"}, {Locale.TIME_FULL, "'kl 'HH.mm z"}, {Locale.DECIMAL_PATTERN_CHARS, "0#,\u00a0;%\u2030E,-"}};
        return objectArray;
    }
}

