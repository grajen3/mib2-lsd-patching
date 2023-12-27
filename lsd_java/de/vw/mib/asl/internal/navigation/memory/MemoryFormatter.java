/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.memory;

import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.util.StringUtil;
import de.vw.mib.asl.internal.navigation.memory.MemoryFormatter$1;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.navigation.memory.transformer.NavigationMemoryDestinationDetailsCollector;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.organizer.AddressData;

public class MemoryFormatter {
    public static NavigationMemoryDestinationDetailsCollector createMemoryOnlineDestinationDetails(ILocationWrapper iLocationWrapper, AddressData addressData, String string) {
        NavigationMemoryDestinationDetailsCollector navigationMemoryDestinationDetailsCollector = (NavigationMemoryDestinationDetailsCollector)ListManager.getGenericASLList(910).getRowItemCacheOnly(0);
        String string2 = navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_name = string != null ? string : "";
        if (addressData != null) {
            navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_country = addressData.getCountry();
            navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_zip = addressData.getPostalCode();
            navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_city = addressData.getLocality();
            navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_street = addressData.getStreet();
        }
        if (iLocationWrapper != null) {
            navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_lat_degree = iLocationWrapper.getLatitudeDegrees();
            navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_lat_minutes = iLocationWrapper.getLatitudeMinutes();
            navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_lat_seconds = iLocationWrapper.getLatitudeSeconds();
            navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_lon_degree = iLocationWrapper.getLongitudeDegrees();
            navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_lon_minutes = iLocationWrapper.getLongitudeMinutes();
            navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_lon_seconds = iLocationWrapper.getLongitudeSeconds();
            navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_phone_number = iLocationWrapper.getPhonenumber();
        }
        navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_type = 4;
        navigationMemoryDestinationDetailsCollector.navigation_memory_destination_details_for_fix_formatter = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationFormatter().prepareFixFormatterFieldData(addressData, string, iLocationWrapper);
        return navigationMemoryDestinationDetailsCollector;
    }

    public static NavigationMemoryDestinationDetailsCollector createMemoryDestinationDetails(ILocationWrapper iLocationWrapper, String string) {
        NavigationMemoryDestinationDetailsCollector navigationMemoryDestinationDetailsCollector = (NavigationMemoryDestinationDetailsCollector)ListManager.getGenericASLList(910).getRowItemCacheOnly(0);
        navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_name = string != null ? string : "";
        navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_country = iLocationWrapper.getCountry();
        navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_zip = iLocationWrapper.getPostalCode();
        navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_city = iLocationWrapper.getCity();
        navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_city_refinement = iLocationWrapper.getCityRefinement();
        navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_street = iLocationWrapper.getStreet();
        navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_street_refinement = iLocationWrapper.getStreetRefinement();
        navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_number = iLocationWrapper.getHousenumber();
        navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_junction = iLocationWrapper.getCrossing();
        navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_country_code = iLocationWrapper.getCountryCode();
        navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_poi_name = iLocationWrapper.getPoiName();
        navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_poi_category = iLocationWrapper.getPoiCategory();
        navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_phone_number = iLocationWrapper.getPhonenumber();
        navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_url = iLocationWrapper.getURLAddress();
        navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_lat_degree = iLocationWrapper.getLatitudeDegrees();
        navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_lat_minutes = iLocationWrapper.getLatitudeMinutes();
        navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_lat_seconds = iLocationWrapper.getLatitudeSeconds();
        navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_lon_degree = iLocationWrapper.getLongitudeDegrees();
        navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_lon_minutes = iLocationWrapper.getLongitudeMinutes();
        navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_lon_seconds = iLocationWrapper.getLongitudeSeconds();
        navigationMemoryDestinationDetailsCollector.navigation_memory_destination_details_for_fix_formatter = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationFormatter().prepareFixFormatterFieldData(iLocationWrapper);
        switch (iLocationWrapper.getLocationType()) {
            case 3: {
                if (StringUtil.isEmpty(iLocationWrapper.getMmiInternalDataValue(3))) {
                    navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_type = 1;
                    break;
                }
                navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_type = 3;
                break;
            }
            case 0: {
                if (ServiceManager.configManagerDiag.getNaviCommonOptionDefaultBoolean(9)) {
                    navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_type = 2;
                    break;
                }
                navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_type = 0;
                break;
            }
            default: {
                navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_type = 0;
            }
        }
        if (iLocationWrapper.getLocationType() == 3) {
            MemoryFormatter$1 memoryFormatter$1 = new MemoryFormatter$1();
            navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_poi_icon = ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForPOIIcon(iLocationWrapper.getIconIndex(), iLocationWrapper.getSubIconIndex(), 0, memoryFormatter$1, navigationMemoryDestinationDetailsCollector);
        } else {
            navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_poi_icon = null;
        }
        return navigationMemoryDestinationDetailsCollector;
    }

    public static NavigationMemoryDestinationDetailsCollector createMemoryDestinationDetails(NavLocation navLocation, String string) {
        return MemoryFormatter.createMemoryDestinationDetails(ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation), string);
    }
}

