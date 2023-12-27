/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.radio.impl;

import de.esolutions.fw.comm.asi.hmisync.radio.ASIHMISyncRadioReply;
import de.esolutions.fw.comm.asi.hmisync.radio.CurrentStation;
import de.esolutions.fw.comm.core.method.MethodException;
import de.vw.mib.asi.radio.ASIRadioResponse;

class ASIRadioBaseServiceImpl$ResponseProxy
implements ASIRadioResponse {
    private final ASIHMISyncRadioReply delegate;

    static ASIRadioBaseServiceImpl$ResponseProxy get(ASIHMISyncRadioReply aSIHMISyncRadioReply) {
        return new ASIRadioBaseServiceImpl$ResponseProxy(aSIHMISyncRadioReply);
    }

    private ASIRadioBaseServiceImpl$ResponseProxy(ASIHMISyncRadioReply aSIHMISyncRadioReply) {
        this.delegate = aSIHMISyncRadioReply;
    }

    @Override
    public void stationDetailsUpdated(CurrentStation[] currentStationArray) {
        try {
            this.delegate.stationDetailsUpdated(currentStationArray);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }
}

