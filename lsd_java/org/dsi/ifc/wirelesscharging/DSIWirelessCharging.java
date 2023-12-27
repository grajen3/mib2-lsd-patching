/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.wirelesscharging;

import org.dsi.ifc.base.DSIBase;

public interface DSIWirelessCharging
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_CHARGINGINFO;
    public static final int ATTR_BATTERYLEVEL;
    public static final int RT_SETWLCSTATE;
    public static final int CHARGINGINFO_OFF;
    public static final int CHARGINGINFO_EMPTY;
    public static final int CHARGINGINFO_NONWLC;
    public static final int CHARGINGINFO_WLCFOD;
    public static final int CHARGINGINFO_WLCHARGE;
    public static final int CHARGINGINFO_WLCFULL;
    public static final int CHARGERSTATE_OFF;
    public static final int CHARGERSTATE_ON;

    default public void setWLCState(int n) {
    }
}

