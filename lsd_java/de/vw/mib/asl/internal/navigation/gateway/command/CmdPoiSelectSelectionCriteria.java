/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.gateway.command;

import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdAbstractSpeller;
import de.vw.mib.asl.internal.navigation.gateway.command.NavGatewayListener;

public class CmdPoiSelectSelectionCriteria
extends CmdAbstractSpeller {
    public final int index;

    public CmdPoiSelectSelectionCriteria(NavGatewayListener navGatewayListener, int n) {
        super(1040, 6019, navGatewayListener);
        this.index = n;
    }

    @Override
    protected void execute(INavGateway iNavGateway) {
        iNavGateway.getDsiNavigation().poiSelectSelectionCriteria(this.index);
    }

    @Override
    public void onFinish() {
        this.l.handleCommandCmdPoiSelectSelectionCriteria(this);
    }
}

