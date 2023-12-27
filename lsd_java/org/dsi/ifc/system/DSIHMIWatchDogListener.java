/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.system;

import org.dsi.ifc.base.DSIListener;

public interface DSIHMIWatchDogListener
extends DSIListener {
    default public void triggerErrorLogDump() {
    }

    default public void updateQueryHeartbeat(int n, int n2) {
    }
}

