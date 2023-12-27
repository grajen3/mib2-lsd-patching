/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cio.app.framework;

import de.vw.mib.cio.CioExecutor;
import de.vw.mib.cio.app.framework.AppLifecycleCioExecutor;
import de.vw.mib.cio.app.framework.CioIntentDefinition;
import de.vw.mib.cio.app.framework.ShowContentCioExecutor;

public interface AppFrameworkCioFactory {
    default public void createAndRegisterAppLifecycleCio(CioIntentDefinition cioIntentDefinition, CioExecutor cioExecutor, AppLifecycleCioExecutor appLifecycleCioExecutor) {
    }

    default public void createAndRegisterCio(CioIntentDefinition cioIntentDefinition, CioExecutor cioExecutor) {
    }

    default public void createAndRegisterShowContentCio(CioIntentDefinition cioIntentDefinition, String string, String string2, CioExecutor cioExecutor, ShowContentCioExecutor showContentCioExecutor) {
    }

    default public void unregisterCio(CioIntentDefinition cioIntentDefinition) {
    }
}

