/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.telephoneng;

import org.dsi.ifc.base.DSIListener;

public interface DSIMobileEquipmentTopologyListener
extends DSIListener {
    default public void responseChangeTopology(int n) {
    }

    default public void updateTopology(int[] nArray, int n) {
    }

    default public void updateUsage(int[] nArray, int n) {
    }
}

