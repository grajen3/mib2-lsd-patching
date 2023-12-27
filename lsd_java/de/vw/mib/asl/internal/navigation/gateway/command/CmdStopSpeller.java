/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.gateway.command;

import de.vw.mib.asl.internal.navigation.gateway.Command;
import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.asl.internal.navigation.gateway.command.NavGatewayListener;

public class CmdStopSpeller
extends Command {
    public CmdStopSpeller(NavGatewayListener navGatewayListener) {
        super(1149, 2005, navGatewayListener);
    }

    @Override
    protected void execute(INavGateway iNavGateway) {
        iNavGateway.getDsiNavigation().liStopSpeller();
    }

    @Override
    public void onFinish() {
        this.l.handleCommandCmdStopSpeller(this);
    }
}

