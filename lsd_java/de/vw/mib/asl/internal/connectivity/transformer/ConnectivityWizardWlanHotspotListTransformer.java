/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.connectivity.transformer;

import de.vw.mib.asl.internal.connectivity.transformer.ConnectivityWLANHotspotHotspotListCollector;
import de.vw.mib.asl.internal.connectivity.util.ConnectivityUtil;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.connectivity.transformer.AbstractConnectivityWizardWlanHotspotListTransformer;

public class ConnectivityWizardWlanHotspotListTransformer
extends AbstractConnectivityWizardWlanHotspotListTransformer {
    @Override
    public int getInt(int n, Object object) {
        ConnectivityWLANHotspotHotspotListCollector connectivityWLANHotspotHotspotListCollector = (ConnectivityWLANHotspotHotspotListCollector)object;
        switch (n) {
            case 3: {
                return ConnectivityUtil.convertDSICryptoModel2ASLEncryptionType(connectivityWLANHotspotHotspotListCollector.discoveredNetwork.getEncryptionType());
            }
            case 2: {
                return connectivityWLANHotspotHotspotListCollector.discoveredNetwork.getSignalStrength() > 0 && connectivityWLANHotspotHotspotListCollector.discoveredNetwork.getSignalStrength() < 5 ? connectivityWLANHotspotHotspotListCollector.discoveredNetwork.getSignalStrength() : 0;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public String getString(int n, Object object) {
        ConnectivityWLANHotspotHotspotListCollector connectivityWLANHotspotHotspotListCollector = (ConnectivityWLANHotspotHotspotListCollector)object;
        switch (n) {
            case 0: {
                return Util.isNullOrEmpty(connectivityWLANHotspotHotspotListCollector.discoveredNetwork.getNetworkName()) ? connectivityWLANHotspotHotspotListCollector.discoveredNetwork.getBssidAddress() : connectivityWLANHotspotHotspotListCollector.discoveredNetwork.getNetworkName();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }
}

