/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.emergency;

import de.vw.mib.asl.api.system.emergency.EmergencyAnnouncementListener;
import de.vw.mib.asl.api.system.emergency.EmergencyAnnouncementService;
import de.vw.mib.asl.internal.system.emergency.EmergencyAnnouncementServiceImpl$1;
import de.vw.mib.asl.internal.system.util.Preconditions;
import de.vw.mib.asl.internal.system.util.SystemLogger;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.log4mib.Logger;
import java.util.ArrayList;
import java.util.Iterator;

public class EmergencyAnnouncementServiceImpl
implements EmergencyAnnouncementService {
    private boolean isEaCurrentlyActive;
    private ArrayList listeners;
    private final SystemLogger systemLogger;
    private ThreadSwitchingTarget threadSwitchingTarget;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$system$emergency$EmergencyAnnouncementServiceImpl;

    public EmergencyAnnouncementServiceImpl(Logger logger, ThreadSwitchingTarget threadSwitchingTarget) {
        Preconditions.checkArgumentNotNull(logger, "The provided instance of class Logger must not be null.");
        Preconditions.checkArgumentNotNull(threadSwitchingTarget, "The provided instance of class ThreadSwitchingTarget must not be null");
        this.systemLogger = new SystemLogger(logger, class$de$vw$mib$asl$internal$system$emergency$EmergencyAnnouncementServiceImpl == null ? (class$de$vw$mib$asl$internal$system$emergency$EmergencyAnnouncementServiceImpl = EmergencyAnnouncementServiceImpl.class$("de.vw.mib.asl.internal.system.emergency.EmergencyAnnouncementServiceImpl")) : class$de$vw$mib$asl$internal$system$emergency$EmergencyAnnouncementServiceImpl);
        this.threadSwitchingTarget = threadSwitchingTarget;
        this.isEaCurrentlyActive = false;
        this.listeners = new ArrayList();
    }

    @Override
    public boolean isEmergencyAnnouncementInProgress() {
        return this.isEaCurrentlyActive;
    }

    @Override
    public void addListener(EmergencyAnnouncementListener emergencyAnnouncementListener) {
        this.listeners.add(emergencyAnnouncementListener);
    }

    @Override
    public void removeListener(EmergencyAnnouncementListener emergencyAnnouncementListener) {
        this.listeners.remove(emergencyAnnouncementListener);
    }

    @Override
    public void setEmergencyAnnouncementState(boolean bl) {
        this.systemLogger.trace(new Object[]{"setEmergencyAnnouncementState called! Currently active: ", new Boolean(this.isEaCurrentlyActive), ". Intended: ", new Boolean(bl), "."});
        if (this.isEaCurrentlyActive != bl) {
            this.isEaCurrentlyActive = bl;
            this.notifyListeners();
        }
    }

    private void notifyListeners() {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            this.notifyListener((EmergencyAnnouncementListener)iterator.next(), this.isEaCurrentlyActive);
        }
    }

    private void notifyListener(EmergencyAnnouncementListener emergencyAnnouncementListener, boolean bl) {
        this.threadSwitchingTarget.enqueue(new EmergencyAnnouncementServiceImpl$1(this, bl, emergencyAnnouncementListener));
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

