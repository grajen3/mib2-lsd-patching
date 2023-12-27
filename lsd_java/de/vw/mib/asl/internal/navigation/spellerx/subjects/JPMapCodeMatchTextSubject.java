/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.spellerx.subjects;

import de.vw.mib.asl.api.navigation.locationinput.ISpellerContext;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdAbstractSpeller;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdAddChar;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdLiGetState;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdRequestValueListByListIndex;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdRestoreState;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSelectListItem;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSetInput;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSetLiValueListWindowSize;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdStartSpeller;
import de.vw.mib.asl.internal.navigation.spellerx.SpellerContext;
import de.vw.mib.asl.internal.navigation.spellerx.XSpellerTarget;
import de.vw.mib.asl.internal.navigation.spellerx.model.ModelListHandler;
import de.vw.mib.asl.internal.navigation.spellerx.model.ModelUpdater;
import de.vw.mib.asl.internal.navigation.spellerx.states.StateMapCode;
import de.vw.mib.asl.internal.navigation.spellerx.subjects.NavReflectionSubject;
import de.vw.mib.asl.internal.navigation.spellerx.util.DataHelper;
import de.vw.mib.asl.internal.navigation.spellerx.util.HnrFlagsImpl;
import de.vw.mib.asl.internal.navigation.spellerx.util.MatchTextSubjectUtil;
import de.vw.mib.properties.values.SpellerData;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LISpellerData;

