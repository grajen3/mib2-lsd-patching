/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.categories;

import de.vw.mib.asl.framework.internal.framework.util.LogUtil;
import de.vw.mib.asl.internal.radio.sdars.categories.CategoryHandler$1;
import de.vw.mib.asl.internal.radio.sdars.categories.ChannelFilterCategory;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPool;
import de.vw.mib.asl.internal.radio.sdars.helper.SatConfig;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.log4mib.LogMessage;
import java.util.Iterator;
import java.util.Vector;
import org.dsi.ifc.sdars.CategoryInfo;

public final class CategoryHandler {
    private final SatDb mDb;
    private final IAslPool mPool;
    CategoryInfo[] mArray = new CategoryInfo[0];
    private final IntObjectOptHashMap mFastAccessMap = new IntObjectOptHashMap();
    private final ChannelFilterCategory mFilter;

    public CategoryHandler(SatDb satDb) {
        this.mDb = satDb;
        this.mPool = this.mDb.getPool();
        this.mFilter = new ChannelFilterCategory(this, this.getBestCatecory());
    }

    public void setCategoryList(CategoryInfo[] categoryInfoArray) {
        if (categoryInfoArray == null) {
            if (this.mArray.length > 0) {
                this.mArray = new CategoryInfo[1];
                this.mArray[0] = SatConfig.CATEGORY_ZERO;
            }
        } else {
            this.mArray = new CategoryInfo[categoryInfoArray.length + 1];
            this.mArray[0] = SatConfig.CATEGORY_ZERO;
            System.arraycopy((Object)categoryInfoArray, 0, (Object)this.mArray, 1, categoryInfoArray.length);
        }
        this.recalc();
        this.log();
        this.mPool.setObjectArray(69, this.mArray);
    }

    private void recalc() {
        this.mFastAccessMap.clear();
        for (int i2 = 0; i2 < this.mArray.length; ++i2) {
            if (this.mArray[i2] == null) continue;
            this.mFastAccessMap.put(this.mArray[i2].getCategoryNumber(), this.mArray[i2]);
        }
    }

    public int size() {
        return this.mArray.length;
    }

    public CategoryInfo getCategory(short s) {
        return (CategoryInfo)this.mFastAccessMap.get(s);
    }

    public String getLabel(short s) {
        CategoryInfo categoryInfo = this.getCategory(s);
        String string = categoryInfo == null ? "" : categoryInfo.fullLabel;
        return string;
    }

    public void log() {
        LogMessage logMessage;
        for (int i2 = 0; i2 < this.mArray.length && (logMessage = this.mDb.getLogHandler().getLogMsg()) != null; ++i2) {
            logMessage.append(LogUtil.fixLength(Integer.toString(i2), 3, true));
            logMessage.append(" Category ");
            logMessage.append(LogUtil.fixLength(Integer.toString(this.mArray[i2].categoryNumber), 3, true));
            logMessage.append(": ");
            logMessage.append(this.mArray[i2].fullLabel);
            logMessage.log();
        }
    }

    public CategoryInfo[] getDisplayableCategories() {
        if (SatConfig.mShowEmptyCategories) {
            return this.mArray;
        }
        Vector vector = new Vector(this.mArray.length);
        for (int i2 = 0; i2 < this.mArray.length; ++i2) {
            if (this.mDb.getMainChannelWalker().getChannelCountForCategory(this.mArray[i2].categoryNumber) <= 0) continue;
            vector.add(this.mArray[i2]);
        }
        Object[] objectArray = new CategoryInfo[vector.size()];
        vector.toArray(objectArray);
        return objectArray;
    }

    public int getIndex(short s) {
        for (int i2 = 0; i2 < this.mArray.length; ++i2) {
            if (this.mArray[i2].categoryNumber != s) continue;
            return i2;
        }
        return -1;
    }

    public Iterator iterator() {
        return new CategoryHandler$1(this);
    }

    public short getBestCatecory() {
        int n = -1;
        if (this.mArray != null && this.mArray.length > 0) {
            block5: for (int i2 = 0; i2 < this.mArray.length; ++i2) {
                if (this.mArray[i2] == null) continue;
                switch (this.mArray[i2].categoryNumber) {
                    case -1: {
                        continue block5;
                    }
                    case 10000: {
                        if (n != -1) continue block5;
                        n = this.mArray[i2].categoryNumber;
                        continue block5;
                    }
                    case 10001: {
                        if (n != -1 && n != 10000) continue block5;
                        n = 10001;
                        continue block5;
                    }
                    default: {
                        return this.mArray[i2].categoryNumber;
                    }
                }
            }
        }
        return (short)n;
    }

    public ChannelFilterCategory getCategoryChannelFilter() {
        return this.mFilter;
    }
}

