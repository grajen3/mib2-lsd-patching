/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.displaycontroller;

import org.dsi.ifc.base.DSIBase;

public interface DSIDisplayController
extends DSIBase {
    public static final String VERSION;
    public static final int RT_SETDISPLAYBRIGHTNESS;
    public static final int RT_SWITCHDISPLAYPOWER;
    public static final int RT_GETDISPLAYBRIGHTNESS;
    public static final int RP_GETDISPLAYBRIGHTNESS;

    default public void switchDisplayPower(int n, int n2, int n3) {
    }

    default public void setDisplayBrightness(int n, int n2) {
    }

    default public void getDisplayBrightness(int n) {
    }
}

