/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.util;

import de.vw.mib.collections.ObjectArrayList;
import de.vw.mib.collections.chars.CharacterOptHashSet;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.util.StringBuilder;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public final class StringUtil {
    private static final String[] EMPTY_STRINGS = new String[0];
    private static final int ASCII_CHARS;
    private static final int ASCII_MASK;
    private static final String[] ASCII_CHAR_STRINGS;

    public static String replaceAll(String string, String string2, String string3) {
        String string4;
        int n;
        int n2 = string2.length();
        int n3 = n = 0 == n2 ? -1 : string.indexOf(string2);
        if (0 > n) {
            string4 = string;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            int n4 = 0;
            do {
                stringBuilder.append(string.substring(n4, n)).append(string3);
            } while (0 < (n = string.indexOf(string2, n4 = n + n2)));
            stringBuilder.append(string.substring(n4));
            string4 = stringBuilder.toString();
        }
        return string4;
    }

    public static String[] split(String string, String string2) {
        String[] stringArray;
        int n = string.length();
        int n2 = string2.length();
        if (0 == n) {
            stringArray = EMPTY_STRINGS;
        } else if (0 == n2) {
            stringArray = StringUtil.getSingleCharacters(string);
        } else {
            ArrayList arrayList = new ArrayList();
            int n3 = -n2;
            int n4 = string.indexOf(string2);
            while (0 <= n4) {
                if (n4 > n3 + n2) {
                    arrayList.add(string.subSequence(n3 + n2, n4));
                }
                n3 = n4;
                n4 = string.indexOf(string2, n3 + 1);
            }
            if (n > n3 + n2) {
                arrayList.add(string.subSequence(n3 + n2, n));
            }
            stringArray = (String[])arrayList.toArray(new String[arrayList.size()]);
        }
        return stringArray;
    }

    public static String[] getSingleCharacters(String string) {
        int n = string.length();
        String[] stringArray = new String[n];
        for (int i2 = n - 1; i2 >= 0; --i2) {
            stringArray[i2] = StringUtil.charToString(string.charAt(i2));
        }
        return stringArray;
    }

    public static String[] split(String string, String[] stringArray) {
        if (string.length() == 0) {
            return new String[0];
        }
        if (stringArray.length == 0) {
            return new String[]{string};
        }
        IntObjectOptHashMap intObjectOptHashMap = IntObjectOptHashMap.createWithNeutralValue(string.length(), 63, 63, "");
        for (int i2 = stringArray.length - 1; i2 >= 0; --i2) {
            if (stringArray[i2].length() == 0) {
                return StringUtil.getSingleCharacters(string);
            }
            StringUtil.addToFoundMap(string, intObjectOptHashMap, stringArray[i2], 0);
        }
        ArrayList arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        int n = -1;
        for (int i3 = 0; i3 < string.length(); ++i3) {
            String string2 = (String)intObjectOptHashMap.get(i3);
            if (string2.length() == 0) {
                if (i3 <= n) continue;
                stringBuilder.append(string.charAt(i3));
                continue;
            }
            if (stringBuilder.length() > 0) {
                arrayList.add(stringBuilder.toString());
            }
            stringBuilder.setLength(0);
            n = Math.max(n, i3 + string2.length() - 1);
            StringUtil.addToFoundMap(string, intObjectOptHashMap, string2, i3 + 1);
        }
        if (stringBuilder.length() > 0) {
            arrayList.add(stringBuilder.toString());
        }
        return (String[])arrayList.toArray(new String[arrayList.size()]);
    }

    private static void addToFoundMap(String string, IntObjectOptHashMap intObjectOptHashMap, String string2, int n) {
        if (string2 == null || string2.length() == 0 || n >= string.length()) {
            return;
        }
        int n2 = string.indexOf(string2, n);
        if (n2 < 0) {
            return;
        }
        String string3 = (String)intObjectOptHashMap.get(n2);
        if (string3.length() < string2.length()) {
            intObjectOptHashMap.put(n2, string2);
            StringUtil.addToFoundMap(string, intObjectOptHashMap, string3, n2 + 1);
        } else {
            StringUtil.addToFoundMap(string, intObjectOptHashMap, string2, n2 + 1);
        }
    }

    public static boolean contains(CharSequence charSequence, char c2) {
        for (int i2 = charSequence.length() - 1; i2 >= 0; --i2) {
            if (charSequence.charAt(i2) != c2) continue;
            return true;
        }
        return false;
    }

    public static boolean contains(CharSequence charSequence, CharSequence charSequence2) {
        int n;
        if (charSequence2.length() == 0) {
            return true;
        }
        int n2 = n = charSequence2.length() - 1;
        for (int i2 = charSequence.length() - 1; i2 >= n2; --i2) {
            if (charSequence.charAt(i2) == charSequence2.charAt(n2)) {
                if (n2 == 0) {
                    return true;
                }
                --n2;
                continue;
            }
            i2 += n - n2;
            n2 = n;
        }
        return false;
    }

    public static String intersectStrings(String string, String string2) {
        int n = 0;
        int n2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        int n3 = string.length();
        int n4 = string2.length();
        while (n < n3 && n2 < n4) {
            int n5 = n;
            int n6 = n2;
            while (string.charAt(n5) != string2.charAt(n6)) {
                if (++n6 < n4) continue;
                n6 = n2;
                if (++n5 < n3) continue;
                return stringBuilder.toString();
            }
            stringBuilder.append(string.charAt(n5));
            n = n5 + 1;
            n2 = n6 + 1;
        }
        return stringBuilder.toString();
    }

    public static String intersectCharSets(String string, String string2) {
        int n = string.length();
        int n2 = string2.length();
        if (n == 0 || n2 == 0) {
            return "";
        }
        char[] cArray = string.toCharArray();
        char[] cArray2 = string2.toCharArray();
        CharacterOptHashSet characterOptHashSet = new CharacterOptHashSet(n2);
        for (int i2 = n2 - 1; i2 >= 0; --i2) {
            characterOptHashSet.add(cArray2[i2]);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i3 = 0; i3 < n; ++i3) {
            char c2 = cArray[i3];
            if (!characterOptHashSet.contains(c2)) continue;
            stringBuilder.append(c2);
        }
        return stringBuilder.toString();
    }

    public static String replaceNullByEmptyString(String string) {
        return string == null ? "" : string;
    }

    public static int getUtf8ByteLength(String string) {
        int n = 0;
        for (int i2 = string.length() - 1; i2 >= 0; --i2) {
            char c2 = string.charAt(i2);
            if (c2 <= '\u007f') {
                ++n;
                continue;
            }
            if (c2 <= '\u07ff') {
                n += 2;
                continue;
            }
            n += 3;
        }
        return n;
    }

    public static String[] filterStringList(String[] stringArray, String string) {
        int n = stringArray.length;
        int n2 = string.length();
        if (n == 0 || n2 == 0) {
            return new String[0];
        }
        char[] cArray = string.toCharArray();
        CharacterOptHashSet characterOptHashSet = new CharacterOptHashSet(n2);
        for (int i2 = n2 - 1; i2 >= 0; --i2) {
            characterOptHashSet.add(cArray[i2]);
        }
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (int i3 = 0; i3 < n; ++i3) {
            String string2 = stringArray[i3];
            boolean bl = true;
            for (int i4 = string2.length() - 1; i4 >= 0; --i4) {
                if (characterOptHashSet.contains(string2.charAt(i4))) continue;
                bl = false;
                break;
            }
            if (!bl) continue;
            objectArrayList.add(string2);
        }
        return (String[])objectArrayList.toArray(new String[objectArrayList.size()]);
    }

    public static String convertUTF8BEIntToString(int n) {
        String string;
        if (n == (n & 0x7F)) {
            string = StringUtil.charToString((char)n);
        } else {
            byte by = (byte)(n >> 24);
            byte by2 = (byte)(n >> 16);
            byte by3 = (byte)(n >> 8);
            byte by4 = (byte)n;
            byte[] byArray = 0 != by ? new byte[]{by, by2, by3, by4} : (0 != by2 ? new byte[]{by2, by3, by4} : (0 != by3 ? new byte[]{by3, by4} : new byte[]{by4}));
            StringUtil.validateUTF8Sequence(byArray);
            try {
                string = new String(byArray, "UTF8");
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                throw new RuntimeException("UTF8 conversion failed", unsupportedEncodingException);
            }
        }
        return string;
    }

    private static void validateUTF8Sequence(byte[] byArray) {
        int n = byArray.length;
        int n2 = 1 == n ? 128 : -128 >> n & 0xFF;
        for (int i2 = 0; i2 < byArray.length; ++i2) {
            if ((byArray[i2] & n2) != (n2 << 1 & n2)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Illegal UTF8 ").append(n).append("-byte sequence, byte #").append(i2 + 1).append(": ").appendHex(byArray[i2] & 0xFF);
                stringBuilder.append(", seq=");
                StringUtil.appendSequence(stringBuilder, byArray);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            n2 = 192;
        }
    }

    public static StringBuilder appendSequence(StringBuilder stringBuilder, byte[] byArray) {
        if (null == byArray) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append("[");
            for (int i2 = 0; i2 < byArray.length; ++i2) {
                if (0 < i2) {
                    stringBuilder.append(" ");
                }
                stringBuilder.append("0x").append(StringUtil.nibbleToHexChar(byArray[i2] >> 4)).append(StringUtil.nibbleToHexChar(byArray[i2]));
            }
            stringBuilder.append("]");
        }
        return stringBuilder;
    }

    private static char nibbleToHexChar(int n) {
        return (char)(10 <= (n &= 0xF) ? 48 + n : 87 + n);
    }

    public static String charToString(char c2) {
        String string = c2 < '\u0080' ? ASCII_CHAR_STRINGS[c2] : Character.toString(c2);
        return string;
    }

    private StringUtil() {
    }

    static {
        ASCII_CHAR_STRINGS = new String[128];
        for (char c2 = '\u0000'; c2 < '\u0080'; c2 = (char)(c2 + '\u0001')) {
            StringUtil.ASCII_CHAR_STRINGS[c2] = Character.toString(c2);
        }
    }
}

