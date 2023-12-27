/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.speller.internal;

import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.speller.filter.SpellerFilter;
import de.vw.mib.speller.internal.Log;
import de.vw.mib.util.StringBuilder;
import java.util.Iterator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;

class SpellerFilterRegistry
implements ServiceListener {
    private final BundleContext context;
    private final IntObjectMap filterReferences = new IntObjectOptHashMap();
    private final IntObjectMap filters = new IntObjectOptHashMap().synchronize();
    static /* synthetic */ Class class$de$vw$mib$speller$filter$SpellerFilter;

    SpellerFilterRegistry(BundleContext bundleContext) {
        this.context = bundleContext;
    }

    void bind() {
        ServiceReference[] serviceReferenceArray;
        LogMessage logMessage = Log.trace();
        if (null != logMessage) {
            logMessage.append("Binding SpellerFilterRegistry to OSGi").log();
        }
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("(").append("objectClass").append("=").append((class$de$vw$mib$speller$filter$SpellerFilter == null ? (class$de$vw$mib$speller$filter$SpellerFilter = SpellerFilterRegistry.class$("de.vw.mib.speller.filter.SpellerFilter")) : class$de$vw$mib$speller$filter$SpellerFilter).getName()).append(")");
        String string = stringBuffer.toString();
        try {
            this.context.addServiceListener(this, string);
            serviceReferenceArray = this.context.getServiceReferences((class$de$vw$mib$speller$filter$SpellerFilter == null ? (class$de$vw$mib$speller$filter$SpellerFilter = SpellerFilterRegistry.class$("de.vw.mib.speller.filter.SpellerFilter")) : class$de$vw$mib$speller$filter$SpellerFilter).getName(), null);
        }
        catch (InvalidSyntaxException invalidSyntaxException) {
            throw new RuntimeException(invalidSyntaxException);
        }
        for (int i2 = 0; serviceReferenceArray != null && i2 < serviceReferenceArray.length; ++i2) {
            this.serviceChanged(new ServiceEvent(1, serviceReferenceArray[i2]));
        }
    }

    void unbind() {
        LogMessage logMessage = Log.trace();
        if (null != logMessage) {
            logMessage.append("Unbinding SpellerFilterRegistry from OSGi").log();
        }
        this.context.removeServiceListener(this);
        Iterator iterator = this.filterReferences.valueIterator();
        while (iterator.hasNext()) {
            ServiceReference serviceReference = (ServiceReference)iterator.next();
            iterator.remove();
            this.context.ungetService(serviceReference);
        }
        this.filterReferences.clear();
        this.filters.clear();
    }

    SpellerFilter getSpellerFilter(int n) {
        return (SpellerFilter)this.filters.get(n);
    }

    @Override
    public void serviceChanged(ServiceEvent serviceEvent) {
        ServiceReference serviceReference = serviceEvent.getServiceReference();
        switch (serviceEvent.getType()) {
            case 1: {
                this.registered(serviceReference);
                break;
            }
            case 4: {
                this.unregistering(serviceReference);
                break;
            }
        }
    }

    private void registered(ServiceReference serviceReference) {
        int n = this.getFilterId(serviceReference);
        if (-1 != n) {
            SpellerFilter spellerFilter;
            ServiceReference serviceReference2;
            LogMessage logMessage = Log.trace();
            if (null != logMessage) {
                logMessage.append("Received SpellerFilter, filterId=").append(n).log();
            }
            if (null != (serviceReference2 = (ServiceReference)this.filterReferences.get(n))) {
                this.context.ungetService(serviceReference);
                this.filters.remove(n);
            }
            if (null != (spellerFilter = (SpellerFilter)this.context.getService(serviceReference))) {
                this.filterReferences.put(n, serviceReference);
                this.filters.put(n, spellerFilter);
            }
        }
    }

    private void unregistering(ServiceReference serviceReference) {
        int n = this.getFilterId(serviceReference);
        if (-1 != n) {
            ServiceReference serviceReference2;
            LogMessage logMessage = Log.trace();
            if (null != logMessage) {
                logMessage.append("Dropping SpellerFilter, filterId=").append(n).log();
            }
            if ((serviceReference2 = (ServiceReference)this.filterReferences.get(n)) == serviceReference) {
                this.context.ungetService(serviceReference);
                this.filterReferences.remove(n);
                this.filters.remove(n);
            }
        }
    }

    private int getFilterId(ServiceReference serviceReference) {
        int n;
        Object object = serviceReference.getProperty("FilterId");
        try {
            if (null == object) {
                StringBuilder stringBuilder = new StringBuilder(50);
                stringBuilder.append("Missing OSGi property \"").append("FilterId").append("\"");
                throw new NullPointerException(stringBuilder.toString());
            }
            if (object instanceof Number) {
                n = ((Number)object).intValue();
            } else {
                try {
                    n = Integer.parseInt(String.valueOf(object));
                }
                catch (NumberFormatException numberFormatException) {
                    StringBuilder stringBuilder = new StringBuilder(50);
                    stringBuilder.append("Could not parse OSGi property \"").append("FilterId").append("\"");
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
                    illegalArgumentException.initCause(numberFormatException);
                    throw illegalArgumentException;
                }
            }
            if (-1 == n) {
                StringBuilder stringBuilder = new StringBuilder(50);
                stringBuilder.append("Illegal OSGI property \"").append("FilterId").append("\": ").append(n);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        catch (RuntimeException runtimeException) {
            LogMessage logMessage = Log.error();
            if (null != logMessage) {
                logMessage.append(runtimeException.getMessage()).attachThrowable(runtimeException).log();
            }
            n = -1;
        }
        return n;
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

