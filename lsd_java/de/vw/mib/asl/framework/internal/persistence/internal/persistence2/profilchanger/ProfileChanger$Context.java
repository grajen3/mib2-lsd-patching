/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger;

import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.ProfileChanger;
import de.vw.mib.asl.framework.internal.persistence.internal.servicesprovider.PersistenceServices;
import java.util.Collection;

public class ProfileChanger$Context {
    boolean isCurrentTaskFinished;
    private final /* synthetic */ ProfileChanger this$0;

    ProfileChanger$Context(ProfileChanger profileChanger) {
        this.this$0 = profileChanger;
    }

    public void markTaskFinished() {
        if (!this.isCurrentTaskFinished) {
            this.isCurrentTaskFinished = true;
            this.this$0.runNextTask();
        }
    }

    public PersistenceModule getModule() {
        return this.this$0.module;
    }

    public PersistenceServices getServices() {
        return this.this$0.services;
    }

    public Collection getProfileChangeListeners() {
        return this.this$0.profileChangeListeners;
    }

    public String toString() {
        return new StringBuffer().append("Context [module=").append(this.getModule().getName()).append("]").toString();
    }
}

