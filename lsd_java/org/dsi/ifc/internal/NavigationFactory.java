/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.internal;

import org.dsi.ifc.base.IFactory;
import org.dsi.ifc.internal.EBLocationAccessorFactory;
import org.dsi.ifc.navigation.util.ILocationAccessorFactory;

public class NavigationFactory
implements IFactory {
    private final ILocationAccessorFactory locationFactory = new EBLocationAccessorFactory();
    static /* synthetic */ Class class$org$dsi$ifc$navigation$util$ILocationAccessorFactory;

    @Override
    public Object getFactory(Class clazz) {
        if (clazz == null) {
            return null;
        }
        if (clazz.equals(class$org$dsi$ifc$navigation$util$ILocationAccessorFactory == null ? (class$org$dsi$ifc$navigation$util$ILocationAccessorFactory = NavigationFactory.class$("org.dsi.ifc.navigation.util.ILocationAccessorFactory")) : class$org$dsi$ifc$navigation$util$ILocationAccessorFactory)) {
            return this.locationFactory;
        }
        return null;
    }

    @Override
    public Class[] getFactoryList() {
        return new Class[]{class$org$dsi$ifc$navigation$util$ILocationAccessorFactory == null ? (class$org$dsi$ifc$navigation$util$ILocationAccessorFactory = NavigationFactory.class$("org.dsi.ifc.navigation.util.ILocationAccessorFactory")) : class$org$dsi$ifc$navigation$util$ILocationAccessorFactory};
    }

    @Override
    public boolean shouldOverride(IFactory iFactory) {
        return false;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError(classNotFoundException.getMessage());
        }
    }
}

