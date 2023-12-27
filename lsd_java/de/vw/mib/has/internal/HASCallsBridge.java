/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has.internal;

import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.has.HASClock;
import de.vw.mib.has.HASClockConsumer;
import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASContextResults;
import de.vw.mib.has.HASInvocation;
import de.vw.mib.has.HASInvocationHandler;
import de.vw.mib.has.HASListControl;
import de.vw.mib.has.HASListRequest;
import de.vw.mib.has.internal.ActionEntry;
import de.vw.mib.has.internal.HASConfig;
import de.vw.mib.has.internal.HASInvocationImpl;
import de.vw.mib.has.internal.HASLog;
import de.vw.mib.has.internal.HASManager;
import de.vw.mib.log4mib.LogMessage;
import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.LinkedList;

final class HASCallsBridge
implements HASContextResults,
HASClockConsumer {
    private static final String LOG_PREFIX;
    private final IntObjectMap calls = new IntObjectOptHashMap().synchronize();

    HASCallsBridge() {
    }

    @Override
    public void callResult(int n, int n2, int n3, HASContainer hASContainer) {
        ActionEntry actionEntry = this.checkoutActionEntry(n, n2);
        if (null != actionEntry) {
            HASInvocationHandler hASInvocationHandler = actionEntry.getResultHandler();
            HASInvocationImpl hASInvocationImpl = actionEntry.getInvocation();
            actionEntry.release();
            hASInvocationImpl.setResultCode(n3);
            hASInvocationImpl.setResult(hASContainer);
            HASCallsBridge.sendResult(hASInvocationHandler, hASInvocationImpl);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void handleActionRequest(HASInvocation hASInvocation, HASInvocationHandler hASInvocationHandler) {
        ActionEntry actionEntry = this.createActionEntry(HASInvocationImpl.copy(hASInvocation), hASInvocationHandler);
        hASInvocation = actionEntry.getInvocation();
        actionEntry.setTTL(HASConfig.getCallTTL());
        int n = actionEntry.getUniqueId();
        boolean bl = false;
        try {
            HASListControl hASListControl = HASManager.getInstance().getRegistry().getListByAction(hASInvocation.getActionId());
            if (null != hASListControl) {
                HASListRequest hASListRequest = HASManager.getInstance().getFactory().createListRequest(n, hASInvocation);
                hASListControl.request(hASListRequest);
            } else {
                hASInvocation.getContext().getServicesImpl().actionRequest(n, hASInvocation.getActionId(), hASInvocation.getArgument());
            }
            bl = true;
        }
        finally {
            if (!bl) {
                this.removeActionEntry(n);
                actionEntry.getInvocation().release();
                actionEntry.release();
            }
        }
    }

    @Override
    public void onClock(HASClock hASClock) {
        this.purgeMissedEntries(hASClock.getInterval());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void purgeMissedEntries(int n) {
        Object object;
        AbstractCollection abstractCollection = null;
        Object object2 = this.calls;
        synchronized (object2) {
            Iterator iterator = this.calls.valueIterator();
            while (iterator.hasNext()) {
                object = (ActionEntry)iterator.next();
                if (!((ActionEntry)object).decreaseTTL(n)) continue;
                iterator.remove();
                if (null == abstractCollection) {
                    abstractCollection = new LinkedList();
                }
                ((LinkedList)abstractCollection).add(object);
            }
        }
        if (null != abstractCollection) {
            while (!abstractCollection.isEmpty()) {
                object2 = (ActionEntry)((LinkedList)abstractCollection).removeFirst();
                int n2 = ((ActionEntry)object2).getUniqueId();
                object = ((ActionEntry)object2).getResultHandler();
                HASInvocationImpl hASInvocationImpl = ((ActionEntry)object2).getInvocation();
                hASInvocationImpl.setResultCode(-3);
                ((ActionEntry)object2).release();
                LogMessage logMessage = HASLog.warn();
                HASLog.appendPrefixAndMethod(logMessage, "HASCallsBridge", "purgeMissedEntries", true).append("Action result timed out");
                HASLog.appendCallId(logMessage, n2, true);
                HASLog.appendHASInvocation(logMessage, hASInvocationImpl, true).log();
                HASCallsBridge.sendResult((HASInvocationHandler)object, hASInvocationImpl);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void sendResult(HASInvocationHandler hASInvocationHandler, HASInvocationImpl hASInvocationImpl) {
        try {
            hASInvocationImpl.setState(1);
            hASInvocationHandler.handleInvocation(hASInvocationImpl);
        }
        finally {
            hASInvocationImpl.release();
        }
    }

    private ActionEntry createActionEntry(HASInvocationImpl hASInvocationImpl, HASInvocationHandler hASInvocationHandler) {
        ActionEntry actionEntry = ActionEntry.create(hASInvocationImpl, hASInvocationHandler);
        this.calls.put(actionEntry.getUniqueId(), actionEntry);
        return actionEntry;
    }

    private void removeActionEntry(int n) {
        this.calls.remove(n);
    }

    private ActionEntry checkoutActionEntry(int n, int n2) {
        ActionEntry actionEntry = (ActionEntry)this.calls.remove(n);
        if (null == actionEntry) {
            LogMessage logMessage = HASLog.warn();
            if (null != logMessage) {
                HASLog.appendPrefixAndMethod(logMessage, "HASCallsBridge", "checkoutActionEntry", true).append("Unexpected call result (maybe timed out before?)");
                HASLog.appendActionId(logMessage, n2, true);
                HASLog.appendCallId(logMessage, n, true).log();
            }
        } else {
            HASInvocationImpl hASInvocationImpl = actionEntry.getInvocation();
            if (hASInvocationImpl.getActionId() != n2) {
                LogMessage logMessage = HASLog.warn();
                if (null != logMessage) {
                    HASLog.appendPrefixAndMethod(logMessage, "HASCallsBridge", "checkoutActionEntry", true).append("Mismatching action result");
                    HASLog.appendActionId(logMessage, n2, true);
                    HASLog.appendHASInvocation(logMessage, hASInvocationImpl, true).log();
                }
                actionEntry.release();
                hASInvocationImpl.release();
                actionEntry = null;
            }
        }
        return actionEntry;
    }
}

