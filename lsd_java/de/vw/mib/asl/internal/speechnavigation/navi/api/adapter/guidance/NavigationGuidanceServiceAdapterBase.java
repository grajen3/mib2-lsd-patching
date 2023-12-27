/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.guidance;

import de.vw.mib.asl.api.navigation.guidance.NavigationGuidanceListenerAdapter;
import de.vw.mib.collections.ints.IntIntMap;
import de.vw.mib.collections.ints.IntIntOptHashMap;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.util.StringBuilder;

public abstract class NavigationGuidanceServiceAdapterBase
extends NavigationGuidanceListenerAdapter {
    protected final IntIntMap guidanceTypeMap = new IntIntOptHashMap(4);
    protected final IntObjectMap guidanceTypeTranslationMap = new IntObjectOptHashMap(5);
    protected final IntIntMap guidanceStateMap = new IntIntOptHashMap(3);
    protected final IntObjectMap guidanceStateTranslationMap = new IntObjectOptHashMap(2);
    protected final IntIntMap guidanceStateResultMap = new IntIntOptHashMap(2);
    protected final IntObjectMap routeCalculationStateRawTranslationMap = new IntObjectOptHashMap(3);

    protected NavigationGuidanceServiceAdapterBase() {
        this.guidanceTypeMap.put(0, 0);
        this.guidanceTypeMap.put(2, 2);
        this.guidanceTypeMap.put(1, 1);
        this.guidanceTypeMap.put(3, 3);
        this.guidanceTypeTranslationMap.put(0, "normal");
        this.guidanceTypeTranslationMap.put(1, "waypoint");
        this.guidanceTypeTranslationMap.put(2, "predictive");
        this.guidanceTypeTranslationMap.put(3, "rubberband");
        this.guidanceTypeTranslationMap.put(-1, "unknown");
        this.guidanceStateMap.put(1, 1);
        this.guidanceStateMap.put(0, 0);
        this.guidanceStateMap.put(-1, -1);
        this.guidanceStateTranslationMap.put(1, "active");
        this.guidanceStateTranslationMap.put(0, "inactive");
        this.guidanceStateTranslationMap.put(-1, "unknown");
        this.guidanceStateResultMap.put(0, 0);
        this.guidanceStateResultMap.put(1, 1);
        this.routeCalculationStateRawTranslationMap.put(2, "finished");
        this.routeCalculationStateRawTranslationMap.put(1, "calculating");
        this.routeCalculationStateRawTranslationMap.put(0, "idle");
    }

    protected String translateRouteCalculationStatus(int[] nArray, int[] nArray2, int[] nArray3) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            stringBuilder.append("[routeId, state, progress] = ").append("[ ");
            stringBuilder.append(nArray[i2]).append(", ");
            stringBuilder.append(this.routeCalculationStateRawTranslationMap.get(nArray2[i2])).append(", ");
            stringBuilder.append(nArray3[i2]).append(" %");
            stringBuilder.append(" ]").append("\n");
        }
        return stringBuilder.toString();
    }

    protected String translateGuidanceStatus(int n, int n2) {
        return new StringBuffer().append(" [guidance mode, guidance status] = [").append(this.guidanceTypeTranslationMap.get(n)).append(", ").append(this.guidanceStateTranslationMap.get(n2)).append("]").toString();
    }
}

