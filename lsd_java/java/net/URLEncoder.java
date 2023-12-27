/*
 * Decompiled with CFR 0.152.
 */
package java.net;

public class URLEncoder {
    static final String digits;

    private URLEncoder() {
    }

    public static String encode(String string) {
        StringBuffer stringBuffer = new StringBuffer();
        int n = 0;
        while (n < string.length()) {
            char c2 = string.charAt(n);
            if (c2 >= 'a' && c2 <= 'z' || c2 >= 'A' && c2 <= 'Z' || c2 >= '0' && c2 <= '9' || ".-*_".indexOf(c2) > -1) {
                stringBuffer.append(c2);
            } else if (c2 == ' ') {
                stringBuffer.append('+');
            } else {
                byte[] byArray = new String(new char[]{c2}).getBytes();
                int n2 = 0;
                while (n2 < byArray.length) {
                    stringBuffer.append('%');
                    stringBuffer.append("0123456789ABCDEF".charAt((byArray[n2] & 0xF0) >> 4));
                    stringBuffer.append("0123456789ABCDEF".charAt(byArray[n2] & 0xF));
                    ++n2;
                }
            }
            ++n;
        }
        return stringBuffer.toString();
    }

    public static String encode(String string, String string2) {
        if (string2 == null) {
            throw new NullPointerException();
        }
        "".getBytes(string2);
        StringBuffer stringBuffer = new StringBuffer();
        int n = -1;
        int n2 = 0;
        while (n2 < string.length()) {
            char c2 = string.charAt(n2);
            if (c2 >= 'a' && c2 <= 'z' || c2 >= 'A' && c2 <= 'Z' || c2 >= '0' && c2 <= '9' || " .-*_".indexOf(c2) > -1) {
                if (n >= 0) {
                    URLEncoder.convert(string.substring(n, n2), stringBuffer, string2);
                    n = -1;
                }
                if (c2 != ' ') {
                    stringBuffer.append(c2);
                } else {
                    stringBuffer.append('+');
                }
            } else if (n < 0) {
                n = n2;
            }
            ++n2;
        }
        if (n >= 0) {
            URLEncoder.convert(string.substring(n, string.length()), stringBuffer, string2);
        }
        return stringBuffer.toString();
    }

    private static void convert(String string, StringBuffer stringBuffer, String string2) {
        byte[] byArray = string.getBytes(string2);
        int n = 0;
        while (n < byArray.length) {
            stringBuffer.append('%');
            stringBuffer.append("0123456789ABCDEF".charAt((byArray[n] & 0xF0) >> 4));
            stringBuffer.append("0123456789ABCDEF".charAt(byArray[n] & 0xF));
            ++n;
        }
    }
}

