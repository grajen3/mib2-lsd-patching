/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.onboard;

import de.vw.mib.asl.api.navigation.locationinput.ISpellerContext;
import de.vw.mib.asl.api.navigation.locationinput.SpellerHandler;
import de.vw.mib.asl.api.navigation.spellerx.XSpellerHandlerMap;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdCancelSpeller;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdGetLocationDescriptionTransform;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdPoiGetXt9LDBs;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSetLiValueListWindowSize;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdTransformAndStrip;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiAbstractElementCommon;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiAbstractHsmState;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiDatapool;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiEvents;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiHsmTarget;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateMainHandler;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.careco.BCmECurrentRange;
import org.dsi.ifc.navigation.NavDataBase;

public final class PoiStateMain
extends PoiAbstractHsmState
implements SpellerHandler {
    private PoiHsmTarget myTarget;
    private PoiStateMainHandler handler;

    public PoiStateMain(PoiHsmTarget poiHsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.myTarget = poiHsmTarget;
        this.handler = new PoiStateMainHandler(this, poiHsmTarget);
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
                XSpellerHandlerMap.addHandler(4, 3, this);
                break;
            }
            case 3: {
                this.myTarget.myTrace(this, "HSM_START");
                break;
            }
            case 4: {
                this.myTarget.myTrace(this, "HSM_EXIT");
                PoiEvents.removeObserver(this.myTarget);
                break;
            }
            case 101001: {
                this.myTarget.myTrace(this, "NAVI_TARGET_GO_ON");
                PoiDatapool.getInstance().setUpdateModel(true);
                this.handler.targetGoOn(eventGeneric);
                break;
            }
            case 100501: {
                this.myTarget.myTrace(this, "EV_NAVI_POI_ASL_STARTPOISPELLER");
                PoiDatapool.getInstance().setUpdateModel(true);
                this.handler.requestTopCategories();
                break;
            }
            case 3400004: {
                this.myTarget.myTrace(this, "ASL_NAVI_MAP_INPUT_POI");
                PoiDatapool.getInstance().setUpdateModel(true);
                this.handler.prepareSelectPoiFromMap(eventGeneric);
                break;
            }
            case 3400002: {
                this.myTarget.myTrace(this, "ASL_NAVI_MAP_INPUT_MULTIPOIS");
                PoiDatapool.getInstance().setUpdateModel(true);
                this.handler.prepareSelectPoiStackFromMap(eventGeneric);
                break;
            }
            case 1073744489: {
                this.myTarget.myTrace(this, "WAIT_FOR_CLICKED_STACK_LOAD_FINISHED");
                break;
            }
            case 3400006: {
                this.myTarget.myTrace(this, "ASL_NAVI_MAP_INPUT_SET_LOCATION_POI_INPUT");
                this.handler.selectGeoPositionFromMap(eventGeneric);
                break;
            }
            case 100500: {
                this.trans((HsmState)eventGeneric.getObject(0));
                break;
            }
            case 1074841937: {
                this.myTarget.myTrace(this, "START_POI_SEARCH");
                PoiDatapool.getInstance().setUpdateModel(true);
                this.handler.startPoiSearch(eventGeneric.getInt(0));
            }
            case 1073742519: {
                this.myTarget.myTrace(this, "ASL_NAVIGATION_POI_SEARCH_START");
                PoiAbstractElementCommon.isOnboardDualListViewActive = true;
                this.handler.searchStart();
                break;
            }
            case 1073742518: {
                this.myTarget.myTrace(this, "ASL_NAVIGATION_POI_SEARCH_SPELLER_INIT");
                this.handler.enterFreetextSpeller(false);
                break;
            }
            case 1074841936: {
                this.myTarget.myTrace(this, "SELECT_TOP_POI");
                PoiDatapool.getInstance().setUpdateModel(true);
                this.handler.prepareSelectTopPoiCategory(eventGeneric);
                break;
            }
            case 1073742500: {
                this.myTarget.myTrace(this, "ASL_NAVIGATION_POI_PIT_STOP_ITEM_LOAD");
                this.handler.selectTopPoiCategory(eventGeneric);
                break;
            }
            case 1074841899: {
                this.myTarget.myTrace(this, "INIT_ONLINE_POI_SEARCH_BY_CATEGORY");
                PoiDatapool.getInstance().setUpdateModel(true);
                this.handler.selectOnlinePoiCategory(eventGeneric);
                break;
            }
            case 1074841847: {
                this.myTarget.myTrace(this, "SEARCH_FUEL_STATIONS_PETROL");
                this.handler.fuelWarning(5);
                break;
            }
            case 1074841848: {
                this.myTarget.myTrace(this, "SEARCH_FUEL_STATIONS_DIESEL");
                this.handler.fuelWarning(6);
                break;
            }
            case 1074841849: {
                this.myTarget.myTrace(this, "SEARCH_FUEL_STATIONS_CNG");
                this.handler.fuelWarning(7);
                break;
            }
            case 1074841850: {
                this.myTarget.myTrace(this, "SEARCH_FUEL_STATIONS_LPG");
                this.handler.fuelWarning(8);
                break;
            }
            case 1073744403: {
                this.myTarget.myTrace(this, "LOAD_CHARGING_STATIONS");
                this.handler.batteryWarning(eventGeneric);
                break;
            }
            case 3492007: {
                this.myTarget.myTrace(this, "EV_POI_ONBOARD_SEARCH_CATEGORY");
                PoiDatapool.getInstance().setUpdateModel(false);
                int n = (int)eventGeneric.getLong(0);
                int n2 = eventGeneric.getInt(1);
                this.handler.startPoiSearchWithCategoryUid(n, n2);
                break;
            }
            case 1074841857: {
                this.myTarget.myTrace(this, "START_POI_SEACH_WITH_CATEGORY_UID2");
                PoiDatapool.getInstance().setUpdateModel(false);
                int n = (int)eventGeneric.getLong(0);
                int n3 = eventGeneric.getInt(1);
                this.handler.startPoiSearchWithCategoryUid(n, n3);
                break;
            }
            case 1073742506: {
                this.myTarget.myTrace(this, "ASL_NAVIGATION_POI_SEARCH_CATEGORY_LIST_LOAD_DATA_REQUEST");
                this.handler.searchStart();
                break;
            }
            case 1073742522: {
                this.myTarget.myTrace(this, "ASL_NAVIGATION_POI_SEARCH_STOP");
                this.handler.stopRunningSearch();
                break;
            }
            case 1073744499: {
                this.myTarget.myTrace(this, "INIT_SEARCH_AREA_SPELLER_X");
                this.handler.initSearchArea(eventGeneric.getInt(0), true);
                break;
            }
            case 1073742505: {
                this.myTarget.myTrace(this, "ASL_NAVIGATION_POI_SAVE_ADDRESS");
                XSpellerHandlerMap.saveSpeller(this);
                break;
            }
            case 1073744062: {
                this.myTarget.myTrace(this, "ASL_NAVIGATION_POI_CONTINUE_TO_DETAIL_VIEW");
                PoiDatapool.getInstance().setUpdateModel(true);
                this.handler.startPoiSearch(2);
                this.handler.continueToDetailView();
                break;
            }
            case 1073744099: {
                this.myTarget.myTrace(this, "INIT_POI_NAME_SPELLER");
                this.handler.enterFreetextSpeller(false);
                break;
            }
            case 1074841877: {
                this.myTarget.myTrace(this, "INIT_SPELLER_MODE");
                this.handler.initFreetextSpellerMode(eventGeneric.getInt(0));
                break;
            }
            case 1073744101: {
                this.myTarget.myTrace(this, "ASL_NAVIGATION_POI__INIT_POI_CATEGORIES");
                this.handler.initPoiCategories();
                break;
            }
            case 1074841946: {
                this.myTarget.myTrace(this, "SETUP_SLDE");
                PoiAbstractElementCommon.searchIsRunning = false;
                this.handler.setupSlde(eventGeneric);
                break;
            }
            case 1073744228: {
                PoiDatapool.getInstance().setUpdateModel(true);
                this.myTarget.myTrace(this, "INIT_SEARCH_AREA_SPELLER_X");
                int n = eventGeneric.getInt(0);
                this.handler.initSearchArea(n, true);
                break;
            }
            case 1073744098: {
                this.myTarget.myTrace(this, "ASL_NAVIGATION_POI_SETUP__CLEAR_ALL_SELECTED_CATEGORY_ELEMENTS");
                this.handler.clearAllButton();
                break;
            }
            case 1073744097: {
                this.myTarget.myTrace(this, "FIND_PO_IS");
                this.handler.searchStartWithoutCategorySelection();
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

    public void initXt9OnboardFinished() {
        this.handler.initXt9Finished();
    }

    @Override
    public void handleCommandCmdCancelSpeller(CmdCancelSpeller cmdCancelSpeller) {
        this.handler.handleCommandCmdCancelSpeller(cmdCancelSpeller);
    }

    @Override
    public void handleCommandCmdGetLocationDescriptionTransform(CmdGetLocationDescriptionTransform cmdGetLocationDescriptionTransform) {
        this.handler.handleCommandCmdGetLocationDescriptionTransform(cmdGetLocationDescriptionTransform);
    }

    @Override
    public void handleCommandCmdTransformAndStrip(CmdTransformAndStrip cmdTransformAndStrip) {
        this.handler.handleCommandCmdTransformAndStrip(cmdTransformAndStrip);
    }

    @Override
    public void handleCommandCmdSetLiValueListWindowSize(CmdSetLiValueListWindowSize cmdSetLiValueListWindowSize) {
        this.handler.handleCommandCmdSetLiValueListWindowSize(cmdSetLiValueListWindowSize);
    }

    @Override
    public void handleCommandCmdPoiGetXt9LDBs(CmdPoiGetXt9LDBs cmdPoiGetXt9LDBs) {
        this.handler.handleCommandCmdPoiGetXt9LDBs(cmdPoiGetXt9LDBs);
    }

    public void dsiCarEcoUpdateBCmECurrentRange(BCmECurrentRange bCmECurrentRange, int n) {
        this.handler.dsiCarEcoUpdateBCmECurrentRange(bCmECurrentRange, n);
    }

    public void updateEtcAvailablePersonalPOIDataBases(NavDataBase[] navDataBaseArray, int n) {
        this.handler.updateEtcAvailablePersonalPOIDataBases(navDataBaseArray, n);
    }

    @Override
    public void onActivated(ISpellerContext iSpellerContext) {
        this.handler.onActivated(iSpellerContext);
    }

    @Override
    public void onLocationSaved(ISpellerContext iSpellerContext) {
        this.handler.onLocationSaved(iSpellerContext);
    }

    @Override
    public void onLocationDiscarded(ISpellerContext iSpellerContext) {
    }

    @Override
    public void onContext(ISpellerContext iSpellerContext) {
        this.handler.onContext(iSpellerContext);
    }
}

