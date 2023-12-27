/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.net.www.protocol.file;

import com.ibm.oti.util.Util;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilePermission;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;
import java.security.Permission;

public class FileURLConnection
extends URLConnection {
    String fileName;
    private InputStream is;
    private int length = -1;
    private boolean isDir = false;
    private FilePermission permission;
    static final String encoding;

    public FileURLConnection(URL uRL) {
        super(uRL);
        String string;
        this.fileName = uRL.getFile();
        if (this.fileName == null) {
            this.fileName = "";
        }
        if ((string = uRL.getHost()) != null && string.length() > 0) {
            this.fileName = new StringBuffer("//").append(string).append(this.fileName).toString();
        }
        this.fileName = Util.decode(this.fileName, false, "UTF8");
    }

    @Override
    public void connect() {
        File file = new File(this.fileName);
        if (file.isDirectory()) {
            this.isDir = true;
            this.is = this.getDirectoryListing(file);
        } else {
            this.is = new BufferedInputStream(new FileInputStream(file));
            this.length = this.is.available();
        }
        this.connected = true;
    }

    @Override
    public int getContentLength() {
        try {
            if (!this.connected) {
                this.connect();
            }
        }
        catch (IOException iOException) {}
        return this.length;
    }

    @Override
    public String getContentType() {
        try {
            if (!this.connected) {
                this.connect();
            }
        }
        catch (IOException iOException) {
            return "content/unknown";
        }
        if (this.isDir) {
            return "text/plain";
        }
        String string = FileURLConnection.guessContentTypeFromName(this.url.getFile());
        if (string == null) {
            return "content/unknown";
        }
        return string;
    }

    private InputStream getDirectoryListing(File file) {
        String[] stringArray = file.list();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        int n = 0;
        while (n < stringArray.length) {
            printStream.print(new StringBuffer(String.valueOf(stringArray[n])).append("\n").toString());
            ++n;
        }
        printStream.close();
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }

    @Override
    public InputStream getInputStream() {
        if (!this.connected) {
            this.connect();
        }
        return this.is;
    }

    @Override
    public Permission getPermission() {
        if (this.permission == null) {
            String string = this.fileName;
            if (File.separatorChar != '/') {
                string = string.replace('/', File.separatorChar);
            }
            this.permission = new FilePermission(string, new String("read"));
        }
        return this.permission;
    }

    @Override
    public String getHeaderField(String string) {
        if (string == null) {
            return null;
        }
        if ((string = string.toLowerCase()).equals("content-type")) {
            return this.getContentType();
        }
        return null;
    }
}

