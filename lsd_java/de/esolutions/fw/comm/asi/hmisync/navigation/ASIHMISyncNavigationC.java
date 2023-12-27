/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.navigation;

import de.esolutions.fw.comm.asi.hmisync.navigation.DestinationInfo;

public interface ASIHMISyncNavigationC {
    default public void startGuidanceToDestinations(DestinationInfo[] destinationInfoArray) {
    }

    default public void setNotification() {
    }

    default public void setNotification(long l) {
    }

    default public void setNotification(long[] lArray) {
    }

    default public void clearNotification() {
    }

    default public void clearNotification(long l) {
    }

    default public void clearNotification(long[] lArray) {
    }
}

