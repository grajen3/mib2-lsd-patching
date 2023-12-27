/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dialogactivation.internal;

import de.vw.mib.dialogactivation.ActivationState;
import de.vw.mib.dialogactivation.SpeechDialogActivationAdmin;
import de.vw.mib.dialogactivation.SpeechDialogActivationApplicant;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public abstract class SpeechDialogActivationApplicantAdapter
implements SpeechDialogActivationApplicant {
    private final BundleContext bundleContext;
    private ServiceRegistration registeredService;
    static /* synthetic */ Class class$de$vw$mib$dialogactivation$SpeechDialogActivationApplicant;

    public SpeechDialogActivationApplicantAdapter(BundleContext bundleContext) {
        this.bundleContext = bundleContext;
    }

    @Override
    public void setAdmin(SpeechDialogActivationAdmin speechDialogActivationAdmin) {
    }

    @Override
    public void updateApplicantsCount(int n) {
    }

    @Override
    public void resultChangeActivationState(boolean bl, ActivationState activationState) {
    }

    @Override
    public void cancelActivation() {
    }

    @Override
    public void resultReadActivationState(ActivationState activationState) {
    }

    @Override
    public void updateActivationState(ActivationState activationState) {
    }

    public final void registerService() {
        if (!this.isServiceRegistered()) {
            this.registeredService = this.bundleContext.registerService((class$de$vw$mib$dialogactivation$SpeechDialogActivationApplicant == null ? (class$de$vw$mib$dialogactivation$SpeechDialogActivationApplicant = SpeechDialogActivationApplicantAdapter.class$("de.vw.mib.dialogactivation.SpeechDialogActivationApplicant")) : class$de$vw$mib$dialogactivation$SpeechDialogActivationApplicant).getName(), (Object)this, null);
        }
    }

    public final void unregisterService() {
        if (this.registeredService != null) {
            this.registeredService.unregister();
            this.registeredService = null;
        }
    }

    public boolean isServiceRegistered() {
        return this.registeredService != null;
    }

    public boolean isRegistered() {
        return this.registeredService != null;
    }

    @Override
    public void cancelRequest(int n) {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

