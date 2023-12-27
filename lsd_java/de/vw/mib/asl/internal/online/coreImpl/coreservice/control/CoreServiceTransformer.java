/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.coreservice.control;

import de.vw.mib.asl.internal.online.coreImpl.corecommon.CoreServiceCommonFactory;
import de.vw.mib.asl.internal.online.coreImpl.corecommon.CoreServiceMappingTable;
import de.vw.mib.asl.internal.online.coreInterfaces.core.client.OnlineLicense;
import de.vw.mib.asl.internal.online.coreInterfaces.core.client.OnlineService;
import de.vw.mib.asl.internal.online.coreInterfaces.core.client.OnlineTrackingService;
import de.vw.mib.asl.internal.online.coreInterfaces.core.client.OnlineUser;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.Device;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.License;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.Service;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.TrackingService;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.User;
import de.vw.mib.collections.ints.IntArrayList;
import de.vw.mib.util.Util;
import edu.emory.mathcs.backport.java.util.Arrays;
import java.util.ArrayList;
import java.util.Date;

public class CoreServiceTransformer {
    public Device getDeviceFromDeviceListWithDeviceID(int n, Device[] deviceArray) {
        if (n > -1 && !Util.isNullOrEmpty(deviceArray)) {
            int n2 = deviceArray.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (deviceArray[i2].getDeviceID() != n) continue;
                return deviceArray[i2];
            }
        }
        return null;
    }

    public Device[] addOrUpdateDeviceToDeviceList(Device device, Device[] deviceArray, int n) {
        if (device != null) {
            if (Util.isNullOrEmpty(deviceArray)) {
                deviceArray = CoreServiceCommonFactory.getDeviceListInstance(1);
                deviceArray[0] = CoreServiceCommonFactory.getDeviceInstance(device.getDeviceID(), device.getDeviceName());
                deviceArray[0].copyTo(device);
            } else {
                Device device2 = this.getDeviceFromDeviceListWithDeviceID(device.getDeviceID(), deviceArray);
                if (device2 != null) {
                    device2.copyTo(device);
                } else {
                    deviceArray = (Device[])Arrays.copyOf(deviceArray, deviceArray.length + 1);
                    deviceArray[deviceArray.length - 1] = CoreServiceCommonFactory.getDeviceInstance(device.getDeviceID(), device.getDeviceName());
                    deviceArray[deviceArray.length - 1].copyTo(device);
                }
            }
        }
        return deviceArray;
    }

    public Device[] updateServiceListToDeviceList(Service[] serviceArray, Device[] deviceArray, int n) {
        deviceArray = this.updateServiceListToDeviceList(serviceArray, deviceArray, n);
        return deviceArray;
    }

    public Device[] updateUserListToDeviceList(User[] userArray, Device[] deviceArray, int n) {
        if (Util.isNullOrEmpty(deviceArray)) {
            if (!Util.isNullOrEmpty(userArray)) {
                int n2;
                int n3 = userArray.length;
                IntArrayList intArrayList = new IntArrayList();
                for (n2 = 0; n2 < n3; ++n2) {
                    if (intArrayList.contains(userArray[n2].getDeviceID())) continue;
                    intArrayList.add(userArray[n2].getDeviceID());
                }
                n2 = intArrayList.size();
                deviceArray = CoreServiceCommonFactory.getDeviceListInstance(n2);
                for (int i2 = 0; i2 < n2; ++i2) {
                    deviceArray[i2] = CoreServiceCommonFactory.getDeviceInstance(intArrayList.get(i2), "");
                    for (int i3 = 0; i3 < userArray.length; ++i3) {
                        deviceArray[i2].addUser(userArray[i3]);
                    }
                }
            }
        } else if (!Util.isNullOrEmpty(userArray)) {
            int n4 = userArray.length;
            for (int i4 = 0; i4 < n4; ++i4) {
                Device device = this.getDeviceFromDeviceListWithDeviceID(userArray[i4].getDeviceID(), deviceArray);
                if (device == null) continue;
                User user = device.getUserWithID(userArray[i4].getUserID());
                if (user != null) {
                    user.copyTo(userArray[i4]);
                    continue;
                }
                device.addUser(userArray[i4]);
            }
        } else {
            Device device = this.getDeviceFromDeviceListWithDeviceID(n, deviceArray);
            if (device != null) {
                device.setUserList(userArray);
            }
        }
        return deviceArray;
    }

    public Service[] extractServiceListFromDeviceList(Device[] deviceArray) {
        Object[] objectArray = null;
        if (!Util.isNullOrEmpty(deviceArray)) {
            int n = 0;
            int n2 = deviceArray.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                Object[] objectArray2 = deviceArray[i2].getServiceList();
                if (Util.isNullOrEmpty(objectArray2)) continue;
                if (objectArray != null && !Util.isNullOrEmpty(objectArray)) {
                    n = objectArray.length;
                    objectArray = (Service[])Arrays.copyOf(objectArray, n + objectArray2.length);
                } else {
                    objectArray = CoreServiceCommonFactory.getServiceListInstance(objectArray2.length);
                }
                System.arraycopy((Object)objectArray2, 0, (Object)objectArray, n, objectArray2.length);
            }
        }
        return objectArray;
    }

    public User[] extractUserListFromDeviceList(Device[] deviceArray) {
        User[] userArray = null;
        if (!Util.isNullOrEmpty(deviceArray)) {
            int n = 0;
            int n2 = deviceArray.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                Object[] objectArray = deviceArray[i2].getUserList();
                if (Util.isNullOrEmpty(objectArray)) continue;
                if (userArray != null && !Util.isNullOrEmpty(userArray)) {
                    n = userArray.length;
                } else {
                    userArray = CoreServiceCommonFactory.getUserListInstance(objectArray.length);
                }
                System.arraycopy((Object)objectArray, 0, (Object)userArray, n, objectArray.length);
            }
        }
        return userArray;
    }

    public OnlineService[] transformToClientServiceList(Service[] serviceArray, Device[] deviceArray, OnlineService[] onlineServiceArray) {
        if (!Util.isNullOrEmpty(serviceArray)) {
            int n = serviceArray.length;
            ArrayList arrayList = new ArrayList();
            if (Util.isNullOrEmpty(onlineServiceArray)) {
                for (int i2 = 0; i2 < n; ++i2) {
                    if (serviceArray[i2].isInvisible() || !serviceArray[i2].isLicenseAvailable()) continue;
                    OnlineService onlineService = this.mapServiceToClientService(serviceArray[i2], deviceArray, new OnlineService());
                    arrayList.add(onlineService);
                }
            } else {
                for (int i3 = 0; i3 < n; ++i3) {
                    if (serviceArray[i3].isInvisible() || !serviceArray[i3].isLicenseAvailable()) continue;
                    OnlineService onlineService = this.getServiceWithServiceID(serviceArray[i3].getServiceID(), onlineServiceArray);
                    onlineService = this.mapServiceToClientService(serviceArray[i3], deviceArray, onlineService != null ? onlineService : new OnlineService());
                    arrayList.add(onlineService);
                }
            }
            if (!arrayList.isEmpty()) {
                onlineServiceArray = (OnlineService[])arrayList.toArray(new OnlineService[arrayList.size()]);
            }
            return onlineServiceArray;
        }
        return null;
    }

    private OnlineService getServiceWithServiceID(String string, OnlineService[] onlineServiceArray) {
        if (!Util.isNullOrEmpty(onlineServiceArray) && !Util.isNullOrEmpty(string)) {
            int n = onlineServiceArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                if (!string.equalsIgnoreCase(onlineServiceArray[i2].getServiceID())) continue;
                return onlineServiceArray[i2];
            }
        }
        return null;
    }

    private OnlineService mapServiceToClientService(Service service, Device[] deviceArray, OnlineService onlineService) {
        if (service != null) {
            if (onlineService == null) {
                onlineService = new OnlineService();
            }
            onlineService.setServiceID(service.getServiceID());
            onlineService.setServiceName(service.getServiceName());
            onlineService.setDeviceID(service.getDeviceID());
            onlineService.setServiceState(service.getServiceState());
            onlineService.setDisabledActivation(service.isDisabledActivation());
            onlineService.setEnabledState(service.getEnabledState() != 2);
            onlineService.setDeactivationBlocked(service.isServiceDisablingBlocked());
            onlineService.setLicense(this.transformToClientLicense(service.getMainLicense(), service.getServiceID()));
            onlineService.setUsers(this.transformToClientUserList(this.getDeviceFromDeviceListWithDeviceID(service.getDeviceID(), deviceArray).getUserList()));
            onlineService.setValidLicense(service.isLicenseAvailable());
            onlineService.setPrivacyGroups(service.getPrivacyGroups());
            onlineService.setCategory(service.getCategories());
            onlineService.setApn(service.getAPN());
            onlineService.setTrackingService(service.isTrackingService());
            onlineService.setTrackingToActive(service.isTrackingActive());
        }
        return onlineService;
    }

    public OnlineLicense transformToClientLicense(License license, String string) {
        if (license != null) {
            OnlineLicense onlineLicense = new OnlineLicense();
            onlineLicense.setLicenseID(license.getLicenseID());
            onlineLicense.setLicenseState(license.getLicenseState());
            onlineLicense.setExpiryDate(license.getLicenseExpiry() != null ? new Date(license.getLicenseExpiry().getTime()) : null);
            onlineLicense.setLicenseType(license.getLicenseType());
            onlineLicense.setServiceID(string);
            return onlineLicense;
        }
        return null;
    }

    public OnlineUser[] transformToClientUserList(User[] userArray) {
        if (!Util.isNullOrEmpty(userArray)) {
            int n = userArray.length;
            OnlineUser[] onlineUserArray = new OnlineUser[n];
            for (int i2 = 0; i2 < n; ++i2) {
                onlineUserArray[i2] = new OnlineUser();
                onlineUserArray[i2].setUserID(userArray[i2].getUserID());
                onlineUserArray[i2].setUserName(userArray[i2].getUserName());
                onlineUserArray[i2].setUserType(CoreServiceMappingTable.getOnlineUserTypeWithUserType(userArray[i2].getUserType()));
            }
            return onlineUserArray;
        }
        return null;
    }

    public OnlineTrackingService[] transformToClientTrackingServices(TrackingService[] trackingServiceArray) {
        if (!Util.isNullOrEmpty(trackingServiceArray)) {
            int n = trackingServiceArray.length;
            OnlineTrackingService[] onlineTrackingServiceArray = new OnlineTrackingService[n];
            for (int i2 = 0; i2 < n; ++i2) {
                onlineTrackingServiceArray[i2] = new OnlineTrackingService();
                onlineTrackingServiceArray[i2].setServiceID(trackingServiceArray[i2].getServiceID());
                onlineTrackingServiceArray[i2].setServiceToActivationInCurrentLifeCycle(trackingServiceArray[i2].isServiceActivatedInCurrentLifeCycle());
                onlineTrackingServiceArray[i2].setTrackingActivated(trackingServiceArray[i2].isTrackingActivated());
            }
            return onlineTrackingServiceArray;
        }
        return null;
    }
}

