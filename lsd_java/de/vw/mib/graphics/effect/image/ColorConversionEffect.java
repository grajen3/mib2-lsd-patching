/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.effect.image;

import de.vw.mib.graphics.effect.image.ImageEffect;
import de.vw.mib.graphics.math.Tuple3f;

public interface ColorConversionEffect
extends ImageEffect {
    default public float getFirstSignalHue() {
    }

    default public void setFirstSignalHue(float f2) {
    }

    default public float getSecondSignalHue() {
    }

    default public void setSecondSignalHue(float f2) {
    }

    default public void setFirstColorConversionParam1(Tuple3f tuple3f) {
    }

    default public Tuple3f getFirstColorConversionParam1() {
    }

    default public void setFirstColorConversionParam2(Tuple3f tuple3f) {
    }

    default public Tuple3f getFirstColorConversionParam2() {
    }

    default public void setFirstColorConversionParam3(Tuple3f tuple3f) {
    }

    default public Tuple3f getFirstColorConversionParam3() {
    }

    default public void setSecondColorConversionParam1(Tuple3f tuple3f) {
    }

    default public Tuple3f getSecondColorConversionParam1() {
    }

    default public void setSecondColorConversionParam2(Tuple3f tuple3f) {
    }

    default public Tuple3f getSecondColorConversionParam2() {
    }

    default public void setSecondColorConversionParam3(Tuple3f tuple3f) {
    }

    default public Tuple3f getSecondColorConversionParam3() {
    }
}

