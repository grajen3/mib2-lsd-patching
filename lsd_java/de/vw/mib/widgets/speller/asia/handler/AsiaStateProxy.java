/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.handler;

import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.widgets.speller.asia.AsiaDatabase;
import de.vw.mib.widgets.speller.asia.handler.AbstractAsiaStateHandler;

public interface AsiaStateProxy {
    public static final int STATE_CANDIDATES;
    public static final int STATE_SPELLING;
    public static final int STATE_PHRASES;
    public static final int STATE_CURSORPOSITION;
    public static final int STATE_BUILD;
    public static final int STATE_SELECT;
    public static final int STATE_SEGMENTATION;
    public static final int STATE_USER_DEFINED_ENTRY;
    public static final int STATE_CLEAR;
    public static final int STATE_INIT;
    public static final int STATE_ADDSYMBOLS;
    public static final int STATE_PREDICTIONCONTEXT;
    public static final int STATE_SETPHRASES;
    public static final int STATE_NONE;
    public static final int STATE_ALL;

    default public AsiaDatabase getAsia() {
    }

    default public void getState(int n, AbstractAsiaStateHandler abstractAsiaStateHandler) {
    }

    default public void getState(int n, IntObjectMap intObjectMap, AbstractAsiaStateHandler abstractAsiaStateHandler) {
    }

    default public void deregisterStateHandler(AbstractAsiaStateHandler abstractAsiaStateHandler) {
    }

    default public void registerStateHandler(AbstractAsiaStateHandler abstractAsiaStateHandler) {
    }
}

