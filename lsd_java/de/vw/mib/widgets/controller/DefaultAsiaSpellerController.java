/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.event.HMIEvent;
import de.vw.mib.widgets.controller.AbstractSpellerController;
import de.vw.mib.widgets.controller.AsiaSpellerController;
import de.vw.mib.widgets.controller.DefaultAsiaSpellerController$OutEventDelegator;
import de.vw.mib.widgets.log.SpellerLogger;
import de.vw.mib.widgets.models.AsiaSpellerModel;
import de.vw.mib.widgets.models.SpellerButtonModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.speller.SpellerElement;
import de.vw.mib.widgets.speller.asia.AbstractStateMachine;
import de.vw.mib.widgets.speller.asia.china.ChinaStateMachine;
import de.vw.mib.widgets.speller.asia.japan.JapanStateMachine;
import de.vw.mib.widgets.speller.asia.korea.KoreaStateMachine;

public class DefaultAsiaSpellerController
extends AbstractSpellerController
implements AsiaSpellerController {
    private DefaultAsiaSpellerController$OutEventDelegator outEventDelegator;
    private AbstractStateMachine stateMachine;

    @Override
    public void activate() {
        super.activate();
        this.startStateMachine();
    }

    @Override
    public void deActivate() {
        this.suspendStateMachine();
        super.deActivate();
    }

    @Override
    public void deInit() {
        this.stopStateMachine();
        super.deInit();
    }

    @Override
    protected void reset() {
        super.reset();
        this.outEventDelegator = new DefaultAsiaSpellerController$OutEventDelegator(this);
    }

    protected final int getAlphabetIndexForInputType(int[] nArray, int n) {
        return nArray != null && nArray.length > n ? nArray[n] : -1;
    }

    protected final AbstractStateMachine getStateMachine() {
        return this.stateMachine;
    }

    protected final void setStateMachine(AbstractStateMachine abstractStateMachine) {
        this.stateMachine = abstractStateMachine;
    }

    @Override
    public void fire_cursorLeftPress() {
        if (this.stateMachine == null || !this.stateMachine.getState().cursorLeftPressed()) {
            super.fire_cursorLeftPress();
        }
    }

    @Override
    public void fire_cursorRightPress() {
        if (this.stateMachine == null || !this.stateMachine.getState().cursorRightPressed()) {
            super.fire_cursorRightPress();
        }
    }

    @Override
    public void fire_deletePress() {
        this.fire_deleted();
    }

    @Override
    public void fire_deleteLongPress() {
        this.fire_longDeleted();
    }

    @Override
    public void fire_hwrErrorConfirmed() {
        if (this.stateMachine == null || !this.stateMachine.getState().hwrErrorConfirmed()) {
            // empty if block
        }
    }

    @Override
    public void fire_cursorPositionChanged(int n) {
        if (this.stateMachine == null || !this.stateMachine.getState().cursorPositionChanged(n)) {
            super.fire_cursorPositionChanged(n);
        }
    }

    @Override
    public void fire_deleted() {
        if (this.stateMachine == null || !this.stateMachine.getState().deleted()) {
            super.fire_deleted();
        }
    }

    @Override
    public void fire_longDeleted() {
        if (this.stateMachine == null || !this.stateMachine.getState().longDeleted()) {
            super.fire_longDeleted();
        }
    }

    @Override
    public void fire_hwrDisabled() {
        if (this.stateMachine == null || !this.stateMachine.getState().hwrDisabled()) {
            this.fireHMIEvent("hwrDisabled");
        }
    }

    @Override
    public void fire_hwrEnabled() {
        if (this.stateMachine == null || !this.stateMachine.getState().hwrEnabled()) {
            this.fireHMIEvent("hwrEnabled");
        }
    }

    @Override
    public void fire_hwrErrorOccurred() {
        if (this.stateMachine == null || !this.stateMachine.getState().hwrErrorOccurred()) {
            this.fireHMIEvent("hwrErrorOccurred");
        }
    }

    @Override
    public void fire_keyLongPressed() {
        if (this.stateMachine == null || !this.stateMachine.getState().keyLongPressed()) {
            super.fire_keyLongPressed();
        }
    }

    @Override
    public void fire_keyPressed() {
        if (this.stateMachine == null || !this.stateMachine.getState().keyPressed()) {
            super.fire_keyPressed();
        }
    }

    @Override
    public void fire_okLongPressed() {
    }

    @Override
    public void fire_okPressed() {
        if (this.stateMachine == null || !this.stateMachine.getState().okPressed()) {
            super.fire_okPressed();
        }
    }

    @Override
    public void fire_ok2LongPressed() {
    }

    @Override
    public void fire_ok2Pressed() {
    }

    @Override
    public void fire_ok3LongPressed() {
    }

    @Override
    public void fire_ok3Pressed() {
    }

    @Override
    public void fire_syllablesAvailable() {
        this.fireStringEvent("syllablesAvailable", "");
    }

    @Override
    public void fire_wordSegmentationAvailable() {
        this.fireStringEvent("wordSegmentationAvailable", "");
    }

    @Override
    public boolean consumeHMIEvent(HMIEvent hMIEvent, String string) {
        boolean bl = false;
        if (string.equals("hwrErrorConfirmed")) {
            this.fire_hwrErrorConfirmed();
            bl = true;
        } else {
            bl = super.consumeHMIEvent(hMIEvent, string);
        }
        return bl;
    }

    @Override
    protected void onAlphabetSwitch(int n) {
        if (this.stateMachine == null || !this.stateMachine.getState().alphabetSwitch(n)) {
            super.onAlphabetSwitch(n);
        }
    }

    @Override
    public void onCandidateSelected(String string, int n) {
        if (this.stateMachine == null || !this.stateMachine.getState().candidateSelected(string, n)) {
            this.fireSpellerEvent("keyPressed", string, 0, 0, 0);
        }
    }

    @Override
    public void onCharactersFiltered(String[] stringArray, String[] stringArray2, boolean bl) {
        if (this.stateMachine == null || !this.stateMachine.getState().charactersFiltered(stringArray, stringArray2, bl)) {
            // empty if block
        }
    }

    @Override
    public void onHwrCharactersRecognized(String[] stringArray) {
        if (this.stateMachine == null || !this.stateMachine.getState().hwrCharactersRecognized(stringArray)) {
            AsiaSpellerModel asiaSpellerModel = (AsiaSpellerModel)this.getWidget();
            asiaSpellerModel.setRecognizedCharacters(stringArray);
        }
    }

    @Override
    public void onNextValidCharacterSelected(String string, int n) {
        if (this.stateMachine == null || !this.stateMachine.getState().nextValidCharacterSelected(string, n)) {
            // empty if block
        }
    }

    @Override
    public void onPredictionSelected(String string, int n) {
        if (this.stateMachine == null || !this.stateMachine.getState().predictionSelected(string, n)) {
            // empty if block
        }
    }

    @Override
    public void onPreviewLineCollapsed() {
        if (this.stateMachine == null || !this.stateMachine.getState().previewLineCollapsed()) {
            // empty if block
        }
    }

    @Override
    public void onPreviewLineExpanded() {
        if (this.stateMachine == null || !this.stateMachine.getState().previewLineExpanded()) {
            // empty if block
        }
    }

    @Override
    public void onRecognizedCharacterSelected(String string, int n) {
        if (this.stateMachine == null || !this.stateMachine.getState().recognizedCharacterSelected(string, n)) {
            // empty if block
        }
    }

    @Override
    protected void onSubSpellerClosed() {
        if (this.stateMachine == null || !this.stateMachine.getState().subSpellerClosed()) {
            super.onSubSpellerClosed();
        }
    }

    @Override
    protected void onSubSpellerOpened() {
        if (this.stateMachine == null || !this.stateMachine.getState().subSpellerOpened()) {
            super.onSubSpellerOpened();
        }
    }

    @Override
    public void propertyChanged(WidgetModel widgetModel, int n) {
        switch (n) {
            case 63: {
                this.inputTypeChanged();
                break;
            }
            default: {
                super.propertyChanged(widgetModel, n);
            }
        }
    }

    protected void inputTypeChanged() {
        if (this.stateMachine != null) {
            this.stopStateMachine();
            this.startStateMachine();
        }
    }

    @Override
    protected void resolveFire(boolean bl, SpellerButtonModel spellerButtonModel) {
        AsiaSpellerModel asiaSpellerModel = (AsiaSpellerModel)this.getWidget();
        SpellerElement spellerElement = spellerButtonModel.getSpellerElement();
        String string = spellerElement.getReturnFunction();
        int[] nArray = asiaSpellerModel.get_alphabetMapping();
        if (string.toUpperCase().startsWith("FUNC_HWR")) {
            spellerButtonModel.stopInternalAnimations();
            int n = this.getAlphabetIndexForInputType(nArray, 3);
            if (string.equalsIgnoreCase("FUNC_HWR_TRADITIONAL")) {
                n = this.getAlphabetIndexForInputType(nArray, 5);
            }
            this.onAlphabetSwitch(n);
        } else if (string.equalsIgnoreCase("FUNC_SHIFT")) {
            if (this.stateMachine == null || !this.stateMachine.getState().shiftPressed()) {
                super.resolveFire(bl, spellerButtonModel);
            }
        } else if (string.equalsIgnoreCase("FUNC_ZHUYIN")) {
            spellerButtonModel.stopInternalAnimations();
            this.onAlphabetSwitch(this.getAlphabetIndexForInputType(nArray, 4));
        } else if (!string.equalsIgnoreCase("FUNC_ENTER")) {
            if (string.equalsIgnoreCase("FUNC_HIRAGANA")) {
                spellerButtonModel.stopInternalAnimations();
                this.onAlphabetSwitch(this.getAlphabetIndexForInputType(nArray, 0));
            } else if (string.equalsIgnoreCase("FUNC_ROMAJI")) {
                spellerButtonModel.stopInternalAnimations();
                this.onAlphabetSwitch(this.getAlphabetIndexForInputType(nArray, 1));
            } else if (string.equalsIgnoreCase("FUNC_JAMO")) {
                spellerButtonModel.stopInternalAnimations();
                this.onAlphabetSwitch(this.getAlphabetIndexForInputType(nArray, 6));
            } else if (string.equalsIgnoreCase("FUNC_JAMO_SEQ")) {
                spellerButtonModel.stopInternalAnimations();
                this.onAlphabetSwitch(this.getAlphabetIndexForInputType(nArray, 7));
            } else {
                super.resolveFire(bl, spellerButtonModel);
            }
        }
    }

    protected void startStateMachine() {
        if (this.stateMachine == null) {
            AsiaSpellerModel asiaSpellerModel = (AsiaSpellerModel)this.getWidget();
            switch (asiaSpellerModel.get_inputType()) {
                case 1: {
                    this.setStateMachine(new ChinaStateMachine(this, asiaSpellerModel));
                    break;
                }
                case 2: {
                    this.setStateMachine(new JapanStateMachine(this, asiaSpellerModel));
                    break;
                }
                case 3: {
                    this.setStateMachine(new KoreaStateMachine(this, asiaSpellerModel));
                    break;
                }
                default: {
                    this.warn(SpellerLogger.getLogger()).append("Unable to start internal state machine, because of undefined 'inputType' of the speller!").append(" [inputType=").append(asiaSpellerModel.get_inputType()).append("]").log();
                }
            }
        }
        if (this.stateMachine != null) {
            this.stateMachine.addOutEventListener(this.outEventDelegator);
            this.stateMachine.start();
        }
    }

    protected void stopStateMachine() {
        if (this.stateMachine != null) {
            this.stateMachine.stop();
            this.stateMachine.removeOutEventListener(this.outEventDelegator);
            this.stateMachine = null;
        }
    }

    protected void suspendStateMachine() {
        if (this.stateMachine != null) {
            this.stateMachine.suspend();
            this.stateMachine.removeOutEventListener(this.outEventDelegator);
        }
    }
}

