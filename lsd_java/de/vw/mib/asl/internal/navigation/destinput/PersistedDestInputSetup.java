/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.destinput;

import de.vw.mib.asl.api.navigation.NavigationDefinitions;
import de.vw.mib.asl.api.navigation.guidance.IPersistedDestInputSetup;
import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.PersistableMap;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import org.dsi.ifc.global.NavLocation;

public class PersistedDestInputSetup
implements IPersistedDestInputSetup {
    private static final Logger NAVI_LOGGER = NavigationDefinitions.NAVI_LOGGER;
    private static final String HOME_DEST_LOCATION;
    private static final NavLocation HOME_DEST_LOCATION_DEFAULT;
    private static final String HOME_DEST_BYTEARRAY;
    private static final byte[] HOME_DEST_BYTEARRAY_DEFAULT;
    private static final int LOCATION_TYPE_DEMO;
    private static final int LOCATION_TYPE_HOME;
    private static final int LOCATION_TYPE_LAST;
    private static final String LAST_DEST_LOCATION;
    private static final NavLocation LAST_DEST_LOCATION_DEFAULT;
    private static final String LAST_DEST_LOCATION_BYTEARRAY;
    private static final byte[] LAST_DEST_BYTEARRAY_DEFAULT;
    private static final String DEMO_DEST;
    private final PersistableMap persistableMap = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getExtendedNavPersistence().getPersistableMap("di");
    private static IPersistedDestInputSetup instance;
    private static final String PERSISTENCE_RESTORED;

    public static IPersistedDestInputSetup getInstance() {
        return instance;
    }

    @Override
    public NavLocation getHomeDest() {
        NavLocation navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE") ? ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().getHomeDestLocation(HOME_DEST_LOCATION_DEFAULT) : this.persistableMap.getNavLocation("home.dest.location", HOME_DEST_LOCATION_DEFAULT);
        return navLocation;
    }

    @Override
    public int getLastInputMode() {
        int n = ServiceManager.configManagerDiag.isFeatureFlagSet(75) ? 1 : 0;
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            n = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().getLastModeDestinationInput();
        }
        return n;
    }

    @Override
    public NavLocation getHomeLocation() {
        return this.getHomeDest();
    }

    @Override
    public void setLastInputMode(int n) {
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setLastModeDestinationInput(n);
    }

    @Override
    public void setHomeDest(NavLocation navLocation, boolean bl) {
        if (navLocation == null) {
            if (NAVI_LOGGER.isTraceEnabled(16384)) {
                LogMessage logMessage = NAVI_LOGGER.trace(16384);
                logMessage.append("Setting home location to null");
                logMessage.log();
            }
            if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
                ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setHomeDestLocation(null);
            } else {
                this.persistableMap.setNavLocation("home.dest.location", null);
            }
        } else {
            if (NAVI_LOGGER.isTraceEnabled(16384)) {
                LogMessage logMessage = NAVI_LOGGER.trace(16384);
                logMessage.append("Invoke Converting home location to stream");
                logMessage.log();
            }
            if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
                ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setHomeDestLocation(navLocation);
            } else {
                this.persistableMap.setNavLocation("home.dest.location", navLocation);
            }
        }
        this.sendHomeAddressChangedEvent();
    }

    @Override
    public NavLocation getLastDest() {
        return this.persistableMap.getNavLocation("last.dest.location", LAST_DEST_LOCATION_DEFAULT);
    }

    @Override
    public void setLastDest(NavLocation navLocation) {
        if (navLocation == null) {
            if (NAVI_LOGGER.isTraceEnabled(16384)) {
                LogMessage logMessage = NAVI_LOGGER.trace(16384);
                logMessage.append("PersistedNaviSetup: Setting lastDestination to null");
                logMessage.log();
            }
            this.persistableMap.setNavLocation("last.dest.location", null);
        } else {
            if (NAVI_LOGGER.isTraceEnabled(16384)) {
                LogMessage logMessage = NAVI_LOGGER.trace(16384);
                logMessage.append("PersistedNaviSetup: Invoke Converting lastDestination location to stream");
                logMessage.log();
            }
            this.persistableMap.setNavLocation("last.dest.location", navLocation);
        }
    }

    @Override
    public NavLocation getDemoDest() {
        return this.persistableMap.getNavLocation("demo.dest", ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getDefaultLocation());
    }

    @Override
    public void setDemoDest(NavLocation navLocation) {
        NavLocation navLocation2 = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getDefaultLocation();
        if (navLocation == null) {
            if (NavigationDefinitions.NAVI_LOGGER.isTraceEnabled(16384)) {
                NavigationDefinitions.NAVI_LOGGER.trace(16384, "Someone tries to set the DEMO location to null. Setting it to the default location instead.");
            }
            this.persistableMap.setNavLocation("demo.dest", navLocation2);
        } else {
            this.persistableMap.setNavLocation("demo.dest", navLocation);
        }
        if (NavigationDefinitions.NAVI_LOGGER.isTraceEnabled(16384)) {
            LogMessage logMessage = NavigationDefinitions.NAVI_LOGGER.trace(16384);
            logMessage.append("Invoke Converting demo location to stream");
            logMessage.log();
        }
    }

    boolean isPersistenceRestored() {
        return ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getExtendedNavPersistence().isLoaded();
    }

    private void setPersistenceRestored(boolean bl) {
        this.persistableMap.setBoolean("persistence.restored", bl);
    }

    @Override
    public void setPersistenceRestoredPublicTemp(boolean bl) {
        this.setPersistenceRestored(bl);
    }

    private void sendHomeAddressChangedEvent() {
        ASLNavigationMapFactory.getNavigationMapApi().sendEvDestInputHomeLocationChanged();
    }

    @Override
    public void updateProperties() {
        boolean bl = PersistedDestInputSetup.getInstance().getHomeDest() != null;
        this.updatePropertyIsHomeLocationSet(bl);
    }

    @Override
    public void updatePropertyIsHomeLocationSet(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(836, bl);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\nPersistedDestSetup");
        NavLocation navLocation = this.getDemoDest();
        stringBuffer.append("\nPersistedDestSetup - Demo Dest              - HMI-Value - ").append(navLocation == null ? "" : navLocation.toString());
        NavLocation navLocation2 = this.getHomeDest();
        stringBuffer.append("\nPersistedDestSetup - Home Dest              - HMI-Value - ").append(navLocation2 == null ? "" : navLocation2.toString());
        NavLocation navLocation3 = this.getHomeLocation();
        stringBuffer.append("\nPersistedDestSetup - Home Location          - HMI-Value - ").append(navLocation3 == null ? "" : navLocation3.toString());
        NavLocation navLocation4 = this.getLastDest();
        stringBuffer.append("\nPersistedDestSetup - Last Destination       - HMI-Value - ").append(navLocation4 == null ? "" : navLocation4.toString());
        int n = this.getLastInputMode();
        stringBuffer.append("\nPersistedDestSetup - Last Input Mode       - HMI-Value - ").append(n);
        stringBuffer.append("\nPersistedDestSetup");
        return stringBuffer.toString();
    }

    public static String getHomeDestBytearray() {
        return "home.dest.byte.array";
    }

    public static byte[] getHomeDestBytearrayDefault() {
        return HOME_DEST_BYTEARRAY_DEFAULT;
    }

    public static int getLocationTypeDemo() {
        return 1;
    }

    public static int getLocationTypeHome() {
        return 0;
    }

    public static int getLocationTypeLast() {
        return 2;
    }

    public static String getLastDestLocationBytearray() {
        return "last.dest.byte.array";
    }

    public static byte[] getLastDestBytearrayDefault() {
        return LAST_DEST_BYTEARRAY_DEFAULT;
    }

    @Override
    public boolean getShowSLDEHelp() {
        boolean bl = true;
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            bl = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().isShowSldeHelp();
        }
        return bl;
    }

    static {
        HOME_DEST_LOCATION_DEFAULT = null;
        HOME_DEST_BYTEARRAY_DEFAULT = null;
        LAST_DEST_LOCATION_DEFAULT = null;
        LAST_DEST_BYTEARRAY_DEFAULT = null;
        instance = new PersistedDestInputSetup();
    }
}

