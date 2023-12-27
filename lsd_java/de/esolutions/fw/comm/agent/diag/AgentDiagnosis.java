/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.diag;

import de.esolutions.fw.comm.agent.AgentWorker;
import de.esolutions.fw.comm.agent.IAgentDiagnosis;
import de.esolutions.fw.comm.agent.IAgentErrorLog;
import de.esolutions.fw.comm.agent.IAgentInfoProvider;
import de.esolutions.fw.comm.agent.IAgentSnapshot;
import de.esolutions.fw.comm.agent.client.ClientPool;
import de.esolutions.fw.comm.agent.config.CommConfigDoctor;
import de.esolutions.fw.comm.agent.diag.AgentErrorLog;
import de.esolutions.fw.comm.agent.diag.AgentSnapshot;
import de.esolutions.fw.comm.agent.directory.IServiceDirectory;
import de.esolutions.fw.comm.agent.service.ServiceRegistry;
import de.esolutions.fw.comm.agent.tracing.CommAgentTracing;
import java.util.ArrayList;
import java.util.List;

public class AgentDiagnosis
implements IAgentDiagnosis {
    private final ClientPool clientPool;
    private final AgentWorker worker;
    private final AgentErrorLog errorLog;
    private final ServiceRegistry serviceRegistry;
    private final IServiceDirectory serviceDirectory;
    private final boolean infoProviderEnabled;
    private List infoProviders = new ArrayList();

    public AgentDiagnosis(ClientPool clientPool, AgentWorker agentWorker, AgentErrorLog agentErrorLog, ServiceRegistry serviceRegistry, IServiceDirectory iServiceDirectory, CommConfigDoctor commConfigDoctor) {
        this.clientPool = clientPool;
        this.worker = agentWorker;
        this.errorLog = agentErrorLog;
        this.serviceRegistry = serviceRegistry;
        this.serviceDirectory = iServiceDirectory;
        this.infoProviderEnabled = true;
    }

    @Override
    public IAgentSnapshot createSnapshot() {
        CommAgentTracing.DIAGNOSIS.log((short)1, "+ createSnapshot");
        AgentSnapshot agentSnapshot = new AgentSnapshot(this.clientPool, this.worker, this.serviceRegistry, this.serviceDirectory, this.infoProviders);
        CommAgentTracing.DIAGNOSIS.log((short)1, "- createSnapshot");
        return agentSnapshot;
    }

    @Override
    public IAgentErrorLog getErrorLog() {
        return this.errorLog;
    }

    @Override
    public void registerInfoProvider(IAgentInfoProvider iAgentInfoProvider) {
        if (this.infoProviderEnabled) {
            this.infoProviders.add(iAgentInfoProvider);
        }
    }

    @Override
    public void unregisterInfoProvider(IAgentInfoProvider iAgentInfoProvider) {
        this.infoProviders.remove(iAgentInfoProvider);
    }
}

