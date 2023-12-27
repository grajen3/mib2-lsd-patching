/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.gateway.command;

import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdAbstractSpeller;
import de.vw.mib.asl.internal.navigation.gateway.command.NavGatewayListener;

public class CmdStartSpeller
extends CmdAbstractSpeller {
    private static final int START_SPELLER_TIMEOUT;
    private final int selectionCriterion;
    private final boolean removeZipCode;
    private final boolean removeTown;
    private final boolean removeStreet;

    public CmdStartSpeller(NavGatewayListener navGatewayListener, int n, boolean bl, boolean bl2, boolean bl3) {
        super(1029, 6019, navGatewayListener, 30000);
        this.selectionCriterion = n;
        this.removeZipCode = bl;
        this.removeTown = bl2;
        this.removeStreet = bl3;
        this.commonErrorString = new StringBuffer().append("StartSpeller(").append(n).append(",").append(bl).append(",").append(bl2).append(",").append(bl3).append(")").toString();
    }

    @Override
    public void execute(INavGateway iNavGateway) {
        iNavGateway.getDsiNavigation().liStartSpeller(this.selectionCriterion, this.removeZipCode, this.removeTown, this.removeStreet);
    }

    @Override
    public void onFinish() {
        this.l.handleCommandCmdStartSpeller(this);
    }
}

