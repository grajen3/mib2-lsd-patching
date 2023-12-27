/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.zeroemission;

import de.esolutions.fw.comm.asi.hmisync.car.zeroemission.ZeroEmissionEntry;

public interface ASIHMISyncCarZeroEmissionReply {
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

    default public void updateZEVisibilityState(int n, boolean bl) {
    }

    default public void updateZeroEmissionValues(ZeroEmissionEntry[] zeroEmissionEntryArray, boolean bl) {
    }

    default public void updateCurrentZeroEmissionValue(ZeroEmissionEntry zeroEmissionEntry, boolean bl) {
    }
}

