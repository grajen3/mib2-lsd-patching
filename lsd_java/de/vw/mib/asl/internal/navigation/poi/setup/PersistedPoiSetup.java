/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.setup;

import de.vw.mib.asl.api.navigation.NavigationConfiguration;
import de.vw.mib.asl.api.navigation.poi.IPersistedPoiSetup;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.PersistableMap;
import de.vw.mib.asl.api.navigation.util.ReloadPersistedDataListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import org.dsi.ifc.global.NavLocation;

public final class PersistedPoiSetup
implements ReloadPersistedDataListener,
IPersistedPoiSetup {
    private static final String POI_LOCATION_FOR_SEARCH_AREA_ADDRESS;
    private static NavLocation POI_LOCATION_FOR_SEARCH_AREA_ADDRESS_DEFAULT;
    private static final String POI_LOCATION_FOR_SEARCH_AREA_MAP;
    private static NavLocation POI_LOCATION_FOR_SEARCH_AREA_MAP_DEFAULT;
    private static final String POI_SEARCH_AREA_NO_GUIDANCE;
    private static final int POI_SEARCH_AREA_NO_GUIDANCE_DEFAULT;
    private static final String POI_SEARCH_AREA_ACTIVE_GUIDANCE;
    private static final int POI_SEARCH_AREA_ACTIVE_GUIDANCE_DEFAULT;
    private static final String POI_FUEL_OPTIONS_DESTINATION_RANGE_WARNING;
    private static final boolean POI_FUEL_OPTIONS_DESTINATION_RANGE_WARNING_DEFAULT;
    private static final String POI_FUEL_OPTIONS_HOME_RANGE_WARNING;
    private static final boolean POI_FUEL_OPTIONS_HOME_RANGE_WARNING_DEFAULT;
    private static final String POI_FUEL_OPTIONS_PREFERRED_CHARGING_SPEED;
    public static final int POI_FUEL_OPTIONS_PREFERRED_CHARGING_SPEED_DEFAULT;
    private static final String POI_ONLINE_SEARCH_PROVIDER_URL;
    private static final String POI_ONLINE_SEARCH_PROVIDER_URL_DEFAULT;
    private static final String POI_ONLINE_SEARCH_PROVIDER_CHECKSUM;
    private static final String POI_ONLINE_SEARCH_PROVIDER_CHECKSUM_DEFAULT;
    private static final String POI_ONLINE_SEARCH_PROVIDER_DYNAMIC_ECHARGING_URL;
    private static final String POI_ONLINE_SEARCH_PROVIDER_DYNAMIC_ECHARGING_FAST_URL;
    private static final String POI_ONLINE_SEARCH_PROVIDER_DYNAMIC_ECHARGING_NORMAL_URL;
    private static final String POI_ONLINE_SEARCH_PROVIDER_DYNAMIC_GAS_URL;
    private static final String POI_ONLINE_SEARCH_PROVIDER_DYNAMIC_NATURAL_GAS_URL;
    private static final String POI_ONLINE_SEARCH_PROVIDER_DYNAMIC_PARKING_URL;
    private static final String POI_ONLINE_SEARCH_PROVIDER_DYNAMIC_ECHARGING_CHECKSUM;
    private static final String POI_ONLINE_SEARCH_PROVIDER_DYNAMIC_ECHARGING_FAST_CHECKSUM;
    private static final String POI_ONLINE_SEARCH_PROVIDER_DYNAMIC_ECHARGING_NORMAL_CHECKSUM;
    private static final String POI_ONLINE_SEARCH_PROVIDER_DYNAMIC_GAS_CHECKSUM;
    private static final String POI_ONLINE_SEARCH_PROVIDER_DYNAMIC_NATURAL_GAS_CHECKSUM;
    private static final String POI_ONLINE_SEARCH_PROVIDER_DYNAMIC_PARKING_CHECKSUM;
    private static final String POI_ONLINE_SEARCH_PROVIDER_DYNAMIC_URL_DEFAULT;
    private static final String POI_ONLINE_SEARCH_PROVIDER_DYNAMIC_CHECKSUM_DEFAULT;
    private static String POI_FUEL_OPTIONS_FUEL_WARNING;
    private static boolean POI_FUEL_OPTIONS_FUEL_WARNING_DEFAULT;
    private PersistableMap persistableMap = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getExtendedNavPersistence().getPersistableMap("poi");
    private static IPersistedPoiSetup myInstance;

    private PersistedPoiSetup() {
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().addReloadPersistedDataListener(this);
    }

    public static IPersistedPoiSetup getInstance() {
        return myInstance;
    }

    public static boolean getPoiFuelOptionsFuelWwarningDefault() {
        return POI_FUEL_OPTIONS_FUEL_WARNING_DEFAULT;
    }

    @Override
    public NavLocation getLocationForSearchAreaAddress() {
        return this.persistableMap.getNavLocation("Poi.LocationForSearchAreaAddress", POI_LOCATION_FOR_SEARCH_AREA_ADDRESS_DEFAULT);
    }

    @Override
    public void setLocationForSearchAreaAddress(NavLocation navLocation) {
        this.persistableMap.setNavLocation("Poi.LocationForSearchAreaAddress", navLocation);
    }

    @Override
    public NavLocation getLocationForSearchAreaMap() {
        return this.persistableMap.getNavLocation("Poi.LocationForSearchAreaMap", POI_LOCATION_FOR_SEARCH_AREA_MAP_DEFAULT);
    }

    @Override
    public void setLocationForSearchAreaMap(NavLocation navLocation) {
        this.persistableMap.setNavLocation("Poi.LocationForSearchAreaMap", navLocation);
    }

    @Override
    public int getSearchAreaNoGuidance() {
        return this.persistableMap.getInt("Poi.SearchAreaNoGuidance", POI_SEARCH_AREA_NO_GUIDANCE_DEFAULT);
    }

    @Override
    public void setSearchAreaNoGuidance(int n) {
        this.persistableMap.setInt("Poi.SearchAreaNoGuidance", n);
    }

    @Override
    public int getSearchAreaActiveGuidance() {
        return this.persistableMap.getInt("Poi.SearchAreaActiceGuidance", 5);
    }

    @Override
    public void setSearchAreaActiveGuidance(int n) {
        this.persistableMap.setInt("Poi.SearchAreaActiceGuidance", n);
    }

    @Override
    public boolean getFuelOptionsDestinationRangeWarning() {
        return this.persistableMap.getBoolean("Poi.DestinationRangeWarning", true);
    }

    @Override
    public void setFuelOptionsDestinationRangeWarning(boolean bl) {
        this.persistableMap.setBoolean("Poi.DestinationRangeWarning", bl);
    }

    @Override
    public boolean getFuelOptionsDestinationHomeWarning() {
        return this.persistableMap.getBoolean("Poi.HomeRangeWarning", false);
    }

    @Override
    public void setFuelOptionsDestinationHomeWarning(boolean bl) {
        this.persistableMap.setBoolean("Poi.HomeRangeWarning", bl);
    }

    @Override
    public int getPreferredChargingSpeed() {
        return this.persistableMap.getInt("Poi.PreferredChargingSpeed", 2);
    }

    @Override
    public void setPreferredChargingSpeed(int n) {
        this.persistableMap.setInt("Poi.PreferredChargingSpeed", n);
    }

    @Override
    public String getOnlineSearchProviderUrl() {
        return this.persistableMap.getString("Poi.OnlineSearchProviderUrl", POI_ONLINE_SEARCH_PROVIDER_URL_DEFAULT);
    }

    @Override
    public void setOnlineSearchProviderUrl(String string) {
        this.persistableMap.setString("Poi.OnlineSearchProviderUrl", string);
    }

    @Override
    public String getOnlineSearchProviderChecksum() {
        return this.persistableMap.getString("Poi.OnlineSearchProviderChecksum", POI_ONLINE_SEARCH_PROVIDER_CHECKSUM_DEFAULT);
    }

    @Override
    public void setOnlineSearchProviderChecksum(String string) {
        this.persistableMap.setString("Poi.OnlineSearchProviderChecksum", string);
    }

    @Override
    public String getOnlineSearchProviderDynamicUrl(int n) {
        switch (n) {
            case 4: {
                return this.persistableMap.getString("Poi.OnlineSearchDynamicEChargingProviderUrl", POI_ONLINE_SEARCH_PROVIDER_DYNAMIC_URL_DEFAULT);
            }
            case 6: {
                return this.persistableMap.getString("Poi.OnlineSearchDynamicEChargingFastProviderUrl", POI_ONLINE_SEARCH_PROVIDER_DYNAMIC_URL_DEFAULT);
            }
            case 5: {
                return this.persistableMap.getString("Poi.OnlineSearchDynamicEChargingNormalProviderUrl", POI_ONLINE_SEARCH_PROVIDER_DYNAMIC_URL_DEFAULT);
            }
            case 1: {
                return this.persistableMap.getString("Poi.OnlineSearchDynamicGasProviderUrl", POI_ONLINE_SEARCH_PROVIDER_DYNAMIC_URL_DEFAULT);
            }
            case 3: {
                return this.persistableMap.getString("Poi.OnlineSearchDynamicNaturalGasProviderUrl", POI_ONLINE_SEARCH_PROVIDER_DYNAMIC_URL_DEFAULT);
            }
            case 2: {
                return this.persistableMap.getString("Poi.OnlineSearchDynamicParkingProviderUrl", POI_ONLINE_SEARCH_PROVIDER_DYNAMIC_URL_DEFAULT);
            }
        }
        return POI_ONLINE_SEARCH_PROVIDER_URL_DEFAULT;
    }

    @Override
    public void setOnlineSearchProviderDynamicUrl(String string, int n) {
        switch (n) {
            case 4: {
                this.persistableMap.setString("Poi.OnlineSearchDynamicEChargingProviderUrl", string);
                break;
            }
            case 6: {
                this.persistableMap.setString("Poi.OnlineSearchDynamicEChargingFastProviderUrl", string);
                break;
            }
            case 5: {
                this.persistableMap.setString("Poi.OnlineSearchDynamicEChargingNormalProviderUrl", string);
                break;
            }
            case 1: {
                this.persistableMap.setString("Poi.OnlineSearchDynamicGasProviderUrl", string);
                break;
            }
            case 3: {
                this.persistableMap.setString("Poi.OnlineSearchDynamicNaturalGasProviderUrl", string);
                break;
            }
            case 2: {
                this.persistableMap.setString("Poi.OnlineSearchDynamicParkingProviderUrl", string);
                break;
            }
        }
    }

    @Override
    public String getOnlineSearchProviderDynamicChecksum(int n) {
        switch (n) {
            case 4: {
                return this.persistableMap.getString("Poi.OnlineSearchDynamicEChargingProviderChecksum", POI_ONLINE_SEARCH_PROVIDER_DYNAMIC_CHECKSUM_DEFAULT);
            }
            case 6: {
                return this.persistableMap.getString("Poi.OnlineSearchDynamicEChargingFastProviderChecksum", POI_ONLINE_SEARCH_PROVIDER_DYNAMIC_CHECKSUM_DEFAULT);
            }
            case 5: {
                return this.persistableMap.getString("Poi.OnlineSearchDynamicEChargingNormalProviderChecksum", POI_ONLINE_SEARCH_PROVIDER_DYNAMIC_CHECKSUM_DEFAULT);
            }
            case 1: {
                return this.persistableMap.getString("Poi.OnlineSearchDynamicGasProviderChecksum", POI_ONLINE_SEARCH_PROVIDER_DYNAMIC_CHECKSUM_DEFAULT);
            }
            case 3: {
                return this.persistableMap.getString("Poi.OnlineSearchDynamicNaturalGasProviderChecksum", POI_ONLINE_SEARCH_PROVIDER_DYNAMIC_CHECKSUM_DEFAULT);
            }
            case 2: {
                return this.persistableMap.getString("Poi.OnlineSearchDynamicParkingProviderChecksum", POI_ONLINE_SEARCH_PROVIDER_DYNAMIC_CHECKSUM_DEFAULT);
            }
        }
        return POI_ONLINE_SEARCH_PROVIDER_CHECKSUM_DEFAULT;
    }

    @Override
    public void setOnlineSearchProviderDynamicChecksum(String string, int n) {
        switch (n) {
            case 4: {
                this.persistableMap.setString("Poi.OnlineSearchDynamicEChargingProviderChecksum", string);
                break;
            }
            case 6: {
                this.persistableMap.setString("Poi.OnlineSearchDynamicEChargingFastProviderChecksum", string);
                break;
            }
            case 5: {
                this.persistableMap.setString("Poi.OnlineSearchDynamicEChargingNormalProviderChecksum", string);
                break;
            }
            case 1: {
                this.persistableMap.setString("Poi.OnlineSearchDynamicGasProviderChecksum", string);
                break;
            }
            case 3: {
                this.persistableMap.setString("Poi.OnlineSearchDynamicNaturalGasProviderChecksum", string);
                break;
            }
            case 2: {
                this.persistableMap.setString("Poi.OnlineSearchDynamicParkingProviderChecksum", string);
                break;
            }
        }
    }

    @Override
    public boolean getFuelOptionsFuelWarning() {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            return ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().isFuelWarinigPopup();
        }
        return this.persistableMap.getBoolean(POI_FUEL_OPTIONS_FUEL_WARNING, true);
    }

    @Override
    public void setFuelOptionsFuelWarning(boolean bl) {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setFuelWarinigPopup(bl);
        } else {
            this.persistableMap.setBoolean(POI_FUEL_OPTIONS_FUEL_WARNING, bl);
        }
    }

    @Override
    public void updateProperties() {
        this.updatePropertyFuelOptionsFuelWarning();
        this.updatePropertyFuelOptionsDestinationRangeWarning();
        this.updatePropertyFuelOptionsDestinationHomeWarning();
        this.updatePropertyPreferredChargingSpeed();
    }

    @Override
    public void updatePropertyFuelOptionsFuelWarning() {
        ServiceManager.aslPropertyManager.valueChangedBoolean(969, this.getFuelOptionsFuelWarning());
    }

    @Override
    public void updatePropertyFuelOptionsDestinationRangeWarning() {
        ServiceManager.aslPropertyManager.valueChangedBoolean(3583, this.getFuelOptionsDestinationRangeWarning());
    }

    @Override
    public void updatePropertyFuelOptionsDestinationHomeWarning() {
        ServiceManager.aslPropertyManager.valueChangedBoolean(3584, this.getFuelOptionsDestinationHomeWarning());
    }

    @Override
    public void updatePropertyPreferredChargingSpeed() {
        ServiceManager.aslPropertyManager.valueChangedInteger(3619, this.getPreferredChargingSpeed());
    }

    @Override
    public void reloadPersistedData() {
        this.updateProperties();
    }

    static {
        POI_LOCATION_FOR_SEARCH_AREA_ADDRESS_DEFAULT = null;
        POI_LOCATION_FOR_SEARCH_AREA_MAP_DEFAULT = null;
        POI_SEARCH_AREA_NO_GUIDANCE_DEFAULT = NavigationConfiguration.LOCATIONINPUT_CHN_FEATURES_AVAILABLE ? 9 : 1;
        POI_ONLINE_SEARCH_PROVIDER_URL_DEFAULT = null;
        POI_ONLINE_SEARCH_PROVIDER_CHECKSUM_DEFAULT = null;
        POI_ONLINE_SEARCH_PROVIDER_DYNAMIC_URL_DEFAULT = null;
        POI_ONLINE_SEARCH_PROVIDER_DYNAMIC_CHECKSUM_DEFAULT = null;
        POI_FUEL_OPTIONS_FUEL_WARNING = "Poi.FuelOptionsFuelWarning";
        POI_FUEL_OPTIONS_FUEL_WARNING_DEFAULT = true;
        myInstance = new PersistedPoiSetup();
    }
}

