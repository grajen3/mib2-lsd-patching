/*
 * Decompiled with CFR 0.152.
 */
package com.sun.opengl.impl;

import java.lang.reflect.Field;

public class GLProcAddressTable {
    public long _addressof_glCoverageMaskNV;
    public long _addressof_glCoverageOperationNV;

    public long getAddressFor(String string) {
        String string2 = new StringBuffer().append("_addressof_").append(string).toString();
        try {
            Field field = super.getClass().getField(string2);
            return field.getLong(this);
        }
        catch (Exception exception) {
            throw new RuntimeException(new StringBuffer().append("WARNING: Address query failed for \"").append(string).append("\"; it's either statically linked or is not a known ").append("function").toString(), exception);
        }
    }
}

