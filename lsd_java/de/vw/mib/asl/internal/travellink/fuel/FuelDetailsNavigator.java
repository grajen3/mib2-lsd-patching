/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.fuel;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapConfiguration;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.travellink.TLinkServiceManager;
import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.Arrays;
import org.dsi.ifc.travellink.GenericPropertyContainer;

public final class FuelDetailsNavigator {
    private int currentIndex = 0;
    private GenericPropertyContainer[] fuelStationList = null;

    public void requestNextFuelStationDetails() {
        try {
            if (null == this.fuelStationList || this.fuelStationList.length < 1) {
                return;
            }
            ++this.currentIndex;
            if (this.currentIndex < 0 || this.currentIndex >= this.fuelStationList.length) {
                this.currentIndex = 0;
            }
            if (ServiceManager.logger2.isTraceEnabled(4)) {
                ServiceManager.logger2.trace(4).append("TL <FUEL> ").append("FuelDetailsNavigator - requestNextFuelStationDetails() - currentIndex = ").append(this.currentIndex).log();
            }
            this.requestFuelStationDetails();
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestPreviousFuelStationDetails() {
        try {
            if (null == this.fuelStationList || this.fuelStationList.length < 1) {
                return;
            }
            --this.currentIndex;
            if (this.currentIndex < 0 || this.currentIndex >= this.fuelStationList.length) {
                this.currentIndex = this.fuelStationList.length - 1;
            }
            if (ServiceManager.logger2.isTraceEnabled(4)) {
                ServiceManager.logger2.trace(4).append("TL <FUEL> ").append("FuelDetailsNavigator - requestPreviousFuelStationDetails() - currentIndex = ").append(this.currentIndex).log();
            }
            this.requestFuelStationDetails();
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestFuelStationDetails() {
        try {
            if (ServiceManager.logger2.isTraceEnabled(4)) {
                ServiceManager.logger2.trace(4).append("TL <FUEL> ").append("FuelDetailsNavigator - requestFuelStationDetails() - currentIndex = ").append(this.currentIndex).log();
            }
            if (null != this.fuelStationList && this.fuelStationList.length > this.currentIndex && null != this.fuelStationList[this.currentIndex]) {
                long l = GenericPropertyUtility.getLong(547424000, 0, this.fuelStationList[this.currentIndex]);
                TLinkServiceManager.getServiceManager().getDsiTravelLinkFuelAdapter().requestFuelStationDetails(l);
                TLinkServiceManager.getServiceManager().getFuel().setSelectedFuelStation(this.fuelStationList[this.currentIndex]);
                ASLNavigationMapConfiguration aSLNavigationMapConfiguration = TLinkServiceManager.getServiceManager().getAslNavigationMapConfigurationSplitView();
                TLinkServiceManager.getServiceManager().getApiNavigation().setFuelStationNavLocation(aSLNavigationMapConfiguration);
                TLinkServiceManager.getServiceManager().getApiNavigation().setMapConfiguration(aSLNavigationMapConfiguration);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void setCurrentArrayIndex(int n) {
        if (ServiceManager.logger2.isTraceEnabled(4)) {
            ServiceManager.logger2.trace(4).append("TL <FUEL> ").append("FuelDetailsNavigator - setCurrentArrayIndex( ").append(n).append(" )").log();
        }
        this.currentIndex = n;
    }

    public void setFuelStationIdArray() {
        try {
            Object[] objectArray;
            if (ServiceManager.logger2.isTraceEnabled(4)) {
                ServiceManager.logger2.trace(4).append("TL <FUEL> ").append("FuelDetailsNavigator - setFuelStationIdArray()").log();
            }
            if (null == (objectArray = ListManager.getGenericASLList(-1757469952).getDSIObjects()) || objectArray.length < 1) {
                this.fuelStationList = new GenericPropertyContainer[0];
                return;
            }
            GenericPropertyContainer[] genericPropertyContainerArray = (GenericPropertyContainer[])objectArray;
            if (null != genericPropertyContainerArray && genericPropertyContainerArray.length > 0 && null != genericPropertyContainerArray[0]) {
                this.fuelStationList = new GenericPropertyContainer[genericPropertyContainerArray.length];
                for (int i2 = 0; i2 < genericPropertyContainerArray.length; ++i2) {
                    this.fuelStationList[i2] = GenericPropertyUtility.getCopy(genericPropertyContainerArray[i2]);
                }
            } else {
                this.fuelStationList = new GenericPropertyContainer[0];
            }
            if (this.fuelStationList.length < 2) {
                TLinkServiceManager.getServiceManager().getGuiControllerMain().setButtonEnabled(-448847104, false);
                TLinkServiceManager.getServiceManager().getGuiControllerMain().setButtonEnabled(-482401536, false);
            } else {
                TLinkServiceManager.getServiceManager().getGuiControllerMain().setButtonEnabled(-448847104, true);
                TLinkServiceManager.getServiceManager().getGuiControllerMain().setButtonEnabled(-482401536, true);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void clear() {
        try {
            if (null != this.fuelStationList && this.fuelStationList.length > 0) {
                Arrays.fill(this.fuelStationList, null);
            }
            this.fuelStationList = null;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }
}

