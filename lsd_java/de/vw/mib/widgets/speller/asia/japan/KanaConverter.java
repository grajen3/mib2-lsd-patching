/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.japan;

import de.vw.mib.util.StringBuilder;

public final class KanaConverter {
    public static final int AVAILABLE_DAKUTEN;
    public static final int AVAILABLE_HANDAKUTEN;
    public static final int FORMAT_HIRAGANA;
    public static final int FORMAT_HW_KATAKANA;
    public static final int FORMAT_KANA;
    public static final int FORMAT_KATAKANA;
    private static final char DAKUTEN;
    private static final char HANDAKUTEN;
    private static final int KANA_CONVERSION_BUFFER_SIZE;
    private static final int UNICODE_HIRAGANA_KATAKANA_OFFSET;
    private static StringBuilder kanaConversionBuffer;

    public static String addPronunciationElementCharacters(String string) {
        KanaConverter.resetKanaConversionBuffer();
        for (int i2 = 0; i2 < string.length(); ++i2) {
            char c2 = string.charAt(i2);
            kanaConversionBuffer.append(c2);
            char c3 = KanaConverter.getKanaWithPronunciationElement(c2, '\u309b');
            if (c3 != c2) {
                kanaConversionBuffer.append(c3);
            }
            if ((c3 = KanaConverter.getKanaWithPronunciationElement(c2, '\u309c')) == c2) continue;
            kanaConversionBuffer.append(c3);
        }
        return kanaConversionBuffer.toString();
    }

    public static String convertString(int n, int n2, String string) {
        KanaConverter.resetKanaConversionBuffer();
        int n3 = string.length();
        block0 : switch (n) {
            case 1: {
                switch (n2) {
                    case 2: {
                        for (int i2 = 0; i2 < n3; ++i2) {
                            kanaConversionBuffer.append(KanaConverter.getKatakana(string.charAt(i2)));
                        }
                        break block0;
                    }
                    case 3: {
                        for (int i3 = 0; i3 < n3; ++i3) {
                            kanaConversionBuffer.append(KanaConverter.getHWKatakana(string.charAt(i3)));
                        }
                        break block0;
                    }
                    case 4: {
                        kanaConversionBuffer.append(string);
                        break;
                    }
                    default: {
                        kanaConversionBuffer.append(string);
                        break;
                    }
                }
                break;
            }
            case 2: {
                switch (n2) {
                    case 1: {
                        for (int i4 = 0; i4 < n3; ++i4) {
                            kanaConversionBuffer.append(KanaConverter.getHiragana(string.charAt(i4)));
                        }
                        break block0;
                    }
                    case 3: {
                        for (int i5 = 0; i5 < n3; ++i5) {
                            kanaConversionBuffer.append(KanaConverter.getHWKatakana(string.charAt(i5)));
                        }
                        break block0;
                    }
                    case 4: {
                        kanaConversionBuffer.append(string);
                        break;
                    }
                    default: {
                        kanaConversionBuffer.append(string);
                        break;
                    }
                }
                break;
            }
            case 3: {
                switch (n2) {
                    case 1: {
                        for (int i6 = 0; i6 < n3; ++i6) {
                            kanaConversionBuffer.append(KanaConverter.getHiraganaFromHWKatakana(string.charAt(i6)));
                        }
                        break block0;
                    }
                    case 2: {
                        for (int i7 = 0; i7 < n3; ++i7) {
                            char c2 = KanaConverter.getHiraganaFromHWKatakana(string.charAt(i7));
                            kanaConversionBuffer.append(KanaConverter.getKatakana(c2));
                        }
                        break block0;
                    }
                    case 4: {
                        kanaConversionBuffer.append(string);
                        break;
                    }
                    default: {
                        kanaConversionBuffer.append(string);
                        break;
                    }
                }
                break;
            }
            case 4: {
                switch (n2) {
                    case 1: {
                        for (int i8 = 0; i8 < n3; ++i8) {
                            kanaConversionBuffer.append(KanaConverter.getHiragana(string.charAt(i8)));
                        }
                        break block0;
                    }
                    case 2: {
                        for (int i9 = 0; i9 < n3; ++i9) {
                            kanaConversionBuffer.append(KanaConverter.getKatakana(string.charAt(i9)));
                        }
                        break block0;
                    }
                    case 3: {
                        for (int i10 = 0; i10 < n3; ++i10) {
                            kanaConversionBuffer.append(KanaConverter.getHWKatakana(string.charAt(i10)));
                        }
                        break block0;
                    }
                    case 4: {
                        kanaConversionBuffer.append(string);
                        break;
                    }
                    default: {
                        kanaConversionBuffer.append(string);
                        break;
                    }
                }
                break;
            }
            default: {
                kanaConversionBuffer.append(string);
            }
        }
        return kanaConversionBuffer.toString();
    }

