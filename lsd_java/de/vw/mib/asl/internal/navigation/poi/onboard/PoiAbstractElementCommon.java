/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.onboard;

import de.vw.mib.asl.api.navigation.ASLNavigationTruffelFactory;
import de.vw.mib.asl.api.navigation.IEConnector;
import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.map.MapConfiguration;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.caching.CacheClient;
import de.vw.mib.asl.internal.navigation.caching.IconKey;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdAbstractSpeller;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdLiGetState;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdPoiSelectSelectionCriteria;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdRequestValueListByListIndex;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdRestoreState;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSelectByCategoryUid;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSelectListItem;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSetInput;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSetLiValueListWindowSize;
import de.vw.mib.asl.internal.navigation.poi.onboard.DynamicPoiCategoryHandler;
import de.vw.mib.asl.internal.navigation.poi.onboard.OnboardPoiDualListViewHandler;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiAbstractHsmState;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiDatapool;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiHsmTarget;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateDetail;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateElementSurrounding;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateSelectFromResultList;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateSubElementSurrounding;
import de.vw.mib.asl.internal.navigation.poi.transformer.PoiConnectorDetailsCollector;
import de.vw.mib.asl.internal.navigation.poi.transformer.PoiResultListCollector;
import de.vw.mib.asl.internal.navigation.util.NaviHelper;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import generated.de.vw.mib.asl.internal.navigation.poi.transformer.NavigationPOIResultSelectedDetailsCollector;
import java.util.ArrayList;
import java.util.Vector;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationDescriptor;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.navigation.LISpellerData;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;
import org.dsi.ifc.navigation.ValueListStatus;

