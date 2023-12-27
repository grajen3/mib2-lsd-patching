/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.common.api.onlineupdatev10.data;

import de.vw.mib.asl.internal.ocu.common.api.onlineupdatev10.mapping.OnlineUpdateMapping;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.OnlineUpdateList_Data;

public class OnlineUpdateListEntry
implements de.vw.mib.asl.api.ocu.onlineupdatev10.data.OnlineUpdateListEntry {
    private final String updateId;
    private final String updateDescription;
    private final long downloadSize;
    private final int estimatedUpdateDuration;
    private final int language;

    public OnlineUpdateListEntry(OnlineUpdateList_Data onlineUpdateList_Data) {
        this.updateId = onlineUpdateList_Data.updateId.toString();
        this.updateDescription = onlineUpdateList_Data.descriptionOnlineUpdate.toString();
        this.downloadSize = OnlineUpdateMapping.mapDownloadSize(onlineUpdateList_Data.downloadSize, onlineUpdateList_Data.downloadSizeUnit);
        this.estimatedUpdateDuration = onlineUpdateList_Data.estimatedUpdateDuration * 60;
        this.language = onlineUpdateList_Data.language;
    }

    @Override
    public String getUpdateId() {
        return this.updateId;
    }

    @Override
    public String getUpdateDescription() {
        return this.updateDescription;
    }

    @Override
    public long getDownloadSize() {
        return this.downloadSize;
    }

    @Override
    public int getEstimatedUpdateDuration() {
        return this.estimatedUpdateDuration;
    }

    @Override
    public int getLanguange() {
        return this.language;
    }

    public int hashCode() {
        int n = 31;
        int n2 = 1;
        n2 = 31 * n2 + (int)this.downloadSize;
        n2 = 31 * n2 + this.estimatedUpdateDuration;
        n2 = 31 * n2 + this.language;
        n2 = 31 * n2 + (this.updateDescription == null ? 0 : this.updateDescription.hashCode());
        n2 = 31 * n2 + (this.updateId == null ? 0 : this.updateId.hashCode());
        return n2;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        OnlineUpdateListEntry onlineUpdateListEntry = (OnlineUpdateListEntry)object;
        if (this.downloadSize != onlineUpdateListEntry.downloadSize) {
            return false;
        }
        if (this.estimatedUpdateDuration != onlineUpdateListEntry.estimatedUpdateDuration) {
            return false;
        }
        if (this.language != onlineUpdateListEntry.language) {
            return false;
        }
        if (this.updateDescription == null ? onlineUpdateListEntry.updateDescription != null : !this.updateDescription.equals(onlineUpdateListEntry.updateDescription)) {
            return false;
        }
        return !(this.updateId == null ? onlineUpdateListEntry.updateId != null : !this.updateId.equals(onlineUpdateListEntry.updateId));
    }
}

