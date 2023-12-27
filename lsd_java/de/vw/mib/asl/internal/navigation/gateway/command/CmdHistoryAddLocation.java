/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.gateway.command;

import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdAbstractSpeller;
import de.vw.mib.asl.internal.navigation.gateway.command.NavGatewayListener;
import org.dsi.ifc.global.NavLocation;

public class CmdHistoryAddLocation
extends CmdAbstractSpeller {
    private static final int START_SPELLER_TIMEOUT;
    private NavLocation location;

    public CmdHistoryAddLocation(NavGatewayListener navGatewayListener, NavLocation navLocation) {
        super(1200, 2084, navGatewayListener, 30000);
        this.location = navLocation;
        this.commonErrorString = new StringBuffer("liHistoryAddLocation(").append(navLocation).append(")").toString();
    }

    @Override
    public void execute(INavGateway iNavGateway) {
        iNavGateway.getDsiNavigation().liHistoryAddLocation(this.location);
    }

    @Override
    public void onFinish() {
        this.l.handleCommandCmdHistoryAddLocation(this);
    }

    @Override
    public void liHistoryResult(int n) {
        this.checkAnswerSum(2084);
    }
}

