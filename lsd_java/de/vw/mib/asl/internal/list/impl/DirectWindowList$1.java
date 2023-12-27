/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list.impl;

import de.vw.mib.asl.internal.list.impl.AbstractASLList$FetchTimeoutHandler;
import de.vw.mib.asl.internal.list.impl.DirectWindowList;

class DirectWindowList$1
implements AbstractASLList$FetchTimeoutHandler {
    private final /* synthetic */ DirectWindowList this$0;

    DirectWindowList$1(DirectWindowList directWindowList) {
        this.this$0 = directWindowList;
    }

    @Override
    public void fetchTimedOut(Object object) {
        this.this$0.fetchTimedOut(object);
    }
}

