/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.adapterOCU.control;

import de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkTrackingServices;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.online.coreImpl.corecommon.CoreServiceCommonFactory;
import de.vw.mib.asl.internal.online.coreImpl.corecommon.CoreServiceMappingTable;
import de.vw.mib.asl.internal.online.coreImpl.corecommon.TrackingServiceImpl;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.Device;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.Service;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.TrackingService;
import de.vw.mib.util.Util;
import java.util.ArrayList;

public class CoreSeviceOCUTrackingServicesHandler {
    private final int SERVICE_GEOFENCE;
    private final int SERVICE_SPEEDALERT;
    private final int SERVICE_VALETALERT;
    private final int SERVICE_VEHICLE_LOCATING_TRACKING;
    private final int SERVICE_TIMEFENCING;
    private final int SERVICE_LOGBOOK;
    private final int SERVICE_DRIVEREFFICIENCY;
    private final int SERVICE_CARFINDER;
    int[] _trackingServicesCoding;
    private final int _trackingServiceCount;
    private TrackingService[] _trackingServices;
    private OnlineNetworkTrackingServices _onlineNetworkTrackingServices;

    public CoreSeviceOCUTrackingServicesHandler() {
        this.SERVICE_GEOFENCE = 0;
        this.SERVICE_SPEEDALERT = 1;
        this.SERVICE_VALETALERT = 2;
        this.SERVICE_VEHICLE_LOCATING_TRACKING = 3;
        this.SERVICE_TIMEFENCING = 4;
        this.SERVICE_LOGBOOK = 5;
        this.SERVICE_DRIVEREFFICIENCY = 6;
        this.SERVICE_CARFINDER = 7;
        this._trackingServiceCount = 8;
    }

    private TrackingService getServiceWithServiceID(String string) {
        if (!Util.isNullOrEmpty(this._trackingServices) && !Util.isNullOrEmpty(string)) {
            int n = this._trackingServices.length;
            for (int i2 = 0; i2 < n; ++i2) {
                if (!this._trackingServices[i2].getServiceID().equalsIgnoreCase(string)) continue;
                return this._trackingServices[i2];
            }
        }
        return null;
    }

