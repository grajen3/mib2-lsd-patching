/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia;

import de.vw.mib.properties.values.SpellerData;
import de.vw.mib.widgets.controller.AsiaSpellerController;
import de.vw.mib.widgets.models.AsiaSpellerModel;
import de.vw.mib.widgets.speller.asia.AbstractStateMachine;
import de.vw.mib.widgets.speller.asia.AsiaPhraseBuffer;
import de.vw.mib.widgets.speller.asia.HWRAreaHandler;

public class State {
    protected AsiaSpellerController stateContext;
    protected final AbstractStateMachine stateMachine;
    protected AsiaSpellerModel speller;

    protected State() {
        this(null);
    }

    protected State(AbstractStateMachine abstractStateMachine) {
        this.stateMachine = abstractStateMachine;
    }

    public boolean alphabetSwitch(int n) {
        return false;
    }

    public boolean candidateSelected(String string, int n) {
        return false;
    }

    public boolean charactersFiltered(String[] stringArray, String[] stringArray2, boolean bl) {
        return false;
    }

    public boolean cursorLeftPressed() {
        return false;
    }

    public boolean cursorPositionChanged(int n) {
        return false;
    }

    public boolean cursorRightPressed() {
        return false;
    }

    public boolean deleted() {
        return false;
    }

    public final void fireHMIEvent(String string) {
        this.stateMachine.notifyHMIEvent(string);
    }

    public final void fireIntegerEvent(String string, int n) {
        this.stateMachine.notifyIntegerEvent(string, n);
    }

    public final void fireStringEvent(String string, String string2) {
        this.stateMachine.notifyStringEvent(string, string2);
    }

    public final void fireSpellerEvent(String string, String string2, int n, int n2, int n3) {
        this.stateMachine.notifySpellerEvent(string, string2, n, n2, n3);
    }

    public void hwrAreaPressed() {
    }

    public void hwrAreaReleased() {
    }

    public boolean hwrCharactersRecognized(String[] stringArray) {
        return false;
    }

    public boolean hwrDisabled() {
        return false;
    }

    public boolean hwrEnabled() {
        return false;
    }

    public boolean hwrErrorConfirmed() {
        return false;
    }

    public boolean hwrErrorOccurred() {
        return false;
    }

    public boolean keyLongPressed() {
        return false;
    }

    public boolean keyPressed() {
        return false;
    }

    public boolean longDeleted() {
        return false;
    }

    public boolean nextValidCharacterSelected(String string, int n) {
        return false;
    }

    public boolean okPressed() {
        return false;
    }

    public void onDeInitState() {
    }

    public void onEnterState(State state) {
    }

    public void onInitState() {
    }

    public void onLeaveState(State state) {
    }

    public void onResumeState() {
    }

    public void onStayState() {
    }

    public void onSuspendState() {
    }

    public void onViewCovered() {
    }

    public void onViewUncovered() {
    }

    public boolean predictionSelected(String string, int n) {
        return false;
    }

    public boolean previewLineCollapsed() {
        return false;
    }

    public boolean previewLineExpanded() {
        return false;
    }

    public boolean recognizedCharacterSelected(String string, int n) {
        return false;
    }

    public void setHwrAreaHandler(HWRAreaHandler hWRAreaHandler) {
    }

    public void setHwrPhraseBuffer(AsiaPhraseBuffer asiaPhraseBuffer) {
    }

    public void setSpellerData(SpellerData spellerData) {
    }

    protected final void setStateId(int n) {
        if (this.stateMachine == null) {
            throw new IllegalStateException("No state machine set!");
        }
        this.stateMachine.setStateId(n);
    }

    protected final boolean isState(State state, int n) {
        if (this.stateMachine != null) {
            return this.stateMachine.isState(state, n);
        }
        throw new IllegalStateException("No state machine set!");
    }

    public final AsiaSpellerModel getWidget() {
        return this.speller;
    }

    public final void setWidget(AsiaSpellerModel asiaSpellerModel) {
        this.speller = asiaSpellerModel;
    }

    public final void setWidgetController(AsiaSpellerController asiaSpellerController) {
        this.stateContext = asiaSpellerController;
    }

    public boolean shiftPressed() {
        return false;
    }

    public boolean subSpellerClosed() {
        return false;
    }

    public boolean subSpellerOpened() {
        return false;
    }

    public String toString() {
        return "State";
    }
}

