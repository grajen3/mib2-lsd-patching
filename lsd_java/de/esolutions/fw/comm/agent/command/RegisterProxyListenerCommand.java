/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.command;

import de.esolutions.fw.comm.agent.command.Command;
import de.esolutions.fw.comm.agent.command.ICommandExecutor;
import de.esolutions.fw.comm.core.IProxyListener;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class RegisterProxyListenerCommand
extends Command {
    protected Proxy proxy;
    protected IProxyListener listener;
    protected boolean doRegister;

    public RegisterProxyListenerCommand(Proxy proxy, IProxyListener iProxyListener, boolean bl) {
        super("RegisterProxyListener");
        this.proxy = proxy;
        this.listener = iProxyListener;
        this.doRegister = bl;
    }

    @Override
    public boolean handle(ICommandExecutor iCommandExecutor) {
        return iCommandExecutor.doRegisterProxyListener(this.proxy, this.listener, this.doRegister);
    }

    @Override
    public ServiceInstanceID getDependentInstanceID() {
        return null;
    }

    @Override
    public String getArgsString() {
        return new StringBuffer().append("instance=").append(this.proxy.getInstanceID()).append(this.doRegister ? " register" : " unregister").toString();
    }
}

