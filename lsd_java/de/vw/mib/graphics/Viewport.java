/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.util.StringBuilder;
import java.io.Serializable;

public final class Viewport
implements Cloneable,
Serializable {
    private static final long serialVersionUID;
    private static HashCodeBuilder hcb;
    private int x;
    private int y;
    private int width;
    private int height;
    private float near;
    private float far;

    public Viewport() {
    }

    public Viewport(int n, int n2, int n3, int n4, float f2, float f3) {
        this.x = n;
        this.y = n2;
        this.width = n3;
        this.height = n4;
        this.near = f2;
        this.far = f3;
    }

    public Viewport(Viewport viewport) {
        this.x = viewport.x;
        this.y = viewport.y;
        this.width = viewport.width;
        this.height = viewport.height;
        this.near = viewport.near;
        this.far = viewport.far;
    }

    public Object clone() {
        try {
            Viewport viewport = (Viewport)super.clone();
            return viewport;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new RuntimeException(cloneNotSupportedException);
        }
    }

    public int hashCode() {
        if (hcb == null) {
            hcb = new HashCodeBuilder();
        }
        hcb.reset();
        hcb.append(this.x);
        hcb.append(this.y);
        hcb.append(this.width);
        hcb.append(this.height);
        hcb.append(this.near);
        hcb.append(this.far);
        return hcb.hashCode();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object != null && super.getClass() == object.getClass()) {
            Viewport viewport = (Viewport)object;
            if (Util.IDENTITY_EQUALS) {
                return this.x == viewport.x && this.y == viewport.y && this.width == viewport.width && this.height == viewport.height && this.near == viewport.near && this.far == viewport.far;
            }
            if (Util.EXACT_EQUALS) {
                return this.x == viewport.x && this.y == viewport.y && this.width == viewport.width && this.height == viewport.height && Float.compare(this.near, viewport.near) == 0 && Float.compare(this.far, viewport.far) == 0;
            }
            return this.x == viewport.x && this.y == viewport.y && this.width == viewport.width && this.height == viewport.height && Util.equalsEpsilon(this.near, viewport.near) && Util.equalsEpsilon(this.far, viewport.far);
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[x=").append(this.x);
        stringBuilder.append(",y=").append(this.y);
        stringBuilder.append(",width=").append(this.width);
        stringBuilder.append(",height=").append(this.height);
        stringBuilder.append(",near=").append(this.near);
        stringBuilder.append(",far=").append(this.far);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void set(Viewport viewport) {
        if (this != viewport) {
            this.x = viewport.x;
            this.y = viewport.y;
            this.width = viewport.width;
            this.height = viewport.height;
            this.near = viewport.near;
            this.far = viewport.far;
        }
    }

    public void set(int n, int n2, int n3, int n4, float f2, float f3) {
        this.x = n;
        this.y = n2;
        this.width = n3;
        this.height = n4;
        this.near = f2;
        this.far = f3;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int n) {
        this.x = n;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int n) {
        this.y = n;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int n) {
        this.width = n;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int n) {
        this.height = n;
    }

    public float getNear() {
        return this.near;
    }

    public void setNear(float f2) {
        this.near = f2;
    }

    public float getFar() {
        return this.far;
    }

    public void setFar(float f2) {
        this.far = f2;
    }
}

