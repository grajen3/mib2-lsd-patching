/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingFacade;
import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.widgets.AbstractWidget$WidgetInternalAnimation;
import de.vw.mib.widgets.WidgetList;
import de.vw.mib.widgets.models.ListItemModel;

class WidgetList$ExpandAnimation
extends AbstractWidget$WidgetInternalAnimation {
    ListItemModel listItem;
    int indexMain;
    int indexFirst;
    int indexLast;
    int offsetMain;
    float offsetSub;
    float spreading;
    float alpha;
    int itemCount;
    float itemDelta;
    EasingParams easingSub;
    EasingParams easingAlpha;
    private final /* synthetic */ WidgetList this$0;

    public WidgetList$ExpandAnimation(WidgetList widgetList) {
        this.this$0 = widgetList;
        super(widgetList, new EasingParams());
    }

    public void setAnimationParams(ListItemModel listItemModel, EasingParams easingParams, EasingParams easingParams2, EasingParams easingParams3) {
        this.listItem = listItemModel;
        this.alpha = 0.0f;
        this.calculateItemIndices();
        this.setEasingParams(easingParams);
        this.easingSub = this.itemCount > 1 ? easingParams : easingParams2;
        this.easingAlpha = easingParams3;
    }

    @Override
    public void animate(float f2, long l, long l2) {
        this.calculateItemIndices();
        this.offsetMain = Math.round(f2);
        this.offsetSub = EasingFacade.calculate(l - this.getStartTime() - (long)this.easingSub.getStartDelay(), this.getStartValue(), this.getDeltaValue(), this.easingSub);
        this.spreading = EasingFacade.calculate(l - this.getStartTime() - (long)this.getEasingParams().getStartDelay(), 0.0f, 1.0f, this.getEasingParams());
        this.alpha = EasingFacade.calculate(l - this.getStartTime() - (long)this.easingAlpha.getStartDelay(), 0.0f, 1.0f, this.easingAlpha);
        this.this$0.invalidateList(17408);
        this.this$0.disableAnimations();
        this.this$0.updateCursor();
        this.this$0.enableAnimations();
        this.this$0.repaint();
    }

    protected void calculateItemIndices() {
        this.indexMain = this.this$0.getAbsIndexByListItemDynamicIndex(this.listItem, this.listItem.getRelativeItemIndex(this.listItem.get_activatedIndex()));
        this.indexFirst = this.indexMain + 1;
        this.indexLast = this.indexMain + this.listItem.getSubItemCount();
        this.itemCount = this.indexLast - this.indexFirst + 1;
        this.itemDelta = this.itemCount > 0 ? this.getDeltaValue() / (float)this.itemCount : 0.0f;
    }

    public int getIndexMain() {
        return this.indexMain;
    }

    public int getIndexFirst() {
        return this.indexFirst;
    }

    public int getIndexLast() {
        return this.indexLast;
    }

    public int getOffsetMain() {
        return this.offsetMain;
    }

    public int getOffsetSub(int n, boolean bl) {
        float f2 = this.offsetSub;
        if (this.itemCount > 1) {
            f2 = bl ? (f2 += (1.0f - this.spreading) * (float)(this.indexLast - n) * this.itemDelta) : (f2 -= this.spreading * (float)(this.indexLast - n) * this.itemDelta);
        }
        return Math.round(f2);
    }

    public float getAlpha() {
        return this.alpha;
    }

    @Override
    public void start(long l) {
        super.start(l);
        this.this$0.freeze();
    }

    @Override
    public void stop() {
        super.stop();
        this.this$0.disableSubItemLimitation(this.listItem);
        this.this$0.validateListImmediately(8402);
        this.this$0.unfreeze();
        this.notifySubItemState();
    }

    protected void notifySubItemState() {
        this.this$0.notifyItemExpanded();
    }
}

