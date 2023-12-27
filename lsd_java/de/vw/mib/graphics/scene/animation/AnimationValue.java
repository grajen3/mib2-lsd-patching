/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.scene.animation;

import de.vw.mib.util.StringBuilder;

public final class AnimationValue {
    public static final int VALUE_TYPE_INTEGER_SCALAR;
    public static final int VALUE_TYPE_INTEGER_VECTOR;
    public static final int VALUE_TYPE_FLOAT_SCALAR;
    public static final int VALUE_TYPE_FLOAT_VECTOR;
    public static final int VALUE_TYPE_NORMAL;
    public static final int VALUE_TYPE_COLOR;
    public final int type;

    public AnimationValue(int n) {
        this.type = n;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[type=").append(this.type);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public int getType() {
        return this.type;
    }
}

