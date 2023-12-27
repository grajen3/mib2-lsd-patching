/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.transformer;

import generated.de.vw.mib.asl.internal.system.transformer.AbstractSystemCalendarListNextMonthTransformer;

public class SystemCalendarListNextMonthTransformer
extends AbstractSystemCalendarListNextMonthTransformer {
    @Override
    public String getString(int n, Object object) {
        if (n == 0) {
            return (String)object;
        }
        throw new IllegalArgumentException();
    }
}

