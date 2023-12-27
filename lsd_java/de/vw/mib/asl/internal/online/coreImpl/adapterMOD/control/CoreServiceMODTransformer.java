/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.adapterMOD.control;

import de.vw.mib.asl.internal.online.coreImpl.adapterMOD.CoreServiceMODFactory;
import de.vw.mib.asl.internal.online.coreImpl.corecommon.CoreServiceCommonFactory;
import de.vw.mib.asl.internal.online.coreImpl.corecommon.CoreServiceMappingTable;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.Device;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.License;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.Service;
import de.vw.mib.collections.ObjectIntOptHashMap;
import de.vw.mib.util.Util;
import java.util.ArrayList;
import org.dsi.ifc.global.DateTime;
import org.dsi.ifc.online.OSRLicense;
import org.dsi.ifc.online.OSRNotifyPropertiesSL;
import org.dsi.ifc.online.OSRServiceListEntry;

public class CoreServiceMODTransformer {
    private int getServiceState(OSRServiceListEntry oSRServiceListEntry, int n) {
        int n2 = n;
        if (oSRServiceListEntry != null) {
            if (oSRServiceListEntry.getLicense() != null && oSRServiceListEntry.getLicense().getState() != 1) {
                int n3 = n2 = oSRServiceListEntry.getLicense().getState() == 3 ? 3 : 5;
            }
            if (!Util.isBitSet(1, oSRServiceListEntry.getVehicleLocalServiceState())) {
                n2 = 6;
            }
        }
        return n2;
    }

    private Service extractServiceState(OSRNotifyPropertiesSL oSRNotifyPropertiesSL, Service service, boolean bl, int n) {
        if (service != null && oSRNotifyPropertiesSL != null) {
            int n2 = -1;
            if (oSRNotifyPropertiesSL.getPrivacyConflict() != 0) {
                n2 = 6;
                service.setEnabledState(2);
                service.setServiceDisablingBlocked(true);
            } else {
                service.setEnabledState(1);
                service.setServiceDisablingBlocked(false);
            }
            if (oSRNotifyPropertiesSL.getReasonConfig() != 0) {
                if (Util.isBitSet(2, oSRNotifyPropertiesSL.getReasonConfig()) || Util.isBitSet(32, oSRNotifyPropertiesSL.getReasonConfig()) || oSRNotifyPropertiesSL.getReasonConfig() == 1) {
                    n2 = 6;
                    service.setEnabledState(2);
                } else if (Util.isBitSet(4, oSRNotifyPropertiesSL.getReasonConfig()) || oSRNotifyPropertiesSL.getReasonConfig() == 2) {
                    n2 = 4;
                }
            }
            if (oSRNotifyPropertiesSL.getReasonLicense() != 0) {
                n2 = 5;
                if (Util.isBitSet(8, oSRNotifyPropertiesSL.getReasonLicense())) {
                    n2 = 8;
                }
            }
            if (oSRNotifyPropertiesSL.getReasonBackend() != 0) {
                n2 = Util.isBitSet(2, oSRNotifyPropertiesSL.getReasonBackend()) ? 3 : (Util.isBitSet(4, oSRNotifyPropertiesSL.getReasonBackend()) ? 5 : 7);
            }
            if (oSRNotifyPropertiesSL.getReasonConnectivity() != 0) {
                n2 = 2;
            }
            if (oSRNotifyPropertiesSL.getReasonConfig() + oSRNotifyPropertiesSL.getReasonConnectivity() + oSRNotifyPropertiesSL.getReasonLicense() + oSRNotifyPropertiesSL.getReasonBackend() + oSRNotifyPropertiesSL.getPrivacyConflict() == 0) {
                service.setEnabledState(bl ? 3 : 1);
                n2 = 0;
            }
            if (n2 == 0 && !Util.isBitSet(4, n)) {
                n2 = 2;
            }
            if (n2 > -1) {
                service.setServiceState(n2);
            }
        }
        return service;
    }

