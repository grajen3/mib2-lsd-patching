/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.komogfxstreamsink;

import org.dsi.ifc.base.DSIBase;

public interface DSIKOMOGfxStreamSink
extends DSIBase {
    public static final String VERSION;
    public static final int RT_SETFGLAYER;
    public static final int RT_FADEIN;
    public static final int RT_FADEOUT;
    public static final int RP_SETFGLAYERRESULT;
    public static final int RP_FADEINRESULT;
    public static final int RP_FADEOUTRESULT;
    public static final int ATTR_GFXSTATE;
    public static final int ATTR_REQUESTSYNC;
    public static final int ATTR_DATARATE;
    public static final int GFXSTATE_UNAVAILABLE;
    public static final int GFXSTATE_AVAILABLE;
    public static final int FGREFPIC_EMPTY;
    public static final int FGREFPIC_KDK;
    public static final int FGREFPIC_EV;
    public static final int FGREFPIC_MAP;
    public static final int FADESPEED_BLIT;
    public static final int FADESPEED_FADE;
    public static final int SYNCREQUEST_SYNCSATISFIED;
    public static final int SYNCREQUEST_SYNCNEEDED;
    public static final int DATARATE_OFF;
    public static final int DATARATE_REDUCEDBANDWIDTH;
    public static final int DATARATE_FULL;

    default public void setFGLayer(int n) {
    }

    default public void fadeIn(int n, int n2, int n3) {
    }

    default public void fadeOut(int n) {
    }
}

