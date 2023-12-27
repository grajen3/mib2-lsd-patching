/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.online.OperatorCallAddressEntry;

public class OperatorCallResult {
    public String serviceId;
    public int serviceType;
    public String name;
    public OperatorCallAddressEntry address;
    public NavLocationWgs84 location;

    public OperatorCallResult() {
        this.serviceId = null;
        this.serviceType = 0;
        this.name = null;
        this.address = null;
        this.location = null;
    }

    public OperatorCallResult(String string, int n, String string2, OperatorCallAddressEntry operatorCallAddressEntry, NavLocationWgs84 navLocationWgs84) {
        this.serviceId = string;
        this.serviceType = n;
        this.name = string2;
        this.address = operatorCallAddressEntry;
        this.location = navLocationWgs84;
    }

    public String getServiceId() {
        return this.serviceId;
    }

    public int getServiceType() {
        return this.serviceType;
    }

    public String getName() {
        return this.name;
    }

    public OperatorCallAddressEntry getAddress() {
        return this.address;
    }

    public NavLocationWgs84 getLocation() {
        return this.location;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(2300);
        stringBuffer.append("OperatorCallResult");
        stringBuffer.append('(');
        stringBuffer.append("serviceId");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.serviceId);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("serviceType");
        stringBuffer.append('=');
        stringBuffer.append(this.serviceType);
        stringBuffer.append(',');
        stringBuffer.append("name");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.name);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("address");
        stringBuffer.append('=');
        stringBuffer.append(this.address);
        stringBuffer.append(',');
        stringBuffer.append("location");
        stringBuffer.append('=');
        stringBuffer.append(this.location);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

