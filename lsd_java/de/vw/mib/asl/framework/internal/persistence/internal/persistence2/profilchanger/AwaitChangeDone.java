/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger;

import de.vw.mib.asl.framework.api.persistence2.AbstractPersistable;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.framework.api.persistence2.ProfileChangeCallback;
import de.vw.mib.asl.framework.api.persistence2.ProfileChangeListener;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.PersistenceLogger;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.ModuleDescriptor;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.ModuleDescriptorRegistry;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.PersistableMetaInfo;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.PreChangeOperation;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.AwaitChangeDone$1;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.AwaitChangeDone$2;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.ProfileChanger$Context;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.ProfileChanger$Task;
import de.vw.mib.asl.framework.internal.persistence.internal.servicesprovider.PersistenceServices;
import de.vw.mib.collections.ObjectOptHashSet;
import de.vw.mib.perf.service.PerfService;
import de.vw.mib.timer.Timer;
import de.vw.mib.timer.TimerManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map$Entry;

public class AwaitChangeDone
implements ProfileChanger$Task {
    private static final long CHANGE_TIMEOUT;
    private Collection pendingChanges;
    private Timer changeTimer;
    private PreChangeOperation preChangeOperation;
    private final Map persistable2MetaInfo;

    public AwaitChangeDone(Map map, PreChangeOperation preChangeOperation) {
        this.persistable2MetaInfo = map;
        this.preChangeOperation = preChangeOperation;
    }

    @Override
    public void run(ProfileChanger$Context profileChanger$Context) {
        this.pendingChanges = new ObjectOptHashSet();
        this.pendingChanges.addAll(profileChanger$Context.getProfileChangeListeners());
        this.lockPersistables(profileChanger$Context.getServices().getModuleDescriptorRegistry(), profileChanger$Context.getModule());
        this.runPreChangeOperation(profileChanger$Context);
        this.startChangeTimer(profileChanger$Context);
        this.invokeListenersChangeProfile(profileChanger$Context);
    }

    void onTimeout(ProfileChanger$Context profileChanger$Context) {
        this.logProfileChangeTimeout(profileChanger$Context);
        profileChanger$Context.markTaskFinished();
    }

    void onProfileChanged(ProfileChanger$Context profileChanger$Context, ProfileChangeListener profileChangeListener, boolean bl) {
        this.traceProfileChanged(profileChanger$Context, profileChangeListener, bl);
        this.pendingChanges.remove(profileChangeListener);
        if (this.pendingChanges.isEmpty()) {
            this.changeTimer.stop();
            profileChanger$Context.markTaskFinished();
        }
    }

    private void runPreChangeOperation(ProfileChanger$Context profileChanger$Context) {
        if (this.preChangeOperation == null) {
            return;
        }
        String string = profileChanger$Context.getModule().getName();
        int n = profileChanger$Context.getServices().getPersistenceKeyProvider().retrieveNamespace(string);
        this.preChangeOperation.run(n);
    }

    private void invokeListenersChangeProfile(ProfileChanger$Context profileChanger$Context) {
        Collection collection = profileChanger$Context.getProfileChangeListeners();
        PersistenceServices persistenceServices = profileChanger$Context.getServices();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            ProfileChangeListener profileChangeListener = (ProfileChangeListener)iterator.next();
            persistenceServices.getPersistenceLogger().trace(new StringBuffer().append("ProfileChangeOperation: Change profile ").append(persistenceServices.getPersistenceTracing().retrieveName(profileChangeListener)).toString());
            profileChangeListener.changeProfile(this.createCallbackAwaitChangeDone(profileChangeListener, profileChanger$Context));
        }
    }

    private void startChangeTimer(ProfileChanger$Context profileChanger$Context) {
        PersistenceServices persistenceServices = profileChanger$Context.getServices();
        TimerManager timerManager = persistenceServices.getTimerManager();
        String string = "Profile Change Timer";
        boolean bl = false;
        Runnable runnable = this.createChangeTimeoutRunnable(profileChanger$Context);
        this.changeTimer = timerManager.createTimer(string, 0, bl, runnable, persistenceServices.getThreadSwitchingTarget());
        this.changeTimer.start();
    }

    private Runnable createChangeTimeoutRunnable(ProfileChanger$Context profileChanger$Context) {
        return new AwaitChangeDone$1(this, profileChanger$Context);
    }

    private ProfileChangeCallback createCallbackAwaitChangeDone(ProfileChangeListener profileChangeListener, ProfileChanger$Context profileChanger$Context) {
        return new AwaitChangeDone$2(this, profileChanger$Context, profileChangeListener);
    }

    private void lockPersistables(ModuleDescriptorRegistry moduleDescriptorRegistry, PersistenceModule persistenceModule) {
        ModuleDescriptor moduleDescriptor = moduleDescriptorRegistry.getOrCreateDescriptor(persistenceModule);
        Iterator iterator = this.persistable2MetaInfo.entrySet().iterator();
        while (iterator.hasNext()) {
            boolean bl;
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            Persistable persistable = (Persistable)map$Entry.getKey();
            PersistableMetaInfo persistableMetaInfo = (PersistableMetaInfo)map$Entry.getValue();
            boolean bl2 = persistableMetaInfo.getModule() == persistenceModule;
            boolean bl3 = bl = persistableMetaInfo.getProfileId() == moduleDescriptor.getProfile();
            if (!bl2 || bl) continue;
            this.tryToLock(persistable);
        }
    }

    private void tryToLock(Persistable persistable) {
        if (persistable.hasUserSpecificData() && persistable instanceof AbstractPersistable) {
            ((AbstractPersistable)persistable).lock();
        }
    }

    private void traceProfileChanged(ProfileChanger$Context profileChanger$Context, ProfileChangeListener profileChangeListener, boolean bl) {
        PersistenceServices persistenceServices = profileChanger$Context.getServices();
        String string = persistenceServices.getPersistenceTracing().retrieveName(profileChangeListener);
        String string2 = profileChanger$Context.getModule().getName();
        PerfService perfService = persistenceServices.getPerfService();
        perfService.performanceLogProfileComponentChange(2, string, bl);
        PersistenceLogger persistenceLogger = persistenceServices.getPersistenceLogger();
        if (!bl) {
            persistenceLogger.error(new StringBuffer().append("Profile change failed for module ").append(string2).append(" listener was:").append(string).toString());
        } else {
            persistenceLogger.trace(new StringBuffer().append("Profile changed for module: ").append(string2).append(" listener was:").append(string).toString());
        }
    }

    private void logProfileChangeTimeout(ProfileChanger$Context profileChanger$Context) {
        PersistenceServices persistenceServices = profileChanger$Context.getServices();
        String string = profileChanger$Context.getModule().getName();
        String string2 = new StringBuffer().append("Profile change timeout for module ").append(string).append(" after ").append((long)0).append("ms! The following listener(s) did not respond:").toString();
        Iterator iterator = this.pendingChanges.iterator();
        while (iterator.hasNext()) {
            ProfileChangeListener profileChangeListener = (ProfileChangeListener)iterator.next();
            string2 = new StringBuffer().append(string2).append("\n  ").append(persistenceServices.getPersistenceTracing().retrieveName(profileChangeListener)).toString();
        }
        persistenceServices.getPersistenceLogger().error(string2);
    }
}

