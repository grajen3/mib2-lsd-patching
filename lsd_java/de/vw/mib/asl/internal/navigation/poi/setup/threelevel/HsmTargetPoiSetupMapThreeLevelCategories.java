/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.setup.threelevel;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.internal.navigation.caching.CacheClient;
import de.vw.mib.asl.internal.navigation.caching.IconKey;
import de.vw.mib.asl.internal.navigation.poi.setup.threelevel.StatePoiSetupMapCategoriesLevel1;
import de.vw.mib.asl.internal.navigation.poi.setup.threelevel.StatePoiSetupMapCategoriesLevel2;
import de.vw.mib.asl.internal.navigation.poi.setup.threelevel.StatePoiSetupMapCategoriesLevel3;
import de.vw.mib.asl.internal.navigation.poi.setup.threelevel.StatePoiSetupMapCategoriesTop;
import de.vw.mib.asl.internal.navigation.poi.setup.threelevel.category.PoiCategories4DsiAndHmi;
import de.vw.mib.asl.internal.navigation.poi.setup.transformer.PoiSetupMultiLevelPoiListCollector;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.global.ResourceLocator;

public final class HsmTargetPoiSetupMapThreeLevelCategories
extends AbstractASLHsmTarget
implements CacheClient {
    private static final int[] ASL_OBSERVER = new int[]{1909002304, 1925779520, 1942556736, -1090387904, -1056833472, 308557056};
    private PoiCategories4DsiAndHmi poiCategories4DsiAndHmi = new PoiCategories4DsiAndHmi(this, this);
    public final StatePoiSetupMapCategoriesTop statePoiSetupTop = new StatePoiSetupMapCategoriesTop(this.poiCategories4DsiAndHmi, this, this.hsm, "statePoiSetupWaiting4Init", this.getWorkStateParent());
    public final StatePoiSetupMapCategoriesLevel1 statePoiSetupLevel1 = new StatePoiSetupMapCategoriesLevel1(this, this.hsm, "statePoiSetupLevel1", this.statePoiSetupTop);
    public final StatePoiSetupMapCategoriesLevel2 statePoiSetupLevel2 = new StatePoiSetupMapCategoriesLevel2(this, this.hsm, "statePoiSetupLevel2", this.statePoiSetupLevel1);
    public final StatePoiSetupMapCategoriesLevel3 statePoiSetupLevel3 = new StatePoiSetupMapCategoriesLevel3(this, this.hsm, "statePoiSetupLevel3", this.statePoiSetupLevel2);

    public HsmTargetPoiSetupMapThreeLevelCategories(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    @Override
    protected HsmState getDefaultState() {
        return this.statePoiSetupTop;
    }

    static void addObserver(AbstractTarget abstractTarget) {
        abstractTarget.addObservers(ASL_OBSERVER);
    }

    static void removeObserver(AbstractTarget abstractTarget) {
        abstractTarget.removeObservers(ASL_OBSERVER);
    }

    public void deleteAllCategorySelectionsAndUpdateDsi() {
        int[] nArray = new int[]{};
        this.updateCategorySelections(nArray);
        this.dsiEhSetCategoryVisibility();
    }

    public void updateCategorySelections(int[] nArray) {
        this.poiCategories4DsiAndHmi.synchronizeCategorySelections(nArray);
    }

    public void togglePoiCategoryAndUpdateDsi(PoiSetupMultiLevelPoiListCollector poiSetupMultiLevelPoiListCollector) {
        this.togglePoiCategory(poiSetupMultiLevelPoiListCollector);
        this.dsiEhSetCategoryVisibility();
    }

    private void togglePoiCategory(PoiSetupMultiLevelPoiListCollector poiSetupMultiLevelPoiListCollector) {
        if (poiSetupMultiLevelPoiListCollector != null) {
            int n = poiSetupMultiLevelPoiListCollector.uniqueId;
            boolean bl = !poiSetupMultiLevelPoiListCollector.selected;
            this.poiCategories4DsiAndHmi.setCategorySelected(n, bl);
        }
    }

    private void dsiEhSetCategoryVisibility() {
        int[] nArray = this.poiCategories4DsiAndHmi.getDsiCategoryUIds();
        boolean[] blArray = this.poiCategories4DsiAndHmi.getDsiCategorySelection();
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainEhSetCategoryVisibility(nArray, blArray);
    }

    public void traceIfEnabled(String string) {
        if (this.isTraceEnabled()) {
            this.trace().append(string).log();
        }
    }

    @Override
    public int getSubClassifier() {
        return 512;
    }

    @Override
    public void handleIconCacheUpdate(IconKey iconKey, ResourceLocator resourceLocator, Object object) {
        int n = (Integer)object;
        this.traceIfEnabled(new StringBuffer().append("POI Icon cache update for uid ").append(n).toString());
        this.poiCategories4DsiAndHmi.updateIcon4CategoryUid(resourceLocator, n);
        this.statePoiSetupTop.updateAllCategoryLevelsDataPools();
    }

    @Override
    public ResourceLocator getDefaultIcon() {
        return null;
    }
}

