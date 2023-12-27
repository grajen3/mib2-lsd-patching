/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.shield.transformer;

import de.vw.mib.asl.api.online.ASLOnlineServiceCallback1;
import de.vw.mib.asl.internal.navigation.shield.transformer.ShieldCollector;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.global.ResourceLocator;

class ShieldCollector$ShieldOnlineResultIconListener
implements ASLOnlineServiceCallback1 {
    private int listIndex;
    private ShieldCollector collector;
    private final /* synthetic */ ShieldCollector this$0;

    public ShieldCollector$ShieldOnlineResultIconListener(ShieldCollector shieldCollector, ShieldCollector shieldCollector2, int n) {
        this.this$0 = shieldCollector;
        this.collector = shieldCollector2;
        this.listIndex = n;
    }

    @Override
    public void updateImageInfo(ResourceLocator resourceLocator) {
        this.collector.resourceLocator = resourceLocator;
        ListManager.getGenericASLList(1710231552).updateListItem(this.listIndex, this.collector);
    }

    @Override
    public void getServiceURLResponse(String string, String string2) {
    }

    @Override
    public void updateImageInfo(int n, ResourceLocator resourceLocator) {
    }
}

