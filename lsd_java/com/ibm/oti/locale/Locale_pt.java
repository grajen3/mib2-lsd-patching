/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.locale;

import com.ibm.oti.locale.Locale;
import com.ibm.oti.util.ExtendedResourceBundle;

public class Locale_pt
extends ExtendedResourceBundle {
    @Override
    protected Object[][] getContents() {
        Object[][] objectArray = new Object[][]{{Locale.FIRST_DAY, new Integer(2)}, {Locale.MONTHS, new String[]{"janeiro", "fevereiro", "mar\u00e7o", "abril", "maio", "junho", "julho", "agosto", "setembro", "outubro", "novembro", "dezembro", ""}}, {Locale.SHORT_MONTHS, new String[]{"jan", "fev", "mar", "abr", "mai", "jun", "jul", "ago", "set", "out", "nov", "dez", ""}}, {Locale.WEEK_DAYS, new String[]{"", "domingo", "segunda-feira", "ter\u00e7a-feira", "quarta-feira", "quinta-feira", "sexta-feira", "s\u00e1bado"}}, {Locale.SHORT_WEEK_DAYS, new String[]{"", "dom", "seg", "ter", "qua", "qui", "sex", "s\u00e1b"}}, {Locale.DATE_SHORT, "dd-MM-yyyy"}, {Locale.DATE_MEDIUM, "d/MMM/yyyy"}, {Locale.DATE_LONG, "d' de 'MMMM' de 'yyyy"}, {Locale.DATE_FULL, "EEEE, d' de 'MMMM' de 'yyyy"}, {Locale.TIME_SHORT, "H:mm"}, {Locale.TIME_MEDIUM, "H:mm:ss"}, {Locale.TIME_LONG, "H:mm:ss z"}, {Locale.TIME_FULL, "HH'H'mm'm' z"}, {Locale.DECIMAL_PATTERN_CHARS, "0#,.;%\u2030E,-"}};
        return objectArray;
    }
}

