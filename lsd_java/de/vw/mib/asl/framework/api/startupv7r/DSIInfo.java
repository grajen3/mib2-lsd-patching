/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.startupv7r;

public class DSIInfo {
    public String interfaceName;
    public int instanceId;

    public DSIInfo(String string, int n) {
        this.interfaceName = string;
        this.instanceId = n;
    }

    public String toString() {
        return new StringBuffer().append("DSIInfo [interfaceName=").append(this.interfaceName).append(", instanceId=").append(this.instanceId).append("]").toString();
    }
}

