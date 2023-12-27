/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.util;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Inet6Util {
    static String hexCharacters = "0123456789ABCDEF";

    public static byte[] createByteArrayFromIPAddressString(String string) {
        int n;
        if (Inet6Util.isValidIPV4Address(string)) {
            StringTokenizer stringTokenizer = new StringTokenizer(string, ".");
            String string2 = "";
            int n2 = 0;
            byte[] byArray = new byte[4];
            int n3 = 0;
            while (n3 < 4) {
                string2 = stringTokenizer.nextToken();
                n2 = Integer.parseInt(string2);
                byArray[n3] = (byte)n2;
                ++n3;
            }
            return byArray;
        }
        if (string.charAt(0) == '[') {
            string = string.substring(1, string.length() - 1);
        }
        StringTokenizer stringTokenizer = new StringTokenizer(string, ":.", true);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String string3 = "";
        String string4 = "";
        int n4 = -1;
        while (stringTokenizer.hasMoreTokens()) {
            string4 = string3;
            string3 = stringTokenizer.nextToken();
            if (string3.equals(":")) {
                if (string4.equals(":")) {
                    n4 = arrayList.size();
                    continue;
                }
                if (string4.equals("")) continue;
                arrayList.add(string4);
                continue;
            }
            if (!string3.equals(".")) continue;
            arrayList2.add(string4);
        }
        if (string4.equals(":")) {
            if (string3.equals(":")) {
                n4 = arrayList.size();
            } else {
                arrayList.add(string3);
            }
        } else if (string4.equals(".")) {
            arrayList2.add(string3);
        }
        int n5 = 8;
        if (arrayList2.size() > 0) {
            n5 -= 2;
        }
        if (n4 != -1) {
            int n6 = n5 - arrayList.size();
            n = 0;
            while (n < n6) {
                arrayList.add(n4, "0");
                ++n;
            }
        }
        byte[] byArray = new byte[16];
        n = 0;
        while (n < arrayList.size()) {
            Inet6Util.convertToBytes((String)arrayList.get(n), byArray, n * 2);
            ++n;
        }
        n = 0;
        while (n < arrayList2.size()) {
            byArray[n + 12] = (byte)(Integer.parseInt((String)arrayList2.get(n)) & 0xFF);
            ++n;
        }
        n = 1;
        int n7 = 0;
        while (n7 < 10) {
            if (byArray[n7] != 0) {
                n = 0;
                break;
            }
            ++n7;
        }
        if (byArray[10] != -1 || byArray[11] != -1) {
            n = 0;
        }
        if (n != 0) {
            byte[] byArray2 = new byte[4];
            int n8 = 0;
            while (n8 < 4) {
                byArray2[n8] = byArray[n8 + 12];
                ++n8;
            }
            return byArray2;
        }
        return byArray;
    }

    public static String createIPAddrStringFromByteArray(byte[] byArray) {
        if (byArray.length == 4) {
            return Inet6Util.addressToString(Inet6Util.bytesToInt(byArray, 0));
        }
        if (byArray.length == 16) {
            if (Inet6Util.isIPv4MappedAddress(byArray)) {
                byte[] byArray2 = new byte[4];
                int n = 0;
                while (n < 4) {
                    byArray2[n] = byArray[n + 12];
                    ++n;
                }
                return Inet6Util.addressToString(Inet6Util.bytesToInt(byArray2, 0));
            }
            StringBuffer stringBuffer = new StringBuffer();
            int n = 0;
            while (n < byArray.length) {
                int n2 = (byArray[n] & 0xF0) >>> 4;
                stringBuffer.append(hexCharacters.charAt(n2));
                n2 = byArray[n] & 0xF;
                stringBuffer.append(hexCharacters.charAt(n2));
                if (n % 2 != 0 && n + 1 < byArray.length) {
                    stringBuffer.append(":");
                }
                ++n;
            }
            return stringBuffer.toString();
        }
        return null;
    }

    public static void convertToBytes(String string, byte[] byArray, int n) {
        int n2;
        int n3 = string.length();
        int n4 = 0;
        byArray[n] = 0;
        byArray[n + 1] = 0;
        if (n3 > 3) {
            n2 = Inet6Util.getIntValue(string.charAt(n4++));
            byArray[n] = (byte)(byArray[n] | n2 << 4);
        }
        if (n3 > 2) {
            n2 = Inet6Util.getIntValue(string.charAt(n4++));
            byArray[n] = (byte)(byArray[n] | n2);
        }
        if (n3 > 1) {
            n2 = Inet6Util.getIntValue(string.charAt(n4++));
            byArray[n + 1] = (byte)(byArray[n + 1] | n2 << 4);
        }
        n2 = Inet6Util.getIntValue(string.charAt(n4));
        byArray[n + 1] = (byte)(byArray[n + 1] | n2 & 0xF);
    }

    static int getIntValue(char c2) {
        switch (c2) {
            case '0': {
                return 0;
            }
            case '1': {
                return 1;
            }
            case '2': {
                return 2;
            }
            case '3': {
                return 3;
            }
            case '4': {
                return 4;
            }
            case '5': {
                return 5;
            }
            case '6': {
                return 6;
            }
            case '7': {
                return 7;
            }
            case '8': {
                return 8;
            }
            case '9': {
                return 9;
            }
        }
        c2 = Character.toLowerCase(c2);
        switch (c2) {
            case 'a': {
                return 10;
            }
            case 'b': {
                return 11;
            }
            case 'c': {
                return 12;
            }
            case 'd': {
                return 13;
            }
            case 'e': {
                return 14;
            }
            case 'f': {
                return 15;
            }
        }
        return 0;
    }

    private static boolean isIPv4MappedAddress(byte[] byArray) {
        int n = 0;
        while (n < 10) {
            if (byArray[n] != 0) {
                return false;
            }
            ++n;
        }
        return byArray[10] == -1 && byArray[11] == -1;
    }

    public static int bytesToInt(byte[] byArray, int n) {
        int n2 = byArray[n + 3] & 0xFF | (byArray[n + 2] & 0xFF) << 8 | (byArray[n + 1] & 0xFF) << 16 | (byArray[n] & 0xFF) << 24;
        return n2;
    }

    public static String addressToString(int n) {
        return new StringBuffer(String.valueOf(n >> 24 & 0xFF)).append(".").append(n >> 16 & 0xFF).append(".").append(n >> 8 & 0xFF).append(".").append(n & 0xFF).toString();
    }

    public static boolean isValidIP6Address(String string) {
        int n = string.length();
        boolean bl = false;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        String string2 = "";
        char c2 = '\u0000';
        char c3 = '\u0000';
        int n5 = 0;
        if (n < 2) {
            return false;
        }
        int n6 = 0;
        while (n6 < n) {
            c3 = c2;
            c2 = string.charAt(n6);
            switch (c2) {
                case '[': {
                    if (n6 != 0) {
                        return false;
                    }
                    if (string.charAt(n - 1) != ']') {
                        return false;
                    }
                    n5 = 1;
                    if (n >= 4) break;
                    return false;
                }
                case ']': {
                    if (n6 != n - 1) {
                        return false;
                    }
                    if (string.charAt(0) == '[') break;
                    return false;
                }
                case '.': {
                    if (++n3 > 3) {
                        return false;
                    }
                    if (!Inet6Util.isValidIP4Word(string2)) {
                        return false;
                    }
                    if (n2 != 6 && !bl) {
                        return false;
                    }
                    if (n2 == 7 && string.charAt(0 + n5) != ':' && string.charAt(1 + n5) != ':') {
                        return false;
                    }
                    string2 = "";
                    break;
                }
                case ':': {
                    if (++n2 > 7) {
                        return false;
                    }
                    if (n3 > 0) {
                        return false;
                    }
                    if (c3 == ':') {
                        if (bl) {
                            return false;
                        }
                        bl = true;
                    }
                    string2 = "";
                    break;
                }
                case '%': {
                    if (n2 == 0) {
                        return false;
                    }
                    ++n4;
                    if (n6 + 1 >= n) {
                        return false;
                    }
                    try {
                        Integer.parseInt(string.substring(n6 + 1));
                        break;
                    }
                    catch (NumberFormatException numberFormatException) {
                        return false;
                    }
                }
                default: {
                    if (n4 == 0) {
                        if (string2.length() > 3) {
                            return false;
                        }
                        if (!Inet6Util.isValidHexChar(c2)) {
                            return false;
                        }
                    }
                    string2 = new StringBuffer(String.valueOf(string2)).append(c2).toString();
                }
            }
            ++n6;
        }
        if (n3 > 0) {
            if (n3 != 3 || !Inet6Util.isValidIP4Word(string2)) {
                return false;
            }
        } else {
            if (n2 != 7 && !bl) {
                return false;
            }
            if (n4 == 0 && string2 == "" && string.charAt(n - 1 - n5) == ':' && string.charAt(n - 2 - n5) != ':') {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidIP4Word(String string) {
        if (string.length() < 1 || string.length() > 3) {
            return false;
        }
        int n = 0;
        while (n < string.length()) {
            char c2 = string.charAt(n);
            if (c2 < '0' || c2 > '9') {
                return false;
            }
            ++n;
        }
        return Integer.parseInt(string) <= 255;
    }

    static boolean isValidHexChar(char c2) {
        return c2 >= '0' && c2 <= '9' || c2 >= 'A' && c2 <= 'F' || c2 >= 'a' && c2 <= 'f';
    }

    public static boolean isValidIPV4Address(String string) {
        int n = 0;
        int n2 = 0;
        int n3 = string.length();
        if (n3 > 15) {
            return false;
        }
        char c2 = '\u0000';
        String string2 = "";
        n2 = 0;
        while (n2 < n3) {
            c2 = string.charAt(n2);
            if (c2 == '.') {
                if (++n > 3) {
                    return false;
                }
                if (string2 == "") {
                    return false;
                }
                if (Integer.parseInt(string2) > 255) {
                    return false;
                }
                string2 = "";
            } else {
                if (!Character.isDigit(c2)) {
                    return false;
                }
                if (string2.length() > 2) {
                    return false;
                }
                string2 = new StringBuffer(String.valueOf(string2)).append(c2).toString();
            }
            ++n2;
        }
        if (string2 == "" || Integer.parseInt(string2) > 255) {
            return false;
        }
        return n == 3;
    }
}

