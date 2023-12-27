/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.graphics.Point;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.util.StringBuilder;
import java.io.Serializable;
import java.util.Arrays;

public final class Polygon
implements Cloneable,
Serializable {
    private static final long serialVersionUID;
    private static int ARRAY_INCREMENT;
    protected Rectangle bounds;
    public int npoints;
    public int[] xpoints;
    public int[] ypoints;
    private static HashCodeBuilder hcb;

    public Polygon() {
        this(new int[ARRAY_INCREMENT], new int[ARRAY_INCREMENT], 0);
    }

    public Polygon(int[] nArray, int[] nArray2, int n) {
        if (n < 0) {
            throw new NegativeArraySizeException();
        }
        if (n > Math.min(nArray.length, nArray2.length)) {
            throw new IndexOutOfBoundsException();
        }
        this.xpoints = (int[])nArray.clone();
        this.ypoints = (int[])nArray2.clone();
        this.npoints = n;
    }

    public Object clone() {
        try {
            Polygon polygon = (Polygon)super.clone();
            polygon.bounds = (Rectangle)this.bounds.clone();
            polygon.xpoints = (int[])this.xpoints.clone();
            polygon.ypoints = (int[])this.ypoints.clone();
            return polygon;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new RuntimeException(cloneNotSupportedException);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[");
        stringBuilder.append("xpoints=[").append(this.xpoints).append("]");
        stringBuilder.append(",ypoints=").append(this.ypoints).append("]");
        stringBuilder.append(",npoints=").append(this.npoints);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void addPoint(int n, int n2) {
        int[] nArray;
        if (this.npoints == this.xpoints.length) {
            nArray = new int[this.npoints + ARRAY_INCREMENT];
            System.arraycopy((Object)this.xpoints, 0, (Object)nArray, 0, this.npoints);
            this.xpoints = nArray;
        }
        if (this.npoints == this.ypoints.length) {
            nArray = new int[this.npoints + ARRAY_INCREMENT];
            System.arraycopy((Object)this.ypoints, 0, (Object)nArray, 0, this.npoints);
            this.ypoints = nArray;
        }
        this.xpoints[this.npoints] = n;
        this.ypoints[this.npoints] = n2;
        ++this.npoints;
        if (this.bounds != null) {
            this.bounds.add(n, n2);
        }
    }

    public boolean contains(int n, int n2) {
        if (!this.getBounds().contains(n, n2)) {
            return false;
        }
        boolean bl = false;
        int n3 = 0;
        int n4 = this.npoints - 1;
        while (n3 < this.npoints) {
            if ((this.ypoints[n3] <= n2 && n2 < this.ypoints[n4] || this.ypoints[n4] <= n2 && n2 < this.ypoints[n3]) && (double)n < (double)((this.xpoints[n4] - this.xpoints[n3]) * (n2 - this.ypoints[n3])) * 1.0 / (double)(this.ypoints[n4] - this.ypoints[n3]) + (double)this.xpoints[n3]) {
                bl = !bl;
            }
            n4 = n3++;
        }
        return bl;
    }

    public boolean contains(Point point) {
        if (point == null) {
            return false;
        }
        return this.contains(point.x, point.y);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object != null && super.getClass() == object.getClass()) {
            Polygon polygon = (Polygon)object;
            return Arrays.equals(this.xpoints, polygon.xpoints) && Arrays.equals(this.ypoints, polygon.ypoints) && this.npoints == polygon.npoints;
        }
        return false;
    }

    public Rectangle getBounds() {
        if (this.npoints == 0) {
            return new Rectangle(0, 0, 0, 0);
        }
        if (this.bounds == null) {
            int n = this.xpoints[0];
            int n2 = this.ypoints[0];
            int n3 = this.xpoints[0];
            int n4 = this.ypoints[0];
            for (int i2 = 1; i2 < this.npoints; ++i2) {
                int n5 = this.xpoints[i2];
                int n6 = this.ypoints[i2];
                if (n5 < n) {
                    n = n5;
                }
                if (n6 < n2) {
                    n2 = n6;
                }
                if (n5 > n3) {
                    n3 = n5;
                }
                if (n6 <= n4) continue;
                n4 = n6;
            }
            this.bounds = new Rectangle(n, n2, n3 - n, n4 - n2);
        }
        return new Rectangle(this.bounds);
    }

    public void getBounds(Rectangle rectangle) {
        if (this.npoints == 0) {
            rectangle.setBounds(0, 0, 0, 0);
        }
        if (this.bounds == null) {
            this.bounds = this.getBounds();
        }
        rectangle.setBounds(this.bounds.x, this.bounds.y, this.bounds.width, this.bounds.height);
    }

    public int hashCode() {
        if (hcb == null) {
            hcb = new HashCodeBuilder();
        }
        hcb.reset();
        hcb.append(this.npoints);
        hcb.append(this.xpoints);
        hcb.append(this.ypoints);
        return hcb.hashCode();
    }

    public void invalidate() {
        this.bounds = null;
    }

    public void reset() {
        this.npoints = 0;
        this.invalidate();
    }

    public void translate(int n, int n2) {
        int n3 = 0;
        while (n3 < this.npoints) {
            int n4 = n3;
            this.xpoints[n4] = this.xpoints[n4] + n;
            int n5 = n3++;
            this.ypoints[n5] = this.ypoints[n5] + n2;
        }
        if (this.bounds != null) {
            this.bounds.translate(n, n2);
        }
    }

    static {
        ARRAY_INCREMENT = 4;
    }
}

