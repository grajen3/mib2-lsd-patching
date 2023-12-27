/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.gateway.command;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdAbstractSpeller;
import de.vw.mib.asl.internal.navigation.gateway.command.NavGatewayListener;

public class CmdRequestValueListByListIndex
extends CmdAbstractSpeller {
    private int anchorIndex;
    private boolean nextPage;

    public int getAnchorIndex() {
        return this.anchorIndex;
    }

    public CmdRequestValueListByListIndex(NavGatewayListener navGatewayListener, int n, boolean bl) {
        super(1109, 6019, navGatewayListener);
        this.anchorIndex = n;
        this.nextPage = bl;
        ServiceManager.logger.trace(16384, new StringBuffer().append("CmdRequestValueListByListIndex(").append(n).append(",").append(bl).append(")").toString());
    }

    @Override
    protected void execute(INavGateway iNavGateway) {
        iNavGateway.getDsiNavigation().lispRequestValueListByListIndex(this.anchorIndex, this.nextPage);
    }

    @Override
    public void onFinish() {
        this.l.handleCommandCmdRequestValueListByListIndex(this);
    }
}

