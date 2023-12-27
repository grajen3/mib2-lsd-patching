/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.gateway.command;

import de.vw.mib.asl.internal.navigation.gateway.Command;
import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.asl.internal.navigation.gateway.command.NavGatewayListener;
import org.dsi.ifc.navigation.NavPhoneData;
import org.dsi.ifc.navigation.TryBestMatchData;
import org.dsi.ifc.navigation.TryBestMatchResultData;

public class CmdTryBestMatch
extends Command {
    private TryBestMatchData tbmData;
    public TryBestMatchResultData[] liTryBestMatchResult_result;
    public long liResult_ReturnCode;

    public CmdTryBestMatch(NavGatewayListener navGatewayListener, TryBestMatchData tryBestMatchData) {
        super(1063, 4025, navGatewayListener, 0);
        this.tbmData = tryBestMatchData;
        if (this.tbmData.getPhoneNumbers() == null) {
            this.tbmData.phoneNumbers = new NavPhoneData[0];
        }
    }

    @Override
    protected void execute(INavGateway iNavGateway) {
        iNavGateway.getDsiNavigation().liTryBestMatch(this.tbmData);
    }

    @Override
    public void onFinish() {
        this.l.handleCommandCmdTryBestMatch(this);
    }

    @Override
    public void liResult(long l) {
        this.liResult_ReturnCode = l;
        this.checkAnswerSum(2005);
    }

    @Override
    public void liTryBestMatchResult(TryBestMatchResultData[] tryBestMatchResultDataArray) {
        this.liTryBestMatchResult_result = tryBestMatchResultDataArray;
        this.checkAnswerSum(2020);
    }
}

