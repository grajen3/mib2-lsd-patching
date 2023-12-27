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
import de.vw.mib.asl.internal.navigation.gateway.command.CmdLastCityHistoryAdd;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdLastStateHistoryAdd;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdLiGetState;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdRequestValueListByListIndex;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdRestoreState;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSelectListItem;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSelectListItemByIdent;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSetCountryForCityAndStreetHistory;
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
import de.vw.mib.asl.internal.navigation.spellerx.util.DataHelper;
import de.vw.mib.asl.internal.navigation.spellerx.util.MatchTextSubjectUtil;
import de.vw.mib.properties.values.SpellerData;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LICityHistoryEntry;
import org.dsi.ifc.navigation.LIStreetHistoryEntry;

public class JapanMatchTextSubject
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
    private boolean historyMatch;
    private long historyMatchId;
    private String historyMatchText;
    private String characterQueue = "";
    private String enteredString = "";
    private MatchTextSubjectUtil mtsUtil = new MatchTextSubjectUtil();

    public JapanMatchTextSubject(XSpellerTarget xSpellerTarget, int n, int n2, ModelListHandler modelListHandler, ModelListHandler modelListHandler2, int n3, boolean bl, boolean bl2, boolean bl3) {
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

    public JapanMatchTextSubject(XSpellerTarget xSpellerTarget, int n, boolean bl, boolean bl2, boolean bl3) {
        this(xSpellerTarget, 0, 0, null, null, n, bl, bl2, bl3);
    }

    public void evtHSM_ENTRY(ISpellerContext iSpellerContext) {
        this.list.invalidateList();
        if (this.previewList != null) {
            this.previewList.invalidateList();
        }
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
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(107);
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(83);
    }

    public void evtEV_SELECT_VIA_INDEX(ISpellerContext iSpellerContext, int n) {
        this.mtsUtil.printTraceMessage(this.target, new StringBuffer("JAPANMATCHTEXTSBUJECT:evtEV_SELECT_VIA_INDEX: Selecting index: ").append(n).toString());
        this.evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_SELECT_MATCH(iSpellerContext, n);
    }

    public void evtEV_SELECT_VIA_ID(ISpellerContext iSpellerContext, String string) {
        this.mtsUtil.printTraceMessage(this.target, new StringBuffer().append("JAPANMATCHTEXTSBUJECT: Received event evtEV_SELECT_VIA_ID with objectId:").append(string).toString());
        if (string != null) {
            this.freezeLists();
            new CmdLiGetState(this).execute();
            new CmdSelectListItemByIdent(this, string).execute();
        } else {
            this.target.getLogger().warn("JAPANMATCHTEXTSBUJECT: objectId is null");
        }
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_SELECT_NOTHING(ISpellerContext iSpellerContext) {
        this.mtsUtil.printTraceMessage(this.target, "JAPANMATCHTEXTRSUBJECT: evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_SELECT_NOTHING entered");
        this.freezeLists();
        this.mtsUtil.handleSelectNothingEvent(this.target);
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILTER_BY_ADD_CHARACTER_HWR(ISpellerContext iSpellerContext, String string, int n, int n2, int n3) {
        this.mtsUtil.printTraceMessage(this.target, "Entering evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILTER_BY_ADD_CHARACTER_HWR ");
        if (!SpellerContext.hwrEnabled) {
            this.evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILTER_BY_ADD_CHARACTER(iSpellerContext, string);
        } else {
            this.target.getSpellerContext().getActiveField().getSpellerData().setSelectionStart(n2);
            this.target.getSpellerContext().getActiveField().getSpellerData().setSelectionEnd(n3);
            this.target.getSpellerContext().getActiveField().getSpellerData().setCursorPosition(n3);
            String string2 = this.enteredString.substring(0, n);
            this.enteredString = new StringBuffer().append(string2).append(string).toString();
            this.list.prepareListForUpdate();
            if (this.previewList != null) {
                this.previewList.prepareListForUpdate();
            }
            new CmdAddChar(this, string).execute();
        }
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_SELECT_PREVIEW(ISpellerContext iSpellerContext, int n) {
        this.freezeLists();
        new CmdLiGetState(this).execute();
        new CmdSelectListItem(this, n).execute();
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_SELECT_MATCH(ISpellerContext iSpellerContext, int n) {
        this.freezeLists();
        new CmdLiGetState(this).execute();
        new CmdSelectListItem(this, n).execute();
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_SELECT_FIRST_MATCH(ISpellerContext iSpellerContext) {
        this.freezeLists();
        new CmdLiGetState(this).execute();
        new CmdSelectListItem(this, 0).execute();
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILTER_BY_ADD_CHARACTER(ISpellerContext iSpellerContext, String string) {
        this.list.prepareListForUpdate();
        if (this.previewList != null) {
            this.previewList.prepareListForUpdate();
        }
        this.enteredString = new StringBuffer(this.target.getSpellerContext().getActiveField().getSpellerData().getEnteredText()).append(string).toString();
        this.setShortValueListMode();
        this.mtsUtil.printTraceMessage(this.target, new StringBuffer("ADD_CHARACTER: Sending (adding) characters by sending cmdSetinput to southside. String: ").append(this.enteredString).toString());
        new CmdAddChar(this, string).execute();
        this.updateSpellerWithAllCharactersAvailable();
        this.setNvcSpellerInputString(this.enteredString);
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILTER_BY_CLEAR_ALL_CHARACTERS(ISpellerContext iSpellerContext) {
        SpellerContext.clearAllCalled = true;
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

    void setNvcSpellerInputString(String string) {
        SpellerData spellerData = this.target.getSpellerContext().getActiveField().getSpellerData();
        spellerData = DataHelper.setSpellerDataInput(spellerData, string);
        this.target.getSpellerContext().getActiveField().setSpellerData(spellerData);
        ModelUpdater.updateSpellerData(this.target.getSpellerContext().getActiveField().getSpellerData(), SpellerContext.ACTIVE_STATE);
    }

    private void updateSpellerWithAllCharactersAvailable() {
        this.target.getSpellerContext().getActiveField().getSpellerData().setAvailableCharacters("\u0007");
        ModelUpdater.updateSpellerData(this.target.getSpellerContext().getActiveField().getSpellerData(), SpellerContext.ACTIVE_STATE);
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILTER_BY_UNDO_LAST_CHARACTERS(ISpellerContext iSpellerContext) {
        this.target.getSpellerContext().getActiveField().getSpellerData().setSelectionStart(0);
        this.target.getSpellerContext().getActiveField().getSpellerData().setSelectionEnd(0);
        this.list.prepareListForUpdate();
        if (this.previewList != null) {
            this.previewList.prepareListForUpdate();
        }
        if (this.characterQueue.length() > 0) {
            this.characterQueue = this.characterQueue.substring(0, this.characterQueue.length() - 1);
        } else if (this.enteredString.length() > 0) {
            this.enteredString = this.enteredString.substring(0, this.enteredString.length() - 1);
            this.mtsUtil.printTraceMessage(this.target, "JAPANAMATCHTEXTSUBJECT.evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILTER_BY_UNDO_LAST_CHARACTERS: Removing character from southside ( via CmdUndoChar)");
            this.setShortValueListMode();
            new CmdUndoChar(this).execute();
        }
    }

    protected void storeHistory(NavLocation navLocation) {
        switch (this.selectionCriterion) {
            case 138: {
                if (navLocation != null) {
                    new CmdSetCountryForCityAndStreetHistory(this, navLocation.getCountryAbbreviation()).execute();
                    String string = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation).getState();
                    new CmdLastStateHistoryAdd(this, navLocation, true, string).execute();
                    break;
                }
                this.mtsUtil.printWarning(this.target, "JAPANMATCHTEXTSBUJECT.storeHistory() the currentLD must not be null or should containt non-null country abbreviation data. History of prefecture may not be handled correctly.");
                break;
            }
            case 2: {
                if (navLocation != null) {
                    String string = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation).getCity();
                    if (string == null) break;
                    new CmdLastCityHistoryAdd(this, navLocation, false, string).execute();
                    break;
                }
                this.mtsUtil.printWarning(this.target, "JAPANMATCHTEXTSBUJECT.storeHistory() the currentLD must not be null. History of municipality may not be handled correctly.");
                break;
            }
        }
    }

    @Override
    public void handleCommandCmdSelectListItem(CmdSelectListItem cmdSelectListItem) {
        this.mtsUtil.printTraceMessage(this.target, "JAPANMATCHTEXTSBUJECT.handleCommandCmdSelectListItem() called");
        this.mtsUtil.handleSelect(cmdSelectListItem, this.target, cmdSelectListItem.liCurrentState_liCurrentLD, cmdSelectListItem.liCurrentState_availableSelectionCriteria, this.inputFieldReadyConst, true);
        this.storeHistory(cmdSelectListItem.liCurrentState_liCurrentLD);
    }

    @Override
    public void handleCommandCmdSelectListItemByIdent(CmdSelectListItemByIdent cmdSelectListItemByIdent) {
        this.mtsUtil.printTraceMessage(this.target, "JAPANMATCHTEXTSBUJECT.handleCommandCmdSelectListItemByIdent() called");
        ModelUpdater.setHousenumberSpellerToUse(cmdSelectListItemByIdent.liCurrentState_usefulRefinementCriteria, this.target);
        this.mtsUtil.handleSelect(cmdSelectListItemByIdent, this.target, cmdSelectListItemByIdent.liCurrentState_liCurrentLD, cmdSelectListItemByIdent.liCurrentState_availableSelectionCriteria, this.inputFieldReadyConst, true);
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
        ServiceManager.aslPropertyManager.valueChangedBoolean(this.inputFieldReadyConst, true);
    }

    @Override
    public void handleCommandCmdStartSpeller(CmdStartSpeller cmdStartSpeller) {
        this.mtsUtil.printTraceMessage(this.target, "JAPANMATCHTEXTSBUJECT.handleCommandCmdStartSpeller() called");
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
        this.mtsUtil.updateLists(this.target, cmdRestoreState, this.list, this.previewList);
        this.mtsUtil.setCharsAndCursor(this.target, cmdRestoreState);
        this.setMatchTextForPreview(cmdRestoreState);
        ModelUpdater.updateNextAvailableCriterions(cmdRestoreState.liCurrentState_availableSelectionCriteria, cmdRestoreState.liCurrentState_liCurrentLD, this.target);
        ModelUpdater.updateListCount((int)cmdRestoreState.liValueList_lispValueListCount, this.selectionCriterion);
        ModelUpdater.updateSpellerData(this.target.getSpellerContext().getActiveField().getSpellerData(), this.target.getSpellerContext().getActiveState());
        ServiceManager.aslPropertyManager.valueChangedBoolean(this.inputFieldReadyConst, true);
        this.mtsUtil.sendPositiveActionResults(this.target);
    }

    private void setMatchTextForPreview(CmdAbstractSpeller cmdAbstractSpeller) {
        String string = this.target.getSpellerContext().getActiveField().getSpellerData().getEnteredText();
        if (cmdAbstractSpeller.liValueList_lispValueList != null && cmdAbstractSpeller.liValueList_lispValueList.list != null && cmdAbstractSpeller.liValueList_lispValueList.list.length > 0 && string.length() > 0) {
            this.matchAgainstCurrentHistory(string);
        }
        this.target.getSpellerContext().getActiveField().getSpellerData().setMatchText("");
        this.target.getSpellerContext().getActiveField().getSpellerData().setMatchCount((int)cmdAbstractSpeller.liValueList_lispValueListCount);
    }

    private void matchAgainstCurrentHistory(String string) {
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
                    if (this.target.getLogger().isTraceEnabled()) {
                        this.target.getLogger().makeTrace().append("CITY-HISTORY: input '").append(string).append("' -> FOUND IN entry '").append(this.historyMatchText).append("' (id=").append(this.historyMatchId).append(")").log();
                    }
                    return;
                }
                if (this.target.getLogger().isTraceEnabled()) {
                    this.target.getLogger().makeTrace().append("CITY-HISTORY: input '").append(string).append("' -> NOT FOUND").log();
                }
                return;
            }
            return;
        }
        if (SpellerContext.ACTIVE_HISTORY_MODE == 10003) {
            LIStreetHistoryEntry[] lIStreetHistoryEntryArray = this.getStreetHistory();
            if (lIStreetHistoryEntryArray != null) {
                if (string == null || string.length() == 0) {
                    if (this.target.getLogger().isTraceEnabled()) {
                        this.target.getLogger().makeTrace().append("STREET-HISTORY: ignore empty input string").log();
                    }
                    return;
                }
                for (int i3 = 0; i3 < lIStreetHistoryEntryArray.length; ++i3) {
                    if (!lIStreetHistoryEntryArray[i3].name.toLowerCase().startsWith(string.toLowerCase())) continue;
                    this.historyMatch = true;
                    this.historyMatchId = lIStreetHistoryEntryArray[i3].id;
                    this.historyMatchText = lIStreetHistoryEntryArray[i3].name;
                    if (this.target.getLogger().isTraceEnabled()) {
                        this.target.getLogger().makeTrace().append("STREET-HISTORY: input '").append(string).append("' FOUND IN entry '").append(this.historyMatchText).append("' (id=").append(this.historyMatchId).append(")").log();
                    }
                    return;
                }
                if (this.target.getLogger().isTraceEnabled()) {
                    this.target.getLogger().makeTrace().append("STREET-HISTORY: input '").append(string).append("' -> NOT FOUND").log();
                }
                return;
            }
            if (this.target.getLogger().isTraceEnabled()) {
                this.target.getLogger().makeTrace().append("STREET-HISTORY: history not available").log();
            }
            return;
        }
    }

    public LICityHistoryEntry[] getCityHistory() {
        return ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getCityHistory();
    }

    public LIStreetHistoryEntry[] getStreetHistory() {
        return ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getStreetHistory();
    }

    private void setShortValueListMode() {
        if (!SpellerContext.useShortLiValueList) {
            this.mtsUtil.printTraceMessage(this.target, "setShortValueListMode: Setting liValueListWindowSize = 1");
            new CmdSetLiValueListWindowSize(this, 1).execute();
        }
    }

    private void freezeLists() {
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

    @Override
    public void handleCommandCmdSetCountryForCityAndStreetHistory(CmdSetCountryForCityAndStreetHistory cmdSetCountryForCityAndStreetHistory) {
        this.mtsUtil.printTraceMessage(this.target, "Entering JapanMatchTextSubject.handleCommandCmdSetCountryForCityAndStreetHistory()");
        ModelUpdater.updateLocationInputInputFieldActionResult(true);
        ModelUpdater.updateLocationInputActionResult(true);
    }

    @Override
    public void handleCommandCmdLastStateHistoryAdd(CmdLastStateHistoryAdd cmdLastStateHistoryAdd) {
        this.mtsUtil.printTraceMessage(this.target, "Entering JapanMatchTextSubject.handleCommandCmdLastStateHistoryAdd()");
        ModelUpdater.updateLocationInputInputFieldActionResult(true);
        ModelUpdater.updateLocationInputActionResult(true);
    }

    @Override
    public void handleCommandCmdLastCityHistoryAdd(CmdLastCityHistoryAdd cmdLastCityHistoryAdd) {
        this.mtsUtil.printTraceMessage(this.target, "Entering JapanMatchTextSubject.handleCommandCmdLastCityHistoryAdd()");
        ModelUpdater.updateLocationInputInputFieldActionResult(true);
        ModelUpdater.updateLocationInputActionResult(true);
    }

    public boolean isHistoryMatch() {
        return this.historyMatch;
    }
}

