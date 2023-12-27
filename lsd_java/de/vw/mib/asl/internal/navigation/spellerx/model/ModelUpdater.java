/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.spellerx.model;

import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.NavigationConfiguration;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.spellerx.SpellerContext;
import de.vw.mib.asl.internal.navigation.spellerx.XSpellerTarget;
import de.vw.mib.asl.internal.navigation.spellerx.model.ModelUpdater$1;
import de.vw.mib.properties.values.SpellerData;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.city.transformer.NavigationLocationInputInputFieldCityListInfoCollector;
import generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.country.transformer.NavigationLocationInputInputFieldCountryListInfoCollector;
import generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.crossing.transformer.NavigationLocationInputInputFieldCrossingListInfoCollector;
import generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.housenumber.transformer.NavigationLocationInputInputFieldHousenumberListInfoCollector;
import generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.mapcode.transformer.NavigationLocationInputInputFieldMapcodeListInfoCollector;
import generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.phonenumber.transformer.NavigationLocationInputInputFieldPhonenumberListInfoCollector;
import generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.postalcode.transformer.NavigationLocationInputInputFieldPostalCodeListInfoCollector;
import generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.province.transformer.NavigationLocationInputInputFieldProvinceListInfoCollector;
import generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.state.transformer.NavigationLocationInputInputFieldStateListInfoCollector;
import generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.street.transformer.NavigationLocationInputInputFieldStreetListInfoCollector;
import generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.streetwithbasenames.transformer.NavigationLocationInputInputFieldStreetWithBasenamesListInfoCollector;
import generated.de.vw.mib.asl.internal.navigation.locationinput.transformer.NavigationLocationInputLocationCollector;
import generated.de.vw.mib.asl.internal.navigation.locationinput.transformer.NavigationLocationInputNextRefinementsCollector;
import org.dsi.ifc.global.NavLocation;

public class ModelUpdater {
    public static final int FIELDFORMAT_DEFAULT;
    public static final int FIELDFORMAT_NUMERIC;
    public static final int FIELDFORMAT_ALPHANUMERIC;

    public static void updateSpellerData(SpellerData spellerData, int n) {
        boolean bl = spellerData.getEnteredText() != null && spellerData.getEnteredText().length() > 0;
        switch (n) {
            case 1: {
                ModelUpdater.updateSpellerDataAndCharEntered(3023, spellerData, 3025, bl);
                break;
            }
            case 9: 
            case 13: {
                ModelUpdater.updateSpellerDataAndCharEntered(3029, spellerData, 3031, bl);
                break;
            }
            case 8: {
                ModelUpdater.updateSpellerDataAndCharEntered(3035, spellerData, 3037, bl);
                break;
            }
            case 2: {
                ModelUpdater.updateSpellerDataAndCharEntered(3048, spellerData, 3050, bl);
                break;
            }
            case 3: {
                ModelUpdater.updateSpellerDataAndCharEntered(3055, spellerData, 3057, bl);
                break;
            }
            case 10: {
                ModelUpdater.updateSpellerDataAndCharEntered(3436, spellerData, 3438, bl);
                break;
            }
            case 7: {
                ModelUpdater.updateSpellerDataAndCharEntered(3062, spellerData, 3064, bl);
                break;
            }
            case 4: {
                ModelUpdater.updateSpellerDataAndCharEntered(3075, spellerData, 3077, bl);
                break;
            }
            case 5: {
                ModelUpdater.updateSpellerDataAndCharEntered(3068, spellerData, 3070, bl);
                break;
            }
            case 6: 
            case 12: {
                ModelUpdater.updateSpellerDataAndCharEntered(3042, spellerData, 3044, bl);
                break;
            }
            case 15: {
                ModelUpdater.updateSpellerDataAndCharEntered(-907014144, spellerData, -873459712, bl);
                break;
            }
            case 14: {
                ModelUpdater.updateSpellerDataAndCharEntered(-974123008, spellerData, -940568576, bl);
                break;
            }
        }
    }

    private static void updateSpellerDataAndCharEntered(int n, SpellerData spellerData, int n2, boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedSpellerData(n, spellerData);
        ServiceManager.aslPropertyManager.valueChangedBoolean(n2, bl);
    }

