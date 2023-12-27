/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media;

import org.dsi.ifc.media.CoverartInfo;

public interface DSIMetadataServiceC {
    default public void requestCoverArt(int n, CoverartInfo coverartInfo) {
    }

    default public void disableOnlineLookup() {
    }

    default public void enableOnlineLookup() {
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

