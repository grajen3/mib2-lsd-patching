/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl;

import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.ModuleDescriptor;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.ModuleRegistrationWaitOperation;

class ModuleRegistrationWaitOperation$2
implements Runnable {
    private final /* synthetic */ ModuleDescriptor val$descriptor;
    private final /* synthetic */ ModuleRegistrationWaitOperation this$0;

    ModuleRegistrationWaitOperation$2(ModuleRegistrationWaitOperation moduleRegistrationWaitOperation, ModuleDescriptor moduleDescriptor) {
        this.this$0 = moduleRegistrationWaitOperation;
        this.val$descriptor = moduleDescriptor;
    }

    @Override
    public void run() {
        this.this$0.runFailOperation(new StringBuffer().append("Module ").append(this.val$descriptor.getNamespace()).append(" was not registered in time, skipping profile change for this module.").toString());
    }
}