    public Service mapExternalToInternalService(OSRServiceListEntry oSRServiceListEntry, Service service, int n) {
        if (oSRServiceListEntry != null) {
            if (service == null) {
                service = CoreServiceCommonFactory.getServiceInstance();
                service.setServiceID(oSRServiceListEntry.getServiceID());
                service.setDeviceID(n);
                service.setInvisible(CoreServiceMappingTable.isServiceInvisible(service.getServiceID()));
            }
            service.setServiceState(this.getServiceState(oSRServiceListEntry, service.getServiceState()));
            service.setEnabledState(this.getEnabledServiceState(oSRServiceListEntry.getVehicleLocalServiceState()));
            service.setDisabledActivation(false);
            service.setLicenseAvailability(oSRServiceListEntry.isLicenseRequired());
            service.setMainLicense(this.transformToLicense(oSRServiceListEntry.license, null));
            service.setTrackingService(false);
            service.setTrackingToActive(false);
            service.setAPN(oSRServiceListEntry.getApn());
            service.setPrivacyGroups(CoreServiceMappingTable.getPrivacyGroup(oSRServiceListEntry.getPrivacyGroup()));
            service.setCategories(CoreServiceMappingTable.getCategoriesWithServiceID(service.getServiceID()));
            service.setServicePackage(CoreServiceMappingTable.getGroupWithServiceID(service.getServiceID()));
            service.setServiceType(oSRServiceListEntry.getServiceType());
            service.setESIMUsageAllowed(false);
            service.setPrimaryUserRequired(false);
            service.setTermsAndConditionsRequired(oSRServiceListEntry.isTermsAndConditionsRequired());
            service.setServiceDisablingBlocked(oSRServiceListEntry.isBlocksDisabling());
        }
        return service;
    }

