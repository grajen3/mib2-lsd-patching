/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.gateway.command;

import de.vw.mib.asl.internal.navigation.gateway.Command;
import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.asl.internal.navigation.gateway.command.NavGatewayListener;
import org.dsi.ifc.global.NavLocation;

public class CmdGetLastStreetHistoryEntry
extends Command {
    public final long id;
    public NavLocation liGetLastStreetHistoryEntryResult_matchedLocation;
    public boolean liGetLastStreetHistoryEntryResult_entryUnchanged;

    public CmdGetLastStreetHistoryEntry(NavGatewayListener navGatewayListener, long l) {
        super(1120, 2055, navGatewayListener);
        this.id = l;
    }

    @Override
    protected void execute(INavGateway iNavGateway) {
        iNavGateway.getDsiNavigation().liGetLastStreetHistoryEntry(this.id);
    }

    @Override
    public void onFinish() {
        this.l.handleCommandCmdGetLastStreetHistoryEntry(this);
    }

    @Override
    public void liGetLastStreetHistoryEntryResult(NavLocation navLocation, boolean bl) {
        this.liGetLastStreetHistoryEntryResult_matchedLocation = navLocation;
        this.liGetLastStreetHistoryEntryResult_entryUnchanged = bl;
        this.checkAnswerSum(2055);
    }
}

