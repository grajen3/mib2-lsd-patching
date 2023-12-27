/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.net.www.protocol.file;

import com.ibm.oti.net.www.protocol.file.FileURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

public class Handler
extends URLStreamHandler {
    @Override
    public URLConnection openConnection(URL uRL) {
        return new FileURLConnection(uRL);
    }

    @Override
    protected void parseURL(URL uRL, String string, int n, int n2) {
        if (n2 < n) {
            return;
        }
        String string2 = "";
        if (n < n2) {
            string2 = string.substring(n, n2).replace('\\', '/');
        }
        super.parseURL(uRL, string2, 0, string2.length());
    }

    private static String canonize(String string) {
        int n = 0;
        String string2 = string;
        if (string2.startsWith("./") && string2.length() > 2) {
            string2 = string2.substring(2);
        }
        if (string2.endsWith("/.")) {
            string2 = string2.substring(0, string2.length() - 2);
        }
        while ((n = string2.indexOf("/./", n)) >= 0) {
            string2 = new StringBuffer(String.valueOf(string2.substring(0, n))).append(string2.substring(n + 2)).toString();
        }
        n = 0;
        while ((n = string2.indexOf("/..", n)) >= 0 && (n + 3 == string2.length() || string2.charAt(n + 3) == '/')) {
            if (n == 0) {
                string2 = string2.substring(n + 3);
                continue;
            }
            int n2 = string2.lastIndexOf(47, n - 1);
            string2 = n + 4 > string2.length() ? string2.substring(0, n2 + 1) : new StringBuffer(String.valueOf(string2.substring(0, n2 + 1))).append(string2.substring(n + 4)).toString();
        }
        if (string2.length() == 0 && string.length() > 0) {
            string2 = string.charAt(0) == '/' ? "/" : ".";
        }
        return string2;
    }
}

