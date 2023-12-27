/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons;

import de.esolutions.fw.util.commons.ArrayUtils;
import de.esolutions.fw.util.commons.Buffer;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

public class StringUtils {
    public static final String DEFAULT_ENCODING;
    public static final char DEFAULT_SEPARATOR;
    private static final char[] nybbleChar;
    public static final int CROP_RIGHT;
    public static final int CROP_RIGHT_ELLIPSIS;
    public static final int CROP_LEFT;
    public static final int CROP_LEFT_ELLIPSIS;
    public static final int CROP_NONE;
    private static char[] special_chars;
    private static char[] special_quote;

    public static String toString(Object[] objectArray, char c2) {
        String string;
        if (objectArray == null) {
            string = "null";
        } else {
            Buffer buffer = new Buffer();
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                if (objectArray[i2] != null) {
                    buffer.append(objectArray[i2].toString());
                } else {
                    buffer.append("null");
                }
                if (i2 >= objectArray.length - 1) continue;
                buffer.append(c2);
            }
            string = buffer.toString();
        }
        return string;
    }

    public static String toString(Object[] objectArray) {
        return StringUtils.toString(objectArray, '|');
    }

    public static String[] toStrings(String string) {
        return StringUtils.toStrings(string, '|');
    }

    public static String[] toStrings(String string, char c2) {
        ArrayList arrayList = new ArrayList(10);
        StringTokenizer stringTokenizer = new StringTokenizer(string, String.valueOf(c2));
        while (stringTokenizer.hasMoreTokens()) {
            arrayList.add(stringTokenizer.nextToken().trim());
        }
        return (String[])arrayList.toArray(new String[arrayList.size()]);
    }

    public static void toHexByte(byte by, Buffer buffer) {
        buffer.append(nybbleChar[by >> 4 & 0xF]);
        buffer.append(nybbleChar[by & 0xF]);
    }

    public static void toHexShort(short s, Buffer buffer) {
        buffer.append(nybbleChar[s >> 12 & 0xF]);
        buffer.append(nybbleChar[s >> 8 & 0xF]);
        buffer.append(nybbleChar[s >> 4 & 0xF]);
        buffer.append(nybbleChar[s & 0xF]);
    }

    public static void toHexInt(int n, Buffer buffer) {
        buffer.append(nybbleChar[n >> 28 & 0xF]);
        buffer.append(nybbleChar[n >> 24 & 0xF]);
        buffer.append(nybbleChar[n >> 20 & 0xF]);
        buffer.append(nybbleChar[n >> 16 & 0xF]);
        buffer.append(nybbleChar[n >> 12 & 0xF]);
        buffer.append(nybbleChar[n >> 8 & 0xF]);
        buffer.append(nybbleChar[n >> 4 & 0xF]);
        buffer.append(nybbleChar[n & 0xF]);
    }

    public static String toHexString(byte[] byArray) {
        Buffer buffer = new Buffer();
        if (byArray != null && byArray.length > 0) {
            buffer = new Buffer(byArray.length * 2);
            for (int i2 = 0; i2 < byArray.length; ++i2) {
                StringUtils.toHexByte(byArray[i2], buffer);
                buffer.append(' ');
            }
        }
        return buffer.toString();
    }

    public static String toHexString(byte[] byArray, int n, int n2) {
        Buffer buffer = new Buffer();
        if (byArray != null && byArray.length > 0) {
            buffer = new Buffer(byArray.length * 3);
            int n3 = n;
            for (int i2 = 0; i2 < n2; ++i2) {
                StringUtils.toHexByte(byArray[n3], buffer);
                ++n3;
            }
        }
        return buffer.toString();
    }

    public static String toHexLine(byte[] byArray, int n, int n2) {
        int n3 = byArray.length;
        if (n3 == 0) {
            return "";
        }
        if (n + n2 > n3) {
            n2 = n3 - n;
        }
        Buffer buffer = new Buffer(n2 * 3);
        StringUtils.toHexInt(n, buffer);
        buffer.append(": ");
        for (int i2 = 0; i2 < n2; ++i2) {
            StringUtils.toHexByte(byArray[n], buffer);
            buffer.append(' ');
            ++n;
        }
        return buffer.toString();
    }

    public static String[] toHexLines(byte[] byArray, int n) {
        boolean bl;
        int n2;
        int n3 = byArray.length;
        if (n3 == 0) {
            return null;
        }
        int n4 = n2 = n3 / n;
        boolean bl2 = bl = n3 % n != 0;
        if (bl) {
            ++n4;
        }
        String[] stringArray = new String[n4];
        int n5 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            stringArray[i2] = StringUtils.toHexLine(byArray, n5, n);
            n5 += n;
        }
        if (bl) {
            stringArray[i2] = StringUtils.toHexLine(byArray, n5, n);
        }
        return stringArray;
    }

    public static String toHexTextLine(byte[] byArray, int n, int n2) {
        int n3;
        int n4 = byArray.length;
        if (n4 == 0) {
            return "";
        }
        int n5 = 0;
        int n6 = n2;
        if (n + n2 > n4) {
            n6 = n4 - n;
            n5 = n2 - n6;
        }
        Buffer buffer = new Buffer(n2 * 4);
        StringUtils.toHexInt(n, buffer);
        buffer.append(": ");
        int n7 = n;
        for (n3 = 0; n3 < n6; ++n3) {
            StringUtils.toHexByte(byArray[n7], buffer);
            buffer.append(' ');
            ++n7;
        }
        for (n3 = 0; n3 < n5; ++n3) {
            buffer.append("   ");
        }
        buffer.append(" ");
        n7 = n;
        for (n3 = 0; n3 < n6; ++n3) {
            byte by = byArray[n7];
            if (by > 31 && by < 127) {
                buffer.append((char)by);
            } else {
                buffer.append('.');
            }
            ++n7;
        }
        return buffer.toString();
    }

    public static String[] toHexTextLines(byte[] byArray, int n) {
        boolean bl;
        int n2;
        int n3 = byArray.length;
        if (n3 == 0) {
            return null;
        }
        int n4 = n2 = n3 / n;
        boolean bl2 = bl = n3 % n != 0;
        if (bl) {
            ++n4;
        }
        String[] stringArray = new String[n4];
        int n5 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            stringArray[i2] = StringUtils.toHexTextLine(byArray, n5, n);
            n5 += n;
        }
        if (bl) {
            stringArray[i2] = StringUtils.toHexTextLine(byArray, n5, n);
        }
        return stringArray;
    }

    public static String toString(Throwable throwable) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(byteArrayOutputStream, true, "UTF-8");
            throwable.printStackTrace(printStream);
            return byteArrayOutputStream.toString("UTF-8").replace('\r', ' ');
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            return "";
        }
    }

    public static String[] splitString(String string, char c2) {
        Object[] objectArray;
        if (string == null) {
            return null;
        }
        int n = string.indexOf(c2);
        if (n == -1) {
            String[] stringArray = new String[]{string};
            return stringArray;
        }
        ArrayList arrayList = new ArrayList(10);
        int n2 = 0;
        while (n != -1) {
            objectArray = string.substring(n2, n);
            arrayList.add(objectArray);
            n2 = n + 1;
            n = string.indexOf(c2, n2);
        }
        if (n2 < string.length()) {
            objectArray = string.substring(n2);
            arrayList.add(objectArray);
        }
        objectArray = new String[arrayList.size()];
        arrayList.toArray(objectArray);
        return objectArray;
    }

    public static String padString(String string, int n, int n2) {
        if (string == null) {
            return null;
        }
        int n3 = string.length();
        if (n3 == n) {
            return string;
        }
        if (n3 > n) {
            switch (n2) {
                case 1: {
                    if (n > 5) {
                        return new StringBuffer().append(string.substring(0, n - 3)).append("...").toString();
                    }
                }
                case 0: {
                    return string.substring(0, n);
                }
                case 3: {
                    if (n > 5) {
                        return new StringBuffer().append("...").append(string.substring(string.length() - (n - 3), string.length())).toString();
                    }
                }
                case 2: {
                    return string.substring(string.length() - n, string.length());
                }
            }
            return string;
        }
        Buffer buffer = new Buffer(string);
        int n4 = n - n3;
        for (int i2 = 0; i2 < n4; ++i2) {
            buffer.append(' ');
        }
        return buffer.toString();
    }

    public static String getArgString(int n, Object[] objectArray) {
        if (n < 0 || objectArray == null || n >= objectArray.length) {
            return new StringBuffer().append("%").append(n + 1).toString();
        }
        Object object = objectArray[n];
        if (object == null) {
            return "[null]";
        }
        if (object instanceof byte[]) {
            return StringUtils.toHexString((byte[])object);
        }
        if (object.getClass().isArray()) {
            Object[] objectArray2 = ArrayUtils.toObjects(object);
            if (objectArray2 == null) {
                objectArray2 = (Object[])object;
            }
            return StringUtils.toString(objectArray2);
        }
        if (object instanceof Throwable) {
            Throwable throwable = (Throwable)object;
            return StringUtils.toString(throwable);
        }
        return object.toString();
    }

    public static void expandArgStringToBuffer(String string, Object[] objectArray, Buffer buffer) {
        int n = 0;
        int n2 = string.length();
        while (n < n2) {
            int n3 = n;
            if ((n = string.indexOf("%", n)) == -1) {
                buffer.append(string.substring(n3, n2));
                break;
            }
            buffer.append(string.substring(n3, n));
            if (n == n2 - 1) break;
            String string2 = string.substring(n + 1, n + 2);
            if (string2.equals("%")) {
                buffer.append("%");
                n += 2;
                continue;
            }
            if (string2.equals("{")) {
                int n4 = string.indexOf("}", n);
                if (n4 == -1) {
                    ++n;
                    continue;
                }
                string2 = string.substring(n + 2, n4);
                if (StringUtils.addArgumentToBuffer(string2, buffer, objectArray)) {
                    n += string2.length() + 3;
                    continue;
                }
                buffer.append(string.substring(n + 1, n4 + 1));
                n += string2.length() + 3;
                continue;
            }
            if (Character.isDigit(string2.charAt(0))) {
                if (!StringUtils.addArgumentToBuffer(string2, buffer, objectArray)) continue;
                n += 2;
                continue;
            }
            if (Character.isDigit(string2.charAt(0))) continue;
            buffer.append(string2);
            n += 2;
        }
    }

    private static boolean addArgumentToBuffer(String string, Buffer buffer, Object[] objectArray) {
        try {
            int n = Integer.parseInt(string);
            buffer.append(StringUtils.getArgString(n - 1, objectArray));
            return true;
        }
        catch (NumberFormatException numberFormatException) {
            return false;
        }
    }

    public static String expandArgString(String string, Object[] objectArray) {
        Buffer buffer = new Buffer();
        StringUtils.expandArgStringToBuffer(string, objectArray, buffer);
        return buffer.toString();
    }

    public static String expandDateString(String string, Date date) {
        int n = string.indexOf(35);
        int n2 = string.lastIndexOf(35);
        if (n >= 0 && n2 >= 0 && n != n2) {
            Buffer buffer = new Buffer();
            if (n > 0) {
                buffer.append(string.substring(0, n));
            }
            String string2 = string.substring(n + 1, n2);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(string2);
            buffer.append(simpleDateFormat.format(date));
            int n3 = string.length();
            if (n2 < n3 - 1) {
                buffer.append(string.substring(n2 + 1));
            }
            return buffer.toString();
        }
        return string;
    }

    public static String addSuffix(String string, String string2) {
        if (string2 != null) {
            int n;
            int n2 = string.length();
            if (n2 < (n = string2.length())) {
                string = new StringBuffer().append(string).append(string2).toString();
            } else {
                int n3 = string.lastIndexOf(string2);
                if (n3 != n2 - n) {
                    string = new StringBuffer().append(string).append(string2).toString();
                }
            }
        }
        return string;
    }

    public static boolean hasSuffix(String string, String string2) {
        int n;
        if (string2 == null) {
            return true;
        }
        int n2 = string.length();
        if (n2 < (n = string2.length())) {
            return false;
        }
        return string.substring(n2 - n).equals(string2);
    }

    public static String cutSuffix(String string) {
        if (string == null) {
            return null;
        }
        int n = string.lastIndexOf(46);
        if (n == -1) {
            return string;
        }
        if (n == 0) {
            return null;
        }
        return string.substring(0, n);
    }

    public static String quoteString(String string, boolean bl) {
        if (string == null) {
            return null;
        }
        Buffer buffer = new Buffer();
        buffer.append('\"');
        if (string.length() > 0) {
            char[] cArray = new char[string.length()];
            string.getChars(0, string.length(), cArray, 0);
            for (int i2 = 0; i2 < cArray.length; ++i2) {
                char c2 = cArray[i2];
                boolean bl2 = false;
                for (int i3 = 0; i3 < special_chars.length; ++i3) {
                    if (special_chars[i3] != c2) continue;
                    buffer.append('\\');
                    buffer.append(special_quote[i3]);
                    bl2 = true;
                    break;
                }
                if (bl2) continue;
                if (bl && (c2 < ' ' || c2 > '\u007f')) {
                    buffer.append("\\u");
                    StringUtils.toHexShort((short)c2, buffer);
                    continue;
                }
                buffer.append(c2);
            }
        }
        buffer.append('\"');
        return buffer.toString();
    }

    public static String quoteString(String string) {
        return StringUtils.quoteString(string, true);
    }

    public static String unquoteString(String string) {
        if (string == null) {
            return null;
        }
        if (string.length() == 0) {
            return string;
        }
        int n = string.length();
        char[] cArray = new char[n];
        string.getChars(0, string.length(), cArray, 0);
        if (cArray[0] != '\"') {
            return string;
        }
        if (cArray[n - 1] != '\"') {
            return string;
        }
        if (n == 2) {
            return "";
        }
        Buffer buffer = new Buffer();
        for (int i2 = 1; i2 < n - 1; ++i2) {
            char c2 = cArray[i2];
            if (c2 == '\\') {
                int n2;
                int n3;
                char c3;
                if (i2 == n - 2) {
                    return null;
                }
                if ((c3 = cArray[++i2]) == 'u') {
                    if (i2 > n - 3) {
                        return null;
                    }
                    n3 = 0;
                    for (n2 = 1; n2 < 5; ++n2) {
                        int n4 = cArray[i2 + n2] - 48;
                        n3 = n4 + n3 * 16;
                    }
                    i2 += 4;
                    buffer.append((char)n3);
                    continue;
                }
                n3 = 0;
                for (n2 = 0; n2 < special_quote.length; ++n2) {
                    if (c3 != special_quote[n2]) continue;
                    buffer.append(special_chars[n2]);
                    n3 = 1;
                    break;
                }
                if (n3 != 0) continue;
                buffer.append('\\');
                buffer.append(c3);
                continue;
            }
            buffer.append(c2);
        }
        return buffer.toString();
    }

    static {
        nybbleChar = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        special_chars = new char[]{'\\', '\"', '/', '\b', '\f', '\n', '\r', '\t'};
        special_quote = new char[]{'\\', '\"', '/', 'b', 'f', 'n', 'r', 't'};
    }
}

