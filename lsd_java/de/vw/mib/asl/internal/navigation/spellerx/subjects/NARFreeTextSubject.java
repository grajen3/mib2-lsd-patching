/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.spellerx.subjects;

import de.vw.mib.asl.api.navigation.locationinput.ISpellerContext;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdLiGetState;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSetInput;
import de.vw.mib.asl.internal.navigation.spellerx.XSpellerTarget;
import de.vw.mib.asl.internal.navigation.spellerx.model.ModelListHandler;
import de.vw.mib.asl.internal.navigation.spellerx.subjects.NavReflectionSubject;
import de.vw.mib.asl.internal.navigation.spellerx.util.FreeTextSubjectUtil;

public class NARFreeTextSubject
extends NavReflectionSubject {
    private XSpellerTarget target;
    private ModelListHandler list;
    private FreeTextSubjectUtil freeTextUtil = new FreeTextSubjectUtil();

    public NARFreeTextSubject(XSpellerTarget xSpellerTarget, int n, int n2, ModelListHandler modelListHandler, ModelListHandler modelListHandler2, int n3, boolean bl, boolean bl2, boolean bl3) {
        super(xSpellerTarget);
        this.target = xSpellerTarget;
        this.list = modelListHandler;
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILTER(ISpellerContext iSpellerContext) {
        String string = this.target.getSpellerContext().getActiveField().getSpellerData().getEnteredText();
        new CmdSetInput(this, string, false).execute();
    }

    public void evtEV_SET_INPUT(ISpellerContext iSpellerContext, String string) {
        this.freeTextUtil.makeTraceComment(this.target, new StringBuffer("NARFREETEXTSUBJECT:evtEV_SET_INPUT: Setting string: ").append(string).toString());
        new CmdSetInput(this, string, false).execute();
    }

    @Override
    public void handleCommandCmdSetInput(CmdSetInput cmdSetInput) {
        if (!this.freeTextUtil.areCmdSetInputReturnValuesCorrect(cmdSetInput)) {
            return;
        }
        this.freeTextUtil.updateHouseNumberSubTypeForNARAndEU(this.target, cmdSetInput.liValueList_lispValueList.list.length, cmdSetInput);
        this.target.getSpellerContext().getActiveField().getSpellerData().setEnteredText(cmdSetInput.lispUpdateSpellerResult_lispCurrentInput);
        this.target.getSpellerContext().getActiveField().getSpellerData().setCursorPosition(this.target.getSpellerContext().getActiveField().getSpellerData().getEnteredText().length());
        this.list.updateItems(cmdSetInput.liValueList_lispValueList, cmdSetInput.liValueList_lispValueListCount, cmdSetInput.lispUpdateSpellerResult_lispCurrentInput);
        this.freeTextUtil.updateActionResultPositively();
    }

    @Override
    public void handleCommandCmdLiGetState(CmdLiGetState cmdLiGetState) {
        this.freeTextUtil.makeTraceComment(this.target, "Storing speller (using DSI)...");
        this.target.getSpellerContext().getActiveField().setDSIState(cmdLiGetState.liGetStateResult_spellerState);
    }
}

