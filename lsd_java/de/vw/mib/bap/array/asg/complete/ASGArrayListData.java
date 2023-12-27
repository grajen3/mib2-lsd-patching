/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.array.asg.complete;

import de.vw.mib.bap.array.asg.complete.ASGArrayListData$1;
import de.vw.mib.bap.datatypes.BAPArrayDataList;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ASGArrayListData
implements BAPArrayDataList {
    public static final int INDEX_NOT_FOUND;
    private static final BAPArrayElement EMPTY_ELEMENT;
    private ArrayList _arrayElements;

    ASGArrayListData() {
    }

    ASGArrayListData(BAPArrayDataList bAPArrayDataList) {
        bAPArrayDataList.addToList(this.getArrayElements());
    }

    private ASGArrayListData(List list) {
        this._arrayElements = new ArrayList(list);
    }

    private ArrayList getArrayElements() {
        if (this._arrayElements == null) {
            this._arrayElements = new ArrayList();
        }
        return this._arrayElements;
    }

    @Override
    public int size() {
        return this.getArrayElements().size();
    }

    public int insertAfter(int n, BAPArrayDataList bAPArrayDataList, int n2) {
        int n3;
        int n4 = n3 = n == 0 ? 0 : this.indexOf(n);
        if (n3 != -1) {
            int n5 = 0;
            int n6 = this.getArrayElements().isEmpty() ? 0 : n3 + 1;
            int n7 = Math.min(bAPArrayDataList.size(), n2);
            while (n5 < n7) {
                this.add(n6, bAPArrayDataList.get(n5));
                ++n5;
                ++n6;
            }
        }
        return n3;
    }

    public int insertBefore(int n, BAPArrayElement bAPArrayElement) {
        int n2 = this.indexOf(n);
        if (n2 != -1) {
            n2 = this.add(n2 > 0 ? --n2 : n2, bAPArrayElement);
        }
        return n2;
    }

    public int add(BAPArrayElement bAPArrayElement) {
        int n = this.indexOf(bAPArrayElement);
        if (n == -1) {
            n = this.size();
            this.getArrayElements().add(bAPArrayElement);
        }
        return n;
    }

    public int add(int n, BAPArrayElement bAPArrayElement) {
        int n2 = this.indexOf(bAPArrayElement);
        if (n2 == -1) {
            n2 = n;
            this.getArrayElements().add(n, bAPArrayElement);
        }
        return n2;
    }

    public boolean replace(BAPArrayElement bAPArrayElement) {
        boolean bl;
        int n = this.indexOf(bAPArrayElement);
        boolean bl2 = bl = n != -1;
        if (bl) {
            this.getArrayElements().set(n, bAPArrayElement);
        }
        return bl;
    }

    public void clearAll() {
        this.getArrayElements().clear();
    }

    public boolean contains(int n) {
        return this.indexOf(n) != -1;
    }

    public int indexOf(BAPArrayElement bAPArrayElement) {
        return this.indexOf(bAPArrayElement.getPos());
    }

    public int indexOf(int n) {
        int n2 = -1;
        ArrayList arrayList = this.getArrayElements();
        int n3 = arrayList.size();
        for (int i2 = 0; i2 < n3; ++i2) {
            BAPArrayElement bAPArrayElement = (BAPArrayElement)arrayList.get(i2);
            if (bAPArrayElement.getPos() != n) continue;
            n2 = i2;
            break;
        }
        return n2;
    }

    @Override
    public BAPArrayElement get(int n) {
        return (BAPArrayElement)this.getArrayElements().get(n);
    }

    @Override
    public BAPArrayDataList getElements(int n, int n2) {
        return new ASGArrayListData(this.getArrayElements().subList(n, n + n2));
    }

    @Override
    public BAPArrayElement getLast() {
        ArrayList arrayList = this.getArrayElements();
        BAPArrayElement bAPArrayElement = !arrayList.isEmpty() ? (BAPArrayElement)arrayList.get(arrayList.size() - 1) : EMPTY_ELEMENT;
        return bAPArrayElement;
    }

    @Override
    public BAPArrayElement getFirst() {
        ArrayList arrayList = this.getArrayElements();
        BAPArrayElement bAPArrayElement = !arrayList.isEmpty() ? (BAPArrayElement)arrayList.get(0) : EMPTY_ELEMENT;
        return bAPArrayElement;
    }

    public void reset(BAPArrayDataList bAPArrayDataList) {
        this.getArrayElements().clear();
        bAPArrayDataList.addToList(this.getArrayElements());
    }

    public void deleteElements(int n, int n2) {
        int n3 = n + n2;
        for (int i2 = n; i2 < n3 && i2 < this.size(); ++i2) {
            this.getArrayElements().remove(i2);
        }
    }

    public void deleteElement(int n) {
        this.getArrayElements().remove(n);
    }

    public boolean deleteElementPos(int n) {
        boolean bl;
        int n2 = this.indexOf(n);
        boolean bl2 = bl = n2 != -1;
        if (bl) {
            this.deleteElement(n2);
        }
        return bl;
    }

    public void deleteElementPositions(BAPArrayDataList bAPArrayDataList) {
        Iterator iterator = bAPArrayDataList.getIterator();
        while (iterator.hasNext()) {
            this.deleteElementPos(((BAPArrayElement)iterator.next()).getPos());
        }
    }

    public BAPArrayDataList toArrayDataList() {
        return new ASGArrayListData(this.getArrayElements());
    }

    @Override
    public Iterator getIterator() {
        return this.getArrayElements().iterator();
    }

    @Override
    public BAPArrayElement[] toArray() {
        ArrayList arrayList = this.getArrayElements();
        Object[] objectArray = new BAPArrayElement[arrayList.size()];
        return (BAPArrayElement[])arrayList.toArray(objectArray);
    }

    @Override
    public boolean addToList(List list) {
        return list.addAll(this.getArrayElements());
    }

    @Override
    public boolean addToList(int n, List list) {
        return list.addAll(n, this.getArrayElements());
    }

    static {
        EMPTY_ELEMENT = new ASGArrayListData$1();
    }
}

