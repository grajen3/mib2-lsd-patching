/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.gateway.command;

import de.vw.mib.asl.internal.navigation.gateway.Command;
import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.asl.internal.navigation.gateway.command.NavGatewayListener;

public class CmdDmLastDestinationsDeleteAll
extends Command {
    public long dmLastDestinationsDeleteAll_resultCode;

    public CmdDmLastDestinationsDeleteAll(NavGatewayListener navGatewayListener) {
        super(1008, 2003, navGatewayListener);
    }

    @Override
    protected void execute(INavGateway iNavGateway) {
        iNavGateway.getDsiNavigation().dmLastDestinationsDeleteAll();
    }

    @Override
    public void onFinish() {
        this.l.handleCommandCmdDmLastDestinationsDeleteAll(this);
    }

    @Override
    public void dmResult(long l, long l2) {
        this.dmLastDestinationsDeleteAll_resultCode = l;
        this.checkAnswerSum(2003);
    }
}

