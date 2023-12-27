/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.korea;

import de.vw.mib.collections.ObjectObjectMap;
import de.vw.mib.util.StringBuilder;
import de.vw.mib.widgets.speller.asia.korea.Jamo$1;
import de.vw.mib.widgets.speller.asia.korea.Jamo$2;
import de.vw.mib.widgets.speller.asia.korea.Jamo$3;
import de.vw.mib.widgets.speller.asia.korea.Jamo$4;
import java.text.CollationKey;
import java.text.Collator;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public final class Jamo {
    public static final char KIYEOK_COMP;
    public static final char KIYEOK_LEAD;
    public static final char KIYEOK_TAIL;
    public static final char SSANGKIYEOK_COMP;
    public static final char SSANGKIYEOK_LEAD;
    public static final char SSANGKIYEOK_TAIL;
    public static final char KIYEOKSIOS_COMP;
    public static final char KIYEOKSIOS_TAIL;
    public static final char NIEUN_COMP;
    public static final char NIEUN_LEAD;
    public static final char NIEUN_TAIL;
    public static final char NIEUNCIEUC_COMP;
    public static final char NIEUNCIEUC_TAIL;
    public static final char NIEUNHIEUH_COMP;
    public static final char NIEUNHIEUH_TAIL;
    public static final char TIKEUT_COMP;
    public static final char TIKEUT_LEAD;
    public static final char TIKEUT_TAIL;
    public static final char SSANGTIKEUT_COMP;
    public static final char SSANGTIKEUT_LEAD;
    public static final char RIEUL_COMP;
    public static final char RIEUL_LEAD;
    public static final char RIEUL_TAIL;
    public static final char RIEULKIYEOK_COMP;
    public static final char RIEULKIYEOK_TAIL;
    public static final char RIEULMIEUM_COMP;
    public static final char RIEULMIEUM_TAIL;
    public static final char RIEULPIEUP_COMP;
    public static final char RIEULPIEUP_TAIL;
    public static final char RIEULSIOS_COMP;
    public static final char RIEULSIOS_TAIL;
    public static final char RIEULTHIEUTH_COMP;
    public static final char RIEULTHIEUTH_TAIL;
    public static final char RIEULPHIEUPH_COMP;
    public static final char RIEULPHIEUPH_TAIL;
    public static final char RIEULHIEUH_COMP;
    public static final char RIEULHIEUH_TAIL;
    public static final char MIEUM_COMP;
    public static final char MIEUM_LEAD;
    public static final char MIEUM_TAIL;
    public static final char PIEUP_COMP;
    public static final char PIEUP_LEAD;
    public static final char PIEUP_TAIL;
    public static final char PIEUPSIOS_COMP;
    public static final char PIEUPSIOS_TAIL;
    public static final char SSANGPIEUP_COMP;
    public static final char SSANGPIEUP_LEAD;
    public static final char SIOS_COMP;
    public static final char SIOS_LEAD;
    public static final char SIOS_TAIL;
    public static final char SSANGSIOS_COMP;
    public static final char SSANGSIOS_LEAD;
    public static final char SSANGSIOS_TAIL;
    public static final char IEUNG_COMP;
    public static final char IEUNG_LEAD;
    public static final char IEUNG_TAIL;
    public static final char CIEUC_COMP;
    public static final char CIEUC_LEAD;
    public static final char CIEUC_TAIL;
    public static final char SSANGCIEUC_COMP;
    public static final char SSANGCIEUC_LEAD;
    public static final char CHIEUCH_COMP;
    public static final char CHIEUCH_LEAD;
    public static final char CHIEUCH_TAIL;
    public static final char KHIEUKH_COMP;
    public static final char KHIEUKH_LEAD;
    public static final char KHIEUKH_TAIL;
    public static final char THIEUTH_COMP;
    public static final char THIEUTH_LEAD;
    public static final char THIEUTH_TAIL;
    public static final char PHIEUPH_COMP;
    public static final char PHIEUPH_LEAD;
    public static final char PHIEUPH_TAIL;
    public static final char HIEUH_COMP;
    public static final char HIEUH_LEAD;
    public static final char HIEUH_TAIL;
    public static final char A_COMP;
    public static final char A;
    public static final char AE_COMP;
    public static final char AE;
    public static final char YA_COMP;
    public static final char YA;
    public static final char YAE_COMP;
    public static final char YAE;
    public static final char EO_COMP;
    public static final char EO;
    public static final char E_COMP;
    public static final char E;
    public static final char YEO_COMP;
    public static final char YEO;
    public static final char YE_COMP;
    public static final char YE;
    public static final char O_COMP;
    public static final char O;
    public static final char WA_COMP;
    public static final char WA;
    public static final char WAE_COMP;
    public static final char WAE;
    public static final char OE_COMP;
    public static final char OE;
    public static final char YO_COMP;
    public static final char YO;
    public static final char U_COMP;
    public static final char U;
    public static final char WEO_COMP;
    public static final char WEO;
    public static final char WE_COMP;
    public static final char WE;
    public static final char WI_COMP;
    public static final char WI;
    public static final char YU_COMP;
    public static final char YU;
    public static final char EU_COMP;
    public static final char EU;
    public static final char YI_COMP;
    public static final char YI;
    public static final char I_COMP;
    public static final char I;
    public static final char MIN;
    public static final char MAX;
    public static final char MIN_LEAD;
    public static final char MAX_LEAD;
    public static final char MIN_VOWEL;
    public static final char MAX_VOWEL;
    public static final char MIN_TAIL;
    public static final char MAX_TAIL;
    public static final char MIN_COMP;
    public static final char MAX_COMP;
    public static final char MIN_COMP_VOWEL;
    public static final char MAX_COMP_VOWEL;
    public static final char MIN_HANGEUL;
    public static final char MAX_HANGEUL;
    public static final int COUNT_LEAD;
    public static final int COUNT_VOWEL;
    public static final int COUNT_TAIL;
    private static final int COUNT_VOWELTAIL;
    private static final int COUNT_LEADVOWELTAIL;
    private static final char RANGE1_COMP_CONSONANT_START;
    private static final char RANGE1_COMP_CONSONANT_END;
    private static final char RANGE2_COMP_CONSONANT_START;
    private static final char RANGE2_COMP_CONSONANT_END;
    private static final char RANGE1_COMP_TAILONLYCONSONANT_START;
    private static final char RANGE1_COMP_TAILONLYCONSONANT_END;
    private static final char RANGE2_COMP_TAILONLYCONSONANT_START;
    private static final char RANGE2_COMP_TAILONLYCONSONANT_END;
    public static final int FAVOR_LEAD;
    public static final int FAVOR_TAIL;
    protected static final ObjectObjectMap COMBINEDCOMPATIBILITYJAMOS;
    protected static final ObjectObjectMap COMPATIBILITYJAMO2JAMO;
    protected static final ObjectObjectMap DOUBLECONSONATS;
    protected static final ObjectObjectMap DOUBLEVOWELS;
    protected static char[] allJamos;
    protected static char[] allCompatibilityJamos;
    protected static char[] allConsonantCompatibilityJamos;
    protected static char[] allConsonantWithoutLeadOnlyCompatibilityJamos;
    protected static char[] allConsonantWithoutTailOnlyCompatibilityJamos;
    protected static char[] allVowelCompatibilityJamos;
    protected static Collator collator;

    public static char asCompatibilityJamo(char c2) {
        if (Jamo.isCompatibilityJamo(c2)) {
            return c2;
        }
        if (Jamo.isJamo(c2)) {
            Iterator iterator = COMPATIBILITYJAMO2JAMO.valueIterator();
            while (iterator.hasNext()) {
                Object object = iterator.next();
                if (!(object instanceof Character[] ? Arrays.binarySearch((Object[])((Character[])object), Jamo.valueOf(c2)) >= 0 : object.equals(Jamo.valueOf(c2)))) continue;
                return ((Character)COMPATIBILITYJAMO2JAMO.getOneKeyByValue(object)).charValue();
            }
            throw new IllegalArgumentException(new StringBuffer().append("No suitable Jamo found to convert! [jamo='").append(c2).append("']").toString());
        }
        throw new IllegalArgumentException(new StringBuffer().append("No Jamo passed to convert! [jamo='").append(c2).append("']").toString());
    }

    public static String asCompatibilityJamos(String string) {
        StringBuilder stringBuilder = new StringBuilder(string.length() + 1);
        for (int i2 = 0; i2 < string.length(); ++i2) {
            char c2 = string.charAt(i2);
            stringBuilder.append(Jamo.isJamo(c2) ? Jamo.asCompatibilityJamo(c2) : c2);
        }
        return stringBuilder.toString();
    }

    public static String asHangeuls(String string) {
        return Jamo.asHangeuls("", string);
    }

    public static String asHangeuls(String string, String string2) {
        String string3;
        StringBuilder stringBuilder = new StringBuilder(string.length() + string2.length());
        StringBuilder stringBuilder2 = new StringBuilder(string.length() + string2.length());
        StringBuilder stringBuilder3 = new StringBuilder(string2.length());
        int n = -1;
        if (string.length() > 0) {
            int n2 = string.length() - 1;
            char c2 = string.charAt(n2);
            if (!Jamo.isHangeul(c2)) {
                char c3;
                int n3;
                String string4 = string.substring(0, n2);
                String string5 = string.substring(n2);
                for (n3 = string4.length() - 1; n3 >= 0; --n3) {
                    c3 = string4.charAt(n3);
                    if (!Jamo.isJamo(c3)) {
                        stringBuilder.append(Jamo.asHangeuls(string4.substring(0, n3 + 1), ""));
                        break;
                    }
                    stringBuilder3.insert(0, c3);
                }
                for (n3 = 0; n3 < string5.length(); ++n3) {
                    c3 = string5.charAt(n3);
                    if (!Jamo.isJamo(c3)) {
                        n = stringBuilder.length();
                        stringBuilder.append(string5.substring(n3));
                        break;
                    }
                    stringBuilder3.append(c3);
                }
            } else {
                stringBuilder2.append(c2);
                stringBuilder.append(string.substring(0, n2));
            }
        }
        if ((string3 = Jamo.asHangeuls(stringBuilder2, stringBuilder3, string2, 0, string2.length())).length() > 0) {
            if (n >= 0) {
                stringBuilder.insert(n, string3);
            } else {
                stringBuilder.append(string3);
            }
        }
        return stringBuilder.toString();
    }

    /*
     * Enabled aggressive block sorting
     */
    protected static String asHangeuls(StringBuilder stringBuilder, StringBuilder stringBuilder2, String string, int n, int n2) {
        char c2;
        if (n < 0 || n >= n2 || n2 > string.length()) {
            if (stringBuilder2.length() <= 0) return stringBuilder.toString();
            String string2 = Jamo.composeHangeul(stringBuilder2.toString());
            stringBuilder2.clear();
            stringBuilder.append(string2);
            return stringBuilder.toString();
        }
        char c3 = stringBuilder.length() > 0 ? stringBuilder.charAt(stringBuilder.length() - 1) : (char)'\u0000';
        char c4 = stringBuilder2.length() > 0 ? stringBuilder2.charAt(stringBuilder2.length() - 1) : (char)'\u0000';
        int n3 = string.length();
        char c5 = n < n3 ? string.charAt(n) : (char)'\u0000';
        char c6 = n + 1 < n3 ? string.charAt(n + 1) : (char)'\u0000';
        char c7 = n + 2 < n3 ? string.charAt(n + 2) : (char)'\u0000';
        char c8 = c2 = n + 3 < n3 ? string.charAt(n + 3) : (char)'\u0000';
        if (Jamo.isHangeul(c3) && stringBuilder2.length() <= 1) {
            if (Jamo.isConsonant(c5)) return Jamo.asHangeuls(stringBuilder.deleteCharAt(stringBuilder.length() - 1), stringBuilder2.append(Jamo.decomposeHangeul(c3)), string, n, n2);
            if (!Jamo.isVowel(c5)) return Jamo.asHangeuls(stringBuilder.append(c5), stringBuilder2, string, ++n, n2);
            return Jamo.asHangeuls(stringBuilder.deleteCharAt(stringBuilder.length() - 1), stringBuilder2.append(Jamo.decomposeHangeul(c3)), string, n, n2);
        }
        if (Jamo.isJamo(c4)) {
            if (Jamo.isLeadConsonant(c4)) {
                if (!Jamo.isVowel(c5)) return stringBuilder.append(stringBuilder2).append(string.toCharArray(), n, n2).toString();
                String string3 = Jamo.composeHangeul(stringBuilder2.append(Jamo.asJamo(c5)).toString());
                stringBuilder2.clear();
                return Jamo.asHangeuls(stringBuilder.append(string3), stringBuilder2, string, ++n, n2);
            }
            if (Jamo.isVowel(c4)) {
                if (Jamo.isCombinedCompatibilityJamoAvailable(Jamo.asCompatibilityJamo(c4), c5)) {
                    String string4 = Jamo.composeHangeul(stringBuilder2.deleteCharAt(stringBuilder2.length() - 1).append(Jamo.asJamo(Jamo.getCombinedCompatibilityJamo(Jamo.asCompatibilityJamo(c4), c5))).toString());
                    stringBuilder2.clear();
                    return Jamo.asHangeuls(stringBuilder.append(string4), stringBuilder2, string, ++n, n2);
                }
                if (!Jamo.isTailConsonant(c5)) return stringBuilder.append(stringBuilder2).append(string.toCharArray(), n, n2).toString();
                String string5 = Jamo.composeHangeul(stringBuilder2.append(Jamo.asJamo(c5, 1)).toString());
                stringBuilder2.clear();
                return Jamo.asHangeuls(stringBuilder.append(string5), stringBuilder2, string, ++n, n2);
            }
            if (!Jamo.isTailConsonant(c4)) return stringBuilder.append(stringBuilder2).append(string.toCharArray(), n, n2).toString();
            if (Jamo.isLeadConsonant(c5)) {
                if (Jamo.isCombinedCompatibilityJamoAvailable(Jamo.asCompatibilityJamo(c4), c5)) {
                    String string6 = Jamo.composeHangeul(stringBuilder2.deleteCharAt(stringBuilder2.length() - 1).append(Jamo.asJamo(Jamo.getCombinedCompatibilityJamo(Jamo.asCompatibilityJamo(c4), c5))).toString());
                    stringBuilder2.clear();
                    return Jamo.asHangeuls(stringBuilder.append(string6), stringBuilder2, string, ++n, n2);
                }
                if (Jamo.isVowel(c6)) {
                    if (!Jamo.isTailConsonant(c7)) return stringBuilder.append(stringBuilder2).append(string.toCharArray(), n, n2).toString();
                    String string7 = Jamo.composeHangeul(stringBuilder2.append(Jamo.asJamo(c5)).append(Jamo.asJamo(c6)).append(Jamo.asJamo(c7, 1)).toString());
                    stringBuilder2.clear();
                    return Jamo.asHangeuls(stringBuilder.append(string7), stringBuilder2, string, n + 3, n2);
                }
                if (Jamo.isTailConsonant(c7)) {
                    if (!Jamo.isLeadConsonant(c2)) return stringBuilder.append(stringBuilder2).append(string.toCharArray(), n, n2).toString();
                    if (!Jamo.isCombinedCompatibilityJamoAvailable(c7, c2)) return stringBuilder.append(stringBuilder2).append(string.toCharArray(), n, n2).toString();
                    return stringBuilder.append(stringBuilder2).append(string.toCharArray(), n, n2).toString();
                }
                String string8 = Jamo.composeHangeul(stringBuilder2.toString());
                stringBuilder2.clear();
                return Jamo.asHangeuls(stringBuilder.append(string8), stringBuilder2.append(Jamo.asJamo(c5)), string, ++n, n2);
            }
            if (!Jamo.isVowel(c5)) return stringBuilder.append(stringBuilder2).append(string.toCharArray(), n, n2).toString();
            if (Jamo.isCombinedJamo(c4)) {
                String string9 = Jamo.getSingleCompatibilityJamos(c4);
                String string10 = Jamo.composeHangeul(stringBuilder2.deleteCharAt(stringBuilder2.length() - 1).append(Jamo.asJamo(string9.charAt(0), 1)).append(Jamo.asJamo(string9.charAt(1))).append(Jamo.asJamo(c5)).toString());
                stringBuilder2.clear();
                return Jamo.asHangeuls(stringBuilder.append(string10), stringBuilder2, string, ++n, n2);
            }
            String string11 = Jamo.composeHangeul(stringBuilder2.deleteCharAt(stringBuilder2.length() - 1).append(Jamo.asJamo(Jamo.asCompatibilityJamo(c4), 0)).append(Jamo.asJamo(c5)).toString());
            stringBuilder2.clear();
            return Jamo.asHangeuls(stringBuilder.append(string11), stringBuilder2, string, ++n, n2);
        }
        if (!Jamo.isLeadConsonant(c5)) return Jamo.asHangeuls(stringBuilder.append(c5), stringBuilder2, string, ++n, n2);
        if (!Jamo.isVowel(c6)) {
            if (!Jamo.isLeadConsonant(c6)) return Jamo.asHangeuls(stringBuilder, stringBuilder2.append(Jamo.asJamo(c5)), string, ++n, n2);
            if (!Jamo.isCombinedCompatibilityJamoAvailable(c5, c6)) return Jamo.asHangeuls(stringBuilder, stringBuilder2.append(Jamo.asJamo(c5)), string, ++n, n2);
            return Jamo.asHangeuls(stringBuilder, stringBuilder2.append(Jamo.asJamo(Jamo.getCombinedCompatibilityJamo(c5, c6))), string, n + 2, n2);
        }
        if (!Jamo.isTailConsonant(c7)) {
            String string12 = Jamo.composeHangeul(stringBuilder2.append(Jamo.asJamo(c5)).append(Jamo.asJamo(c6)).toString());
            stringBuilder2.clear();
            return Jamo.asHangeuls(stringBuilder.append(string12), stringBuilder2, string, n + 2, n2);
        }
        if (Jamo.isLeadConsonant(c2) && Jamo.isCombinedCompatibilityJamoAvailable(c7, c2)) {
            String string13 = Jamo.composeHangeul(stringBuilder2.append(Jamo.asJamo(c5)).append(Jamo.asJamo(c6)).append(Jamo.asJamo(Jamo.getCombinedCompatibilityJamo(c7, c2))).toString());
            stringBuilder2.clear();
            return Jamo.asHangeuls(stringBuilder.append(string13), stringBuilder2, string, n + 4, n2);
        }
        if (Jamo.isVowel(c2)) {
            String string14 = Jamo.composeHangeul(stringBuilder2.append(Jamo.asJamo(c5)).append(Jamo.asJamo(c6)).append(Jamo.asJamo(c7)).append(Jamo.asJamo(c2)).toString());
            stringBuilder2.clear();
            return Jamo.asHangeuls(stringBuilder.append(string14), stringBuilder2, string, n + 4, n2);
        }
        String string15 = Jamo.composeHangeul(stringBuilder2.append(Jamo.asJamo(c5)).append(Jamo.asJamo(c6)).append(Jamo.asJamo(c7, 1)).toString());
        stringBuilder2.clear();
        return Jamo.asHangeuls(stringBuilder.append(string15), stringBuilder2, string, n + 3, n2);
    }

    public static char asJamo(char c2) {
        return Jamo.asJamo(c2, 0);
    }

    public static char asJamo(char c2, int n) {
        if (Jamo.isJamo(c2)) {
            return c2;
        }
        if (Jamo.isCompatibilityJamo(c2)) {
            Object object = COMPATIBILITYJAMO2JAMO.get(Jamo.valueOf(c2));
            if (object instanceof Character[]) {
                return ((Character[])object)[n].charValue();
            }
            if (object != null) {
                return ((Character)object).charValue();
            }
            throw new IllegalArgumentException(new StringBuffer().append("Unknown compatibiliy Jamo passed to convert! [jamo='").append(c2).append("']").toString());
        }
        throw new IllegalArgumentException(new StringBuffer().append("No Jamo passed to convert! [jamo='").append(c2).append("']").toString());
    }

    public static String asJamos(String string) {
        StringBuilder stringBuilder = new StringBuilder(string.length() + 1);
        for (int i2 = 0; i2 < string.length(); ++i2) {
            char c2 = string.charAt(i2);
            if (Jamo.isCompatibilityJamo(c2)) {
                boolean bl;
                boolean bl2 = i2 > 0 && Jamo.isVowel(string.charAt(i2 - 1));
                boolean bl3 = bl = i2 + 1 < string.length() && Jamo.isVowel(string.charAt(i2 + 1));
                stringBuilder.append(Jamo.asJamo(c2, bl2 ? (bl ? 0 : 1) : 0));
                continue;
            }
            stringBuilder.append(c2);
        }
        return stringBuilder.toString();
    }

    public static synchronized String asJamosJDK(String string) {
        if (collator == null) {
            collator = Collator.getInstance(Locale.KOREA);
            collator.setDecomposition(2);
            collator.setStrength(3);
        }
        CollationKey collationKey = collator.getCollationKey(string);
        byte[] byArray = collationKey.toByteArray();
        int n = 0;
        for (int i2 = byArray.length - 2; i2 >= 0 && (byArray[i2] != 0 || byArray[i2 + 1] != 0); i2 -= 2) {
            n = i2;
        }
        byte[] byArray2 = new byte[byArray.length - n];
        System.arraycopy((Object)byArray, n, (Object)byArray2, 0, byArray2.length);
        return String.valueOf(Jamo.toCharArray(byArray2));
    }

    static String composeHangeul(String string) {
        int n = string.length();
        if (n == 0) {
            return "";
        }
        char c2 = string.charAt(0);
        StringBuilder stringBuilder = new StringBuilder(n);
        stringBuilder.append(c2);
        for (int i2 = 1; i2 < n; ++i2) {
            int n2;
            int n3;
            char c3 = string.charAt(i2);
            int n4 = c2 - 4352;
            if (0 <= n4 && n4 < 19 && 0 <= (n3 = c3 - 4449) && n3 < 21) {
                c2 = (char)(0xAC0000 + (n4 * 21 + n3) * 28);
                stringBuilder.setCharAt(stringBuilder.length() - 1, c2);
                continue;
            }
            n3 = c2 - 0xAC0000;
            if (0 <= n3 && n3 < 11172 && n3 % 28 == 0 && 0 <= (n2 = c3 - 4519) && n2 <= 28) {
                c2 = (char)(c2 + n2);
                stringBuilder.setCharAt(stringBuilder.length() - 1, c2);
                continue;
            }
            c2 = c3;
            stringBuilder.append(c3);
        }
        return stringBuilder.toString();
    }

    static String decomposeHangeul(char c2) {
        int n = c2 - 0xAC0000;
        if (n < 0 || n >= 11172) {
            return String.valueOf(c2);
        }
        int n2 = 4352 + n / 588;
        int n3 = 4449 + n % 588 / 28;
        int n4 = 4519 + n % 28;
        StringBuilder stringBuilder = new StringBuilder(4).append((char)n2).append((char)n3);
        if (n4 != 4519) {
            stringBuilder.append((char)n4);
        }
        return stringBuilder.toString();
    }

    static String decomposeHangeuls(String string) {
        StringBuilder stringBuilder = new StringBuilder(string.length() * 3);
        for (int i2 = string.length() - 1; i2 >= 0; --i2) {
            stringBuilder.append(Jamo.decomposeHangeul(string.charAt(i2)));
        }
        return stringBuilder.toString();
    }

    protected static char[] flatten(Iterator iterator) {
        Object object;
        LinkedList linkedList = new LinkedList();
        while (iterator.hasNext()) {
            object = iterator.next();
            if (object instanceof Character[]) {
                linkedList.addAll(Arrays.asList((Character[])object));
                continue;
            }
            linkedList.add(object);
        }
        object = new char[linkedList.size()];
        for (int i2 = 0; i2 < linkedList.size(); ++i2) {
            object[i2] = ((Character)linkedList.get(i2)).charValue();
        }
        return object;
    }

    public static synchronized char[] getAllCompatibilityJamos() {
        if (allCompatibilityJamos == null) {
            allCompatibilityJamos = Jamo.flatten(COMPATIBILITYJAMO2JAMO.keySet().iterator());
        }
        return allCompatibilityJamos;
    }

    public static String getAllCompatibilityJamosAsString() {
        return String.valueOf(Jamo.getAllCompatibilityJamos());
    }

    public static synchronized char[] getAllConsonantCompatibilityJamos() {
        if (allConsonantCompatibilityJamos == null) {
            char[] cArray = new char[Jamo.getAllCompatibilityJamos().length];
            int n = 0;
            for (int i2 = 0; i2 < Jamo.getAllCompatibilityJamos().length; ++i2) {
                char c2 = Jamo.getAllCompatibilityJamos()[i2];
                if (!Jamo.isConsonant(c2)) continue;
                cArray[n++] = c2;
            }
            allConsonantCompatibilityJamos = new char[n];
            System.arraycopy((Object)cArray, 0, (Object)allConsonantCompatibilityJamos, 0, allConsonantCompatibilityJamos.length);
        }
        return allConsonantCompatibilityJamos;
    }

    public static String getAllConsonantCompatibilityJamosAsString() {
        return String.valueOf(Jamo.getAllConsonantCompatibilityJamos());
    }

    public static synchronized char[] getAllConsonantWithoutLeadOnlyCompatibilityJamos() {
        if (allConsonantWithoutLeadOnlyCompatibilityJamos == null) {
            char[] cArray = new char[Jamo.getAllConsonantCompatibilityJamos().length];
            int n = 0;
            for (int i2 = 0; i2 < Jamo.getAllConsonantCompatibilityJamos().length; ++i2) {
                char c2 = Jamo.getAllConsonantCompatibilityJamos()[i2];
                if (Jamo.isLeadOnlyConsonant(c2)) continue;
                cArray[n++] = c2;
            }
            allConsonantWithoutLeadOnlyCompatibilityJamos = new char[n];
            System.arraycopy((Object)cArray, 0, (Object)allConsonantWithoutLeadOnlyCompatibilityJamos, 0, allConsonantWithoutLeadOnlyCompatibilityJamos.length);
        }
        return allConsonantWithoutLeadOnlyCompatibilityJamos;
    }

    public static String getAllConsonantWithoutLeadOnlyCompatibilityJamosAsString() {
        return String.valueOf(Jamo.getAllConsonantWithoutLeadOnlyCompatibilityJamos());
    }

    public static synchronized char[] getAllConsonantWithoutTailOnlyCompatibilityJamos() {
        if (allConsonantWithoutTailOnlyCompatibilityJamos == null) {
            char[] cArray = new char[Jamo.getAllConsonantCompatibilityJamos().length];
            int n = 0;
            for (int i2 = 0; i2 < Jamo.getAllConsonantCompatibilityJamos().length; ++i2) {
                char c2 = Jamo.getAllConsonantCompatibilityJamos()[i2];
                if (Jamo.isTailOnlyConsonant(c2)) continue;
                cArray[n++] = c2;
            }
            allConsonantWithoutTailOnlyCompatibilityJamos = new char[n];
            System.arraycopy((Object)cArray, 0, (Object)allConsonantWithoutTailOnlyCompatibilityJamos, 0, allConsonantWithoutTailOnlyCompatibilityJamos.length);
        }
        return allConsonantWithoutTailOnlyCompatibilityJamos;
    }

    public static String getAllConsonantWithoutTailOnlyCompatibilityJamosAsString() {
        return String.valueOf(Jamo.getAllConsonantWithoutTailOnlyCompatibilityJamos());
    }

    public static synchronized char[] getAllVowelCompatibilityJamos() {
        if (allVowelCompatibilityJamos == null) {
            char[] cArray = new char[Jamo.getAllCompatibilityJamos().length];
            int n = 0;
            for (int i2 = 0; i2 < Jamo.getAllCompatibilityJamos().length; ++i2) {
                char c2 = Jamo.getAllCompatibilityJamos()[i2];
                if (!Jamo.isVowel(c2)) continue;
                cArray[n++] = c2;
            }
            allVowelCompatibilityJamos = new char[n];
            System.arraycopy((Object)cArray, 0, (Object)allVowelCompatibilityJamos, 0, allVowelCompatibilityJamos.length);
        }
        return allVowelCompatibilityJamos;
    }

    public static String getAllVowelCompatibilityJamosAsString() {
        return String.valueOf(Jamo.getAllVowelCompatibilityJamos());
    }

    public static synchronized char[] getAllJamos() {
        if (allJamos == null) {
            allJamos = Jamo.flatten(COMPATIBILITYJAMO2JAMO.values().iterator());
        }
        return allJamos;
    }

    public static String getAllJamosAsString() {
        return String.valueOf(Jamo.getAllJamos());
    }

    public static String getAvailableCompatibilityJamosAsString(String string) {
        if (string == null || string.length() <= 0) {
            return Jamo.getAllConsonantWithoutTailOnlyCompatibilityJamosAsString();
        }
        char c2 = string.charAt(string.length() - 1);
        if (Jamo.isJamo(c2) || Jamo.isCompatibilityJamo(c2)) {
            if (Jamo.isLeadConsonant(c2)) {
                if (Jamo.isDoubleConsonantAvailable(c2)) {
                    return Jamo.getAllVowelCompatibilityJamosAsString().concat(String.valueOf(Jamo.asCompatibilityJamo(c2)));
                }
                return Jamo.getAllVowelCompatibilityJamosAsString();
            }
            if (Jamo.isVowel(c2)) {
                if (Jamo.isDoubleVowelAvailable(c2)) {
                    return Jamo.getAllConsonantWithoutLeadOnlyCompatibilityJamosAsString().concat(String.valueOf(Jamo.asCompatibilityJamo(c2)));
                }
                return Jamo.getAllConsonantWithoutLeadOnlyCompatibilityJamosAsString();
            }
            if (Jamo.isTailConsonant(c2)) {
                return Jamo.getAllConsonantWithoutTailOnlyCompatibilityJamosAsString();
            }
            return Jamo.getAllConsonantWithoutTailOnlyCompatibilityJamosAsString();
        }
        if (Jamo.isHangeul(c2)) {
            return Jamo.getAvailableCompatibilityJamosAsString(Jamo.decomposeHangeul(c2));
        }
        return Jamo.getAllConsonantWithoutTailOnlyCompatibilityJamosAsString();
    }

    public static char getCombinedCompatibilityJamo(char c2, char c3) {
        if (Jamo.isCombinedCompatibilityJamoAvailable(c2, c3)) {
            return ((Character)COMBINEDCOMPATIBILITYJAMOS.get(Jamo.valueOf(Jamo.valuesOf(c2, c3)))).charValue();
        }
        throw new IllegalArgumentException(new StringBuffer().append("No combined compatibility Jamo available! [compJamo0='").append(c2).append("', compJamo1='").append(c3).append("']").toString());
    }

    public static char getDoubleCompatibilityConsonant(char c2) {
        if (Jamo.isDoubleConsonantAvailable(c2)) {
            return ((Character)DOUBLECONSONATS.getOneKeyByValue(Jamo.valueOf(c2))).charValue();
        }
        throw new IllegalArgumentException(new StringBuffer().append("No double consonant Jamo available! [compJamo='").append(c2).append("']").toString());
    }

    public static String getPossibleCombinableCompatibilityJamos(char c2) {
        if (Jamo.isJamo(c2)) {
            return Jamo.getPossibleCombinableCompatibilityJamos(Jamo.asCompatibilityJamo(c2));
        }
        if (Jamo.isCompatibilityJamo(c2)) {
            StringBuilder stringBuilder = new StringBuilder(COMBINEDCOMPATIBILITYJAMOS.size() + 1);
            Iterator iterator = COMBINEDCOMPATIBILITYJAMOS.keyIterator();
            while (iterator.hasNext()) {
                int n;
                String string = (String)iterator.next();
                if (string == null || string.length() <= 0 || (n = string.indexOf(c2)) != 0) continue;
                stringBuilder.append(string.charAt(1));
            }
            return stringBuilder.toString();
        }
        return "";
    }

    public static String getSingleCompatibilityJamos(char c2) {
        if (Jamo.isCombinedJamo(c2)) {
            return (String)COMBINEDCOMPATIBILITYJAMOS.getOneKeyByValue(Jamo.valueOf(Jamo.asCompatibilityJamo(c2)));
        }
        throw new IllegalArgumentException(new StringBuffer().append("No combined compatibility Jamo passed! [jamo='").append(c2).append("']").toString());
    }

    public static boolean isCombinedCompatibilityJamoAvailable(char c2, char c3) {
        if (Jamo.isCompatibilityJamo(c2) && Jamo.isCompatibilityJamo(c3)) {
            return COMBINEDCOMPATIBILITYJAMOS.containsKey(Jamo.valueOf(Jamo.valuesOf(c2, c3)));
        }
        if (Jamo.isJamo(c2) || Jamo.isJamo(c3)) {
            return Jamo.isCombinedCompatibilityJamoAvailable(Jamo.asCompatibilityJamo(c2), Jamo.asCompatibilityJamo(c3));
        }
        return false;
    }

    public static boolean isCombinedJamo(char c2) {
        if (Jamo.isJamo(c2)) {
            return COMBINEDCOMPATIBILITYJAMOS.containsValue(Jamo.valueOf(Jamo.asCompatibilityJamo(c2)));
        }
        return false;
    }

    public static boolean isCompatibilityJamo(char c2) {
        return '\u3130' <= c2 && c2 <= '\u318f';
    }

    public static boolean isCompatibilityJamo(String string) {
        boolean bl = true;
        for (int i2 = 0; i2 < string.length(); ++i2) {
            boolean bl2 = bl = bl && Jamo.isCompatibilityJamo(string.charAt(i2));
            if (!bl) break;
        }
        return bl;
    }

    public static boolean isConsonant(char c2) {
        if (Jamo.isJamo(c2)) {
            return Jamo.isLeadConsonant(c2) || Jamo.isTailConsonant(c2);
        }
        if (Jamo.isCompatibilityJamo(c2)) {
            return '\u3131' <= c2 && c2 <= '\u314e' || '\u3165' <= c2 && c2 <= '\u318e';
        }
        return false;
    }

    public static boolean isDoubleConsonant(char c2) {
        if (Jamo.isConsonant(c2)) {
            return DOUBLECONSONATS.containsKey(Jamo.valueOf(c2));
        }
        return false;
    }

    public static boolean isDoubleConsonantAvailable(char c2) {
        if (Jamo.isConsonant(c2)) {
            return DOUBLECONSONATS.containsValue(Jamo.valueOf(c2));
        }
        return false;
    }

    public static boolean isDoubleVowel(char c2) {
        if (Jamo.isVowel(c2)) {
            return DOUBLEVOWELS.containsKey(Jamo.valueOf(c2));
        }
        return false;
    }

    public static boolean isDoubleVowelAvailable(char c2) {
        if (Jamo.isVowel(c2)) {
            return DOUBLEVOWELS.containsValue(Jamo.valueOf(c2));
        }
        return false;
    }

    public static boolean isHangeul(char c2) {
        return '\uac0000' <= c2 && c2 <= '\ua3d70000';
    }

    public static boolean isJamo(char c2) {
        return '\u1100' <= c2 && c2 <= '\u11ff';
    }

    public static boolean isJamos(String string) {
        boolean bl = false;
        if (string != null) {
            for (int i2 = string.length() - 1; i2 >= 0; --i2) {
                boolean bl2 = bl = bl || Jamo.isJamo(string.charAt(i2));
                if (!bl) break;
            }
        }
        return bl;
    }

    public static boolean isLeadConsonant(char c2) {
        if (Jamo.isJamo(c2)) {
            return '\u1100' <= c2 && c2 <= '\u115f';
        }
        if (Jamo.isCompatibilityJamo(c2)) {
            return (Jamo.isLeadOnlyConsonant(c2) || Jamo.isConsonant(c2)) && !Jamo.isTailOnlyConsonant(c2);
        }
        return false;
    }

    public static boolean isLeadOnlyConsonant(char c2) {
        if (Jamo.isJamo(c2)) {
            return Jamo.isLeadConsonant(c2) && !Jamo.isTailConsonant(c2);
        }
        if (Jamo.isCompatibilityJamo(c2)) {
            return c2 == '\u3138' || c2 == '\u3143' || c2 == '\u3149';
        }
        return false;
    }

    public static boolean isTailConsonant(char c2) {
        if (Jamo.isJamo(c2)) {
            return '\u11a8' <= c2 && c2 <= '\u11ff';
        }
        if (Jamo.isCompatibilityJamo(c2)) {
            return Jamo.isTailOnlyConsonant(c2) || !Jamo.isLeadOnlyConsonant(c2) && Jamo.isConsonant(c2);
        }
        return false;
    }

    public static boolean isTailOnlyConsonant(char c2) {
        if (Jamo.isJamo(c2)) {
            return !Jamo.isLeadConsonant(c2) && Jamo.isTailConsonant(c2);
        }
        if (Jamo.isCompatibilityJamo(c2)) {
            return c2 == '\u3133' || '\u3135' <= c2 && c2 <= '\u3136' || '\u313a' <= c2 && c2 <= '\u3140' || c2 == '\u3144';
        }
        return false;
    }

    public static boolean isVowel(char c2) {
        if (Jamo.isJamo(c2)) {
            return '\u1161' <= c2 && c2 <= '\u11a7';
        }
        if (Jamo.isCompatibilityJamo(c2)) {
            return '\u314f' <= c2 && c2 <= '\u3163';
        }
        return false;
    }

    protected static char[] toCharArray(byte[] byArray) {
        char[] cArray = new char[byArray.length / 2];
        for (int i2 = 0; i2 < cArray.length; ++i2) {
            char c2 = (char)((char)byArray[i2 * 2] << 8);
            cArray[i2] = c2 = (char)(c2 + (0xFF & byArray[i2 * 2 + 1]));
        }
        return cArray;
    }

    protected static Character valueOf(char c2) {
        return new Character(c2);
    }

    protected static String valueOf(Character[] characterArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < characterArray.length; ++i2) {
            stringBuilder.append(characterArray[i2].charValue());
        }
        return stringBuilder.toString();
    }

    protected static Character[] valuesOf(char c2, char c3) {
        return new Character[]{Jamo.valueOf(c2), Jamo.valueOf(c3)};
    }

    private Jamo() {
    }

    static {
        COMBINEDCOMPATIBILITYJAMOS = new Jamo$1();
        COMPATIBILITYJAMO2JAMO = new Jamo$2();
        DOUBLECONSONATS = new Jamo$3();
        DOUBLEVOWELS = new Jamo$4();
    }
}

