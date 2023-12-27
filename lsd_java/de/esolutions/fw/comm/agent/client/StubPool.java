/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.client;

import de.esolutions.fw.comm.agent.client.IClientHandler;
import de.esolutions.fw.comm.agent.diag.info.StubInfo;
import de.esolutions.fw.comm.agent.service.Stub;
import de.esolutions.fw.comm.agent.tracing.CommAgentTracing;
import de.esolutions.fw.comm.core.IService;
import de.esolutions.fw.util.commons.pool.ShortPool;

public class StubPool {
    protected ShortPool clientStubs;

    public StubPool(short s) {
        this.clientStubs = new ShortPool(s);
    }

    public synchronized int size() {
        return this.clientStubs.size();
    }

    public synchronized short add(Stub stub) {
        short s = this.clientStubs.add(stub);
        CommAgentTracing.PROXYSTUBPOOL.log((short)1, "#PoolSize StubPool, size=%1, stubID=%2 [add]", new Integer(this.size()), (Object)new Short(s));
        return s;
    }

    public synchronized Stub remove(short s) {
        Stub stub = (Stub)this.clientStubs.remove(s);
        CommAgentTracing.PROXYSTUBPOOL.log((short)1, "#PoolSize StubPool, size=%1, stubID=%2 [remove] ", new Integer(this.size()), (Object)new Short(s));
        return stub;
    }

    public synchronized Stub getForID(short s) {
        return (Stub)this.clientStubs.getObject(s);
    }

    public synchronized void clear() {
        this.clientStubs.clear();
        CommAgentTracing.PROXYSTUBPOOL.log((short)1, "#PoolSize StubPool, size=%1 [clear] ", new Integer(this.size()));
    }

    public synchronized short[] getUsedIDs() {
        return this.clientStubs.getUsedIDs();
    }

    public synchronized Stub[] getIDsForClient(IClientHandler iClientHandler) {
        short[] sArray = this.clientStubs.getUsedIDs();
        if (sArray == null) {
            return null;
        }
        int n = 0;
        for (int i2 = 0; i2 < sArray.length; ++i2) {
            Stub stub = this.getForID(sArray[i2]);
            if (stub.getClient() != iClientHandler) continue;
            ++n;
        }
        if (n == 0) {
            return null;
        }
        Stub[] stubArray = new Stub[n];
        n = 0;
        for (int i3 = 0; i3 < sArray.length; ++i3) {
            Stub stub = this.getForID(sArray[i3]);
            if (stub.getClient() != iClientHandler) continue;
            stubArray[n++] = stub;
        }
        return stubArray;
    }

    public synchronized Stub[] getIDsForService(IService iService) {
        short[] sArray = this.clientStubs.getUsedIDs();
        if (sArray == null) {
            return null;
        }
        int n = 0;
        for (int i2 = 0; i2 < sArray.length; ++i2) {
            Stub stub = this.getForID(sArray[i2]);
            if (stub.getService() != iService) continue;
            ++n;
        }
        if (n == 0) {
            return null;
        }
        Stub[] stubArray = new Stub[n];
        n = 0;
        for (int i3 = 0; i3 < sArray.length; ++i3) {
            Stub stub = this.getForID(sArray[i3]);
            if (stub.getService() != iService) continue;
            stubArray[n++] = stub;
        }
        return stubArray;
    }

    public synchronized StubInfo[] createStubInfos() {
        Object[] objectArray = this.clientStubs.getUsedObjects();
        if (objectArray != null) {
            StubInfo[] stubInfoArray = new StubInfo[objectArray.length];
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                Stub stub = (Stub)objectArray[i2];
                stubInfoArray[i2] = new StubInfo(stub);
            }
            return stubInfoArray;
        }
        return null;
    }
}

