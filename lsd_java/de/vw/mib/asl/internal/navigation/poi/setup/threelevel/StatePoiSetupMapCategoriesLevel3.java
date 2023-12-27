/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.setup.threelevel;

import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.poi.setup.threelevel.HsmTargetPoiSetupMapThreeLevelCategories;
import de.vw.mib.asl.internal.navigation.poi.setup.threelevel.StatePoiSetupMapCategoriesBase;
import de.vw.mib.asl.internal.navigation.poi.setup.transformer.PoiSetupMultiLevelPoiListCollector;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import generated.de.vw.mib.asl.internal.ListManager;

public final class StatePoiSetupMapCategoriesLevel3
extends StatePoiSetupMapCategoriesBase {
    public StatePoiSetupMapCategoriesLevel3(HsmTargetPoiSetupMapThreeLevelCategories hsmTargetPoiSetupMapThreeLevelCategories, Hsm hsm, String string, HsmState hsmState) {
        super(hsmTargetPoiSetupMapThreeLevelCategories, hsm, string, hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                break;
            }
            case 3: {
                this.target.traceIfEnabled("Enter state StatePoiSetupMapCategoriesLevel3");
                this.updateLevel3CategoriesDataPool();
                break;
            }
            case 4: {
                this.clearLevel3CategoriesDataPool();
                this.clearExpandedCategoryParent();
                break;
            }
            case 1074841971: {
                this.toggleSelectedPoiCategory(eventGeneric);
                break;
            }
            case 3499026: {
                this.target.traceIfEnabled("handle update level 3 category visibility result");
                this.updateCategorySelectionsFromEventParameter(eventGeneric);
                this.updateLevel3CategoriesDataPool();
                break;
            }
            case 1073742527: {
                this.target.traceIfEnabled("clear selection of all categories");
                this.target.deleteAllCategorySelectionsAndUpdateDsi();
                this.updateLevel3CategoriesDataPool();
                break;
            }
            default: {
                hsmState = this.getParent();
            }
        }
        return hsmState;
    }

    public void updateLevel3CategoriesDataPool() {
        GenericASLList genericASLList = ListManager.getGenericASLList(-588247040);
        this.setHmiDatapoolLists(genericASLList);
    }

    public void clearLevel3CategoriesDataPool() {
        GenericASLList genericASLList = ListManager.getGenericASLList(-588247040);
        this.clearHmiDatapoolList(genericASLList);
    }

    private void toggleSelectedPoiCategory(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        PoiSetupMultiLevelPoiListCollector poiSetupMultiLevelPoiListCollector = this.getExpandedCategoryForIndex(n);
        this.target.trace("toggle poi category on level 3, index:", n);
        this.target.togglePoiCategoryAndUpdateDsi(poiSetupMultiLevelPoiListCollector);
    }
}

