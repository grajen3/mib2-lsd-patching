/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.util;

import org.dsi.ifc.telephoneng.DSIMobileEquipment;

public class TripleMobileEquipment$TopologyUsage {
    private final int[] usage;
    private final int firstNad;
    private final int hfp1;
    private final int hfp2;

    public static boolean isUsed(int n) {
        return n == 1 || n == 0;
    }

    public TripleMobileEquipment$TopologyUsage(int[] nArray) {
        int n;
        this.usage = nArray;
        int n2 = -1;
        int n3 = -1;
        int n4 = -1;
        for (n = nArray.length - 1; n >= 0; --n) {
            if (nArray[n] == 0) {
                n2 = n;
                continue;
            }
            if (nArray[n] != 1) continue;
            n3 = n;
        }
        if (n3 != -1) {
            for (n = n3; n < nArray.length; ++n) {
                if (nArray[n] != 1) continue;
                n4 = n;
            }
        }
        this.firstNad = n2;
        this.hfp1 = n3;
        this.hfp2 = n4;
    }

    public int getNad() {
        return this.firstNad;
    }

    public int getHfp1() {
        return this.hfp1;
    }

    public int getHfp2() {
        return this.hfp2;
    }

    public int getUsage(int n) {
        return this.usage[n];
    }

    DSIMobileEquipment[] filterUsed(DSIMobileEquipment[] dSIMobileEquipmentArray) {
        int n = 0;
        for (int i2 = 0; i2 < this.usage.length; ++i2) {
            if (!TripleMobileEquipment$TopologyUsage.isUsed(this.usage[i2])) continue;
            ++n;
        }
        DSIMobileEquipment[] dSIMobileEquipmentArray2 = new DSIMobileEquipment[n];
        int n2 = 0;
        for (int i3 = 0; i3 < this.usage.length; ++i3) {
            if (!TripleMobileEquipment$TopologyUsage.isUsed(this.usage[i3])) continue;
            dSIMobileEquipmentArray2[n2++] = dSIMobileEquipmentArray[i3];
        }
        return dSIMobileEquipmentArray2;
    }

    static /* synthetic */ int[] access$000(TripleMobileEquipment$TopologyUsage tripleMobileEquipment$TopologyUsage) {
        return tripleMobileEquipment$TopologyUsage.usage;
    }
}

