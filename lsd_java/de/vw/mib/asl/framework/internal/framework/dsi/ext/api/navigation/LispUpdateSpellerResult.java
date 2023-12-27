/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.dsi.ext.api.navigation;

public final class LispUpdateSpellerResult {
    private final String lispCurrentInput;
    private final int lispCurrentSelectionCriterion;
    private final boolean lispIsFullMatch;
    private final boolean lispIsUndoAvailable;
    private final String lispValidCharacters;
    private final int lispMultiCriteria_Criterion1;
    private final int lispMultiCriteria_Criterion2;
    private final boolean lispMultiCriteria_IsActive;
    private final boolean lispMultiCriteria_IsAmbiguous;
    private final int lispInputFormat;
    private final long returnCode;

    public LispUpdateSpellerResult(Object[] objectArray) {
        this.lispCurrentInput = (String)objectArray[0];
        this.lispCurrentSelectionCriterion = (Integer)objectArray[1];
        this.lispIsFullMatch = (Boolean)objectArray[2];
        this.lispIsUndoAvailable = (Boolean)objectArray[3];
        this.lispValidCharacters = (String)objectArray[4];
        this.lispMultiCriteria_Criterion1 = (Integer)objectArray[5];
        this.lispMultiCriteria_Criterion2 = (Integer)objectArray[6];
        this.lispMultiCriteria_IsActive = (Boolean)objectArray[7];
        this.lispMultiCriteria_IsAmbiguous = (Boolean)objectArray[8];
        this.lispInputFormat = (Integer)objectArray[9];
        this.returnCode = (Long)objectArray[10];
    }

    public String getLispCurrentInput() {
        return this.lispCurrentInput;
    }

    public int getLispCurrentSelectionCriterion() {
        return this.lispCurrentSelectionCriterion;
    }

    public boolean isLispIsFullMatch() {
        return this.lispIsFullMatch;
    }

    public boolean isLispIsUndoAvailable() {
        return this.lispIsUndoAvailable;
    }

    public String getLispValidCharacters() {
        return this.lispValidCharacters;
    }

    public int getLispMultiCriteria_Criterion1() {
        return this.lispMultiCriteria_Criterion1;
    }

    public int getLispMultiCriteria_Criterion2() {
        return this.lispMultiCriteria_Criterion2;
    }

    public boolean isLispMultiCriteria_IsActive() {
        return this.lispMultiCriteria_IsActive;
    }

    public boolean isLispMultiCriteria_IsAmbiguous() {
        return this.lispMultiCriteria_IsAmbiguous;
    }

    public int getLispInputFormat() {
        return this.lispInputFormat;
    }

    public long getReturnCode() {
        return this.returnCode;
    }
}

