/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl;

import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.framework.api.persistence2.ProfileChangeListener;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.ReadyForProfileChangesListener;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.DsiReadyForProfileChangesObserver;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.PersistableModuleAddedListener;
import de.vw.mib.asl.framework.internal.persistence.internal.servicesprovider.PersistenceServices;
import de.vw.mib.asl.framework.internal.persistence.internal.util.Preconditions;
import edu.emory.mathcs.backport.java.util.Collections;
import java.util.Collection;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ModuleDescriptor {
    private final int namespace;
    private final DsiReadyForProfileChangesObserver dsiStateObserver;
    private final Set persitableModuleListeners = new HashSet();
    private final Map profileChangeListeners = new IdentityHashMap();
    private PersistenceModule module;
    private byte currentProfile;

    public ModuleDescriptor(int n, PersistenceServices persistenceServices) {
        Preconditions.checkArgumentNotNull(persistenceServices, "Argument >services< must not be null!");
        this.namespace = n;
        this.dsiStateObserver = new DsiReadyForProfileChangesObserver(persistenceServices);
        this.currentProfile = persistenceServices.getPersistableService().getInitialProfile();
    }

    public int getNamespace() {
        return this.namespace;
    }

    public void setPersistenceModule(PersistenceModule persistenceModule) {
        Preconditions.checkArgumentNotNull(persistenceModule, "Argument >module< must not be null!");
        Preconditions.checkState(this.module == null, new StringBuffer().append("A module is already set for this descriptor! The current persistence module is:").append(this.module).toString());
        this.module = persistenceModule;
        this.observeAndUpdateDsiReadyForProfileChanges();
        this.firePersistableModuleAdded();
    }

    public PersistenceModule getPersistenceModule() {
        return this.module;
    }

    public boolean hasPersistenceModule() {
        return this.getPersistenceModule() != null;
    }

    public void addReadyListener(ReadyForProfileChangesListener readyForProfileChangesListener) {
        this.dsiStateObserver.addReadyListener(readyForProfileChangesListener);
    }

    public void addPersistableModuleAddedListener(PersistableModuleAddedListener persistableModuleAddedListener) {
        Preconditions.checkArgumentNotNull(persistableModuleAddedListener);
        this.persitableModuleListeners.add(persistableModuleAddedListener);
    }

    public void removePersistableModuleAddedListener(PersistableModuleAddedListener persistableModuleAddedListener) {
        this.persitableModuleListeners.remove(persistableModuleAddedListener);
    }

    public boolean isReadyForProfileChanges() {
        return this.dsiStateObserver.isReadyForProfileChanges();
    }

    public byte getProfile() {
        return this.currentProfile;
    }

    public void setProfile(byte by) {
        Preconditions.checkArgument(by > 0, new StringBuffer().append("Argument >profileId< must be greater than 1! Got: ").append(by).toString());
        this.currentProfile = by;
    }

    public String toString() {
        String string = this.module == null ? "null" : this.module.getName();
        return new StringBuffer().append("ModuleDescriptor [persistenceModule=").append(string).append(", namespace=").append(this.namespace).append("]").toString();
    }

    private void observeAndUpdateDsiReadyForProfileChanges() {
        this.dsiStateObserver.init(this.module);
    }

    private void firePersistableModuleAdded() {
        Iterator iterator = this.persitableModuleListeners.iterator();
        while (iterator.hasNext()) {
            PersistableModuleAddedListener persistableModuleAddedListener = (PersistableModuleAddedListener)iterator.next();
            persistableModuleAddedListener.onPersistableModuleAdded(this);
        }
    }

    public void addProfileChangeListener(ProfileChangeListener profileChangeListener) {
        Preconditions.checkArgumentNotNull(profileChangeListener, "Argument >listener< must not be null!");
        this.profileChangeListeners.put(profileChangeListener, null);
    }

    public void removeProfileChangeListener(ProfileChangeListener profileChangeListener) {
        this.profileChangeListeners.remove(profileChangeListener);
    }

    public Collection getProfileChangeListeners() {
        return Collections.unmodifiableCollection(this.profileChangeListeners.keySet());
    }
}

