/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia;

import de.vw.mib.properties.values.SpellerData;
import de.vw.mib.widgets.FeatureToggles;
import de.vw.mib.widgets.speller.SpellerFrameworkFacade;
import de.vw.mib.widgets.speller.asia.AbstractStateMachine;
import de.vw.mib.widgets.speller.asia.ConversionAwareState;
import de.vw.mib.widgets.speller.asia.HWRAwareState;
import de.vw.mib.widgets.speller.asia.State;
import de.vw.mib.widgets.speller.asia.handler.AbstractAsiaStateHandler;
import de.vw.mib.widgets.speller.asia.handler.AsiaStateHandlerRegistry;
import de.vw.mib.widgets.speller.asia.handler.AsiaStateHandlerUtilizingState;
import de.vw.mib.widgets.speller.asia.handler.CandidateSelectedHandler;
import de.vw.mib.widgets.speller.asia.handler.ClearHandler;
import de.vw.mib.widgets.speller.asia.handler.CursorPositionHandler;
import de.vw.mib.widgets.speller.asia.handler.InitHandler;
import de.vw.mib.widgets.speller.asia.handler.SelectCandidateHandler;
import de.vw.mib.widgets.speller.asia.handler.SwitchAlphabetHandler;
import de.vw.mib.widgets.speller.asia.handler.SwitchToHWRStateHandler;
import de.vw.mib.widgets.speller.asia.handler.SyncPhrasesHandler;
import de.vw.mib.widgets.speller.asia.handler.TransferSymbolsUnconvertedHandler;

