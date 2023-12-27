/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.handler;

import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.widgets.speller.asia.AsiaCache;
import de.vw.mib.widgets.speller.asia.AsiaDatabase;
import de.vw.mib.widgets.speller.asia.AsiaDatabaseState;
import de.vw.mib.widgets.speller.asia.ExtendedAsiaAdapter;
import de.vw.mib.widgets.speller.asia.handler.AbstractAsiaStateHandler;
import de.vw.mib.widgets.speller.asia.handler.DefaultAsiaStateProxy;
import org.dsi.ifc.asiainput.UserDefinedEntry;

final class DefaultAsiaStateProxy$AsiaStateCollector
extends ExtendedAsiaAdapter {
    private final AsiaCache asiaCache;
    private final AsiaDatabase asiaInputWrapper;
    private AsiaDatabaseState asiaState;
    private boolean cancelled;
    private boolean obsolete;
    private final IntObjectMap parameters;
    private final AbstractAsiaStateHandler stateHandler;
    private final int states;
    private final /* synthetic */ DefaultAsiaStateProxy this$0;

    public DefaultAsiaStateProxy$AsiaStateCollector(DefaultAsiaStateProxy defaultAsiaStateProxy, int n, IntObjectMap intObjectMap, AsiaDatabase asiaDatabase, AbstractAsiaStateHandler abstractAsiaStateHandler) {
        this.this$0 = defaultAsiaStateProxy;
        this.states = n;
        this.parameters = intObjectMap;
        this.asiaInputWrapper = asiaDatabase;
        this.stateHandler = abstractAsiaStateHandler;
        this.asiaCache = asiaDatabase.getCache();
        this.reset();
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public void cancel() {
        this.cancelled = true;
    }

    public boolean isObsolete() {
        return this.obsolete;
    }

    public void obsolete() {
        this.obsolete = true;
    }

    public Object getParameter(int n) {
        if (this.parameters != null && this.parameters.containsKey(n)) {
            return this.parameters.get(n);
        }
        return null;
    }

    public AbstractAsiaStateHandler getStateHandler() {
        return this.stateHandler;
    }

    public int getStates() {
        return this.states;
    }

    public void reset() {
        this.asiaState = new AsiaDatabaseState();
        this.asiaState.setStates(this.states);
        this.cancelled = false;
        this.obsolete = false;
    }

    public void setNextState(int n) {
        this.asiaState.setState(n);
    }

    @Override
    public void asiaBuiltCandidates(int n) {
        this.asiaState.appendState(16);
        if (this.checkAsiaInput()) {
            return;
        }
        this.asiaCache.setCandidatesCount(n);
        this.this$0.onStateRequestPartlyFinished(this, this.asiaInputWrapper, this.asiaState, this.stateHandler, 16);
        if (this.cancelled || (this.states & 1) == 0 && (this.states & 2) == 0) {
            this.this$0.onStateRequestFinished(this, this.asiaInputWrapper, this.asiaState, this.stateHandler, this.states);
            return;
        }
        if ((this.states & 1) > 0) {
            this.asiaState.setState(1);
            this.asiaInputWrapper.getCandidates(n);
        } else if ((this.states & 2) > 0) {
            this.asiaState.setState(2);
            this.asiaInputWrapper.getSpelling();
        }
    }

    @Override
    public void asiaReceivedCandidates(String[] stringArray) {
        this.asiaState.appendState(1);
        if (this.checkAsiaInput()) {
            return;
        }
        this.asiaCache.setCandidates(stringArray);
        this.asiaState.setCandidates(stringArray);
        this.this$0.onStateRequestPartlyFinished(this, this.asiaInputWrapper, this.asiaState, this.stateHandler, 1);
        if (this.cancelled || (this.states & 2) == 0 && (this.states & 4) == 0 && (this.states & 8) == 0) {
            this.this$0.onStateRequestFinished(this, this.asiaInputWrapper, this.asiaState, this.stateHandler, this.states);
            return;
        }
        if ((this.states & 2) > 0) {
            this.asiaState.setState(2);
            this.asiaInputWrapper.getSpelling();
        } else if ((this.states & 4) > 0) {
            this.asiaState.setState(4);
            this.asiaInputWrapper.getPhrases();
        } else if ((this.states & 8) > 0) {
            this.asiaState.setState(8);
            this.asiaInputWrapper.getCursorPosition();
        }
    }

    @Override
    public void asiaReceivedSpelling(String string) {
        this.asiaState.appendState(2);
        if (this.checkAsiaInput()) {
            return;
        }
        this.asiaCache.setSpelling(string);
        this.asiaState.setSpelling(string);
        this.this$0.onStateRequestPartlyFinished(this, this.asiaInputWrapper, this.asiaState, this.stateHandler, 2);
        if (this.cancelled || (this.states & 4) == 0 && (this.states & 8) == 0 && (this.states & 0x800) == 0) {
            this.this$0.onStateRequestFinished(this, this.asiaInputWrapper, this.asiaState, this.stateHandler, this.states);
            return;
        }
        if ((this.states & 4) > 0) {
            this.asiaState.setState(4);
            this.asiaInputWrapper.getPhrases();
        } else if ((this.states & 8) > 0) {
            this.asiaState.setState(8);
            this.asiaInputWrapper.getCursorPosition();
        } else if ((this.states & 0x800) > 0) {
            this.asiaState.setState(2048);
            this.asiaInputWrapper.getPredictionContext();
        }
    }

    @Override
    public void asiaReceivedPhrases(String string) {
        this.asiaState.appendState(4);
        this.asiaState.setPhrases(string);
        this.this$0.onStateRequestPartlyFinished(this, this.asiaInputWrapper, this.asiaState, this.stateHandler, 4);
        if (this.cancelled || (this.states & 8) == 0 && (this.states & 0x40) == 0 && (this.states & 0x80) == 0) {
            this.this$0.onStateRequestFinished(this, this.asiaInputWrapper, this.asiaState, this.stateHandler, this.states);
            return;
        }
        if ((this.states & 0x40) > 0) {
            this.asiaState.setState(64);
            this.asiaInputWrapper.getSegmentation(string);
        } else if ((this.states & 0x80) > 0) {
            this.asiaState.setState(128);
            this.asiaInputWrapper.addUserDefinedEntry(new UserDefinedEntry(string, ""));
            this.this$0.onStateRequestFinished(this, this.asiaInputWrapper, this.asiaState, this.stateHandler, this.states);
        } else if ((this.states & 8) > 0) {
            this.asiaInputWrapper.getCursorPosition();
        }
    }

    @Override
    public void asiaReceivedPredictionContext(String string) {
        this.asiaState.appendState(2048);
        this.asiaState.setPredictionContext(string);
        this.this$0.onStateRequestFinished(this, this.asiaInputWrapper, this.asiaState, this.stateHandler, this.states);
    }

    @Override
    public void asiaReceivedCursorPosition(int n) {
        this.asiaState.appendState(8);
        this.asiaState.setCursorPosition(n);
        this.this$0.onStateRequestPartlyFinished(this, this.asiaInputWrapper, this.asiaState, this.stateHandler, 8);
        if (this.cancelled || (this.states & 0x10) == 0) {
            this.this$0.onStateRequestFinished(this, this.asiaInputWrapper, this.asiaState, this.stateHandler, this.states);
        }
        if ((this.states & 0x10) > 0) {
            this.asiaState.setState(16);
            this.asiaInputWrapper.buildCandidates();
        }
    }

    @Override
    public void asiaReceivedErrorStatus(int n) {
        if (this.checkAsiaInput()) {
            return;
        }
        this.asiaCache.markMultipleStatesAsDirty((byte)31);
        this.asiaState.setStatus(n);
        this.this$0.warn(new StringBuffer().append("Received error status during [").append(this.this$0.traceStates(this.asiaState.getState())).append("]!").toString());
        switch (n) {
            case 49: {
                this.asiaState.setSpelling(this.asiaCache.getSpelling().concat(this.asiaCache.getSymbols()));
                break;
            }
            case 0: {
                switch (this.asiaState.getState()) {
                    case 2: {
                        this.asiaState.setStatus(-1);
                        this.asiaReceivedSpelling("");
                        return;
                    }
                }
                break;
            }
        }
        this.this$0.onStateRequestFinished(this, this.asiaInputWrapper, this.asiaState, this.stateHandler, this.states);
    }

    @Override
    public void asiaReceivedTimeout() {
        if (this.checkAsiaInput()) {
            return;
        }
        this.asiaState.setStatus(0);
        this.this$0.onStateRequestFinished(this, this.asiaInputWrapper, this.asiaState, this.stateHandler, this.states);
    }

    @Override
    public void asiaSelectedCandidate(int n) {
        this.asiaState.appendState(32);
        if (this.checkAsiaInput()) {
            return;
        }
        this.this$0.onStateRequestFinished(this, this.asiaInputWrapper, this.asiaState, this.stateHandler, this.states);
    }

    @Override
    public void asiaReceivedSegmentation(String string) {
        this.asiaState.appendState(64);
        if (this.checkAsiaInput()) {
            return;
        }
        this.asiaState.setSegmentation(string);
        this.this$0.onStateRequestPartlyFinished(this, this.asiaInputWrapper, this.asiaState, this.stateHandler, 64);
        if (this.cancelled || (this.states & 8) == 0) {
            this.this$0.onStateRequestFinished(this, this.asiaInputWrapper, this.asiaState, this.stateHandler, this.states);
            return;
        }
        if ((this.states & 0x80) > 0) {
            this.asiaState.setState(128);
            this.asiaInputWrapper.addUserDefinedEntry(new UserDefinedEntry(this.asiaState.getPhrases(), ""));
        }
        if ((this.states & 8) > 0) {
            this.asiaState.setState(8);
            this.asiaInputWrapper.getCursorPosition();
        }
    }

    private boolean checkAsiaInput() {
        return !this.asiaInputWrapper.isInitialized();
    }
}

