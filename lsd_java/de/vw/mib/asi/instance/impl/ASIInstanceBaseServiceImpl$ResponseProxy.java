/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.instance.impl;

import de.esolutions.fw.comm.asi.hmisync.instance.ASIHMISyncInstanceReply;
import de.esolutions.fw.comm.core.method.MethodException;
import de.vw.mib.asi.instance.ASIInstanceResponse;

class ASIInstanceBaseServiceImpl$ResponseProxy
implements ASIInstanceResponse {
    private final ASIHMISyncInstanceReply delegate;

    static ASIInstanceBaseServiceImpl$ResponseProxy get(ASIHMISyncInstanceReply aSIHMISyncInstanceReply) {
        return new ASIInstanceBaseServiceImpl$ResponseProxy(aSIHMISyncInstanceReply);
    }

    private ASIInstanceBaseServiceImpl$ResponseProxy(ASIHMISyncInstanceReply aSIHMISyncInstanceReply) {
        this.delegate = aSIHMISyncInstanceReply;
    }

    @Override
    public void responseInstanceId(String string, String string2, int n, int n2) {
        try {
            this.delegate.responseInstanceId(string, string2, n, n2);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }
}

