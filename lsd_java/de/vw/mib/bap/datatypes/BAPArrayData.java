/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.datatypes;

import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayDataList;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class BAPArrayData
implements BAPEntity,
BAPArrayDataList {
    private final int maxElements;
    private final ArrayList elements;
    private final ArrayHeader arrayHeader;

    public BAPArrayData(int n) {
        this(n, null);
    }

    public BAPArrayData(int n, ArrayHeader arrayHeader) {
        this.maxElements = n;
        this.arrayHeader = arrayHeader;
        this.elements = new ArrayList();
    }

    public BAPArrayData(BAPArrayDataList bAPArrayDataList) {
        this(0);
        bAPArrayDataList.addToList(this.elements);
    }

    private BAPArrayData(List list, int n, ArrayHeader arrayHeader) {
        this.maxElements = n;
        this.arrayHeader = arrayHeader;
        this.elements = new ArrayList(list);
    }

    public boolean add(BAPArrayElement bAPArrayElement) {
        if (this.elements.size() < this.maxElements) {
            return this.elements.add(bAPArrayElement);
        }
        return false;
    }

    public boolean replace(int n, BAPArrayElement bAPArrayElement) {
        boolean bl;
        if (0 <= n && n < this.elements.size()) {
            this.elements.set(n, bAPArrayElement);
            bl = true;
        } else {
            bl = false;
        }
        return bl;
    }

    @Override
    public void reset() {
        this.elements.clear();
    }

    @Override
    public int size() {
        return this.elements.size();
    }

    public int maxSize() {
        return this.maxElements;
    }

    @Override
    public BAPArrayElement get(int n) {
        return (BAPArrayElement)this.elements.get(n);
    }

    @Override
    public BAPArrayDataList getElements(int n, int n2) {
        return new BAPArrayData(this.elements.subList(n, n + n2), this.maxSize(), this.arrayHeader);
    }

    @Override
    public BAPArrayElement getLast() {
        return this.get(this.size() - 1);
    }

    @Override
    public BAPArrayElement getFirst() {
        return this.get(0);
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        int n;
        boolean bl;
        BAPArrayData bAPArrayData = (BAPArrayData)bAPEntity;
        int n2 = this.elements.size();
        boolean bl2 = bl = n2 == (n = bAPArrayData.size());
        if (bl) {
            for (int i2 = 0; i2 < n2; ++i2) {
                BAPArrayElement bAPArrayElement;
                BAPArrayElement bAPArrayElement2 = (BAPArrayElement)this.elements.get(i2);
                if (bAPArrayElement2.equalTo(bAPArrayElement = bAPArrayData.get(i2))) continue;
                bl = false;
                break;
            }
        }
        return bl;
    }

    @Override
    public int bitSize() {
        throw new UnsupportedOperationException("BAP array's are not support bitSize");
    }

    @Override
    public void deserialize(BitStream bitStream) {
        throw new UnsupportedOperationException("BAP array's are not deserializeable");
    }

    @Override
    public void serialize(BitStream bitStream) {
        int n = this.elements.size();
        for (int i2 = 0; i2 < n; ++i2) {
            BAPArrayElement bAPArrayElement = (BAPArrayElement)this.elements.get(i2);
            if (this.arrayHeader != null) {
                bAPArrayElement.setArrayHeader(this.arrayHeader);
            }
            bAPArrayElement.serialize(bitStream);
        }
    }

    @Override
    public String toString() {
        return "BAP array";
    }

    @Override
    public Iterator getIterator() {
        return this.elements.iterator();
    }

    @Override
    public BAPArrayElement[] toArray() {
        Object[] objectArray = new BAPArrayElement[this.elements.size()];
        return (BAPArrayElement[])this.elements.toArray(objectArray);
    }

    @Override
    public boolean addToList(List list) {
        return list.addAll(this.elements);
    }

    @Override
    public boolean addToList(int n, List list) {
        return list.addAll(n, this.elements);
    }
}

