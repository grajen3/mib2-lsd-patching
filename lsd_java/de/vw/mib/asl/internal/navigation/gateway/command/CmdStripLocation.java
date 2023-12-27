/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.gateway.command;

import de.vw.mib.asl.internal.navigation.gateway.Command;
import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.asl.internal.navigation.gateway.command.NavGatewayListener;
import org.dsi.ifc.global.NavLocation;

public class CmdStripLocation
extends Command {
    private NavLocation location;
    private int type;
    public NavLocation liStripLocationResult_location;
    public boolean diLocationOverwriteFlag = false;

    public CmdStripLocation(NavGatewayListener navGatewayListener, NavLocation navLocation, int n) {
        super(1112, 2053, navGatewayListener);
        this.location = navLocation;
        this.type = n;
    }

    public CmdStripLocation(NavGatewayListener navGatewayListener, NavLocation navLocation, int n, boolean bl) {
        this(navGatewayListener, navLocation, n);
        this.diLocationOverwriteFlag = bl;
    }

    @Override
    protected void execute(INavGateway iNavGateway) {
        iNavGateway.getDsiNavigation().liStripLocation(this.location, this.type);
    }

    @Override
    public void onFinish() {
        this.l.handleCommandCmdStripLocation(this);
    }

    @Override
    public void liStripLocationResult(NavLocation navLocation) {
        this.liStripLocationResult_location = navLocation;
        this.checkAnswerSum(2053);
    }
}