public abstract class PoiAbstractElementCommon
extends PoiAbstractHsmState
implements CacheClient {
    protected PoiHsmTarget myTarget;
    protected static final int MAX_NUMBER_OF_ELEMENTS;
    private boolean requestRunning = false;
    private boolean stopRequestingValueList;
    private boolean hybridSearchSetInputRequired = false;
    private boolean ignoreResultList = false;
    private int lastSubstringSearchStatus = 0;
    public static PoiResultListCollector[] poiResultList;
    public static ArrayList poiArrayList;
    protected static boolean continueSearch;
    protected int availableItems;
    public static LISpellerData savedSpellerState;
    protected static int lastUsedPoiIndex;
    OnboardPoiDualListViewHandler dualListViewHandler;
    protected static boolean isOnboardDualListViewActive;
    Integer lock = new Integer(0);
    protected static boolean firstUpdateDone;
    public static boolean searchIsRunning;
    public static boolean isHasNextPage;
    public static int lispValueListCount;
    protected NavLocation selectedPoiDetails = new NavLocation();
    protected NavigationPOIResultSelectedDetailsCollector poiDetailsCollector = new NavigationPOIResultSelectedDetailsCollector();
    protected int currentIndexForPoiDetailView = 0;
    protected boolean waitWithCancelSpeller = false;

    public PoiAbstractElementCommon(PoiHsmTarget poiHsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.myTarget = poiHsmTarget;
        this.dualListViewHandler = new OnboardPoiDualListViewHandler();
    }

    @Override
    public ResourceLocator getDefaultIcon() {
        return null;
    }

    @Override
    public void handleIconCacheUpdate(IconKey iconKey, ResourceLocator resourceLocator, Object object) {
        int n = (Integer)object;
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this).append("handleIconCacheUpdate index:").append(n).append(" IconID:").append(resourceLocator.getId()).log();
        }
        if (n < poiArrayList.size()) {
            ((PoiResultListCollector)PoiAbstractElementCommon.poiArrayList.get((int)n)).resourceLocator = resourceLocator;
            PoiAbstractElementCommon.poiResultList[n].resourceLocator = resourceLocator;
            Object[] objectArray = new PoiResultListCollector[]{poiResultList[n]};
            this.myTarget.notifierModel.notifyResultListItemsUpdateItems(n, objectArray);
        } else if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeError(this).append("Index out of bounds (index:").append(n).append(" size:").append(poiArrayList.size()).append(")").log();
        }
    }

    protected void clearModelData() {
        this.myTarget.myTrace(this, "clearModelData");
        poiResultList = new PoiResultListCollector[0];
        poiArrayList = new ArrayList();
        lastUsedPoiIndex = 0;
        lispValueListCount = 0;
        this.myTarget.notifierModel.notifyResultListItemsUpdateList(poiResultList);
    }

    protected void appendValueListToResultList(LIValueList lIValueList, int n) {
        this.myTarget.myTrace(this, "appendValueListToResultList");
        for (int i2 = 0; i2 < lIValueList.list.length && poiArrayList.size() < 200; ++i2) {
            if (lIValueList.list[i2] != null) {
                boolean bl;
                int n2;
                LIValueListElement lIValueListElement = lIValueList.list[i2];
                String string = lIValueListElement.data;
                ResourceLocator resourceLocator = ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForPOIIcon(lIValueListElement.iconIndex, lIValueListElement.subIconIndex, 0, this, new Integer(poiArrayList.size()));
                if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
                    this.myTarget.makeTrace(this).append("IconIndex:").append(lIValueList.list[i2].iconIndex).append(" SubIconIndex:").append(lIValueList.list[i2].subIconIndex).log();
                }
                int n3 = PoiAbstractElementCommon.calculateDistance(lIValueListElement);
                if (n == 2 && poiArrayList.size() > 0 && (n2 = ((PoiResultListCollector)PoiAbstractElementCommon.poiArrayList.get((int)(PoiAbstractElementCommon.poiArrayList.size() - 1))).distance) > n3 && 100.0 - 100.0 / (double)n2 * (double)n3 < 10.0) {
                    if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
                        this.myTarget.makeTrace(this).append("Corrected distance from ").append(n3).append(" to ").append(n2).log();
                    }
                    n3 = n2;
                }
                n2 = PoiAbstractElementCommon.calculateDirectionIndex(lIValueListElement);
                boolean bl2 = true;
                boolean bl3 = bl = lIValueList.list[i2].toRefine && lIValueList.list[i2].validDestination;
                if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
                    this.myTarget.makeTrace(this).append("Element (absolut):").append(poiArrayList.size()).append(" Element (relative):").append(i2).append(" Name:").append(string).append(" HasChilds:").append(bl ? "true" : "false").append(" distance:").append(n3).append(" directionIndex:").append(n2).append(" insideRange:").append(bl2).log();
                }
                bl = false;
                poiArrayList.add(new PoiResultListCollector(lIValueList.list[i2].iconIndex, lIValueList.list[i2].subIconIndex, resourceLocator, string, bl, n3, n2, bl2, lIValueList.list[i2].latitude, lIValueList.list[i2].longitude, lIValueList.list[i2].listIndex));
                continue;
            }
            poiArrayList.add(new PoiResultListCollector(null, "=null!", false, 0, 0, false, -1));
            if (!this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) continue;
            this.myTarget.makeError(this).append("LIValueList.list[").append(i2).append("] = null!").log();
        }
    }

    public static int calculateDirectionIndex(LIValueListElement lIValueListElement) {
        return ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().calculateDirectionIndex(PoiDatapool.getInstance().getReferenceLocation().getLongitude(), PoiDatapool.getInstance().getReferenceLocation().getLatitude(), lIValueListElement.getLongitude(), lIValueListElement.getLatitude(), PoiDatapool.getInstance().getReferenceDirection());
    }

    public static int calculateDistance(LIValueListElement lIValueListElement) {
        return ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().calculateDistance(lIValueListElement.getLongitude(), lIValueListElement.getLatitude(), PoiDatapool.getInstance().getReferenceLocation().getLongitude(), PoiDatapool.getInstance().getReferenceLocation().getLatitude());
    }

    @Override
    public void handleCommandCmdSetLiValueListWindowSize(CmdSetLiValueListWindowSize cmdSetLiValueListWindowSize) {
        this.myTarget.myCmdTrace(this, cmdSetLiValueListWindowSize);
        if (cmdSetLiValueListWindowSize.liResult_ReturnCode != 0L) {
            this.myTarget.myError(this, "CmdSetLiValueListWindowSize failded.");
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void handleUPDATEPOISUBSTRINGSEARCHSTATUS(ValueListStatus valueListStatus) {
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this).append("ValueListStatus updated. status=").append(valueListStatus.status).append(" distance:").append(valueListStatus.getDistance()).append(" numberOfAvailableItems:").append(valueListStatus.getNumberOfAvailableItems()).log();
        }
        if (valueListStatus.status != 0) {
            this.myTarget.myTrace(this, new StringBuffer().append("ValueListStatus, isHybridSearchSetInputRequired()=").append(this.isHybridSearchSetInputRequired()).toString());
            if (!this.isHybridSearchSetInputRequired() && valueListStatus.distance > 0) {
                this.myTarget.myTrace(this, new StringBuffer().append("ValueListStatus, notifyCurrentSearchRadius==").append(valueListStatus.distance).toString());
                this.myTarget.notifierModel.notifyCurrentSearchRadius(valueListStatus.distance);
            } else if (valueListStatus.distance > 0) {
                this.myTarget.myTrace(this, "ValueListStatus skiping notifyCurrentSearchRadius because it is a first level query for hybrid search.");
            } else {
                this.myTarget.myTrace(this, "ValueListStatus skiping notifyCurrentSearchRadius because radius is 0.");
            }
            this.setLastSubstringSearchStatus(valueListStatus.status);
            if (PoiDatapool.getInstance().isUpdateModel()) {
                switch (valueListStatus.status) {
                    case 2: {
                        this.myTarget.myTrace(this, "ValueListStatus==POISEARCHSTATUS_RUNNING");
                        if (!firstUpdateDone) {
                            this.myTarget.notifierModel.updateSearchStatus(true);
                            firstUpdateDone = true;
                        }
                        if (this.myTarget.getLastLiValueWindowSize() != 0 && poiArrayList.size() == lastUsedPoiIndex) {
                            this.requestNextBlock(valueListStatus.getNumberOfAvailableItems());
                            break;
                        }
                        this.myTarget.myTrace(this, "LiValueWindowSize is 0, will not ask for search results then.");
                        break;
                    }
                    case 3: {
                        this.myTarget.myTrace(this, "ValueListStatus==POISEARCHSTATUS_FINISHED");
                        this.myTarget.notifierModel.updateSearchStatus(false);
                        if (this.myTarget.getLastLiValueWindowSize() != 0) {
                            if (valueListStatus.getNumberOfAvailableItems() == 0 && poiArrayList.size() == 0) {
                                this.myTarget.notifierModel.notifySearchStateNothingFound();
                                this.myTarget.notifierModel.notifyToChangeStateOfMapUpdatePopup(true);
                                break;
                            }
                            if (poiArrayList.size() != lastUsedPoiIndex) break;
                            this.requestNextBlock(valueListStatus.getNumberOfAvailableItems());
                            break;
                        }
                        if (!this.isHybridSearchSetInputRequired()) break;
                        this.myTarget.myTrace(this, "LiValueWindowSize is 0, will not ask for search results then.");
                        this.setHybridSearchSetInputRequired(false);
                        this.myTarget.setLiValueListWindowSize(this, -1, false);
                        this.myTarget.myTrace(this, "CmdSetInput");
                        new CmdSetInput(this, PoiDatapool.getInstance().getFilterName(), false).execute();
                        return;
                    }
                    case 1: {
                        this.myTarget.myTrace(this, "ValueListStatus==POISEARCHSTATUS_CANCELED");
                        if (valueListStatus.getNumberOfAvailableItems() == 0 && poiArrayList.size() == 0) {
                            this.myTarget.notifierModel.notifySearchStateNothingFound();
                            this.myTarget.notifierModel.notifyToChangeStateOfMapUpdatePopup(true);
                            this.myTarget.notifierModel.updateSearchStatus(false);
                        }
                        if (!this.isHybridSearchSetInputRequired()) break;
                        this.setHybridSearchSetInputRequired(false);
                        break;
                    }
                    default: {
                        if (!this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) break;
                        this.myTarget.makeTrace(this).append("Unknown status for 'ValueListStatus':").append(valueListStatus.status).log();
                        break;
                    }
                }
            }
        } else {
            this.myTarget.myTrace(this, "ValueListStatus==POISEARCHSTATUS_INVALID");
        }
        if (!PoiDatapool.getInstance().isUpdateModel()) {
            PoiHsmTarget.handleOnboardPoiStatusResult(valueListStatus);
        }
    }

    public void dsiNavigationUpdatePoiSubstringSearchStatus(ValueListStatus valueListStatus, int n) {
        this.myTarget.myTrace(this, "DSINAVIGATION_UPDATEPOISUBSTRINGSEARCHSTATUS");
        if (n == 1) {
            this.handleUPDATEPOISUBSTRINGSEARCHSTATUS(valueListStatus);
        }
    }

    protected void requestNextBlock(int n) {
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this).append("requestNextBlock  newAmountOfAvailableItems:").append(n).append("  requestRunning:").append(this.isRequestRunning() ? "true" : "false").log();
        }
        int n2 = Math.max(0, n - poiArrayList.size());
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this).append("countOfRequestableItems:").append(n2).log();
        }
        this.availableItems = n;
        if (this.getLastSubstringSearchStatus() == 3 && poiArrayList.size() >= this.availableItems || poiArrayList.size() >= 200) {
            this.myTarget.myTrace(this, "Finished POI search");
        }
        if (this.isStopRequestingValueList()) {
            this.myTarget.myTrace(this, "requestNextBlock not firing CmdRequestValueListByListIndex because stopRequestingValueList is true");
        }
        if (!this.isRequestRunning() && n2 > 0 && poiArrayList.size() < 200 && !this.isStopRequestingValueList()) {
            this.setRequestRunning(true);
            if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
                this.myTarget.makeTrace(this).append("ignoreUpdates:").append(PoiStateElementSurrounding.ignoreUpdates).log();
            }
            if (PoiStateElementSurrounding.ignoreUpdates) {
                this.myTarget.myTrace(this, "Updates for surrounding search are ignored!");
                return;
            }
            if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
                this.myTarget.makeTrace(this).append("CmdRequestValueListByListIndex (").append(poiArrayList.size()).append(")").log();
            }
            new CmdLiGetState(this).execute();
            CmdRequestValueListByListIndex cmdRequestValueListByListIndex = new CmdRequestValueListByListIndex(this, poiArrayList.size(), true);
            cmdRequestValueListByListIndex.execute();
        }
    }

    protected Vector getNavLocationsFromResultList(PoiResultListCollector[] poiResultListCollectorArray) {
        Vector vector = new Vector();
        for (int i2 = 0; i2 < poiResultListCollectorArray.length; ++i2) {
            NavLocation navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(poiResultListCollectorArray[i2].latitude, poiResultListCollectorArray[i2].longitude).getLocation();
            navLocation.positionValid = true;
            navLocation.proprietaryData = new NavLocationDescriptor[]{new NavLocationDescriptor(), new NavLocationDescriptor(), new NavLocationDescriptor(), new NavLocationDescriptor(), new NavLocationDescriptor(), new NavLocationDescriptor(), new NavLocationDescriptor(), new NavLocationDescriptor(), new NavLocationDescriptor(), new NavLocationDescriptor()};
            navLocation.proprietaryData[0].selectionCriterion = 16641;
            navLocation.proprietaryData[0].data = poiResultListCollectorArray[i2].poiName;
            navLocation.proprietaryData[1].selectionCriterion = 520;
            navLocation.proprietaryData[1].data = new Integer(poiResultListCollectorArray[i2].iconIndex).toString();
            navLocation.proprietaryData[2].selectionCriterion = 282;
            navLocation.proprietaryData[2].data = new Integer(poiResultListCollectorArray[i2].subIconIndex).toString();
            navLocation.proprietaryData[3].selectionCriterion = 124;
            navLocation.proprietaryData[3].data = new Integer(poiResultListCollectorArray[i2].directionIndex).toString();
            navLocation.proprietaryData[4].selectionCriterion = 123;
            navLocation.proprietaryData[4].data = new Integer(poiResultListCollectorArray[i2].distance).toString();
            navLocation.proprietaryData[5].selectionCriterion = 4097;
            navLocation.proprietaryData[5].data = new Integer(poiResultListCollectorArray[i2].listIndex).toString();
            navLocation.proprietaryData[6].selectionCriterion = 128;
            navLocation.proprietaryData[6].data = "";
            navLocation.proprietaryData[7].selectionCriterion = 8;
            navLocation.proprietaryData[7].data = "";
            navLocation.proprietaryData[8].selectionCriterion = 0;
            navLocation.proprietaryData[8].data = new Integer(this.myTarget.getTargetId()).toString();
            navLocation.proprietaryData[9].selectionCriterion = 310378496;
            navLocation.proprietaryData[9].data = "";
            vector.add(navLocation);
        }
        return vector;
    }

    protected void updateSldeSearchResults(Vector vector) {
        this.myTarget.myTrace(this, new StringBuffer().append("updateSldeSearchResults: lastSubstringSearchStatus: ").append(this.getLastSubstringSearchStatus()).append(", Resultlistsize: ").append(poiArrayList.size()).append(", AvailableItems: ").append(this.availableItems).toString());
        if (this.getLastSubstringSearchStatus() == 3 && poiArrayList.size() >= this.availableItems || poiArrayList.size() >= 200) {
            ASLNavigationTruffelFactory.getNavigationTruffelApi().setSearchResults(vector, false, ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getSoPosPositionDescription(), false);
        } else {
            ASLNavigationTruffelFactory.getNavigationTruffelApi().setSearchResults(vector, true, ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getSoPosPositionDescription(), false);
        }
    }

    public int getLastSubstringSearchStatus() {
        return this.lastSubstringSearchStatus;
    }

    public void setLastSubstringSearchStatus(int n) {
        this.lastSubstringSearchStatus = n;
    }

    @Override
    public void handleCommandCmdPoiSelectSelectionCriteria(CmdPoiSelectSelectionCriteria cmdPoiSelectSelectionCriteria) {
        if (this.waitWithCancelSpeller) {
            this.waitWithCancelSpeller = false;
        }
        this.handleLiValueList(cmdPoiSelectSelectionCriteria);
    }

    public boolean isRequestRunning() {
        return this.requestRunning;
    }

    public void setRequestRunning(boolean bl) {
        this.requestRunning = bl;
    }

    public boolean isStopRequestingValueList() {
        return this.stopRequestingValueList;
    }

    public void setStopRequestingValueList(boolean bl) {
        this.stopRequestingValueList = bl;
    }

    protected void handleLIVALUELIST(LIValueList lIValueList, int n) {
        this.myTarget.myTrace(this, "LIValueList list updated.");
        int n2 = PoiDatapool.getInstance().getCurrentUseCase();
        if (this.isIgnoreResultList() && (n2 == 4 || n2 == 5 || n2 == 6 || n2 == 8 || n2 == 7 || n2 == 14 || n2 == 9 || n2 == 17 || n2 == 15 || n2 == 16 || n2 == 9 || n2 == 10 || n2 == 0xF800000 || n2 == 18)) {
            this.setIgnoreResultList(false);
            this.myTarget.myTrace(this, "LIValueList list ignored, this time.");
            return;
        }
        boolean bl = true;
        if (!PoiDatapool.getInstance().isUpdateModel()) {
            PoiHsmTarget.handleOnboardValueList(lIValueList, n);
        } else {
            int n3;
            if (lIValueList != null && lIValueList.list != null) {
                n3 = lIValueList.list.length;
                if (continueSearch) {
                    if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
                        this.myTarget.makeTrace(this).append("Ignored previous ").append(n3).append(" elements after restore!").log();
                    }
                    continueSearch = false;
                    return;
                }
                if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
                    this.myTarget.makeTrace(this).append("Length of LIValueList:").append(n3).log();
                }
                boolean bl2 = bl = n3 <= 0;
                if (bl) {
                    this.myTarget.myTrace(this, "LIValueList.list.length == 0!");
                    poiArrayList = new ArrayList();
                    lastUsedPoiIndex = 0;
                }
            } else {
                this.myTarget.myTrace(this, "LIValueList == null");
                if (this.getLastSubstringSearchStatus() != 3) {
                    this.clearModelData();
                    ((PoiStateSubElementSurrounding)this.myTarget.statePoiSubElementSurrounding).clearModelData();
                    this.availableItems = 0;
                    this.myTarget.notifierModel.updateSearchStatus(true);
                }
            }
            if (!bl) {
                n3 = lastUsedPoiIndex;
                this.appendValueListToResultList(lIValueList, 2);
                poiResultList = new PoiResultListCollector[poiArrayList.size()];
                poiArrayList.toArray(poiResultList);
                if (isOnboardDualListViewActive) {
                    isHasNextPage = lIValueList.isHasNextPage();
                    lispValueListCount = n;
                    this.requestDetailedDataForEachNewPoiEntry(n3, lIValueList.list.length);
                }
            }
            this.updateOnlineSwitchButtonState();
        }
    }

    @Override
    public void handleCommandCmdSelectByCategoryUid(CmdSelectByCategoryUid cmdSelectByCategoryUid) {
        this.myTarget.myCmdTrace(this, cmdSelectByCategoryUid);
        int n = 16;
        if (PoiDatapool.getInstance().getFilterName().length() == 0) {
            this.myTarget.setLiValueListWindowSize(this, -1, false);
        } else {
            this.myTarget.setLiValueListWindowSize(this, 0, false);
            this.setIgnoreResultList(true);
            this.setHybridSearchSetInputRequired(true);
        }
        if (!this.myTarget.selectCriterionInPOIValueList(this, cmdSelectByCategoryUid.liValueList_lispValueList, n)) {
            // empty if block
        }
    }

    public boolean isIgnoreResultList() {
        return this.ignoreResultList;
    }

    public void setIgnoreResultList(boolean bl) {
        this.ignoreResultList = bl;
    }

    public void handleLiValueList(CmdAbstractSpeller cmdAbstractSpeller) {
        this.myTarget.myCmdTrace(this, cmdAbstractSpeller);
        if (cmdAbstractSpeller.liResult_ReturnCode != 0L) {
            if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
                this.myTarget.makeError(this).append("Error! returnCode=").append(cmdAbstractSpeller.liResult_ReturnCode).log();
            }
            return;
        }
        this.handleLIVALUELIST(cmdAbstractSpeller.liValueList_lispValueList, (int)cmdAbstractSpeller.liValueList_lispValueListCount);
    }

    void updateOnlineSwitchButtonState() {
        int n = PoiDatapool.getInstance().getFilterCategoryUid();
        this.myTarget.myTrace(this, new StringBuffer().append("Selected onboard category UID: ").append(n).toString());
        this.myTarget.myTrace(this, new StringBuffer().append("Last selected top POI category UID: ").append(PoiDatapool.getInstance().getLastSelectedTopPoiUid()).toString());
        if (n != -1) {
            DynamicPoiCategoryHandler.updateByOnboardUid(n);
        }
    }

    protected boolean isHybridSearchSetInputRequired() {
        return this.hybridSearchSetInputRequired;
    }

    protected void setHybridSearchSetInputRequired(boolean bl) {
        this.hybridSearchSetInputRequired = bl;
    }

    @Override
    public void handleCommandCmdLiGetState(CmdLiGetState cmdLiGetState) {
        if (null != cmdLiGetState.liGetStateResult_spellerState) {
            if (null == cmdLiGetState.getBlindArgument("DetailedPoi_SkipSaveState")) {
                savedSpellerState = cmdLiGetState.liGetStateResult_spellerState;
            }
        } else if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeError(this).append("handleCommandCmdLiGetState: getStateResult_spellerState is null.").log();
        }
    }

    public void requestDetailedDataForEachNewPoiEntry(int n, int n2) {
        CmdSelectListItem cmdSelectListItem = new CmdSelectListItem(this, n, n + n2 - 1);
        cmdSelectListItem.setBlindArgument("DetailedPoi", new Object());
        cmdSelectListItem.execute();
    }

    protected void processSelectListItemForDetailedPOI(CmdSelectListItem cmdSelectListItem) {
        if (isOnboardDualListViewActive) {
            if (cmdSelectListItem.getMaxIndex() == cmdSelectListItem.getIndex()) {
                if (null != savedSpellerState) {
                    CmdRestoreState cmdRestoreState = new CmdRestoreState(this, savedSpellerState);
                    cmdRestoreState.setBlindArgument("DetailedPoi", new Object());
                    cmdRestoreState.execute();
                } else if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
                    this.myTarget.makeError(this).append("processSelectListItemForDetailedPOI: savedSpellerState is null. Cannot restore speller.").log();
                }
                if (0 == PoiDatapool.getInstance().getCurrentUseCase() && (lispValueListCount > lastUsedPoiIndex || isHasNextPage)) {
                    new CmdRequestValueListByListIndex(this, lastUsedPoiIndex, true).execute();
                }
            } else {
                CmdSelectListItem cmdSelectListItem2 = new CmdSelectListItem(this, cmdSelectListItem.getIndex() + 1, cmdSelectListItem.getMaxIndex());
                cmdSelectListItem2.setBlindArgument("DetailedPoi", new Object());
                cmdSelectListItem2.execute();
            }
        }
    }

    public void cutOffResultList(int n) {
        ArrayList arrayList = new ArrayList(n);
        PoiResultListCollector[] poiResultListCollectorArray = new PoiResultListCollector[n];
        for (int i2 = 0; i2 < n; ++i2) {
            arrayList.add(poiArrayList.get(i2));
            poiResultListCollectorArray[i2] = poiResultList[i2];
        }
        poiArrayList = arrayList;
        poiResultList = poiResultListCollectorArray;
    }

    public void updateCuttedResultListAtHmi(int n) {
        Object object;
        if (poiResultList.length != n) {
            object = new PoiResultListCollector[n];
            for (int i2 = 0; i2 < n; ++i2) {
                object[i2] = poiResultList[i2];
            }
            poiResultList = object;
        }
        this.myTarget.notifierModel.notifyResultListItemsUpdateList(poiResultList);
        if (PoiDatapool.getInstance().getCurrentUseCase() == 14) {
            object = this.getNavLocationsFromResultList(poiResultList);
            this.updateSldeSearchResults((Vector)object);
        }
    }

    protected void selectPoiElementWithoutChildren(int n) {
        if (poiResultList.length != 0 && n <= poiResultList.length) {
            this.selectedPoiDetails = PoiAbstractElementCommon.poiResultList[n].poiNavLocation;
            if (!PoiDatapool.getInstance().isUpdateModel()) {
                PoiHsmTarget.handleOnboardPoiResult(this.selectedPoiDetails);
            }
            MapConfiguration mapConfiguration = new MapConfiguration(this.selectedPoiDetails, 25, 0);
            ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainContentGotoLocation(13, mapConfiguration);
            mapConfiguration.setPoiShowCategoryIcon(true);
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setPOILocation(this.selectedPoiDetails);
            ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(this.selectedPoiDetails);
            this.writePoiDetails(iLocationWrapper);
            try {
                this.writePoiChargingStationDetails(iLocationWrapper);
            }
            catch (Throwable throwable) {
                ServiceManager.logger.error(16384, "Workaround for wrong POIFactory", throwable);
            }
            this.myTarget.notifierModel.notifyNaviPoiDataLoadFinished();
        } else {
            PoiStateDetail.currentDetailsIndex = n;
            PoiStateSelectFromResultList.restore = false;
            this.trans(this.myTarget.statePoiSelectFromResultList);
        }
    }

    protected void writePoiDetails(ILocationWrapper iLocationWrapper) {
        ResourceLocator resourceLocator;
        this.myTarget.myTrace(this, "writePoiDetails");
        int n = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().calculateDistance(this.selectedPoiDetails.longitude, this.selectedPoiDetails.latitude, PoiDatapool.getInstance().getReferenceLocation().getLongitude(), PoiDatapool.getInstance().getReferenceLocation().getLatitude());
        int n2 = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().calculateDirectionIndex(PoiDatapool.getInstance().getReferenceLocation().getLongitude(), PoiDatapool.getInstance().getReferenceLocation().getLatitude(), this.selectedPoiDetails.longitude, this.selectedPoiDetails.latitude, PoiDatapool.getInstance().getReferenceDirection());
        int n3 = iLocationWrapper.getIconIndex();
        int n4 = iLocationWrapper.getSubIconIndex();
        int n5 = iLocationWrapper.getLatitude();
        int n6 = iLocationWrapper.getLongitude();
        String string = iLocationWrapper.getPoiClass();
        String string2 = iLocationWrapper.getPoiCategory();
        String string3 = iLocationWrapper.getPoiName();
        String string4 = iLocationWrapper.getCountry();
        String string5 = iLocationWrapper.getCountryCode();
        String string6 = iLocationWrapper.getCity();
        String string7 = iLocationWrapper.getCityRefinement();
        String string8 = iLocationWrapper.getCityCenter();
        String string9 = iLocationWrapper.getStreet();
        String string10 = iLocationWrapper.getStreetRefinement();
        String string11 = iLocationWrapper.getCrossing();
        String string12 = iLocationWrapper.getHousenumber();
        String string13 = iLocationWrapper.getPostalCode();
        String string14 = iLocationWrapper.getMotorWayExit();
        String string15 = iLocationWrapper.getPhonenumber();
        String string16 = "";
        String string17 = "";
        try {
            string16 = iLocationWrapper.getState();
        }
        catch (Throwable throwable) {
            ServiceManager.logger.error(16384, "Workaround for wrong POIFactory", throwable);
        }
        try {
            string17 = iLocationWrapper.getProvince();
        }
        catch (Throwable throwable) {
            ServiceManager.logger.error(16384, "Workaround for wrong POIFactory", throwable);
        }
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this).append("distance=").append(n).log();
            this.myTarget.makeTrace(this).append("direction=").append(n2).log();
            this.myTarget.makeTrace(this).append("getIconIndex=").append(n3).log();
            this.myTarget.makeTrace(this).append("getSubIconIndex=").append(n4).log();
            this.myTarget.makeTrace(this).append("getLatitude=").append(n5).log();
            this.myTarget.makeTrace(this).append("getLongitude=").append(n6).log();
            this.myTarget.makeTrace(this).append("getPoiClass=").append(string).log();
            this.myTarget.makeTrace(this).append("getPoiCategory=").append(string2).log();
            this.myTarget.makeTrace(this).append("getPoiName=").append(string3).log();
            this.myTarget.makeTrace(this).append("getCountry=").append(string4).log();
            this.myTarget.makeTrace(this).append("getCountryAbbreviation=").append(string5).log();
            this.myTarget.makeTrace(this).append("getTown=").append(string6).log();
            this.myTarget.makeTrace(this).append("getTownRefinement=").append(string7).log();
            this.myTarget.makeTrace(this).append("getTowncenter=").append(string8).log();
            this.myTarget.makeTrace(this).append("getStreet=").append(string9).log();
            this.myTarget.makeTrace(this).append("getStreetRefinement=").append(string10).log();
            this.myTarget.makeTrace(this).append("getJunction=").append(string11).log();
            this.myTarget.makeTrace(this).append("getHousenumber=").append(string12).log();
            this.myTarget.makeTrace(this).append("getZipCode=").append(string13).log();
            this.myTarget.makeTrace(this).append("getMotorWayExit=").append(string14).log();
            this.myTarget.makeTrace(this).append("getPhonenumber=").append(string15).log();
            this.myTarget.makeTrace(this).append("getState=").append(string16).log();
            this.myTarget.makeTrace(this).append("getProvince=").append(string17).log();
        }
        this.poiDetailsCollector = new NavigationPOIResultSelectedDetailsCollector();
        this.poiDetailsCollector.navigation_poi_result_selected_details_distance = n;
        this.poiDetailsCollector.navigation_poi_result_selected_details_direction_arrow_index = n2;
        this.poiDetailsCollector.navigation_poi_result_selected_details_headline_icon = resourceLocator = ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForPOIIcon(n3, n4, 0, this, null);
        this.poiDetailsCollector.navigation_poi_result_selected_details_latitude = n5;
        this.poiDetailsCollector.navigation_poi_result_selected_details_longitude = n6;
        this.poiDetailsCollector.navigation_poi_result_selected_details_class = string;
        this.poiDetailsCollector.navigation_poi_result_selected_details_category = string2;
        this.poiDetailsCollector.navigation_poi_result_selected_details_name = string3;
        this.poiDetailsCollector.navigation_poi_result_selected_details_country = string4;
        this.poiDetailsCollector.navigation_poi_result_selected_details_country_code = string5;
        this.poiDetailsCollector.navigation_poi_result_selected_details_city = string6;
        this.poiDetailsCollector.navigation_poi_result_selected_details_city_refinement = string7;
        this.poiDetailsCollector.navigation_poi_result_selected_details_city_center = string8;
        this.poiDetailsCollector.navigation_poi_result_selected_details_street = string9;
        this.poiDetailsCollector.navigation_poi_result_selected_street_refinement = string10;
        this.poiDetailsCollector.navigation_poi_result_selected_details_crossing = string11;
        this.poiDetailsCollector.navigation_poi_result_selected_details_housenumber = string12;
        this.poiDetailsCollector.navigation_poi_result_selected_details_zip = string13;
        this.poiDetailsCollector.navigation_poi_result_selected_details_motorway_exit = string14;
        this.poiDetailsCollector.navigation_poi_result_selected_details_phone_number = string15;
        this.poiDetailsCollector.navigation_poi_result_selected_details_url = "";
        this.poiDetailsCollector.navigation_poi_result_selected_details_state = string16;
        this.poiDetailsCollector.navigation_poi_result_selected_details_province = string17;
        this.poiDetailsCollector.navigation_poi_result_selected_detail_address_for_fix_formatter = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationFormatter().prepareFixFormatterFieldData(iLocationWrapper);
        this.myTarget.notifierModel.notifyPoiName(string3);
        ServiceManager.aslPropertyManager.valueChangedString(-672133120, iLocationWrapper.getURLAddress());
        this.myTarget.notifierModel.notifyPoiDetails(this.poiDetailsCollector);
    }

    protected void writePoiChargingStationDetails(ILocationWrapper iLocationWrapper) {
        int n;
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this).append("writePoiChargingStationDetails").log();
        }
        String string = iLocationWrapper.getChargingStationProvider() != null ? iLocationWrapper.getChargingStationProvider() : "";
        int n2 = iLocationWrapper.getChargingStationAccess();
        int n3 = iLocationWrapper.getChargingStationOnSitePayment();
        int n4 = iLocationWrapper.getChargingStationOpen24h();
        int n5 = iLocationWrapper.getChargingStationPay();
        int n6 = iLocationWrapper.getChargingStationSubscription();
        int n7 = iLocationWrapper.getEConnectorCount();
        IEConnector[] iEConnectorArray = iLocationWrapper.getEConnectors();
        boolean bl = true;
        if (ASLSystemFactory.getSystemApi().getFeatureFlagValueBEV()) {
            int n8 = NaviHelper.getInstance().calculateDistance(iLocationWrapper.getLongitude(), iLocationWrapper.getLatitude(), PoiDatapool.getInstance().getCcp().getLongitude(), PoiDatapool.getInstance().getCcp().getLatitude());
            n = (int)((double)PoiDatapool.getInstance().getRemainingBatteryRangeFixed() * 0.95 / 1.25);
            if (n < n8) {
                // empty if block
            }
        }
        this.poiDetailsCollector.navigation_poi_result_selected_details_inside_range = bl;
        this.poiDetailsCollector.navigation_poi_result_selected_details_provider_available = string != null && string.length() > 0;
        this.poiDetailsCollector.navigation_poi_result_selected_details_provider = string;
        switch (n2) {
            case -1: {
                this.poiDetailsCollector.navigation_poi_result_selected_details_access = 0;
                break;
            }
            case 0: {
                this.poiDetailsCollector.navigation_poi_result_selected_details_access = 1;
                break;
            }
            case 1: {
                this.poiDetailsCollector.navigation_poi_result_selected_details_access = 2;
                break;
            }
            case 2: {
                this.poiDetailsCollector.navigation_poi_result_selected_details_access = 3;
                break;
            }
            case 3: {
                this.poiDetailsCollector.navigation_poi_result_selected_details_access = 4;
                break;
            }
            default: {
                this.poiDetailsCollector.navigation_poi_result_selected_details_access = 0;
                if (!this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) break;
                this.myTarget.makeError(this).append("'chargingAccess' unknown value!").log();
            }
        }
        switch (n3) {
            case -1: {
                this.poiDetailsCollector.navigation_poi_result_selected_details_onsitepayment_available = false;
                this.poiDetailsCollector.navigation_poi_result_selected_details_onsitepayment = "";
                break;
            }
            case 0: {
                this.poiDetailsCollector.navigation_poi_result_selected_details_onsitepayment_available = false;
                this.poiDetailsCollector.navigation_poi_result_selected_details_onsitepayment = "";
                break;
            }
            case 1: {
                this.poiDetailsCollector.navigation_poi_result_selected_details_onsitepayment_available = true;
                this.poiDetailsCollector.navigation_poi_result_selected_details_onsitepayment = ":-)";
                break;
            }
            default: {
                this.poiDetailsCollector.navigation_poi_result_selected_details_onsitepayment_available = false;
                this.poiDetailsCollector.navigation_poi_result_selected_details_onsitepayment = "";
                if (!this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) break;
                this.myTarget.makeError(this).append("'chargingStationOnSitePayment' unknown value!").log();
            }
        }
        switch (n3) {
            case -1: {
                this.poiDetailsCollector.navigation_poi_result_selected_details_onsitepayment__enum = 0;
                break;
            }
            case 0: {
                this.poiDetailsCollector.navigation_poi_result_selected_details_onsitepayment__enum = 2;
                break;
            }
            case 1: {
                this.poiDetailsCollector.navigation_poi_result_selected_details_onsitepayment__enum = 1;
                break;
            }
            default: {
                this.poiDetailsCollector.navigation_poi_result_selected_details_onsitepayment__enum = 0;
                if (!this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) break;
                this.myTarget.makeError(this).append("'chargingStationOnSitePayment' unknown value!").log();
            }
        }
        switch (n4) {
            case 1: {
                this.poiDetailsCollector.navigation_poi_result_selected_details_open24h = 2;
                break;
            }
            default: {
                this.poiDetailsCollector.navigation_poi_result_selected_details_open24h = 0;
            }
        }
        switch (n5) {
            case -1: {
                this.poiDetailsCollector.navigation_poi_result_selected_details_payment = 0;
                break;
            }
            case 0: {
                this.poiDetailsCollector.navigation_poi_result_selected_details_payment = 2;
                break;
            }
            case 1: {
                this.poiDetailsCollector.navigation_poi_result_selected_details_payment = 1;
                break;
            }
            default: {
                this.poiDetailsCollector.navigation_poi_result_selected_details_payment = 0;
                if (!this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) break;
                this.myTarget.makeError(this).append("'chargingStationPay' unknown value!").log();
            }
        }
        switch (n6) {
            case -1: {
                this.poiDetailsCollector.navigation_poi_result_selected_details_subscription = 0;
                break;
            }
            case 0: {
                this.poiDetailsCollector.navigation_poi_result_selected_details_subscription = 2;
                break;
            }
            case 1: {
                this.poiDetailsCollector.navigation_poi_result_selected_details_subscription = 1;
                break;
            }
            default: {
                this.poiDetailsCollector.navigation_poi_result_selected_details_subscription = 0;
                if (!this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) break;
                this.myTarget.makeError(this).append("'chargingStationSubscription' unknown value!").log();
            }
        }
        this.poiDetailsCollector.navigation_poi_result_selected_details_connector_count = n7;
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this).append("chargingProvider=").append(string).log();
            this.myTarget.makeTrace(this).append("chargingAccess=").append(n2).log();
            this.myTarget.makeTrace(this).append("chargingStationOnSitePayment=").append(n3).log();
            this.myTarget.makeTrace(this).append("chargingStationOpen24h=").append(n4).log();
            this.myTarget.makeTrace(this).append("chargingStationPay=").append(n5).log();
            this.myTarget.makeTrace(this).append("chargingStationSubscription=").append(n6).log();
            this.myTarget.makeTrace(this).append("eConnectorCount=").append(n7).log();
        }
        this.myTarget.notifierModel.notifyPoiDetails(this.poiDetailsCollector);
        PoiConnectorDetailsCollector[] poiConnectorDetailsCollectorArray = new PoiConnectorDetailsCollector[n7];
        for (n = 0; n < n7; ++n) {
            String string2;
            String string3;
            int n9;
            String string4;
            String string5;
            poiConnectorDetailsCollectorArray[n] = new PoiConnectorDetailsCollector(0, "", "", "", "", 0, 0);
            if (iEConnectorArray[n] == null) {
                if (!this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) continue;
                this.myTarget.makeError(this).append("eConnector[").append(n).append("] == null!").log();
                continue;
            }
            poiConnectorDetailsCollectorArray[n].chargeMode = string5 = iEConnectorArray[n].getChargeMode() != null ? iEConnectorArray[n].getChargeMode() : "";
            poiConnectorDetailsCollectorArray[n].chargeLevel = string4 = iEConnectorArray[n].getChargeLevel() != null ? iEConnectorArray[n].getChargeLevel() : "";
            poiConnectorDetailsCollectorArray[n].count = n9 = iEConnectorArray[n].getCountAvailable();
            poiConnectorDetailsCollectorArray[n].fuseProtection = string3 = iEConnectorArray[n].getFuseProtection() != null ? iEConnectorArray[n].getFuseProtection() : "";
            poiConnectorDetailsCollectorArray[n].name = string2 = iEConnectorArray[n].getName() != null ? iEConnectorArray[n].getName() : "";
            float f2 = iEConnectorArray[n].getPowerOutput();
            poiConnectorDetailsCollectorArray[n].poweroutput = (int)(f2 * 31300);
            int n10 = iEConnectorArray[n].getType();
            switch (n10) {
                case -1: {
                    poiConnectorDetailsCollectorArray[n].type = 0;
                    break;
                }
                case 15: {
                    poiConnectorDetailsCollectorArray[n].type = 1;
                    break;
                }
                case 32: {
                    poiConnectorDetailsCollectorArray[n].type = 2;
                    break;
                }
                case 33: {
                    poiConnectorDetailsCollectorArray[n].type = 3;
                    break;
                }
                case 42: {
                    poiConnectorDetailsCollectorArray[n].type = 4;
                    break;
                }
                case 43: {
                    poiConnectorDetailsCollectorArray[n].type = 5;
                    break;
                }
                case 31: {
                    poiConnectorDetailsCollectorArray[n].type = 6;
                    break;
                }
                case 41: {
                    poiConnectorDetailsCollectorArray[n].type = 7;
                    break;
                }
                default: {
                    poiConnectorDetailsCollectorArray[n].type = 0;
                    if (!this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) break;
                    this.myTarget.makeError(this).append("'type' unknown value!").log();
                }
            }
            if (!this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) continue;
            this.myTarget.makeTrace(this).append("chargeMode=").append(string5).log();
            this.myTarget.makeTrace(this).append("chargeLevel=").append(string4).log();
            this.myTarget.makeTrace(this).append("countAvailable=").append(n9).log();
            this.myTarget.makeTrace(this).append("fuseProtection=").append(string3).log();
            this.myTarget.makeTrace(this).append("name=").append(string2).log();
            this.myTarget.makeTrace(this).append("powerOutput=").append(f2).log();
            this.myTarget.makeTrace(this).append("type=").append(n10).log();
        }
        this.myTarget.notifierModel.notifyPoiConnectorDetails(poiConnectorDetailsCollectorArray);
    }

    public boolean isWaitWithCancelSpeller() {
        return this.waitWithCancelSpeller;
    }

    public void setWaitWithCancelSpeller(boolean bl) {
        this.waitWithCancelSpeller = bl;
    }

    static {
        poiArrayList = new ArrayList(0);
        continueSearch = false;
        lastUsedPoiIndex = 0;
        isOnboardDualListViewActive = false;
        firstUpdateDone = false;
        lispValueListCount = 0;
    }
}

