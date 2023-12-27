/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab;

import org.dsi.ifc.radio.ServiceInfo;

public class ServiceInfoHash {
    public int ensID;
    public int ensECC;
    public long sID;
    public long mFrequency;

    public ServiceInfoHash(ServiceInfo serviceInfo) {
        this.ensID = serviceInfo.ensID;
        this.ensECC = serviceInfo.ensECC;
        this.sID = serviceInfo.sID;
    }

    public ServiceInfoHash(ServiceInfo serviceInfo, long l) {
        this.ensID = serviceInfo.ensID;
        this.ensECC = serviceInfo.ensECC;
        this.sID = serviceInfo.sID;
        this.mFrequency = l;
    }

    public int hashCode() {
        int n = 31;
        int n2 = 1;
        n2 = 31 * n2 + this.ensECC;
        n2 = 31 * n2 + this.ensID;
        n2 = 31 * n2 + (int)(this.sID ^ this.sID >>> 32);
        n2 = 31 * n2 + (int)(this.mFrequency ^ this.mFrequency >>> 32);
        return n2;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        ServiceInfoHash serviceInfoHash = (ServiceInfoHash)object;
        if (this.ensECC != serviceInfoHash.ensECC) {
            return false;
        }
        if (this.ensID != serviceInfoHash.ensID) {
            return false;
        }
        if (this.sID != serviceInfoHash.sID) {
            return false;
        }
        return this.mFrequency == serviceInfoHash.mFrequency;
    }
}

