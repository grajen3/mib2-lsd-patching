/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.copyonwrite;

import de.vw.mib.collections.CollectionsHelper;
import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.util.StringBuilder;
import java.util.Collection;
import java.util.Iterator;

public final class CowList {
    public static final CowList EMPTY = new CowList();
    private static final int SIZE_WARNING_THRESHOLD;
    private final Object head;
    private final CowList tail;
    private final int size;

    private CowList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private CowList(Object object, CowList cowList) {
        this.head = object;
        this.tail = cowList;
        this.size = cowList.size() + 1;
    }

    public int size() {
        return this.size;
    }

    public CowList add(Object object) {
        if (this.size >= 500) {
            CollectionsHelper.writeSizeWarning("CowList", this.size + 1, 3);
        }
        return new CowList(object, this);
    }

    public CowList addAll(CowList cowList) {
        CowList cowList2 = this;
        CowList cowList3 = cowList;
        while (cowList3 != EMPTY) {
            cowList2 = cowList2.add(cowList3.head);
            cowList3 = cowList3.tail;
        }
        return cowList2;
    }

    public CowList addAll(Collection collection) {
        CowList cowList = this;
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            cowList = cowList.add(iterator.next());
        }
        return cowList;
    }

    public Object head() {
        return this.head;
    }

    public CowList tail() {
        return this.tail;
    }

    public CowList remove(Object object) {
        CowList cowList = EMPTY;
        CowList cowList2 = this;
        while (cowList2 != EMPTY) {
            if (object == cowList2.head) {
                cowList = cowList2;
                break;
            }
            cowList2 = cowList2.tail;
        }
        if (cowList == EMPTY) {
            return this;
        }
        cowList2 = cowList.tail;
        CowList cowList3 = this;
        while (cowList3 != cowList) {
            cowList2 = cowList2.add(cowList3.head);
            cowList3 = cowList3.tail;
        }
        return cowList2;
    }

    public String toString() {
        return this.append(new StringBuilder()).toString();
    }

    public StringBuilder append(StringBuilder stringBuilder) {
        stringBuilder.append("[");
        String string = "";
        CowList cowList = this;
        while (cowList.size > 0) {
            stringBuilder.append(string).append(cowList.head);
            string = ", ";
            cowList = cowList.tail;
        }
        return stringBuilder.append("]");
    }

    public int hashCode() {
        HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
        CowList cowList = this;
        while (cowList != EMPTY) {
            hashCodeBuilder.append(cowList.head);
            cowList = cowList.tail;
        }
        return hashCodeBuilder.hashCode();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        CowList cowList = (CowList)object;
        CowList cowList2 = this;
        CowList cowList3 = cowList;
        do {
            if (!(cowList2.head == null ? cowList3.head != null : !cowList2.head.equals(cowList3.head))) continue;
            return false;
        } while ((cowList2 = cowList2.tail) != (cowList3 = cowList3.tail));
        return true;
    }

    public CowList addIfAbsent(Object object) {
        CowList cowList = this;
        while (cowList != EMPTY) {
            if (cowList.head == object) {
                return this;
            }
            cowList = cowList.tail;
        }
        return new CowList(object, this);
    }

    public CowList addAllAbsent(CowList cowList) {
        CowList cowList2 = this;
        CowList cowList3 = cowList;
        while (cowList3 != EMPTY) {
            cowList2 = cowList2.addIfAbsent(cowList3.head);
            cowList3 = cowList3.tail;
        }
        return cowList2;
    }

    public CowList addAllAbsent(Collection collection) {
        CowList cowList = this;
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            cowList = cowList.addIfAbsent(iterator.next());
        }
        return cowList;
    }

    public CowList removeAll(CowList cowList) {
        CowList cowList2 = EMPTY;
        CowList cowList3 = this;
        while (cowList3 != EMPTY) {
            if (!cowList.contains(cowList3.head)) {
                cowList2 = cowList2.add(cowList3.head);
            }
            cowList3 = cowList3.tail;
        }
        return cowList2;
    }

    public CowList removeAll(Collection collection) {
        CowList cowList = EMPTY;
        CowList cowList2 = this;
        while (cowList2 != EMPTY) {
            if (!collection.contains(cowList2.head)) {
                cowList = cowList.add(cowList2.head);
            }
            cowList2 = cowList2.tail;
        }
        return cowList;
    }

    public CowList retainAll(CowList cowList) {
        CowList cowList2 = EMPTY;
        CowList cowList3 = this;
        while (cowList3 != EMPTY) {
            if (cowList.contains(cowList3.head)) {
                cowList2 = cowList2.add(cowList3.head);
            }
            cowList3 = cowList3.tail;
        }
        return cowList2;
    }

    public CowList retainAll(Collection collection) {
        CowList cowList = EMPTY;
        CowList cowList2 = this;
        while (cowList2 != EMPTY) {
            if (collection.contains(cowList2.head)) {
                cowList = cowList.add(cowList2.head);
            }
            cowList2 = cowList2.tail;
        }
        return cowList;
    }

    public boolean contains(Object object) {
        CowList cowList = this;
        while (cowList != EMPTY) {
            if (cowList.head == object) {
                return true;
            }
            cowList = cowList.tail;
        }
        return false;
    }
}

