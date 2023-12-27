/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink;

import de.vw.mib.asl.api.system.UnitChangeListener;
import de.vw.mib.asl.internal.travellink.TLinkServiceManager;

public final class UnitChangeListenerImpl
implements UnitChangeListener {
    @Override
    public void onUnitChanged(int n, int n2) {
        TLinkServiceManager.getServiceManager().getMain().onUnitChange();
    }
}

