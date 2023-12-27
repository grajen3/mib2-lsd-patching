/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.net.www.protocol.http;

import java.io.IOException;
import java.net.Socket;
import java.util.TimerTask;

class HttpURLConnection$CacheEntry {
    private Socket socket;
    private TimerTask timerTask;

    public HttpURLConnection$CacheEntry(Socket socket, TimerTask timerTask) {
        this.socket = socket;
        this.timerTask = timerTask;
    }

    public Socket getSocket() {
        return this.socket;
    }

    public void closeSocket() {
        try {
            this.socket.close();
        }
        catch (IOException iOException) {}
        this.timerTask.cancel();
    }

    public void cancelTimerTask() {
        this.timerTask.cancel();
    }
}

