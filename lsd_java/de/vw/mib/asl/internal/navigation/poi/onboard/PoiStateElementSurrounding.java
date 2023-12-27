/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.onboard;

import de.vw.mib.asl.api.navigation.ASLNavigationTruffelFactory;
import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.util.StringUtil;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdCancelSpeller;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdLiGetState;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdPoiStartSpellerAlongRoute;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdPoiStartSpellerAlongRouteAdvanced;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdRequestValueListByListIndex;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdRestoreState;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSelectByCategoryUid;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSelectByMultipleCategoryUids;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSelectListItem;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSelectListItemPoi;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSetInput;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSetLiValueListWindowSize;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdStartSpeller;
import de.vw.mib.asl.internal.navigation.poi.onboard.DynamicPoiCategoryHandler;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiAbstractElementCommon;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiAbstractSubElementCommon;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiDatapool;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiHsmTarget;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateDetail;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateSelectFromResultList;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateSubElementSurrounding;
import de.vw.mib.asl.internal.navigation.poi.transformer.PoiResultListCollector;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import java.util.Vector;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LISpellerData;
import org.dsi.ifc.navigation.LIValueList;

public final class PoiStateElementSurrounding
extends PoiAbstractElementCommon {
    public static LISpellerData runningSearchState = null;
    public static boolean ignoreUpdates = false;
    static final int LIST_SEL_INDEX_ALL_GROUP_ITEM;
    static final int LIST_SEL_INDEX_NONE;
    private static int listSelection;
    boolean ignoreResultList = true;
    private int alongTheRouteSelCritDes;

    public PoiStateElementSurrounding(PoiHsmTarget poiHsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(poiHsmTarget, hsm, string, hsmState);
        this.setSelectionCriteriaForCurrentVariant();
    }

    private void setSelectionCriteriaForCurrentVariant() {
        boolean bl = ServiceManager.configManagerDiag.isFeatureFlagSet(70);
        boolean bl2 = ServiceManager.configManagerDiag.getNaviLocationOptionDefaultBoolean(1);
        boolean bl3 = ServiceManager.configManagerDiag.isFeatureFlagSet(75);
        this.alongTheRouteSelCritDes = bl && (bl2 || bl3) ? 0x11800000 : 0xB800000;
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
            case 4: {
                this.myTarget.myTrace(this, "HSM_EXIT");
                break;
            }
            case 3492006: {
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
            case 1073742502: {
                this.myTarget.myTrace(this, "ASL_NAVIGATION_POI_RESULT_SELECT_DETAILS");
                this.currentIndexForPoiDetailView = eventGeneric.getInt(0);
                this.selectPoiElementWithoutChildren(this.currentIndexForPoiDetailView);
                break;
            }
            case 1073742525: {
                this.myTarget.myTrace(this, "ASL_NAVIGATION_POI_SELECT_SEARCH_ELEMENT");
                this.selectPoiElementWithChildren(eventGeneric.getInt(0), eventGeneric.getInt(1));
                break;
            }
            case 1073742526: {
                this.myTarget.myTrace(this, "ASL_NAVIGATION_POI_SELECT_SEARCH_ELEMENT_CLOSE");
                this.childrenClosed();
                break;
            }
            case 1073742523: {
                this.myTarget.myTrace(this, "ASL_NAVIGATION_POI_SEARCH_VIEW_CLOSE");
                PoiAbstractElementCommon.isOnboardDualListViewActive = false;
                break;
            }
            case 3492005: {
                new CmdSetLiValueListWindowSize(this, eventGeneric.getInt(1)).execute();
                new CmdRequestValueListByListIndex(this, eventGeneric.getInt(0), true).execute();
                break;
            }
            case 1073742522: {
                this.myTarget.myTrace(this, "SEARCH_STOP");
                int n = PoiDatapool.getInstance().getCurrentUseCase();
                PoiAbstractElementCommon.searchIsRunning = false;
                this.setStopRequestingValueList(true);
                this.myTarget.makeTrace(this).append("PoiDatapool.currentUseCase=").append(n).log();
                if (n == 15 || this.isWaitWithCancelSpeller()) break;
                new CmdCancelSpeller(this).execute();
                break;
            }
            case 3488002: {
                this.selectByIndexSlde(eventGeneric);
                break;
            }
            case 3488005: {
                this.handleSldeRestoreSpeller();
                break;
            }
            case 3400031: {
                this.myTarget.myTrace(this, "ASL_NAVI_POI_ONBOARD_DUALLIST_RESULTS_ENTER_EXIT");
                PoiAbstractElementCommon.isOnboardDualListViewActive = eventGeneric.getBoolean(0);
                if (!PoiAbstractElementCommon.isOnboardDualListViewActive && PoiAbstractElementCommon.lastUsedPoiIndex > 0) {
                    this.setRequestRunning(true);
                    this.setStopRequestingValueList(true);
                    this.cutOffResultList(PoiAbstractElementCommon.lastUsedPoiIndex);
                    CmdLiGetState cmdLiGetState = new CmdLiGetState(this);
                    cmdLiGetState.setBlindArgument("DetailedPoi_SkipSaveState", new Object());
                    cmdLiGetState.execute();
                    if (!eventGeneric.getBoolean(1)) break;
                    PoiAbstractElementCommon.searchIsRunning = false;
                    new CmdCancelSpeller(this).execute();
                    break;
                }
                if (!PoiAbstractElementCommon.isOnboardDualListViewActive || !PoiAbstractElementCommon.searchIsRunning || PoiAbstractElementCommon.lastUsedPoiIndex <= 0) break;
                this.setRequestRunning(false);
                this.setStopRequestingValueList(false);
                this.dualListViewHandler.setForceRedraw();
                this.updateCuttedResultListAtHmi(PoiAbstractElementCommon.lastUsedPoiIndex);
                CmdRestoreState cmdRestoreState = new CmdRestoreState(this, PoiAbstractElementCommon.savedSpellerState);
                cmdRestoreState.setBlindArgument("DetailedPoi", new Object());
                cmdRestoreState.execute();
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

    static void setListSelectionIndex(int n) {
        listSelection = n;
    }

    private void handleSldeRestoreSpeller() {
        if (PoiAbstractElementCommon.poiResultList.length == 0) {
            if (PoiAbstractElementCommon.savedSpellerState != null) {
                PoiAbstractElementCommon.continueSearch = true;
                this.setStopRequestingValueList(false);
                this.setIgnoreResultList(true);
                new CmdRestoreState(this, PoiAbstractElementCommon.savedSpellerState).execute();
            } else if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
                this.myTarget.makeError(this).append("handleSldeRestoreSpeller: saved spellerState is null.").log();
            }
        }
    }

    private void selectByIndexSlde(EventGeneric eventGeneric) {
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this).append("PoiStateElementSurrounding selectByIndexSlde").log();
        }
        Integer n = (Integer)eventGeneric.getObject(54080768);
        int n2 = n;
        if (PoiAbstractElementCommon.poiResultList.length > 0) {
            if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
                this.myTarget.makeTrace(this).append("PoiStateElementSurrounding selectByIndexSlde getting location from copy").log();
            }
            if (n2 < PoiAbstractElementCommon.poiResultList.length) {
                NavLocation navLocation = PoiAbstractElementCommon.poiResultList[n2].poiNavLocation;
                ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setPOILocation(navLocation);
                ASLNavigationTruffelFactory.getNavigationTruffelApi().setSelectedSearchResult(navLocation, n);
            }
        } else {
            this.setStopRequestingValueList(true);
            new CmdLiGetState(this).execute();
            CmdSelectListItem cmdSelectListItem = new CmdSelectListItem(this, n2);
            cmdSelectListItem.setBlindArgument("SldeSelection", eventGeneric.getObject(54080768));
            cmdSelectListItem.execute();
        }
    }

    @Override
    public void handleCommandCmdStartSpeller(CmdStartSpeller cmdStartSpeller) {
        this.handleLiValueList(cmdStartSpeller);
    }

    @Override
    public void handleCommandCmdRequestValueListByListIndex(CmdRequestValueListByListIndex cmdRequestValueListByListIndex) {
        this.handleLiValueList(cmdRequestValueListByListIndex);
    }

    @Override
    public void handleCommandCmdSetInput(CmdSetInput cmdSetInput) {
        this.handleLiValueList(cmdSetInput);
    }

    @Override
    public void handleCommandCmdPoiStartSpellerAlongRoute(CmdPoiStartSpellerAlongRoute cmdPoiStartSpellerAlongRoute) {
        this.handleLiValueList(cmdPoiStartSpellerAlongRoute);
    }

    @Override
    public void handleCommandCmdPoiStartSpellerAlongRouteAdvanced(CmdPoiStartSpellerAlongRouteAdvanced cmdPoiStartSpellerAlongRouteAdvanced) {
        this.handleLiValueList(cmdPoiStartSpellerAlongRouteAdvanced);
    }

    @Override
    public void handleCommandCmdSelectListItemPoi(CmdSelectListItemPoi cmdSelectListItemPoi) {
        this.myTarget.myCmdTrace(this, cmdSelectListItemPoi);
        if (cmdSelectListItemPoi.liResult_ReturnCode != 0L) {
            if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
                this.myTarget.makeError(this).append("Error! returnCode=").append(cmdSelectListItemPoi.liResult_ReturnCode).log();
            }
            return;
        }
        this.handlePOIVALUELIST(cmdSelectListItemPoi.liValueList_lispValueList);
    }

    @Override
    public void handleCommandCmdSelectListItem(CmdSelectListItem cmdSelectListItem) {
        Object[] objectArray;
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this).append("PoiStateElementSurrounding handleCommandCmdSelectListItem enter").log();
        }
        if (cmdSelectListItem.liCurrentState_liCurrentLD == null || cmdSelectListItem.liResult_ReturnCode != 0L) {
            if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
                this.myTarget.makeError(this).append("Error! location null or returnCode=").append(cmdSelectListItem.liResult_ReturnCode).log();
            }
            ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().resetNaviContext("lispSelectListItem didn't succeed on southside - Returned location is null or returncode not ok");
            return;
        }
        if (PoiDatapool.getInstance().isSpecialSpellerHandlingNeeded() && null != PoiAbstractElementCommon.savedSpellerState && PoiAbstractElementCommon.isOnboardDualListViewActive) {
            objectArray = new CmdRestoreState(this, PoiAbstractElementCommon.savedSpellerState);
            objectArray.setBlindArgument("DetailedPoi", new Object());
            objectArray.execute();
        }
        if (null != cmdSelectListItem.getBlindArgument("DetailedPoi")) {
            if (PoiAbstractElementCommon.lastUsedPoiIndex < PoiAbstractElementCommon.poiResultList.length) {
                PoiAbstractElementCommon.poiResultList[PoiAbstractElementCommon.lastUsedPoiIndex].updateListItemWithMorePoiDetails(cmdSelectListItem.liCurrentState_liCurrentLD);
                if (cmdSelectListItem.getMaxIndex() + 1 == ++PoiAbstractElementCommon.lastUsedPoiIndex) {
                    this.myTarget.notifierModel.notifySearchStateFound();
                    objectArray = new PoiResultListCollector[PoiAbstractElementCommon.lastUsedPoiIndex];
                    for (int i2 = 0; i2 < PoiAbstractElementCommon.lastUsedPoiIndex; ++i2) {
                        objectArray[i2] = PoiAbstractElementCommon.poiResultList[i2];
                    }
                    this.myTarget.notifierModel.notifyResultListItemsUpdateList(objectArray);
                    if (PoiDatapool.getInstance().getCurrentUseCase() == 14) {
                        Vector vector = this.getNavLocationsFromResultList((PoiResultListCollector[])objectArray);
                        this.updateSldeSearchResults(vector);
                    }
                    this.setRequestRunning(false);
                }
            }
            this.processSelectListItemForDetailedPOI(cmdSelectListItem);
        } else {
            objectArray = cmdSelectListItem.liCurrentState_liCurrentLD;
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setPOILocation((NavLocation)objectArray);
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
            eventGeneric.setReceiverTargetId(-884272128);
            eventGeneric.setReceiverEventId(1630090496);
            eventGeneric.setObject(1646867712, objectArray);
            eventGeneric.setObject(1663644928, cmdSelectListItem.getBlindArgument("SldeSelection"));
            ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
        }
    }

    @Override
    public void handleCommandCmdRestoreState(CmdRestoreState cmdRestoreState) {
        if (cmdRestoreState.liResult_ReturnCode == 0L && cmdRestoreState.liValueList_lispValueList == null && this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeError(this).append("lispValueList == null!!!").log();
            this.myTarget.makeError(this).append("If the value list is null, an already running search was restarted -> this should never happen.").log();
            this.myTarget.makeTrace(this).append("If this case comes true, we have to check together with navi south which circumstances are responsible for this unwanted behavior!").log();
        }
        if (cmdRestoreState.getBlindArgument("DetailedPoi") == null) {
            this.handleLiValueList(cmdRestoreState);
        }
    }

    public void childrenClosed() {
        ((PoiStateSubElementSurrounding)this.myTarget.statePoiSubElementSurrounding).clearModelData();
        PoiStateDetail.isChild = false;
        this.myTarget.notifierModel.notifyNaviPoiDataLoadFinished();
    }

    private void handleHsmStart() {
        this.myTarget.myTrace(this, "handleHsmStart");
        this.myTarget.notifierModel.notifySearchTypeSurrounding(true);
        PoiAbstractElementCommon.isOnboardDualListViewActive = true;
        ignoreUpdates = false;
        PoiAbstractElementCommon.firstUpdateDone = false;
        PoiAbstractElementCommon.searchIsRunning = false;
        PoiAbstractElementCommon.isHasNextPage = false;
        this.setRequestRunning(false);
        this.myTarget.getDsiNavigation().poiSetSortOrder2(2);
        this.myTarget.setLiValueListWindowSize(this, -1, true);
        this.setStopRequestingValueList(false);
        this.myTarget.notifierModel.notifyToChangeStateOfMapUpdatePopup(false);
        if (PoiDatapool.getInstance().getCurrentUseCase() == 20) {
            this.updateLastOnboardSearchResults();
        } else {
            this.requestPOIElements();
        }
    }

    private void handlePOIVALUELIST(LIValueList lIValueList) {
        this.myTarget.myTrace(this, "LIValueList list updated with POI options.");
        if (!this.myTarget.selectCriterionInPOIValueList(this, lIValueList, 16)) {
            // empty if block
        }
    }

    @Override
    public void handleCommandCmdSelectByMultipleCategoryUids(CmdSelectByMultipleCategoryUids cmdSelectByMultipleCategoryUids) {
        this.myTarget.myTrace(this, "handleCmdSelectByMultipleCategoryUids");
        if (!this.myTarget.selectCriterionInPOIValueList(this, cmdSelectByMultipleCategoryUids.liValueList_lispValueList, 16)) {
            // empty if block
        }
    }

    private void updateLastOnboardSearchResults() {
        this.myTarget.myTrace(this, "updateLastOnboardSearchResults()");
        if (PoiDatapool.getInstance().getCurrentUseCase() == 20) {
            PoiDatapool.getInstance().setCurrentUseCase(4);
        }
        this.clearModelData();
        this.prepareRequestPoiElements();
        int n = PoiDatapool.getInstance().getFilterCategoryUid() != -1 ? PoiDatapool.getInstance().getFilterCategoryUid() : PoiDatapool.getInstance().getLastSelectedTopPoiUid();
        DynamicPoiCategoryHandler.updateByOnboardUid(n);
        this.requestOnboardPois(n);
    }

    private void selectPoiElementWithChildren(int n, int n2) {
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this).append("POI index:").append(n).append(", Child index:").append(n2).log();
        }
        if (n2 == -1) {
            PoiAbstractSubElementCommon.listSelection = n;
            this.trans(this.myTarget.statePoiSubElementSurrounding);
        } else {
            PoiStateDetail.currentDetailsIndex = n2;
            PoiStateSelectFromResultList.restore = false;
            this.trans(this.myTarget.statePoiSubElementRestore);
        }
    }

    private void prepareRequestPoiElements() {
        PoiStateDetail.isChild = false;
        this.setLastSubstringSearchStatus(0);
        this.ignoreResultList = true;
        this.availableItems = 0;
        ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(PoiDatapool.getInstance().getReferenceLocation().getLatitude(), PoiDatapool.getInstance().getReferenceLocation().getLongitude());
        this.myTarget.getDsiNavigation().poiSetContext(iLocationWrapper.getLocation());
    }

    private void requestPOIElements() {
        this.myTarget.myTrace(this, "requestPOIElements()");
        this.prepareRequestPoiElements();
        this.myTarget.notifierModel.notifySearchStateSearching();
        this.myTarget.notifierModel.notifyNaviPoiDataLoadFinished();
        switch (PoiDatapool.getInstance().getCurrentUseCase()) {
            case 4: {
                PoiAbstractElementCommon.searchIsRunning = true;
                this.requestOnboardPois(PoiDatapool.getInstance().getLastSelectedTopPoiUid());
                break;
            }
            case 14: {
                PoiAbstractElementCommon.searchIsRunning = true;
                this.myTarget.myTrace(this, "CmdPoiStartSpellerAlongRoute");
                this.myTarget.setLiValueListWindowSize(this, 0, false);
                new CmdPoiStartSpellerAlongRoute(this, this.alongTheRouteSelCritDes, 0L, 0L).execute();
                this.myTarget.setLiValueListWindowSize(this, -1, false);
                this.myTarget.myTrace(this, "CmdSetInput");
                new CmdSetInput(this, PoiDatapool.getInstance().getFilterName(), false).execute();
                break;
            }
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: {
                PoiAbstractElementCommon.searchIsRunning = true;
                int n = PoiDatapool.getInstance().getCurrentUseCase();
                this.getFuelOrChargingStations(n);
                break;
            }
            case 11: {
                PoiAbstractElementCommon.searchIsRunning = true;
                if (listSelection == -1) {
                    this.myTarget.myTrace(this, "CmdStartSpeller");
                    new CmdStartSpeller(this, 0xA800000, false, false, false).execute();
                    break;
                }
                this.myTarget.myTrace(this, new StringBuffer().append("CmdSelectListItemPoi: ").append(listSelection).toString());
                new CmdSelectListItemPoi(this, listSelection).execute();
                break;
            }
            case 12: {
                PoiAbstractElementCommon.searchIsRunning = true;
                if (listSelection == -1) {
                    this.myTarget.myTrace(this, "CmdPoiStartSpellerAlongRoute");
                    new CmdPoiStartSpellerAlongRoute(this, 0xA800000, 0L, 0L).execute();
                    break;
                }
                this.myTarget.myTrace(this, "CmdSelectListItemPoi");
                new CmdSelectListItemPoi(this, listSelection).execute();
                break;
            }
            case 15: {
                PoiAbstractElementCommon.searchIsRunning = true;
                if (PoiDatapool.getInstance().getFilterName().length() != 0 || PoiDatapool.getInstance().getFilterCategoryUid() != -1) {
                    this.setIgnoreResultList(true);
                    this.myTarget.setLiValueListWindowSize(this, 0, false);
                } else {
                    this.setIgnoreResultList(false);
                    this.myTarget.setLiValueListWindowSize(this, -1, false);
                }
                if (PoiDatapool.getInstance().getFilterCategoryUid() == -1) {
                    this.myTarget.myTrace(this, "CmdStartSpeller");
                    new CmdStartSpeller(this, 0x11800000, false, false, false).execute();
                    this.setHybridSearchSetInputRequired(true);
                    break;
                }
                if (PoiDatapool.getInstance().getFilterName().length() != 0) {
                    this.myTarget.myTrace(this, "CmdStartSpeller");
                    new CmdStartSpeller(this, 0xF800000, false, false, false).execute();
                    this.myTarget.myTrace(this, "CmdSelectByCategoryUid");
                    new CmdSelectByCategoryUid(this, PoiDatapool.getInstance().getFilterCategoryUid()).execute();
                    break;
                }
                this.myTarget.myTrace(this, "CmdStartSpeller");
                new CmdStartSpeller(this, 0xF800000, false, false, false).execute();
                this.myTarget.myTrace(this, "CmdSelectByCategoryUid");
                new CmdSelectByCategoryUid(this, PoiDatapool.getInstance().getFilterCategoryUid()).execute();
                break;
            }
            case 16: {
                PoiAbstractElementCommon.searchIsRunning = true;
                if (PoiDatapool.getInstance().getFilterName().length() != 0 || PoiDatapool.getInstance().getFilterCategoryUid() != -1) {
                    this.setIgnoreResultList(true);
                    this.myTarget.setLiValueListWindowSize(this, 0, false);
                } else {
                    this.ignoreResultList = false;
                }
                if (PoiDatapool.getInstance().getFilterCategoryUid() == -1) {
                    this.myTarget.myTrace(this, "CmdPoiStartSpellerAlongRoute");
                    new CmdPoiStartSpellerAlongRoute(this, 0x11800000, 0L, 0L).execute();
                    if (PoiDatapool.getInstance().getFilterName().length() == 0) break;
                    this.myTarget.setLiValueListWindowSize(this, -1, false);
                    this.myTarget.myTrace(this, "CmdSetInput");
                    new CmdSetInput(this, PoiDatapool.getInstance().getFilterName(), false).execute();
                    break;
                }
                this.myTarget.myTrace(this, "CmdPoiStartSpellerAlongRoute");
                new CmdPoiStartSpellerAlongRoute(this, 0xF800000, 0L, 0L).execute();
                this.myTarget.myTrace(this, "CmdSelectByCategoryUid");
                new CmdSelectByCategoryUid(this, PoiDatapool.getInstance().getFilterCategoryUid()).execute();
                break;
            }
            case 17: {
                PoiAbstractElementCommon.searchIsRunning = true;
                this.myTarget.myTrace(this, "CmdStartSpeller");
                this.myTarget.setLiValueListWindowSize(this, 0, false);
                this.setIgnoreResultList(true);
                new CmdStartSpeller(this, 0xF800000, false, false, false).execute();
                this.myTarget.myTrace(this, "CmdSelectByCategoryUid");
                new CmdSelectByCategoryUid(this, PoiDatapool.getInstance().getFilterCategoryUid()).execute();
                break;
            }
            case 18: {
                PoiAbstractElementCommon.searchIsRunning = true;
                this.myTarget.myTrace(this, "CmdPoiStartSpellerAlongRoute");
                this.myTarget.setLiValueListWindowSize(this, 0, false);
                this.setIgnoreResultList(true);
                new CmdPoiStartSpellerAlongRoute(this, 0xF800000, 0L, 0L).execute();
                this.myTarget.myTrace(this, "CmdSelectByCategoryUid");
                new CmdSelectByCategoryUid(this, PoiDatapool.getInstance().getFilterCategoryUid()).execute();
                break;
            }
            default: {
                this.myTarget.myError(this, "Unknown use case");
            }
        }
    }

    private void requestOnboardPois(int n) {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().isRgActive()) {
            this.myTarget.myTrace(this, "CmdSetLiValueListWindowSize = 0");
            this.setIgnoreResultList(true);
            this.myTarget.setLiValueListWindowSize(this, 0, false);
            this.myTarget.myTrace(this, "CmdPoiStartSpellerAlongRoute");
            new CmdPoiStartSpellerAlongRoute(this, 0xF800000, 0L, 0L).execute();
        } else {
            this.myTarget.myTrace(this, "CmdSetLiValueListWindowSize = 0");
            this.myTarget.setLiValueListWindowSize(this, 0, false);
            this.setIgnoreResultList(true);
            this.myTarget.myTrace(this, "CmdStartSpeller");
            new CmdStartSpeller(this, 0xF800000, false, false, false).execute();
        }
        if (ASLSystemFactory.getSystemApi().getFeatureFlagValueBEV() && n == 134) {
            this.selectChargingStations();
        } else if (ServiceManager.configManagerDiag.isFeatureFlagSet(70) && ASLSystemFactory.getSystemApi().getFeatureFlagValuePHEV() && n == 134) {
            this.myTarget.myTrace(this, new StringBuffer().append("CmdSelectByCategoryUid changed to PHEV from: ").append(n).append(" to: ").append(133).toString());
            this.myTarget.myTrace(this, "CmdSetLiValueListWindowSize = -1");
            this.myTarget.setLiValueListWindowSize(this, -1, false);
            new CmdSelectByCategoryUid(this, 133).execute();
        } else {
            this.myTarget.myTrace(this, "CmdSetLiValueListWindowSize = -1");
            this.myTarget.setLiValueListWindowSize(this, -1, false);
            this.setWaitWithCancelSpeller(true);
            this.myTarget.myTrace(this, new StringBuffer().append("CmdSelectByCategoryUid: ").append(n).toString());
            new CmdSelectByCategoryUid(this, n).execute();
        }
    }

    private void selectChargingStations() {
        this.myTarget.myTrace(this, "selectChargingStations()");
        int[] nArray = DynamicPoiCategoryHandler.getPreferredChargingStationCategoryUids();
        this.myTarget.myTrace(this, "CmdSetLiValueListWindowSize = -1");
        this.myTarget.setLiValueListWindowSize(this, -1, false);
        this.myTarget.myTrace(this, "CmdSelectByMultipleCategoryUids");
        new CmdSelectByMultipleCategoryUids(this, nArray).execute();
    }

    private void getFuelOrChargingStations(int n) {
        int n2 = DynamicPoiCategoryHandler.getOnboardCategoryUidByUsecase(n);
        PoiDatapool.getInstance().setFilterCategoryUid(n2);
        PoiDatapool.getInstance().setLastSelectedTopPoiUid(n2);
        String string = PoiDatapool.getInstance().getTopPoiCategoryName(n2);
        if (StringUtil.isEmpty(string)) {
            int n3 = DynamicPoiCategoryHandler.getOnboardCategoryUidByUsecase(5);
            string = PoiDatapool.getInstance().getTopPoiCategoryName(n3);
        }
        PoiDatapool.getInstance().setSelectedCategoryName(string);
        this.myTarget.notifierModel.notifySelectedCategoryName(PoiDatapool.getInstance().getSelectedCategoryName());
        PoiDatapool.getInstance().setEnteredName("");
        this.myTarget.notifierModel.notifyEnteredName(PoiDatapool.getInstance().getEnteredName());
        PoiDatapool.getInstance().setFilterName("");
        this.myTarget.notifierModel.notifyNameFilter(PoiDatapool.getInstance().getFilterName());
        this.myTarget.myTrace(this, new StringBuffer().append("getFuelOrChargingStations(").append(n).append(") -> categoryUid=").append(n2).toString());
        switch (n) {
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: {
                if (ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().isRgActive()) {
                    this.myTarget.myTrace(this, "CmdPoiStartSpellerAlongRoute");
                    new CmdPoiStartSpellerAlongRoute(this, 0xF800000, 0L, 0L).execute();
                } else {
                    this.myTarget.myTrace(this, "CmdStartSpeller");
                    new CmdStartSpeller(this, 0xF800000, false, false, false).execute();
                }
                this.setIgnoreResultList(true);
                this.myTarget.setLiValueListWindowSize(this, 0, false);
                new CmdLiGetState(this).execute();
                if (n == 9) {
                    this.selectChargingStations();
                    break;
                }
                this.myTarget.myTrace(this, "CmdSelectByCategoryUid");
                new CmdSelectByCategoryUid(this, n2).execute();
                break;
            }
            case 10: {
                this.myTarget.myTrace(this, "CmdStartSpeller");
                new CmdStartSpeller(this, 0xF800000, false, false, false).execute();
                this.setIgnoreResultList(true);
                this.myTarget.setLiValueListWindowSize(this, 0, false);
                new CmdLiGetState(this).execute();
                this.selectChargingStations();
                break;
            }
            default: {
                this.myTarget.myError(this, "Not supported use case");
            }
        }
    }
}

