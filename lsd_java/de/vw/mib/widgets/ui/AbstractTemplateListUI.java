/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.shape.RectangleDrawable;
import de.vw.mib.widgets.models.ContainerModel;
import de.vw.mib.widgets.models.TemplateListModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.ListUI;

public abstract class AbstractTemplateListUI
extends ListUI {
    private static boolean LETTER_SCROLLING_DEBUG = System.getProperty("de.vw.mib.widgets.letterscrollingdebug") != null;
    private static final int LETTER_INDICATOR_WIDTH;
    private static final int LETTER_INDICATOR_HEIGHT;
    private Rectangle childBoundsBefore = new Rectangle();
    private Rectangle childBoundsAfter = new Rectangle();
    private boolean transferEnabled;
    private RectangleDrawable letterIndicatorDrawable;

    @Override
    public void init() {
        super.init();
        this.transferEnabled = true;
    }

    @Override
    public void deInit() {
        AbstractTemplateListUI.disposeDrawable(this.letterIndicatorDrawable);
        this.letterIndicatorDrawable = null;
        super.deInit();
    }

    @Override
    public void paint(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        TemplateListModel templateListModel = (TemplateListModel)widgetModel;
        templateListModel.freeze();
        templateListModel.validateList();
        super.paint(graphics3D, viewModel, widgetModel, rectangle, rectangle2, f2);
        templateListModel.unfreeze();
    }

    @Override
    protected void paintContent(Graphics3D graphics3D, ViewModel viewModel, ContainerModel containerModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        TemplateListModel templateListModel = (TemplateListModel)containerModel;
        this.paintListContent(graphics3D, viewModel, templateListModel, rectangle, rectangle2, f2);
    }

    public void paintListContent(Graphics3D graphics3D, ViewModel viewModel, TemplateListModel templateListModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        this.paintRegularChildren(graphics3D, viewModel, templateListModel, true, rectangle, rectangle2, f2);
        this.paintItems(graphics3D, viewModel, templateListModel, rectangle, rectangle2, f2);
    }

    public void paintListContentOverlay(Graphics3D graphics3D, ViewModel viewModel, TemplateListModel templateListModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        this.paintRegularChildren(graphics3D, viewModel, templateListModel, false, rectangle, rectangle2, f2);
        this.paintDragIndicator(graphics3D, viewModel, templateListModel, rectangle, rectangle2, f2);
        this.paintDropIndicator(graphics3D, viewModel, templateListModel, rectangle, rectangle2);
        if (LETTER_SCROLLING_DEBUG && templateListModel.isLetterScrollingIndicatorActive()) {
            this.paintLetterIndicatorDebug(graphics3D, viewModel, templateListModel);
        }
    }

    protected abstract void paintItems(Graphics3D graphics3D, ViewModel viewModel, TemplateListModel templateListModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
    }

    protected abstract void paintDragIndicator(Graphics3D graphics3D, ViewModel viewModel, TemplateListModel templateListModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
    }

    protected abstract void paintDropIndicator(Graphics3D graphics3D, ViewModel viewModel, TemplateListModel templateListModel, Rectangle rectangle, Rectangle rectangle2) {
    }

    protected void paintRegularChildren(Graphics3D graphics3D, ViewModel viewModel, TemplateListModel templateListModel, boolean bl, Rectangle rectangle, Rectangle rectangle2, float f2) {
        WidgetModel[] widgetModelArray = templateListModel.getChildren();
        boolean bl2 = viewModel.is_renderBoundingBoxes();
        int n = widgetModelArray.length;
        int n2 = bl ? 0 : templateListModel.getChildIndexLastItem() + 1;
        int n3 = bl ? templateListModel.getChildIndexFirstItem() : n;
        Rectangle rectangle3 = bl ? this.childBoundsBefore : this.childBoundsAfter;
        for (int i2 = n2; i2 < n3; ++i2) {
            WidgetModel widgetModel = widgetModelArray[i2];
            widgetModel.getBounds(rectangle3);
            rectangle3.x += rectangle2.x;
            rectangle3.y += rectangle2.y;
            this.paintChild(graphics3D, viewModel, widgetModel, rectangle, rectangle3, rectangle2, f2, bl2);
        }
    }

    protected final void disableTransfer() {
        this.transferEnabled = false;
    }

    protected final void enableTransfer() {
        this.transferEnabled = true;
    }

    protected final boolean isTransferEnabled() {
        return this.transferEnabled;
    }

    private void paintLetterIndicatorDebug(Graphics3D graphics3D, ViewModel viewModel, TemplateListModel templateListModel) {
        int n = (templateListModel.get_width() >> 1) - 12;
        int n2 = (templateListModel.get_height() >> 1) - 12;
        String string = templateListModel.getLetterScrollingText();
        if (string != null) {
            this.updateLetterIndicatorDrawable(graphics3D, templateListModel);
            this.letterIndicatorDrawable.setColor(Color4f.GRAY);
            this.letterIndicatorDrawable.draw(n - 20, n2 - 50);
            this.drawDebugText(graphics3D, n, n2, string);
        }
    }

    private void updateLetterIndicatorDrawable(Graphics3D graphics3D, TemplateListModel templateListModel) {
        if (this.letterIndicatorDrawable == null) {
            this.letterIndicatorDrawable = AbstractTemplateListUI.updateRectangleDrawable(graphics3D, templateListModel, this.letterIndicatorDrawable, 0, 0, 60, 80);
        }
    }
}

