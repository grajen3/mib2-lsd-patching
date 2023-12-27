/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.animations.Animation;
import de.vw.mib.animation.animations.KeyframeAnimation;
import de.vw.mib.animation.animations.KeyframeAnimationParams;
import de.vw.mib.animation.animations.KeyframeBasedAnimation;
import de.vw.mib.animation.control.AnimatedPropertiesAccessor;
import de.vw.mib.animation.control.AnimationListener;
import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.Point;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.properties.values.LayoutAttribs;
import de.vw.mib.widgets.AbstractWidget;
import de.vw.mib.widgets.event.PropertyChangedListener;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.layout.ContainerLayout;
import de.vw.mib.widgets.models.ContainerModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Container
extends AbstractWidget
implements ContainerModel,
PropertyChangedListener,
AnimationListener {
    private static final WidgetModel[] NO_CHILDREN;
    private LayoutAttribs layoutAttribs;
    private KeyframeAnimation[] keyframeAnimations;
    private Image alphaImage;
    private short reflectionDistance;
    private short reflectionAlpha;
    private Image reflectionAlphaImage;
    private WidgetModel[] children;
    private IntObjectMap runningKeyframeAnimations;
    private int[] layoutFlags;
    private Insets offscreenInsets;
    private short reflectionRenderMode;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$widgets$Container;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$ContainerUI;

    public void init(boolean bl, int n, Image image, boolean bl2, boolean bl3, EasingParams[] easingParamsArray, boolean bl4, int n2, KeyframeAnimation[] keyframeAnimationArray, boolean bl5, LayoutAttribs layoutAttribs, String string, int n3, Image image2, int n4, boolean bl6, int n5, Insets insets, boolean bl7, int n6, int n7, int n8) {
        super.init(bl, n, bl3, easingParamsArray, bl4, n2, bl5, string, n5, insets, bl7, n6, n7, n8);
        this.layoutAttribs = layoutAttribs;
        this.keyframeAnimations = keyframeAnimationArray;
        this.alphaImage = image;
        this.reflectionAlpha = (short)n3;
        this.reflectionAlphaImage = image2;
        this.reflectionDistance = (short)n4;
        this.setInternalStateFlag(9, bl2);
        this.setInternalStateFlag(11, bl6);
        this.setInternalStateFlag(13, false);
        this.setInternalStateFlag(10, true);
    }

    @Override
    protected void reset() {
        super.reset();
        this.layoutAttribs = null;
        this.keyframeAnimations = null;
        this.alphaImage = null;
        this.reflectionAlphaImage = null;
        this.children = NO_CHILDREN;
        this.runningKeyframeAnimations = null;
        this.layoutFlags = null;
        this.setInternalStateFlag(16, false);
        this.setInternalStateFlag(15, false);
        this.offscreenInsets = null;
        this.reflectionRenderMode = 0;
        this.setInternalStateFlag(10, true);
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
        if (this.arePropertyChangedListenerRequired()) {
            this.registerPropertyChangedListener(this, this.getChildren());
        }
        ServiceManager.imageManager.preloadImageFromCurrentSkin(this.get_alphaImage());
        ServiceManager.imageManager.preloadImageFromCurrentSkin(this.get_reflectionAlphaImage());
        this.initializeLayoutManager();
        if (!this.getInternalStateFlag(17)) {
            for (int i2 = this.children.length - 1; i2 >= 0; --i2) {
                this.children[i2].init(viewModel);
            }
        }
    }

    @Override
    public void deInit() {
        this.stopKeyframeAnimations();
        if (!$assertionsDisabled && this.runningKeyframeAnimations != null && !this.runningKeyframeAnimations.isEmpty()) {
            throw new AssertionError();
        }
        if (this.arePropertyChangedListenerRequired()) {
            this.removePropertyChangedListener(this, this.getChildren());
        }
        if (!this.getInternalStateFlag(17)) {
            for (int i2 = this.children.length - 1; i2 >= 0; --i2) {
                this.children[i2].deInit();
            }
        }
        this.layoutFlags = null;
        this.setInternalStateFlag(16, false);
        super.deInit();
    }

    @Override
    public void activate() {
        super.activate();
        if (!this.getInternalStateFlag(17)) {
            for (int i2 = this.children.length - 1; i2 >= 0; --i2) {
                this.children[i2].activate();
            }
        }
    }

    @Override
    public void deActivate() {
        if (!this.getInternalStateFlag(17)) {
            for (int i2 = this.children.length - 1; i2 >= 0; --i2) {
                this.children[i2].deActivate();
            }
        }
        super.deActivate();
    }

    protected boolean arePropertyChangedListenerRequired() {
        return this.isLayoutEnabled() && this.layoutAttribs.getLayoutOrientation() != 2;
    }

    protected final void updatePropertyChangedListener() {
        if (this.arePropertyChangedListenerRequired()) {
            this.registerPropertyChangedListener(this, this.getChildren());
        } else {
            this.removePropertyChangedListener(this, this.getChildren());
        }
    }

    @Override
    public void stopInternalAnimations() {
        super.stopInternalAnimations();
        for (int i2 = this.children.length - 1; i2 >= 0; --i2) {
            this.children[i2].stopInternalAnimations();
        }
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return new Class[]{class$de$vw$mib$widgets$ui$ContainerUI == null ? (class$de$vw$mib$widgets$ui$ContainerUI = Container.class$("de.vw.mib.widgets.ui.ContainerUI")) : class$de$vw$mib$widgets$ui$ContainerUI};
    }

    @Override
    public final LayoutAttribs get_layoutAttribs() {
        return this.layoutAttribs;
    }

    @Override
    public final void set_layoutAttribs(LayoutAttribs layoutAttribs) {
        LayoutAttribs layoutAttribs2 = this.layoutAttribs;
        if (layoutAttribs2 == null || !layoutAttribs2.equals(layoutAttribs)) {
            this.layoutAttribs = layoutAttribs;
            this.layoutChanged(layoutAttribs2);
            this.propertyChanged(15);
        }
    }

    @Override
    public final KeyframeAnimation[] get_keyframeAnimations() {
        return this.keyframeAnimations;
    }

    @Override
    public final void set_keyframeAnimations(KeyframeAnimation[] keyframeAnimationArray) {
        Object[] objectArray = this.keyframeAnimations;
        if (!Arrays.equals(objectArray, keyframeAnimationArray)) {
            this.keyframeAnimations = keyframeAnimationArray;
            this.keyframeAnimationsChanged((KeyframeAnimation[])objectArray);
            this.propertyChanged(16);
        }
    }

    @Override
    public final void set_reflectionEnabled(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(11);
        if (bl2 != bl) {
            this.setInternalStateFlag(11, bl);
            this.reflectionEnabledChanged(bl2);
            this.propertyChanged(19);
        }
    }

    @Override
    public final boolean is_reflectionEnabled() {
        return this.getInternalStateFlag(11);
    }

    @Override
    public final void set_reflectionAlpha(int n) {
        short s = this.reflectionAlpha;
        if (s != n) {
            this.reflectionAlpha = (short)n;
            this.reflectionAlphaChanged(s);
            this.propertyChanged(20);
        }
    }

    @Override
    public final int get_reflectionAlpha() {
        return this.reflectionAlpha;
    }

    @Override
    public final void set_reflectionAlphaImage(Image image) {
        Image image2 = this.reflectionAlphaImage;
        if (image2 == null || !image2.equals(image)) {
            this.reflectionAlphaImage = image;
            this.reflectionAlphaImageChanged(image2);
            this.propertyChanged(21);
        }
    }

    @Override
    public final Image get_reflectionAlphaImage() {
        return this.reflectionAlphaImage;
    }

    @Override
    public final void set_reflectionDistance(int n) {
        short s = this.reflectionDistance;
        if (s != n) {
            this.reflectionDistance = (short)n;
            this.reflectionAlphaChanged(s);
            this.propertyChanged(22);
        }
    }

    @Override
    public final int get_reflectionDistance() {
        return this.reflectionDistance;
    }

    @Override
    public final void set_alphaImageEnabled(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(9);
        if (bl != bl2) {
            this.setInternalStateFlag(9, bl);
            this.alphaImageEnabledChanged(bl2);
            this.propertyChanged(17);
        }
    }

    @Override
    public final boolean is_alphaImageEnabled() {
        return this.getInternalStateFlag(9);
    }

    @Override
    public final Image get_alphaImage() {
        return this.alphaImage;
    }

    @Override
    public final void set_alphaImage(Image image) {
        Image image2 = this.alphaImage;
        if (image2 == null || !image2.equals(image)) {
            this.alphaImage = image;
            this.alphaImageChanged(image2);
            this.propertyChanged(18);
        }
    }

    @Override
    public final WidgetModel[] getChildren() {
        return this.children;
    }

    @Override
    public final void setChildren(WidgetModel[] widgetModelArray) {
        Object[] objectArray = this.children;
        if (!Arrays.equals(objectArray, widgetModelArray)) {
            this.children = widgetModelArray;
            this.childrenChanged((WidgetModel[])objectArray);
        }
    }

    @Override
    public final WidgetModel getChild(int n) {
        return this.children[n];
    }

    public final int getChildCount() {
        return this.children.length;
    }

    @Override
    public void calculateBoundingBox(int n, int n2, Point point, Point point2) {
        if (!this.is_visible()) {
            return;
        }
        this.validateLayout();
        int n3 = n + this.get_x();
        int n4 = n2 + this.get_y();
        for (int i2 = 0; i2 < this.children.length; ++i2) {
            this.children[i2].calculateBoundingBox(n3, n4, point, point2);
        }
    }

    @Override
    public boolean isRenderOffscreen() {
        return this.getInternalStateFlag(12) || this.getInternalStateFlag(9);
    }

    @Override
    public boolean isRenderOffscreenReplace() {
        return this.checkInternalStateMask(0);
    }

    @Override
    public Insets getOffscreenInsets() {
        return this.offscreenInsets;
    }

    @Override
    public void setOffscreenInsets(Insets insets) {
        this.offscreenInsets = insets;
    }

    @Override
    public void setRenderOffscreenReplaceEnabled(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(14);
        if (bl2 != bl) {
            this.setInternalStateFlag(14, bl);
        }
    }

    @Override
    public void setRenderOffscreenReplace(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(13);
        if (bl2 != bl) {
            this.setInternalStateFlag(13, bl);
        }
    }

    @Override
    public void setRenderOffscreen(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(12);
        if (bl2 != bl) {
            this.setInternalStateFlag(12, bl);
        }
    }

    @Override
    public float getAlphaImageRotation() {
        return 0.0f;
    }

    @Override
    public int getDecoration() {
        return 0;
    }

    protected final void setDistinctWidgetSizeMapping(boolean bl) {
        this.setInternalStateFlag(10, bl);
    }

    protected void childrenChanged(WidgetModel[] widgetModelArray) {
        int n;
        if (widgetModelArray != null) {
            for (n = widgetModelArray.length - 1; n >= 0; --n) {
                ((AbstractWidget)widgetModelArray[n]).setParent(null);
            }
        }
        for (n = this.children.length - 1; n >= 0; --n) {
            ((AbstractWidget)this.children[n]).setParent(this);
        }
    }

    @Override
    protected void visibleChanged(boolean bl) {
        super.visibleChanged(bl);
        if (this.areParentsVisible()) {
            this.parentVisibilityChanged(bl);
        }
        if (this.is_visible()) {
            this.invalidateLayout();
        }
    }

    @Override
    protected void parentVisibilityChanged(boolean bl) {
        for (int i2 = this.children.length - 1; i2 >= 0; --i2) {
            AbstractWidget abstractWidget = (AbstractWidget)this.children[i2];
            if (!abstractWidget.is_visible()) continue;
            abstractWidget.parentVisibilityChanged(bl);
        }
    }

    @Override
    protected void widthChanged(int n) {
        super.widthChanged(n);
        this.invalidateLayout();
    }

    @Override
    protected void heightChanged(int n) {
        super.heightChanged(n);
        this.invalidateLayout();
    }

    protected void keyframeAnimationsChanged(KeyframeAnimation[] keyframeAnimationArray) {
    }

    protected void layoutChanged(LayoutAttribs layoutAttribs) {
        this.updatePropertyChangedListener();
        this.initializeLayoutManager();
        this.invalidateLayout();
        this.repaint();
    }

    protected void alphaImageEnabledChanged(boolean bl) {
        this.repaint();
    }

    protected void alphaImageChanged(Image image) {
        ServiceManager.imageManager.preloadImageFromCurrentSkin(this.get_alphaImage());
        this.repaint();
    }

    protected void reflectionEnabledChanged(boolean bl) {
        this.repaint();
    }

    protected void reflectionAlphaChanged(int n) {
        this.repaint();
    }

    protected void reflectionAlphaImageChanged(Image image) {
        ServiceManager.imageManager.preloadImageFromCurrentSkin(this.get_reflectionAlphaImage());
        this.repaint();
    }

    protected void reflectionDistanceChanged(int n) {
        this.repaint();
    }

    private boolean isLayoutEnabled() {
        return this.layoutAttribs != null && this.layoutAttribs.getLayoutOrientation() != -1;
    }

    private void initializeLayoutManager() {
        if (this.isLayoutEnabled()) {
            this.layoutFlags = new int[this.getChildCount() / 32 + 1];
            for (int i2 = 0; i2 < this.layoutFlags.length; ++i2) {
                this.layoutFlags[i2] = 0;
            }
            this.invalidateLayout();
        } else {
            this.layoutFlags = null;
        }
    }

    protected final void invalidateLayout() {
        this.setInternalStateFlag(16, false);
    }

    @Override
    public void validateLayout() {
        if (!this.isLayoutValid()) {
            this.setInternalStateFlag(16, true);
            this.performLayout();
        }
    }

    protected final boolean isLayoutValid() {
        return this.getInternalStateFlag(16);
    }

    @Override
    public void performLayout() {
        LayoutAttribs layoutAttribs = this.get_layoutAttribs();
        if (layoutAttribs != null && layoutAttribs.getLayoutOrientation() != -1) {
            this.setInternalStateFlag(15, true);
            ContainerLayout.performLayout(this.getLayoutableChildren(), this.getVisibleLayoutableChildCount(), layoutAttribs, this.get_width(), this.get_height(), this.layoutFlags, this.getInternalStateFlag(10));
            if (LOGGER.isTraceEnabled(16384)) {
                LogMessage logMessage = LOGGER.trace(16384);
                logMessage.append("Container '").append(this.getQualifiedName()).append("': applied automatic layout to children").log();
            }
            this.setInternalStateFlag(15, false);
        }
    }

    @Override
    public final void invalidate() {
        for (int i2 = this.children.length - 1; i2 >= 0; --i2) {
            this.children[i2].invalidate();
        }
        super.invalidate();
    }

    @Override
    protected final Rectangle markHierarchyDirtyDRM(int n, int n2, int n3, int n4) {
        if (this.isRenderOffscreen()) {
            return super.markHierarchyDirtyDRM(this.get_x(), this.get_y(), this.get_width(), this.get_height());
        }
        return super.markHierarchyDirtyDRM(n, n2, n3, n4);
    }

    @Override
    protected final void invalidateLocalTransform() {
        if (AbstractWidget.CACHE_TRANSFORM) {
            super.invalidateLocalTransform();
            for (int i2 = this.children.length - 1; i2 >= 0; --i2) {
                ((AbstractWidget)this.children[i2]).invalidateGlobalTransform();
            }
        }
    }

    @Override
    protected final void invalidateGlobalTransform() {
        if (AbstractWidget.CACHE_TRANSFORM) {
            super.invalidateGlobalTransform();
            for (int i2 = this.children.length - 1; i2 >= 0; --i2) {
                ((AbstractWidget)this.children[i2]).invalidateGlobalTransform();
            }
        }
    }

    @Override
    public void propertyChanged(WidgetModel widgetModel, int n) {
        if (!(this.getInternalStateFlag(15) || this.get_layoutAttribs() == null || n != 5 && n != 10 && n != 11 && n != 7)) {
            if (!this.areAnimationsEnabled()) {
                ContainerLayout.setAnimatedLayoutEnabled(false, this.layoutFlags);
            }
            this.invalidateLayout();
        }
    }

    @Override
    public final void findTouchEventConsumingWidgets(List list, int n, int n2) {
        ArrayList arrayList = new ArrayList(this.getChildCount());
        this.getChildren(arrayList, 3);
        if (this.is_visible() && this.get_alpha() > 0 && null != arrayList) {
            int n3 = this.getAbsX();
            int n4 = this.getAbsY();
            for (int i2 = arrayList.size() - 1; i2 >= 0; --i2) {
                WidgetModel widgetModel = (WidgetModel)arrayList.get(i2);
                if (!widgetModel.isPointInside(n - n3, n2 - n4)) continue;
                if (null != widgetModel.getController()) {
                    if (widgetModel.get_alpha() <= 0) continue;
                    list.add(widgetModel);
                    continue;
                }
                widgetModel.findTouchEventConsumingWidgets(list, n, n2);
            }
        }
    }

    protected void registerPropertyChangedListener(PropertyChangedListener propertyChangedListener, WidgetModel[] widgetModelArray) {
        if (widgetModelArray != null && propertyChangedListener != null) {
            for (int i2 = widgetModelArray.length - 1; i2 >= 0; --i2) {
                WidgetModel widgetModel = widgetModelArray[i2];
                if (widgetModel == null) continue;
                widgetModel.addPropertyChangedListener(propertyChangedListener);
            }
        }
    }

    protected void removePropertyChangedListener(PropertyChangedListener propertyChangedListener, WidgetModel[] widgetModelArray) {
        if (widgetModelArray != null && propertyChangedListener != null) {
            for (int i2 = widgetModelArray.length - 1; i2 >= 0; --i2) {
                WidgetModel widgetModel = widgetModelArray[i2];
                if (widgetModel == null) continue;
                widgetModel.removePropertyChangedListener(propertyChangedListener);
            }
        }
    }

    @Override
    public final void getChildren(List list, int n) {
        this.getChildren(list, n, false);
    }

    @Override
    public void setReflectionRenderMode(int n) {
        this.reflectionRenderMode = (short)n;
    }

    @Override
    public int getReflectionRenderMode() {
        return this.reflectionRenderMode;
    }

    @Override
    public final void getAllChildren(List list, int n) {
        this.getChildren(list, n, true);
    }

    private void getChildren(List list, int n, boolean bl) {
        boolean bl2 = 0 != (n & 1);
        boolean bl3 = 0 != (n & 2);
        boolean bl4 = 0 != (n & 4);
        for (int i2 = 0; i2 < this.children.length; ++i2) {
            boolean bl5;
            WidgetModel widgetModel = this.children[i2];
            boolean bl6 = bl5 = (!bl2 || bl2 && widgetModel.is_visible()) && (!bl3 || bl3 && widgetModel.is_enabled()) && (!bl4 || bl4 && widgetModel.is_layoutable() && widgetModel.getUI() != null);
            if (bl5) {
                list.add(widgetModel);
            }
            if (!bl || !(widgetModel instanceof Container)) continue;
            ((Container)widgetModel).getChildren(list, n, bl);
        }
    }

    private WidgetModel[] getLayoutableChildren() {
        ArrayList arrayList = new ArrayList(this.getChildCount());
        this.getChildren(arrayList, 4);
        return (WidgetModel[])arrayList.toArray(new WidgetModel[arrayList.size()]);
    }

    public final int getVisibleChildCount() {
        ArrayList arrayList = new ArrayList(this.getChildCount());
        this.getChildren(arrayList, 1);
        return arrayList.size();
    }

    protected final int getVisibleLayoutableChildCount() {
        ArrayList arrayList = new ArrayList(this.getChildCount());
        this.getChildren(arrayList, 5);
        return arrayList.size();
    }

    public final int getEnabledChildCount() {
        ArrayList arrayList = new ArrayList(this.getChildCount());
        this.getChildren(arrayList, 2);
        return arrayList.size();
    }

    @Override
    public final void startKeyframeAnimation(AnimatedPropertiesAccessor animatedPropertiesAccessor, int n) {
        if (!this.areAnimationsEnabled() || this.keyframeAnimations == null || this.keyframeAnimations.length == 0 || n >= this.keyframeAnimations.length) {
            return;
        }
        if (this.runningKeyframeAnimations != null && this.runningKeyframeAnimations.containsKey(n)) {
            if (LOGGER.isTraceEnabled(1) && LOGGER.isTraceEnabled(8192)) {
                LOGGER.trace(1).append("Container '").append(this.getQualifiedName()).append("': Starting of keyframe animation at index ").append(n).append(" ignored - animation is already running").log();
            }
            return;
        }
        if (LOGGER.isTraceEnabled(1) && LOGGER.isTraceEnabled(8192)) {
            LogMessage logMessage = LOGGER.trace(1);
            logMessage.append("Container '").append(this.getQualifiedName()).append("': Starting keyframe animation at index ").append(n).log();
        }
        this.startKeyframeAnimationInternal(animatedPropertiesAccessor, n, this.keyframeAnimations[n], 0, null);
    }

    protected final void startKeyframeAnimationInternal(AnimatedPropertiesAccessor animatedPropertiesAccessor, int n, KeyframeAnimationParams keyframeAnimationParams, int n2, AnimationListener animationListener) {
        KeyframeBasedAnimation keyframeBasedAnimation = new KeyframeBasedAnimation(n, keyframeAnimationParams, animatedPropertiesAccessor, this.get_targetId());
        if (animationListener != null) {
            keyframeBasedAnimation.addAnimationListener(animationListener);
        }
        keyframeBasedAnimation.addAnimationListener(this);
        ServiceManager.animationManager.startAnimation(keyframeBasedAnimation, n2);
    }

    @Override
    public final void stopKeyframeAnimation(int n) {
        if (this.keyframeAnimations == null || this.keyframeAnimations.length == 0 || n >= this.keyframeAnimations.length) {
            return;
        }
        if (LOGGER.isTraceEnabled(1) && LOGGER.isTraceEnabled(8192)) {
            LogMessage logMessage = LOGGER.trace(1);
            logMessage.append("Container '").append(this.getQualifiedName()).append("': Stopping keyframe animation at index ").append(n).log();
        }
        this.stopKeyframeAnimationInternal(n);
    }

    protected final void stopKeyframeAnimationInternal(int n) {
        KeyframeBasedAnimation keyframeBasedAnimation;
        if (this.runningKeyframeAnimations != null && (keyframeBasedAnimation = (KeyframeBasedAnimation)this.runningKeyframeAnimations.get(n)) != null) {
            this.stopKeyframeAnimation(keyframeBasedAnimation);
        }
    }

    private void stopKeyframeAnimation(KeyframeBasedAnimation keyframeBasedAnimation) {
        ServiceManager.animationManager.stopAnimation(keyframeBasedAnimation);
    }

    @Override
    public final void stopKeyframeAnimations() {
        if (this.runningKeyframeAnimations != null) {
            Object[] objectArray = this.runningKeyframeAnimations.valuesToArray();
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                this.stopKeyframeAnimation((KeyframeBasedAnimation)objectArray[i2]);
            }
        }
    }

    protected final boolean isKeyframeAnimationRunning(int n) {
        return this.runningKeyframeAnimations != null ? this.runningKeyframeAnimations.containsKey(n) : false;
    }

    @Override
    public final boolean isKeyframeAnimationsRunning() {
        return this.runningKeyframeAnimations != null && this.runningKeyframeAnimations.size() > 0;
    }

    @Override
    public final void animationStarted(Animation animation) {
        KeyframeBasedAnimation keyframeBasedAnimation = (KeyframeBasedAnimation)animation;
        if (this.runningKeyframeAnimations == null) {
            this.runningKeyframeAnimations = new IntObjectOptHashMap();
        }
        this.runningKeyframeAnimations.put(keyframeBasedAnimation.getKeyframeAnimationId(), keyframeBasedAnimation);
    }

    @Override
    public final void animationStopped(Animation animation) {
        KeyframeBasedAnimation keyframeBasedAnimation = (KeyframeBasedAnimation)animation;
        if (!$assertionsDisabled && this.runningKeyframeAnimations == null) {
            throw new AssertionError();
        }
        this.runningKeyframeAnimations.remove(keyframeBasedAnimation.getKeyframeAnimationId());
        keyframeBasedAnimation.removeAnimationListener(this);
    }

    @Override
    public final void animationRunning(Animation animation) {
    }

    @Override
    public final void animationProgress(Animation animation, int n) {
    }

    @Override
    public void setAnimationBlockingEnabled(boolean bl) {
        for (int i2 = 0; i2 < this.children.length; ++i2) {
            WidgetModel widgetModel = this.children[i2];
            widgetModel.setAnimationBlockingEnabled(bl);
        }
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
        $assertionsDisabled = !(class$de$vw$mib$widgets$Container == null ? (class$de$vw$mib$widgets$Container = Container.class$("de.vw.mib.widgets.Container")) : class$de$vw$mib$widgets$Container).desiredAssertionStatus();
        NO_CHILDREN = new WidgetModel[0];
    }
}

