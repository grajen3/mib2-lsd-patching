/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.gateway.command;

import de.vw.mib.asl.internal.navigation.gateway.Command;
import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.asl.internal.navigation.gateway.command.NavGatewayListener;
import org.dsi.ifc.global.NavLocation;

public class CmdGetLastCityHistoryEntry
extends Command {
    public final long id;
    public NavLocation liGetLastCityHistoryEntryResult_matchedLocation;
    public boolean liGetLastCityHistoryEntryResult_entryUnchanged;

    public CmdGetLastCityHistoryEntry(NavGatewayListener navGatewayListener, long l) {
        super(1099, 2048, navGatewayListener);
        this.id = l;
    }

    @Override
    protected void execute(INavGateway iNavGateway) {
        iNavGateway.getDsiNavigation().liGetLastCityHistoryEntry(this.id);
    }

    @Override
    public void onFinish() {
        this.l.handleCommandCmdGetLastCityHistoryEntry(this);
    }

    @Override
    public void liGetLastCityHistoryEntryResult(NavLocation navLocation, boolean bl) {
        this.liGetLastCityHistoryEntryResult_matchedLocation = navLocation;
        this.liGetLastCityHistoryEntryResult_entryUnchanged = bl;
        this.checkAnswerSum(2048);
    }
}

