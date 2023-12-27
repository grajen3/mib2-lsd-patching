/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.entryconditions;

import de.vw.mib.asl.framework.internal.startupv7r.entryconditions.EntryCondition;
import de.vw.mib.asl.framework.internal.startupv7r.model.ContextWorkUnit;

public abstract class AbstractOneTimeApplyingEntryCondition
implements EntryCondition {
    private boolean conditionWasApplied;

    @Override
    public final void apply(ContextWorkUnit contextWorkUnit) {
        if (!this.conditionWasApplied) {
            this.conditionWasApplied = true;
            this.apply();
        }
    }

    protected abstract void apply() {
    }
}

