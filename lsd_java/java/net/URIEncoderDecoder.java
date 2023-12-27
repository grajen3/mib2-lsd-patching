/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import com.ibm.oti.util.Msg;
import java.io.ByteArrayOutputStream;
import java.net.URISyntaxException;

class URIEncoderDecoder {
    static final String digits;
    static final String encoding;

    URIEncoderDecoder() {
    }

    static void validate(String string, String string2) {
        int n = 0;
        while (n < string.length()) {
            char c2 = string.charAt(n);
            if (c2 == '%') {
                do {
                    if (n + 2 >= string.length()) {
                        throw new URISyntaxException(string, Msg.getString("K0313"), n);
                    }
                    int n2 = Character.digit(string.charAt(n + 1), 16);
                    int n3 = Character.digit(string.charAt(n + 2), 16);
                    if (n2 != -1 && n3 != -1) continue;
                    throw new URISyntaxException(string, Msg.getString("K0314", string.substring(n, n + 3)), n);
                } while ((n += 3) < string.length() && string.charAt(n) == '%');
                continue;
            }
            if (!(c2 >= 'a' && c2 <= 'z' || c2 >= 'A' && c2 <= 'Z' || c2 >= '0' && c2 <= '9' || string2.indexOf(c2) > -1 || c2 > '\u007f' && !Character.isSpaceChar(c2) && !Character.isISOControl(c2))) {
                throw new URISyntaxException(string, Msg.getString("K00c1"), n);
            }
            ++n;
        }
    }

    static void validateSimple(String string, String string2) {
        int n = 0;
        while (n < string.length()) {
            char c2 = string.charAt(n);
            if (!(c2 >= 'a' && c2 <= 'z' || c2 >= 'A' && c2 <= 'Z' || c2 >= '0' && c2 <= '9' || string2.indexOf(c2) > -1)) {
                throw new URISyntaxException(string, Msg.getString("K00c1"), n);
            }
            ++n;
        }
    }

    static String quoteIllegal(String string, String string2) {
        StringBuffer stringBuffer = new StringBuffer();
        int n = 0;
        while (n < string.length()) {
            char c2 = string.charAt(n);
            if (c2 >= 'a' && c2 <= 'z' || c2 >= 'A' && c2 <= 'Z' || c2 >= '0' && c2 <= '9' || string2.indexOf(c2) > -1 || c2 > '\u007f' && !Character.isSpaceChar(c2) && !Character.isISOControl(c2)) {
                stringBuffer.append(c2);
            } else {
                byte[] byArray = new String(new char[]{c2}).getBytes("UTF8");
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

    static String encodeOthers(String string) {
        StringBuffer stringBuffer = new StringBuffer();
        int n = 0;
        while (n < string.length()) {
            char c2 = string.charAt(n);
            if (c2 <= '\u007f') {
                stringBuffer.append(c2);
            } else {
                byte[] byArray = new String(new char[]{c2}).getBytes("UTF8");
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

    static String decode(String string) {
        StringBuffer stringBuffer = new StringBuffer();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int n = 0;
        while (n < string.length()) {
            char c2 = string.charAt(n);
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
                stringBuffer.append(byteArrayOutputStream.toString("UTF8"));
                continue;
            }
            stringBuffer.append(c2);
            ++n;
        }
        return stringBuffer.toString();
    }
}

