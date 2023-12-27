/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.sse;

import org.dsi.ifc.base.DSIBase;

public interface DSISSE
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_MICGAINLEVEL;
    public static final int ATTR_MODE;
    public static final int ATTR_MICMUTESTATE;
    public static final int RT_REQUESTSETMODE;
    public static final int RT_REQUESTSETMICGAINLEVEL;
    public static final int RT_REQUESTSETMICMUTESTATE;
    public static final int RP_RESPONSESETMODE;
    public static final int RP_RESPONSESETMICGAINLEVEL;
    public static final int RP_RESPONSESETMICMUTESTATE;
    public static final int RESPONSE_OK;
    public static final int RESPONSE_ERROR;
    public static final int MODE_HFP_OFF;
    public static final int MODE_HFP_ON;
    public static final int MODE_SDS_INTERN_ON;
    public static final int MODE_SDS_INTERN_OFF;
    public static final int MODE_SDS_EXTERN_ON;
    public static final int MODE_SDS_EXTERN_OFF;
    public static final int MODE_NONE;
    public static final int MODE_SDS_SMARTPHONE_INT_ON;
    public static final int MODE_SDS_SMARTPHONE_INT_OFF;
    public static final int MODE_TEL_SMARTPHONE_INT_ON;
    public static final int MODE_TEL_SMARTPHONE_INT_OFF;
    public static final int MICMUTESTATE_ON;
    public static final int MICMUTESTATE_OFF;

    default public void requestSetMode(int n) {
    }

    default public void requestSetMicGainLevel(int n) {
    }

    default public void requestSetMicMuteState(int n) {
    }
}

