/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sdfeaturecollectionmanager.internal;

import de.vw.mib.hmi.utils.OsgiUtil;
import de.vw.mib.sdfeaturecollectionmanager.SdFeatureCollectionHandlerFactory;
import de.vw.mib.sdfeaturecollectionmanager.internal.SdFeatureCollectionManagerImpl;
import de.vw.mib.sdfeaturecollectionmanager.internal.ServiceManagerSdFeatureCollection;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator
implements BundleActivator {
    private static final String SD_FEATURE_COLLECTION_HANDLER_FACTORY_CLASS_NAME = (class$de$vw$mib$sdfeaturecollectionmanager$SdFeatureCollectionHandlerFactory == null ? (class$de$vw$mib$sdfeaturecollectionmanager$SdFeatureCollectionHandlerFactory = Activator.class$("de.vw.mib.sdfeaturecollectionmanager.SdFeatureCollectionHandlerFactory")) : class$de$vw$mib$sdfeaturecollectionmanager$SdFeatureCollectionHandlerFactory).getName();
    private static final String SD_FEATURE_COLLECTION_MANAGER_CLASS_NAME = (class$de$vw$mib$sdfeaturecollectionmanager$SdFeatureCollectionManager == null ? (class$de$vw$mib$sdfeaturecollectionmanager$SdFeatureCollectionManager = Activator.class$("de.vw.mib.sdfeaturecollectionmanager.SdFeatureCollectionManager")) : class$de$vw$mib$sdfeaturecollectionmanager$SdFeatureCollectionManager).getName();
    static /* synthetic */ Class class$de$vw$mib$sdfeaturecollectionmanager$SdFeatureCollectionHandlerFactory;
    static /* synthetic */ Class class$de$vw$mib$sdfeaturecollectionmanager$SdFeatureCollectionManager;

    @Override
    public void start(BundleContext bundleContext) {
        this.requestSdFeatureCollectionHandlerFactory(bundleContext);
        this.provideSdFeatureCollectionManager(bundleContext);
    }

    @Override
    public void stop(BundleContext bundleContext) {
    }

    private void provideSdFeatureCollectionManager(BundleContext bundleContext) {
        bundleContext.registerService(SD_FEATURE_COLLECTION_MANAGER_CLASS_NAME, (Object)new SdFeatureCollectionManagerImpl(), null);
    }

    private void requestSdFeatureCollectionHandlerFactory(BundleContext bundleContext) {
        Object object = OsgiUtil.getService(bundleContext, SD_FEATURE_COLLECTION_HANDLER_FACTORY_CLASS_NAME);
        ServiceManagerSdFeatureCollection.sdFeatureCollectionHandlerFactory = (SdFeatureCollectionHandlerFactory)object;
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

