/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.command;

import de.esolutions.fw.comm.agent.command.Command;
import de.esolutions.fw.comm.agent.command.ICommandExecutor;
import de.esolutions.fw.comm.core.IServiceInstanceListener;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class RegisterServiceInstanceListenerCommand
extends Command {
    protected ServiceInstanceID instanceID;
    protected IServiceInstanceListener listener;
    protected boolean doRegister;

    public RegisterServiceInstanceListenerCommand(ServiceInstanceID serviceInstanceID, IServiceInstanceListener iServiceInstanceListener, boolean bl) {
        super("RegisterServiceInstanceListener");
        this.instanceID = serviceInstanceID;
        this.listener = iServiceInstanceListener;
        this.doRegister = bl;
    }

    @Override
    public boolean handle(ICommandExecutor iCommandExecutor) {
        return iCommandExecutor.doRegisterServiceInstanceListener(this.instanceID, this.listener, this.doRegister);
    }

    @Override
    public ServiceInstanceID getDependentInstanceID() {
        return null;
    }

    @Override
    public String getArgsString() {
        return new StringBuffer().append("instance=").append(this.instanceID).append(this.doRegister ? " register" : " unregister").toString();
    }
}

