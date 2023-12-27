/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.gateway.command;

import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdAbstractSpeller;
import de.vw.mib.asl.internal.navigation.gateway.command.NavGatewayListener;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LISpellerData;

public class CmdRestoreState
extends CmdAbstractSpeller {
    private LISpellerData spellerState;
    public NavLocation liCurrentState_liCurrentLD;
    public int[] liCurrentState_availableSelectionCriteria;
    public int[] liCurrentState_usefulRefinementCriteria;
    public long liCurrentState_returnCode;

    public CmdRestoreState(NavGatewayListener navGatewayListener, LISpellerData lISpellerData) {
        super(1018, 8075, navGatewayListener);
        this.spellerState = lISpellerData;
    }

    @Override
    protected void execute(INavGateway iNavGateway) {
        iNavGateway.getDsiNavigation().liRestoreState(this.spellerState);
    }

    @Override
    public void onFinish() {
        this.l.handleCommandCmdRestoreState(this);
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

