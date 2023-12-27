/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.comm;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.agent.service.ServiceQueueWorker;
import de.esolutions.fw.dsi.comm.IDSIServiceWorker;
import de.esolutions.fw.util.commons.timeout.TimeSourceProvider;

public class SimpleDSIServiceWorker
extends ServiceQueueWorker
implements IDSIServiceWorker {
    private final String name;

    public SimpleDSIServiceWorker(String string) {
        super(string, 100, 5000, false, 5, TimeSourceProvider.getMonotonicTimeSource(), Agent.getAgent().getRunnableWrapper());
        this.name = string;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getUseCount() {
        return this.serviceCount;
    }

    @Override
    public void start() {
    }

    @Override
    public void stop() {
    }
}

