/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.audio.impl;

import de.esolutions.fw.comm.asi.hmisync.audio.ASIHMISyncAudioReply;
import de.esolutions.fw.comm.core.method.MethodException;
import de.vw.mib.asi.audio.ASIAudioResponse;

class ASIAudioBaseServiceImpl$ResponseProxy
implements ASIAudioResponse {
    private final ASIHMISyncAudioReply delegate;

    static ASIAudioBaseServiceImpl$ResponseProxy get(ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        return new ASIAudioBaseServiceImpl$ResponseProxy(aSIHMISyncAudioReply);
    }

    private ASIAudioBaseServiceImpl$ResponseProxy(ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        this.delegate = aSIHMISyncAudioReply;
    }

    @Override
    public void responseEnableA2LS(int n) {
        try {
            this.delegate.responseEnableA2LS(n);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }
}

