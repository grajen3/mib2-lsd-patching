/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.onboard;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdCancelSpeller;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdLiGetState;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdRequestValueListByListIndex;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdRestoreState;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSelectByCategoryUid;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSelectListItem;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSetInput;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdStartSpeller;
import de.vw.mib.asl.internal.navigation.poi.onboard.DynamicPoiCategoryHandler;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiAbstractElementCommon;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiAbstractSubElementCommon;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiDatapool;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiHsmTarget;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateDetail;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateElementSurrounding;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateSelectFromResultList;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateSubElementNoSurrounding;
import de.vw.mib.asl.internal.navigation.poi.transformer.PoiResultListCollector;
import de.vw.mib.asl.internal.navigation.util.NaviHelper;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LISpellerData;

public class PoiStateElementNoSurrounding
extends PoiAbstractElementCommon {
    public static NavLocation poiFromMapLocation = null;
    public static LISpellerData parentPOIState = null;
    public static boolean stopRequestingValueList = false;
    private boolean searchTerminated = true;

    public PoiStateElementNoSurrounding(PoiHsmTarget poiHsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(poiHsmTarget, hsm, string, hsmState);
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
            case 1073742522: {
                this.myTarget.myTrace(this, "SEARCH_STOP");
                PoiAbstractElementCommon.isOnboardDualListViewActive = false;
                int n = PoiDatapool.getInstance().getCurrentUseCase();
                this.myTarget.makeTrace(this).append("PoiDatapool.currentUseCase=").append(n).log();
                if (n == 0xF800000) break;
                new CmdCancelSpeller(this).execute();
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
            case 3400031: {
                this.myTarget.myTrace(this, "ASL_NAVI_POI_ONBOARD_DUALLIST_RESULTS_ENTER_EXIT");
                PoiAbstractElementCommon.isOnboardDualListViewActive = eventGeneric.getBoolean(0);
                if (!PoiAbstractElementCommon.isOnboardDualListViewActive) {
                    CmdLiGetState cmdLiGetState = new CmdLiGetState(this);
                    cmdLiGetState.setBlindArgument("DetailedPoi_SkipSaveState", new Object());
                    cmdLiGetState.execute();
                    this.setRequestRunning(true);
                    this.setStopRequestingValueList(true);
                    this.cutOffResultList(PoiAbstractElementCommon.lastUsedPoiIndex);
                    if (!eventGeneric.getBoolean(1)) break;
                    PoiAbstractElementCommon.searchIsRunning = false;
                    new CmdCancelSpeller(this).execute();
                    break;
                }
                if (!PoiAbstractElementCommon.searchIsRunning || PoiAbstractElementCommon.lastUsedPoiIndex <= 0) break;
                this.updateCuttedResultListAtHmi(PoiAbstractElementCommon.lastUsedPoiIndex);
                this.setRequestRunning(false);
                this.setStopRequestingValueList(false);
                CmdRestoreState cmdRestoreState = new CmdRestoreState(this, PoiAbstractElementCommon.savedSpellerState);
                cmdRestoreState.setBlindArgument("DetailedPoi", new Object());
                cmdRestoreState.execute();
                break;
            }
            case 1073742523: {
                this.myTarget.myTrace(this, "SEARCH_VIEW_CLOSE");
                PoiAbstractElementCommon.isOnboardDualListViewActive = false;
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

    private void handleHsmStart() {
        this.myTarget.myTrace(this, "handleHsmStart");
        this.myTarget.notifierModel.notifySearchTypeSurrounding(false);
        this.setRequestRunning(false);
        PoiAbstractElementCommon.firstUpdateDone = false;
        PoiAbstractElementCommon.searchIsRunning = false;
        PoiStateElementSurrounding.ignoreUpdates = false;
        PoiAbstractElementCommon.isOnboardDualListViewActive = true;
        PoiAbstractElementCommon.isHasNextPage = false;
        this.setStopRequestingValueList(false);
        this.myTarget.notifierModel.notifyToChangeStateOfMapUpdatePopup(false);
        this.myTarget.setLiValueListWindowSize(this, 1, true);
        if (!PoiAbstractElementCommon.continueSearch) {
            this.clearModelData();
            stopRequestingValueList = false;
            this.searchTerminated = false;
            this.requestPOIElements();
        }
    }

    @Override
    public void handleCommandCmdStartSpeller(CmdStartSpeller cmdStartSpeller) {
        this.handleLiValueList(cmdStartSpeller);
        this.myTarget.notifierModel.notifyNaviPoiDataLoadFinished();
    }

    @Override
    public void handleCommandCmdRequestValueListByListIndex(CmdRequestValueListByListIndex cmdRequestValueListByListIndex) {
        this.handleLiValueList(cmdRequestValueListByListIndex);
    }

    private void requestPOIElements() {
        this.myTarget.myTrace(this, "requestPOIElements");
        this.myTarget.getDsiNavigation().poiSetSortOrder2(0);
        PoiStateDetail.isChild = false;
        this.setIgnoreResultList(false);
        this.availableItems = 0;
        this.myTarget.notifierModel.notifySearchStateSearching();
        switch (PoiDatapool.getInstance().getCurrentUseCase()) {
            case 0: {
                PoiAbstractElementCommon.searchIsRunning = true;
                int n = DynamicPoiCategoryHandler.getOnboardCategoryUidByUsecase(PoiDatapool.getInstance().getCurrentUseCase());
                PoiDatapool.getInstance().setFilterCategoryUid(n);
                this.myTarget.getDsiNavigation().poiSetContext(poiFromMapLocation);
                this.myTarget.myTrace(this, "CmdStartSpeller");
                new CmdStartSpeller(this, 0xD800000, false, false, false).execute();
                new CmdLiGetState(this).execute();
                break;
            }
            case 32783: {
                PoiAbstractElementCommon.searchIsRunning = true;
                NavLocation navLocation = PoiDatapool.getInstance().getAreaLocation().getLocation();
                this.myTarget.getDsiNavigation().poiSetContext(NaviHelper.getInstance().cloneNavLocation(navLocation, false));
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
                    this.myTarget.setLiValueListWindowSize(this, 0, false);
                    this.setIgnoreResultList(true);
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
            default: {
                this.myTarget.myError(this, "Unknown use case");
            }
        }
    }

    @Override
    public void handleCommandCmdRestoreState(CmdRestoreState cmdRestoreState) {
        this.myTarget.myCmdTrace(this, cmdRestoreState);
        if (cmdRestoreState.getBlindArgument("DetailedPoi") == null) {
            stopRequestingValueList = false;
        }
        if (cmdRestoreState.liResult_ReturnCode != 0L) {
            if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
                this.myTarget.makeError(this).append("Error! returnCode=").append(cmdRestoreState.liResult_ReturnCode).log();
            }
            return;
        }
    }

    @Override
    public void handleCommandCmdSetInput(CmdSetInput cmdSetInput) {
        this.handleLiValueList(cmdSetInput);
    }

    public void childrenClosed() {
        this.myTarget.myTrace(this, "childrenClosed");
        ((PoiStateSubElementNoSurrounding)this.myTarget.statePoiSubElementNoSurrounding).clearModelData();
        PoiStateDetail.isChild = false;
        this.myTarget.notifierModel.notifyNaviPoiDataLoadFinished();
    }

    private void selectPoiElementWithChildren(int n, int n2) {
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this).append("POI index:").append(n).append(", Child index:").append(n2).log();
        }
        if (n2 == -1) {
            PoiAbstractSubElementCommon.listSelection = n;
            this.trans(this.myTarget.statePoiSubElementNoSurrounding);
        } else {
            PoiStateDetail.currentDetailsIndex = n2;
            PoiStateSelectFromResultList.restore = false;
            this.trans(this.myTarget.statePoiSubElementRestore);
        }
    }

    @Override
    public void handleCommandCmdSelectListItem(CmdSelectListItem cmdSelectListItem) {
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this).append("PoiStateElementNoSurrounding handleCommandCmdSelectListItem enter").log();
        }
        if (cmdSelectListItem.liCurrentState_liCurrentLD == null || cmdSelectListItem.liResult_ReturnCode != 0L) {
            if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
                this.myTarget.makeError(this).append("Error! location null or returnCode=").append(cmdSelectListItem.liResult_ReturnCode).log();
            }
            ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().resetNaviContext("lispSelectListItem didn't succeed on southside - Returned location is null or returncode not ok");
            return;
        }
        if (null != cmdSelectListItem.getBlindArgument("DetailedPoi")) {
            Object[] objectArray;
            if (PoiDatapool.getInstance().isSpecialSpellerHandlingNeeded() && null != PoiAbstractElementCommon.savedSpellerState) {
                objectArray = new CmdRestoreState(this, PoiAbstractElementCommon.savedSpellerState);
                objectArray.setBlindArgument("DetailedPoi", new Object());
                objectArray.execute();
            }
            if (PoiAbstractElementCommon.lastUsedPoiIndex < PoiAbstractElementCommon.poiResultList.length) {
                PoiAbstractElementCommon.poiResultList[PoiAbstractElementCommon.lastUsedPoiIndex].updateListItemWithMorePoiDetails(cmdSelectListItem.liCurrentState_liCurrentLD);
                if (cmdSelectListItem.getMaxIndex() + 1 == ++PoiAbstractElementCommon.lastUsedPoiIndex) {
                    this.myTarget.notifierModel.notifySearchStateFound();
                    objectArray = new PoiResultListCollector[PoiAbstractElementCommon.lastUsedPoiIndex];
                    for (int i2 = 0; i2 < PoiAbstractElementCommon.lastUsedPoiIndex; ++i2) {
                        objectArray[i2] = PoiAbstractElementCommon.poiResultList[i2];
                    }
                    this.myTarget.notifierModel.notifyResultListItemsUpdateList(objectArray);
                    this.setRequestRunning(false);
                }
            }
            this.processSelectListItemForDetailedPOI(cmdSelectListItem);
        }
    }
}

