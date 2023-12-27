/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r;

import de.vw.mib.asl.framework.internal.startupv7r.model.AbstractWorkUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

class StartupSummarizer$WorkUnitSummary {
    private final List additionalMessages = new ArrayList();
    private final AbstractWorkUnit workUnit;
    private final int worker;
    private final Collection activeWorkUnits;

    public StartupSummarizer$WorkUnitSummary(AbstractWorkUnit abstractWorkUnit, int n, Collection collection) {
        this.workUnit = abstractWorkUnit;
        this.worker = n;
        this.activeWorkUnits = new HashSet(collection);
    }

    public AbstractWorkUnit getWorkUnit() {
        return this.workUnit;
    }

    public int getWorker() {
        return this.worker;
    }

    public Collection getActiveWorkUnits() {
        return this.activeWorkUnits;
    }

    public List getAdditionalMessages() {
        return this.additionalMessages;
    }
}

