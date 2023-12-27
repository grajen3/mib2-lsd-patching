/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.common.sequence;

import de.vw.mib.asl.internal.mostkombi.common.sequence.SequenceDelegate;

public interface Sequence {
    default public void initialize() {
    }

    default public void uninitialize() {
    }

    default public void appendToSequence(SequenceDelegate sequenceDelegate) {
    }

    default public boolean isPartOfOtherSequence() {
    }

    default public boolean isPartOfSequence(SequenceDelegate sequenceDelegate) {
    }

    default public void executeSequence() {
    }

    default public String getSequenceName() {
    }

    default public int getIdentifier() {
    }
}

