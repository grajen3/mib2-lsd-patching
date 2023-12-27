/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has.internal;

import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASContainerMarshaller;
import de.vw.mib.has.HASException;
import de.vw.mib.has.HASFactory;
import de.vw.mib.pool.PoorMansPool;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.has.HASDataContainer;

public final class HASContainerBuilder {
    private static final int START_HIERARCHY_ID;
    private HASFactory factory;
    private static final int ARRAYLIST_POOL_MAX_ELEMENTS;
    private static final int ARRAYLIST_POOL_INIT_LISTSIZE;
    private static final int ARRAYLIST_POOL_MAX_LISTSIZE;
    private static final PoorMansPool ARRAYLIST_POOL;

    void init(HASFactory hASFactory) {
        this.factory = hASFactory;
    }

    HASContainer build(HASDataContainer[] hASDataContainerArray) {
        HASContainer hASContainer;
        if (null == this.factory) {
            throw new IllegalStateException("HAS factory not set");
        }
        if (null == hASDataContainerArray || 0 == hASDataContainerArray.length) {
            hASContainer = null;
        } else if (1 == hASDataContainerArray.length) {
            HASDataContainer hASDataContainer = hASDataContainerArray[0];
            hASContainer = -1 == hASDataContainer.getParentId() ? this.build(hASDataContainer) : null;
        } else {
            int n;
            HASDataContainer hASDataContainer;
            int n2;
            hASContainer = null;
            IntObjectOptHashMap intObjectOptHashMap = new IntObjectOptHashMap(hASDataContainerArray.length);
            for (n2 = 0; n2 < hASDataContainerArray.length; ++n2) {
                hASDataContainer = hASDataContainerArray[n2];
                n = hASDataContainer.getHierarchyId();
                if (intObjectOptHashMap.containsKey(n)) {
                    throw HASException.ambiguousHierarchyId(n);
                }
                HASContainer hASContainer2 = this.build(hASDataContainer);
                intObjectOptHashMap.put(n, hASContainer2);
                if (-1 != hASDataContainer.getParentId()) continue;
                if (null == hASContainer) {
                    hASContainer = hASContainer2;
                    continue;
                }
                throw HASException.ambiguousRootContainer();
            }
            for (n2 = 0; n2 < hASDataContainerArray.length; ++n2) {
                hASDataContainer = hASDataContainerArray[n2];
                n = hASDataContainer.getHierarchyId();
                int n3 = hASDataContainer.getParentId();
                HASContainer hASContainer3 = (HASContainer)intObjectOptHashMap.get(n);
                if (-1 == hASDataContainer.getParentId()) continue;
                HASContainer hASContainer4 = (HASContainer)intObjectOptHashMap.get(n3);
                if (null == hASContainer4) {
                    throw HASException.incompleteContainerTree(n3);
                }
                this.factory.createContainerMarshaller(hASContainer4.getContainerId()).addChild(hASContainer4, hASContainer3);
            }
        }
        if (null == hASContainer && null != hASDataContainerArray && 0 < hASDataContainerArray.length) {
            throw HASException.missingRootContainer();
        }
        return hASContainer;
    }

    private HASContainer build(HASDataContainer hASDataContainer) {
        int n = hASDataContainer.getContainerId();
        return this.factory.createContainerMarshaller(n).unmarshal(hASDataContainer);
    }

    public HASDataContainer[] build(HASContainer hASContainer) {
        HASDataContainer[] hASDataContainerArray;
        if (null == this.factory) {
            throw new IllegalStateException("HAS factory not set");
        }
        if (null == hASContainer) {
            hASDataContainerArray = null;
        } else {
            ArrayList arrayList = HASContainerBuilder.borrowArrayList();
            this.buildRecursive(-1, 1, hASContainer, arrayList);
            hASDataContainerArray = (HASDataContainer[])arrayList.toArray(new HASDataContainer[arrayList.size()]);
            HASContainerBuilder.release(arrayList);
        }
        return hASDataContainerArray;
    }

    private int buildRecursive(int n, int n2, HASContainer hASContainer, List list) {
        HASContainerMarshaller hASContainerMarshaller = this.factory.createContainerMarshaller(hASContainer.getContainerId());
        HASDataContainer hASDataContainer = hASContainerMarshaller.marshal(hASContainer);
        hASDataContainer.parentId = n;
        n = n2;
        hASDataContainer.hierarchyId = n2++;
        list.add(hASDataContainer);
        ArrayList arrayList = HASContainerBuilder.borrowArrayList();
        hASContainerMarshaller.getChildren(hASContainer, arrayList);
        int n3 = arrayList.size();
        for (int i2 = 0; i2 < n3; ++i2) {
            HASContainer hASContainer2 = (HASContainer)arrayList.get(i2);
            n2 = this.buildRecursive(n, n2, hASContainer2, list);
        }
        HASContainerBuilder.release(arrayList);
        return n2;
    }

    private static ArrayList borrowArrayList() {
        ArrayList arrayList = (ArrayList)ARRAYLIST_POOL.borrow();
        if (null == arrayList) {
            arrayList = new ArrayList(20);
        }
        return arrayList;
    }

    private static void release(ArrayList arrayList) {
        if (null != arrayList && arrayList.size() <= 200) {
            arrayList.clear();
            ARRAYLIST_POOL.release(arrayList);
        }
    }

    static {
        ARRAYLIST_POOL = new PoorMansPool("HAS.ArrayList", 30);
    }
}

