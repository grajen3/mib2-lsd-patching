/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.predictivenavigation;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.global.NavLocation;

public interface DSIPredictiveNavigation
extends DSIBase {
    public static final String VERSION;
    public static final int OPERATIONMODE_INACTIVE;
    public static final int OPERATIONMODE_PASSIVE;
    public static final int OPERATIONMODE_ACTIVE;
    public static final int ROUTECALCULATIONSTATE_NOT_CALCULATED;
    public static final int ROUTECALCULATIONSTATE_CALCULATING;
    public static final int ROUTECALCULATIONSTATE_CALCULATED;
    public static final int ROUTECALCULATIONSTATE_RECALCULATING;
    public static final int ROUTECOLOR_0;
    public static final int ROUTECOLOR_1;
    public static final int ROUTECOLOR_2;
    public static final int ROUTECOLOR_3;
    public static final int ROUTECOLOR_4;
    public static final int ROUTECOLOR_5;
    public static final int RT_SETOPERATIONMODE;
    public static final int RT_SETMAXPREDICTIONS;
    public static final int RT_CLEARCACHE;
    public static final int RT_CLEARCACHEBYDESTINATION;
    public static final int RT_CLEARCACHEBYAGE;
    public static final int RP_CLEARCACHERESULT;
    public static final int ATTR_OPERATIONMODE;
    public static final int ATTR_LIKELYDESTINATIONS;
    public static final int ATTR_MAXPREDICTIONS;

    default public void setOperationMode(int n) {
    }

    default public void setMaxPredictions(int n) {
    }

    default public void clearCache() {
    }

    default public void clearCacheByDestination(NavLocation navLocation, int n) {
    }

    default public void clearCacheByAge(long l) {
    }
}

