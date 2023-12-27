/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.j9.ssl;

import com.ibm.j9.ssl.SessionState;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

public class J9SSLSessionContext {
    private Hashtable sessionTable = new Hashtable(1);
    private static final int NO_TIMEOUT;
    private int timeOutSeconds = 300;
    private static final int NO_LIMIT;
    private int maxCacheSize = 0;
    private static final int MS_IN_SECOND;
    private static final int INIT_TABLE_SIZE;

    public synchronized void addSession(SessionState sessionState) {
        this.purgeExpiredSessions();
        if (this.maxCacheSize != 0 && this.sessionTable.size() >= this.maxCacheSize) {
            throw new IllegalStateException("session cache is full");
        }
        if (sessionState != null && sessionState.getSessionID() != null) {
            this.sessionTable.put(sessionState.getSessionID(), sessionState);
        }
    }

    public synchronized void removeSession(SessionState sessionState) {
        this.sessionTable.remove(sessionState.getSessionID());
    }

    public synchronized SessionState getSession(byte[] byArray) {
        this.purgeExpiredSessions();
        return (SessionState)this.sessionTable.get(byArray);
    }

    public synchronized SessionState getSession(String string) {
        this.purgeExpiredSessions();
        Enumeration enumeration = this.sessionTable.elements();
        while (enumeration.hasMoreElements()) {
            SessionState sessionState = (SessionState)enumeration.nextElement();
            if (!sessionState.getHostName().equals(string)) continue;
            return sessionState;
        }
        return null;
    }

    public synchronized Enumeration getIDs() {
        return this.sessionTable.keys();
    }

    public synchronized int getSessionCacheSize() {
        return this.maxCacheSize;
    }

    public synchronized void setSessionCacheSize(int n) {
        if (this.maxCacheSize < 0) {
            throw new IllegalArgumentException("cache size cannot be < 0");
        }
        this.maxCacheSize = n;
    }

    public synchronized int getSessionTimeoutSeconds() {
        return this.timeOutSeconds;
    }

    public synchronized void setSessionTimeoutSeconds(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("timeout must not be < 0");
        }
        this.timeOutSeconds = n;
        this.purgeExpiredSessions();
    }

    private void purgeExpiredSessions() {
        if (this.timeOutSeconds == 0) {
            return;
        }
        long l = System.currentTimeMillis();
        long l2 = this.timeOutSeconds * 1000;
        Collection collection = this.sessionTable.values();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            SessionState sessionState = (SessionState)iterator.next();
            long l3 = sessionState.getCreationTime() + l2;
            if (l > l3) {
                sessionState.invalidate();
            }
            if (sessionState.isValid()) continue;
            iterator.remove();
        }
    }
}