    private Service getServiceWithServiceID(Service[] serviceArray, String string) {
        if (!Util.isNullOrEmpty(serviceArray) && !Util.isNullOrEmpty(string)) {
            int n = serviceArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                if (!serviceArray[i2].getServiceID().equalsIgnoreCase(string)) continue;
                return serviceArray[i2];
            }
        }
        return null;
    }

    private Service setGetTrackingInfo(Service service, boolean bl) {
        if (service != null) {
            if (bl) {
                service.setTrackingService(true);
                service.setTrackingToActive(true);
                service.setServiceState(1);
            } else {
                service.setTrackingToActive(false);
            }
        }
        return service;
    }

    private TrackingService setGetTrackingInfo(TrackingService trackingService, boolean bl, int n) {
        if (trackingService != null) {
            if (bl && this.getTrackingServiceCodingWithIndex(n) > 0) {
                trackingService.setServiceToActivationInCurrentLifeCycle(true);
                trackingService.setTrackingActivated(true);
            } else {
                trackingService.setTrackingActivated(false);
            }
        }
        return trackingService;
    }

    int getServiceBitWithServiceID(String string) {
        if (!Util.isNullOrEmpty(string)) {
            if (string.equalsIgnoreCase(CoreServiceMappingTable.getServiceIDWithModelID(23))) {
                return 0;
            }
            if (string.equalsIgnoreCase(CoreServiceMappingTable.getServiceIDWithModelID(31))) {
                return 1;
            }
            if (string.equalsIgnoreCase(CoreServiceMappingTable.getServiceIDWithModelID(50))) {
                return 2;
            }
            if (string.equalsIgnoreCase(CoreServiceMappingTable.getServiceIDWithModelID(56))) {
                return 3;
            }
            if (string.equalsIgnoreCase(CoreServiceMappingTable.getServiceIDWithModelID(58))) {
                return 4;
            }
            if (string.equalsIgnoreCase(CoreServiceMappingTable.getServiceIDWithModelID(57))) {
                return 5;
            }
            if (string.equalsIgnoreCase(CoreServiceMappingTable.getServiceIDWithModelID(55))) {
                return 6;
            }
            if (string.equalsIgnoreCase(CoreServiceMappingTable.getServiceIDWithModelID(37))) {
                return 7;
            }
        }
        return -1;
    }

    private boolean getTrackingStatusWithServiceID(String string) {
        if (!Util.isNullOrEmpty(string)) {
            if (this.getOnlineNetworkTrackingServices() != null) {
                if (string.equalsIgnoreCase(CoreServiceMappingTable.getServiceIDWithModelID(23))) {
                    return this._onlineNetworkTrackingServices.isGeofenceActive();
                }
                if (string.equalsIgnoreCase(CoreServiceMappingTable.getServiceIDWithModelID(31))) {
                    return this._onlineNetworkTrackingServices.isSpeedAlertActive();
                }
                if (string.equalsIgnoreCase(CoreServiceMappingTable.getServiceIDWithModelID(50))) {
                    return this._onlineNetworkTrackingServices.isValetAlertActive();
                }
                if (string.equalsIgnoreCase(CoreServiceMappingTable.getServiceIDWithModelID(56))) {
                    return this._onlineNetworkTrackingServices.isVehicleLocationAndTrackingActive();
                }
                if (string.equalsIgnoreCase(CoreServiceMappingTable.getServiceIDWithModelID(58))) {
                    return this._onlineNetworkTrackingServices.isTimefenceActive();
                }
                if (string.equalsIgnoreCase(CoreServiceMappingTable.getServiceIDWithModelID(57))) {
                    return this._onlineNetworkTrackingServices.isDriversLogbookActive();
                }
                if (string.equalsIgnoreCase(CoreServiceMappingTable.getServiceIDWithModelID(55))) {
                    return this._onlineNetworkTrackingServices.isDriversEfficiencyReportActive();
                }
            }
            if (string.equalsIgnoreCase(CoreServiceMappingTable.getServiceIDWithModelID(37))) {
                return true;
            }
        }
        return false;
    }

    public boolean isTrackingServiceActiveMonitored(String string, boolean bl) {
        if (!Util.isNullOrEmpty(string) && bl && this.isTrackingService(string)) {
            return this.getTrackingStatusWithServiceID(string);
        }
        return false;
    }

    public void createTrackingServices() {
        this._trackingServices = CoreServiceCommonFactory.getTrackingServiceListInstance(8);
        if (!Util.isNullOrEmpty(this._trackingServices)) {
            this._trackingServices[0].setServiceID(CoreServiceMappingTable.getServiceIDWithModelID(23));
            this._trackingServices[1].setServiceID(CoreServiceMappingTable.getServiceIDWithModelID(31));
            this._trackingServices[2].setServiceID(CoreServiceMappingTable.getServiceIDWithModelID(50));
            this._trackingServices[3].setServiceID(CoreServiceMappingTable.getServiceIDWithModelID(56));
            this._trackingServices[4].setServiceID(CoreServiceMappingTable.getServiceIDWithModelID(58));
            this._trackingServices[5].setServiceID(CoreServiceMappingTable.getServiceIDWithModelID(55));
            this._trackingServices[6].setServiceID(CoreServiceMappingTable.getServiceIDWithModelID(57));
            this._trackingServices[7].setServiceID(CoreServiceMappingTable.getServiceIDWithModelID(37));
        }
    }

    public void setTrackingServicesCoding(int[] nArray) {
        ServiceManager.logger2.trace(16384).append("CoreSeviceOCUTrackingServicesHandler").append(new StringBuffer().append(".setTrackingServicesCoding(").append(Util.isNullOrEmpty(nArray) ? 0 : nArray.length).append(")").toString()).log();
        this._trackingServicesCoding = nArray;
    }

    public int[] getTrackingServicesCoding() {
        return this._trackingServicesCoding;
    }

    public int getTrackingServiceCodingWithIndex(int n) {
        if (n > -1 && !Util.isNullOrEmpty(this.getTrackingServicesCoding()) && n < this.getTrackingServicesCoding().length) {
            return this.getTrackingServicesCoding()[n];
        }
        return -1;
    }

    public boolean isTrackingServicesUpdateValid(OnlineNetworkTrackingServices onlineNetworkTrackingServices, boolean bl) {
        if (!Util.isNullOrEmpty(this._trackingServices) && onlineNetworkTrackingServices != null) {
            TrackingService trackingService = this.getServiceWithServiceID(CoreServiceMappingTable.getServiceIDWithModelID(23));
            if (trackingService != null && (!trackingService.isServiceActivatedInCurrentLifeCycle() && onlineNetworkTrackingServices.isGeofenceActive() && trackingService.isTrackingActivated() != onlineNetworkTrackingServices.isGeofenceActive() || bl && trackingService.isServiceActivatedInCurrentLifeCycle() && trackingService.isTrackingActivated() != onlineNetworkTrackingServices.isGeofenceActive())) {
                return true;
            }
            TrackingService trackingService2 = this.getServiceWithServiceID(CoreServiceMappingTable.getServiceIDWithModelID(31));
            if (trackingService2 != null && (!trackingService2.isServiceActivatedInCurrentLifeCycle() && onlineNetworkTrackingServices.isSpeedAlertActive() && trackingService2.isTrackingActivated() != onlineNetworkTrackingServices.isSpeedAlertActive() || bl && trackingService2.isServiceActivatedInCurrentLifeCycle() && trackingService2.isTrackingActivated() != onlineNetworkTrackingServices.isSpeedAlertActive())) {
                return true;
            }
            TrackingService trackingService3 = this.getServiceWithServiceID(CoreServiceMappingTable.getServiceIDWithModelID(50));
            if (trackingService3 != null && (!trackingService3.isServiceActivatedInCurrentLifeCycle() && onlineNetworkTrackingServices.isValetAlertActive() && trackingService3.isTrackingActivated() != onlineNetworkTrackingServices.isValetAlertActive() || bl && trackingService3.isServiceActivatedInCurrentLifeCycle() && trackingService3.isTrackingActivated() != onlineNetworkTrackingServices.isValetAlertActive())) {
                return true;
            }
            TrackingService trackingService4 = this.getServiceWithServiceID(CoreServiceMappingTable.getServiceIDWithModelID(56));
            if (trackingService4 != null && (!trackingService4.isServiceActivatedInCurrentLifeCycle() && onlineNetworkTrackingServices.isDriversEfficiencyReportActive() && trackingService4.isTrackingActivated() != onlineNetworkTrackingServices.isDriversEfficiencyReportActive() || bl && trackingService4.isServiceActivatedInCurrentLifeCycle() && trackingService4.isTrackingActivated() != onlineNetworkTrackingServices.isDriversEfficiencyReportActive())) {
                return true;
            }
            TrackingService trackingService5 = this.getServiceWithServiceID(CoreServiceMappingTable.getServiceIDWithModelID(58));
            if (trackingService5 != null && (!trackingService5.isServiceActivatedInCurrentLifeCycle() && onlineNetworkTrackingServices.isTimefenceActive() && trackingService5.isTrackingActivated() != onlineNetworkTrackingServices.isTimefenceActive() || bl && trackingService5.isServiceActivatedInCurrentLifeCycle() && trackingService5.isTrackingActivated() != onlineNetworkTrackingServices.isTimefenceActive())) {
                return true;
            }
            TrackingService trackingService6 = this.getServiceWithServiceID(CoreServiceMappingTable.getServiceIDWithModelID(57));
            if (trackingService6 != null && (!trackingService6.isServiceActivatedInCurrentLifeCycle() && onlineNetworkTrackingServices.isDriversLogbookActive() && trackingService6.isTrackingActivated() != onlineNetworkTrackingServices.isDriversLogbookActive() || bl && trackingService6.isServiceActivatedInCurrentLifeCycle() && trackingService6.isTrackingActivated() != onlineNetworkTrackingServices.isDriversLogbookActive())) {
                return true;
            }
            TrackingService trackingService7 = this.getServiceWithServiceID(CoreServiceMappingTable.getServiceIDWithModelID(55));
            if (trackingService7 != null && (!trackingService7.isServiceActivatedInCurrentLifeCycle() && onlineNetworkTrackingServices.isVehicleLocationAndTrackingActive() && trackingService7.isTrackingActivated() != onlineNetworkTrackingServices.isVehicleLocationAndTrackingActive() || bl && trackingService7.isServiceActivatedInCurrentLifeCycle() && trackingService7.isTrackingActivated() != onlineNetworkTrackingServices.isVehicleLocationAndTrackingActive())) {
                return true;
            }
        }
        return false;
    }

    public TrackingService[] getActiveTrackingServices(OnlineNetworkTrackingServices onlineNetworkTrackingServices) {
        TrackingService[] trackingServiceArray = null;
        if (onlineNetworkTrackingServices != null && !Util.isNullOrEmpty(this._trackingServices) && !Util.isNullOrEmpty(this.getTrackingServicesCoding())) {
            TrackingService trackingService;
            TrackingService trackingService2;
            TrackingService trackingService3;
            TrackingService trackingService4;
            TrackingService trackingService5;
            TrackingService trackingService6;
            ArrayList arrayList = new ArrayList();
            TrackingService trackingService7 = this.getServiceWithServiceID(CoreServiceMappingTable.getServiceIDWithModelID(23));
            if (trackingService7 != null && (trackingService7 = this.setGetTrackingInfo(trackingService7, onlineNetworkTrackingServices.isGeofenceActive(), 0)).isTrackingActivated()) {
                arrayList.add(trackingService7);
            }
            if ((trackingService6 = this.getServiceWithServiceID(CoreServiceMappingTable.getServiceIDWithModelID(31))) != null && (trackingService6 = this.setGetTrackingInfo(trackingService6, onlineNetworkTrackingServices.isSpeedAlertActive(), 1)).isTrackingActivated()) {
                arrayList.add(trackingService6);
            }
            if ((trackingService5 = this.getServiceWithServiceID(CoreServiceMappingTable.getServiceIDWithModelID(50))) != null && (trackingService5 = this.setGetTrackingInfo(trackingService5, onlineNetworkTrackingServices.isValetAlertActive(), 2)).isTrackingActivated()) {
                arrayList.add(trackingService5);
            }
            if ((trackingService4 = this.getServiceWithServiceID(CoreServiceMappingTable.getServiceIDWithModelID(56))) != null && (trackingService4 = this.setGetTrackingInfo(trackingService4, onlineNetworkTrackingServices.isDriversEfficiencyReportActive(), 6)).isTrackingActivated()) {
                arrayList.add(trackingService4);
            }
            if ((trackingService3 = this.getServiceWithServiceID(CoreServiceMappingTable.getServiceIDWithModelID(58))) != null && (trackingService3 = this.setGetTrackingInfo(trackingService3, onlineNetworkTrackingServices.isTimefenceActive(), 4)).isTrackingActivated()) {
                arrayList.add(trackingService3);
            }
            if ((trackingService2 = this.getServiceWithServiceID(CoreServiceMappingTable.getServiceIDWithModelID(57))) != null && (trackingService2 = this.setGetTrackingInfo(trackingService2, onlineNetworkTrackingServices.isDriversLogbookActive(), 5)).isTrackingActivated()) {
                arrayList.add(trackingService2);
            }
            if ((trackingService = this.getServiceWithServiceID(CoreServiceMappingTable.getServiceIDWithModelID(55))) != null && (trackingService = this.setGetTrackingInfo(trackingService, onlineNetworkTrackingServices.isVehicleLocationAndTrackingActive(), 3)).isTrackingActivated()) {
                arrayList.add(trackingService);
            }
            if (!arrayList.isEmpty()) {
                trackingServiceArray = (TrackingService[])arrayList.toArray(new TrackingServiceImpl[arrayList.size()]);
            }
        }
        return trackingServiceArray;
    }

    public boolean isTrackingServicesStatusChanged(OnlineNetworkTrackingServices onlineNetworkTrackingServices) {
        if (onlineNetworkTrackingServices != null && !Util.isNullOrEmpty(this._trackingServices)) {
            TrackingService trackingService = this.getServiceWithServiceID(CoreServiceMappingTable.getServiceIDWithModelID(23));
            if (trackingService != null && trackingService.isTrackingActivated() != onlineNetworkTrackingServices.isGeofenceActive()) {
                return true;
            }
            TrackingService trackingService2 = this.getServiceWithServiceID(CoreServiceMappingTable.getServiceIDWithModelID(31));
            if (trackingService2 != null && trackingService2.isTrackingActivated() != onlineNetworkTrackingServices.isSpeedAlertActive()) {
                return true;
            }
            TrackingService trackingService3 = this.getServiceWithServiceID(CoreServiceMappingTable.getServiceIDWithModelID(50));
            if (trackingService3 != null && trackingService3.isTrackingActivated() != onlineNetworkTrackingServices.isValetAlertActive()) {
                return true;
            }
            TrackingService trackingService4 = this.getServiceWithServiceID(CoreServiceMappingTable.getServiceIDWithModelID(56));
            if (trackingService4 != null && trackingService4.isTrackingActivated() != onlineNetworkTrackingServices.isDriversEfficiencyReportActive()) {
                return true;
            }
            TrackingService trackingService5 = this.getServiceWithServiceID(CoreServiceMappingTable.getServiceIDWithModelID(58));
            if (trackingService5 != null && trackingService5.isTrackingActivated() != onlineNetworkTrackingServices.isTimefenceActive()) {
                return true;
            }
            TrackingService trackingService6 = this.getServiceWithServiceID(CoreServiceMappingTable.getServiceIDWithModelID(57));
            if (trackingService6 != null && trackingService6.isTrackingActivated() != onlineNetworkTrackingServices.isDriversLogbookActive()) {
                return true;
            }
            TrackingService trackingService7 = this.getServiceWithServiceID(CoreServiceMappingTable.getServiceIDWithModelID(55));
            if (trackingService7 != null && trackingService7.isTrackingActivated() != onlineNetworkTrackingServices.isVehicleLocationAndTrackingActive()) {
                return true;
            }
        }
        return false;
    }

    public boolean isTrackingService(String string) {
        if (!Util.isNullOrEmpty(string)) {
            if (string.equalsIgnoreCase(CoreServiceMappingTable.getServiceIDWithModelID(23))) {
                return true;
            }
            if (string.equalsIgnoreCase(CoreServiceMappingTable.getServiceIDWithModelID(31))) {
                return true;
            }
            if (string.equalsIgnoreCase(CoreServiceMappingTable.getServiceIDWithModelID(50))) {
                return true;
            }
            if (string.equalsIgnoreCase(CoreServiceMappingTable.getServiceIDWithModelID(56))) {
                return true;
            }
            if (string.equalsIgnoreCase(CoreServiceMappingTable.getServiceIDWithModelID(58))) {
                return true;
            }
            if (string.equalsIgnoreCase(CoreServiceMappingTable.getServiceIDWithModelID(57))) {
                return true;
            }
            if (string.equalsIgnoreCase(CoreServiceMappingTable.getServiceIDWithModelID(55))) {
                return true;
            }
            if (string.equalsIgnoreCase(CoreServiceMappingTable.getServiceIDWithModelID(37))) {
                return true;
            }
        }
        return false;
    }

    public boolean isAnyTrackingServicesValid(OnlineNetworkTrackingServices onlineNetworkTrackingServices) {
        return onlineNetworkTrackingServices.isGeofenceActive() || onlineNetworkTrackingServices.isSpeedAlertActive() || onlineNetworkTrackingServices.isValetAlertActive() || onlineNetworkTrackingServices.isDriversEfficiencyReportActive() || onlineNetworkTrackingServices.isDriversLogbookActive() || onlineNetworkTrackingServices.isTimefenceActive() || onlineNetworkTrackingServices.isVehicleLocationAndTrackingActive();
    }

    public Device updateTrackingInfo(Device device, OnlineNetworkTrackingServices onlineNetworkTrackingServices) {
        this.setOnlineNetworkTrackingServices(onlineNetworkTrackingServices);
        if (device != null && !Util.isNullOrEmpty(device.getServiceList())) {
            Service service;
            Service service2;
            Service service3;
            Service service4;
            Service service5;
            Service service6;
            Service service7 = this.getServiceWithServiceID(device.getServiceList(), CoreServiceMappingTable.getServiceIDWithModelID(23));
            if (service7 != null) {
                service7 = this.setGetTrackingInfo(service7, onlineNetworkTrackingServices.isGeofenceActive());
                device.addService(service7);
            }
            if ((service6 = this.getServiceWithServiceID(device.getServiceList(), CoreServiceMappingTable.getServiceIDWithModelID(31))) != null) {
                service6 = this.setGetTrackingInfo(service6, onlineNetworkTrackingServices.isSpeedAlertActive());
                device.addService(service6);
            }
            if ((service5 = this.getServiceWithServiceID(device.getServiceList(), CoreServiceMappingTable.getServiceIDWithModelID(50))) != null) {
                service5 = this.setGetTrackingInfo(service5, onlineNetworkTrackingServices.isValetAlertActive());
                device.addService(service5);
            }
            if ((service4 = this.getServiceWithServiceID(device.getServiceList(), CoreServiceMappingTable.getServiceIDWithModelID(56))) != null) {
                service4 = this.setGetTrackingInfo(service4, onlineNetworkTrackingServices.isDriversEfficiencyReportActive());
                device.addService(service4);
            }
            if ((service3 = this.getServiceWithServiceID(device.getServiceList(), CoreServiceMappingTable.getServiceIDWithModelID(58))) != null) {
                service3 = this.setGetTrackingInfo(service3, onlineNetworkTrackingServices.isTimefenceActive());
                device.addService(service3);
            }
            if ((service2 = this.getServiceWithServiceID(device.getServiceList(), CoreServiceMappingTable.getServiceIDWithModelID(57))) != null) {
                service2 = this.setGetTrackingInfo(service2, onlineNetworkTrackingServices.isDriversLogbookActive());
                device.addService(service2);
            }
            if ((service = this.getServiceWithServiceID(device.getServiceList(), CoreServiceMappingTable.getServiceIDWithModelID(55))) != null) {
                service = this.setGetTrackingInfo(service, onlineNetworkTrackingServices.isVehicleLocationAndTrackingActive());
                device.addService(service);
            }
        }
        return device;
    }

    public boolean isTrackingServicesStatusChanged(Device device, OnlineNetworkTrackingServices onlineNetworkTrackingServices) {
        if (device != null && !Util.isNullOrEmpty(device.getServiceList())) {
            Service service = this.getServiceWithServiceID(device.getServiceList(), CoreServiceMappingTable.getServiceIDWithModelID(23));
            if (service != null && onlineNetworkTrackingServices.isGeofenceActive() && service.isTrackingActive() != onlineNetworkTrackingServices.isGeofenceActive()) {
                return true;
            }
            Service service2 = this.getServiceWithServiceID(device.getServiceList(), CoreServiceMappingTable.getServiceIDWithModelID(31));
            if (service2 != null && onlineNetworkTrackingServices.isSpeedAlertActive() && service2.isTrackingActive() != onlineNetworkTrackingServices.isSpeedAlertActive()) {
                return true;
            }
            Service service3 = this.getServiceWithServiceID(device.getServiceList(), CoreServiceMappingTable.getServiceIDWithModelID(50));
            if (service3 != null && onlineNetworkTrackingServices.isValetAlertActive() && service3.isTrackingActive() != onlineNetworkTrackingServices.isValetAlertActive()) {
                return true;
            }
            Service service4 = this.getServiceWithServiceID(device.getServiceList(), CoreServiceMappingTable.getServiceIDWithModelID(56));
            if (service4 != null && onlineNetworkTrackingServices.isDriversEfficiencyReportActive() && service4.isTrackingActive() != onlineNetworkTrackingServices.isDriversEfficiencyReportActive()) {
                return true;
            }
            Service service5 = this.getServiceWithServiceID(device.getServiceList(), CoreServiceMappingTable.getServiceIDWithModelID(58));
            if (service5 != null && onlineNetworkTrackingServices.isTimefenceActive() && service5.isTrackingActive() != onlineNetworkTrackingServices.isTimefenceActive()) {
                return true;
            }
            Service service6 = this.getServiceWithServiceID(device.getServiceList(), CoreServiceMappingTable.getServiceIDWithModelID(57));
            if (service6 != null && onlineNetworkTrackingServices.isDriversLogbookActive() && service6.isTrackingActive() != onlineNetworkTrackingServices.isDriversLogbookActive()) {
                return true;
            }
            Service service7 = this.getServiceWithServiceID(device.getServiceList(), CoreServiceMappingTable.getServiceIDWithModelID(55));
            if (service7 != null && onlineNetworkTrackingServices.isVehicleLocationAndTrackingActive() && service7.isTrackingActive() != onlineNetworkTrackingServices.isVehicleLocationAndTrackingActive()) {
                return true;
            }
        }
        return false;
    }

    public boolean isTrackingServicesUpdateValid(Device device, OnlineNetworkTrackingServices onlineNetworkTrackingServices) {
        if (device != null && !Util.isNullOrEmpty(device.getServiceList()) && onlineNetworkTrackingServices != null) {
            Service service = this.getServiceWithServiceID(device.getServiceList(), CoreServiceMappingTable.getServiceIDWithModelID(23));
            if (service != null && !service.isTrackingService() && onlineNetworkTrackingServices.isGeofenceActive() && service.isTrackingActive() != onlineNetworkTrackingServices.isGeofenceActive()) {
                return true;
            }
            Service service2 = this.getServiceWithServiceID(device.getServiceList(), CoreServiceMappingTable.getServiceIDWithModelID(31));
            if (service2 != null && !service2.isTrackingService() && onlineNetworkTrackingServices.isSpeedAlertActive() && service2.isTrackingActive() != onlineNetworkTrackingServices.isSpeedAlertActive()) {
                return true;
            }
            Service service3 = this.getServiceWithServiceID(device.getServiceList(), CoreServiceMappingTable.getServiceIDWithModelID(50));
            if (service3 != null && !service3.isTrackingService() && onlineNetworkTrackingServices.isValetAlertActive() && service3.isTrackingActive() != onlineNetworkTrackingServices.isValetAlertActive()) {
                return true;
            }
            Service service4 = this.getServiceWithServiceID(device.getServiceList(), CoreServiceMappingTable.getServiceIDWithModelID(56));
            if (service4 != null && !service4.isTrackingService() && onlineNetworkTrackingServices.isDriversEfficiencyReportActive() && service4.isTrackingActive() != onlineNetworkTrackingServices.isDriversEfficiencyReportActive()) {
                return true;
            }
            Service service5 = this.getServiceWithServiceID(device.getServiceList(), CoreServiceMappingTable.getServiceIDWithModelID(58));
            if (service5 != null && !service5.isTrackingService() && onlineNetworkTrackingServices.isTimefenceActive() && service5.isTrackingActive() != onlineNetworkTrackingServices.isTimefenceActive()) {
                return true;
            }
            Service service6 = this.getServiceWithServiceID(device.getServiceList(), CoreServiceMappingTable.getServiceIDWithModelID(57));
            if (service6 != null && !service6.isTrackingService() && onlineNetworkTrackingServices.isDriversLogbookActive() && service6.isTrackingActive() != onlineNetworkTrackingServices.isDriversLogbookActive()) {
                return true;
            }
            Service service7 = this.getServiceWithServiceID(device.getServiceList(), CoreServiceMappingTable.getServiceIDWithModelID(55));
            if (service7 != null && !service7.isTrackingService() && onlineNetworkTrackingServices.isVehicleLocationAndTrackingActive() && service7.isTrackingActive() != onlineNetworkTrackingServices.isVehicleLocationAndTrackingActive()) {
                return true;
            }
        }
        return false;
    }

    public OnlineNetworkTrackingServices getOnlineNetworkTrackingServices() {
        return this._onlineNetworkTrackingServices;
    }

    public void setOnlineNetworkTrackingServices(OnlineNetworkTrackingServices onlineNetworkTrackingServices) {
        this._onlineNetworkTrackingServices = onlineNetworkTrackingServices;
    }
}

