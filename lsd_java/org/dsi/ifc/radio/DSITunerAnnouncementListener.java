/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radio;

import org.dsi.ifc.base.DSIListener;

public interface DSITunerAnnouncementListener
extends DSIListener {
    default public void updateFilter(int n, int n2) {
    }

    default public void updateAvailability(int n, int n2) {
    }

    default public void updateStatus(int n, int n2) {
    }

    default public void updateStationName(String string, int n, long l, int n2) {
    }
}

