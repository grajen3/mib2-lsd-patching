/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.connectivity.esim;

import de.vw.mib.asl.api.connectivity.services.datavolume.DataTraffic;

public class DataTrafficImpl
implements DataTraffic {
    String simId;
    int apnId;
    long bytesReceived;
    long bytesSent;

    public DataTrafficImpl(String string, int n, long l, long l2) {
        this.simId = string;
        this.apnId = n;
        this.bytesReceived = l;
        this.bytesSent = l2;
    }

    @Override
    public String getServiceId() {
        return this.simId;
    }

    @Override
    public int getApn() {
        return this.apnId;
    }

    @Override
    public long getBytesSent() {
        return this.bytesSent;
    }

    @Override
    public long getBytesReceived() {
        return this.bytesReceived;
    }
}

