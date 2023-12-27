/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.helper;

import de.vw.mib.asl.internal.radio.sdars.categories.ChannelFilterCategory;
import de.vw.mib.asl.internal.radio.sdars.helper.ChannelFilter;
import de.vw.mib.asl.internal.radio.sdars.helper.ComparatorCategoryNumber;
import de.vw.mib.asl.internal.radio.sdars.helper.SatConfig;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import org.dsi.ifc.sdars.CategoryInfo;

public final class CategoryWalker {
    private final SatDb mDb;
    private CategoryInfo[] mArray = null;
    private int mCurrentIndex;
    private ChannelFilterCategory mChannelFilter;
    private static final Comparator COMPARATOR = new ComparatorCategoryNumber();

    public CategoryWalker(SatDb satDb, boolean bl, boolean bl2, boolean bl3, ChannelFilter[] channelFilterArray) {
        this.mDb = satDb;
        this.fill(bl, bl2, bl3, channelFilterArray);
    }

    public void fill(boolean bl, boolean bl2, boolean bl3, ChannelFilter[] channelFilterArray) {
        LinkedList linkedList = new LinkedList();
        if (bl2) {
            linkedList.add(SatConfig.CATEGORY_SIMILAR);
        }
        Iterator iterator = this.mDb.getCategories().iterator();
        while (iterator.hasNext()) {
            CategoryInfo categoryInfo = (CategoryInfo)iterator.next();
            if (!bl3 && (!bl || categoryInfo.categoryNumber != 10000) && this.mDb.getChannels().getChannelCountForCategory(categoryInfo.categoryNumber, channelFilterArray) <= 0) continue;
            if (categoryInfo.equals(SatConfig.CATEGORY_ZERO)) {
                linkedList.addFirst(categoryInfo);
                continue;
            }
            linkedList.add(categoryInfo);
        }
        Collections.sort(linkedList, COMPARATOR);
        this.mArray = new CategoryInfo[linkedList.size()];
        linkedList.toArray(this.mArray);
        this.mCurrentIndex = -1;
    }

    public CategoryInfo[] getArray() {
        return this.mArray;
    }

    public void setCurrentByIndex(int n) {
        if (n >= 0 && n < this.mArray.length) {
            this.mCurrentIndex = n;
        }
    }

    public void setCurrentByNo(short s) {
        for (int i2 = 0; i2 < this.mArray.length; ++i2) {
            if (this.mArray[i2].categoryNumber != s) continue;
            this.mCurrentIndex = i2;
            break;
        }
    }

    public int getCurrentIndex() {
        return this.mCurrentIndex;
    }

    public CategoryInfo getCurrent() {
        if (this.mArray != null && this.mArray.length > 0 && this.mCurrentIndex >= 0 && this.mCurrentIndex < this.mArray.length) {
            return this.mArray[this.mCurrentIndex];
        }
        return null;
    }

    public short getCurrentNo() {
        if (this.mArray != null && this.mArray.length > 0 && this.mCurrentIndex >= 0 && this.mCurrentIndex < this.mArray.length) {
            return this.mArray[this.mCurrentIndex].getCategoryNumber();
        }
        return -1;
    }

    public CategoryInfo getByNo(short s) {
        for (int i2 = 0; i2 < this.mArray.length; ++i2) {
            if (this.mArray[i2].categoryNumber != s) continue;
            return this.mArray[i2];
        }
        return null;
    }

    public CategoryInfo getByIndex(int n) {
        if (n >= 0 && this.mArray != null && n < this.mArray.length) {
            return this.mArray[n];
        }
        return null;
    }

    public boolean inc() {
        int n = this.mCurrentIndex++;
        if (this.mArray != null && this.mArray.length > 0 && this.mCurrentIndex > this.mArray.length) {
            this.mCurrentIndex = 0;
        }
        return n != this.mCurrentIndex;
    }

    public boolean dec() {
        int n = this.mCurrentIndex--;
        if (this.mArray != null && this.mArray.length > 0 && this.mCurrentIndex < 0) {
            this.mCurrentIndex = this.mArray.length - 1;
        }
        return n != this.mCurrentIndex;
    }

    public ChannelFilter getChannelFilter() {
        if (this.mChannelFilter == null) {
            this.mChannelFilter = this.mDb.getCategories().getCategoryChannelFilter();
            this.mChannelFilter.setCategory(this.getCurrentNo());
        }
        return this.mChannelFilter;
    }
}

