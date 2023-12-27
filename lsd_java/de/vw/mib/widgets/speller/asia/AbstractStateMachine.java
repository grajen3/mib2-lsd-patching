/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia;

import de.vw.mib.collections.copyonwrite.CowList;
import de.vw.mib.properties.values.SpellerData;
import de.vw.mib.widgets.View;
import de.vw.mib.widgets.controller.AsiaSpellerController;
import de.vw.mib.widgets.event.OutEventListener;
import de.vw.mib.widgets.event.PropertyChangedListener;
import de.vw.mib.widgets.event.ViewChangedListener;
import de.vw.mib.widgets.log.SpellerLogger;
import de.vw.mib.widgets.models.AsiaSpellerModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.speller.asia.AsiaPhraseBuffer;
import de.vw.mib.widgets.speller.asia.DefaultAsiaPhraseSymbolBuffer;
import de.vw.mib.widgets.speller.asia.DefaultState;
import de.vw.mib.widgets.speller.asia.HWRAreaHandler;
import de.vw.mib.widgets.speller.asia.State;

public abstract class AbstractStateMachine
implements PropertyChangedListener,
ViewChangedListener {
    public static final int STATE_UNDEFINED;
    protected static final int STATE_COUNT_ABSTRACTSTATEMACHINE;
    protected final AsiaSpellerController stateContext;
    protected final AsiaSpellerModel speller;
    protected State lastState;
    private HWRAreaHandler hwrAreaHandler;
    public boolean hwrConfirmationExpected;
    public boolean hwrErrorConfirmed;
    public boolean hwrErrorOccurred;
    protected AsiaPhraseBuffer hwrPhraseBuffer;
    private CowList outEventListeners;
    protected State state;
    protected State[] states;
    private boolean suspended = false;
    private final State undefinedState;

    protected AbstractStateMachine(AsiaSpellerController asiaSpellerController, AsiaSpellerModel asiaSpellerModel) {
        this.stateContext = asiaSpellerController;
        this.speller = asiaSpellerModel;
        this.hwrAreaHandler = new HWRAreaHandler(this);
        this.hwrConfirmationExpected = false;
        this.hwrErrorConfirmed = false;
        this.hwrErrorOccurred = false;
        this.hwrPhraseBuffer = new DefaultAsiaPhraseSymbolBuffer();
        this.outEventListeners = CowList.EMPTY;
        this.undefinedState = new DefaultState(this);
    }

    public final State getState() {
        int n = this.getStateId();
        switch (n) {
            case -1: {
                return this.undefinedState;
            }
        }
        return this.states[n];
    }

    protected final int getStateId() {
        if (this.state == null || this.states == null) {
            return -1;
        }
        for (int i2 = this.states.length - 1; i2 >= 0; --i2) {
            if (this.states[i2] != this.state) continue;
            return i2;
        }
        return -1;
    }

    protected final boolean isStateId(int n) {
        if (this.state == null) {
            return n == -1;
        }
        return this.states != null && n >= 0 && n < this.states.length ? this.state == this.states[n] : false;
    }

    protected final boolean isState(State state, int n) {
        if (state == null) {
            return n == -1;
        }
        return this.states != null && n >= 0 && n < this.states.length ? super.getClass() == super.getClass() : false;
    }

    protected final void setStateId(int n) {
        State state;
        if (n != -1 && (n < -1 || this.states == null || n >= this.states.length)) {
            throw new IllegalArgumentException("Unknown state index passed or states are not initialized!");
        }
        State state2 = this.state;
        State state3 = state = n == -1 ? this.undefinedState : this.states[n];
        if (state2 != state) {
            this.stateChanging(state2, state);
            this.lastState = state2;
            this.state = state;
            this.stateChanged(state2, state);
        } else if (state2 != null) {
            state2.onStayState();
        }
    }

    public final void addOutEventListener(OutEventListener outEventListener) {
        this.outEventListeners = this.outEventListeners.addIfAbsent(outEventListener);
    }

    protected void beforeEnterState() {
    }

    protected void beforeLeaveState() {
    }

    protected abstract State[] defineStates() {
    }

    private void deinitStates() {
        if (this.states != null) {
            for (int i2 = this.states.length - 1; i2 >= 0; --i2) {
                if (this.states[i2] == null) continue;
                this.states[i2].onDeInitState();
                this.states[i2].setHwrAreaHandler(null);
                this.states[i2].setHwrPhraseBuffer(null);
                this.states[i2].setWidgetController(null);
                this.states[i2].setWidget(null);
                this.states[i2] = null;
            }
            this.states = null;
        }
    }

    private void initStates(AsiaSpellerModel asiaSpellerModel) {
        int n;
        this.states = new State[0];
        State[] stateArray = this.defineStates();
        if (stateArray != null) {
            n = this.states.length + stateArray.length;
            State[] stateArray2 = new State[n];
            if (this.states.length > 0) {
                System.arraycopy((Object)this.states, 0, (Object)stateArray2, 0, this.states.length);
            }
            if (stateArray.length > 0) {
                System.arraycopy((Object)stateArray, 0, (Object)stateArray2, this.states.length, stateArray.length);
            }
            this.states = stateArray2;
        }
        for (n = this.states.length - 1; n >= 0; --n) {
            if (this.states[n] == null) continue;
            this.states[n].setWidget(asiaSpellerModel);
            this.states[n].setWidgetController(this.stateContext);
            this.states[n].setHwrAreaHandler(this.hwrAreaHandler);
            this.states[n].setHwrPhraseBuffer(this.hwrPhraseBuffer);
            this.states[n].onInitState();
        }
    }

    final void notifyHMIEvent(String string) {
        for (CowList cowList = this.outEventListeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            OutEventListener outEventListener = (OutEventListener)cowList.head();
            outEventListener.outHMIEventFired(string);
        }
    }

    final void notifyIntegerEvent(String string, int n) {
        for (CowList cowList = this.outEventListeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            OutEventListener outEventListener = (OutEventListener)cowList.head();
            outEventListener.outIntegerEventFired(string, n);
        }
    }

    final void notifySpellerEvent(String string, String string2, int n, int n2, int n3) {
        for (CowList cowList = this.outEventListeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            OutEventListener outEventListener = (OutEventListener)cowList.head();
            outEventListener.outSpellerEventFired(string, string2, n, n2, n3);
        }
    }

    final void notifyStringEvent(String string, String string2) {
        for (CowList cowList = this.outEventListeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            OutEventListener outEventListener = (OutEventListener)cowList.head();
            outEventListener.outStringEventFired(string, string2);
        }
    }

    @Override
    public void propertyChanged(WidgetModel widgetModel, int n) {
        switch (n) {
            case 32: 
            case 44: 
            case 54: 
            case 55: 
            case 56: 
            case 58: 
            case 69: 
            case 70: 
            case 71: 
            case 72: 
            case 73: {
                this.resolveState(this.speller);
                break;
            }
            case 48: {
                SpellerData spellerData = this.speller.get_spellerData();
                this.getState().setSpellerData(spellerData);
                break;
            }
        }
    }

    public final void removeOutEventListener(OutEventListener outEventListener) {
        this.outEventListeners = this.outEventListeners.remove(outEventListener);
    }

    protected void resolveState(AsiaSpellerModel asiaSpellerModel) {
        this.setStateId(-1);
    }

    public final void start() {
        Object object;
        if (!this.suspended) {
            this.stateContext.trace(SpellerLogger.getLogger()).append("start state machine").log();
            this.initStates(this.speller);
            this.resolveState(this.speller);
        } else {
            this.stateContext.trace(SpellerLogger.getLogger()).append("resume state machine").log();
            object = this.getState();
            this.stateContext.trace(SpellerLogger.getLogger()).append("Resuming state [").append(object).append("]").log();
            ((State)object).onResumeState();
            this.stateContext.trace(SpellerLogger.getLogger()).append("Resumed state [").append(object).append("]").log();
            this.suspended = false;
            this.resolveState(this.speller);
        }
        if (this.speller != null) {
            this.speller.addPropertyChangedListener(this);
            object = this.speller.getView();
            if (object != null) {
                object.addViewChangedListener(this);
            }
        }
    }

    protected final void stateChanging(State state, State state2) {
        if (state != null) {
            this.beforeLeaveState();
            this.stateContext.trace(SpellerLogger.getLogger()).append("Leaving state [").append(state).append("]").log();
            state.onLeaveState(state2);
            this.stateContext.trace(SpellerLogger.getLogger()).append("Left state [").append(state).append("]").log();
        }
    }

    protected final void stateChanged(State state, State state2) {
        if (state2 != null) {
            this.beforeEnterState();
            this.stateContext.trace(SpellerLogger.getLogger()).append("Entering state [").append(state2).append("]").log();
            state2.onEnterState(state);
            this.stateContext.trace(SpellerLogger.getLogger()).append("Entered state [").append(state2).append("]").log();
        }
    }

    public final void stop() {
        Object object;
        if (this.speller != null) {
            this.speller.removePropertyChangedListener(this);
            object = this.speller.getView();
            if (object != null) {
                object.removeViewChangedListener(this);
            }
        }
        if (this.suspended) {
            this.suspended = false;
        }
        this.stateContext.trace(SpellerLogger.getLogger()).append("stop state machine").log();
        object = this.getState();
        this.beforeLeaveState();
        this.stateContext.trace(SpellerLogger.getLogger()).append("Shutting down state [").append(object).append("]").log();
        ((State)object).onLeaveState(null);
        this.stateContext.trace(SpellerLogger.getLogger()).append("Shut down state [").append(object).append("]").log();
        this.deinitStates();
        this.lastState = null;
        this.state = null;
        this.hwrConfirmationExpected = false;
        this.hwrErrorConfirmed = false;
        this.hwrErrorOccurred = false;
        this.hwrPhraseBuffer.removeAllPhrases();
    }

    public final void suspend() {
        Object object;
        if (this.speller != null) {
            this.speller.removePropertyChangedListener(this);
            object = this.speller.getView();
            if (object != null) {
                object.removeViewChangedListener(this);
            }
        }
        this.stateContext.trace(SpellerLogger.getLogger()).append("suspend state machine").log();
        object = this.getState();
        this.stateContext.trace(SpellerLogger.getLogger()).append("Suspending state [").append(object).append("]").log();
        ((State)object).onSuspendState();
        this.stateContext.trace(SpellerLogger.getLogger()).append("Suspended state [").append(object).append("]").log();
        this.suspended = true;
    }

    @Override
    public void viewCovered() {
        this.getState().onViewCovered();
    }

    @Override
    public void viewUncovered() {
        this.getState().onViewUncovered();
    }

    @Override
    public void viewInited(View view) {
    }

    @Override
    public void viewEntered(View view) {
    }

    @Override
    public void viewLeft(View view) {
    }
}

