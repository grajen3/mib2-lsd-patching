/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.setup.threelevel;

import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.poi.setup.threelevel.HsmTargetPoiSetupMapThreeLevelCategories;
import de.vw.mib.asl.internal.navigation.poi.setup.threelevel.StatePoiSetupMapCategoriesBase;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import generated.de.vw.mib.asl.internal.ListManager;

public final class StatePoiSetupMapCategoriesLevel2
extends StatePoiSetupMapCategoriesBase {
    public StatePoiSetupMapCategoriesLevel2(HsmTargetPoiSetupMapThreeLevelCategories hsmTargetPoiSetupMapThreeLevelCategories, Hsm hsm, String string, HsmState hsmState) {
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
                this.target.traceIfEnabled("Enter state StatePoiSetupMapCategoriesLevel2");
                this.updateLevel2CategoriesDataPool();
                break;
            }
            case 4: {
                this.clearLevel2CategoriesDataPool();
                this.clearExpandedCategoryParent();
                break;
            }
            case 1074841970: {
                this.toggleSelectedPoiCategory(eventGeneric);
                break;
            }
            case 3499026: {
                this.target.traceIfEnabled("handle update level 2 category visibility result");
                this.updateCategorySelectionsFromEventParameter(eventGeneric);
                this.updateLevel2CategoriesDataPool();
                break;
            }
            case 1073742527: {
                this.target.traceIfEnabled("clear selection of all categories");
                this.target.deleteAllCategorySelectionsAndUpdateDsi();
                this.updateLevel2CategoriesDataPool();
                break;
            }
            default: {
                hsmState = this.getParent();
            }
        }
        return hsmState;
    }

    public void updateLevel2CategoriesDataPool() {
        GenericASLList genericASLList = ListManager.getGenericASLList(-605024256);
        this.setHmiDatapoolLists(genericASLList);
    }

    public void clearLevel2CategoriesDataPool() {
        GenericASLList genericASLList = ListManager.getGenericASLList(-605024256);
        this.clearHmiDatapoolList(genericASLList);
    }

    private void toggleSelectedPoiCategory(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        this.target.trace("toggle poi category on level 2, index:", n);
        this.toggleSelectionOrState(n, this.target.statePoiSetupLevel3);
    }
}