public class JPMapCodeMatchTextSubject
extends NavReflectionSubject {
    private int charEnteredConst;
    private int inputFieldReadyConst;
    private XSpellerTarget target;
    private ModelListHandler list;
    private int selectionCriterion;
    private boolean removeStreet;
    private boolean removeTown;
    private boolean removeZipCode;
    private String enteredString = "";
    private MatchTextSubjectUtil mtsUtil = new MatchTextSubjectUtil();
    private LISpellerData spellerData;

    public JPMapCodeMatchTextSubject(XSpellerTarget xSpellerTarget, int n, int n2, ModelListHandler modelListHandler, ModelListHandler modelListHandler2, int n3, boolean bl, boolean bl2, boolean bl3) {
        super(xSpellerTarget);
        this.charEnteredConst = n;
        this.inputFieldReadyConst = n2;
        this.target = xSpellerTarget;
        this.list = modelListHandler;
        this.selectionCriterion = n3;
        this.removeStreet = bl3;
        this.removeTown = bl2;
        this.removeZipCode = bl;
    }

    public void evtHSM_ENTRY(ISpellerContext iSpellerContext) {
        this.mtsUtil.printTraceMessage(this.target, "JPMAPCODEMATCHTEXTSUBJECT: Entering HSMEntry");
        ServiceManager.aslPropertyManager.valueChangedBoolean(this.charEnteredConst, false);
        ServiceManager.aslPropertyManager.valueChangedBoolean(this.inputFieldReadyConst, false);
    }

    public void evtHSM_START(ISpellerContext iSpellerContext) {
        this.mtsUtil.printTraceMessage(this.target, "JPMAPCODEMATCHTEXTSUBJECT: Entering HSMStart");
        this.setShortValueListMode();
        if (this.spellerData != null && StateMapCode.restore) {
            this.list.prepareListForRestore();
            StateMapCode.restore = false;
            StateMapCode.restored = true;
            ServiceManager.aslPropertyManager.valueChangedBoolean(this.inputFieldReadyConst, false);
            SpellerContext.cancelFlag = false;
            this.mtsUtil.printTraceMessage(this.target, new StringBuffer("JPMAPCODEMATCHTEXTSUBJECT:HSMStart restoring: ").append(this.target.getSpellerContext().getActiveField().getName()).toString());
            new CmdRestoreState(this, this.spellerData).execute();
        } else {
            this.list.prepareListForInitialFill();
            ServiceManager.aslPropertyManager.valueChangedBoolean(this.inputFieldReadyConst, false);
            this.mtsUtil.printTraceMessage(this.target, new StringBuffer("JPMAPCODEMATCHTEXTSUBJECT:HSMStart starting speller: ").append(this.target.getSpellerContext().getActiveField().getName()).toString());
            StateMapCode.restored = false;
            new CmdStartSpeller(this, this.selectionCriterion, this.removeZipCode, this.removeTown, this.removeStreet).execute();
        }
    }

    public void evtHSM_EXIT(ISpellerContext iSpellerContext) {
        this.mtsUtil.printTraceMessage(this.target, "JPMAPCODEMATCHTEXTSUBJECT: Entering evtHSM_EXIT");
        if (this.target.getSpellerContext().getActiveField() == null) {
            return;
        }
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(107);
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(83);
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_SELECT_MATCH(ISpellerContext iSpellerContext, int n) {
        this.mtsUtil.printTraceMessage(this.target, new StringBuffer().append("JPMAPCODEMATCHTEXTSUBJECT: evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_SELECT_FIRST_MATCH entered, selecting idx").append(n).toString());
        this.list.freezeList();
        new CmdLiGetState(this).execute();
        new CmdSelectListItem(this, n).execute();
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_SELECT_FIRST_MATCH(ISpellerContext iSpellerContext) {
        this.mtsUtil.printTraceMessage(this.target, "JPMAPCODEMATCHTEXTSUBJECT: evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_SELECT_FIRST_MATCH entered, selecting idx 0");
        this.list.freezeList();
        new CmdLiGetState(this).execute();
        new CmdSelectListItem(this, 0).execute();
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_ADD_CHARACTER(ISpellerContext iSpellerContext, String string) {
        this.evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILTER_BY_ADD_CHARACTER(iSpellerContext, string);
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_UNDO_LAST_CHARACTERS(ISpellerContext iSpellerContext) {
        this.evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILTER_BY_UNDO_LAST_CHARACTERS(iSpellerContext);
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_CLEAR_ALL_CHARACTERS(ISpellerContext iSpellerContext) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(this.inputFieldReadyConst, false);
        this.mtsUtil.printTraceMessage(this.target, "JPMAPCODEMATCHTEXTSUBJECT.evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_CLEAR_ALL_CHARACTERS entered");
        this.list.prepareListForUpdate();
        this.enteredString = "";
        this.mtsUtil.printTraceMessage(this.target, "JPMAPCODEMATCHTEXTSUBJECT.evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILTER_BY_UNDO_LAST_CHARACTERS: Removing character from southside ( via CmdSetChar)");
        this.setShortValueListMode();
        new CmdSetInput(this, "", false).execute();
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILTER_BY_ADD_CHARACTER(ISpellerContext iSpellerContext, String string) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(this.inputFieldReadyConst, false);
        this.list.prepareListForUpdate();
        this.enteredString = new StringBuffer(this.target.getSpellerContext().getActiveField().getSpellerData().getEnteredText()).append(string).toString();
        this.setShortValueListMode();
        this.mtsUtil.printTraceMessage(this.target, new StringBuffer("JPMAPCODEMATCHTEXTSUBJECT.ADD_CHARACTER: Sending (adding) characters by sending CmdSetinput to southside. String: ").append(this.enteredString).toString());
        new CmdSetInput(this, this.enteredString, false).execute();
        this.setNvcSpellerInputString(this.enteredString);
    }

    void setNvcSpellerInputString(String string) {
        this.mtsUtil.printTraceMessage(this.target, new StringBuffer("JPMAPCODEMATCHTEXTSUBJECT.setNvcSpellerInputString: Sending string to show in model. String: ").append(string).toString());
        SpellerData spellerData = this.target.getSpellerContext().getActiveField().getSpellerData();
        spellerData = DataHelper.setSpellerDataInput(spellerData, string);
        this.target.getSpellerContext().getActiveField().setSpellerData(spellerData);
        ModelUpdater.updateSpellerData(this.target.getSpellerContext().getActiveField().getSpellerData(), SpellerContext.ACTIVE_STATE);
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILTER_BY_UNDO_LAST_CHARACTERS(ISpellerContext iSpellerContext) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(this.inputFieldReadyConst, false);
        this.mtsUtil.printTraceMessage(this.target, "JPMAPCODEMATCHTEXTSUBJECT.evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILTER_BY_UNDO_LAST_CHARACTERS entered");
        this.list.prepareListForUpdate();
        if (this.enteredString.length() > 0) {
            this.enteredString = this.enteredString.substring(0, this.enteredString.length() - 1);
        }
        this.mtsUtil.printTraceMessage(this.target, "JPMAPCODEMATCHTEXTSUBJECT.evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILTER_BY_UNDO_LAST_CHARACTERS: Removing character from southside ( via CmdSetInput)");
        this.setShortValueListMode();
        new CmdSetInput(this, this.enteredString, false).execute();
    }

    @Override
    public void handleCommandCmdSelectListItem(CmdSelectListItem cmdSelectListItem) {
        this.mtsUtil.printTraceMessage(this.target, "JPMAPCODEMATCHTEXTSUBJECT.handleCommandCmdSelectListItem() callback entered");
        ModelUpdater.setHousenumberSpellerToUse(cmdSelectListItem.liCurrentState_usefulRefinementCriteria, this.target);
        NavLocation navLocation = cmdSelectListItem.liCurrentState_liCurrentLD;
        this.mtsUtil.handleSelect(cmdSelectListItem, this.target, navLocation, cmdSelectListItem.liCurrentState_availableSelectionCriteria, this.inputFieldReadyConst, false);
        ModelUpdater.updateLocationInputInputFieldActionResult(true);
        ModelUpdater.updateLocationInputActionResult(true);
    }

    @Override
    public void handleCommandCmdSetInput(CmdSetInput cmdSetInput) {
        this.mtsUtil.printTraceMessage(this.target, "JPMAPCODEMATCHTEXTSUBJECT.handleCommandCmdSetInput() called");
        if (cmdSetInput.liResult_ReturnCode != 0L) {
            this.target.getLogger().error("JPMAPCODEMATCHTEXTSUBJECT->handleCommandCmdSetInput southside return value is NOK");
            return;
        }
        if (SpellerContext.getActiveExtInterfaceField() != 0) {
            XSpellerTarget.changeExtInterfaceList(cmdSetInput.liValueList_lispValueList, cmdSetInput.liValueList_lispValueListCount, new HnrFlagsImpl());
        }
        this.mtsUtil.printTraceMessage(this.target, "JPMAPCODEMATCHTEXTSUBJECT.handleCommandCmdSetInput(): No more chars in queue");
        this.addOrDeleteChars(cmdSetInput);
    }

    @Override
    public void handleCommandCmdLiGetState(CmdLiGetState cmdLiGetState) {
        this.mtsUtil.printTraceMessage(this.target, "JPMAPCODEMATCHTEXTSUBJECT.handleCommandCmdLiGetState() entered");
        this.target.getSpellerContext().getActiveField().setDSIState(cmdLiGetState.liGetStateResult_spellerState);
        this.spellerData = cmdLiGetState.liGetStateResult_spellerState;
    }

    @Override
    public void handleCommandCmdRequestValueListByListIndex(CmdRequestValueListByListIndex cmdRequestValueListByListIndex) {
        this.mtsUtil.printTraceMessage(this.target, "JPMAPCODEMATCHTEXTSUBJECT.handleCommandCmdRequestValueListByListIndex() entered");
        this.mtsUtil.updateLists(this.target, cmdRequestValueListByListIndex, this.list);
        this.mtsUtil.setCharsAndCursor(this.target, cmdRequestValueListByListIndex);
        this.mtsUtil.printList(this.target, cmdRequestValueListByListIndex.liValueList_lispValueList.list);
        ModelUpdater.updateListCount((int)cmdRequestValueListByListIndex.liValueList_lispValueListCount, this.selectionCriterion);
        ModelUpdater.updateSpellerData(this.target.getSpellerContext().getActiveField().getSpellerData(), this.target.getSpellerContext().getActiveState());
        ServiceManager.aslPropertyManager.valueChangedBoolean(this.inputFieldReadyConst, true);
    }

    @Override
    public void handleCommandCmdStartSpeller(CmdStartSpeller cmdStartSpeller) {
        this.mtsUtil.printTraceMessage(this.target, "JPMAPCODEMATCHTEXTSUBJECT.handleCommandCmdStartSpeller() entered");
        ModelUpdater.updateListCount((int)cmdStartSpeller.liValueList_lispValueListCount, this.selectionCriterion);
        this.mtsUtil.updateLists(this.target, cmdStartSpeller, this.list);
        this.mtsUtil.setCharsAndCursor(this.target, cmdStartSpeller);
        ModelUpdater.updateSpellerData(this.target.getSpellerContext().getActiveField().getSpellerData(), this.target.getSpellerContext().getActiveState());
        ServiceManager.aslPropertyManager.valueChangedBoolean(this.inputFieldReadyConst, true);
        this.mtsUtil.sendPositiveActionResults(this.target);
    }

    @Override
    public void handleCommandCmdAddChar(CmdAddChar cmdAddChar) {
        this.mtsUtil.printTraceMessage(this.target, "JPMAPCODEMATCHTEXTSUBJECT.handleCommandCmdAddChar() entered");
        this.addOrDeleteChars(cmdAddChar);
    }

    @Override
    public void handleCommandCmdRestoreState(CmdRestoreState cmdRestoreState) {
        this.mtsUtil.printTraceMessage(this.target, "JPMAPCODEMATCHTEXTSUBJECT.handleCommandCmdRestoreState() entered");
        this.mtsUtil.updateLists(this.target, cmdRestoreState, this.list);
        this.mtsUtil.setCharsAndCursor(this.target, cmdRestoreState);
        ModelUpdater.updateListCount((int)cmdRestoreState.liValueList_lispValueListCount, this.selectionCriterion);
        ModelUpdater.updateSpellerData(this.target.getSpellerContext().getActiveField().getSpellerData(), this.target.getSpellerContext().getActiveState());
        ServiceManager.aslPropertyManager.valueChangedBoolean(this.inputFieldReadyConst, true);
        this.mtsUtil.sendPositiveActionResults(this.target);
    }

    private void addOrDeleteChars(CmdAbstractSpeller cmdAbstractSpeller) {
        int n = this.target.getSpellerContext().getActiveState();
        StateMapCode.restored = false;
        this.mtsUtil.updateLists(this.target, cmdAbstractSpeller, this.list);
        this.mtsUtil.setCharsAndCursor(this.target, cmdAbstractSpeller);
        ModelUpdater.updateListCount((int)cmdAbstractSpeller.liValueList_lispValueListCount, this.selectionCriterion);
        ModelUpdater.updateSpellerData(this.target.getSpellerContext().getActiveField().getSpellerData(), n);
        ServiceManager.aslPropertyManager.valueChangedBoolean(this.inputFieldReadyConst, true);
        ModelUpdater.updateLocationInputInputFieldActionResult(true);
    }

    private void setShortValueListMode() {
        if (!SpellerContext.useShortLiValueList) {
            this.mtsUtil.printTraceMessage(this.target, "JPMAPCODEMATCHTEXTSUBJECT:setShortValueListMode -> setShortValueListMode: Setting liValueListWindowSize = 1");
            new CmdSetLiValueListWindowSize(this, 1).execute();
        }
    }

    @Override
    public void handleCommandCmdSetLiValueListWindowSize(CmdSetLiValueListWindowSize cmdSetLiValueListWindowSize) {
        SpellerContext.useShortLiValueListHnr = false;
        SpellerContext.useShortLiValueList = true;
        if (this.target.getLogger().isTraceEnabled()) {
            this.target.getLogger().makeTrace().append("SetLiValueListSize return code is: ").append(cmdSetLiValueListWindowSize.liResult_ReturnCode).append(" New window size is: ").append(cmdSetLiValueListWindowSize.getWindowSize()).log();
        }
    }
}

