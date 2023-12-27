/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.gateway.command;

import de.vw.mib.asl.internal.navigation.gateway.Command;
import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.asl.internal.navigation.gateway.command.NavGatewayListener;
import org.dsi.ifc.global.NavLocation;

public class CmdSetCurrentLD
extends Command {
    private NavLocation locDescID;
    public long liResult_ReturnCode;
    public NavLocation liCurrentState_liCurrentLD;
    public int[] liCurrentState_availableSelectionCriteria;
    public int[] liCurrentState_usefulRefinementCriteria;
    public long liCurrentState_returnCode;
    public boolean diLocationOverwriteFlag = false;

    public CmdSetCurrentLD(NavGatewayListener navGatewayListener, NavLocation navLocation) {
        super(1019, 4061, navGatewayListener);
        this.locDescID = navLocation;
    }

    public CmdSetCurrentLD(NavGatewayListener navGatewayListener, NavLocation navLocation, boolean bl) {
        this(navGatewayListener, navLocation);
        this.diLocationOverwriteFlag = bl;
    }

    @Override
    protected void execute(INavGateway iNavGateway) {
        iNavGateway.getDsiNavigation().liSetCurrentLD(this.locDescID);
    }

    @Override
    public void onFinish() {
        this.l.handleCommandCmdSetCurrentLD(this);
    }

    @Override
    public void liResult(long l) {
        this.liResult_ReturnCode = l;
        if (l != 0L) {
            this.commonErrorString = new StringBuffer().append(this.commonErrorString).append(" liResult(").append(l).append(") ").toString();
            this.checkAnswerSum(this.getAnswerSum() + 3);
        } else {
            this.checkAnswerSum(2005);
        }
    }

    @Override
    public void liCurrentState(NavLocation navLocation, int[] nArray, int[] nArray2, long l) {
        this.liCurrentState_liCurrentLD = navLocation;
        this.liCurrentState_availableSelectionCriteria = nArray;
        this.liCurrentState_usefulRefinementCriteria = nArray2;
        this.liCurrentState_returnCode = l;
        this.checkAnswerSum(2056);
    }
}

