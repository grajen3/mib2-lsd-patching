/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.model;

import de.vw.mib.asl.framework.internal.startupv7r.AbstractStartupTask;
import de.vw.mib.asl.framework.internal.startupv7r.model.AbstractWorkUnit;

public class SpecialWorkUnit
extends AbstractWorkUnit {
    private AbstractStartupTask specialMethod;

    public AbstractStartupTask getSpecialMethod() {
        return this.specialMethod;
    }

    public void setSpecialMethod(AbstractStartupTask abstractStartupTask) {
        this.specialMethod = abstractStartupTask;
    }
}

