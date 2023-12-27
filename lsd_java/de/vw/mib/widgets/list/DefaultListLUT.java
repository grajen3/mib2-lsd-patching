/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.list;

import de.vw.mib.widgets.list.AbstractListLUT;
import de.vw.mib.widgets.models.ListItemModel;

public final class DefaultListLUT
extends AbstractListLUT {
    private int[] lutItemID;
    private int[] lutItemIndex;
    private int[][] lutItemLayout;

    public DefaultListLUT() {
        this.initLUT();
    }

    @Override
    protected void initLUT() {
        super.initLUT();
        this.lutItemID = this.initLUT(this.itemCount, -1);
        this.lutItemIndex = this.initLUT(this.itemCount, -1);
        this.lutItemLayout = this.initLUT(this.itemCount, this.layoutValueCount, -1);
    }

    @Override
    public void dispose() {
        this.lutItemID = null;
        this.lutItemIndex = null;
        this.lutItemLayout = null;
    }

    @Override
    public int getItemID(int n) {
        if (n >= 0 && n < this.lutItemID.length) {
            return this.lutItemID[n];
        }
        return -1;
    }

    @Override
    public int getItemIndex(int n) {
        ListItemModel listItemModel;
        int n2 = this.getItemID(n);
        if (n2 != -1 && (listItemModel = this.listItems[n2]) != null) {
            return listItemModel.getExistenceItemIndex(this.lutItemIndex[n]);
        }
        return -1;
    }

    @Override
    public int getItemLayoutValue(int n, int n2) {
        if (n >= 0 && n < this.lutItemLayout.length) {
            return this.lutItemLayout[n][n2];
        }
        return -1;
    }

    @Override
    public void setItemLayoutValue(int n, int n2, int n3) {
        if (n >= 0 && n < this.lutItemLayout.length) {
            this.lutItemLayout[n][n2] = n3;
        }
    }

    @Override
    public int getAbsIndexByListItemDynamicIndex(ListItemModel listItemModel, int n) {
        int n2 = -1;
        int n3 = -1;
        if (this.listItems != null && listItemModel != null && n >= 0) {
            int n4;
            for (n4 = 0; n4 < this.listItems.length; ++n4) {
                if (this.listItems[n4].get_targetId() != listItemModel.get_targetId()) continue;
                n3 = n4;
                break;
            }
            for (n4 = 0; n4 < this.itemCount; ++n4) {
                if (this.getItemID(n4) != n3 || this.getItemIndex(n4) != n) continue;
                n2 = n4;
                break;
            }
        }
        return n2;
    }

    @Override
    protected void updateItemLUT() {
        super.updateItemLUT();
        this.layoutable.performLayout();
    }

    @Override
    protected void addItem(int n, int n2, int n3) {
        if (n2 >= 0 && n2 < this.lutItemID.length) {
            this.lutItemID[n2] = n;
            this.lutItemIndex[n2] = n3;
        }
    }

    @Override
    protected int addItemBlock(int n, int n2) {
        ListItemModel listItemModel = this.listItems[n];
        return this.addItemBlock(n, n2, 0, listItemModel.getExistenceItemCount() - 1);
    }

    @Override
    protected int addItemBlock(int n, int n2, int n3, int n4) {
        int n5 = 0;
        if (this.orderInverted) {
            while (n4 - n5 >= n3) {
                this.addItem(n, n2 + n5, n4 - n5);
                ++n5;
            }
        } else {
            while (n3 + n5 <= n4) {
                this.addItem(n, n2 + n5, n3 + n5);
                ++n5;
            }
        }
        return n2 + n5;
    }

    @Override
    protected int getRelativeIndex(int n) {
        return this.lutItemIndex[n];
    }
}