    public static String convertToHiragana(String string) {
        KanaConverter.resetKanaConversionBuffer();
        for (int i2 = 0; i2 < string.length(); ++i2) {
            kanaConversionBuffer.append(KanaConverter.getHiragana(string.charAt(i2)));
        }
        return kanaConversionBuffer.toString();
    }

    public static String convertToKatakana(String string) {
        KanaConverter.resetKanaConversionBuffer();
        for (int i2 = 0; i2 < string.length(); ++i2) {
            kanaConversionBuffer.append(KanaConverter.getKatakana(string.charAt(i2)));
        }
        return kanaConversionBuffer.toString();
    }

    public static char getBaseCharacter(char c2) {
        char c3;
        switch (c2) {
            case '\u3094': {
                c3 = '\u3046';
                break;
            }
            case '\u304c': {
                c3 = '\u304b';
                break;
            }
            case '\u304e': {
                c3 = '\u304d';
                break;
            }
            case '\u3050': {
                c3 = '\u304f';
                break;
            }
            case '\u3052': {
                c3 = '\u3051';
                break;
            }
            case '\u3054': {
                c3 = '\u3053';
                break;
            }
            case '\u3056': {
                c3 = '\u3055';
                break;
            }
            case '\u3058': {
                c3 = '\u3057';
                break;
            }
            case '\u305a': {
                c3 = '\u3059';
                break;
            }
            case '\u305c': {
                c3 = '\u305b';
                break;
            }
            case '\u305e': {
                c3 = '\u305d';
                break;
            }
            case '\u3060': {
                c3 = '\u305f';
                break;
            }
            case '\u3062': {
                c3 = '\u3061';
                break;
            }
            case '\u3065': {
                c3 = '\u3064';
                break;
            }
            case '\u3067': {
                c3 = '\u3066';
                break;
            }
            case '\u3069': {
                c3 = '\u3068';
                break;
            }
            case '\u3070': 
            case '\u3071': {
                c3 = '\u306f';
                break;
            }
            case '\u3073': 
            case '\u3074': {
                c3 = '\u3072';
                break;
            }
            case '\u3076': 
            case '\u3077': {
                c3 = '\u3075';
                break;
            }
            case '\u3079': 
            case '\u307a': {
                c3 = '\u3078';
                break;
            }
            case '\u307c': 
            case '\u307d': {
                c3 = '\u307b';
                break;
            }
            case '\u30f4': {
                c3 = '\u30a6';
                break;
            }
            case '\u30ac': {
                c3 = '\u30ab';
                break;
            }
            case '\u30ae': {
                c3 = '\u30ad';
                break;
            }
            case '\u30b0': {
                c3 = '\u30af';
                break;
            }
            case '\u30b2': {
                c3 = '\u30b1';
                break;
            }
            case '\u30b4': {
                c3 = '\u30b3';
                break;
            }
            case '\u30b6': {
                c3 = '\u30b5';
                break;
            }
            case '\u30b8': {
                c3 = '\u30b7';
                break;
            }
            case '\u30ba': {
                c3 = '\u30b9';
                break;
            }
            case '\u30bc': {
                c3 = '\u30bb';
                break;
            }
            case '\u30be': {
                c3 = '\u30bd';
                break;
            }
            case '\u30c0': {
                c3 = '\u30bf';
                break;
            }
            case '\u30c2': {
                c3 = '\u30c1';
                break;
            }
            case '\u30c5': {
                c3 = '\u30c4';
                break;
            }
            case '\u30c7': {
                c3 = '\u30c6';
                break;
            }
            case '\u30c9': {
                c3 = '\u30c8';
                break;
            }
            case '\u30d0': 
            case '\u30d1': {
                c3 = '\u30cf';
                break;
            }
            case '\u30d3': 
            case '\u30d4': {
                c3 = '\u30d2';
                break;
            }
            case '\u30d6': 
            case '\u30d7': {
                c3 = '\u30d5';
                break;
            }
            case '\u30d9': 
            case '\u30da': {
                c3 = '\u30d8';
                break;
            }
            case '\u30dc': 
            case '\u30dd': {
                c3 = '\u30db';
                break;
            }
            default: {
                c3 = c2;
            }
        }
        return c3;
    }

