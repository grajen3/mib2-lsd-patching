/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.gateway.command;

import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdAbstractSpeller;
import de.vw.mib.asl.internal.navigation.gateway.command.NavGatewayListener;

public class CmdSetInput
extends CmdAbstractSpeller {
    String input;
    boolean autoSelectInput;

    public CmdSetInput(NavGatewayListener navGatewayListener, String string, boolean bl) {
        super(1026, 6019, navGatewayListener);
        this.input = string;
        this.autoSelectInput = bl;
    }

    @Override
    protected void execute(INavGateway iNavGateway) {
        iNavGateway.getDsiNavigation().lispSetInput(this.input, this.autoSelectInput);
    }

    @Override
    public void onFinish() {
        this.l.handleCommandCmdSetInput(this);
    }

    public boolean getAutoSelectInput() {
        return this.autoSelectInput;
    }
}

