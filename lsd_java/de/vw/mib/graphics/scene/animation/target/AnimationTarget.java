/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.scene.animation.target;

public interface AnimationTarget {
    public static final int TARGET_TYPE_CAMERA;
    public static final int TARGET_TYPE_LIGHT;
    public static final int TARGET_TYPE_MATERIAL;
    public static final int TARGET_TYPE_NODE;
    public static final int TARGET_ATTRIBUTE_INDEX_INVALID;

    default public int getType() {
    }

    default public int getAttribute() {
    }

    default public int getAttributeIndex() {
    }

    default public int getArrayIndex() {
    }

    default public Object getTarget() {
    }

    default public void setValue(float[] fArray) {
    }
}

