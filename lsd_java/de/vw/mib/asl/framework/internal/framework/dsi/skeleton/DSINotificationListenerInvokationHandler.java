/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.dsi.skeleton;

import de.vw.mib.asl.framework.internal.framework.dsi.proxy.DSIProxyTarget;
import de.vw.mib.asl.framework.internal.framework.dsi.skeleton.DSISkeletonTarget;
import de.vw.mib.asl.framework.internal.framework.dsi.util.Cfg$PT;
import de.vw.mib.asl.framework.internal.framework.dsi.util.Constants;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.asl.framework.internal.framework.dsi.util.Utils;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.log4mib.InvocationContext;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.reflection.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

final class DSINotificationListenerInvokationHandler
extends InvocationHandler {
    private final DSISkeletonTarget skeletonTarget;
    private final int typeIdx;
    private final int instanceId;
    private final int[] notDiscardableUpdateIds;
    private final int[] ignoreValidFlagUpdateIds;

    DSINotificationListenerInvokationHandler(DSISkeletonTarget dSISkeletonTarget, int n, int n2) {
        this.skeletonTarget = dSISkeletonTarget;
        this.typeIdx = n;
        this.instanceId = n2;
        this.ignoreValidFlagUpdateIds = Cfg$PT.getNonValidateNotifications(n);
        this.notDiscardableUpdateIds = Cfg$PT.getNonDiscardableNotifications(n);
    }

    @Override
    public Object invoke(Object object, Method method, int n, Object[] objectArray) {
        if (null == method) {
            throw new NullPointerException("method");
        }
        InvocationContext.startSpecificInvocation(-3, null);
        if (Utils.isTraceEnabled(this.typeIdx)) {
            Utils.traceListenerUpdateInvocation(this.typeIdx, this.instanceId, method.getName(), objectArray);
        }
        if (n == -1) {
            n = this.skeletonTarget.getListenerMethodIndex(this.typeIdx, method.getName(), method.getParameterTypes());
        }
        Utils.putRuntimeListenerMethodName(this.typeIdx, n, method.getName());
        Utils.debugInvokeNotificationListener(this.typeIdx, this.instanceId, n, objectArray);
        if (null == objectArray || 0 == objectArray.length || !(objectArray[objectArray.length - 1] instanceof Integer)) {
            LogMessage logMessage = this.skeletonTarget.error();
            logMessage.append("Non-update method called on notification listener - cannot propagate ");
            Utils.appendInstanceMethod(logMessage, RuntimeGeneratedConstants.LISTENER_TS_NS[this.typeIdx], this.instanceId, method.getName());
            logMessage.log();
            Constants.PROXY_OAP.returnArray(objectArray);
        } else if (!this.validUpdate(n, objectArray)) {
            Constants.PROXY_OAP.returnArray(objectArray);
        } else if (this.skeletonTarget.isQueueOverloaded() && !this.notDiscardable(n)) {
            LogMessage logMessage = this.skeletonTarget.error();
            logMessage.append("DISPATCHER QUEUE FULL - cannot propagate ");
            Utils.appendInstanceMethod(logMessage, RuntimeGeneratedConstants.LISTENER_TS_NS[this.typeIdx], this.instanceId, method.getName());
            logMessage.log();
            Constants.PROXY_OAP.returnArray(objectArray);
        } else {
            Object[] objectArray2 = this.skeletonTarget.getListenerInterceptors(this.typeIdx, this.instanceId);
            if (0 < objectArray2.length) {
                this.wrappedInvoke(n, objectArray, objectArray2);
            } else {
                this.methodInvoke(n, objectArray);
            }
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void wrappedInvoke(int n, Object[] objectArray, Object[] objectArray2) {
        String string = RuntimeGeneratedConstants.LISTENER_TS_NS[this.typeIdx];
        boolean bl = Utils.before(objectArray2, string, this.instanceId, n, objectArray);
        if (bl) {
            Object[] objectArray3 = Constants.PROXY_OAP.borrowArray(objectArray.length);
            System.arraycopy((Object)objectArray, 0, (Object)objectArray3, 0, objectArray.length);
            try {
                this.methodInvoke(n, objectArray);
            }
            finally {
                try {
                    Utils.after(objectArray2, string, this.instanceId, n, objectArray3);
                }
                finally {
                    Constants.PROXY_OAP.returnArray(objectArray3);
                }
            }
        }
        Constants.PROXY_OAP.returnArray(objectArray);
    }

    private void methodInvoke(int n, Object[] objectArray) {
        EventGeneric eventGeneric = DSIProxyTarget.createNotificationInvocationEvent(this.typeIdx, this.instanceId, n, objectArray);
        this.skeletonTarget.send(eventGeneric);
    }

    private boolean validUpdate(int n, Object[] objectArray) {
        return (Integer)objectArray[objectArray.length - 1] == 1 || this.ignoreValideFlag(n);
    }

    private boolean ignoreValideFlag(int n) {
        return DSINotificationListenerInvokationHandler.orderedContains(this.ignoreValidFlagUpdateIds, n);
    }

    private boolean notDiscardable(int n) {
        return DSINotificationListenerInvokationHandler.orderedContains(this.notDiscardableUpdateIds, n);
    }

    private static boolean orderedContains(int[] nArray, int n) {
        return null != nArray && 0 <= Arrays.binarySearch(nArray, n);
    }
}

