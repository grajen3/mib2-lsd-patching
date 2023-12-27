/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.net.www.protocol.jxe;

import com.ibm.oti.net.www.protocol.jxe.JxeURLConnection;
import com.ibm.oti.vm.Jxe;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

public class Handler
extends URLStreamHandler {
    Jxe jxe;

    public Handler() {
    }

    public Handler(Jxe jxe) {
        this.jxe = jxe;
    }

    @Override
    public URLConnection openConnection(URL uRL) {
        return new JxeURLConnection(uRL, this.jxe);
    }
}

