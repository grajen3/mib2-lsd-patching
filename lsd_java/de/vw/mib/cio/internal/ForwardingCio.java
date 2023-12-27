/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cio.internal;

import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.internal.AbstractCio;
import de.vw.mib.cio.internal.Dictionary;
import de.vw.mib.cio.internal.ScriptWidgetService;

final class ForwardingCio
extends AbstractCio {
    private final AbstractCio targetCio;

    ForwardingCio(String string, String string2, String string3, String string4, String string5, String string6, int n, long l, long[] lArray, AbstractCio abstractCio, Dictionary dictionary, ScriptWidgetService scriptWidgetService) {
        super(string, string2, string3, abstractCio.getActionId(), string4, string5, string6, n, l, lArray, dictionary, scriptWidgetService);
        this.targetCio = abstractCio;
    }

    ForwardingCio(String string, String string2, String string3, String string4, String string5, String string6, int n, long l, AbstractCio abstractCio, Dictionary dictionary, ScriptWidgetService scriptWidgetService) {
        this(string, string2, string3, string4, string5, string6, n, l, abstractCio.getVisualizationIds(), abstractCio, dictionary, scriptWidgetService);
    }

    @Override
    public boolean isAvailable() {
        return super.isAvailable() & this.targetCio.isAvailable();
    }

    @Override
    void execute(CioActionParameters cioActionParameters) {
        this.targetCio.execute(cioActionParameters);
    }
}

