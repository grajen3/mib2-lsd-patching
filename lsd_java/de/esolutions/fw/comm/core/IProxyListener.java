/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core;

import de.esolutions.fw.comm.core.Proxy;

public interface IProxyListener {
    default public void proxyStateChanged(Proxy proxy, int n) {
    }
}

