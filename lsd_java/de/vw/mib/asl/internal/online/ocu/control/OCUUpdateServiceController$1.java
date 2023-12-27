/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.ocu.control;

import de.vw.mib.asl.api.online.ASLOnlineServiceListener;
import de.vw.mib.asl.internal.online.ocu.control.OCUUpdateServiceController;

class OCUUpdateServiceController$1
implements ASLOnlineServiceListener {
    private final /* synthetic */ OCUUpdateServiceController this$0;

    OCUUpdateServiceController$1(OCUUpdateServiceController oCUUpdateServiceController) {
        this.this$0 = oCUUpdateServiceController;
    }

    @Override
    public void updateServiceStatusOnChange(int n) {
        if (n == 0) {
            this.this$0.setState(3);
        } else {
            this.this$0.setState(2);
        }
    }
}

