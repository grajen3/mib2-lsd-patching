/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.gateway.command;

import de.vw.mib.asl.internal.navigation.gateway.Command;
import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.asl.internal.navigation.gateway.command.NavGatewayListener;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueListElement;

public class CmdGetLocationFromLiValueListElement
extends Command {
    public NavLocation lispGetLocationFromLiValueListElement_location;
    public LIValueListElement liValueListElement;

    public CmdGetLocationFromLiValueListElement(NavGatewayListener navGatewayListener, LIValueListElement lIValueListElement) {
        super(1193, 4100, navGatewayListener);
        this.liValueListElement = lIValueListElement;
    }

    @Override
    protected void execute(INavGateway iNavGateway) {
        iNavGateway.getDsiNavigation().lispGetLocationFromLiValueListElement(this.liValueListElement.listIndex);
    }

    @Override
    public void onFinish() {
        this.l.handleCommandCmdGetLocationFromLiValueListElement(this);
    }

    @Override
    public void liResult(long l) {
        this.checkAnswerSum(2005);
    }

    @Override
    public void lispGetLocationFromLiValueListResult(int n, NavLocation navLocation) {
        this.lispGetLocationFromLiValueListElement_location = navLocation;
        this.checkAnswerSum(2095);
    }
}

