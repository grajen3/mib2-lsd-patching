/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.gateway.command;

import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdAbstractSpeller;
import de.vw.mib.asl.internal.navigation.gateway.command.NavGatewayListener;
import org.dsi.ifc.global.NavLocation;

public class CmdSelectListItem
extends CmdAbstractSpeller {
    protected static final int TIMEOUT;
    private final int index;
    public NavLocation liCurrentState_liCurrentLD;
    public int[] liCurrentState_availableSelectionCriteria;
    public int[] liCurrentState_usefulRefinementCriteria;
    public long liCurrentState_returnCode;
    private int maxIndex;

    public CmdSelectListItem(NavGatewayListener navGatewayListener, int n) {
        this(navGatewayListener, n, n);
    }

    public CmdSelectListItem(NavGatewayListener navGatewayListener, int n, int n2) {
        super(1025, 4061, navGatewayListener, 30000);
        this.index = n;
        this.setMaxIndex(n2);
    }

    @Override
    protected void execute(INavGateway iNavGateway) {
        iNavGateway.getDsiNavigation().lispSelectListItem(this.getIndex());
    }

    @Override
    public void onFinish() {
        this.l.handleCommandCmdSelectListItem(this);
    }

    @Override
    public void liCurrentState(NavLocation navLocation, int[] nArray, int[] nArray2, long l) {
        this.liCurrentState_liCurrentLD = navLocation;
        this.liCurrentState_availableSelectionCriteria = nArray;
        this.liCurrentState_usefulRefinementCriteria = nArray2;
        this.liCurrentState_returnCode = l;
        this.checkAnswerSum(2056);
    }

    public int getMaxIndex() {
        return this.maxIndex;
    }

    void setMaxIndex(int n) {
        this.maxIndex = n;
    }

    public int getIndex() {
        return this.index;
    }
}

