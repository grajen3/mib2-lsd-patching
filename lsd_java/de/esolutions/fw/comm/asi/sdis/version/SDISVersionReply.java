/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.sdis.version;

public interface SDISVersionReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateASIVersion(String string, boolean bl) {
    }

    default public void updateSDISInterfaceVersion(String string, boolean bl) {
    }

    default public void updateMMXSWVersion(String string, boolean bl) {
    }

    default public void updateMMXSKUVersion(String string, boolean bl) {
    }

    default public void updateMUDetailedVersion(String string, boolean bl) {
    }
}

