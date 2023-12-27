/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.setup.threelevel.category;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.internal.navigation.caching.CacheClient;
import de.vw.mib.asl.internal.navigation.poi.setup.threelevel.category.PoiCategoryHelper;
import de.vw.mib.asl.internal.navigation.poi.setup.threelevel.category.PoiCategoryList;
import de.vw.mib.asl.internal.navigation.poi.setup.threelevel.category.PoiCategoryTree;
import de.vw.mib.asl.internal.navigation.poi.setup.threelevel.category.PoiCategoryTreeElement;
import de.vw.mib.asl.internal.navigation.poi.setup.transformer.PoiSetupMultiLevelPoiListCollector;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.log4mib.LogMessage;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.navigation.Category;

public class PoiCategories4DsiAndHmi {
    private PoiCategoryTree hmiCategoryTree;
    private PoiCategoryList dsiCategoryList;
    CacheClient cacheClient4Icons;
    AbstractTarget target;

    public PoiCategories4DsiAndHmi(AbstractTarget abstractTarget, CacheClient cacheClient) {
        this.target = abstractTarget;
        this.cacheClient4Icons = cacheClient;
        this.createHmiCategoryTree(0);
        this.createDsiCategoryList(0);
    }

    public void setCategories(Category[] categoryArray) {
        if (categoryArray == null) {
            LogMessage logMessage = this.target.warn().append("Received invalid poi categories array!");
            PoiCategoryHelper.logIfEnabled(this.target, logMessage);
        } else {
            this.createHmiCategoryTree(categoryArray.length);
            this.createDsiCategoryList(categoryArray.length);
            this.fillCategories(categoryArray);
        }
    }

    private void createHmiCategoryTree(int n) {
        this.hmiCategoryTree = new PoiCategoryTree(this.target, n);
    }

    private void createDsiCategoryList(int n) {
        this.dsiCategoryList = new PoiCategoryList(n);
    }

    private void fillCategories(Category[] categoryArray) {
        for (int i2 = 0; i2 < categoryArray.length; ++i2) {
            Category category = categoryArray[i2];
            PoiSetupMultiLevelPoiListCollector poiSetupMultiLevelPoiListCollector = this.createPoiSetupPoiListCollector4DsiResponse(category);
            this.hmiCategoryTree.setCategoryForIndex(i2, poiSetupMultiLevelPoiListCollector);
            this.dsiCategoryList.setCategoryForIndex(i2, category.categoryUid, poiSetupMultiLevelPoiListCollector.selected, !poiSetupMultiLevelPoiListCollector.isParent);
        }
    }

    private PoiSetupMultiLevelPoiListCollector createPoiSetupPoiListCollector4DsiResponse(Category category) {
        ResourceLocator resourceLocator = ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForPOIIcon(category.iconIndex, category.subIconIndex, 0, this.cacheClient4Icons, new Integer(category.categoryUid));
        boolean bl = this.isCategoryVisible(category);
        boolean bl2 = this.isParentCategory(category);
        int n = this.getParentId(category);
        if (resourceLocator == null) {
            LogMessage logMessage = this.target.trace().append(new StringBuffer().append("POI Icon ResourceLocator=null for category=").append(category.description).toString());
            PoiCategoryHelper.logIfEnabled(this.target, logMessage);
        }
        return new PoiSetupMultiLevelPoiListCollector(bl, resourceLocator, category.getDescription(), category.getCategoryUid(), bl2, n);
    }

    private boolean isCategoryVisible(Category category) {
        return category.isVisible();
    }

    private boolean isParentCategory(Category category) {
        return category.isParent();
    }

    private int getParentId(Category category) {
        return category.getParentId();
    }

    public PoiCategoryTreeElement getCategoryTreeRoot() {
        return this.hmiCategoryTree.getRoot();
    }

    public void setCategorySelected(int n, boolean bl) {
        this.dsiCategoryList.setCategorySelected(n, bl);
        this.hmiCategoryTree.setCategorySelected(n, bl);
    }

    public void synchronizeCategorySelections(int[] nArray) {
        this.dsiCategoryList.synchronizeCategorySelections(nArray);
        this.hmiCategoryTree.synchronizeCategorySelection(nArray);
    }

    public int[] getDsiCategoryUIds() {
        return this.dsiCategoryList.getUIds();
    }

    public boolean[] getDsiCategorySelection() {
        return this.dsiCategoryList.getCategorySelection();
    }

    public void updateIcon4CategoryUid(ResourceLocator resourceLocator, int n) {
        PoiCategoryTreeElement poiCategoryTreeElement = this.getCategoryTreeRoot().findCategoryHavingId(n);
        if (poiCategoryTreeElement != null) {
            this.updateIcon4Category(poiCategoryTreeElement, resourceLocator);
            poiCategoryTreeElement = poiCategoryTreeElement.findCategoryInDirectChildren(n);
            if (poiCategoryTreeElement != null) {
                this.updateIcon4Category(poiCategoryTreeElement, resourceLocator);
            }
        }
    }

    private void updateIcon4Category(PoiCategoryTreeElement poiCategoryTreeElement, ResourceLocator resourceLocator) {
        if (poiCategoryTreeElement != null) {
            poiCategoryTreeElement.updateIcon(resourceLocator);
        }
    }
}

