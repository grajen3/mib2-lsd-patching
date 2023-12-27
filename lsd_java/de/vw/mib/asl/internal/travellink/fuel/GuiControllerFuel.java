/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.fuel;

import de.vw.mib.asl.api.navigation.GuidanceInfo;
import de.vw.mib.asl.api.navigation.NavAddress;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.travellink.GuiControllerCommon;
import de.vw.mib.asl.internal.travellink.TLinkServiceManager;
import de.vw.mib.asl.internal.travellink.dsi.Constants;
import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkFuelStationsInfoForMainViewCollector;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkSetupFuelTypeCollector;
import de.vw.mib.properties.values.SpellerData;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.travellink.transformer.TravelLinkFuelStationAddressCollector;
import java.util.ArrayList;
import java.util.Arrays;
import org.dsi.ifc.travellink.GenericPropertyContainer;

public final class GuiControllerFuel
implements GuiControllerCommon {
    public GuiControllerFuel() {
        ServiceManager.aslPropertyManager.valueChangedInteger(2067735296, 1);
    }

    @Override
    public void setSubscriptionState(int n) {
        if (ServiceManager.logger2.isTraceEnabled(4)) {
            ServiceManager.logger2.trace(4).append("TL <FUEL> ").append("GuiControllerFuel - setSubscriptionState(").append(n).append(")").log();
        }
        if (n == 2) {
            ServiceManager.aslPropertyManager.valueChangedInteger(4154, 1);
        } else if (n == 0) {
            ServiceManager.aslPropertyManager.valueChangedInteger(4154, 2);
        } else {
            ServiceManager.aslPropertyManager.valueChangedInteger(4154, 0);
        }
    }

    public void setFuelStationListSortOrder(int n) {
        if (ServiceManager.logger2.isTraceEnabled(4)) {
            ServiceManager.logger2.trace(4).append("TL <FUEL> ").append("GuiControllerFuel - setFuelStationListSortOrder(").append(n).append(")").log();
        }
        if (n >= 0 && n <= 2) {
            ServiceManager.aslPropertyManager.valueChangedInteger(2084512512, n);
        } else {
            ServiceManager.aslPropertyManager.valueChangedInteger(2084512512, 2);
        }
    }

    public void prepareAndUpdateFuelStationList(GenericPropertyContainer[] genericPropertyContainerArray) {
        if (ServiceManager.logger2.isTraceEnabled(4)) {
            ServiceManager.logger2.trace(4).append("TL <FUEL> ").append("GuiControllerFuel - prepareAndUpdateFuelStationList()").log();
        }
        if (null == genericPropertyContainerArray || genericPropertyContainerArray.length < 1) {
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(2050958080);
            ListManager.getGenericASLList(-1757469952).updateList(new GenericPropertyContainer[0]);
        } else {
            Object[] objectArray = new GenericPropertyContainer[genericPropertyContainerArray.length];
            for (int i2 = 0; i2 < genericPropertyContainerArray.length; ++i2) {
                objectArray[i2] = GenericPropertyUtility.getCopy(genericPropertyContainerArray[i2]);
            }
            Arrays.sort(objectArray, TLinkServiceManager.getServiceManager().getComparatorFuelList());
            ListManager.getGenericASLList(-1757469952).updateList(objectArray);
        }
    }

    public void prepareAndUpdateFuelAllStationDetails(GenericPropertyContainer[] genericPropertyContainerArray) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(4)) {
                ServiceManager.logger2.trace(4).append("TL <FUEL> ").append("GuiControllerFuel - prepareAndUpdateFuelAllStationDetails()").log();
            }
            if (null == genericPropertyContainerArray || genericPropertyContainerArray.length < 1) {
                this.prepareAndUpdateFuelStationAddress(null);
                ListManager.getGenericASLList(-1673583872).updateList(new GenericPropertyContainer[0]);
            } else {
                this.prepareAndUpdateFuelStationAddress(genericPropertyContainerArray[0]);
                int n = 0;
                int n2 = 0;
                if (genericPropertyContainerArray[0] != null && genericPropertyContainerArray[0].getKeys() != null) {
                    n2 = GenericPropertyUtility.getIndex(-1734277376, genericPropertyContainerArray[0].getKeys());
                }
                if (null != genericPropertyContainerArray[0].values && genericPropertyContainerArray[0].values.length > n2 && null != genericPropertyContainerArray[0].values[n2] && null != genericPropertyContainerArray[0].values[n2].valuesFloat && (n = genericPropertyContainerArray[0].values[n2].valuesFloat.length) < 0) {
                    n = 0;
                }
                Object[] objectArray = new GenericPropertyContainer[n];
                GenericPropertyContainer genericPropertyContainer = null;
                GenericPropertyContainer genericPropertyContainer2 = null;
                GenericPropertyContainer genericPropertyContainer3 = null;
                GenericPropertyContainer genericPropertyContainer4 = null;
                int n3 = -9999;
                if (genericPropertyContainerArray[0] != null && genericPropertyContainerArray[0].getKeys() != null) {
                    n3 = GenericPropertyUtility.getIndex(-1767831808, genericPropertyContainerArray[0].getKeys());
                }
                if (-9999 == n3) {
                    ListManager.getGenericASLList(-1673583872).updateList(new GenericPropertyContainer[0]);
                    return;
                }
                block8: for (int i2 = 0; i2 < n; ++i2) {
                    objectArray[i2] = GenericPropertyUtility.getFlatCopy(genericPropertyContainerArray[0], i2);
                    if (null == objectArray[i2]) continue;
                    int n4 = GenericPropertyUtility.getInt(-1767831808, 0, objectArray[i2]);
                    switch (n4) {
                        case 0: {
                            genericPropertyContainer = objectArray[i2];
                            continue block8;
                        }
                        case 1: {
                            genericPropertyContainer2 = objectArray[i2];
                            continue block8;
                        }
                        case 2: {
                            genericPropertyContainer3 = objectArray[i2];
                            continue block8;
                        }
                        case 3: {
                            genericPropertyContainer4 = objectArray[i2];
                            continue block8;
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                if (null != genericPropertyContainer) {
                    arrayList.add(genericPropertyContainer);
                }
                if (null != genericPropertyContainer2) {
                    arrayList.add(genericPropertyContainer2);
                }
                if (null != genericPropertyContainer3) {
                    arrayList.add(genericPropertyContainer3);
                }
                if (null != genericPropertyContainer4) {
                    arrayList.add(genericPropertyContainer4);
                }
                if (arrayList == null || arrayList.size() < 1) {
                    ListManager.getGenericASLList(-1673583872).updateList(new GenericPropertyContainer[0]);
                } else {
                    objectArray = (GenericPropertyContainer[])arrayList.toArray(new GenericPropertyContainer[arrayList.size()]);
                    ListManager.getGenericASLList(-1673583872).updateList(objectArray);
                }
                if (ServiceManager.logger2.isTraceEnabled(4)) {
                    ServiceManager.logger2.trace(4).append("TL <FUEL> ").append("GuiControllerFuel - prepareAndUpdateFuelAllStationDetails() - Update SELECTED_FUEL_RESULT_PRICES_LIST").log();
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void prepareAndUpdateFuelStationAddress(GenericPropertyContainer genericPropertyContainer) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(4)) {
                ServiceManager.logger2.trace(4).append("TL <FUEL> ").append("GuiControllerFuel - prepareAndUpdateFuelStationAddress()").log();
            }
            Object[] objectArray = new TravelLinkFuelStationAddressCollector[]{new TravelLinkFuelStationAddressCollector()};
            if (null == genericPropertyContainer) {
                objectArray[0].travellink_fuel_station_address__direction = 0;
                objectArray[0].travellink_fuel_station_address__distance = 0;
                objectArray[0].travellink_fuel_station_address__distance_and_unit = "";
                objectArray[0].travellink_fuel_station_address__name = "";
                objectArray[0].travellink_fuel_station_address__icon = Constants.INVALID_RESOURCE_LOCATOR_VALUE;
                objectArray[0].travellink_fuel_station_address__address = "";
            } else {
                String string;
                int n = GenericPropertyUtility.getInt(-1834940672, 0, genericPropertyContainer);
                objectArray[0].travellink_fuel_station_address__direction = n = TLinkServiceManager.getServiceManager().getTravelLinkUtil().checkDirection(n);
                objectArray[0].travellink_fuel_station_address__distance = GenericPropertyUtility.getInt(-1851717888, 0, genericPropertyContainer);
                int n2 = GenericPropertyUtility.getInt(-1851717888, 0, genericPropertyContainer);
                objectArray[0].travellink_fuel_station_address__distance_and_unit = TLinkServiceManager.getServiceManager().getTravelLinkUtil().getDistanceValueAndUnit(n2);
                ((TravelLinkFuelStationAddressCollector)objectArray[0]).travellink_fuel_station_address__icon = GenericPropertyUtility.getResourceLocator(-1818163456, 0, genericPropertyContainer);
                ((TravelLinkFuelStationAddressCollector)objectArray[0]).travellink_fuel_station_address__name = GenericPropertyUtility.getString(-2019490048, 0, genericPropertyContainer);
                String string2 = GenericPropertyUtility.getString(-1952381184, 0, genericPropertyContainer);
                String string3 = GenericPropertyUtility.getString(-2002712832, 0, genericPropertyContainer);
                String string4 = GenericPropertyUtility.getString(-1985935616, 0, genericPropertyContainer);
                String string5 = GenericPropertyUtility.getString(-1935603968, 0, genericPropertyContainer);
                String string6 = GenericPropertyUtility.getString(-1683945728, 0, genericPropertyContainer);
                String string7 = GenericPropertyUtility.getString(-1969158400, 0, genericPropertyContainer);
                ((TravelLinkFuelStationAddressCollector)objectArray[0]).travellink_fuel_station_address__address = string = TLinkServiceManager.getServiceManager().getTravelLinkUtil().generateFormattedAddressNamingRuleA(string2, string3, string4, string5, string6, string7);
            }
            ListManager.getGenericASLList(-415292672).updateList(objectArray);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateSpellerFreeCharEntered(SpellerData spellerData) {
        if (ServiceManager.logger2.isTraceEnabled(4)) {
            ServiceManager.logger2.trace(4).append("TL <FUEL> ").append("GuiControllerFuel - updateSpellerFreeCharEntered()").log();
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(-1556143360, spellerData.getEnteredText().trim().length() > 0);
    }

    public void updateSpellerData(SpellerData spellerData) {
        if (ServiceManager.logger2.isTraceEnabled(4)) {
            ServiceManager.logger2.trace(4).append("TL <FUEL> ").append("GuiControllerFuel - updateSpellerData()").log();
        }
        ServiceManager.aslPropertyManager.valueChangedSpellerData(-1572920576, spellerData);
    }

    public void setFuelStationSearchArea(int n) {
        if (ServiceManager.logger2.isTraceEnabled(4)) {
            ServiceManager.logger2.trace(4).append("TL <FUEL> ").append("GuiControllerFuel - setFuelStationSearchArea(").append(n).append(")").log();
        }
        if (n >= 0 && n <= 2) {
            ServiceManager.aslPropertyManager.valueChangedInteger(-1858133248, n);
        } else {
            ServiceManager.aslPropertyManager.valueChangedInteger(-1858133248, 0);
        }
    }

    public void setPreferredFuelTypeListIndex(int n) {
        if (ServiceManager.logger2.isTraceEnabled(4)) {
            ServiceManager.logger2.trace(4).append("TL <FUEL> ").append("GuiControllerFuel - setPreferredFuelType(").append(n).append(")").log();
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(4057, n);
    }

    public void prepareAndUpdateFuelClosestStation(GenericPropertyContainer[] genericPropertyContainerArray, boolean bl) {
        int n;
        if (ServiceManager.logger2.isTraceEnabled(4)) {
            ServiceManager.logger2.trace(4).append("TL <FUEL> ").append("GuiControllerFuel - prepareAndUpdateFuelClosestStation()").log();
        }
        int n2 = 4;
        Object[] objectArray = ListManager.getGenericASLList(-113302784).getDSIObjects();
        if (null != objectArray && objectArray.length == 4 && bl) {
            return;
        }
        Object[] objectArray2 = new TravelLinkFuelStationsInfoForMainViewCollector[4];
        for (n = 0; n < 4; ++n) {
            objectArray2[n] = new TravelLinkFuelStationsInfoForMainViewCollector();
        }
        if (null != genericPropertyContainerArray && genericPropertyContainerArray.length > 0 && null != genericPropertyContainerArray[0]) {
            n = TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getFuelStationListSortOrder();
            TLinkServiceManager.getServiceManager().getTravelLinkPersistable().setFuelStationListSortOrder(2);
            Arrays.sort(genericPropertyContainerArray, TLinkServiceManager.getServiceManager().getComparatorFuelList());
            TLinkServiceManager.getServiceManager().getTravelLinkPersistable().setFuelStationListSortOrder(n);
            TLinkServiceManager.getServiceManager().getFuel().setSelectedFuelStation(genericPropertyContainerArray[0]);
            for (int i2 = 0; i2 < genericPropertyContainerArray.length && i2 < 4; ++i2) {
                if (null == genericPropertyContainerArray[i2]) continue;
                String string = GenericPropertyUtility.getString(597755648, 0, genericPropertyContainerArray[i2]);
                int n3 = TLinkServiceManager.getServiceManager().getFuel().getFuelPriceCurrency(genericPropertyContainerArray[i2]);
                int n4 = (int)GenericPropertyUtility.getFloat(648087296, 0, genericPropertyContainerArray[i2]);
                float f2 = GenericPropertyUtility.getFloat(648087296, 0, genericPropertyContainerArray[i2]);
                int n5 = (int)(f2 * 51266) % 100;
                String string2 = TLinkServiceManager.getServiceManager().getFuel().getFuelPriceAsString(n4, n5, n3);
                ((TravelLinkFuelStationsInfoForMainViewCollector)objectArray2[i2]).travellinkFuelStationsInfoForMainViewNameString = string;
                ((TravelLinkFuelStationsInfoForMainViewCollector)objectArray2[i2]).travellinkFuelStationsInfoForMainViewPriceString = string2;
            }
            ServiceManager.aslPropertyManager.valueChangedInteger(2067735296, 2);
        } else if (bl) {
            ServiceManager.aslPropertyManager.valueChangedInteger(2067735296, 1);
        } else {
            ServiceManager.aslPropertyManager.valueChangedInteger(2067735296, 0);
        }
        ListManager.getGenericASLList(-113302784).updateList(objectArray2);
    }

    public void prepareAndUpdateFuelTypeList(GenericPropertyContainer[] genericPropertyContainerArray) {
        if (ServiceManager.logger2.isTraceEnabled(4)) {
            ServiceManager.logger2.trace(4).append("TL <FUEL> ").append("GuiControllerFuel - prepareAndUpdateFuelTypeList()").log();
        }
        if (null != genericPropertyContainerArray && genericPropertyContainerArray.length > 0 && null != genericPropertyContainerArray[0]) {
            int n;
            Arrays.sort(genericPropertyContainerArray, TLinkServiceManager.getServiceManager().getComparatorString(-392100096));
            Object[] objectArray = new TravelLinkSetupFuelTypeCollector[genericPropertyContainerArray.length];
            for (n = 0; n < objectArray.length; ++n) {
                objectArray[n] = new TravelLinkSetupFuelTypeCollector();
                if (null == genericPropertyContainerArray[n]) continue;
                objectArray[n].fuelTypeName = GenericPropertyUtility.getString(-392100096, 0, genericPropertyContainerArray[n]);
                ((TravelLinkSetupFuelTypeCollector)objectArray[n]).fuelTypeId = GenericPropertyUtility.getInt(-375322880, 0, genericPropertyContainerArray[n]);
            }
            n = TLinkServiceManager.getServiceManager().getFuel().getPreferredFuelTypeListIndex((TravelLinkSetupFuelTypeCollector[])objectArray);
            if (n > -1 && n < objectArray.length) {
                TLinkServiceManager.getServiceManager().getGuiControllerFuel().setPreferredFuelTypeListIndex(n);
                ((TravelLinkSetupFuelTypeCollector)objectArray[n]).fuelTypeActivated = true;
                this.setSelectedFuelTypeInSetupMain(TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getPreferredFuelTypeName());
            } else {
                TLinkServiceManager.getServiceManager().getGuiControllerFuel().setPreferredFuelTypeListIndex(0);
            }
            ListManager.getGenericASLList(-213966080).updateList(objectArray);
        } else {
            Object[] objectArray = new TravelLinkSetupFuelTypeCollector[]{new TravelLinkSetupFuelTypeCollector()};
            objectArray[0].fuelTypeId = TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getPreferredFuelTypeId();
            objectArray[0].fuelTypeName = TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getPreferredFuelTypeName();
            objectArray[0].fuelTypeActivated = true;
            ListManager.getGenericASLList(-213966080).updateList(objectArray);
            TLinkServiceManager.getServiceManager().getGuiControllerFuel().setPreferredFuelTypeListIndex(0);
            this.setSelectedFuelTypeInSetupMain(TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getPreferredFuelTypeName());
        }
    }

    public void setSelectedFuelTypeInSetupMain(String string) {
        ServiceManager.aslPropertyManager.valueChangedString(-163634432, string);
    }

    public void displayOverlayFuelNoResults() {
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(2050958080);
    }

    public void updateNavigationAddressWithSelectedSearchArea() {
        try {
            NavAddress navAddress;
            GuidanceInfo[] guidanceInfoArray;
            boolean bl = TLinkServiceManager.getServiceManager().getApiNavigation().isRouteGuidanceActive();
            int n = TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getFuelStationSearchArea();
            String string = "";
            if (!bl && n != 0) {
                ServiceManager.logger2.info(4).append("TL <FUEL> ").append("GuiControllerFuel - fuel search option reverted to C0_CCP since there is no guidance - previous value: ").append(n).log();
                n = 0;
                TLinkServiceManager.getServiceManager().getTravelLinkPersistable().setFuelStationSearchArea(n);
                this.setFuelStationSearchArea(n);
            }
            if (0 == n) {
                NavAddress navAddress2 = TLinkServiceManager.getServiceManager().getApiNavigation().getCurrentCarPosition();
                if (null != navAddress2) {
                    String string2 = navAddress2.getCity();
                    String string3 = navAddress2.getStreet();
                    String string4 = navAddress2.getHousenumber();
                    String string5 = navAddress2.getCountry();
                    String string6 = navAddress2.getState();
                    String string7 = navAddress2.getZip();
                    string = TLinkServiceManager.getServiceManager().getTravelLinkUtil().getNavigationFormattedAddressNamingRule14(string2, string3, string4, string5, string6, string7);
                }
            } else if ((2 == n || 1 == n) && null != (guidanceInfoArray = TLinkServiceManager.getServiceManager().getApiNavigation().getGuidanceInfo()) && null != (navAddress = guidanceInfoArray[1].getAddress())) {
                String string8 = navAddress.getCity();
                String string9 = navAddress.getStreet();
                String string10 = navAddress.getHousenumber();
                String string11 = navAddress.getCountry();
                String string12 = navAddress.getState();
                String string13 = navAddress.getZip();
                string = TLinkServiceManager.getServiceManager().getTravelLinkUtil().getNavigationFormattedAddressNamingRule14(string8, string9, string10, string11, string12, string13);
            }
            ServiceManager.aslPropertyManager.valueChangedString(121643776, string);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }
}

