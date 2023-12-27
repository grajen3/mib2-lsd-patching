/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.handler;

import de.vw.mib.collections.copyonwrite.CowList;
import de.vw.mib.widgets.models.AsiaSpellerModel;
import de.vw.mib.widgets.speller.asia.AsiaDatabase;
import de.vw.mib.widgets.speller.asia.AsiaInputInitializer;
import de.vw.mib.widgets.speller.asia.State;
import de.vw.mib.widgets.speller.asia.handler.AbstractAsiaStateHandler;
import de.vw.mib.widgets.speller.asia.handler.AsiaStateHandlerUtilizingState;
import de.vw.mib.widgets.speller.asia.handler.DefaultAsiaStateProxy;
import de.vw.mib.widgets.speller.asia.handler.StateUtilizingAsiaStateHandler;

public final class AsiaStateHandlerRegistry
implements AsiaStateHandlerUtilizingState {
    private CowList asiaStateHandlers = CowList.EMPTY;
    private final State state;

    public AsiaStateHandlerRegistry(State state) {
        this.state = state;
    }

    @Override
    public void armAsiaStateHandlers() {
        AsiaSpellerModel asiaSpellerModel = this.state.getWidget();
        if (asiaSpellerModel != null) {
            AsiaInputInitializer asiaInputInitializer = asiaSpellerModel.getAsiaInputInitializer();
            AsiaDatabase asiaDatabase = AsiaDatabase.getAsiaInputWrapper(asiaInputInitializer);
            DefaultAsiaStateProxy defaultAsiaStateProxy = DefaultAsiaStateProxy.getProxy(asiaDatabase);
            for (CowList cowList = this.asiaStateHandlers; cowList != CowList.EMPTY; cowList = cowList.tail()) {
                AbstractAsiaStateHandler abstractAsiaStateHandler = (AbstractAsiaStateHandler)cowList.head();
                abstractAsiaStateHandler.setAsiaStateProxy(defaultAsiaStateProxy);
                this.setState(abstractAsiaStateHandler, this.state);
            }
        } else {
            throw new IllegalStateException("The states' speller instance is NOT set!");
        }
    }

    protected void setState(AbstractAsiaStateHandler abstractAsiaStateHandler, State state) {
        if (abstractAsiaStateHandler instanceof StateUtilizingAsiaStateHandler) {
            ((StateUtilizingAsiaStateHandler)((Object)abstractAsiaStateHandler)).setState(state);
        }
        if (abstractAsiaStateHandler.hasNextStateHandler()) {
            this.setState(abstractAsiaStateHandler.nextStateHandler, state);
        }
    }

    @Override
    public void deregisterAllAsiaStateHandlers() {
        this.asiaStateHandlers = CowList.EMPTY;
    }

    @Override
    public void deregisterAsiaStateHandler(AbstractAsiaStateHandler abstractAsiaStateHandler) {
        this.asiaStateHandlers = this.asiaStateHandlers.remove(abstractAsiaStateHandler);
    }

    @Override
    public void disarmAsiaStateHandlers() {
        for (CowList cowList = this.asiaStateHandlers; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            AbstractAsiaStateHandler abstractAsiaStateHandler = (AbstractAsiaStateHandler)cowList.head();
            abstractAsiaStateHandler.setAsiaStateProxy(null);
        }
    }

    @Override
    public void registerAsiaStateHandler(AbstractAsiaStateHandler abstractAsiaStateHandler) {
        this.asiaStateHandlers = this.asiaStateHandlers.addIfAbsent(abstractAsiaStateHandler);
    }
}

