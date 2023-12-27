/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.util;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class StringDataHelper {
    public static String encode(String[] stringArray, String[] stringArray2) {
        StringBuffer stringBuffer = new StringBuffer("?");
        if (stringArray.length != stringArray2.length) {
            return "";
        }
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            try {
                String string = URLEncoder.encode(stringArray[i2], "UTF-8");
                String string2 = URLEncoder.encode(stringArray2[i2], "UTF-8");
                stringBuffer.append(string).append("=").append(string2).append("&");
                continue;
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                // empty catch block
            }
        }
        return stringBuffer.toString();
    }

    public static Object getValue(String string, String string2) {
        String string3;
        if (string == null || string.length() == 0) {
            return "";
        }
        int n = string.indexOf(63);
        if (n == -1 || n + 1 == string.length()) {
            return "";
        }
        String string4 = string.substring(n + 1);
        if ((n = string4.indexOf(string3 = string2.concat("="))) == -1) {
            return "";
        }
        if ((n += string3.length()) > string4.length()) {
            return "";
        }
        String string5 = string4.substring(n);
        n = string5.indexOf(38);
        try {
            string5 = URLDecoder.decode(n >= 0 ? string5.substring(0, n) : string5, "UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            // empty catch block
        }
        return string5;
    }

    public static Map decode(String string) {
        HashMap hashMap = new HashMap();
        String string2 = null;
        try {
            string2 = new URL(string).getQuery();
        }
        catch (MalformedURLException malformedURLException) {
            return hashMap;
        }
        if (string2 == null || string2.length() == 0) {
            return hashMap;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(string2, "&");
        while (stringTokenizer.hasMoreTokens()) {
            String string3 = stringTokenizer.nextToken();
            StringTokenizer stringTokenizer2 = new StringTokenizer(string3, "=");
            try {
                String string4 = URLDecoder.decode(stringTokenizer2.nextToken(), "UTF-8");
                String string5 = URLDecoder.decode(stringTokenizer2.nextToken(), "UTF-8");
                hashMap.put(string4, string5);
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {}
        }
        return hashMap;
    }
}

