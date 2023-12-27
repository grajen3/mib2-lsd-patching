/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.clients.model.common;

import de.vw.mib.asl.internal.online.coreInterfaces.core.client.OnlineService;
import de.vw.mib.util.Util;
import java.util.Arrays;

public class OnlineServicePackage {
    private int _packageID;
    private int _packageState;
    private int _packageCategory;
    private OnlineService[] _services;

    public int getPackageID() {
        return this._packageID;
    }

    public void setPackageID(int n) {
        this._packageID = n;
    }

    public int getPackageState() {
        return this._packageState;
    }

    public void setPackageState(int n) {
        this._packageState = n;
    }

    public int getPackageCategory() {
        return this._packageCategory;
    }

    public void setPackageCategory(int n) {
        this._packageCategory = n;
    }

    public OnlineService[] getServices() {
        return this._services;
    }

    public void setServices(OnlineService[] onlineServiceArray) {
        this._services = onlineServiceArray;
    }

    public void addService(OnlineService onlineService) {
        if (onlineService != null) {
            if (Util.isNullOrEmpty(this._services)) {
                this._services = new OnlineService[1];
                this._services[0] = onlineService;
            } else {
                OnlineService onlineService2 = this.getServiceWithID(onlineService.getServiceID());
                if (onlineService2 != null) {
                    onlineService2.copyTo(onlineService);
                } else {
                    this._services = (OnlineService[])edu.emory.mathcs.backport.java.util.Arrays.copyOf(this._services, this._services.length + 1);
                    this._services[this._services.length - 1] = onlineService;
                }
            }
        }
    }

    private OnlineService getServiceWithID(String string) {
        if (!Util.isNullOrEmpty(string) && !Util.isNullOrEmpty(this._services)) {
            int n = this._services.length;
            for (int i2 = 0; i2 < n; ++i2) {
                if (this._services[i2] == null || Util.isNullOrEmpty(this._services[i2].getServiceID()) || !this._services[i2].getServiceID().equalsIgnoreCase(string)) continue;
                return this._services[i2];
            }
        }
        return null;
    }

    public void copyTo(OnlineServicePackage onlineServicePackage) {
        if (onlineServicePackage != null && this != onlineServicePackage) {
            this._packageID = onlineServicePackage.getPackageID();
            this._packageCategory = onlineServicePackage.getPackageCategory();
            this._packageState = onlineServicePackage.getPackageState();
            this._services = Util.isNullOrEmpty(onlineServicePackage.getServices()) ? null : (OnlineService[])edu.emory.mathcs.backport.java.util.Arrays.copyOf(onlineServicePackage.getServices(), onlineServicePackage.getServices().length);
        }
    }

    public String toString() {
        return new StringBuffer().append("OnlineServicePackage [_packageID=").append(this._packageID).append(", _packageState=").append(this._packageState).append(", _packageCategory=").append(this._packageCategory).append(", _services=").append(this._services != null ? Arrays.asList(this._services) : null).append("]").toString();
    }
}

