/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.gateway.command;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.gateway.Command;
import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.asl.internal.navigation.gateway.command.NavGatewayListener;

public class CmdSetCountryForCityAndStreetHistory
extends Command {
    protected static final int TIMEOUT;
    public final String countryAbbreviation;
    public long liSetCountryForCityAndStreetHistoryResult_returnCode;

    public CmdSetCountryForCityAndStreetHistory(NavGatewayListener navGatewayListener, String string) {
        super(1098, 2057, navGatewayListener, 0);
        this.countryAbbreviation = string;
    }

    @Override
    protected void execute(INavGateway iNavGateway) {
        if (this.countryAbbreviation == null || "".equals(this.countryAbbreviation)) {
            ServiceManager.logger.error(16384).append("CmdSetCountryForCityAndStreetHistory called with empty country").log();
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().updateLiCityHistory(null, 2);
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().updateLiStreetHistory(null, 2);
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().updateLiCountryForCityAndStreetHistory("", 2);
            this.liSetCountryForCityAndStreetHistoryResult(-1);
        } else {
            iNavGateway.getDsiNavigation().liSetCountryForCityAndStreetHistory(this.countryAbbreviation);
        }
    }

    @Override
    public void onFinish() {
        this.l.handleCommandCmdSetCountryForCityAndStreetHistory(this);
    }

    @Override
    public void liSetCountryForCityAndStreetHistoryResult(int n) {
        ServiceManager.logger.warn(16384).append("CmdSetCountryForCityAndStreetHistoryResult.liSetCountryForCityAndStreetHistoryResult called").log();
        this.liSetCountryForCityAndStreetHistoryResult_returnCode = n;
        this.checkAnswerSum(2057);
    }
}

