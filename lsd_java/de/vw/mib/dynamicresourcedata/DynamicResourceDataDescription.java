/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dynamicresourcedata;

import de.vw.mib.dynamicresourcedata.DynamicResourceData;

public interface DynamicResourceDataDescription {
    default public DynamicResourceDataDescription input(String string) {
    }

    default public DynamicResourceDataDescription output(String string, int n) {
    }

    default public DynamicResourceData create() {
    }
}

