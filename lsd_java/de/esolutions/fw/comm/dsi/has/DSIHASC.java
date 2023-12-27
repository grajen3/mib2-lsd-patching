/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.has;

import org.dsi.ifc.has.HASDataContainer;

public interface DSIHASC {
    default public void hmiReady() {
    }

    default public void actionResult(int n, int n2, HASDataContainer[] hASDataContainerArray, int n3) {
    }

    default public void propertyUpdate(int n, HASDataContainer[] hASDataContainerArray, int n2) {
    }

    default public void subscribeResult(int n, int n2) {
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

