/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.dsi.ext.api.navigation;

import org.dsi.ifc.global.NavLocation;

public final class LiCurrentState {
    private final NavLocation liCurrentLD;
    private final int[] availableSelectionCriteria;
    private final int[] usefulRefinementCriteria;
    private final long returnCode;

    public LiCurrentState(Object[] objectArray) {
        this.liCurrentLD = (NavLocation)objectArray[0];
        this.availableSelectionCriteria = (int[])objectArray[1];
        this.usefulRefinementCriteria = (int[])objectArray[2];
        this.returnCode = (Long)objectArray[3];
    }

    public NavLocation getLiCurrentLD() {
        return this.liCurrentLD;
    }

    public int[] getAvailableSelectionCriteria() {
        return this.availableSelectionCriteria;
    }

    public int[] getUsefulRefinementCriteria() {
        return this.usefulRefinementCriteria;
    }

    public long getReturnCode() {
        return this.returnCode;
    }
}

