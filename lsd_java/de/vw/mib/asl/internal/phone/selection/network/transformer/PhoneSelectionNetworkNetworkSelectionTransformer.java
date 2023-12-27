/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.selection.network.transformer;

import de.vw.mib.asl.internal.phone.selection.NetworkProviderListCollector;
import generated.de.vw.mib.asl.internal.phone.selection.network.transformer.AbstractPhoneSelectionNetworkNetworkSelectionTransformer;
import org.dsi.ifc.telephoneng.NetworkProvider;

public class PhoneSelectionNetworkNetworkSelectionTransformer
extends AbstractPhoneSelectionNetworkNetworkSelectionTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        NetworkProvider networkProvider = ((NetworkProviderListCollector)object).networkProvider;
        switch (n) {
            case 1: {
                return networkProvider.telProviderState == 1;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        NetworkProvider networkProvider = ((NetworkProviderListCollector)object).networkProvider;
        switch (n) {
            case 0: {
                return networkProvider.telLongProviderName;
            }
        }
        throw new IllegalArgumentException();
    }
}

