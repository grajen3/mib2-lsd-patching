/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.radio.impl;

import de.esolutions.fw.comm.asi.hmisync.radio.CurrentStation;
import de.esolutions.fw.comm.asi.hmisync.radio.StationInfo;
import de.esolutions.fw.comm.core.method.MethodException;
import de.vw.mib.asi.radio.ASIRadioListener;
import de.vw.mib.asi.radio.impl.ASIRadioBaseServiceImpl;

class ASIRadioBaseServiceImpl$ListenerProxy
implements ASIRadioListener {
    private final /* synthetic */ ASIRadioBaseServiceImpl this$0;

    ASIRadioBaseServiceImpl$ListenerProxy(ASIRadioBaseServiceImpl aSIRadioBaseServiceImpl) {
        this.this$0 = aSIRadioBaseServiceImpl;
    }

    @Override
    public void updateActiveBand(int n, boolean bl) {
        try {
            this.this$0.updateActiveBand(n, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateActiveStation(CurrentStation currentStation, boolean bl) {
        try {
            this.this$0.updateActiveStation(currentStation, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateBandList(int[] nArray, boolean bl) {
        try {
            this.this$0.updateBandList(nArray, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateRadioStationList(StationInfo[] stationInfoArray, boolean bl) {
        try {
            this.this$0.updateRadioStationList(stationInfoArray, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateSeekStatus(int n, boolean bl) {
        try {
            this.this$0.updateSeekStatus(n, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }
}

