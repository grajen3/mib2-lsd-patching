/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.predictivenavigation;

import org.dsi.ifc.global.NavLocation;

public interface DSIPredictiveNavigationC {
    default public void setOperationMode(int n) {
    }

    default public void setMaxPredictions(int n) {
    }

    default public void clearCache() {
    }

    default public void clearCacheByDestination(NavLocation navLocation, int n) {
    }

    default public void clearCacheByAge(long l) {
    }

    default public void setNotification(int[] nArray) {
    }

    default public void setNotification(int n) {
    }

    default public void setNotification() {
    }

    default public void clearNotification(int[] nArray) {
    }

    default public void clearNotification(int n) {
    }

    default public void clearNotification() {
    }

    default public void yySet(String string, String string2) {
    }
}

