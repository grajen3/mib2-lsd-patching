/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.dsiproxy;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyInterceptor;

public class DSIProxyInterceptorAdapter
implements DSIProxyInterceptor {
    @Override
    public boolean before(String string, int n, int n2, Object[] objectArray) {
        return true;
    }

    @Override
    public void after(String string, int n, int n2, Object[] objectArray) {
    }
}

