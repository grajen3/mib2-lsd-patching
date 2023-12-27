/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.dynamic;

import de.vw.mib.asl.framework.api.startupv7r.dynamic.DynamicWorkUnitStarter;
import de.vw.mib.asl.framework.api.startupv7r.dynamic.DynamicWorkUnitStarterCallback;
import de.vw.mib.asl.framework.internal.startupv7r.StartupTask;
import de.vw.mib.asl.framework.internal.startupv7r.dynamic.DynamicWorkUnitStarterImpl$1;
import de.vw.mib.asl.framework.internal.startupv7r.model.AbstractWorkUnit;
import de.vw.mib.asl.framework.internal.startupv7r.model.WorkUnitModelUtil;
import de.vw.mib.asl.framework.internal.startupv7r.workunits.ControllerFactory;
import de.vw.mib.hmi.utils.Preconditions;

public class DynamicWorkUnitStarterImpl
implements DynamicWorkUnitStarter {
    private final AbstractWorkUnit[] workUnits;
    private final ControllerFactory controllerFactory;

    public DynamicWorkUnitStarterImpl(ControllerFactory controllerFactory, AbstractWorkUnit[] abstractWorkUnitArray) {
        boolean bl = true;
        this.controllerFactory = controllerFactory;
        this.workUnits = new WorkUnitModelUtil().findDynamicWorkUnits(abstractWorkUnitArray, bl);
    }

    @Override
    public void startDynamicWorkUnit(String string, DynamicWorkUnitStarterCallback dynamicWorkUnitStarterCallback) {
        Preconditions.checkArgument(this.checkDynamicWorkUnitExists(string), new StringBuffer().append("The work unit '").append(string).append("' is no known dynamic work unit.").toString());
        Preconditions.checkArgument(dynamicWorkUnitStarterCallback != null, "The given callback must not be null.");
        StartupTask startupTask = this.controllerFactory.createController(this.findDynamicWorkUnit(string));
        startupTask.run(this.createCallback(dynamicWorkUnitStarterCallback));
    }

    @Override
    public boolean checkDynamicWorkUnitExists(String string) {
        return this.findDynamicWorkUnit(string) != null;
    }

    private Runnable createCallback(DynamicWorkUnitStarterCallback dynamicWorkUnitStarterCallback) {
        return new DynamicWorkUnitStarterImpl$1(this, dynamicWorkUnitStarterCallback);
    }

    private AbstractWorkUnit findDynamicWorkUnit(String string) {
        if (string == null) {
            return null;
        }
        for (int i2 = 0; i2 < this.workUnits.length; ++i2) {
            if (!string.equals(this.workUnits[i2].getName())) continue;
            return this.workUnits[i2];
        }
        return null;
    }
}

