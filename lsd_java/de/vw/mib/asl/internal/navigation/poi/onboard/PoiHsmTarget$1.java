/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.onboard;

import de.vw.mib.asl.api.speechengine.messenger.dialog.DialogStateConsumer;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiAbstractElementCommon;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiHsmTarget;
import de.vw.mib.genericevents.EventGeneric;

class PoiHsmTarget$1
implements DialogStateConsumer {
    private final /* synthetic */ PoiHsmTarget this$0;

    PoiHsmTarget$1(PoiHsmTarget poiHsmTarget) {
        this.this$0 = poiHsmTarget;
    }

    @Override
    public void onDialogStateChanged(int n) {
        if (n == 2 && PoiAbstractElementCommon.isOnboardDualListViewActive) {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(1608594176);
            eventGeneric.setBoolean(0, false);
            eventGeneric.setBoolean(1, true);
            this.this$0.triggerMe(eventGeneric, 1608594176);
        }
    }
}

