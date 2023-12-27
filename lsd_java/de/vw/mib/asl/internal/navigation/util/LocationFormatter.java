/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.util;

import de.vw.mib.asl.api.navigation.ASLNavigationTruffelFactory;
import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.poi.ASLNavigationPoiFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.api.navigation.util.ILocationFormatterConstants;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.util.StringUtil;
import de.vw.mib.asl.internal.navigation.util.LocationFormatter$1;
import de.vw.mib.asl.internal.navigation.util.LocationFormatter$2;
import de.vw.mib.asl.internal.navigation.util.NaviHelper;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.FixFormatterFieldDataImpl;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.navigation.homedestinput.transformer.NavigationHomeDestInputHomeDestinationDetailCollector;
import generated.de.vw.mib.asl.internal.navigation.memory.transformer.NavigationMemoryDestinationDetailsCollector;
import java.util.HashMap;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.organizer.AddressData;
import org.dsi.ifc.search.Highlight;
import org.dsi.ifc.search.SearchResult;

public final class LocationFormatter
implements ILocationFormatterConstants {
    private static IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, "LocationFormatter");
    private static HashMap tokenWordtypeTable;
    private static char[] digits;

    private static HashMap getTokenWordtypeTable(boolean bl) {
        if (tokenWordtypeTable == null) {
            tokenWordtypeTable = new HashMap();
            tokenWordtypeTable.put(new Integer(1), "City");
            tokenWordtypeTable.put(new Integer(17), "Country");
            tokenWordtypeTable.put(new Integer(3), "Street");
            tokenWordtypeTable.put(new Integer(6), "State");
            tokenWordtypeTable.put(new Integer(7), "Housenumber");
            tokenWordtypeTable.put(new Integer(4), "PostalCode");
            tokenWordtypeTable.put(new Integer(2), "StreetRefinement");
            tokenWordtypeTable.put(new Integer(103), "Crossing");
            tokenWordtypeTable.put(new Integer(12), "PoiCategory");
            tokenWordtypeTable.put(new Integer(5), "PoiName");
            tokenWordtypeTable.put(new Integer(11), "Phonenumber");
            tokenWordtypeTable.put(new Integer(22), "CustomName");
            tokenWordtypeTable.put(new Integer(80), "CityNearby");
        }
        if (bl) {
            tokenWordtypeTable.put(new Integer(23), "Ward");
            tokenWordtypeTable.put(new Integer(24), "Chome");
            tokenWordtypeTable.put(new Integer(25), "Place");
        } else {
            tokenWordtypeTable.remove(new Integer(23));
            tokenWordtypeTable.remove(new Integer(24));
            tokenWordtypeTable.remove(new Integer(25));
        }
        return tokenWordtypeTable;
    }

    private LocationFormatter() {
    }

    public static String createDetailString(int n, NavLocation navLocation) {
        String string;
        String string2;
        if (navLocation == null) {
            return "";
        }
        String string3 = navLocation.country;
        String string4 = navLocation.town;
        if (string4 != null) {
            string4 = LocationFormatter.replaceSpecialChars(string4);
        }
        String string5 = navLocation.zipCode;
        String string6 = navLocation.street;
        if (string6 != null) {
            string6 = LocationFormatter.replaceSpecialChars(string6);
        }
        String string7 = navLocation.housenumber;
        String string8 = navLocation.junction;
        if (string8 != null) {
            string8 = LocationFormatter.replaceSpecialChars(string8);
        }
        if ((string2 = navLocation.towncenter) != null) {
            string2 = LocationFormatter.replaceSpecialChars(string2);
        }
        switch (n) {
            case 0: {
                string = LocationFormatter.formatDetailString(string3, null, null, null, null, null, null);
                break;
            }
            case 1: {
                string = LocationFormatter.formatDetailString(string3, LocationFormatter.replaceSpecialChars(string4), null, null, null, null, null);
                break;
            }
            case 2: {
                string = LocationFormatter.formatDetailString(string3, string4, string2, null, null, null, null);
                break;
            }
            case 3: {
                string = LocationFormatter.formatDetailString(string3, string4, null, string5, null, null, null);
                break;
            }
            case 4: {
                string = LocationFormatter.formatDetailString(string3, string4, null, string5, string6, null, null);
                break;
            }
            case 5: {
                string = LocationFormatter.formatDetailString(string3, string4, null, string5, string6, string7, null);
                break;
            }
            case 6: {
                string = LocationFormatter.formatDetailString(string3, string4, null, string5, string6, null, string8);
                break;
            }
            case 7: {
                string = LocationFormatter.formatDetailString(string3, string4, string2, string5, string6, string7, string8);
                break;
            }
            default: {
                string = "";
            }
        }
        return string;
    }

    private static String formatDetailString(String string, String string2, String string3, String string4, String string5, String string6, String string7) {
        StringBuffer stringBuffer = new StringBuffer(150);
        if (string != null) {
            stringBuffer.append(string);
        }
        if (string4 != null) {
            stringBuffer.append(new StringBuffer().append("\\n").append(string4).append(", ").toString());
            if (string2 != null) {
                stringBuffer.append(string2);
            }
        } else if (string2 != null) {
            stringBuffer.append(new StringBuffer().append("\\n").append(string2).toString());
            if (string3 != null) {
                stringBuffer.append(new StringBuffer().append("\\n").append(string3).toString());
            }
        }
        if (string5 != null) {
            stringBuffer.append(new StringBuffer().append("\\n").append(string5).toString());
            if (string6 != null) {
                stringBuffer.append(new StringBuffer().append(" ").append(string6).toString());
            } else if (string7 != null) {
                stringBuffer.append(new StringBuffer().append("/").append(string7).toString());
            }
        }
        return LocationFormatter.replaceSpecialChars(stringBuffer.toString());
    }

    private static String replaceSpecialChars(String string) {
        int n = string.indexOf("%");
        if (n < 0) {
            return string;
        }
        return new StringBuffer().append(string.substring(0, n)).append(", ").append(string.substring(n + 1)).toString();
    }

    public static void updateNavDetailLocationGetter(NavLocation navLocation) {
        ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation);
        FixFormatterFieldDataImpl fixFormatterFieldDataImpl = (FixFormatterFieldDataImpl)LocationFormatter.prepareFixFormatterFieldData(iLocationWrapper);
        if (iLocationWrapper.isNavigable()) {
            ServiceManager.aslPropertyManager.valueChangedBoolean(-1359998976, true);
        } else {
            ServiceManager.aslPropertyManager.valueChangedBoolean(-1359998976, false);
        }
        switch (iLocationWrapper.getLocationType()) {
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(-1376776192, 0);
                break;
            }
            case 3: {
                if (StringUtil.isEmpty(iLocationWrapper.getMmiInternalDataValue(3))) {
                    ServiceManager.aslPropertyManager.valueChangedInteger(-1376776192, 2);
                    break;
                }
                ServiceManager.aslPropertyManager.valueChangedInteger(-1376776192, 3);
                fixFormatterFieldDataImpl.put("URLAddress", ASLNavigationPoiFactory.getNavigationPoiApi().getSelectedOnlinePoiUrl());
                ServiceManager.aslPropertyManager.valueChangedString(-672133120, ASLNavigationPoiFactory.getNavigationPoiApi().getSelectedOnlinePoiUrl());
                break;
            }
            case 0: {
                if (ServiceManager.configManagerDiag.getNaviCommonOptionDefaultBoolean(9)) break;
                ServiceManager.aslPropertyManager.valueChangedInteger(-1376776192, 0);
                break;
            }
            default: {
                ServiceManager.aslPropertyManager.valueChangedInteger(-1376776192, 0);
            }
        }
        ServiceManager.aslPropertyManager.valueChangedFixFormatterFieldData(-1343221760, fixFormatterFieldDataImpl);
        NavLocation navLocation2 = ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getSoPosPositionDescription();
        int n = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().calculateDirectionIndex(navLocation2.getLongitude(), navLocation2.getLatitude(), iLocationWrapper.getLongitude(), iLocationWrapper.getLatitude(), ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getSoPosPosition().getDirectionAngle());
        ServiceManager.aslPropertyManager.valueChangedInteger(-1309667328, n);
        int n2 = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().calculateDistance(navLocation2.getLongitude(), navLocation2.getLatitude(), iLocationWrapper.getLongitude(), iLocationWrapper.getLatitude());
        ServiceManager.aslPropertyManager.valueChangedInteger(-1292890112, n2);
        if (iLocationWrapper.getLocationType() == 3) {
            LocationFormatter$1 locationFormatter$1 = new LocationFormatter$1();
            int n3 = -2;
            ServiceManager.aslPropertyManager.valueChangedResourceLocator(-1326444544, ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForPOIIcon(iLocationWrapper.getIconIndex(), iLocationWrapper.getSubIconIndex(), 0, locationFormatter$1, new Integer(-2)));
        } else {
            ServiceManager.aslPropertyManager.valueChangedResourceLocator(-1326444544, null);
        }
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
        navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_url = "";
        navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_lat_degree = iLocationWrapper.getLatitudeDegrees();
        navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_lat_minutes = iLocationWrapper.getLatitudeMinutes();
        navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_lat_seconds = iLocationWrapper.getLatitudeSeconds();
        navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_lon_degree = iLocationWrapper.getLongitudeDegrees();
        navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_lon_minutes = iLocationWrapper.getLongitudeMinutes();
        navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_lon_seconds = iLocationWrapper.getLongitudeSeconds();
        navigationMemoryDestinationDetailsCollector.navigation_memory_destination_details_for_fix_formatter = LocationFormatter.prepareFixFormatterFieldData(iLocationWrapper);
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
            LocationFormatter$2 locationFormatter$2 = new LocationFormatter$2();
            navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_poi_icon = ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForPOIIcon(iLocationWrapper.getIconIndex(), iLocationWrapper.getSubIconIndex(), 0, locationFormatter$2, navigationMemoryDestinationDetailsCollector);
        } else {
            navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_poi_icon = null;
        }
        return navigationMemoryDestinationDetailsCollector;
    }

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
        navigationMemoryDestinationDetailsCollector.navigation_memory_destination_details_for_fix_formatter = LocationFormatter.prepareFixFormatterFieldData(addressData, string, iLocationWrapper);
        return navigationMemoryDestinationDetailsCollector;
    }

    public static NavigationMemoryDestinationDetailsCollector createMemoryDestinationDetails(NavLocation navLocation, String string) {
        return LocationFormatter.createMemoryDestinationDetails(ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation), string);
    }

    private static void put(FixFormatterFieldDataImpl fixFormatterFieldDataImpl, String string, String string2) {
        if (string2 != null && string2.length() > 0) {
            fixFormatterFieldDataImpl.put(string, string2);
        }
    }

    private static void putHighlightData(FixFormatterFieldDataImpl fixFormatterFieldDataImpl, Highlight[] highlightArray, String string) {
        if (highlightArray != null && highlightArray.length > 0) {
            int[][] nArray = new int[highlightArray.length][3];
            for (int i2 = 0; i2 < highlightArray.length; ++i2) {
                nArray[i2][0] = highlightArray[i2].highlightStart;
                nArray[i2][1] = highlightArray[i2].highlightEnd;
                nArray[i2][2] = highlightArray[i2].type;
            }
            fixFormatterFieldDataImpl.put2dIntArray(string, nArray);
        }
    }

    public static FixFormatterFieldData prepareFixFormatterFieldData(SearchResult searchResult) {
        Object object;
        boolean bl;
        FixFormatterFieldDataImpl fixFormatterFieldDataImpl = new FixFormatterFieldDataImpl();
        boolean bl2 = bl = searchResult.source == -100;
        if (searchResult.position != null) {
            double[] dArray = NaviHelper.getInstance().decimalToDegMinSec(searchResult.position.getLat());
            object = NaviHelper.getInstance().decimalToDegMinSec(searchResult.position.getLon());
            fixFormatterFieldDataImpl.put("LatitudeDegrees", (int)dArray[0]);
            fixFormatterFieldDataImpl.put("LatitudeMinutes", (int)dArray[1]);
            fixFormatterFieldDataImpl.put("LatitudeSeconds", (int)(dArray[2] * 10.0));
            fixFormatterFieldDataImpl.put("LongitudeDegrees", (int)object[0]);
            fixFormatterFieldDataImpl.put("LongitudeMinutes", (int)object[1]);
            fixFormatterFieldDataImpl.put("LongitudeSeconds", (int)(object[2] * 10.0));
        }
        if (searchResult.country != null && searchResult.country.code != null) {
            fixFormatterFieldDataImpl.put("CountryCode", searchResult.country.code);
        }
        if (searchResult.entryType == 16) {
            fixFormatterFieldDataImpl.put("isCityCenter", true);
        }
        if (searchResult.entryType == 64) {
            fixFormatterFieldDataImpl.put("isCityPart", true);
        }
        if (bl || searchResult.source == -101) {
            fixFormatterFieldDataImpl.put("isLastDest", true);
        } else {
            fixFormatterFieldDataImpl.put("isLastDest", false);
        }
        if (ASLNavigationTruffelFactory.getNavigationTruffelApi() != null) {
            int n = ASLNavigationTruffelFactory.getNavigationTruffelApi().getLastDestsGeoPos();
            if (searchResult.getSource() == n) {
                fixFormatterFieldDataImpl.put("isDSITypeGeoPos", true);
            } else {
                fixFormatterFieldDataImpl.put("isDSITypeGeoPos", false);
            }
        } else {
            fixFormatterFieldDataImpl.put("isDSITypeGeoPos", false);
        }
        if (searchResult.tokens != null) {
            block5: for (int i2 = 0; i2 < searchResult.tokens.length; ++i2) {
                if (searchResult.tokens[i2] == null || (object = (Object)((String)LocationFormatter.getTokenWordtypeTable(bl).get(new Integer(searchResult.tokens[i2].wordType)))) == null || fixFormatterFieldDataImpl.contains((String)object)) continue;
                LocationFormatter.put(fixFormatterFieldDataImpl, (String)object, searchResult.tokens[i2].token);
                LocationFormatter.putHighlightData(fixFormatterFieldDataImpl, searchResult.tokens[i2].highlights, new StringBuffer().append((String)object).append(".hi").toString());
                switch (searchResult.tokens[i2].wordType) {
                    case 2: {
                        if (!bl) {
                            LocationFormatter.put(fixFormatterFieldDataImpl, "CityPart", searchResult.tokens[i2].token);
                            LocationFormatter.putHighlightData(fixFormatterFieldDataImpl, searchResult.tokens[i2].highlights, "CityPart.hi");
                        }
                        LocationFormatter.put(fixFormatterFieldDataImpl, "Place", searchResult.tokens[i2].token);
                        LocationFormatter.putHighlightData(fixFormatterFieldDataImpl, searchResult.tokens[i2].highlights, "Place.hi");
                        continue block5;
                    }
                    case 4: {
                        LocationFormatter.put(fixFormatterFieldDataImpl, "Ward", searchResult.tokens[i2].token);
                        LocationFormatter.putHighlightData(fixFormatterFieldDataImpl, searchResult.tokens[i2].highlights, "Ward.hi");
                        continue block5;
                    }
                    case 3: {
                        LocationFormatter.put(fixFormatterFieldDataImpl, "Chome", searchResult.tokens[i2].token);
                        LocationFormatter.putHighlightData(fixFormatterFieldDataImpl, searchResult.tokens[i2].highlights, "Chome.hi");
                        continue block5;
                    }
                }
            }
        }
        return fixFormatterFieldDataImpl;
    }

    public static FixFormatterFieldData prepareFixFormatterFieldData(ILocationWrapper iLocationWrapper) {
        FixFormatterFieldDataImpl fixFormatterFieldDataImpl = new FixFormatterFieldDataImpl();
        LocationFormatter.put(fixFormatterFieldDataImpl, "Country", iLocationWrapper.getCountry());
        LocationFormatter.put(fixFormatterFieldDataImpl, "CountryCode", iLocationWrapper.getCountryCode());
        LocationFormatter.put(fixFormatterFieldDataImpl, "State", iLocationWrapper.getState());
        LocationFormatter.put(fixFormatterFieldDataImpl, "StateAbbreviation", iLocationWrapper.getStateAbbreviation());
        LocationFormatter.put(fixFormatterFieldDataImpl, "City", iLocationWrapper.getCity());
        LocationFormatter.put(fixFormatterFieldDataImpl, "CityRefinement", iLocationWrapper.getCityRefinement());
        LocationFormatter.put(fixFormatterFieldDataImpl, "Place", iLocationWrapper.getPlace());
        LocationFormatter.put(fixFormatterFieldDataImpl, "MapCode", iLocationWrapper.getMapCode());
        LocationFormatter.put(fixFormatterFieldDataImpl, "Crossing", iLocationWrapper.getCrossing());
        LocationFormatter.put(fixFormatterFieldDataImpl, "Housenumber", iLocationWrapper.getHousenumber());
        LocationFormatter.put(fixFormatterFieldDataImpl, "PoiCategory", iLocationWrapper.getPoiCategory());
        LocationFormatter.put(fixFormatterFieldDataImpl, "URLAddress", iLocationWrapper.getURLAddress());
        LocationFormatter.put(fixFormatterFieldDataImpl, "PostalCode", iLocationWrapper.getPostalCode());
        LocationFormatter.put(fixFormatterFieldDataImpl, "Street", iLocationWrapper.getStreet());
        LocationFormatter.put(fixFormatterFieldDataImpl, "StreetNearby", iLocationWrapper.getStreetNearby());
        LocationFormatter.put(fixFormatterFieldDataImpl, "StreetRefinement", iLocationWrapper.getStreetRefinement());
        LocationFormatter.put(fixFormatterFieldDataImpl, "CustomName", iLocationWrapper.getMmiInternalDataValue(1));
        fixFormatterFieldDataImpl = LocationFormatter.prepareFixFormatterFieldData(iLocationWrapper, fixFormatterFieldDataImpl);
        fixFormatterFieldDataImpl.put("isCityCenter", iLocationWrapper.isCityCenter());
        fixFormatterFieldDataImpl.put("isPostalCodeSpelled", iLocationWrapper.isPostalCodeSpelled());
        fixFormatterFieldDataImpl.put("isStateSpelled", iLocationWrapper.isStateSpelled());
        fixFormatterFieldDataImpl.put("isStreetBasename", iLocationWrapper.isStreetBasename());
        fixFormatterFieldDataImpl.put("isTownorder9", iLocationWrapper.isTownorder9());
        fixFormatterFieldDataImpl.put("isDSITypeGeoPos", iLocationWrapper.getLocationDSIType() == 2);
        fixFormatterFieldDataImpl.put("isFullPostalCode", iLocationWrapper.isFullPostalCode());
        String string = iLocationWrapper.getPhonenumber();
        String string2 = iLocationWrapper.getPoiName();
        LocationFormatter.put(fixFormatterFieldDataImpl, "Phonenumber", string);
        LocationFormatter.put(fixFormatterFieldDataImpl, "PoiName", string2);
        LocationFormatter.put(fixFormatterFieldDataImpl, "Ward", iLocationWrapper.getWard());
        LocationFormatter.put(fixFormatterFieldDataImpl, "Chome", iLocationWrapper.getChome());
        LocationFormatter.put(fixFormatterFieldDataImpl, "Place", iLocationWrapper.getPlace());
        LocationFormatter.put(fixFormatterFieldDataImpl, "Provider", iLocationWrapper.getChargingStationProvider());
        LocationFormatter.put(fixFormatterFieldDataImpl, "Pay", Integer.toString(iLocationWrapper.getChargingStationPay()));
        LocationFormatter.put(fixFormatterFieldDataImpl, "Subscription", Integer.toString(iLocationWrapper.getChargingStationSubscription()));
        LocationFormatter.put(fixFormatterFieldDataImpl, "Access", Integer.toString(iLocationWrapper.getChargingStationAccess()));
        LocationFormatter.put(fixFormatterFieldDataImpl, "Open24h", Integer.toString(iLocationWrapper.getChargingStationOpen24h()));
        return fixFormatterFieldDataImpl;
    }

    public static FixFormatterFieldData prepareFixFormatterFieldData(ILocationWrapper iLocationWrapper, String string, String string2) {
        FixFormatterFieldDataImpl fixFormatterFieldDataImpl = (FixFormatterFieldDataImpl)LocationFormatter.prepareFixFormatterFieldData(iLocationWrapper);
        if (string != null) {
            LocationFormatter.put(fixFormatterFieldDataImpl, "PoiName", string);
        }
        if (string2 != null) {
            LocationFormatter.put(fixFormatterFieldDataImpl, "Phonenumber", string2);
        }
        return fixFormatterFieldDataImpl;
    }

    private static String replaceDigitsByCharZ(String string) {
        for (int i2 = 0; i2 <= 9; ++i2) {
            string = string.replace(digits[i2], 'Z');
        }
        return string;
    }

    private static int countNonZchars(String string, int n) {
        int n2 = 0;
        int n3 = 0;
        for (int i2 = 0; i2 < string.length() && n3 < n; ++i2) {
            if (string.charAt(i2) != 'Z') {
                ++n2;
                continue;
            }
            ++n3;
        }
        return n2;
    }

    private static int getNonDigitCount(String string, int n) {
        int n2;
        block2: {
            n2 = 0;
            try {
                string = LocationFormatter.replaceDigitsByCharZ(string);
                n2 = LocationFormatter.countNonZchars(string, n);
            }
            catch (Exception exception) {
                if (!logger.isTraceEnabled()) break block2;
                logger.trace("getNonDigitCount exception");
            }
        }
        return n2;
    }

    public static FixFormatterFieldData prepareFixFormatterFieldData(ILocationWrapper iLocationWrapper, String string, String string2, String string3) {
        FixFormatterFieldDataImpl fixFormatterFieldDataImpl = (FixFormatterFieldDataImpl)LocationFormatter.prepareFixFormatterFieldData(iLocationWrapper, string, string2);
        if (string3 != null) {
            Highlight highlight = new Highlight(0, string3.length() + LocationFormatter.getNonDigitCount(string2, string3.length()), 0);
            LocationFormatter.putHighlightData(fixFormatterFieldDataImpl, new Highlight[]{highlight}, "Phonenumber.hi");
        }
        return fixFormatterFieldDataImpl;
    }

    public static FixFormatterFieldData prepareFixFormatterFieldData(AddressData addressData, String string, ILocationWrapper iLocationWrapper) {
        FixFormatterFieldDataImpl fixFormatterFieldDataImpl = new FixFormatterFieldDataImpl();
        LocationFormatter.put(fixFormatterFieldDataImpl, "Country", addressData.getCountry());
        LocationFormatter.put(fixFormatterFieldDataImpl, "State", addressData.getRegion());
        LocationFormatter.put(fixFormatterFieldDataImpl, "City", addressData.getLocality());
        LocationFormatter.put(fixFormatterFieldDataImpl, "PostalCode", addressData.getPostalCode());
        LocationFormatter.put(fixFormatterFieldDataImpl, "Street", addressData.getStreet());
        LocationFormatter.put(fixFormatterFieldDataImpl, "CustomName", string);
        fixFormatterFieldDataImpl = LocationFormatter.prepareFixFormatterFieldData(iLocationWrapper, fixFormatterFieldDataImpl);
        LocationFormatter.put(fixFormatterFieldDataImpl, "Phonenumber", iLocationWrapper == null ? null : iLocationWrapper.getPhonenumber());
        return fixFormatterFieldDataImpl;
    }

    private static FixFormatterFieldDataImpl prepareFixFormatterFieldData(ILocationWrapper iLocationWrapper, FixFormatterFieldDataImpl fixFormatterFieldDataImpl) {
        FixFormatterFieldDataImpl fixFormatterFieldDataImpl2 = fixFormatterFieldDataImpl != null ? fixFormatterFieldDataImpl : new FixFormatterFieldDataImpl();
        int n = iLocationWrapper != null ? iLocationWrapper.getLatitudeDegrees() : 0;
        int n2 = iLocationWrapper != null ? iLocationWrapper.getLatitudeMinutes() : 0;
        int n3 = iLocationWrapper != null ? iLocationWrapper.getLatitudeSeconds() : 0;
        int n4 = iLocationWrapper != null ? iLocationWrapper.getLongitudeDegrees() : 0;
        int n5 = iLocationWrapper != null ? iLocationWrapper.getLongitudeMinutes() : 0;
        int n6 = iLocationWrapper != null ? iLocationWrapper.getLongitudeSeconds() : 0;
        fixFormatterFieldDataImpl2.put("LatitudeDegrees", n);
        fixFormatterFieldDataImpl2.put("LatitudeMinutes", n2);
        fixFormatterFieldDataImpl2.put("LatitudeSeconds", n3);
        fixFormatterFieldDataImpl2.put("LatitudeDeciSeconds", n3);
        fixFormatterFieldDataImpl2.put("LongitudeDegrees", n4);
        fixFormatterFieldDataImpl2.put("LongitudeMinutes", n5);
        fixFormatterFieldDataImpl2.put("LongitudeSeconds", n6);
        fixFormatterFieldDataImpl2.put("LongitudeDeciSeconds", n6);
        return fixFormatterFieldDataImpl2;
    }

    public static void fillHomeAddressGetter(NavLocation navLocation) {
        ILocationWrapper iLocationWrapper;
        if (navLocation != null) {
            iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation);
            ServiceManager.aslPropertyManager.valueChangedBoolean(836, true);
        } else {
            iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper();
            ServiceManager.aslPropertyManager.valueChangedBoolean(836, false);
        }
        String string = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationFormatter().createDetailString(7, navLocation);
        ServiceManager.aslPropertyManager.valueChangedString(834, string);
        ServiceManager.aslPropertyManager.valueChangedString(835, string);
        NavigationHomeDestInputHomeDestinationDetailCollector navigationHomeDestInputHomeDestinationDetailCollector = (NavigationHomeDestInputHomeDestinationDetailCollector)ListManager.getGenericASLList(837).getRowItemCacheOnly(0);
        if (navigationHomeDestInputHomeDestinationDetailCollector != null) {
            navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_home_destination_detail_city = iLocationWrapper.getCity();
            navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_home_destination_detail_city_refinement = iLocationWrapper.getCityRefinement();
            navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_home_destination_detail_country_code = iLocationWrapper.getCountryCode();
            navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_home_destination_detail_cross = iLocationWrapper.getCrossing();
            navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_home_destination_detail_hno = iLocationWrapper.getHousenumber();
            navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_current_dest_data_lat_degree = iLocationWrapper.getLatitudeDegrees();
            navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_current_dest_data_lat_minutes = iLocationWrapper.getLatitudeMinutes();
            navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_home_destination_detail_lat_seconds = iLocationWrapper.getLatitudeSeconds();
            navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_home_destination_detail_lon_degree = iLocationWrapper.getLatitudeDegrees();
            navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_home_destination_detail_lon_minutes = iLocationWrapper.getLongitudeMinutes();
            navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_home_destination_detail_lon_seconds = iLocationWrapper.getLongitudeSeconds();
            navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_home_destination_detail_street = iLocationWrapper.getStreet();
            navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_home_destination_detail_street_refinement = iLocationWrapper.getStreetRefinement();
            navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_home_destination_detail_zip = iLocationWrapper.getPostalCode();
            navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_home_destination_detail_address_for_fix_formatter = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationFormatter().prepareFixFormatterFieldData(iLocationWrapper);
            try {
                navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_home_destination_detail_full_postal_code = iLocationWrapper.isFullPostalCode();
            }
            catch (Throwable throwable) {
                navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_home_destination_detail_full_postal_code = false;
                ServiceManager.errorHandler.handleError(throwable);
            }
            try {
                navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_home_destination_detail_postal_code_spelled = iLocationWrapper.isPostalCodeSpelled();
            }
            catch (Throwable throwable) {
                navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_home_destination_detail_postal_code_spelled = false;
                ServiceManager.errorHandler.handleError(throwable);
            }
        }
    }

    static {
        digits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    }
}

