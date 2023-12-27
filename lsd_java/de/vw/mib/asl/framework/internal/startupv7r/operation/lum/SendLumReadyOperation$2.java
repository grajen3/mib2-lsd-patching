/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.operation.lum;

import de.vw.mib.asl.framework.internal.startupv7r.model.AbstractWorkUnit;
import de.vw.mib.asl.framework.internal.startupv7r.operation.WorkUnitStarterListener;
import de.vw.mib.asl.framework.internal.startupv7r.operation.lum.SendLumReadyOperation;

class SendLumReadyOperation$2
implements WorkUnitStarterListener {
    private final /* synthetic */ AbstractWorkUnit val$lumWorkUnit;
    private final /* synthetic */ String val$lastContentId;
    private final /* synthetic */ SendLumReadyOperation this$0;

    SendLumReadyOperation$2(SendLumReadyOperation sendLumReadyOperation, AbstractWorkUnit abstractWorkUnit, String string) {
        this.this$0 = sendLumReadyOperation;
        this.val$lumWorkUnit = abstractWorkUnit;
        this.val$lastContentId = string;
    }

    @Override
    public void onWorkUnitCompleted(AbstractWorkUnit abstractWorkUnit) {
        if (abstractWorkUnit == this.val$lumWorkUnit) {
            this.this$0.sendLumReady();
        }
    }

    @Override
    public void onWorkUnitAboutToStart(AbstractWorkUnit abstractWorkUnit) {
        if (abstractWorkUnit == this.val$lumWorkUnit && "HMI_NAVI".equals(this.val$lastContentId)) {
            this.this$0.sendLumReady();
        }
    }
}

