/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.spellerx.subjects;

import de.vw.mib.asl.api.navigation.locationinput.ISpellerContext;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.asl.AbstractReflectionContext;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdAbstractSpeller;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdAddChar;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdLiGetState;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdRequestValueListByListIndex;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdRestoreState;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSelectListItem;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSelectListItemByIdent;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSetInput;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSetLiValueListWindowSize;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSetNVCRange;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdStartSpeller;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdUndoChar;
import de.vw.mib.asl.internal.navigation.spellerx.SpellerContext;
import de.vw.mib.asl.internal.navigation.spellerx.XSpellerTarget;
import de.vw.mib.asl.internal.navigation.spellerx.model.ModelListHandler;
import de.vw.mib.asl.internal.navigation.spellerx.model.ModelUpdater;
import de.vw.mib.asl.internal.navigation.spellerx.subjects.NavReflectionSubject;
import de.vw.mib.asl.internal.navigation.spellerx.util.FreeTextSubjectUtil;
import de.vw.mib.asl.internal.navigation.spellerx.util.GeneralSubjectUtil;
import de.vw.mib.asl.internal.navigation.spellerx.util.MatchTextSubjectUtil;
import de.vw.mib.log4mib.Logger;
import org.dsi.ifc.global.NavLocation;

public class ChinaMatchTextHnrSubject
extends NavReflectionSubject {
    private int charEnteredConst;
    private int inputFieldReadyConst;
    private XSpellerTarget target;
    private ModelListHandler list;
    private ModelListHandler previewList;
    private int selectionCriterion;
    private boolean removeStreet;
    private boolean removeTown;
    private boolean removeZipCode;
    private String characterQueue = "";
    private String enteredString = "";
    private MatchTextSubjectUtil mtsUtil = new MatchTextSubjectUtil();

    public ChinaMatchTextHnrSubject(XSpellerTarget xSpellerTarget, int n, int n2, ModelListHandler modelListHandler, ModelListHandler modelListHandler2, int n3, boolean bl, boolean bl2, boolean bl3) {
        super(xSpellerTarget);
        this.charEnteredConst = n;
        this.inputFieldReadyConst = n2;
        this.target = xSpellerTarget;
        this.list = modelListHandler;
        this.previewList = modelListHandler2;
        this.selectionCriterion = n3;
        this.removeStreet = bl3;
        this.removeTown = bl2;
        this.removeZipCode = bl;
    }

    public void evtHSM_ENTRY(ISpellerContext iSpellerContext) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(this.charEnteredConst, false);
        ServiceManager.aslPropertyManager.valueChangedBoolean(this.inputFieldReadyConst, false);
    }

    public void evtHSM_START(ISpellerContext iSpellerContext) {
        this.list.prepareListForInitialFill();
        if (this.previewList != null) {
            this.previewList.prepareListForInitialFill();
        }
        this.setShortValueListMode();
        if (SpellerContext.cancelFlag && this.target.getSpellerContext().getActiveField().hasDSIState()) {
            this.restoreSpeller();
        } else {
            this.startSpeller();
        }
    }

    private void startSpeller() {
        this.enteredString = "";
        this.list.prepareListForInitialFill();
        if (this.previewList != null) {
            this.previewList.prepareListForInitialFill();
        }
        new CmdStartSpeller(this, this.selectionCriterion, this.removeZipCode, this.removeTown, this.removeStreet).execute();
    }

    private void restoreSpeller() {
        ServiceManager.aslPropertyManager.valueChangedBoolean(this.inputFieldReadyConst, false);
        this.list.prepareListForRestore();
        if (this.previewList != null) {
            this.previewList.prepareListForRestore();
        }
        this.mtsUtil.printTraceMessage(this.target, new StringBuffer("Trying to restore state: ").append(this.target.getSpellerContext().getActiveField().getName()).toString());
        SpellerContext.cancelFlag = false;
        new CmdRestoreState(this, this.target.getSpellerContext().getActiveField().getDSIState()).execute();
    }

    public void evtHSM_EXIT(ISpellerContext iSpellerContext) {
        if (this.target.getSpellerContext().getActiveField() == null) {
            return;
        }
        if (this.previewList != null) {
            // empty if block
        }
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(107);
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(83);
    }

    public void evtEV_SET_INPUT(ISpellerContext iSpellerContext, String string) {
        this.mtsUtil.printTraceMessage(this.target, new StringBuffer("CHINAMATCHTEXTHNRSUBJECT:evtEV_SET_INPUT: Setting string: ").append(string).toString());
        new CmdSetInput(this, string, false).execute();
    }

    public void evtEV_SELECT_VIA_INDEX(ISpellerContext iSpellerContext, int n) {
        new FreeTextSubjectUtil().makeTraceComment(this.target, new StringBuffer("CHINAMATCHTEXTHNRSUBJECT:evtEV_SELECT_VIA_INDEX: Selecting index: ").append(n).toString());
        this.evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_SELECT_MATCH(iSpellerContext, n);
    }

    public void evtEV_SELECT_VIA_ID(ISpellerContext iSpellerContext, String string) {
        this.mtsUtil.printTraceMessage(this.target, new StringBuffer().append("CHINAMATCHTEXTHNRSUBJECT: Received event evtEV_SELECT_VIA_ID with objectId:").append(string).toString());
        if (string != null) {
            this.freezeChnLists();
            new CmdLiGetState(this).execute();
            new CmdSelectListItemByIdent(this, string).execute();
        } else {
            this.target.getLogger().warn("CHINAMATCHTEXTHNRSUBJECT: objectId is null");
        }
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_SELECT_NOTHING(ISpellerContext iSpellerContext) {
        this.mtsUtil.printTraceMessage(this.target, "CHINAMATCHTEXTHNRSUBJECT: evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_SELECT_NOTHING entered");
        this.freezeChnLists();
        this.mtsUtil.handleSelectNothingEvent(this.target);
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_SET_HWR_SPELLER_MODE_ENABLED(AbstractReflectionContext abstractReflectionContext, boolean bl) {
        this.mtsUtil.printTraceMessage(this.target, "Entering evtASL_NAVIGATION_LOCATION_INPUT_SET_HWR_SPELLER_MODE_ENABLED(boolean) ");
        if (bl) {
            new CmdSetNVCRange(this, 2).execute();
        } else {
            new CmdSetNVCRange(this, 1).execute();
        }
        SpellerContext.hwrEnabled = bl;
        ServiceManager.aslPropertyManager.valueChangedBoolean(1127358464, bl);
        this.mtsUtil.printTraceMessage(this.target, new StringBuffer("HWR is ").append(SpellerContext.hwrEnabled ? "true" : "false").toString());
    }

    @Override
    public void handleCommandCmdSetNVCRange(CmdSetNVCRange cmdSetNVCRange) {
        if (cmdSetNVCRange.liResult_ReturnCode != 0L) {
            this.target.getLogger().makeError().append("Entering HWR: handleCommandCmdSetNVCRange didn't work");
            return;
        }
        if (SpellerContext.clearAllCalled) {
            this.mtsUtil.printTraceMessage(this.target, "Speller switch recognised. Clearing input field");
            this.target.getSpellerContext().getActiveField().getSpellerData().setSelectionStart(0);
            this.target.getSpellerContext().getActiveField().getSpellerData().setSelectionEnd(0);
            new CmdSetInput(this, "", false).execute();
            SpellerContext.clearAllCalled = false;
        }
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILTER_BY_ADD_CHARACTER_HWR(ISpellerContext iSpellerContext, String string, int n, int n2, int n3) {
        this.mtsUtil.printTraceMessage(this.target, "Entering evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILTER_BY_ADD_CHARACTER_HWR ");
        if (!SpellerContext.hwrEnabled) {
            this.evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILTER_BY_ADD_CHARACTER(iSpellerContext, string);
        } else {
            String string2 = this.enteredString.substring(0, n);
            this.enteredString = new StringBuffer().append(string2).append(string).toString();
            this.list.prepareListForUpdate();
            if (this.previewList != null) {
                this.previewList.prepareListForUpdate();
            }
            new CmdSetInput(this, this.enteredString, false).execute();
        }
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_SELECT_MATCH(ISpellerContext iSpellerContext, int n) {
        this.freezeChnLists();
        new CmdLiGetState(this).execute();
        new CmdSelectListItem(this, n).execute();
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_SELECT_FIRST_MATCH(ISpellerContext iSpellerContext) {
        this.freezeChnLists();
        new CmdLiGetState(this).execute();
        new CmdSelectListItem(this, 0).execute();
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILTER_BY_ADD_CHARACTER(ISpellerContext iSpellerContext, String string) {
        this.mtsUtil.printTraceMessage(this.target, new StringBuffer().append("CHNMATCHTEXTHNRSUBJECT: evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILTER_BY_ADD_CHARACTER entered, adding character: ").append(string).toString());
        this.list.prepareListForUpdate();
        this.enteredString = new StringBuffer(this.target.getSpellerContext().getActiveField().getSpellerData().getEnteredText()).append(string).toString();
        new CmdSetInput(this, this.enteredString, false).execute();
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILTER_BY_CLEAR_ALL_CHARACTERS(ISpellerContext iSpellerContext) {
        SpellerContext.clearAllCalled = true;
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILTER_BY_UNDO_LAST_CHARACTERS(ISpellerContext iSpellerContext) {
        this.list.prepareListForUpdate();
        this.target.getSpellerContext().getActiveField().getSpellerData().setSelectionStart(0);
        this.target.getSpellerContext().getActiveField().getSpellerData().setSelectionEnd(0);
        if (this.previewList != null) {
            this.previewList.prepareListForUpdate();
        }
        if (this.characterQueue.length() > 0) {
            this.characterQueue = this.characterQueue.substring(0, this.characterQueue.length() - 1);
        } else if (this.enteredString.length() > 0) {
            this.enteredString = this.enteredString.substring(0, this.enteredString.length() - 1);
            this.mtsUtil.printTraceMessage(this.target, "CHINAMATCHTEXTHNRSUBJECT.evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILTER_BY_UNDO_LAST_CHARACTERS: Removing character from southside ( via CmdUndoChar)");
            this.setShortValueListMode();
            new CmdUndoChar(this).execute();
        }
    }

    @Override
    public void handleCommandCmdSelectListItem(CmdSelectListItem cmdSelectListItem) {
        NavLocation navLocation = cmdSelectListItem.liCurrentState_liCurrentLD;
        this.target.getSpellerContext().setLocation(navLocation);
        ModelUpdater.updateLocation(navLocation, this.target);
        ModelUpdater.updateNextAvailableCriterions(cmdSelectListItem.liCurrentState_availableSelectionCriteria, navLocation, this.target);
        this.mtsUtil.printAvailableCriterions(this.target, cmdSelectListItem.liCurrentState_availableSelectionCriteria);
        this.mtsUtil.updateMap(this.target, navLocation);
        new GeneralSubjectUtil().setOriginalLocation(this.target, navLocation, false);
        ModelUpdater.updateLocationInputInputFieldActionResult(true);
        ModelUpdater.updateLocationInputActionResult(true);
        ModelUpdater.setHousenumberSpellerToUse(cmdSelectListItem.liCurrentState_usefulRefinementCriteria, this.target);
        if (SpellerContext.getActiveExtInterfaceField() != 0) {
            XSpellerTarget.changeExtLocation(navLocation, cmdSelectListItem.liCurrentState_availableSelectionCriteria, false);
        }
    }

    @Override
    public void handleCommandCmdSelectListItemByIdent(CmdSelectListItemByIdent cmdSelectListItemByIdent) {
        this.mtsUtil.printTraceMessage(this.target, "CHNMATCHTEXTHNRSUBJECT.handleCommandCmdSelectListItemByIdent() called");
        ModelUpdater.setHousenumberSpellerToUse(cmdSelectListItemByIdent.liCurrentState_usefulRefinementCriteria, this.target);
        this.mtsUtil.handleSelect(cmdSelectListItemByIdent, this.target, cmdSelectListItemByIdent.liCurrentState_liCurrentLD, cmdSelectListItemByIdent.liCurrentState_availableSelectionCriteria, this.inputFieldReadyConst, true);
    }

    @Override
    public void handleCommandCmdSetInput(CmdSetInput cmdSetInput) {
        Logger logger = ServiceManager.logger;
        if (cmdSetInput.liResult_ReturnCode != 0L) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Error in setInput in fieldActive state failed (returnCode=").append(cmdSetInput.liResult_ReturnCode).append(")");
            logger.error(16384, stringBuffer.toString());
            ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().resetNaviContext(new StringBuffer("SetInput in fieldActive state failed: ").append(cmdSetInput.liResult_ReturnCode).toString());
            return;
        }
        if (SpellerContext.getActiveExtInterfaceField() != 0) {
            XSpellerTarget.changeExtInterfaceList(cmdSetInput.liValueList_lispValueList, cmdSetInput.liValueList_lispValueListCount, this.mtsUtil.calculateHnrFlags(this.target, cmdSetInput));
        }
        this.addOrDeleteChars(cmdSetInput);
        ModelUpdater.updateLocationInputInputFieldActionResult(true);
        ModelUpdater.updateLocationInputActionResult(true);
    }

    @Override
    public void handleCommandCmdLiGetState(CmdLiGetState cmdLiGetState) {
        this.mtsUtil.printTraceMessage(this.target, "Storing speller (using DSI)...");
        this.target.getSpellerContext().getActiveField().setDSIState(cmdLiGetState.liGetStateResult_spellerState);
    }

    @Override
    public void handleCommandCmdRequestValueListByListIndex(CmdRequestValueListByListIndex cmdRequestValueListByListIndex) {
        this.mtsUtil.updateLists(this.target, cmdRequestValueListByListIndex, this.list, this.previewList);
        this.mtsUtil.setCharsAndCursor(this.target, cmdRequestValueListByListIndex);
        this.mtsUtil.printList(this.target, cmdRequestValueListByListIndex.liValueList_lispValueList.list);
        ModelUpdater.updateListCount((int)cmdRequestValueListByListIndex.liValueList_lispValueListCount, this.selectionCriterion);
        ModelUpdater.updateSpellerData(this.target.getSpellerContext().getActiveField().getSpellerData(), this.target.getSpellerContext().getActiveState());
    }

    @Override
    public void handleCommandCmdStartSpeller(CmdStartSpeller cmdStartSpeller) {
        this.mtsUtil.updateLists(this.target, cmdStartSpeller, this.list, this.previewList);
        this.mtsUtil.setCharsAndCursor(this.target, cmdStartSpeller);
        this.setMatchTextForPreview(cmdStartSpeller);
        ModelUpdater.updateListCount((int)cmdStartSpeller.liValueList_lispValueListCount, this.selectionCriterion);
        ModelUpdater.updateSpellerData(this.target.getSpellerContext().getActiveField().getSpellerData(), this.target.getSpellerContext().getActiveState());
        ServiceManager.aslPropertyManager.valueChangedBoolean(this.inputFieldReadyConst, true);
        this.mtsUtil.sendPositiveActionResults(this.target);
    }

    @Override
    public void handleCommandCmdAddChar(CmdAddChar cmdAddChar) {
        this.addOrDeleteChars(cmdAddChar);
    }

    @Override
    public void handleCommandCmdUndoChar(CmdUndoChar cmdUndoChar) {
        if (cmdUndoChar.liValueList_lispValueListCount < 1L && cmdUndoChar.lispUpdateSpellerResult_lispCurrentInput.length() > 0) {
            new CmdUndoChar(this).execute();
        } else {
            this.addOrDeleteChars(cmdUndoChar);
        }
    }

    private void addOrDeleteChars(CmdAbstractSpeller cmdAbstractSpeller) {
        int n = this.target.getSpellerContext().getActiveState();
        this.mtsUtil.updateLists(this.target, cmdAbstractSpeller, this.list, this.previewList);
        this.mtsUtil.setCharsAndCursor(this.target, cmdAbstractSpeller);
        this.setMatchTextForPreview(cmdAbstractSpeller);
        ModelUpdater.updateListCount((int)cmdAbstractSpeller.liValueList_lispValueListCount, this.selectionCriterion);
        ModelUpdater.updateSpellerData(this.target.getSpellerContext().getActiveField().getSpellerData(), n);
        ModelUpdater.updateLocationInputInputFieldActionResult(true);
    }

    @Override
    public void handleCommandCmdRestoreState(CmdRestoreState cmdRestoreState) {
        NavLocation navLocation = cmdRestoreState.liCurrentState_liCurrentLD;
        this.target.getSpellerContext().setLocation(navLocation);
        ModelUpdater.updateLocation(navLocation, this.target);
        this.mtsUtil.updateLists(this.target, cmdRestoreState, this.list, this.previewList);
        this.mtsUtil.setCharsAndCursor(this.target, cmdRestoreState);
        this.setMatchTextForPreview(cmdRestoreState);
        ModelUpdater.updateListCount((int)cmdRestoreState.liValueList_lispValueListCount, this.selectionCriterion);
        ModelUpdater.updateSpellerData(this.target.getSpellerContext().getActiveField().getSpellerData(), this.target.getSpellerContext().getActiveState());
        ServiceManager.aslPropertyManager.valueChangedBoolean(this.inputFieldReadyConst, true);
        this.mtsUtil.sendPositiveActionResults(this.target);
    }

    private void setMatchTextForPreview(CmdAbstractSpeller cmdAbstractSpeller) {
        String string = "";
        String string2 = this.target.getSpellerContext().getActiveField().getSpellerData().getEnteredText();
        if (cmdAbstractSpeller.liValueList_lispValueList != null && cmdAbstractSpeller.liValueList_lispValueList.list != null && cmdAbstractSpeller.liValueList_lispValueList.list.length > 0) {
            String string3 = cmdAbstractSpeller.liValueList_lispValueList.list[0].data;
            if (string2.length() > 0) {
                string = string3;
            }
        }
        this.target.getSpellerContext().getActiveField().getSpellerData().setMatchText(string);
        this.target.getSpellerContext().getActiveField().getSpellerData().setMatchCount((int)cmdAbstractSpeller.liValueList_lispValueListCount);
    }

    private void setShortValueListMode() {
        if (!SpellerContext.useShortLiValueList) {
            this.mtsUtil.printTraceMessage(this.target, "setShortValueListMode: Setting liValueListWindowSize = 1");
            new CmdSetLiValueListWindowSize(this, 1).execute();
        }
    }

    private void freezeChnLists() {
        this.list.freezeList();
        if (this.previewList != null) {
            this.previewList.freezeList();
        }
    }

    @Override
    public void handleCommandCmdSetLiValueListWindowSize(CmdSetLiValueListWindowSize cmdSetLiValueListWindowSize) {
        SpellerContext.useShortLiValueListHnr = false;
        SpellerContext.useShortLiValueList = true;
        this.mtsUtil.printTraceMessage(this.target, new StringBuffer("SetLiValueListSize return code is: ").append(cmdSetLiValueListWindowSize.liResult_ReturnCode).append(" New window size is: ").append(cmdSetLiValueListWindowSize.getWindowSize()).toString());
    }
}

