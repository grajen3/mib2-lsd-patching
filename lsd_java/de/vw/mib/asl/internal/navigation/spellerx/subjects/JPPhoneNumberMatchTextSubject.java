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
import de.vw.mib.asl.internal.navigation.spellerx.states.StatePhoneNumber;
import de.vw.mib.asl.internal.navigation.spellerx.subjects.NavReflectionSubject;
import de.vw.mib.asl.internal.navigation.spellerx.util.DataHelper;
import de.vw.mib.asl.internal.navigation.spellerx.util.HnrFlagsImpl;
import de.vw.mib.asl.internal.navigation.spellerx.util.MatchTextSubjectUtil;
import de.vw.mib.properties.values.SpellerData;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LISpellerData;

public class JPPhoneNumberMatchTextSubject
extends NavReflectionSubject {
    private int charEnteredConst;
    private int inputFieldReadyConst;
    private XSpellerTarget target;
    private ModelListHandler list;
    private int selectionCriterion;
    private boolean removeStreet;
    private boolean removeTown;
    private boolean removeZipCode;
    private String enteredString = "0";
    private MatchTextSubjectUtil mtsUtil = new MatchTextSubjectUtil();
    private LISpellerData spellerData;

    public JPPhoneNumberMatchTextSubject(XSpellerTarget xSpellerTarget, int n, int n2, ModelListHandler modelListHandler, ModelListHandler modelListHandler2, int n3, boolean bl, boolean bl2, boolean bl3) {
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
        this.mtsUtil.printTraceMessage(this.target, "JPPHONENUMBERMATCHTEXTSUBJECT: Entering HSMEntry");
        ServiceManager.aslPropertyManager.valueChangedBoolean(this.charEnteredConst, false);
        ServiceManager.aslPropertyManager.valueChangedBoolean(this.inputFieldReadyConst, false);
    }

    public void evtHSM_START(ISpellerContext iSpellerContext) {
        this.mtsUtil.printTraceMessage(this.target, "JPPHONENUMBERMATCHTEXTSUBJECT: Entering HSMStart");
        this.setShortValueListMode();
        if (this.spellerData != null && StatePhoneNumber.restore) {
            this.list.prepareListForRestore();
            ServiceManager.aslPropertyManager.valueChangedBoolean(this.inputFieldReadyConst, false);
            StatePhoneNumber.restore = false;
            StatePhoneNumber.restored = true;
            this.mtsUtil.printTraceMessage(this.target, "JPPHONENUMBERMATCHTEXTSUBJECT:HSMStart restoring: phonenumber ");
            new CmdRestoreState(this, this.spellerData).execute();
        } else {
            this.list.prepareListForInitialFill();
            ServiceManager.aslPropertyManager.valueChangedBoolean(this.inputFieldReadyConst, false);
            this.mtsUtil.printTraceMessage(this.target, new StringBuffer("JPPHONENUMBERMATCHTEXTSUBJECT:HSMStart starting speller: ").append(this.target.getSpellerContext().getActiveField().getName()).toString());
            StatePhoneNumber.restored = false;
            this.enteredString = "0";
            new CmdStartSpeller(this, this.selectionCriterion, this.removeZipCode, this.removeTown, this.removeStreet).execute();
        }
    }

    public void evtHSM_EXIT(ISpellerContext iSpellerContext) {
        this.mtsUtil.printTraceMessage(this.target, "JPPHONENUMBERMATCHTEXTSUBJECT: Entering evtHSM_EXIT");
        if (this.target.getSpellerContext().getActiveField() == null) {
            return;
        }
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(107);
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(83);
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_SELECT_MATCH(ISpellerContext iSpellerContext, int n) {
        this.mtsUtil.printTraceMessage(this.target, new StringBuffer().append("JPPHONENUMBERMATCHTEXTSUBJECT: evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_SELECT_FIRST_MATCH entered, selecting idx").append(n).toString());
        this.list.freezeList();
        new CmdLiGetState(this).execute();
        new CmdSelectListItem(this, n).execute();
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_ADD_CHARACTER(ISpellerContext iSpellerContext, String string) {
        this.evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILTER_BY_ADD_CHARACTER(iSpellerContext, string);
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_SELECT_FIRST_MATCH(ISpellerContext iSpellerContext) {
        this.mtsUtil.printTraceMessage(this.target, "JPPHONENUMBERMATCHTEXTSUBJECT: evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_SELECT_FIRST_MATCH entered, selecting idx 0");
        this.list.freezeList();
        new CmdLiGetState(this).execute();
        new CmdSelectListItem(this, 0).execute();
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILL_RESULT_LIST(ISpellerContext iSpellerContext) {
        this.mtsUtil.printTraceMessage(this.target, "JPPHONENUMBERMATCHTEXTSUBJECT: evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILL_RESULT_LIST entered, resolve elements");
        this.list.resolveElements(null);
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_RETURN_TO_DUAL_LIST(ISpellerContext iSpellerContext) {
        this.mtsUtil.printTraceMessage(this.target, "JPPHONENUMBERMATCHTEXTSUBJECT: evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_RETURN_TO_DUAL_LIST entered, restoring spellerdata");
        StatePhoneNumber.restored = true;
        new CmdRestoreState(this, this.spellerData).execute();
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILTER_BY_ADD_CHARACTER(ISpellerContext iSpellerContext, String string) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(this.inputFieldReadyConst, false);
        this.list.prepareListForUpdate();
        this.enteredString = new StringBuffer(this.target.getSpellerContext().getActiveField().getSpellerData().getEnteredText()).append(string).toString();
        this.setShortValueListMode();
        this.mtsUtil.printTraceMessage(this.target, new StringBuffer("JPPHONENUMBERMATCHTEXTSUBJECT.ADD_CHARACTER: Sending (adding) characters by sending CmdSetinput to southside. String: ").append(this.enteredString).toString());
        new CmdSetInput(this, this.enteredString, false).execute();
        this.setNvcSpellerInputString(this.enteredString);
    }

    void setNvcSpellerInputString(String string) {
        this.mtsUtil.printTraceMessage(this.target, new StringBuffer("JPPHONENUMBERMATCHTEXTSUBJECT.setNvcSpellerInputString: Sending string to show in model. String: ").append(string).toString());
        SpellerData spellerData = this.target.getSpellerContext().getActiveField().getSpellerData();
        spellerData = DataHelper.setSpellerDataInput(spellerData, string);
        this.target.getSpellerContext().getActiveField().setSpellerData(spellerData);
        ModelUpdater.updateSpellerData(this.target.getSpellerContext().getActiveField().getSpellerData(), SpellerContext.ACTIVE_STATE);
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_UNDO_LAST_CHARACTERS(ISpellerContext iSpellerContext) {
        this.evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILTER_BY_UNDO_LAST_CHARACTERS(iSpellerContext);
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_CLEAR_ALL_CHARACTERS(ISpellerContext iSpellerContext) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(this.inputFieldReadyConst, false);
        SpellerContext.clearAllCalled = true;
        this.mtsUtil.printTraceMessage(this.target, "JPPHONENUMBERMATCHTEXTSUBJECT.ASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_CLEAR_ALL_CHARACTERS entered");
        this.list.prepareListForUpdate();
        if (this.enteredString.length() > 0) {
            this.enteredString = "";
            this.mtsUtil.printTraceMessage(this.target, "JPPHONENUMBERMATCHTEXTSUBJECT.ASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_CLEAR_ALL_CHARACTERS: Removing all character from southside ( via CmdSetInput)");
            this.setShortValueListMode();
            new CmdSetInput(this, "0", false).execute();
        }
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILTER_BY_UNDO_LAST_CHARACTERS(ISpellerContext iSpellerContext) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(this.inputFieldReadyConst, false);
        this.mtsUtil.printTraceMessage(this.target, "JPPHONENUMBERMATCHTEXTSUBJECT.evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILTER_BY_UNDO_LAST_CHARACTERS entered");
        this.list.prepareListForUpdate();
        if (this.enteredString.length() > 1) {
            this.enteredString = this.enteredString.substring(0, this.enteredString.length() - 1);
        }
        this.mtsUtil.printTraceMessage(this.target, "JPPHONENUMBERMATCHTEXTSUBJECT.evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILTER_BY_UNDO_LAST_CHARACTERS: Removing character from southside ( via CmdSetInput)");
        this.setShortValueListMode();
        new CmdSetInput(this, this.enteredString, false).execute();
    }

    @Override
    public void handleCommandCmdSelectListItem(CmdSelectListItem cmdSelectListItem) {
        this.mtsUtil.printTraceMessage(this.target, "JPPHONENUMBERMATCHTEXTSUBJECT.handleCommandCmdSelectListItem() callback entered");
        ModelUpdater.setHousenumberSpellerToUse(cmdSelectListItem.liCurrentState_usefulRefinementCriteria, this.target);
        NavLocation navLocation = cmdSelectListItem.liCurrentState_liCurrentLD;
        this.mtsUtil.handleSelect(cmdSelectListItem, this.target, navLocation, cmdSelectListItem.liCurrentState_availableSelectionCriteria, this.inputFieldReadyConst, false);
        ModelUpdater.updateLocationInputInputFieldActionResult(true);
    }

    @Override
    public void handleCommandCmdSetInput(CmdSetInput cmdSetInput) {
        this.mtsUtil.printTraceMessage(this.target, "JPPHONENUMBERMATCHTEXTSUBJECT.handleCommandCmdSetInput() called");
        if (cmdSetInput.liResult_ReturnCode != 0L) {
            this.target.getLogger().error("JPPHONENUMBERMATCHTEXTSUBJECT->handleCommandCmdSetInput southside return value is NOK");
            return;
        }
        if (SpellerContext.getActiveExtInterfaceField() != 0) {
            XSpellerTarget.changeExtInterfaceList(cmdSetInput.liValueList_lispValueList, cmdSetInput.liValueList_lispValueListCount, new HnrFlagsImpl());
        }
        this.mtsUtil.printTraceMessage(this.target, "JPPHONENUMBERMATCHTEXTSUBJECT.handleCommandCmdSetInput(): No more chars in queue");
        this.addOrDeleteChars(cmdSetInput);
    }

    @Override
    public void handleCommandCmdLiGetState(CmdLiGetState cmdLiGetState) {
        this.mtsUtil.printTraceMessage(this.target, "JPPHONENUMBERMATCHTEXTSUBJECT.handleCommandCmdLiGetState() entered");
        this.spellerData = cmdLiGetState.liGetStateResult_spellerState;
        this.target.getSpellerContext().getActiveField().setDSIState(cmdLiGetState.liGetStateResult_spellerState);
    }

    @Override
    public void handleCommandCmdRequestValueListByListIndex(CmdRequestValueListByListIndex cmdRequestValueListByListIndex) {
        this.mtsUtil.printTraceMessage(this.target, "JPPHONENUMBERMATCHTEXTSUBJECT.handleCommandCmdRequestValueListByListIndex() entered");
        this.mtsUtil.updateLists(this.target, cmdRequestValueListByListIndex, this.list);
        this.mtsUtil.setCharsAndCursor(this.target, cmdRequestValueListByListIndex);
        this.mtsUtil.printList(this.target, cmdRequestValueListByListIndex.liValueList_lispValueList.list);
        ModelUpdater.updateListCount((int)cmdRequestValueListByListIndex.liValueList_lispValueListCount, this.selectionCriterion);
        ModelUpdater.updateSpellerData(this.target.getSpellerContext().getActiveField().getSpellerData(), this.target.getSpellerContext().getActiveState());
        ServiceManager.aslPropertyManager.valueChangedBoolean(this.inputFieldReadyConst, true);
    }

    @Override
    public void handleCommandCmdStartSpeller(CmdStartSpeller cmdStartSpeller) {
        this.mtsUtil.printTraceMessage(this.target, "JPPHONENUMBERMATCHTEXTSUBJECT.handleCommandCmdStartSpeller() entered");
        ModelUpdater.updateListCount((int)cmdStartSpeller.liValueList_lispValueListCount, this.selectionCriterion);
        this.mtsUtil.updateLists(this.target, cmdStartSpeller, this.list);
        this.mtsUtil.setCharsAndCursor(this.target, cmdStartSpeller);
        ModelUpdater.updateSpellerData(this.target.getSpellerContext().getActiveField().getSpellerData(), this.target.getSpellerContext().getActiveState());
        ServiceManager.aslPropertyManager.valueChangedBoolean(this.inputFieldReadyConst, true);
        this.mtsUtil.sendPositiveActionResults(this.target);
    }

    @Override
    public void handleCommandCmdAddChar(CmdAddChar cmdAddChar) {
        this.mtsUtil.printTraceMessage(this.target, "JPPHONENUMBERMATCHTEXTSUBJECT.handleCommandCmdAddChar() entered");
        this.addOrDeleteChars(cmdAddChar);
    }

    @Override
    public void handleCommandCmdRestoreState(CmdRestoreState cmdRestoreState) {
        this.mtsUtil.printTraceMessage(this.target, "JPPHONENUMBERMATCHTEXTSUBJECT.handleCommandCmdRestoreState() entered");
        this.mtsUtil.updateLists(this.target, cmdRestoreState, this.list);
        this.mtsUtil.setCharsAndCursor(this.target, cmdRestoreState);
        this.list.resolveElements(cmdRestoreState.liValueList_lispValueList);
        ModelUpdater.updateListCount((int)cmdRestoreState.liValueList_lispValueListCount, this.selectionCriterion);
        ModelUpdater.updateSpellerData(this.target.getSpellerContext().getActiveField().getSpellerData(), this.target.getSpellerContext().getActiveState());
        ServiceManager.aslPropertyManager.valueChangedBoolean(this.inputFieldReadyConst, true);
        this.mtsUtil.sendPositiveActionResults(this.target);
    }

    private void addOrDeleteChars(CmdAbstractSpeller cmdAbstractSpeller) {
        this.mtsUtil.printTraceMessage(this.target, "JPPHONENUMBERMATCHTEXTSUBJECT.addOrDeleteChars() entered");
        int n = this.target.getSpellerContext().getActiveState();
        StatePhoneNumber.restored = false;
        this.mtsUtil.setCharsAndCursor(this.target, cmdAbstractSpeller);
        ModelUpdater.updateListCount((int)cmdAbstractSpeller.liValueList_lispValueListCount, this.selectionCriterion);
        ModelUpdater.updateSpellerData(this.target.getSpellerContext().getActiveField().getSpellerData(), n);
        ServiceManager.aslPropertyManager.valueChangedBoolean(this.inputFieldReadyConst, true);
        ModelUpdater.updateLocationInputInputFieldActionResult(true);
        this.mtsUtil.updateLists(this.target, cmdAbstractSpeller, this.list);
    }

    private void setShortValueListMode() {
        if (!SpellerContext.useShortLiValueList) {
            this.mtsUtil.printTraceMessage(this.target, "JPPHONENUMBERMATCHTEXTSUBJECT:setShortValueListMode -> setShortValueListMode: Setting liValueListWindowSize = 1");
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

