/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cio.internal;

import de.vw.mib.app.framework.assembly.AppDefinitionDataProvider;
import de.vw.mib.app.framework.assembly.CioFilterData;
import de.vw.mib.app.framework.assembly.CioFilterData$CioFilterEntry;
import de.vw.mib.app.framework.assembly.CioIntentClassData;
import de.vw.mib.cio.CioDictionary;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.CioRegistrationListener;
import de.vw.mib.cio.framework.diag.CioDiagListener;
import de.vw.mib.cio.internal.AbstractCio;
import de.vw.mib.cio.internal.DiagService;
import de.vw.mib.cio.internal.Dictionary$1;
import de.vw.mib.cio.internal.Dictionary$DictionaryEntry;
import de.vw.mib.collections.longs.LongObjectMap;
import de.vw.mib.collections.longs.LongObjectOptHashMap;
import de.vw.mib.log4mib.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

final class Dictionary
implements CioDictionary {
    private static final CioIntent[] TEMPLATE = new CioIntent[0];
    private final Logger logger;
    private final Map cioEntries;
    private final LongObjectMap cioIntents;
    private final Map cioIntentClasses;
    private final Map cioIntentFilters;
    private CioDiagListener diagListener;

    Dictionary(Logger logger, AppDefinitionDataProvider appDefinitionDataProvider) {
        this.logger = logger;
        this.cioEntries = new HashMap();
        this.cioIntents = new LongObjectOptHashMap();
        this.cioIntentClasses = this.createCioIntentClassesMap(appDefinitionDataProvider.getCioIntentClasses());
        this.cioIntentFilters = this.createCioIntentFiltersMap(appDefinitionDataProvider.getCioFilters());
        this.diagListener = CioDiagListener.EMPTY_DIAG_LISTENER;
    }

    private Map createCioIntentFiltersMap(CioFilterData[] cioFilterDataArray) {
        if (cioFilterDataArray == null) {
            return new HashMap();
        }
        HashMap hashMap = new HashMap(cioFilterDataArray.length);
        for (int i2 = 0; i2 < cioFilterDataArray.length; ++i2) {
            hashMap.put(cioFilterDataArray[i2].getCioFilterName(), cioFilterDataArray[i2]);
        }
        return hashMap;
    }

    @Override
    public CioIntent getCioIntent(String string) {
        Dictionary$DictionaryEntry dictionary$DictionaryEntry = this.getEntry(string);
        return dictionary$DictionaryEntry.getCio();
    }

    @Override
    public CioIntent getCioIntent(String string, CioIntent cioIntent) {
        return this.getCioIntent(string, "*", cioIntent, false);
    }

    @Override
    public CioIntent getCioIntent(String string, String string2) {
        return this.getCioIntent(string, string2, false);
    }

    @Override
    public CioIntent getCioIntent(String string, String string2, boolean bl) {
        if (string2 == null || string2.length() == 0) {
            return null;
        }
        Dictionary$DictionaryEntry dictionary$DictionaryEntry = this.getEntry(string);
        List list = dictionary$DictionaryEntry.getCios();
        if (list.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < list.size(); ++i2) {
            AbstractCio abstractCio = (AbstractCio)list.get(i2);
            if (!"*".equals(string2) && !string2.equals(abstractCio.getUsage()) || bl && !abstractCio.isAvailable()) continue;
            return abstractCio;
        }
        return null;
    }

    @Override
    public CioIntent getCioIntent(String string, String string2, CioIntent cioIntent) {
        return this.getCioIntent(string, string2, cioIntent, false);
    }

    @Override
    public CioIntent getCioIntent(String string, String string2, CioIntent cioIntent, boolean bl) {
        if (cioIntent == null) {
            return null;
        }
        if (string2 == null || string2.length() == 0) {
            return null;
        }
        Dictionary$DictionaryEntry dictionary$DictionaryEntry = this.getEntry(string);
        List list = dictionary$DictionaryEntry.getCios();
        if (list.isEmpty()) {
            return null;
        }
        AbstractCio abstractCio = (AbstractCio)cioIntent;
        for (int i2 = 0; i2 < list.size(); ++i2) {
            AbstractCio abstractCio2 = (AbstractCio)list.get(i2);
            if (!"*".equals(string2) && !string2.equals(abstractCio2.getUsage()) || bl && !abstractCio2.isAvailable() || !abstractCio2.hasSameProvider(abstractCio)) continue;
            return abstractCio2;
        }
        return null;
    }

    @Override
    public CioIntent[] getCioIntents(String string) {
        Dictionary$DictionaryEntry dictionary$DictionaryEntry = this.getEntry(string);
        List list = dictionary$DictionaryEntry.getCios();
        if (list.isEmpty()) {
            return null;
        }
        return (CioIntent[])list.toArray(TEMPLATE);
    }

    @Override
    public CioIntent[] getCioIntents(String string, String string2) {
        return this.getCioIntents(string, string2, false);
    }

    @Override
    public CioIntent[] getCioIntents(String string, String string2, boolean bl) {
        ArrayList arrayList = this.filterCios(string, string2, bl);
        if (arrayList == null) {
            return null;
        }
        return (CioIntent[])arrayList.toArray(TEMPLATE);
    }

    @Override
    public CioIntent[] getCioIntentsByFilter(String string) {
        CioFilterData cioFilterData = (CioFilterData)this.cioIntentFilters.get(string);
        if (cioFilterData == null) {
            return null;
        }
        ArrayList arrayList = this.filterCios(cioFilterData.getCioIntentClassNameRef(), cioFilterData.getUsage(), true);
        if (arrayList == null) {
            return null;
        }
        Dictionary$1 dictionary$1 = new Dictionary$1(this);
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        CioFilterData$CioFilterEntry[] cioFilterData$CioFilterEntryArray = cioFilterData.getFilterEntries();
        if (cioFilterData$CioFilterEntryArray == null || cioFilterData$CioFilterEntryArray.length == 0) {
            Collections.sort(arrayList, dictionary$1);
            return (CioIntent[])arrayList.toArray(new CioIntent[arrayList.size()]);
        }
        TreeSet treeSet = new TreeSet(dictionary$1);
        for (int i2 = 0; i2 < cioFilterData$CioFilterEntryArray.length; ++i2) {
            CioFilterData$CioFilterEntry cioFilterData$CioFilterEntry = cioFilterData$CioFilterEntryArray[i2];
            for (int i3 = 0; i3 < arrayList.size(); ++i3) {
                AbstractCio abstractCio = (AbstractCio)arrayList.get(i3);
                if (cioFilterData$CioFilterEntry.getAppInstanceNameRef() != null && !cioFilterData$CioFilterEntry.getAppInstanceNameRef().equals(abstractCio.getAppInstanceName()) || cioFilterData$CioFilterEntry.getAppNameRef() != null && !cioFilterData$CioFilterEntry.getAppNameRef().equals(abstractCio.getAppName()) || cioFilterData$CioFilterEntry.getCioNameRef() != null && !cioFilterData$CioFilterEntry.getCioNameRef().equals(abstractCio.getCioName()) || cioFilterData$CioFilterEntry.getCioIntentNameRef() != null && !cioFilterData$CioFilterEntry.getCioIntentNameRef().equals(abstractCio.getCioIntentName())) continue;
                treeSet.add(abstractCio);
            }
            arrayList2.addAll(treeSet);
            treeSet.clear();
        }
        if (cioFilterData.getMode() == 1 && !arrayList.isEmpty()) {
            arrayList.removeAll(arrayList2);
            Collections.sort(arrayList, dictionary$1);
            arrayList2.addAll(arrayList);
        }
        return (CioIntent[])arrayList2.toArray(new CioIntent[arrayList2.size()]);
    }

    @Override
    public void addCioRegistrationListener(String string, CioRegistrationListener cioRegistrationListener) {
        Dictionary$DictionaryEntry dictionary$DictionaryEntry = this.getEntry(string);
        dictionary$DictionaryEntry.addListener(cioRegistrationListener);
    }

    @Override
    public void removeCioRegistrationListener(String string, CioRegistrationListener cioRegistrationListener) {
        Dictionary$DictionaryEntry dictionary$DictionaryEntry = this.getEntry(string);
        dictionary$DictionaryEntry.removeListener(cioRegistrationListener);
    }

    Collection getAllCioIntents() {
        return this.cioIntents.values();
    }

    Map getCioIntentClasses() {
        return this.cioIntentClasses;
    }

    AbstractCio getCioIntentById(long l) {
        return (AbstractCio)this.cioIntents.get(l);
    }

    boolean isCioRegistered(AbstractCio abstractCio) {
        return this.cioIntents.containsKey(abstractCio.getCioIntentId());
    }

    void onCioIntentChanged(AbstractCio abstractCio) {
        this.diagListener.onCioIntentChanged(abstractCio);
    }

    void registerCio(AbstractCio abstractCio) {
        if (this.logger.isTraceEnabled(1)) {
            this.logger.trace(1).append("register cio ").append(abstractCio).log();
        }
        String string = abstractCio.getCioIntentClass();
        Dictionary$DictionaryEntry dictionary$DictionaryEntry = this.getEntry(string);
        dictionary$DictionaryEntry.registerCio(abstractCio);
        this.cioIntents.put(abstractCio.getCioIntentId(), abstractCio);
        this.diagListener.onCioIntentRegistered(abstractCio);
    }

    void unregisterCio(AbstractCio abstractCio) {
        if (this.logger.isTraceEnabled(1)) {
            this.logger.trace(1).append("unregister cio ").append(abstractCio).log();
        }
        String string = abstractCio.getCioIntentClass();
        Dictionary$DictionaryEntry dictionary$DictionaryEntry = this.getEntry(string);
        dictionary$DictionaryEntry.unregisterCio(abstractCio);
        this.cioIntents.remove(abstractCio.getCioIntentId());
        this.diagListener.onCioIntentUnregistered(abstractCio);
    }

    void setCioDiagListener(DiagService diagService) {
        this.diagListener = diagService;
    }

    private ArrayList filterCios(String string, String string2, boolean bl) {
        if (string2 == null || string2.length() == 0) {
            return null;
        }
        Dictionary$DictionaryEntry dictionary$DictionaryEntry = this.getEntry(string);
        List list = dictionary$DictionaryEntry.getCios();
        if (list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); ++i2) {
            AbstractCio abstractCio = (AbstractCio)list.get(i2);
            if (!"*".equals(string2) && !string2.equals(abstractCio.getUsage()) || bl && !abstractCio.isAvailable()) continue;
            arrayList.add(abstractCio);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    private Map createCioIntentClassesMap(CioIntentClassData[] cioIntentClassDataArray) {
        HashMap hashMap = new HashMap();
        if (cioIntentClassDataArray == null) {
            return hashMap;
        }
        for (int i2 = 0; i2 < cioIntentClassDataArray.length; ++i2) {
            CioIntentClassData cioIntentClassData = cioIntentClassDataArray[i2];
            String string = cioIntentClassData.getName();
            hashMap.put(string, cioIntentClassData);
        }
        return hashMap;
    }

    private Dictionary$DictionaryEntry getEntry(String string) {
        Dictionary$DictionaryEntry dictionary$DictionaryEntry = (Dictionary$DictionaryEntry)this.cioEntries.get(string);
        if (dictionary$DictionaryEntry == null) {
            dictionary$DictionaryEntry = new Dictionary$DictionaryEntry(string);
            this.cioEntries.put(string, dictionary$DictionaryEntry);
        }
        return dictionary$DictionaryEntry;
    }
}

