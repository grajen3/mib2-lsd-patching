/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.collections.copyonwrite.CowList;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.Point;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.font.Font;
import de.vw.mib.graphics.font.FontAttribs;
import de.vw.mib.graphics.font.layout.TextLayout;
import de.vw.mib.graphics.font.style.TextStyle;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.util.StringUtil;
import de.vw.mib.widgets.AbstractText;
import de.vw.mib.widgets.ScrollableText$ScrollingAnimation;
import de.vw.mib.widgets.event.AdjustmentListener;
import de.vw.mib.widgets.interfaces.Adjustable;
import de.vw.mib.widgets.interfaces.Draggable$DragDataStorage;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.models.ScrollableTextModel;
import de.vw.mib.widgets.models.ScrollableTextModel$Tab;
import de.vw.mib.widgets.models.ScrollableTextModel$TabbedRow;
import de.vw.mib.widgets.models.ScrollableTextModel$TabbedTextLayout;
import de.vw.mib.widgets.models.ViewModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ScrollableText
extends AbstractText
implements ScrollableTextModel {
    private static final String TAB_TAG;
    private int firstLineIndex;
    private int[] tabPositions;
    private int viewPortPosition;
    private int pageSize;
    protected ScrollableText$ScrollingAnimation scrollingAnimation;
    private CowList adjustmentListeners;
    private int adjustmentShadowCounter;
    private Draggable$DragDataStorage dragDataStorage;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$ScrollableTextUI;

    @Override
    protected void reset() {
        super.reset();
        this.adjustmentListeners = CowList.EMPTY;
        this.dragDataStorage = new Draggable$DragDataStorage();
        this.tabPositions = null;
    }

    public void init(boolean bl, int n, int n2, boolean bl2, int n3, int n4, int n5, Color color, Color color2, Color color3, Color[] colorArray, Color[] colorArray2, Color color4, EasingParams[] easingParamsArray, boolean bl3, int n6, FontAttribs fontAttribs, int[] nArray, Color color5, int n7, boolean bl4, int n8, boolean bl5, int n9, String string, Insets insets, int[] nArray2, int n10, String string2, boolean bl6, Insets insets2, boolean bl7, int n11, int n12, int n13, int n14) {
        super.init(bl, n, n2, bl2, n3, n4, n5, color, color2, color3, colorArray, colorArray2, color4, easingParamsArray, bl3, fontAttribs, nArray, color5, n7, bl4, n8, bl5, n9, string, insets, n10, string2, bl6, insets2, bl7, n11, n12, n13, n14);
        this.firstLineIndex = n6;
        this.tabPositions = nArray2;
    }

    public void init(boolean bl, int n, int n2, boolean bl2, int n3, int n4, int n5, Color color, Color color2, Color color3, Color[] colorArray, Color[] colorArray2, Color color4, EasingParams[] easingParamsArray, boolean bl3, int n6, FontAttribs fontAttribs, int[] nArray, Color color5, int n7, boolean bl4, int n8, boolean bl5, int n9, String string, Insets insets, int[] nArray2, int n10, String string2, Color[] colorArray3, boolean bl6, Insets insets2, boolean bl7, int n11, int n12, int n13, int n14) {
        this.init(bl, n, n2, bl2, n3, n4, n5, color, color2, color3, colorArray, colorArray2, color4, easingParamsArray, bl3, n6, fontAttribs, nArray, color5, n7, bl4, n8, bl5, n9, string, insets, nArray2, n10, string2, bl6, insets2, bl7, n11, n12, n13, n14);
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
        if (this.is_visible() && this.areParentsVisible()) {
            this.updateTextlayout();
        }
    }

    @Override
    public void deInit() {
        this.adjustmentListeners = CowList.EMPTY;
        this.adjustmentShadowCounter = 0;
        this.viewPortPosition = 0;
        this.pageSize = 0;
        super.deInit();
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return new Class[]{class$de$vw$mib$widgets$ui$ScrollableTextUI == null ? (class$de$vw$mib$widgets$ui$ScrollableTextUI = ScrollableText.class$("de.vw.mib.widgets.ui.ScrollableTextUI")) : class$de$vw$mib$widgets$ui$ScrollableTextUI};
    }

    @Override
    public int get_firstLineIndex() {
        return this.firstLineIndex;
    }

    @Override
    public void set_firstLineIndex(int n) {
        int n2 = this.firstLineIndex;
        if (n2 != n) {
            this.firstLineIndex = n;
            this.firstLineIndexChanged(n2);
            this.propertyChanged(35);
        }
    }

    @Override
    public int[] get_tabPositions() {
        return this.tabPositions;
    }

    @Override
    public void set_tabPositions(int[] nArray) {
        int[] nArray2 = this.tabPositions;
        if (!Arrays.equals(nArray2, nArray)) {
            this.tabPositions = nArray;
            this.tabPositionsChanged(nArray2);
            this.propertyChanged(36);
        }
    }

    @Override
    public int getFirstVisibleLineIndex() {
        int n = this.scrollingAnimation != null && this.scrollingAnimation.isActive() ? (int)(this.scrollingAnimation.getStartValue() + this.scrollingAnimation.getDeltaValue()) : this.viewPortPosition;
        return Math.max(0, n / this.getMaxLineHeight());
    }

    protected void firstLineIndexChanged(int n) {
        this.snap(this.get_firstLineIndex());
        this.notifyAdjustmentListener();
        this.repaintParent();
    }

    protected void tabPositionsChanged(int[] nArray) {
        this.clearTextLayout();
        this.notifyAdjustmentListener();
        this.repaint();
    }

    protected void textColorsChanged(Color[] colorArray) {
        this.notifyAdjustmentListener();
        this.repaint();
    }

    @Override
    protected void heightChanged(int n) {
        this.notifyAdjustmentListener();
        super.heightChanged(n);
    }

    @Override
    protected void textChanged(String string) {
        super.textChanged(string);
        this.stopInternalSnapAnimation();
        this.setViewportPosition(0);
        if (this.is_visible() && this.areParentsVisible()) {
            this.updateTextlayout();
        }
    }

    @Override
    protected void visibleChanged(boolean bl) {
        if (!bl && this.textLayout == null && this.areParentsVisible()) {
            this.updateTextlayout();
        }
        super.visibleChanged(bl);
    }

    @Override
    protected void parentVisibilityChanged(boolean bl) {
        if (!bl && this.textLayout == null) {
            this.updateTextlayout();
        }
        super.parentVisibilityChanged(bl);
    }

    private void updatePagesize(TextLayout textLayout) {
        this.pageSize = textLayout.getHeight();
        this.viewPortPosition = Util.clamp(this.viewPortPosition, this.getMinimum(), this.getMaximum());
    }

    protected TextLayout formatText(String string) {
        Font font = this.getFont();
        Insets insets = this.get_padding();
        int n = insets.left + insets.right;
        int n2 = this.get_width() - n;
        int n3 = this.get_lineSpacing();
        int[] nArray = this.get_tabPositions() != null ? this.get_tabPositions() : new int[]{};
        boolean bl = this.get_alignmentHorizontal() == 2;
        string = StringUtil.replaceAll(string, "\\n", "\n");
        List list = ScrollableText.splitStringByToken(string, "\n");
        int n4 = list.size();
        int n5 = 0;
        ArrayList arrayList = new ArrayList(n4);
        ArrayList arrayList2 = new ArrayList(nArray.length);
        for (int i2 = 0; i2 < n4; ++i2) {
            String string2 = (String)list.get(i2);
            List list2 = ScrollableText.splitStringByToken(string2, "\\t");
            int n6 = Math.min(list2.size(), nArray.length + 1);
            int n7 = 0;
            arrayList2.clear();
            for (int i3 = 0; i3 < n6; ++i3) {
                String string3 = (String)list2.get(i3);
                int n8 = i3 == 0 ? 0 : nArray[i3 - 1];
                int n9 = i3 < n6 - 1 ? nArray[i3] - n8 : n2 - n8;
                TextStyle[] textStyleArray = this.createTextStyles(string3);
                TextLayout textLayout = ServiceManager.textLayoutManager.performTextLayout(n9, -129, -129, false, '\u2026', false, '-', textStyleArray, string3.trim(), font);
                n7 = n3 > 0 ? Math.max(n7, textLayout.getHeight()) : Math.max(n7, textLayout.getLineCount() * n3);
                n7 = Math.max(Math.max(Math.max(n7, textLayout.getHeight()), textLayout.getLineCount() * n3), n3);
                List list3 = this.is_textStylingEnabled() ? this.createTextHighlights(string3, textLayout) : null;
                arrayList2.add(new ScrollableTextModel$Tab(bl ? n2 - n8 - n9 : n8, textLayout, list3, textStyleArray));
            }
            arrayList.add(new ScrollableTextModel$TabbedRow(n5, n7, (ScrollableTextModel$Tab[])arrayList2.toArray(new ScrollableTextModel$Tab[arrayList2.size()])));
            n5 += n7;
        }
        return new ScrollableTextModel$TabbedTextLayout(n5, (ScrollableTextModel$TabbedRow[])arrayList.toArray(new ScrollableTextModel$TabbedRow[arrayList.size()]));
    }

    private static List splitStringByToken(String string, String string2) {
        ArrayList arrayList = new ArrayList();
        int n = string2.length();
        int n2 = 0;
        int n3 = 0;
        do {
            if ((n3 = string.indexOf(string2, n2)) != -1) {
                arrayList.add(string.substring(n2, n3));
                n2 = n3 + n;
                continue;
            }
            arrayList.add(string.substring(n2, string.length()));
        } while (n3 != -1);
        return arrayList;
    }

    @Override
    protected TextLayout createTextLayout(String string) {
        TextLayout textLayout = null;
        if (string != null && this.getFont() != null) {
            textLayout = this.formatText(string);
            this.updatePagesize(textLayout);
            this.notifyAdjustmentListener();
        }
        return textLayout;
    }

    @Override
    protected int getTextStyleLinebreakMode() {
        return 0;
    }

    private void snap(int n) {
        int n2 = this.calculateSnapPosition(n);
        if (!this.startInternalSnapAnimation(n2, this.getEasing(12))) {
            this.setViewportPosition(n2);
        }
    }

    private boolean startInternalSnapAnimation(int n, EasingParams easingParams) {
        this.stopInternalSnapAnimation();
        if (easingParams == null) {
            return false;
        }
        this.scrollingAnimation = new ScrollableText$ScrollingAnimation(this, this, easingParams, this.viewPortPosition, n - this.viewPortPosition);
        return this.startInternalAnimation(this.scrollingAnimation);
    }

    private void stopInternalSnapAnimation() {
        if (this.scrollingAnimation != null) {
            this.stopInternalAnimation(this.scrollingAnimation);
            this.scrollingAnimation = null;
        }
    }

    @Override
    public void stopInternalAnimations() {
        super.stopInternalAnimations();
        this.stopInternalSnapAnimation();
    }

    private void setViewportPosition(int n) {
        if (n != this.viewPortPosition) {
            this.viewPortPosition = n;
            this.notifyAdjustmentListener();
            this.repaintParent();
        }
    }

    private int getViewportHeight() {
        Insets insets = this.get_padding();
        return this.get_height() - insets.bottom - insets.top;
    }

    private int calculateSnapPosition(int n) {
        return Util.clamp(n * this.getMaxLineHeight() + (n > 0 ? this.get_baselineOffset() : 0), this.getMinimum(), this.getMaximum());
    }

    @Override
    public boolean adaptSnapPosition(Point point, int n) {
        point.y = this.calculateSnapPosition(Util.divideAndCeil(point.y, this.getMaxLineHeight()));
        return false;
    }

    @Override
    public Draggable$DragDataStorage getDragDataStorage() {
        return this.dragDataStorage;
    }

    @Override
    public void getViewPort(Rectangle rectangle) {
        rectangle.setBounds(0, this.viewPortPosition, 0, this.getViewportHeight());
    }

    @Override
    public void getVisualAreaBounds(Rectangle rectangle) {
        rectangle.setBounds(0, 0, 0, this.pageSize);
    }

    @Override
    public int getMaxDraggingSpeed() {
        return this.get_height();
    }

    @Override
    public void setViewportPosition(int n, int n2) {
        this.setViewportPosition(n2);
    }

    @Override
    public boolean useDragDeceleration() {
        return true;
    }

    @Override
    public void startSnapAnimation(int n, int n2, EasingParams easingParams) {
        this.stopInternalSnapAnimation();
        this.startInternalSnapAnimation(n2, easingParams);
    }

    @Override
    public void startDragging() {
    }

    @Override
    public void stopDragging() {
    }

    @Override
    public int getMinimum() {
        return 0;
    }

    @Override
    public void setMinimum(int n) {
    }

    @Override
    public int getMaximum() {
        return this.pageSize > this.getViewportHeight() ? this.pageSize - this.getViewportHeight() + this.get_baselineOffset() : 0;
    }

    @Override
    public void setMaximum(int n) {
    }

    @Override
    public int getBlockIncrement() {
        return this.getViewportHeight();
    }

    @Override
    public void setBlockIncrement(int n) {
    }

    @Override
    public int getValue() {
        return this.viewPortPosition;
    }

    @Override
    public void setValue(int n) {
        this.setViewportPosition(n);
    }

    @Override
    public int getUnitIncrement() {
        return this.getMaxLineHeight();
    }

    @Override
    public void setUnitIncrement(int n) {
    }

    @Override
    public void disableAdjustmentChanged() {
        ++this.adjustmentShadowCounter;
    }

    @Override
    public void enableAdjustmentChanged() {
        --this.adjustmentShadowCounter;
    }

    @Override
    public boolean isAdjustmentEnabled() {
        return this.adjustmentShadowCounter == 0;
    }

    @Override
    public void addAdjustmentListener(AdjustmentListener adjustmentListener) {
        this.adjustmentListeners = this.adjustmentListeners.addIfAbsent(adjustmentListener);
        adjustmentListener.adjustmentValueChanged(this, 0);
    }

    @Override
    public void removeAdjustmentListener(AdjustmentListener adjustmentListener) {
        this.adjustmentListeners = this.adjustmentListeners.remove(adjustmentListener);
    }

    @Override
    public void adjustmentValueChanged(Adjustable adjustable, int n) {
        if (n == 1) {
            this.stopInternalSnapAnimation();
        } else if (n == 2) {
            this.snap(Math.round((float)this.getValue() / (float)this.getMaxLineHeight()));
        } else if (n == 0) {
            this.disableAdjustmentChanged();
            this.setValue(adjustable.getValue());
            this.enableAdjustmentChanged();
        }
        this.repaintParent();
    }

    protected void notifyAdjustmentListener() {
        if (this.isAdjustmentEnabled()) {
            for (CowList cowList = this.adjustmentListeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
                AdjustmentListener adjustmentListener = (AdjustmentListener)cowList.head();
                adjustmentListener.adjustmentValueChanged(this, 0);
            }
        }
    }

    @Override
    public int getMaxLineCount() {
        return -1;
    }

    @Override
    public int getMaxLineWidth() {
        Insets insets = this.get_padding();
        int n = insets.left + insets.right;
        return this.get_width() - n;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

