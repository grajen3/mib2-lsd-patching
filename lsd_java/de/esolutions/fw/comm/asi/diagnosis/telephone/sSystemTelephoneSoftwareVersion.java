/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.telephone;

public class sSystemTelephoneSoftwareVersion {
    public long msg_id;
    public String version;

    public long getMsg_id() {
        return this.msg_id;
    }

    public void setMsg_id(long l) {
        this.msg_id = l;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String string) {
        this.version = string;
    }

    public sSystemTelephoneSoftwareVersion() {
    }

    public sSystemTelephoneSoftwareVersion(long l, String string) {
        this.msg_id = l;
        this.version = string;
    }

    public String toString() {
        return new StringBuffer("sSystemTelephoneSoftwareVersion{").append("msg_id=").append(this.msg_id).append(", version=").append(this.version).append("}").toString();
    }
}

