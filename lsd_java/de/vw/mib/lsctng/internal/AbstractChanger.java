/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.lsctng.internal;

import de.vw.mib.collections.copyonwrite.CowList;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.lsctng.internal.AbstractMediator;
import de.vw.mib.lsctng.internal.CheckAllChangesReady;
import de.vw.mib.lsctng.internal.ServiceManager;
import de.vw.mib.lsctng.internal.StrategyOverException;
import de.vw.mib.lsctng.internal.TimeoutException;
import de.vw.mib.util.StringBuilder;

abstract class AbstractChanger
implements CheckAllChangesReady {
    private static final boolean TIMED_OUT_TOTAL;
    private static final boolean NOT_TIMED_OUT_TOTAL;
    protected static final boolean CONSISTENT_STATE;
    protected static final boolean INCONSISTENT_STATE;
    private final CowList mediators;
    private long timeoutOneElement;
    private long timeoutTotal;
    private boolean hasAllExpectedAnswers;
    private static int nextId;
    protected static final int SUB_CLASSIFIER;
    protected static final Logger LOG;
    private long startTimeOfChange;
    private long startTimeChangeObject;
    private CowList currentMediators;
    private int allChangesReadyCount;
    static /* synthetic */ Class class$de$vw$mib$lsctng$internal$AbstractChanger;

    AbstractChanger(CowList cowList, long l, long l2) {
        this.mediators = this.getRelevantMediators(cowList);
        this.timeoutOneElement = l;
        this.timeoutTotal = l2;
        this.currentMediators = CowList.EMPTY;
        if (LOG.isTraceEnabled(1024)) {
            LOG.trace(1024).append("new changer: ").append(super.getClass().getName()).log();
        }
    }

    private CowList getRelevantMediators(CowList cowList) {
        return this.getRelevantMediators(cowList, CowList.EMPTY);
    }

    private CowList getRelevantMediators(CowList cowList, CowList cowList2) {
        if (cowList != CowList.EMPTY) {
            cowList2 = this.getRelevantMediators(cowList.tail(), cowList2);
            AbstractMediator abstractMediator = (AbstractMediator)cowList.head();
            if (this.isRelevantMediator(abstractMediator)) {
                cowList2 = cowList2.add(abstractMediator);
            }
        }
        return cowList2;
    }

    abstract boolean isRelevantMediator(AbstractMediator abstractMediator) {
    }

    void setTimeoutOneElement(long l) {
        if (LOG.isTraceEnabled(1024)) {
            LOG.trace(1024).append("call: ").append(super.getClass().getName()).append(".setTimeoutOneElement(long)").log();
        }
        this.timeoutOneElement = l;
    }

    void setTimeoutTotal(long l) {
        if (LOG.isTraceEnabled(1024)) {
            LOG.trace(1024).append("call: ").append(super.getClass().getName()).append(".setTimeoutTotal(long)").log();
        }
        this.timeoutTotal = l;
    }

    void change() {
        if (LOG.isTraceEnabled(1024)) {
            LOG.trace(1024).append("call: ").append(super.getClass().getName()).append(".change()").log();
        }
        if (this.mediators.size() < 1) {
            LOG.warn(1024, "No mediator to change. This should not happen. Do nothing.");
            return;
        }
        this.changeUntilAllOk();
    }

    private synchronized void changeUntilAllOk() {
        if (LOG.isTraceEnabled(1024)) {
            LOG.trace(1024).append("call: ").append(super.getClass().getName()).append(".changeUntilAllOk()").log();
        }
        int n = 0;
        this.currentMediators = this.mediators;
        this.startTimeOfChange = ServiceManager.fw4u.system.currentTimeMillis();
        while (true) {
            if (n >= this.getStrategyLength()) {
                this.checkStateAndFailIfNecessary(this.createStrategyOverException());
                break;
            }
            this.hasAllExpectedAnswers = false;
            this.startTimeChangeObject = ServiceManager.fw4u.system.currentTimeMillis();
            this.changeToCurrentIdx(this.currentMediators, n);
            boolean bl = false;
            if (!this.hasAllExpectedAnswers) {
                long l = this.calcTimeout(this.startTimeOfChange, this.startTimeChangeObject);
                bl = this.waitForAnswers(l);
            }
            if (bl) {
                this.checkStateAndFailIfNecessary(this.createTimeoutException());
                break;
            }
            this.currentMediators = this.computeMediatorsForNextChange(this.mediators, n);
            if (this.currentMediators.size() < 1) break;
            ++n;
        }
        this.cleanUp(this.mediators);
    }

    void cleanUp(CowList cowList) {
    }

    private RuntimeException createStrategyOverException() {
        return new StrategyOverException(super.getClass().getName());
    }

    private RuntimeException createTimeoutException() {
        return new TimeoutException(super.getClass().getName());
    }

    private void checkStateAndFailIfNecessary(RuntimeException runtimeException) {
        String string = runtimeException.getMessage();
        LOG.warn(1024).append(super.getClass().getName()).append(": ").append(string).append(". Checking for valid state...").log();
        if (this.tryToReachValidState(this.mediators)) {
            LOG.info(1024).append("LSC ").append(string).append(", but state is valid.").log();
        } else {
            LOG.fatal(1024).append("LSC failed ultimately!").attachThrowable(runtimeException).log();
        }
    }

    protected abstract CowList computeMediatorsForNextChange(CowList cowList, int n) {
    }

    private boolean waitForAnswers(long l) {
        if (LOG.isTraceEnabled(1024)) {
            LOG.trace(1024).append("call: ").append(super.getClass().getName()).append(".waitForAnswers()").log();
        }
        long l2 = ServiceManager.fw4u.system.currentTimeMillis();
        if (l > 0L) {
            if (LOG.isTraceEnabled(1024)) {
                LOG.trace(1024).append("waiting maximal ").append(l).append(" ms").log();
            }
            try {
                super.wait(l);
            }
            catch (InterruptedException interruptedException) {
                LOG.error(1024).append("waiting interrupted").attachThrowable(interruptedException).log();
            }
        }
        long l3 = ServiceManager.fw4u.system.currentTimeMillis();
        if (LOG.isTraceEnabled(1024)) {
            LOG.trace(1024).append("waiting done after ").append(l3 - l2).append(" ms").log();
        }
        if (l3 - l2 >= l) {
            LOG.error(1024).append("Operation timed out after ").append(l3 - l2).append(" ms").log();
            return l <= 0L;
        }
        return false;
    }

    protected abstract boolean tryToReachValidState(CowList cowList) {
    }

    private long calcTimeout(long l, long l2) {
        if (LOG.isTraceEnabled(1024)) {
            LOG.trace(1024).append("call: ").append(super.getClass().getName()).append(".calcTimeout(").append(l).append(", ").append(l2).append(")").log();
        }
        long l3 = ServiceManager.fw4u.system.currentTimeMillis();
        long l4 = Math.max(1L, this.timeoutOneElement - (l3 - l2));
        long l5 = this.timeoutTotal - (l3 - l);
        return Math.min(l4, l5);
    }

    private void changeToCurrentIdx(CowList cowList, int n) {
        this.allChangesReadyCount = 0;
        if (LOG.isTraceEnabled(1024)) {
            LOG.trace(1024).append("call: ").append(super.getClass().getName()).append(".changeToCurrentIdx(").append(n).append(")").log();
        }
        for (CowList cowList2 = cowList; cowList2 != CowList.EMPTY; cowList2 = cowList2.tail()) {
            AbstractMediator abstractMediator = (AbstractMediator)cowList2.head();
            int n2 = AbstractChanger.getNextChangeId();
            this.change(abstractMediator, n, n2);
        }
    }

    static synchronized int getNextChangeId() {
        if (LOG.isTraceEnabled(1024)) {
            LOG.trace(1024).append("call: ").append((class$de$vw$mib$lsctng$internal$AbstractChanger == null ? (class$de$vw$mib$lsctng$internal$AbstractChanger = AbstractChanger.class$("de.vw.mib.lsctng.internal.AbstractChanger")) : class$de$vw$mib$lsctng$internal$AbstractChanger).getName()).append(".static").append(".getNextChangeId()").log();
        }
        return nextId++;
    }

    protected final void change(AbstractMediator abstractMediator, int n, int n2) {
        if (LOG.isTraceEnabled(1024)) {
            LOG.trace(1024).append("call: ").append(super.getClass().getName()).append(".change(").append(abstractMediator.toString()).append(", ").append(n).append(",").append(n2).append(")").log();
        }
        this.changeInternal(abstractMediator, n, n2);
    }

    protected abstract void changeInternal(AbstractMediator abstractMediator, int n, int n2) {
    }

    protected abstract int getStrategyLength() {
    }

    @Override
    public synchronized void checkAllChangesReady() {
        if (LOG.isTraceEnabled(1024)) {
            LOG.trace(1024).append("call: ").append(super.getClass().getName()).append(".checkAllChangesReady()").log();
        }
        ++this.allChangesReadyCount;
        int n = this.currentMediators.size();
        if (LOG.isTraceEnabled(1024)) {
            LOG.trace(1024).append("changes ready: ").append(this.allChangesReadyCount).append("/").append(n).log();
        }
        if (this.allChangesReadyCount < n) {
            this.hasAllExpectedAnswers = false;
            return;
        }
        boolean bl = true;
        for (CowList cowList = this.currentMediators; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            AbstractMediator abstractMediator = (AbstractMediator)cowList.head();
            if (!this.isChanging(abstractMediator)) continue;
            bl = false;
            break;
        }
        this.hasAllExpectedAnswers = bl;
        LOG.normal(1024).append(super.getClass().getName()).append(" All changes ready: ").append(this.hasAllExpectedAnswers).log();
        if (this.hasAllExpectedAnswers) {
            super.notifyAll();
        }
    }

    protected abstract boolean isChanging(AbstractMediator abstractMediator) {
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName()).append(": [").append(this.mediators.size()).append(" mediators, timeout=").append(this.timeoutOneElement).append("/").append(this.timeoutTotal).append("]");
        return stringBuilder.toString();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        nextId = 0;
        LOG = ServiceManager.createLogger();
    }
}

