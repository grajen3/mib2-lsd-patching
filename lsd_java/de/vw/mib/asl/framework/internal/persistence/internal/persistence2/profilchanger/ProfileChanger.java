/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger;

import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.ProfileChanger$Context;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.ProfileChanger$Task;
import de.vw.mib.asl.framework.internal.persistence.internal.servicesprovider.PersistenceServices;
import de.vw.mib.asl.framework.internal.persistence.internal.util.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProfileChanger {
    final PersistenceServices services;
    final Collection profileChangeListeners;
    final List tasks = new ArrayList();
    final PersistenceModule module;
    private static final int NOT_STARTED;
    private static final int STARTED;
    private int state = 0;

    public ProfileChanger(PersistenceServices persistenceServices, PersistenceModule persistenceModule, Collection collection) {
        Preconditions.checkArgumentNotNull(persistenceServices);
        Preconditions.checkArgumentNotNull(persistenceModule);
        Preconditions.checkArgumentNotNull(collection);
        this.module = persistenceModule;
        this.profileChangeListeners = collection;
        this.services = persistenceServices;
    }

    public void appendTask(ProfileChanger$Task profileChanger$Task) {
        Preconditions.checkArgumentNotNull(profileChanger$Task);
        Preconditions.checkState(this.state == 0, "Unable to append a new task, cause this changer was already started!");
        this.tasks.add(profileChanger$Task);
    }

    public void run() {
        Preconditions.checkState(this.state == 0, "The profile change was already started!");
        this.state = 1;
        this.services.getPersistenceLogger().trace(new StringBuffer().append("Starting profile change for module ").append(this.module.getName()).toString());
        this.runNextTask();
    }

    void runNextTask() {
        if (this.tasks.isEmpty()) {
            return;
        }
        ProfileChanger$Context profileChanger$Context = new ProfileChanger$Context(this);
        ProfileChanger$Task profileChanger$Task = (ProfileChanger$Task)this.tasks.remove(0);
        profileChanger$Task.run(profileChanger$Context);
    }
}

