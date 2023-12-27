/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.generic.impl;

import de.esolutions.fw.comm.asi.hmisync.generic.ASIHMISyncGenericReply;
import de.esolutions.fw.comm.asi.hmisync.generic.GenericPacket;
import de.esolutions.fw.comm.core.method.MethodException;
import de.vw.mib.asi.generic.ASIGenericResponse;

class ASIGenericBaseServiceImpl$ResponseProxy
implements ASIGenericResponse {
    private final ASIHMISyncGenericReply delegate;

    static ASIGenericBaseServiceImpl$ResponseProxy get(ASIHMISyncGenericReply aSIHMISyncGenericReply) {
        return new ASIGenericBaseServiceImpl$ResponseProxy(aSIHMISyncGenericReply);
    }

    private ASIGenericBaseServiceImpl$ResponseProxy(ASIHMISyncGenericReply aSIHMISyncGenericReply) {
        this.delegate = aSIHMISyncGenericReply;
    }

    @Override
    public void sendDataFromUnit(GenericPacket genericPacket) {
        try {
            this.delegate.sendDataFromUnit(genericPacket);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }
}

