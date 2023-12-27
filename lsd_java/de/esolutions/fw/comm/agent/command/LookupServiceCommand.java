/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.command;

import de.esolutions.fw.comm.agent.command.Command;
import de.esolutions.fw.comm.agent.command.ICommandExecutor;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class LookupServiceCommand
extends Command {
    protected ServiceInstanceID instanceID;

    public LookupServiceCommand(ServiceInstanceID serviceInstanceID) {
        super("LookupService");
        this.instanceID = serviceInstanceID;
    }

    @Override
    public boolean handle(ICommandExecutor iCommandExecutor) {
        return iCommandExecutor.doLookupService(this.instanceID);
    }

    @Override
    public String getArgsString() {
        return new StringBuffer().append("instance=").append(this.instanceID).toString();
    }
}

