/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.messages.transformer;

import generated.de.vw.mib.asl.internal.messages.transformer.AbstractMessagesSelectedMessageContactsTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class MessagesSelectedMessageContactsTransformer
extends AbstractMessagesSelectedMessageContactsTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        return false;
    }

    @Override
    public long getLong(int n, Object object) {
        return 0L;
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        return new ResourceLocator();
    }

    @Override
    public String getString(int n, Object object) {
        return "";
    }
}

