/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.util;

import com.ibm.oti.util.Msg;
import com.ibm.oti.vm.VM;
import java.io.ByteArrayOutputStream;
import java.io.UTFDataFormatException;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.TimeZone;

public final class Util {
    private static String[] WEEKDAYS = new String[]{"", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    private static String[] MONTHS = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private static final boolean useNative = VM.useNatives();
    private static final String defaultEncoding;

    static {
        String string = System.getProperty("os.encoding");
        if (string != null) {
            try {
                "".getBytes(string);
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                string = null;
            }
        }
        defaultEncoding = string;
    }

    public static byte[] getBytes(String string) {
        if (defaultEncoding != null) {
            try {
                return string.getBytes(defaultEncoding);
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {}
        }
        return string.getBytes();
    }

    public static String toString(byte[] byArray) {
        if (defaultEncoding != null) {
            try {
                return new String(byArray, 0, byArray.length, defaultEncoding);
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {}
        }
        return new String(byArray, 0, byArray.length);
    }

    public static String toString(byte[] byArray, int n, int n2) {
        if (defaultEncoding != null) {
            try {
                return new String(byArray, n, n2, defaultEncoding);
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {}
        }
        return new String(byArray, n, n2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static long parseDate(String string) {
        int n;
        int n2 = 0;
        int n3 = string.length();
        int n4 = 0;
        int n5 = -1;
        int n6 = -1;
        int n7 = -1;
        int n8 = -1;
        int n9 = -1;
        int n10 = -1;
        StringBuffer stringBuffer = new StringBuffer();
        while (n2 <= n3) {
            char c2 = n2 < n3 ? (char)string.charAt(n2) : (char)'\r';
            ++n2;
            if (c2 >= 'a' && c2 <= 'z' || c2 >= 'A' && c2 <= 'Z') {
                n = 1;
            } else if (c2 >= '0' && c2 <= '9') {
                n = 2;
            } else {
                if (" ,-:\r\t".indexOf(c2) == -1) {
                    throw new IllegalArgumentException();
                }
                n = 0;
            }
            if (n4 == 2 && n != 2) {
                int n11 = Integer.parseInt(stringBuffer.toString());
                stringBuffer.setLength(0);
                if (n11 >= 70) {
                    if (n5 != -1 || c2 != ' ' && c2 != ',' && c2 != '\r') {
                        throw new IllegalArgumentException();
                    }
                    n5 = n11;
                } else if (c2 == ':') {
                    if (n8 == -1) {
                        n8 = n11;
                    } else {
                        if (n9 != -1) throw new IllegalArgumentException();
                        n9 = n11;
                    }
                } else if (c2 == ' ' || c2 == ',' || c2 == '-' || c2 == '\r') {
                    if (n8 != -1 && n9 == -1) {
                        n9 = n11;
                    } else if (n9 != -1 && n10 == -1) {
                        n10 = n11;
                    } else if (n7 == -1) {
                        n7 = n11;
                    } else {
                        if (n5 != -1) throw new IllegalArgumentException();
                        n5 = n11;
                    }
                } else {
                    if (n5 != -1 || n6 == -1 || n7 == -1) throw new IllegalArgumentException();
                    n5 = n11;
                }
            } else if (n4 == 1 && n != 1) {
                String string2 = stringBuffer.toString().toUpperCase();
                stringBuffer.setLength(0);
                if (string2.length() < 3) {
                    throw new IllegalArgumentException();
                }
                if (!(Util.parse(string2, WEEKDAYS) != -1 || n6 == -1 && (n6 = Util.parse(string2, MONTHS)) != -1 || string2.equals("GMT"))) {
                    throw new IllegalArgumentException();
                }
            }
            if (n == 1 || n == 2) {
                stringBuffer.append(c2);
            }
            n4 = n;
        }
        if (n5 == -1 || n6 == -1 || n7 == -1) throw new IllegalArgumentException();
        if (n8 == -1) {
            n8 = 0;
        }
        if (n9 == -1) {
            n9 = 0;
        }
        if (n10 == -1) {
            n10 = 0;
        }
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        n = calendar.get(1) - 80;
        if (n5 < 100 && (n5 += n / 100 * 100) < n) {
            n5 += 100;
        }
        calendar.set(1, n5);
        calendar.set(2, n6);
        calendar.set(5, n7);
        calendar.set(11, n8);
        calendar.set(12, n9);
        calendar.set(13, n10);
        calendar.set(14, 0);
        return calendar.getTime().getTime();
    }

    private static int parse(String string, String[] stringArray) {
        int n = string.length();
        int n2 = 0;
        while (n2 < stringArray.length) {
            if (string.regionMatches(true, 0, stringArray[n2], 0, n)) {
                return n2;
            }
            ++n2;
        }
        return -1;
    }

    private static native String convertUTF8(byte[] byArray, int n, int n2) {
    }

    public static String convertFromUTF8(byte[] byArray, int n, int n2) {
        if (useNative) {
            String string = Util.convertUTF8(byArray, n, n2);
            if (string != null) {
                return string;
            }
            throw new UTFDataFormatException();
        }
        return Util.convertUTF8WithBuf(byArray, new char[n2], n, n2);
    }

    public static String convertUTF8WithBuf(byte[] byArray, char[] cArray, int n, int n2) {
        int n3 = 0;
        int n4 = 0;
        while (n3 < n2) {
            byte by;
            if ((cArray[n4] = (char)byArray[n + n3++]) < '\u0080') {
                ++n4;
                continue;
            }
            char c2 = cArray[n4];
            if ((c2 & 0xE0) == 192) {
                if (n3 >= n2) {
                    throw new UTFDataFormatException(Msg.getString("K0062", n3));
                }
                if (((by = byArray[n3++]) & 0xC0) != 128) {
                    throw new UTFDataFormatException(Msg.getString("K0062", n3 - 1));
                }
                cArray[n4++] = (char)((c2 & 0x1F) << 6 | by & 0x3F);
                continue;
            }
            if ((c2 & 0xF0) == 224) {
                if (n3 + 1 >= n2) {
                    throw new UTFDataFormatException(Msg.getString("K0063", n3 + 1));
                }
                by = byArray[n3++];
                byte by2 = byArray[n3++];
                if ((by & 0xC0) != 128 || (by2 & 0xC0) != 128) {
                    throw new UTFDataFormatException(Msg.getString("K0064", n3 - 2));
                }
                cArray[n4++] = (char)((c2 & 0xF) << 12 | (by & 0x3F) << 6 | by2 & 0x3F);
                continue;
            }
            throw new UTFDataFormatException(Msg.getString("K0065", n3 - 1));
        }
        return new String(cArray, 0, n4);
    }

    public static boolean matchesPattern(String string, String string2) {
        if (string.indexOf(42) != -1) {
            return false;
        }
        if (string.equals(string2)) {
            return true;
        }
        int n = string2.indexOf(42);
        if (n == -1) {
            return false;
        }
        if (n > 0 && !string.regionMatches(false, 0, string2, 0, n)) {
            return false;
        }
        if (n < string2.length() - 1) {
            int n2 = string2.length() - n - 1;
            if (!string.regionMatches(false, string.length() - n2, string2, n + 1, n2)) {
                return false;
            }
        }
        return true;
    }

    public static String decode(String string, boolean bl) {
        return Util.decode(string, bl, null);
    }

    public static String decode(String string, boolean bl, String string2) {
        if (!bl && string.indexOf(37) == -1) {
            return string;
        }
        StringBuffer stringBuffer = new StringBuffer(string.length());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int n = 0;
        while (n < string.length()) {
            char c2 = string.charAt(n);
            if (bl && c2 == '+') {
                stringBuffer.append(' ');
            } else {
                if (c2 == '%') {
                    byteArrayOutputStream.reset();
                    do {
                        if (n + 2 >= string.length()) {
                            throw new IllegalArgumentException(Msg.getString("K01fe", n));
                        }
                        int n2 = Character.digit(string.charAt(n + 1), 16);
                        int n3 = Character.digit(string.charAt(n + 2), 16);
                        if (n2 == -1 || n3 == -1) {
                            throw new IllegalArgumentException(Msg.getString("K01ff", string.substring(n, n + 3), String.valueOf(n)));
                        }
                        byteArrayOutputStream.write((byte)((n2 << 4) + n3));
                    } while ((n += 3) < string.length() && string.charAt(n) == '%');
                    if (string2 != null) {
                        try {
                            stringBuffer.append(byteArrayOutputStream.toString(string2));
                            continue;
                        }
                        catch (UnsupportedEncodingException unsupportedEncodingException) {
                            throw new IllegalArgumentException(unsupportedEncodingException.getMessage());
                        }
                    }
                    stringBuffer.append(byteArrayOutputStream.toString());
                    continue;
                }
                stringBuffer.append(c2);
            }
            ++n;
        }
        return stringBuffer.toString();
    }
}

