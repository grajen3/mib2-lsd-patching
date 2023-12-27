/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list.impl;

import de.vw.mib.asl.internal.list.impl.AbstractASLList$FetchTimeoutHandler;

interface AbstractASLList$FetchTimer {
    public static final long DEFAULT_FETCH_TIMEOUT;

    default public Object startFetchTimer(Object object) {
    }

    default public Object stopFetchTimer() {
    }

    default public long getFetchTimeout() {
    }

    default public void setFetchTimeout(long l) {
    }

    default public void setFetchTimeoutHandler(AbstractASLList$FetchTimeoutHandler abstractASLList$FetchTimeoutHandler) {
    }
}

