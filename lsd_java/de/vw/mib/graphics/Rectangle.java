/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.graphics.Dimension;
import de.vw.mib.graphics.Point;
import de.vw.mib.pool.PooledObject;
import de.vw.mib.util.StringBuilder;
import java.io.Serializable;

public final class Rectangle
implements Serializable,
Cloneable,
PooledObject {
    private static final long serialVersionUID;
    private static HashCodeBuilder hcb;
    public int x;
    public int y;
    public int width;
    public int height;

    public Rectangle() {
        this(0, 0, 0, 0);
    }

    public Rectangle(Dimension dimension) {
        this(dimension.width, dimension.height);
    }

    public Rectangle(int n, int n2) {
        this(0, 0, n, n2);
    }

    public Rectangle(int n, int n2, int n3, int n4) {
        this.x = n;
        this.y = n2;
        this.width = n3;
        this.height = n4;
    }

    public Rectangle(Point point) {
        this(point.x, point.y, 0, 0);
    }

    public Rectangle(Point point, Dimension dimension) {
        this(point.x, point.y, dimension.width, dimension.height);
    }

    public Rectangle(Rectangle rectangle) {
        this(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }

    public Object clone() {
        try {
            return super.clone();
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
        return hcb.hashCode();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object != null && super.getClass() == object.getClass()) {
            Rectangle rectangle = (Rectangle)object;
            return this.x == rectangle.x && this.y == rectangle.y && this.width == rectangle.width && this.height == rectangle.height;
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
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public void backToPool() {
        this.x = 0;
        this.y = 0;
        this.width = 0;
        this.height = 0;
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

    public Rectangle getBounds() {
        return new Rectangle(this.x, this.y, this.width, this.height);
    }

    public void setBounds(int n, int n2, int n3, int n4) {
        this.x = n;
        this.y = n2;
        this.width = n3;
        this.height = n4;
    }

    public void setBounds(Rectangle rectangle) {
        this.setBounds(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
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

    public Dimension getSize() {
        return new Dimension(this.width, this.height);
    }

    public void setSize(int n, int n2) {
        this.width = n;
        this.height = n2;
    }

    public void setSize(Dimension dimension) {
        this.setSize(dimension.width, dimension.height);
    }

    public boolean isEmpty() {
        return this.width <= 0 || this.height <= 0;
    }

    public void add(int n, int n2) {
        long l;
        if (n < this.x) {
            l = (long)this.width + (long)this.x - (long)n;
            this.width = l > 0 ? 0 : (int)l;
            this.x = n;
        } else if (n > this.x + this.width) {
            this.width = n - this.x;
        }
        if (n2 < this.y) {
            l = (long)this.height + (long)this.y - (long)n2;
            this.height = l > 0 ? 0 : (int)l;
            this.y = n2;
        } else if (n2 > this.y + this.height) {
            this.height = n2 - this.y;
        }
    }

    public void add(Point point) {
        this.add(point.x, point.y);
    }

    public void add(Rectangle rectangle) {
        int n = this.x < rectangle.x ? this.x : rectangle.x;
        int n2 = this.y < rectangle.y ? this.y : rectangle.y;
        int n3 = this.x + this.width;
        int n4 = rectangle.x + rectangle.width;
        int n5 = n3 > n4 ? n3 : n4;
        n3 = this.y + this.height;
        n4 = rectangle.y + rectangle.height;
        int n6 = n3 > n4 ? n3 : n4;
        this.x = n;
        this.y = n2;
        this.width = n5 - n;
        this.height = n6 - n2;
    }

    public boolean contains(int n, int n2) {
        if (this.width <= 0 || this.height <= 0) {
            return false;
        }
        if (n < this.x || n2 < this.y) {
            return false;
        }
        long l = (long)this.x + (long)this.width;
        long l2 = (long)this.y + (long)this.height;
        return (long)n < l && (long)n2 < l2;
    }

    public boolean contains(Point point) {
        return this.contains(point.x, point.y);
    }

    public boolean contains(int n, int n2, int n3, int n4) {
        if (n3 <= 0 || n4 <= 0) {
            return false;
        }
        if (this.width <= 0 || this.height <= 0) {
            return false;
        }
        return this.contains(n, n2) && this.contains(n + n3 - 1, n2 + n4 - 1);
    }

    public boolean contains(Rectangle rectangle) {
        return this.contains(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }

    public void grow(int n, int n2) {
        this.x -= n;
        this.y -= n2;
        this.width += 2 * n;
        this.height += 2 * n2;
    }

    public Rectangle intersection(Rectangle rectangle) {
        if (this == rectangle) {
            return new Rectangle(this.x, this.y, this.width, this.height);
        }
        int n = this.x > rectangle.x ? this.x : rectangle.x;
        int n2 = this.y > rectangle.y ? this.y : rectangle.y;
        long l = Math.min((long)this.x + (long)this.width, (long)rectangle.x + (long)rectangle.width);
        long l2 = Math.min((long)this.y + (long)this.height, (long)rectangle.y + (long)rectangle.height);
        return new Rectangle((long)n > l ? 0 : n, (long)n2 > l2 ? 0 : n2, l < (long)n ? 0 : (int)Math.min(l - (long)n, (long)0), l2 < (long)n2 ? 0 : (int)Math.min(l2 - (long)n2, (long)0));
    }

    public boolean intersects(Rectangle rectangle) {
        return rectangle == this || (long)rectangle.x < (long)this.x + (long)this.width && (long)rectangle.y < (long)this.y + (long)this.height && (long)rectangle.x + (long)rectangle.width > (long)this.x && (long)rectangle.y + (long)rectangle.height > (long)this.y;
    }

    public void translate(int n, int n2) {
        this.x += n;
        this.y += n2;
    }

    public Rectangle union(Rectangle rectangle) {
        int n = this.x < rectangle.x ? this.x : rectangle.x;
        int n2 = this.y < rectangle.y ? this.y : rectangle.y;
        int n3 = this.x + this.width;
        int n4 = rectangle.x + rectangle.width;
        int n5 = n3 > n4 ? n3 : n4;
        n3 = this.y + this.height;
        n4 = rectangle.y + rectangle.height;
        int n6 = n3 > n4 ? n3 : n4;
        return new Rectangle(n, n2, n5 - n, n6 - n2);
    }
}

