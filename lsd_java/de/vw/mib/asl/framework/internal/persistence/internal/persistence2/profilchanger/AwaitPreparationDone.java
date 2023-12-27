/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger;

import de.vw.mib.asl.framework.api.persistence2.ProfileChangeCallback;
import de.vw.mib.asl.framework.api.persistence2.ProfileChangeListener;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.AwaitPreparationDone$1;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.AwaitPreparationDone$2;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.ProfileChanger$Context;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.ProfileChanger$Task;
import de.vw.mib.asl.framework.internal.persistence.internal.servicesprovider.PersistenceServices;
import de.vw.mib.collections.ObjectOptHashSet;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.timer.Timer;
import de.vw.mib.timer.TimerManager;
import java.util.Collection;
import java.util.Iterator;

public class AwaitPreparationDone
implements ProfileChanger$Task {
    private static final String TIMER_NAME;
    private static final int PREPARATION_TIMEOUT;
    private Collection pendingPreparations;
    private Timer timer;

    @Override
    public void run(ProfileChanger$Context profileChanger$Context) {
        profileChanger$Context.getServices().getPersistenceLogger().trace(new StringBuffer().append("Await 'profile change preparation' for '").append(profileChanger$Context.getModule().getName()).append("'").toString());
        this.pendingPreparations = new ObjectOptHashSet();
        this.pendingPreparations.addAll(profileChanger$Context.getProfileChangeListeners());
        this.startPreparationTimer(profileChanger$Context);
        this.notifyListenersForPreparation(profileChanger$Context);
    }

    void onReadyForProfileChange(ProfileChangeListener profileChangeListener, ProfileChanger$Context profileChanger$Context) {
        PersistenceServices persistenceServices = profileChanger$Context.getServices();
        String string = persistenceServices.getPersistenceTracing().retrieveName(profileChangeListener);
        persistenceServices.getPersistenceLogger().trace(new StringBuffer().append("'Profile change preparation' finished for '").append(profileChanger$Context.getModule().getName()).append("'  listener: ").append(string).toString());
        this.pendingPreparations.remove(profileChangeListener);
        if (this.pendingPreparations.isEmpty()) {
            this.timer.stop();
            persistenceServices.getPersistenceLogger().trace(new StringBuffer().append("'Profile change preparation' finished for '").append(profileChanger$Context.getModule().getName()).append("'").toString());
            profileChanger$Context.markTaskFinished();
        }
    }

    void onPreparationTimeout(ProfileChanger$Context profileChanger$Context) {
        this.logPendingListeners(this.pendingPreparations, profileChanger$Context);
        profileChanger$Context.markTaskFinished();
    }

    private void startPreparationTimer(ProfileChanger$Context profileChanger$Context) {
        PersistenceServices persistenceServices = profileChanger$Context.getServices();
        TimerManager timerManager = persistenceServices.getTimerManager();
        boolean bl = false;
        Runnable runnable = this.createTimeoutRunnable(profileChanger$Context);
        ThreadSwitchingTarget threadSwitchingTarget = persistenceServices.getThreadSwitchingTarget();
        this.timer = timerManager.createTimer("Profile Change Preparation Timer", 0, bl, runnable, threadSwitchingTarget);
        this.timer.start();
    }

    private void notifyListenersForPreparation(ProfileChanger$Context profileChanger$Context) {
        Iterator iterator = profileChanger$Context.getProfileChangeListeners().iterator();
        while (iterator.hasNext()) {
            ProfileChangeListener profileChangeListener = (ProfileChangeListener)iterator.next();
            this.traceListenerPreparation(profileChangeListener, profileChanger$Context);
            profileChangeListener.prepareForProfileChange(this.createPreparationCallback(profileChangeListener, profileChanger$Context));
        }
    }

    private void logPendingListeners(Collection collection, ProfileChanger$Context profileChanger$Context) {
        PersistenceServices persistenceServices = profileChanger$Context.getServices();
        String string = profileChanger$Context.getModule().getName();
        String string2 = new StringBuffer().append("Profile change preparation timeout for '").append(string).append("' after ").append(5000).append("ms! The following listener(s) did not respond:").toString();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            ProfileChangeListener profileChangeListener = (ProfileChangeListener)iterator.next();
            string2 = new StringBuffer().append(string2).append("\n  ").append(persistenceServices.getPersistenceTracing().retrieveName(profileChangeListener)).toString();
        }
        persistenceServices.getPersistenceLogger().error(string2);
    }

    private void traceListenerPreparation(ProfileChangeListener profileChangeListener, ProfileChanger$Context profileChanger$Context) {
        boolean bl = true;
        PersistenceServices persistenceServices = profileChanger$Context.getServices();
        String string = persistenceServices.getPersistenceTracing().retrieveName(profileChangeListener);
        persistenceServices.getPersistenceLogger().trace(new StringBuffer().append("'Profile change preparation' started for '").append(profileChanger$Context.getModule().getName()).append("' listener: ").append(string).toString());
        persistenceServices.getPerfService().performanceLogProfileComponentChange(1, string, bl);
    }

    private Runnable createTimeoutRunnable(ProfileChanger$Context profileChanger$Context) {
        return new AwaitPreparationDone$1(this, profileChanger$Context);
    }

    private ProfileChangeCallback createPreparationCallback(ProfileChangeListener profileChangeListener, ProfileChanger$Context profileChanger$Context) {
        return new AwaitPreparationDone$2(this, profileChangeListener, profileChanger$Context);
    }
}

