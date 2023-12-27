/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.car.driving.impl;

import de.esolutions.fw.comm.asi.hmisync.car.driving.TADConfiguration;
import de.esolutions.fw.comm.asi.hmisync.car.driving.TADVehicleInfo;
import de.esolutions.fw.comm.core.method.MethodException;
import de.vw.mib.asi.car.driving.ASICarDrivingListener;
import de.vw.mib.asi.car.driving.impl.ASICarDrivingBaseServiceImpl;

class ASICarDrivingBaseServiceImpl$ListenerProxy
implements ASICarDrivingListener {
    private final /* synthetic */ ASICarDrivingBaseServiceImpl this$0;

    ASICarDrivingBaseServiceImpl$ListenerProxy(ASICarDrivingBaseServiceImpl aSICarDrivingBaseServiceImpl) {
        this.this$0 = aSICarDrivingBaseServiceImpl;
    }

    @Override
    public void updateDriveSelectActiveProfile(int n, boolean bl) {
        try {
            this.this$0.updateDriveSelectActiveProfile(n, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateDriveSelectActiveProfileVisibilityState(int n, boolean bl) {
        try {
            this.this$0.updateDriveSelectActiveProfileVisibilityState(n, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateSuspensionControlCurrentLevel(int n, boolean bl) {
        try {
            this.this$0.updateSuspensionControlCurrentLevel(n, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateSuspensionControlTargetLevel(int n, boolean bl) {
        try {
            this.this$0.updateSuspensionControlTargetLevel(n, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateSuspensionVisibilityState(int[] nArray, boolean bl) {
        try {
            this.this$0.updateSuspensionVisibilityState(nArray, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateTADConfiguration(TADConfiguration tADConfiguration, boolean bl) {
        try {
            this.this$0.updateTADConfiguration(tADConfiguration, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateTADCurrentPitchAngle(float f2, boolean bl) {
        try {
            this.this$0.updateTADCurrentPitchAngle(f2, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateTADCurrentRollAngle(float f2, boolean bl) {
        try {
            this.this$0.updateTADCurrentRollAngle(f2, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateTADNegMaxPitch(float f2, boolean bl) {
        try {
            this.this$0.updateTADNegMaxPitch(f2, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateTADNegMaxRollAngle(float f2, boolean bl) {
        try {
            this.this$0.updateTADNegMaxRollAngle(f2, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateTADPosMaxPitch(float f2, boolean bl) {
        try {
            this.this$0.updateTADPosMaxPitch(f2, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateTADPosMaxRollAngle(float f2, boolean bl) {
        try {
            this.this$0.updateTADPosMaxRollAngle(f2, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateTADVehicleInfo(TADVehicleInfo tADVehicleInfo, boolean bl) {
        try {
            this.this$0.updateTADVehicleInfo(tADVehicleInfo, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateTADVisibilityState(int n, boolean bl) {
        try {
            this.this$0.updateTADVisibilityState(n, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }
}

