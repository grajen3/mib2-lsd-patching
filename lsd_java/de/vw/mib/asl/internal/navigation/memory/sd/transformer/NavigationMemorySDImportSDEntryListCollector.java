/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.memory.sd.transformer;

import org.dsi.ifc.global.ResourceLocator;

public class NavigationMemorySDImportSDEntryListCollector {
    private String name;
    private ResourceLocator resourceLocator;
    private boolean selected;

    public NavigationMemorySDImportSDEntryListCollector() {
    }

    public NavigationMemorySDImportSDEntryListCollector(ResourceLocator resourceLocator) {
        this.setResourceLocator(resourceLocator);
    }

    public NavigationMemorySDImportSDEntryListCollector(String string, boolean bl) {
        this.name = string;
        this.selected = bl;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void setSelected(boolean bl) {
        this.selected = bl;
    }

    public void setResourceLocator(ResourceLocator resourceLocator) {
        this.resourceLocator = resourceLocator;
    }

    public ResourceLocator getResourceLocator() {
        return this.resourceLocator;
    }
}

