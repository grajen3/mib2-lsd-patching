/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has.internal;

import de.vw.mib.has.HASClockConsumer;
import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASList;
import de.vw.mib.has.HASListRequest;

abstract class HASListControlImpl$Strategy
implements HASList,
HASClockConsumer {
    protected static final String LOG_PREFIX_ARRAY;
    protected static final String LOG_PREFIX_CACHE;
    static final HASContainer[] EMPTY_ARRAY;

    HASListControlImpl$Strategy() {
    }

    protected int prepareRequest(HASListRequest hASListRequest) {
        int n = this.getSize();
        int n2 = this.getPageSize();
        int n3 = Math.min(n - n2, hASListRequest.getOffset());
        n3 = Math.max(n3, 0);
        hASListRequest.setOffset(n3);
        int n4 = Math.min(n2, n - n3);
        n4 = Math.max(0, n4);
        HASContainer[] hASContainerArray = 0 >= n4 ? EMPTY_ARRAY : new HASContainer[n4];
        hASListRequest.setData(hASContainerArray);
        return n4;
    }

    protected abstract void request(HASListRequest hASListRequest) {
    }

    static {
        EMPTY_ARRAY = new HASContainer[0];
    }
}

