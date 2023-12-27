/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.datapool;

public final class FormatterService {
    private static final int MAX_FORMAT_PARAMETERS;
    private static final CharSequence[] FORMAT_PARAMETERS;

    private FormatterService() {
    }

    public static String format(CharSequence charSequence) {
        return ((Object)charSequence).toString();
    }

    public static String format(CharSequence charSequence, CharSequence charSequence2) {
        FormatterService.FORMAT_PARAMETERS[0] = charSequence2;
        return FormatterService.format(charSequence, FORMAT_PARAMETERS, 1);
    }

    public static String format(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        FormatterService.FORMAT_PARAMETERS[0] = charSequence2;
        FormatterService.FORMAT_PARAMETERS[1] = charSequence3;
        return FormatterService.format(charSequence, FORMAT_PARAMETERS, 2);
    }

    public static String format(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4) {
        FormatterService.FORMAT_PARAMETERS[0] = charSequence2;
        FormatterService.FORMAT_PARAMETERS[1] = charSequence3;
        FormatterService.FORMAT_PARAMETERS[2] = charSequence4;
        return FormatterService.format(charSequence, FORMAT_PARAMETERS, 3);
    }

    public static String format(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, CharSequence charSequence5) {
        FormatterService.FORMAT_PARAMETERS[0] = charSequence2;
        FormatterService.FORMAT_PARAMETERS[1] = charSequence3;
        FormatterService.FORMAT_PARAMETERS[2] = charSequence4;
        FormatterService.FORMAT_PARAMETERS[3] = charSequence5;
        return FormatterService.format(charSequence, FORMAT_PARAMETERS, 4);
    }

    public static String format(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, CharSequence charSequence5, CharSequence charSequence6) {
        FormatterService.FORMAT_PARAMETERS[0] = charSequence2;
        FormatterService.FORMAT_PARAMETERS[1] = charSequence3;
        FormatterService.FORMAT_PARAMETERS[2] = charSequence4;
        FormatterService.FORMAT_PARAMETERS[3] = charSequence5;
        FormatterService.FORMAT_PARAMETERS[4] = charSequence6;
        return FormatterService.format(charSequence, FORMAT_PARAMETERS, 5);
    }

    public static String format(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, CharSequence charSequence5, CharSequence charSequence6, CharSequence charSequence7) {
        FormatterService.FORMAT_PARAMETERS[0] = charSequence2;
        FormatterService.FORMAT_PARAMETERS[1] = charSequence3;
        FormatterService.FORMAT_PARAMETERS[2] = charSequence4;
        FormatterService.FORMAT_PARAMETERS[3] = charSequence5;
        FormatterService.FORMAT_PARAMETERS[4] = charSequence6;
        FormatterService.FORMAT_PARAMETERS[5] = charSequence7;
        return FormatterService.format(charSequence, FORMAT_PARAMETERS, 6);
    }

    public static String format(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, CharSequence charSequence5, CharSequence charSequence6, CharSequence charSequence7, CharSequence charSequence8) {
        FormatterService.FORMAT_PARAMETERS[0] = charSequence2;
        FormatterService.FORMAT_PARAMETERS[1] = charSequence3;
        FormatterService.FORMAT_PARAMETERS[2] = charSequence4;
        FormatterService.FORMAT_PARAMETERS[3] = charSequence5;
        FormatterService.FORMAT_PARAMETERS[4] = charSequence6;
        FormatterService.FORMAT_PARAMETERS[5] = charSequence7;
        FormatterService.FORMAT_PARAMETERS[6] = charSequence8;
        return FormatterService.format(charSequence, FORMAT_PARAMETERS, 7);
    }

    public static String format(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, CharSequence charSequence5, CharSequence charSequence6, CharSequence charSequence7, CharSequence charSequence8, CharSequence charSequence9) {
        FormatterService.FORMAT_PARAMETERS[0] = charSequence2;
        FormatterService.FORMAT_PARAMETERS[1] = charSequence3;
        FormatterService.FORMAT_PARAMETERS[2] = charSequence4;
        FormatterService.FORMAT_PARAMETERS[3] = charSequence5;
        FormatterService.FORMAT_PARAMETERS[4] = charSequence6;
        FormatterService.FORMAT_PARAMETERS[5] = charSequence7;
        FormatterService.FORMAT_PARAMETERS[6] = charSequence8;
        FormatterService.FORMAT_PARAMETERS[7] = charSequence9;
        return FormatterService.format(charSequence, FORMAT_PARAMETERS, 8);
    }

    public static String format(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, CharSequence charSequence5, CharSequence charSequence6, CharSequence charSequence7, CharSequence charSequence8, CharSequence charSequence9, CharSequence charSequence10) {
        FormatterService.FORMAT_PARAMETERS[0] = charSequence2;
        FormatterService.FORMAT_PARAMETERS[1] = charSequence3;
        FormatterService.FORMAT_PARAMETERS[2] = charSequence4;
        FormatterService.FORMAT_PARAMETERS[3] = charSequence5;
        FormatterService.FORMAT_PARAMETERS[4] = charSequence6;
        FormatterService.FORMAT_PARAMETERS[5] = charSequence7;
        FormatterService.FORMAT_PARAMETERS[6] = charSequence8;
        FormatterService.FORMAT_PARAMETERS[7] = charSequence9;
        FormatterService.FORMAT_PARAMETERS[8] = charSequence10;
        return FormatterService.format(charSequence, FORMAT_PARAMETERS, 9);
    }

    public static String format(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, CharSequence charSequence5, CharSequence charSequence6, CharSequence charSequence7, CharSequence charSequence8, CharSequence charSequence9, CharSequence charSequence10, CharSequence charSequence11) {
        FormatterService.FORMAT_PARAMETERS[0] = charSequence2;
        FormatterService.FORMAT_PARAMETERS[1] = charSequence3;
        FormatterService.FORMAT_PARAMETERS[2] = charSequence4;
        FormatterService.FORMAT_PARAMETERS[3] = charSequence5;
        FormatterService.FORMAT_PARAMETERS[4] = charSequence6;
        FormatterService.FORMAT_PARAMETERS[5] = charSequence7;
        FormatterService.FORMAT_PARAMETERS[6] = charSequence8;
        FormatterService.FORMAT_PARAMETERS[7] = charSequence9;
        FormatterService.FORMAT_PARAMETERS[8] = charSequence10;
        FormatterService.FORMAT_PARAMETERS[9] = charSequence11;
        return FormatterService.format(charSequence, FORMAT_PARAMETERS, 10);
    }

    private static String format(CharSequence charSequence, CharSequence[] charSequenceArray, int n) {
        int n2 = charSequence.length();
        StringBuffer stringBuffer = new StringBuffer(n2);
        int n3 = 0;
        for (int i2 = 0; i2 < n2 - 3; ++i2) {
            char c2;
            if (charSequence.charAt(i2) != '$' || charSequence.charAt(i2 + 1) != '{' || charSequence.charAt(i2 + 3) != '}' || '0' > (c2 = charSequence.charAt(i2 + 2)) || c2 >= 48 + n) continue;
            stringBuffer.append(((Object)charSequence.subSequence(n3, i2)).toString());
            stringBuffer.append(((Object)charSequenceArray[c2 - 48]).toString());
            n3 = i2 + 4;
        }
        stringBuffer.append(((Object)charSequence.subSequence(n3, n2)).toString());
        return stringBuffer.toString();
    }

    static {
        FORMAT_PARAMETERS = new CharSequence[10];
    }
}

