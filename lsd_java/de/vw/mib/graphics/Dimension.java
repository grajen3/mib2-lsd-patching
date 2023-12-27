/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.pool.PooledObject;
import de.vw.mib.util.StringBuilder;
import java.io.Serializable;

public final class Dimension
implements Serializable,
Cloneable,
PooledObject {
    private static final long serialVersionUID;
    private static HashCodeBuilder hcb;
    public int width;
    public int height;

    public Dimension() {
        this(0, 0);
    }

    public Dimension(Dimension dimension) {
        this(dimension.width, dimension.height);
    }

    public Dimension(int n, int n2) {
        this.width = n;
        this.height = n2;
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
        hcb.append(this.width);
        hcb.append(this.height);
        return hcb.hashCode();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object != null && super.getClass() == object.getClass()) {
            Dimension dimension = (Dimension)object;
            return this.width == dimension.width && this.height == dimension.height;
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[width=").append(this.width);
        stringBuilder.append(",height=").append(this.height);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public void backToPool() {
        this.width = 0;
        this.height = 0;
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
}

