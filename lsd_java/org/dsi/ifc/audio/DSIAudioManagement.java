/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.audio;

import org.dsi.ifc.base.DSIBase;

public interface DSIAudioManagement
extends DSIBase {
    public static final String VERSION;
    public static final int RT_FADETOCONNECTION;
    public static final int RT_RELEASECONNECTION;
    public static final int RT_GETACTIVECONNECTION;
    public static final int RT_GETACTIVEENTERTAINMENTCONNECTION;
    public static final int RT_REQUESTCONNECTION;
    public static final int RT_SETVOLUMELOCK;
    public static final int RT_GETVOLUMELOCK;
    public static final int ATTR_AMAVAILABLE;
    public static final int ATTR_ACTIVECONNECTION;
    public static final int ATTR_ACTIVEENTERTAINMENTCONNECTION;
    public static final int RP_ERRORCONNECTION;
    public static final int RP_FADEDIN;
    public static final int RP_PAUSECONNECTION;
    public static final int RP_STARTCONNECTION;
    public static final int RP_STOPCONNECTION;
    public static final int RP_RESPONSEVOLUMELOCK;

    default public void fadeToConnection(int n, int n2) {
    }

    default public void releaseConnection(int n, int n2) {
    }

    default public void getActiveConnection(int n) {
    }

    default public void getActiveEntertainmentConnection(int n) {
    }

    default public void requestConnection(int n, int n2, int n3) {
    }

    default public void setVolumelock(int n, int n2, boolean bl) {
    }

    default public void getVolumelock(int n, int n2) {
    }
}

