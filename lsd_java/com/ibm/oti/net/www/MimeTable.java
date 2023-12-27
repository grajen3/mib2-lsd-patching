/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.net.www;

import com.ibm.oti.net.www.MimeTable$1;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.FileNameMap;
import java.security.AccessController;
import java.util.Properties;

public class MimeTable
implements FileNameMap {
    public static final String UNKNOWN;
    public static final Properties types;

    static {
        types = new Properties();
    }

    public MimeTable() {
        InputStream inputStream = (InputStream)AccessController.doPrivileged(new MimeTable$1(this));
        if (inputStream != null) {
            try {
                try {
                    types.load(inputStream);
                }
                finally {
                    inputStream.close();
                }
            }
            catch (IOException iOException) {}
        }
    }

    private InputStream getContentTypes() {
        String string = System.getProperty("content.types.user.table");
        if (string != null) {
            try {
                return new FileInputStream(string);
            }
            catch (IOException iOException) {}
        }
        String string2 = System.getProperty("java.home");
        File file = new File(string2, "lib/content-types.properties");
        try {
            return new FileInputStream(file);
        }
        catch (IOException iOException) {
            return null;
        }
    }

    @Override
    public String getContentTypeFor(String string) {
        if (string.endsWith("/")) {
            return (String)types.get("html");
        }
        int n = string.lastIndexOf(35);
        if (n < 0) {
            n = string.length();
        }
        int n2 = string.lastIndexOf(46) + 1;
        String string2 = "";
        if (n2 > string.lastIndexOf(47)) {
            string2 = string.substring(n2, n);
        }
        return (String)types.get(string2.toLowerCase());
    }

    static /* synthetic */ InputStream access$0(MimeTable mimeTable) {
        return mimeTable.getContentTypes();
    }
}

