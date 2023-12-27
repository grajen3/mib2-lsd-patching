/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.streamsink.usecases;

import de.vw.mib.asl.internal.mostkombi.common.sequence.Sequence;
import de.vw.mib.asl.internal.mostkombi.common.sequence.SequenceDelegate;
import de.vw.mib.asl.internal.mostkombi.streamsink.usecases.StreamSinkUseCase;
import de.vw.mib.asl.internal.mostkombi.streamsink.usecases.SwitchToPermanentMapSequence;

public class SwitchToPermanentMap
extends StreamSinkUseCase {
    private Sequence _switchToPermanentMapSequence;

    private Sequence getSwitchToPermanentMapSequence() {
        if (this._switchToPermanentMapSequence == null) {
            SwitchToPermanentMapSequence switchToPermanentMapSequence = new SwitchToPermanentMapSequence();
            switchToPermanentMapSequence.setDelegate(this.getCategoryDelegate());
            switchToPermanentMapSequence.initialize();
            this._switchToPermanentMapSequence = switchToPermanentMapSequence;
        }
        return this._switchToPermanentMapSequence;
    }

    private void clearSwitchToPermanentMapSequence() {
        if (this._switchToPermanentMapSequence != null) {
            this._switchToPermanentMapSequence.uninitialize();
            this._switchToPermanentMapSequence.appendToSequence(null);
            this._switchToPermanentMapSequence = null;
        }
    }

    @Override
    public void initialize() {
    }

    @Override
    public void uninitialize() {
        this.clearSwitchToPermanentMapSequence();
    }

    @Override
    public int getIdentifier() {
        return 1455166976;
    }

    @Override
    public void executeSequence() {
        this.getSwitchToPermanentMapSequence().appendToSequence(this);
        this.getSwitchToPermanentMapSequence().executeSequence();
    }

    @Override
    public void sequenceDone(Sequence sequence) {
        this.clearSwitchToPermanentMapSequence();
        SequenceDelegate sequenceDelegate = this.getSequenceDelegate();
        if (sequenceDelegate != null) {
            sequenceDelegate.sequenceDone(this);
        }
    }
}

