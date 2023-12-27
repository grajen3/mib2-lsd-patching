/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.navigation.impl;

import de.esolutions.fw.comm.asi.hmisync.navigation.ASIHMISyncNavigationReply;
import de.esolutions.fw.comm.core.method.MethodException;
import de.vw.mib.asi.navigation.ASINavigationResponse;

class ASINavigationBaseServiceImpl$ResponseProxy
implements ASINavigationResponse {
    private final ASIHMISyncNavigationReply delegate;

    static ASINavigationBaseServiceImpl$ResponseProxy get(ASIHMISyncNavigationReply aSIHMISyncNavigationReply) {
        return new ASINavigationBaseServiceImpl$ResponseProxy(aSIHMISyncNavigationReply);
    }

    private ASINavigationBaseServiceImpl$ResponseProxy(ASIHMISyncNavigationReply aSIHMISyncNavigationReply) {
        this.delegate = aSIHMISyncNavigationReply;
    }

    @Override
    public void startGuidanceToDestinationsResult(int n) {
        try {
            this.delegate.startGuidanceToDestinationsResult(n);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }
}

