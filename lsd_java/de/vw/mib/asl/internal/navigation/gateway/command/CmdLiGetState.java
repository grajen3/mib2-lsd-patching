/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.gateway.command;

import de.vw.mib.asl.internal.navigation.gateway.Command;
import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.asl.internal.navigation.gateway.command.NavGatewayListener;
import org.dsi.ifc.navigation.LISpellerData;

public class CmdLiGetState
extends Command {
    public LISpellerData liGetStateResult_spellerState;

    public CmdLiGetState(NavGatewayListener navGatewayListener) {
        super(1017, 2004, navGatewayListener);
    }

    @Override
    protected void execute(INavGateway iNavGateway) {
        iNavGateway.getDsiNavigation().liGetState();
    }

    @Override
    public void onFinish() {
        this.l.handleCommandCmdLiGetState(this);
    }

    @Override
    public void liGetStateResult(LISpellerData lISpellerData) {
        this.liGetStateResult_spellerState = lISpellerData;
        this.checkAnswerSum(2004);
    }
}

