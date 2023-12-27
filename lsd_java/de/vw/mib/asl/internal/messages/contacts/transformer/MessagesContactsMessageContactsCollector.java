/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.messages.contacts.transformer;

import org.dsi.ifc.organizer.DataSet;

public class MessagesContactsMessageContactsCollector {
    public DataSet dataSet;
    public boolean isSelected;

    public MessagesContactsMessageContactsCollector(DataSet dataSet, boolean bl) {
        this.dataSet = dataSet;
        this.isSelected = bl;
    }
}

