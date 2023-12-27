/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import com.ibm.oti.util.Msg;
import com.ibm.oti.util.Util;
import java.io.ByteArrayOutputStream;

public class URLDecoder {
    public static String decode(String string) {
        return Util.decode(string, true);
    }

    public static String decode(String string, String string2) {
        if (string2 == null) {
            throw new NullPointerException();
        }
        StringBuffer stringBuffer = new StringBuffer(string.length());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int n = 0;
        while (n < string.length()) {
            char c2 = string.charAt(n);
            if (c2 == '+') {
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
                    stringBuffer.append(byteArrayOutputStream.toString(string2));
                    continue;
                }
                stringBuffer.append(c2);
            }
            ++n;
        }
        return stringBuffer.toString();
    }
}

