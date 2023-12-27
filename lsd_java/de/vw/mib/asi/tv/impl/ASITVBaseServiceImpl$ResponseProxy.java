/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.tv.impl;

import de.esolutions.fw.comm.asi.hmisync.tv.ASIHMISyncTVReply;
import de.vw.mib.asi.tv.ASITVResponse;

class ASITVBaseServiceImpl$ResponseProxy
implements ASITVResponse {
    private final ASIHMISyncTVReply delegate;

    static ASITVBaseServiceImpl$ResponseProxy get(ASIHMISyncTVReply aSIHMISyncTVReply) {
        return new ASITVBaseServiceImpl$ResponseProxy(aSIHMISyncTVReply);
    }

    private ASITVBaseServiceImpl$ResponseProxy(ASIHMISyncTVReply aSIHMISyncTVReply) {
        this.delegate = aSIHMISyncTVReply;
    }
}

