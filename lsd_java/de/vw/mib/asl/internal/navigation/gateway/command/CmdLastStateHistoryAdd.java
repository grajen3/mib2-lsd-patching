/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.gateway.command;

import de.vw.mib.asl.internal.navigation.gateway.Command;
import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.asl.internal.navigation.gateway.command.NavGatewayListener;
import org.dsi.ifc.global.NavLocation;

public class CmdLastStateHistoryAdd
extends Command {
    protected static final int TIMEOUT;
    public final NavLocation state;
    public final boolean hasCities;
    public final String nameOfEntry;
    public long returnCode;

    public CmdLastStateHistoryAdd(NavGatewayListener navGatewayListener, NavLocation navLocation, boolean bl, String string) {
        super(1162, 2084, navGatewayListener, 0);
        this.state = navLocation;
        this.hasCities = bl;
        this.nameOfEntry = string;
    }

    @Override
    protected void execute(INavGateway iNavGateway) {
        iNavGateway.getDsiNavigation().liLastCityHistoryAdd(this.state, this.hasCities, this.nameOfEntry);
    }

    @Override
    public void onFinish() {
        this.l.handleCommandCmdLastStateHistoryAdd(this);
    }

    @Override
    public void liLastCityAndStreetHistoryResult(long l) {
        this.returnCode = l;
        this.checkAnswerSum(2084);
    }
}

