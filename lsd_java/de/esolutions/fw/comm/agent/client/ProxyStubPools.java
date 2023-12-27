/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.client;

import de.esolutions.fw.comm.agent.client.IClientHandler;
import de.esolutions.fw.comm.agent.client.ProxyPool;
import de.esolutions.fw.comm.agent.client.StubOrError;
import de.esolutions.fw.comm.agent.client.StubPool;
import de.esolutions.fw.comm.agent.config.CommConfig;
import de.esolutions.fw.comm.agent.diag.info.ProxyInfo;
import de.esolutions.fw.comm.agent.diag.info.StubInfo;
import de.esolutions.fw.comm.agent.service.IServiceFinder;
import de.esolutions.fw.comm.agent.service.ServiceHandler;
import de.esolutions.fw.comm.agent.service.ServiceIKChecker;
import de.esolutions.fw.comm.agent.service.Stub;
import de.esolutions.fw.comm.agent.tracing.CommAgentTracing;
import de.esolutions.fw.comm.core.IExtendedReplyService;
import de.esolutions.fw.comm.core.IExtendedService;
import de.esolutions.fw.comm.core.IProxyBackend;
import de.esolutions.fw.comm.core.IService;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.ServiceUUID;
import de.esolutions.fw.util.commons.timeout.ITimeSource;

public class ProxyStubPools {
    private final ProxyPool proxyPool;
    private final StubPool stubPool;
    private final IServiceFinder serviceFinder;
    private final ServiceIKChecker ikChecker;
    private final ITimeSource monoTime;
    private final short proxyPoolSize;
    private final short stubPoolSize;

    public ProxyStubPools(IServiceFinder iServiceFinder, CommConfig commConfig, ServiceIKChecker serviceIKChecker, ITimeSource iTimeSource) {
        this.stubPoolSize = (short)commConfig.getStubPoolSize();
        this.proxyPoolSize = (short)commConfig.getProxyPoolSize();
        this.proxyPool = new ProxyPool(this.proxyPoolSize);
        this.stubPool = new StubPool(this.stubPoolSize);
        this.serviceFinder = iServiceFinder;
        this.ikChecker = serviceIKChecker;
        this.monoTime = iTimeSource;
    }

    public short getProxyIDPoolSize() {
        return this.proxyPoolSize;
    }

    public short getStubIDPoolSize() {
        return this.stubPoolSize;
    }

    public synchronized void shutdown() {
        short[] sArray;
        int n;
        CommAgentTracing.PROXYSTUBPOOL.log((short)0, "+ shutdown");
        short[] sArray2 = this.proxyPool.getUsedIDs();
        if (sArray2 != null) {
            int n2 = sArray2.length;
            CommAgentTracing.PROXYSTUBPOOL.log((short)1, "%1 orphaned proxies", new Integer(n2));
            for (n = 0; n < n2; ++n) {
                Proxy proxy = this.proxyPool.getForID(sArray2[n]);
                CommAgentTracing.PROXYSTUBPOOL.log((short)0, "proxy#%1: %2", new Short(sArray2[n]), (Object)proxy.getInstanceID());
            }
            this.proxyPool.clear();
        }
        if ((sArray = this.stubPool.getUsedIDs()) != null) {
            n = sArray.length;
            CommAgentTracing.PROXYSTUBPOOL.log((short)1, "%1 orphaned stubs", new Integer(n));
            for (int i2 = 0; i2 < n; ++i2) {
                Stub stub = this.stubPool.getForID(sArray[i2]);
                CommAgentTracing.PROXYSTUBPOOL.log((short)0, "stub#%1: %2", new Short(sArray[i2]), (Object)stub.getServiceHandler().getInstanceID());
            }
            this.stubPool.clear();
        }
        CommAgentTracing.PROXYSTUBPOOL.log((short)0, "- shutdown");
    }

    public synchronized Stub removeStub(short s) {
        Stub stub = this.stubPool.remove(s);
        if (stub == null) {
            CommAgentTracing.PROXYSTUBPOOL.log((short)2, "Can't remove stub=#%1: not found", new Short(s));
        } else {
            CommAgentTracing.PROXYSTUBPOOL.log((short)1, "removed stub=#%1 (pool size %2)", new Short(s), (Object)new Integer(this.stubPool.size()));
        }
        return stub;
    }

    public synchronized int countStubs(IClientHandler iClientHandler) {
        Stub[] stubArray = this.stubPool.getIDsForClient(iClientHandler);
        if (stubArray != null) {
            return stubArray.length;
        }
        return 0;
    }

    public synchronized int countProxies(IProxyBackend iProxyBackend) {
        Proxy[] proxyArray = this.proxyPool.getIDsForBackend(iProxyBackend);
        if (proxyArray != null) {
            return proxyArray.length;
        }
        return 0;
    }

