/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.setup.threelevel.category;

import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.log4mib.LogMessage;
import java.util.Arrays;

public class PoiCategoryHelper {
    public static boolean isCategorySelected(int[] nArray, int n) {
        int n2 = -1;
        if (nArray != null) {
            n2 = Arrays.binarySearch(nArray, n);
        }
        return n2 >= 0;
    }

    public static void logIfEnabled(AbstractTarget abstractTarget, LogMessage logMessage) {
        if (abstractTarget.isTraceEnabled()) {
            logMessage.log();
        }
    }
}

