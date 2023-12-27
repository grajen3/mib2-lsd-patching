/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.spellerx.subjects;

import de.vw.mib.asl.api.navigation.ASLNavigationTruffelFactory;
import de.vw.mib.asl.api.navigation.locationinput.ISpellerContext;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdAbstractSpeller;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdAddChar;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdLiGetState;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdRequestValueListByListIndex;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdRestoreState;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSelectListItem;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSelectListItemByIdent;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSetCurrentLD;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSetInput;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdStartSpeller;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdStripLocation;
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
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.housenumber.transformer.NavigationLocationInputInputFieldHousenumberListInfoCollector;
import org.dsi.ifc.global.NavLocation;

public class EUMatchTextPointLocationSubject
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

    public EUMatchTextPointLocationSubject(XSpellerTarget xSpellerTarget, int n, int n2, ModelListHandler modelListHandler, ModelListHandler modelListHandler2, int n3, boolean bl, boolean bl2, boolean bl3) {
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
        this.mtsUtil.printTraceMessage(this.target, "EUMATCHTEXT_PL_SUBJECT: Entering HSMEntry");
        ServiceManager.aslPropertyManager.valueChangedBoolean(this.charEnteredConst, false);
        ServiceManager.aslPropertyManager.valueChangedBoolean(this.inputFieldReadyConst, false);
    }

    public void evtHSM_START(ISpellerContext iSpellerContext) {
        this.mtsUtil.printTraceMessage(this.target, "EUMATCHTEXT_PL_SUBJECT: Entering HSMStart");
        this.list.prepareListForInitialFill();
        if (SpellerContext.cancelFlag && this.target.getSpellerContext().getActiveField().hasDSIState()) {
            ServiceManager.aslPropertyManager.valueChangedBoolean(this.inputFieldReadyConst, false);
            this.target.getLogger().trace(new StringBuffer("Trying to restore state: ").append(this.target.getSpellerContext().getActiveField().getName()).toString());
            SpellerContext.cancelFlag = false;
            this.mtsUtil.printTraceMessage(this.target, new StringBuffer("EUMATCHTEXT_PL_SUBJECT:HSMStart restoring: ").append(this.target.getSpellerContext().getActiveField().getName()).toString());
            new CmdRestoreState(this, this.target.getSpellerContext().getActiveField().getDSIState()).execute();
        } else {
            this.mtsUtil.printTraceMessage(this.target, new StringBuffer("EUMATCHTEXT_PL_SUBJECT:HSMStart starting speller: ").append(this.target.getSpellerContext().getActiveField().getName()).toString());
            new CmdStartSpeller(this, this.selectionCriterion, this.removeZipCode, this.removeTown, this.removeStreet).execute();
        }
    }

    public void evtHSM_EXIT(ISpellerContext iSpellerContext) {
        this.mtsUtil.printTraceMessage(this.target, "EUMATCHTEXT_PL_SUBJECT: Entering evtHSM_EXIT");
        if (this.target.getSpellerContext().getActiveField() == null) {
            return;
        }
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(107);
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(83);
    }

    public void evtEV_SET_INPUT(ISpellerContext iSpellerContext, String string) {
        this.mtsUtil.printTraceMessage(this.target, new StringBuffer("EUMATCHTEXTSUBJECT:evtEV_SET_INPUT: Setting string: ").append(string).toString());
        new CmdSetInput(this, string, false).execute();
    }

    public void evtEV_SELECT_VIA_INDEX(ISpellerContext iSpellerContext, int n) {
        new FreeTextSubjectUtil().makeTraceComment(this.target, new StringBuffer("EUMATCHTEXTPOINTLOCATIONSUBJECT:evtEV_SELECT_VIA_INDEX: Selecting index: ").append(n).toString());
        this.evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_SELECT_MATCH(iSpellerContext, n);
    }

    public void evtEV_SELECT_VIA_ID(ISpellerContext iSpellerContext, String string) {
        this.mtsUtil.printTraceMessage(this.target, new StringBuffer().append("EUMATCHTEXTPOINTLOCATIONSUBJECT: Received event evtEV_SELECT_VIA_ID with objectId:").append(string).toString());
        if (string != null) {
            this.list.freezeList();
            new CmdLiGetState(this).execute();
            new CmdSelectListItemByIdent(this, string).execute();
        } else {
            this.target.getLogger().warn("EUMATCHTEXTSUBJECT: objectId is null");
        }
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_SELECT_NOTHING(ISpellerContext iSpellerContext) {
        this.list.freezeList();
        if (this.target.getLogger().isTraceEnabled()) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getExtLoggerHelper().appendLocation(this.target.getLogger().makeTrace().append(" CommonFreeTextSubject.evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_SELECT_NOTHING -> stripping location: "), this.target.getSpellerContext().getLocation()).log();
        }
        new CmdStripLocation(this, this.target.getSpellerContext().getLocation(), 3).execute();
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_SELECT_MATCH(ISpellerContext iSpellerContext, int n) {
        this.mtsUtil.printTraceMessage(this.target, new StringBuffer("EUMATCHTEXT_PL_SUBJECT: evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_SELECT_MATCH entered, selecting ").append(n).toString());
        this.list.freezeList();
        new CmdLiGetState(this).execute();
        new CmdSelectListItem(this, n).execute();
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_SELECT_FIRST_MATCH(ISpellerContext iSpellerContext) {
        this.mtsUtil.printTraceMessage(this.target, "EUMATCHTEXT_PL_SUBJECT: evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_SELECT_FIRST_MATCH entered, selecting idx 0");
        this.list.freezeList();
        new CmdLiGetState(this).execute();
        new CmdSelectListItem(this, 0).execute();
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILTER_BY_ADD_CHARACTER(ISpellerContext iSpellerContext, String string) {
        this.list.prepareListForUpdate();
        this.enteredString = new StringBuffer(this.target.getSpellerContext().getActiveField().getSpellerData().getEnteredText()).append(string).toString();
        this.mtsUtil.printTraceMessage(this.target, new StringBuffer("EUMATCHTEXT_PL_SUBJECT.ADD_CHARACTER: Sending (adding) characters by sending CmdSetInput to southside. String: ").append(this.enteredString).toString());
        new CmdSetInput(this, this.enteredString, false).execute();
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILTER_BY_UNDO_LAST_CHARACTERS(ISpellerContext iSpellerContext) {
        this.mtsUtil.printTraceMessage(this.target, "EUMATCHTEXT_PL_SUBJECT.evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILTER_BY_UNDO_LAST_CHARACTERS entered");
        this.list.prepareListForUpdate();
        new CmdUndoChar(this).execute();
    }

    @Override
    public void handleCommandCmdSelectListItem(CmdSelectListItem cmdSelectListItem) {
        ASLNavigationTruffelFactory.getNavigationTruffelApi().setShieldHouseNumber(cmdSelectListItem.liCurrentState_liCurrentLD.getHousenumber());
        this.mtsUtil.printTraceMessage(this.target, "EUMATCHTEXT_PL_SUBJECT.handleCommandCmdSelectListItem() callback entered");
        ModelUpdater.setHousenumberSpellerToUse(cmdSelectListItem.liCurrentState_usefulRefinementCriteria, this.target);
        this.mtsUtil.handleSelect(cmdSelectListItem, this.target, cmdSelectListItem.liCurrentState_liCurrentLD, cmdSelectListItem.liCurrentState_availableSelectionCriteria, this.inputFieldReadyConst, true);
    }

    @Override
    public void handleCommandCmdSelectListItemByIdent(CmdSelectListItemByIdent cmdSelectListItemByIdent) {
        this.mtsUtil.printTraceMessage(this.target, "EUMATCHTEXT_PL_SUBJECT.handleCommandCmdSelectListItemByIdent() called");
        ModelUpdater.setHousenumberSpellerToUse(cmdSelectListItemByIdent.liCurrentState_usefulRefinementCriteria, this.target);
        this.mtsUtil.handleSelect(cmdSelectListItemByIdent, this.target, cmdSelectListItemByIdent.liCurrentState_liCurrentLD, cmdSelectListItemByIdent.liCurrentState_availableSelectionCriteria, this.inputFieldReadyConst, true);
    }

    @Override
    public void handleCommandCmdLiGetState(CmdLiGetState cmdLiGetState) {
        this.mtsUtil.printTraceMessage(this.target, "EUMATCHTEXT_PL_SUBJECT.handleCommandCmdLiGetState() entered");
        this.target.getSpellerContext().getActiveField().setDSIState(cmdLiGetState.liGetStateResult_spellerState);
    }

    @Override
    public void handleCommandCmdRequestValueListByListIndex(CmdRequestValueListByListIndex cmdRequestValueListByListIndex) {
        this.mtsUtil.printTraceMessage(this.target, "EUMATCHTEXT_PL_SUBJECT.handleCommandCmdRequestValueListByListIndex() entered");
        this.mtsUtil.updateLists(this.target, cmdRequestValueListByListIndex, this.list);
        this.mtsUtil.setCharsAndCursor(this.target, cmdRequestValueListByListIndex);
        this.mtsUtil.printList(this.target, cmdRequestValueListByListIndex.liValueList_lispValueList.list);
        ModelUpdater.updateListCount((int)cmdRequestValueListByListIndex.liValueList_lispValueListCount, this.selectionCriterion);
        ModelUpdater.updateSpellerData(this.target.getSpellerContext().getActiveField().getSpellerData(), this.target.getSpellerContext().getActiveState());
    }

    @Override
    public void handleCommandCmdStartSpeller(CmdStartSpeller cmdStartSpeller) {
        this.mtsUtil.printTraceMessage(this.target, "EUMATCHTEXT_PL_SUBJECT.handleCommandCmdStartSpeller() entered");
        this.mtsUtil.updateLists(this.target, cmdStartSpeller, this.list, null);
        this.mtsUtil.setCharsAndCursor(this.target, cmdStartSpeller);
        this.setMatchTextForPreview(cmdStartSpeller);
        ModelUpdater.updateListCount((int)cmdStartSpeller.liValueList_lispValueListCount, this.selectionCriterion);
        ModelUpdater.updateSpellerData(this.target.getSpellerContext().getActiveField().getSpellerData(), this.target.getSpellerContext().getActiveState());
        ServiceManager.aslPropertyManager.valueChangedBoolean(this.inputFieldReadyConst, true);
        this.mtsUtil.sendPositiveActionResults(this.target);
    }

    @Override
    public void handleCommandCmdAddChar(CmdAddChar cmdAddChar) {
        this.mtsUtil.printTraceMessage(this.target, "EUMATCHTEXT_PL_SUBJECT.handleCommandCmdAddChar() entered");
        this.addOrDeleteChars(cmdAddChar);
    }

    @Override
    public void handleCommandCmdUndoChar(CmdUndoChar cmdUndoChar) {
        this.mtsUtil.printTraceMessage(this.target, "EUMATCHTEXT_PL_SUBJECT.handleCommandCmdUndoChar() entered");
        this.addOrDeleteChars(cmdUndoChar);
    }

    @Override
    public void handleCommandCmdRestoreState(CmdRestoreState cmdRestoreState) {
        this.mtsUtil.printTraceMessage(this.target, "EUMATCHTEXT_PL_SUBJECT.handleCommandCmdRestoreState() entered");
        this.mtsUtil.updateLists(this.target, cmdRestoreState, this.list);
        this.mtsUtil.setCharsAndCursor(this.target, cmdRestoreState);
        this.setMatchTextForPreview(cmdRestoreState);
        ModelUpdater.updateListCount((int)cmdRestoreState.liValueList_lispValueListCount, this.selectionCriterion);
        ModelUpdater.updateSpellerData(this.target.getSpellerContext().getActiveField().getSpellerData(), this.target.getSpellerContext().getActiveState());
        ServiceManager.aslPropertyManager.valueChangedBoolean(this.inputFieldReadyConst, true);
        this.mtsUtil.sendPositiveActionResults(this.target);
    }

    private void addOrDeleteChars(CmdAbstractSpeller cmdAbstractSpeller) {
        int n = this.target.getSpellerContext().getActiveState();
        this.mtsUtil.updateLists(this.target, cmdAbstractSpeller, this.list);
        this.mtsUtil.setCharsAndCursor(this.target, cmdAbstractSpeller);
        this.setMatchTextForPreview(cmdAbstractSpeller);
        ModelUpdater.updateListCount((int)cmdAbstractSpeller.liValueList_lispValueListCount, this.selectionCriterion);
        ModelUpdater.updateSpellerData(this.target.getSpellerContext().getActiveField().getSpellerData(), n);
        ModelUpdater.updateLocationInputInputFieldActionResult(true);
    }

    private void setMatchTextForPreview(CmdAbstractSpeller cmdAbstractSpeller) {
        String string = "";
        String string2 = this.target.getSpellerContext().getActiveField().getSpellerData().getEnteredText();
        if (cmdAbstractSpeller.liValueList_lispValueList != null && cmdAbstractSpeller.liValueList_lispValueList.list != null && cmdAbstractSpeller.liValueList_lispValueList.list.length > 0 && string2.length() > 0) {
            string = cmdAbstractSpeller.liValueList_lispValueList.list[0].data;
        }
        this.target.getSpellerContext().getActiveField().getSpellerData().setMatchText(string);
        this.target.getSpellerContext().getActiveField().getSpellerData().setMatchCount((int)cmdAbstractSpeller.liValueList_lispValueListCount);
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILTER(ISpellerContext iSpellerContext) {
        String string = this.target.getSpellerContext().getActiveField().getSpellerData().getEnteredText();
        new CmdSetInput(this, string, false).execute();
    }

    @Override
    public void handleCommandCmdSetInput(CmdSetInput cmdSetInput) {
        Logger logger = ServiceManager.logger;
        if (cmdSetInput.liResult_ReturnCode != 0L) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("EUMatchTextPointLocationSubject -> Error in setInput in fieldActive state failed (returnCode=").append(cmdSetInput.liResult_ReturnCode).append(")");
            logger.error(16384, stringBuffer.toString());
            ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().resetNaviContext(new StringBuffer("SetInput in fieldActive state failed: ").append(cmdSetInput.liResult_ReturnCode).toString());
            return;
        }
        GenericASLList genericASLList = ListManager.getGenericASLList(3080);
        NavigationLocationInputInputFieldHousenumberListInfoCollector navigationLocationInputInputFieldHousenumberListInfoCollector = (NavigationLocationInputInputFieldHousenumberListInfoCollector)genericASLList.getRowItem(0);
        if (SpellerContext.getActiveExtInterfaceField() != 0) {
            XSpellerTarget.changeExtInterfaceList(cmdSetInput.liValueList_lispValueList, cmdSetInput.liValueList_lispValueListCount, this.mtsUtil.calculateHnrFlags(this.target, cmdSetInput));
        }
        this.addOrDeleteChars(cmdSetInput);
        ModelUpdater.updateLocationInputInputFieldActionResult(true);
        ModelUpdater.updateLocationInputActionResult(true);
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_ADD_CHARACTER(ISpellerContext iSpellerContext, String string) {
        this.evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILTER_BY_ADD_CHARACTER(iSpellerContext, string);
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_UNDO_LAST_CHARACTERS(ISpellerContext iSpellerContext) {
        this.evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILTER_BY_UNDO_LAST_CHARACTERS(iSpellerContext);
    }

    @Override
    public void handleCommandCmdStripLocation(CmdStripLocation cmdStripLocation) {
        NavLocation navLocation = cmdStripLocation.liStripLocationResult_location;
        if (this.target.getLogger().isTraceEnabled()) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getExtLoggerHelper().appendLocation(this.target.getLogger().makeTrace().append(" EUMatchTextPointLocationSubject.handleCommandCmdStripLocation -> stripped location: "), navLocation).log();
        }
        new GeneralSubjectUtil().setOriginalLocation(this.target, navLocation, false);
        ModelUpdater.updateLocationResolved(false);
        ASLNavigationUtilFactory.getNavigationUtilApi().getExtLoggerHelper().appendLocation(this.target.getLogger().makeTrace().append(" EUMatchTextPointLocationSubject.handleCommandCmdStripLocation -> sending liSetCurrentLD with location: "), navLocation).log();
        new CmdSetCurrentLD(this, navLocation).execute();
    }

    @Override
    public void handleCommandCmdSetCurrentLD(CmdSetCurrentLD cmdSetCurrentLD) {
        NavLocation navLocation = cmdSetCurrentLD.liCurrentState_liCurrentLD;
        if (this.target.getLogger().isTraceEnabled()) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getExtLoggerHelper().appendLocation(this.target.getLogger().makeTrace().append(" EUMatchTextPointLocationSubject -> handleCommandCmdSetCurrentLD location: "), navLocation).log();
        }
        ModelUpdater.updateNextAvailableCriterions(cmdSetCurrentLD.liCurrentState_availableSelectionCriteria, navLocation, this.target);
        ModelUpdater.setHousenumberSpellerToUse(cmdSetCurrentLD.liCurrentState_usefulRefinementCriteria, this.target);
        ModelUpdater.updateLocation(navLocation, this.target);
        ModelUpdater.updateLocationResolved(true);
        new MatchTextSubjectUtil().printAvailableCriterions(this.target, cmdSetCurrentLD.liCurrentState_availableSelectionCriteria);
        this.target.getSpellerContext().setLocation(navLocation);
        if (this.target.getSpellerContext().getActiveField() != null) {
            ModelUpdater.updateSpellerData(this.target.getSpellerContext().getActiveField().getSpellerData(), this.target.getSpellerContext().getActiveState());
        }
        ModelUpdater.updateLocationInputInputFieldActionResult(true);
    }
}

