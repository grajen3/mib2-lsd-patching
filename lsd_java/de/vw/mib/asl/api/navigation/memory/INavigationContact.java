/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.memory;

import de.vw.mib.asl.api.navigation.memory.INavigationContactAddress;
import org.dsi.ifc.global.ResourceLocator;

public interface INavigationContact {
    default public long getId() {
    }

    default public String getName() {
    }

    default public ResourceLocator getIcon() {
    }

    default public INavigationContactAddress[] getAddresses() {
    }
}

