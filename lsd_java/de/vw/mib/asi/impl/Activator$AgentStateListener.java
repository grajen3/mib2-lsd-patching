/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.impl;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.agent.IAgentStateListener;
import de.vw.mib.log4mib.ClassifiedLogger;

class Activator$AgentStateListener
implements IAgentStateListener {
    private final ClassifiedLogger clogger;

    Activator$AgentStateListener(ClassifiedLogger classifiedLogger) {
        this.clogger = classifiedLogger;
    }

    @Override
    public void agentStarted(Agent agent) {
        this.clogger.info().append("ASI Agent started.").log();
    }

    @Override
    public void agentAboutToStop(Agent agent) {
        this.clogger.info().append("ASI Agent about to stop.").log();
    }
}

