/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.asl;

import java.util.Hashtable;

public class AbstractReflectionContext
extends Hashtable {
    public int getIntValue(String string, int n) {
        Object object = this.get(string);
        if (object instanceof Number) {
            return ((Number)object).intValue();
        }
        return n;
    }

    public void setIntValue(String string, int n) {
        this.put(string, new Integer(n));
    }
}

