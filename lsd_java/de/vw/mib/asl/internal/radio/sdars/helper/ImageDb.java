/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.helper;

import de.vw.mib.asl.framework.api.persistence.PersistenceInputStream;
import de.vw.mib.asl.framework.api.persistence.PersistenceUtil;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.asl.internal.radio.sdars.helper.SatUtil;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.log4mib.LogMessage;
import org.dsi.ifc.global.ResourceLocator;

public final class ImageDb {
    private final SatDb mDb;
    private final IntObjectMap mImageMap;

    ImageDb(SatDb satDb) {
        this.mDb = satDb;
        this.mImageMap = new IntObjectOptHashMap(384);
    }

    public void addImage(int n, ResourceLocator resourceLocator) {
        boolean bl;
        if (resourceLocator != null && (bl = SatUtil.isValid(resourceLocator))) {
            boolean bl2 = false;
            ResourceLocator resourceLocator2 = (ResourceLocator)this.mImageMap.get(n);
            if (resourceLocator2 == null) {
                bl2 = true;
            } else {
                boolean bl3 = SatUtil.equals(resourceLocator, resourceLocator2);
                if (!bl3) {
                    bl2 = true;
                }
            }
            if (bl2) {
                LogMessage logMessage;
                this.mImageMap.put(n, resourceLocator);
                if (resourceLocator2 != null && (logMessage = this.mDb.getLogHandler().getLogMsg()) != null) {
                    logMessage.append("Change Image: old=");
                    logMessage.append(resourceLocator2.toString());
                    logMessage.append(", new=");
                    logMessage.append(resourceLocator.toString());
                    logMessage.log();
                }
            }
        }
    }

    public void removeImage(int n) {
        this.mImageMap.remove(n);
    }

    public ResourceLocator getImage(int n) {
        ResourceLocator resourceLocator = (ResourceLocator)this.mImageMap.get(n);
        if (n != 0 && resourceLocator == null) {
            ResourceLocator resourceLocator2;
            resourceLocator = resourceLocator2 = (ResourceLocator)this.mImageMap.get(0);
        }
        return resourceLocator;
    }

    public void fromStream(PersistenceInputStream persistenceInputStream, short s) {
        int n;
        if (s >= 14 && (n = persistenceInputStream.readShort()) > 0) {
            boolean bl = Boolean.getBoolean("de.vw.mib.asl.internal.radio.sdars.load_image_db");
            for (int i2 = 0; i2 < n; ++i2) {
                short s2 = persistenceInputStream.readShort();
                ResourceLocator resourceLocator = PersistenceUtil.readResourceLocator(persistenceInputStream);
                if (!bl) continue;
                this.addImage(s2, resourceLocator);
            }
        }
    }

    public IntObjectMap getImageMap() {
        return this.mImageMap;
    }
}