    public static char getHiragana(char c2) {
        char c3 = c2;
        if ('\u30a0' < c2 && c2 < '\u30f4') {
            c3 = (char)(c2 - 96);
        }
        return c3;
    }

    public static char getHiraganaFromHWKatakana(char n) {
        int n2 = n;
        switch (n) {
            case 65383: {
                n2 = 12353;
                break;
            }
            case 65384: {
                n2 = 12355;
                break;
            }
            case 65385: {
                n2 = 12357;
                break;
            }
            case 65386: {
                n2 = 12359;
                break;
            }
            case 65387: {
                n2 = 12361;
                break;
            }
            case 65388: {
                n2 = 12419;
                break;
            }
            case 65389: {
                n2 = 12421;
                break;
            }
            case 65390: {
                n2 = 12423;
                break;
            }
            case 65391: {
                n2 = 12387;
                break;
            }
            case 65392: {
                n2 = 12540;
                break;
            }
            case 65393: {
                n2 = 12354;
                break;
            }
            case 65394: {
                n2 = 12356;
                break;
            }
            case 65395: {
                n2 = 12358;
                break;
            }
            case 65396: {
                n2 = 12360;
                break;
            }
            case 65397: {
                n2 = 12362;
                break;
            }
            case 65398: {
                n2 = 12363;
                break;
            }
            case 65399: {
                n2 = 12365;
                break;
            }
            case 65400: {
                n2 = 12367;
                break;
            }
            case 65401: {
                n2 = 12369;
                break;
            }
            case 65402: {
                n2 = 12371;
                break;
            }
            case 65403: {
                n2 = 12373;
                break;
            }
            case 65404: {
                n2 = 12375;
                break;
            }
            case 65405: {
                n2 = 12377;
                break;
            }
            case 65406: {
                n2 = 12379;
                break;
            }
            case 65407: {
                n2 = 12381;
                break;
            }
            case 65408: {
                n2 = 12383;
                break;
            }
            case 65409: {
                n2 = 12385;
                break;
            }
            case 65410: {
                n2 = 12388;
                break;
            }
            case 65411: {
                n2 = 12390;
                break;
            }
            case 65412: {
                n2 = 12392;
                break;
            }
            case 65413: {
                n2 = 12394;
                break;
            }
            case 65414: {
                n2 = 12395;
                break;
            }
            case 65415: {
                n2 = 12396;
                break;
            }
            case 65416: {
                n2 = 12397;
                break;
            }
            case 65417: {
                n2 = 12398;
                break;
            }
            case 65418: {
                n2 = 12399;
                break;
            }
            case 65419: {
                n2 = 12402;
                break;
            }
            case 65420: {
                n2 = 12405;
                break;
            }
            case 65421: {
                n2 = 12408;
                break;
            }
            case 65422: {
                n2 = 12411;
                break;
            }
            case 65423: {
                n2 = 12414;
                break;
            }
            case 65424: {
                n2 = 12415;
                break;
            }
            case 65425: {
                n2 = 12416;
                break;
            }
            case 65426: {
                n2 = 12417;
                break;
            }
            case 65427: {
                n2 = 12418;
                break;
            }
            case 65428: {
                n2 = 12420;
                break;
            }
            case 65429: {
                n2 = 12422;
                break;
            }
            case 65430: {
                n2 = 12424;
                break;
            }
            case 65431: {
                n2 = 12425;
                break;
            }
            case 65432: {
                n2 = 12426;
                break;
            }
            case 65433: {
                n2 = 12427;
                break;
            }
            case 65434: {
                n2 = 12428;
                break;
            }
            case 65435: {
                n2 = 12429;
                break;
            }
            case 65436: {
                n2 = 12431;
                break;
            }
            case 65382: {
                n2 = 12434;
                break;
            }
            case 65437: {
                n2 = 12435;
                break;
            }
            case 65438: {
                n2 = 12443;
                break;
            }
            case 65439: {
                n2 = 12444;
                break;
            }
        }
        return (char)n2;
    }

