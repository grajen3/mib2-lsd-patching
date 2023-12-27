/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.scene.graph.transform;

import de.vw.mib.graphics.math.Tuple3f;

public interface Scalable {
    default public void getScale(Tuple3f tuple3f) {
    }

    default public void setScale(Tuple3f tuple3f) {
    }

    default public void setScale(float f2, float f3, float f4) {
    }

    default public Scalable scale(Tuple3f tuple3f) {
    }

    default public Scalable scale(float f2, float f3, float f4) {
    }
}

