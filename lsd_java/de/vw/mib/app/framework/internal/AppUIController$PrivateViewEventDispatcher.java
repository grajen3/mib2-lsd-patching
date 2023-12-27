/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.internal;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.app.framework.internal.AppUIController;
import de.vw.mib.app.framework.internal.Services$EventDispatcherServices;
import de.vw.mib.event.dispatcher.apps.ViewEventDispatcher;

final class AppUIController$PrivateViewEventDispatcher
implements ViewEventDispatcher {
    private final AppDefinition receiver;
    private final AppDefinition sender;
    private final de.vw.mib.event.dispatcher.ViewEventDispatcher globalViewEventDispatcher;
    private final /* synthetic */ AppUIController this$0;

    AppUIController$PrivateViewEventDispatcher(AppUIController appUIController, AppDefinition appDefinition, Services$EventDispatcherServices services$EventDispatcherServices) {
        this.this$0 = appUIController;
        this.receiver = appDefinition;
        this.sender = appDefinition;
        this.globalViewEventDispatcher = services$EventDispatcherServices.getViewEventDispatcher();
    }

    @Override
    public void invoke(Runnable runnable) {
        this.globalViewEventDispatcher.invoke(runnable);
    }

    @Override
    public void createAndSubmitBooleanValueEvent(int n, boolean bl) {
        this.globalViewEventDispatcher.createAndSubmitBooleanValueEvent(this.sender, this.receiver, n, bl);
    }

    @Override
    public void createAndSubmitHMIEvent(int n) {
        this.globalViewEventDispatcher.createAndSubmitHMIEvent(this.sender, this.receiver, n);
    }

    @Override
    public void createAndSubmitIntegerValueEvent(int n, int n2) {
        this.globalViewEventDispatcher.createAndSubmitIntegerValueEvent(this.sender, this.receiver, n, n2);
    }

    @Override
    public void createAndSubmitListItemEvent(int n, int n2, int n3, int n4, int n5, String string, long l) {
        this.globalViewEventDispatcher.createAndSubmitListItemEvent(this.sender, this.receiver, n, n2, n3, n4, n5, string, l);
    }

    @Override
    public void createAndSubmitPointEvent(int n, int n2, int n3, int n4, int n5) {
        this.globalViewEventDispatcher.createAndSubmitPointEvent(this.sender, this.receiver, n, n2, n3, n4, n5);
    }

    @Override
    public void createAndSubmitSpellerValueEvent(int n, String string, int n2, int n3, int n4) {
        this.globalViewEventDispatcher.createAndSubmitSpellerValueEvent(this.sender, this.receiver, n, string, n2, n3, n4);
    }

    @Override
    public void createAndSubmitStringValueEvent(int n, String string) {
        this.globalViewEventDispatcher.createAndSubmitStringValueEvent(this.sender, this.receiver, n, string);
    }
}

