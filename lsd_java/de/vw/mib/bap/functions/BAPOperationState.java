/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.functions;

public interface BAPOperationState {
    public static final int STATE_NORMAL_OPERATION;
    public static final int STATE_OFF_STAND_BY;
    public static final int STATE_INITIALIZING;
    public static final int STATE_DEFECT;

    default public int getState() {
    }
}

