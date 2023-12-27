/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.japan;

import de.vw.mib.util.StringBuilder;
import de.vw.mib.widgets.speller.asia.japan.Hiragana;

public final class HiraganaFreeTextConverter {
    public static final String PRONUNCIATION_ELEMENTS = String.valueOf(new char[]{'\u309b', '\u309c'});
    private static final String HIRAGANAS_DAKUTEN = Hiragana.getWithDakutenAvailable();
    private static final String HIRAGANAS_HANDAKUTEN = Hiragana.getWithHandakutenAvailable();

    public static String getAllKanasWithDakuten() {
        return HIRAGANAS_DAKUTEN;
    }

    public static String getAllKanasWithHandakuten() {
        return HIRAGANAS_HANDAKUTEN;
    }

    public static String getAllKanasWithPronunciationElement(char c2) {
        switch (c2) {
            case '\u309b': {
                return HiraganaFreeTextConverter.getAllKanasWithDakuten();
            }
            case '\u309c': {
                return HiraganaFreeTextConverter.getAllKanasWithHandakuten();
            }
        }
        return "";
    }

    private static char getKanaWithDakuten(char c2) {
        switch (c2) {
            case '\u3046': {
                c2 = (char)12436;
                break;
            }
            case '\u304b': {
                c2 = (char)12364;
                break;
            }
            case '\u304d': {
                c2 = (char)12366;
                break;
            }
            case '\u304f': {
                c2 = (char)12368;
                break;
            }
            case '\u3051': {
                c2 = (char)12370;
                break;
            }
            case '\u3053': {
                c2 = (char)12372;
                break;
            }
            case '\u3055': {
                c2 = (char)12374;
                break;
            }
            case '\u3057': {
                c2 = (char)12376;
                break;
            }
            case '\u3059': {
                c2 = (char)12378;
                break;
            }
            case '\u305b': {
                c2 = (char)12380;
                break;
            }
            case '\u305d': {
                c2 = (char)12382;
                break;
            }
            case '\u305f': {
                c2 = (char)12384;
                break;
            }
            case '\u3061': {
                c2 = (char)12386;
                break;
            }
            case '\u3064': {
                c2 = (char)12389;
                break;
            }
            case '\u3066': {
                c2 = (char)12391;
                break;
            }
            case '\u3068': {
                c2 = (char)12393;
                break;
            }
            case '\u306f': {
                c2 = (char)12400;
                break;
            }
            case '\u3072': {
                c2 = (char)12403;
                break;
            }
            case '\u3075': {
                c2 = (char)12406;
                break;
            }
            case '\u3078': {
                c2 = (char)12409;
                break;
            }
            case '\u307b': {
                c2 = (char)12412;
                break;
            }
            case '\u30a6': {
                c2 = (char)12532;
                break;
            }
            case '\u30ab': {
                c2 = (char)12460;
                break;
            }
            case '\u30ad': {
                c2 = (char)12462;
                break;
            }
            case '\u30af': {
                c2 = (char)12464;
                break;
            }
            case '\u30b1': {
                c2 = (char)12466;
                break;
            }
            case '\u30b3': {
                c2 = (char)12468;
                break;
            }
            case '\u30b5': {
                c2 = (char)12470;
                break;
            }
            case '\u30b7': {
                c2 = (char)12472;
                break;
            }
            case '\u30b9': {
                c2 = (char)12474;
                break;
            }
            case '\u30bb': {
                c2 = (char)12476;
                break;
            }
            case '\u30bd': {
                c2 = (char)12478;
                break;
            }
            case '\u30bf': {
                c2 = (char)12480;
                break;
            }
            case '\u30c1': {
                c2 = (char)12482;
                break;
            }
            case '\u30c4': {
                c2 = (char)12485;
                break;
            }
            case '\u30c6': {
                c2 = (char)12487;
                break;
            }
            case '\u30c8': {
                c2 = (char)12489;
                break;
            }
            case '\u30cf': {
                c2 = (char)12496;
                break;
            }
            case '\u30d2': {
                c2 = (char)12499;
                break;
            }
            case '\u30d5': {
                c2 = (char)12502;
                break;
            }
            case '\u30d8': {
                c2 = (char)12505;
                break;
            }
            case '\u30db': {
                c2 = (char)12508;
                break;
            }
        }
        return c2;
    }

