/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.api.model;

import de.vw.mib.asl.api.phone.services.CommonContact;
import org.dsi.ifc.global.ResourceLocator;

public abstract class CommonContactImpl
implements CommonContact {
    private final long contactId;
    private final String combinedName;
    private final ResourceLocator image;
    private final int telEntryType;

    public CommonContactImpl(long l, String string, ResourceLocator resourceLocator, int n) {
        this.contactId = l;
        this.combinedName = string;
        this.image = resourceLocator;
        this.telEntryType = n;
    }

    @Override
    public long getContactId() {
        return this.contactId;
    }

    @Override
    public String getCombinedName() {
        return this.combinedName;
    }

    @Override
    public ResourceLocator getImage() {
        return this.image;
    }

    @Override
    public int getTelEntryType() {
        return this.telEntryType;
    }

    public String toString() {
        return new StringBuffer().append("CommonContactImpl [contactId=").append(this.contactId).append(", combinedName=").append(this.combinedName).append(", image=").append(this.image).append(", telEntryType=").append(this.telEntryType).append(", numberCount=").append(this.getNumberCount()).append("]").toString();
    }
}

