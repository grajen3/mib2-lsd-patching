/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.onboard;

import de.vw.mib.asl.api.navigation.NavigationConfiguration;
import de.vw.mib.asl.internal.navigation.caching.CacheClient;
import de.vw.mib.asl.internal.navigation.caching.HsmCacheHandler;
import de.vw.mib.asl.internal.navigation.caching.IconKey;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdLiGetState;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdPoiSelectSelectionCriteria;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdRequestValueListByListIndex;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSelectListItemPoi;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiAbstractHsmState;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiDatapool;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiHsmTarget;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateCategoryGroup;
import de.vw.mib.asl.internal.navigation.poi.transformer.PoiCatListCollector;
import de.vw.mib.asl.internal.navigation.util.NaviHelper;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import java.util.ArrayList;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.navigation.LISpellerData;
import org.dsi.ifc.navigation.LIValueList;

public final class PoiStateCategory
extends PoiAbstractHsmState
implements CacheClient {
    private PoiHsmTarget myTarget;
    public static PoiCatListCollector[] getSearchCatList;
    public static ArrayList catArrayList;
    public static int listSelection;
    public static LISpellerData spellerState;

    public PoiStateCategory(PoiHsmTarget poiHsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
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
    public void handleCommandCmdPoiSelectSelectionCriteria(CmdPoiSelectSelectionCriteria cmdPoiSelectSelectionCriteria) {
        this.myTarget.myCmdTrace(this, cmdPoiSelectSelectionCriteria);
        if (cmdPoiSelectSelectionCriteria.liResult_ReturnCode != 0L) {
            if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
                this.myTarget.makeTrace(this).append("Error! returnCode=").append(cmdPoiSelectSelectionCriteria.liResult_ReturnCode).log();
            }
            return;
        }
        this.handleLIVALUELIST(cmdPoiSelectSelectionCriteria.liValueList_lispValueList);
    }

    @Override
    public void handleCommandCmdLiGetState(CmdLiGetState cmdLiGetState) {
        this.myTarget.myCmdTrace(this, cmdLiGetState);
        this.handleLIGETSTATERESULT(cmdLiGetState.liGetStateResult_spellerState);
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

    public void clearModelData() {
        getSearchCatList = new PoiCatListCollector[0];
        catArrayList = new ArrayList();
        this.myTarget.notifierModel.notifyCategoryListItemsUpdateList(getSearchCatList);
    }

    private void handleHsmStart() {
        this.clearModelData();
        this.myTarget.setSortOrder(NavigationConfiguration.POI_IS_SORT_ORDER_FOR_CATEGORY_GROUPS_NATURAL);
        new CmdSelectListItemPoi(this, listSelection).execute();
    }

    private void handleLIVALUELIST(LIValueList lIValueList) {
        this.myTarget.myTrace(this, "LIValueList list updated.");
        boolean bl = false;
        if (lIValueList != null && lIValueList.list != null) {
            if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
                this.myTarget.makeTrace(this).append("Length of LIValueList:").append(lIValueList.list.length).log();
            }
            if (lIValueList.list.length > 0) {
                bl = true;
            } else {
                this.myTarget.myError(this, "LIValueList.list.length == 0!");
                NaviHelper.getInstance().resetNaviContext("LIValueList.list.length == 0!");
            }
        } else {
            this.myTarget.myError(this, "LIValueList == null");
            NaviHelper.getInstance().resetNaviContext("LIValueList == null");
        }
        if (bl) {
            this.appendValueListToResultList(lIValueList);
            if (lIValueList != null && lIValueList.isHasNextPage()) {
                this.myTarget.myTrace(this, "CmdRequestValueListByListIndex");
                new CmdRequestValueListByListIndex(this, catArrayList.size(), true).execute();
            } else {
                getSearchCatList = new PoiCatListCollector[catArrayList.size()];
                catArrayList.toArray(getSearchCatList);
                this.myTarget.notifierModel.notifyCategoryListItemsUpdateList(getSearchCatList);
                this.myTarget.notifierModel.notifyCategoryOpenedIndex(listSelection);
                new CmdLiGetState(this).execute();
            }
        }
    }

    private void handlePOIVALUELIST(LIValueList lIValueList) {
        this.myTarget.myTrace(this, "LIValueList list updated with POI options.");
        if (!this.myTarget.selectCriterionInPOIValueList(this, lIValueList, 2) && PoiDatapool.getInstance().getOpenedCategoryGroupUid() == 10) {
            ((PoiStateCategoryGroup)this.myTarget.statePoiCategoryGroup).groupClosed();
            this.myTarget.myTrace(this, "Show popup to indicate that there are no personal POIs available.");
            this.myTarget.notifierModel.notifyNoPpoiInstalledPopup();
        }
    }

    private void handleLIGETSTATERESULT(LISpellerData lISpellerData) {
        this.myTarget.myTrace(this, "liSpellerData updated.");
        spellerState = lISpellerData;
        this.myTarget.notifierModel.notifyNaviPoiDataLoadFinished();
    }

    @Override
    public ResourceLocator getDefaultIcon() {
        return null;
    }

    @Override
    public void handleIconCacheUpdate(IconKey iconKey, ResourceLocator resourceLocator, Object object) {
        int n;
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this).append("handleIconCacheUpdate index:").append((Integer)object).append(" IconID:").append(resourceLocator.getId()).log();
        }
        if ((n = ((Integer)object).intValue()) < catArrayList.size()) {
            ((PoiCatListCollector)PoiStateCategory.catArrayList.get((int)n)).resourceLocator = resourceLocator;
            if (getSearchCatList.length != 0 && n < getSearchCatList.length) {
                PoiStateCategory.getSearchCatList[n].resourceLocator = resourceLocator;
                Object[] objectArray = new PoiCatListCollector[]{getSearchCatList[n]};
                this.myTarget.notifierModel.notifyCategoryListItemsUpdateItems(n, objectArray);
            }
        } else if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeError(this).append("Index out of bounds (index:").append(resourceLocator.getId()).append(" length:").append(getSearchCatList.length).append(")").log();
        }
    }

    private void appendValueListToResultList(LIValueList lIValueList) {
        this.myTarget.myTrace(this, "appendValueListToResultList");
        for (int i2 = 0; i2 < lIValueList.list.length; ++i2) {
            if (lIValueList.list[i2] != null) {
                ResourceLocator resourceLocator = HsmCacheHandler.resourceIdForPOIIcon(lIValueList.list[i2].iconIndex, lIValueList.list[i2].subIconIndex, 0, this, new Integer(catArrayList.size()));
                if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
                    this.myTarget.makeTrace(this).append("IconIndex:").append(lIValueList.list[i2].iconIndex).append(" SubIconIndex:").append(lIValueList.list[i2].subIconIndex).log();
                }
                if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
                    this.myTarget.makeTrace(this).append("Category ").append(i2).append(":").append(lIValueList.list[i2].data).log();
                }
                catArrayList.add(new PoiCatListCollector(resourceLocator, lIValueList.list[i2].getData(), lIValueList.list[i2].getCriteriaNumber(), lIValueList.list[i2].getIconIndex(), true, lIValueList.list[i2].isToRefine()));
                continue;
            }
            if (!this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) continue;
            this.myTarget.makeError(this).append("LIValueList.list[").append(i2).append("i] = null!").log();
        }
    }

    static {
        catArrayList = null;
    }
}

