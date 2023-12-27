/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.ddp20;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.ddp20.DisplayStatus;
import org.dsi.ifc.ddp20.VersionInfo;

public interface DSIDDP20Listener
extends DSIListener {
    default public void updateVersionInfo(VersionInfo versionInfo, int n) {
    }

    default public void updatePowerStatus(int n, int n2) {
    }

    default public void updateDisplayStatus(DisplayStatus displayStatus, int n) {
    }

    default public void updateBufferStatus(int n, int n2) {
    }
}

