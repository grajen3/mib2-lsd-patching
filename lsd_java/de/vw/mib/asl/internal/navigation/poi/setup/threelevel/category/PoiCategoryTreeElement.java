/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.setup.threelevel.category;

import de.vw.mib.asl.internal.navigation.poi.setup.threelevel.category.PoiCategoryHelper;
import de.vw.mib.asl.internal.navigation.poi.setup.transformer.PoiSetupMultiLevelPoiListCollector;
import java.util.ArrayList;
import java.util.Iterator;
import org.dsi.ifc.global.ResourceLocator;

public class PoiCategoryTreeElement {
    private PoiSetupMultiLevelPoiListCollector categoryElement = null;
    private ArrayList childCategories = new ArrayList(0);
    public static final PoiSetupMultiLevelPoiListCollector EMPTY_POI_SETUP_CATEGORY = new PoiSetupMultiLevelPoiListCollector(false, null, "", 0, false, 0);

    public PoiCategoryTreeElement(PoiSetupMultiLevelPoiListCollector poiSetupMultiLevelPoiListCollector) {
        this.categoryElement = poiSetupMultiLevelPoiListCollector;
    }

    public PoiSetupMultiLevelPoiListCollector getElement() {
        return this.categoryElement;
    }

    public boolean addChild(PoiCategoryTreeElement poiCategoryTreeElement) {
        return this.childCategories.add(poiCategoryTreeElement);
    }

    public PoiSetupMultiLevelPoiListCollector[] getPoiCategoryList4Hmi() {
        PoiSetupMultiLevelPoiListCollector[] poiSetupMultiLevelPoiListCollectorArray = new PoiSetupMultiLevelPoiListCollector[this.childCategories.size()];
        for (int i2 = 0; i2 < this.childCategories.size(); ++i2) {
            poiSetupMultiLevelPoiListCollectorArray[i2] = ((PoiCategoryTreeElement)this.childCategories.get((int)i2)).categoryElement;
        }
        return poiSetupMultiLevelPoiListCollectorArray;
    }

    public PoiSetupMultiLevelPoiListCollector[] getEmptyPoiCategoryList4Hmi() {
        return new PoiSetupMultiLevelPoiListCollector[0];
    }

    public PoiCategoryTreeElement findCategoryHavingId(int n) {
        PoiCategoryTreeElement poiCategoryTreeElement = this.checkAndGetCategoryIfItIsThis(n);
        if (poiCategoryTreeElement == null) {
            poiCategoryTreeElement = this.findCategoryInChildrenRecursively(n);
        }
        return poiCategoryTreeElement;
    }

    public PoiCategoryTreeElement checkAndGetCategoryIfItIsThis(int n) {
        PoiCategoryTreeElement poiCategoryTreeElement = null;
        if (this.categoryElement.uniqueId == n) {
            poiCategoryTreeElement = this;
        } else if (n == 0 && this.categoryElement.uniqueId == PoiCategoryTreeElement.EMPTY_POI_SETUP_CATEGORY.uniqueId) {
            poiCategoryTreeElement = this;
        }
        return poiCategoryTreeElement;
    }

    private PoiCategoryTreeElement findCategoryInChildrenRecursively(int n) {
        PoiCategoryTreeElement poiCategoryTreeElement = null;
        Iterator iterator = this.childCategories.iterator();
        while (poiCategoryTreeElement == null && iterator.hasNext()) {
            PoiCategoryTreeElement poiCategoryTreeElement2 = (PoiCategoryTreeElement)iterator.next();
            if (poiCategoryTreeElement2 == null) continue;
            poiCategoryTreeElement = poiCategoryTreeElement2.findCategoryHavingId(n);
        }
        return poiCategoryTreeElement;
    }

    public PoiCategoryTreeElement findCategoryInDirectChildren(int n) {
        PoiCategoryTreeElement poiCategoryTreeElement = null;
        Iterator iterator = this.childCategories.iterator();
        while (poiCategoryTreeElement == null && iterator.hasNext()) {
            PoiCategoryTreeElement poiCategoryTreeElement2 = (PoiCategoryTreeElement)iterator.next();
            if (poiCategoryTreeElement2 == null) continue;
            poiCategoryTreeElement = poiCategoryTreeElement2.checkAndGetCategoryIfItIsThis(n);
        }
        return poiCategoryTreeElement;
    }

    public void checkAndUpdateSelection(int[] nArray) {
        boolean bl = PoiCategoryHelper.isCategorySelected(nArray, this.categoryElement.uniqueId);
        this.setSelected(bl);
    }

    public void setSelected(boolean bl) {
        this.categoryElement.selected = bl;
    }

    public void updateIcon(ResourceLocator resourceLocator) {
        this.categoryElement.icon = resourceLocator;
    }
}

