/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat;

import de.vw.mib.asl.framework.api.persistence2.dsi.AbstractPersonalizedAppDsiAdapter;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat.DsiStateMachine$ContextImpl;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat.DsiStateMachine$DsiStateChangeListener;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat.State;
import de.vw.mib.asl.framework.internal.persistence.internal.servicesprovider.PersistenceServices;
import de.vw.mib.asl.framework.internal.persistence.internal.util.Preconditions;

public class DsiStateMachine {
    final AbstractPersonalizedAppDsiAdapter dsiAdapter;
    final PersistenceServices persistenceServices;
    private DsiStateMachine$ContextImpl context;
    private State currentState;
    private DsiStateMachine$DsiStateChangeListener listener;

    public DsiStateMachine(PersistenceServices persistenceServices, AbstractPersonalizedAppDsiAdapter abstractPersonalizedAppDsiAdapter) {
        Preconditions.checkArgumentNotNull(persistenceServices, "Argument >persistenceServices< must not be null!");
        Preconditions.checkArgumentNotNull(abstractPersonalizedAppDsiAdapter, "Argument >dsiAdapter< must not be null!");
        this.persistenceServices = persistenceServices;
        this.dsiAdapter = abstractPersonalizedAppDsiAdapter;
    }

    public void setStateChangeListener(DsiStateMachine$DsiStateChangeListener dsiStateChangeListener) {
        this.listener = dsiStateChangeListener;
    }

    public void start(State state) {
        Preconditions.checkState(this.currentState == null, "This state machine is already started!");
        Preconditions.checkArgument(state != null, "The >initialState< must not be null!");
        this.currentState = state;
        this.context = new DsiStateMachine$ContextImpl(this);
        this.currentState.onEnter(this.context);
    }

    void changeToState(State state) {
        if (state == null || state == this.currentState) {
            return;
        }
        this.context.deactivate();
        this.currentState.onExit(this.context);
        this.currentState = state;
        this.context = new DsiStateMachine$ContextImpl(this);
        this.currentState.onEnter(this.context);
        if (this.listener != null) {
            this.listener.onStateChanged(state);
        }
    }

    State getCurrentState() {
        return this.currentState;
    }
}

