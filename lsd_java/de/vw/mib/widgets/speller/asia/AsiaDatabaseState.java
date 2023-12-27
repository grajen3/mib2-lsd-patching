/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia;

import de.vw.mib.util.StringBuilder;
import de.vw.mib.widgets.speller.asia.AsiaDatabaseState$UnmodifiableAsiaState;

public class AsiaDatabaseState {
    public static final int DEFAULT_STATUS;
    public static final AsiaDatabaseState$UnmodifiableAsiaState EMPTY_STATE;
    protected String[] candidates;
    protected int cursorPosition;
    protected String phrases;
    protected String predictionContext;
    protected String segmentation;
    protected String spelling;
    private int state;
    protected int states;
    private int statesReceived;
    protected int status;

    public AsiaDatabaseState() {
        this(new String[0], 0, "", "", "", "", -1, 0);
    }

    protected AsiaDatabaseState(String[] stringArray, int n, String string, String string2, String string3, String string4, int n2, int n3) {
        this.candidates = stringArray;
        this.cursorPosition = n;
        this.phrases = string;
        this.predictionContext = string2;
        this.segmentation = string3;
        this.spelling = string4;
        this.status = n2;
        this.state = 0;
        this.states = n3;
        this.statesReceived = 0;
    }

    public final String[] getCandidates() {
        return this.candidates;
    }

    public void setCandidates(String[] stringArray) {
        this.candidates = stringArray;
    }

    public final int getCursorPosition() {
        return this.cursorPosition;
    }

    public void setCursorPosition(int n) {
        this.cursorPosition = n;
    }

    public final boolean hasPhrases() {
        return this.phrases != null && this.phrases.length() > 0;
    }

    public final int getNumberOfPhrases() {
        return this.hasPhrases() ? this.phrases.length() : 0;
    }

    public final String getPhrases() {
        return this.phrases;
    }

    public void setPhrases(String string) {
        this.phrases = string;
    }

    public final String getPredictionContext() {
        return this.predictionContext;
    }

    public void setPredictionContext(String string) {
        this.predictionContext = string;
    }

    public final String getSegmentation() {
        return this.segmentation;
    }

    public void setSegmentation(String string) {
        this.segmentation = string;
    }

    public final boolean hasSelection() {
        return this.getSelectionStart() != this.getSelectionEnd();
    }

    public final int getSelectionStart() {
        return this.cursorPosition;
    }

    public final int getSelectionEnd() {
        return this.cursorPosition + this.getNumberOfSpelling();
    }

    public final boolean hasSpelling() {
        return this.spelling != null && this.spelling.length() > 0;
    }

    public final int getNumberOfSpelling() {
        return this.hasSpelling() ? this.spelling.length() : 0;
    }

    public final String getSpelling() {
        return this.spelling;
    }

    public void setSpelling(String string) {
        this.spelling = string;
    }

    public final int getState() {
        return this.state;
    }

    public void setState(int n) {
        this.state = n;
    }

    public final int getStates() {
        return this.states;
    }

    public void setStates(int n) {
        this.states = n;
    }

    public final int getStatus() {
        return this.status;
    }

    public void setStatus(int n) {
        this.status = n;
    }

    public final boolean isStateAppended(int n) {
        return (this.statesReceived & n) > 0;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName()).append("[");
        stringBuilder.append("candidates='");
        if (this.candidates != null) {
            for (int i2 = 0; i2 < this.candidates.length; ++i2) {
                stringBuilder.append(this.candidates[i2]);
                if (i2 >= this.candidates.length - 1) continue;
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("', ");
        stringBuilder.append("phrases='").append(this.phrases).append("', ");
        stringBuilder.append("segmentation='").append(this.segmentation).append("', ");
        stringBuilder.append("spelling='").append(this.spelling).append("', ");
        stringBuilder.append("cursorPosition=").append(this.cursorPosition);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void appendState(int n) {
        this.statesReceived |= n;
        if ((this.state ^ n) == 0) {
            this.state = 0;
        }
    }

    static {
        EMPTY_STATE = new AsiaDatabaseState$UnmodifiableAsiaState();
    }
}

