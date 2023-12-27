/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.amfm.persistence.ResourceLocatorPersistence;
import de.vw.mib.asl.framework.api.persistence2.Persistable;

public interface SatImage
extends Persistable {
    default public int getSid() {
    }

    default public void setSid(int n) {
    }

    default public ResourceLocatorPersistence getResourceLocator() {
    }

    default public void setResourceLocator(ResourceLocatorPersistence resourceLocatorPersistence) {
    }
}

