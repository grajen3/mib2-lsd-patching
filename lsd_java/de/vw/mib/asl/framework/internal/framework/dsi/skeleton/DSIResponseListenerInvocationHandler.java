/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.dsi.skeleton;

import de.vw.mib.asl.framework.internal.framework.dsi.proxy.DSIProxyTarget;
import de.vw.mib.asl.framework.internal.framework.dsi.proxy.InvocationItem;
import de.vw.mib.asl.framework.internal.framework.dsi.skeleton.DSISkeletonTarget;
import de.vw.mib.asl.framework.internal.framework.dsi.util.Cfg$C;
import de.vw.mib.asl.framework.internal.framework.dsi.util.Cfg$PT;
import de.vw.mib.asl.framework.internal.framework.dsi.util.Constants;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.asl.framework.internal.framework.dsi.util.Utils;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.log4mib.InvocationContext;
import de.vw.mib.reflection.InvocationHandler;
import java.lang.reflect.Method;

final class DSIResponseListenerInvocationHandler
extends InvocationHandler {
    private final DSISkeletonTarget skeletonTarget;
    private final int typeIdx;
    private final int instId;
    private final int typeInstIdx;
    private final int asyncExcId;

    DSIResponseListenerInvocationHandler(DSISkeletonTarget dSISkeletonTarget, int n, int n2) {
        this.skeletonTarget = dSISkeletonTarget;
        this.typeIdx = n;
        this.instId = n2;
        this.typeInstIdx = Utils.getInstDepObjIdx(n, n2);
        this.asyncExcId = Cfg$C.getListenerAsyncExceptionId(n);
    }

    @Override
    public Object invoke(Object object, Method method, int n, Object[] objectArray) {
        if (null == method) {
            throw new NullPointerException("method");
        }
        InvocationContext.startSpecificInvocation(-3, null);
        if (-1 == n) {
            n = this.skeletonTarget.getListenerMethodIndex(this.typeIdx, method.getName(), method.getParameterTypes());
        }
        if (this.asyncExcId == n) {
            Utils.logListenerAsyncException(this.typeIdx, this.instId, method.getName(), objectArray);
        } else if (Utils.isTraceEnabled(this.typeIdx)) {
            InvocationItem invocationItem;
            IntObjectMap intObjectMap;
            long l = -1L;
            if (!Cfg$PT.isNonSyncService(this.typeIdx) && null != (intObjectMap = Constants.PROXY_PENDIG_CS[this.typeInstIdx]) && null != (invocationItem = (InvocationItem)intObjectMap.get(n))) {
                l = Utils.currentTimeMillis() - invocationItem.reqTs;
            }
            Utils.traceListenerInvocation(this.typeIdx, this.instId, l, method.getName(), objectArray);
        }
        Utils.putRuntimeListenerMethodName(this.typeIdx, n, method.getName());
        Utils.debugInvokeResponseListener(this.typeIdx, this.instId, n, objectArray);
        Object[] objectArray2 = this.skeletonTarget.getListenerInterceptors(this.typeIdx, this.instId);
        if (0 < objectArray2.length) {
            this.wrappedInvoke(n, objectArray, objectArray2);
        } else {
            this.methodInvoke(n, objectArray);
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void wrappedInvoke(int n, Object[] objectArray, Object[] objectArray2) {
        boolean bl = Utils.before(objectArray2, RuntimeGeneratedConstants.LISTENER_TS_NS[this.typeIdx], this.instId, n, objectArray);
        if (bl) {
            Object[] objectArray3 = Constants.PROXY_OAP.borrowArray(objectArray.length);
            System.arraycopy((Object)objectArray, 0, (Object)objectArray3, 0, objectArray.length);
            try {
                this.methodInvoke(n, objectArray);
            }
            finally {
                try {
                    Utils.after(objectArray2, RuntimeGeneratedConstants.LISTENER_TS_NS[this.typeIdx], this.instId, n, objectArray3);
                }
                finally {
                    Constants.PROXY_OAP.returnArray(objectArray3);
                }
            }
        }
        Constants.PROXY_OAP.returnArray(objectArray);
    }

    private void methodInvoke(int n, Object[] objectArray) {
        EventGeneric eventGeneric = DSIProxyTarget.createResponseInvocationEvent(this.typeIdx, this.instId, n, objectArray);
        this.skeletonTarget.send(eventGeneric);
    }
}

