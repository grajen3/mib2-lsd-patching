/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl;

import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.framework.api.persistence2.dsi.AbstractPersonalizedAppDsiAdapter;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.ReadyForProfileChangesListener;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.dsi.DsiAdapterProvider;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.DsiReadyForProfileChangesObserver$1;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.DsiReadyForProfileChangesObserver$StateMachineFactory;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat.DsiStateMachine;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat.DsiStateMachine$DsiStateChangeListener;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat.StateAwaitDsiStarted;
import de.vw.mib.asl.framework.internal.persistence.internal.servicesprovider.PersistenceServices;
import de.vw.mib.asl.framework.internal.persistence.internal.util.Preconditions;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class DsiReadyForProfileChangesObserver {
    private final HashMap dsiAdapter2StateMachine = new HashMap();
    private final DsiAdapterProvider dsiAdapterProvider;
    private final Set moduleListeners = new HashSet();
    private boolean isReadyForProfilChanges = false;
    private final PersistenceServices services;
    private final DsiReadyForProfileChangesObserver$StateMachineFactory stateMachineFactory;
    private PersistenceModule module;

    public DsiReadyForProfileChangesObserver(PersistenceServices persistenceServices) {
        this(persistenceServices, new DsiReadyForProfileChangesObserver$StateMachineFactory());
    }

    DsiReadyForProfileChangesObserver(PersistenceServices persistenceServices, DsiReadyForProfileChangesObserver$StateMachineFactory dsiReadyForProfileChangesObserver$StateMachineFactory) {
        Preconditions.checkArgumentNotNull(persistenceServices, "Argument >services< must not be null!");
        Preconditions.checkArgumentNotNull(dsiReadyForProfileChangesObserver$StateMachineFactory, "Argument >stateMachineFactory< must not be null!");
        this.services = persistenceServices;
        this.stateMachineFactory = dsiReadyForProfileChangesObserver$StateMachineFactory;
        this.dsiAdapterProvider = persistenceServices.getDsiAdapterProvider();
    }

    public void addReadyListener(ReadyForProfileChangesListener readyForProfileChangesListener) {
        Preconditions.checkArgumentNotNull(readyForProfileChangesListener, "Argument >listener< must not be null!");
        if (this.isReadyForProfileChanges()) {
            readyForProfileChangesListener.onReadyForProfileChanges(this.module);
            return;
        }
        this.moduleListeners.add(readyForProfileChangesListener);
    }

    public boolean isReadyForProfileChanges() {
        return this.isReadyForProfilChanges;
    }

    public void init(PersistenceModule persistenceModule) {
        Preconditions.checkArgumentNotNull(persistenceModule, "Argument >module< must not be null!");
        Preconditions.checkState(this.module == null, "Illegal call of init(..), only one call is allowed!");
        this.module = persistenceModule;
        if (this.hasNoDsiAdapters()) {
            this.isReadyForProfilChanges = true;
            this.fireReadyForProfileChanges();
        } else {
            this.registerDsiReadyListener();
        }
    }

    void onAllModulDsisReady() {
        this.isReadyForProfilChanges = true;
        this.removeStateMachines();
        this.fireReadyForProfileChanges();
    }

    private DsiStateMachine$DsiStateChangeListener createStateChangeListener(int n) {
        return new DsiReadyForProfileChangesObserver$1(this, n);
    }

    private DsiStateMachine getStateMachine(AbstractPersonalizedAppDsiAdapter abstractPersonalizedAppDsiAdapter) {
        DsiStateMachine dsiStateMachine = (DsiStateMachine)this.dsiAdapter2StateMachine.get(abstractPersonalizedAppDsiAdapter);
        if (dsiStateMachine == null) {
            dsiStateMachine = this.stateMachineFactory.create(this.services, abstractPersonalizedAppDsiAdapter);
            this.dsiAdapter2StateMachine.put(abstractPersonalizedAppDsiAdapter, dsiStateMachine);
            dsiStateMachine.start(new StateAwaitDsiStarted());
        }
        return dsiStateMachine;
    }

    private boolean hasNoDsiAdapters() {
        List list = this.dsiAdapterProvider.getDsiAdapters(this.module);
        return list.isEmpty();
    }

    private void registerDsiReadyListener() {
        List list = this.dsiAdapterProvider.getDsiAdapters(this.module);
        DsiStateMachine$DsiStateChangeListener dsiStateMachine$DsiStateChangeListener = this.createStateChangeListener(list.size());
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            AbstractPersonalizedAppDsiAdapter abstractPersonalizedAppDsiAdapter = (AbstractPersonalizedAppDsiAdapter)iterator.next();
            DsiStateMachine dsiStateMachine = this.getStateMachine(abstractPersonalizedAppDsiAdapter);
            dsiStateMachine.setStateChangeListener(dsiStateMachine$DsiStateChangeListener);
        }
    }

    private void fireReadyForProfileChanges() {
        Iterator iterator = this.moduleListeners.iterator();
        while (iterator.hasNext()) {
            ReadyForProfileChangesListener readyForProfileChangesListener = (ReadyForProfileChangesListener)iterator.next();
            readyForProfileChangesListener.onReadyForProfileChanges(this.module);
        }
        this.moduleListeners.clear();
    }

    private void removeStateMachines() {
        Iterator iterator = this.dsiAdapterProvider.getDsiAdapters(this.module).iterator();
        while (iterator.hasNext()) {
            this.dsiAdapter2StateMachine.remove(iterator.next());
        }
    }
}

