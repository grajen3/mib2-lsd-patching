/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.net.www.protocol.jxe;

import com.ibm.oti.util.Msg;
import com.ibm.oti.vm.Jxe;
import com.ibm.oti.vm.JxePermission;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.security.Permission;

public class JxeURLConnection
extends URLConnection {
    private InputStream is;
    private int length = -1;
    private boolean isDir = false;
    private Jxe jxe;

    public JxeURLConnection(URL uRL, Jxe jxe) {
        super(uRL);
        this.jxe = jxe;
    }

    @Override
    public void connect() {
        if (this.jxe == null) {
            throw new IOException(Msg.getString("K01a8"));
        }
        String string = this.getURL().getFile();
        if (string.startsWith("/")) {
            string = string.substring(1);
        }
        this.is = this.jxe.getResourceAsStream(string);
        if (this.is == null) {
            throw new FileNotFoundException(string);
        }
        this.length = this.is.available();
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
            return "text/html";
        }
        String string = JxeURLConnection.guessContentTypeFromName(this.url.getFile());
        if (string == null) {
            return "content/unknown";
        }
        return string;
    }

    @Override
    public boolean getDoOutput() {
        return false;
    }

    @Override
    public InputStream getInputStream() {
        if (!this.connected) {
            this.connect();
        }
        return this.is;
    }

    public Jxe getJxe() {
        return this.jxe;
    }

    @Override
    public Permission getPermission() {
        return new JxePermission(this.getURL().getHost());
    }
}

