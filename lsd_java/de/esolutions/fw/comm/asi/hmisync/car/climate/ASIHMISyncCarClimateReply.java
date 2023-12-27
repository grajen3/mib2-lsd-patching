/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.climate;

import de.esolutions.fw.comm.asi.hmisync.car.IntBaseType;

public interface ASIHMISyncCarClimateReply {
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

    default public void updateAirconTempZone1(IntBaseType intBaseType, boolean bl) {
    }

    default public void updateAirconTempZone2(IntBaseType intBaseType, boolean bl) {
    }

    default public void updateAirconMaxAC(boolean bl, boolean bl2) {
    }
}