    private static char getKanaWithHandakuten(char c2) {
        switch (c2) {
            case '\u306f': {
                c2 = (char)12401;
                break;
            }
            case '\u3072': {
                c2 = (char)12404;
                break;
            }
            case '\u3075': {
                c2 = (char)12407;
                break;
            }
            case '\u3078': {
                c2 = (char)12410;
                break;
            }
            case '\u307b': {
                c2 = (char)12413;
                break;
            }
            case '\u30cf': {
                c2 = (char)12497;
                break;
            }
            case '\u30d2': {
                c2 = (char)12500;
                break;
            }
            case '\u30d5': {
                c2 = (char)12503;
                break;
            }
            case '\u30d8': {
                c2 = (char)12506;
                break;
            }
            case '\u30db': {
                c2 = (char)12509;
                break;
            }
        }
        return c2;
    }

    public static char getKanaWithPronunciationElement(char c2, char c3) {
        switch (c3) {
            case '\u309b': {
                c2 = HiraganaFreeTextConverter.getKanaWithDakuten(c2);
                break;
            }
            case '\u309c': {
                c2 = HiraganaFreeTextConverter.getKanaWithHandakuten(c2);
                break;
            }
        }
        return c2;
    }

    public static char getLargeKanaForKana(char c2) {
        switch (c2) {
            case '\u3041': {
                c2 = (char)12354;
                break;
            }
            case '\u3047': {
                c2 = (char)12360;
                break;
            }
            case '\u3043': {
                c2 = (char)12356;
                break;
            }
            case '\u3049': {
                c2 = (char)12362;
                break;
            }
            case '\u3045': {
                c2 = (char)12358;
                break;
            }
            case '\u3095': {
                c2 = (char)12363;
                break;
            }
            case '\u3096': {
                c2 = (char)12369;
                break;
            }
            case '\u3063': {
                c2 = (char)12388;
                break;
            }
            case '\u3083': {
                c2 = (char)12420;
                break;
            }
            case '\u3087': {
                c2 = (char)12424;
                break;
            }
            case '\u3085': {
                c2 = (char)12422;
                break;
            }
            case '\u308e': {
                c2 = (char)12431;
                break;
            }
        }
        return c2;
    }

    public static String getPronunciationElementsForKana(char c2) {
        StringBuilder stringBuilder = new StringBuilder();
        if (HIRAGANAS_DAKUTEN.indexOf(c2) > -1) {
            stringBuilder.append('\u309b');
        }
        if (HIRAGANAS_HANDAKUTEN.indexOf(c2) > -1) {
            stringBuilder.append('\u309c');
        }
        return stringBuilder.toString();
    }

    public static char getSmallKanaForKana(char c2) {
        switch (c2) {
            case '\u3042': {
                c2 = (char)12353;
                break;
            }
            case '\u3048': {
                c2 = (char)12359;
                break;
            }
            case '\u3044': {
                c2 = (char)12355;
                break;
            }
            case '\u304a': {
                c2 = (char)12361;
                break;
            }
            case '\u3046': {
                c2 = (char)12357;
                break;
            }
            case '\u304b': {
                c2 = (char)12437;
                break;
            }
            case '\u3051': {
                c2 = (char)12438;
                break;
            }
            case '\u3064': {
                c2 = (char)12387;
                break;
            }
            case '\u3084': {
                c2 = (char)12419;
                break;
            }
            case '\u3088': {
                c2 = (char)12423;
                break;
            }
            case '\u3086': {
                c2 = (char)12421;
                break;
            }
            case '\u308f': {
                c2 = (char)12430;
                break;
            }
        }
        return c2;
    }

    public static String getUnavailablePronunciationElementsForKana(char c2) {
        StringBuilder stringBuilder = new StringBuilder();
        if (HIRAGANAS_DAKUTEN.indexOf(c2) == -1) {
            stringBuilder.append('\u309b');
        }
        if (HIRAGANAS_HANDAKUTEN.indexOf(c2) == -1) {
            stringBuilder.append('\u309c');
        }
        return stringBuilder.toString();
    }

    public static boolean isLargeKanaAvailable(char c2) {
        return Hiragana.getLargeAvailable().indexOf(c2) >= 0;
    }

    public static boolean isPronunciationElement(char c2) {
        switch (c2) {
            case '\u309b': 
            case '\u309c': {
                return true;
            }
        }
        return false;
    }

    public static boolean isSmallKanaAvailable(char c2) {
        return Hiragana.getSmallAvailable().indexOf(c2) >= 0;
    }

    private HiraganaFreeTextConverter() {
    }
}

