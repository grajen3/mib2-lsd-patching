/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.connectivity.transformer;

import generated.de.vw.mib.asl.internal.connectivity.transformer.AbstractConnectivityWLANAvailableChannelsTransformer;

public class ConnectivityWLANAvailableChannelsTransformer
extends AbstractConnectivityWLANAvailableChannelsTransformer {
    @Override
    public int getInt(int n, Object object) {
        switch (n) {
            case 0: {
                return 0;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }
}

