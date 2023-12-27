/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.gateway.command;

import de.vw.mib.asl.internal.navigation.gateway.Command;
import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.asl.internal.navigation.gateway.command.NavGatewayListener;

public class CmdCancelSpeller
extends Command {
    public long liResult_ReturnCode;

    public CmdCancelSpeller(NavGatewayListener navGatewayListener) {
        super(1021, 2005, navGatewayListener);
    }

    @Override
    public void execute(INavGateway iNavGateway) {
        iNavGateway.getDsiNavigation().lispCancelSpeller();
    }

    @Override
    public void liResult(long l) {
        this.liResult_ReturnCode = l;
        this.checkAnswerSum(2005);
    }

    @Override
    public void onFinish() {
        this.l.handleCommandCmdCancelSpeller(this);
    }
}

