/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.onboard.ppoi;

import de.vw.mib.asl.internal.navigation.caching.CacheClient;
import de.vw.mib.asl.internal.navigation.caching.HsmCacheHandler;
import de.vw.mib.asl.internal.navigation.caching.IconKey;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdLiGetState;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdPoiSelectSelectionCriteria;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdRequestValueListByListIndex;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdRestoreState;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSelectListItem;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSelectListItemPoi;
import de.vw.mib.asl.internal.navigation.personalpoi.transformer.PPoiResultListCollector;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateCategory;
import de.vw.mib.asl.internal.navigation.poi.onboard.ppoi.PPoiAbstractHsmState;
import de.vw.mib.asl.internal.navigation.poi.onboard.ppoi.PPoiHsmTarget;
import de.vw.mib.asl.internal.navigation.poi.onboard.ppoi.PPoiStateDetail;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import java.util.ArrayList;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.navigation.LISpellerData;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.ValueListStatus;

public class PPoiStateCategory
extends PPoiAbstractHsmState
implements CacheClient {
    private static final int MAX_NUMBER_OF_ELEMENTS;
    private PPoiHsmTarget pPoiTarget;
    private PPoiResultListCollector[] getSearchCatList;
    private int selectedEntrFromGroupList;
    private int availableItems;
    private int lastSubstringSearchStatus = 0;
    private ArrayList catArrayList = null;
    private boolean requestRunning = false;
    private boolean ignoreUpdatesAfterPPoiwasSelected;
    public static boolean IGNORE_FURTHER_GROUP_ELEMENTS;
    public static LISpellerData SAVED_SPELLER_SATE;
    protected static int lastUsedPoiIndex;

    public PPoiStateCategory(PPoiHsmTarget pPoiHsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(pPoiHsmTarget, hsm, string, hsmState);
        this.pPoiTarget = pPoiHsmTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        this.pPoiTarget.myTrace(this, new StringBuffer().append("Received event ID: ").append(eventGeneric.getReceiverEventId()).toString());
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.pPoiTarget.myTrace(this, "HSM_ENTRY");
                break;
            }
            case 3: {
                this.pPoiTarget.myTrace(this, "HSM_START");
                this.handleHsmStart();
                break;
            }
            case 4: {
                this.pPoiTarget.myTrace(this, "HSM_EXIT");
                break;
            }
            case 1074841975: {
                this.pPoiTarget.myTrace(this, "ASL_NAVIGATION_PERSONAL_POI_RESULT_SELECT_CATEGORY_ITEM");
                this.selectPoiElement(eventGeneric.getInt(0));
                break;
            }
            default: {
                this.pPoiTarget.myTrace(this, new StringBuffer().append("Received event which is not handled in this state (ID=").append(eventGeneric.getReceiverEventId()).append(")").toString());
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private void handleHsmStart() {
        this.setIgnoreUpdatesAfterPPoiwasSelected(false);
        this.setIsRequestRunning(false);
        if (SAVED_SPELLER_SATE != null) {
            this.clearModelData();
            new CmdRestoreState(this, SAVED_SPELLER_SATE).execute();
        } else {
            new CmdLiGetState(this).execute();
        }
    }

    @Override
    public void handleCommandCmdRestoreState(CmdRestoreState cmdRestoreState) {
        this.selectcategoryElements();
    }

    @Override
    public void handleCommandCmdSelectListItemPoi(CmdSelectListItemPoi cmdSelectListItemPoi) {
        this.pPoiTarget.myTrace(this, cmdSelectListItemPoi.toString());
        if (cmdSelectListItemPoi.liResult_ReturnCode != 0L) {
            this.pPoiTarget.myError(this, new StringBuffer().append("Error! returnCode=").append(cmdSelectListItemPoi.liResult_ReturnCode).toString());
            return;
        }
        this.handlePOIVALUELIST(cmdSelectListItemPoi.liValueList_lispValueList, 16);
    }

    @Override
    public void handleCommandCmdPoiSelectSelectionCriteria(CmdPoiSelectSelectionCriteria cmdPoiSelectSelectionCriteria) {
        this.pPoiTarget.myTrace(this, cmdPoiSelectSelectionCriteria.toString());
        if (cmdPoiSelectSelectionCriteria.liResult_ReturnCode != 0L) {
            this.pPoiTarget.myTrace(this, new StringBuffer().append("Error! returnCode= ").append(cmdPoiSelectSelectionCriteria.liResult_ReturnCode).toString());
            return;
        }
        this.pPoiTarget.notifierModel.quitModelWaitstate();
    }

    @Override
    public void handleIconCacheUpdate(IconKey iconKey, ResourceLocator resourceLocator, Object object) {
        this.pPoiTarget.myTrace(this, new StringBuffer().append("handleIconCacheUpdate index:").append((Integer)object).append(" IconID:").append(resourceLocator.getId()).toString());
        int n = (Integer)object;
        if (n < this.catArrayList.size()) {
            ((PPoiResultListCollector)this.catArrayList.get((int)n)).resourceLocator = resourceLocator;
            if (this.getSearchCatList.length != 0 && n < this.getSearchCatList.length) {
                this.getSearchCatList[n].resourceLocator = resourceLocator;
                Object[] objectArray = new PPoiResultListCollector[]{this.getSearchCatList[n]};
                this.pPoiTarget.notifierModel.notifyCategoryListItemsUpdateItems(n, objectArray);
            }
        } else {
            this.pPoiTarget.myError(this, new StringBuffer().append("Index out of bounds (index: ").append(resourceLocator.getId()).append(" length:").append(this.getSearchCatList.length).append(")").toString());
        }
    }

    @Override
    public void handleCommandCmdRequestValueListByListIndex(CmdRequestValueListByListIndex cmdRequestValueListByListIndex) {
        this.pPoiTarget.myTrace(this, cmdRequestValueListByListIndex.toString());
        if (cmdRequestValueListByListIndex.liResult_ReturnCode != 0L) {
            this.pPoiTarget.myError(this, new StringBuffer().append("Error! returnCode=").append(cmdRequestValueListByListIndex.liResult_ReturnCode).toString());
            return;
        }
        this.handleLIVALUELIST(cmdRequestValueListByListIndex.liValueList_lispValueList);
    }

    @Override
    public void handleCommandCmdSelectListItem(CmdSelectListItem cmdSelectListItem) {
        this.pPoiTarget.myTrace(this, new StringBuffer().append("handleCommandCmdSelectListItem (").append(cmdSelectListItem.getElapsedTimeInMs()).append("ms").toString());
        if (cmdSelectListItem.liResult_ReturnCode != 0L) {
            this.pPoiTarget.myError(this, new StringBuffer().append("Error! returnCode=").append(cmdSelectListItem.liResult_ReturnCode).toString());
            this.pPoiTarget.transAfterCallback(this.pPoiTarget.statePpoi);
            return;
        }
        ((PPoiStateDetail)this.pPoiTarget.statePPoiDetail).setcurrentDestinationLocation(cmdSelectListItem.liCurrentState_liCurrentLD);
        this.pPoiTarget.transAfterCallback(this.pPoiTarget.statePPoiDetail);
    }

    @Override
    public void handleCommandCmdLiGetState(CmdLiGetState cmdLiGetState) {
        SAVED_SPELLER_SATE = cmdLiGetState.liGetStateResult_spellerState;
        this.selectcategoryElements();
    }

    private void handleLIVALUELIST(LIValueList lIValueList) {
        this.pPoiTarget.myTrace(this, "LIValueList list updated.");
        this.setIsRequestRunning(false);
        if (IGNORE_FURTHER_GROUP_ELEMENTS) {
            return;
        }
        boolean bl = false;
        if (bl = this.isliValuelistEmpty(lIValueList, bl)) {
            this.appendValueListToResultList(lIValueList);
            this.getSearchCatList = new PPoiResultListCollector[this.catArrayList.size()];
            this.catArrayList.toArray(this.getSearchCatList);
            this.pPoiTarget.notifierModel.notifyCategoryListItemsUpdateList(this.getSearchCatList);
            this.requestNextBlock(this.availableItems);
        }
    }

    public void dsiNavigationUpdatePoiSubstringSearchStatus(ValueListStatus valueListStatus, int n) {
        this.pPoiTarget.myTrace(this, "DSINAVIGATION_UPDATEPOISUBSTRINGSEARCHSTATUS");
        if (n == 1) {
            this.handleUpdatePoiSubstringSearchStatus(valueListStatus);
        }
    }

    private void selectcategoryElements() {
        this.pPoiTarget.getDsiNavigation().poiSetSortOrder2(2);
        this.pPoiTarget.setLiValueListWindowSize(this, -1, true);
        this.setPoiContextToDsi();
        this.pPoiTarget.notifierModel.notifySearchStateSearching();
        this.pPoiTarget.notifierModel.notifyNaviPoiDataLoadFinished();
        new CmdSelectListItemPoi(this, this.selectedEntrFromGroupList).execute();
    }

    private void selectPoiElement(int n) {
        this.pPoiTarget.myTrace(this, new StringBuffer().append("PPOI index:").append(n).toString());
        this.setIgnoreUpdatesAfterPPoiwasSelected(true);
        this.pPoiTarget.myTrace(this, "CmdSelectListItem");
        new CmdSelectListItem(this, n).execute();
    }

    private void handleUpdatePoiSubstringSearchStatus(ValueListStatus valueListStatus) {
        this.pPoiTarget.myTrace(this, new StringBuffer().append("ValueListStatus updated. status= ").append(valueListStatus.status).append(" distance: ").append(valueListStatus.getDistance()).append(" numberOfAvailableItems: ").append(valueListStatus.getNumberOfAvailableItems()).toString());
        if (valueListStatus.status == 0) {
            this.pPoiTarget.myError(this, "ValueListStatus==POISEARCHSTATUS_INVALID");
            return;
        }
        this.setLastSubstringSearchStatus(valueListStatus.status);
        switch (valueListStatus.status) {
            case 2: {
                this.pPoiTarget.myTrace(this, "ValueListStatus==PPOISEARCHSTATUS_RUNNING");
                this.pPoiTarget.notifierModel.notifySearchStateSearching();
                if (this.pPoiTarget.getLastLiValueWindowSize() != 0) {
                    this.requestNextBlock(valueListStatus.getNumberOfAvailableItems());
                    break;
                }
                this.pPoiTarget.myTrace(this, "LiValueWindowSize is 0, will not ask for search results then.");
                break;
            }
            case 3: {
                this.pPoiTarget.myTrace(this, "ValueListStatus==PPOISEARCHSTATUS_FINISHED");
                if (valueListStatus.getNumberOfAvailableItems() == 0 && this.catArrayList.size() == 0) {
                    this.pPoiTarget.notifierModel.notifySearchStateNothingFound();
                    break;
                }
                this.requestNextBlock(valueListStatus.getNumberOfAvailableItems());
                break;
            }
            case 1: {
                this.pPoiTarget.myTrace(this, "ValueListStatus==POISEARCHSTATUS_CANCELED");
                if (valueListStatus.getNumberOfAvailableItems() != 0 || this.catArrayList.size() != 0) break;
                this.pPoiTarget.notifierModel.notifySearchStateNothingFound();
                break;
            }
            default: {
                this.pPoiTarget.myTrace(this, new StringBuffer().append("Unknown status for 'ValueListStatus': ").append(valueListStatus.status).toString());
            }
        }
    }

    private void requestNextBlock(int n) {
        this.pPoiTarget.myTrace(this, new StringBuffer().append("requestNextBlock  newAmountOfAvailableItems:").append(n).append("  requestRunning:").append(this.isRequestRunning()).toString());
        int n2 = Math.max(0, n - this.catArrayList.size());
        this.pPoiTarget.myTrace(this, new StringBuffer().append("countOfRequestableItems:").append(n2).toString());
        this.availableItems = n;
        if (this.getLastSubstringSearchStatus() == 3 && this.catArrayList.size() >= this.availableItems || this.catArrayList.size() >= 200) {
            this.pPoiTarget.notifierModel.notifySearchStateFound();
            this.pPoiTarget.myTrace(this, "Finished POI search");
        }
        if (!this.isRequestRunning() && n2 > 0 && this.catArrayList.size() < 200) {
            this.setIsRequestRunning(true);
            this.pPoiTarget.myTrace(this, new StringBuffer().append("ignoreUpdates:").append(this.ignoreUpdatesAfterPPoiwasSelected).toString());
            if (this.ignoreUpdatesAfterPPoiwasSelected) {
                this.pPoiTarget.myTrace(this, "Updates for category search");
                return;
            }
            this.pPoiTarget.myTrace(this, new StringBuffer().append("CmdRequestValueListByListIndex (").append(this.catArrayList.size()).append(")").toString());
            new CmdRequestValueListByListIndex(this, this.catArrayList.size(), true).execute();
        }
    }

    private void appendValueListToResultList(LIValueList lIValueList) {
        this.pPoiTarget.myTrace(this, "appendValueListToResultList");
        for (int i2 = 0; i2 < lIValueList.list.length; ++i2) {
            if (lIValueList.list[i2] != null) {
                ResourceLocator resourceLocator = HsmCacheHandler.resourceIdForPOIIcon(lIValueList.list[i2].iconIndex, lIValueList.list[i2].subIconIndex, 0, this, new Integer(this.catArrayList.size()));
                this.pPoiTarget.myTrace(this, new StringBuffer().append("IconIndex:").append(lIValueList.list[i2].iconIndex).append(" SubIconIndex:").append(lIValueList.list[i2].subIconIndex).toString());
                int n = PPoiStateCategory.calculateDistance(lIValueList.list[i2]);
                String string = lIValueList.list[i2].getData();
                this.catArrayList.add(new PPoiResultListCollector(resourceLocator, string, n));
                continue;
            }
            this.pPoiTarget.myTrace(this, new StringBuffer().append("LIValueList.list[").append(i2).append("i] = null!").toString());
        }
    }

    public void clearModelData() {
        this.getSearchCatList = new PPoiResultListCollector[0];
        this.catArrayList = new ArrayList();
        this.pPoiTarget.notifierModel.notifyCategoryListItemsUpdateList(PoiStateCategory.getSearchCatList);
    }

    @Override
    public ResourceLocator getDefaultIcon() {
        return null;
    }

    public void setSelectedEntryFromGroupList(int n) {
        this.selectedEntrFromGroupList = n;
    }

    public int getLastSubstringSearchStatus() {
        return this.lastSubstringSearchStatus;
    }

    public void setLastSubstringSearchStatus(int n) {
        this.lastSubstringSearchStatus = n;
    }

    public void setIsRequestRunning(boolean bl) {
        this.requestRunning = bl;
    }

    public boolean isRequestRunning() {
        return this.requestRunning;
    }

    public void setIgnoreUpdatesAfterPPoiwasSelected(boolean bl) {
        this.ignoreUpdatesAfterPPoiwasSelected = bl;
    }

    static {
        IGNORE_FURTHER_GROUP_ELEMENTS = false;
        lastUsedPoiIndex = 0;
    }
}

