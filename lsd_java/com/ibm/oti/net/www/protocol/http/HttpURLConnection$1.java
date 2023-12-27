/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.net.www.protocol.http;

import com.ibm.oti.net.www.protocol.http.HttpURLConnection;
import com.ibm.oti.net.www.protocol.http.HttpURLConnection$CacheEntry;
import java.net.Socket;
import java.util.Hashtable;
import java.util.TimerTask;

final class HttpURLConnection$1
extends TimerTask {
    private final /* synthetic */ String val$hostName;
    private final /* synthetic */ int val$hostPort;
    private final /* synthetic */ Socket val$socket;

    HttpURLConnection$1(String string, int n, Socket socket) {
        this.val$hostName = string;
        this.val$hostPort = n;
        this.val$socket = socket;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        boolean bl = false;
        HttpURLConnection$CacheEntry httpURLConnection$CacheEntry = null;
        String string = HttpURLConnection.access$0(this.val$hostName, this.val$hostPort);
        Hashtable hashtable = HttpURLConnection.access$1();
        synchronized (hashtable) {
            httpURLConnection$CacheEntry = (HttpURLConnection$CacheEntry)HttpURLConnection.access$1().get(string);
            if (httpURLConnection$CacheEntry != null && httpURLConnection$CacheEntry.getSocket() == this.val$socket) {
                bl = true;
                HttpURLConnection.access$1().remove(string);
            }
        }
        if (bl) {
            httpURLConnection$CacheEntry.closeSocket();
        }
    }
}

