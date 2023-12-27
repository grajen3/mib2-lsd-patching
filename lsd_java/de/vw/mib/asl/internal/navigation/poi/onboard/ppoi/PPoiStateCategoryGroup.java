/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.onboard.ppoi;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.internal.navigation.caching.CacheClient;
import de.vw.mib.asl.internal.navigation.caching.IconKey;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdLiGetState;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdPoiSelectSelectionCriteria;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdRequestValueListByListIndex;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSelectListItemPoi;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdStartSpeller;
import de.vw.mib.asl.internal.navigation.personalpoi.transformer.PPoiCatListCollector;
import de.vw.mib.asl.internal.navigation.personalpoi.transformer.PPoiResultListCollector;
import de.vw.mib.asl.internal.navigation.poi.onboard.ppoi.PPoiAbstractHsmState;
import de.vw.mib.asl.internal.navigation.poi.onboard.ppoi.PPoiHsmTarget;
import de.vw.mib.asl.internal.navigation.poi.onboard.ppoi.PPoiStateCategory;
import de.vw.mib.asl.internal.navigation.poi.transformer.PoiCatListCollector;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import java.util.ArrayList;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.navigation.LISpellerData;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

public class PPoiStateCategoryGroup
extends PPoiAbstractHsmState
implements CacheClient {
    private PPoiHsmTarget ppoiTarget;
    private PPoiCatListCollector[] groupList;
    private ArrayList catGroupArrayList = new ArrayList(0);
    private LISpellerData groupState;
    private static final int MAX_NUMBER_OF_ELEMENTS;

    public PPoiStateCategoryGroup(PPoiHsmTarget pPoiHsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(pPoiHsmTarget, hsm, string, hsmState);
        this.ppoiTarget = pPoiHsmTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (this.ppoiTarget.getTextLogger().isTraceEnabled(this.ppoiTarget.getSubClassifier())) {
            this.ppoiTarget.makeTrace(this).append("Received event ID:").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.ppoiTarget.myTrace(this, "HSM_ENTRY");
                break;
            }
            case 3: {
                this.ppoiTarget.myTrace(this, "HSM_START");
                this.handleHsmStart();
                break;
            }
            case 4: {
                this.ppoiTarget.myTrace(this, "HSM_EXIT");
                break;
            }
            case 1074841974: {
                this.selectCategoryGroup(eventGeneric);
                break;
            }
            default: {
                this.ppoiTarget.myTrace(this, new StringBuffer().append("Received event which is not handled in this state (ID=").append(eventGeneric.getReceiverEventId()).append(")").toString());
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private void handleHsmStart() {
        this.ppoiTarget.myTrace(this, "handleHsmStart");
        this.ppoiTarget.setLiValueListWindowSize(this, -1, true);
        this.setPoiContextToDsi();
        this.ppoiTarget.getDsiNavigation().poiSetSortOrder2(0);
        this.ppoiTarget.myTrace(this, "CmdStartSpeller");
        new CmdStartSpeller(this, 0xF800000, false, false, false).execute();
    }

    @Override
    public void handleCommandCmdStartSpeller(CmdStartSpeller cmdStartSpeller) {
        if (cmdStartSpeller.liResult_ReturnCode != 0L) {
            this.ppoiTarget.myError(this, new StringBuffer().append("Error! returnCode=").append(cmdStartSpeller.liResult_ReturnCode).toString());
            return;
        }
        boolean bl = false;
        if (bl = this.isliValuelistEmpty(cmdStartSpeller.liValueList_lispValueList, bl)) {
            this.ppoiTarget.myTrace(this, "CmdLiGetState");
            new CmdLiGetState(this).execute();
        }
    }

    @Override
    public void handleCommandCmdLiGetState(CmdLiGetState cmdLiGetState) {
        this.ppoiTarget.getDsiNavigation().poiSetSortOrder2(1);
        new CmdSelectListItemPoi(this, 0).execute();
    }

    @Override
    public void handleCommandCmdSelectListItemPoi(CmdSelectListItemPoi cmdSelectListItemPoi) {
        this.handlePOIVALUELIST(cmdSelectListItemPoi.liValueList_lispValueList, 2);
    }

    @Override
    public void handleCommandCmdPoiSelectSelectionCriteria(CmdPoiSelectSelectionCriteria cmdPoiSelectSelectionCriteria) {
        this.handleLIVALUELIST(cmdPoiSelectSelectionCriteria.liValueList_lispValueList);
    }

    @Override
    public void handleCommandCmdRequestValueListByListIndex(CmdRequestValueListByListIndex cmdRequestValueListByListIndex) {
        this.ppoiTarget.myTrace(this, cmdRequestValueListByListIndex.toString());
        if (cmdRequestValueListByListIndex.liResult_ReturnCode != 0L) {
            if (this.ppoiTarget.getTextLogger().isTraceEnabled(this.ppoiTarget.getSubClassifier())) {
                this.ppoiTarget.makeError(this).append("Error! returnCode=").append(cmdRequestValueListByListIndex.liResult_ReturnCode).log();
            }
            return;
        }
        this.handleLIVALUELIST(cmdRequestValueListByListIndex.liValueList_lispValueList);
    }

    private void handleLIVALUELIST(LIValueList lIValueList) {
        if (lIValueList != null && lIValueList.list != null) {
            this.ppoiTarget.notifierModel.quitModelWaitstate();
            this.appendValueListToResultList(lIValueList);
            if (lIValueList.isHasNextPage()) {
                this.ppoiTarget.myTrace(this, "CmdRequestValueListByListIndex");
                new CmdRequestValueListByListIndex(this, this.catGroupArrayList.size(), true).execute();
            } else {
                this.groupList = new PPoiCatListCollector[this.catGroupArrayList.size()];
                this.catGroupArrayList.toArray(this.groupList);
                this.ppoiTarget.notifierModel.notifyCategoryGroupListItemsUpdateList(this.groupList);
            }
        }
    }

    @Override
    public void handleIconCacheUpdate(IconKey iconKey, ResourceLocator resourceLocator, Object object) {
        int n = (Integer)object;
        this.ppoiTarget.myTrace(this, new StringBuffer().append("handleIconCacheUpdate index: ").append(n).append(" IconID: ").append(resourceLocator.getId()).toString());
        if (n < this.catGroupArrayList.size()) {
            ((PPoiCatListCollector)this.catGroupArrayList.get((int)n)).resourceLocator = resourceLocator;
            this.groupList[n].resourceLocator = resourceLocator;
            Object[] objectArray = new PPoiCatListCollector[]{this.groupList[n]};
            this.ppoiTarget.notifierModel.notifyResultListItemsUpdateItems(n, objectArray);
        } else {
            this.ppoiTarget.myError(this, new StringBuffer().append("Index out of bounds (index: ").append(n).append(" size: ").append(this.catGroupArrayList.size()).append(")").toString());
        }
    }

    public void clearModelData() {
        this.ppoiTarget.myTrace(this, "clearModelData");
        this.groupList = new PPoiCatListCollector[0];
        this.catGroupArrayList = new ArrayList();
        this.ppoiTarget.notifierModel.notifyCategoryGroupListItemsUpdateList(this.groupList);
        this.ppoiTarget.notifierModel.notifyCategoryListItemsUpdateList(new PoiCatListCollector[0]);
    }

    @Override
    public ResourceLocator getDefaultIcon() {
        return null;
    }

    private void appendValueListToResultList(LIValueList lIValueList) {
        this.ppoiTarget.myTrace(this, "appendValueListToResultList");
        for (int i2 = 0; i2 < lIValueList.list.length && this.catGroupArrayList.size() < 200; ++i2) {
            if (lIValueList.list[i2] != null) {
                LIValueListElement lIValueListElement = lIValueList.list[i2];
                String string = lIValueListElement.data;
                ResourceLocator resourceLocator = ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForPOIIcon(lIValueListElement.iconIndex, lIValueListElement.subIconIndex, 0, this, new Integer(this.catGroupArrayList.size()));
                this.catGroupArrayList.add(new PPoiCatListCollector(resourceLocator, string));
                continue;
            }
            this.catGroupArrayList.add(new PPoiResultListCollector(null, "=null!", 0));
            this.ppoiTarget.myError(this, new StringBuffer().append("LIValueList.list[").append(i2).append("] = null!").toString());
        }
    }

    private void selectCategoryGroup(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        this.ppoiTarget.myTrace(this, new StringBuffer().append("ASL_Navigation_Personal_POI_Category_SELECT_GROUP_ELEMENT with index: ").append(n).toString());
        this.pPoiTarget.statePPoiCategoy.setSelectedEntryFromGroupList(n);
        PPoiStateCategory.SAVED_SPELLER_SATE = null;
        PPoiStateCategory.IGNORE_FURTHER_GROUP_ELEMENTS = false;
        this.pPoiTarget.transAfterCallback(this.ppoiTarget.statePPoiCategoy);
    }
}

