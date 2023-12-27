/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl;

import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.ModuleDescriptor;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.ModuleRegistrationWaitOperation;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.PersistableModuleAddedListener;
import de.vw.mib.timer.Timer;

class ModuleRegistrationWaitOperation$1
implements PersistableModuleAddedListener {
    private final /* synthetic */ Timer val$timer;
    private final /* synthetic */ ModuleRegistrationWaitOperation this$0;

    ModuleRegistrationWaitOperation$1(ModuleRegistrationWaitOperation moduleRegistrationWaitOperation, Timer timer) {
        this.this$0 = moduleRegistrationWaitOperation;
        this.val$timer = timer;
    }

    @Override
    public void onPersistableModuleAdded(ModuleDescriptor moduleDescriptor) {
        this.val$timer.stop();
        this.this$0.runSuccessOperation("after waiting");
    }
}

