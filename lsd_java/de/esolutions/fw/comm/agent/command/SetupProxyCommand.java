/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.command;

import de.esolutions.fw.comm.agent.client.IClientHandler;
import de.esolutions.fw.comm.agent.command.Command;
import de.esolutions.fw.comm.agent.command.ICommandExecutor;
import de.esolutions.fw.comm.core.Proxy;

public class SetupProxyCommand
extends Command {
    protected Proxy proxy;

    public SetupProxyCommand(Proxy proxy, IClientHandler iClientHandler) {
        super("SetupProxy");
        this.proxy = proxy;
        this.setDependentClientHandler(iClientHandler);
    }

    @Override
    public boolean handle(ICommandExecutor iCommandExecutor) {
        return iCommandExecutor.doSetupProxy(this.proxy, this.handler);
    }

    @Override
    public void drop(ICommandExecutor iCommandExecutor, boolean bl) {
        iCommandExecutor.dropSetupProxy(this.proxy, bl);
    }

    @Override
    public String getArgsString() {
        return new StringBuffer().append("instance=").append(this.proxy.getInstanceID()).toString();
    }
}

