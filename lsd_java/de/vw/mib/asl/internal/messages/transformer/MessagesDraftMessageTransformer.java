/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.messages.transformer;

import generated.de.vw.mib.asl.internal.messages.transformer.AbstractMessagesDraftMessageTransformer;
import org.dsi.ifc.messaging.ListEntry;

public class MessagesDraftMessageTransformer
extends AbstractMessagesDraftMessageTransformer {
    @Override
    public String getString(int n, Object object) {
        ListEntry listEntry = (ListEntry)object;
        switch (n) {
            case 0: {
                if (listEntry.getMessageListEntry().getMatchedAddress().getAdbEntryID() != 0L) {
                    return listEntry.getMessageListEntry().getMatchedAddress().getName();
                }
                return listEntry.getMessageListEntry().getRecipients()[0];
            }
            case 1: {
                if (listEntry.getMessageListEntry().getMatchedAddress().getAdbEntryID() != 0L) {
                    return listEntry.getMessageListEntry().getMatchedAddress().getAddress();
                }
                return listEntry.getMessageListEntry().getRecipients()[0];
            }
            case 2: {
                return listEntry.getMessageListEntry().getSubject();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        switch (n) {
            case 3: {
                return true;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }
}

