/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent;

import de.esolutions.fw.comm.agent.IAgentErrorLog;
import de.esolutions.fw.comm.agent.IAgentInfoProvider;
import de.esolutions.fw.comm.agent.IAgentSnapshot;

public interface IAgentDiagnosis {
    default public IAgentSnapshot createSnapshot() {
    }

    default public IAgentErrorLog getErrorLog() {
    }

    default public void registerInfoProvider(IAgentInfoProvider iAgentInfoProvider) {
    }

    default public void unregisterInfoProvider(IAgentInfoProvider iAgentInfoProvider) {
    }
}

