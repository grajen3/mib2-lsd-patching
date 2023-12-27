/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.gateway.command;

import de.vw.mib.asl.internal.navigation.gateway.Command;
import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.asl.internal.navigation.gateway.command.NavGatewayListener;
import org.dsi.ifc.global.NavLocation;

public class CmdRgSetPosition
extends Command {
    private NavLocation position;
    public long liResult_ReturnCode;

    public CmdRgSetPosition(NavGatewayListener navGatewayListener, NavLocation navLocation) {
        super(1019, 1035, navGatewayListener);
        this.position = navLocation;
    }

    @Override
    protected void execute(INavGateway iNavGateway) {
        iNavGateway.getDsiNavigation().rgSetPosition(this.position);
        this.checkAnswerSum(1035);
    }

    @Override
    public void onFinish() {
    }
}

