/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.command;

import de.esolutions.fw.comm.agent.command.Command;
import de.esolutions.fw.comm.agent.command.ICommandExecutor;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class RegisterRemoteServiceCommand
extends Command {
    protected ServiceInstanceID instanceID;
    protected short agentID;
    protected boolean doRegister;

    public RegisterRemoteServiceCommand(ServiceInstanceID serviceInstanceID, short s, boolean bl) {
        super("RegisterRemoteService");
        this.instanceID = serviceInstanceID;
        this.agentID = s;
        this.doRegister = bl;
    }

    @Override
    public boolean handle(ICommandExecutor iCommandExecutor) {
        return iCommandExecutor.doRegisterRemoteService(this.instanceID, this.agentID, this.doRegister);
    }

    @Override
    public ServiceInstanceID getDependentInstanceID() {
        return null;
    }

    @Override
    public String getArgsString() {
        return new StringBuffer().append("instance=").append(this.instanceID).append(" agent=#").append(this.agentID).append(this.doRegister ? " register" : " unregister").toString();
    }
}