    public static char getKanaWithPronunciationElement(char c2, char c3) {
        block0 : switch (c3) {
            case '\u309b': {
                switch (c2) {
                    case '\u3046': {
                        c2 = (char)12436;
                        break block0;
                    }
                    case '\u304b': {
                        c2 = (char)12364;
                        break block0;
                    }
                    case '\u304d': {
                        c2 = (char)12366;
                        break block0;
                    }
                    case '\u304f': {
                        c2 = (char)12368;
                        break block0;
                    }
                    case '\u3051': {
                        c2 = (char)12370;
                        break block0;
                    }
                    case '\u3053': {
                        c2 = (char)12372;
                        break block0;
                    }
                    case '\u3055': {
                        c2 = (char)12374;
                        break block0;
                    }
                    case '\u3057': {
                        c2 = (char)12376;
                        break block0;
                    }
                    case '\u3059': {
                        c2 = (char)12378;
                        break block0;
                    }
                    case '\u305b': {
                        c2 = (char)12380;
                        break block0;
                    }
                    case '\u305d': {
                        c2 = (char)12382;
                        break block0;
                    }
                    case '\u305f': {
                        c2 = (char)12384;
                        break block0;
                    }
                    case '\u3061': {
                        c2 = (char)12386;
                        break block0;
                    }
                    case '\u3064': {
                        c2 = (char)12389;
                        break block0;
                    }
                    case '\u3066': {
                        c2 = (char)12391;
                        break block0;
                    }
                    case '\u3068': {
                        c2 = (char)12393;
                        break block0;
                    }
                    case '\u306f': {
                        c2 = (char)12400;
                        break block0;
                    }
                    case '\u3072': {
                        c2 = (char)12403;
                        break block0;
                    }
                    case '\u3075': {
                        c2 = (char)12406;
                        break block0;
                    }
                    case '\u3078': {
                        c2 = (char)12409;
                        break block0;
                    }
                    case '\u307b': {
                        c2 = (char)12412;
                        break block0;
                    }
                    case '\u30a6': {
                        c2 = (char)12532;
                        break block0;
                    }
                    case '\u30ab': {
                        c2 = (char)12460;
                        break block0;
                    }
                    case '\u30ad': {
                        c2 = (char)12462;
                        break block0;
                    }
                    case '\u30af': {
                        c2 = (char)12464;
                        break block0;
                    }
                    case '\u30b1': {
                        c2 = (char)12466;
                        break block0;
                    }
                    case '\u30b3': {
                        c2 = (char)12468;
                        break block0;
                    }
                    case '\u30b5': {
                        c2 = (char)12470;
                        break block0;
                    }
                    case '\u30b7': {
                        c2 = (char)12472;
                        break block0;
                    }
                    case '\u30b9': {
                        c2 = (char)12474;
                        break block0;
                    }
                    case '\u30bb': {
                        c2 = (char)12476;
                        break block0;
                    }
                    case '\u30bd': {
                        c2 = (char)12478;
                        break block0;
                    }
                    case '\u30bf': {
                        c2 = (char)12480;
                        break block0;
                    }
                    case '\u30c1': {
                        c2 = (char)12482;
                        break block0;
                    }
                    case '\u30c4': {
                        c2 = (char)12485;
                        break block0;
                    }
                    case '\u30c6': {
                        c2 = (char)12487;
                        break block0;
                    }
                    case '\u30c8': {
                        c2 = (char)12489;
                        break block0;
                    }
                    case '\u30cf': {
                        c2 = (char)12496;
                        break block0;
                    }
                    case '\u30d2': {
                        c2 = (char)12499;
                        break block0;
                    }
                    case '\u30d5': {
                        c2 = (char)12502;
                        break block0;
                    }
                    case '\u30d8': {
                        c2 = (char)12505;
                        break block0;
                    }
                    case '\u30db': {
                        c2 = (char)12508;
                        break block0;
                    }
                }
                break;
            }
            case '\u309c': {
                switch (c2) {
                    case '\u306f': {
                        c2 = (char)12401;
                        break block0;
                    }
                    case '\u3072': {
                        c2 = (char)12404;
                        break block0;
                    }
                    case '\u3075': {
                        c2 = (char)12407;
                        break block0;
                    }
                    case '\u3078': {
                        c2 = (char)12410;
                        break block0;
                    }
                    case '\u307b': {
                        c2 = (char)12413;
                        break block0;
                    }
                    case '\u30cf': {
                        c2 = (char)12497;
                        break block0;
                    }
                    case '\u30d2': {
                        c2 = (char)12500;
                        break block0;
                    }
                    case '\u30d5': {
                        c2 = (char)12503;
                        break block0;
                    }
                    case '\u30d8': {
                        c2 = (char)12506;
                        break block0;
                    }
                    case '\u30db': {
                        c2 = (char)12509;
                        break block0;
                    }
                }
                break;
            }
        }
        return c2;
    }

