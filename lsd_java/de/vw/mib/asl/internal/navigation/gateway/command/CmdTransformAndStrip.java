/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.gateway.command;

import de.vw.mib.asl.internal.navigation.gateway.Command;
import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.asl.internal.navigation.gateway.command.NavGatewayListener;
import org.dsi.ifc.global.NavLocation;

public class CmdTransformAndStrip
extends Command {
    INavGateway gw;
    public int stripType;
    public NavLocation location;

    public CmdTransformAndStrip(NavGatewayListener navGatewayListener, NavLocation navLocation, int n) {
        super(1054, 4071, navGatewayListener, 0);
        this.location = navLocation;
        this.stripType = n;
    }

    public CmdTransformAndStrip(NavGatewayListener navGatewayListener, NavLocation navLocation, int n, long l) {
        super(1054, 4071, navGatewayListener, l);
        this.location = navLocation;
        this.stripType = n;
    }

    @Override
    protected void execute(INavGateway iNavGateway) {
        this.gw = iNavGateway;
        iNavGateway.getDsiNavigation().liGetLocationDescriptionTransform(this.location);
    }

    @Override
    protected void onFinish() {
        this.l.handleCommandCmdTransformAndStrip(this);
    }

    @Override
    public void liGetLocationDescriptionTransformResult(NavLocation navLocation) {
        this.checkAnswerSum(2018);
        this.req_type = 1112;
        this.location = navLocation;
        this.gw.getDsiNavigation().liStripLocation(navLocation, this.stripType);
    }

    @Override
    public void liStripLocationResult(NavLocation navLocation) {
        this.location = navLocation;
        this.checkAnswerSum(2053);
    }
}

