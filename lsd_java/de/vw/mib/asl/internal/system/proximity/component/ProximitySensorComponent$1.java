/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.proximity.component;

import de.vw.mib.asl.internal.system.abtfeatures.DsiKeyPanelListenerAdapter;
import de.vw.mib.asl.internal.system.proximity.component.ProximitySensorComponent;

class ProximitySensorComponent$1
extends DsiKeyPanelListenerAdapter {
    private final /* synthetic */ ProximitySensorComponent this$0;

    ProximitySensorComponent$1(ProximitySensorComponent proximitySensorComponent) {
        this.this$0 = proximitySensorComponent;
    }

    @Override
    public void updateProximity(int n, int n2, int n3) {
        this.this$0.installProximityValue(n2 != 0);
    }
}

