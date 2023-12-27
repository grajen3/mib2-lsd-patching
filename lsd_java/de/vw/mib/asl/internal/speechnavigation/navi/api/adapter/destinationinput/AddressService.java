/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput;

import de.vw.mib.asl.api.navigation.memory.INavigationContactAddress;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.ResolveAddressListener;

public interface AddressService {
    default public void resolveAddress(ResolveAddressListener resolveAddressListener, INavigationContactAddress iNavigationContactAddress) {
    }
}

