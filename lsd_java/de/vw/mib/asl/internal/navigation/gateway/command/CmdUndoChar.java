/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.gateway.command;

import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdAbstractSpeller;
import de.vw.mib.asl.internal.navigation.gateway.command.NavGatewayListener;

public class CmdUndoChar
extends CmdAbstractSpeller {
    public CmdUndoChar(NavGatewayListener navGatewayListener) {
        super(1027, 6019, navGatewayListener);
    }

    @Override
    protected void execute(INavGateway iNavGateway) {
        iNavGateway.getDsiNavigation().lispUndoCharacter();
    }

    @Override
    public void onFinish() {
        this.l.handleCommandCmdUndoChar(this);
    }
}

