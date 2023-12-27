/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.texture;

import de.vw.mib.graphics.math.Tuple2f;
import de.vw.mib.graphics.math.Tuple3f;
import de.vw.mib.graphics.texture.TextureCoordinate;

public final class TextureCoordinate3f
extends Tuple3f
implements TextureCoordinate {
    private static final long serialVersionUID;

    public TextureCoordinate3f() {
    }

    public TextureCoordinate3f(Tuple3f tuple3f) {
        super(tuple3f);
    }

    public TextureCoordinate3f(Tuple2f tuple2f, float f2) {
        super(tuple2f, f2);
    }

    public TextureCoordinate3f(float[] fArray) {
        super(fArray);
    }

    public TextureCoordinate3f(float f2, float f3, float f4) {
        super(f2, f3, f4);
    }

    public float getU() {
        return this.x;
    }

    public void setU(float f2) {
        this.x = f2;
    }

    public float getV() {
        return this.y;
    }

    public void setV(float f2) {
        this.y = f2;
    }

    public float getW() {
        return this.z;
    }

    public void setW(float f2) {
        this.z = f2;
    }
}

