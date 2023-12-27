/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.bc;

import de.esolutions.fw.comm.asi.hmisync.car.FloatBaseType;
import de.esolutions.fw.comm.asi.hmisync.car.IntBaseType;
import de.esolutions.fw.comm.asi.hmisync.car.bc.BCTermGeneralData;

public interface ASIHMISyncCarBordComputerReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateASIVersion(String string, boolean bl) {
    }

    default public void updateRequestIDs(short[] sArray, boolean bl) {
    }

    default public void updateReplyIDs(short[] sArray, boolean bl) {
    }

    default public void updateBCShortTermAverageConsumption1Visibility(int n, boolean bl) {
    }

    default public void updateBCShortTermAverageConsumption1(FloatBaseType floatBaseType, boolean bl) {
    }

    default public void updateBCShortTermAverageConsumption2Visibility(int n, boolean bl) {
    }

    default public void updateBCShortTermAverageConsumption2(FloatBaseType floatBaseType, boolean bl) {
    }

    default public void updateBCLongTermAverageConsumption1Visibility(int n, boolean bl) {
    }

    default public void updateBCLongTermAverageConsumption1(FloatBaseType floatBaseType, boolean bl) {
    }

    default public void updateBCLongTermAverageConsumption2Visibility(int n, boolean bl) {
    }

    default public void updateBCLongTermAverageConsumption2(FloatBaseType floatBaseType, boolean bl) {
    }

    default public void updateBCCurrentRange1Visibility(int n, boolean bl) {
    }

    default public void updateBCCurrentRange1(IntBaseType intBaseType, boolean bl) {
    }

    default public void updateBCCurrentRange2Visibility(int n, boolean bl) {
    }

    default public void updateBCCurrentRange2(IntBaseType intBaseType, boolean bl) {
    }

    default public void updateBCShortTermGeneralVisibility(int n, boolean bl) {
    }

    default public void updateBCShortTermGeneral(BCTermGeneralData bCTermGeneralData, boolean bl) {
    }

    default public void updateBCLongTermGeneralVisibility(int n, boolean bl) {
    }

    default public void updateBCLongTermGeneral(BCTermGeneralData bCTermGeneralData, boolean bl) {
    }
}

