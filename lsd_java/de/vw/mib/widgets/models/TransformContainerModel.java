/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.widgets.interfaces.Decoratable;
import de.vw.mib.widgets.models.ContainerModel;

public interface TransformContainerModel
extends ContainerModel,
Decoratable {
    public static final int PID_BASE;
    public static final int PID_Z;
    public static final int PID_DEPTH;
    public static final int PID_ROTATION_X;
    public static final int PID_ROTATION_Y;
    public static final int PID_ROTATION_Z;
    public static final int PID_PIVOT_X;
    public static final int PID_PIVOT_Y;
    public static final int PID_PIVOT_Z;
    public static final int PID_SCALING_X;
    public static final int PID_SCALING_Y;
    public static final int PID_SCALING_Z;
    public static final int PID_PROJECTION_NEAR;
    public static final int PID_PROJECTION_FAR;
    public static final int PID_PROJECTION_FOV;
    public static final int PID_PROJECTION_TYPE;
    public static final int PID_DECORATION;
    public static final int PID_ALPHA_IMAGE_ROTATION;
    public static final int PID_COUNT_TRANSFORMCONTAINER;
    public static final int SID_BASE;
    public static final int SID_COUNT_TRANSFORMCONTAINER;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_ALPHA_IMAGE_ROTATION;
    public static final int EASING_INDEX_TRANSLATE_Z;
    public static final int EASING_INDEX_ROTATION_X;
    public static final int EASING_INDEX_ROTATION_Y;
    public static final int EASING_INDEX_ROTATION_Z;
    public static final int EASING_INDEX_SCALING_X;
    public static final int EASING_INDEX_SCALING_Y;
    public static final int EASING_INDEX_SCALING_Z;
    public static final int EASING_INDEX_COUNT_TRANSFORM_CONTAINER;
    public static final int PROJECTIONTYPE_INHERIT_FROM_PARENT;
    public static final int PROJECTIONTYPE_ORTHOGONAL;
    public static final int PROJECTIONTYPE_PERSPECTIVE;
    public static final int PROJECTIONTYPE_PERSPECTIVE_WIDGET_POV;

    default public int get_z() {
    }

    default public void set_z(int n) {
    }

    default public int get_depth() {
    }

    default public void set_depth(int n) {
    }

    default public float get_rotationX() {
    }

    default public void set_rotationX(float f2) {
    }

    default public float get_rotationY() {
    }

    default public void set_rotationY(float f2) {
    }

    default public float get_rotationZ() {
    }

    default public void set_rotationZ(float f2) {
    }

    default public float get_pivotX() {
    }

    default public void set_pivotX(float f2) {
    }

    default public float get_pivotY() {
    }

    default public void set_pivotY(float f2) {
    }

    default public float get_pivotZ() {
    }

    default public void set_pivotZ(float f2) {
    }

    default public void set_scalingX(float f2) {
    }

    default public float get_scalingX() {
    }

    default public void set_scalingY(float f2) {
    }

    default public float get_scalingY() {
    }

    default public void set_scalingZ(float f2) {
    }

    default public float get_scalingZ() {
    }

    default public float get_projectionNear() {
    }

    default public void set_projectionNear(float f2) {
    }

    default public float get_projectionFar() {
    }

    default public void set_projectionFar(float f2) {
    }

    default public float get_projectionFOV() {
    }

    default public void set_projectionFOV(float f2) {
    }

    default public int get_projectionType() {
    }

    default public void set_projectionType(int n) {
    }

    default public void set_alphaImageRotation(float f2) {
    }

    default public float get_alphaImageRotation() {
    }

    default public float getProjectionDistance() {
    }

    default public boolean isTransformationRequired() {
    }
}

