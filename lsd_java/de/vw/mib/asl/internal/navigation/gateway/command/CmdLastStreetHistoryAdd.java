/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.gateway.command;

import de.vw.mib.asl.internal.navigation.gateway.Command;
import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.asl.internal.navigation.gateway.command.NavGatewayListener;
import org.dsi.ifc.global.NavLocation;

public class CmdLastStreetHistoryAdd
extends Command {
    public final NavLocation street;
    public final String nameOfEntry;
    public long liLastCityAndStreetHistoryResult_returnCode;

    public CmdLastStreetHistoryAdd(NavGatewayListener navGatewayListener, NavLocation navLocation, String string) {
        super(1102, 2049, navGatewayListener);
        this.street = navLocation;
        this.nameOfEntry = string;
    }

    @Override
    protected void execute(INavGateway iNavGateway) {
        iNavGateway.getDsiNavigation().liLastStreetHistoryAdd(this.street, this.nameOfEntry);
    }

    @Override
    public void onFinish() {
        this.l.handleCommandCmdLastStreetHistoryAdd(this);
    }

    @Override
    public void liLastCityAndStreetHistoryResult(long l) {
        this.liLastCityAndStreetHistoryResult_returnCode = l;
        this.checkAnswerSum(2049);
    }
}

