/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.pool.PooledObject;
import de.vw.mib.util.StringBuilder;
import java.io.Serializable;

public final class Point
implements Serializable,
Cloneable,
PooledObject {
    private static final long serialVersionUID;
    private static HashCodeBuilder hcb;
    public int x;
    public int y;

    public Point() {
        this(0, 0);
    }

    public Point(Point point) {
        this(point.x, point.y);
    }

    public Point(int n, int n2) {
        this.x = n;
        this.y = n2;
    }

    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new RuntimeException(cloneNotSupportedException);
        }
    }

    @Override
    public void backToPool() {
        this.x = 0;
        this.y = 0;
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

    public int hashCode() {
        if (hcb == null) {
            hcb = new HashCodeBuilder();
        }
        hcb.reset();
        hcb.append(this.x);
        hcb.append(this.y);
        return hcb.hashCode();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object != null && super.getClass() == object.getClass()) {
            Point point = (Point)object;
            return this.x == point.x && this.y == point.y;
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[x=").append(this.x);
        stringBuilder.append(",y=").append(this.y);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public Point getLocation() {
        return new Point(this.x, this.y);
    }

    public void setLocation(int n, int n2) {
        this.x = n;
        this.y = n2;
    }

    public void setLocation(Point point) {
        this.setLocation(point.x, point.y);
    }

    public void move(int n, int n2) {
        this.setLocation(n, n2);
    }

    public void translate(int n, int n2) {
        this.x += n;
        this.y += n2;
    }
}

