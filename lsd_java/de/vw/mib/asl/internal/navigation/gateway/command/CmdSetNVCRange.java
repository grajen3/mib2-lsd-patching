/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.gateway.command;

import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdAbstractSpeller;
import de.vw.mib.asl.internal.navigation.gateway.command.NavGatewayListener;

public class CmdSetNVCRange
extends CmdAbstractSpeller {
    private static final int START_SPELLER_TIMEOUT;
    private final int range;

    public CmdSetNVCRange(NavGatewayListener navGatewayListener, int n) {
        super(1191, 2005, navGatewayListener, 30000);
        this.range = n;
        this.commonErrorString = new StringBuffer("liSetNVCRange(").append(n).append(")").toString();
    }

    @Override
    public void execute(INavGateway iNavGateway) {
        iNavGateway.getDsiNavigation().liSetNVCRange(this.range);
    }

    @Override
    public void onFinish() {
        this.l.handleCommandCmdSetNVCRange(this);
    }

    public int getRange() {
        return this.range;
    }
}

