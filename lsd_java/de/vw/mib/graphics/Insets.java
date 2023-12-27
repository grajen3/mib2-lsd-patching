/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.pool.PooledObject;
import de.vw.mib.util.StringBuilder;
import java.io.Serializable;

public final class Insets
implements Cloneable,
Serializable,
PooledObject {
    private static final long serialVersionUID;
    private static HashCodeBuilder hcb;
    public int top;
    public int left;
    public int bottom;
    public int right;

    public Insets() {
    }

    public Insets(int n, int n2, int n3, int n4) {
        this.top = n;
        this.left = n2;
        this.bottom = n3;
        this.right = n4;
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
        hcb.append(this.top);
        hcb.append(this.left);
        hcb.append(this.bottom);
        hcb.append(this.right);
        return hcb.hashCode();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object != null && super.getClass() == object.getClass()) {
            Insets insets = (Insets)object;
            return this.top == insets.top && this.left == insets.left && this.bottom == insets.bottom && this.right == insets.right;
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[top=").append(this.top);
        stringBuilder.append(",left=").append(this.left);
        stringBuilder.append(",bottom=").append(this.bottom);
        stringBuilder.append(",right=").append(this.right);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public void backToPool() {
        this.top = 0;
        this.left = 0;
        this.bottom = 0;
        this.right = 0;
    }

    public int getTop() {
        return this.top;
    }

    public void setTop(int n) {
        this.top = n;
    }

    public int getLeft() {
        return this.left;
    }

    public void setLeft(int n) {
        this.left = n;
    }

    public int getBottom() {
        return this.bottom;
    }

    public void setBottom(int n) {
        this.bottom = n;
    }

    public int getRight() {
        return this.right;
    }

    public void setRight(int n) {
        this.right = n;
    }

    public void set(int n, int n2, int n3, int n4) {
        this.top = n;
        this.left = n2;
        this.bottom = n3;
        this.right = n4;
    }
}

