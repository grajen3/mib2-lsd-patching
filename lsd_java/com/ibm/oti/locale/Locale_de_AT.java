/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.locale;

import com.ibm.oti.locale.Locale;
import com.ibm.oti.util.ExtendedResourceBundle;

public class Locale_de_AT
extends ExtendedResourceBundle {
    @Override
    protected Object[][] getContents() {
        Object[][] objectArray = new Object[][]{{Locale.MONTHS, new String[]{"J\u00e4nner", "Februar", "M\u00e4rz", "April", "Mai", "Juni", "Juli", "August", "September", "Oktober", "November", "Dezember", ""}}, {Locale.SHORT_MONTHS, new String[]{"J\u00e4n", "Feb", "M\u00e4r", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez", ""}}, {Locale.DATE_LONG, "dd. MMMM yyyy"}, {Locale.DATE_FULL, "EEEE, dd. MMMM yyyy"}, {Locale.TIME_FULL, "HH:mm' Uhr 'z"}, {Locale.CURRENCY_SYMBOL, "\u20ac"}, {Locale.INTL_CURRENCY_SYMBOL, "EUR"}};
        return objectArray;
    }
}

