/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.command;

import de.esolutions.fw.comm.agent.command.Command;
import de.esolutions.fw.comm.agent.command.ICommandExecutor;
import de.esolutions.fw.comm.core.IService;
import de.esolutions.fw.comm.core.IServiceListener;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class RegisterServiceListenerCommand
extends Command {
    protected IService service;
    protected IServiceListener listener;
    protected boolean doRegister;

    public RegisterServiceListenerCommand(IService iService, IServiceListener iServiceListener, boolean bl) {
        super("RegisterServiceListener");
        this.service = iService;
        this.listener = iServiceListener;
        this.doRegister = bl;
    }

    @Override
    public boolean handle(ICommandExecutor iCommandExecutor) {
        return iCommandExecutor.doRegisterServiceListener(this.service, this.listener, this.doRegister);
    }

    @Override
    public ServiceInstanceID getDependentInstanceID() {
        return null;
    }

    @Override
    public String getArgsString() {
        return new StringBuffer().append("instance=").append(this.service.getInstanceID()).append(this.doRegister ? " register" : " unregister").toString();
    }
}

