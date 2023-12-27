/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.picturestore.persistence;

import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.framework.api.persistence.AslPersistenceSyncApi;
import de.vw.mib.asl.internal.picturestore.persistence.ResourceLocatorKey;
import de.vw.mib.asl.picturestore.persistence.PictureStorePersistenceService;
import de.vw.mib.asl.picturestore.persistence.PictureStorePersistenceServiceImpl;
import de.vw.mib.asl.picturestore.persistence.StoredPicture;
import de.vw.mib.collections.ObjectIntMap;
import de.vw.mib.collections.ObjectIntMap$Entry;
import de.vw.mib.collections.ObjectIntOptHashMap;
import de.vw.mib.log4mib.Logger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.global.ResourceLocator;

public class PictureStorePersonalization {
    private final Logger logger;
    private final Services services;
    private final AslPersistenceSyncApi persistenceSyncApi;
    private final PictureStorePersistenceService persistenceService;
    private final ObjectIntMap userMap;
    private final ObjectIntMap ctxMap;
    private final List list;

    public PictureStorePersonalization(Logger logger, Services services, AslPersistenceSyncApi aslPersistenceSyncApi) {
        this.logger = logger;
        this.services = services;
        this.persistenceSyncApi = aslPersistenceSyncApi;
        this.persistenceService = PictureStorePersistenceServiceImpl.getInstance();
        this.list = this.persistenceService.loadPictureStore().getPictures();
        this.userMap = new ObjectIntOptHashMap(this.list.size());
        this.ctxMap = new ObjectIntOptHashMap(this.list.size());
        for (int i2 = 0; i2 < this.list.size(); ++i2) {
            StoredPicture storedPicture = (StoredPicture)this.list.get(i2);
            ResourceLocatorKey resourceLocatorKey = new ResourceLocatorKey(new ResourceLocator(storedPicture.getIdentification(), storedPicture.getUrl()));
            this.userMap.put(resourceLocatorKey, storedPicture.getBitfieldOfUsers());
            this.ctxMap.put(resourceLocatorKey, storedPicture.getCtxId());
        }
    }

    private int getUserBit() {
        return 1 << this.persistenceSyncApi.getActiveProfile();
    }

    private void rewriteList() {
        this.list.clear();
        Iterator iterator = this.userMap.entryIterator();
        while (iterator.hasNext()) {
            ObjectIntMap$Entry objectIntMap$Entry = (ObjectIntMap$Entry)iterator.next();
            ResourceLocatorKey resourceLocatorKey = (ResourceLocatorKey)objectIntMap$Entry.getKey();
            StoredPicture storedPicture = this.persistenceService.createStoredPicture();
            storedPicture.setIdentification(resourceLocatorKey.getResourceLocator().getId());
            storedPicture.setUrl(resourceLocatorKey.getResourceLocator().getUrl());
            storedPicture.setBitfieldOfUsers(objectIntMap$Entry.getValue());
            storedPicture.setCtxId(this.ctxMap.get(resourceLocatorKey));
            this.list.add(storedPicture);
        }
    }

    public void addPicture(ResourceLocator resourceLocator, int n) {
        ResourceLocatorKey resourceLocatorKey = new ResourceLocatorKey(resourceLocator);
        int n2 = this.userMap.get(resourceLocatorKey);
        this.userMap.put(resourceLocatorKey, n2 | this.getUserBit());
        this.ctxMap.put(resourceLocatorKey, n);
        this.rewriteList();
    }

    public ResourceLocator[] deletePictures(ResourceLocator[] resourceLocatorArray) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < resourceLocatorArray.length; ++i2) {
            ResourceLocatorKey resourceLocatorKey = new ResourceLocatorKey(resourceLocatorArray[i2]);
            if (!this.userMap.containsKey(resourceLocatorKey)) continue;
            int n = this.userMap.get(resourceLocatorKey) & ~this.getUserBit();
            if (n == 0) {
                this.userMap.remove(resourceLocatorKey);
                this.ctxMap.remove(resourceLocatorKey);
                arrayList.add(resourceLocatorKey.getResourceLocator());
                continue;
            }
            this.userMap.put(resourceLocatorKey, n);
        }
        this.rewriteList();
        return (ResourceLocator[])arrayList.toArray(new ResourceLocator[arrayList.size()]);
    }

    public ResourceLocator[] deleteAllPictures(int n) {
        HashSet hashSet = new HashSet(this.userMap.entrySet());
        ArrayList arrayList = new ArrayList();
        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            ObjectIntMap$Entry objectIntMap$Entry = (ObjectIntMap$Entry)iterator.next();
            ResourceLocatorKey resourceLocatorKey = (ResourceLocatorKey)objectIntMap$Entry.getKey();
            if (this.ctxMap.get(resourceLocatorKey) != n) continue;
            int n2 = objectIntMap$Entry.getValue() & ~this.getUserBit();
            if (n2 == 0) {
                this.userMap.remove(resourceLocatorKey);
                this.ctxMap.remove(resourceLocatorKey);
                arrayList.add(resourceLocatorKey.getResourceLocator());
                continue;
            }
            this.userMap.put(resourceLocatorKey, n2);
        }
        this.rewriteList();
        return (ResourceLocator[])arrayList.toArray(new ResourceLocator[arrayList.size()]);
    }

    public void copyProfile(int n, int n2) {
        int n3 = 1 << n;
        int n4 = 1 << n2;
        HashSet hashSet = new HashSet(this.userMap.entrySet());
        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            ObjectIntMap$Entry objectIntMap$Entry = (ObjectIntMap$Entry)iterator.next();
            ResourceLocatorKey resourceLocatorKey = (ResourceLocatorKey)objectIntMap$Entry.getKey();
            if ((this.userMap.get(resourceLocatorKey) & n3) == 0) continue;
            int n5 = objectIntMap$Entry.getValue() | n4;
            this.userMap.put(resourceLocatorKey, n5);
        }
        this.rewriteList();
    }

    public ResourceLocator[] resetProfile(int n) {
        int n2 = 1 << n;
        HashSet hashSet = new HashSet(this.userMap.entrySet());
        ArrayList arrayList = new ArrayList();
        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            ObjectIntMap$Entry objectIntMap$Entry = (ObjectIntMap$Entry)iterator.next();
            ResourceLocatorKey resourceLocatorKey = (ResourceLocatorKey)objectIntMap$Entry.getKey();
            if ((this.userMap.get(resourceLocatorKey) & n2) == 0) continue;
            int n3 = objectIntMap$Entry.getValue() & ~n2;
            if (n3 == 0) {
                this.userMap.remove(resourceLocatorKey);
                this.ctxMap.remove(resourceLocatorKey);
                arrayList.add(resourceLocatorKey.getResourceLocator());
                continue;
            }
            this.userMap.put(resourceLocatorKey, n3);
        }
        this.rewriteList();
        return (ResourceLocator[])arrayList.toArray(new ResourceLocator[arrayList.size()]);
    }

    public ResourceLocator[] resetAllProfiles() {
        ResourceLocatorKey[] resourceLocatorKeyArray = (ResourceLocatorKey[])this.userMap.keysToArray(new ResourceLocatorKey[this.userMap.size()]);
        ResourceLocator[] resourceLocatorArray = new ResourceLocator[resourceLocatorKeyArray.length];
        for (int i2 = 0; i2 < resourceLocatorArray.length; ++i2) {
            resourceLocatorArray[i2] = resourceLocatorKeyArray[i2].getResourceLocator();
        }
        this.userMap.clear();
        this.ctxMap.clear();
        this.rewriteList();
        return resourceLocatorArray;
    }
}

