/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.mastercontrol;

public interface ASIHMISyncMasterControlReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void factoryReset() {
    }

    default public void enterAppContext(int n, String string) {
    }

    default public void updateASIVersion(String string, boolean bl) {
    }

    default public void updateRequestIDs(short[] sArray, boolean bl) {
    }

    default public void updateReplyIDs(short[] sArray, boolean bl) {
    }

    default public void updateHUVersion(String string, boolean bl) {
    }

    default public void updateVIN(String string, boolean bl) {
    }

    default public void updateLockState(int n, boolean bl) {
    }

    default public void updateBlockState(int n, boolean bl) {
    }
}

