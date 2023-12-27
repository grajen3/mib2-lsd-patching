/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.categories;

import de.vw.mib.asl.internal.radio.sdars.categories.CategoryHandler;
import de.vw.mib.asl.internal.radio.sdars.helper.ChannelFilter;
import org.dsi.ifc.sdars.StationInfo;

public final class ChannelFilterCategory
implements ChannelFilter {
    private int mCategory = -1;
    private final CategoryHandler mCategoryHandler;

    ChannelFilterCategory(CategoryHandler categoryHandler, int n) {
        this.mCategoryHandler = categoryHandler;
        this.setCategory(n);
    }

    public int getCategory() {
        return this.mCategory;
    }

    public void setCategory(int n) {
        this.mCategory = n;
    }

    @Override
    public boolean checkChannel(StationInfo stationInfo) {
        this.ensureValidCategory();
        boolean bl = false;
        if (stationInfo != null && (this.mCategory == -1 || this.mCategory == stationInfo.categoryNumber)) {
            return true;
        }
        return bl;
    }

    private void ensureValidCategory() {
        if (this.mCategory == -1) {
            this.mCategory = this.mCategoryHandler.getBestCatecory();
        }
    }

    public String toString() {
        return new StringBuffer().append("ChannelCategoryFilter=").append(this.mCategory).toString();
    }
}

