/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.client;

import de.esolutions.fw.comm.agent.diag.info.ProxyInfo;
import de.esolutions.fw.comm.agent.tracing.CommAgentTracing;
import de.esolutions.fw.comm.core.IProxyBackend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.util.commons.pool.ShortPool;

public class ProxyPool {
    protected ShortPool clientProxies;

    public ProxyPool(short s) {
        this.clientProxies = new ShortPool(s);
    }

    public synchronized int size() {
        return this.clientProxies.size();
    }

    public synchronized short add(Proxy proxy) {
        short s = this.clientProxies.add(proxy);
        CommAgentTracing.PROXYSTUBPOOL.log((short)1, "#PoolSize ProxyPool, size=%1, proxyID=%2 [add]", new Integer(this.size()), (Object)new Short(s));
        return s;
    }

    public synchronized short addIfMissing(Proxy proxy) {
        short s = -1;
        s = this.clientProxies.findObject(proxy) == -1 ? (short)this.clientProxies.add(proxy) : (short)proxy.getProxyID();
        CommAgentTracing.PROXYSTUBPOOL.log((short)1, "#PoolSize ProxyPool, size=%1, proxyID=%2 [addIfMissing]", new Integer(this.size()), (Object)new Short(s));
        return s;
    }

    public synchronized Proxy remove(short s) {
        Proxy proxy = (Proxy)this.clientProxies.remove(s);
        short s2 = -1;
        if (proxy != null) {
            s2 = proxy.getProxyID();
        }
        CommAgentTracing.PROXYSTUBPOOL.log((short)1, "#PoolSize ProxyPool, size=%1, proxyID=%2 [remove]", new Integer(this.size()), (Object)new Short(s2));
        return proxy;
    }

    public synchronized Proxy getForID(short s) {
        return (Proxy)this.clientProxies.getObject(s);
    }

    public synchronized void clear() {
        this.clientProxies.clear();
        CommAgentTracing.PROXYSTUBPOOL.log((short)1, "#PoolSize ProxyPool, size=%1 [clear]", new Integer(this.size()));
    }

    public synchronized short[] getUsedIDs() {
        return this.clientProxies.getUsedIDs();
    }

    public synchronized Proxy[] getIDsForBackend(IProxyBackend iProxyBackend) {
        short[] sArray = this.clientProxies.getUsedIDs();
        if (sArray == null) {
            return null;
        }
        int n = 0;
        for (int i2 = 0; i2 < sArray.length; ++i2) {
            Proxy proxy = this.getForID(sArray[i2]);
            if (proxy.getBackend() != iProxyBackend) continue;
            ++n;
        }
        if (n == 0) {
            return null;
        }
        Proxy[] proxyArray = new Proxy[n];
        n = 0;
        for (int i3 = 0; i3 < sArray.length; ++i3) {
            Proxy proxy = this.getForID(sArray[i3]);
            if (proxy.getBackend() != iProxyBackend) continue;
            proxyArray[n++] = proxy;
        }
        return proxyArray;
    }

    public synchronized Proxy[] getIDsForServiceInstanceID(IProxyBackend iProxyBackend, ServiceInstanceID serviceInstanceID) {
        short[] sArray = this.clientProxies.getUsedIDs();
        if (sArray == null) {
            return null;
        }
        int n = 0;
        for (int i2 = 0; i2 < sArray.length; ++i2) {
            Proxy proxy = this.getForID(sArray[i2]);
            if (!proxy.getInstanceID().equals(serviceInstanceID) || proxy.getBackend() != iProxyBackend) continue;
            ++n;
        }
        if (n == 0) {
            return null;
        }
        Proxy[] proxyArray = new Proxy[n];
        n = 0;
        for (int i3 = 0; i3 < sArray.length; ++i3) {
            Proxy proxy = this.getForID(sArray[i3]);
            if (!proxy.getInstanceID().equals(serviceInstanceID) || proxy.getBackend() != iProxyBackend) continue;
            proxyArray[n++] = proxy;
        }
        return proxyArray;
    }

    public synchronized ProxyInfo[] createProxyInfos() {
        Object[] objectArray = this.clientProxies.getUsedObjects();
        if (objectArray != null) {
            ProxyInfo[] proxyInfoArray = new ProxyInfo[objectArray.length];
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                Proxy proxy = (Proxy)objectArray[i2];
                proxyInfoArray[i2] = new ProxyInfo(proxy);
            }
            return proxyInfoArray;
        }
        return null;
    }
}

