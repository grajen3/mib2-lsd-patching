/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.splitscreen.overlays;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.PersistableMap;

public class PersistedOverlaysSetup {
    private static final String OVERLAYS_KANBAN_ACTIVE;
    private static final boolean OVERLAYS_KANBAN_ACTIVE_DEFAULT;
    private static final String OVERLAYS_KDK_ACTIVE;
    private static final boolean OVERLAYS_KDK_ACTIVE_DEFAULT;
    private static final String OVERLAYS_MOTORWAYINFO_ACTIVE;
    private static final boolean OVERLAYS_MOTORWAYINFO_ACTIVE_DEFAULT;
    private static final String ROUTEINFO_DISPLAY_MODE;
    private static PersistedOverlaysSetup instance;
    private PersistableMap persistableMap = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getExtendedNavPersistence().getPersistableMap("overlays");

    public static PersistedOverlaysSetup getInstance() {
        return instance;
    }

    public boolean isKanban() {
        return this.persistableMap.getBoolean("kanban.active", true);
    }

    public boolean isKDK() {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            return ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().isKDK();
        }
        return this.persistableMap.getBoolean("kdk.active", true);
    }

    public boolean isMotorwayInfo() {
        return this.persistableMap.getBoolean("motorway.info.active", true);
    }

    public int getRouteinfoDisplayMode() {
        return this.persistableMap.getInt("routeinfo.display.mode", 1);
    }

    public void setKanban(boolean bl) {
        this.persistableMap.setBoolean("kanban.active", bl);
    }

    public void setKDK(boolean bl) {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setKDK(bl);
        } else {
            this.persistableMap.setBoolean("kdk.active", bl);
        }
    }

    public void setMotorwayInfo(boolean bl) {
        this.persistableMap.setBoolean("motorway.info.active", bl);
    }

    public void setRouteinfoDisplayMode(int n) {
        this.persistableMap.setInt("routeinfo.display.mode", n);
    }

    public void clear() {
        this.persistableMap.clear();
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setKDK(true);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\nPersistedOverlaysSetup");
        stringBuffer.append("\nPersistedOverlaysSetup - Route Information           - HMI-Value - ").append(this.getRouteinfoDisplayMode() == 1 ? "Complete" : "Compact");
        stringBuffer.append("\nPersistedOverlaysSetup - Kanban Activated            - HMI-Value - ").append(this.isKanban() ? "true" : "false");
        stringBuffer.append("\nPersistedOverlaysSetup - KDK Activated               - HMI-Value - ").append(this.isKDK() ? "true" : "false");
        stringBuffer.append("\nPersistedOverlaysSetup - Motorway Info Activated     - HMI-Value - ").append(this.isMotorwayInfo() ? "true" : "false");
        stringBuffer.append("\nPersistedOverlaysSetup");
        return stringBuffer.toString();
    }

    static {
        instance = new PersistedOverlaysSetup();
    }
}

