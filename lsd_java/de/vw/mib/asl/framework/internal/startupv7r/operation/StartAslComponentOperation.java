/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.operation;

import de.vw.mib.asl.framework.api.framework.component.ASLComponent;
import de.vw.mib.asl.framework.internal.startupv7r.AbstractStartupTask;
import de.vw.mib.asl.framework.internal.startupv7r.StartupServices;
import de.vw.mib.asl.framework.internal.startupv7r.model.ContextWorkUnit;

public class StartAslComponentOperation
extends AbstractStartupTask {
    private final StartupServices startupServices;
    private final ContextWorkUnit workUnit;

    public StartAslComponentOperation(StartupServices startupServices, ContextWorkUnit contextWorkUnit) {
        super(startupServices.getLogger());
        this.startupServices = startupServices;
        this.workUnit = contextWorkUnit;
    }

    @Override
    protected void runTask() {
        this.startAslComponents(this.workUnit);
        this.finish();
    }

    private void startAslComponents(ContextWorkUnit contextWorkUnit) {
        if (contextWorkUnit != null) {
            String[] stringArray = contextWorkUnit.getAslComponentQualifiedNames();
            this.startAslComponents(stringArray);
        } else {
            this.warn("ContextWorkUnit is null.");
        }
    }

    private void startAslComponents(String[] stringArray) {
        if (stringArray != null) {
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                String string = stringArray[i2];
                this.startAslComponent(string);
            }
        } else {
            this.warn("getAslComponentQualifiedNames returns null.");
        }
    }

    private void startAslComponent(String string) {
        try {
            Class clazz = Class.forName(string);
            Object object = clazz.newInstance();
            ASLComponent aSLComponent = (ASLComponent)object;
            aSLComponent.init(this.startupServices.getLogger(), this.startupServices.getAslFrameworkServices());
            this.trace(new StringBuffer().append("Successfully initialized class: ").append(string).toString());
        }
        catch (Exception exception) {
            this.error(new StringBuffer().append("Could not initialize class: ").append(string).toString(), exception);
        }
    }
}

