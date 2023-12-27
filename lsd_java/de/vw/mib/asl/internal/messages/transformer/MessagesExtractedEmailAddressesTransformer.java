/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.messages.transformer;

import generated.de.vw.mib.asl.internal.messages.transformer.AbstractMessagesExtractedEmailAddressesTransformer;

public class MessagesExtractedEmailAddressesTransformer
extends AbstractMessagesExtractedEmailAddressesTransformer {
    @Override
    public String getString(int n, Object object) {
        String string = (String)object;
        switch (n) {
            case 0: {
                return string;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }
}

