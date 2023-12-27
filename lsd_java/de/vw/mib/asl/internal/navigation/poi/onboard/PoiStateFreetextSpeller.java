/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.onboard;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListViewListener;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdPoiSelectSelectionCriteria;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdRequestValueListByListIndex;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdRestoreState;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSelectByCategoryUid;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSetInput;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdStartSpeller;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiAbstractElementCommon;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiDatapool;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiHsmTarget;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateDetail;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateElementSurrounding;
import de.vw.mib.asl.internal.navigation.poi.transformer.PoiResultListCollector;
import de.vw.mib.asl.internal.navigation.util.NaviHelper;
import de.vw.mib.asl.internal.navigation.util.SpellerDataHelper;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.properties.values.SpellerData;
import org.dsi.ifc.navigation.LISpellerData;
import org.dsi.ifc.navigation.LIValueList;

public class PoiStateFreetextSpeller
extends PoiAbstractElementCommon
implements ASLListViewListener {
    public static LISpellerData parentPOIState = null;
    private boolean ignoreResultList = false;
    public static boolean stopRequestingValueList = false;
    private boolean searchTerminated = true;
    public static boolean liveSearchStarted = false;
    private boolean myScrollingFlag = false;
    private boolean secondPartOfHwrLiveListAvailable = false;
    private boolean isRequestRunning = false;
    private String nextStringToRequest = "";
    private boolean cancelFlag = false;

    public PoiStateFreetextSpeller(PoiHsmTarget poiHsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(poiHsmTarget, hsm, string, hsmState);
        this.myTarget = poiHsmTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this).append("Received event ID:").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.myTarget.myTrace(this, "HSM_ENTRY");
                break;
            }
            case 3: {
                this.myTarget.myTrace(this, "HSM_START");
                this.handleHsmStart();
                break;
            }
            case 1073744228: {
                this.storePreviousInputString();
                hsmState = this.myParent;
                break;
            }
            case 4: {
                this.myTarget.myTrace(this, "HSM_EXIT");
                break;
            }
            case 1073742512: {
                this.myTarget.myTrace(this, "ASL_NAVIGATION_POI_SEARCH_SET_NAME");
                this.initializeThesaurusSearch();
                break;
            }
            case 1073742514: {
                this.myTarget.myTrace(this, "ASL_NAVIGATION_POI_SEARCH_SET_NAME_SET_CHAR");
                this.characterAddedInFreetextSpeller(eventGeneric.getString(0));
                break;
            }
            case 1073742513: {
                this.myTarget.myTrace(this, "ASL_NAVIGATION_POI_SEARCH_SET_NAME_DEL_CHAR");
                this.characterDeletedInFreetextSpeller();
                break;
            }
            case 1073742515: {
                this.myTarget.myTrace(this, "ASL_NAVIGATION_POI_SEARCH_SET_NAME_SET_CURSOR_POSITION");
                this.cursorPositionSetInFreetextSpeller(eventGeneric.getInt(0));
                break;
            }
            case 1074841871: {
                this.myTarget.myTrace(this, "SEARCH_SET_NAME_SET_CHAR_HWR");
                this.searchSetNameSetCharHwr(eventGeneric.getString(0), eventGeneric.getInt(1), eventGeneric.getInt(2), eventGeneric.getInt(3));
                break;
            }
            case 1074841872: {
                this.myTarget.myTrace(this, "SEARCH_SET_NAME_DEL_ALL_CHARS");
                this.searchSetNameDelAllChars();
                break;
            }
            case 1074841873: {
                this.myTarget.myTrace(this, "SET_HWR_SPELLER_MODE_ENABLED");
                this.setHwrSpellerModeEnabled(eventGeneric.getBoolean(0));
                break;
            }
            case 1073742502: {
                this.myTarget.myTrace(this, "ASL_NAVIGATION_POI_RESULT_SELECT_DETAILS");
                this.currentIndexForPoiDetailView = eventGeneric.getInt(0);
                this.selectPoiElementWithoutChildren(this.currentIndexForPoiDetailView);
                break;
            }
            case 1073742503: {
                this.myTarget.myTrace(this, "ASL_NAVIGATION_POI_RESULT_SELECT_NEXT_DETAILS");
                this.selectPoiElementWithoutChildren(++this.currentIndexForPoiDetailView);
                break;
            }
            case 1073742504: {
                this.myTarget.myTrace(this, "ASL_NAVIGATION_POI_RESULT_SELECT_PREV_DETAILS");
                this.selectPoiElementWithoutChildren(--this.currentIndexForPoiDetailView);
                break;
            }
            case 1073742511: {
                this.myTarget.myTrace(this, "ASL_NAVIGATION_POI_SEARCH_RESULT_DETAIL_VIEW_CLOSE");
                this.myTarget.notifierModel.notifyNaviPoiDataLoadFinished();
                break;
            }
            case 1074841923: {
                this.myTarget.myTrace(this, "NAME_SPELLER_CANCELED");
                this.nameSpellerCanceled();
                break;
            }
            case 1074841893: {
                this.myTarget.myTrace(this, "NAME_SPELLER_ENTERED");
                this.nameSpellerEntered();
                break;
            }
            case 1074841895: {
                this.myTarget.myTrace(this, "SEARCH_SET_NAME_UPDATE_SEPARATORS");
                this.updateSeparatorString(eventGeneric.getString(0));
                break;
            }
            case 1074841894: {
                this.myTarget.myTrace(this, "NAME_SPELLER_OK_PRESSED");
                this.nameSpellerOkPressed(eventGeneric.getString(0));
                break;
            }
            case 1074841908: {
                this.myTarget.myTrace(this, "EXPAND_HWR_LIVE_SEARCH_PREVIEWLINE");
                this.expandHwrLiveSearchPreviewline();
                break;
            }
            default: {
                if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
                    this.myTarget.makeTrace(this).append("Received event which is not handled in this state (ID=").append(eventGeneric.getReceiverEventId()).append(")").log();
                }
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private void storePreviousInputString() {
        if (!this.cancelFlag) {
            this.setPreviousInputString(PoiDatapool.getInstance().getEnteredName());
        }
    }

    private void handleHsmStart() {
        this.myTarget.myTrace(this, "handleHsmStart");
        this.isRequestRunning = false;
        this.nextStringToRequest = "";
        if (this.isLiveSearch()) {
            this.updateLiveSearch();
        }
    }

    private void initializeThesaurusSearch() {
        this.myTarget.myTrace(this, "initializeThesaurusSearch");
        this.myTarget.notifierModel.notifyNameFilter(PoiDatapool.getInstance().getFilterName());
        PoiDatapool.getInstance().setCurrentUseCase(14);
        this.inputStringValid();
    }

    private void characterAddedInFreetextSpeller(String string) {
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this).append("Character:").append(string).log();
        }
        SpellerData spellerData = PoiDatapool.getInstance().getSpellerData();
        SpellerDataHelper.addChar(spellerData, string);
        PoiDatapool.getInstance().setEnteredName(spellerData.getEnteredText());
        this.myTarget.notifierModel.notifySpellerData(spellerData);
        this.inputStringValid();
    }

    private void characterDeletedInFreetextSpeller() {
        this.myTarget.myTrace(this, "Character deleted.");
        this.resetHwrLiveListSearch();
        SpellerData spellerData = PoiDatapool.getInstance().getSpellerData();
        SpellerDataHelper.deleteChar(spellerData);
        PoiDatapool.getInstance().setEnteredName(spellerData.getEnteredText());
        this.myTarget.notifierModel.notifySpellerData(spellerData);
        this.inputStringValid();
        if (this.isLiveSearch()) {
            this.updateLiveSearch();
        }
    }

    private void cursorPositionSetInFreetextSpeller(int n) {
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this).append("Cursor position set to: ").append(n).log();
        }
        SpellerData spellerData = PoiDatapool.getInstance().getSpellerData();
        spellerData.setCursorPosition(n);
        this.myTarget.notifierModel.notifySpellerData(spellerData);
    }

    private void inputStringValid() {
        this.myTarget.myTrace(this, "inputStringValid()");
        this.myTarget.notifierModel.notifySpellerCharacterEntered(PoiDatapool.getInstance().getEnteredName().length() != 0);
    }

    private void searchSetNameSetCharHwr(String string, int n, int n2, int n3) {
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this).append("searchSetNameSetCharHwr:").append(string).append(" cursorpos:").append(n).append(" selectionStart:").append(n2).append(" selectionEnd").append(n3).log();
        }
        SpellerData spellerData = PoiDatapool.getInstance().getSpellerData();
        SpellerDataHelper.addChar(spellerData, string);
        PoiDatapool.getInstance().setEnteredName(spellerData.getEnteredText());
        spellerData.setSelectionStart(n2);
        spellerData.setSelectionEnd(n3);
        this.myTarget.notifierModel.notifySpellerData(spellerData);
        this.inputStringValid();
        if (this.isLiveSearch()) {
            this.updateLiveSearch();
        }
    }

    private void searchSetNameDelAllChars() {
        this.myTarget.myTrace(this, "searchSetNameDelAllChars()");
        this.resetHwrLiveListSearch();
        SpellerData spellerData = PoiDatapool.getInstance().getSpellerData();
        SpellerDataHelper.clear(spellerData);
        PoiDatapool.getInstance().setEnteredName("");
        this.setPreviousInputString("");
        this.myTarget.notifierModel.notifySpellerData(spellerData);
        if (this.isLiveSearch()) {
            this.updateLiveSearch();
        }
    }

    private void setHwrSpellerModeEnabled(boolean bl) {
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this).append("setHwrSpellerModeEnabled:").append(bl ? "true" : "false").log();
        }
        PoiDatapool.getInstance().setHwrActive(bl);
        ServiceManager.aslPropertyManager.valueChangedBoolean(1127358464, bl);
        if (!bl) {
            liveSearchStarted = false;
            this.isRequestRunning = false;
            this.nextStringToRequest = "";
            this.clearModelData();
            this.resetHwrLiveListSearch();
        }
    }

    private boolean isLiveSearch() {
        this.myTarget.myTrace(this, "isLiveSearch()");
        boolean bl = false;
        if (PoiDatapool.getInstance().isHwrActive() && (PoiDatapool.getInstance().getCurrentUseCase() == 0xF800000 || PoiDatapool.getInstance().getCurrentUseCase() == 19)) {
            bl = true;
        }
        return bl;
    }

    private void updateLiveSearch() {
        this.myTarget.myTrace(this, "updateLiveSearch()");
        if (PoiDatapool.getInstance().getSpellerData().getEnteredText().length() == 0) {
            this.clearModelData();
            this.resetHwrLiveListSearch();
            this.myTarget.notifierModel.notifyNaviPoiDataLoadFinished();
            return;
        }
        PoiStateElementSurrounding.ignoreUpdates = false;
        if (!PoiAbstractElementCommon.continueSearch) {
            if (!liveSearchStarted) {
                PoiDatapool.getInstance().setFilterCategoryUid(PoiDatapool.getInstance().getCategoryUidForUidSearch());
                this.clearModelData();
                this.resetHwrLiveListSearch();
                this.requestPOIElements();
            } else {
                String string = PoiDatapool.getInstance().getSpellerData().getEnteredText();
                if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
                    this.myTarget.makeTrace(this).append("newInputString:").append(string).log();
                    this.myTarget.makeTrace(this).append("previousInputString:").append(this.getPreviousInputString()).log();
                }
                if (!string.equals(this.getPreviousInputString())) {
                    this.clearModelData();
                    this.resetHwrLiveListSearch();
                    if (this.isRequestRunning) {
                        this.nextStringToRequest = PoiDatapool.getInstance().getSpellerData().getEnteredText();
                        this.myTarget.myTrace(this, "Optimization: don't request string while previous request is running.");
                    } else {
                        this.myTarget.myTrace(this, "CmdSetInput");
                        new CmdSetInput(this, string, false).execute();
                        this.isRequestRunning = true;
                        this.nextStringToRequest = "";
                    }
                    this.setPreviousInputString(PoiDatapool.getInstance().getSpellerData().getEnteredText());
                } else {
                    this.myTarget.myTrace(this, "Optimization: surpress liSetInput because of identical input string.");
                }
            }
        } else {
            PoiAbstractElementCommon.continueSearch = false;
            this.myTarget.myTrace(this, "CmdRestoreState");
            new CmdRestoreState(this, parentPOIState).execute();
            stopRequestingValueList = false;
            this.myTarget.notifierModel.notifyNaviPoiDataLoadFinished();
        }
    }

    private void nameSpellerCanceled() {
        this.cancelFlag = true;
        this.resetHwrLiveListSearch();
        SpellerData spellerData = PoiDatapool.getInstance().getSpellerData();
        SpellerDataHelper.clear(spellerData);
        PoiDatapool.getInstance().setEnteredName(this.getPreviousInputString());
        this.myTarget.notifierModel.notifySpellerData(spellerData);
        if (this.isLiveSearch()) {
            this.updateLiveSearch();
        }
    }

    private void nameSpellerEntered() {
        this.myTarget.myTrace(this, "nameSpellerEntered()");
        if (PoiDatapool.getInstance().getFreetextSpellerMode() == 1) {
            if (PoiDatapool.getInstance().getXt9Databases() != null && PoiDatapool.getInstance().getXt9Databases().length > 0) {
                PoiDatapool.getInstance().getSpellerData().setWordDatabaseNames(PoiDatapool.getInstance().getXt9Databases());
            } else {
                PoiDatapool.getInstance().getSpellerData().setWordDatabaseNames(new String[0]);
            }
        } else {
            PoiDatapool.getInstance().getSpellerData().setWordDatabaseNames(new String[0]);
        }
        this.cancelFlag = false;
        this.myTarget.notifierModel.notifySpellerData(PoiDatapool.getInstance().getSpellerData());
    }

    private void updateSeparatorString(String string) {
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this).append("updateSeparatorString() Entered name with separators:").append(string != null ? string : "NULL").log();
        }
        PoiDatapool.getInstance().setFilterNameWithSeparators(string);
    }

    private void nameSpellerOkPressed(String string) {
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this).append("nameSpellerOkPressed() Entered name:").append(string != null ? string : "NULL").log();
        }
    }

    private void requestPOIElements() {
        this.myTarget.myTrace(this, "requestPOIElements()");
        PoiDatapool.getInstance().setCurrentUseCase(19);
        this.myTarget.getDsiNavigation().poiSetSortOrder2(0);
        this.myTarget.getDsiNavigation().poiSetContext(PoiDatapool.getInstance().getAreaLocation().getLocation());
        this.myTarget.getDsiNavigation().poiSetListStyle(1);
        PoiStateDetail.isChild = false;
        this.ignoreResultList = false;
        this.availableItems = 0;
        this.myScrollingFlag = false;
        this.secondPartOfHwrLiveListAvailable = false;
        liveSearchStarted = true;
        stopRequestingValueList = false;
        this.isRequestRunning = true;
        this.nextStringToRequest = "";
        if (PoiDatapool.getInstance().getFilterCategoryUid() == -1) {
            this.myTarget.notifierModel.notifySearchStateSearching();
            this.myTarget.setLiValueListWindowSize(this, 0, true);
            this.myTarget.myTrace(this, "CmdStartSpeller");
            new CmdStartSpeller(this, 0x11800000, false, false, false).execute();
            this.myTarget.setLiValueListWindowSize(this, -1, false);
            this.myTarget.myTrace(this, "CmdSetInput");
            new CmdSetInput(this, PoiDatapool.getInstance().getSpellerData().getEnteredText(), false).execute();
            this.setPreviousInputString(PoiDatapool.getInstance().getSpellerData().getEnteredText());
        } else {
            this.ignoreResultList = true;
            this.myTarget.setLiValueListWindowSize(this, 0, true);
            this.myTarget.myTrace(this, "CmdStartSpeller");
            new CmdStartSpeller(this, 0xF800000, false, false, false).execute();
            this.myTarget.myTrace(this, "CmdSelectByCategoryUid");
            new CmdSelectByCategoryUid(this, PoiDatapool.getInstance().getFilterCategoryUid()).execute();
        }
    }

    @Override
    public void listViewUpdated(ASLList aSLList, int n, int n2, Object[] objectArray) {
        boolean bl;
        this.myTarget.myTrace(this, "listViewUpdated()");
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this).append("index:").append(n).append("  count:").append(n2).append("  secondPartOfHwrLiveListAvailable:").append(this.secondPartOfHwrLiveListAvailable ? "true" : "false").append("  searchTerminated:").append(this.searchTerminated ? "true" : "false").append("  myScrollingFlag:").append(this.myScrollingFlag ? "true" : "false").append("  list.getSize():").append(aSLList.getSize()).log();
        }
        if (!this.secondPartOfHwrLiveListAvailable || this.searchTerminated) {
            return;
        }
        boolean bl2 = bl = n == -1 && n2 == 0;
        if (bl) {
            this.myScrollingFlag = true;
        } else if (this.myScrollingFlag) {
            int n3 = aSLList.getSize();
            if (n + n2 >= n3 / 2) {
                try {
                    this.myTarget.triggerMe(-1769471744);
                }
                catch (GenericEventException genericEventException) {
                    ServiceManager.errorHandler.handleDsiError(genericEventException);
                }
            }
            this.myScrollingFlag = false;
        }
    }

    private void requestSecondPartOfHwrLiveList() {
        this.myTarget.myTrace(this, "requestSecondPartOfHwrLiveList()");
        if (this.secondPartOfHwrLiveListAvailable && !this.searchTerminated && PoiAbstractElementCommon.poiArrayList.size() < 200) {
            if (!stopRequestingValueList) {
                if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
                    this.myTarget.makeTrace(this).append("CmdRequestValueListByListIndex (").append(PoiAbstractElementCommon.poiResultList.length).append(")").log();
                }
                new CmdRequestValueListByListIndex(this, PoiAbstractElementCommon.poiResultList.length, true).execute();
                this.isRequestRunning = true;
            } else {
                this.myTarget.myTrace(this, "Requesting elements stopped, because selection was done while loading.");
            }
        } else {
            this.myTarget.notifierModel.notifySearchStateFound();
        }
        this.searchTerminated = true;
    }

    private void expandHwrLiveSearchPreviewline() {
        this.myTarget.myTrace(this, "expandHwrLiveSearchPreviewline()");
        this.requestSecondPartOfHwrLiveList();
    }

    private void resetHwrLiveListSearch() {
        this.myTarget.myTrace(this, "resetHwrLiveListSearch()");
        this.secondPartOfHwrLiveListAvailable = false;
        this.searchTerminated = false;
    }

    @Override
    public void handleCommandCmdStartSpeller(CmdStartSpeller cmdStartSpeller) {
        this.myTarget.myCmdTrace(this, cmdStartSpeller);
        if (cmdStartSpeller.liResult_ReturnCode != 0L) {
            if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
                this.myTarget.makeError(this).append("Error! returnCode=").append(cmdStartSpeller.liResult_ReturnCode).log();
            }
            return;
        }
        this.handleLIVALUELIST(cmdStartSpeller.liValueList_lispValueList);
        this.myTarget.notifierModel.notifyNaviPoiDataLoadFinished();
    }

    @Override
    public void handleCommandCmdRequestValueListByListIndex(CmdRequestValueListByListIndex cmdRequestValueListByListIndex) {
        this.myTarget.myCmdTrace(this, cmdRequestValueListByListIndex);
        this.isRequestRunning = false;
        if (cmdRequestValueListByListIndex.liResult_ReturnCode != 0L) {
            if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
                this.myTarget.makeError(this).append("Error! returnCode=").append(cmdRequestValueListByListIndex.liResult_ReturnCode).log();
            }
            return;
        }
        this.handleLIVALUELIST(cmdRequestValueListByListIndex.liValueList_lispValueList);
    }

    private void handleLIVALUELIST(LIValueList lIValueList) {
        this.myTarget.myTrace(this, "LIValueList list updated.");
        if (this.ignoreResultList) {
            this.myTarget.myTrace(this, "First liValueList ignored, because filter is active.");
            this.ignoreResultList = false;
            return;
        }
        if (PoiDatapool.getInstance().getSpellerData().getEnteredText().length() == 0) {
            this.clearModelData();
            this.resetHwrLiveListSearch();
            return;
        }
        if (this.nextStringToRequest.length() > 0) {
            this.clearModelData();
            this.resetHwrLiveListSearch();
            this.myTarget.myTrace(this, "Optimization: String changed during last request -> request new string.");
            this.myTarget.myTrace(this, "CmdSetInput");
            new CmdSetInput(this, PoiDatapool.getInstance().getSpellerData().getEnteredText(), false).execute();
            this.isRequestRunning = true;
            this.nextStringToRequest = "";
            this.setPreviousInputString(PoiDatapool.getInstance().getSpellerData().getEnteredText());
            return;
        }
        this.myTarget.setLiValueListWindowSize(this, -1, false);
        this.myTarget.notifierModel.notifySearchStateSearching();
        if (lIValueList != null && lIValueList.list != null) {
            if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
                this.myTarget.makeTrace(this).append("Length of LIValueList:").append(lIValueList.list.length).log();
            }
            if (lIValueList.list.length > 0) {
                this.appendValueListToResultList(lIValueList, 1);
                PoiAbstractElementCommon.poiResultList = new PoiResultListCollector[PoiAbstractElementCommon.poiArrayList.size()];
                PoiAbstractElementCommon.poiArrayList.toArray(PoiAbstractElementCommon.poiResultList);
                this.myTarget.notifierModel.notifyResultListItemsUpdateList(PoiAbstractElementCommon.poiResultList);
                if (lIValueList.isHasNextPage() && PoiAbstractElementCommon.poiArrayList.size() < 200) {
                    this.secondPartOfHwrLiveListAvailable = true;
                    this.myTarget.myTrace(this, "More elements are available...");
                } else {
                    this.myTarget.notifierModel.notifySearchStateFound();
                    this.secondPartOfHwrLiveListAvailable = false;
                    this.myTarget.myTrace(this, "Search terminated...");
                }
            }
        } else {
            this.myTarget.myTrace(this, "LIValueList == null");
            NaviHelper.getInstance().resetNaviContext("LIValueList == null");
        }
    }

    @Override
    public void handleCommandCmdRestoreState(CmdRestoreState cmdRestoreState) {
        this.myTarget.myCmdTrace(this, cmdRestoreState);
        if (cmdRestoreState.liResult_ReturnCode != 0L) {
            if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
                this.myTarget.makeError(this).append("Error! returnCode=").append(cmdRestoreState.liResult_ReturnCode).log();
            }
            return;
        }
    }

    @Override
    public void handleCommandCmdSetInput(CmdSetInput cmdSetInput) {
        this.myTarget.myCmdTrace(this, cmdSetInput);
        this.isRequestRunning = false;
        if (cmdSetInput.liResult_ReturnCode != 0L) {
            if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
                this.myTarget.makeError(this).append("Error! returnCode=").append(cmdSetInput.liResult_ReturnCode).log();
            }
            return;
        }
        this.handleLIVALUELIST(cmdSetInput.liValueList_lispValueList);
    }

    @Override
    public void handleCommandCmdSelectByCategoryUid(CmdSelectByCategoryUid cmdSelectByCategoryUid) {
        this.myTarget.myCmdTrace(this, cmdSelectByCategoryUid);
        this.myTarget.setLiValueListWindowSize(this, 0, false);
        this.ignoreResultList = true;
        if (!this.myTarget.selectCriterionInPOIValueList(this, cmdSelectByCategoryUid.liValueList_lispValueList, 25)) {
            // empty if block
        }
        if (PoiDatapool.getInstance().getCurrentUseCase() == 19) {
            this.myTarget.setLiValueListWindowSize(this, -1, false);
            this.myTarget.myTrace(this, "CmdSetInput");
            new CmdSetInput(this, PoiDatapool.getInstance().getSpellerData().getEnteredText(), false).execute();
            this.setPreviousInputString(PoiDatapool.getInstance().getSpellerData().getEnteredText());
        }
    }

    @Override
    public void handleCommandCmdPoiSelectSelectionCriteria(CmdPoiSelectSelectionCriteria cmdPoiSelectSelectionCriteria) {
        this.myTarget.myCmdTrace(this, cmdPoiSelectSelectionCriteria);
        if (cmdPoiSelectSelectionCriteria.liResult_ReturnCode != 0L) {
            if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
                this.myTarget.makeError(this).append("Error! returnCode=").append(cmdPoiSelectSelectionCriteria.liResult_ReturnCode).log();
            }
            return;
        }
        this.handleLIVALUELIST(cmdPoiSelectSelectionCriteria.liValueList_lispValueList);
    }

    protected String getPreviousInputString() {
        return PoiDatapool.getInstance().getFreetextSpellerPreviousInputString();
    }

    protected void setPreviousInputString(String string) {
        PoiDatapool.getInstance().setFreetextSpellerPreviousInputString(string);
    }
}

