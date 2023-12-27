/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dialogactivation.internal;

import de.vw.mib.dialogactivation.SpeechDialogActivationApplicant;
import de.vw.mib.dialogactivation.internal.ModalSpeechDialogAdmin;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.popup.PopupSpeechSegueService;
import de.vw.mib.threads.AsyncServiceFactory;
import java.util.ArrayList;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class Activator
implements BundleActivator,
ServiceTrackerCustomizer {
    private static final int TRACE_SUB_CLASSIFIER;
    private ModalSpeechDialogAdmin admin;
    private ServiceTracker serviceTracker;
    private BundleContext bundleContext;
    private Logger logger;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;
    static /* synthetic */ Class class$de$vw$mib$popup$PopupSpeechSegueService;
    static /* synthetic */ Class class$de$vw$mib$dialogactivation$SpeechDialogActivationApplicant;
    static /* synthetic */ Class class$de$vw$mib$threads$AsyncServiceFactory;

    @Override
    public void start(BundleContext bundleContext) {
        AsyncServiceFactory asyncServiceFactory;
        this.bundleContext = bundleContext;
        LoggerFactory loggerFactory = (LoggerFactory)this.bundleContext.getService(this.bundleContext.getServiceReference((class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = Activator.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory).getName()));
        this.logger = loggerFactory.getLogger(4096);
        PopupSpeechSegueService popupSpeechSegueService = (PopupSpeechSegueService)this.bundleContext.getService(this.bundleContext.getServiceReference((class$de$vw$mib$popup$PopupSpeechSegueService == null ? (class$de$vw$mib$popup$PopupSpeechSegueService = Activator.class$("de.vw.mib.popup.PopupSpeechSegueService")) : class$de$vw$mib$popup$PopupSpeechSegueService).getName()));
        if (popupSpeechSegueService == null) {
            this.logger.fatal(2, "Fundamental changes during bundle startup happened. PopupSpeechSegueService not registered before DialogActivationControl. All speech dialogs will not work.");
        }
        if ((asyncServiceFactory = this.retrieveAsyncServiceFactoryASL()) == null) {
            this.logger.fatal(2, "Fundamental changes during bundle startup happened. AsyncServiceFactory for ASL (GenericEvents bundle) was not registered before DialogActivationControl. All speech dialogs will not work.");
        }
        this.admin = new ModalSpeechDialogAdmin(popupSpeechSegueService, asyncServiceFactory, this.logger);
        this.serviceTracker = new ServiceTracker(this.bundleContext, (class$de$vw$mib$dialogactivation$SpeechDialogActivationApplicant == null ? (class$de$vw$mib$dialogactivation$SpeechDialogActivationApplicant = Activator.class$("de.vw.mib.dialogactivation.SpeechDialogActivationApplicant")) : class$de$vw$mib$dialogactivation$SpeechDialogActivationApplicant).getName(), (ServiceTrackerCustomizer)this);
        this.serviceTracker.open();
    }

    private AsyncServiceFactory retrieveAsyncServiceFactoryASL() {
        AsyncServiceFactory asyncServiceFactory = null;
        try {
            String string = "(MIBThreadId=3)";
            ServiceReference[] serviceReferenceArray = this.bundleContext.getServiceReferences((class$de$vw$mib$threads$AsyncServiceFactory == null ? (class$de$vw$mib$threads$AsyncServiceFactory = Activator.class$("de.vw.mib.threads.AsyncServiceFactory")) : class$de$vw$mib$threads$AsyncServiceFactory).getName(), "(MIBThreadId=3)");
            if (serviceReferenceArray.length != 1) {
                this.logger.error(2, "[DialogActivationControl] Wrong number of services when getting service-references. ");
                return null;
            }
            asyncServiceFactory = (AsyncServiceFactory)this.bundleContext.getService(serviceReferenceArray[0]);
        }
        catch (InvalidSyntaxException invalidSyntaxException) {
            this.logger.error(2, "[DialogActivationControl] Wrong filter when getting service-references. ", invalidSyntaxException);
        }
        return asyncServiceFactory;
    }

    @Override
    public void stop(BundleContext bundleContext) {
        this.admin = null;
    }

    private ArrayList getRegisteredApplicants() {
        ArrayList arrayList = null;
        try {
            ServiceReference[] serviceReferenceArray = this.bundleContext.getServiceReferences((class$de$vw$mib$dialogactivation$SpeechDialogActivationApplicant == null ? (class$de$vw$mib$dialogactivation$SpeechDialogActivationApplicant = Activator.class$("de.vw.mib.dialogactivation.SpeechDialogActivationApplicant")) : class$de$vw$mib$dialogactivation$SpeechDialogActivationApplicant).getName(), null);
            arrayList = new ArrayList(serviceReferenceArray.length);
            for (int i2 = 0; i2 < serviceReferenceArray.length; ++i2) {
                SpeechDialogActivationApplicant speechDialogActivationApplicant = (SpeechDialogActivationApplicant)this.bundleContext.getService(serviceReferenceArray[i2]);
                arrayList.add(speechDialogActivationApplicant);
            }
        }
        catch (InvalidSyntaxException invalidSyntaxException) {
            this.logger.error(2, "[DialogActivationControl] Wrong filter when getting service-references. ", invalidSyntaxException);
        }
        return arrayList;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        SpeechDialogActivationApplicant speechDialogActivationApplicant = (SpeechDialogActivationApplicant)this.bundleContext.getService(serviceReference);
        this.admin.addedApplicant(speechDialogActivationApplicant, this.getRegisteredApplicants());
        return speechDialogActivationApplicant;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        SpeechDialogActivationApplicant speechDialogActivationApplicant = (SpeechDialogActivationApplicant)this.bundleContext.getService(serviceReference);
        this.admin.removedApplicant(speechDialogActivationApplicant, this.getRegisteredApplicants());
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

