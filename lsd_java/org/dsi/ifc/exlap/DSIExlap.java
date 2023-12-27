/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.exlap;

import org.dsi.ifc.base.DSIBase;

public interface DSIExlap
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_AVAILABLESERVICES;
    public static final int RESULTTYPE_OK;
    public static final int RESULTTYPE_ERROR;
    public static final int STATUS_AVAILABLE;
    public static final int STATUS_CAN_BE_BOUGHT;
    public static final int RT_START;
    public static final int RT_STOP;
    public static final int RP_STARTRESULT;
    public static final int RP_STOPRESULT;

    default public void start() {
    }

    default public void stop() {
    }
}

