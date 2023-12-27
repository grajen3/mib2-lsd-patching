/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.messages.contacts.search.transformer;

import generated.de.vw.mib.asl.internal.messages.contacts.search.transformer.AbstractMessagesContactsSearchSpellerPreviewListTransformer;
import org.dsi.ifc.organizer.DataSet;

public class MessagesContactsSearchSpellerPreviewListTransformer
extends AbstractMessagesContactsSearchSpellerPreviewListTransformer {
    @Override
    public String getString(int n, Object object) {
        DataSet dataSet = (DataSet)object;
        switch (n) {
            case 0: {
                return dataSet.getGeneralDescription1();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }
}

