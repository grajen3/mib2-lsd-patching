/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.config;

import de.esolutions.fw.util.config.query.IConfigQuery;

public class TSTransportParam {
    private String file;
    private String mountpoint;

    public static TSTransportParam create(IConfigQuery iConfigQuery) {
        String string = iConfigQuery.getStringValue("ts.file");
        String string2 = iConfigQuery.getStringValue("ts.mountpoint");
        if (string == null && string2 == null) {
            return null;
        }
        TSTransportParam tSTransportParam = new TSTransportParam(string2, string);
        return tSTransportParam;
    }

    private TSTransportParam(String string, String string2) {
        this.mountpoint = string;
        this.file = string2;
    }

    public String getMountpoint() {
        return this.mountpoint;
    }

    public String getFile() {
        return this.file;
    }

    public String toString() {
        return new StringBuffer().append("[TS:").append(this.mountpoint).append(", ").append(this.file).append("]").toString();
    }

    public boolean equals(Object object) {
        if (!(object instanceof TSTransportParam)) {
            return false;
        }
        TSTransportParam tSTransportParam = (TSTransportParam)object;
        return tSTransportParam.file.equals(this.file) && tSTransportParam.mountpoint.equals(this.mountpoint);
    }

    public int hashCode() {
        int n = 1;
        n += 7 * this.file.hashCode();
        return n += 31 * this.mountpoint.hashCode();
    }
}

