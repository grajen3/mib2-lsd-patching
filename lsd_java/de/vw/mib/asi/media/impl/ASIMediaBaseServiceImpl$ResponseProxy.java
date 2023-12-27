/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.media.impl;

import de.esolutions.fw.comm.asi.hmisync.media.ASIHMISyncMediaReply;
import de.esolutions.fw.comm.asi.hmisync.media.MediaEntry;
import de.esolutions.fw.comm.core.method.MethodException;
import de.vw.mib.asi.media.ASIMediaResponse;

class ASIMediaBaseServiceImpl$ResponseProxy
implements ASIMediaResponse {
    private final ASIHMISyncMediaReply delegate;

    static ASIMediaBaseServiceImpl$ResponseProxy get(ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        return new ASIMediaBaseServiceImpl$ResponseProxy(aSIHMISyncMediaReply);
    }

    private ASIMediaBaseServiceImpl$ResponseProxy(ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        this.delegate = aSIHMISyncMediaReply;
    }

    @Override
    public void indicationCmdBlocked(int n) {
        try {
            this.delegate.indicationCmdBlocked(n);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void responsePlayList(boolean bl, int n, MediaEntry[] mediaEntryArray) {
        try {
            this.delegate.responsePlayList(bl, n, mediaEntryArray);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void responseSetPlaySelection(boolean bl) {
        try {
            this.delegate.responseSetPlaySelection(bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void responsePlayMoreFrom(long l, int n, int n2) {
        try {
            this.delegate.responsePlayMoreFrom(l, n, n2);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }
}

