/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

import org.dsi.ifc.global.DateTime;

public class OSRLicense {
    public String id;
    public int state;
    public DateTime activation;
    public DateTime expires;
    public String duration;
    public String[] country;
    public String serviceID;
    public boolean warn;
    public String name;
    public String description;
    public String[] onlineserviceassignments;
    public int type;

    public OSRLicense() {
        this.id = null;
        this.state = 6;
        this.activation = null;
        this.expires = null;
        this.duration = null;
        this.country = null;
        this.serviceID = null;
        this.warn = false;
        this.name = null;
        this.description = null;
        this.onlineserviceassignments = null;
        this.type = 0;
    }

    public OSRLicense(String string, int n, DateTime dateTime, DateTime dateTime2, String string2, String[] stringArray, String string3, boolean bl, String string4, String string5, String[] stringArray2, int n2) {
        this.id = string;
        this.state = n;
        this.activation = dateTime;
        this.expires = dateTime2;
        this.duration = string2;
        this.country = stringArray;
        this.serviceID = string3;
        this.warn = bl;
        this.name = string4;
        this.description = string5;
        this.onlineserviceassignments = stringArray2;
        this.type = n2;
    }

    public String getId() {
        return this.id;
    }

    public int getState() {
        return this.state;
    }

    public DateTime getActivation() {
        return this.activation;
    }

    public DateTime getExpires() {
        return this.expires;
    }

    public String getDuration() {
        return this.duration;
    }

    public String[] getCountry() {
        return this.country;
    }

    public String getServiceID() {
        return this.serviceID;
    }

    public boolean isWarn() {
        return this.warn;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String[] getOnlineserviceassignments() {
        return this.onlineserviceassignments;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        int n;
        int n2;
        int n3;
        StringBuffer stringBuffer = new StringBuffer(2700);
        stringBuffer.append("OSRLicense");
        stringBuffer.append('(');
        stringBuffer.append("id");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.id);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("state");
        stringBuffer.append('=');
        stringBuffer.append(this.state);
        stringBuffer.append(',');
        stringBuffer.append("activation");
        stringBuffer.append('=');
        stringBuffer.append(this.activation);
        stringBuffer.append(',');
        stringBuffer.append("expires");
        stringBuffer.append('=');
        stringBuffer.append(this.expires);
        stringBuffer.append(',');
        stringBuffer.append("duration");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.duration);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("country");
        stringBuffer.append('[');
        if (this.country != null) {
            stringBuffer.append(this.country.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.country != null) {
            n3 = this.country.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append('\"');
                stringBuffer.append(this.country[n]);
                stringBuffer.append('\"');
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.country);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("serviceID");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.serviceID);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("warn");
        stringBuffer.append('=');
        stringBuffer.append(this.warn);
        stringBuffer.append(',');
        stringBuffer.append("name");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.name);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("description");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.description);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("onlineserviceassignments");
        stringBuffer.append('[');
        if (this.onlineserviceassignments != null) {
            stringBuffer.append(this.onlineserviceassignments.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.onlineserviceassignments != null) {
            n3 = this.onlineserviceassignments.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append('\"');
                stringBuffer.append(this.onlineserviceassignments[n]);
                stringBuffer.append('\"');
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.onlineserviceassignments);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("type");
        stringBuffer.append('=');
        stringBuffer.append(this.type);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

