/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.online.coreservice;

import java.util.Arrays;

public class License {
    public String id;
    public int state;
    public long activation;
    public long expires;
    public String duration;
    public String[] country;
    public String serviceID;
    public boolean warn;
    public String name;

    public String getId() {
        return this.id;
    }

    public void setId(String string) {
        this.id = string;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int n) {
        this.state = n;
    }

    public long getActivation() {
        return this.activation;
    }

    public void setActivation(long l) {
        this.activation = l;
    }

    public long getExpires() {
        return this.expires;
    }

    public void setExpires(long l) {
        this.expires = l;
    }

    public String getDuration() {
        return this.duration;
    }

    public void setDuration(String string) {
        this.duration = string;
    }

    public String[] getCountry() {
        return this.country;
    }

    public void setCountry(String[] stringArray) {
        this.country = stringArray;
    }

    public String getServiceID() {
        return this.serviceID;
    }

    public void setServiceID(String string) {
        this.serviceID = string;
    }

    public boolean isWarn() {
        return this.warn;
    }

    public void setWarn(boolean bl) {
        this.warn = bl;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }

    public License() {
    }

    public License(String string, int n, long l, long l2, String string2, String[] stringArray, String string3, boolean bl, String string4) {
        this.id = string;
        this.state = n;
        this.activation = l;
        this.expires = l2;
        this.duration = string2;
        this.country = stringArray;
        this.serviceID = string3;
        this.warn = bl;
        this.name = string4;
    }

    public String toString() {
        return new StringBuffer("License{").append("id=").append(this.id).append(", state=").append(this.state).append(", activation=").append(this.activation).append(", expires=").append(this.expires).append(", duration=").append(this.duration).append(", country=").append("[").append(this.country == null ? "null" : Arrays.asList(this.country).toString()).append("]").append(", serviceID=").append(this.serviceID).append(", warn=").append(this.warn).append(", name=").append(this.name).append("}").toString();
    }
}

