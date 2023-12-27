/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sm;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.modelapi.ui.ModelApiDownEventService;

public interface AppHmiEnvironment {
    default public AppDefinition getAppInstance() {
    }

    default public ModelApiDownEventService getModelApiDownEventService() {
    }

    default public void showView(String string, String string2, boolean bl, int n) {
    }

    default public void hideView(String string, String string2) {
    }

    default public void requestVisibility(String string) {
    }
}