    public static char getHWKatakana(char n) {
        int n2 = n;
        switch (n2) {
            case 12353: 
            case 12449: {
                n2 = 1744764928;
                break;
            }
            case 12355: 
            case 12451: {
                n2 = 1761542144;
                break;
            }
            case 12357: 
            case 12453: {
                n2 = 1778319360;
                break;
            }
            case 12359: 
            case 12455: {
                n2 = 1795096576;
                break;
            }
            case 12361: 
            case 12457: {
                n2 = 1811873792;
                break;
            }
            case 12419: 
            case 12515: {
                n2 = 1828651008;
                break;
            }
            case 12421: 
            case 12517: {
                n2 = 1845428224;
                break;
            }
            case 12423: 
            case 12519: {
                n2 = 1862205440;
                break;
            }
            case 12387: 
            case 12483: {
                n2 = 0x6FFF0000;
                break;
            }
            case 12540: {
                n2 = 0x70FF0000;
                break;
            }
            case 12354: 
            case 12450: {
                n2 = 1912537088;
                break;
            }
            case 12356: 
            case 12452: {
                n2 = 1929314304;
                break;
            }
            case 12358: 
            case 12454: {
                n2 = 1946091520;
                break;
            }
            case 12360: 
            case 12456: {
                n2 = 1962868736;
                break;
            }
            case 12362: 
            case 12458: {
                n2 = 1979645952;
                break;
            }
            case 12363: 
            case 12459: {
                n2 = 1996423168;
                break;
            }
            case 12365: 
            case 12461: {
                n2 = 0x77FF0000;
                break;
            }
            case 12367: 
            case 12463: {
                n2 = 2029977600;
                break;
            }
            case 12369: 
            case 12465: {
                n2 = 2046754816;
                break;
            }
            case 12371: 
            case 12467: {
                n2 = 2063532032;
                break;
            }
            case 12373: 
            case 12469: {
                n2 = 2080309248;
                break;
            }
            case 12375: 
            case 12471: {
                n2 = 2097086464;
                break;
            }
            case 12377: 
            case 12473: {
                n2 = 2113863680;
                break;
            }
            case 12379: 
            case 12475: {
                n2 = 2130640896;
                break;
            }
            case 12381: 
            case 12477: {
                n2 = 0x7FFF0000;
                break;
            }
            case 12383: 
            case 12479: {
                n2 = -2130771968;
                break;
            }
            case 12385: 
            case 12481: {
                n2 = -2113994752;
                break;
            }
            case 12388: 
            case 12484: {
                n2 = -2097217536;
                break;
            }
            case 12390: 
            case 12486: {
                n2 = -2080440320;
                break;
            }
            case 12392: 
            case 12488: {
                n2 = -2063663104;
                break;
            }
            case 12394: 
            case 12490: {
                n2 = -2046885888;
                break;
            }
            case 12395: 
            case 12491: {
                n2 = -2030108672;
                break;
            }
            case 12396: 
            case 12492: {
                n2 = -2013331456;
                break;
            }
            case 12397: 
            case 12493: {
                n2 = -1996554240;
                break;
            }
            case 12398: 
            case 12494: {
                n2 = -1979777024;
                break;
            }
            case 12399: 
            case 12495: {
                n2 = -1962999808;
                break;
            }
            case 12402: 
            case 12498: {
                n2 = -1946222592;
                break;
            }
            case 12405: 
            case 12501: {
                n2 = -1929445376;
                break;
            }
            case 12408: 
            case 12504: {
                n2 = -1912668160;
                break;
            }
            case 12411: 
            case 12507: {
                n2 = -1895890944;
                break;
            }
            case 12414: 
            case 12510: {
                n2 = -1879113728;
                break;
            }
            case 12415: 
            case 12511: {
                n2 = -1862336512;
                break;
            }
            case 12416: 
            case 12512: {
                n2 = -1845559296;
                break;
            }
            case 12417: 
            case 12513: {
                n2 = -1828782080;
                break;
            }
            case 12418: 
            case 12514: {
                n2 = -1812004864;
                break;
            }
            case 12420: 
            case 12516: {
                n2 = -1795227648;
                break;
            }
            case 12422: 
            case 12518: {
                n2 = -1778450432;
                break;
            }
            case 12424: 
            case 12520: {
                n2 = -1761673216;
                break;
            }
            case 12425: 
            case 12521: {
                n2 = -1744896000;
                break;
            }
            case 12426: 
            case 12522: {
                n2 = -1728118784;
                break;
            }
            case 12427: 
            case 12523: {
                n2 = -1711341568;
                break;
            }
            case 12428: 
            case 12524: {
                n2 = -1694564352;
                break;
            }
            case 12429: 
            case 12525: {
                n2 = -1677787136;
                break;
            }
            case 12431: 
            case 12527: {
                n2 = -1661009920;
                break;
            }
            case 12434: 
            case 12530: {
                n2 = 0x66FF0000;
                break;
            }
            case 12435: 
            case 12531: {
                n2 = -1644232704;
                break;
            }
            case 12443: {
                n2 = -1627455488;
                break;
            }
            case 12444: {
                n2 = -1610678272;
                break;
            }
        }
        return (char)n2;
    }

