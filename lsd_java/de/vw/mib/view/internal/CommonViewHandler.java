/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.view.internal.ViewHandlerAppServices;
import de.vw.mib.view.internal.ViewHandlerServices;
import de.vw.mib.viewmanager.internal.PopupViewHandler;
import de.vw.mib.viewmanager.internal.ViewHandler;

public interface CommonViewHandler
extends ViewHandler,
PopupViewHandler {
    default public void postConstructor(ViewHandlerServices viewHandlerServices, ViewHandlerAppServices viewHandlerAppServices) {
    }

    default public AppDefinition getAppDefinition() {
    }
}

