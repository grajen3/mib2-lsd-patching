/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.vm;

import com.ibm.oti.vm.VM;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Properties;

public final class MsgHelp {
    public static String format(String string, Object[] objectArray) {
        StringBuffer stringBuffer = new StringBuffer(string.length() + objectArray.length * 20);
        String[] stringArray = new String[objectArray.length];
        int n = 0;
        while (n < objectArray.length) {
            stringArray[n] = objectArray[n] == null ? "<null>" : objectArray[n].toString();
            ++n;
        }
        n = 0;
        int n2 = string.indexOf(123, 0);
        while (n2 >= 0) {
            if (n2 != 0 && string.charAt(n2 - 1) == '\\') {
                if (n2 != 1) {
                    stringBuffer.append(string.substring(n, n2 - 1));
                }
                stringBuffer.append('{');
                n = n2 + 1;
            } else if (n2 > string.length() - 3) {
                stringBuffer.append(string.substring(n, string.length()));
                n = string.length();
            } else {
                byte by = (byte)Character.digit(string.charAt(n2 + 1), 10);
                if (by < 0 || string.charAt(n2 + 2) != '}') {
                    stringBuffer.append(string.substring(n, n2 + 1));
                    n = n2 + 1;
                } else {
                    stringBuffer.append(string.substring(n, n2));
                    if (by >= stringArray.length) {
                        stringBuffer.append("<missing argument>");
                    } else {
                        stringBuffer.append(stringArray[by]);
                    }
                    n = n2 + 3;
                }
            }
            n2 = string.indexOf(123, n);
        }
        if (n < string.length()) {
            stringBuffer.append(string.substring(n, string.length()));
        }
        return stringBuffer.toString();
    }

    public static Hashtable loadMessages(String string) {
        String string2;
        String string3;
        InputStream inputStream = null;
        Properties properties = new Properties();
        Locale locale = Locale.getDefault();
        String string4 = locale.getLanguage();
        if (string4.length() == 0) {
            string4 = "en";
        }
        if ((string3 = locale.getCountry()).length() == 0) {
            string3 = "US";
        }
        String string5 = locale.getVariant();
        ClassLoader classLoader = VM.getStackClassLoader(1);
        if (string5.length() > 0 && (inputStream = classLoader.getResourceAsStream(string2 = new StringBuffer(String.valueOf(string)).append("_").append(string4).append("_").append(string3).append("_").append(string5).append(".properties").toString())) != null) {
            properties.load(inputStream);
            return properties;
        }
        string2 = new StringBuffer(String.valueOf(string)).append("_").append(string4).append("_").append(string3).append(".properties").toString();
        inputStream = classLoader.getResourceAsStream(string2);
        if (inputStream != null) {
            properties.load(inputStream);
            return properties;
        }
        string2 = new StringBuffer(String.valueOf(string)).append("_").append(string4).append(".properties").toString();
        inputStream = classLoader.getResourceAsStream(string2);
        if (inputStream != null) {
            properties.load(inputStream);
            return properties;
        }
        inputStream = classLoader.getResourceAsStream(new StringBuffer(String.valueOf(string)).append(".properties").toString());
        if (inputStream != null) {
            properties.load(inputStream);
            return properties;
        }
        return null;
    }
}

