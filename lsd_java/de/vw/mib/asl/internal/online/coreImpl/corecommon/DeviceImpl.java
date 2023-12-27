/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.corecommon;

import de.vw.mib.asl.internal.online.coreImpl.corecommon.CoreServiceCommonFactory;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.Device;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.Service;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.User;
import de.vw.mib.util.Util;
import edu.emory.mathcs.backport.java.util.Arrays;

public class DeviceImpl
implements Device {
    private int _deviceID;
    private String _deviceName;
    private int _deviceType;
    private User[] _userList;
    private Service[] _serviceList;

    public DeviceImpl(int n, String string) {
        this._deviceID = n;
        this._deviceName = string;
    }

    @Override
    public int getDeviceID() {
        return this._deviceID;
    }

    @Override
    public String getDeviceName() {
        return this._deviceName;
    }

    @Override
    public boolean isMainDevice() {
        return 1 == this._deviceType;
    }

    @Override
    public void setUserList(User[] userArray) {
        this._userList = userArray;
    }

    @Override
    public void addUser(User user) {
        if (user != null) {
            if (Util.isNullOrEmpty(this._userList)) {
                this._userList = new User[1];
                this._userList[0] = CoreServiceCommonFactory.getUserInstance();
                this._userList[0].copyTo(user);
            } else {
                User user2 = this.getUserWithID(user.getUserID());
                if (user2 != null) {
                    user2.copyTo(user);
                } else {
                    this._userList = (User[])Arrays.copyOf(this._userList, this._userList.length + 1);
                    this._userList[this._userList.length - 1] = CoreServiceCommonFactory.getUserInstance();
                    this._userList[this._userList.length - 1].copyTo(user);
                }
            }
        }
    }

    @Override
    public User[] getUserList() {
        return this._userList;
    }

    @Override
    public boolean checkIfUserAvailable(User user) {
        return user != null && !Util.isNullOrEmpty(this._userList) && this.getUserWithID(user.getUserID()) != null;
    }

    @Override
    public User getUserWithID(int n) {
        if (n > -1 && !Util.isNullOrEmpty(this._userList)) {
            int n2 = this._userList.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (this._userList[i2] == null || this._userList[i2].getUserID() != n) continue;
                return this._userList[i2];
            }
        }
        return null;
    }

    @Override
    public void setServiceList(Service[] serviceArray) {
        this._serviceList = serviceArray;
    }

    @Override
    public void addService(Service service) {
        if (service != null) {
            if (Util.isNullOrEmpty(this._serviceList)) {
                this._serviceList = new Service[1];
                this._serviceList[0] = CoreServiceCommonFactory.getServiceInstance();
                this._serviceList[0].copyTo(service);
            } else {
                Service service2 = this.getServiceWithID(service.getServiceID());
                if (service2 != null) {
                    service2.copyTo(service);
                } else {
                    this._serviceList = (Service[])Arrays.copyOf(this._serviceList, this._serviceList.length + 1);
                    this._serviceList[this._serviceList.length - 1] = CoreServiceCommonFactory.getServiceInstance();
                    this._serviceList[this._serviceList.length - 1].copyTo(service);
                }
            }
        }
    }

    @Override
    public Service[] getServiceList() {
        return this._serviceList;
    }

    @Override
    public boolean checkIfServiceAvailable(Service service) {
        return service != null && !Util.isNullOrEmpty(this._serviceList) && this.getServiceWithID(service.getServiceID()) != null;
    }

    @Override
    public Service getServiceWithID(String string) {
        if (!Util.isNullOrEmpty(string) && !Util.isNullOrEmpty(this._serviceList)) {
            int n = this._serviceList.length;
            for (int i2 = 0; i2 < n; ++i2) {
                if (this._serviceList[i2] == null || Util.isNullOrEmpty(this._serviceList[i2].getServiceID()) || !this._serviceList[i2].getServiceID().equalsIgnoreCase(string)) continue;
                return this._serviceList[i2];
            }
        }
        return null;
    }

    @Override
    public void setDeviceType(int n) {
        this._deviceType = n;
    }

    @Override
    public int getDeviceType() {
        return this._deviceType;
    }

    @Override
    public void copyTo(Device device) {
        if (device != null && this != device) {
            int n;
            int n2;
            this._deviceID = device.getDeviceID();
            this._deviceName = device.getDeviceName();
            this._deviceType = device.getDeviceType();
            if (!Util.isNullOrEmpty(device.getServiceList())) {
                n2 = device.getServiceList().length;
                this._serviceList = CoreServiceCommonFactory.getServiceListInstance(n2);
                for (n = 0; n < n2; ++n) {
                    if (this._serviceList[n] == null) {
                        this._serviceList[n] = CoreServiceCommonFactory.getServiceInstance();
                    }
                    this._serviceList[n].copyTo(device.getServiceList()[n]);
                }
            } else {
                this._serviceList = null;
            }
            if (!Util.isNullOrEmpty(device.getUserList())) {
                n2 = device.getUserList().length;
                this._userList = CoreServiceCommonFactory.getUserListInstance(n2);
                for (n = 0; n < n2; ++n) {
                    if (this._userList[n] == null) {
                        this._userList[n] = CoreServiceCommonFactory.getUserInstance();
                    }
                    this._userList[n].copyTo(device.getUserList()[n]);
                }
            } else {
                this._userList = null;
            }
        }
    }

    public String toString() {
        int n;
        int n2;
        int n3;
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("Device");
        stringBuffer.append('(');
        stringBuffer.append("DeviceID");
        stringBuffer.append('=');
        stringBuffer.append(this._deviceID);
        stringBuffer.append(',');
        stringBuffer.append("DeviceName");
        stringBuffer.append('=');
        stringBuffer.append(!Util.isNullOrEmpty(this._deviceName) ? this._deviceName : "");
        stringBuffer.append(',');
        stringBuffer.append("DeviceType");
        stringBuffer.append('=');
        stringBuffer.append(this._deviceType);
        stringBuffer.append(',');
        stringBuffer.append("ServiceList");
        stringBuffer.append('[');
        if (!Util.isNullOrEmpty(this._serviceList)) {
            stringBuffer.append(this._serviceList.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (!Util.isNullOrEmpty(this._serviceList)) {
            n3 = this._serviceList.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this._serviceList[n].toString());
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this._serviceList);
        }
        stringBuffer.append('}');
        stringBuffer.append("UserList");
        stringBuffer.append('[');
        if (!Util.isNullOrEmpty(this._userList)) {
            stringBuffer.append(this._userList.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (!Util.isNullOrEmpty(this._userList)) {
            n3 = this._userList.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this._userList[n].toString());
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this._userList);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

