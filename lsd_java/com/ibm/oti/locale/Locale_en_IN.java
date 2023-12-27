/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.locale;

import com.ibm.oti.locale.Locale;
import com.ibm.oti.util.ExtendedResourceBundle;

public class Locale_en_IN
extends ExtendedResourceBundle {
    @Override
    protected Object[][] getContents() {
        Object[][] objectArray = new Object[][]{{Locale.DATE_SHORT, "d-MM-yy"}, {Locale.DATE_MEDIUM, "d-MM-yyyy"}, {Locale.DATE_LONG, "MMMM d yyyy"}, {Locale.DATE_FULL, "EEEE MMMM d yyyy"}, {Locale.TIME_LONG, "h:mm:ss a"}, {Locale.CURRENCY_SYMBOL, "Rs."}, {Locale.INTL_CURRENCY_SYMBOL, "INR"}};
        return objectArray;
    }
}

