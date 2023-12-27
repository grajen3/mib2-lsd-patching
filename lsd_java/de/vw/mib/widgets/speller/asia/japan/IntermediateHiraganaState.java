/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.japan;

import de.vw.mib.properties.values.SpellerData;
import de.vw.mib.widgets.speller.asia.State;
import de.vw.mib.widgets.speller.asia.japan.Hiragana;
import de.vw.mib.widgets.speller.asia.japan.HiraganaFreeTextConverter;
import de.vw.mib.widgets.speller.asia.japan.JapanStateMachine;
import de.vw.mib.widgets.speller.asia.japan.Katakana;
import de.vw.mib.widgets.speller.asia.japan.LatinState;

final class IntermediateHiraganaState
extends LatinState {
    public IntermediateHiraganaState(JapanStateMachine japanStateMachine) {
        super(japanStateMachine);
    }

    @Override
    public void setSpellerData(SpellerData spellerData) {
        this.speller.updateSpellerButtons("", HiraganaFreeTextConverter.PRONUNCIATION_ELEMENTS);
    }

    @Override
    public boolean keyPressed() {
        char c2;
        String string = this.stateContext.getLastEnteredCharacter();
        if (string != null && string.length() > 0 && (Hiragana.isHiragana(c2 = string.charAt(0)) || Katakana.isKatakana(c2))) {
            this.setStateId(0);
            this.stateContext.fire_keyPressed();
            return true;
        }
        return false;
    }

    @Override
    public void onEnterState(State state) {
        super.onEnterState(state);
        this.speller.updateSpellerButtons("", HiraganaFreeTextConverter.PRONUNCIATION_ELEMENTS);
    }

    @Override
    public String toString() {
        return "Intermediate Hiragana";
    }
}

