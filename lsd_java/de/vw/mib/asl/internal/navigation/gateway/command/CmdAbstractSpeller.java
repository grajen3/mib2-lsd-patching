/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.gateway.command;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.gateway.Command;
import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.asl.internal.navigation.gateway.command.NavGatewayListener;
import org.dsi.ifc.navigation.LIValueList;

public abstract class CmdAbstractSpeller
extends Command {
    long timeExecuted;
    long timeFinished;
    public long liResult_ReturnCode = 1L;
    public String lispUpdateSpellerResult_lispCurrentInput;
    public int lispUpdateSpellerResult_lispCurrentSelectionCriterion;
    public boolean lispUpdateSpellerResult_lispIsFullMatch;
    public boolean lispUpdateSpellerResult_lispIsUndoAvailable;
    public String lispUpdateSpellerResult_lispValidCharacters;
    public int lispUpdateSpellerResult_lispMultiCriteriaCriterion1;
    public int lispUpdateSpellerResult_lispMultiCriteriaCriterion2;
    public boolean lispUpdateSpellerResult_lispMultiCriteriaIsActive;
    public boolean lispUpdateSpellerResult_lispMultiCriteriaIsAmbiguous;
    public int lispUpdateSpellerResult_lispInputFormat;
    public long lispUpdateSpellerResult_returnCode;
    public LIValueList liValueList_lispValueList;
    public long liValueList_lispValueListCount = 0L;

    @Override
    protected void execute(INavGateway iNavGateway) {
        this.timeExecuted = ServiceManager.timerManager.getSystemTimeMillis();
    }

    @Override
    public void lispUpdateSpellerResult(String string, int n, boolean bl, boolean bl2, String string2, int n2, int n3, boolean bl3, boolean bl4, int n4, long l) {
        this.lispUpdateSpellerResult_lispCurrentInput = string;
        this.lispUpdateSpellerResult_lispCurrentSelectionCriterion = n;
        this.lispUpdateSpellerResult_lispIsFullMatch = bl;
        this.lispUpdateSpellerResult_lispIsUndoAvailable = bl2;
        this.lispUpdateSpellerResult_lispValidCharacters = string2;
        this.lispUpdateSpellerResult_lispMultiCriteriaCriterion1 = n2;
        this.lispUpdateSpellerResult_lispMultiCriteriaCriterion2 = n3;
        this.lispUpdateSpellerResult_lispMultiCriteriaIsActive = bl3;
        this.lispUpdateSpellerResult_lispMultiCriteriaIsAmbiguous = bl4;
        this.lispUpdateSpellerResult_lispInputFormat = n4;
        this.lispUpdateSpellerResult_returnCode = l;
        this.checkAnswerSum(2006);
    }

    @Override
    public void onFinish() {
    }

    public CmdAbstractSpeller(int n, int n2, NavGatewayListener navGatewayListener) {
        super(n, n2, navGatewayListener);
    }

    public CmdAbstractSpeller(int n, int n2, NavGatewayListener navGatewayListener, int n3) {
        super(n, n2, navGatewayListener, n3);
    }

    @Override
    public void liResult(long l) {
        this.liResult_ReturnCode = l;
        if (l != 0L) {
            this.commonErrorString = new StringBuffer().append(this.commonErrorString).append(" liResult(").append(l).append(") ").toString();
            this.checkAnswerSum(this.getAnswerSum() + 3);
        } else {
            this.checkAnswerSum(2005);
        }
    }

    @Override
    public void lispUpdateSpellerResult(String string, int n, boolean bl, boolean bl2, String string2, int n2, int n3, boolean bl3, boolean bl4, long l) {
        this.lispUpdateSpellerResult_lispCurrentInput = string;
        this.lispUpdateSpellerResult_lispCurrentSelectionCriterion = n;
        this.lispUpdateSpellerResult_lispIsFullMatch = bl;
        this.lispUpdateSpellerResult_lispIsUndoAvailable = bl2;
        this.lispUpdateSpellerResult_lispValidCharacters = string2;
        this.lispUpdateSpellerResult_lispMultiCriteriaCriterion1 = n2;
        this.lispUpdateSpellerResult_lispMultiCriteriaCriterion2 = n3;
        this.lispUpdateSpellerResult_lispMultiCriteriaIsActive = bl3;
        this.lispUpdateSpellerResult_lispMultiCriteriaIsAmbiguous = bl4;
        this.lispUpdateSpellerResult_returnCode = l;
        this.checkAnswerSum(2006);
    }

    @Override
    public void liValueList(LIValueList lIValueList, long l) {
        this.liValueList_lispValueList = lIValueList;
        this.liValueList_lispValueListCount = l;
        this.checkAnswerSum(2008);
    }
}

