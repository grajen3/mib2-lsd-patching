/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.predictivenavigation;

import org.dsi.ifc.predictivenavigation.LikelyDestination;

public interface DSIPredictiveNavigationReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateOperationMode(int n, int n2) {
    }

    default public void updateLikelyDestinations(LikelyDestination[] likelyDestinationArray, int n) {
    }

    default public void updateMaxPredictions(int n, int n2) {
    }

    default public void clearCacheResult() {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

