/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.komonavinfo;

public interface DSIKOMONavInfoReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void setCurrentStreetResult(int n) {
    }

    default public void setTurnToStreetResult(int n) {
    }

    default public void setCityNameResult(int n) {
    }

    default public void setSemiDynRouteResult(int n) {
    }

    default public void setTrafficOffsetResult(int n) {
    }

    default public void setRgSelectResult(int n) {
    }

    default public void setCapabilitiesResult(int n) {
    }

    default public void setMapScaleResult(int n, int n2, boolean[] blArray, int n3, int n4, boolean[] blArray2, boolean bl) {
    }

    default public void setMapScale(int n, int n2, boolean[] blArray, int n3, int n4, int n5) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

