/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.gateway.command;

import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdAbstractSpeller;
import de.vw.mib.asl.internal.navigation.gateway.command.NavGatewayListener;

public class CmdSetLiValueListWindowSize
extends CmdAbstractSpeller {
    private static final int START_SPELLER_TIMEOUT;
    private final int windowSize;

    public CmdSetLiValueListWindowSize(NavGatewayListener navGatewayListener, int n) {
        super(1172, 2005, navGatewayListener, 30000);
        this.windowSize = n;
        this.commonErrorString = new StringBuffer("SetLiValueListSize(").append(n).append(")").toString();
    }

    @Override
    public void execute(INavGateway iNavGateway) {
        iNavGateway.getDsiNavigation().liValueListWindowSize(this.windowSize);
    }

    @Override
    public void onFinish() {
        this.l.handleCommandCmdSetLiValueListWindowSize(this);
    }

    public int getWindowSize() {
        return this.windowSize;
    }
}

