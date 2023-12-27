/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.connectivity.transformer;

import org.dsi.ifc.networking.DiscoveredNetwork;

public class ConnectivityWLANHotspotHotspotListCollector {
    public DiscoveredNetwork discoveredNetwork = null;
    public boolean isTrustedDevice = false;
    public boolean isAvailable = false;

    public ConnectivityWLANHotspotHotspotListCollector(DiscoveredNetwork discoveredNetwork, boolean bl, boolean bl2) {
        this.discoveredNetwork = discoveredNetwork;
        this.isTrustedDevice = bl;
        this.isAvailable = bl2;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ConnectivityWLANHotspotHotspotListCollector [discoveredNetwork=");
        stringBuffer.append(this.discoveredNetwork);
        stringBuffer.append(", isTrustedDevice=");
        stringBuffer.append(this.isTrustedDevice);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}

