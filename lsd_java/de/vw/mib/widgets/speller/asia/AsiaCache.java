/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia;

import de.vw.mib.util.StringBuilder;
import de.vw.mib.widgets.speller.asia.AsiaSymbolBuffer;

public final class AsiaCache {
    private static final boolean CACHING_ENABLED = System.getProperty("de.vw.mib.widgets.speller.xt9DisableCaching") == null;
    public static final byte STATE_INDEX__CLEAR;
    public static final byte STATE_INDEX__SPELLING;
    public static final byte STATE_INDEX__CANDIDATE_COUNT;
    public static final byte STATE_INDEX__CANDIDATES;
    public static final byte STATE_INDEX__PREDICTION_CONTEXT;
    public static final byte STATE_MASK__CLEAR;
    public static final byte STATE_MASK__SPELLING;
    public static final byte STATE_MASK__CANDIDATE_COUNT;
    public static final byte STATE_MASK__CANDIDATES;
    public static final byte STATE_MASK__PREDICTION_CONTEXT;
    public static final byte STATE_MASK__ALL;
    private String[] candidates;
    private int candidatesCount;
    private byte dirtyStates;
    private String predictionContext;
    private final AsiaSymbolBuffer symbolBuffer;
    private final StringBuilder untreatedSymbolBuffer;

    public AsiaCache(AsiaSymbolBuffer asiaSymbolBuffer) {
        this.symbolBuffer = asiaSymbolBuffer;
        this.untreatedSymbolBuffer = new StringBuilder();
        this.clearCache();
    }

    public void addSymbols(String string) {
        this.untreatedSymbolBuffer.append(string);
    }

    public void clearSymbols() {
        this.untreatedSymbolBuffer.clear();
    }

    public String getSymbols() {
        return this.untreatedSymbolBuffer.toString();
    }

    public boolean isCachingEnabled() {
        return CACHING_ENABLED;
    }

    public String[] getCandidates() {
        return this.candidates;
    }

    public void setCandidates(String[] stringArray) {
        this.candidates = stringArray;
        this.markStateAsClean((byte)3);
    }

    public int getCandidatesCount() {
        return this.candidatesCount;
    }

    public void setCandidatesCount(int n) {
        this.candidatesCount = n;
        this.markStateAsClean((byte)2);
    }

    public String getPredictionContext() {
        return this.predictionContext;
    }

    public void setPreditionContext(String string) {
        this.predictionContext = string;
        this.markStateAsClean((byte)4);
    }

    public String getSpelling() {
        return this.symbolBuffer.getSymbols();
    }

    public void setSpelling(String string) {
        this.symbolBuffer.setSymbols(string);
        this.markStateAsClean((byte)1);
        this.untreatedSymbolBuffer.clear();
    }

    public void clearCache() {
        this.setSpelling("");
        this.setCandidatesCount(0);
        this.setCandidates(new String[0]);
        this.setPreditionContext("");
        this.clearSymbols();
        this.markMultipleStatesAsDirty((byte)31);
        this.markStateAsClean((byte)0);
    }

    public boolean isStateDirty(byte by) {
        return (this.dirtyStates & 1 << by) != 0;
    }

    public void markMultipleStatesAsClean(byte by) {
        this.dirtyStates = (byte)(this.dirtyStates & ~by);
    }

    public void markMultipleStatesAsDirty(byte by) {
        this.dirtyStates = (byte)(this.dirtyStates | by);
    }

    public void markStateAsClean(byte by) {
        this.dirtyStates = (byte)(this.dirtyStates & ~(1 << by));
    }

    public void markStateAsDirty(byte by) {
        this.dirtyStates = (byte)(this.dirtyStates | 1 << by);
    }
}

