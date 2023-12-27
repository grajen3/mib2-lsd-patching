/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent;

import de.esolutions.fw.comm.agent.diag.IInfoBase;
import de.esolutions.fw.comm.agent.diag.info.ClientInfo;
import de.esolutions.fw.comm.agent.diag.info.ProxyInfo;
import de.esolutions.fw.comm.agent.diag.info.ServiceHandlerInfo;
import de.esolutions.fw.comm.agent.diag.info.ServiceLocatorInfo;
import de.esolutions.fw.comm.agent.diag.info.StubInfo;
import de.esolutions.fw.comm.agent.diag.info.WorkerInfo;

public interface IAgentSnapshot {
    default public ProxyInfo[] getAllProxies() {
    }

    default public StubInfo[] getAllStubs() {
    }

    default public ClientInfo[] getAllClients() {
    }

    default public WorkerInfo getWorker() {
    }

    default public ServiceHandlerInfo[] getAllServiceHandlers() {
    }

    default public ServiceLocatorInfo[] getAllServiceLocators() {
    }

    default public String[] getAllInfoProviderNames() {
    }

    default public IInfoBase[] getInfoProviderData(String string) {
    }

    default public long getTimeStamp() {
    }
}

