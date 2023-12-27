/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.spellerx.subjects;

import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.locationinput.ISpellerContext;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdAbstractSpeller;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdAddChar;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdGetLastCityHistoryEntry;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdLiGetState;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdRequestValueListByListIndex;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdRestoreState;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSelectListItem;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSelectListItemByIdent;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSetCountryForCityAndStreetHistory;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSetCurrentLD;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSetInput;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSetLiValueListWindowSize;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdStartSpeller;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdUndoChar;
import de.vw.mib.asl.internal.navigation.spellerx.SpellerContext;
import de.vw.mib.asl.internal.navigation.spellerx.XSpellerTarget;
import de.vw.mib.asl.internal.navigation.spellerx.model.ModelListHandler;
import de.vw.mib.asl.internal.navigation.spellerx.model.ModelUpdater;
import de.vw.mib.asl.internal.navigation.spellerx.subjects.NavReflectionSubject;
import de.vw.mib.asl.internal.navigation.spellerx.util.DataHelper;
import de.vw.mib.asl.internal.navigation.spellerx.util.FreeTextSubjectUtil;
import de.vw.mib.asl.internal.navigation.spellerx.util.HnrFlagsImpl;
import de.vw.mib.asl.internal.navigation.spellerx.util.MatchTextSubjectUtil;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.properties.values.SpellerData;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LICityHistoryEntry;
import org.dsi.ifc.navigation.LIStreetHistoryEntry;

