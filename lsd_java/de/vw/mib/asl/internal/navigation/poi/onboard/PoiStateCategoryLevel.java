/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.onboard;

import de.vw.mib.asl.internal.navigation.poi.onboard.DynamicPoiCategoryHandler;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiAbstractHsmState;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiDatapool;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiHsmTarget;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateCategory;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateCategoryGroup;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateElementSurrounding;
import de.vw.mib.asl.internal.navigation.poi.transformer.PoiCatGroupListCollector;
import de.vw.mib.asl.internal.navigation.poi.transformer.PoiCatListCollector;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class PoiStateCategoryLevel
extends PoiAbstractHsmState {
    private PoiHsmTarget myTarget;

    public PoiStateCategoryLevel(PoiHsmTarget poiHsmTarget, Hsm hsm, String string, HsmState hsmState) {
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
            case 1073742509: {
                this.myTarget.myTrace(this, "ASL_NAVIGATION_POI_SEARCH_CATEGORY_SELECT_GROUP_ELEMENT");
                this.selectCategoryGroup(eventGeneric.getInt(0));
                break;
            }
            case 1073742510: {
                this.myTarget.myTrace(this, "ASL_NAVIGATION_POI_SEARCH_CATEGORY_SELECT_GROUP_ELEMENT_CLOSE");
                this.selectCategoryGroupClose();
                break;
            }
            case 1073742507: {
                this.myTarget.myTrace(this, "ASL_NAVIGATION_POI_INIT_ALL_CATEGORY_LIST");
                this.selectAllGroupItem();
                break;
            }
            case 1073742508: {
                this.myTarget.myTrace(this, "ASL_NAVIGATION_POI_SEARCH_CATEGORY_SELECT_CATEGORY_ELEMENT");
                this.selectCategory(eventGeneric.getInt(0));
                break;
            }
            case 1073744103: {
                this.myTarget.myTrace(this, "ASL_NAVIGATION_POI__SELECT_ALL_GROUP_ELEMENTS");
                PoiDatapool.getInstance().setSelectedCategoryName("");
                PoiDatapool.getInstance().setSelectedCategoryUid(-1);
                break;
            }
            case 1073744105: {
                this.myTarget.myTrace(this, "ASL_NAVIGATION_POI__SELECT_POI_CATEGORY__1");
                this.selectNameOfCategory(eventGeneric.getInt(0));
                break;
            }
            case 1073744104: {
                this.myTarget.myTrace(this, "ASL_NAVIGATION_POI__SELECT_ALL_CATEGORY_ELEMENTS");
                this.selectNameOfCategory(-1);
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

    private void selectCategoryGroup(int n) {
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this).append("Group index:").append(n).append(" selected.").log();
        }
        PoiDatapool.getInstance().setOpenedCategoryGroupUid(((PoiCatGroupListCollector)PoiStateCategoryGroup.catGroupArrayList.get((int)n)).uid);
        PoiStateCategory.listSelection = n;
        this.trans(this.myTarget.statePoiCategory);
    }

    private void selectAllGroupItem() {
        PoiDatapool.getInstance().setSelectedCategoryUid(-1);
        PoiStateElementSurrounding.setListSelectionIndex(-1);
        this.trans(this.myTarget.statePoiElementSurrounding);
    }

    private void selectCategoryGroupClose() {
        ((PoiStateCategoryGroup)this.myTarget.statePoiCategoryGroup).groupClosed();
    }

    private void selectCategory(int n) {
        int n2 = ((PoiCatListCollector)PoiStateCategory.catArrayList.get((int)n)).uid;
        PoiDatapool.getInstance().setSelectedCategoryUid(n2);
        PoiDatapool.getInstance().setLastSelectedTopPoiUid(n2);
        PoiDatapool.getInstance().setFilterCategoryUid(PoiDatapool.getInstance().getLastSelectedTopPoiUid());
        DynamicPoiCategoryHandler.updateByOnboardUid(n2);
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this).append("Category index:").append(n).append(" selected.").log();
            this.myTarget.makeTrace(this).append("Category UID:").append(n2).append(" selected.").log();
        }
        PoiStateElementSurrounding.setListSelectionIndex(n);
        this.trans(this.myTarget.statePoiElementSurrounding);
    }

    private void selectNameOfCategory(int n) {
        int n2;
        String string;
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this).append("Category index:").append(n).append(" selected.").log();
        }
        if (n == -1) {
            string = ((PoiCatGroupListCollector)PoiStateCategoryGroup.catGroupArrayList.get((int)PoiStateCategory.listSelection)).catName;
            n2 = ((PoiCatGroupListCollector)PoiStateCategoryGroup.catGroupArrayList.get((int)PoiStateCategory.listSelection)).uid;
        } else {
            string = ((PoiCatListCollector)PoiStateCategory.catArrayList.get((int)n)).catName;
            n2 = ((PoiCatListCollector)PoiStateCategory.catArrayList.get((int)n)).uid;
        }
        PoiDatapool.getInstance().setSelectedCategoryName(string);
        PoiDatapool.getInstance().setSelectedCategoryUid(n2);
        PoiDatapool.getInstance().setLastSelectedTopPoiUid(n2);
        PoiDatapool.getInstance().setFilterCategoryUid(PoiDatapool.getInstance().getLastSelectedTopPoiUid());
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this).append("Category (UID):").append(string).append(" (").append(n2).append(") selected.").log();
        }
    }
}

