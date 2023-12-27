/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.math.geometry;

import de.vw.mib.graphics.math.Transformable;
import de.vw.mib.graphics.math.geometry.Distance;
import java.io.Serializable;

public interface Geometry
extends Cloneable,
Serializable,
Distance,
Transformable {
    default public Object clone() {
    }
}

