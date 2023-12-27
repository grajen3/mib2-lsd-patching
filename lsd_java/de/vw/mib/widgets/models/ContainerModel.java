/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.animation.animations.KeyframeAnimation;
import de.vw.mib.animation.control.AnimatedPropertiesAccessor;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.properties.values.LayoutAttribs;
import de.vw.mib.widgets.animation.Animatable;
import de.vw.mib.widgets.layout.Layoutable;
import de.vw.mib.widgets.models.WidgetModel;
import java.util.List;

public interface ContainerModel
extends WidgetModel,
Layoutable,
Animatable {
    public static final int PID_BASE;
    public static final int PID_LAYOUT_ATTRIBS;
    public static final int PID_KEYFRAME_ANIMATIONS;
    public static final int PID_ALPHA_IMAGE_ENABLED;
    public static final int PID_ALPHA_IMAGE;
    public static final int PID_REFLECTION_ENABLED;
    public static final int PID_REFLECTION_ALPHA;
    public static final int PID_REFLECTION_ALPHA_IMAGE;
    public static final int PID_REFLECTION_DISTANCE;
    public static final int PID_COUNT_CONTAINER;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_COUNT_CONTAINER;
    public static final int SID_BASE;
    public static final int SID_ALPHAIMAGE_ENABLED;
    public static final int SID_DISTINCT_WIDGET_SIZE_MAPPING;
    public static final int SID_REFLECTION_ENABLED;
    public static final int SID_RENDER_OFFSCREEN;
    public static final int SID_RENDER_OFFSCREEN_REPLACE;
    public static final int SID_RENDER_OFFSCREEN_REPLACE_ENABLED;
    public static final int SID_LAYOUTING_ACTIVE;
    public static final int SID_LAYOUT_VALID;
    public static final int SID_NO_CHILDREN_LIFECYCLE_AUTHORITY;
    public static final int SID_COUNT_CONTAINER;
    public static final int REFLECTION_RENDER_MODE_DEFAULT;
    public static final int REFLECTION_RENDER_MODE_WO_REFLECTION;
    public static final int REFLECTION_RENDER_MODE_REFLECTION_ONLY;
    public static final int MATCH_VISIBLE_CHILDREN;
    public static final int MATCH_ENABLED_CHILDREN;
    public static final int MATCH_LAYOUTABLE_CHILDREN;

    default public LayoutAttribs get_layoutAttribs() {
    }

    default public void set_layoutAttribs(LayoutAttribs layoutAttribs) {
    }

    default public void set_keyframeAnimations(KeyframeAnimation[] keyframeAnimationArray) {
    }

    default public void set_reflectionEnabled(boolean bl) {
    }

    default public boolean is_reflectionEnabled() {
    }

    default public void set_reflectionAlpha(int n) {
    }

    default public int get_reflectionAlpha() {
    }

    default public void set_reflectionAlphaImage(Image image) {
    }

    default public Image get_reflectionAlphaImage() {
    }

    default public void set_reflectionDistance(int n) {
    }

    default public int get_reflectionDistance() {
    }

    default public void set_alphaImageEnabled(boolean bl) {
    }

    default public boolean is_alphaImageEnabled() {
    }

    default public void set_alphaImage(Image image) {
    }

    default public Image get_alphaImage() {
    }

    default public KeyframeAnimation[] get_keyframeAnimations() {
    }

    @Override
    default public void startKeyframeAnimation(AnimatedPropertiesAccessor animatedPropertiesAccessor, int n) {
    }

    @Override
    default public void stopKeyframeAnimation(int n) {
    }

    default public void stopKeyframeAnimations() {
    }

    default public boolean isKeyframeAnimationsRunning() {
    }

    default public WidgetModel getChild(int n) {
    }

    default public WidgetModel[] getChildren() {
    }

    default public void setChildren(WidgetModel[] widgetModelArray) {
    }

    default public void getChildren(List list, int n) {
    }

    default public void getAllChildren(List list, int n) {
    }

    default public boolean isRenderOffscreen() {
    }

    default public void setRenderOffscreen(boolean bl) {
    }

    default public Insets getOffscreenInsets() {
    }

    default public void setOffscreenInsets(Insets insets) {
    }

    default public boolean isRenderOffscreenReplace() {
    }

    default public void setRenderOffscreenReplace(boolean bl) {
    }

    default public void setRenderOffscreenReplaceEnabled(boolean bl) {
    }

    default public void setReflectionRenderMode(int n) {
    }

    default public int getReflectionRenderMode() {
    }

    @Override
    default public void validateLayout() {
    }

    default public int getDecoration() {
    }

    default public float getAlphaImageRotation() {
    }
}

