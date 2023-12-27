/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.gateway.command;

import de.vw.mib.asl.internal.navigation.gateway.Command;
import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.asl.internal.navigation.gateway.command.NavGatewayListener;
import org.dsi.ifc.global.NavLocation;

public class CmdPoiGetXt9LDBs
extends Command {
    private NavLocation navLocation;
    private int mode = -1;
    public String[] poiGetXt9LdbResult_xt9Databases;

    public CmdPoiGetXt9LDBs(NavGatewayListener navGatewayListener, NavLocation navLocation, int n) {
        super(1194, 2099, navGatewayListener);
        this.navLocation = navLocation;
        this.mode = n;
    }

    @Override
    protected void execute(INavGateway iNavGateway) {
        iNavGateway.getDsiNavigation().poiGetXt9LDBs(this.navLocation, this.mode);
    }

    @Override
    public void onFinish() {
        this.l.handleCommandCmdPoiGetXt9LDBs(this);
    }

    @Override
    public void poiGetXt9LDBsResult(String[] stringArray) {
        this.poiGetXt9LdbResult_xt9Databases = stringArray;
        this.checkAnswerSum(2099);
    }
}