    public static void updateLocationInputActionResult(boolean bl) {
        if (ServiceManager.logger.isTraceEnabled(16384)) {
            ServiceManager.logger.trace(16384).append("updateLocationInputActionResult(").append(bl).append(")").log();
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(2827, bl ? 0 : 1);
    }

    public static void updateHomeDestInputActionResult(boolean bl) {
        if (ServiceManager.logger.isTraceEnabled(16384)) {
            ServiceManager.logger.trace(16384).append("updateHomeDestInputActionResult(").append(bl).append(")").log();
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(2933, bl ? 0 : 1);
    }

    public static void updateLocationInputInputFieldActionResult(boolean bl) {
        if (ServiceManager.logger.isTraceEnabled(16384)) {
            ServiceManager.logger.trace(16384).append("updateLocationInputInputFieldActionResult(").append(bl).append(")").log();
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(2831, bl ? 0 : 1);
    }

    public static void updateNextAvailableCriterions(int[] nArray, NavLocation navLocation, XSpellerTarget xSpellerTarget) {
        Object object;
        boolean bl = false;
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        boolean bl5 = false;
        boolean bl6 = false;
        boolean bl7 = false;
        boolean bl8 = false;
        boolean bl9 = false;
        boolean bl10 = false;
        boolean bl11 = false;
        if (nArray == null) {
            ServiceManager.logger.error(16384).append("No nextAvailableCriterions are being received").log();
        } else {
            object = null;
            if (ServiceManager.logger.isTraceEnabled(16384)) {
                object = ServiceManager.logger.trace(16384).append("updateNextAvailableCriterions([");
            }
            block15: for (int i2 = 0; i2 < nArray.length; ++i2) {
                if (ServiceManager.logger.isTraceEnabled(16384) && object != null) {
                    object = object.append(nArray[i2]).append(", ");
                }
                switch (nArray[i2]) {
                    case 133: {
                        if (!ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("LICENSE_PLATE_SPELLER_ENABLED") || xSpellerTarget.LOCATIONINPUT_ENABLE_NAR_FEATURES || NavigationConfiguration.LOCATIONINPUT_CHN_FEATURES_AVAILABLE) continue block15;
                        bl6 = true;
                        continue block15;
                    }
                    case 2: {
                        if (NavigationConfiguration.LOCATIONINPUT_JPY_FEATURES_AVAILABLE) {
                            bl6 = true;
                            continue block15;
                        }
                        if (xSpellerTarget.LOCATIONINPUT_ENABLE_NAR_FEATURES || NavigationConfiguration.LOCATIONINPUT_CHN_FEATURES_AVAILABLE) {
                            bl6 = true;
                            continue block15;
                        }
                        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("LICENSE_PLATE_SPELLER_ENABLED")) continue block15;
                        bl6 = true;
                        continue block15;
                    }
                    case 5: {
                        bl = true;
                        continue block15;
                    }
                    case 136: {
                        bl = true;
                        continue block15;
                    }
                    case 4: {
                        bl2 = true;
                        continue block15;
                    }
                    case 144: {
                        bl9 = true;
                        continue block15;
                    }
                    case 3: {
                        bl4 = true;
                        continue block15;
                    }
                    case 147: {
                        bl10 = true;
                        continue block15;
                    }
                    case 6: {
                        bl3 = true;
                        continue block15;
                    }
                    case 127: {
                        bl5 = true;
                        continue block15;
                    }
                    case 141: {
                        bl11 = true;
                        continue block15;
                    }
                    case 152: {
                        bl8 = true;
                        continue block15;
                    }
                    case 138: {
                        bl7 = true;
                        continue block15;
                    }
                }
            }
            if (ServiceManager.logger.isTraceEnabled(16384) && object != null) {
                object.append("], ").append(navLocation.toString()).log();
            }
        }
        object = ListManager.getGenericASLList(2829);
        NavigationLocationInputNextRefinementsCollector navigationLocationInputNextRefinementsCollector = (NavigationLocationInputNextRefinementsCollector)((GenericASLList)object).getRowItem(0);
        navigationLocationInputNextRefinementsCollector.navigation_locationinput_next_refinements_province_available = bl7;
        navigationLocationInputNextRefinementsCollector.navigation_locationinput_next_refinements_city_available = bl6;
        navigationLocationInputNextRefinementsCollector.navigation_locationinput_next_refinements_housenumber_available = bl;
        navigationLocationInputNextRefinementsCollector.navigation_locationinput_next_refinements_housenumber_alternative_available = bl;
        navigationLocationInputNextRefinementsCollector.navigation_locationinput_next_refinements_housenumber_match_or_alternative_available = bl;
        navigationLocationInputNextRefinementsCollector.navigation_locationinput_next_refinements_street_disambiguation_available = bl5;
        navigationLocationInputNextRefinementsCollector.navigation_locationinput_next_refinements_province_needed = true;
        navigationLocationInputNextRefinementsCollector.navigation_locationinput_next_refinements_state_available = bl7;
        navigationLocationInputNextRefinementsCollector.navigation_locationinput_next_refinements_crossing_available = bl2;
        boolean bl12 = navigationLocationInputNextRefinementsCollector.navigation_locationinput_next_refinements_postal_code_available = bl3;
        if (NavigationConfiguration.LOCATIONINPUT_JPY_FEATURES_AVAILABLE) {
            navigationLocationInputNextRefinementsCollector.navigation_locationinput_next_refinements_province_needed = bl7;
            navigationLocationInputNextRefinementsCollector.navigation_locationinput_next_refinements_state_available = bl8;
            navigationLocationInputNextRefinementsCollector.navigation_locationinput_next_refinements_street_available = bl9;
            navigationLocationInputNextRefinementsCollector.navigation_locationinput_next_refinements_crossing_available = bl;
            navigationLocationInputNextRefinementsCollector.navigation_locationinput_next_refinements_postal_code_available = bl10;
        } else if (xSpellerTarget.LOCATIONINPUT_ENABLE_NAR_FEATURES) {
            navigationLocationInputNextRefinementsCollector.navigation_locationinput_next_refinements_street_with_bn_available = navLocation.getTown() != null && !navLocation.getTown().equals("") && bl4;
            navigationLocationInputNextRefinementsCollector.navigation_locationinput_next_refinements_street_available = navLocation.getTown() != null && !navLocation.getTown().equals("") && bl11;
            navigationLocationInputNextRefinementsCollector.navigation_locationinput_next_refinements_state_needed = navLocation != null && navLocation.getCountryAbbreviation() != null && navLocation.getCountryAbbreviation().equals("USA");
        } else {
            navigationLocationInputNextRefinementsCollector.navigation_locationinput_next_refinements_street_available = bl4;
        }
        ((GenericASLList)object).updateListItem(0, navigationLocationInputNextRefinementsCollector);
    }

    public static void updateListCount(int n, int n2) {
        try {
            switch (n2) {
                case 1: {
                    ModelUpdater.updateCountryListCount(n);
                    break;
                }
                case 138: 
                case 152: {
                    ModelUpdater.updateProvinceListCount(n);
                    ModelUpdater.updateStateListCount(n);
                    break;
                }
                case 2: 
                case 133: {
                    ModelUpdater.updateCityListCount(n);
                    break;
                }
                case 3: 
                case 144: {
                    ModelUpdater.updateStreetListCount(n);
                    ModelUpdater.updateStreetListWithBasenamesCount(n);
                    break;
                }
                case 141: {
                    ModelUpdater.updateStreetListCount(n);
                    break;
                }
                case 4: {
                    ModelUpdater.updateCrossingListCount(n);
                    break;
                }
                case 6: 
                case 147: {
                    ModelUpdater.updateZipCodeListCount(n);
                    break;
                }
                case 5: 
                case 136: {
                    if (NavigationConfiguration.LOCATIONINPUT_JPY_FEATURES_AVAILABLE) {
                        ModelUpdater.updateCrossingListCount(n);
                        break;
                    }
                    ModelUpdater.updateHnrListCount(n);
                    break;
                }
                case 142: {
                    ModelUpdater.updateMapcodeListCount(n);
                    break;
                }
                case 8: {
                    ModelUpdater.updatePhonenumber(n);
                    break;
                }
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    private static void updateCountryListCount(int n) {
        GenericASLList genericASLList = ListManager.getGenericASLList(3028);
        NavigationLocationInputInputFieldCountryListInfoCollector navigationLocationInputInputFieldCountryListInfoCollector = (NavigationLocationInputInputFieldCountryListInfoCollector)genericASLList.getRowItem(0);
        navigationLocationInputInputFieldCountryListInfoCollector.navigation_locationinput_inputfield_country_list_info_size = n;
        genericASLList.updateListItem(0, navigationLocationInputInputFieldCountryListInfoCollector);
    }

    private static void updateStateListCount(int n) {
        GenericASLList genericASLList = ListManager.getGenericASLList(3034);
        NavigationLocationInputInputFieldStateListInfoCollector navigationLocationInputInputFieldStateListInfoCollector = (NavigationLocationInputInputFieldStateListInfoCollector)genericASLList.getRowItem(0);
        navigationLocationInputInputFieldStateListInfoCollector.navigation_locationinput_inputfield_state_list_info_size = n;
        genericASLList.updateListItem(0, navigationLocationInputInputFieldStateListInfoCollector);
    }

    private static void updateZipCodeListCount(int n) {
        GenericASLList genericASLList = ListManager.getGenericASLList(3047);
        NavigationLocationInputInputFieldPostalCodeListInfoCollector navigationLocationInputInputFieldPostalCodeListInfoCollector = (NavigationLocationInputInputFieldPostalCodeListInfoCollector)genericASLList.getRowItem(0);
        navigationLocationInputInputFieldPostalCodeListInfoCollector.navigation_locationinput_inputfield_postalcode_list_info_size = n;
        genericASLList.updateListItem(0, navigationLocationInputInputFieldPostalCodeListInfoCollector);
    }

    private static void updateCrossingListCount(int n) {
        GenericASLList genericASLList = ListManager.getGenericASLList(3074);
        NavigationLocationInputInputFieldCrossingListInfoCollector navigationLocationInputInputFieldCrossingListInfoCollector = (NavigationLocationInputInputFieldCrossingListInfoCollector)genericASLList.getRowItem(0);
        navigationLocationInputInputFieldCrossingListInfoCollector.navigation_locationinput_inputfield_crossing_list_info_size = n;
        genericASLList.updateListItem(0, navigationLocationInputInputFieldCrossingListInfoCollector);
    }

    private static void updateStreetListCount(int n) {
        GenericASLList genericASLList = ListManager.getGenericASLList(3061);
        NavigationLocationInputInputFieldStreetListInfoCollector navigationLocationInputInputFieldStreetListInfoCollector = (NavigationLocationInputInputFieldStreetListInfoCollector)genericASLList.getRowItem(0);
        navigationLocationInputInputFieldStreetListInfoCollector.navigation_locationinput_inputfield_street_list_info_size = n;
        genericASLList.updateListItem(0, navigationLocationInputInputFieldStreetListInfoCollector);
    }

    private static void updateStreetListWithBasenamesCount(int n) {
        GenericASLList genericASLList = ListManager.getGenericASLList(3442);
        NavigationLocationInputInputFieldStreetWithBasenamesListInfoCollector navigationLocationInputInputFieldStreetWithBasenamesListInfoCollector = (NavigationLocationInputInputFieldStreetWithBasenamesListInfoCollector)genericASLList.getRowItem(0);
        navigationLocationInputInputFieldStreetWithBasenamesListInfoCollector.navigation_locationinput_inputfield_streetwithbasenames_list_info_size = n;
        genericASLList.updateListItem(0, navigationLocationInputInputFieldStreetWithBasenamesListInfoCollector);
    }

    private static void updateCityListCount(int n) {
        GenericASLList genericASLList = ListManager.getGenericASLList(3054);
        NavigationLocationInputInputFieldCityListInfoCollector navigationLocationInputInputFieldCityListInfoCollector = (NavigationLocationInputInputFieldCityListInfoCollector)genericASLList.getRowItem(0);
        navigationLocationInputInputFieldCityListInfoCollector.navigation_locationinput_inputfield_city_list_info_size = n;
        genericASLList.updateListItem(0, navigationLocationInputInputFieldCityListInfoCollector);
    }

    private static void updateProvinceListCount(int n) {
        GenericASLList genericASLList = ListManager.getGenericASLList(3041);
        NavigationLocationInputInputFieldProvinceListInfoCollector navigationLocationInputInputFieldProvinceListInfoCollector = (NavigationLocationInputInputFieldProvinceListInfoCollector)genericASLList.getRowItem(0);
        navigationLocationInputInputFieldProvinceListInfoCollector.navigation_locationinput_inputfield_province_list_info_size = n;
        genericASLList.updateListItem(0, navigationLocationInputInputFieldProvinceListInfoCollector);
    }

    private static void updateHnrListCount(int n) {
        GenericASLList genericASLList = ListManager.getGenericASLList(3080);
        NavigationLocationInputInputFieldHousenumberListInfoCollector navigationLocationInputInputFieldHousenumberListInfoCollector = (NavigationLocationInputInputFieldHousenumberListInfoCollector)genericASLList.getRowItem(0);
        navigationLocationInputInputFieldHousenumberListInfoCollector.navigation_locationinput_inputfield_housenumber_list_info_size = n;
        genericASLList.updateListItem(0, navigationLocationInputInputFieldHousenumberListInfoCollector);
    }

    private static void updatePhonenumber(int n) {
        GenericASLList genericASLList = ListManager.getGenericASLList(-923791360);
        NavigationLocationInputInputFieldPhonenumberListInfoCollector navigationLocationInputInputFieldPhonenumberListInfoCollector = (NavigationLocationInputInputFieldPhonenumberListInfoCollector)genericASLList.getRowItem(0);
        navigationLocationInputInputFieldPhonenumberListInfoCollector.navigation_locationinput_inputfield_phonenumber_list_info_size = n;
        genericASLList.updateListItem(0, navigationLocationInputInputFieldPhonenumberListInfoCollector);
    }

    private static void updateMapcodeListCount(int n) {
        GenericASLList genericASLList = ListManager.getGenericASLList(-856682496);
        NavigationLocationInputInputFieldMapcodeListInfoCollector navigationLocationInputInputFieldMapcodeListInfoCollector = (NavigationLocationInputInputFieldMapcodeListInfoCollector)genericASLList.getRowItem(0);
        navigationLocationInputInputFieldMapcodeListInfoCollector.navigation_locationinput_inputfield_mapcode_list_info_size = n;
        genericASLList.updateListItem(0, navigationLocationInputInputFieldMapcodeListInfoCollector);
    }

    public static void updateLocation(NavLocation navLocation, XSpellerTarget xSpellerTarget) {
        GenericASLList genericASLList = ListManager.getGenericASLList(2830);
        NavigationLocationInputLocationCollector navigationLocationInputLocationCollector = (NavigationLocationInputLocationCollector)genericASLList.getRowItem(0);
        if (navLocation != null) {
            ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation);
            navigationLocationInputLocationCollector.navigation_locationinput_location_country_code = iLocationWrapper.getCountryCode();
            navigationLocationInputLocationCollector.navigation_locationinput_location_iso_country_code = iLocationWrapper.getIsoCountryCode();
            navigationLocationInputLocationCollector.navigation_locationinput_location_country = iLocationWrapper.getCountry();
            navigationLocationInputLocationCollector.navigation_locationinput_location_province = iLocationWrapper.getState();
            navigationLocationInputLocationCollector.navigation_locationinput_location_state = NavigationConfiguration.LOCATIONINPUT_JPY_FEATURES_AVAILABLE ? iLocationWrapper.getWard() : iLocationWrapper.getState();
            navigationLocationInputLocationCollector.navigation_locationinput_location_city = iLocationWrapper.getCity();
            navigationLocationInputLocationCollector.navigation_locationinput_location_city_refinement = iLocationWrapper.getCityRefinement();
            navigationLocationInputLocationCollector.navigation_locationinput_location_city_center = iLocationWrapper.isCityCenter();
            navigationLocationInputLocationCollector.navigation_locationinput_location_street = iLocationWrapper.getStreet();
            navigationLocationInputLocationCollector.navigation_locationinput_location_street_refinement = iLocationWrapper.getStreetRefinement();
            navigationLocationInputLocationCollector.navigation_locationinput_location_postal_code = NavigationConfiguration.LOCATIONINPUT_JPY_FEATURES_AVAILABLE ? iLocationWrapper.getPlace() : iLocationWrapper.getPostalCode();
            navigationLocationInputLocationCollector.navigation_locationinput_location_full_postal_code = iLocationWrapper.isFullPostalCode();
            navigationLocationInputLocationCollector.navigation_locationinput_location_postal_code_spelled = iLocationWrapper.isPostalCodeSpelled();
            navigationLocationInputLocationCollector.navigation_locationinput_location_crossing = iLocationWrapper.getCrossing();
            navigationLocationInputLocationCollector.navigation_locationinput_location_housenumber = iLocationWrapper.getHousenumber();
            navigationLocationInputLocationCollector.navigation_locationinput_location_guideable = iLocationWrapper.isNavigable();
            navigationLocationInputLocationCollector.navigation_locationinput_location_lat_degree = iLocationWrapper.getLatitudeDegrees();
            navigationLocationInputLocationCollector.navigation_locationinput_location_lat_minutes = iLocationWrapper.getLatitudeMinutes();
            navigationLocationInputLocationCollector.navigation_locationinput_location_lat_seconds = iLocationWrapper.getLatitudeSeconds();
            navigationLocationInputLocationCollector.navigation_locationinput_location_lon_degree = iLocationWrapper.getLongitudeDegrees();
            navigationLocationInputLocationCollector.navigation_locationinput_location_lon_minutes = iLocationWrapper.getLongitudeMinutes();
            navigationLocationInputLocationCollector.navigation_locationinput_location_lon_seconds = iLocationWrapper.getLongitudeSeconds();
            navigationLocationInputLocationCollector.navigation_locationinput_location_address_details_for_fix_formatter = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationFormatter().prepareFixFormatterFieldData(iLocationWrapper);
            Integer n = new Integer(-2000);
            navigationLocationInputLocationCollector.navigation_locationinput_location_country_icon = ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForCountryIcon(iLocationWrapper.getCountryIconIndex(), 1, new ModelUpdater$1(navigationLocationInputLocationCollector), n);
            navigationLocationInputLocationCollector.navigation_locationinput_location_empty = navLocation.getCountry() != null && navLocation.getCountry().equals("") ? true : navLocation.getCountryAbbreviation() != null && navLocation.getCountryAbbreviation().equals("USA") && iLocationWrapper.getState().equals("");
            if (NavigationConfiguration.LOCATIONINPUT_JPY_FEATURES_AVAILABLE) {
                navigationLocationInputLocationCollector.navigation_locationinput_location_province = iLocationWrapper.getProvince();
                navigationLocationInputLocationCollector.navigation_locationinput_location_city = iLocationWrapper.getCity();
                navigationLocationInputLocationCollector.navigation_locationinput_location_state = iLocationWrapper.getWard();
                navigationLocationInputLocationCollector.navigation_locationinput_location_postal_code = iLocationWrapper.getPlace();
                navigationLocationInputLocationCollector.navigation_locationinput_location_street = iLocationWrapper.getChome();
                navigationLocationInputLocationCollector.navigation_locationinput_location_crossing = iLocationWrapper.getHousenumber();
            }
        } else {
            xSpellerTarget.getLogger().makeError().append("Cannot update location because it is null!").log();
            return;
        }
        genericASLList.updateListItem(0, navigationLocationInputLocationCollector);
        if (xSpellerTarget.getLogger().isTraceEnabled()) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getExtLoggerHelper().appendLocation(xSpellerTarget.getLogger().makeTrace().append(" SPELLER>   updated location: "), navLocation).log();
        }
    }

    public static void updateLocationResolved(boolean bl) {
        GenericASLList genericASLList = ListManager.getGenericASLList(2830);
        NavigationLocationInputLocationCollector navigationLocationInputLocationCollector = (NavigationLocationInputLocationCollector)genericASLList.getRowItem(0);
        navigationLocationInputLocationCollector.navigation_locationinput_location_resolved = bl;
        genericASLList.updateListItem(0, navigationLocationInputLocationCollector);
    }

    public static void updateNearestHousenumber(String string) {
        ServiceManager.aslPropertyManager.valueChangedString(-135327744, string);
    }

    public static void updatePointLocationGetter(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(-152104960, bl);
    }

    public static void setHousenumberSpellerToUse(int[] nArray, XSpellerTarget xSpellerTarget) {
        if (nArray == null) {
            ModelUpdater.setDefaultHousenumberSpeller(xSpellerTarget);
            xSpellerTarget.getLogger().makeError().append("Usefulrefinements are null.");
            return;
        }
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (nArray[i2] == 136) {
                ModelUpdater.setDefaultHousenumberSpeller(xSpellerTarget);
                return;
            }
            if (nArray[i2] != 5) continue;
            ModelUpdater.setPointLocationHousenumberSpeller(xSpellerTarget);
            return;
        }
        ModelUpdater.setDefaultHousenumberSpeller(xSpellerTarget);
        xSpellerTarget.getLogger().makeError().append("Fallback to default hnr speller. No housenumber speller available in usefulrefinementcriteria");
    }

    private static void setDefaultHousenumberSpeller(XSpellerTarget xSpellerTarget) {
        if (xSpellerTarget.getLogger().isTraceEnabled()) {
            xSpellerTarget.getLogger().makeTrace().append("Enable default hnr speller").log();
        }
        SpellerContext.isPointLocation = false;
        ModelUpdater.updatePointLocationGetter(false);
    }

    private static void setPointLocationHousenumberSpeller(XSpellerTarget xSpellerTarget) {
        if (xSpellerTarget.getLogger().isTraceEnabled()) {
            xSpellerTarget.getLogger().makeTrace().append("Enable nvc hnr speller").log();
        }
        SpellerContext.isPointLocation = true;
        ModelUpdater.updatePointLocationGetter(true);
    }
}

