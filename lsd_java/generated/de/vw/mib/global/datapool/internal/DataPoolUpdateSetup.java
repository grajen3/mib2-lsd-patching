/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.global.datapool.internal;

import de.vw.mib.hmi.internal.ServiceManagerCommon;
import generated.de.vw.mib.global.datapool.internal.DataPoolUpdate;

public final class DataPoolUpdateSetup {
    private DataPoolUpdateSetup() {
    }

    public static void bind(DataPoolUpdate dataPoolUpdate) {
        DataPoolUpdateSetup.registerOnProperties(dataPoolUpdate);
        DataPoolUpdateSetup.registerOnAslLists(dataPoolUpdate, new int[]{58, 10530, 10480, 10462, 10560, -508755712, 332, 333, 3344, -1306503424, 462, 924, 1744638720, 1461, 5908736});
    }

    private static void registerOnProperties(DataPoolUpdate dataPoolUpdate) {
        ServiceManagerCommon.modelDatapool.registerDatapoolUpdate(dataPoolUpdate);
    }

    private static void registerOnAslLists(DataPoolUpdate dataPoolUpdate, int[] nArray) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            int n = nArray[i2];
            ServiceManagerCommon.dynamicListItemControlManager.getListItemControl(n).addListItemControlListener(dataPoolUpdate.createAslListUpdate(n));
        }
    }
}

