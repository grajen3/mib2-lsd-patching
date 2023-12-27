/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.handler;

import de.vw.mib.widgets.speller.asia.State;
import de.vw.mib.widgets.speller.asia.handler.AbstractAsiaStateHandler;
import de.vw.mib.widgets.speller.asia.handler.HandlerStrategy;
import de.vw.mib.widgets.speller.asia.handler.StateUtilizingAsiaStateHandler;
import de.vw.mib.widgets.speller.asia.handler.StrategyUtilizingAsiaStateHandler;

public abstract class AbstractStateStrategyUtilizingAsiaStateHandler
extends AbstractAsiaStateHandler
implements StateUtilizingAsiaStateHandler,
StrategyUtilizingAsiaStateHandler {
    private State state;
    private HandlerStrategy strategy;

    protected AbstractStateStrategyUtilizingAsiaStateHandler() {
        this(null, null);
    }

    protected AbstractStateStrategyUtilizingAsiaStateHandler(State state) {
        this(state, null);
    }

    protected AbstractStateStrategyUtilizingAsiaStateHandler(HandlerStrategy handlerStrategy) {
        this(null, handlerStrategy);
    }

    protected AbstractStateStrategyUtilizingAsiaStateHandler(State state, HandlerStrategy handlerStrategy) {
        this.state = state;
        this.strategy = handlerStrategy;
    }

    @Override
    public final State getState() {
        return this.state;
    }

    @Override
    public final void setState(State state) {
        State state2 = this.state;
        if (state2 != state) {
            this.state = state;
            this.stateChanged(state2, state);
        }
    }

    protected final HandlerStrategy getStrategy() {
        return this.strategy;
    }

    @Override
    public final void setStrategy(HandlerStrategy handlerStrategy) {
        HandlerStrategy handlerStrategy2 = this.strategy;
        if (handlerStrategy2 != handlerStrategy) {
            this.strategy = handlerStrategy;
            this.strategyChanged(handlerStrategy2, handlerStrategy);
        }
    }

    protected void stateChanged(State state, State state2) {
    }

    protected void strategyChanged(HandlerStrategy handlerStrategy, HandlerStrategy handlerStrategy2) {
        if (handlerStrategy2 != null) {
            handlerStrategy2.setHandler(this);
        }
    }

    protected final void fireHMIEvent(String string) {
        if (this.state != null) {
            this.state.fireHMIEvent(string);
        }
    }

    protected final void fireIntegerEvent(String string, int n) {
        if (this.state != null) {
            this.state.fireIntegerEvent(string, n);
        }
    }

    protected final void fireSpellerEvent(String string, String string2, int n, int n2, int n3) {
        if (this.state != null) {
            this.state.fireSpellerEvent(string, string2, n, n2, n3);
        }
    }

    protected final void fireStringEvent(String string, String string2) {
        if (this.state != null) {
            this.state.fireStringEvent(string, string2);
        }
    }
}

