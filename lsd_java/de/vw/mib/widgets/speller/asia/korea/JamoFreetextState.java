/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.korea;

import de.vw.mib.properties.values.SpellerData;
import de.vw.mib.widgets.log.SpellerLogger;
import de.vw.mib.widgets.speller.asia.State;
import de.vw.mib.widgets.speller.asia.korea.AbstractJamoState;
import de.vw.mib.widgets.speller.asia.korea.Jamo;
import de.vw.mib.widgets.speller.asia.korea.KoreaStateMachine;

final class JamoFreetextState
extends AbstractJamoState {
    public JamoFreetextState(KoreaStateMachine koreaStateMachine) {
        super(koreaStateMachine);
    }

    @Override
    public String toString() {
        return new StringBuffer().append("JamoFreetext[").append(super.toString()).append("]").toString();
    }

    @Override
    public void onEnterState(State state) {
        String string = this.getWidget().get_spellerData() != null ? this.getWidget().get_spellerData().getEnteredText() : "";
        this.updateSpellerButtons(string);
    }

    @Override
    public void onLeaveState(State state) {
        this.getWidget().updateSpellerButtons("", "");
    }

    @Override
    public void setSpellerData(SpellerData spellerData) {
        String string = spellerData != null ? spellerData.getEnteredText() : "";
        this.updateSpellerButtons(string);
    }

    private void updateSpellerButtons(String string) {
        String string2 = Jamo.getAvailableCompatibilityJamosAsString(string);
        this.stateContext.trace(SpellerLogger.getLogger()).append("Enabling available compatibiliy Jamos. [jamos='").append(string2).append("']").log();
        this.getWidget().updateSpellerButtons(string2, "");
    }
}