    public static char getKatakana(char c2) {
        char c3 = c2;
        if ('\u3040' < c2 && c2 < '\u3094') {
            c3 = (char)(c2 + 96);
        }
        return c3;
    }

    public static char getPronunciationElement(char c2) {
        char c3;
        switch (c2) {
            case '\u304c': 
            case '\u304e': 
            case '\u3050': 
            case '\u3052': 
            case '\u3054': 
            case '\u3056': 
            case '\u3058': 
            case '\u305a': 
            case '\u305c': 
            case '\u305e': 
            case '\u3060': 
            case '\u3062': 
            case '\u3065': 
            case '\u3067': 
            case '\u3069': 
            case '\u3070': 
            case '\u3073': 
            case '\u3076': 
            case '\u3079': 
            case '\u307c': 
            case '\u3094': 
            case '\u30ac': 
            case '\u30ae': 
            case '\u30b0': 
            case '\u30b2': 
            case '\u30b4': 
            case '\u30b6': 
            case '\u30b8': 
            case '\u30ba': 
            case '\u30bc': 
            case '\u30be': 
            case '\u30c0': 
            case '\u30c2': 
            case '\u30c5': 
            case '\u30c7': 
            case '\u30c9': 
            case '\u30d0': 
            case '\u30d3': 
            case '\u30d6': 
            case '\u30d9': 
            case '\u30dc': 
            case '\u30f4': {
                c3 = '\u309b';
                break;
            }
            case '\u3071': 
            case '\u3074': 
            case '\u3077': 
            case '\u307a': 
            case '\u307d': 
            case '\u30d1': 
            case '\u30d4': 
            case '\u30d7': 
            case '\u30da': 
            case '\u30dd': {
                c3 = '\u309c';
                break;
            }
            default: {
                c3 = c2;
            }
        }
        return c3;
    }

