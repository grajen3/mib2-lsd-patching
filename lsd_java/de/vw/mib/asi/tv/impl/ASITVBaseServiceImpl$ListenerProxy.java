/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.tv.impl;

import de.esolutions.fw.comm.asi.hmisync.tv.ActiveStationInfo;
import de.esolutions.fw.comm.asi.hmisync.tv.KeySet;
import de.esolutions.fw.comm.asi.hmisync.tv.ParentalSettings;
import de.esolutions.fw.comm.asi.hmisync.tv.StationInfo;
import de.esolutions.fw.comm.core.method.MethodException;
import de.vw.mib.asi.tv.ASITVListener;
import de.vw.mib.asi.tv.impl.ASITVBaseServiceImpl;

class ASITVBaseServiceImpl$ListenerProxy
implements ASITVListener {
    private final /* synthetic */ ASITVBaseServiceImpl this$0;

    ASITVBaseServiceImpl$ListenerProxy(ASITVBaseServiceImpl aSITVBaseServiceImpl) {
        this.this$0 = aSITVBaseServiceImpl;
    }

    @Override
    public void updateActiveStationInfo(ActiveStationInfo activeStationInfo, boolean bl) {
        try {
            this.this$0.updateActiveStationInfo(activeStationInfo, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateActiveTVStationState(long l, boolean bl) {
        try {
            this.this$0.updateActiveTVStationState(l, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updatePanelKeySet(KeySet[] keySetArray, boolean bl) {
        try {
            this.this$0.updatePanelKeySet(keySetArray, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateParentalSettings(ParentalSettings parentalSettings, boolean bl) {
        try {
            this.this$0.updateParentalSettings(parentalSettings, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateSeekStatus(byte by, boolean bl) {
        try {
            this.this$0.updateSeekStatus(by, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateStationInfo(StationInfo[] stationInfoArray, boolean bl) {
        try {
            this.this$0.updateStationInfo(stationInfoArray, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateTerminalMode(byte by, boolean bl) {
        try {
            this.this$0.updateTerminalMode(by, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateTunerConfig(long l, boolean bl) {
        try {
            this.this$0.updateTunerConfig(l, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }
}

