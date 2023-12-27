/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cio.internal;

import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioExecutor;
import de.vw.mib.cio.CioPayload;
import de.vw.mib.cio.internal.AbstractCio;
import de.vw.mib.cio.internal.Dictionary;
import de.vw.mib.cio.internal.ScriptWidgetService;

final class Cio
extends AbstractCio {
    private final CioExecutor executor;

    Cio(String string, String string2, String string3, int n, String string4, String string5, String string6, int n2, long l, long[] lArray, CioExecutor cioExecutor, Dictionary dictionary, ScriptWidgetService scriptWidgetService) {
        this(string, string2, string3, n, string4, string5, string6, n2, null, null, l, lArray, cioExecutor, dictionary, scriptWidgetService);
    }

    Cio(String string, String string2, String string3, int n, String string4, String string5, String string6, int n2, CioPayload cioPayload, Object object, long l, long[] lArray, CioExecutor cioExecutor, Dictionary dictionary, ScriptWidgetService scriptWidgetService) {
        super(string, string2, string3, n, string4, string5, string6, n2, cioPayload, object, l, lArray, dictionary, scriptWidgetService);
        this.executor = cioExecutor;
    }

    @Override
    public String getCioExecutor() {
        return this.executor.toString();
    }

    @Override
    void execute(CioActionParameters cioActionParameters) {
        this.executor.execute(this, cioActionParameters);
    }
}

