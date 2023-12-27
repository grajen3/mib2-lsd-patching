/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.features.model;

import de.vw.mib.asl.api.speechengine.features.model.DynamicString;

public class DynamicStringImpl
implements DynamicString {
    private final String value;
    private final boolean isDynamic;

    public DynamicStringImpl(String string, boolean bl) {
        this.value = string;
        this.isDynamic = bl;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public boolean isDynamic() {
        return this.isDynamic;
    }
}

