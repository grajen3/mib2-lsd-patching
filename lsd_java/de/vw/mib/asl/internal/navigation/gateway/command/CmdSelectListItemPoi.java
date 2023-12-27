/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.gateway.command;

import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdAbstractSpeller;
import de.vw.mib.asl.internal.navigation.gateway.command.NavGatewayListener;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueList;

public class CmdSelectListItemPoi
extends CmdAbstractSpeller {
    public final int index;
    public NavLocation liCurrentState_liCurrentLD;
    public int[] liCurrentState_availableSelectionCriteria;
    public int[] liCurrentState_usefulRefinementCriteria;
    public long liCurrentState_returnCode;

    @Override
    public void poiValueList(LIValueList lIValueList, long l) {
        this.liValueList_lispValueList = lIValueList;
        this.liValueList_lispValueListCount = l;
        this.checkAnswerSum(2010);
    }

    public CmdSelectListItemPoi(NavGatewayListener navGatewayListener, int n) {
        super(1025, 4015, navGatewayListener);
        this.index = n;
    }

    @Override
    protected void execute(INavGateway iNavGateway) {
        iNavGateway.getDsiNavigation().lispSelectListItem(this.index);
    }

    @Override
    public void onFinish() {
        this.l.handleCommandCmdSelectListItemPoi(this);
    }
}

