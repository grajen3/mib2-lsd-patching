/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.streamsink.usecases;

import de.vw.mib.asl.internal.mostkombi.common.category.Category;
import de.vw.mib.asl.internal.mostkombi.common.category.CategoryDelegate;
import de.vw.mib.asl.internal.mostkombi.common.sequence.Sequence;
import de.vw.mib.asl.internal.mostkombi.common.sequence.SequenceDelegate;
import de.vw.mib.asl.internal.mostkombi.common.timer.Timer;
import de.vw.mib.asl.internal.mostkombi.common.timer.TimerNotifier;
import de.vw.mib.asl.internal.mostkombi.common.timer.TimerObj;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.Target;

abstract class StreamSinkSequence
implements Category,
Sequence,
SequenceDelegate,
Target,
TimerNotifier {
    private CategoryDelegate _categoryDelegate;
    private SequenceDelegate _sequenceDelegate;
    private int _currentStep = -1;
    private Timer _timer;
    private static int TIMER_WAIT_FOR_STEP_TO_EXECUTE = 15000;

    StreamSinkSequence() {
    }

    protected final CategoryDelegate getCategoryDelegate() {
        return this._categoryDelegate;
    }

    protected final SequenceDelegate getSequenceDelegate() {
        return this._sequenceDelegate;
    }

    private Timer getTimer() {
        if (this._timer == null) {
            this._timer = new TimerObj(this, TIMER_WAIT_FOR_STEP_TO_EXECUTE);
        }
        return this._timer;
    }

    @Override
    public void timerFired(Timer timer) {
        SequenceDelegate sequenceDelegate = this.getSequenceDelegate();
        if (sequenceDelegate != null && sequenceDelegate.sequenceStepFailed(this, this.getCurrentStep(), this.getStepDescription(this.getCurrentStep())) != 2) {
            this.stepDone();
        } else if (sequenceDelegate == null) {
            this.getCategoryDelegate().getLogger().error(this.getCategoryDelegate().getSubClassifier()).append("Timer fired in class ").append(super.getClass().getName()).append(" although delegate is not set").log();
        }
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
        return this.getSequenceDelegate().getSequence(sequence, n);
    }

    @Override
    public int sequenceStepFailed(Sequence sequence, int n, String string) {
        return this.getSequenceDelegate().sequenceStepFailed(sequence, n, string);
    }

    protected int getCurrentStep() {
        return this._currentStep;
    }

    protected void stepDone() {
        ++this._currentStep;
        if (this.executeNextStep()) {
            this.getTimer().retrigger(null);
        } else {
            this.getTimer().stop();
        }
    }

    protected void sequenceAbort() {
        this.getTimer().stop();
        if (this.getCategoryDelegate().getLogger().isTraceEnabled(this.getCategoryDelegate().getSubClassifier())) {
            this.getCategoryDelegate().getLogger().trace(this.getCategoryDelegate().getSubClassifier()).append("Sequence aborted: ").append(this.getSequenceName()).log();
        }
    }

    protected void sequenceFinished() {
        this.getTimer().stop();
        this.getSequenceDelegate().sequenceDone(this);
    }

    protected abstract String getStepDescription(int n) {
    }

    protected abstract boolean executeNextStep() {
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

