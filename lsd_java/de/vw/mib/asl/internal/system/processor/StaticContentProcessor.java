/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.processor;

import de.vw.mib.asl.api.system.contentprocessor.AbstractContentProcessor;
import de.vw.mib.log4mib.Logger;

public class StaticContentProcessor
extends AbstractContentProcessor {
    public StaticContentProcessor(Logger logger, String string, String string2) {
        super(logger, string);
        this.updateContent(string2);
    }

    @Override
    public void requestContent(String string) {
    }
}

