/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.command;

import de.esolutions.fw.comm.agent.command.Command;
import de.esolutions.fw.comm.agent.command.ICommandExecutor;
import de.esolutions.fw.comm.core.Proxy;

public class DisconnectProxyCommand
extends Command {
    protected Proxy proxy;

    public DisconnectProxyCommand(Proxy proxy) {
        super("DisconnectProxy");
        this.proxy = proxy;
    }

    @Override
    public boolean handle(ICommandExecutor iCommandExecutor) {
        return iCommandExecutor.doDisconnectProxy(this.proxy);
    }

    @Override
    public String getArgsString() {
        return new StringBuffer().append("instance=").append(this.proxy.getInstanceID()).toString();
    }
}

