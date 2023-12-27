/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia;

import de.vw.mib.widgets.controller.TouchAreaController;
import de.vw.mib.widgets.log.SpellerLogger;
import de.vw.mib.widgets.models.TouchAreaModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.speller.asia.AbstractStateMachine;
import de.vw.mib.widgets.speller.asia.AsiaPhraseBuffer;
import de.vw.mib.widgets.speller.asia.HWRAreaHandler;
import de.vw.mib.widgets.speller.asia.HWRAwareState;
import de.vw.mib.widgets.speller.asia.State;
import de.vw.mib.widgets.speller.hwr.HWRWrapper;

public abstract class AbstractHWRCommonState
extends State
implements HWRAwareState {
    private HWRAreaHandler hwrAreaHandler;
    protected AsiaPhraseBuffer hwrPhraseBuffer;

    protected AbstractHWRCommonState(AbstractStateMachine abstractStateMachine) {
        super(abstractStateMachine);
    }

    @Override
    public String toString() {
        return "HWRCommon";
    }

    protected final void confirmRecommendedRecognition(String string, int n, int n2, int n3) {
        String string2 = string.substring(n2, n3);
        n = Math.max(0, n - string2.length());
        this.hwrPhraseBuffer.addPhrase(string2);
        this.fireSpellerEvent("keyPressed", string2, n, 0, 0);
        this.stateMachine.hwrConfirmationExpected = false;
    }

    @Override
    public boolean cursorPositionChanged(int n) {
        return true;
    }

    @Override
    public boolean deleted() {
        HWRWrapper.getHWR(this.speller).restartHwrEngine();
        if (!this.speller.isSelectionDefined()) {
            this.hwrPhraseBuffer.removePhrase();
        }
        this.stateMachine.hwrConfirmationExpected = false;
        int n = this.speller.getCursorPosition();
        int n2 = this.speller.getSelectionStart();
        int n3 = this.speller.getSelectionEnd();
        this.fireSpellerEvent("deleted", "", n, n2, n3);
        return true;
    }

    protected final void enableHwr() {
        HWRWrapper.getHWR(this.speller).restartHwrEngine();
        this.enableHwrArea(true);
        if (this.stateMachine.hwrConfirmationExpected && this.speller.isSelectionDefined()) {
            String string = this.speller.getEnteredText();
            int n = this.speller.getCursorPosition();
            int n2 = this.speller.getSelectionStart();
            int n3 = this.speller.getSelectionEnd();
            this.confirmRecommendedRecognition(string, n, n2, n3);
        }
    }

    protected final void enableHwrArea(boolean bl) {
        TouchAreaModel touchAreaModel = this.speller.get_hwrAreaRef();
        if (touchAreaModel != null && touchAreaModel.is_enabled() != bl) {
            TouchAreaController touchAreaController = (TouchAreaController)touchAreaModel.getController();
            if (touchAreaController != null && this.hwrAreaHandler != null) {
                if (bl) {
                    touchAreaController.removeOutEventListener(this.hwrAreaHandler);
                    touchAreaController.addOutEventListener(this.hwrAreaHandler);
                } else {
                    touchAreaController.removeOutEventListener(this.hwrAreaHandler);
                }
            }
            touchAreaModel.set_enabled(bl);
        }
    }

    protected final String determineSuitableRecognizedChar(String string, String[] stringArray) {
        String string2 = null;
        if (stringArray != null) {
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                String string3 = stringArray[i2];
                if (string3 == null || string3.length() == 0 || this.speller.willCharMaxExceed(string, string3)) continue;
                string2 = string3;
                break;
            }
        }
        return string2;
    }

    protected final void disableHwr() {
        HWRWrapper.getHWR(this.speller).suspendHwrEngine();
        this.enableHwrArea(false);
    }

    @Override
    public void hwrAreaPressed() {
        this.stateContext.trace(SpellerLogger.getLogger()).append("hwrAreaPressed").log();
        this.showWidgetRefs(this.speller.get_hwrInfoTextRefs(), false);
        if (this.stateMachine.hwrConfirmationExpected && this.speller.isSelectionDefined()) {
            this.speller.setRecognizedCharacters(null);
            int n = this.speller.getCursorPosition();
            this.fireSpellerEvent("deleted", "", n, 0, 0);
        }
    }

    @Override
    public void hwrAreaReleased() {
        this.stateContext.trace(SpellerLogger.getLogger()).append("hwrAreaReleased").log();
    }

    @Override
    public boolean hwrCharactersRecognized(String[] stringArray) {
        if (stringArray != null && stringArray.length > 0) {
            String string;
            this.speller.setRecognizedCharacters(stringArray);
            if (!this.speller.isCharMaxReached() && (string = this.determineSuitableRecognizedChar(this.hwrPhraseBuffer.getPhrases(), stringArray)) != null) {
                int n;
                int n2 = n = this.speller.isSelectionDefined() ? this.speller.getSelectionStart() : this.speller.getCursorPosition();
                int n3 = n + string.length();
                this.fireSpellerEvent("keyPressed", string, n, n2, n3);
                this.hwrPhraseBuffer.setCursorPosition(n);
                this.stateMachine.hwrConfirmationExpected = true;
            }
        } else {
            this.stateContext.fire_hwrErrorOccurred();
        }
        return true;
    }

    @Override
    public boolean hwrDisabled() {
        this.enableHwrArea(false);
        this.fireHMIEvent("hwrDisabled");
        return true;
    }

    @Override
    public boolean hwrEnabled() {
        this.enableHwrArea(true);
        this.fireHMIEvent("hwrEnabled");
        return true;
    }

    @Override
    public boolean hwrErrorConfirmed() {
        if (this.stateMachine.hwrErrorOccurred) {
            HWRWrapper.getHWR(this.speller).restartHwrEngine();
            this.enableHwrArea(true);
            this.stateMachine.hwrErrorConfirmed = true;
            this.stateMachine.hwrErrorOccurred = false;
        }
        return true;
    }

    @Override
    public boolean hwrErrorOccurred() {
        this.stateMachine.hwrErrorOccurred = true;
        this.stateMachine.hwrErrorConfirmed = false;
        HWRWrapper.getHWR(this.speller).suspendHwrEngine();
        this.enableHwrArea(false);
        this.fireHMIEvent("hwrErrorOccurred");
        return true;
    }

    @Override
    public boolean keyPressed() {
        boolean bl = this.speller.isCharMaxReached();
        boolean bl2 = this.speller.isSelectionDefined();
        int n = this.speller.getCursorPosition();
        if (!bl || bl2 && bl) {
            if (bl2) {
                n = this.speller.getSelectionStart();
                HWRWrapper.getHWR(this.speller).restartHwrEngine();
                this.speller.setRecognizedCharacters(null);
            }
            String string = this.stateContext.getLastEnteredCharacter();
            this.fireSpellerEvent("keyPressed", string, n, 0, 0);
            this.hwrPhraseBuffer.addPhrase(string);
        }
        return true;
    }

    @Override
    public boolean nextValidCharacterSelected(String string, int n) {
        boolean bl = this.speller.isCharMaxReached();
        boolean bl2 = this.speller.willCharMaxExceed(this.hwrPhraseBuffer.getPhrases(), string);
        if (!bl2 && (!this.speller.isCharMaxReached() || this.speller.isSelectionDefined() && bl)) {
            this.hwrPhraseBuffer.addPhrase(string);
            int n2 = this.speller.getCursorPosition();
            int n3 = this.speller.getSelectionStart();
            int n4 = this.speller.getSelectionEnd();
            this.fireSpellerEvent("keyPressed", string, n2, n3, n4);
        }
        return true;
    }

    @Override
    public void onDeInitState() {
        this.hwrAreaHandler = null;
        this.hwrPhraseBuffer = null;
        this.stateMachine.hwrConfirmationExpected = false;
        this.stateMachine.hwrErrorConfirmed = false;
        this.stateMachine.hwrErrorOccurred = false;
        super.onDeInitState();
    }

    @Override
    public void onEnterState(State state) {
        super.onEnterState(state);
        if (!(state instanceof HWRAwareState)) {
            this.showWidgetRefs(this.speller.get_hwrInfoTextRefs(), true);
            this.enableHwrArea(false);
            HWRWrapper.getHWR(this.speller).initHwrEngine().startHwrEngine();
            if (state == null) {
                String string = this.speller.getEnteredText();
                int n = this.speller.getCursorPosition();
                if (string != null) {
                    if (this.speller.isSelectionDefined()) {
                        n = Math.min(this.speller.getSelectionStart(), string.length());
                        String string2 = string = n > 0 ? string.substring(0, n) : "";
                    }
                    if (string.length() > 0) {
                        this.hwrPhraseBuffer.addPhrase(string);
                        this.hwrPhraseBuffer.setCursorPosition(n);
                    }
                }
            }
        }
    }

    @Override
    public void onInitState() {
        super.onInitState();
        this.stateMachine.hwrConfirmationExpected = false;
        this.stateMachine.hwrErrorConfirmed = false;
        this.stateMachine.hwrErrorOccurred = false;
    }

    @Override
    public void onLeaveState(State state) {
        if (!(state instanceof HWRAwareState)) {
            this.stateMachine.hwrConfirmationExpected = false;
            this.stateMachine.hwrErrorConfirmed = false;
            this.stateMachine.hwrErrorOccurred = false;
            this.speller.setRecognizedCharacters(null);
            HWRWrapper.getHWR(this.speller).stopHwrEngine().deInitHwrEngine();
            this.hwrDisabled();
        }
        super.onLeaveState(state);
    }

    @Override
    public boolean previewLineCollapsed() {
        this.enableHwr();
        return true;
    }

    @Override
    public boolean previewLineExpanded() {
        this.disableHwr();
        return true;
    }

    @Override
    public void onResumeState() {
        super.onResumeState();
        HWRWrapper.getHWR(this.speller).initHwrEngine().startHwrEngine();
    }

    @Override
    public void onSuspendState() {
        super.onSuspendState();
        HWRWrapper.getHWR(this.speller).stopHwrEngine().deInitHwrEngine();
    }

    @Override
    public void onViewCovered() {
        if (!this.stateMachine.hwrErrorOccurred) {
            HWRWrapper.getHWR(this.speller).suspendHwrEngine();
            this.enableHwrArea(false);
        }
    }

    @Override
    public void onViewUncovered() {
        if (!this.stateMachine.hwrErrorConfirmed) {
            HWRWrapper.getHWR(this.speller).restartHwrEngine();
            this.enableHwrArea(true);
            if (this.stateMachine.hwrConfirmationExpected && this.speller.isSelectionDefined()) {
                String string = this.speller.getEnteredText();
                int n = this.speller.getCursorPosition();
                int n2 = this.speller.getSelectionStart();
                int n3 = this.speller.getSelectionEnd();
                this.confirmRecommendedRecognition(string, n, n2, n3);
            }
        } else {
            this.stateMachine.hwrErrorConfirmed = false;
        }
    }

    @Override
    public boolean recognizedCharacterSelected(String string, int n) {
        boolean bl = this.speller.isCharMaxReached();
        boolean bl2 = this.speller.willCharMaxExceed(this.hwrPhraseBuffer.getPhrases(), string);
        if (!bl2 && (!bl || this.speller.isSelectionDefined() && bl)) {
            HWRWrapper.getHWR(this.speller).restartHwrEngine();
            this.hwrPhraseBuffer.addPhrase(string);
            this.stateMachine.hwrConfirmationExpected = false;
        }
        return true;
    }

    protected final void showWidgetRefs(WidgetModel[] widgetModelArray, boolean bl) {
        if (widgetModelArray != null) {
            for (int i2 = widgetModelArray.length - 1; i2 >= 0; --i2) {
                if (widgetModelArray[i2] == null) continue;
                widgetModelArray[i2].set_visible(bl);
            }
        }
    }

    @Override
    public final void setHwrAreaHandler(HWRAreaHandler hWRAreaHandler) {
        this.hwrAreaHandler = hWRAreaHandler;
    }

    @Override
    public final void setHwrPhraseBuffer(AsiaPhraseBuffer asiaPhraseBuffer) {
        this.hwrPhraseBuffer = asiaPhraseBuffer;
    }

    @Override
    public boolean subSpellerClosed() {
        this.speller.setRecognizedCharacters(null);
        this.enableHwr();
        return true;
    }

    @Override
    public boolean subSpellerOpened() {
        this.disableHwr();
        return true;
    }
}

