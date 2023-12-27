/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.japan;

public final class Hiragana {
    public static final char A;
    public static final char A_SMALL;
    public static final char I;
    public static final char I_SMALL;
    public static final char U;
    public static final char U_SMALL;
    public static final char VU;
    public static final char E;
    public static final char E_SMALL;
    public static final char O;
    public static final char O_SMALL;
    public static final char KA;
    public static final char KA_SMALL;
    public static final char GA;
    public static final char KI;
    public static final char GI;
    public static final char KU;
    public static final char GU;
    public static final char KE;
    public static final char KE_SMALL;
    public static final char GE;
    public static final char KO;
    public static final char GO;
    public static final char SA;
    public static final char ZA;
    public static final char SI;
    public static final char ZI;
    public static final char SU;
    public static final char ZU;
    public static final char SE;
    public static final char ZE;
    public static final char SO;
    public static final char ZO;
    public static final char TA;
    public static final char DA;
    public static final char TI;
    public static final char DI;
    public static final char TU;
    public static final char TU_SMALL;
    public static final char DU;
    public static final char TE;
    public static final char DE;
    public static final char TO;
    public static final char DO;
    public static final char NA;
    public static final char NI;
    public static final char NU;
    public static final char NE;
    public static final char NO;
    public static final char HA;
    public static final char BA;
    public static final char PA;
    public static final char HI;
    public static final char BI;
    public static final char PI;
    public static final char HU;
    public static final char BU;
    public static final char PU;
    public static final char HE;
    public static final char BE;
    public static final char PE;
    public static final char HO;
    public static final char BO;
    public static final char PO;
    public static final char MA;
    public static final char MI;
    public static final char MU;
    public static final char ME;
    public static final char MO;
    public static final char YA;
    public static final char YA_SMALL;
    public static final char YU;
    public static final char YU_SMALL;
    public static final char YO;
    public static final char YO_SMALL;
    public static final char RA;
    public static final char RI;
    public static final char RU;
    public static final char RE;
    public static final char RO;
    public static final char WA;
    public static final char WA_SMALL;
    public static final char WI;
    public static final char WE;
    public static final char WO;
    public static final char N;
    public static final char DAKUTEN;
    public static final char HANDAKUTEN;
    public static final char MIN;
    public static final char MAX;
    private static char[] LARGE_AVAILABLE;
    private static char[] SMALL_AVAILABLE;
    private static char[] WITH_DAKUTEN_AVAILABLE;
    private static char[] WITH_HANDAKUTEN_AVAILABLE;

    public static char[] getAllLargeAvailable() {
        if (LARGE_AVAILABLE == null) {
            LARGE_AVAILABLE = new char[]{'\u3041', '\u3043', '\u3045', '\u3047', '\u3049', '\u3095', '\u3096', '\u3063', '\u3083', '\u3085', '\u3087', '\u308e'};
        }
        return LARGE_AVAILABLE;
    }

    public static char[] getAllSmallAvailable() {
        if (SMALL_AVAILABLE == null) {
            SMALL_AVAILABLE = new char[]{'\u3042', '\u3044', '\u3046', '\u3048', '\u304a', '\u304b', '\u3051', '\u3064', '\u3084', '\u3086', '\u3088', '\u308f'};
        }
        return SMALL_AVAILABLE;
    }

    public static char[] getAllWithDakutenAvailable() {
        if (WITH_DAKUTEN_AVAILABLE == null) {
            WITH_DAKUTEN_AVAILABLE = new char[]{'\u3046', '\u304b', '\u304d', '\u304f', '\u3051', '\u3053', '\u3055', '\u3057', '\u3059', '\u305b', '\u305d', '\u305f', '\u3061', '\u3064', '\u3066', '\u3068', '\u306f', '\u3072', '\u3075', '\u3078', '\u307b'};
        }
        return WITH_DAKUTEN_AVAILABLE;
    }

    public static char[] getAllWithHandakutenAvailable() {
        if (WITH_HANDAKUTEN_AVAILABLE == null) {
            WITH_HANDAKUTEN_AVAILABLE = new char[]{'\u306f', '\u3072', '\u3075', '\u3078', '\u307b'};
        }
        return WITH_HANDAKUTEN_AVAILABLE;
    }

    public static String getLargeAvailable() {
        return String.valueOf(Hiragana.getAllLargeAvailable());
    }

    public static String getSmallAvailable() {
        return String.valueOf(Hiragana.getAllSmallAvailable());
    }

    public static String getWithDakutenAvailable() {
        return String.valueOf(Hiragana.getAllWithDakutenAvailable());
    }

    public static String getWithHandakutenAvailable() {
        return String.valueOf(Hiragana.getAllWithHandakutenAvailable());
    }

    public static boolean isHiragana(char c2) {
        return '\u3040' <= c2 && c2 <= '\u309f';
    }

    public static boolean isHiraganas(String string) {
        boolean bl = false;
        for (int i2 = 0; i2 < string.length() && (bl = Hiragana.isHiragana(string.charAt(i2))); ++i2) {
        }
        return bl;
    }

    private Hiragana() {
    }
}

