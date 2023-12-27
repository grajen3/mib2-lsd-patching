/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.setup.threelevel.category;

import de.vw.mib.asl.internal.navigation.poi.setup.threelevel.category.PoiCategoryHelper;
import de.vw.mib.asl.internal.navigation.poi.setup.threelevel.category.PoiCategoryTreeElement;
import de.vw.mib.asl.internal.navigation.poi.setup.transformer.PoiSetupMultiLevelPoiListCollector;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.log4mib.LogMessage;
import java.util.ArrayList;

public class PoiCategoryTree {
    private PoiCategoryTreeElement hmiCategoryTreeRoot;
    private PoiCategoryTreeElement[] hmiCategoryTreeElementList;
    private ArrayList childrenTemporarilyWaitingForParent = new ArrayList(0);
    private AbstractTarget target;

    public PoiCategoryTree(AbstractTarget abstractTarget, int n) {
        this.target = abstractTarget;
        this.hmiCategoryTreeRoot = new PoiCategoryTreeElement(PoiCategoryTreeElement.EMPTY_POI_SETUP_CATEGORY);
        this.hmiCategoryTreeElementList = new PoiCategoryTreeElement[n];
    }

    public PoiCategoryTreeElement getRoot() {
        return this.hmiCategoryTreeRoot;
    }

    public void setCategoryForIndex(int n, PoiSetupMultiLevelPoiListCollector poiSetupMultiLevelPoiListCollector) {
        PoiCategoryTreeElement poiCategoryTreeElement = this.createChildWithoutParent(poiSetupMultiLevelPoiListCollector);
        if (this.addAsChildInTree(poiCategoryTreeElement, poiSetupMultiLevelPoiListCollector.parentId)) {
            this.checkAndAddWaitingChildren(poiCategoryTreeElement);
        } else {
            this.addAsWaitingChild(poiCategoryTreeElement);
        }
        this.storeElementInList(n, poiCategoryTreeElement);
    }

    private PoiCategoryTreeElement createChildWithoutParent(PoiSetupMultiLevelPoiListCollector poiSetupMultiLevelPoiListCollector) {
        return new PoiCategoryTreeElement(poiSetupMultiLevelPoiListCollector);
    }

    private boolean addAsChildInTree(PoiCategoryTreeElement poiCategoryTreeElement, int n) {
        boolean bl = false;
        PoiCategoryTreeElement poiCategoryTreeElement2 = this.hmiCategoryTreeRoot.findCategoryHavingId(n);
        if (poiCategoryTreeElement2 != null) {
            bl = poiCategoryTreeElement2.addChild(poiCategoryTreeElement);
        }
        return bl;
    }

    private void addAsWaitingChild(PoiCategoryTreeElement poiCategoryTreeElement) {
        this.childrenTemporarilyWaitingForParent.add(poiCategoryTreeElement);
    }

    private void removeWaitingChild(PoiCategoryTreeElement poiCategoryTreeElement) {
        this.childrenTemporarilyWaitingForParent.remove(poiCategoryTreeElement);
    }

    private void checkAndAddWaitingChildren(PoiCategoryTreeElement poiCategoryTreeElement) {
        PoiCategoryTreeElement poiCategoryTreeElement2 = null;
        do {
            if ((poiCategoryTreeElement2 = this.findFirstChildWaiting4Parent(poiCategoryTreeElement)) == null) continue;
            poiCategoryTreeElement.addChild(poiCategoryTreeElement2);
            this.removeWaitingChild(poiCategoryTreeElement2);
            this.checkAndAddWaitingChildren(poiCategoryTreeElement2);
        } while (poiCategoryTreeElement2 != null);
    }

    private PoiCategoryTreeElement findFirstChildWaiting4Parent(PoiCategoryTreeElement poiCategoryTreeElement) {
        PoiCategoryTreeElement poiCategoryTreeElement2 = null;
        for (int i2 = 0; i2 < this.childrenTemporarilyWaitingForParent.size(); ++i2) {
            PoiCategoryTreeElement poiCategoryTreeElement3 = (PoiCategoryTreeElement)this.childrenTemporarilyWaitingForParent.get(i2);
            if (poiCategoryTreeElement.checkAndGetCategoryIfItIsThis(poiCategoryTreeElement3.getElement().parentId) == null) continue;
            poiCategoryTreeElement2 = poiCategoryTreeElement3;
            break;
        }
        return poiCategoryTreeElement2;
    }

    private void storeElementInList(int n, PoiCategoryTreeElement poiCategoryTreeElement) {
        if (n >= this.hmiCategoryTreeElementList.length) {
            LogMessage logMessage = this.target.warn().append("storeElementInList(): index out of range:").append(n);
            PoiCategoryHelper.logIfEnabled(this.target, logMessage);
        } else {
            this.hmiCategoryTreeElementList[n] = poiCategoryTreeElement;
        }
    }

    public void setCategorySelected(int n, boolean bl) {
        PoiCategoryTreeElement poiCategoryTreeElement = this.hmiCategoryTreeRoot.findCategoryHavingId(n);
        if (poiCategoryTreeElement == null) {
            LogMessage logMessage = this.target.warn().append("setCategorySelected(): category not found, UId:").append(n);
            PoiCategoryHelper.logIfEnabled(this.target, logMessage);
        } else {
            poiCategoryTreeElement.setSelected(bl);
        }
    }

    public void synchronizeCategorySelection(int[] nArray) {
        for (int i2 = 0; i2 < this.hmiCategoryTreeElementList.length; ++i2) {
            PoiCategoryTreeElement poiCategoryTreeElement = this.hmiCategoryTreeElementList[i2];
            if (poiCategoryTreeElement == null) continue;
            poiCategoryTreeElement.checkAndUpdateSelection(nArray);
        }
    }
}

