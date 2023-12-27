/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.result.model;

import de.vw.mib.asl.api.speechengine.result.model.ResultCollection;
import de.vw.mib.asl.api.speechengine.result.model.ResultItem;
import de.vw.mib.asl.api.speechengine.result.model.ResultItemIdentifier;
import de.vw.mib.asl.internal.speechengine.result.model.ResultItemImpl;
import de.vw.mib.collections.ObjectArrayList;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import org.dsi.ifc.speechrec.GraphemicGroup;
import org.dsi.ifc.speechrec.NBestList;
import org.dsi.ifc.speechrec.NBestListEntry;

public class ResultCollectionImpl
implements ResultCollection {
    private int eventId;
    private NBestList model;
    private IntObjectOptHashMap groupToItems;

    public ResultCollectionImpl(int n, NBestList nBestList) {
        int n2;
        Object object;
        int n3;
        this.eventId = n;
        this.model = nBestList;
        if (nBestList.getGraphemicGroups() == null) {
            nBestList.graphemicGroups = new GraphemicGroup[0];
        }
        int n4 = nBestList.getGraphemicGroups().length;
        this.groupToItems = new IntObjectOptHashMap(n4 + 1);
        int n5 = 0;
        for (n3 = 0; n3 < n4; ++n3) {
            object = this.model.graphemicGroups[n3];
            if (object == null) continue;
            this.groupToItems.put(n3, new ObjectArrayList(((GraphemicGroup)object).getGraphemicGroupSize()));
            n5 += ((GraphemicGroup)object).getGraphemicGroupSize();
        }
        n3 = this.model.getEntries().length - n5;
        if (n3 > 0) {
            this.groupToItems.put(-1, new ObjectArrayList(n3));
        }
        object = new int[n4 + 1];
        object[0] = n4;
        for (n2 = 1; n2 < ((Object)object).length; ++n2) {
            object[n2] = false;
        }
        n2 = nBestList.getEntries().length;
        for (int i2 = 0; i2 < n2; ++i2) {
            NBestListEntry nBestListEntry = nBestList.getEntries()[i2];
            if (n2 > 1) {
                int n6 = nBestListEntry.getGraphemicGroupIndex() + 1;
                Object object2 = object;
                int n7 = n6;
                object2[n7] = object2[n7] + true;
                this.addItem(new ResultItemImpl((int)(object[n6] - true), nBestListEntry));
                continue;
            }
            this.addItem(new ResultItemImpl(i2, nBestListEntry));
        }
    }

    @Override
    public int getEventId() {
        return this.eventId;
    }

    @Override
    public int getSize() {
        return this.model.getEntries().length;
    }

    @Override
    public ResultItem[] getItems() {
        int n = this.groupToItems.containsKey(-1) ? this.groupToItems.keySet().size() + ((ObjectArrayList)this.groupToItems.get(-1)).size() : this.groupToItems.keySet().size();
        ObjectArrayList objectArrayList = new ObjectArrayList(n);
        IntIterator intIterator = this.groupToItems.keyIterator();
        while (intIterator.hasNext()) {
            Object object;
            int n2 = intIterator.next();
            if (n2 != -1) {
                object = this.createGroup(n2);
                if (object == null) continue;
                objectArrayList.add(object);
                continue;
            }
            object = this.get(-1);
            for (int i2 = 0; i2 < ((ObjectArrayList)object).size(); ++i2) {
                objectArrayList.add(((ObjectArrayList)object).get(i2));
            }
        }
        return (ResultItem[])objectArrayList.toArray(new ResultItem[objectArrayList.size()]);
    }

    private ResultItem[] getItems(int n) {
        ObjectArrayList objectArrayList = this.get(n);
        return (ResultItem[])objectArrayList.toArray(new ResultItem[objectArrayList.size()]);
    }

    private ResultItem getItem(ResultItemIdentifier resultItemIdentifier) {
        IntIterator intIterator = this.groupToItems.keyIterator();
        while (intIterator.hasNext()) {
            int n = intIterator.next();
            ResultItem[] resultItemArray = this.getItems(n);
            ResultItem resultItem = ResultCollectionImpl.getItemByIndex(resultItemArray, resultItemIdentifier.getObjectIndex());
            if (resultItem != null) {
                return resultItem;
            }
            for (int i2 = 0; i2 < resultItemArray.length; ++i2) {
                if (0 != resultItemArray[i2].getIdentifier().compareTo(resultItemIdentifier)) continue;
                return resultItemArray[i2];
            }
        }
        return null;
    }

    @Override
    public ResultItem select(ResultItem resultItem) {
        if (resultItem == null) {
            return this.getItem();
        }
        if (resultItem.hasGroup()) {
            ResultItem resultItem2 = this.getGroup(resultItem.getGroupId());
            return resultItem2;
        }
        ResultItem resultItem3 = this.getItem(resultItem.getIdentifier());
        return resultItem3;
    }

    @Override
    public ResultItem[] expand(ResultItem resultItem) {
        if (resultItem.isGroup()) {
            ResultItem[] resultItemArray = this.getItems(resultItem.getGroupId());
            return resultItemArray;
        }
        return new ResultItem[0];
    }

    @Override
    public ResultItem[] expand(int n) {
        ObjectArrayList objectArrayList = (ObjectArrayList)this.groupToItems.get(n);
        return objectArrayList == null ? new ResultItem[]{} : (ResultItem[])objectArrayList.toArray(new ResultItem[objectArrayList.size()]);
    }

    @Override
    public int[] getGroupsId() {
        return this.groupToItems.keysToArray();
    }

    @Override
    public ResultItem getItem() {
        return (ResultItem)this.get(-1).get(0);
    }

    private ResultItem getGroup(int n) {
        return this.createGroup(n);
    }

    @Override
    public ResultItem select(int n) {
        return this.getItems()[n];
    }

    private static ResultItem getItemByIndex(ResultItem[] resultItemArray, int n) {
        if (n >= 0 && n < resultItemArray.length) {
            return resultItemArray[n];
        }
        return null;
    }

    private void addItem(ResultItemImpl resultItemImpl) {
        int n = resultItemImpl.getGroupId();
        if (!this.groupToItems.containsKey(n)) {
            n = -1;
        }
        ((ObjectArrayList)this.groupToItems.get(n)).add(resultItemImpl);
    }

    private ObjectArrayList get(int n) {
        return this.groupToItems.containsKey(n) ? (ObjectArrayList)this.groupToItems.get(n) : new ObjectArrayList();
    }

    private ResultItem createGroup(int n) {
        if (this.groupToItems.containsKey(n)) {
            GraphemicGroup graphemicGroup = this.model.getGraphemicGroups()[n];
            return new ResultItemImpl(n, graphemicGroup.getGroupText(), graphemicGroup.getGraphemicGroupSize());
        }
        return null;
    }
}

