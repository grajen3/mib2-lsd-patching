/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.japan;

import de.vw.mib.properties.values.SpellerData;
import de.vw.mib.util.StringBuilder;
import de.vw.mib.widgets.speller.asia.State;
import de.vw.mib.widgets.speller.asia.japan.AbstractCharacterBufferState;
import de.vw.mib.widgets.speller.asia.japan.Hiragana;
import de.vw.mib.widgets.speller.asia.japan.JapanStateMachine;
import de.vw.mib.widgets.speller.asia.japan.RomajiMatchConverter;
import java.util.Arrays;

final class RomajiMatchState
extends AbstractCharacterBufferState {
    private static final int CONVERSION_RESULT_SIZE;
    private String availableHiraganas;
    private final String[] conversionResult = new String[2];
    private final StringBuilder enteredTextBuffer = new StringBuilder();

    public RomajiMatchState(JapanStateMachine japanStateMachine) {
        super(japanStateMachine);
    }

    private String getNextValidRomajis() {
        this.convertToRomaji(this.availableHiraganas);
        return this.conversionResult[1];
    }

    private String convertToRomaji(String string) {
        this.resetConversionResult();
        if (Hiragana.isHiraganas(string)) {
            RomajiMatchConverter.convertHiraganas(string, this.getCharacters(), this.conversionResult);
            String string2 = this.conversionResult[0];
            if (string2 != null && string2.length() > 0) {
                return Hiragana.isHiragana(string2.charAt(0)) ? string2 : null;
            }
        }
        return null;
    }

    @Override
    public boolean deleted() {
        if (this.deleteLastCharacter()) {
            this.speller.updateInputField(this.getCharacters(this.enteredTextBuffer), this.getCharacters(), this.getNumberOfCharacters(this.enteredTextBuffer) + this.getNumberOfCharacters());
            this.speller.updateSpellerButtons(this.getNextValidRomajis(), "");
            return true;
        }
        this.deleteLastCharacter(this.enteredTextBuffer);
        return false;
    }

    @Override
    public boolean keyPressed() {
        this.addCharacter(this.stateContext.getLastEnteredCharacter());
        String string = this.convertToRomaji(this.availableHiraganas);
        if (string != null) {
            this.clearCharacters();
            this.clearCharacters(this.enteredTextBuffer);
            this.availableHiraganas = null;
            this.fireSpellerEvent("keyPressed", string, 0, 0, 0);
        } else {
            this.speller.updateInputField(this.getCharacters(this.enteredTextBuffer), this.getCharacters(), this.getNumberOfCharacters(this.enteredTextBuffer) + this.getNumberOfCharacters());
            this.speller.updateSpellerButtons(this.getNextValidRomajis(), "");
        }
        return true;
    }

    @Override
    public void onEnterState(State state) {
        SpellerData spellerData = this.speller.get_spellerData();
        this.setSpellerData(spellerData);
    }

    @Override
    public void onLeaveState(State state) {
        this.speller.updateInputField(this.getCharacters(this.enteredTextBuffer), "", this.getNumberOfCharacters(this.enteredTextBuffer));
        this.speller.updateSpellerButtons(this.availableHiraganas, "");
        this.availableHiraganas = null;
        this.clearCharacters();
        this.clearCharacters(this.enteredTextBuffer);
    }

    private void resetConversionResult() {
        Arrays.fill(this.conversionResult, "");
    }

    @Override
    public void setSpellerData(SpellerData spellerData) {
        this.availableHiraganas = this.filterHiragana(spellerData.getAvailableCharacters());
        this.setCharacters(this.enteredTextBuffer, spellerData.getEnteredText());
        this.speller.updateInputField(this.getCharacters(this.enteredTextBuffer), this.getCharacters(), this.getNumberOfCharacters(this.enteredTextBuffer) + this.getNumberOfCharacters());
        this.speller.updateSpellerButtons(this.getNextValidRomajis(), "");
    }

    @Override
    public String toString() {
        return "Romaji (Match)";
    }

    private String filterHiragana(String string) {
        if (string == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(string.length());
        for (int i2 = 0; i2 < string.length(); ++i2) {
            char c2 = string.charAt(i2);
            if (!Hiragana.isHiragana(c2)) continue;
            stringBuffer.append(c2);
        }
        return stringBuffer.toString();
    }
}

