/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.gateway.command;

import de.vw.mib.asl.internal.navigation.gateway.Command;
import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.asl.internal.navigation.gateway.command.NavGatewayListener;
import org.dsi.ifc.navigation.Route;

public class CmdRmRouteAdd
extends Command {
    private String name;
    private Route route;
    private int rmID;
    private int resultCode;
    private long routeId;

    public CmdRmRouteAdd(NavGatewayListener navGatewayListener, Route route, int n, String string) {
        super(1074, 2029, navGatewayListener);
        this.name = string;
        this.route = route;
        this.rmID = n;
    }

    @Override
    protected void execute(INavGateway iNavGateway) {
        iNavGateway.getDsiNavigation().rmRouteAdd(this.rmID, this.route, this.name);
    }

    @Override
    public void onFinish() {
        this.l.handleCommandCmdRmRouteAdd(this);
    }

    @Override
    public void rmRouteAddResult(int n, long l) {
        this.resultCode = n;
        this.routeId = l;
        this.checkAnswerSum(2029);
    }

    public long getRouteId() {
        return this.routeId;
    }

    public int getResultCode() {
        return this.resultCode;
    }
}

