/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.gateway.command;

import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdAbstractSpeller;
import de.vw.mib.asl.internal.navigation.gateway.command.NavGatewayListener;
import org.dsi.ifc.navigation.LIValueList;

public class CmdSelectByCategoryUid
extends CmdAbstractSpeller {
    public final int categoryUid;

    @Override
    public void poiValueList(LIValueList lIValueList, long l) {
        this.liValueList_lispValueList = lIValueList;
        this.liValueList_lispValueListCount = l;
        this.checkAnswerSum(2010);
    }

    public CmdSelectByCategoryUid(NavGatewayListener navGatewayListener, int n) {
        super(1142, 4015, navGatewayListener);
        this.categoryUid = n;
    }

    @Override
    protected void execute(INavGateway iNavGateway) {
        iNavGateway.getDsiNavigation().lispSelectByCategoryUid(this.categoryUid);
    }

    @Override
    public void onFinish() {
        this.l.handleCommandCmdSelectByCategoryUid(this);
    }
}

