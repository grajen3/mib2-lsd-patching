/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.base;

import org.dsi.ifc.base.IFactory;

public interface IAdapterManager {
    default public void registerFactories(IFactory iFactory) {
    }

    default public void unregisterFactories(IFactory iFactory) {
    }

    default public Object getFactory(Class clazz) {
    }
}

