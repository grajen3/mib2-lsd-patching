/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.base;

public interface IFactory {
    default public Object getFactory(Class clazz) {
    }

    default public Class[] getFactoryList() {
    }

    default public boolean shouldOverride(IFactory iFactory) {
    }
}