    public synchronized Stub[] getStubsForClient(IClientHandler iClientHandler) {
        return this.stubPool.getIDsForClient(iClientHandler);
    }

    public synchronized StubOrError createStub(ServiceInstanceID serviceInstanceID, IClientHandler iClientHandler, short s, short s2) {
        ServiceHandler serviceHandler = this.serviceFinder.findService(serviceInstanceID);
        if (serviceHandler == null) {
            CommAgentTracing.PROXYSTUBPOOL.log((short)4, "Can't create stub: unknown service %1", serviceInstanceID);
            return new StubOrError(6);
        }
        IService iService = serviceHandler.getService();
        ServiceInstanceID serviceInstanceID2 = iService.getInstanceID();
        Boolean bl = null;
        if (iService instanceof IExtendedService) {
            bl = ((IExtendedService)iService).getCheckIK();
        } else if (iService instanceof IExtendedReplyService) {
            bl = ((IExtendedReplyService)iService).getCheckIK();
        }
        boolean bl2 = this.ikChecker.isCompatible("Stub", serviceInstanceID2, serviceInstanceID, bl);
        if (!bl2) {
            CommAgentTracing.AGENT.log((short)5, "Stub Interface Key Mismatch: no compatible service for proxy %1 found:\n%2", serviceInstanceID, (Object)serviceInstanceID2);
            return new StubOrError(4);
        }
        Stub stub = new Stub(serviceHandler, iClientHandler, s, s2, this.monoTime);
        short s3 = this.stubPool.add(stub);
        if (s3 == -1) {
            CommAgentTracing.PROXYSTUBPOOL.log((short)4, "Can't create stub: no IDs left!");
            return new StubOrError(8);
        }
        stub.setStubID(s3);
        return new StubOrError(stub);
    }

    public synchronized Stub getStubForID(short s) {
        Stub stub = this.stubPool.getForID(s);
        if (stub == null) {
            CommAgentTracing.PROXYSTUBPOOL.log((short)2, "Can't get object for stub=#%1", new Short(s));
        }
        return stub;
    }

    public synchronized Proxy getProxyForID(short s) {
        Proxy proxy = this.proxyPool.getForID(s);
        if (proxy == null) {
            CommAgentTracing.PROXYSTUBPOOL.log((short)4, "Can't get object for proxy=#%1", new Short(s));
        }
        return proxy;
    }

    public synchronized short addProxy(Proxy proxy, IProxyBackend iProxyBackend) {
        short s = this.proxyPool.addIfMissing(proxy);
        proxy.setProxyID(s);
        if (s == -1) {
            CommAgentTracing.PROXYSTUBPOOL.log((short)4, "Can't add proxy: no IDs left!");
        } else {
            proxy.setBackend(iProxyBackend);
        }
        return s;
    }

    public synchronized Proxy makeProxyAlive(short s, short s2) {
        Proxy proxy = this.proxyPool.getForID(s);
        if (proxy == null) {
            CommAgentTracing.PROXYSTUBPOOL.log((short)4, "Can't make proxy alive: proxy=#%1 not found", new Short(s));
            return null;
        }
        proxy.setStubID(s2);
        proxy.getLifecycle().setAlive();
        return proxy;
    }

    public synchronized Proxy makeProxyFailed(short s, byte by) {
        Proxy proxy = this.proxyPool.getForID(s);
        if (proxy == null) {
            CommAgentTracing.PROXYSTUBPOOL.log((short)4, "Can't make proxy failed: proxy=#%1 not found", new Short(s));
            return null;
        }
        this.proxyPool.remove(s);
        CommAgentTracing.PROXYSTUBPOOL.log((short)1, "marked proxy #%1 failed with error code %2 (pool size %3)", new Short(s), (Object)new Integer(by), (Object)new Integer(this.proxyPool.size()));
        proxy.getLifecycle().setError(by);
        proxy.setProxyID((short)-1);
        return proxy;
    }

    public synchronized void makeProxyDead(Proxy proxy) {
        short s = proxy.getProxyID();
        this.proxyPool.remove(s);
        if (proxy.getPendingError() != 0) {
            proxy.getLifecycle().setError(proxy.getPendingError());
            proxy.setProxyID((short)-1);
            CommAgentTracing.PROXYSTUBPOOL.log((short)1, "marked proxy #%1 error with %3 (pool size %2)", new Short(s), (Object)new Integer(this.proxyPool.size()), (Object)Proxy.ERROR_NAMES[proxy.getPendingError()]);
        } else {
            proxy.getLifecycle().setDead();
            proxy.setProxyID((short)-1);
            CommAgentTracing.PROXYSTUBPOOL.log((short)1, "marked proxy #%1 dead (pool size %2)", new Short(s), (Object)new Integer(this.proxyPool.size()));
        }
    }

