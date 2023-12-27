/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.entryconditions;

import de.vw.mib.asl.framework.internal.startupv7r.entryconditions.EntryCondition;
import de.vw.mib.asl.framework.internal.startupv7r.model.ContextWorkUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EntryConditionService {
    private final List entryConditions = new ArrayList();

    EntryConditionService() {
    }

    public void applyEntryConditions(ContextWorkUnit contextWorkUnit) {
        Iterator iterator = this.entryConditions.iterator();
        while (iterator.hasNext()) {
            EntryCondition entryCondition = (EntryCondition)iterator.next();
            if ((entryCondition.getBitmask() & contextWorkUnit.getBitmaskToCheckForSpecialEntryConditions()) == 0) continue;
            entryCondition.apply(contextWorkUnit);
        }
    }

    public void registerEntryCondition(EntryCondition entryCondition) {
        this.entryConditions.add(entryCondition);
    }
}

