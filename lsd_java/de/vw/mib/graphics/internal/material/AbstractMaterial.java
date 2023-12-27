/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.material;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.util.StringBuilder;
import java.io.Serializable;

public abstract class AbstractMaterial
implements Cloneable,
Serializable {
    private static final long serialVersionUID;
    private static HashCodeBuilder hcb;

    public AbstractMaterial() {
    }

    public AbstractMaterial(AbstractMaterial abstractMaterial) {
    }

    public Object clone() {
        try {
            AbstractMaterial abstractMaterial = (AbstractMaterial)super.clone();
            return abstractMaterial;
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
        return hcb.hashCode();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object != null && super.getClass() == object.getClass()) {
            AbstractMaterial abstractMaterial = (AbstractMaterial)object;
            return false;
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

