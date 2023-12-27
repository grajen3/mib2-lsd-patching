/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.car.climate.impl;

import de.esolutions.fw.comm.asi.hmisync.car.IntBaseType;
import de.esolutions.fw.comm.core.method.MethodException;
import de.vw.mib.asi.car.climate.ASICarClimateListener;
import de.vw.mib.asi.car.climate.impl.ASICarClimateBaseServiceImpl;

class ASICarClimateBaseServiceImpl$ListenerProxy
implements ASICarClimateListener {
    private final /* synthetic */ ASICarClimateBaseServiceImpl this$0;

    ASICarClimateBaseServiceImpl$ListenerProxy(ASICarClimateBaseServiceImpl aSICarClimateBaseServiceImpl) {
        this.this$0 = aSICarClimateBaseServiceImpl;
    }

    @Override
    public void updateAirconMaxAC(boolean bl, boolean bl2) {
        try {
            this.this$0.updateAirconMaxAC(bl, bl2);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateAirconTempZone1(IntBaseType intBaseType, boolean bl) {
        try {
            this.this$0.updateAirconTempZone1(intBaseType, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateAirconTempZone2(IntBaseType intBaseType, boolean bl) {
        try {
            this.this$0.updateAirconTempZone2(intBaseType, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }
}

