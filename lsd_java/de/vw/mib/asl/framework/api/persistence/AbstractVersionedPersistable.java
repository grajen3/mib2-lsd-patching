/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.persistence;

import de.vw.mib.asl.framework.api.persistence.PersistenceInputStream;
import de.vw.mib.asl.framework.api.persistence.PersistenceOutputStream;
import de.vw.mib.asl.framework.api.persistence.VersionedPersistable;
import java.io.IOException;

public abstract class AbstractVersionedPersistable
implements VersionedPersistable {
    @Override
    public final short getCorrectOrSupportedVersion(PersistenceInputStream persistenceInputStream) {
        short s = persistenceInputStream.readShort();
        if (s == this.getVersion()) {
            return s;
        }
        short[] sArray = this.getSupportedVersions();
        boolean bl = false;
        for (int i2 = 0; i2 < sArray.length; ++i2) {
            if (s != sArray[i2]) continue;
            bl = true;
            break;
        }
        if (bl) {
            return s;
        }
        throw new IOException(new StringBuffer().append("Persistable Version not supported! Found version: ").append(s).toString());
    }

    @Override
    public final void fromStream(PersistenceInputStream persistenceInputStream) {
        short s = this.getCorrectOrSupportedVersion(persistenceInputStream);
        if (s != -1) {
            this.fromStreamInternal(persistenceInputStream, s);
        }
    }

    @Override
    public final void toStream(PersistenceOutputStream persistenceOutputStream) {
        persistenceOutputStream.writeShort(this.getVersion());
        this.toStreamInternal(persistenceOutputStream);
    }
}

