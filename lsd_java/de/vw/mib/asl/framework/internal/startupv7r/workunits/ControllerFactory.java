/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.workunits;

import de.vw.mib.asl.framework.internal.startupv7r.StartupServices;
import de.vw.mib.asl.framework.internal.startupv7r.StartupSummarizer;
import de.vw.mib.asl.framework.internal.startupv7r.StartupTask;
import de.vw.mib.asl.framework.internal.startupv7r.model.AbstractWorkUnit;
import de.vw.mib.asl.framework.internal.startupv7r.model.ContextWorkUnit;
import de.vw.mib.asl.framework.internal.startupv7r.model.SpecialWorkUnit;
import de.vw.mib.asl.framework.internal.startupv7r.workunits.AbstractStartupWorkUnitController;
import de.vw.mib.asl.framework.internal.startupv7r.workunits.ContextInformationWorkUnit;
import de.vw.mib.asl.framework.internal.startupv7r.workunits.SpecialMethodWorkUnit;
import de.vw.mib.hmi.utils.Preconditions;

public class ControllerFactory {
    private final StartupServices startupServices;
    private final StartupSummarizer startupSummarizer;

    public ControllerFactory(StartupServices startupServices, StartupSummarizer startupSummarizer) {
        this.startupServices = startupServices;
        this.startupSummarizer = startupSummarizer;
    }

    public StartupTask createController(AbstractWorkUnit abstractWorkUnit) {
        Preconditions.checkArgument(abstractWorkUnit != null, "Given model must not be null");
        Preconditions.checkArgument(this.startupSummarizer != null, "Given StartupSummarizer must not be null");
        return this.createController(abstractWorkUnit, this.startupSummarizer);
    }

    private AbstractStartupWorkUnitController createController(AbstractWorkUnit abstractWorkUnit, StartupSummarizer startupSummarizer) {
        AbstractStartupWorkUnitController abstractStartupWorkUnitController;
        if (abstractWorkUnit instanceof ContextWorkUnit) {
            abstractStartupWorkUnitController = new ContextInformationWorkUnit(this.startupServices, (ContextWorkUnit)abstractWorkUnit, startupSummarizer);
        } else if (abstractWorkUnit instanceof SpecialWorkUnit) {
            abstractStartupWorkUnitController = new SpecialMethodWorkUnit(this.startupServices, (SpecialWorkUnit)abstractWorkUnit);
        } else {
            throw new IllegalArgumentException(new StringBuffer().append("Unsupported model: ").append(super.getClass().getName()).toString());
        }
        return abstractStartupWorkUnitController;
    }
}

