/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.sd.internal;

import de.vw.mib.activation.BundleActivatorExtension;
import de.vw.mib.asl.api.speechengine.features.FeatureFactory;
import de.vw.mib.asl.api.speechengine.speechproxy.SpeechProxy;
import de.vw.mib.sdfeaturecollectionmanager.SdFeatureCollectionHandlerFactory;
import de.vw.mib.sdfeaturecollectionmanager.internal.ServiceManagerSdFeatureCollection;
import generated.de.vw.mib.global.sd.internal.SdFeatureCollectionFactoryImpl;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;

public class Activator
implements BundleActivatorExtension,
ServiceListener {
    private BundleContext bundleContext;
    private static final int DIRECT;
    private static final int INDIRECT;
    private int preloaded = 0;
    private int waitingListeners = 2;
    private SdFeatureCollectionHandlerFactory sdFeatureCollectionHandlerFactory;
    static /* synthetic */ Class class$de$vw$mib$sdfeaturecollectionmanager$SdFeatureCollectionHandlerFactory;

    @Override
    public void preload(BundleContext bundleContext) {
        this.bundleContext = bundleContext;
        this.preloaded = this.preloaded == 2 ? 2 : 1;
        this.preloadSetup();
        this.bundleContext.registerService((class$de$vw$mib$sdfeaturecollectionmanager$SdFeatureCollectionHandlerFactory == null ? (class$de$vw$mib$sdfeaturecollectionmanager$SdFeatureCollectionHandlerFactory = Activator.class$("de.vw.mib.sdfeaturecollectionmanager.SdFeatureCollectionHandlerFactory")) : class$de$vw$mib$sdfeaturecollectionmanager$SdFeatureCollectionHandlerFactory).getName(), (Object)this.sdFeatureCollectionHandlerFactory, null);
        String string = "(|(objectClass=de.vw.mib.asl.api.speechengine.features.FeatureFactory)(objectClass=de.vw.mib.asl.api.speechengine.speechproxy.SpeechProxy))";
        this.bundleContext.addServiceListener(this, string);
        String string2 = null;
        ServiceReference[] serviceReferenceArray = this.bundleContext.getServiceReferences(string2, string);
        for (int i2 = 0; serviceReferenceArray != null && i2 < serviceReferenceArray.length; ++i2) {
            this.serviceChanged(new ServiceEvent(1, serviceReferenceArray[i2]));
        }
    }

    @Override
    public void serviceChanged(ServiceEvent serviceEvent) {
        if (1 == serviceEvent.getType()) {
            Object object = this.bundleContext.getService(serviceEvent.getServiceReference());
            if (object instanceof FeatureFactory && ServiceManagerSdFeatureCollection.featureFactory == null) {
                ServiceManagerSdFeatureCollection.featureFactory = (FeatureFactory)object;
                --this.waitingListeners;
                this.listenerPartialSetup(this.waitingListeners == 0);
            }
            if (object instanceof SpeechProxy && ServiceManagerSdFeatureCollection.speechProxy == null) {
                ServiceManagerSdFeatureCollection.speechProxy = (SpeechProxy)object;
                --this.waitingListeners;
                this.listenerPartialSetup(this.waitingListeners == 0);
            }
        }
    }

    @Override
    public void start(BundleContext bundleContext) {
        if (this.preloaded == 0) {
            this.preloaded = 2;
            this.preload(bundleContext);
        }
        this.startSetup();
    }

    @Override
    public void stop(BundleContext bundleContext) {
    }

    private void preloadSetup() {
        ServiceManagerSdFeatureCollection.maxSpeechIndex = 15;
        this.sdFeatureCollectionHandlerFactory = new SdFeatureCollectionFactoryImpl();
    }

    private void listenerPartialSetup(boolean bl) {
    }

    private void startSetup() {
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

