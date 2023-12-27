/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics;

import de.vw.mib.Disposable;
import de.vw.mib.graphics.Graphics3D;

public interface Resource
extends Disposable {
    default public Graphics3D getGraphics3D() {
    }
}

