/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.adapterOCU.control;

import de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkServiceListEntry;
import de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkUser;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.online.coreImpl.adapterOCU.CoreServiceOCUFactory;
import de.vw.mib.asl.internal.online.coreImpl.corecommon.CoreServiceCommonFactory;
import de.vw.mib.asl.internal.online.coreImpl.corecommon.CoreServiceMappingTable;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.Device;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.License;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.Service;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.User;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.util.Util;
import java.util.ArrayList;
import java.util.Random;
import org.dsi.ifc.global.DateTime;

public class CoreServiceOCUTransformer {
    private int getEnabledServiceState(boolean bl, boolean bl2) {
        int n = 2;
        n = bl ? 1 : n;
        n = bl && bl2 ? 3 : n;
        return n;
    }

    private User mappingToUser(OnlineNetworkUser onlineNetworkUser, User user) {
        if (onlineNetworkUser != null) {
            if (user == null) {
                user = CoreServiceCommonFactory.getUserInstance();
            }
            Random random = new Random();
            user.setUserID(random.nextInt(10));
            user.setDeviceID(1);
            user.setUserName(onlineNetworkUser.getUserName());
            if (ServiceManager.logger2.isTraceEnabled(16384)) {
                LogMessage logMessage = ServiceManager.logger2.trace(16384);
                logMessage.append(new StringBuffer().append("User Name = ").append(Util.isNullOrEmpty(user.getUserName()) ? "EMPTY NAME" : user.getUserName()).append(")").toString()).log();
            }
            user.setUserType(onlineNetworkUser.getUserType().value());
            user.setAsMainUser(onlineNetworkUser.getUserType().value() == 0);
        }
        return user;
    }

    private int getServiceState(OnlineNetworkServiceListEntry onlineNetworkServiceListEntry, int n, boolean bl, boolean bl2) {
        int n2 = 0;
        if (!onlineNetworkServiceListEntry.isServiceNotBlockedByDriver()) {
            n2 = 6;
        } else if (onlineNetworkServiceListEntry.getServiceLicenseState().value() != 0 && CoreServiceMappingTable.getInternalLicenseState(onlineNetworkServiceListEntry.getServiceLicenseState().value(), n) != 1) {
            n2 = 5;
        } else if (!onlineNetworkServiceListEntry.isServiceEnabled()) {
            n2 = 7;
        } else if (bl) {
            n2 = 1;
        }
        if (n2 != 0 && !bl2) {
            n2 = 3;
        }
        return n2;
    }

    private int getServiceState(Service service, int n, boolean bl, boolean bl2) {
        int n2 = 0;
        if (service.getEnabledState() == 2) {
            n2 = 6;
        } else if (service.isLicenseAvailable() && service.getMainLicense() != null && service.getMainLicense().getLicenseState() != 1) {
            n2 = 5;
        } else if (!service.isDisabledActivation()) {
            n2 = 7;
        } else if (n != 0) {
            n2 = 2;
        } else if (bl) {
            n2 = 1;
        }
        if (n2 != 0 && !bl2) {
            n2 = 3;
        }
        return n2;
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

    public Device transformToDevice(OnlineNetworkServiceListEntry[] onlineNetworkServiceListEntryArray, Device device, boolean bl) {
        device = this.transformToDeviceWithServiceList(this.transformToServices(onlineNetworkServiceListEntryArray, device != null ? device.getServiceList() : null, device != null ? device.getDeviceID() : 1, bl), device);
        return device;
    }

    public Device transformToDeviceWithServiceList(Service[] serviceArray, Device device) {
        if (device == null) {
            device = CoreServiceOCUFactory.getOCUDevice();
            device.setDeviceType(0);
        }
        device.setServiceList(serviceArray);
        return device;
    }

    public Device transformToDeviceWithUserList(User[] userArray, Device device) {
        if (device == null) {
            device = CoreServiceOCUFactory.getOCUDevice();
            device.setDeviceType(0);
        }
        device.setUserList(userArray);
        return device;
    }

    public Service[] transformToServices(OnlineNetworkServiceListEntry[] onlineNetworkServiceListEntryArray, Service[] serviceArray, int n, boolean bl) {
        if (!Util.isNullOrEmpty(onlineNetworkServiceListEntryArray)) {
            int n2 = onlineNetworkServiceListEntryArray.length;
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < n2; ++i2) {
                if (!CoreServiceMappingTable.isValidService(onlineNetworkServiceListEntryArray[i2].getServiceId())) continue;
                Service service = null;
                if (!Util.isNullOrEmpty(serviceArray)) {
                    service = this.getServiceFromServiceList(onlineNetworkServiceListEntryArray[i2].getServiceId(), serviceArray);
                }
                service = this.mapToInternalService(onlineNetworkServiceListEntryArray[i2], service, n, bl);
                arrayList.add(service);
            }
            if (!arrayList.isEmpty()) {
                serviceArray = (Service[])arrayList.toArray(CoreServiceCommonFactory.getServiceListInstance(arrayList.size()));
            }
        }
        return serviceArray;
    }

