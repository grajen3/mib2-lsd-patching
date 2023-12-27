/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.collections.copyonwrite.CowList;
import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.ProximityEvent;
import de.vw.mib.event.TouchEvent;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.Point;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.math.Transform;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.pool.PooledObject;
import de.vw.mib.util.StringBuilder;
import de.vw.mib.widgets.AbstractWidget$1;
import de.vw.mib.widgets.AbstractWidget$2;
import de.vw.mib.widgets.AbstractWidget$3;
import de.vw.mib.widgets.AbstractWidget$4;
import de.vw.mib.widgets.AbstractWidget$AlphaValueAccessor;
import de.vw.mib.widgets.AbstractWidget$PropertyAnimation;
import de.vw.mib.widgets.AbstractWidget$PublicPropertyAnimation;
import de.vw.mib.widgets.AbstractWidget$VisibleAnimationNotifier;
import de.vw.mib.widgets.AbstractWidget$WidgetInternalAnimation;
import de.vw.mib.widgets.View;
import de.vw.mib.widgets.controller.WidgetController;
import de.vw.mib.widgets.event.PropertyChangedListener;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.WidgetUI;
import edu.emory.mathcs.backport.java.util.Arrays;
import java.util.List;

public abstract class AbstractWidget
implements WidgetModel,
PooledObject {
    protected static final boolean ANIMATIONS_ENABLED = System.getProperty("de.vw.mib.widgets.disableanimations") == null;
    private static final boolean DISABLE_PROPERTYCHANGE_MECHANISM = System.getProperty("de.vw.mib.widgets.disablepropertychange") != null;
    public static final boolean DIRTY_REGION_MANAGEMENT = System.getProperty("de.vw.mib.widgets.dirtyregions") != null;
    public static final boolean CACHE_TRANSFORM = System.getProperty("de.vw.mib.widgets.cachetransform") != null;
    private static final int DEFAULT_TARGETID;
    private static final String DEFAULT_NAME;
    protected static Logger LOGGER;
    private int targetId;
    private String name;
    short x;
    short y;
    short width;
    short height;
    short alpha;
    private EasingParams[] easing;
    private long internalStates;
    private WidgetController controller;
    private WidgetUI ui;
    private AbstractWidget parent;
    private ViewModel view;
    protected Transform localTransform;
    private Transform globalTransform;
    private CowList propertyChangedListeners;
    private static int paintStatisticsCounter;
    public static int transformStatisticsCounter;
    private static int repaintShadowCounter;
    private int propertyChangedShadowCounter;
    private Insets touchInsets;
    private AbstractWidget$VisibleAnimationNotifier visibleAnimationNotifier;
    private AbstractWidget$PublicPropertyAnimation translateXAnimation;
    private AbstractWidget$PublicPropertyAnimation translateYAnimation;
    private AbstractWidget$PublicPropertyAnimation scaleWidthAnimation;
    private AbstractWidget$PublicPropertyAnimation scaleHeightAnimation;
    AbstractWidget$PublicPropertyAnimation fadeAlphaAnimation;
    AbstractWidget$PublicPropertyAnimation fadeVisibleAnimation;
    AbstractWidget$PropertyAnimation fadeInVisibleAnimation;
    private AbstractWidget$AlphaValueAccessor alphaPropertyAccessor;

    protected AbstractWidget() {
        if (null == LOGGER) {
            LOGGER = ServiceManager.loggerFactory.getLogger(2048);
        }
        this.reset();
    }

    @Override
    public final void backToPool() {
        this.reset();
    }

    protected void reset() {
        this.targetId = 0;
        this.name = "<None>";
        this.x = 0;
        this.y = 0;
        this.width = 0;
        this.height = 0;
        this.alpha = 0;
        this.easing = null;
        this.internalStates = 0L;
        this.controller = null;
        this.ui = null;
        this.parent = null;
        this.localTransform = null;
        this.globalTransform = null;
        this.propertyChangedListeners = CowList.EMPTY;
        this.propertyChangedShadowCounter = 0;
        this.touchInsets = null;
    }

    public void init(boolean bl, int n, boolean bl2, EasingParams[] easingParamsArray, boolean bl3, int n2, boolean bl4, String string, int n3, Insets insets, boolean bl5, int n4, int n5, int n6) {
        this.targetId = n3;
        this.name = string;
        this.x = (short)n5;
        this.y = (short)n6;
        this.width = (short)n4;
        this.height = (short)n2;
        this.alpha = (short)n;
        this.easing = easingParamsArray;
        this.touchInsets = insets;
        this.setInternalStateFlag(3, bl2);
        this.setInternalStateFlag(0, bl);
        this.setInternalStateFlag(1, bl3);
        this.setInternalStateFlag(2, bl5);
        this.setInternalStateFlag(8, bl4);
        this.setInternalStateFlag(4, true);
        this.setInternalStateFlag(5, true);
    }

    @Override
    public void init(ViewModel viewModel) {
        this.setView(viewModel);
        if (this.controller != null) {
            this.controller.init();
        }
        if (this.ui != null) {
            this.ui.init();
        }
    }

    @Override
    public void deInit() {
        this.disableAnimations();
        if (this.controller != null) {
            this.controller.deInit();
        }
        if (this.ui != null) {
            this.ui.deInit();
        }
        this.propertyChangedListeners = CowList.EMPTY;
        this.enableAnimations();
        this.fadeAlphaAnimation = null;
        this.fadeVisibleAnimation = null;
        this.translateXAnimation = null;
        this.translateYAnimation = null;
        this.scaleWidthAnimation = null;
        this.scaleHeightAnimation = null;
        this.view = null;
    }

    @Override
    public void activate() {
        this.disableAnimations();
        if (this.controller != null) {
            this.controller.activate();
        }
        this.enableAnimations();
    }

    @Override
    public void deActivate() {
        this.disableAnimations();
        if (this.controller != null) {
            this.controller.deActivate();
        }
        this.enableAnimations();
    }

    public final String toString() {
        return this.getQualifiedName();
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return null;
    }

    @Override
    public final int get_targetId() {
        return this.targetId;
    }

    @Override
    public final void set_targetId(int n) {
        this.targetId = n;
    }

    @Override
    public final String get_name() {
        return this.name;
    }

    @Override
    public final void set_name(String string) {
        this.name = string;
    }

    @Override
    public final boolean is_activated() {
        return this.getInternalStateFlag(0);
    }

    @Override
    public final void set_activated(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(0);
        if (bl2 != bl) {
            this.setInternalStateFlag(0, bl);
            this.activatedChanged(bl2);
            this.propertyChanged(3);
        }
    }

    @Override
    public final boolean is_enabled() {
        return this.checkInternalStateMask(0);
    }

    @Override
    public final void set_enabled(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(1);
        if (bl2 != bl) {
            this.setInternalStateFlag(1, bl);
            this.enabledChanged(bl2);
            this.propertyChanged(4);
        }
    }

    @Override
    public final boolean is_availableInVariant() {
        return this.getInternalStateFlag(3);
    }

    @Override
    public final void set_availableInVariant(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(3);
        if (bl2 != bl) {
            this.setInternalStateFlag(3, bl);
            this.availableInVariantChanged(bl2);
            this.propertyChanged(6);
        }
    }

    @Override
    public final boolean is_visible() {
        return this.checkInternalStateMask(0);
    }

    @Override
    public final void set_visible(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(2);
        if (bl2 != bl) {
            this.setInternalStateFlag(2, bl);
            this.startFadeVisibleAnimation(bl);
            this.visibleChanged(bl2);
            this.propertyChanged(5);
        }
    }

    @Override
    public boolean is_layoutable() {
        return this.getInternalStateFlag(8);
    }

    @Override
    public void set_layoutable(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(8);
        if (bl2 != bl) {
            this.setInternalStateFlag(8, bl);
            this.layoutableChanged(bl2);
            this.propertyChanged(7);
        }
    }

    @Override
    public final int get_x() {
        return this.x;
    }

    @Override
    public final void set_x(int n) {
        short s = this.x;
        if (!this.startTranslateXAnimation(n) && s != n) {
            this.x = (short)n;
            this.xChanged(s);
            this.propertyChanged(8);
        }
    }

    @Override
    public final int get_y() {
        return this.y;
    }

    @Override
    public final void set_y(int n) {
        short s = this.y;
        if (!this.startTranslateYAnimation(n) && s != n) {
            this.y = (short)n;
            this.yChanged(s);
            this.propertyChanged(9);
        }
    }

    @Override
    public final int get_width() {
        return this.width;
    }

    @Override
    public final void set_width(int n) {
        short s = this.width;
        if (!this.startScaleWidthAnimation(n) && s != n) {
            this.width = (short)n;
            this.widthChanged(s);
            this.propertyChanged(10);
        }
    }

    @Override
    public final int get_height() {
        return this.height;
    }

    @Override
    public final void set_height(int n) {
        short s = this.height;
        if (!this.startScaleHeightAnimation(n) && s != n) {
            this.height = (short)n;
            this.heightChanged(s);
            this.propertyChanged(11);
        }
    }

    @Override
    public final int get_alpha() {
        return this.alpha;
    }

    @Override
    public final void set_alpha(int n) {
        short s = this.alpha;
        if (!this.startFadeAlphaAnimation(n) && s != n) {
            this.alpha = (short)n;
            this.alphaChanged(s);
            this.propertyChanged(12);
        }
    }

    @Override
    public final EasingParams[] get_easing() {
        return this.easing;
    }

    @Override
    public final void set_easing(EasingParams[] easingParamsArray) {
        Object[] objectArray = this.easing;
        if (!Arrays.equals(objectArray, easingParamsArray)) {
            this.easing = easingParamsArray;
            this.easingChanged((EasingParams[])objectArray);
            this.propertyChanged(13);
        }
    }

    @Override
    public final Insets get_touchInsets() {
        return this.touchInsets;
    }

    @Override
    public final void set_touchInsets(Insets insets) {
        Insets insets2 = this.touchInsets;
        if (insets2 != insets) {
            this.touchInsets = insets;
            this.touchInsetsChanged(insets2);
            this.propertyChanged(14);
        }
    }

    @Override
    public final WidgetController getController() {
        return this.controller;
    }

    @Override
    public final void setController(WidgetController widgetController) {
        if (widgetController != null) {
            widgetController.setWidget(this);
            this.controller = widgetController;
        }
    }

    @Override
    public final WidgetUI getUI() {
        return this.ui;
    }

    @Override
    public final void setUI(WidgetUI widgetUI) {
        if (widgetUI != null) {
            widgetUI.setWidget(this);
            this.ui = widgetUI;
        }
    }

    @Override
    public final WidgetModel getParent() {
        return this.parent;
    }

    public final void setParent(AbstractWidget abstractWidget) {
        this.parent = abstractWidget;
    }

    @Override
    public ViewModel getView() {
        return this.view;
    }

    public final void setView(ViewModel viewModel) {
        this.view = viewModel;
    }

    @Override
    public final String getQualifiedName() {
        StringBuilder stringBuilder = new StringBuilder();
        WidgetModel widgetModel = this;
        do {
            stringBuilder.insert(0, widgetModel.get_name());
            widgetModel = widgetModel.getParent();
            if (widgetModel == null) continue;
            stringBuilder.insert(0, '.');
        } while (widgetModel != null);
        return stringBuilder.toString();
    }

    protected final void setInternalStateFlag(int n, boolean bl) {
        this.internalStates = this.internalStates & (1L << n ^ 0xFFFFFFFFFFFFFFFFL) | (bl ? 1L : 0L) << n;
    }

    protected final void setInternalStateMask(long l, long l2) {
        this.internalStates = this.internalStates & (l ^ 0xFFFFFFFFFFFFFFFFL) | l & l2;
    }

    protected final boolean getInternalStateFlag(int n) {
        return (this.internalStates & 1L << n) != 0L;
    }

    protected final boolean checkInternalStateMask(long l) {
        return (this.internalStates & l) == l;
    }

    @Override
    public boolean canConsumeHMIEvents() {
        return this.is_enabled();
    }

    @Override
    public void setAnimationBlockingEnabled(boolean bl) {
    }

    protected void activatedChanged(boolean bl) {
    }

    protected void enabledChanged(boolean bl) {
    }

    protected void availableInVariantChanged(boolean bl) {
        this.propertyChanged(5);
    }

    protected void visibleChanged(boolean bl) {
        this.repaintParent();
    }

    protected void layoutableChanged(boolean bl) {
        this.repaintParent();
    }

    protected void parentVisibilityChanged(boolean bl) {
        this.repaintParent();
    }

    protected void xChanged(int n) {
        this.invalidateLocalTransform();
        if (DIRTY_REGION_MANAGEMENT) {
            Rectangle rectangle = new Rectangle(n, this.y, this.width, this.height);
            Rectangle rectangle2 = new Rectangle(this.x, this.y, this.width, this.height);
            if (rectangle.intersects(rectangle2)) {
                Rectangle rectangle3 = rectangle.union(rectangle2);
                this.repaint(rectangle3.x, rectangle3.y, rectangle3.width, rectangle3.height);
            } else {
                this.repaint(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
                this.repaint(rectangle2.x, rectangle2.y, rectangle2.width, rectangle2.height);
            }
        } else {
            this.repaintParent();
        }
    }

    protected void yChanged(int n) {
        this.invalidateLocalTransform();
        if (DIRTY_REGION_MANAGEMENT) {
            Rectangle rectangle = new Rectangle(this.x, n, this.width, this.height);
            Rectangle rectangle2 = new Rectangle(this.x, this.y, this.width, this.height);
            if (rectangle.intersects(rectangle2)) {
                Rectangle rectangle3 = rectangle.union(rectangle2);
                this.repaint(rectangle3.x, rectangle3.y, rectangle3.width, rectangle3.height);
            } else {
                this.repaint(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
                this.repaint(rectangle2.x, rectangle2.y, rectangle2.width, rectangle2.height);
            }
        } else {
            this.repaintParent();
        }
    }

    protected void widthChanged(int n) {
        if (DIRTY_REGION_MANAGEMENT) {
            this.repaint(this.x, this.y, Math.max(this.width, n), this.height);
        } else {
            this.repaint();
        }
    }

    protected void heightChanged(int n) {
        if (DIRTY_REGION_MANAGEMENT) {
            this.repaint(this.x, this.y, this.width, Math.max(this.height, n));
        } else {
            this.repaint();
        }
    }

    protected void alphaChanged(int n) {
        this.repaintParent();
    }

    protected void easingChanged(EasingParams[] easingParamsArray) {
    }

    protected void touchInsetsChanged(Insets insets) {
    }

    @Override
    public final void addPropertyChangedListener(PropertyChangedListener propertyChangedListener) {
        this.propertyChangedListeners = this.propertyChangedListeners.addIfAbsent(propertyChangedListener);
    }

    @Override
    public final void removePropertyChangedListener(PropertyChangedListener propertyChangedListener) {
        this.propertyChangedListeners = this.propertyChangedListeners.remove(propertyChangedListener);
    }

    protected final void propertyChanged(int n) {
        if (DISABLE_PROPERTYCHANGE_MECHANISM || this.propertyChangedShadowCounter == 0) {
            this.disablePropertyChanged();
            for (CowList cowList = this.propertyChangedListeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
                PropertyChangedListener propertyChangedListener = (PropertyChangedListener)cowList.head();
                propertyChangedListener.propertyChanged(this, n);
            }
            this.enablePropertyChanged();
        }
    }

    @Override
    public final void disablePropertyChanged() {
        ++this.propertyChangedShadowCounter;
    }

    @Override
    public final void enablePropertyChanged() {
        --this.propertyChangedShadowCounter;
    }

    protected void invalidateLocalTransform() {
        this.setInternalStateFlag(6, false);
        this.setInternalStateFlag(7, false);
    }

    @Override
    public final Transform getLocalTransform() {
        if (!this.getInternalStateFlag(6)) {
            if (this.localTransform == null) {
                this.localTransform = new Transform();
            }
            this.updateLocalTransform();
            this.setInternalStateFlag(6, true);
            this.setInternalStateFlag(7, false);
        }
        return this.localTransform;
    }

    protected final void setLocalTransform(Transform transform) {
        this.getLocalTransform().set(transform);
        this.setInternalStateFlag(6, true);
        this.setInternalStateFlag(7, false);
    }

    /*
     * Handled unverifiable bytecode (illegal stack merge).
     */
    protected void updateLocalTransform() {
        this.localTransform.setTranslation(this.x, this.y, this.getParent() != null ? 0.0f : (float)4201669);
    }

    protected void invalidateGlobalTransform() {
        this.setInternalStateFlag(7, false);
    }

    @Override
    public final Transform getGlobalTransform() {
        if (!this.getInternalStateFlag(7)) {
            if (this.globalTransform == null) {
                this.globalTransform = new Transform();
            }
            this.updateGlobalTransform();
            this.setInternalStateFlag(7, true);
        }
        return this.globalTransform;
    }

    public final void setGlobalTransform(Transform transform) {
        this.globalTransform.set(transform);
        this.setInternalStateFlag(7, true);
    }

    private void updateGlobalTransform() {
        Transform transform = this.getLocalTransform();
        WidgetModel widgetModel = this.getParent();
        if (widgetModel != null) {
            Transform transform2 = widgetModel.getGlobalTransform();
            transform2.transform(transform, this.globalTransform);
            ++transformStatisticsCounter;
        } else {
            this.globalTransform.set(transform);
        }
    }

    public static final int getTransformStatisticsCounter() {
        return transformStatisticsCounter;
    }

    public static final void clearTransformStatisticsCounter() {
        transformStatisticsCounter = 0;
    }

    @Override
    public int getAbsAlpha() {
        int n = this.alpha;
        AbstractWidget abstractWidget = this.parent;
        while (abstractWidget != null) {
            n = (int)((float)(n * abstractWidget.alpha) / 32579);
            abstractWidget = abstractWidget.parent;
        }
        return n;
    }

    @Override
    public final int getAbsX() {
        int n = this.x;
        AbstractWidget abstractWidget = this.parent;
        while (abstractWidget != null) {
            n += abstractWidget.x;
            abstractWidget = abstractWidget.parent;
        }
        return n;
    }

    @Override
    public final int getAbsY() {
        int n = this.y;
        AbstractWidget abstractWidget = this.parent;
        while (abstractWidget != null) {
            n += abstractWidget.y;
            abstractWidget = abstractWidget.parent;
        }
        return n;
    }

    @Override
    public int getAbsZ() {
        return this.parent == null ? 0 : this.parent.getAbsZ();
    }

    @Override
    public final void getBounds(Rectangle rectangle) {
        rectangle.setBounds(this.x, this.y, this.width, this.height);
    }

    protected final void setBounds(Rectangle rectangle) {
        this.disableAnimations();
        this.set_x(rectangle.x);
        this.set_y(rectangle.y);
        this.set_width(rectangle.width);
        this.set_height(rectangle.height);
        this.enableAnimations();
    }

    @Override
    public final void getAbsBounds(Rectangle rectangle) {
        rectangle.setBounds(this.getAbsX(), this.getAbsY(), this.width, this.height);
    }

    @Override
    public final boolean isPointInside(int n, int n2, int n3) {
        int n4 = -n3;
        int n5 = -n3;
        int n6 = -n3;
        int n7 = -n3;
        Insets insets = this.get_touchInsets();
        if (insets != null) {
            n4 += insets.left;
            n5 += insets.right;
            n6 += insets.top;
            n7 += insets.bottom;
        }
        return n >= this.x + n4 && n < this.x + this.width - n5 && n2 >= this.y + n6 && n2 < this.y + this.height - n7;
    }

    @Override
    public final boolean isPointInside(int n, int n2) {
        return this.isPointInside(n, n2, 0);
    }

    @Override
    public final boolean isAbsPointInside(int n, int n2) {
        return this.isAbsPointInside(n, n2, 0);
    }

    @Override
    public boolean isAbsPointInside(int n, int n2, int n3) {
        return this.isPointInside(n + this.get_x() - this.getAbsX(), n2 + this.get_y() - this.getAbsY(), n3);
    }

    @Override
    public final boolean areParentsEnabled() {
        AbstractWidget abstractWidget = this.parent;
        while (abstractWidget != null) {
            if (!abstractWidget.is_enabled()) {
                return false;
            }
            abstractWidget = abstractWidget.parent;
        }
        return true;
    }

    @Override
    public final boolean areParentsVisible() {
        AbstractWidget abstractWidget = this.parent;
        while (abstractWidget != null) {
            if (!abstractWidget.is_visible()) {
                return false;
            }
            abstractWidget = abstractWidget.parent;
        }
        return true;
    }

    @Override
    public final boolean canParentsConsumeHMIEvents() {
        AbstractWidget abstractWidget = this.parent;
        while (abstractWidget != null) {
            if (!abstractWidget.canConsumeHMIEvents()) {
                return false;
            }
            abstractWidget = abstractWidget.parent;
        }
        return true;
    }

    @Override
    public void calculateBoundingBox(int n, int n2, Point point, Point point2) {
        if (this.getUI() == null || !this.is_visible()) {
            return;
        }
        int n3 = n + this.x;
        int n4 = n2 + this.y;
        point.x = Math.min(n3, point.x);
        point.y = Math.min(n4, point.y);
        point2.x = Math.max(n3 + this.width, point2.x);
        point2.y = Math.max(n4 + this.height, point2.y);
    }

    @Override
    public final boolean isDirty() {
        return this.getInternalStateFlag(4);
    }

    private void setDirty(boolean bl) {
        this.setInternalStateFlag(4, bl);
    }

    @Override
    public final boolean isInvalid() {
        return this.getInternalStateFlag(5);
    }

    private void setInvalid(boolean bl) {
        this.setInternalStateFlag(5, bl);
    }

    @Override
    public void invalidate() {
        this.setInternalStateMask(0, 0);
    }

    @Override
    public final boolean isPaintable() {
        return this.ui != null && (this.is_visible() || this.isVisibleRelevantAnimationRunning()) && this.width > 0 && this.height > 0;
    }

    @Override
    public final void paint(Graphics3D graphics3D, ViewModel viewModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        boolean bl = LOGGER.isTraceEnabled(2048) && LOGGER.isTraceEnabled(64);
        boolean bl2 = LOGGER.isTraceEnabled(2048) && LOGGER.isTraceEnabled(128);
        long l = bl2 ? ServiceManager.timerManager.getSystemTimeMicros() : 0L;
        AbstractWidget.disableRepaints();
        this.ui.paint(graphics3D, viewModel, this, rectangle, rectangle2, f2);
        this.setInternalStateMask(0, 0L);
        AbstractWidget.enableRepaints();
        if (bl || bl2) {
            long l2 = bl2 ? ServiceManager.timerManager.getSystemTimeMicros() : 0L;
            LogMessage logMessage = LOGGER.trace(2048);
            logMessage.append(this.getQualifiedName()).append(" (").append(super.getClass()).append(").paint(clipArea=").append(rectangle).append(", absBounds=").append(rectangle2).append(", alpha=").append(f2).append(")");
            if (bl2) {
                logMessage.append(": ");
                logMessage.append(l2 - l).append("\u00b5s");
            }
            logMessage.log();
        }
        ++paintStatisticsCounter;
    }

    private boolean markHierarchyDirty() {
        boolean bl = false;
        AbstractWidget abstractWidget = this;
        do {
            LogMessage logMessage;
            if (!abstractWidget.isDirty()) {
                abstractWidget.setDirty(true);
            }
            if (abstractWidget.isPaintable()) {
                abstractWidget = abstractWidget.parent;
                if (abstractWidget != null) continue;
                if (AbstractWidget.areRepaintsEnabled()) {
                    bl = true;
                    continue;
                }
                if (!LOGGER.isTraceEnabled(2048)) continue;
                logMessage = LOGGER.trace(2048);
                logMessage.append(this.getQualifiedName()).append(".markHierarchyDirty() early out due to disabled repaints");
                logMessage.log();
                continue;
            }
            if (!LOGGER.isTraceEnabled(2048)) break;
            logMessage = LOGGER.trace(2048);
            logMessage.append(this.getQualifiedName()).append(".markHierarchyDirty() early out due to parent not paintable");
            logMessage.log();
            break;
        } while (abstractWidget != null);
        return bl;
    }

    protected Rectangle markHierarchyDirtyDRM(int n, int n2, int n3, int n4) {
        Rectangle rectangle = new Rectangle(n, n2, n3, n4);
        AbstractWidget abstractWidget = this;
        do {
            if (!abstractWidget.isDirty()) {
                abstractWidget.setDirty(true);
            }
            if (!abstractWidget.isPaintable()) break;
            abstractWidget = abstractWidget.parent;
            if (abstractWidget != null) {
                n += abstractWidget.x;
                n2 += abstractWidget.y;
                continue;
            }
            if (AbstractWidget.areRepaintsEnabled()) {
                rectangle = new Rectangle(n, n2, n3, n4);
                continue;
            }
            if (!LOGGER.isTraceEnabled(2048)) continue;
            LogMessage logMessage = LOGGER.trace(2048);
            logMessage.append(this.getQualifiedName()).append(".repaint() early out due to disabled repaints");
            logMessage.log();
        } while (abstractWidget != null);
        return rectangle;
    }

    private void repaint(int n, int n2, int n3, int n4) {
        Object object;
        boolean bl = false;
        this.setInvalid(true);
        if (DIRTY_REGION_MANAGEMENT) {
            object = this.markHierarchyDirtyDRM(n, n2, n3, n4);
            if (object != null) {
                boolean bl2 = false;
                boolean bl3 = false;
                if (!bl3) {
                    if (this.view != null) {
                        ((View)this.view).dirtyRegions.add(object);
                    }
                    if (LOGGER.isTraceEnabled(2048)) {
                        LogMessage logMessage = LOGGER.trace(2048);
                        logMessage.append(this.getQualifiedName()).append(".repaint(").append(n).append(",").append(n2).append(",").append(n3).append(",").append(n4).append(") added dirty region ").append(object);
                        logMessage.log();
                    }
                } else if (LOGGER.isTraceEnabled(2048)) {
                    LogMessage logMessage = LOGGER.trace(2048);
                    logMessage.append(this.getQualifiedName()).append(".repaint(").append(n).append(", ").append(n2).append(", ").append(n3).append(", ").append(n4).append(") late out due to duplicate dirty region");
                    logMessage.log();
                }
                bl = true;
            }
        } else {
            bl = this.markHierarchyDirty();
        }
        if (bl) {
            if (ServiceManager.repaintManager != null) {
                if (LOGGER.isTraceEnabled(2048)) {
                    object = LOGGER.trace(2048);
                    object.append(this.getQualifiedName()).append(".repaint(").append(n).append(",").append(n2).append(",").append(n3).append(",").append(n4).append(") in hierarchy valid: triggering RepaintManager.repaint()");
                    object.log();
                }
                ServiceManager.repaintManager.repaint();
            } else {
                LOGGER.error(1, "No RepaintManager registered");
            }
        } else if (LOGGER.isTraceEnabled(2048)) {
            object = LOGGER.trace(2048);
            object.append(this.getQualifiedName()).append(".repaint() in hierarchy not valid: early out due to at least one invisible parent");
            object.log();
        }
    }

    @Override
    public final void repaint() {
        if (LOGGER.isTraceEnabled(2048)) {
            LogMessage logMessage = LOGGER.trace(2048);
            logMessage.append(this.getQualifiedName()).append(".repaint(").append(this.getAbsX()).append(",").append(this.getAbsY()).append(",").append(this.get_width()).append(",").append(this.get_height()).append(") requested by widget");
            logMessage.log();
        }
        this.repaint(this.x, this.y, this.width, this.height);
    }

    protected final void repaintParent() {
        if (this.parent != null) {
            this.parent.repaint();
        } else {
            this.repaint();
        }
    }

    public static final int getPaintStatisticsCounter() {
        return paintStatisticsCounter;
    }

    public static final void clearPaintStatisticsCounter() {
        paintStatisticsCounter = 0;
    }

    private static void enableRepaints() {
        --repaintShadowCounter;
    }

    private static void disableRepaints() {
        ++repaintShadowCounter;
    }

    public static final boolean areRepaintsEnabled() {
        return repaintShadowCounter == 0;
    }

    public static final void resetRepaintsEnabled() {
        repaintShadowCounter = 0;
    }

    @Override
    public final boolean consumeHMIEvent(HMIEvent hMIEvent, String string) {
        if (this.controller != null && this.canConsumeHMIEvents() && this.canParentsConsumeHMIEvents()) {
            return this.controller.consumeHMIEvent(hMIEvent, string);
        }
        return false;
    }

    @Override
    public final boolean consumeTouchEvent(TouchEvent touchEvent) {
        if (this.controller != null && this.is_enabled() && this.is_visible() && this.get_alpha() > 0) {
            return this.controller.consumeTouchEvent(touchEvent);
        }
        return false;
    }

    @Override
    public final boolean consumeProximityEvent(ProximityEvent proximityEvent) {
        if (this.controller != null && this.is_enabled() && this.is_visible() && this.get_alpha() > 0) {
            return this.controller.consumeProximityEvent(proximityEvent);
        }
        return false;
    }

    @Override
    public void findTouchEventConsumingWidgets(List list, int n, int n2) {
    }

    @Override
    public final void findTouchEventConsumingWidgets(List list, TouchEvent touchEvent) {
        this.findTouchEventConsumingWidgets(list, touchEvent.getX(), touchEvent.getY());
    }

    @Override
    public boolean isVisibleRelevantAnimationRunning() {
        return this.fadeVisibleAnimation != null && this.fadeVisibleAnimation.isActive() || this.fadeInVisibleAnimation != null && this.fadeInVisibleAnimation.isActive();
    }

    @Override
    public void stopInternalAnimations() {
        this.stopInternalAnimation(this.translateXAnimation);
        this.stopInternalAnimation(this.translateYAnimation);
        this.stopInternalAnimation(this.scaleWidthAnimation);
        this.stopInternalAnimation(this.scaleHeightAnimation);
        this.stopInternalAnimation(this.fadeAlphaAnimation);
        this.stopFadeVisibleAnimation();
    }

    private void stopFadeVisibleAnimation() {
        if (this.fadeVisibleAnimation != null) {
            this.stopInternalAnimation(this.fadeVisibleAnimation);
            this.fadeVisibleAnimation = null;
        }
    }

    private boolean startTranslateXAnimation(int n) {
        if (this.translateXAnimation == null && this.isEasingAvailable(0)) {
            this.translateXAnimation = new AbstractWidget$PublicPropertyAnimation(this, 0, 8, new AbstractWidget$1(this));
        }
        return this.startPropertyAnimation(this.translateXAnimation, n);
    }

    private boolean startTranslateYAnimation(int n) {
        if (this.translateYAnimation == null && this.isEasingAvailable(1)) {
            this.translateYAnimation = new AbstractWidget$PublicPropertyAnimation(this, 1, 9, new AbstractWidget$2(this));
        }
        return this.startPropertyAnimation(this.translateYAnimation, n);
    }

    private boolean startScaleWidthAnimation(int n) {
        if (this.scaleWidthAnimation == null && this.isEasingAvailable(2)) {
            this.scaleWidthAnimation = new AbstractWidget$PublicPropertyAnimation(this, 2, 10, new AbstractWidget$3(this));
        }
        return this.startPropertyAnimation(this.scaleWidthAnimation, n);
    }

    private boolean startScaleHeightAnimation(int n) {
        if (this.scaleHeightAnimation == null && this.isEasingAvailable(3)) {
            this.scaleHeightAnimation = new AbstractWidget$PublicPropertyAnimation(this, 3, 11, new AbstractWidget$4(this));
        }
        return this.startPropertyAnimation(this.scaleHeightAnimation, n);
    }

    private boolean startFadeAlphaAnimation(int n) {
        this.stopInternalAnimation(this.fadeInVisibleAnimation);
        this.stopInternalAnimation(this.fadeVisibleAnimation);
        if (this.fadeAlphaAnimation == null && this.isEasingAvailable(4)) {
            this.fadeAlphaAnimation = new AbstractWidget$PublicPropertyAnimation(this, 4, 12, this.getAlphaValueAccessor());
        }
        return this.startPropertyAnimation(this.fadeAlphaAnimation, n);
    }

    private boolean startFadeVisibleAnimation(boolean bl) {
        this.stopInternalAnimation(this.fadeAlphaAnimation);
        if (bl) {
            if (this.fadeInVisibleAnimation != null && this.fadeInVisibleAnimation.isActive()) {
                this.stopInternalAnimation(this.fadeInVisibleAnimation);
            }
            if (this.fadeVisibleAnimation == null && this.isEasingAvailable(5)) {
                this.fadeVisibleAnimation = new AbstractWidget$PublicPropertyAnimation(this, 5, 5, this.getAlphaValueAccessor());
            }
            return this.startPropertyAnimation(this.fadeVisibleAnimation, 0.0f, this.alpha, true);
        }
        short s = this.alpha;
        AbstractWidget$AlphaValueAccessor abstractWidget$AlphaValueAccessor = this.getAlphaValueAccessor();
        if (this.fadeVisibleAnimation != null && this.fadeVisibleAnimation.isActive()) {
            this.stopInternalAnimation(this.fadeVisibleAnimation);
        }
        if (this.fadeInVisibleAnimation == null && this.isEasingAvailable(6)) {
            this.fadeInVisibleAnimation = new AbstractWidget$PublicPropertyAnimation(this, 6, 5, abstractWidget$AlphaValueAccessor);
            this.fadeInVisibleAnimation.addAnimationListener(abstractWidget$AlphaValueAccessor);
        }
        abstractWidget$AlphaValueAccessor.setOriginalValue(this.alpha);
        return this.startPropertyAnimation(this.fadeInVisibleAnimation, s, 0.0f, true);
    }

    private AbstractWidget$AlphaValueAccessor getAlphaValueAccessor() {
        if (this.alphaPropertyAccessor == null) {
            this.alphaPropertyAccessor = new AbstractWidget$AlphaValueAccessor(this);
        }
        return this.alphaPropertyAccessor;
    }

    @Override
    public void enableAnimations() {
        if (this.view != null) {
            this.view.enableAnimations();
        }
    }

    @Override
    public void disableAnimations() {
        if (this.view != null) {
            this.view.disableAnimations();
        }
    }

    @Override
    public boolean areAnimationsEnabled() {
        return this.view != null && this.view.areAnimationsEnabled();
    }

    @Override
    public void resetAnimationsEnabled() {
        if (this.view != null) {
            this.view.resetAnimationsEnabled();
        }
    }

    protected final EasingParams getEasing(int n) {
        EasingParams[] easingParamsArray = this.get_easing();
        return !this.areAnimationsEnabled() || easingParamsArray == null || easingParamsArray.length <= n || !AbstractWidget.isEasingValid(easingParamsArray[n]) ? null : easingParamsArray[n];
    }

    protected static boolean isEasingValid(EasingParams easingParams) {
        return easingParams != null && easingParams.getEasingClass() != 0 && easingParams.getDuration() != 0;
    }

    protected final boolean isEasingAvailable(int n) {
        return this.easing != null && this.easing.length > n && this.easing[n] != null && this.easing[n].getEasingClass() != 0;
    }

    protected final boolean startInternalAnimation(AbstractWidget$WidgetInternalAnimation abstractWidget$WidgetInternalAnimation) {
        return this.startInternalAnimation(abstractWidget$WidgetInternalAnimation, false);
    }

    protected final boolean startInternalAnimation(AbstractWidget$WidgetInternalAnimation abstractWidget$WidgetInternalAnimation, boolean bl) {
        if (this.areAnimationsEnabled() && this.areParentsVisible() && this.is_availableInVariant() && (bl || this.is_visible() || this.isVisibleRelevantAnimationRunning())) {
            if (bl) {
                if (this.visibleAnimationNotifier == null) {
                    this.visibleAnimationNotifier = new AbstractWidget$VisibleAnimationNotifier(this);
                }
                abstractWidget$WidgetInternalAnimation.addAnimationListener(this.visibleAnimationNotifier);
            }
            ServiceManager.animationManager.startAnimation(abstractWidget$WidgetInternalAnimation);
            if (LOGGER.isTraceEnabled(1) && LOGGER.isTraceEnabled(8192)) {
                LOGGER.trace(1).append("Widget '").append(this.getQualifiedName()).append("': Starting internal animation ").append(super.getClass().getName()).log();
            }
            return true;
        }
        return false;
    }

    protected final boolean startPropertyAnimation(AbstractWidget$PropertyAnimation abstractWidget$PropertyAnimation, float f2, float f3, boolean bl) {
        if (abstractWidget$PropertyAnimation != null) {
            return abstractWidget$PropertyAnimation.startAnimation(f2, f3, bl);
        }
        return false;
    }

    protected final boolean startPropertyAnimation(AbstractWidget$PropertyAnimation abstractWidget$PropertyAnimation, float f2) {
        if (abstractWidget$PropertyAnimation != null) {
            return abstractWidget$PropertyAnimation.startAnimation(f2);
        }
        return false;
    }

    protected final void stopInternalAnimation(AbstractWidget$WidgetInternalAnimation abstractWidget$WidgetInternalAnimation) {
        ServiceManager.animationManager.stopAnimation(abstractWidget$WidgetInternalAnimation);
    }
}

