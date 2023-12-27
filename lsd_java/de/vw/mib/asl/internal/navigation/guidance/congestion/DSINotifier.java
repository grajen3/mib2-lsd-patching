/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.congestion;

import org.dsi.ifc.navigation.DSIBlocking;

public class DSINotifier {
    private DSIBlocking dsiBlocking;

    public DSINotifier(DSIBlocking dSIBlocking) {
        this.dsiBlocking = dSIBlocking;
    }

    public void blockRouteBasedOnLength(int n, int n2) {
        this.dsiBlocking.blockRouteBasedOnLength(n, n2);
    }

    public void deleteBlock(long[] lArray) {
        this.dsiBlocking.deleteBlock(lArray);
    }
}

