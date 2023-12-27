/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger;

import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.PersistenceLogger;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.ReadyForProfileChangesListener;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.ModuleDescriptor;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.ModuleDescriptorRegistry;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.AwaitDsiReady$1;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.ProfileChanger$Context;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.ProfileChanger$Task;

public class AwaitDsiReady
implements ProfileChanger$Task {
    @Override
    public void run(ProfileChanger$Context profileChanger$Context) {
        PersistenceModule persistenceModule;
        ModuleDescriptorRegistry moduleDescriptorRegistry = profileChanger$Context.getServices().getModuleDescriptorRegistry();
        ModuleDescriptor moduleDescriptor = moduleDescriptorRegistry.getOrCreateDescriptor(persistenceModule = profileChanger$Context.getModule());
        if (moduleDescriptor.isReadyForProfileChanges()) {
            profileChanger$Context.markTaskFinished();
            this.trace(profileChanger$Context, new StringBuffer().append("Module >").append(persistenceModule).append("< is instantly ready for profile changes.").toString());
            return;
        }
        this.trace(profileChanger$Context, new StringBuffer().append("Awaiting profile change readiness for module >").append(persistenceModule).append("<.").toString());
        moduleDescriptor.addReadyListener(this.createReadyListener(profileChanger$Context));
    }

    private ReadyForProfileChangesListener createReadyListener(ProfileChanger$Context profileChanger$Context) {
        return new AwaitDsiReady$1(this, profileChanger$Context);
    }

    void trace(ProfileChanger$Context profileChanger$Context, String string) {
        PersistenceLogger persistenceLogger = profileChanger$Context.getServices().getPersistenceLogger();
        persistenceLogger.trace(string);
    }
}

