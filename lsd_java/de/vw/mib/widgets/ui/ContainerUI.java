/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.image.ScaleImageDrawable;
import de.vw.mib.graphics.drawable.shape.PolyLineDrawable;
import de.vw.mib.graphics.math.Transform;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.math.geometry.Point2f;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.widgets.AbstractWidget;
import de.vw.mib.widgets.interfaces.Decoratable$DecorationConfiguratior;
import de.vw.mib.widgets.models.ContainerModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.AbstractWidgetUI;
import de.vw.mib.widgets.ui.ContainerUI$ReflectionDecorationHelper;
import de.vw.mib.widgets.ui.ContainerUI$SnapshotDecorationHelper;
import de.vw.mib.widgets.ui.util.EffectDecorator;

public class ContainerUI
extends AbstractWidgetUI {
    public static final boolean DEBUG_REPAINT = System.getProperty("de.vw.mib.widgets.debugrepaint") != null;
    private static final boolean INTERSECT_CHILDREN = System.getProperty("de.vw.mib.widgets.intersectchildren") != null;
    private static final boolean INTERSECT_CHILDREN_HIGHLIGHT_ERRORS = INTERSECT_CHILDREN && !AbstractWidget.DIRTY_REGION_MANAGEMENT && DEBUG_REPAINT;
    private static final float BOUNDINGBOX_ALPHA;
    private static final Color4f BOUNDINGBOX_COLOR;
    private EffectDecorator snapshotDecorator;
    private EffectDecorator reflectionDecorator;
    private ContainerUI$SnapshotDecorationHelper snapshotDecorationHelper;
    private ContainerUI$ReflectionDecorationHelper reflectionDecorationHelper;
    private boolean offscreenUpdatePerformed;
    private final Rectangle childBounds = new Rectangle();
    private PolyLineDrawable boundingBoxDrawable;

    @Override
    public void init() {
        super.init();
        this.offscreenUpdatePerformed = false;
    }

    @Override
    public void deInit() {
        if (this.snapshotDecorator != null) {
            this.snapshotDecorator.dispose();
            this.snapshotDecorator = null;
        }
        if (this.snapshotDecorationHelper != null) {
            this.snapshotDecorationHelper.dispose();
            this.snapshotDecorationHelper = null;
        }
        if (this.reflectionDecorator != null) {
            this.reflectionDecorator.dispose();
            this.reflectionDecorator = null;
        }
        if (this.reflectionDecorationHelper != null) {
            this.reflectionDecorationHelper.dispose();
            this.reflectionDecorationHelper = null;
        }
        if (this.boundingBoxDrawable != null) {
            this.boundingBoxDrawable.dispose();
            this.boundingBoxDrawable = null;
        }
        super.deInit();
    }

    @Override
    public void paint(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        ContainerModel containerModel = (ContainerModel)widgetModel;
        containerModel.validateLayout();
        if (!this.offscreenUpdatePerformed) {
            this.updateOffscreenDrawables(graphics3D, viewModel, containerModel, rectangle, rectangle2, 0);
        }
        if (containerModel.getReflectionRenderMode() != 2) {
            this.paintContainer(graphics3D, viewModel, containerModel, rectangle, rectangle2, f2, !containerModel.isRenderOffscreenReplace());
        }
        if (containerModel.getReflectionRenderMode() != 1 && this.reflectionDecorator != null) {
            if (this.reflectionDecorator.isValid()) {
                graphics3D.pushMatrix(0);
                graphics3D.scaleMatrix(0, 1.0f, 32959, 1.0f);
                int n = graphics3D.getBlendFactorSourceRGB();
                int n2 = graphics3D.getBlendFactorDestinationRGB();
                int n3 = graphics3D.getBlendFactorSourceAlpha();
                int n4 = graphics3D.getBlendFactorDestinationAlpha();
                int n5 = rectangle2.height;
                rectangle2.height = this.reflectionDecorationHelper.getHeight();
                graphics3D.setBlendFactorsSeparate(13, 7, 1, 7);
                float f3 = f2 * AbstractWidgetUI.normalizeAlpha(containerModel.get_reflectionAlpha());
                graphics3D.setBlendColor(new Color4f(1.0f, 1.0f, 1.0f, f3));
                this.reflectionDecorator.draw(graphics3D, rectangle, rectangle2, f3, 0, -containerModel.get_height() - this.reflectionDecorationHelper.getHeight() - containerModel.get_reflectionDistance());
                rectangle2.height = n5;
                graphics3D.setBlendFactorsSeparate(n, n2, n3, n4);
                graphics3D.popMatrix(0);
            } else {
                LogMessage logMessage = LOGGER.warn(1);
                logMessage.append("Container '").append(containerModel.getQualifiedName()).append("': Unable to draw reflection").log();
            }
        }
        this.offscreenUpdatePerformed = false;
    }

    protected final void paintContainer(Graphics3D graphics3D, ViewModel viewModel, ContainerModel containerModel, Rectangle rectangle, Rectangle rectangle2, float f2, boolean bl) {
        if (this.snapshotDecorator != null) {
            if (!bl) {
                graphics3D.setBlendingEnabled(false);
                this.snapshotDecorator.draw(graphics3D, rectangle, rectangle2, f2, -this.snapshotDecorationHelper.getOffsetX(), -this.snapshotDecorationHelper.getOffsetY());
                graphics3D.setBlendingEnabled(true);
            } else {
                graphics3D.setBlendColor(new Color4f(1.0f, 1.0f, 1.0f, f2));
                int n = graphics3D.getBlendFactorSourceRGB();
                int n2 = graphics3D.getBlendFactorDestinationRGB();
                int n3 = graphics3D.getBlendFactorSourceAlpha();
                int n4 = graphics3D.getBlendFactorDestinationAlpha();
                graphics3D.setBlendFactorsSeparate(13, 7, 1, 7);
                this.snapshotDecorator.draw(graphics3D, rectangle, rectangle2, f2, -this.snapshotDecorationHelper.getOffsetX(), -this.snapshotDecorationHelper.getOffsetY());
                graphics3D.setBlendFactorsSeparate(n, n2, n3, n4);
            }
        } else {
            this.paintContent(graphics3D, viewModel, containerModel, rectangle, rectangle2, f2);
        }
    }

    protected void paintContent(Graphics3D graphics3D, ViewModel viewModel, ContainerModel containerModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        boolean bl;
        WidgetModel[] widgetModelArray = containerModel.getChildren();
        boolean bl2 = bl = viewModel != null && viewModel.is_renderBoundingBoxes();
        if (viewModel == null) {
            LogMessage logMessage = LOGGER.error(1024);
            logMessage.append("View is null in ContainerUI.paintContent! Use fallback!").log();
        }
        for (int i2 = 0; i2 < widgetModelArray.length; ++i2) {
            WidgetModel widgetModel = widgetModelArray[i2];
            widgetModel.getBounds(this.childBounds);
            this.childBounds.x += rectangle2.x;
            this.childBounds.y += rectangle2.y;
            if (AbstractWidget.DIRTY_REGION_MANAGEMENT) {
                if (!rectangle.intersects(this.childBounds)) continue;
                this.paintChild(graphics3D, viewModel, widgetModel, rectangle, this.childBounds, rectangle2, f2, bl);
                continue;
            }
            if (INTERSECT_CHILDREN && !rectangle2.intersects(this.childBounds)) continue;
            this.paintChild(graphics3D, viewModel, widgetModel, rectangle, this.childBounds, rectangle2, f2, bl);
            if (!INTERSECT_CHILDREN_HIGHLIGHT_ERRORS || rectangle2.contains(this.childBounds)) continue;
            this.paintBoundingBox(graphics3D, this.childBounds);
        }
    }

    protected void paintChild(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, Rectangle rectangle3, float f2, boolean bl) {
        float f3;
        if (widgetModel.isPaintable() && f2 > 0.0f && (f3 = f2 * AbstractWidgetUI.normalizeAlpha(widgetModel.get_alpha())) > 0.0f) {
            int n = rectangle2.x - rectangle3.x;
            int n2 = rectangle2.y - rectangle3.y;
            if (n != 0 || n2 != 0) {
                graphics3D.pushMatrix(0);
                if (AbstractWidget.CACHE_TRANSFORM) {
                    Transform transform = widgetModel.getGlobalTransform();
                    graphics3D.setViewTransformation(transform);
                } else {
                    graphics3D.translateMatrix(0, n, n2, 0.0f);
                }
            }
            widgetModel.paint(graphics3D, viewModel, rectangle, rectangle2, f3);
            if (!AbstractWidget.DIRTY_REGION_MANAGEMENT && (bl && !DEBUG_REPAINT || DEBUG_REPAINT && widgetModel.isDirty())) {
                this.paintBoundingBox(graphics3D, rectangle2);
            }
            if (n != 0 || n2 != 0) {
                graphics3D.popMatrix(0);
            }
        }
    }

    protected final void paintBoundingBox(Graphics3D graphics3D, Rectangle rectangle) {
        boolean bl = graphics3D.isScissorTestEnabled();
        graphics3D.setScissorTestEnabled(false);
        if (this.boundingBoxDrawable == null) {
            this.boundingBoxDrawable = graphics3D.getDrawableManager().createPolyLineDrawable();
            this.boundingBoxDrawable.setStrokeWidth(1.0f);
            this.boundingBoxDrawable.setClosed(true);
            this.boundingBoxDrawable.setAlpha(16447);
            this.boundingBoxDrawable.setColor(BOUNDINGBOX_COLOR);
        }
        Point2f point2f = new Point2f(0.0f, 0.0f);
        Point2f point2f2 = new Point2f((float)rectangle.width - 1.0f, 0.0f);
        Point2f point2f3 = new Point2f((float)rectangle.width - 1.0f, (float)rectangle.height - 1.0f);
        Point2f point2f4 = new Point2f(0.0f, (float)rectangle.height - 1.0f);
        this.boundingBoxDrawable.setCoordinates2D(new Point2f[]{point2f, point2f2, point2f3, point2f4});
        this.boundingBoxDrawable.draw();
        graphics3D.setScissorTestEnabled(bl);
    }

    protected final void updateOffscreenDrawables(Graphics3D graphics3D, ViewModel viewModel, ContainerModel containerModel, Rectangle rectangle, Rectangle rectangle2, int n) {
        boolean bl;
        boolean bl2 = bl = containerModel.getReflectionRenderMode() == 2;
        if (!bl) {
            boolean bl3 = graphics3D.isDepthTestEnabled();
            boolean bl4 = graphics3D.isAlphaTestEnabled();
            graphics3D.setAlphaTestEnabled(false);
            graphics3D.setDepthTestEnabled(false);
            if (containerModel.isRenderOffscreen()) {
                if (this.snapshotDecorator == null || !this.snapshotDecorator.isValid() || containerModel.isDirty()) {
                    this.snapshotDecorator = this.updateSnapshotDecoration(graphics3D, containerModel, rectangle, rectangle2, n, this.snapshotDecorator);
                }
            } else if (this.snapshotDecorator != null) {
                this.snapshotDecorator.dispose();
                this.snapshotDecorator = null;
            }
            if (containerModel.is_reflectionEnabled() && containerModel.get_reflectionAlphaImage() != null && !containerModel.get_reflectionAlphaImage().getCurrentImage().isEmpty()) {
                if (this.reflectionDecorator == null || !this.reflectionDecorator.isValid() || containerModel.isDirty()) {
                    this.reflectionDecorator = this.updateReflectionDecoration(graphics3D, containerModel, rectangle, rectangle2, n, this.reflectionDecorator);
                }
            } else if (this.reflectionDecorator != null) {
                this.reflectionDecorator.dispose();
                this.reflectionDecorator = null;
            }
            this.offscreenUpdatePerformed = true;
            graphics3D.setDepthTestEnabled(bl3);
            graphics3D.setAlphaTestEnabled(bl4);
        }
    }

    private EffectDecorator updateSnapshotDecoration(Graphics3D graphics3D, ContainerModel containerModel, Rectangle rectangle, Rectangle rectangle2, int n, EffectDecorator effectDecorator) {
        Insets insets = containerModel.getOffscreenInsets();
        boolean bl = containerModel.isDirty();
        if (effectDecorator == null) {
            bl = true;
            this.snapshotDecorationHelper = new ContainerUI$SnapshotDecorationHelper(this);
            effectDecorator = new EffectDecorator(this.snapshotDecorationHelper);
        }
        if (bl) {
            Decoratable$DecorationConfiguratior.configureDecoration(containerModel.getDecoration(), effectDecorator);
            effectDecorator.invalidate();
        }
        int n2 = rectangle2.width;
        int n3 = rectangle2.height;
        int n4 = insets != null ? insets.left : 0;
        int n5 = insets != null ? insets.top : 0;
        rectangle2.width = rectangle2.width + (insets != null ? insets.left + insets.right : 0);
        rectangle2.height = rectangle2.height + (insets != null ? insets.top + insets.bottom : 0);
        this.snapshotDecorationHelper.setAbsZ(n);
        this.snapshotDecorationHelper.setOffset(n4, n5);
        effectDecorator.create(graphics3D, rectangle, rectangle2);
        rectangle2.width = n2;
        rectangle2.height = n3;
        return effectDecorator;
    }

    private EffectDecorator updateReflectionDecoration(Graphics3D graphics3D, ContainerModel containerModel, Rectangle rectangle, Rectangle rectangle2, int n, EffectDecorator effectDecorator) {
        if (effectDecorator == null) {
            this.reflectionDecorationHelper = new ContainerUI$ReflectionDecorationHelper(this, graphics3D, rectangle2);
            effectDecorator = new EffectDecorator(this.reflectionDecorationHelper);
            effectDecorator.addNullDecoration();
        }
        if (containerModel.isDirty()) {
            effectDecorator.invalidate();
        }
        this.reflectionDecorationHelper.setAbsZ(n);
        effectDecorator.create(graphics3D, rectangle, rectangle2);
        return effectDecorator;
    }

    protected static final void paintAlphaMaskDrawable(Graphics3D graphics3D, ScaleImageDrawable scaleImageDrawable, int n, int n2, float f2) {
        int n3 = graphics3D.getBlendFactorSourceRGB();
        int n4 = graphics3D.getBlendFactorDestinationRGB();
        int n5 = graphics3D.getBlendFactorSourceAlpha();
        int n6 = graphics3D.getBlendFactorDestinationAlpha();
        graphics3D.setBlendFactorsSeparate(0, 6, 0, 6);
        if (!Util.equalsEpsilon(f2, 0.0f)) {
            graphics3D.pushMatrix(0);
            float f3 = (float)scaleImageDrawable.getWidth() / 2.0f;
            float f4 = (float)scaleImageDrawable.getWidth() / 2.0f;
            graphics3D.translateMatrix(0, (float)n + f3, (float)n2 + f4, 0.0f);
            graphics3D.rotateMatrix(0, f2, 0.0f, 0.0f, 1.0f);
            scaleImageDrawable.draw(-f3, -f4);
            graphics3D.popMatrix(0);
        } else {
            scaleImageDrawable.draw(n, n2);
        }
        graphics3D.setBlendFactorsSeparate(n3, n4, n5, n6);
    }

    static {
        BOUNDINGBOX_COLOR = Color4f.MAGENTA;
    }
}

