/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.workunits;

import de.vw.mib.asl.framework.internal.startupv7r.StartupServices;
import de.vw.mib.asl.framework.internal.startupv7r.model.AbstractWorkUnit;
import de.vw.mib.asl.framework.internal.startupv7r.model.SpecialWorkUnit;
import de.vw.mib.asl.framework.internal.startupv7r.workunits.AbstractStartupWorkUnitController;
import de.vw.mib.asl.framework.internal.startupv7r.workunits.SpecialMethodWorkUnit$1;

public class SpecialMethodWorkUnit
extends AbstractStartupWorkUnitController {
    private final SpecialWorkUnit model;
    private boolean thisContextWasCompletelyStartedAlready = false;
    private int currentInternalWorkStateIndex = -1;

    public SpecialMethodWorkUnit(StartupServices startupServices, SpecialWorkUnit specialWorkUnit) {
        super(startupServices.getLogger());
        this.model = specialWorkUnit;
    }

    public void doNextWorkStep() {
        ++this.currentInternalWorkStateIndex;
        if (!this.thisContextWasCompletelyStartedAlready) {
            if (this.currentInternalWorkStateIndex == 0) {
                this.doNextWorkStep();
            } else {
                this.trace(new StringBuffer().append(this.model.getName()).append(" is calling its special method...").toString());
                this.thisContextWasCompletelyStartedAlready = true;
                this.model.getSpecialMethod().run(new SpecialMethodWorkUnit$1(this));
            }
        } else {
            this.trace(new StringBuffer().append(this.model.getName()).append(" is finished, moving on...").toString());
            this.finish();
        }
    }

    public boolean wasCompletelyStartedAlready() {
        return this.thisContextWasCompletelyStartedAlready;
    }

    public String getName() {
        return this.model.getName();
    }

    public void setPersistenceReady() {
        this.warn("Set Persistence ready was called on a special method Workunit .. this should not happen!");
    }

    public void resetThisWorkUnitForReuseDuringRun() {
        this.currentInternalWorkStateIndex = -1;
        this.thisContextWasCompletelyStartedAlready = false;
    }

    public String getWorkstepForDebugging() {
        return "N/A - is special Method";
    }

    @Override
    public AbstractWorkUnit getModel() {
        return this.model;
    }

    @Override
    public void runTask() {
        this.doNextWorkStep();
    }

    static /* synthetic */ void access$000(SpecialMethodWorkUnit specialMethodWorkUnit) {
        specialMethodWorkUnit.finish();
    }
}

