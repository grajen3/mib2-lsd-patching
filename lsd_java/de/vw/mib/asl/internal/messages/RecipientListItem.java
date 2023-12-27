/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.messages;

import org.dsi.ifc.global.ResourceLocator;

public class RecipientListItem {
    public long entryId;
    public int numberType;
    public String number;
    public String name;
    public ResourceLocator picture;

    public RecipientListItem(long l, int n, String string, String string2, ResourceLocator resourceLocator) {
        this.entryId = l;
        this.numberType = n;
        this.number = string;
        this.name = string2;
        this.picture = resourceLocator;
    }

    public boolean equals(Object object) {
        if (object == null || super.getClass() != object.getClass()) {
            return false;
        }
        RecipientListItem recipientListItem = (RecipientListItem)object;
        return recipientListItem.entryId == this.entryId && recipientListItem.number.equals(this.number);
    }

    public int hashCode() {
        int n = 1;
        n = (int)((long)n * (0 + this.entryId));
        n = this.number != null ? n * 31 + this.number.hashCode() : (n *= 31 + this.numberType);
        return n;
    }
}

