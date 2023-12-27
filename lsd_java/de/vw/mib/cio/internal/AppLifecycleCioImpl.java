/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cio.internal;

import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.app.framework.AppLifecycleCio;
import de.vw.mib.cio.app.framework.AppLifecycleCioExecutor;
import de.vw.mib.cio.internal.AbstractCio;
import de.vw.mib.cio.internal.Dictionary;
import de.vw.mib.cio.internal.ScriptWidgetService;
import de.vw.mib.util.StringBuilder;

final class AppLifecycleCioImpl
extends AbstractCio
implements AppLifecycleCio {
    private final AppLifecycleCioExecutor executor;

    AppLifecycleCioImpl(String string, String string2, String string3, String string4, String string5, String string6, int n, long l, long[] lArray, AppLifecycleCioExecutor appLifecycleCioExecutor, Dictionary dictionary, ScriptWidgetService scriptWidgetService) {
        super(string, string2, string3, 0, string4, string5, string6, n, l, lArray, dictionary, scriptWidgetService);
        this.executor = appLifecycleCioExecutor;
    }

    @Override
    void execute(CioActionParameters cioActionParameters) {
        this.executor.execute(this, cioActionParameters);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("AppLifecycleCioIntent - ");
        stringBuilder.append("appName: ").append(this.appName);
        return stringBuilder.toString();
    }
}

