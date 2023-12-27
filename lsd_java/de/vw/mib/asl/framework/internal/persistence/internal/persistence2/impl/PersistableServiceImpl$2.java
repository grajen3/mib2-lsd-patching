/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl;

import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.ModuleDescriptor;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.PersistableServiceImpl;
import java.util.Iterator;

class PersistableServiceImpl$2
implements Runnable {
    private final /* synthetic */ ModuleDescriptor val$moduleDescriptor;
    private final /* synthetic */ byte val$profileId;
    private final /* synthetic */ Iterator val$descriptorIterator;
    private final /* synthetic */ PersistableServiceImpl this$0;

    PersistableServiceImpl$2(PersistableServiceImpl persistableServiceImpl, ModuleDescriptor moduleDescriptor, byte by, Iterator iterator) {
        this.this$0 = persistableServiceImpl;
        this.val$moduleDescriptor = moduleDescriptor;
        this.val$profileId = by;
        this.val$descriptorIterator = iterator;
    }

    @Override
    public void run() {
        PersistenceModule persistenceModule = this.val$moduleDescriptor.getPersistenceModule();
        this.this$0.performProfileChange(persistenceModule, this.val$profileId, this.val$descriptorIterator);
    }
}

