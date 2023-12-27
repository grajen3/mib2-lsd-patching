/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.widgets.WidgetList;
import de.vw.mib.widgets.WidgetList$ExpandAnimation;
import de.vw.mib.widgets.models.ListItemModel;

public class WidgetList$CollapseAnimation
extends WidgetList$ExpandAnimation {
    ListItemModel frozenItem;
    private final /* synthetic */ WidgetList this$0;

    protected WidgetList$CollapseAnimation(WidgetList widgetList) {
        this.this$0 = widgetList;
        super(widgetList);
    }

    @Override
    public void start(long l) {
        super.start(l);
        ListItemModel listItemModel = this.this$0.getItem(this.getIndexFirst());
        if (listItemModel.isSubItem() && listItemModel.hasSubSlider()) {
            this.frozenItem = this.this$0.getItem(this.getIndexFirst());
            this.frozenItem.disableTransfer();
        }
    }

    @Override
    protected void calculateItemIndices() {
        this.indexMain = this.this$0.getAbsIndexByListItemDynamicIndex(this.listItem, this.listItem.getRelativeItemIndex(this.listItem.getActivatedIndexPrev()));
        this.indexFirst = this.indexMain + 1;
        this.indexLast = this.indexMain + this.listItem.getSubItemCount();
        this.itemCount = this.indexLast - this.indexFirst + 1;
        this.itemDelta = this.itemCount > 0 ? this.getDeltaValue() / (float)this.itemCount : 0.0f;
    }

    @Override
    public void stop() {
        if (this.frozenItem != null) {
            this.frozenItem.enableTransfer();
            this.frozenItem = null;
        }
        this.listItem.setActivatedIndexPrev(-1);
        super.stop();
    }

    @Override
    protected void notifySubItemState() {
        this.this$0.notifyItemCollapsed();
    }
}

