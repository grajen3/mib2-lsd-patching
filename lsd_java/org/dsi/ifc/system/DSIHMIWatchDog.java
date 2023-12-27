/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.system;

import org.dsi.ifc.base.DSIBase;

public interface DSIHMIWatchDog
extends DSIBase {
    public static final String VERSION;
    public static final int RT_ERRORLOGDUMPRESULT;
    public static final int RT_HEARTBEAT;
    public static final int RT_HMIREADY;
    public static final int ATTR_QUERYHEARTBEAT;
    public static final int IN_TRIGGERERRORLOGDUMP;
    public static final int RESULTCODE_OK;
    public static final int RESULTCODE_FAIL;

    default public void heartbeat(int n) {
    }

    default public void errorlogDumpResult(int n) {
    }

    default public void hmiReady() {
    }
}

