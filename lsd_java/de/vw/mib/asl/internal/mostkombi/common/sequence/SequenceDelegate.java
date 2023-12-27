/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.common.sequence;

import de.vw.mib.asl.internal.mostkombi.common.sequence.Sequence;

public interface SequenceDelegate {
    public static final int SEQUENCE_ACTION_CLIENT_DECIDE;
    public static final int SEQUENCE_ACTION_CONTINUE_SEQUENCE;
    public static final int SEQUENCE_ACTION_STOP_SEQUENCE;

    default public Sequence getSequence(Sequence sequence, int n) {
    }

    default public void sequenceDone(Sequence sequence) {
    }

    default public int sequenceStepFailed(Sequence sequence, int n, String string) {
    }
}

