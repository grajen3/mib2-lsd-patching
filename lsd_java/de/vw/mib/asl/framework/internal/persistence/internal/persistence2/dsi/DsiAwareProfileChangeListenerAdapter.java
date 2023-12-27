/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.dsi;

import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.framework.api.persistence2.ProfileChangeCallback;
import de.vw.mib.asl.framework.api.persistence2.ProfileChangeListener;
import de.vw.mib.asl.framework.api.persistence2.dsi.AbstractPersonalizedAppDsiAdapter;
import de.vw.mib.asl.framework.api.persistence2.dsi.DsiAwareProfileChangeListener;
import de.vw.mib.asl.framework.api.persistence2.dsi.DsiAwareProfileChangeListenerCallback;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.PersistableService;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.dsi.DsiAdapterProvider;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.dsi.DsiAwareProfileChangeListenerAdapter$1;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.dsi.DsiAwareProfileChangeListenerAdapter$2;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.dsi.DsiAwareProfileChangeListenerAdapter$3;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.dsi.DsiProfileChangedListener;
import de.vw.mib.asl.framework.internal.persistence.internal.servicesprovider.PersistenceServices;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import java.util.Iterator;
import java.util.List;

public class DsiAwareProfileChangeListenerAdapter
implements ProfileChangeListener {
    private static final String LOG_DELIM;
    private static final boolean PROFILE_CHANGE_FAILED;
    private final DsiAwareProfileChangeListener dsiAwareProfileChangeListener;
    private final DsiAdapterProvider dsiProvider;
    private final Logger logger;
    private final PersistableService persistableService;
    private final PersistenceModule persistenceModule;
    private List dsiAdapters;
    private boolean dsiListenerInitialized;
    private int currentAction;
    private ProfileChangeCallback profileChangeCallback;
    private List pendingDsiAdapter;

    public DsiAwareProfileChangeListenerAdapter(DsiAwareProfileChangeListener dsiAwareProfileChangeListener, PersistenceModule persistenceModule, PersistenceServices persistenceServices) {
        this.checkConstructorArguments(dsiAwareProfileChangeListener, persistenceModule, persistenceServices);
        this.dsiAwareProfileChangeListener = dsiAwareProfileChangeListener;
        this.persistenceModule = persistenceModule;
        this.dsiProvider = persistenceServices.getDsiAdapterProvider();
        this.logger = persistenceServices.getLogger();
        this.persistableService = persistenceServices.getPersistableService();
    }

    @Override
    public void changeProfile(ProfileChangeCallback profileChangeCallback) {
        this.profileChangeCallback = profileChangeCallback;
        this.initDsiAdapter();
        this.initDsiListener();
        this.initCurrentAction();
        DsiAwareProfileChangeListenerCallback dsiAwareProfileChangeListenerCallback = this.createProfileChangedPreDsiCallback(this.dsiAdapters);
        this.dsiAwareProfileChangeListener.changeProfilePreDsi(dsiAwareProfileChangeListenerCallback);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof DsiAwareProfileChangeListenerAdapter)) {
            return false;
        }
        DsiAwareProfileChangeListenerAdapter dsiAwareProfileChangeListenerAdapter = (DsiAwareProfileChangeListenerAdapter)object;
        return !(this.dsiAwareProfileChangeListener == null ? dsiAwareProfileChangeListenerAdapter.dsiAwareProfileChangeListener != null : !this.dsiAwareProfileChangeListener.equals(dsiAwareProfileChangeListenerAdapter.dsiAwareProfileChangeListener));
    }

    public int hashCode() {
        int n = 31;
        int n2 = 1;
        n2 = 31 * n2 + (this.dsiAwareProfileChangeListener == null ? 0 : this.dsiAwareProfileChangeListener.hashCode());
        return n2;
    }

    public String toString() {
        return new StringBuffer().append("DsiAwareProfileChangeListenerAdapter [dsiAwareProfileChangeListener=").append(this.dsiAwareProfileChangeListener).append(", persistenceModule=").append(this.persistenceModule.getName()).append(", dsiAdapters=").append(this.dsiAdapters).append(", pendingDsiAdapter=").append(this.pendingDsiAdapter).append("]").toString();
    }

    @Override
    public void prepareForProfileChange(ProfileChangeCallback profileChangeCallback) {
        this.dsiAwareProfileChangeListener.prepareForProfileChange(this.createProfileChangePreparationCallback(profileChangeCallback));
    }

    LogMessage logInfo() {
        LogMessage logMessage = this.logger.info(32).append("[DsiAwareProfileChangeListenerAdapter] ");
        return logMessage;
    }

    LogMessage logError() {
        LogMessage logMessage = this.logger.error(32).append("[DsiAwareProfileChangeListenerAdapter] ");
        return logMessage;
    }

    LogMessage logWarning() {
        return this.logger.warn(32).append("[DsiAwareProfileChangeListenerAdapter] ");
    }

    void notifyDsiAnswer(int n, int n2, AbstractPersonalizedAppDsiAdapter abstractPersonalizedAppDsiAdapter) {
        if (this.profileChangeCallback == null) {
            this.logError().append("Ignoring unexpected answer for action >").append(n2).append("< as no anwer was expected.").log();
            return;
        }
        if (n2 != this.currentAction) {
            this.logError().append("Ignoring unexpected answer for action >").append(n2).append("< as expected action was >").append(this.currentAction).append("<.").log();
            return;
        }
        byte by = this.persistableService.getActiveProfile();
        if (n != by && this.currentAction != 3) {
            this.logError().append("Ignoring unexpected answer. DSI confirmed profile >").append(n).append("<, but expected was >").append(by).append("<.").log();
            return;
        }
        this.pendingDsiAdapter.remove(abstractPersonalizedAppDsiAdapter);
        if (this.pendingDsiAdapter.isEmpty()) {
            this.dsiAwareProfileChangeListener.changeProfilePostDsi(this.createProfileChangedPostDsiCallback(this.profileChangeCallback));
            this.profileChangeCallback = null;
        } else {
            this.logInfo().append(new StringBuffer().append("Didn't called >changeProfilePostDsi< , cause the following DSIs didn't notify the callback yet: ").append(this.pendingDsiAdapter).toString()).log();
        }
    }

    void setPendingDsiAdapterCallbacks(List list) {
        this.pendingDsiAdapter = list;
    }

    private void checkConstructorArguments(DsiAwareProfileChangeListener dsiAwareProfileChangeListener, PersistenceModule persistenceModule, PersistenceServices persistenceServices) {
        if (dsiAwareProfileChangeListener == null) {
            throw new IllegalArgumentException("DSI aware profile change listener argument must not be null!");
        }
        if (persistenceModule == null) {
            throw new IllegalArgumentException("Persistence module argument must not be null.");
        }
        if (persistenceServices == null) {
            throw new IllegalArgumentException("Persistence service manager argument must not be null.");
        }
    }

    private DsiAwareProfileChangeListenerCallback createProfileChangedPostDsiCallback(ProfileChangeCallback profileChangeCallback) {
        String string = new StringBuffer().append("Profile change post DSI for >").append(this.persistenceModule.getName()).append("<").toString();
        return new DsiAwareProfileChangeListenerAdapter$1(this, this.logger, string, string, profileChangeCallback);
    }

    private DsiAwareProfileChangeListenerCallback createProfileChangedPreDsiCallback(List list) {
        byte by = this.persistableService.getActiveProfile();
        String string = new StringBuffer().append("Profile change pre DSI for >").append(this.persistenceModule.getName()).append("<").toString();
        int n = this.currentAction;
        return new DsiAwareProfileChangeListenerAdapter$2(this, this.logger, string, string, list, n, by);
    }

    private DsiAwareProfileChangeListenerCallback createProfileChangePreparationCallback(ProfileChangeCallback profileChangeCallback) {
        String string = new StringBuffer().append("Profile change preparation for >").append(this.persistenceModule.getName()).append("<").toString();
        return new DsiAwareProfileChangeListenerAdapter$3(this, this.logger, string, string, profileChangeCallback);
    }

    private void failProfileChange(Exception exception, String string) {
        this.logError().append(string).log();
        this.profileChangeCallback.notifyProfileChanged(false);
        throw new RuntimeException(string, exception);
    }

    private void initCurrentAction() {
        this.currentAction = this.persistableService.getCurrentAction();
        if (this.currentAction == 0) {
            this.failProfileChange(null, "PersistableService indicates no profile action.");
        }
    }

    private void initDsiAdapter() {
        if (this.dsiAdapters == null) {
            this.dsiAdapters = this.dsiProvider.getDsiAdapters(this.persistenceModule);
            this.dsiAdapters = this.dsiProvider.filterUnregisteredDsis(this.dsiAdapters);
            this.verifyAdaptersExist();
        }
    }

    private void verifyAdaptersExist() {
        if (this.dsiAdapters == null) {
            this.failProfileChange(null, new StringBuffer().append("No DSI adapter registered for persisence module >").append(this.persistenceModule.getName()).append("<.").toString());
        } else if (this.dsiAdapters.isEmpty()) {
            this.failProfileChange(null, new StringBuffer().append("No DSI available for the persistence module >").append(this.persistenceModule.getName()).append("< (none is started).").toString());
        }
    }

    private void initDsiListener() {
        if (!this.dsiListenerInitialized) {
            try {
                Iterator iterator = this.dsiAdapters.iterator();
                while (iterator.hasNext()) {
                    AbstractPersonalizedAppDsiAdapter abstractPersonalizedAppDsiAdapter = (AbstractPersonalizedAppDsiAdapter)iterator.next();
                    DsiProfileChangedListener dsiProfileChangedListener = new DsiProfileChangedListener(this, this.persistableService, this.logger, this.persistenceModule.getName(), abstractPersonalizedAppDsiAdapter);
                    this.dsiProvider.addDsiListener(abstractPersonalizedAppDsiAdapter, dsiProfileChangedListener);
                }
                this.dsiListenerInitialized = true;
            }
            catch (Exception exception) {
                String string = new StringBuffer().append("Cannot register DSI listener for module >").append(this.persistenceModule.getName()).append("<.").toString();
                this.failProfileChange(exception, string);
            }
        }
    }
}