public class NARMatchTextSubject
extends NavReflectionSubject {
    private int charEnteredConst;
    private int inputFieldReadyConst;
    private XSpellerTarget target;
    private ModelListHandler list;
    private int selectionCriterion;
    private boolean removeStreet;
    private boolean removeTown;
    private boolean removeZipCode;
    private boolean historyMatch;
    private long historyMatchId;
    private String historyMatchText;
    private String characterQueue = "";
    private String enteredString = "";
    private boolean addCharCommandSend = false;
    private MatchTextSubjectUtil mtsUtil = new MatchTextSubjectUtil();

    public NARMatchTextSubject(XSpellerTarget xSpellerTarget, int n, int n2, ModelListHandler modelListHandler, ModelListHandler modelListHandler2, int n3, boolean bl, boolean bl2, boolean bl3) {
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
        this.mtsUtil.printTraceMessage(this.target, "NARMATCHTEXTSUBJECT: Entering HSMEntry");
        ServiceManager.aslPropertyManager.valueChangedBoolean(this.charEnteredConst, false);
        ServiceManager.aslPropertyManager.valueChangedBoolean(this.inputFieldReadyConst, false);
    }

    public void evtHSM_START(ISpellerContext iSpellerContext) {
        this.mtsUtil.printTraceMessage(this.target, "NARMATCHTEXTSUBJECT: Entering HSMStart");
        this.clearHistoryRelatedVariables();
        this.setShortValueListMode();
        if (SpellerContext.cancelFlag && this.target.getSpellerContext().getActiveField().hasDSIState()) {
            this.list.prepareListForRestore();
            ServiceManager.aslPropertyManager.valueChangedBoolean(this.inputFieldReadyConst, false);
            SpellerContext.cancelFlag = false;
            this.mtsUtil.printTraceMessage(this.target, new StringBuffer("NARMATCHTEXTSUBJECT:HSMStart restoring: ").append(this.target.getSpellerContext().getActiveField().getName()).toString());
            new CmdRestoreState(this, this.target.getSpellerContext().getActiveField().getDSIState()).execute();
        } else {
            this.list.prepareListForInitialFill();
            ServiceManager.aslPropertyManager.valueChangedBoolean(this.inputFieldReadyConst, false);
            this.mtsUtil.printTraceMessage(this.target, new StringBuffer("NARMATCHTEXTSUBJECT:HSMStart starting speller: ").append(this.target.getSpellerContext().getActiveField().getName()).toString());
            new CmdStartSpeller(this, this.selectionCriterion, this.removeZipCode, this.removeTown, this.removeStreet).execute();
        }
    }

    public void evtHSM_EXIT(ISpellerContext iSpellerContext) {
        this.mtsUtil.printTraceMessage(this.target, "NARMATCHTEXTSUBJECT: Entering evtHSM_EXIT");
        if (this.target.getSpellerContext().getActiveField() == null) {
            return;
        }
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(107);
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(83);
    }

    public void evtEV_SET_INPUT(ISpellerContext iSpellerContext, String string) {
        this.mtsUtil.printTraceMessage(this.target, new StringBuffer("NARFREETEXTSUBJECT:evtEV_SET_INPUT: Setting string: ").append(string).toString());
        new CmdSetInput(this, string, false).execute();
    }

    public void evtEV_SELECT_VIA_INDEX(ISpellerContext iSpellerContext, int n) {
        new FreeTextSubjectUtil().makeTraceComment(this.target, new StringBuffer("NARMATCHTEXTSUBJECT:evtEV_SELECT_VIA_INDEX: Selecting index: ").append(n).toString());
        this.evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_SELECT_MATCH(iSpellerContext, n);
    }

    public void evtEV_SELECT_VIA_ID(ISpellerContext iSpellerContext, String string) {
        this.mtsUtil.printTraceMessage(this.target, new StringBuffer().append("NARMATCHTEXTSUBJECT: Received event evtEV_SELECT_VIA_ID with objectId:").append(string).toString());
        if (string != null) {
            this.list.freezeList();
            new CmdLiGetState(this).execute();
            new CmdSelectListItemByIdent(this, string).execute();
        } else {
            this.target.getLogger().warn("NARMATCHTEXTSUBJECT: objectId is null");
        }
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_SELECT_NOTHING(ISpellerContext iSpellerContext) {
        this.mtsUtil.printTraceMessage(this.target, "NARMATCHTEXTSUBJECT: evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_SELECT_NOTHING entered");
        this.clearHistoryRelatedVariables();
        this.list.freezeList();
        this.mtsUtil.handleSelectNothingEvent(this.target);
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_SELECT_MATCH(ISpellerContext iSpellerContext, int n) {
        this.list.freezeList();
        new CmdLiGetState(this).execute();
        this.clearHistoryRelatedVariables();
        new CmdSelectListItem(this, n).execute();
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_SELECT_FIRST_MATCH(ISpellerContext iSpellerContext) {
        this.mtsUtil.printTraceMessage(this.target, "NARMATCHTEXTSUBJECT: evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_SELECT_FIRST_MATCH entered, selecting idx 0");
        this.list.freezeList();
        new CmdLiGetState(this).execute();
        new CmdSelectListItem(this, 0).execute();
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILTER_BY_ADD_CHARACTER(ISpellerContext iSpellerContext, String string) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(this.inputFieldReadyConst, false);
        this.mtsUtil.printTraceMessage(this.target, "NARMATCHTEXTSUBJECT: evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILTER_BY_ADD_CHARACTER entered, selecting idx 0");
        this.list.prepareListForUpdate();
        this.characterQueue = new StringBuffer(this.characterQueue).append(string).toString();
        this.enteredString = new StringBuffer(this.target.getSpellerContext().getActiveField().getSpellerData().getEnteredText()).append(string).toString();
        this.setShortValueListMode();
        if (!this.addCharCommandSend) {
            this.mtsUtil.printTraceMessage(this.target, new StringBuffer("NARMATCHTEXTSUBJECT.ADD_CHARACTER: Sending (adding) characters by sending CmdSetinput to southside. String: ").append(this.enteredString).toString());
            new CmdSetInput(this, this.enteredString, false).execute();
            this.characterQueue = "";
            this.addCharCommandSend = true;
            this.updateSpellerWithAllCharactersAvailable();
        }
        this.setNvcSpellerInputString(this.enteredString);
    }

    void setNvcSpellerInputString(String string) {
        this.mtsUtil.printTraceMessage(this.target, new StringBuffer("NARMATCHTEXTSUBJECT.setNvcSpellerInputString: Sending string to show in model. String: ").append(string).toString());
        SpellerData spellerData = this.target.getSpellerContext().getActiveField().getSpellerData();
        spellerData = DataHelper.setSpellerDataInput(spellerData, string);
        this.target.getSpellerContext().getActiveField().setSpellerData(spellerData);
        ModelUpdater.updateSpellerData(this.target.getSpellerContext().getActiveField().getSpellerData(), SpellerContext.ACTIVE_STATE);
    }

    private void updateSpellerWithAllCharactersAvailable() {
        this.mtsUtil.printTraceMessage(this.target, "NARMATCHTEXTSUBJECT.updateSpellerWithAllCharactersAvailable(): Enabling allCharacters");
        this.target.getSpellerContext().getActiveField().getSpellerData().setAvailableCharacters("\u0007");
        ModelUpdater.updateSpellerData(this.target.getSpellerContext().getActiveField().getSpellerData(), SpellerContext.ACTIVE_STATE);
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILTER_BY_UNDO_LAST_CHARACTERS(ISpellerContext iSpellerContext) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(this.inputFieldReadyConst, false);
        this.mtsUtil.printTraceMessage(this.target, "NARMATCHTEXTSUBJECT.evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILTER_BY_UNDO_LAST_CHARACTERS entered");
        this.list.prepareListForUpdate();
        if (this.characterQueue.length() > 0) {
            this.mtsUtil.printTraceMessage(this.target, "NARMATCHTEXTSUBJECT.evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILTER_BY_UNDO_LAST_CHARACTERS: Removing character from queue");
            this.characterQueue = this.characterQueue.substring(0, this.characterQueue.length() - 1);
        } else if (this.enteredString.length() > 0) {
            this.enteredString = this.enteredString.substring(0, this.enteredString.length() - 1);
            this.mtsUtil.printTraceMessage(this.target, "NARMATCHTEXTSUBJECT.evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILTER_BY_UNDO_LAST_CHARACTERS: Removing character from southside ( via CmdUndoChar)");
            this.setShortValueListMode();
            new CmdUndoChar(this).execute();
        }
    }

    @Override
    public void handleCommandCmdSelectListItem(CmdSelectListItem cmdSelectListItem) {
        this.mtsUtil.printTraceMessage(this.target, "NARMATCHTEXTSUBJECT.handleCommandCmdSelectListItem() callback entered");
        ModelUpdater.setHousenumberSpellerToUse(cmdSelectListItem.liCurrentState_usefulRefinementCriteria, this.target);
        this.mtsUtil.handleSelect(cmdSelectListItem, this.target, cmdSelectListItem.liCurrentState_liCurrentLD, cmdSelectListItem.liCurrentState_availableSelectionCriteria, this.inputFieldReadyConst, true);
    }

    @Override
    public void handleCommandCmdSelectListItemByIdent(CmdSelectListItemByIdent cmdSelectListItemByIdent) {
        this.mtsUtil.printTraceMessage(this.target, "NARMATCHTEXTSUBJECT.handleCommandCmdSelectListItemByIdent() called");
        ModelUpdater.setHousenumberSpellerToUse(cmdSelectListItemByIdent.liCurrentState_usefulRefinementCriteria, this.target);
        this.mtsUtil.handleSelect(cmdSelectListItemByIdent, this.target, cmdSelectListItemByIdent.liCurrentState_liCurrentLD, cmdSelectListItemByIdent.liCurrentState_availableSelectionCriteria, this.inputFieldReadyConst, true);
    }

    @Override
    public void handleCommandCmdSetInput(CmdSetInput cmdSetInput) {
        this.mtsUtil.printTraceMessage(this.target, "NARMATCHTEXTSUBJECT.handleCommandCmdSetInput() called");
        if (cmdSetInput.liResult_ReturnCode != 0L) {
            this.target.getLogger().error("NARMATCHTEXTSUBJECT->handleCommandCmdSetInput southside return value is NOK");
            return;
        }
        if (SpellerContext.getActiveExtInterfaceField() != 0) {
            XSpellerTarget.changeExtInterfaceList(cmdSetInput.liValueList_lispValueList, cmdSetInput.liValueList_lispValueListCount, new HnrFlagsImpl());
        }
        if (this.characterQueue.length() > 0) {
            this.mtsUtil.printTraceMessage(this.target, new StringBuffer("NARMATCHTEXTSUBJECT.handleCommandCmdSetInput(): Sending (adding) characters by sending cmdSetinput to southside. String: ").append(this.enteredString).toString());
            new CmdSetInput(this, this.enteredString, false).execute();
            this.characterQueue = "";
            this.addCharCommandSend = true;
            this.updateSpellerWithAllCharactersAvailable();
            this.setNvcSpellerInputString(this.enteredString);
            return;
        }
        this.mtsUtil.printTraceMessage(this.target, "NARMATCHTEXTSUBJECT.handleCommandCmdSetInput(): No more chars in queue");
        this.addCharCommandSend = false;
        this.addOrDeleteChars(cmdSetInput);
        if (cmdSetInput.liValueList_lispValueListCount < 1L && cmdSetInput.lispUpdateSpellerResult_lispCurrentInput.length() > 0) {
            this.mtsUtil.printTraceMessage(this.target, "NARMATCHTEXTSUBJECT.handleCommandCmdSetInput(): liValueList is empty! Removing chars via CmdUndoChar from southside until list > 0");
            new CmdUndoChar(this).execute();
            return;
        }
    }

    @Override
    public void handleCommandCmdLiGetState(CmdLiGetState cmdLiGetState) {
        this.mtsUtil.printTraceMessage(this.target, "NARMATCHTEXTSUBJECT.handleCommandCmdLiGetState() entered");
        this.target.getSpellerContext().getActiveField().setDSIState(cmdLiGetState.liGetStateResult_spellerState);
    }

    @Override
    public void handleCommandCmdRequestValueListByListIndex(CmdRequestValueListByListIndex cmdRequestValueListByListIndex) {
        this.mtsUtil.printTraceMessage(this.target, "NARMATCHTEXTSUBJECT.handleCommandCmdRequestValueListByListIndex() entered");
        this.mtsUtil.updateLists(this.target, cmdRequestValueListByListIndex, this.list);
        this.mtsUtil.setCharsAndCursor(this.target, cmdRequestValueListByListIndex);
        this.mtsUtil.printList(this.target, cmdRequestValueListByListIndex.liValueList_lispValueList.list);
        ModelUpdater.updateListCount((int)cmdRequestValueListByListIndex.liValueList_lispValueListCount, this.selectionCriterion);
        ModelUpdater.updateSpellerData(this.target.getSpellerContext().getActiveField().getSpellerData(), this.target.getSpellerContext().getActiveState());
        ServiceManager.aslPropertyManager.valueChangedBoolean(this.inputFieldReadyConst, true);
    }

    @Override
    public void handleCommandCmdStartSpeller(CmdStartSpeller cmdStartSpeller) {
        this.mtsUtil.printTraceMessage(this.target, "NARMATCHTEXTSUBJECT.handleCommandCmdStartSpeller() entered");
        this.mtsUtil.updateLists(this.target, cmdStartSpeller, this.list);
        this.mtsUtil.setCharsAndCursor(this.target, cmdStartSpeller);
        this.setMatchTextForPreview(cmdStartSpeller);
        ModelUpdater.updateListCount((int)cmdStartSpeller.liValueList_lispValueListCount, this.selectionCriterion);
        ModelUpdater.updateSpellerData(this.target.getSpellerContext().getActiveField().getSpellerData(), this.target.getSpellerContext().getActiveState());
        ServiceManager.aslPropertyManager.valueChangedBoolean(this.inputFieldReadyConst, true);
        this.mtsUtil.sendPositiveActionResults(this.target);
    }

    @Override
    public void handleCommandCmdAddChar(CmdAddChar cmdAddChar) {
        this.mtsUtil.printTraceMessage(this.target, "NARMATCHTEXTSUBJECT.handleCommandCmdAddChar() entered");
        this.addOrDeleteChars(cmdAddChar);
    }

    @Override
    public void handleCommandCmdUndoChar(CmdUndoChar cmdUndoChar) {
        this.mtsUtil.printTraceMessage(this.target, "NARMATCHTEXTSUBJECT.handleCommandCmdUndoChar() entered");
        if (cmdUndoChar.liValueList_lispValueListCount < 1L && cmdUndoChar.lispUpdateSpellerResult_lispCurrentInput.length() > 0) {
            new CmdUndoChar(this).execute();
        } else {
            this.addOrDeleteChars(cmdUndoChar);
        }
    }

    @Override
    public void handleCommandCmdRestoreState(CmdRestoreState cmdRestoreState) {
        this.mtsUtil.printTraceMessage(this.target, "NARMATCHTEXTSUBJECT.handleCommandCmdRestoreState() entered");
        this.mtsUtil.updateLists(this.target, cmdRestoreState, this.list);
        this.mtsUtil.setCharsAndCursor(this.target, cmdRestoreState);
        this.setMatchTextForPreview(cmdRestoreState);
        ModelUpdater.updateListCount((int)cmdRestoreState.liValueList_lispValueListCount, this.selectionCriterion);
        ModelUpdater.updateSpellerData(this.target.getSpellerContext().getActiveField().getSpellerData(), this.target.getSpellerContext().getActiveState());
        ServiceManager.aslPropertyManager.valueChangedBoolean(this.inputFieldReadyConst, true);
        this.mtsUtil.sendPositiveActionResults(this.target);
    }

    @Override
    public void handleCommandCmdGetLastCityHistoryEntry(CmdGetLastCityHistoryEntry cmdGetLastCityHistoryEntry) {
        this.mtsUtil.printTraceMessage(this.target, "NARMATCHTEXTSUBJECT.handleCommandCmdGetLastCityHistoryEntry() entered");
        NavLocation navLocation = cmdGetLastCityHistoryEntry.liGetLastCityHistoryEntryResult_matchedLocation;
        if (this.target.getLogger().isTraceEnabled()) {
            LogMessage logMessage = this.target.getLogger().makeTrace().append("setting city history location (using DSI): ");
            ASLNavigationUtilFactory.getNavigationUtilApi().getExtLoggerHelper().appendLocation(logMessage, navLocation);
        }
        new CmdSetCurrentLD(this, navLocation, true).execute();
    }

    private void addOrDeleteChars(CmdAbstractSpeller cmdAbstractSpeller) {
        int n = this.target.getSpellerContext().getActiveState();
        this.mtsUtil.updateLists(this.target, cmdAbstractSpeller, this.list);
        this.mtsUtil.setCharsAndCursor(this.target, cmdAbstractSpeller);
        this.setMatchTextForPreview(cmdAbstractSpeller);
        ModelUpdater.updateListCount((int)cmdAbstractSpeller.liValueList_lispValueListCount, this.selectionCriterion);
        ModelUpdater.updateSpellerData(this.target.getSpellerContext().getActiveField().getSpellerData(), n);
        ServiceManager.aslPropertyManager.valueChangedBoolean(this.inputFieldReadyConst, true);
        ModelUpdater.updateLocationInputInputFieldActionResult(true);
    }

    private void setMatchTextForPreview(CmdAbstractSpeller cmdAbstractSpeller) {
        String string = "";
        String string2 = this.target.getSpellerContext().getActiveField().getSpellerData().getEnteredText();
        if (cmdAbstractSpeller.liValueList_lispValueList != null && cmdAbstractSpeller.liValueList_lispValueList.list != null && cmdAbstractSpeller.liValueList_lispValueList.list.length > 0) {
            String string3 = cmdAbstractSpeller.liValueList_lispValueList.list[0].data;
            if (string2.length() > 0) {
                this.matchAgainstCurrentHistory(string2);
                string = this.historyMatch ? this.historyMatchText : string3;
            }
        }
        this.target.getSpellerContext().getActiveField().getSpellerData().setMatchText(string);
        this.target.getSpellerContext().getActiveField().getSpellerData().setMatchCount((int)cmdAbstractSpeller.liValueList_lispValueListCount);
    }

    private void matchAgainstCurrentHistory(String string) {
        this.mtsUtil.printTraceMessage(this.target, "Entering NARMATCHTEXTSUBJECT:matchAgainstCurrentHistory");
        this.historyMatch = false;
        this.historyMatchId = 0L;
        this.historyMatchText = null;
        String string2 = string.toLowerCase();
        if (SpellerContext.ACTIVE_HISTORY_MODE == 10002) {
            LICityHistoryEntry[] lICityHistoryEntryArray = this.getCityHistory();
            if (string == null || string.length() == 0) {
                return;
            }
            if (lICityHistoryEntryArray != null) {
                for (int i2 = 0; i2 < lICityHistoryEntryArray.length; ++i2) {
                    String string3 = lICityHistoryEntryArray[i2].name;
                    String string4 = string3 == null ? "" : string3.toLowerCase();
                    boolean bl = string4.startsWith(string2);
                    if (!bl) continue;
                    this.historyMatch = true;
                    this.historyMatchId = lICityHistoryEntryArray[i2].id;
                    this.historyMatchText = lICityHistoryEntryArray[i2].name;
                    this.mtsUtil.printTraceMessage(this.target, new StringBuffer("NARMatchTextSubject: CITY-HISTORY: input '").append(string).append("' -> FOUND IN entry '").append(this.historyMatchText).append("' (id=").append(this.historyMatchId).append(")").toString());
                    return;
                }
                this.mtsUtil.printTraceMessage(this.target, new StringBuffer("NAR CITY-HISTORY: input= '").append(string).append("' -> NOT FOUND").toString());
                return;
            }
            this.mtsUtil.printWarning(this.target, "CITY-HISTORY: history not available or null");
            return;
        }
        if (SpellerContext.ACTIVE_HISTORY_MODE == 10003) {
            LIStreetHistoryEntry[] lIStreetHistoryEntryArray = this.getStreetHistory();
            if (lIStreetHistoryEntryArray != null) {
                if (string == null || string.length() == 0) {
                    this.mtsUtil.printTraceMessage(this.target, "STREET-HISTORY: ignore empty input string");
                    return;
                }
                for (int i3 = 0; i3 < lIStreetHistoryEntryArray.length; ++i3) {
                    if (!lIStreetHistoryEntryArray[i3].name.toLowerCase().startsWith(string.toLowerCase())) continue;
                    this.historyMatch = true;
                    this.historyMatchId = lIStreetHistoryEntryArray[i3].id;
                    this.historyMatchText = lIStreetHistoryEntryArray[i3].name;
                    StringBuffer stringBuffer = new StringBuffer("NARMatchTextSubject: STREET-HISTORY: input '").append(string).append("' FOUND IN entry '").append(this.historyMatchText).append("' (id=").append(this.historyMatchId).append(")");
                    this.mtsUtil.printTraceMessage(this.target, stringBuffer.toString());
                    return;
                }
                this.mtsUtil.printTraceMessage(this.target, new StringBuffer("NARMatchTextSubect: STREET-HISTORY: input '").append(string).append("' -> NOT FOUND").toString());
                return;
            }
            this.mtsUtil.printWarning(this.target, "NARMATCHTEXTSUBJECT:matchAgainstCurrentHistory -> STREET-HISTORY: history not available");
            return;
        }
    }

    public LICityHistoryEntry[] getCityHistory() {
        return ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getCityHistory();
    }

    public LIStreetHistoryEntry[] getStreetHistory() {
        return ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getStreetHistory();
    }

    private void clearHistoryRelatedVariables() {
        this.mtsUtil.printTraceMessage(this.target, "NARMATCHTEXTSUBJECT:clearHistoryRelatedVariables -> Clearing all history related variables");
        this.historyMatch = false;
        this.historyMatchId = 0L;
        this.historyMatchText = "";
    }

    private void setShortValueListMode() {
        if (!SpellerContext.useShortLiValueList) {
            this.mtsUtil.printTraceMessage(this.target, "NARMATCHTEXTSUBJECT:setShortValueListMode -> setShortValueListMode: Setting liValueListWindowSize = 1");
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

    @Override
    public void handleCommandCmdSetCurrentLD(CmdSetCurrentLD cmdSetCurrentLD) {
        NavLocation navLocation = cmdSetCurrentLD.liCurrentState_liCurrentLD;
        if (navLocation == null) {
            ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper();
            navLocation = iLocationWrapper.getLocation();
        }
        if (this.target.getLogger().isTraceEnabled()) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getExtLoggerHelper().appendLocation(this.target.getLogger().makeTrace().append(" NARMATCHTEXTSUBJECT->handleCommandCmdSetCurrentLD location: "), navLocation).log();
        }
        ModelUpdater.updateNextAvailableCriterions(cmdSetCurrentLD.liCurrentState_availableSelectionCriteria, navLocation, this.target);
        ModelUpdater.setHousenumberSpellerToUse(cmdSetCurrentLD.liCurrentState_usefulRefinementCriteria, this.target);
        ModelUpdater.updateLocation(navLocation, this.target);
        ModelUpdater.updateLocationResolved(true);
        this.mtsUtil.updateMap(this.target, navLocation);
        this.mtsUtil.printAvailableCriterions(this.target, cmdSetCurrentLD.liCurrentState_availableSelectionCriteria);
        this.target.getSpellerContext().setLocation(navLocation);
        if (this.target.getSpellerContext().getActiveField() != null) {
            ModelUpdater.updateSpellerData(this.target.getSpellerContext().getActiveField().getSpellerData(), this.target.getSpellerContext().getActiveState());
        }
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(83);
        ModelUpdater.updateLocationInputActionResult(true);
        ModelUpdater.updateLocationInputInputFieldActionResult(true);
        new CmdSetCountryForCityAndStreetHistory(this, navLocation.getCountryAbbreviation()).execute();
    }
}

