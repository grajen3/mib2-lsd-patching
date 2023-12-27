/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl;

import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.PersistenceKeyProvider;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.PersistenceLogger;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.RawPersistenceIdsDataProvider;
import de.vw.mib.collections.ObjectIntMap;
import de.vw.mib.collections.ObjectIntOptHashMap;
import de.vw.mib.collections.ints.IntArrayList;
import de.vw.mib.collections.ints.IntLongMap;
import de.vw.mib.collections.ints.IntLongOptHashMap;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;

public class PersistenceKeyProviderImpl
implements PersistenceKeyProvider {
    private static final int[] NO_IDS = new int[0];
    private static final int INDEX_NAMESPACES;
    private static final int INDEX_NAMESPACE_NAMES;
    private static final int INDEX_PERSISTABLE_IDS;
    private static final int INDEX_VERSIONS;
    private final PersistenceLogger logger;
    private final IntArrayList namespaces = new IntArrayList();
    private final ObjectIntMap mapName2Namespace = new ObjectIntOptHashMap();
    private final IntObjectMap mapNamespace2CommonPersistableIds = new IntObjectOptHashMap();
    private final IntObjectMap mapNamespace2UserSepecficPersistableIds = new IntObjectOptHashMap();
    private final IntLongMap mapNamespace2Version = new IntLongOptHashMap();
    private int dataIndex;

    public PersistenceKeyProviderImpl(RawPersistenceIdsDataProvider rawPersistenceIdsDataProvider, PersistenceLogger persistenceLogger) {
        this.logger = persistenceLogger;
        this.loadData(rawPersistenceIdsDataProvider);
    }

    @Override
    public int[] retrieveCommonPersistableIds(int n) {
        if (this.mapNamespace2CommonPersistableIds.containsKey(n)) {
            return (int[])this.mapNamespace2CommonPersistableIds.get(n);
        }
        return NO_IDS;
    }

    @Override
    public int[] retrieveUserSpecificPersistableIds(int n) {
        if (this.mapNamespace2UserSepecficPersistableIds.containsKey(n)) {
            return (int[])this.mapNamespace2UserSepecficPersistableIds.get(n);
        }
        return NO_IDS;
    }

    @Override
    public int retrieveNamespace(String string) {
        if (this.mapName2Namespace.containsKey(string)) {
            return this.mapName2Namespace.get(string);
        }
        return -1;
    }

    @Override
    public long retrieveVersion(int n) {
        if (this.mapNamespace2Version.containsKey(n)) {
            return this.mapNamespace2Version.get(n);
        }
        return -1L;
    }

    @Override
    public int[] retrieveNamespaceIds() {
        return this.namespaces.toArray();
    }

    @Override
    public String retrieveNamespaceName(int n) {
        return (String)this.mapName2Namespace.getOneKeyByValue(n);
    }

    private void loadData(RawPersistenceIdsDataProvider rawPersistenceIdsDataProvider) {
        try {
            Object[] objectArray = rawPersistenceIdsDataProvider.retrieveRawData();
            this.loadNamespaces(objectArray);
            this.loadNamespaceNames(objectArray);
            this.loadPersistenceKeys(objectArray);
            this.loadVersions(objectArray);
        }
        catch (Throwable throwable) {
            this.logger.error("Could not read persistence ids: Error while parsing the contents.", throwable);
        }
    }

    private void loadNamespaces(Object[] objectArray) {
        int[] nArray = (int[])objectArray[0];
        int n = nArray[0];
        for (int i2 = 0; i2 < n; ++i2) {
            int n2 = nArray[i2 + 1];
            this.namespaces.add(n2);
        }
    }

    private void loadNamespaceNames(Object[] objectArray) {
        String[] stringArray = (String[])objectArray[1];
        int n = this.namespaces.size();
        for (int i2 = 0; i2 < n; ++i2) {
            int n2 = this.namespaces.get(i2);
            String string = stringArray[i2];
            this.mapName2Namespace.put(string, n2);
        }
    }

    private void loadPersistenceKeys(Object[] objectArray) {
        int[] nArray = (int[])objectArray[2];
        int n = this.namespaces.size();
        for (int i2 = 0; i2 < n; ++i2) {
            int n2 = this.namespaces.get(i2);
            int[] nArray2 = this.readPersistableIds(nArray);
            int[] nArray3 = this.readPersistableIds(nArray);
            this.mapNamespace2CommonPersistableIds.put(n2, nArray2);
            this.mapNamespace2UserSepecficPersistableIds.put(n2, nArray3);
        }
    }

    private void loadVersions(Object[] objectArray) {
        long[] lArray = (long[])objectArray[3];
        int n = this.namespaces.size();
        for (int i2 = 0; i2 < n; ++i2) {
            int n2 = this.namespaces.get(i2);
            long l = lArray[i2];
            this.mapNamespace2Version.put(n2, l);
        }
    }

    private int[] readPersistableIds(int[] nArray) {
        int n = this.readNextInt(nArray);
        int[] nArray2 = new int[n];
        for (int i2 = 0; i2 < n; ++i2) {
            nArray2[i2] = this.readNextInt(nArray);
        }
        return nArray2;
    }

    private int readNextInt(int[] nArray) {
        return nArray[this.dataIndex++];
    }
}

