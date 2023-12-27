/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.fuel;

import de.vw.mib.asl.api.navigation.NavAddress;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.travellink.DataProcessor;
import de.vw.mib.asl.internal.travellink.TLinkServiceManager;
import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkSetupFuelTypeCollector;
import de.vw.mib.genericevents.EventGeneric;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.Arrays;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.AddressData;
import org.dsi.ifc.organizer.PersonalData;
import org.dsi.ifc.organizer.PhoneData;
import org.dsi.ifc.travellink.GenericPropertyContainer;

public final class Fuel
implements DataProcessor {
    private GenericPropertyContainer selectedFuelStationWithDetails = null;
    private GenericPropertyContainer selectedFuelStation = null;
    public static final int REQUESTTYPE_TL_FUEL_GAS_STATIONS_UNKNOWN;
    public static final int REQUESTTYPE_TL_FUEL_GAS_STATIONS_CLOSEST;
    public static final int REQUESTTYPE_TL_FUEL_GAS_STATIONS_USER_SELECTION;
    private int fuelGasStationsRequestType = 0;

    @Override
    public void processAndUpdate(int n, GenericPropertyContainer[] genericPropertyContainerArray, int n2, int n3) {
        if (ServiceManager.logger2.isTraceEnabled(4)) {
            if (null == genericPropertyContainerArray) {
                ServiceManager.logger2.trace(4).append("TL <FUEL> ").append("Fuel - processAndUpdate() - requestType = ").append(n).append(", properties == null, status = ").append(n2).log();
            } else {
                ServiceManager.logger2.trace(4).append("TL <FUEL> ").append("Fuel - processAndUpdate() - requestType = ").append(n).append(", properties.length = ").append(genericPropertyContainerArray.length).append(", status = ").append(n2).log();
            }
        }
        if (this.checkValidData(n, genericPropertyContainerArray)) {
            switch (n) {
                case 49: {
                    if (1 != this.getFuelGasStationsRequestType()) break;
                    TLinkServiceManager.getServiceManager().getGuiControllerFuel().prepareAndUpdateFuelClosestStation(genericPropertyContainerArray, false);
                    this.requestFuelStationDetailsForClosestStation(genericPropertyContainerArray);
                    TLinkServiceManager.getServiceManager().getGuiControllerFuel().prepareAndUpdateFuelStationList(genericPropertyContainerArray);
                    break;
                }
                case 29: {
                    if (2 != this.getFuelGasStationsRequestType()) break;
                    TLinkServiceManager.getServiceManager().getDatapool().put(29, genericPropertyContainerArray);
                    TLinkServiceManager.getServiceManager().getGuiControllerFuel().prepareAndUpdateFuelStationList(genericPropertyContainerArray);
                    break;
                }
                case 30: {
                    TLinkServiceManager.getServiceManager().getDatapool().put(30, genericPropertyContainerArray);
                    TLinkServiceManager.getServiceManager().getGuiControllerFuel().prepareAndUpdateFuelAllStationDetails(genericPropertyContainerArray);
                    this.setSelectedFuelStationWithDetails(genericPropertyContainerArray);
                    break;
                }
                case 51: {
                    TLinkServiceManager.getServiceManager().getGuiControllerFuel().prepareAndUpdateFuelTypeList(genericPropertyContainerArray);
                    break;
                }
                case 56: {
                    this.printPreferredFuelType(genericPropertyContainerArray);
                    break;
                }
                default: {
                    if (!ServiceManager.logger2.isTraceEnabled(4)) break;
                    ServiceManager.logger2.error(4).append("Fuel : processAndUpdate : RequestType is not handled. requestType = ").append(n).log();
                }
            }
        }
    }

    public boolean checkValidData(int n, GenericPropertyContainer[] genericPropertyContainerArray) {
        if (ServiceManager.logger2.isTraceEnabled(4)) {
            ServiceManager.logger2.trace(4).append("TL <FUEL> ").append("Fuel - checkValidData() - requestType = ").append(n).log();
        }
        if (genericPropertyContainerArray != null && n >= 0 && n < 60) {
            switch (n) {
                case 29: 
                case 30: 
                case 49: 
                case 51: 
                case 56: {
                    if (genericPropertyContainerArray.length > 0) {
                        return true;
                    }
                    if (ServiceManager.logger2.isTraceEnabled(4)) {
                        ServiceManager.logger2.error(4).append("Fuel : checkValidData : Data length not valid for REQUESTTYPE_TL_FUEL_GAS_STATIONS. Data length --> ").append(genericPropertyContainerArray.length).log();
                    }
                    if (2 == this.getFuelGasStationsRequestType()) {
                        TLinkServiceManager.getServiceManager().getGuiControllerFuel().displayOverlayFuelNoResults();
                    }
                    return false;
                }
            }
            if (ServiceManager.logger2.isTraceEnabled(4)) {
                ServiceManager.logger2.error(4).append("Fuel : checkValidData : Error requestType --> ").append(n).log();
            }
            return false;
        }
        if (genericPropertyContainerArray == null && ServiceManager.logger2.isTraceEnabled(4)) {
            ServiceManager.logger2.error(4).append("Fuel : checkValidData : Propreties is null ").log();
        }
        if (n < 0 && n < 60 && ServiceManager.logger2.isTraceEnabled(4)) {
            ServiceManager.logger2.error(4).append("Fuel : checkValidData : Error requestType received --> ").append(n).log();
        }
        return false;
    }

    public void setFuelStationListSortOrder(EventGeneric eventGeneric) {
        try {
            int n = eventGeneric.getInt(0);
            if (ServiceManager.logger2.isTraceEnabled(4)) {
                ServiceManager.logger2.trace(4).append("TL <FUEL> ").append("Fuel - setFuelStationListSortOrder() - fuelStationListSortOrder = ").append(n).log();
            }
            TLinkServiceManager.getServiceManager().getTravelLinkPersistable().setFuelStationListSortOrder(n);
            TLinkServiceManager.getServiceManager().getGuiControllerFuel().setFuelStationListSortOrder(n);
            Object[] objectArray = ListManager.getGenericASLList(-1757469952).getDSIObjects();
            if (null == objectArray || objectArray.length < 1) {
                return;
            }
            Object[] objectArray2 = (GenericPropertyContainer[])objectArray;
            if (null != objectArray2 && objectArray2.length > 0 && null != objectArray2[0]) {
                Arrays.sort(objectArray2, TLinkServiceManager.getServiceManager().getComparatorFuelList());
                ListManager.getGenericASLList(-1757469952).updateList(objectArray2);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void setFuelStationSearchArea(EventGeneric eventGeneric) {
        try {
            int n = eventGeneric.getInt(0);
            if (ServiceManager.logger2.isTraceEnabled(4)) {
                ServiceManager.logger2.trace(4).append("TL <FUEL> ").append("Fuel - setFuelStationSearchArea() - fuelStationSearchArea = ").append(n).log();
            }
            TLinkServiceManager.getServiceManager().getTravelLinkPersistable().setFuelStationSearchArea(n);
            TLinkServiceManager.getServiceManager().getGuiControllerFuel().setFuelStationSearchArea(n);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void setPreferredFuelType(EventGeneric eventGeneric) {
        try {
            Object[] objectArray;
            if (ServiceManager.logger2.isTraceEnabled(4)) {
                ServiceManager.logger2.trace(4).append("TL <FUEL> ").append("Fuel - setPreferredFuelType()").log();
            }
            if (null != (objectArray = ListManager.getGenericASLList(-213966080).getDSIObjects()) && objectArray.length > 0) {
                int n = eventGeneric.getInt(0);
                Object[] objectArray2 = (TravelLinkSetupFuelTypeCollector[])objectArray;
                if (null != objectArray2 && objectArray2.length > n && n > -1 && null != objectArray2[n]) {
                    int n2 = objectArray2[n].fuelTypeId;
                    TLinkServiceManager.getServiceManager().getTravelLinkPersistable().setPreferredFuelTypeId(n2);
                    String string = objectArray2[n].fuelTypeName;
                    if (null == string) {
                        string = "";
                    }
                    TLinkServiceManager.getServiceManager().getTravelLinkPersistable().setPreferredFuelTypeName(string);
                    TLinkServiceManager.getServiceManager().getGuiControllerFuel().setPreferredFuelTypeListIndex(n);
                    TLinkServiceManager.getServiceManager().getDsiTravelLinkFuelAdapter().requestToSetPreferredFuelType(string, n2);
                    for (int i2 = 0; i2 < objectArray2.length; ++i2) {
                        objectArray2[i2].fuelTypeActivated = false;
                    }
                    objectArray2[n].fuelTypeActivated = true;
                    ListManager.getGenericASLList(-213966080).updateList(objectArray2);
                    TLinkServiceManager.getServiceManager().getGuiControllerFuel().setSelectedFuelTypeInSetupMain(string);
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public int getPreferredFuelTypeListIndex(TravelLinkSetupFuelTypeCollector[] travelLinkSetupFuelTypeCollectorArray) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(4)) {
                ServiceManager.logger2.trace(4).append("TL <FUEL> ").append("Fuel - getPreferredFuelTypeListIndex()").log();
            }
            if (null != travelLinkSetupFuelTypeCollectorArray && travelLinkSetupFuelTypeCollectorArray.length > 0) {
                int n = TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getPreferredFuelTypeId();
                for (int i2 = 0; i2 < travelLinkSetupFuelTypeCollectorArray.length; ++i2) {
                    if (null == travelLinkSetupFuelTypeCollectorArray[i2] || travelLinkSetupFuelTypeCollectorArray[i2].fuelTypeId != n) continue;
                    return i2;
                }
            }
            return -1;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return -1;
        }
    }

    public void updateSelectedFuelStation() {
        if (ServiceManager.logger2.isTraceEnabled(4)) {
            ServiceManager.logger2.trace(4).append("TL <FUEL> ").append("Fuel - updateSelectedFuelStation()").log();
        }
        if (null == this.selectedFuelStationWithDetails) {
            TLinkServiceManager.getServiceManager().getGuiControllerFuel().prepareAndUpdateFuelStationAddress(null);
        } else {
            TLinkServiceManager.getServiceManager().getGuiControllerFuel().prepareAndUpdateFuelStationAddress(this.selectedFuelStationWithDetails);
        }
    }

    public void startGuidance() {
        try {
            if (ServiceManager.logger2.isTraceEnabled(4)) {
                ServiceManager.logger2.trace(4).append("TL <FUEL> ").append("Fuel - startGuidance()").log();
            }
            if (null != this.selectedFuelStationWithDetails) {
                String string = GenericPropertyUtility.getString(-2019490048, 0, this.selectedFuelStationWithDetails);
                String string2 = GenericPropertyUtility.getString(-2002712832, 0, this.selectedFuelStationWithDetails);
                String string3 = GenericPropertyUtility.getString(-1985935616, 0, this.selectedFuelStationWithDetails);
                String string4 = GenericPropertyUtility.getString(-1969158400, 0, this.selectedFuelStationWithDetails);
                String string5 = GenericPropertyUtility.getString(-1952381184, 0, this.selectedFuelStationWithDetails);
                String string6 = GenericPropertyUtility.getString(-1918826752, 0, this.selectedFuelStationWithDetails);
                String string7 = GenericPropertyUtility.getString(-1935603968, 0, this.selectedFuelStationWithDetails);
                double d2 = GenericPropertyUtility.getDouble(-2053044480, 0, this.selectedFuelStationWithDetails);
                double d3 = GenericPropertyUtility.getDouble(-2036267264, 0, this.selectedFuelStationWithDetails);
                NavAddress navAddress = new NavAddress();
                navAddress.setName(string);
                navAddress.setStreet(string2);
                navAddress.setHousenumber(string3);
                navAddress.setZip(string4);
                navAddress.setCity(string5);
                navAddress.setState(string6);
                navAddress.setPhoneNumber(string7);
                navAddress.setLongitude(d3);
                navAddress.setLatitude(d2);
                TLinkServiceManager.getServiceManager().getApiNavigation().startGuidance(navAddress);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void storeContact() {
        try {
            GenericPropertyContainer[] genericPropertyContainerArray;
            if (ServiceManager.logger2.isTraceEnabled(4)) {
                ServiceManager.logger2.trace(4).append("TL <FUEL> ").append("Fuel - storeContact()").log();
            }
            if (null != (genericPropertyContainerArray = TLinkServiceManager.getServiceManager().getDatapool().get(30)) && genericPropertyContainerArray.length > 0 && null != genericPropertyContainerArray[0]) {
                String string = GenericPropertyUtility.getString(-2019490048, 0, genericPropertyContainerArray[0]);
                String string2 = GenericPropertyUtility.getString(-2002712832, 0, genericPropertyContainerArray[0]);
                String string3 = GenericPropertyUtility.getString(-1985935616, 0, genericPropertyContainerArray[0]);
                String string4 = GenericPropertyUtility.getString(-1969158400, 0, genericPropertyContainerArray[0]);
                String string5 = GenericPropertyUtility.getString(-1952381184, 0, genericPropertyContainerArray[0]);
                String string6 = GenericPropertyUtility.getString(-1935603968, 0, genericPropertyContainerArray[0]);
                double d2 = GenericPropertyUtility.getDouble(-2053044480, 0, genericPropertyContainerArray[0]);
                double d3 = GenericPropertyUtility.getDouble(-2036267264, 0, genericPropertyContainerArray[0]);
                String string7 = "";
                if (null != string2 && string2.length() > 0 && null != string3 && string3.length() > 0) {
                    string7 = new StringBuffer().append(string3).append(" ").append(string2).toString();
                } else if (null != string2 && string2.length() > 0) {
                    string7 = string2;
                } else if (null != string3 && string3.length() > 0) {
                    string7 = string3;
                }
                AddressData addressData = new AddressData();
                addressData.street = string7;
                addressData.postalCode = string4;
                addressData.locality = string5;
                addressData.geoPosition = TLinkServiceManager.getServiceManager().getTravelLinkUtil().formatGeoPosition(d2, d3);
                PersonalData personalData = new PersonalData();
                personalData.lastName = TLinkServiceManager.getServiceManager().getFreeSpeller().getEnteredText();
                TLinkServiceManager.getServiceManager().getFreeSpeller().clear();
                personalData.organization = string;
                PhoneData phoneData = new PhoneData();
                phoneData.number = string6;
                AdbEntry adbEntry = new AdbEntry();
                adbEntry.personalData = personalData;
                adbEntry.addressData = new AddressData[]{addressData};
                adbEntry.phoneData = new PhoneData[]{phoneData};
                adbEntry.combinedName = "";
                TLinkServiceManager.getServiceManager().getApiNavigation().storeContact(adbEntry);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestFuelStationDetailsForListIndex(int n) {
        try {
            Object[] objectArray;
            if (ServiceManager.logger2.isTraceEnabled(4)) {
                ServiceManager.logger2.trace(4).append("TL <FUEL> ").append("Fuel - requestFuelStationDetailsForListIndex( ").append(n).append(" )").log();
            }
            if (null == (objectArray = ListManager.getGenericASLList(-1757469952).getDSIObjects()) || objectArray.length < 1) {
                return;
            }
            GenericPropertyContainer[] genericPropertyContainerArray = (GenericPropertyContainer[])objectArray;
            if (null != genericPropertyContainerArray && genericPropertyContainerArray.length > n && null != genericPropertyContainerArray[n]) {
                this.setSelectedFuelStation(genericPropertyContainerArray[n]);
                long l = GenericPropertyUtility.getLong(547424000, 0, genericPropertyContainerArray[n]);
                TLinkServiceManager.getServiceManager().getDsiTravelLinkFuelAdapter().requestFuelStationDetails(l);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestFuelStationDetailsForClosestStation(GenericPropertyContainer[] genericPropertyContainerArray) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(4)) {
                ServiceManager.logger2.trace(4).append("TL <FUEL> ").append("Fuel - requestFuelStationDetailsForClosestStation()").log();
            }
            if (null != genericPropertyContainerArray && genericPropertyContainerArray.length > 0 && null != genericPropertyContainerArray[0]) {
                long l = GenericPropertyUtility.getLong(547424000, 0, genericPropertyContainerArray[0]);
                TLinkServiceManager.getServiceManager().getDsiTravelLinkFuelAdapter().requestFuelStationDetails(l);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public GenericPropertyContainer getSelectedFuelStationWithDetails() {
        if (ServiceManager.logger2.isTraceEnabled(4)) {
            ServiceManager.logger2.trace(4).append("TL <FUEL> ").append("Fuel - getSelectedFuelStationWithDetails()").log();
        }
        return this.selectedFuelStationWithDetails;
    }

    public void setSelectedFuelStationWithDetails(GenericPropertyContainer[] genericPropertyContainerArray) {
        if (ServiceManager.logger2.isTraceEnabled(4)) {
            ServiceManager.logger2.trace(4).append("TL <FUEL> ").append("Fuel - setSelectedFuelStationWithDetails()").log();
        }
        if (null != genericPropertyContainerArray && genericPropertyContainerArray.length == 1 && null != genericPropertyContainerArray[0]) {
            this.selectedFuelStationWithDetails = GenericPropertyUtility.getCopy(genericPropertyContainerArray[0]);
        }
    }

    public GenericPropertyContainer getSelectedFuelStation() {
        if (ServiceManager.logger2.isTraceEnabled(4)) {
            ServiceManager.logger2.trace(4).append("TL <FUEL> ").append("Fuel - getSelectedFuelStation()").log();
        }
        return this.selectedFuelStation;
    }

    public void setSelectedFuelStation(GenericPropertyContainer genericPropertyContainer) {
        if (ServiceManager.logger2.isTraceEnabled(4)) {
            ServiceManager.logger2.trace(4).append("TL <FUEL> ").append("Fuel - setSelectedFuelStation()").log();
        }
        if (null != genericPropertyContainer) {
            this.selectedFuelStation = GenericPropertyUtility.getCopy(genericPropertyContainer);
        }
    }

    public int getFuelPriceCurrency(GenericPropertyContainer genericPropertyContainer) {
        int n;
        if (ServiceManager.logger2.isTraceEnabled(4)) {
            ServiceManager.logger2.trace(4).append("TL <FUEL> ").append("Fuel - getFuelPriceCurrency()").log();
        }
        if ((n = GenericPropertyUtility.getInt(664864512, 0, genericPropertyContainer)) == 1) {
            return 2;
        }
        return 0;
    }

    public int getFuelGasStationsRequestType() {
        if (ServiceManager.logger2.isTraceEnabled(4)) {
            ServiceManager.logger2.trace(4).append("TL <FUEL> ").append("Fuel - getFuelGasStationsRequestType()").log();
        }
        return this.fuelGasStationsRequestType;
    }

    public void setFuelGasStationsRequestType(int n) {
        if (ServiceManager.logger2.isTraceEnabled(4)) {
            ServiceManager.logger2.trace(4).append("TL <FUEL> ").append("Fuel - setFuelGasStationsRequestType( ").append(n).append(" )").log();
        }
        this.fuelGasStationsRequestType = n;
    }

    public void printPreferredFuelType(GenericPropertyContainer[] genericPropertyContainerArray) {
        if (ServiceManager.logger2.isTraceEnabled(4)) {
            ServiceManager.logger2.trace(4).append("TL <FUEL> ").append("GuiControllerFuel - printPreferredFuelType()").log();
        }
        if (genericPropertyContainerArray != null && genericPropertyContainerArray.length > 0 && genericPropertyContainerArray[0] != null) {
            int n = GenericPropertyUtility.getInt(1302464256, 0, genericPropertyContainerArray[0]);
            String string = GenericPropertyUtility.getString(1285687040, 0, genericPropertyContainerArray[0]);
            if (ServiceManager.logger2.isTraceEnabled(4)) {
                ServiceManager.logger2.trace(4).append("TL <FUEL> ").append("Preferred fuel type id is ").append(n).append("and the Preferred fuel type name is ").append(string).log();
            }
        }
    }

    public void updateFuelStationList() {
        GenericPropertyContainer[] genericPropertyContainerArray = TLinkServiceManager.getServiceManager().getDatapool().get(29);
        if (genericPropertyContainerArray != null && genericPropertyContainerArray.length > 0 && genericPropertyContainerArray[0] != null) {
            TLinkServiceManager.getServiceManager().getGuiControllerFuel().prepareAndUpdateFuelStationList(genericPropertyContainerArray);
        } else if (ServiceManager.logger2.isTraceEnabled(4)) {
            ServiceManager.logger2.trace(4).append("Fuel : updateFuelStationList : No Data ").log();
        }
    }

    public String getFuelPriceAsString(int n, int n2, int n3) {
        try {
            String string = "$";
            if (n3 < 0 || n3 > 1 || n < 0 || n2 < 0) {
                ServiceManager.logger2.error(4).append("Fuel : getFuelPriceAsString : (currency < 0 || currency > 1 || price < 0 || percentil < 0) ").log();
                return "--";
            }
            String string2 = n2 < 10 ? new StringBuffer().append("0").append(ServiceManager.fixFormat4Asl.fmtInteger(n2)).toString() : ServiceManager.fixFormat4Asl.fmtInteger(n2);
            return new StringBuffer().append(string).append(ServiceManager.fixFormat4Asl.fmtInteger(n)).append(".").append(string2).toString();
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return "--";
        }
    }
}

