/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.car.service.impl;

import de.esolutions.fw.comm.asi.hmisync.car.FloatBaseType;
import de.esolutions.fw.comm.asi.hmisync.car.service.AdBlueInfo;
import de.esolutions.fw.comm.asi.hmisync.car.service.OilLevelData;
import de.esolutions.fw.comm.asi.hmisync.car.service.SIAOilInspection;
import de.esolutions.fw.comm.asi.hmisync.car.service.SIAServiceData;
import de.esolutions.fw.comm.asi.hmisync.car.service.TireDisplayData;
import de.esolutions.fw.comm.core.method.MethodException;
import de.vw.mib.asi.car.service.ASICarServiceListener;
import de.vw.mib.asi.car.service.impl.ASICarServiceBaseServiceImpl;

class ASICarServiceBaseServiceImpl$ListenerProxy
implements ASICarServiceListener {
    private final /* synthetic */ ASICarServiceBaseServiceImpl this$0;

    ASICarServiceBaseServiceImpl$ListenerProxy(ASICarServiceBaseServiceImpl aSICarServiceBaseServiceImpl) {
        this.this$0 = aSICarServiceBaseServiceImpl;
    }

    @Override
    public void updateAdBlueInfo(AdBlueInfo adBlueInfo, boolean bl) {
        try {
            this.this$0.updateAdBlueInfo(adBlueInfo, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateAdBlueInfoVisibilityState(int n, boolean bl) {
        try {
            this.this$0.updateAdBlueInfoVisibilityState(n, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateKeyData(int[] nArray, boolean bl) {
        try {
            this.this$0.updateKeyData(nArray, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateKeyDataVisibilityState(int n, boolean bl) {
        try {
            this.this$0.updateKeyDataVisibilityState(n, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateOilLevelData(OilLevelData oilLevelData, boolean bl) {
        try {
            this.this$0.updateOilLevelData(oilLevelData, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateOilLevelDataVisibilityState(int n, boolean bl) {
        try {
            this.this$0.updateOilLevelDataVisibilityState(n, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateSIAOilInspection(SIAOilInspection sIAOilInspection, boolean bl) {
        try {
            this.this$0.updateSIAOilInspection(sIAOilInspection, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateSIAOilInspectionVisibilityState(int[] nArray, boolean bl) {
        try {
            this.this$0.updateSIAOilInspectionVisibilityState(nArray, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateSIAServiceData(SIAServiceData sIAServiceData, boolean bl) {
        try {
            this.this$0.updateSIAServiceData(sIAServiceData, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateSIAServiceDataVisibilityState(int n, boolean bl) {
        try {
            this.this$0.updateSIAServiceDataVisibilityState(n, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateTireDisplayData(TireDisplayData tireDisplayData, boolean bl) {
        try {
            this.this$0.updateTireDisplayData(tireDisplayData, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateTireDisplayDataVisibilityState(int n, boolean bl) {
        try {
            this.this$0.updateTireDisplayDataVisibilityState(n, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateTireSystem(int n, boolean bl) {
        try {
            this.this$0.updateTireSystem(n, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateVehicleSpeed(FloatBaseType floatBaseType, boolean bl) {
        try {
            this.this$0.updateVehicleSpeed(floatBaseType, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateVehicleSpeedVisibility(int n, boolean bl) {
        try {
            this.this$0.updateVehicleSpeedVisibility(n, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateVinData(String string, boolean bl) {
        try {
            this.this$0.updateVinData(string, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateVinDataVisibilityState(int n, boolean bl) {
        try {
            this.this$0.updateVinDataVisibilityState(n, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }
}

