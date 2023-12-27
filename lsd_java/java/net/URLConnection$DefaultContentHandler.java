/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import java.net.ContentHandler;
import java.net.URLConnection;

class URLConnection$DefaultContentHandler
extends ContentHandler {
    final /* synthetic */ URLConnection this$0;

    URLConnection$DefaultContentHandler(URLConnection uRLConnection) {
        this.this$0 = uRLConnection;
    }

    @Override
    public Object getContent(URLConnection uRLConnection) {
        return uRLConnection.getInputStream();
    }
}

