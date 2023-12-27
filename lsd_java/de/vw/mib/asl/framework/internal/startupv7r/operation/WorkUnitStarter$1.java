/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.operation;

import de.vw.mib.asl.framework.internal.startupv7r.model.AbstractWorkUnit;
import de.vw.mib.asl.framework.internal.startupv7r.operation.WorkUnitStarter;

class WorkUnitStarter$1
implements Runnable {
    private final /* synthetic */ AbstractWorkUnit val$workUnit;
    private final /* synthetic */ WorkUnitStarter this$0;

    WorkUnitStarter$1(WorkUnitStarter workUnitStarter, AbstractWorkUnit abstractWorkUnit) {
        this.this$0 = workUnitStarter;
        this.val$workUnit = abstractWorkUnit;
    }

    @Override
    public void run() {
        this.this$0.finishWorkUnitStart(this.val$workUnit);
        this.this$0.runWorkUnits();
    }
}

