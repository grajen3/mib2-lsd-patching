/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.locale;

import com.ibm.oti.locale.Locale;
import com.ibm.oti.util.ExtendedResourceBundle;

public class Locale_en_BE
extends ExtendedResourceBundle {
    @Override
    protected Object[][] getContents() {
        Object[][] objectArray = new Object[][]{{Locale.DATE_SHORT, "dd/MM/yy"}, {Locale.DATE_MEDIUM, "dd MMM yyyy"}, {Locale.DATE_LONG, "EEE dd MMM yyyy"}, {Locale.DATE_FULL, "EEEE dd MMMM yyyy"}, {Locale.TIME_SHORT, "H:mm"}, {Locale.TIME_MEDIUM, "H:mm:ss"}, {Locale.TIME_LONG, "H:mm:ss z"}, {Locale.TIME_FULL, "H' h 'mm' min 'ss' s 'z"}, {Locale.DECIMAL_PATTERN_CHARS, "0#,.;%\u2030E,-"}, {Locale.CURRENCY_SYMBOL, "\u20ac"}, {Locale.INTL_CURRENCY_SYMBOL, "EUR"}, {Locale.CURRENCY, "#,##0.00 \u00a4"}};
        return objectArray;
    }
}

