/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.gateway.command;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdAbstractSpeller;
import de.vw.mib.asl.internal.navigation.gateway.command.NavGatewayListener;

public class CmdGetMatchingNVC
extends CmdAbstractSpeller {
    private static final int START_SPELLER_TIMEOUT;
    private final String predictedNvc;
    public String validNvc = "";

    public CmdGetMatchingNVC(NavGatewayListener navGatewayListener, String string) {
        super(1192, 2094, navGatewayListener, 30000);
        this.predictedNvc = string;
        this.commonErrorString = new StringBuffer("lispGetMatchingNVC(").append(string).append(")").toString();
    }

    @Override
    public void execute(INavGateway iNavGateway) {
        iNavGateway.getDsiNavigation().lispGetMatchingNVC(this.predictedNvc);
    }

    @Override
    public void onFinish() {
        this.l.handleCommandCmdGetMatchingNVC(this);
    }

    public String getPredictedNvc() {
        return this.predictedNvc;
    }

    @Override
    public void lispGetMatchingNVCResult(String string) {
        ServiceManager.logger.warn(16384).append("CmdGetMatchingNVC.lispGetMatchingNVCResult -> Returned NVC: ").append(string).log();
        this.validNvc = string;
        this.checkAnswerSum(2094);
    }
}

