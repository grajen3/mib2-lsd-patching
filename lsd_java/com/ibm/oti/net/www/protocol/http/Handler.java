/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.net.www.protocol.http;

import com.ibm.oti.net.www.protocol.http.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

public class Handler
extends URLStreamHandler {
    @Override
    protected URLConnection openConnection(URL uRL) {
        return new HttpURLConnection(uRL, this.getDefaultPort());
    }

    @Override
    protected int getDefaultPort() {
        return 80;
    }
}

