/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.agent.IAgentLifecycleListener;
import de.esolutions.fw.comm.core.Lifecycle;
import de.esolutions.fw.util.commons.timeout.ITimeSource;
import de.esolutions.fw.util.commons.timeout.TimeSourceProvider;

public class AgentStarter
implements IAgentLifecycleListener {
    private int timeOut = 5;
    private String errorString = null;
    private boolean agentIsAlive;
    private boolean agentIsDead;
    private boolean agentIsError;
    private boolean brokerConnected;
    private boolean cantReachBroker;

    public void setTimeOut(int n) {
        this.timeOut = n;
    }

    public int getTimeOut() {
        return this.timeOut;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean start() {
        Agent agent = Agent.init();
        if (agent == null) {
            AgentStarter agentStarter = this;
            synchronized (agentStarter) {
                this.errorString = Agent.getErrorString();
            }
            return false;
        }
        agent.registerAgentLifecycleListener(this);
        try {
            Agent.start();
        }
        catch (Exception exception) {
            this.errorString = new StringBuffer().append("Agent start failed: ").append(exception).toString();
            return false;
        }
        ITimeSource iTimeSource = TimeSourceProvider.getMonotonicTimeSource();
        long l = iTimeSource.getCurrentTime() + (long)(this.timeOut * 1000);
        AgentStarter agentStarter = this;
        synchronized (agentStarter) {
            while (!this.agentIsAlive || !this.brokerConnected) {
                long l2 = iTimeSource.getCurrentTime();
                if (l2 >= l) {
                    if (!this.agentIsAlive) {
                        this.errorString = new StringBuffer().append("agent did not went alive: ").append(agent.getReturnCodeErrorString()).toString();
                        return false;
                    }
                    this.errorString = "agent is alive but broker connection is not available";
                    return false;
                }
                try {
                    super.wait();
                }
                catch (InterruptedException interruptedException) {
                    // empty catch block
                }
                if (this.cantReachBroker) {
                    this.errorString = "agent aborted trying to reach the broker";
                    return false;
                }
                if (this.agentIsError) {
                    this.errorString = agent.getReturnCodeErrorString();
                    return false;
                }
                if (!this.agentIsDead) continue;
                this.errorString = "he is dead, jim.";
                return false;
            }
        }
        return true;
    }

    public boolean stop() {
        try {
            Agent.stop();
            return true;
        }
        catch (Exception exception) {
            this.errorString = new StringBuffer().append("agent stop: ").append(exception.getMessage()).toString();
            return false;
        }
    }

    public synchronized String getErrorString() {
        return this.errorString;
    }

    @Override
    public synchronized void lifecycleChanged(Lifecycle lifecycle, Object object) {
        if (lifecycle.isAlive()) {
            this.agentIsAlive = true;
        } else if (lifecycle.isError()) {
            this.agentIsError = true;
        } else if (lifecycle.isDead()) {
            this.agentIsDead = true;
        }
        super.notify();
    }

    @Override
    public synchronized void brokerLinkStateChanged(boolean bl) {
        this.brokerConnected = bl;
        super.notify();
    }

    @Override
    public synchronized void brokerConnectRetry(boolean bl) {
        if (bl) {
            this.cantReachBroker = true;
        }
        super.notify();
    }

    @Override
    public void agentIdUpdate(short s) {
    }

    @Override
    public Short getAgentIdProposal() {
        return null;
    }
}

