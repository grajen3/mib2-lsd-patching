/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.ddp20;

import org.dsi.ifc.ddp20.DisplayStatus;
import org.dsi.ifc.ddp20.VersionInfo;

public interface DSIDDP20Reply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateVersionInfo(VersionInfo versionInfo, int n) {
    }

    default public void updatePowerStatus(int n, int n2) {
    }

    default public void updateDisplayStatus(DisplayStatus displayStatus, int n) {
    }

    default public void updateBufferStatus(int n, int n2) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

