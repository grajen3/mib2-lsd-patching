/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.service;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.agent.directory.DirectoryEntry;
import de.esolutions.fw.comm.agent.directory.IServiceQueryReply;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class ServiceQueryHelper
implements IServiceQueryReply {
    private DirectoryEntry[] result;
    private int errorCode;

    public boolean queryAllServices(Agent agent) {
        return this.queryService(agent, null);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean queryService(Agent agent, ServiceInstanceID serviceInstanceID) {
        if (agent == null) {
            return false;
        }
        agent.queryService(serviceInstanceID, this);
        ServiceQueryHelper serviceQueryHelper = this;
        synchronized (serviceQueryHelper) {
            while (this.errorCode == 0 && this.result == null) {
                try {
                    super.wait();
                }
                catch (InterruptedException interruptedException) {}
            }
            return this.result != null;
            {
            }
        }
    }

    public synchronized int getErrorCode() {
        return this.errorCode;
    }

    public synchronized DirectoryEntry[] getResult() {
        return this.result;
    }

    @Override
    public synchronized void serviceQueryResult(ServiceInstanceID serviceInstanceID, DirectoryEntry[] directoryEntryArray) {
        this.result = directoryEntryArray;
        super.notify();
    }

    @Override
    public synchronized void serviceQueryFailed(ServiceInstanceID serviceInstanceID, int n) {
        this.errorCode = n;
        super.notify();
    }
}

