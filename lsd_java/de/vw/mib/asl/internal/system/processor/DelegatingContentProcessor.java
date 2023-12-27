/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.processor;

import de.vw.mib.app.desktop.ContentProcessor;
import de.vw.mib.asl.api.system.contentprocessor.AbstractContentProcessor;
import de.vw.mib.collections.ObjectObjectMap;
import de.vw.mib.collections.ObjectObjectOptHashMap;

public class DelegatingContentProcessor
implements ContentProcessor {
    private final ObjectObjectMap mapScreenAreaToDelegate = new ObjectObjectOptHashMap();

    @Override
    public boolean requestContent(String string, String string2) {
        if (this.mapScreenAreaToDelegate.containsKey(string)) {
            AbstractContentProcessor abstractContentProcessor = (AbstractContentProcessor)this.mapScreenAreaToDelegate.get(string);
            abstractContentProcessor.requestContent(string2);
            return true;
        }
        return false;
    }

    public void addDelegate(String string, AbstractContentProcessor abstractContentProcessor) {
        this.verifyArguments(string, abstractContentProcessor);
        this.mapScreenAreaToDelegate.put(string, abstractContentProcessor);
    }

    private void verifyArguments(String string, AbstractContentProcessor abstractContentProcessor) {
        if (abstractContentProcessor == null) {
            throw new IllegalArgumentException("The given delegate must not be null.");
        }
        if (string == null) {
            throw new IllegalArgumentException("The given screen area must not be null.");
        }
        if (this.mapScreenAreaToDelegate.containsKey(string)) {
            throw new IllegalArgumentException(new StringBuffer().append("A delegate was alread added for screan area ").append(string).append(".").toString());
        }
    }
}

