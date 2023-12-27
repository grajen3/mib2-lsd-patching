/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.dsi;

import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.framework.api.persistence2.dsi.AbstractPersonalizedAppDsiAdapter;
import de.vw.mib.asl.framework.api.persistence2.dsi.PersonalizedAppListener;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.dsi.DelegatingPersonalizedAppAdapter;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.dsi.DsiAdapterProvider;
import de.vw.mib.asl.framework.internal.persistence.internal.util.Preconditions;
import de.vw.mib.collections.ObjectObjectMultimap;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.timer.Invoker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.osgi.framework.BundleContext;

public class DsiAdapterProviderImpl
implements DsiAdapterProvider {
    private static final String LOGGER_PREFIX;
    private final BundleContext bundleContext;
    private HashMap dsiAdapterToListenerDelegateMap = new HashMap();
    private final Logger logger;
    private ObjectObjectMultimap persistenceModuleToDsiAdapterMap = new ObjectObjectMultimap();
    private final Invoker invoker;

    public DsiAdapterProviderImpl(BundleContext bundleContext, Logger logger, Invoker invoker) {
        this.bundleContext = bundleContext;
        this.logger = logger;
        this.invoker = invoker;
    }

    @Override
    public void addDsiListener(AbstractPersonalizedAppDsiAdapter abstractPersonalizedAppDsiAdapter, PersonalizedAppListener personalizedAppListener) {
        Preconditions.checkArgumentNotNull(abstractPersonalizedAppDsiAdapter, "DSI adapter must not be null.");
        Preconditions.checkArgumentNotNull(personalizedAppListener, "Personalization listener must not be null.");
        DelegatingPersonalizedAppAdapter delegatingPersonalizedAppAdapter = (DelegatingPersonalizedAppAdapter)this.dsiAdapterToListenerDelegateMap.get(abstractPersonalizedAppDsiAdapter);
        if (delegatingPersonalizedAppAdapter == null) {
            delegatingPersonalizedAppAdapter = new DelegatingPersonalizedAppAdapter(this.invoker);
            abstractPersonalizedAppDsiAdapter.init(delegatingPersonalizedAppAdapter);
            this.dsiAdapterToListenerDelegateMap.put(abstractPersonalizedAppDsiAdapter, delegatingPersonalizedAppAdapter);
        }
        delegatingPersonalizedAppAdapter.addDelegate(personalizedAppListener);
    }

    @Override
    public List filterUnregisteredDsis(List list) {
        if (list == null) {
            throw new IllegalArgumentException("Adapter list must not be null.");
        }
        ArrayList arrayList = new ArrayList();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            AbstractPersonalizedAppDsiAdapter abstractPersonalizedAppDsiAdapter = (AbstractPersonalizedAppDsiAdapter)iterator.next();
            if (this.checkIsDsiAvailableForAdapter(abstractPersonalizedAppDsiAdapter)) {
                arrayList.add(abstractPersonalizedAppDsiAdapter);
                continue;
            }
            this.logger.info(32).append("DsiAdapterProviderImpl").append("Skipping South Side communcation with ").append(abstractPersonalizedAppDsiAdapter.getDsiClass()).append(" since it is not started.").log();
        }
        return arrayList;
    }

    @Override
    public List getAllDsiAdapters() {
        List list = Arrays.asList(this.persistenceModuleToDsiAdapterMap.valuesToArray());
        return Collections.unmodifiableList(list);
    }

    @Override
    public List getDsiAdapters(PersistenceModule persistenceModule) {
        return Arrays.asList(this.persistenceModuleToDsiAdapterMap.getAll(persistenceModule).toArray());
    }

    @Override
    public boolean hasRegisteredDsiAdapters(PersistenceModule persistenceModule) {
        return this.persistenceModuleToDsiAdapterMap.containsKey(persistenceModule);
    }

    @Override
    public void registerDsiAdapter(PersistenceModule persistenceModule, AbstractPersonalizedAppDsiAdapter abstractPersonalizedAppDsiAdapter) {
        Preconditions.checkArgumentNotNull(persistenceModule, "Persistence module must not be null.");
        Preconditions.checkArgumentNotNull(abstractPersonalizedAppDsiAdapter, "DSI adapter must not be null.");
        this.persistenceModuleToDsiAdapterMap.put(persistenceModule, abstractPersonalizedAppDsiAdapter);
    }

    @Override
    public void removeDsiListener(AbstractPersonalizedAppDsiAdapter abstractPersonalizedAppDsiAdapter, PersonalizedAppListener personalizedAppListener) {
        DelegatingPersonalizedAppAdapter delegatingPersonalizedAppAdapter = (DelegatingPersonalizedAppAdapter)this.dsiAdapterToListenerDelegateMap.get(abstractPersonalizedAppDsiAdapter);
        if (delegatingPersonalizedAppAdapter != null) {
            delegatingPersonalizedAppAdapter.removeDelegate(personalizedAppListener);
        }
    }

    private boolean checkIsDsiAvailableForAdapter(AbstractPersonalizedAppDsiAdapter abstractPersonalizedAppDsiAdapter) {
        return this.bundleContext.getServiceReference(abstractPersonalizedAppDsiAdapter.getDsiClass().getName()) != null;
    }
}

