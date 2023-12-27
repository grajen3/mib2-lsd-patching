/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.persistence2;

import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistableFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;

public interface PersistenceModule {
    default public String getName() {
    }

    default public long getVersion() {
    }

    default public HandlerFactory getHandlerFactory() {
    }

    default public PersistableFactory getPersistableFactory() {
    }

    default public PersistableSerializerFactory getSerializerFactory() {
    }

    default public byte[] getDeclaration() {
    }

    default public boolean isUserSpecific() {
    }
}

