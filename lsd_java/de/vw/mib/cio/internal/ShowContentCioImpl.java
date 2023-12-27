/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cio.internal;

import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.app.framework.ShowContentCio;
import de.vw.mib.cio.app.framework.ShowContentCioExecutor;
import de.vw.mib.cio.internal.AbstractCio;
import de.vw.mib.cio.internal.Dictionary;
import de.vw.mib.cio.internal.ScriptWidgetService;

final class ShowContentCioImpl
extends AbstractCio
implements ShowContentCio {
    private final ShowContentCioExecutor executor;
    private final String contentId;
    private final String screenAreaId;

    ShowContentCioImpl(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, int n, long l, long[] lArray, ShowContentCioExecutor showContentCioExecutor, Dictionary dictionary, ScriptWidgetService scriptWidgetService) {
        super(string, string2, string5, 0, string6, string7, string8, n, l, lArray, dictionary, scriptWidgetService);
        this.contentId = string3;
        this.screenAreaId = string4;
        this.executor = showContentCioExecutor;
    }

    @Override
    public String getContentId() {
        return this.contentId;
    }

    @Override
    public String getScreenAreaId() {
        return this.screenAreaId;
    }

    @Override
    void execute(CioActionParameters cioActionParameters) {
        this.executor.execute(this);
    }
}

