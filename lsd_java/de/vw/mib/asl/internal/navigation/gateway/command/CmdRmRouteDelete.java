/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.gateway.command;

import de.vw.mib.asl.internal.navigation.gateway.Command;
import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.asl.internal.navigation.gateway.command.NavGatewayListener;

public class CmdRmRouteDelete
extends Command {
    private int rmID;
    private long routeId;

    public CmdRmRouteDelete(NavGatewayListener navGatewayListener, long l, int n) {
        super(1075, 2030, navGatewayListener);
        this.rmID = n;
        this.routeId = l;
    }

    @Override
    protected void execute(INavGateway iNavGateway) {
        iNavGateway.getDsiNavigation().rmRouteDelete(this.rmID, this.routeId);
    }

    @Override
    public void onFinish() {
        this.l.handleCommandCmdRmRouteDelete(this);
    }

    @Override
    public void rmRouteDeleteResult(int n) {
        this.checkAnswerSum(2030);
    }
}

