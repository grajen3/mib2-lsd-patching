/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.operation.lum;

import de.vw.mib.asl.framework.internal.startupv7r.model.AbstractWorkUnit;
import de.vw.mib.asl.framework.internal.startupv7r.model.ContextWorkUnit;
import de.vw.mib.asl.framework.internal.startupv7r.operation.WorkUnitStarterListener;
import de.vw.mib.asl.framework.internal.startupv7r.operation.lum.AbstractLumReadyOperation;

class AbstractLumReadyOperation$2
implements WorkUnitStarterListener {
    private final /* synthetic */ AbstractLumReadyOperation this$0;

    AbstractLumReadyOperation$2(AbstractLumReadyOperation abstractLumReadyOperation) {
        this.this$0 = abstractLumReadyOperation;
    }

    @Override
    public void onWorkUnitCompleted(AbstractWorkUnit abstractWorkUnit) {
        if (this.checkIsSwdlWorkUnit(abstractWorkUnit)) {
            this.this$0.sendLumReady();
        }
    }

    @Override
    public void onWorkUnitAboutToStart(AbstractWorkUnit abstractWorkUnit) {
    }

    private boolean checkIsSwdlWorkUnit(AbstractWorkUnit abstractWorkUnit) {
        if (abstractWorkUnit instanceof ContextWorkUnit) {
            ContextWorkUnit contextWorkUnit = (ContextWorkUnit)abstractWorkUnit;
            return (contextWorkUnit.getBitmaskToCheckForSpecialExitConditions() & 0x40) != 0;
        }
        return false;
    }
}

