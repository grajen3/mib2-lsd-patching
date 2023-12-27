/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.setup.trafficmap;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.PersistableMap;
import de.vw.mib.asl.internal.navigation.map.setup.trafficmap.PersistedTrafficSetup$Holder;

public class PersistedTrafficSetup {
    private static final String MAIN_MAP_SHOW_SPEED_AND_FLOW;
    private static final boolean MAIN_MAP_SHOW_SPEED_AND_FLOW_DEFAULT;
    private static final String SHOW_CONGESTIONS;
    private static final boolean SHOW_CONGESTIONS_DEFAULT;
    private static final String SHOW_FREE_FLOW;
    private static final boolean SHOW_FREE_FLOW_DEFAULT;
    private static final String SHOW_INCIDENTS;
    private static final boolean SHOW_INCIDENTS_DEFAULT;
    private static final String SPEED_AND_FLOW_ROAD_CLASS;
    private static final int SPEED_AND_FLOW_ROAD_CLASS_DEFAULT;
    private PersistableMap persistableMap = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getExtendedNavPersistence().getPersistableMap("traffic");

    public static final PersistedTrafficSetup getInstance() {
        return PersistedTrafficSetup$Holder.INSTANCE;
    }

    public void clear() {
        this.persistableMap.clear();
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setTrafficShowCongestion(true);
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setTrafficShowFreeFlow(true);
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setTrafficShowIncidents(true);
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setMainMapShowSpeedAndFlow(true);
    }

    public int getSpeedAndFlowRoadClass() {
        return this.persistableMap.getInt("speedAndFlow.roadClass", 3);
    }

    public int getSpeedAndFlowRoadClassDSI() {
        int n = this.getSpeedAndFlowRoadClass();
        switch (n) {
            case 0: {
                return 4;
            }
            case 1: {
                return 1;
            }
            case 2: {
                return 2;
            }
            case 3: {
                return 3;
            }
        }
        return 3;
    }

    public boolean getTrafficShowCongestion() {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            return ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().getTrafficShowCongestion();
        }
        return this.persistableMap.getBoolean("show.congestions", true);
    }

    public boolean getTrafficShowFreeFlow() {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            return ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().getTrafficShowFreeFlow();
        }
        return this.persistableMap.getBoolean("show.freeflow", true);
    }

    public boolean getTrafficShowIncidents() {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            return ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().getTrafficShowIncidents();
        }
        return this.persistableMap.getBoolean("show.incidents", true);
    }

    public boolean isMainMapShowSpeedAndFlow() {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            return ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().getMainMapShowSpeedAndFlow();
        }
        return this.persistableMap.getBoolean("show.speedandflow", true);
    }

    public void setMainMapShowSpeedAndFlow(boolean bl) {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setMainMapShowSpeedAndFlow(bl);
        } else {
            this.persistableMap.setBoolean("show.speedandflow", bl);
        }
    }

    public void setSpeedAndFlowRoadClass(int n) {
        this.persistableMap.setInt("speedAndFlow.roadClass", n);
    }

    public void setTrafficShowCongestion(boolean bl) {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setTrafficShowCongestion(bl);
        } else {
            this.persistableMap.setBoolean("show.congestions", bl);
        }
    }

    public void setTrafficShowFreeFlow(boolean bl) {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setTrafficShowFreeFlow(bl);
        } else {
            this.persistableMap.setBoolean("show.freeflow", bl);
        }
    }

    public void setTrafficShowIncidents(boolean bl) {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setTrafficShowIncidents(bl);
        } else {
            this.persistableMap.setBoolean("show.incidents", bl);
        }
    }
}

