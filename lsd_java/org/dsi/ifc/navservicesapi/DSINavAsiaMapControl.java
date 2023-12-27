/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navservicesapi;

import org.dsi.ifc.base.DSIBase;

public interface DSINavAsiaMapControl
extends DSIBase {
    public static final String VERSION;
    public static final int RT_SENDTORESUME;
    public static final int RT_SENDTOSUSPEND;
    public static final int RT_SETVIEWTYPE;
    public static final int RT_SETDATARATE;
    public static final int RT_SETZOOMLEVEL;
    public static final int ATTR_MAPSTATUS;
    public static final int ATTR_VIEWTYPE;
    public static final int ATTR_DATARATE;
    public static final int ATTR_ZOOMLEVEL;
    public static final int ATTR_RECOMMENDEDZOOM;
    public static final int MAPSTATUS_SUSPENDED;
    public static final int MAPSTATUS_STARTING;
    public static final int MAPSTATUS_READY;
    public static final int MAPSTATUS_RESTARING;
    public static final int MAPSTATUS_ERORR;
    public static final int VIEWTYPE_MAP;
    public static final int VIEWTYPE_KDK;
    public static final int DATARATE_REDUCED;
    public static final int DATARATE_FULL;
    public static final int DATARATE_OFF;

    default public void sendToResume() {
    }

    default public void sendToSuspend() {
    }

    default public void setViewType(int n) {
    }

    default public void setDataRate(int n) {
    }

    default public void setZoomLevel(float f2) {
    }
}

