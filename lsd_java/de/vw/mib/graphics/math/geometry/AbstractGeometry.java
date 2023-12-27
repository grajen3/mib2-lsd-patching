/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.math.geometry;

import de.vw.mib.graphics.math.geometry.Geometry;

public abstract class AbstractGeometry
implements Geometry {
    private static final long serialVersionUID;

    @Override
    public Object clone() {
        try {
            AbstractGeometry abstractGeometry = (AbstractGeometry)super.clone();
            return abstractGeometry;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new RuntimeException(cloneNotSupportedException);
        }
    }
}

