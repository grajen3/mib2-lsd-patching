/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger;

import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.ModuleDescriptor;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.ModuleDescriptorRegistry;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.ProfileChanger$Context;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.ProfileChanger$Task;

public class UpdateDescriptorProfil
implements ProfileChanger$Task {
    private final byte profileId;

    public UpdateDescriptorProfil(byte by) {
        this.profileId = by;
    }

    @Override
    public void run(ProfileChanger$Context profileChanger$Context) {
        ModuleDescriptor moduleDescriptor = this.getDescriptor(profileChanger$Context);
        moduleDescriptor.setProfile(this.profileId);
        profileChanger$Context.markTaskFinished();
    }

    private ModuleDescriptor getDescriptor(ProfileChanger$Context profileChanger$Context) {
        PersistenceModule persistenceModule = profileChanger$Context.getModule();
        ModuleDescriptorRegistry moduleDescriptorRegistry = profileChanger$Context.getServices().getModuleDescriptorRegistry();
        return moduleDescriptorRegistry.getOrCreateDescriptor(persistenceModule);
    }
}

