/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.headunit.impl;

import de.esolutions.fw.comm.asi.hmisync.headunit.ASIHMISyncHeadUnitReply;
import de.esolutions.fw.comm.core.method.MethodException;
import de.vw.mib.asi.headunit.ASIHeadUnitResponse;

class ASIHeadUnitBaseServiceImpl$ResponseProxy
implements ASIHeadUnitResponse {
    private final ASIHMISyncHeadUnitReply delegate;

    static ASIHeadUnitBaseServiceImpl$ResponseProxy get(ASIHMISyncHeadUnitReply aSIHMISyncHeadUnitReply) {
        return new ASIHeadUnitBaseServiceImpl$ResponseProxy(aSIHMISyncHeadUnitReply);
    }

    private ASIHeadUnitBaseServiceImpl$ResponseProxy(ASIHMISyncHeadUnitReply aSIHMISyncHeadUnitReply) {
        this.delegate = aSIHMISyncHeadUnitReply;
    }

    @Override
    public void resetLanguage(int n, String string) {
        try {
            this.delegate.resetLanguage(n, string);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }
}

