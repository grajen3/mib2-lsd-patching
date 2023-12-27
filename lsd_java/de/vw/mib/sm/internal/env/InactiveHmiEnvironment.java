/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sm.internal.env;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.modelapi.ui.ModelApiDownEventService;
import de.vw.mib.sm.AppHmiEnvironment;

public class InactiveHmiEnvironment
implements AppHmiEnvironment {
    public static final AppHmiEnvironment INSTANCE = new InactiveHmiEnvironment();

    @Override
    public AppDefinition getAppInstance() {
        throw this.inactiveException();
    }

    @Override
    public ModelApiDownEventService getModelApiDownEventService() {
        throw this.inactiveException();
    }

    @Override
    public void showView(String string, String string2, boolean bl, int n) {
        throw this.inactiveException();
    }

    @Override
    public void hideView(String string, String string2) {
        throw this.inactiveException();
    }

    @Override
    public void requestVisibility(String string) {
        throw this.inactiveException();
    }

    private IllegalStateException inactiveException() {
        return new IllegalStateException("The HMI part is inactive. Access the environment is not supported.");
    }
}

