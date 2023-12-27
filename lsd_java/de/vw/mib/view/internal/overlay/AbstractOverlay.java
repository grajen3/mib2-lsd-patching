/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal.overlay;

import de.vw.mib.graphics.Dimension;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Point;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.view.internal.overlay.Overlay;

public abstract class AbstractOverlay
implements Overlay {
    private final Logger logger;
    private final Graphics3D g3d;
    private final String name;
    private final Rectangle rectangle;

    public AbstractOverlay(Logger logger, Graphics3D graphics3D, String string, Dimension dimension) {
        this.logger = logger;
        this.g3d = graphics3D;
        this.name = string;
        this.rectangle = new Rectangle(dimension);
    }

    public AbstractOverlay(Logger logger, Graphics3D graphics3D, String string) {
        this(logger, graphics3D, string, new Dimension());
    }

    @Override
    public void dispose() {
    }

    protected final Logger getLogger() {
        return this.logger;
    }

    protected final Graphics3D getGraphics3D() {
        return this.g3d;
    }

    @Override
    public final String getName() {
        return this.name;
    }

    @Override
    public final Rectangle getRectangle() {
        return this.rectangle;
    }

    @Override
    public final int getX() {
        return this.rectangle.getX();
    }

    @Override
    public final void setX(int n) {
        this.rectangle.setX(n);
    }

    @Override
    public final int getY() {
        return this.rectangle.getY();
    }

    @Override
    public final void setY(int n) {
        this.rectangle.setY(n);
    }

    @Override
    public final void setPosition(int n, int n2) {
        this.rectangle.setLocation(n, n2);
    }

    @Override
    public final void setPosition(Point point) {
        this.rectangle.setLocation(point);
    }

    @Override
    public final int getWidth() {
        return this.rectangle.getWidth();
    }

    @Override
    public final void setWidth(int n) {
        this.rectangle.setWidth(n);
    }

    @Override
    public final int getHeight() {
        return this.rectangle.getHeight();
    }

    @Override
    public final void setHeight(int n) {
        this.rectangle.setHeight(n);
    }

    @Override
    public final void setSize(int n, int n2) {
        this.rectangle.setSize(n, n2);
    }

    @Override
    public final void setSize(Dimension dimension) {
        this.rectangle.setSize(dimension);
    }

    @Override
    public abstract void draw() {
    }
}

