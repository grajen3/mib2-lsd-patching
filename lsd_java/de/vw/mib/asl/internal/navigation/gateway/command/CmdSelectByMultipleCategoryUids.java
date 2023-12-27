/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.gateway.command;

import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdAbstractSpeller;
import de.vw.mib.asl.internal.navigation.gateway.command.NavGatewayListener;
import org.dsi.ifc.navigation.LIValueList;

public class CmdSelectByMultipleCategoryUids
extends CmdAbstractSpeller {
    public final int[] categoryUids;

    @Override
    public void poiValueList(LIValueList lIValueList, long l) {
        this.liValueList_lispValueList = lIValueList;
        this.liValueList_lispValueListCount = l;
        this.checkAnswerSum(2010);
    }

    public CmdSelectByMultipleCategoryUids(NavGatewayListener navGatewayListener, int[] nArray) {
        super(1169, 4015, navGatewayListener);
        this.categoryUids = nArray;
    }

    @Override
    protected void execute(INavGateway iNavGateway) {
        iNavGateway.getDsiNavigation().lispSelectByMultipleCategoryUids(this.categoryUids);
    }

    @Override
    public void onFinish() {
        this.l.handleCommandCmdSelectByMultipleCategoryUids(this);
    }
}

