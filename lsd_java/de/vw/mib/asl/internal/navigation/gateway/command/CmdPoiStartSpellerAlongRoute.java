/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.gateway.command;

import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdAbstractSpeller;
import de.vw.mib.asl.internal.navigation.gateway.command.NavGatewayListener;

public class CmdPoiStartSpellerAlongRoute
extends CmdAbstractSpeller {
    private final int selectionCriterion;
    private final long corridor;
    private final long length;

    public CmdPoiStartSpellerAlongRoute(NavGatewayListener navGatewayListener, int n, long l, long l2) {
        super(1038, 6019, navGatewayListener);
        this.selectionCriterion = n;
        this.corridor = l;
        this.length = l2;
    }

    @Override
    public void execute(INavGateway iNavGateway) {
        iNavGateway.getDsiNavigation().poiStartSpellerAlongRoute(this.selectionCriterion, this.corridor, this.length);
    }

    @Override
    public void onFinish() {
        this.l.handleCommandCmdPoiStartSpellerAlongRoute(this);
    }
}

