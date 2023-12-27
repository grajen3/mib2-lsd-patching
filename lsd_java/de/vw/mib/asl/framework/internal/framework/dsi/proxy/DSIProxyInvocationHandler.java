/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.dsi.proxy;

import de.vw.mib.asl.framework.internal.framework.dsi.proxy.DSIProxyTarget;
import de.vw.mib.reflection.InvocationHandler;
import java.lang.reflect.Method;

public final class DSIProxyInvocationHandler
extends InvocationHandler {
    private final DSIProxyTarget proxyTarget;
    private final int typeIdx;
    private final int instId;
    private final int targetId;

    public DSIProxyInvocationHandler(DSIProxyTarget dSIProxyTarget, int n, int n2, int n3) {
        this.proxyTarget = dSIProxyTarget;
        this.typeIdx = n;
        this.instId = n2;
        this.targetId = n3;
    }

    @Override
    public Object invoke(Object object, Method method, int n, Object[] objectArray) {
        this.proxyTarget.handlerInvoke(this.typeIdx, this.instId, this.targetId, method, n, objectArray);
        return null;
    }
}

