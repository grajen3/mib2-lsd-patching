/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.media.impl;

import de.esolutions.fw.comm.asi.hmisync.media.ASIHMISyncMediaBrowserReply;
import de.esolutions.fw.comm.asi.hmisync.media.MediaEntry;
import de.esolutions.fw.comm.core.method.MethodException;
import de.vw.mib.asi.media.ASIMediaBrowserResponse;

class ASIMediaBrowserBaseServiceImpl$ResponseProxy
implements ASIMediaBrowserResponse {
    private final ASIHMISyncMediaBrowserReply delegate;

    static ASIMediaBrowserBaseServiceImpl$ResponseProxy get(ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) {
        return new ASIMediaBrowserBaseServiceImpl$ResponseProxy(aSIHMISyncMediaBrowserReply);
    }

    private ASIMediaBrowserBaseServiceImpl$ResponseProxy(ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) {
        this.delegate = aSIHMISyncMediaBrowserReply;
    }

    @Override
    public void responseChangeFolder(boolean bl) {
        try {
            this.delegate.responseChangeFolder(bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void responseAddSelection(boolean bl) {
        try {
            this.delegate.responseAddSelection(bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void responseList(boolean bl, int n, MediaEntry[] mediaEntryArray) {
        try {
            this.delegate.responseList(bl, n, mediaEntryArray);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }
}

