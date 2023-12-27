/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl.ext.traffic;

import de.vw.mib.asl.api.navigation.traffic.IResourceLocatorExtern;
import org.dsi.ifc.global.ResourceLocator;

public class IResourceLocatorExternImpl
implements IResourceLocatorExtern {
    private int id;
    private String url;

    public IResourceLocatorExternImpl(ResourceLocator resourceLocator) {
        if (resourceLocator != null) {
            this.setId(resourceLocator.getId());
            this.setUrl(resourceLocator.getUrl());
        } else {
            this.setId(0);
            this.setUrl("");
        }
    }

    @Override
    public int getId() {
        return this.id;
    }

    private void setId(int n) {
        this.id = n;
    }

    @Override
    public String getUrl() {
        return this.url;
    }

    private void setUrl(String string) {
        this.url = string;
    }
}

