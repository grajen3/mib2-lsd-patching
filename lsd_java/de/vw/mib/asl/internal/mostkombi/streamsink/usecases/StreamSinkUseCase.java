/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.streamsink.usecases;

import de.vw.mib.asl.internal.mostkombi.common.category.Category;
import de.vw.mib.asl.internal.mostkombi.common.category.CategoryDelegate;
import de.vw.mib.asl.internal.mostkombi.common.sequence.Sequence;
import de.vw.mib.asl.internal.mostkombi.common.sequence.SequenceDelegate;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.Target;

abstract class StreamSinkUseCase
implements Category,
Sequence,
SequenceDelegate,
Target {
    private CategoryDelegate _categoryDelegate;
    private SequenceDelegate _sequenceDelegate;

    StreamSinkUseCase() {
    }

    protected final CategoryDelegate getCategoryDelegate() {
        return this._categoryDelegate;
    }

    protected final SequenceDelegate getSequenceDelegate() {
        return this._sequenceDelegate;
    }

    @Override
    public final void setDelegate(CategoryDelegate categoryDelegate) {
        this._categoryDelegate = categoryDelegate;
    }

    @Override
    public void appendToSequence(SequenceDelegate sequenceDelegate) {
        this._sequenceDelegate = sequenceDelegate;
    }

    @Override
    public boolean isPartOfOtherSequence() {
        return this.getSequenceDelegate() != null;
    }

    @Override
    public boolean isPartOfSequence(SequenceDelegate sequenceDelegate) {
        return this.getSequenceDelegate() == sequenceDelegate;
    }

    @Override
    public final String getSequenceName() {
        String string = super.getClass().getName();
        int n = string.lastIndexOf(46);
        if (n >= 0) {
            return string.substring(n + 1);
        }
        return "";
    }

    @Override
    public final Sequence getSequence(Sequence sequence, int n) {
        SequenceDelegate sequenceDelegate = this.getSequenceDelegate();
        Sequence sequence2 = sequenceDelegate == null ? (Sequence)((Object)this.getCategoryDelegate().getCategory(this, n)) : this.getSequenceDelegate().getSequence(sequence, n);
        return sequence2;
    }

    @Override
    public int sequenceStepFailed(Sequence sequence, int n, String string) {
        int n2;
        SequenceDelegate sequenceDelegate = this.getSequenceDelegate();
        if (sequenceDelegate == null) {
            if (this.getCategoryDelegate().getLogger().isTraceEnabled(this.getCategoryDelegate().getSubClassifier())) {
                this.getCategoryDelegate().getLogger().error(this.getCategoryDelegate().getSubClassifier()).append(sequence.getSequenceName()).append(": step failed: ").append(string).append(" step-number=").append(n).log();
            }
            n2 = 0;
        } else {
            n2 = this.getSequenceDelegate().sequenceStepFailed(sequence, n, string);
        }
        return n2;
    }

    @Override
    public final GenericEvents getMainObject() {
        return null;
    }

    @Override
    public final int getTargetId() {
        return this.getIdentifier();
    }

    @Override
    public final void gotEvent(EventGeneric eventGeneric) {
    }

    @Override
    public final void setTargetId(int n) {
    }
}

