/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.setup.threelevel;

import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.poi.setup.threelevel.HsmTargetPoiSetupMapThreeLevelCategories;
import de.vw.mib.asl.internal.navigation.poi.setup.threelevel.category.PoiCategoryTreeElement;
import de.vw.mib.asl.internal.navigation.poi.setup.transformer.PoiSetupMultiLevelPoiListCollector;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.LogMessage;
import java.util.Arrays;

public abstract class StatePoiSetupMapCategoriesBase
extends AbstractHsmState {
    protected PoiCategoryTreeElement expandedCategoryParent;
    private PoiSetupMultiLevelPoiListCollector[] expandedCategoriesOnHmi;
    protected HsmTargetPoiSetupMapThreeLevelCategories target;

    public StatePoiSetupMapCategoriesBase(HsmTargetPoiSetupMapThreeLevelCategories hsmTargetPoiSetupMapThreeLevelCategories, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmTargetPoiSetupMapThreeLevelCategories;
    }

    public void setExpandedCategoryParent(PoiCategoryTreeElement poiCategoryTreeElement) {
        this.expandedCategoryParent = poiCategoryTreeElement;
    }

    protected void clearExpandedCategoryParent() {
        this.expandedCategoryParent = null;
    }

    private boolean hasCategoryExpanded(int n) {
        return this.expandedCategoryParent != null && this.expandedCategoryParent.checkAndGetCategoryIfItIsThis(n) != null;
    }

    @Override
    public abstract HsmState handle(EventGeneric eventGeneric) {
    }

    protected PoiSetupMultiLevelPoiListCollector getExpandedCategoryForIndex(int n) {
        PoiSetupMultiLevelPoiListCollector poiSetupMultiLevelPoiListCollector = null;
        if (this.expandedCategoriesOnHmi != null && n < this.expandedCategoriesOnHmi.length && n >= 0) {
            poiSetupMultiLevelPoiListCollector = this.expandedCategoriesOnHmi[n];
        }
        return poiSetupMultiLevelPoiListCollector;
    }

    protected void setHmiDatapoolLists(GenericASLList genericASLList) {
        if (this.expandedCategoryParent != null) {
            this.expandedCategoriesOnHmi = this.expandedCategoryParent.getPoiCategoryList4Hmi();
            if (this.target.isTraceEnabled()) {
                LogMessage logMessage = this.target.trace();
                logMessage.append("StatePoiSetupWork#setHmiDatapoolLists: \n");
                logMessage.append("Category List: \n");
                for (int i2 = 0; i2 < this.expandedCategoriesOnHmi.length; ++i2) {
                    logMessage.append(this.expandedCategoriesOnHmi[i2].toString());
                    logMessage.append("\n");
                }
                logMessage.log();
            }
            genericASLList.updateList(this.expandedCategoriesOnHmi);
        }
    }

    protected void clearHmiDatapoolList(GenericASLList genericASLList) {
        if (this.expandedCategoryParent != null) {
            this.expandedCategoriesOnHmi = this.expandedCategoryParent.getEmptyPoiCategoryList4Hmi();
            if (this.target.isTraceEnabled()) {
                LogMessage logMessage = this.target.trace();
                logMessage.append("Clear Sub-Categories of ");
                logMessage.append(this.expandedCategoryParent.getElement().catName);
                logMessage.append("\n");
                logMessage.log();
            }
            genericASLList.updateList(this.expandedCategoriesOnHmi);
        }
    }

    protected void updateCategorySelectionsFromEventParameter(EventGeneric eventGeneric) {
        int[] nArray = (int[])eventGeneric.getObject(0);
        Arrays.sort(nArray);
        this.target.updateCategorySelections(nArray);
    }

    protected void toggleSelectionOrState(int n, StatePoiSetupMapCategoriesBase statePoiSetupMapCategoriesBase) {
        PoiSetupMultiLevelPoiListCollector poiSetupMultiLevelPoiListCollector = this.getExpandedCategoryForIndex(n);
        if (poiSetupMultiLevelPoiListCollector != null) {
            if (poiSetupMultiLevelPoiListCollector.isParent) {
                this.toggleState(poiSetupMultiLevelPoiListCollector.uniqueId, statePoiSetupMapCategoriesBase);
            } else {
                this.target.togglePoiCategoryAndUpdateDsi(poiSetupMultiLevelPoiListCollector);
            }
        }
    }

    private void toggleState(int n, StatePoiSetupMapCategoriesBase statePoiSetupMapCategoriesBase) {
        if (statePoiSetupMapCategoriesBase.hasCategoryExpanded(n)) {
            this.switch2ParentStateOf(statePoiSetupMapCategoriesBase);
        } else {
            this.switch2State(n, statePoiSetupMapCategoriesBase);
        }
    }

    private void switch2ParentStateOf(StatePoiSetupMapCategoriesBase statePoiSetupMapCategoriesBase) {
        this.trans(statePoiSetupMapCategoriesBase.getParent());
    }

    private void switch2State(int n, StatePoiSetupMapCategoriesBase statePoiSetupMapCategoriesBase) {
        PoiCategoryTreeElement poiCategoryTreeElement = this.expandedCategoryParent.findCategoryInDirectChildren(n);
        statePoiSetupMapCategoriesBase.setExpandedCategoryParent(poiCategoryTreeElement);
        this.trans(statePoiSetupMapCategoriesBase);
    }
}

