/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.gateway.command;

import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdAbstractSpeller;
import de.vw.mib.asl.internal.navigation.gateway.command.NavGatewayListener;
import org.dsi.ifc.global.NavLocation;

public class CmdSelectListItemByIdent
extends CmdAbstractSpeller {
    public final String ident;
    public NavLocation liCurrentState_liCurrentLD;
    public int[] liCurrentState_availableSelectionCriteria;
    public int[] liCurrentState_usefulRefinementCriteria;
    public long liCurrentState_returnCode;

    public CmdSelectListItemByIdent(NavGatewayListener navGatewayListener, String string) {
        super(1154, 4061, navGatewayListener);
        this.ident = string;
    }

    @Override
    protected void execute(INavGateway iNavGateway) {
        iNavGateway.getDsiNavigation().lispSelectListItemByIdent(this.ident);
    }

    @Override
    public void onFinish() {
        this.l.handleCommandCmdSelectListItemByIdent(this);
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

