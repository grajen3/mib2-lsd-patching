/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.onboard;

import de.vw.mib.asl.api.navigation.ASLNavigationFactory;
import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.INavigationListElement;
import de.vw.mib.asl.api.navigation.locationinput.ASLNavigationLocationinputAPI;
import de.vw.mib.asl.api.navigation.locationinput.ASLNavigationLocationinputFactory;
import de.vw.mib.asl.api.navigation.memory.NavigationMemoryService;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.caching.CacheClient;
import de.vw.mib.asl.internal.navigation.caching.IconKey;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdRequestValueListByListIndex;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSetCurrentLD;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdStartSpeller;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiAbstractHsmState;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiDatapool;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiHsmTarget;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateRequestTopCategories$1;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateRequestTopCategories$2;
import de.vw.mib.asl.internal.navigation.poi.transformer.PoiPitStopItemCollector;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.LogMessage;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.navigation.LIValueList;

public final class PoiStateRequestTopCategories
extends PoiAbstractHsmState
implements CacheClient {
    private int TOP_POI_MAX_RESULT_ENTRIES;
    private PoiHsmTarget myTarget;
    private PoiPitStopItemCollector[] topPoiResultList;
    private int noOfReceivedTopPois = 0;
    int[] topCategoryUids;

    public PoiStateRequestTopCategories(PoiHsmTarget poiHsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.myTarget = poiHsmTarget;
        this.TOP_POI_MAX_RESULT_ENTRIES = ServiceManager.configManagerDiag.isFeatureFlagSet(75) ? 5 : 3;
        this.topCategoryUids = new int[0];
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
            default: {
                if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
                    this.myTarget.makeTrace(this).append("Received event which is not handled in this state (ID=").append(eventGeneric.getReceiverEventId()).append(")").log();
                }
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void setCurrentLdSpeech(NavLocation navLocation) {
        if (navLocation == null || navLocation.getLatitude() == 0 && navLocation.getLongitude() == 0) {
            NavLocation navLocation2;
            this.myTarget.myTrace(this, "last destination location is null or invalid (0,0) -> using default ccp");
            navLocation = navLocation2 = ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getSoPosPositionDescription();
            if (navLocation2 == null || navLocation2.getLatitude() == 0 && navLocation2.getLongitude() == 0) {
                this.myTarget.myTrace(this, "ccp is null or invalid (0,0) -> using default Location");
                navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().cloneLocation(ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getDefaultLocation());
            }
        }
        this.myTarget.myTrace(this, new StringBuffer().append("setCurrentLdSpeech: ").append(navLocation.toString()).toString());
        new CmdSetCurrentLD(this, navLocation).execute();
    }

    @Override
    public void handleCommandCmdStartSpeller(CmdStartSpeller cmdStartSpeller) {
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this).append("handleCommandCmdStartSpeller (").append(cmdStartSpeller.getElapsedTimeInMs()).append(" ms").log();
        }
        this.notifyNaviStartup();
        if (cmdStartSpeller.liResult_ReturnCode != 0L) {
            if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
                this.myTarget.makeError(this).append("Error! returnCode=").append(cmdStartSpeller.liResult_ReturnCode).log();
            }
            return;
        }
        this.noOfReceivedTopPois = 0;
        this.handleLIVALUELIST(cmdStartSpeller.liValueList_lispValueList);
        this.myTarget.myTrace(this, "Speech setCurentLD, prepare execution");
        PoiStateRequestTopCategories$1 poiStateRequestTopCategories$1 = new PoiStateRequestTopCategories$1(this);
        NavigationMemoryService navigationMemoryService = null;
        try {
            navigationMemoryService = ASLNavigationFactory.getNavigationApi().getNavigationMemoryService(poiStateRequestTopCategories$1);
            INavigationListElement[] iNavigationListElementArray = navigationMemoryService.getLastDestinations();
            if (iNavigationListElementArray != null && iNavigationListElementArray.length > 0) {
                navigationMemoryService.getLastDestination(iNavigationListElementArray[0]);
            } else {
                this.setCurrentLdSpeech(null);
            }
        }
        catch (Exception exception) {
            this.myTarget.myTrace(this, new StringBuffer().append("Error in accessing the last Destinaiton: ").append(exception.getMessage()).toString());
            this.setCurrentLdSpeech(null);
        }
    }

    @Override
    public void handleCommandCmdSetCurrentLD(CmdSetCurrentLD cmdSetCurrentLD) {
        this.myTarget.myTrace(this, new StringBuffer().append("Speech setCurentLD executed with returnCode: ").append(cmdSetCurrentLD.liResult_ReturnCode).toString());
        NavLocation navLocation = cmdSetCurrentLD.liCurrentState_liCurrentLD;
        int[] nArray = cmdSetCurrentLD.liCurrentState_availableSelectionCriteria;
        if (nArray != null) {
            ASLNavigationLocationinputAPI aSLNavigationLocationinputAPI = ASLNavigationLocationinputFactory.getNavigationLocationinputApi();
            aSLNavigationLocationinputAPI.setStartupState(new PoiStateRequestTopCategories$2(this, navLocation, nArray));
        } else {
            this.warn("handleCommandCmdSetCurrentLD: availableSelectionCriteria is null!");
        }
    }

    private boolean isPointLocation(int[] nArray) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (nArray[i2] == 136) {
                return false;
            }
            if (nArray[i2] != 5) continue;
            return true;
        }
        return false;
    }

    private void notifyNaviStartup() {
        if (this.myTarget.blockedGoOnEvent != null) {
            try {
                this.myTarget.myTrace(this, "Navi-Startup: Sending blocked GO_ON event back to Navi-Startup");
                this.myTarget.sendBack(this.myTarget.blockedGoOnEvent);
            }
            catch (GenericEventException genericEventException) {
                LogMessage logMessage = this.myTarget.error();
                logMessage.append(genericEventException);
                logMessage.log();
            }
            this.myTarget.blockedGoOnEvent = null;
        }
    }

    private void handleHsmStart() {
        String string = ServiceManager.configManagerDiag.getPureVariant();
        if (string.startsWith("PREMIUM_")) {
            this.notifyNaviStartup();
            return;
        }
        this.myTarget.myTrace(this, "POISORTORDER_NATURAL");
        this.myTarget.getDsiNavigation().poiSetSortOrder2(0);
        ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper();
        this.myTarget.getDsiNavigation().poiSetContext(iLocationWrapper.getLocation());
        this.topPoiResultList = new PoiPitStopItemCollector[this.TOP_POI_MAX_RESULT_ENTRIES];
        this.myTarget.setLiValueListWindowSize(this, -1, true);
        if (5 == ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getNavstateOfOperation()) {
            new CmdStartSpeller(this, 0x9800000, false, false, false).execute();
        }
    }

    private void handleLIVALUELIST(LIValueList lIValueList) {
        this.myTarget.myTrace(this, "LIValueList list updated.");
        if (lIValueList != null && lIValueList.list != null) {
            if (lIValueList.list.length > 0) {
                int n = lIValueList.list.length;
                for (int i2 = 0; this.noOfReceivedTopPois < this.TOP_POI_MAX_RESULT_ENTRIES && i2 < n; ++i2) {
                    PoiPitStopItemCollector poiPitStopItemCollector;
                    if (lIValueList.list[i2] != null && lIValueList.list[i2].data != null) {
                        String string = lIValueList.list[i2].data;
                        int n2 = lIValueList.list[i2].criteriaNumber;
                        int[] nArray = new int[this.topCategoryUids.length + 1];
                        System.arraycopy((Object)this.topCategoryUids, 0, (Object)nArray, 0, this.topCategoryUids.length);
                        nArray[this.topCategoryUids.length] = n2;
                        this.topCategoryUids = nArray;
                        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
                            this.myTarget.makeTrace(this).append("Top POI category ").append(this.noOfReceivedTopPois).append(":'").append(string).append("  UID:").append(lIValueList.list[i2].criteriaNumber).log();
                        }
                        ResourceLocator resourceLocator = ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForPOIIcon(lIValueList.list[i2].iconIndex, lIValueList.list[i2].subIconIndex, 0, this, new Integer(this.noOfReceivedTopPois));
                        poiPitStopItemCollector = new PoiPitStopItemCollector(resourceLocator, string);
                        PoiDatapool.getInstance().setTopPoiCategoryName(n2, string);
                    } else {
                        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
                            this.myTarget.makeError(this).append("liValueList[").append(this.noOfReceivedTopPois).append("] == NULL!").log();
                        }
                        poiPitStopItemCollector = new PoiPitStopItemCollector(null, "");
                    }
                    this.topPoiResultList[this.noOfReceivedTopPois] = poiPitStopItemCollector;
                    ++this.noOfReceivedTopPois;
                }
            } else {
                this.myTarget.myError(this, "liValueList was empty!");
            }
            PoiDatapool.getInstance().setTopPoiCategoryUids(this.topCategoryUids);
        } else {
            this.myTarget.myError(this, "liValueList == NULL!");
        }
        if (lIValueList != null) {
            if (lIValueList.hasNextPage && this.noOfReceivedTopPois < this.TOP_POI_MAX_RESULT_ENTRIES) {
                this.myTarget.myTrace(this, "CmdRequestValueListByListIndex");
                new CmdRequestValueListByListIndex(this, this.noOfReceivedTopPois, true).execute();
            } else {
                PoiPitStopItemCollector[] poiPitStopItemCollectorArray;
                int[] nArray;
                if (this.noOfReceivedTopPois < this.TOP_POI_MAX_RESULT_ENTRIES) {
                    nArray = new int[this.noOfReceivedTopPois];
                    System.arraycopy((Object)this.topCategoryUids, 0, (Object)nArray, 0, this.noOfReceivedTopPois);
                    poiPitStopItemCollectorArray = new PoiPitStopItemCollector[this.noOfReceivedTopPois];
                    System.arraycopy((Object)this.topPoiResultList, 0, (Object)poiPitStopItemCollectorArray, 0, this.noOfReceivedTopPois);
                } else {
                    nArray = this.topCategoryUids;
                    poiPitStopItemCollectorArray = this.topPoiResultList;
                }
                PoiDatapool.getInstance().setTopPoiCategoryUids(nArray);
                if (!ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().isTopPoisHaveBeenLoadedSuccessfully()) {
                    ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setTopPoisHaveBeenLoadedSuccessfully(true);
                }
                this.myTarget.notifierModel.notifyTopPoiCategoriesUpdateList(poiPitStopItemCollectorArray);
            }
        }
    }

    @Override
    public ResourceLocator getDefaultIcon() {
        return null;
    }

    @Override
    public void handleIconCacheUpdate(IconKey iconKey, ResourceLocator resourceLocator, Object object) {
        int n;
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this).append("handleIconCacheUpdate index:").append((Integer)object).log();
        }
        if ((n = ((Integer)object).intValue()) < this.topPoiResultList.length) {
            this.topPoiResultList[n].resourceLocator = resourceLocator;
            PoiPitStopItemCollector[] poiPitStopItemCollectorArray = new PoiPitStopItemCollector[]{this.topPoiResultList[n]};
            this.myTarget.notifierModel.notifyTopPoiCategoriesUpdateItems(n, poiPitStopItemCollectorArray);
        } else if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeError(this).append("Index out of bounds (index:").append(iconKey).append(" length:").append(this.topPoiResultList.length).append(")").log();
        }
    }

    @Override
    public void handleCommandCmdRequestValueListByListIndex(CmdRequestValueListByListIndex cmdRequestValueListByListIndex) {
        this.myTarget.myCmdTrace(this, cmdRequestValueListByListIndex);
        if (cmdRequestValueListByListIndex.liResult_ReturnCode != 0L) {
            if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
                this.myTarget.makeError(this).append("Error! returnCode=").append(cmdRequestValueListByListIndex.liResult_ReturnCode).log();
            }
            return;
        }
        this.handleLIVALUELIST(cmdRequestValueListByListIndex.liValueList_lispValueList);
    }

    public void dsiNavigationUpdateNavstateOfOperation(int n, int n2) {
        this.myTarget.myTrace(this, "Entered DSINAVIGATION_UPDATENAVSTATEOFOPERATION.");
        if (n2 != 1) {
            this.trace("Entered DSINAVIGATION_UPDATENAVSTATEOFOPERATION with invalid flag");
            return;
        }
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().updateNavstateOfOperation(n, n2);
        switch (n) {
            case 5: {
                this.trace("NAVI-STARTUP NAVSTATEOFOPERATION_FULLY_OPERABLE -> Restart speller to update Top POIs.");
                this.handleHsmStart();
                break;
            }
        }
    }

    static /* synthetic */ boolean access$000(PoiStateRequestTopCategories poiStateRequestTopCategories, int[] nArray) {
        return poiStateRequestTopCategories.isPointLocation(nArray);
    }
}

