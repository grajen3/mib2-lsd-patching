/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.telephoneng;

import org.dsi.ifc.base.DSIBase;

public interface DSIMobileEquipmentTopology
extends DSIBase {
    public static final String VERSION;
    public static final int RT_REQUESTCHANGETOPOLOGY;
    public static final int ATTR_TOPOLOGY;
    public static final int ATTR_USAGE;
    public static final int RP_RESPONSECHANGETOPOLOGY;
    public static final int USAGE_NAD;
    public static final int USAGE_HFP;

    default public void requestChangeTopology(int[] nArray) {
    }
}

