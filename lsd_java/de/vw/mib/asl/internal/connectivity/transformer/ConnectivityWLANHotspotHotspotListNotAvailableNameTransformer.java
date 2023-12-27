/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.connectivity.transformer;

import de.vw.mib.asl.internal.connectivity.transformer.WlanTrustedNetworkCollector;
import generated.de.vw.mib.asl.internal.connectivity.transformer.AbstractConnectivityWLANHotspotHotspotListNotAvailableNameTransformer;

public class ConnectivityWLANHotspotHotspotListNotAvailableNameTransformer
extends AbstractConnectivityWLANHotspotHotspotListNotAvailableNameTransformer {
    @Override
    public String getString(int n, Object object) {
        WlanTrustedNetworkCollector wlanTrustedNetworkCollector = (WlanTrustedNetworkCollector)object;
        switch (n) {
            case 0: {
                return wlanTrustedNetworkCollector.trustedNetworkName;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }
}

