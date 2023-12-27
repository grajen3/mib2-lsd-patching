/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.mastercontrol.impl;

import de.esolutions.fw.comm.asi.hmisync.mastercontrol.ASIHMISyncMasterControlReply;
import de.esolutions.fw.comm.core.method.MethodException;
import de.vw.mib.asi.mastercontrol.ASIMasterControlResponse;

class ASIMasterControlBaseServiceImpl$ResponseProxy
implements ASIMasterControlResponse {
    private final ASIHMISyncMasterControlReply delegate;

    static ASIMasterControlBaseServiceImpl$ResponseProxy get(ASIHMISyncMasterControlReply aSIHMISyncMasterControlReply) {
        return new ASIMasterControlBaseServiceImpl$ResponseProxy(aSIHMISyncMasterControlReply);
    }

    private ASIMasterControlBaseServiceImpl$ResponseProxy(ASIHMISyncMasterControlReply aSIHMISyncMasterControlReply) {
        this.delegate = aSIHMISyncMasterControlReply;
    }

    @Override
    public void factoryReset() {
        try {
            this.delegate.factoryReset();
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void enterAppContext(int n, String string) {
        try {
            this.delegate.enterAppContext(n, string);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }
}