public abstract class AbstractFreetextConversionState
extends State
implements AsiaStateHandlerUtilizingState,
ConversionAwareState {
    private final AsiaStateHandlerRegistry asiaStateHandlerRegistry = new AsiaStateHandlerRegistry(this);
    protected CandidateSelectedHandler candidateSelectedHandler;
    protected AbstractAsiaStateHandler candidateSelectionHandlerChain;
    protected AbstractAsiaStateHandler clearHandlerChain;
    protected CursorPositionHandler cursorPositionHandler;
    protected AbstractAsiaStateHandler cursorPositionHandlerChain;
    protected AbstractAsiaStateHandler initHandlerChain;
    protected SelectCandidateHandler selectCanidateHandler;
    protected SwitchAlphabetHandler switchAlphabetHandler;
    protected AbstractAsiaStateHandler switchAlphabetHandlerChain;
    protected SyncPhrasesHandler syncPhrasesHandler;
    protected AbstractAsiaStateHandler syncPhrasesHandlerChain;
    protected SwitchToHWRStateHandler switchToHWRStateHandler;

    protected AbstractFreetextConversionState(AbstractStateMachine abstractStateMachine) {
        super(abstractStateMachine);
    }

    @Override
    public boolean alphabetSwitch(int n) {
        int[] nArray = this.speller.get_alphabetMapping();
        boolean bl = false;
        if (nArray != null) {
            int n2 = this.getAlphabetIndexForInputType(nArray, 3);
            int n3 = this.getAlphabetIndexForInputType(nArray, 5);
            if (n2 == n || n3 == n) {
                bl = true;
            }
        }
        this.switchToHWRStateHandler.setShouldTakeOver(bl);
        this.switchAlphabetHandler.setAlphabetIndex(n);
        this.switchAlphabetHandlerChain.doGetState();
        return true;
    }

    protected final int getAlphabetIndexForInputType(int[] nArray, int n) {
        return nArray.length > n ? nArray[n] : -1;
    }

    @Override
    public final void armAsiaStateHandlers() {
        this.asiaStateHandlerRegistry.armAsiaStateHandlers();
    }

    @Override
    public boolean candidateSelected(String string, int n) {
        this.selectCanidateHandler.setIndex(n);
        this.selectCanidateHandler.setCandidate(string);
        this.candidateSelectedHandler.setSelectedCandidate(string);
        this.candidateSelectionHandlerChain.doGetState();
        return true;
    }

    @Override
    public boolean charactersFiltered(String[] stringArray, String[] stringArray2, boolean bl) {
        this.speller.setCandidates(stringArray);
        this.selectCanidateHandler.setFiltered(bl);
        this.selectCanidateHandler.setNoneFilteredCandidates(stringArray2);
        return true;
    }

    @Override
    public boolean cursorLeftPressed() {
        this.cursorPositionHandler.setDirection(2);
        this.cursorPositionHandlerChain.doGetState();
        return true;
    }

    @Override
    public boolean cursorRightPressed() {
        this.cursorPositionHandler.setDirection(8);
        this.cursorPositionHandlerChain.doGetState();
        return true;
    }

    @Override
    public boolean cursorPositionChanged(int n) {
        this.cursorPositionHandler.setPosition(n);
        this.cursorPositionHandlerChain.doGetState();
        return true;
    }

    @Override
    public final void deregisterAllAsiaStateHandlers() {
        this.asiaStateHandlerRegistry.deregisterAllAsiaStateHandlers();
    }

    @Override
    public final void deregisterAsiaStateHandler(AbstractAsiaStateHandler abstractAsiaStateHandler) {
        this.asiaStateHandlerRegistry.deregisterAsiaStateHandler(abstractAsiaStateHandler);
    }

    @Override
    public final void disarmAsiaStateHandlers() {
        this.asiaStateHandlerRegistry.disarmAsiaStateHandlers();
    }

    protected void initCandidateSelectionHandlerChain() {
        this.selectCanidateHandler = new SelectCandidateHandler();
        this.candidateSelectedHandler = new CandidateSelectedHandler();
        this.candidateSelectionHandlerChain = this.selectCanidateHandler;
        this.candidateSelectionHandlerChain.appendNextStateHandler(this.candidateSelectedHandler);
        this.registerAsiaStateHandler(this.candidateSelectionHandlerChain);
    }

    protected void initClearHandlerChain() {
        this.clearHandlerChain = new ClearHandler();
        this.registerAsiaStateHandler(this.clearHandlerChain);
    }

    protected void initCursorPositionHandlerChain() {
        this.cursorPositionHandler = new CursorPositionHandler();
        this.cursorPositionHandlerChain = this.cursorPositionHandler;
        this.registerAsiaStateHandler(this.cursorPositionHandlerChain);
    }

    protected void initInitHandlerChain() {
        this.initHandlerChain = new InitHandler();
        this.registerAsiaStateHandler(this.initHandlerChain);
    }

    protected void initSwitchAlphabetHandlerChain() {
        this.switchToHWRStateHandler = new SwitchToHWRStateHandler();
        this.switchAlphabetHandler = new SwitchAlphabetHandler();
        this.switchAlphabetHandlerChain = this.switchToHWRStateHandler;
        this.switchAlphabetHandlerChain.appendNextStateHandler(this.switchAlphabetHandler);
        if (FeatureToggles.isFeatureToggleEnabled("de.vw.mib.widgets.asiaspeller.permanent.conversion.disabled")) {
            this.switchAlphabetHandlerChain = new TransferSymbolsUnconvertedHandler();
            this.switchAlphabetHandlerChain.appendNextStateHandler(this.switchAlphabetHandler);
        }
        this.registerAsiaStateHandler(this.switchAlphabetHandlerChain);
    }

    protected void initSyncPhrasesHandlerChain() {
        this.syncPhrasesHandler = new SyncPhrasesHandler();
        this.syncPhrasesHandlerChain = this.syncPhrasesHandler;
        this.registerAsiaStateHandler(this.syncPhrasesHandlerChain);
    }

    protected boolean isCharMinReached() {
        return this.speller.getEnteredText().length() >= this.speller.get_charMin();
    }

    protected final boolean isTransferUnconvertedTriggered() {
        char c2;
        boolean bl = false;
        String string = this.stateContext.getLastEnteredCharacter();
        if (string != null && string.length() > 0 && Character.isSpaceChar(c2 = string.charAt(0))) {
            bl = true;
        }
        return bl;
    }

    @Override
    public void onDeInitState() {
        this.disarmAsiaStateHandlers();
        this.deregisterAllAsiaStateHandlers();
        this.candidateSelectedHandler = null;
        this.candidateSelectionHandlerChain = null;
        this.clearHandlerChain = null;
        this.cursorPositionHandler = null;
        this.cursorPositionHandlerChain = null;
        this.initHandlerChain = null;
        this.selectCanidateHandler = null;
        this.syncPhrasesHandler = null;
        this.syncPhrasesHandlerChain = null;
        this.switchToHWRStateHandler = null;
        this.switchAlphabetHandler = null;
        this.switchAlphabetHandlerChain = null;
        super.onDeInitState();
    }

    @Override
    public void onEnterState(State state) {
        super.onEnterState(state);
        this.armAsiaStateHandlers();
        if (!(state instanceof ConversionAwareState) || !((ConversionAwareState)((Object)state)).equalConversionType(this)) {
            boolean bl;
            if (state == null) {
                this.fireHMIEvent("hwrDisabled");
            }
            SpellerFrameworkFacade.getFacade(this.speller).initFilter();
            this.initHandlerChain.doGetState();
            String string = this.speller.getEnteredText();
            boolean bl2 = string.length() > 0;
            boolean bl3 = bl = this.speller.getSpelling().length() > 0;
            if (!bl && bl2) {
                int n;
                boolean bl4 = this.speller.isSelectionDefined();
                if (bl4) {
                    boolean bl5;
                    n = this.speller.getSelectionStart();
                    int n2 = this.speller.getSelectionEnd();
                    boolean bl6 = bl5 = n == 0 && n2 == string.length();
                    if (bl5) {
                        bl2 = false;
                    } else {
                        boolean bl7 = bl2 = (string = string.substring(0, n)).length() > 0;
                    }
                }
                if (bl2) {
                    n = this.speller.getCursorPosition();
                    if (n <= string.length()) {
                        this.syncPhrasesHandler.setCursorPosition(n);
                    }
                    this.syncPhrasesHandler.setPhrases(string);
                    this.syncPhrasesHandler.doGetStateSingle();
                }
            }
        }
    }

    @Override
    public void onLeaveState(State state) {
        if (!(state instanceof ConversionAwareState) || !((ConversionAwareState)((Object)state)).equalConversionType(this)) {
            SpellerFrameworkFacade.getFacade(this.speller).deInitFilter();
            this.speller.setCandidates(null);
            if (state instanceof HWRAwareState) {
                if (this.speller.getSpelling().length() > 0) {
                    this.clearHandlerChain.doGetState();
                }
            } else {
                this.clearHandlerChain.doGetState();
            }
        }
        super.onLeaveState(state);
    }

    @Override
    public void onInitState() {
        super.onInitState();
        this.initCandidateSelectionHandlerChain();
        this.initClearHandlerChain();
        this.initCursorPositionHandlerChain();
        this.initInitHandlerChain();
        this.initSyncPhrasesHandlerChain();
        this.initSwitchAlphabetHandlerChain();
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
    public final void registerAsiaStateHandler(AbstractAsiaStateHandler abstractAsiaStateHandler) {
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
    public boolean shiftPressed() {
        this.stateContext.toggleLowerUpperCase();
        return true;
    }

    @Override
    public String toString() {
        return "AbstractFreetextConversion";
    }
}

