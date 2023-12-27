/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal.overlay;

import de.vw.mib.Disposable;
import de.vw.mib.graphics.Dimension;
import de.vw.mib.graphics.Point;
import de.vw.mib.graphics.Rectangle;

public interface Overlay
extends Disposable {
    default public String getName() {
    }

    default public Rectangle getRectangle() {
    }

    default public int getX() {
    }

    default public void setX(int n) {
    }

    default public int getY() {
    }

    default public void setY(int n) {
    }

    default public void setPosition(int n, int n2) {
    }

    default public void setPosition(Point point) {
    }

    default public int getWidth() {
    }

    default public void setWidth(int n) {
    }

    default public int getHeight() {
    }

    default public void setHeight(int n) {
    }

    default public void setSize(int n, int n2) {
    }

    default public void setSize(Dimension dimension) {
    }

    default public void draw() {
    }
}

