/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.gateway.command;

import de.vw.mib.asl.internal.navigation.gateway.Command;
import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.asl.internal.navigation.gateway.command.NavGatewayListener;
import org.dsi.ifc.global.NavLocation;

public class CmdTransformAndToStream
extends Command {
    INavGateway gw;
    private NavLocation location;
    public byte[] stream;
    public Object arg;

    public CmdTransformAndToStream(NavGatewayListener navGatewayListener, NavLocation navLocation) {
        this(navGatewayListener, navLocation, null);
    }

    public CmdTransformAndToStream(NavGatewayListener navGatewayListener, NavLocation navLocation, Object object) {
        super(1054, 4061, navGatewayListener, 0);
        this.location = navLocation;
        this.arg = object;
    }

    @Override
    protected void execute(INavGateway iNavGateway) {
        this.gw = iNavGateway;
        iNavGateway.getDsiNavigation().liGetLocationDescriptionTransform(this.location);
    }

    @Override
    public void liGetLocationDescriptionTransformResult(NavLocation navLocation) {
        this.checkAnswerSum(2018);
        this.req_type = 1092;
        this.location = navLocation;
        this.gw.getDsiNavigation().locationToStream(navLocation);
    }

    @Override
    public void locationToStreamResult(boolean bl, byte[] byArray) {
        this.stream = byArray;
        this.checkAnswerSum(2043);
    }

    @Override
    protected void onFinish() {
        this.l.handleCommandCmdTransformAndToStream(this);
    }
}

