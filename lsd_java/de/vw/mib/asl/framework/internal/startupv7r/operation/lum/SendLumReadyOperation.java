/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.operation.lum;

import de.vw.mib.asl.framework.internal.startupv7r.StartupServices;
import de.vw.mib.asl.framework.internal.startupv7r.model.AbstractWorkUnit;
import de.vw.mib.asl.framework.internal.startupv7r.model.ContextWorkUnit;
import de.vw.mib.asl.framework.internal.startupv7r.model.LastUserModeMapping;
import de.vw.mib.asl.framework.internal.startupv7r.operation.WorkUnitStarter;
import de.vw.mib.asl.framework.internal.startupv7r.operation.WorkUnitStarterListener;
import de.vw.mib.asl.framework.internal.startupv7r.operation.lum.AbstractLumReadyOperation;
import de.vw.mib.asl.framework.internal.startupv7r.operation.lum.SendLumReadyOperation$1;
import de.vw.mib.asl.framework.internal.startupv7r.operation.lum.SendLumReadyOperation$2;

public class SendLumReadyOperation
extends AbstractLumReadyOperation {
    private final StartupServices startupServices;
    private final LastUserModeMapping lumMapping;
    private final WorkUnitStarter workUnitStarter;

    public SendLumReadyOperation(StartupServices startupServices, LastUserModeMapping lastUserModeMapping, WorkUnitStarter workUnitStarter) {
        super(startupServices, workUnitStarter);
        this.startupServices = startupServices;
        this.lumMapping = lastUserModeMapping;
        this.workUnitStarter = workUnitStarter;
        startupServices.getStartupStateService().addListener(new SendLumReadyOperation$1(this));
    }

    void onLastUserModeAvailable() {
        String string = this.startupServices.getSystemStateService().getLastContentId();
        AbstractWorkUnit abstractWorkUnit = this.lumMapping.retrieveWorkUnit(string);
        if (abstractWorkUnit == null) {
            this.sendLumReady();
        } else {
            if ("HMI_NAVI".equals(string)) {
                abstractWorkUnit = this.overrideLumWorkUnitForNav(abstractWorkUnit);
            }
            this.workUnitStarter.addListener(this.createWorkUnitStarterListener(string, abstractWorkUnit));
        }
    }

    private AbstractWorkUnit overrideLumWorkUnitForNav(AbstractWorkUnit abstractWorkUnit) {
        AbstractWorkUnit abstractWorkUnit2 = this.findPreconditonWithNavDomain(abstractWorkUnit);
        if (abstractWorkUnit2 != null) {
            abstractWorkUnit = abstractWorkUnit2;
        }
        return abstractWorkUnit;
    }

    private AbstractWorkUnit findPreconditonWithNavDomain(AbstractWorkUnit abstractWorkUnit) {
        AbstractWorkUnit[] abstractWorkUnitArray;
        if (abstractWorkUnit instanceof ContextWorkUnit && this.checkContainsNavDomain((ContextWorkUnit)(abstractWorkUnitArray = (AbstractWorkUnit[])abstractWorkUnit))) {
            return abstractWorkUnitArray;
        }
        abstractWorkUnitArray = abstractWorkUnit.getPreconditions();
        if (abstractWorkUnitArray != null) {
            for (int i2 = 0; i2 < abstractWorkUnitArray.length; ++i2) {
                AbstractWorkUnit abstractWorkUnit2 = abstractWorkUnitArray[i2];
                AbstractWorkUnit abstractWorkUnit3 = this.findPreconditonWithNavDomain(abstractWorkUnit2);
                if (abstractWorkUnit3 == null) continue;
                return abstractWorkUnit3;
            }
        }
        return null;
    }

    private boolean checkContainsNavDomain(ContextWorkUnit contextWorkUnit) {
        int[] nArray = contextWorkUnit.getDomainToStart();
        if (nArray != null) {
            for (int i2 = 0; i2 < contextWorkUnit.getDomainToStart().length; ++i2) {
                if (nArray[i2] != 6) continue;
                return true;
            }
        }
        return false;
    }

    private WorkUnitStarterListener createWorkUnitStarterListener(String string, AbstractWorkUnit abstractWorkUnit) {
        return new SendLumReadyOperation$2(this, abstractWorkUnit, string);
    }
}