    public static int getPronunciationElementForHWKatakana(char c2) {
        int n = 0;
        switch (c2) {
            case '\uff73': 
            case '\uff76': 
            case '\uff77': 
            case '\uff78': 
            case '\uff79': 
            case '\uff7a': 
            case '\uff7b': 
            case '\uff7c': 
            case '\uff7d': 
            case '\uff7e': 
            case '\uff7f': 
            case '\uff80': 
            case '\uff81': 
            case '\uff82': 
            case '\uff83': 
            case '\uff84': {
                n |= 1;
                break;
            }
            case '\uff8a': 
            case '\uff8b': 
            case '\uff8c': 
            case '\uff8d': 
            case '\uff8e': {
                n |= 3;
                break;
            }
        }
        return n;
    }

    public static int getPronunciationElementForKana(char c2) {
        int n = 0;
        switch (c2) {
            case '\u3046': 
            case '\u304b': 
            case '\u304d': 
            case '\u304f': 
            case '\u3051': 
            case '\u3053': 
            case '\u3055': 
            case '\u3057': 
            case '\u3059': 
            case '\u305b': 
            case '\u305d': 
            case '\u305f': 
            case '\u3061': 
            case '\u3064': 
            case '\u3066': 
            case '\u3068': 
            case '\u30a6': 
            case '\u30ab': 
            case '\u30ad': 
            case '\u30af': 
            case '\u30b1': 
            case '\u30b3': 
            case '\u30b5': 
            case '\u30b7': 
            case '\u30b9': 
            case '\u30bb': 
            case '\u30bd': 
            case '\u30bf': 
            case '\u30c1': 
            case '\u30c4': 
            case '\u30c6': 
            case '\u30c8': {
                n |= 1;
                break;
            }
            case '\u306f': 
            case '\u3072': 
            case '\u3075': 
            case '\u3078': 
            case '\u307b': 
            case '\u30cf': 
            case '\u30d2': 
            case '\u30d5': 
            case '\u30d8': 
            case '\u30db': {
                n |= 3;
                break;
            }
        }
        return n;
    }

    public static String getValidBaseHiraganaChars(String string) {
        KanaConverter.resetKanaConversionBuffer();
        for (int i2 = 0; i2 < string.length(); ++i2) {
            kanaConversionBuffer.append(KanaConverter.getBaseCharacter(string.charAt(i2)));
        }
        return kanaConversionBuffer.toString();
    }

    private static void resetKanaConversionBuffer() {
        kanaConversionBuffer.delete(0, kanaConversionBuffer.length());
    }

    private KanaConverter() {
    }

    static {
        kanaConversionBuffer = new StringBuilder(64);
    }
}

