/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.gateway.command;

import de.vw.mib.asl.internal.navigation.gateway.Command;
import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.asl.internal.navigation.gateway.command.NavGatewayListener;
import org.dsi.ifc.global.NavLocation;

public class CmdLastCityHistoryAdd
extends Command {
    protected static final int TIMEOUT;
    public final NavLocation city;
    public final boolean hasStreets;
    public final String nameOfEntry;
    public long liLastCityAndStreetHistoryResult_returnCode;

    public CmdLastCityHistoryAdd(NavGatewayListener navGatewayListener, NavLocation navLocation, boolean bl, String string) {
        super(1100, 2049, navGatewayListener, 0);
        this.city = navLocation;
        this.hasStreets = bl;
        this.nameOfEntry = string;
    }

    @Override
    protected void execute(INavGateway iNavGateway) {
        iNavGateway.getDsiNavigation().liLastCityHistoryAdd(this.city, this.hasStreets, this.nameOfEntry);
    }

    @Override
    public void onFinish() {
        this.l.handleCommandCmdLastCityHistoryAdd(this);
    }

    @Override
    public void liLastCityAndStreetHistoryResult(long l) {
        this.liLastCityAndStreetHistoryResult_returnCode = l;
        this.checkAnswerSum(2049);
    }
}

