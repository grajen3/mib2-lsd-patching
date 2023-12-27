/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.gateway.command;

import de.vw.mib.asl.internal.navigation.gateway.Command;
import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.asl.internal.navigation.gateway.command.NavGatewayListener;
import org.dsi.ifc.global.NavLocation;

public class CmdDmLastDestinationsGet
extends Command {
    public final long idestID;
    public long dmLastDestinationsGetResult_resultCode;
    public NavLocation dmLastDestinationsGetResult_destination;

    public CmdDmLastDestinationsGet(NavGatewayListener navGatewayListener, long l) {
        super(1010, 2001, navGatewayListener);
        this.idestID = l;
    }

    @Override
    protected void execute(INavGateway iNavGateway) {
        iNavGateway.getDsiNavigation().dmLastDestinationsGet(this.idestID);
    }

    @Override
    public void onFinish() {
        this.l.handleCommandCmdDmLastDestinationsGet(this);
    }

    @Override
    public void dmLastDestinationsGetResult(long l, NavLocation navLocation) {
        this.dmLastDestinationsGetResult_resultCode = l;
        this.dmLastDestinationsGetResult_destination = navLocation;
        this.checkAnswerSum(2001);
    }
}

