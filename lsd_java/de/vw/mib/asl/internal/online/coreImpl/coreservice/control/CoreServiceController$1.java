/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.coreservice.control;

import de.vw.mib.asl.api.online.ASLOnlineServiceListener;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.control.CoreServiceController;
import de.vw.mib.util.Util;

class CoreServiceController$1
implements Runnable {
    private final /* synthetic */ String val$serviceID;
    private final /* synthetic */ ASLOnlineServiceListener val$listener;
    private final /* synthetic */ CoreServiceController this$0;

    CoreServiceController$1(CoreServiceController coreServiceController, String string, ASLOnlineServiceListener aSLOnlineServiceListener) {
        this.this$0 = coreServiceController;
        this.val$serviceID = string;
        this.val$listener = aSLOnlineServiceListener;
    }

    @Override
    public void run() {
        boolean bl = false;
        if (!this.this$0.getRegisteredServices().isEmpty() && !Util.isNullOrEmpty(this.this$0.getServiceList())) {
            int n = this.this$0.getServiceList().length;
            for (int i2 = 0; i2 < n; ++i2) {
                if (!this.val$serviceID.equalsIgnoreCase(this.this$0.getServiceList()[i2].getServiceID())) continue;
                this.val$listener.updateServiceStatusOnChange(CoreServiceController.access$000(this.this$0, this.this$0.getServiceList()[i2]));
                this.this$0.getServiceList()[i2].setServiceChanged(false);
                bl = true;
            }
        }
        if (!bl) {
            this.val$listener.updateServiceStatusOnChange(CoreServiceController.access$000(this.this$0, null));
        }
    }
}

