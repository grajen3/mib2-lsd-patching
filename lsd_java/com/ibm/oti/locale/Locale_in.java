/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.locale;

import com.ibm.oti.locale.Locale;
import com.ibm.oti.util.ExtendedResourceBundle;

public class Locale_in
extends ExtendedResourceBundle {
    @Override
    protected Object[][] getContents() {
        Object[][] objectArray = new Object[][]{{Locale.FIRST_DAY, new Integer(2)}, {Locale.MONTHS, new String[]{"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "Nopember", "Desember", ""}}, {Locale.SHORT_MONTHS, new String[]{"Jan", "Feb", "Mar", "Apr", "Mei", "Jun", "Jul", "Agu", "Sep", "Okt", "Nop", "Des", ""}}, {Locale.WEEK_DAYS, new String[]{"", "Minggu", "Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu"}}, {Locale.SHORT_WEEK_DAYS, new String[]{"", "Minggu", "Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu"}}, {Locale.DATE_SHORT, "dd/MM/yy"}, {Locale.DATE_MEDIUM, "dd/MM/yyyy"}, {Locale.DATE_LONG, "d MMMM, yyyy"}, {Locale.DATE_FULL, "EEEE d MMMM, yyyy"}, {Locale.TIME_SHORT, "H:mm"}, {Locale.TIME_MEDIUM, "H:mm:ss"}, {Locale.TIME_LONG, "H:mm:ss"}, {Locale.TIME_FULL, "H:mm:ss z"}, {Locale.DECIMAL_PATTERN_CHARS, "0#,.;%\u2030E,-"}, {Locale.CURRENCY, "\u00a4 #,##0.00;- \u00a4 #,##0.00"}};
        return objectArray;
    }
}

