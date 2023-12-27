/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.organizer;

import org.dsi.ifc.global.ResourceLocator;

public interface DSIAdbVCardExchangeC {
    default public void importVCard(ResourceLocator[] resourceLocatorArray, int n) {
    }

    default public void exportVCard(int n, String string, long[] lArray, int n2) {
    }

    default public void exportSpellerVCard(int n, int n2, String string, long[] lArray, int n3) {
    }

    default public void createVCard(int n, long[] lArray, int n2) {
    }

    default public void parseVCard(String string) {
    }

    default public void requestAbort(int n) {
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

