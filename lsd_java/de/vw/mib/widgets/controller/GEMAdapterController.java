/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.ViewController;

public interface GEMAdapterController
extends ViewController {
    public static final String IN_ROTATELEFT_NAME;
    public static final String IN_ROTATERIGHT_NAME;
    public static final String IN_ROTATEPRESS_NAME;
    public static final String IN_ROTATERELEASE_NAME;

    default public void fire_rotateLeft() {
    }

    default public void fire_rotateRight() {
    }

    default public void fire_rotatePress() {
    }

    default public void fire_rotateRelease() {
    }
}

