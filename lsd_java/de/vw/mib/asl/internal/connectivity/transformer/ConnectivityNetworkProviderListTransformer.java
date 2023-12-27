/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.connectivity.transformer;

import de.vw.mib.asl.internal.connectivity.transformer.ConnectivityNetworkProviderListCollector;
import generated.de.vw.mib.asl.internal.connectivity.transformer.AbstractConnectivityNetworkProviderListTransformer;

public class ConnectivityNetworkProviderListTransformer
extends AbstractConnectivityNetworkProviderListTransformer {
    @Override
    public String getString(int n, Object object) {
        ConnectivityNetworkProviderListCollector connectivityNetworkProviderListCollector = (ConnectivityNetworkProviderListCollector)object;
        switch (n) {
            case 1: {
                return connectivityNetworkProviderListCollector.networkProvider.getTelLongProviderName();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public int getInt(int n, Object object) {
        ConnectivityNetworkProviderListCollector connectivityNetworkProviderListCollector = (ConnectivityNetworkProviderListCollector)object;
        switch (n) {
            case 0: {
                if (connectivityNetworkProviderListCollector.isLoading) {
                    return 2;
                }
                if (connectivityNetworkProviderListCollector.networkProvider.getTelProviderState() == 1) {
                    return 1;
                }
                return 0;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }
}

