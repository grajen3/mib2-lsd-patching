/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.calendar.db.provider;

public class VersionInfo {
    public int version;
    public int profileId;

    public int getVersion() {
        return this.version;
    }

    public void setVersion(int n) {
        this.version = n;
    }

    public int getProfileId() {
        return this.profileId;
    }

    public void setProfileId(int n) {
        this.profileId = n;
    }

    public VersionInfo() {
    }

    public VersionInfo(int n, int n2) {
        this.version = n;
        this.profileId = n2;
    }

    public String toString() {
        return new StringBuffer("VersionInfo{").append("version=").append(this.version).append(", profileId=").append(this.profileId).append("}").toString();
    }
}

