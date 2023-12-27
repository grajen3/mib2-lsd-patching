/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.list;

import de.vw.mib.collections.ints.IntIntOptHashMap;
import de.vw.mib.widgets.list.AbstractListLUT;
import de.vw.mib.widgets.list.OptimizedListLUT$ItemBlock;
import de.vw.mib.widgets.models.ListItemModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class OptimizedListLUT
extends AbstractListLUT {
    private static final int LAYOUT_CACHE_SIZE;
    private List itemBlocks;
    private int layoutIndexFirst;
    private int layoutIndexLast;
    private IntIntOptHashMap[] layoutCache;

    @Override
    protected void initLUT() {
        super.initLUT();
        boolean bl = true;
        this.itemBlocks = new ArrayList(1);
        this.layoutCache = new IntIntOptHashMap[this.layoutValueCount];
        for (int i2 = 0; i2 < this.layoutValueCount; ++i2) {
            this.layoutCache[i2] = new IntIntOptHashMap();
        }
    }

    @Override
    public void dispose() {
        this.itemBlocks = null;
    }

    @Override
    public int getItemID(int n) {
        int n2 = -1;
        OptimizedListLUT$ItemBlock optimizedListLUT$ItemBlock = this.findItemBlockByIndex(n);
        if (optimizedListLUT$ItemBlock != null) {
            n2 = optimizedListLUT$ItemBlock.itemID;
        }
        return n2;
    }

    @Override
    public int getItemIndex(int n) {
        int n2 = -1;
        OptimizedListLUT$ItemBlock optimizedListLUT$ItemBlock = this.findItemBlockByIndex(n);
        if (optimizedListLUT$ItemBlock != null && this.listItems != null) {
            int n3 = this.getRelativeIndex(n);
            ListItemModel listItemModel = this.listItems[optimizedListLUT$ItemBlock.itemID];
            n2 = listItemModel.getExistenceItemIndex(n3);
        }
        return n2;
    }

    @Override
    public int getItemLayoutValue(int n, int n2) {
        if (n >= 0 && n < this.itemCount && !this.layoutCache[n2].containsKey(n)) {
            OptimizedListLUT$ItemBlock optimizedListLUT$ItemBlock = this.findItemBlockByIndex(n);
            if (this.layoutCache[n2].size() > 20) {
                this.clearLayoutCache();
            }
            this.layoutCache[n2].put(n, optimizedListLUT$ItemBlock.layoutValueStart[n2] + optimizedListLUT$ItemBlock.layoutValueGap[n2] * (n - optimizedListLUT$ItemBlock.absIndexFirst));
        }
        return this.layoutCache[n2].get(n);
    }

    @Override
    public void setItemLayoutValue(int n, int n2, int n3) {
        if (n >= 0 && n < this.itemCount) {
            OptimizedListLUT$ItemBlock optimizedListLUT$ItemBlock = this.findItemBlockByIndex(n);
            if (n == optimizedListLUT$ItemBlock.absIndexFirst) {
                optimizedListLUT$ItemBlock.layoutValueStart[n2] = n3;
            } else {
                optimizedListLUT$ItemBlock.layoutValueGap[n2] = n3 - optimizedListLUT$ItemBlock.layoutValueStart[n2];
            }
        }
    }

    @Override
    public int getLayoutIndexFirst() {
        return this.layoutIndexFirst;
    }

    @Override
    public int getLayoutIndexLast() {
        return this.layoutIndexLast;
    }

    @Override
    public int getAbsIndexByListItemDynamicIndex(ListItemModel listItemModel, int n) {
        int n2 = -1;
        int n3 = -1;
        int n4 = this.itemBlocks.size();
        OptimizedListLUT$ItemBlock optimizedListLUT$ItemBlock = null;
        if (this.listItems != null && listItemModel != null && n >= 0) {
            int n5;
            for (n5 = 0; n5 < this.listItems.length; ++n5) {
                if (this.listItems[n5].get_targetId() != listItemModel.get_targetId()) continue;
                n3 = n5;
                break;
            }
            for (n5 = 0; n5 < n4; ++n5) {
                optimizedListLUT$ItemBlock = (OptimizedListLUT$ItemBlock)this.itemBlocks.get(n5);
                if (n3 != optimizedListLUT$ItemBlock.itemID || optimizedListLUT$ItemBlock.absIndexFirst + n - optimizedListLUT$ItemBlock.relIndexFirst > optimizedListLUT$ItemBlock.absIndexLast) continue;
                n2 = optimizedListLUT$ItemBlock.absIndexFirst + (n - optimizedListLUT$ItemBlock.relIndexFirst);
                break;
            }
        }
        return n2;
    }

    @Override
    protected void updateItemLUT() {
        this.itemBlocks.clear();
        super.updateItemLUT();
        if (this.layoutable != null) {
            Iterator iterator = this.itemBlocks.iterator();
            while (iterator.hasNext()) {
                OptimizedListLUT$ItemBlock optimizedListLUT$ItemBlock = (OptimizedListLUT$ItemBlock)iterator.next();
                this.layoutIndexFirst = optimizedListLUT$ItemBlock.absIndexFirst;
                this.layoutIndexLast = optimizedListLUT$ItemBlock.absIndexFirst < optimizedListLUT$ItemBlock.absIndexLast ? optimizedListLUT$ItemBlock.absIndexFirst + 1 : optimizedListLUT$ItemBlock.absIndexLast;
                this.layoutable.performLayout();
            }
        }
        this.clearLayoutCache();
    }

    @Override
    protected void addItem(int n, int n2, int n3) {
        this.itemBlocks.add(new OptimizedListLUT$ItemBlock(n, n2, n2 + 1, n3, this.layoutValueCount));
    }

    @Override
    protected int addItemBlock(int n, int n2) {
        ListItemModel listItemModel = this.listItems[n];
        int n3 = n2 + listItemModel.getExistenceItemCount() - 1;
        this.itemBlocks.add(new OptimizedListLUT$ItemBlock(n, n2, n3, 0, this.layoutValueCount));
        return n3 + 1;
    }

    @Override
    protected int addItemBlock(int n, int n2, int n3, int n4) {
        int n5 = n2 + n4 - n3;
        this.itemBlocks.add(new OptimizedListLUT$ItemBlock(n, n2, n5, n3, this.layoutValueCount));
        return n2 + n4 - n3 + 1;
    }

    private OptimizedListLUT$ItemBlock findItemBlockByIndex(int n) {
        int n2 = this.itemBlocks.size();
        OptimizedListLUT$ItemBlock optimizedListLUT$ItemBlock = null;
        for (int i2 = 0; i2 < n2; ++i2) {
            OptimizedListLUT$ItemBlock optimizedListLUT$ItemBlock2 = (OptimizedListLUT$ItemBlock)this.itemBlocks.get(i2);
            if (n < optimizedListLUT$ItemBlock2.absIndexFirst || n > optimizedListLUT$ItemBlock2.absIndexLast) continue;
            optimizedListLUT$ItemBlock = optimizedListLUT$ItemBlock2;
            break;
        }
        return optimizedListLUT$ItemBlock;
    }

    private void clearLayoutCache() {
        for (int i2 = 0; i2 < this.layoutCache.length; ++i2) {
            this.layoutCache[i2].clear();
        }
    }

    @Override
    protected int getRelativeIndex(int n) {
        int n2 = -1;
        OptimizedListLUT$ItemBlock optimizedListLUT$ItemBlock = this.findItemBlockByIndex(n);
        if (optimizedListLUT$ItemBlock != null && this.listItems != null) {
            n2 = optimizedListLUT$ItemBlock.relIndexFirst + (this.orderInverted ? optimizedListLUT$ItemBlock.absIndexLast - n : n - optimizedListLUT$ItemBlock.absIndexFirst);
        }
        return n2;
    }
}

