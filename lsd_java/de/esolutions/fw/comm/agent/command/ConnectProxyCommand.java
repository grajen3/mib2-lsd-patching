/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.command;

import de.esolutions.fw.comm.agent.command.Command;
import de.esolutions.fw.comm.agent.command.ICommandExecutor;
import de.esolutions.fw.comm.core.Proxy;

public class ConnectProxyCommand
extends Command {
    protected Proxy proxy;

    public ConnectProxyCommand(Proxy proxy) {
        super("ConnectProxy");
        this.setDependentInstanceID(proxy.getInstanceID());
        this.proxy = proxy;
    }

    @Override
    public boolean handle(ICommandExecutor iCommandExecutor) {
        return iCommandExecutor.doConnectProxy(this.proxy);
    }

    @Override
    public void drop(ICommandExecutor iCommandExecutor, boolean bl) {
        iCommandExecutor.dropConnectProxy(this.proxy, bl);
    }

    @Override
    public String getArgsString() {
        return new StringBuffer().append("instance=").append(this.proxy.getInstanceID()).toString();
    }
}

