/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.entryconditions;

import de.vw.mib.asl.framework.internal.startupv7r.StartupServices;
import de.vw.mib.asl.framework.internal.startupv7r.entryconditions.EntryConditionAllowLscInStd;
import de.vw.mib.asl.framework.internal.startupv7r.entryconditions.EntryConditionService;

public class EntryConditionServiceFactory {
    public EntryConditionService create(StartupServices startupServices) {
        EntryConditionService entryConditionService = new EntryConditionService();
        entryConditionService.registerEntryCondition(new EntryConditionAllowLscInStd(startupServices));
        return entryConditionService;
    }
}

