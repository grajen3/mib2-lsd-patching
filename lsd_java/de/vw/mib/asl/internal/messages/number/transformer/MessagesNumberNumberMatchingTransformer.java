/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.messages.number.transformer;

import generated.de.vw.mib.asl.internal.messages.number.transformer.AbstractMessagesNumberNumberMatchingTransformer;

public class MessagesNumberNumberMatchingTransformer
extends AbstractMessagesNumberNumberMatchingTransformer {
    @Override
    public String getString(int n, Object object) {
        switch (n) {
            case 0: {
                return "";
            }
            case 1: {
                return "";
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }
}

