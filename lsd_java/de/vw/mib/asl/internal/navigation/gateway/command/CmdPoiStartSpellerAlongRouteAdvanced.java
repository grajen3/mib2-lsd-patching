/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.gateway.command;

import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdAbstractSpeller;
import de.vw.mib.asl.internal.navigation.gateway.command.NavGatewayListener;

public class CmdPoiStartSpellerAlongRouteAdvanced
extends CmdAbstractSpeller {
    private final int selectionCriterion;
    private final long corridor;
    private final long length;
    private final long offset;
    private final boolean reverse;

    public CmdPoiStartSpellerAlongRouteAdvanced(NavGatewayListener navGatewayListener, int n, long l, long l2, long l3, boolean bl) {
        super(1170, 6019, navGatewayListener);
        this.selectionCriterion = n;
        this.corridor = l;
        this.length = l2;
        this.offset = l3;
        this.reverse = bl;
    }

    @Override
    public void execute(INavGateway iNavGateway) {
        iNavGateway.getDsiNavigation().poiStartSpellerAlongRouteAdvanced(this.selectionCriterion, this.corridor, this.length, this.offset, this.reverse);
    }

    @Override
    public void onFinish() {
        this.l.handleCommandCmdPoiStartSpellerAlongRouteAdvanced(this);
    }
}

