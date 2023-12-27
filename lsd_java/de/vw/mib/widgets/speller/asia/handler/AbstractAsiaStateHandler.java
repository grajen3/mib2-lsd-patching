/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.handler;

import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.speller.asia.AsiaDatabase;
import de.vw.mib.widgets.speller.asia.AsiaDatabaseState;
import de.vw.mib.widgets.speller.asia.AsiaDatabaseStateListener;
import de.vw.mib.widgets.speller.asia.AsiaStatusText;
import de.vw.mib.widgets.speller.asia.handler.AsiaStateProxy;

public abstract class AbstractAsiaStateHandler
implements AsiaDatabaseStateListener,
Cloneable {
    private static final int UNDEFINED_REQUETSTED_STATES;
    protected static final Logger LOGGER;
    protected AbstractAsiaStateHandler nextStateHandler;
    protected int requestedStates;
    protected IntObjectMap stateParameters;
    protected AsiaStateProxy stateProxy;
    private int stateShadowCounter;

    protected AbstractAsiaStateHandler() {
        this.reset();
    }

    public final void reset() {
        this.requestedStates = -1;
        this.stateShadowCounter = 0;
        this.onReset();
    }

    public final AbstractAsiaStateHandler appendNextStateHandler(AbstractAsiaStateHandler abstractAsiaStateHandler) {
        if (this.hasNextStateHandler() && this.nextStateHandler != abstractAsiaStateHandler) {
            return this.nextStateHandler.appendNextStateHandler(abstractAsiaStateHandler);
        }
        return this.setNextStateHandler(abstractAsiaStateHandler);
    }

    public final boolean hasNextStateHandler() {
        return this.nextStateHandler != null;
    }

    public final AbstractAsiaStateHandler insertNextStateHandler(int n, AbstractAsiaStateHandler abstractAsiaStateHandler) {
        if (1 <= n && n <= this.size()) {
            AbstractAsiaStateHandler abstractAsiaStateHandler2 = this.nextStateHandler;
            for (int i2 = 2; i2 < n; ++i2) {
                abstractAsiaStateHandler2 = abstractAsiaStateHandler2.nextStateHandler;
            }
            AbstractAsiaStateHandler abstractAsiaStateHandler3 = abstractAsiaStateHandler2.nextStateHandler;
            return abstractAsiaStateHandler2.setNextStateHandler(abstractAsiaStateHandler).appendNextStateHandler(abstractAsiaStateHandler3);
        }
        throw new IndexOutOfBoundsException();
    }

    public final AbstractAsiaStateHandler setNextStateHandler(AbstractAsiaStateHandler abstractAsiaStateHandler) {
        this.nextStateHandler = abstractAsiaStateHandler;
        this.stateShadowCounter = 0;
        return abstractAsiaStateHandler;
    }

    public final void setAsiaStateProxy(AsiaStateProxy asiaStateProxy) {
        if (this.hasNextStateHandler()) {
            this.nextStateHandler.setAsiaStateProxy(asiaStateProxy);
        }
        if (this.stateProxy != null) {
            this.stateProxy.deregisterStateHandler(this);
        }
        this.stateProxy = asiaStateProxy;
        if (this.stateProxy != null) {
            this.stateProxy.registerStateHandler(this);
        }
    }

    public final int size() {
        int n = 1;
        AbstractAsiaStateHandler abstractAsiaStateHandler = this.nextStateHandler;
        while (abstractAsiaStateHandler != null && abstractAsiaStateHandler.hasNextStateHandler()) {
            abstractAsiaStateHandler = abstractAsiaStateHandler.nextStateHandler;
            ++n;
        }
        return n;
    }

    public String toString() {
        return super.getClass().getName();
    }

    @Override
    public final void asiaReceivedAsiaDatabaseState(AsiaDatabaseState asiaDatabaseState) {
        int n = asiaDatabaseState.getStatus();
        switch (n) {
            case -1: {
                this.onStateSuccessfullyReceived(asiaDatabaseState);
                this.doGetNextState();
                this.reset();
                break;
            }
            default: {
                this.onStateFaultyReceived(n, asiaDatabaseState);
                this.reset();
            }
        }
    }

    protected Object clone() {
        AbstractAsiaStateHandler abstractAsiaStateHandler = (AbstractAsiaStateHandler)super.clone();
        if (abstractAsiaStateHandler.stateParameters != null && !abstractAsiaStateHandler.stateParameters.isEmpty()) {
            IntObjectOptHashMap intObjectOptHashMap = new IntObjectOptHashMap();
            intObjectOptHashMap.putAll(abstractAsiaStateHandler.stateParameters);
            abstractAsiaStateHandler.stateParameters = intObjectOptHashMap;
        }
        return abstractAsiaStateHandler;
    }

    protected final void doGetNextState() {
        if (this.hasNextStateHandler() && this.isDoGetNextStateAllowed()) {
            this.nextStateHandler.doGetState();
        }
        this.resumeDoGetNextState();
    }

    public final void doGetState() {
        if (this.stateProxy != null && this.stateProxy.getAsia() != null) {
            this.setRequestedStates(-1);
            this.doGetState(this.stateProxy, this.stateProxy.getAsia());
        } else {
            LogMessage logMessage = LOGGER.warn(64);
            logMessage.append(super.getClass().getName()).append(": ").append("No proxy set to get the state from or proxy misconfigured!").log();
        }
    }

    protected void doGetState(AsiaStateProxy asiaStateProxy, AsiaDatabase asiaDatabase) {
        if (this.stateParameters == null) {
            this.stateParameters = new IntObjectOptHashMap();
        } else {
            this.stateParameters.clear();
        }
        this.doGetState(asiaStateProxy, this.stateParameters, asiaDatabase);
    }

    protected void doGetState(AsiaStateProxy asiaStateProxy, IntObjectMap intObjectMap, AsiaDatabase asiaDatabase) {
    }

    public final void doGetStateSingle() {
        this.skipDoGetNextState();
        this.doGetState();
    }

    protected final boolean isDoGetNextStateAllowed() {
        return this.stateShadowCounter == 0;
    }

    protected void onReset() {
    }

    protected void onStateSuccessfullyReceived(AsiaDatabaseState asiaDatabaseState) {
        if (this.stateProxy != null && this.stateProxy.getAsia() != null) {
            this.onStateSuccessfullyReceived(asiaDatabaseState, this.stateProxy.getAsia());
        } else {
            LogMessage logMessage = LOGGER.error(64);
            logMessage.append(super.getClass().getName()).append(": ").append("No proxy set to get the state from or proxy misconfigured!").log();
        }
    }

    protected void onStateSuccessfullyReceived(AsiaDatabaseState asiaDatabaseState, AsiaDatabase asiaDatabase) {
        if (this.stateParameters != null && !this.stateParameters.isEmpty()) {
            this.onStateSuccessfullyReceived(asiaDatabaseState, this.stateParameters, asiaDatabase);
        }
    }

    protected void onStateSuccessfullyReceived(AsiaDatabaseState asiaDatabaseState, IntObjectMap intObjectMap, AsiaDatabase asiaDatabase) {
    }

    protected void onStateFaultyReceived(int n, AsiaDatabaseState asiaDatabaseState) {
        if (this.stateProxy != null && this.stateProxy.getAsia() != null) {
            this.onStateFaultyReceived(n, asiaDatabaseState, this.stateProxy, this.stateProxy.getAsia());
        } else {
            LogMessage logMessage = LOGGER.error(64);
            logMessage.append(super.getClass().getName()).append(": ").append("No proxy set to get the state from or proxy misconfigured!").log();
        }
    }

    protected void onStateFaultyReceived(int n, AsiaDatabaseState asiaDatabaseState, AsiaStateProxy asiaStateProxy, AsiaDatabase asiaDatabase) {
        LogMessage logMessage = LOGGER.error(64);
        logMessage.append("Widget '").append(super.getClass().getName()).append("': ERROR (").append(n).append(") ").append(AsiaStatusText.getText(n)).log();
    }

    protected final void resumeDoGetNextState() {
        --this.stateShadowCounter;
        this.stateShadowCounter = Util.clamp(this.stateShadowCounter, 0, -129);
    }

    protected final void setRequestedStates(int n) {
        this.requestedStates = n;
    }

    protected final void skipDoGetNextState() {
        ++this.stateShadowCounter;
    }

    static {
        LOGGER = ServiceManager.loggerFactory.getLogger(2048);
    }
}

