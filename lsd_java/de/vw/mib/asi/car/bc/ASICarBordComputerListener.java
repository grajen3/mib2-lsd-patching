/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.car.bc;

import de.esolutions.fw.comm.asi.hmisync.car.FloatBaseType;
import de.esolutions.fw.comm.asi.hmisync.car.IntBaseType;
import de.esolutions.fw.comm.asi.hmisync.car.bc.BCTermGeneralData;
import de.vw.mib.asi.ASIListener;

public interface ASICarBordComputerListener
extends ASIListener {
    default public void updateBCCurrentRange1(IntBaseType intBaseType, boolean bl) {
    }

    default public void updateBCCurrentRange1Visibility(int n, boolean bl) {
    }

    default public void updateBCCurrentRange2(IntBaseType intBaseType, boolean bl) {
    }

    default public void updateBCCurrentRange2Visibility(int n, boolean bl) {
    }

    default public void updateBCLongTermAverageConsumption1(FloatBaseType floatBaseType, boolean bl) {
    }

    default public void updateBCLongTermAverageConsumption1Visibility(int n, boolean bl) {
    }

    default public void updateBCLongTermAverageConsumption2(FloatBaseType floatBaseType, boolean bl) {
    }

    default public void updateBCLongTermAverageConsumption2Visibility(int n, boolean bl) {
    }

    default public void updateBCLongTermGeneral(BCTermGeneralData bCTermGeneralData, boolean bl) {
    }

    default public void updateBCLongTermGeneralVisibility(int n, boolean bl) {
    }

    default public void updateBCShortTermAverageConsumption1(FloatBaseType floatBaseType, boolean bl) {
    }

    default public void updateBCShortTermAverageConsumption1Visibility(int n, boolean bl) {
    }

    default public void updateBCShortTermAverageConsumption2(FloatBaseType floatBaseType, boolean bl) {
    }

    default public void updateBCShortTermAverageConsumption2Visibility(int n, boolean bl) {
    }

    default public void updateBCShortTermGeneral(BCTermGeneralData bCTermGeneralData, boolean bl) {
    }

    default public void updateBCShortTermGeneralVisibility(int n, boolean bl) {
    }
}

