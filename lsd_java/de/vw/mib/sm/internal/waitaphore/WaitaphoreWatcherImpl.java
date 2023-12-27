/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sm.internal.waitaphore;

import de.vw.mib.collections.ints.IntIntMap;
import de.vw.mib.collections.ints.IntIntOptHashMap;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.datapool.ModelDatapoolObserver;
import de.vw.mib.hmi.internal.ServiceManagerCommon;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.sm.internal.waitaphore.WaitaphoreObserver;
import de.vw.mib.sm.internal.waitaphore.WaitaphoreWatcher;
import de.vw.mib.sm.internal.waitaphore.WaitaphoreWatcherImpl$1;
import de.vw.mib.sm.internal.waitaphore.WaitaphoreWatcherImpl$2;
import de.vw.mib.timer.Timer;

public class WaitaphoreWatcherImpl
implements WaitaphoreWatcher,
ModelDatapoolObserver {
    private static final int CTX_CLASSIFIER;
    private static final int SUB_CLASSIFIER;
    private static final int STATE_RESPONSE;
    private static final int STATE_PENDING;
    private static final int STATE_WAIT_TIMEOUT;
    private static final int STATE_ERROR_TIMEOUT;
    private static final String[] STATE_NAMES;
    private final Logger logger = ServiceManagerCommon.loggerFactory.getLogger(0x800000);
    private final IntIntMap states = new IntIntOptHashMap();
    private final IntObjectMap timers = new IntObjectOptHashMap();
    private final IntObjectMap observers = new IntObjectOptHashMap();
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$sm$internal$waitaphore$WaitaphoreWatcherImpl;

    @Override
    public void datapoolValueChanged(int n) {
        if (this.changeState(n, 0) > 0) {
            ServiceManagerCommon.modelDatapool.unregisterObserver(n, this);
            WaitaphoreObserver waitaphoreObserver = (WaitaphoreObserver)this.observers.get(n);
            this.informObserver(waitaphoreObserver, n, 0);
        }
    }

    @Override
    public void lockWaitaphore(int n, int n2) {
        int n3 = ServiceManagerCommon.configurationManager.getWaitStateTimeout();
        if (n3 > n2) {
            LogMessage logMessage = this.logger.error(8);
            logMessage.append("The error timeout (").append(n2).append("ms) for waitaphore '").append(n);
            logMessage.append("' must be greater than the wait timeout (").append(n3).append("ms)!");
            logMessage.log();
        }
        this.changeState(n, 1);
        ServiceManagerCommon.modelDatapool.registerObserver(n, this, false);
        this.startTimer(n, n3, new WaitaphoreWatcherImpl$1(this, n, n2));
    }

    void onWaitTimeout(int n, int n2) {
        if (this.getState(n) == 0) {
            return;
        }
        int n3 = ServiceManagerCommon.configurationManager.getWaitStateTimeout();
        int n4 = n3 < n2 ? 2 : 3;
        this.changeState(n, n4);
        WaitaphoreObserver waitaphoreObserver = (WaitaphoreObserver)this.observers.get(n);
        this.informObserver(waitaphoreObserver, n, n4);
        if (n4 == 2) {
            this.startTimer(n, n2 - n3, new WaitaphoreWatcherImpl$2(this, n));
        }
    }

    void onErrorTimeout(int n) {
        if (this.getState(n) == 0) {
            return;
        }
        this.changeState(n, 3);
        WaitaphoreObserver waitaphoreObserver = (WaitaphoreObserver)this.observers.get(n);
        this.informObserver(waitaphoreObserver, n, 3);
    }

    private void startTimer(int n, long l, Runnable runnable) {
        Timer timer = (Timer)this.timers.get(n);
        if (timer == null) {
            timer = ServiceManagerCommon.timerManager.createTimer(new StringBuffer().append("AslGetterTimer-").append(n).toString());
            timer.setRepeat(false);
            this.timers.put(n, timer);
        } else {
            timer.stop();
        }
        timer.setDelay(l);
        timer.setRunnable(runnable, ServiceManagerCommon.datapoolEventDispatcher);
        timer.start();
    }

    @Override
    public void enterPropertyWaitaphore(int n, WaitaphoreObserver waitaphoreObserver) {
        int n2 = this.getState(n);
        this.observers.put(n, waitaphoreObserver);
        this.informObserver(waitaphoreObserver, n, n2);
    }

    @Override
    public void leavePropertyWaitaphore(int n, WaitaphoreObserver waitaphoreObserver) {
        this.observers.remove(n);
    }

    private int getState(int n) {
        return this.states.get(n);
    }

    private int changeState(int n, int n2) {
        int n3;
        int n4 = n3 = n2 == 0 ? this.states.remove(n) : this.states.put(n, n2);
        if (this.logger.isTraceEnabled(8)) {
            LogMessage logMessage = this.logger.trace(8);
            logMessage.append("Waitaphore [property ").append(n).append("] change state from ");
            logMessage.append(STATE_NAMES[n3]).append(" to ").append(STATE_NAMES[n2]);
            logMessage.log();
        }
        return n3;
    }

    private void informObserver(WaitaphoreObserver waitaphoreObserver, int n, int n2) {
        if (waitaphoreObserver != null) {
            if (n2 == 3 || this.logger.isTraceEnabled(8)) {
                LogMessage logMessage = n2 == 3 ? this.logger.warn(8) : this.logger.trace(8);
                logMessage.append("Waitaphore [property ").append(n).append("] informs observer for state ");
                logMessage.append(STATE_NAMES[n2]).append(": ").append(super.getClass().getName());
                logMessage.log();
            }
            switch (n2) {
                case 0: {
                    waitaphoreObserver.response();
                    break;
                }
                case 1: {
                    break;
                }
                case 2: {
                    waitaphoreObserver.waitTimeout();
                    break;
                }
                case 3: {
                    waitaphoreObserver.errorTimeout();
                    break;
                }
                default: {
                    if (!$assertionsDisabled) {
                        throw new AssertionError((Object)"Illegal state");
                    }
                    break;
                }
            }
        }
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
        $assertionsDisabled = !(class$de$vw$mib$sm$internal$waitaphore$WaitaphoreWatcherImpl == null ? (class$de$vw$mib$sm$internal$waitaphore$WaitaphoreWatcherImpl = WaitaphoreWatcherImpl.class$("de.vw.mib.sm.internal.waitaphore.WaitaphoreWatcherImpl")) : class$de$vw$mib$sm$internal$waitaphore$WaitaphoreWatcherImpl).desiredAssertionStatus();
        STATE_NAMES = new String[]{"0:response", "1:pending", "2:waitTimeout", "3:errorTimeout"};
    }
}

