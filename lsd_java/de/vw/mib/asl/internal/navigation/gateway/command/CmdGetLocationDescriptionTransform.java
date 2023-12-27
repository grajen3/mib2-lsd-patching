/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.gateway.command;

import de.vw.mib.asl.internal.navigation.gateway.Command;
import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.asl.internal.navigation.gateway.command.NavGatewayListener;
import org.dsi.ifc.global.NavLocation;

public class CmdGetLocationDescriptionTransform
extends Command {
    private NavLocation locDescID;
    public NavLocation liGetLocationDescriptionTransformResult_NavLocation;

    public CmdGetLocationDescriptionTransform(NavGatewayListener navGatewayListener, NavLocation navLocation) {
        super(1054, 2018, navGatewayListener);
        this.locDescID = navLocation;
    }

    @Override
    protected void execute(INavGateway iNavGateway) {
        iNavGateway.getDsiNavigation().liGetLocationDescriptionTransform(this.locDescID);
    }

    @Override
    public void onFinish() {
        this.l.handleCommandCmdGetLocationDescriptionTransform(this);
    }

    @Override
    public void liGetLocationDescriptionTransformResult(NavLocation navLocation) {
        this.liGetLocationDescriptionTransformResult_NavLocation = navLocation;
        this.checkAnswerSum(2018);
    }
}

