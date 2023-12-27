/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal;

import de.vw.mib.collections.ObjectOptHashSet;
import de.vw.mib.perf.service.PerfService;
import de.vw.mib.skin.SkinClassLoader;
import de.vw.mib.util.StringBuilder;
import de.vw.mib.view.internal.CommonViewHandler;
import de.vw.mib.view.internal.ViewHandlerAppServices;
import de.vw.mib.view.internal.ViewHandlerServices;
import de.vw.mib.viewmanager.internal.PopupViewHandler;
import de.vw.mib.viewmanager.internal.ViewHandler;
import de.vw.mib.viewmanager.internal.ViewHandlerFactory;
import java.util.Set;

public abstract class LocalViewHandlerFactory
implements ViewHandlerFactory {
    private static final String[] EMPTY_NAMES = new String[0];
    private final SkinClassLoader skinClassLoader;
    private final PerfService perfService;
    private final ViewHandlerServices viewHandlerServices;
    private final ViewHandlerAppServices viewHandlerAppServices;

    public LocalViewHandlerFactory(SkinClassLoader skinClassLoader, PerfService perfService, ViewHandlerServices viewHandlerServices, ViewHandlerAppServices viewHandlerAppServices) {
        this.skinClassLoader = skinClassLoader;
        this.perfService = perfService;
        this.viewHandlerServices = viewHandlerServices;
        this.viewHandlerAppServices = viewHandlerAppServices;
    }

    protected static StringBuilder newBuffer(String string) {
        StringBuilder stringBuilder = new StringBuilder(string.length() + 30);
        stringBuilder.append(string);
        return stringBuilder;
    }

    protected static Set setOf(String[] stringArray) {
        ObjectOptHashSet objectOptHashSet = new ObjectOptHashSet(stringArray.length);
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            objectOptHashSet.add(stringArray[i2]);
        }
        return objectOptHashSet;
    }

    @Override
    public final ViewHandler createViewHandler(String string) {
        return this.createHandler(string);
    }

    @Override
    public final PopupViewHandler createPopupViewHandler(String string) {
        if (this.isAppPopup(string)) {
            return this.createHandler(string);
        }
        return null;
    }

    protected boolean isAppPopup(String string) {
        return false;
    }

    private CommonViewHandler createHandler(String string) {
        this.perfService.performanceLogViewHandler(string, 3);
        String string2 = this.getQualifiedClassName(string);
        CommonViewHandler commonViewHandler = (CommonViewHandler)this.skinClassLoader.getViewHandler(string2);
        if (commonViewHandler != null) {
            commonViewHandler.postConstructor(this.viewHandlerServices, this.viewHandlerAppServices);
        }
        this.perfService.performanceLogViewHandler(string, 4);
        return commonViewHandler;
    }

    protected abstract String getQualifiedClassName(String string) {
    }

    protected static String buildQualifiedClassName(StringBuilder stringBuilder, String string) {
        int n = stringBuilder.length();
        String string2 = stringBuilder.append(string).toString();
        stringBuilder.setLength(n);
        return string2;
    }

    @Override
    public String[] getFastAccessibleViewHandler() {
        return EMPTY_NAMES;
    }

    @Override
    public String[] getFastAccessiblePopupViewHandler() {
        return EMPTY_NAMES;
    }

    @Override
    public String getDarkFaderIndicatorViewHandler() {
        return null;
    }

    @Override
    public String getPopupBackgroundViewHandler() {
        return null;
    }
}

