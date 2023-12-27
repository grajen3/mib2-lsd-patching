/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.animations.KeyframeAnimation;
import de.vw.mib.animation.control.AnimatedPropertiesAccessor;
import de.vw.mib.animation.control.AnimationListener;
import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.collections.copyonwrite.CowList;
import de.vw.mib.event.dispatcher.apps.ViewEventDispatcher;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.Point;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.properties.values.LayoutAttribs;
import de.vw.mib.widgets.AbstractWidget;
import de.vw.mib.widgets.ScreenArea;
import de.vw.mib.widgets.TransformContainer;
import de.vw.mib.widgets.event.ViewChangedListener;
import de.vw.mib.widgets.models.ScreenModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class View
extends TransformContainer
implements ViewModel {
    private static final boolean ALWAYS_RENDER_BOUNDING_BOXES;
    private Color colorBackground;
    private KeyframeAnimation[] enterAnimations;
    private KeyframeAnimation[] leaveAnimations;
    private int[] viewTypes;
    private int viewTypeSelection;
    private int touchForwardingMode;
    private CowList viewChangedListeners;
    private Point pointerPosition;
    private int runningEnterAnimationId;
    private int runningLeaveAnimationId;
    public List dirtyRegions;
    private int animationShadowCounter = -129;
    private CowList proximityConsumers;
    private ScreenArea[] screenAreas;
    private ViewEventDispatcher viewEventDispatcher;
    protected boolean animationBlockingEnabled;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$ViewUI;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$widgets$View;

    @Override
    protected void reset() {
        super.reset();
        this.viewChangedListeners = CowList.EMPTY;
        this.proximityConsumers = CowList.EMPTY;
        this.colorBackground = null;
        this.enterAnimations = null;
        this.leaveAnimations = null;
        this.runningEnterAnimationId = -1;
        this.runningLeaveAnimationId = -1;
        if (AbstractWidget.DIRTY_REGION_MANAGEMENT) {
            if (this.dirtyRegions == null) {
                this.dirtyRegions = new ArrayList();
            } else {
                this.dirtyRegions.clear();
            }
        }
        this.screenAreas = null;
        this.viewEventDispatcher = null;
        this.animationBlockingEnabled = false;
    }

    public void init(boolean bl, int n, Image image, boolean bl2, float f2, boolean bl3, Color color, int n2, int n3, EasingParams[] easingParamsArray, boolean bl4, KeyframeAnimation[] keyframeAnimationArray, int n4, KeyframeAnimation[] keyframeAnimationArray2, boolean bl5, LayoutAttribs layoutAttribs, KeyframeAnimation[] keyframeAnimationArray3, String string, boolean bl6, float f3, float f4, float f5, float f6, float f7, float f8, int n5, int n6, Image image2, int n7, boolean bl7, boolean bl8, boolean bl9, float f9, float f10, float f11, float f12, float f13, float f14, int n8, int n9, Insets insets, int[] nArray, int n10, boolean bl10, int n11, int n12, int n13, int n14) {
        super.init(bl, n, image, bl2, f2, bl3, n2, n3, easingParamsArray, bl4, n4, keyframeAnimationArray2, bl5, layoutAttribs, string, f3, f4, f5, f6, f7, f8, n5, n6, image2, n7, bl7, f9, f10, f11, f12, f13, f14, n8, insets, bl10, n11, n12, n13, n14);
        this.colorBackground = color;
        this.enterAnimations = keyframeAnimationArray;
        this.leaveAnimations = keyframeAnimationArray3;
        this.viewTypes = nArray;
        this.viewTypeSelection = n10;
        this.touchForwardingMode = n9;
        this.setInternalStateFlag(18, bl8);
        this.setInternalStateFlag(19, bl9);
        this.runningLeaveAnimationId = -1;
        this.runningEnterAnimationId = -1;
        this.setInternalStateFlag(20, bl6);
        if (LOGGER.isTraceEnabled(1024)) {
            LogMessage logMessage = LOGGER.trace(1024);
            logMessage.append("View ").append(this.toString()).append(": view.init(parameter) finished").log();
        }
    }

    public void init(boolean bl, int n, Image image, boolean bl2, boolean bl3, Color color, int n2, int n3, EasingParams[] easingParamsArray, boolean bl4, KeyframeAnimation[] keyframeAnimationArray, int n4, KeyframeAnimation[] keyframeAnimationArray2, boolean bl5, LayoutAttribs layoutAttribs, KeyframeAnimation[] keyframeAnimationArray3, String string, boolean bl6, float f2, float f3, float f4, float f5, float f6, float f7, int n5, int n6, Image image2, int n7, boolean bl7, boolean bl8, boolean bl9, float f8, float f9, float f10, float f11, float f12, float f13, int n8, int n9, Insets insets, int[] nArray, int n10, boolean bl10, int n11, int n12, int n13, int n14) {
        this.init(bl, n, image, bl2, 0.0f, bl3, color, n2, n3, easingParamsArray, bl4, keyframeAnimationArray, n4, keyframeAnimationArray2, bl5, layoutAttribs, keyframeAnimationArray3, string, bl6, f2, f3, f4, f5, f6, f7, n5, n6, image2, n7, bl7, bl8, bl9, f8, f9, f10, f11, f12, f13, n8, n9, insets, nArray, n10, bl10, n11, n12, n13, n14);
    }

    @Override
    public void init() {
        this.init(this);
    }

    @Override
    public final int get_projectionType() {
        return 3;
    }

    @Override
    public void init(ViewModel viewModel) {
        this.set_activated(false);
        super.init(this);
        if (this.getParent() != null && this.getParent().getView() != null) {
            this.getParent().getView().addProximityConsumer(this);
        }
        if (LOGGER.isTraceEnabled(1024)) {
            LogMessage logMessage = LOGGER.trace(1024);
            logMessage.append("View '").append(this.toString()).append("': view.init() finished").log();
        }
        this.onInit();
    }

    @Override
    public void deInit() {
        this.stopInternalAnimations();
        if (this.getParent() != null && this.getParent().getView() != null) {
            this.getParent().getView().removeProximityConsumer(this);
        }
        super.deInit();
        if (LOGGER.isTraceEnabled(1024)) {
            LogMessage logMessage = LOGGER.trace(1024);
            logMessage.append("View '").append(this.toString()).append("': view.deInit() finished").log();
        }
    }

    @Override
    public void activate() {
        this.set_activated(true);
        this.resetAnimationsEnabled();
        super.activate();
        if (LOGGER.isTraceEnabled(1024)) {
            LogMessage logMessage = LOGGER.trace(1024);
            logMessage.append("View '").append(this.toString()).append("': view.activate() finished").log();
        }
    }

    @Override
    public void deActivate() {
        this.set_activated(false);
        this.disableAnimations();
        super.deActivate();
        if (LOGGER.isTraceEnabled(1024)) {
            LogMessage logMessage = LOGGER.trace(1024);
            logMessage.append("View '").append(this.toString()).append("': view.deActivate() finished").log();
        }
    }

    @Override
    public boolean areAnimationsEnabled() {
        return this.animationShadowCounter == 0;
    }

    @Override
    public void disableAnimations() {
        ++this.animationShadowCounter;
    }

    @Override
    public void enableAnimations() {
        --this.animationShadowCounter;
    }

    @Override
    public void resetAnimationsEnabled() {
        this.animationShadowCounter = ANIMATIONS_ENABLED ? 0 : -129;
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return new Class[]{class$de$vw$mib$widgets$ui$ViewUI == null ? (class$de$vw$mib$widgets$ui$ViewUI = View.class$("de.vw.mib.widgets.ui.ViewUI")) : class$de$vw$mib$widgets$ui$ViewUI};
    }

    @Override
    public final boolean is_renderBoundingBoxes() {
        ScreenModel screenModel = this.getScreen();
        boolean bl = screenModel != null && screenModel != this ? screenModel.is_renderBoundingBoxes() : false;
        return this.getInternalStateFlag(18) || ALWAYS_RENDER_BOUNDING_BOXES || bl;
    }

    @Override
    public final void set_renderBoundingBoxes(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(18);
        if (bl2 != bl) {
            this.setInternalStateFlag(18, bl);
            this.renderBoundingBoxesChanged(bl2);
            this.propertyChanged(40);
        }
    }

    @Override
    public final boolean is_renderInfo() {
        return this.getInternalStateFlag(19);
    }

    @Override
    public final void set_renderInfo(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(19);
        if (bl2 != bl) {
            this.setInternalStateFlag(19, bl);
            this.renderInfoChanged(bl2);
            this.propertyChanged(41);
        }
    }

    @Override
    public final Color get_colorBackground() {
        return this.colorBackground;
    }

    @Override
    public final void set_colorBackground(Color color) {
        Color color2 = this.colorBackground;
        if (color2 == null || !color2.equals(color)) {
            this.colorBackground = color;
            this.colorBackgroundChanged(color2);
            this.propertyChanged(42);
        }
    }

    @Override
    public final KeyframeAnimation[] get_enterAnimations() {
        return this.enterAnimations;
    }

    @Override
    public final void set_enterAnimations(KeyframeAnimation[] keyframeAnimationArray) {
        Object[] objectArray = this.enterAnimations;
        if (!Arrays.equals(objectArray, keyframeAnimationArray)) {
            this.enterAnimations = keyframeAnimationArray;
            this.enterAnimationsChanged((KeyframeAnimation[])objectArray);
            this.propertyChanged(43);
        }
    }

    @Override
    public final KeyframeAnimation[] get_leaveAnimations() {
        return this.leaveAnimations;
    }

    @Override
    public final void set_leaveAnimations(KeyframeAnimation[] keyframeAnimationArray) {
        Object[] objectArray = this.leaveAnimations;
        if (!Arrays.equals(objectArray, keyframeAnimationArray)) {
            this.leaveAnimations = keyframeAnimationArray;
            this.enterAnimationsChanged((KeyframeAnimation[])objectArray);
            this.propertyChanged(44);
        }
    }

    @Override
    public boolean is_opaque() {
        return this.getInternalStateFlag(20);
    }

    @Override
    public void set_opaque(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(20);
        if (bl2 != bl) {
            this.setInternalStateFlag(20, bl);
            this.opaqueChanged(bl2);
            this.propertyChanged(48);
        }
    }

    @Override
    public final int[] get_viewTypes() {
        return this.viewTypes;
    }

    @Override
    public final void set_viewTypes(int[] nArray) {
        int[] nArray2 = this.viewTypes;
        if (!Arrays.equals(nArray2, nArray)) {
            this.viewTypes = nArray;
            this.viewTypesChanged(nArray2);
            this.propertyChanged(45);
        }
    }

    @Override
    public final int get_viewTypeSelection() {
        return this.viewTypeSelection;
    }

    @Override
    public final void set_viewTypeSelection(int n) {
        int n2 = this.viewTypeSelection;
        if (n2 != n) {
            this.viewTypeSelection = n;
            this.viewTypeSelectionChanged(n2);
            this.propertyChanged(46);
        }
    }

    @Override
    public int get_touchForwardingMode() {
        return this.touchForwardingMode;
    }

    @Override
    public void set_touchForwardingMode(int n) {
        int n2 = this.touchForwardingMode;
        if (n2 != n) {
            this.touchForwardingMode = n;
            this.touchForwardingModeChanged(n2);
            this.propertyChanged(47);
        }
    }

    @Override
    public final int getDisplayID() {
        return 0;
    }

    @Override
    public Point getPointerPosition() {
        return this.pointerPosition;
    }

    @Override
    public void setPointerPosition(Point point) {
        this.pointerPosition = point;
    }

    @Override
    public int getCurrentViewType() {
        return this.viewTypeSelection < this.viewTypes.length ? this.viewTypes[this.viewTypeSelection] : -1;
    }

    @Override
    public final ViewModel getView() {
        return this;
    }

    @Override
    public ScreenModel getScreen() {
        ViewModel viewModel = this;
        while (viewModel != null && viewModel.getParent() != null) {
            viewModel = viewModel.getParent().getView();
        }
        return viewModel instanceof ScreenModel ? (ScreenModel)viewModel : null;
    }

    @Override
    public void addViewChangedListener(ViewChangedListener viewChangedListener) {
        this.viewChangedListeners = this.viewChangedListeners.addIfAbsent(viewChangedListener);
    }

    @Override
    public void removeViewChangedListener(ViewChangedListener viewChangedListener) {
        this.viewChangedListeners = this.viewChangedListeners.remove(viewChangedListener);
    }

    @Override
    public void addProximityConsumer(WidgetModel widgetModel) {
        this.proximityConsumers = this.proximityConsumers.addIfAbsent(widgetModel);
    }

    @Override
    public void removeProximityConsumer(WidgetModel widgetModel) {
        this.proximityConsumers = this.proximityConsumers.remove(widgetModel);
    }

    @Override
    public CowList getProximityConsumers() {
        return this.proximityConsumers;
    }

    @Override
    public void setViewEventDispatcher(ViewEventDispatcher viewEventDispatcher) {
        this.viewEventDispatcher = viewEventDispatcher;
    }

    @Override
    public ViewEventDispatcher getViewEventDispatcher() {
        return this.viewEventDispatcher;
    }

    @Override
    public void setViewEventDispatcher(de.vw.mib.event.dispatcher.ViewEventDispatcher viewEventDispatcher) {
    }

    protected void renderBoundingBoxesChanged(boolean bl) {
        this.repaint();
    }

    protected void renderInfoChanged(boolean bl) {
        this.repaint();
    }

    protected void colorBackgroundChanged(Color color) {
        this.repaint();
    }

    protected void opaqueChanged(boolean bl) {
        this.repaint();
    }

    protected void enterAnimationsChanged(KeyframeAnimation[] keyframeAnimationArray) {
    }

    protected void leaveAnimationsChanged(KeyframeAnimation[] keyframeAnimationArray) {
    }

    protected void viewTypeSelectionChanged(int n) {
    }

    protected void viewTypesChanged(int[] nArray) {
    }

    protected void touchForwardingModeChanged(int n) {
    }

    @Override
    public final boolean isEnterAnimationRunning() {
        boolean bl = this.isKeyframeAnimationRunning(this.runningEnterAnimationId);
        if (this.runningEnterAnimationId != -1 && !bl) {
            this.runningEnterAnimationId = -1;
        }
        return bl;
    }

    @Override
    public boolean startEnterAnimation(AnimatedPropertiesAccessor animatedPropertiesAccessor, int n, int n2, AnimationListener animationListener) {
        if (!$assertionsDisabled && this.runningEnterAnimationId != -1) {
            throw new AssertionError();
        }
        if (!ANIMATIONS_ENABLED || this.enterAnimations == null || n < 0 || n >= this.enterAnimations.length || this.enterAnimations[n].isEmpty() || this.animationBlockingEnabled) {
            return false;
        }
        if (LOGGER.isTraceEnabled(1024) && LOGGER.isTraceEnabled(8192)) {
            LogMessage logMessage = LOGGER.trace(1024);
            logMessage.append("View '").append(this.toString()).append("': Starting view enter animation at index ").append(n).log();
        }
        int n3 = this.getEnterAnimationId(n);
        this.startKeyframeAnimationInternal(animatedPropertiesAccessor, n3, this.enterAnimations[n], n2, animationListener);
        boolean bl = this.isKeyframeAnimationRunning(n3);
        if (bl) {
            this.runningEnterAnimationId = n3;
        }
        return bl;
    }

    @Override
    public final void stopEnterAnimation(int n) {
        if (this.enterAnimations == null || n < 0 || n >= this.enterAnimations.length || this.animationBlockingEnabled) {
            return;
        }
        if (LOGGER.isTraceEnabled(1024) && LOGGER.isTraceEnabled(8192)) {
            LogMessage logMessage = LOGGER.trace(1024);
            logMessage.append("View '").append(this.toString()).append("': Stopping view enter enimation at index ").append(n).log();
        }
        this.stopKeyframeAnimationInternal(this.getEnterAnimationId(n));
        this.runningEnterAnimationId = -1;
    }

    private int getEnterAnimationId(int n) {
        return 1000 + n;
    }

    @Override
    public final boolean isLeaveAnimationRunning() {
        boolean bl = this.isKeyframeAnimationRunning(this.runningLeaveAnimationId);
        if (this.runningLeaveAnimationId != -1 && !bl) {
            this.runningLeaveAnimationId = -1;
        }
        return bl;
    }

    @Override
    public boolean startLeaveAnimation(AnimatedPropertiesAccessor animatedPropertiesAccessor, int n, int n2, AnimationListener animationListener) {
        if (!$assertionsDisabled && this.runningLeaveAnimationId != -1) {
            throw new AssertionError();
        }
        if (!ANIMATIONS_ENABLED || this.leaveAnimations == null || this.leaveAnimations.length == 0 || n >= this.leaveAnimations.length || this.leaveAnimations[n].isEmpty() || this.animationBlockingEnabled) {
            return false;
        }
        if (LOGGER.isTraceEnabled(1024) && LOGGER.isTraceEnabled(8192)) {
            LogMessage logMessage = LOGGER.trace(1024);
            logMessage.append("View '").append(this.toString()).append("': Starting view leave animation at index ").append(n).log();
        }
        int n3 = this.getLeaveAnimationId(n);
        this.startKeyframeAnimationInternal(animatedPropertiesAccessor, n3, this.leaveAnimations[n], n2, animationListener);
        boolean bl = this.isKeyframeAnimationRunning(n3);
        if (bl) {
            this.runningLeaveAnimationId = n3;
        }
        return bl;
    }

    @Override
    public final void stopLeaveAnimation(int n) {
        if (this.leaveAnimations == null || this.leaveAnimations.length == 0 || n >= this.leaveAnimations.length || this.animationBlockingEnabled) {
            return;
        }
        if (LOGGER.isTraceEnabled(1024) && LOGGER.isTraceEnabled(8192)) {
            LogMessage logMessage = LOGGER.trace(1024);
            logMessage.append("View '").append(this.toString()).append("': Stopping view leave animation at index ").append(n).log();
        }
        this.stopKeyframeAnimationInternal(this.getLeaveAnimationId(n));
        this.runningLeaveAnimationId = -1;
    }

    private int getLeaveAnimationId(int n) {
        return 2000 + n;
    }

    protected final void fireViewCovered() {
        for (CowList cowList = this.viewChangedListeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            ViewChangedListener viewChangedListener = (ViewChangedListener)cowList.head();
            viewChangedListener.viewCovered();
        }
    }

    protected final void fireViewUncovered() {
        for (CowList cowList = this.viewChangedListeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            ViewChangedListener viewChangedListener = (ViewChangedListener)cowList.head();
            viewChangedListener.viewUncovered();
        }
    }

    protected final void fireViewInited() {
        for (CowList cowList = this.viewChangedListeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            ViewChangedListener viewChangedListener = (ViewChangedListener)cowList.head();
            viewChangedListener.viewInited(this);
        }
    }

    protected final void fireViewEntered() {
        for (CowList cowList = this.viewChangedListeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            ViewChangedListener viewChangedListener = (ViewChangedListener)cowList.head();
            viewChangedListener.viewEntered(this);
        }
    }

    protected final void fireViewLeft() {
        for (CowList cowList = this.viewChangedListeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            ViewChangedListener viewChangedListener = (ViewChangedListener)cowList.head();
            viewChangedListener.viewLeft(this);
        }
    }

    @Override
    public void onCover() {
        this.fireViewCovered();
        if (LOGGER.isTraceEnabled(1024)) {
            LogMessage logMessage = LOGGER.trace(1024);
            logMessage.append("View '").append(this.toString()).append("': view.onCover() finished").log();
        }
    }

    @Override
    public void onUncover() {
        this.fireViewUncovered();
        if (LOGGER.isTraceEnabled(1024)) {
            LogMessage logMessage = LOGGER.trace(1024);
            logMessage.append("View '").append(this.toString()).append("': view.onUncover() finished").log();
        }
    }

    public void onInit() {
        this.fireViewInited();
        if (LOGGER.isTraceEnabled(1024)) {
            LogMessage logMessage = LOGGER.trace(1024);
            logMessage.append("View '").append(this.toString()).append("': view.onInit() finished").log();
        }
    }

    @Override
    public void onEnter() {
        this.fireViewEntered();
        if (LOGGER.isTraceEnabled(1024)) {
            LogMessage logMessage = LOGGER.trace(1024);
            logMessage.append("View '").append(this.toString()).append("': view.onEnter() finished").log();
        }
    }

    @Override
    public void onLeave() {
        this.fireViewLeft();
        if (LOGGER.isTraceEnabled(1024)) {
            LogMessage logMessage = LOGGER.trace(1024);
            logMessage.append("View '").append(this.toString()).append("': view.onLeave() finished").log();
        }
    }

    @Override
    public void setAnimationBlockingEnabled(boolean bl) {
        super.setAnimationBlockingEnabled(bl);
        this.animationBlockingEnabled = bl;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        $assertionsDisabled = !(class$de$vw$mib$widgets$View == null ? (class$de$vw$mib$widgets$View = View.class$("de.vw.mib.widgets.View")) : class$de$vw$mib$widgets$View).desiredAssertionStatus();
        ALWAYS_RENDER_BOUNDING_BOXES = System.getProperty("de.vw.mib.widgets.boundingboxes.always") != null;
    }
}

