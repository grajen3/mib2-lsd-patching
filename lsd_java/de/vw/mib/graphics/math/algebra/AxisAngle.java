/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.math.algebra;

import de.vw.mib.graphics.math.Tuple4f;
import de.vw.mib.graphics.math.algebra.Vector3f;

public final class AxisAngle
extends Tuple4f {
    private static final long serialVersionUID;

    public AxisAngle() {
    }

    public AxisAngle(AxisAngle axisAngle) {
        super(axisAngle);
    }

    public AxisAngle(float f2, float f3, float f4, float f5) {
        super(f2, f3, f4, f5);
    }

    public AxisAngle(Vector3f vector3f, float f2) {
        super(vector3f.x, vector3f.y, vector3f.z, f2);
    }

    public float getAngle() {
        return this.getW();
    }

    public void setAngle(float f2) {
        this.setW(f2);
    }
}

