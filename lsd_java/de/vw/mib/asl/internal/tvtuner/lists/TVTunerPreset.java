/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.tvtuner.lists;

import de.vw.mib.asl.framework.api.persistence.Persistable;
import de.vw.mib.asl.framework.api.persistence.PersistenceInputStream;
import de.vw.mib.asl.framework.api.persistence.PersistenceOutputStream;
import org.dsi.ifc.tvtuner.ServiceInfo;

public class TVTunerPreset
extends ServiceInfo
implements Persistable {
    public int tvNormArea;

    public TVTunerPreset() {
        super(0L, 0, "", -1, 0);
        this.tvNormArea = 0;
    }

    public TVTunerPreset(ServiceInfo serviceInfo) {
        super(serviceInfo.namePID, serviceInfo.servicePID, serviceInfo.name, serviceInfo.sType, serviceInfo.contentGroup);
    }

    public TVTunerPreset(ServiceInfo serviceInfo, int n) {
        super(serviceInfo.namePID, serviceInfo.servicePID, serviceInfo.name, serviceInfo.sType, serviceInfo.contentGroup);
        this.tvNormArea = n;
    }

    public TVTunerPreset(PersistenceInputStream persistenceInputStream) {
        this.fromStream(persistenceInputStream);
    }

    @Override
    public void fromStream(PersistenceInputStream persistenceInputStream) {
        this.name = persistenceInputStream.readString();
        this.namePID = persistenceInputStream.readLong();
        this.servicePID = persistenceInputStream.readInt();
        this.sType = persistenceInputStream.readInt();
        this.contentGroup = persistenceInputStream.readInt();
        this.tvNormArea = persistenceInputStream.readInt();
    }

    @Override
    public void toStream(PersistenceOutputStream persistenceOutputStream) {
        persistenceOutputStream.writeString(this.name);
        persistenceOutputStream.writeLong(this.namePID);
        persistenceOutputStream.writeInt(this.servicePID);
        persistenceOutputStream.writeInt(this.sType);
        persistenceOutputStream.writeInt(this.contentGroup);
        persistenceOutputStream.writeInt(this.tvNormArea);
    }

    @Override
    public void clear() {
        this.name = "";
        this.namePID = 0L;
        this.servicePID = 0;
        this.sType = -1;
        this.contentGroup = 0;
        this.tvNormArea = 0;
    }

    public int getTvNormArea() {
        return this.tvNormArea;
    }
}

