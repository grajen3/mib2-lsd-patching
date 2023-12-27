/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.scene.animation.target;

import de.vw.mib.graphics.math.Tuple3f;
import de.vw.mib.graphics.math.Tuple4f;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.math.algebra.AxisAngle;
import de.vw.mib.graphics.scene.animation.target.AnimationTarget;
import de.vw.mib.util.StringBuilder;

public abstract class AbstractAnimationTarget
implements AnimationTarget {
    public static final int TARGET_TYPE_CAMERA;
    public static final int TARGET_TYPE_LIGHT;
    public static final int TARGET_TYPE_MATERIAL;
    public static final int TARGET_TYPE_NODE;
    public static final int TARGET_ATTRIBUTE_INDEX_INVALID;
    private final int type;
    private final int attribute;
    private final int attributeIndex;
    private final int arrayIndex;

    public AbstractAnimationTarget(int n, int n2, int n3, int n4) {
        this.type = n;
        this.attribute = n2;
        this.attributeIndex = n3;
        this.arrayIndex = n4;
    }

    public AbstractAnimationTarget(int n, int n2, int n3) {
        this(n, n2, -1, n3);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[type=").append(this.type);
        stringBuilder.append(",attribute=").append(this.attribute);
        stringBuilder.append(",attributeIndex=").append(this.attributeIndex);
        stringBuilder.append(",arrayIndex=").append(this.arrayIndex);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public final int getType() {
        return this.type;
    }

    @Override
    public final int getAttribute() {
        return this.attribute;
    }

    @Override
    public final int getAttributeIndex() {
        return this.attributeIndex;
    }

    @Override
    public final int getArrayIndex() {
        return this.arrayIndex;
    }

    @Override
    public abstract Object getTarget() {
    }

    @Override
    public abstract void setValue(float[] fArray) {
    }

    protected static void setValue(Tuple3f tuple3f, float[] fArray, int n) {
        if (fArray.length == 1) {
            tuple3f.set(n, fArray[0]);
        } else {
            tuple3f.set(fArray);
        }
    }

    protected static void setValue(Tuple4f tuple4f, float[] fArray, int n) {
        if (fArray.length == 1) {
            tuple4f.set(n, fArray[0]);
        } else {
            tuple4f.set(fArray);
        }
    }

    protected static void setValue(AxisAngle axisAngle, float[] fArray, int n) {
        if (fArray.length == 1) {
            float f2 = fArray[0];
            axisAngle.set(n, n == 3 ? Util.toRadians(f2) : f2);
        } else {
            axisAngle.set(fArray);
        }
    }
}

