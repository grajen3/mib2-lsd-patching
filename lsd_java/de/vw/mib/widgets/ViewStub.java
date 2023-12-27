/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.animations.KeyframeAnimation;
import de.vw.mib.animation.control.AnimatedPropertiesAccessor;
import de.vw.mib.animation.control.AnimationListener;
import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.collections.copyonwrite.CowList;
import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.ProximityEvent;
import de.vw.mib.event.TouchEvent;
import de.vw.mib.event.dispatcher.apps.ViewEventDispatcher;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.Point;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.graphics.math.Transform;
import de.vw.mib.properties.values.LayoutAttribs;
import de.vw.mib.widgets.controller.WidgetController;
import de.vw.mib.widgets.event.PropertyChangedListener;
import de.vw.mib.widgets.event.ViewChangedListener;
import de.vw.mib.widgets.models.ScreenModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.WidgetUI;
import java.util.List;

public class ViewStub
implements ViewModel {
    @Override
    public int getDisplayID() {
        return 0;
    }

    @Override
    public boolean isInvalid() {
        return false;
    }

    @Override
    public int getAbsAlpha() {
        return 0;
    }

    @Override
    public void getAbsBounds(Rectangle rectangle) {
    }

    @Override
    public void invalidate() {
    }

    @Override
    public ScreenModel getScreen() {
        return null;
    }

    @Override
    public void onEnter() {
    }

    @Override
    public void onLeave() {
    }

    @Override
    public boolean isLeaveAnimationRunning() {
        return false;
    }

    @Override
    public boolean isEnterAnimationRunning() {
        return false;
    }

    @Override
    public boolean isPaintable() {
        return true;
    }

    @Override
    public boolean isTransformationRequired() {
        return false;
    }

    @Override
    public void addViewChangedListener(ViewChangedListener viewChangedListener) {
    }

    @Override
    public Color get_colorBackground() {
        return null;
    }

    @Override
    public KeyframeAnimation[] get_enterAnimations() {
        return null;
    }

    @Override
    public KeyframeAnimation[] get_leaveAnimations() {
        return null;
    }

    @Override
    public int[] get_viewTypes() {
        return null;
    }

    @Override
    public int get_viewTypeSelection() {
        return 0;
    }

    @Override
    public int getCurrentViewType() {
        return 0;
    }

    @Override
    public Point getPointerPosition() {
        return null;
    }

    @Override
    public void init() {
    }

    @Override
    public boolean is_renderBoundingBoxes() {
        return false;
    }

    @Override
    public boolean is_renderInfo() {
        return false;
    }

    @Override
    public void onCover() {
    }

    @Override
    public void onUncover() {
    }

    @Override
    public void removeViewChangedListener(ViewChangedListener viewChangedListener) {
    }

    @Override
    public void set_colorBackground(Color color) {
    }

    @Override
    public void set_enterAnimations(KeyframeAnimation[] keyframeAnimationArray) {
    }

    @Override
    public void set_leaveAnimations(KeyframeAnimation[] keyframeAnimationArray) {
    }

    @Override
    public void set_renderBoundingBoxes(boolean bl) {
    }

    @Override
    public void set_renderInfo(boolean bl) {
    }

    @Override
    public void set_viewTypes(int[] nArray) {
    }

    @Override
    public void set_viewTypeSelection(int n) {
    }

    @Override
    public void setPointerPosition(Point point) {
    }

    @Override
    public boolean startEnterAnimation(AnimatedPropertiesAccessor animatedPropertiesAccessor, int n, int n2, AnimationListener animationListener) {
        return false;
    }

    @Override
    public boolean startLeaveAnimation(AnimatedPropertiesAccessor animatedPropertiesAccessor, int n, int n2, AnimationListener animationListener) {
        return false;
    }

    @Override
    public void stopEnterAnimation(int n) {
    }

    @Override
    public void stopLeaveAnimation(int n) {
    }

    @Override
    public int get_depth() {
        return 0;
    }

    @Override
    public float get_pivotX() {
        return 0.0f;
    }

    @Override
    public float get_pivotY() {
        return 0.0f;
    }

    @Override
    public float get_pivotZ() {
        return 0.0f;
    }

    @Override
    public float get_projectionFar() {
        return 0.0f;
    }

    @Override
    public float get_projectionFOV() {
        return 0.0f;
    }

    @Override
    public float get_projectionNear() {
        return 0.0f;
    }

    @Override
    public int get_projectionType() {
        return 0;
    }

    @Override
    public float get_rotationX() {
        return 0.0f;
    }

    @Override
    public float get_rotationY() {
        return 0.0f;
    }

    @Override
    public float get_rotationZ() {
        return 0.0f;
    }

    @Override
    public float get_scalingX() {
        return 0.0f;
    }

    @Override
    public float get_scalingY() {
        return 0.0f;
    }

    @Override
    public float get_scalingZ() {
        return 0.0f;
    }

    @Override
    public int get_z() {
        return 0;
    }

    @Override
    public float getProjectionDistance() {
        return 0.0f;
    }

    @Override
    public void set_depth(int n) {
    }

    @Override
    public void set_pivotX(float f2) {
    }

    @Override
    public void set_pivotY(float f2) {
    }

    @Override
    public void set_pivotZ(float f2) {
    }

    @Override
    public void set_projectionFar(float f2) {
    }

    @Override
    public void set_projectionFOV(float f2) {
    }

    @Override
    public void set_projectionNear(float f2) {
    }

    @Override
    public void set_projectionType(int n) {
    }

    @Override
    public void set_rotationX(float f2) {
    }

    @Override
    public void set_rotationY(float f2) {
    }

    @Override
    public void set_rotationZ(float f2) {
    }

    @Override
    public void set_scalingX(float f2) {
    }

    @Override
    public void set_scalingY(float f2) {
    }

    @Override
    public void set_scalingZ(float f2) {
    }

    @Override
    public void set_z(int n) {
    }

    @Override
    public Image get_alphaImage() {
        return null;
    }

    @Override
    public void set_alphaImageRotation(float f2) {
    }

    @Override
    public float get_alphaImageRotation() {
        return 0.0f;
    }

    @Override
    public KeyframeAnimation[] get_keyframeAnimations() {
        return null;
    }

    @Override
    public LayoutAttribs get_layoutAttribs() {
        return null;
    }

    @Override
    public int get_reflectionAlpha() {
        return 0;
    }

    @Override
    public Image get_reflectionAlphaImage() {
        return null;
    }

    @Override
    public int get_reflectionDistance() {
        return 0;
    }

    @Override
    public void getAllChildren(List list, int n) {
    }

    @Override
    public WidgetModel getChild(int n) {
        return null;
    }

    @Override
    public WidgetModel[] getChildren() {
        return null;
    }

    @Override
    public void getChildren(List list, int n) {
    }

    @Override
    public boolean is_alphaImageEnabled() {
        return false;
    }

    @Override
    public boolean is_reflectionEnabled() {
        return false;
    }

    @Override
    public boolean isKeyframeAnimationsRunning() {
        return false;
    }

    @Override
    public boolean isRenderOffscreen() {
        return false;
    }

    @Override
    public void set_alphaImage(Image image) {
    }

    @Override
    public void set_alphaImageEnabled(boolean bl) {
    }

    @Override
    public void set_keyframeAnimations(KeyframeAnimation[] keyframeAnimationArray) {
    }

    @Override
    public void set_layoutAttribs(LayoutAttribs layoutAttribs) {
    }

    @Override
    public void set_reflectionAlpha(int n) {
    }

    @Override
    public void set_reflectionAlphaImage(Image image) {
    }

    @Override
    public void set_reflectionDistance(int n) {
    }

    @Override
    public void set_reflectionEnabled(boolean bl) {
    }

    @Override
    public void setChildren(WidgetModel[] widgetModelArray) {
    }

    @Override
    public void setRenderOffscreen(boolean bl) {
    }

    @Override
    public void startKeyframeAnimation(AnimatedPropertiesAccessor animatedPropertiesAccessor, int n) {
    }

    @Override
    public void stopKeyframeAnimation(int n) {
    }

    @Override
    public void stopKeyframeAnimations() {
    }

    @Override
    public void validateLayout() {
    }

    @Override
    public void performLayout() {
    }

    @Override
    public void activate() {
    }

    @Override
    public void addPropertyChangedListener(PropertyChangedListener propertyChangedListener) {
    }

    @Override
    public boolean areAnimationsEnabled() {
        return false;
    }

    @Override
    public boolean consumeHMIEvent(HMIEvent hMIEvent, String string) {
        return false;
    }

    @Override
    public boolean consumeTouchEvent(TouchEvent touchEvent) {
        return false;
    }

    @Override
    public boolean consumeProximityEvent(ProximityEvent proximityEvent) {
        return false;
    }

    @Override
    public void deActivate() {
    }

    @Override
    public void deInit() {
    }

    @Override
    public void disableAnimations() {
    }

    @Override
    public void disablePropertyChanged() {
    }

    @Override
    public void enableAnimations() {
    }

    @Override
    public void enablePropertyChanged() {
    }

    @Override
    public void findTouchEventConsumingWidgets(List list, int n, int n2) {
    }

    @Override
    public void findTouchEventConsumingWidgets(List list, TouchEvent touchEvent) {
    }

    @Override
    public int get_alpha() {
        return 0;
    }

    @Override
    public EasingParams[] get_easing() {
        return null;
    }

    @Override
    public int get_height() {
        return 0;
    }

    @Override
    public String get_name() {
        return null;
    }

    @Override
    public int get_targetId() {
        return 0;
    }

    @Override
    public Insets get_touchInsets() {
        return null;
    }

    @Override
    public int get_width() {
        return 0;
    }

    @Override
    public int get_x() {
        return 0;
    }

    @Override
    public int get_y() {
        return 0;
    }

    @Override
    public int getAbsX() {
        return 0;
    }

    @Override
    public int getAbsY() {
        return 0;
    }

    @Override
    public void getBounds(Rectangle rectangle) {
    }

    @Override
    public WidgetController getController() {
        return null;
    }

    @Override
    public Transform getGlobalTransform() {
        return null;
    }

    @Override
    public Transform getLocalTransform() {
        return null;
    }

    @Override
    public WidgetModel getParent() {
        return null;
    }

    @Override
    public String getQualifiedName() {
        return null;
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return null;
    }

    @Override
    public WidgetUI getUI() {
        return null;
    }

    @Override
    public ViewModel getView() {
        return null;
    }

    @Override
    public void init(ViewModel viewModel) {
    }

    @Override
    public boolean is_activated() {
        return false;
    }

    @Override
    public boolean is_availableInVariant() {
        return false;
    }

    @Override
    public boolean is_enabled() {
        return false;
    }

    @Override
    public boolean is_visible() {
        return false;
    }

    @Override
    public boolean is_layoutable() {
        return false;
    }

    @Override
    public boolean isAbsPointInside(int n, int n2) {
        return false;
    }

    @Override
    public boolean isVisibleRelevantAnimationRunning() {
        return false;
    }

    @Override
    public boolean areParentsEnabled() {
        return false;
    }

    @Override
    public boolean areParentsVisible() {
        return false;
    }

    @Override
    public boolean canParentsConsumeHMIEvents() {
        return false;
    }

    @Override
    public boolean isPointInside(int n, int n2, int n3) {
        return false;
    }

    @Override
    public boolean isPointInside(int n, int n2) {
        return false;
    }

    @Override
    public boolean isDirty() {
        return false;
    }

    @Override
    public void paint(Graphics3D graphics3D, ViewModel viewModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
    }

    @Override
    public void removePropertyChangedListener(PropertyChangedListener propertyChangedListener) {
    }

    @Override
    public void repaint() {
    }

    @Override
    public void resetAnimationsEnabled() {
    }

    @Override
    public void set_activated(boolean bl) {
    }

    @Override
    public void set_alpha(int n) {
    }

    @Override
    public void set_availableInVariant(boolean bl) {
    }

    @Override
    public void set_easing(EasingParams[] easingParamsArray) {
    }

    @Override
    public void set_enabled(boolean bl) {
    }

    @Override
    public void set_height(int n) {
    }

    @Override
    public void set_name(String string) {
    }

    @Override
    public void set_targetId(int n) {
    }

    @Override
    public void set_touchInsets(Insets insets) {
    }

    @Override
    public void set_visible(boolean bl) {
    }

    @Override
    public void set_layoutable(boolean bl) {
    }

    @Override
    public void set_width(int n) {
    }

    @Override
    public void set_x(int n) {
    }

    @Override
    public void set_y(int n) {
    }

    @Override
    public void setController(WidgetController widgetController) {
    }

    @Override
    public void setUI(WidgetUI widgetUI) {
    }

    @Override
    public void stopInternalAnimations() {
    }

    @Override
    public boolean isRenderOffscreenReplace() {
        return false;
    }

    @Override
    public void setRenderOffscreenReplace(boolean bl) {
    }

    @Override
    public int getAbsZ() {
        return 0;
    }

    @Override
    public void setOffscreenInsets(Insets insets) {
    }

    @Override
    public Insets getOffscreenInsets() {
        return null;
    }

    @Override
    public void setRenderOffscreenReplaceEnabled(boolean bl) {
    }

    @Override
    public boolean isAbsPointInside(int n, int n2, int n3) {
        return false;
    }

    @Override
    public void setReflectionRenderMode(int n) {
    }

    @Override
    public int getReflectionRenderMode() {
        return 0;
    }

    @Override
    public boolean canConsumeHMIEvents() {
        return false;
    }

    @Override
    public void calculateBoundingBox(int n, int n2, Point point, Point point2) {
    }

    @Override
    public int get_touchForwardingMode() {
        return 0;
    }

    @Override
    public void set_touchForwardingMode(int n) {
    }

    @Override
    public boolean is_opaque() {
        return false;
    }

    @Override
    public void set_opaque(boolean bl) {
    }

    @Override
    public void addProximityConsumer(WidgetModel widgetModel) {
    }

    @Override
    public void removeProximityConsumer(WidgetModel widgetModel) {
    }

    @Override
    public CowList getProximityConsumers() {
        return null;
    }

    @Override
    public int getDecoration() {
        return 0;
    }

    @Override
    public int get_decoration() {
        return 0;
    }

    @Override
    public void set_decoration(int n) {
    }

    @Override
    public ViewEventDispatcher getViewEventDispatcher() {
        return null;
    }

    @Override
    public void setViewEventDispatcher(ViewEventDispatcher viewEventDispatcher) {
    }

    @Override
    public void setViewEventDispatcher(de.vw.mib.event.dispatcher.ViewEventDispatcher viewEventDispatcher) {
    }

    @Override
    public float getAlphaImageRotation() {
        return 0.0f;
    }

    @Override
    public void setAnimationBlockingEnabled(boolean bl) {
    }
}

