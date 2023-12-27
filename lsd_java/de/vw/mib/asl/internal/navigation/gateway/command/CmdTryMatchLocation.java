/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.gateway.command;

import de.vw.mib.asl.internal.navigation.gateway.Command;
import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.asl.internal.navigation.gateway.command.NavGatewayListener;
import org.dsi.ifc.navigation.TryMatchLocationData;
import org.dsi.ifc.navigation.TryMatchLocationResultData;

public class CmdTryMatchLocation
extends Command {
    private TryMatchLocationData tmlData;
    public TryMatchLocationResultData[] liTryMatchLocationResult_result;
    public long liResult_ReturnCode;

    public CmdTryMatchLocation(NavGatewayListener navGatewayListener, TryMatchLocationData tryMatchLocationData) {
        super(1174, 4091, navGatewayListener, 0);
        this.tmlData = tryMatchLocationData;
    }

    @Override
    protected void execute(INavGateway iNavGateway) {
        iNavGateway.getDsiNavigation().liTryMatchLocation(this.tmlData);
    }

    @Override
    public void onFinish() {
        this.l.handleCommandCmdTryMatchLocation(this);
    }

    @Override
    public void liResult(long l) {
        this.liResult_ReturnCode = l;
        this.checkAnswerSum(2005);
    }

    @Override
    public void liTryMatchLocationResult(TryMatchLocationResultData[] tryMatchLocationResultDataArray) {
        this.liTryMatchLocationResult_result = tryMatchLocationResultDataArray;
        this.checkAnswerSum(2086);
    }
}