    public synchronized Proxy[] getProxiesForBackend(IProxyBackend iProxyBackend) {
        return this.proxyPool.getIDsForBackend(iProxyBackend);
    }

    public synchronized Stub[] dropStubsForClient(IClientHandler iClientHandler) {
        Stub[] stubArray = this.stubPool.getIDsForClient(iClientHandler);
        if (stubArray != null) {
            for (int i2 = 0; i2 < stubArray.length; ++i2) {
                Stub stub = stubArray[i2];
                short s = stub.getStubID();
                CommAgentTracing.CLIENT.log((short)1, "dropping stub=#%1 (backend lost)", new Short(s));
                this.stubPool.remove(s);
                stub.getServiceHandler().detachedStub(stub);
            }
        }
        return stubArray;
    }

    public synchronized Stub[] getStubsForService(IService iService) {
        return this.stubPool.getIDsForService(iService);
    }

    public synchronized Proxy[] dropProxiesForBackend(IProxyBackend iProxyBackend, boolean bl) {
        Proxy[] proxyArray = this.proxyPool.getIDsForBackend(iProxyBackend);
        if (proxyArray != null) {
            for (int i2 = 0; i2 < proxyArray.length; ++i2) {
                Proxy proxy = proxyArray[i2];
                short s = proxy.getProxyID();
                CommAgentTracing.CLIENT.log((short)1, "dropping proxy=#%1 (backend lost)", new Short(s));
                this.proxyPool.remove(s);
                if (bl) {
                    proxy.getLifecycle().setError(3);
                    continue;
                }
                proxy.getLifecycle().setDead();
            }
        }
        return proxyArray;
    }

    public synchronized Proxy[] dropProxiesForBackend(IProxyBackend iProxyBackend) {
        return this.dropProxiesForBackend(iProxyBackend, true);
    }

    public synchronized Proxy[] getProxiesForService(ServiceInstanceID serviceInstanceID, IProxyBackend iProxyBackend) {
        Proxy[] proxyArray = this.proxyPool.getIDsForServiceInstanceID(iProxyBackend, serviceInstanceID);
        return proxyArray;
    }

    public synchronized Proxy[] dropProxiesForService(ServiceInstanceID serviceInstanceID, IProxyBackend iProxyBackend) {
        Proxy[] proxyArray = this.proxyPool.getIDsForServiceInstanceID(iProxyBackend, serviceInstanceID);
        if (proxyArray != null) {
            for (int i2 = 0; i2 < proxyArray.length; ++i2) {
                Proxy proxy = proxyArray[i2];
                short s = proxy.getProxyID();
                CommAgentTracing.CLIENT.log((short)1, "dropping proxy=#%1 (service lost)", new Short(s));
                this.proxyPool.remove(proxy.getProxyID());
                proxy.getLifecycle().setError(6);
            }
        }
        return proxyArray;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void dumpCommDatamodelProxies(short s) {
        int[] nArray;
        int[] nArray2;
        ServiceUUID[] serviceUUIDArray;
        Object object;
        ProxyStubPools proxyStubPools = this;
        synchronized (proxyStubPools) {
            object = this.proxyPool.getUsedIDs();
            if (object == null) {
                CommAgentTracing.COMM.log((short)2, "no proxies found on='%1' ", new Short(s));
                return;
            }
            serviceUUIDArray = new ServiceUUID[((short[])object).length];
            nArray2 = new int[((short[])object).length];
            nArray = new int[((short[])object).length];
            for (int i2 = 0; i2 < ((short[])object).length; ++i2) {
                Proxy proxy = this.proxyPool.getForID(object[i2]);
                serviceUUIDArray[i2] = proxy.getInstanceID().getServiceUUID();
                nArray2[i2] = proxy.getInstanceID().getHandle();
                nArray[i2] = proxy.getState();
            }
        }
        for (int i3 = 0; i3 < nArray.length; ++i3) {
            object = null;
            if (nArray[i3] == 0) {
                object = "UNBORN";
            }
            if (nArray[i3] == 1) {
                object = "ALIVE";
            }
            if (nArray[i3] == 2 || nArray[i3] == 3) {
                object = "DEAD";
            }
            if (object == null) continue;
            CommAgentTracing.COMM.log((short)2, "on='%1' event='proxy-status' interface='%2:%3' info='%4' ", new Short(s), (Object)serviceUUIDArray[i3], (Object)new Integer(nArray2[i3]), object);
        }
    }

    public ProxyInfo[] createProxyInfos() {
        return this.proxyPool.createProxyInfos();
    }

    public StubInfo[] createStubInfos() {
        return this.stubPool.createStubInfos();
    }
}

