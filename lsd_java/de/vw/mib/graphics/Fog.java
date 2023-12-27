/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics;

import java.io.Serializable;

public final class Fog
implements Cloneable,
Serializable {
    private static final long serialVersionUID;

    public Object clone() {
        try {
            Fog fog = (Fog)super.clone();
            return fog;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new RuntimeException(cloneNotSupportedException);
        }
    }
}

