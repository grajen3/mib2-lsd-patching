/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.corecommon;

import de.vw.mib.asl.internal.online.coreImpl.corecommon.CoreServiceCommonFactory;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.Application;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.Service;
import de.vw.mib.util.Util;
import edu.emory.mathcs.backport.java.util.Arrays;

public class ApplicationImpl
implements Application {
    private String _applicationID;
    private int _deviceID;
    private int _applicationState;
    private boolean _applicationActive;
    private boolean _invisibleApplication;
    private Service[] _serviceList;
    private boolean _deactivationBlocked;

    @Override
    public void setApplicationID(String string) {
        this._applicationID = string;
    }

    @Override
    public String getApplicationID() {
        return this._applicationID;
    }

    @Override
    public void setDeviceID(int n) {
        this._deviceID = n;
    }

    @Override
    public int getDeviceID() {
        return this._deviceID;
    }

    @Override
    public void setApplicationState(int n) {
        this._applicationState = n;
    }

    @Override
    public int getApplicationState() {
        return this._applicationState;
    }

    @Override
    public void deactivateApplication(boolean bl) {
        this._applicationActive = bl;
    }

    @Override
    public boolean isApplicationDeactivated() {
        return this._applicationActive;
    }

    @Override
    public boolean isDeactivationBlocked() {
        return this._deactivationBlocked;
    }

    @Override
    public void setDeactivationBlocked(boolean bl) {
        this._deactivationBlocked = bl;
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
    public Service getServiceWithID(String string) {
        if (!Util.isNullOrEmpty(string) && !Util.isNullOrEmpty(this._serviceList)) {
            int n = this._serviceList.length;
            for (int i2 = 0; i2 < n; ++i2) {
                if (!this._serviceList[i2].getServiceID().equalsIgnoreCase(string)) continue;
                return this._serviceList[i2];
            }
        }
        return null;
    }

    @Override
    public void setApplicationInvisible(boolean bl) {
        this._invisibleApplication = bl;
    }

    @Override
    public boolean isApplicationInvisible() {
        return this._invisibleApplication;
    }

    @Override
    public boolean isServiceExists(Service service, String string) {
        if (!Util.isNullOrEmpty(this._serviceList)) {
            String string2 = string;
            if (service != null) {
                string2 = service.getServiceID();
            }
            if (this.getServiceWithID(string2) != null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void copyTo(Application application) {
        if (application != null && this != application) {
            this._applicationID = application.getApplicationID();
            this._applicationState = application.getApplicationState();
            this._applicationActive = application.isApplicationDeactivated();
            this._invisibleApplication = application.isApplicationInvisible();
            this._deactivationBlocked = application.isDeactivationBlocked();
            this._deviceID = application.getDeviceID();
            if (!Util.isNullOrEmpty(application.getServiceList())) {
                int n = application.getServiceList().length;
                this._serviceList = CoreServiceCommonFactory.getServiceListInstance(n);
                for (int i2 = 0; i2 < n; ++i2) {
                    this._serviceList[i2].copyTo(application.getServiceList()[i2]);
                }
            }
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("Application");
        stringBuffer.append('(');
        stringBuffer.append("applicationID");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(!Util.isNullOrEmpty(this._applicationID) ? this._applicationID : "");
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("DeviceID");
        stringBuffer.append('=');
        stringBuffer.append(this._deviceID);
        stringBuffer.append(',');
        stringBuffer.append("State");
        stringBuffer.append('=');
        stringBuffer.append(this._applicationState);
        stringBuffer.append(',');
        stringBuffer.append("Active");
        stringBuffer.append('=');
        stringBuffer.append(this._applicationActive);
        stringBuffer.append(',');
        stringBuffer.append("Invisible");
        stringBuffer.append('=');
        stringBuffer.append(this._invisibleApplication);
        stringBuffer.append(',');
        stringBuffer.append("DeactivationBlocked");
        stringBuffer.append('=');
        stringBuffer.append(this._deactivationBlocked);
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
            int n = this._serviceList.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this._serviceList[i2].toString());
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this._serviceList);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

