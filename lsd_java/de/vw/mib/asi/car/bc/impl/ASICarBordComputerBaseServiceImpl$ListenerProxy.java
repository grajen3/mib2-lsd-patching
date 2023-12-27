/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.car.bc.impl;

import de.esolutions.fw.comm.asi.hmisync.car.FloatBaseType;
import de.esolutions.fw.comm.asi.hmisync.car.IntBaseType;
import de.esolutions.fw.comm.asi.hmisync.car.bc.BCTermGeneralData;
import de.esolutions.fw.comm.core.method.MethodException;
import de.vw.mib.asi.car.bc.ASICarBordComputerListener;
import de.vw.mib.asi.car.bc.impl.ASICarBordComputerBaseServiceImpl;

class ASICarBordComputerBaseServiceImpl$ListenerProxy
implements ASICarBordComputerListener {
    private final /* synthetic */ ASICarBordComputerBaseServiceImpl this$0;

    ASICarBordComputerBaseServiceImpl$ListenerProxy(ASICarBordComputerBaseServiceImpl aSICarBordComputerBaseServiceImpl) {
        this.this$0 = aSICarBordComputerBaseServiceImpl;
    }

    @Override
    public void updateBCCurrentRange1(IntBaseType intBaseType, boolean bl) {
        try {
            this.this$0.updateBCCurrentRange1(intBaseType, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateBCCurrentRange1Visibility(int n, boolean bl) {
        try {
            this.this$0.updateBCCurrentRange1Visibility(n, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateBCCurrentRange2(IntBaseType intBaseType, boolean bl) {
        try {
            this.this$0.updateBCCurrentRange2(intBaseType, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateBCCurrentRange2Visibility(int n, boolean bl) {
        try {
            this.this$0.updateBCCurrentRange2Visibility(n, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateBCLongTermAverageConsumption1(FloatBaseType floatBaseType, boolean bl) {
        try {
            this.this$0.updateBCLongTermAverageConsumption1(floatBaseType, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateBCLongTermAverageConsumption1Visibility(int n, boolean bl) {
        try {
            this.this$0.updateBCLongTermAverageConsumption1Visibility(n, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateBCLongTermAverageConsumption2(FloatBaseType floatBaseType, boolean bl) {
        try {
            this.this$0.updateBCLongTermAverageConsumption2(floatBaseType, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateBCLongTermAverageConsumption2Visibility(int n, boolean bl) {
        try {
            this.this$0.updateBCLongTermAverageConsumption2Visibility(n, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateBCLongTermGeneral(BCTermGeneralData bCTermGeneralData, boolean bl) {
        try {
            this.this$0.updateBCLongTermGeneral(bCTermGeneralData, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateBCLongTermGeneralVisibility(int n, boolean bl) {
        try {
            this.this$0.updateBCLongTermGeneralVisibility(n, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateBCShortTermAverageConsumption1(FloatBaseType floatBaseType, boolean bl) {
        try {
            this.this$0.updateBCShortTermAverageConsumption1(floatBaseType, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateBCShortTermAverageConsumption1Visibility(int n, boolean bl) {
        try {
            this.this$0.updateBCShortTermAverageConsumption1Visibility(n, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateBCShortTermAverageConsumption2(FloatBaseType floatBaseType, boolean bl) {
        try {
            this.this$0.updateBCShortTermAverageConsumption2(floatBaseType, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateBCShortTermAverageConsumption2Visibility(int n, boolean bl) {
        try {
            this.this$0.updateBCShortTermAverageConsumption2Visibility(n, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateBCShortTermGeneral(BCTermGeneralData bCTermGeneralData, boolean bl) {
        try {
            this.this$0.updateBCShortTermGeneral(bCTermGeneralData, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateBCShortTermGeneralVisibility(int n, boolean bl) {
        try {
            this.this$0.updateBCShortTermGeneralVisibility(n, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }
}