    public Service getServiceFromServiceList(String string, Service[] serviceArray) {
        if (!Util.isNullOrEmpty(string) && !Util.isNullOrEmpty(serviceArray)) {
            int n = serviceArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                if (!string.equalsIgnoreCase(serviceArray[i2].getServiceID())) continue;
                return serviceArray[i2];
            }
        }
        return null;
    }

    public int getEnabledServiceState(int n) {
        int n2 = 2;
        n2 = Util.isBitSet(1, n) ? 1 : n2;
        n2 = Util.isBitSet(1, n) && Util.isBitSet(2, n) ? 3 : n2;
        return n2;
    }

    public boolean checkIfCoreServiceIsAvailable(Service[] serviceArray) {
        if (!Util.isNullOrEmpty(serviceArray)) {
            int n = serviceArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                if (Util.isNullOrEmpty(serviceArray[i2].getServiceID()) || !serviceArray[i2].getServiceID().equalsIgnoreCase(CoreServiceMappingTable.getServiceIDWithModelID(0))) continue;
                return true;
            }
        }
        return false;
    }

    public Device transformToDevice(Service[] serviceArray, Device device) {
        if (device == null) {
            device = CoreServiceMODFactory.getMODDevice();
            device.setDeviceType(0);
            device.setUserList(null);
        }
        device.setServiceList(serviceArray);
        return device;
    }

    public Service[] transformToServices(OSRServiceListEntry[] oSRServiceListEntryArray, Service[] serviceArray, int n) {
        if (!Util.isNullOrEmpty(oSRServiceListEntryArray)) {
            int n2 = oSRServiceListEntryArray.length;
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < n2; ++i2) {
                if (oSRServiceListEntryArray[i2] == null || !CoreServiceMappingTable.isValidService(oSRServiceListEntryArray[i2].getServiceID())) continue;
                Service service = null;
                if (!Util.isNullOrEmpty(serviceArray)) {
                    service = this.getServiceFromServiceList(oSRServiceListEntryArray[i2].getServiceID(), serviceArray);
                }
                service = this.mapExternalToInternalService(oSRServiceListEntryArray[i2], service, n);
                arrayList.add(service);
            }
            if (!arrayList.isEmpty()) {
                serviceArray = (Service[])arrayList.toArray(CoreServiceCommonFactory.getServiceListInstance(arrayList.size()));
            }
        }
        return serviceArray;
    }

    public License transformToLicense(OSRLicense oSRLicense, License license) {
        License license2 = license;
        if (oSRLicense != null) {
            if (license2 == null) {
                license2 = CoreServiceCommonFactory.getLicenseInstance();
            }
            license2.setLicenseID(oSRLicense.getId());
            license2.setLicenseState(oSRLicense.getState());
            license2.setLicenseExpiry(oSRLicense.getExpires() != null ? (oSRLicense.getExpires().getTime() > 0L ? oSRLicense.getExpires() : null) : null);
            license2.setLicenseType(oSRLicense.getType());
            license2.setLicenseValidity(oSRLicense.getExpires() != null && oSRLicense.getExpires().getTime() > new DateTime().getTime());
        }
        return license2;
    }

    public Service[] updateServiceWithLicense(OSRLicense oSRLicense, Service[] serviceArray) {
        String string;
        if (oSRLicense != null && !Util.isNullOrEmpty(serviceArray) && !Util.isNullOrEmpty(string = oSRLicense.getServiceID())) {
            int n = serviceArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                if (!serviceArray[i2].getServiceID().equalsIgnoreCase(string)) continue;
            }
        }
        return serviceArray;
    }

    public Service[] updateServices(OSRNotifyPropertiesSL[] oSRNotifyPropertiesSLArray, Service[] serviceArray, int n, boolean bl) {
        block4: {
            if (Util.isNullOrEmpty(serviceArray)) break block4;
            if (!Util.isNullOrEmpty(oSRNotifyPropertiesSLArray)) {
                int n2 = oSRNotifyPropertiesSLArray.length;
                for (int i2 = 0; i2 < n2; ++i2) {
                    Service service = this.getServiceFromServiceList(oSRNotifyPropertiesSLArray[i2].getServiceID(), serviceArray);
                    service = this.extractServiceState(oSRNotifyPropertiesSLArray[i2], service, bl, n);
                }
            } else {
                int n3 = serviceArray.length;
                for (int i3 = 0; i3 < n3; ++i3) {
                    serviceArray[i3].setServiceState(2);
                }
            }
        }
        return serviceArray;
    }

    public ObjectIntOptHashMap updateServicesReasonResult(OSRNotifyPropertiesSL[] oSRNotifyPropertiesSLArray, ObjectIntOptHashMap objectIntOptHashMap) {
        if (!Util.isNullOrEmpty(oSRNotifyPropertiesSLArray)) {
            int n = oSRNotifyPropertiesSLArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                String string = oSRNotifyPropertiesSLArray[i2].getServiceID();
                int n2 = 0;
                if (oSRNotifyPropertiesSLArray[i2].getPrivacyConflict() != 0) {
                    n2 = 24;
                }
                if (oSRNotifyPropertiesSLArray[i2].getReasonConfig() != 0) {
                    n2 = Util.isBitSet(4, oSRNotifyPropertiesSLArray[i2].getReasonConfig()) ? 2 : 24;
                }
                if (oSRNotifyPropertiesSLArray[i2].getReasonLicense() != 0) {
                    n2 = 50;
                }
                if (oSRNotifyPropertiesSLArray[i2].getReasonBackend() != 0) {
                    if (Util.isBitSet(64, oSRNotifyPropertiesSLArray[i2].getReasonBackend())) {
                        n2 = 13;
                    }
                    if (Util.isBitSet(32, oSRNotifyPropertiesSLArray[i2].getReasonBackend())) {
                        n2 = 13;
                    }
                    if (Util.isBitSet(16, oSRNotifyPropertiesSLArray[i2].getReasonBackend())) {
                        n2 = 13;
                    }
                    if (Util.isBitSet(8, oSRNotifyPropertiesSLArray[i2].getReasonBackend())) {
                        n2 = 55;
                    }
                    if (Util.isBitSet(4, oSRNotifyPropertiesSLArray[i2].getReasonBackend())) {
                        n2 = 50;
                    }
                    if (Util.isBitSet(2, oSRNotifyPropertiesSLArray[i2].getReasonBackend())) {
                        n2 = 15;
                    }
                    if (Util.isBitSet(1, oSRNotifyPropertiesSLArray[i2].getReasonBackend())) {
                        n2 = 14;
                    }
                }
                if (oSRNotifyPropertiesSLArray[i2].getReasonConnectivity() != 0) {
                    n2 = 6;
                }
                if (oSRNotifyPropertiesSLArray[i2].getReasonConfig() + oSRNotifyPropertiesSLArray[i2].getReasonConnectivity() + oSRNotifyPropertiesSLArray[i2].getReasonLicense() + oSRNotifyPropertiesSLArray[i2].getReasonBackend() + oSRNotifyPropertiesSLArray[i2].getPrivacyConflict() == 0) {
                    n2 = 0;
                }
                objectIntOptHashMap.put(string, n2);
            }
        }
        return objectIntOptHashMap;
    }

    public boolean checkForPrivacyModeActiveStatus(OSRNotifyPropertiesSL[] oSRNotifyPropertiesSLArray) {
        if (!Util.isNullOrEmpty(oSRNotifyPropertiesSLArray)) {
            int n = oSRNotifyPropertiesSLArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                if (oSRNotifyPropertiesSLArray[i2].getPrivacyConflict() == 0 || !Util.isBitSet(32, oSRNotifyPropertiesSLArray[i2].getPrivacyConflict())) continue;
                return true;
            }
        }
        return false;
    }
}

