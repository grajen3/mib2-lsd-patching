/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mirrorlink.target;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListDataUpdateListener;
import de.vw.mib.asl.internal.mirrorlink.target.MirrorLinkController;
import de.vw.mib.genericevents.EventGeneric;

class MirrorLinkController$1
implements ASLListDataUpdateListener {
    private final /* synthetic */ MirrorLinkController this$0;

    MirrorLinkController$1(MirrorLinkController mirrorLinkController) {
        this.this$0 = mirrorLinkController;
    }

    @Override
    public void notifyListDataUpdated(ASLList aSLList) {
        Object object;
        if (MirrorLinkController.access$000(this.this$0).isTraceEnabled()) {
            object = MirrorLinkController.access$000(this.this$0).trace();
            object.append("MirrorLinkController").append(".send SELECT_APP_LIST").log();
        }
        MirrorLinkController.access$200(this.this$0).removeASLListDataUpdateListener(MirrorLinkController.access$100(this.this$0));
        MirrorLinkController.access$102(this.this$0, null);
        object = ServiceManager.mGenericEventFactory.newEvent(1460207680);
        ((EventGeneric)object).setInt(0, MirrorLinkController.access$300(this.this$0));
        ServiceManager.eventMain.getEventDispatcher().sendSafe((EventGeneric)object);
    }
}

