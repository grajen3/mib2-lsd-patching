/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.setup.threelevel.category;

import de.vw.mib.asl.internal.navigation.poi.setup.threelevel.category.PoiCategoryHelper;

public class PoiCategoryList {
    private int[] dsiCategoryUids = new int[0];
    private boolean[] dsiCategoriesSelected = new boolean[0];
    private boolean[] dsiCategoriesSelectableMask = new boolean[0];

    public PoiCategoryList(int n) {
        this.dsiCategoryUids = new int[n];
        this.dsiCategoriesSelected = new boolean[n];
        this.dsiCategoriesSelectableMask = new boolean[n];
    }

    public void setCategoryForIndex(int n, int n2, boolean bl, boolean bl2) {
        this.dsiCategoryUids[n] = n2;
        this.dsiCategoriesSelected[n] = bl;
        this.dsiCategoriesSelectableMask[n] = bl2;
    }

    public void setCategorySelected(int n, boolean bl) {
        int n2 = this.getSelectableCategoryIndexByUId(n);
        if (n2 >= 0) {
            this.dsiCategoriesSelected[n2] = bl;
        }
    }

    private int getSelectableCategoryIndexByUId(int n) {
        int n2 = -1;
        for (int i2 = 0; i2 < this.dsiCategoryUids.length; ++i2) {
            if (this.dsiCategoryUids[i2] != n || !this.dsiCategoriesSelectableMask[i2]) continue;
            n2 = i2;
            break;
        }
        return n2;
    }

    public void synchronizeCategorySelections(int[] nArray) {
        for (int i2 = 0; i2 < this.dsiCategoryUids.length; ++i2) {
            this.dsiCategoriesSelected[i2] = PoiCategoryHelper.isCategorySelected(nArray, this.dsiCategoryUids[i2]);
        }
    }

    public int[] getUIds() {
        return this.dsiCategoryUids;
    }

    public boolean[] getCategorySelection() {
        return this.dsiCategoriesSelected;
    }
}

