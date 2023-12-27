/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl;

import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.PersistenceKeyProvider;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.ModuleDescriptor;
import de.vw.mib.asl.framework.internal.persistence.internal.servicesprovider.PersistenceServices;
import de.vw.mib.asl.framework.internal.persistence.internal.util.Preconditions;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import java.util.Collection;

public class ModuleDescriptorRegistry {
    private IntObjectMap modules = new IntObjectOptHashMap();
    private final PersistenceKeyProvider keyProvider;
    private final PersistenceServices services;

    public ModuleDescriptorRegistry(PersistenceServices persistenceServices) {
        Preconditions.checkArgumentNotNull(persistenceServices, "Argument >services< must not be null!");
        this.keyProvider = persistenceServices.getPersistenceKeyProvider();
        this.services = persistenceServices;
    }

    public ModuleDescriptor getOrCreateDescriptor(int n) {
        return this.getOrCreateDescriptor(n, null);
    }

    public ModuleDescriptor getOrCreateDescriptor(PersistenceModule persistenceModule) {
        int n = this.keyProvider.retrieveNamespace(persistenceModule.getName());
        return this.getOrCreateDescriptor(n, persistenceModule);
    }

    public Collection getDescriptors() {
        return this.modules.values();
    }

    public boolean containsDescriptor(int n) {
        return this.modules.containsKey(n);
    }

    public String toString() {
        return new StringBuffer().append("PersistenceModuleRegistry[modules=").append(this.modules).append("]").toString();
    }

    private ModuleDescriptor getOrCreateDescriptor(int n, PersistenceModule persistenceModule) {
        if (!this.isApplicable(n)) {
            return null;
        }
        ModuleDescriptor moduleDescriptor = this.getDescriptor(n);
        this.setPersistenceModule(moduleDescriptor, persistenceModule);
        return moduleDescriptor;
    }

    private void setPersistenceModule(ModuleDescriptor moduleDescriptor, PersistenceModule persistenceModule) {
        if (persistenceModule == null) {
            return;
        }
        if (moduleDescriptor.getPersistenceModule() != null) {
            return;
        }
        moduleDescriptor.setPersistenceModule(persistenceModule);
    }

    private ModuleDescriptor getDescriptor(int n) {
        ModuleDescriptor moduleDescriptor = (ModuleDescriptor)this.modules.get(n);
        if (moduleDescriptor == null) {
            moduleDescriptor = new ModuleDescriptor(n, this.services);
            this.modules.put(n, moduleDescriptor);
        }
        return moduleDescriptor;
    }

    private boolean isApplicable(int n) {
        return n >= 5050 && n <= 6000;
    }
}

