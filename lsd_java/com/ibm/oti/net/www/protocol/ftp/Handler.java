/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.net.www.protocol.ftp;

import com.ibm.oti.net.www.protocol.ftp.FtpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

public class Handler
extends URLStreamHandler {
    @Override
    protected URLConnection openConnection(URL uRL) {
        return new FtpURLConnection(uRL);
    }

    @Override
    protected int getDefaultPort() {
        return 21;
    }
}

