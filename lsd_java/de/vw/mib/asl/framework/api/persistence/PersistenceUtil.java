/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.persistence;

import de.vw.mib.asl.framework.api.persistence.PersistenceInputStream;
import de.vw.mib.asl.framework.api.persistence.PersistenceOutputStream;
import org.dsi.ifc.global.ResourceLocator;

public final class PersistenceUtil {
    private PersistenceUtil() {
    }

    public static ResourceLocator readResourceLocator(PersistenceInputStream persistenceInputStream) {
        boolean bl = persistenceInputStream.readBoolean();
        if (bl) {
            ResourceLocator resourceLocator = new ResourceLocator();
            boolean bl2 = persistenceInputStream.readBoolean();
            if (bl2) {
                resourceLocator.id = persistenceInputStream.readInt();
            } else {
                resourceLocator.url = persistenceInputStream.readString();
            }
            return resourceLocator;
        }
        return null;
    }

    public static void writeResourceLocator(ResourceLocator resourceLocator, PersistenceOutputStream persistenceOutputStream) {
        if (resourceLocator == null) {
            persistenceOutputStream.writeBoolean(false);
        } else {
            persistenceOutputStream.writeBoolean(true);
            boolean bl = resourceLocator.isIntResource();
            persistenceOutputStream.writeBoolean(bl);
            if (bl) {
                persistenceOutputStream.writeInt(resourceLocator.id);
            } else {
                persistenceOutputStream.writeString(resourceLocator.url);
            }
        }
    }
}