    public User[] transformToUsers(OnlineNetworkUser[] onlineNetworkUserArray, User[] userArray) {
        if (!Util.isNullOrEmpty(onlineNetworkUserArray)) {
            int n = onlineNetworkUserArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                if (Util.isNullOrEmpty(userArray) || n != userArray.length) {
                    userArray = CoreServiceCommonFactory.getUserListInstance(onlineNetworkUserArray.length);
                }
                userArray[i2] = this.mappingToUser(onlineNetworkUserArray[i2], userArray[i2]);
            }
        }
        return userArray;
    }

    public License transformToLicense(OnlineNetworkServiceListEntry onlineNetworkServiceListEntry, License license) {
        License license2 = license;
        if (onlineNetworkServiceListEntry != null) {
            if (license2 == null) {
                license2 = CoreServiceCommonFactory.getLicenseInstance();
            }
            license2.setLicenseID(onlineNetworkServiceListEntry.getServiceLicenseId());
            license2.setLicenseState(CoreServiceMappingTable.getInternalLicenseState(onlineNetworkServiceListEntry.getServiceLicenseState().value(), 1));
            license2.setLicenseExpiry(new DateTime(onlineNetworkServiceListEntry.getExpirationDate().getTime()));
            license2.setActivationDate(new DateTime(onlineNetworkServiceListEntry.getActivationDate().getTime()));
            license2.setPeriodOfValidityDate(new DateTime(onlineNetworkServiceListEntry.getPeriodOfValidityDate().getTime()));
            license2.setLicenseType(0);
        }
        return license2;
    }

    public Device updateDeviceConnectionStatus(Device device, int n, boolean bl) {
        if (device == null) {
            device = CoreServiceOCUFactory.getOCUDevice();
            device.setDeviceType(0);
            device.setServiceList(null);
        }
        if (device != null && !Util.isNullOrEmpty(device.getServiceList())) {
            int n2 = device.getServiceList().length;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (device.getServiceList()[i2] == null) continue;
                device.getServiceList()[i2].setServiceState(this.getServiceState(device.getServiceList()[i2], n, device.getServiceList()[i2].isTrackingActive(), bl));
            }
        }
        return device;
    }

    public Service mapToInternalService(OnlineNetworkServiceListEntry onlineNetworkServiceListEntry, Service service, int n, boolean bl) {
        if (onlineNetworkServiceListEntry != null) {
            int[] nArray;
            if (service == null) {
                service = CoreServiceCommonFactory.getServiceInstance();
                service.setServiceID(onlineNetworkServiceListEntry.getServiceId());
                service.setServiceName(onlineNetworkServiceListEntry.getServiceName());
                service.setDeviceID(n);
                service.setInvisible(CoreServiceMappingTable.isServiceInvisible(service.getServiceID()));
            }
            service.setEnabledState(this.getEnabledServiceState(onlineNetworkServiceListEntry.isServiceNotBlockedByDriver(), onlineNetworkServiceListEntry.isServiceRoamingAllowed()));
            boolean bl2 = CoreServiceOCUFactory.getTrackingServicesHandler().isTrackingService(service.getServiceID());
            service.setTrackingService(bl2);
            service.setTrackingToActive(bl2 && CoreServiceOCUFactory.getTrackingServicesHandler().isTrackingServiceActiveMonitored(service.getServiceID(), service.getEnabledState() != 2));
            service.setLicenseAvailability(onlineNetworkServiceListEntry.getServiceLicenseState().value() != 0);
            service.setAPN(0);
            if (bl2) {
                int[] nArray2 = new int[2];
                nArray2[0] = 1;
                nArray = nArray2;
                nArray2[1] = 2;
            } else {
                int[] nArray3 = new int[1];
                nArray = nArray3;
                nArray3[0] = 1;
            }
            service.setPrivacyGroups(nArray);
            service.setCategories(CoreServiceMappingTable.getCategoriesWithServiceID(service.getServiceID()));
            service.setServicePackage(CoreServiceMappingTable.getGroupWithServiceID(service.getServiceID()));
            service.setServiceType(1);
            service.setESIMUsageAllowed(false);
            service.setPrimaryUserRequired(true);
            service.setTermsAndConditionsRequired(false);
            service.setServiceDisablingBlocked(onlineNetworkServiceListEntry.isServiceBlockingProtected());
            service.setServiceState(this.getServiceState(onlineNetworkServiceListEntry, n, service.isTrackingActive(), bl));
            service.setDisabledActivation(onlineNetworkServiceListEntry.isServiceEnabled());
            License license = service.getMainLicense();
            if (!Util.isNullOrEmpty(onlineNetworkServiceListEntry.getServiceLicenseId()) && service.isLicenseAvailable()) {
                if (license == null) {
                    license = CoreServiceCommonFactory.getLicenseInstance();
                    license.setLicenseID(onlineNetworkServiceListEntry.getServiceLicenseId());
                }
                license.setLicenseState(CoreServiceMappingTable.getInternalLicenseState(onlineNetworkServiceListEntry.getServiceLicenseState().value(), n));
                license.setLicenseValidity(onlineNetworkServiceListEntry.getServiceLicenseState().value() == 2);
                license.setLicenseExpiry(new DateTime(onlineNetworkServiceListEntry.getExpirationDate().getTime()));
                license.setActivationDate(new DateTime(onlineNetworkServiceListEntry.getActivationDate().getTime()));
                license.setPeriodOfValidityDate(new DateTime(onlineNetworkServiceListEntry.getPeriodOfValidityDate().getTime()));
                license.setLicenseType(0);
            }
            service.setMainLicense(license);
        }
        return service;
    }
}

