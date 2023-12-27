/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.clientapi.list.impl;

interface FetchTimer {
    public static final long DEFAULT_FETCH_TIMEOUT;

    default public Object startFetchTimer(Object object) {
    }

    default public Object stopFetchTimer() {
    }

    default public long getFetchTimeout() {
    }

    default public void setFetchTimeout(long l) {
    }
}

