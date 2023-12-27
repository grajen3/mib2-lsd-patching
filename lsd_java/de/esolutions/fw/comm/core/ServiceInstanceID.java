/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core;

import de.esolutions.fw.comm.core.ServiceUUID;

public class ServiceInstanceID {
    private final ServiceUUID uuid;
    private int handle;
    private final ServiceUUID interfaceKey;
    private String description;

    public ServiceInstanceID() {
        this.uuid = new ServiceUUID();
        this.handle = 0;
        this.interfaceKey = new ServiceUUID();
    }

    public ServiceInstanceID(ServiceUUID serviceUUID, int n, ServiceUUID serviceUUID2) {
        this.uuid = serviceUUID;
        this.handle = n;
        this.interfaceKey = serviceUUID2 == null ? new ServiceUUID() : serviceUUID2;
    }

    public ServiceInstanceID(String string, int n, String string2) {
        this.uuid = new ServiceUUID(string);
        this.handle = n;
        this.interfaceKey = string2 != null ? new ServiceUUID(string2) : new ServiceUUID();
    }

    public ServiceInstanceID(ServiceUUID serviceUUID, int n, ServiceUUID serviceUUID2, String string) {
        this(serviceUUID, n, serviceUUID2);
        this.description = string;
    }

    public ServiceInstanceID(String string, int n, String string2, String string3) {
        this(string, n, string2);
        this.description = string3;
    }

    public ServiceUUID getServiceUUID() {
        return this.uuid;
    }

    public void setHandle(int n) {
        this.handle = n;
    }

    public int getHandle() {
        return this.handle;
    }

    public ServiceUUID getInterfaceKey() {
        return this.interfaceKey;
    }

    public String getDescription() {
        return this.description;
    }

    public String toString() {
        if (this.description != null) {
            return new StringBuffer().append("['").append(this.description).append("'=").append(this.uuid).append(":0x").append(Integer.toHexString(this.handle)).append(":").append(this.interfaceKey).append("]").toString();
        }
        return new StringBuffer().append("[").append(this.uuid).append(":0x").append(Integer.toHexString(this.handle)).append(":").append(this.interfaceKey).append("]").toString();
    }

    public boolean equals(Object object) {
        if (!(object instanceof ServiceInstanceID)) {
            return false;
        }
        ServiceInstanceID serviceInstanceID = (ServiceInstanceID)object;
        return this.uuid.equals(serviceInstanceID.uuid) && this.handle == serviceInstanceID.handle;
    }

    public int hashCode() {
        int n = 1;
        n += 7 * this.handle;
        if (this.uuid != null) {
            n += 41 * this.uuid.toString().hashCode();
        }
        if (this.interfaceKey != null) {
            n += 31 * this.interfaceKey.toString().hashCode();
        }
        return n;
    }
}

