/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.startup;

import de.vw.mib.asl.framework.api.persistence2.startup.PersistenceStartupListener;
import de.vw.mib.asl.framework.api.persistence2.startup.PersistenceStartupService;
import de.vw.mib.asl.framework.api.startupv7r.startupstate.StartupStateService;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.PersistableService;
import de.vw.mib.asl.framework.internal.persistence.internal.startup.PersistenceStartupServiceImpl$1;
import de.vw.mib.asl.framework.internal.persistence.internal.startup.PersistenceStartupServiceImpl$2;
import de.vw.mib.asl.framework.internal.persistence.internal.util.Preconditions;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.timer.Invoker;
import java.util.ArrayList;
import java.util.Iterator;

public class PersistenceStartupServiceImpl
implements PersistenceStartupService {
    private final ArrayList listeners = new ArrayList();
    private final Invoker invoker;
    private final Logger logger;
    private final StartupStateService startupStateService;
    private final PersistableService persistableService;
    private boolean isInitialStartupProfileSet;
    private int profileChangeModeOverride;

    public PersistenceStartupServiceImpl(Invoker invoker, StartupStateService startupStateService, PersistableService persistableService, Logger logger) {
        Preconditions.checkArgumentNotNull(invoker);
        Preconditions.checkArgumentNotNull(startupStateService);
        Preconditions.checkArgumentNotNull(persistableService);
        Preconditions.checkArgumentNotNull(logger);
        this.invoker = invoker;
        this.startupStateService = startupStateService;
        this.persistableService = persistableService;
        this.logger = logger;
        persistableService.addGlobalProfileChangeListener(new PersistenceStartupServiceImpl$1(this), 0);
    }

    @Override
    public void addListener(PersistenceStartupListener persistenceStartupListener) {
        this.checkAddListenerArgument(persistenceStartupListener);
        this.listeners.add(persistenceStartupListener);
    }

    @Override
    public boolean isInitialStartupProfileSet() {
        return this.isInitialStartupProfileSet;
    }

    public void notifyInitialStartupProfileSet() {
        this.isInitialStartupProfileSet = true;
        if (this.logger.isTraceEnabled(32)) {
            this.logger.trace(32, "[PersistenceStartupServiceImpl] Profile is set. Notifying listener.");
        }
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            PersistenceStartupListener persistenceStartupListener = (PersistenceStartupListener)iterator.next();
            this.invoker.invoke(new PersistenceStartupServiceImpl$2(this, persistenceStartupListener));
        }
    }

    @Override
    public void removeListener(PersistenceStartupListener persistenceStartupListener) {
        this.listeners.remove(persistenceStartupListener);
    }

    @Override
    public int getProfileChangeMode() {
        if (this.persistableService.isProfileSwitchOngoing()) {
            return this.profileChangeModeOverride;
        }
        return this.calculateCurrentProfileChangeMode();
    }

    void storeProfileChangeModeOverride() {
        this.profileChangeModeOverride = this.calculateCurrentProfileChangeMode();
    }

    private int calculateCurrentProfileChangeMode() {
        if (this.startupStateService.getStartupState() == 2) {
            return 1;
        }
        return 0;
    }

    private void checkAddListenerArgument(PersistenceStartupListener persistenceStartupListener) {
        Preconditions.checkArgumentNotNull(persistenceStartupListener, "Listener must not be null.");
        if (this.listeners.contains(persistenceStartupListener)) {
            throw new IllegalArgumentException("Listener already registered.");
        }
    }
}

