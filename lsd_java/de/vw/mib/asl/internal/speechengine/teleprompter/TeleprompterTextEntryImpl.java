/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.teleprompter;

import de.vw.mib.asl.api.speechengine.features.model.DynamicString;
import de.vw.mib.asl.api.speechengine.teleprompter.data.TeleprompterTextEntry;

public class TeleprompterTextEntryImpl
implements TeleprompterTextEntry {
    private final DynamicString dynamicString;

    public TeleprompterTextEntryImpl(DynamicString dynamicString) {
        this.dynamicString = dynamicString;
    }

    @Override
    public String getText() {
        return this.dynamicString.getValue();
    }

    @Override
    public boolean containsDynamicParts() {
        return this.dynamicString.isDynamic();
    }
}

