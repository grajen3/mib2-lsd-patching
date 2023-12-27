/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.gateway.command;

import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdAbstractSpeller;
import de.vw.mib.asl.internal.navigation.gateway.command.NavGatewayListener;

public class CmdAddChar
extends CmdAbstractSpeller {
    public final String character;

    public CmdAddChar(NavGatewayListener navGatewayListener, String string) {
        super(1020, 6019, navGatewayListener);
        this.character = string;
    }

    @Override
    protected void execute(INavGateway iNavGateway) {
        iNavGateway.getDsiNavigation().lispAddCharacter(this.character);
    }

    @Override
    public void onFinish() {
        this.l.handleCommandCmdAddChar(this);
    }
}

