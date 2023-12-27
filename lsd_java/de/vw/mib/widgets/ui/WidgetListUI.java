/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.image.ScaleImageDrawable;
import de.vw.mib.graphics.drawable.offscreen.OffscreenDrawable;
import de.vw.mib.graphics.drawable.shape.RectangleDrawable;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.widgets.interfaces.FocusableUI;
import de.vw.mib.widgets.models.ContainerModel;
import de.vw.mib.widgets.models.ListItemModel;
import de.vw.mib.widgets.models.TemplateListModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetListModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.AbstractTemplateListUI;
import de.vw.mib.widgets.ui.AbstractWidgetUI;
import de.vw.mib.widgets.ui.WidgetListUI$Separators;
import java.io.IOException;

public class WidgetListUI
extends AbstractTemplateListUI
implements FocusableUI {
    private boolean expandAnimationRunning;
    private boolean collapseAnimationRunning;
    private final Rectangle clippingAreaDefault;
    private final Rectangle clippingAreaExpand;
    private final Rectangle clippingAreaCollapse;
    protected final Rectangle childBounds = new Rectangle();
    protected final Rectangle viewport = new Rectangle();
    private final WidgetListUI$Separators separators;
    private ScaleImageDrawable drawableSeparatorMain;
    private ScaleImageDrawable drawableSeparatorSub;
    private OffscreenDrawable drawableOffscreenBrowsing;
    private ScaleImageDrawable dropIndicatorImageDrawable;
    private RectangleDrawable dropIndicatorRectDrawable;

    public WidgetListUI() {
        this.clippingAreaDefault = new Rectangle();
        this.clippingAreaExpand = new Rectangle();
        this.clippingAreaCollapse = new Rectangle();
        this.separators = new WidgetListUI$Separators();
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void deInit() {
        WidgetListUI.disposeDrawable(this.drawableSeparatorMain);
        this.drawableSeparatorMain = null;
        WidgetListUI.disposeDrawable(this.drawableSeparatorSub);
        this.drawableSeparatorSub = null;
        WidgetListUI.disposeDrawable(this.drawableOffscreenBrowsing);
        this.drawableOffscreenBrowsing = null;
        WidgetListUI.disposeDrawable(this.dropIndicatorImageDrawable);
        this.dropIndicatorImageDrawable = null;
        WidgetListUI.disposeDrawable(this.dropIndicatorRectDrawable);
        this.dropIndicatorRectDrawable = null;
        super.deInit();
    }

    @Override
    public void paint(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        WidgetListModel widgetListModel = (WidgetListModel)widgetModel;
        super.paint(graphics3D, viewModel, widgetListModel, rectangle, rectangle2, f2);
        if (!widgetListModel.isBrowsingTextureDrawingEnabled()) {
            this.paintListContentOverlay(graphics3D, viewModel, widgetListModel, rectangle, rectangle2, f2);
        }
    }

    @Override
    protected void paintContent(Graphics3D graphics3D, ViewModel viewModel, ContainerModel containerModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        WidgetListModel widgetListModel = (WidgetListModel)containerModel;
        this.expandAnimationRunning = widgetListModel.isExpandAnimationRunning();
        this.collapseAnimationRunning = widgetListModel.isCollapseAnimationRunning();
        this.clippingAreaDefault.setBounds(0, 0, widgetListModel.get_width(), widgetListModel.get_height());
        this.clippingAreaExpand.setBounds(this.clippingAreaDefault);
        this.clippingAreaCollapse.setBounds(this.clippingAreaDefault);
        this.viewport.setBounds(widgetListModel.getViewport());
        if (this.expandAnimationRunning || this.collapseAnimationRunning) {
            boolean bl = widgetListModel.get_separatorMode() != 0;
            int n = widgetListModel.getExpandIndexFirst() - 1;
            int n2 = widgetListModel.getCollapseIndexFirst() - 1;
            int n3 = bl ? widgetListModel.getItemHeight(n) : widgetListModel.getItemHeight(n) >> 1;
            int n4 = bl ? widgetListModel.getItemHeight(n2) : widgetListModel.getItemHeight(n2) >> 1;
            int n5 = widgetListModel.get_spacingVertical();
            this.clippingAreaExpand.y = widgetListModel.getItemY(n) + n3 + n5 - this.viewport.y;
            this.clippingAreaExpand.y = Math.max(0, this.clippingAreaExpand.y);
            this.clippingAreaExpand.height = Math.max(0, this.clippingAreaExpand.height - this.clippingAreaExpand.y);
            this.clippingAreaCollapse.y = widgetListModel.getItemY(n2) + n4 + n5 - this.viewport.y;
            this.clippingAreaCollapse.y = Math.max(0, this.clippingAreaCollapse.y);
            this.clippingAreaCollapse.height = Math.max(0, this.clippingAreaCollapse.height - this.clippingAreaCollapse.y);
        } else {
            this.enableClipping(graphics3D, rectangle, this.clippingAreaDefault, rectangle2);
        }
        if (widgetListModel.isBrowsingTextureInvalid()) {
            if (this.drawableOffscreenBrowsing == null) {
                this.drawableOffscreenBrowsing = graphics3D.getDrawableManager().createOffscreenDrawable(widgetListModel.get_width(), widgetListModel.get_height(), false);
            }
            this.disableTransfer();
            this.paintOffscreenBrowsingTexture(graphics3D, viewModel, widgetListModel, rectangle, rectangle2, f2);
            widgetListModel.validateBrowsing();
            this.enableTransfer();
        }
        if (widgetListModel.isBrowsingTextureDrawingEnabled()) {
            this.paintBrowsing(graphics3D, viewModel, widgetListModel, rectangle, rectangle2, f2);
        } else {
            super.paintContent(graphics3D, viewModel, widgetListModel, rectangle, rectangle2, f2);
        }
        this.disableClipping(graphics3D);
    }

    @Override
    public void paintListContent(Graphics3D graphics3D, ViewModel viewModel, TemplateListModel templateListModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        WidgetListModel widgetListModel = (WidgetListModel)templateListModel;
        this.paintSeparators(graphics3D, viewModel, rectangle, rectangle2, f2, widgetListModel);
        super.paintListContent(graphics3D, viewModel, templateListModel, rectangle, rectangle2, f2);
    }

    @Override
    public void paintFocused(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        WidgetListModel widgetListModel = (WidgetListModel)widgetModel;
        this.paintItem(graphics3D, viewModel, rectangle, rectangle2, f2, viewModel.is_renderBoundingBoxes(), widgetListModel, widgetListModel.getFocusedIndex());
    }

    @Override
    protected void paintItems(Graphics3D graphics3D, ViewModel viewModel, TemplateListModel templateListModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        WidgetListModel widgetListModel = (WidgetListModel)templateListModel;
        int n = widgetListModel.getFirstVisibleIndex();
        int n2 = widgetListModel.getLastVisibleIndex();
        if (n != -1 && n2 != -1) {
            boolean bl = viewModel.is_renderBoundingBoxes();
            for (int i2 = n2; i2 >= n; --i2) {
                if (this.expandAnimationRunning || this.collapseAnimationRunning) {
                    this.enableClippingCollapseExpand(graphics3D, widgetListModel, rectangle, i2, rectangle2);
                    float f3 = this.getAlphaCollapseExpand(widgetListModel, i2, f2);
                    this.paintItem(graphics3D, viewModel, rectangle, rectangle2, f3, bl, widgetListModel, i2);
                    this.disableClipping(graphics3D);
                    continue;
                }
                this.paintItem(graphics3D, viewModel, rectangle, rectangle2, f2, bl, widgetListModel, i2);
            }
        }
    }

    protected void paintItem(Graphics3D graphics3D, ViewModel viewModel, Rectangle rectangle, Rectangle rectangle2, float f2, boolean bl, WidgetListModel widgetListModel, int n) {
        ListItemModel listItemModel = widgetListModel.getItem(n);
        boolean bl2 = this.isTransferEnabled();
        if (listItemModel != null) {
            int n2 = widgetListModel.getItemIndex(n);
            int n3 = widgetListModel.getDragIndex();
            if (bl2) {
                widgetListModel.transferData(listItemModel, n, n2);
            }
            widgetListModel.transferStates(listItemModel, n, n2);
            widgetListModel.disableAnimations();
            listItemModel.set_x(widgetListModel.getItemX(n) - this.viewport.x);
            listItemModel.set_y(widgetListModel.getItemY(n) - this.viewport.y);
            widgetListModel.enableAnimations();
            listItemModel.getBounds(this.childBounds);
            this.childBounds.x += rectangle2.x;
            this.childBounds.y += rectangle2.y;
            if (n3 != -1 && n3 == n) {
                float f3 = f2 * AbstractWidgetUI.normalizeAlpha(widgetListModel.get_alphaDragItemSource());
                this.paintChild(graphics3D, viewModel, listItemModel, rectangle, this.childBounds, rectangle2, f3, bl);
            } else {
                this.paintChild(graphics3D, viewModel, listItemModel, rectangle, this.childBounds, rectangle2, f2, bl);
            }
        }
    }

    @Override
    protected void paintDragIndicator(Graphics3D graphics3D, ViewModel viewModel, TemplateListModel templateListModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        WidgetListModel widgetListModel = (WidgetListModel)templateListModel;
        int n = templateListModel.getDragIndex();
        if (n != -1) {
            ListItemModel listItemModel = templateListModel.getItemMaster(n).getDragItemClone();
            int n2 = templateListModel.getItemIndex(n);
            templateListModel.transferData(listItemModel, n, n2);
            templateListModel.transferStates(listItemModel, n, n2);
            widgetListModel.disableAnimations();
            listItemModel.set_x(widgetListModel.getDragPosition().x);
            listItemModel.set_y(widgetListModel.getDragPosition().y);
            widgetListModel.enableAnimations();
            listItemModel.getBounds(this.childBounds);
            this.childBounds.x += rectangle2.x;
            this.childBounds.y += rectangle2.y;
            float f3 = f2 * AbstractWidgetUI.normalizeAlpha(widgetListModel.get_alphaDragItem());
            this.paintChild(graphics3D, viewModel, listItemModel, rectangle, this.childBounds, rectangle2, f3, viewModel.is_renderBoundingBoxes());
        }
    }

    @Override
    protected void paintDropIndicator(Graphics3D graphics3D, ViewModel viewModel, TemplateListModel templateListModel, Rectangle rectangle, Rectangle rectangle2) {
        int n = templateListModel.getDropIndex();
        if (n != -1) {
            WidgetListModel widgetListModel = (WidgetListModel)templateListModel;
            Image image = widgetListModel.get_dropIndicatorImage();
            if (image != null) {
                try {
                    Insets insets = widgetListModel.get_dropIndicatorInsets();
                    int n2 = widgetListModel.getItemX(n) - this.viewport.x + insets.left;
                    int n3 = widgetListModel.getItemY(n) - this.viewport.y + insets.top;
                    this.updateDropIndicatorImageDrawable(graphics3D, widgetListModel);
                    if (this.dropIndicatorImageDrawable != null) {
                        this.dropIndicatorImageDrawable.draw(n2, n3);
                    }
                }
                catch (IOException iOException) {
                    LogMessage logMessage = LOGGER.error(32);
                    logMessage.append("Widget '").append(widgetListModel.getQualifiedName()).append("': Unable to load image (").append(image).append("): ").attachThrowable(iOException).log();
                }
            } else {
                this.updateDropIndicatorRectDrawable(graphics3D, widgetListModel);
                this.dropIndicatorRectDrawable.setColor(Color4f.RED);
                this.dropIndicatorRectDrawable.draw();
            }
        }
    }

    private void paintSeparators(Graphics3D graphics3D, ViewModel viewModel, Rectangle rectangle, Rectangle rectangle2, float f2, WidgetListModel widgetListModel) {
        int n = widgetListModel.getFirstVisibleIndex();
        int n2 = widgetListModel.getLastVisibleIndex();
        int n3 = widgetListModel.get_separatorMode();
        boolean bl = widgetListModel.getMaximum() > 0;
        float f3 = f2;
        if (n3 != 0 && n != -1 && n2 != -1) {
            this.updateSeparators(widgetListModel);
            this.updateSeparatorDrawables(graphics3D, widgetListModel);
            if ((n3 & 2) != 0 && n == 0) {
                this.paintSeparator(graphics3D, 0, 0, widgetListModel, f3, bl);
            }
            if ((n3 & 1) != 0) {
                for (int i2 = n; i2 <= n2; ++i2) {
                    if (i2 <= 0) continue;
                    if (this.expandAnimationRunning || this.collapseAnimationRunning) {
                        this.enableClippingCollapseExpand(graphics3D, widgetListModel, rectangle, i2, rectangle2);
                        f3 = this.getAlphaCollapseExpand(widgetListModel, i2, f2);
                        this.paintSeparator(graphics3D, i2 - 1, i2, widgetListModel, f3, bl);
                        this.disableClipping(graphics3D);
                        continue;
                    }
                    this.paintSeparator(graphics3D, i2 - 1, i2, widgetListModel, f3, bl);
                }
            }
            if ((n3 & 4) != 0 && n2 == widgetListModel.get_itemCount() - 1) {
                if (this.expandAnimationRunning || this.collapseAnimationRunning) {
                    this.enableClipping(graphics3D, rectangle, this.clippingAreaDefault, rectangle2);
                    this.paintSeparator(graphics3D, n2, n2, widgetListModel, f3, bl);
                    this.disableClipping(graphics3D);
                } else {
                    this.paintSeparator(graphics3D, n2, n2, widgetListModel, f3, bl);
                }
            }
        }
    }

    protected void paintSeparator(Graphics3D graphics3D, int n, int n2, WidgetListModel widgetListModel, float f2, boolean bl) {
        ScaleImageDrawable scaleImageDrawable;
        boolean bl2 = n == n2;
        int n3 = bl2 ? widgetListModel.getItemWidth(n2) + widgetListModel.get_spacingHorizontal() : 0;
        int n4 = bl2 ? widgetListModel.getItemHeight(n2) + widgetListModel.get_spacingVertical() : 0;
        int n5 = widgetListModel.getItemX(n2) - this.viewport.x + n3;
        int n6 = widgetListModel.getItemY(n2) - this.viewport.y + n4;
        ListItemModel listItemModel = widgetListModel.getItem(n);
        ListItemModel listItemModel2 = widgetListModel.getItem(n2);
        boolean bl3 = false;
        if (listItemModel != null && listItemModel2 != null) {
            bl3 = widgetListModel.getItem(n).isSubItem() && widgetListModel.getItem(n2).isSubItem();
        }
        Insets insets = bl3 ? this.separators.insetsSub : this.separators.insetsMain;
        ScaleImageDrawable scaleImageDrawable2 = scaleImageDrawable = bl3 ? this.drawableSeparatorSub : this.drawableSeparatorMain;
        if (scaleImageDrawable != null) {
            scaleImageDrawable.setAlpha(f2);
            graphics3D.pushMatrix(0);
            switch (widgetListModel.get_orientation()) {
                case 0: {
                    graphics3D.translateMatrix(0, insets.left, n6 + widgetListModel.get_separatorOffset(), 0.0f);
                    scaleImageDrawable.draw();
                    break;
                }
                case 1: {
                    graphics3D.translateMatrix(0, n5 + widgetListModel.get_separatorOffset(), insets.top, 0.0f);
                    scaleImageDrawable.draw();
                    break;
                }
                case 2: {
                    if (widgetListModel.getItemY(n) == widgetListModel.getItemY(n2) && !bl2) break;
                    graphics3D.translateMatrix(0, insets.left, n6 + widgetListModel.get_separatorOffset(), 0.0f);
                    scaleImageDrawable.draw();
                    break;
                }
                case 3: {
                    if (widgetListModel.getItemX(n) == widgetListModel.getItemX(n2) && !bl2) break;
                    graphics3D.translateMatrix(0, n5 + widgetListModel.get_separatorOffset(), insets.top, 0.0f);
                    scaleImageDrawable.draw();
                    break;
                }
            }
            graphics3D.popMatrix(0);
        }
    }

    private void paintBrowsing(Graphics3D graphics3D, ViewModel viewModel, WidgetListModel widgetListModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        int n;
        if (this.drawableOffscreenBrowsing != null && this.drawableOffscreenBrowsing.isValid()) {
            graphics3D.setBlendColor(new Color4f(1.0f, 1.0f, 1.0f, f2));
            n = graphics3D.getBlendFactorSourceRGB();
            int n2 = graphics3D.getBlendFactorDestinationRGB();
            int n3 = graphics3D.getBlendFactorSourceAlpha();
            int n4 = graphics3D.getBlendFactorDestinationAlpha();
            graphics3D.setBlendFactorsSeparate(13, 7, 1, 7);
            this.drawableOffscreenBrowsing.setAlpha(f2);
            this.drawableOffscreenBrowsing.draw(widgetListModel.getBrowsingPositionPrevContext(), 0.0f);
            graphics3D.setBlendFactorsSeparate(n, n2, n3, n4);
        }
        graphics3D.pushMatrix(0);
        n = widgetListModel.getBrowsingPositionNextContext();
        graphics3D.translateMatrix(0, n, 0.0f, 0.0f);
        rectangle2.translate(n, 0);
        this.paintListContent(graphics3D, viewModel, widgetListModel, rectangle, rectangle2, f2);
        this.paintListContentOverlay(graphics3D, viewModel, widgetListModel, rectangle, rectangle2, f2);
        rectangle2.translate(-n, 0);
        graphics3D.popMatrix(0);
    }

    private void paintOffscreenBrowsingTexture(Graphics3D graphics3D, ViewModel viewModel, WidgetListModel widgetListModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        OffscreenDrawable offscreenDrawable = this.drawableOffscreenBrowsing;
        if (offscreenDrawable != null) {
            offscreenDrawable.prepareGraphics(graphics3D, rectangle2, 0);
            this.paintListContent(graphics3D, viewModel, widgetListModel, rectangle, rectangle2, f2);
            this.paintListContentOverlay(graphics3D, viewModel, widgetListModel, rectangle, rectangle2, f2);
            offscreenDrawable.restoreGraphics(graphics3D, rectangle2);
        }
    }

    private void enableClippingCollapseExpand(Graphics3D graphics3D, WidgetListModel widgetListModel, Rectangle rectangle, int n, Rectangle rectangle2) {
        if (this.expandAnimationRunning && n >= widgetListModel.getExpandIndexFirst() && n <= widgetListModel.getExpandIndexLast()) {
            this.enableClipping(graphics3D, rectangle, this.clippingAreaExpand, rectangle2);
        } else if (this.collapseAnimationRunning && n >= widgetListModel.getCollapseIndexFirst() && n <= widgetListModel.getCollapseIndexLast()) {
            this.enableClipping(graphics3D, rectangle, this.clippingAreaCollapse, rectangle2);
        } else {
            this.enableClipping(graphics3D, rectangle, this.clippingAreaDefault, rectangle2);
        }
    }

    private float getAlphaCollapseExpand(WidgetListModel widgetListModel, int n, float f2) {
        if (this.expandAnimationRunning && n >= widgetListModel.getExpandIndexFirst() && n <= widgetListModel.getExpandIndexLast()) {
            return Util.clamp(f2 * widgetListModel.getExpandAlpha(), 0.0f, 1.0f);
        }
        if (this.collapseAnimationRunning && n >= widgetListModel.getCollapseIndexFirst() && n <= widgetListModel.getCollapseIndexLast()) {
            return Util.clamp(f2 * (1.0f - widgetListModel.getCollapseAlpha()), 0.0f, 1.0f);
        }
        return f2;
    }

    private void updateSeparatorDrawables(Graphics3D graphics3D, WidgetListModel widgetListModel) {
        boolean bl;
        boolean bl2 = widgetListModel.isInvalid();
        boolean bl3 = bl2 || this.drawableSeparatorMain == null || this.drawableSeparatorMain.getImage() == null;
        boolean bl4 = bl = bl2 || this.drawableSeparatorSub == null || this.drawableSeparatorSub.getImage() == null;
        if (this.separators.valid && (bl3 || bl)) {
            int n;
            int n2;
            int n3;
            int n4;
            if (this.separators.vertical) {
                int n5 = widgetListModel.get_width();
                n4 = n5 - this.separators.insetsMain.left - this.separators.insetsMain.right;
                n3 = n5 - this.separators.insetsSub.left - this.separators.insetsSub.right;
                n2 = 0;
                n = 0;
            } else {
                int n6 = widgetListModel.get_height();
                n4 = 0;
                n3 = 0;
                n2 = n6 - this.separators.insetsMain.top - this.separators.insetsMain.bottom;
                n = n6 - this.separators.insetsSub.top - this.separators.insetsSub.bottom;
            }
            if (bl3) {
                this.drawableSeparatorMain = this.updateDrawable(graphics3D, widgetListModel, this.drawableSeparatorMain, this.separators.imageMain, n4, n2);
            }
            if (bl) {
                this.drawableSeparatorSub = this.updateDrawable(graphics3D, widgetListModel, this.drawableSeparatorSub, this.separators.imageSub, n3, n);
            }
        }
    }

    private ScaleImageDrawable updateDrawable(Graphics3D graphics3D, WidgetListModel widgetListModel, ScaleImageDrawable scaleImageDrawable, Image image, int n, int n2) {
        try {
            scaleImageDrawable = WidgetListUI.updateScaleImageDrawable(graphics3D, widgetListModel, scaleImageDrawable, image, n, n2);
        }
        catch (IOException iOException) {
            LogMessage logMessage = LOGGER.error(4);
            logMessage.append("Widget '").append(widgetListModel).append("': Unable to load image (").append(image).append("): ").append(iOException).log();
        }
        return scaleImageDrawable;
    }

    private void updateDropIndicatorRectDrawable(Graphics3D graphics3D, WidgetListModel widgetListModel) {
        int n = 2;
        int n2 = widgetListModel.getDropIndex();
        int n3 = widgetListModel.getItemX(n2);
        int n4 = widgetListModel.getItemY(n2);
        int n5 = widgetListModel.isVertical() ? widgetListModel.getItemWidth(n2) : 2;
        int n6 = widgetListModel.isVertical() ? 2 : widgetListModel.getItemHeight(n2);
        this.dropIndicatorRectDrawable = WidgetListUI.updateRectangleDrawable(graphics3D, widgetListModel, this.dropIndicatorRectDrawable, n3, n4, n5, n6);
    }

    private void updateDropIndicatorImageDrawable(Graphics3D graphics3D, WidgetListModel widgetListModel) {
        Image image = widgetListModel.get_dropIndicatorImage();
        Insets insets = widgetListModel.get_dropIndicatorInsets();
        this.dropIndicatorImageDrawable = WidgetListUI.updateScaleImageDrawable(graphics3D, widgetListModel, this.dropIndicatorImageDrawable, image);
        if (widgetListModel.isInvalid() && this.dropIndicatorImageDrawable != null) {
            int n = widgetListModel.getDropIndex();
            int n2 = widgetListModel.getItemWidth(n) - insets.left - insets.right;
            int n3 = widgetListModel.getItemHeight(n) - insets.top - insets.bottom;
            this.dropIndicatorImageDrawable.setWidth(n2);
            this.dropIndicatorImageDrawable.setHeight(n3);
        }
    }

    private void updateSeparators(WidgetListModel widgetListModel) {
        Image[] imageArray = widgetListModel.get_separatorImages();
        Insets[] insetsArray = widgetListModel.get_separatorInsets();
        this.separators.valid = false;
        this.separators.dynamic = widgetListModel.isDynamic();
        this.separators.vertical = widgetListModel.isVertical();
        if (imageArray != null && insetsArray != null && imageArray.length >= 4 && insetsArray.length >= 4) {
            if (this.separators.dynamic) {
                this.separators.imageMain = imageArray[1];
                this.separators.imageSub = imageArray[3];
                this.separators.insetsMain = insetsArray[1];
                this.separators.insetsSub = insetsArray[3];
            } else {
                this.separators.imageMain = imageArray[0];
                this.separators.imageSub = imageArray[2];
                this.separators.insetsMain = insetsArray[0];
                this.separators.insetsSub = insetsArray[2];
            }
            this.separators.valid = this.separators.imageMain != null && this.separators.imageSub != null && this.separators.insetsMain != null && this.separators.insetsSub != null;
        }
    }
}

