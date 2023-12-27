/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.diag;

import de.esolutions.fw.comm.agent.AgentWorker;
import de.esolutions.fw.comm.agent.IAgentInfoProvider;
import de.esolutions.fw.comm.agent.IAgentSnapshot;
import de.esolutions.fw.comm.agent.client.ClientPool;
import de.esolutions.fw.comm.agent.diag.AgentInfoMap;
import de.esolutions.fw.comm.agent.diag.IInfoBase;
import de.esolutions.fw.comm.agent.diag.info.ClientInfo;
import de.esolutions.fw.comm.agent.diag.info.ProxyInfo;
import de.esolutions.fw.comm.agent.diag.info.ServiceHandlerInfo;
import de.esolutions.fw.comm.agent.diag.info.ServiceLocatorInfo;
import de.esolutions.fw.comm.agent.diag.info.StubInfo;
import de.esolutions.fw.comm.agent.diag.info.WorkerInfo;
import de.esolutions.fw.comm.agent.directory.IServiceDirectory;
import de.esolutions.fw.comm.agent.service.ServiceRegistry;
import java.util.List;

public class AgentSnapshot
implements IAgentSnapshot {
    private final ProxyInfo[] proxies;
    private final StubInfo[] stubs;
    private final ClientInfo[] clients;
    private final WorkerInfo worker;
    private final ServiceHandlerInfo[] svcHandlers;
    private final ServiceLocatorInfo[] svcLocators;
    private final long timeStamp;
    private final AgentInfoMap agentInfoMap;

    public AgentSnapshot(ClientPool clientPool, AgentWorker agentWorker, ServiceRegistry serviceRegistry, IServiceDirectory iServiceDirectory, List list) {
        this.proxies = clientPool.createProxyInfos();
        this.stubs = clientPool.createStubInfos();
        this.clients = clientPool.createClientInfos();
        this.svcHandlers = serviceRegistry.createServiceHandlerInfos();
        this.svcLocators = iServiceDirectory.createServiceLocatorInfos();
        this.worker = new WorkerInfo(agentWorker);
        this.timeStamp = System.currentTimeMillis();
        this.agentInfoMap = new AgentInfoMap();
        if (list != null) {
            int n = list.size();
            for (int i2 = 0; i2 < n; ++i2) {
                IAgentInfoProvider iAgentInfoProvider = (IAgentInfoProvider)list.get(i2);
                this.agentInfoMap.add(iAgentInfoProvider.getAgentInfoMap());
            }
        }
    }

    @Override
    public final ProxyInfo[] getAllProxies() {
        return this.proxies;
    }

    @Override
    public StubInfo[] getAllStubs() {
        return this.stubs;
    }

    @Override
    public ClientInfo[] getAllClients() {
        return this.clients;
    }

    @Override
    public ServiceHandlerInfo[] getAllServiceHandlers() {
        return this.svcHandlers;
    }

    @Override
    public ServiceLocatorInfo[] getAllServiceLocators() {
        return this.svcLocators;
    }

    @Override
    public WorkerInfo getWorker() {
        return this.worker;
    }

    @Override
    public long getTimeStamp() {
        return this.timeStamp;
    }

    @Override
    public String[] getAllInfoProviderNames() {
        return this.agentInfoMap.getAllNames();
    }

    @Override
    public IInfoBase[] getInfoProviderData(String string) {
        return this.agentInfoMap.getIInfoBaseForName(string);
    }
}

