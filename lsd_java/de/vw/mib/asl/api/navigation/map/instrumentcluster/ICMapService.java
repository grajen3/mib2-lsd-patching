/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.map.instrumentcluster;

public interface ICMapService {
    public static final int MAP_SWITCH_STATE_NOT_AVAILABLE;
    public static final int MAP_SWITCH_STATE_VISIBLE_IN_ABT;
    public static final int MAP_SWITCH_STATE_VISIBLE_IN_KOMBI;
    public static final int MAP_SWITCH_STATE_SWITCHING_TO_ABT_REQUEST;
    public static final int MAP_SWITCH_STATE_SWITCHING_TO_ABT_SHOW_MAP;
    public static final int MAP_SWITCH_STATE_SWITCHING_TO_KOMBI;
    public static final int NAVIGATION_MAP_IN_ABT_INVISIBLE;
    public static final int NAVIGATION_MAP_IN_ABT_VISIBLE;
    public static final int IC_MAP_SERVICE_STATE_NOT_READY;
    public static final int IC_MAP_SERVICE_STATE_READY;

    default public void setMapSwitchState(int n) {
    }

    default public void freeService() {
    }

    default public int getMapSwitchState() {
    }

    default public boolean getMapVisibilityForFPKSwitch() {
    }

    default public int getMapVisibilityInAbt() {
    }

    default public void failedToPerformSwitch() {
    }

    default public int getICMapServiceState() {
    }

    default public boolean isMapSwitchFunctionAvailableInKombi() {
    }

    default public void setMapSwitchFunctionAvailableInKombi(boolean bl) {
    }

    default public boolean isMapTemporarilyInABT() {
    }
}

