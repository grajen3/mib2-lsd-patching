/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.texture;

import de.vw.mib.graphics.math.Tuple2f;
import de.vw.mib.graphics.texture.TextureCoordinate;

public final class TextureCoordinate2f
extends Tuple2f
implements TextureCoordinate {
    private static final long serialVersionUID;

    public TextureCoordinate2f() {
    }

    public TextureCoordinate2f(Tuple2f tuple2f) {
        super(tuple2f);
    }

    public TextureCoordinate2f(float[] fArray) {
        super(fArray);
    }

    public TextureCoordinate2f(float f2, float f3) {
        super(f2, f3);
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
}

