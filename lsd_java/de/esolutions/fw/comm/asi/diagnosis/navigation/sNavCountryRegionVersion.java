/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.navigation;

import de.esolutions.fw.comm.asi.diagnosis.navigation.sNavCountryRegionVersionEntry;
import java.util.Arrays;

public class sNavCountryRegionVersion {
    public long msg_id;
    public short status;
    public sNavCountryRegionVersionEntry[] versionList;

    public long getMsg_id() {
        return this.msg_id;
    }

    public void setMsg_id(long l) {
        this.msg_id = l;
    }

    public short getStatus() {
        return this.status;
    }

    public void setStatus(short s) {
        this.status = s;
    }

    public sNavCountryRegionVersionEntry[] getVersionList() {
        return this.versionList;
    }

    public void setVersionList(sNavCountryRegionVersionEntry[] sNavCountryRegionVersionEntryArray) {
        this.versionList = sNavCountryRegionVersionEntryArray;
    }

    public sNavCountryRegionVersion() {
        this.versionList = null;
    }

    public sNavCountryRegionVersion(long l, short s, sNavCountryRegionVersionEntry[] sNavCountryRegionVersionEntryArray) {
        this.msg_id = l;
        this.status = s;
        this.versionList = sNavCountryRegionVersionEntryArray;
    }

    public String toString() {
        return new StringBuffer("sNavCountryRegionVersion{").append("msg_id=").append(this.msg_id).append(", status=").append(this.status).append(", versionList=").append("[").append(this.versionList == null ? "null" : Arrays.asList(this.versionList).toString()).append("]").append("}").toString();
    }
}

