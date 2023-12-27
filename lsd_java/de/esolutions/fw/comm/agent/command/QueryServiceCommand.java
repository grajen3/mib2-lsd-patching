/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.command;

import de.esolutions.fw.comm.agent.command.Command;
import de.esolutions.fw.comm.agent.command.ICommandExecutor;
import de.esolutions.fw.comm.agent.directory.IServiceQueryReply;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class QueryServiceCommand
extends Command {
    protected final ServiceInstanceID instanceID;
    protected final IServiceQueryReply reply;

    public QueryServiceCommand(ServiceInstanceID serviceInstanceID, IServiceQueryReply iServiceQueryReply) {
        super("QueryService");
        this.setDependentInstanceID(serviceInstanceID);
        this.setDropNow(true);
        this.instanceID = serviceInstanceID;
        this.reply = iServiceQueryReply;
    }

    @Override
    public boolean handle(ICommandExecutor iCommandExecutor) {
        return iCommandExecutor.doQueryService(this.instanceID, this.reply);
    }

    @Override
    public void drop(ICommandExecutor iCommandExecutor, boolean bl) {
        iCommandExecutor.dropQueryService(this.instanceID, this.reply, bl);
    }

    @Override
    public String getArgsString() {
        return new StringBuffer().append("instance=").append(this.instanceID).toString();
    }
}

