/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.china;

import de.vw.mib.properties.values.SpellerData;
import de.vw.mib.widgets.speller.asia.AbstractStateMachine;
import de.vw.mib.widgets.speller.asia.ConversionAwareState;
import de.vw.mib.widgets.speller.asia.State;
import de.vw.mib.widgets.speller.asia.handler.AbstractAsiaStateHandler;
import de.vw.mib.widgets.speller.asia.handler.AddUserDefinedEntryHandler;
import de.vw.mib.widgets.speller.asia.handler.AsiaStateHandlerRegistry;
import de.vw.mib.widgets.speller.asia.handler.AsiaStateHandlerUtilizingState;
import de.vw.mib.widgets.speller.asia.handler.ClearHandler;
import de.vw.mib.widgets.speller.asia.handler.GetSegmentationHandler;
import de.vw.mib.widgets.speller.asia.handler.InitHandler;
import de.vw.mib.widgets.speller.asia.handler.OkHandler;
import de.vw.mib.widgets.speller.asia.handler.SyncPhrasesHandler;

public class UserDefinedEntryAndWordSegmentationOnlyState
extends State
implements AsiaStateHandlerUtilizingState,
ConversionAwareState {
    private final AsiaStateHandlerRegistry asiaStateHandlerRegistry = new AsiaStateHandlerRegistry(this);
    protected AbstractAsiaStateHandler clearHandlerChain;
    protected AbstractAsiaStateHandler initHandlerChain;
    protected AbstractAsiaStateHandler okHandlerChain;
    protected SyncPhrasesHandler syncPhrasesHandler;
    protected AbstractAsiaStateHandler syncPhrasesHandlerChain;

    public UserDefinedEntryAndWordSegmentationOnlyState(AbstractStateMachine abstractStateMachine) {
        super(abstractStateMachine);
    }

    @Override
    public void armAsiaStateHandlers() {
        this.asiaStateHandlerRegistry.armAsiaStateHandlers();
    }

    @Override
    public void deregisterAllAsiaStateHandlers() {
        this.asiaStateHandlerRegistry.deregisterAllAsiaStateHandlers();
    }

    @Override
    public void deregisterAsiaStateHandler(AbstractAsiaStateHandler abstractAsiaStateHandler) {
        this.asiaStateHandlerRegistry.deregisterAsiaStateHandler(abstractAsiaStateHandler);
    }

    @Override
    public void disarmAsiaStateHandlers() {
        this.asiaStateHandlerRegistry.disarmAsiaStateHandlers();
    }

    @Override
    public boolean equalConversionType(ConversionAwareState conversionAwareState) {
        if (this == conversionAwareState) {
            return true;
        }
        return conversionAwareState instanceof UserDefinedEntryAndWordSegmentationOnlyState;
    }

    protected void initClearHandlerChain() {
        this.clearHandlerChain = new ClearHandler();
        this.registerAsiaStateHandler(this.clearHandlerChain);
    }

    protected void initInitHandlerChain() {
        this.initHandlerChain = new InitHandler();
        this.registerAsiaStateHandler(this.initHandlerChain);
    }

    protected void initOkHandlerChain() {
        boolean bl = this.speller.is_userDatabaseEnabled();
        boolean bl2 = this.speller.is_wordSegmentationEnabled();
        if (bl || bl2) {
            if (bl) {
                this.okHandlerChain = new AddUserDefinedEntryHandler(1);
            }
            if (bl2 && !bl) {
                this.okHandlerChain = new GetSegmentationHandler(1);
            } else if (bl2) {
                this.okHandlerChain.appendNextStateHandler(new GetSegmentationHandler(1));
            }
            this.okHandlerChain.appendNextStateHandler(new OkHandler());
        } else {
            this.okHandlerChain = new OkHandler();
        }
        this.registerAsiaStateHandler(this.okHandlerChain);
    }

    protected void initSyncPhrasesHandlerChain() {
        this.syncPhrasesHandler = new SyncPhrasesHandler();
        this.syncPhrasesHandlerChain = this.syncPhrasesHandler;
        this.registerAsiaStateHandler(this.syncPhrasesHandlerChain);
    }

    @Override
    public boolean okPressed() {
        this.okHandlerChain.doGetState();
        return true;
    }

    @Override
    public void onDeInitState() {
        this.disarmAsiaStateHandlers();
        this.deregisterAllAsiaStateHandlers();
        this.clearHandlerChain = null;
        this.initHandlerChain = null;
        this.okHandlerChain = null;
        super.onDeInitState();
    }

    @Override
    public void onEnterState(State state) {
        super.onEnterState(state);
        this.armAsiaStateHandlers();
        if (!(state instanceof ConversionAwareState) || !((ConversionAwareState)((Object)state)).equalConversionType(this)) {
            if (state == null) {
                this.fireHMIEvent("hwrDisabled");
            }
            this.initHandlerChain.doGetState();
        }
    }

    @Override
    public void onInitState() {
        super.onInitState();
        this.initClearHandlerChain();
        this.initInitHandlerChain();
        this.initOkHandlerChain();
        this.initSyncPhrasesHandlerChain();
    }

    @Override
    public void onLeaveState(State state) {
        if (!(state instanceof ConversionAwareState) || !((ConversionAwareState)((Object)state)).equalConversionType(this)) {
            this.clearHandlerChain.doGetState();
        }
        super.onLeaveState(state);
    }

    @Override
    public void onStayState() {
        this.disarmAsiaStateHandlers();
        this.deregisterAllAsiaStateHandlers();
        this.onInitState();
        this.armAsiaStateHandlers();
        super.onStayState();
    }

    @Override
    public void registerAsiaStateHandler(AbstractAsiaStateHandler abstractAsiaStateHandler) {
        this.asiaStateHandlerRegistry.registerAsiaStateHandler(abstractAsiaStateHandler);
    }

    @Override
    public void setSpellerData(SpellerData spellerData) {
        String string = spellerData != null ? spellerData.getEnteredText() : "";
        int n = spellerData != null ? spellerData.getCursorPosition() : 0;
        this.syncPhrasesHandler.setPhrases(string);
        this.syncPhrasesHandler.setCursorPosition(n);
        this.syncPhrasesHandler.doGetState();
    }

    @Override
    public String toString() {
        return "UserDefinedEntryAndWordSegmentationOnly";
    }
}

