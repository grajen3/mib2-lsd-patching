/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.AbstractMap;
import edu.emory.mathcs.backport.java.util.AbstractMap$SimpleImmutableEntry;
import edu.emory.mathcs.backport.java.util.NavigableMap;
import edu.emory.mathcs.backport.java.util.NavigableSet;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentNavigableMap;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentSkipListMap$ComparableUsingComparator;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentSkipListMap$EntryIterator;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentSkipListMap$EntrySet;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentSkipListMap$HeadIndex;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentSkipListMap$Index;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentSkipListMap$KeyIterator;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentSkipListMap$KeySet;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentSkipListMap$Node;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentSkipListMap$SubMap;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentSkipListMap$ValueIterator;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentSkipListMap$Values;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;

public class ConcurrentSkipListMap
extends AbstractMap
implements ConcurrentNavigableMap,
Cloneable,
Serializable {
    private static final long serialVersionUID;
    private static final Random seedGenerator;
    private static final Object BASE_HEADER;
    private volatile transient ConcurrentSkipListMap$HeadIndex head;
    private final Comparator comparator;
    private transient int randomSeed;
    private transient ConcurrentSkipListMap$KeySet keySet;
    private transient ConcurrentSkipListMap$EntrySet entrySet;
    private transient ConcurrentSkipListMap$Values values;
    private transient ConcurrentNavigableMap descendingMap;
    private static final int EQ;
    private static final int LT;
    private static final int GT;

    final void initialize() {
        this.keySet = null;
        this.entrySet = null;
        this.values = null;
        this.descendingMap = null;
        this.randomSeed = seedGenerator.nextInt() | 0x100;
        this.head = new ConcurrentSkipListMap$HeadIndex(new ConcurrentSkipListMap$Node(null, BASE_HEADER, null), null, null, 1);
    }

    private synchronized boolean casHead(ConcurrentSkipListMap$HeadIndex concurrentSkipListMap$HeadIndex, ConcurrentSkipListMap$HeadIndex concurrentSkipListMap$HeadIndex2) {
        if (this.head == concurrentSkipListMap$HeadIndex) {
            this.head = concurrentSkipListMap$HeadIndex2;
            return true;
        }
        return false;
    }

    private Comparable comparable(Object object) {
        if (object == null) {
            throw new NullPointerException();
        }
        if (this.comparator != null) {
            return new ConcurrentSkipListMap$ComparableUsingComparator(object, this.comparator);
        }
        return (Comparable)object;
    }

    int compare(Object object, Object object2) {
        Comparator comparator = this.comparator;
        if (comparator != null) {
            return comparator.compare(object, object2);
        }
        return ((Comparable)object).compareTo(object2);
    }

    boolean inHalfOpenRange(Object object, Object object2, Object object3) {
        if (object == null) {
            throw new NullPointerException();
        }
        return !(object2 != null && this.compare(object, object2) < 0 || object3 != null && this.compare(object, object3) >= 0);
    }

    boolean inOpenRange(Object object, Object object2, Object object3) {
        if (object == null) {
            throw new NullPointerException();
        }
        return !(object2 != null && this.compare(object, object2) < 0 || object3 != null && this.compare(object, object3) > 0);
    }

    private ConcurrentSkipListMap$Node findPredecessor(Comparable comparable) {
        Object object;
        if (comparable == null) {
            throw new NullPointerException();
        }
        block0: while (true) {
            object = this.head;
            ConcurrentSkipListMap$Index concurrentSkipListMap$Index = ((ConcurrentSkipListMap$Index)object).right;
            while (true) {
                Object object2;
                if (concurrentSkipListMap$Index != null) {
                    object2 = concurrentSkipListMap$Index.node;
                    Object object3 = ((ConcurrentSkipListMap$Node)object2).key;
                    if (((ConcurrentSkipListMap$Node)object2).value == null) {
                        if (!((ConcurrentSkipListMap$Index)object).unlink(concurrentSkipListMap$Index)) continue block0;
                        concurrentSkipListMap$Index = ((ConcurrentSkipListMap$Index)object).right;
                        continue;
                    }
                    if (comparable.compareTo(object3) > 0) {
                        object = concurrentSkipListMap$Index;
                        concurrentSkipListMap$Index = concurrentSkipListMap$Index.right;
                        continue;
                    }
                }
                if ((object2 = ((ConcurrentSkipListMap$Index)object).down) == null) break block0;
                object = object2;
                concurrentSkipListMap$Index = ((ConcurrentSkipListMap$Index)object2).right;
            }
            break;
        }
        return ((ConcurrentSkipListMap$Index)object).node;
    }

    /*
     * Unable to fully structure code
     */
    private ConcurrentSkipListMap$Node findNode(Comparable var1_1) {
        block0: while (true) {
            var2_2 = this.findPredecessor(var1_1);
            var3_3 = var2_2.next;
            while (true) {
                if (var3_3 == null) {
                    return null;
                }
                var4_4 = var3_3.next;
                if (var3_3 != var2_2.next) continue block0;
                var5_5 = var3_3.value;
                if (var5_5 == null) {
                    var3_3.helpDelete(var2_2, var4_4);
                    continue block0;
                }
                if (var5_5 != var3_3 && var2_2.value != null) ** break;
                continue block0;
                var6_6 = var1_1.compareTo(var3_3.key);
                if (var6_6 == 0) {
                    return var3_3;
                }
                if (var6_6 < 0) {
                    return null;
                }
                var2_2 = var3_3;
                var3_3 = var4_4;
            }
            break;
        }
    }

    private Object doGet(Object object) {
        Object object2;
        int n;
        Object object3;
        ConcurrentSkipListMap$Node concurrentSkipListMap$Node;
        Comparable comparable = this.comparable(object);
        ConcurrentSkipListMap$Node concurrentSkipListMap$Node2 = null;
        ConcurrentSkipListMap$Index concurrentSkipListMap$Index = this.head;
        ConcurrentSkipListMap$Index concurrentSkipListMap$Index2 = concurrentSkipListMap$Index.right;
        while (true) {
            if (concurrentSkipListMap$Index2 != null && (concurrentSkipListMap$Node = concurrentSkipListMap$Index2.node) != concurrentSkipListMap$Node2 && (object3 = concurrentSkipListMap$Node.key) != null) {
                n = comparable.compareTo(object3);
                if (n > 0) {
                    concurrentSkipListMap$Index = concurrentSkipListMap$Index2;
                    concurrentSkipListMap$Index2 = concurrentSkipListMap$Index2.right;
                    continue;
                }
                if (n == 0) {
                    Object object4 = concurrentSkipListMap$Node.value;
                    return object4 != null ? object4 : this.getUsingFindNode(comparable);
                }
                concurrentSkipListMap$Node2 = concurrentSkipListMap$Node;
            }
            if ((object2 = concurrentSkipListMap$Index.down) == null) break;
            concurrentSkipListMap$Index = object2;
            concurrentSkipListMap$Index2 = ((ConcurrentSkipListMap$Index)object2).right;
        }
        concurrentSkipListMap$Node = concurrentSkipListMap$Index.node.next;
        while (concurrentSkipListMap$Node != null) {
            object3 = concurrentSkipListMap$Node.key;
            if (object3 != null) {
                n = comparable.compareTo(object3);
                if (n == 0) {
                    object2 = concurrentSkipListMap$Node.value;
                    return object2 != null ? object2 : this.getUsingFindNode(comparable);
                }
                if (n < 0) break;
            }
            concurrentSkipListMap$Node = concurrentSkipListMap$Node.next;
        }
        return null;
    }

    private Object getUsingFindNode(Comparable comparable) {
        ConcurrentSkipListMap$Node concurrentSkipListMap$Node;
        Object object;
        do {
            if ((concurrentSkipListMap$Node = this.findNode(comparable)) != null) continue;
            return null;
        } while ((object = concurrentSkipListMap$Node.value) == null);
        return object;
    }

    private Object doPut(Object object, Object object2, boolean bl) {
        ConcurrentSkipListMap$Node concurrentSkipListMap$Node;
        Comparable comparable = this.comparable(object);
        block0: while (true) {
            ConcurrentSkipListMap$Node concurrentSkipListMap$Node2 = this.findPredecessor(comparable);
            ConcurrentSkipListMap$Node concurrentSkipListMap$Node3 = concurrentSkipListMap$Node2.next;
            while (concurrentSkipListMap$Node3 != null) {
                concurrentSkipListMap$Node = concurrentSkipListMap$Node3.next;
                if (concurrentSkipListMap$Node3 != concurrentSkipListMap$Node2.next) continue block0;
                Object object3 = concurrentSkipListMap$Node3.value;
                if (object3 == null) {
                    concurrentSkipListMap$Node3.helpDelete(concurrentSkipListMap$Node2, concurrentSkipListMap$Node);
                    continue block0;
                }
                if (object3 == concurrentSkipListMap$Node3 || concurrentSkipListMap$Node2.value == null) continue block0;
                int n = comparable.compareTo(concurrentSkipListMap$Node3.key);
                if (n > 0) {
                    concurrentSkipListMap$Node2 = concurrentSkipListMap$Node3;
                    concurrentSkipListMap$Node3 = concurrentSkipListMap$Node;
                    continue;
                }
                if (n != 0) break;
                if (!bl && !concurrentSkipListMap$Node3.casValue(object3, object2)) continue block0;
                return object3;
            }
            if (concurrentSkipListMap$Node2.casNext(concurrentSkipListMap$Node3, concurrentSkipListMap$Node = new ConcurrentSkipListMap$Node(object, object2, concurrentSkipListMap$Node3))) break;
        }
        int n = this.randomLevel();
        if (n > 0) {
            this.insertIndex(concurrentSkipListMap$Node, n);
        }
        return null;
    }

    private int randomLevel() {
        int n = this.randomSeed;
        n ^= n << 13;
        n ^= n >>> 17;
        n ^= n << 5;
        this.randomSeed = n;
        if ((n & 0x1800000) != 0) {
            return 0;
        }
        int n2 = 1;
        while (((n >>>= 1) & 1) != 0) {
            ++n2;
        }
        return n2;
    }

    private void insertIndex(ConcurrentSkipListMap$Node concurrentSkipListMap$Node, int n) {
        ConcurrentSkipListMap$HeadIndex concurrentSkipListMap$HeadIndex = this.head;
        int n2 = concurrentSkipListMap$HeadIndex.level;
        if (n <= n2) {
            ConcurrentSkipListMap$Index concurrentSkipListMap$Index = null;
            for (int i2 = 1; i2 <= n; ++i2) {
                concurrentSkipListMap$Index = new ConcurrentSkipListMap$Index(concurrentSkipListMap$Node, concurrentSkipListMap$Index, null);
            }
            this.addIndex(concurrentSkipListMap$Index, concurrentSkipListMap$HeadIndex, n);
        } else {
            int n3;
            ConcurrentSkipListMap$HeadIndex concurrentSkipListMap$HeadIndex2;
            ConcurrentSkipListMap$Index[] concurrentSkipListMap$IndexArray;
            block7: {
                int n4;
                ConcurrentSkipListMap$HeadIndex concurrentSkipListMap$HeadIndex3;
                n = n2 + 1;
                concurrentSkipListMap$IndexArray = new ConcurrentSkipListMap$Index[n + 1];
                ConcurrentSkipListMap$Index concurrentSkipListMap$Index = null;
                for (int i3 = 1; i3 <= n; ++i3) {
                    concurrentSkipListMap$IndexArray[i3] = concurrentSkipListMap$Index = new ConcurrentSkipListMap$Index(concurrentSkipListMap$Node, concurrentSkipListMap$Index, null);
                }
                do {
                    concurrentSkipListMap$HeadIndex2 = this.head;
                    n4 = concurrentSkipListMap$HeadIndex2.level;
                    if (n <= n4) {
                        n3 = n;
                        break block7;
                    }
                    concurrentSkipListMap$HeadIndex3 = concurrentSkipListMap$HeadIndex2;
                    ConcurrentSkipListMap$Node concurrentSkipListMap$Node2 = concurrentSkipListMap$HeadIndex2.node;
                    for (int i4 = n4 + 1; i4 <= n; ++i4) {
                        concurrentSkipListMap$HeadIndex3 = new ConcurrentSkipListMap$HeadIndex(concurrentSkipListMap$Node2, concurrentSkipListMap$HeadIndex3, concurrentSkipListMap$IndexArray[i4], i4);
                    }
                } while (!this.casHead(concurrentSkipListMap$HeadIndex2, concurrentSkipListMap$HeadIndex3));
                n3 = n4;
            }
            this.addIndex(concurrentSkipListMap$IndexArray[n3], concurrentSkipListMap$HeadIndex2, n3);
        }
    }

    /*
     * Unable to fully structure code
     */
    private void addIndex(ConcurrentSkipListMap$Index var1_1, ConcurrentSkipListMap$HeadIndex var2_2, int var3_3) {
        var4_4 = var3_3;
        var5_5 = this.comparable(var1_1.node.key);
        if (var5_5 == null) {
            throw new NullPointerException();
        }
        block0: while (true) {
            var6_6 = var2_2.level;
            var7_7 = var2_2;
            var8_8 = var7_7.right;
            var9_9 = var1_1;
            while (true) {
                if (var8_8 != null) {
                    var10_10 = var8_8.node;
                    var11_11 = var5_5.compareTo(var10_10.key);
                    if (var10_10.value == null) {
                        if (!var7_7.unlink(var8_8)) continue block0;
                        var8_8 = var7_7.right;
                        continue;
                    }
                    if (var11_11 > 0) {
                        var7_7 = var8_8;
                        var8_8 = var8_8.right;
                        continue;
                    }
                }
                if (var6_6 == var4_4) {
                    if (var9_9.indexesDeletedNode()) {
                        this.findNode(var5_5);
                        return;
                    }
                    if (var7_7.link(var8_8, var9_9)) ** break;
                    continue block0;
                    if (--var4_4 == 0) {
                        if (var9_9.indexesDeletedNode()) {
                            this.findNode(var5_5);
                        }
                        return;
                    }
                }
                if (--var6_6 >= var4_4 && var6_6 < var3_3) {
                    var9_9 = var9_9.down;
                }
                var7_7 = var7_7.down;
                var8_8 = var7_7.right;
            }
            break;
        }
    }

    final Object doRemove(Object object, Object object2) {
        Object object3;
        ConcurrentSkipListMap$Node concurrentSkipListMap$Node;
        ConcurrentSkipListMap$Node concurrentSkipListMap$Node2;
        ConcurrentSkipListMap$Node concurrentSkipListMap$Node3;
        Comparable comparable = this.comparable(object);
        block0: while (true) {
            concurrentSkipListMap$Node3 = this.findPredecessor(comparable);
            concurrentSkipListMap$Node2 = concurrentSkipListMap$Node3.next;
            while (true) {
                if (concurrentSkipListMap$Node2 == null) {
                    return null;
                }
                concurrentSkipListMap$Node = concurrentSkipListMap$Node2.next;
                if (concurrentSkipListMap$Node2 != concurrentSkipListMap$Node3.next) continue block0;
                object3 = concurrentSkipListMap$Node2.value;
                if (object3 == null) {
                    concurrentSkipListMap$Node2.helpDelete(concurrentSkipListMap$Node3, concurrentSkipListMap$Node);
                    continue block0;
                }
                if (object3 == concurrentSkipListMap$Node2 || concurrentSkipListMap$Node3.value == null) continue block0;
                int n = comparable.compareTo(concurrentSkipListMap$Node2.key);
                if (n < 0) {
                    return null;
                }
                if (n <= 0) break;
                concurrentSkipListMap$Node3 = concurrentSkipListMap$Node2;
                concurrentSkipListMap$Node2 = concurrentSkipListMap$Node;
            }
            if (object2 != null && !object2.equals(object3)) {
                return null;
            }
            if (concurrentSkipListMap$Node2.casValue(object3, null)) break;
        }
        if (!concurrentSkipListMap$Node2.appendMarker(concurrentSkipListMap$Node) || !concurrentSkipListMap$Node3.casNext(concurrentSkipListMap$Node2, concurrentSkipListMap$Node)) {
            this.findNode(comparable);
        } else {
            this.findPredecessor(comparable);
            if (this.head.right == null) {
                this.tryReduceLevel();
            }
        }
        return object3;
    }

    private void tryReduceLevel() {
        ConcurrentSkipListMap$HeadIndex concurrentSkipListMap$HeadIndex;
        ConcurrentSkipListMap$HeadIndex concurrentSkipListMap$HeadIndex2;
        ConcurrentSkipListMap$HeadIndex concurrentSkipListMap$HeadIndex3 = this.head;
        if (concurrentSkipListMap$HeadIndex3.level > 3 && (concurrentSkipListMap$HeadIndex2 = (ConcurrentSkipListMap$HeadIndex)concurrentSkipListMap$HeadIndex3.down) != null && (concurrentSkipListMap$HeadIndex = (ConcurrentSkipListMap$HeadIndex)concurrentSkipListMap$HeadIndex2.down) != null && concurrentSkipListMap$HeadIndex.right == null && concurrentSkipListMap$HeadIndex2.right == null && concurrentSkipListMap$HeadIndex3.right == null && this.casHead(concurrentSkipListMap$HeadIndex3, concurrentSkipListMap$HeadIndex2) && concurrentSkipListMap$HeadIndex3.right != null) {
            this.casHead(concurrentSkipListMap$HeadIndex2, concurrentSkipListMap$HeadIndex3);
        }
    }

    ConcurrentSkipListMap$Node findFirst() {
        while (true) {
            ConcurrentSkipListMap$Node concurrentSkipListMap$Node = this.head.node;
            ConcurrentSkipListMap$Node concurrentSkipListMap$Node2 = concurrentSkipListMap$Node.next;
            if (concurrentSkipListMap$Node2 == null) {
                return null;
            }
            if (concurrentSkipListMap$Node2.value != null) {
                return concurrentSkipListMap$Node2;
            }
            concurrentSkipListMap$Node2.helpDelete(concurrentSkipListMap$Node, concurrentSkipListMap$Node2.next);
        }
    }

    Map$Entry doRemoveFirstEntry() {
        Object object;
        ConcurrentSkipListMap$Node concurrentSkipListMap$Node;
        ConcurrentSkipListMap$Node concurrentSkipListMap$Node2;
        ConcurrentSkipListMap$Node concurrentSkipListMap$Node3;
        while (true) {
            concurrentSkipListMap$Node3 = this.head.node;
            concurrentSkipListMap$Node2 = concurrentSkipListMap$Node3.next;
            if (concurrentSkipListMap$Node2 == null) {
                return null;
            }
            concurrentSkipListMap$Node = concurrentSkipListMap$Node2.next;
            if (concurrentSkipListMap$Node2 != concurrentSkipListMap$Node3.next) continue;
            object = concurrentSkipListMap$Node2.value;
            if (object == null) {
                concurrentSkipListMap$Node2.helpDelete(concurrentSkipListMap$Node3, concurrentSkipListMap$Node);
                continue;
            }
            if (concurrentSkipListMap$Node2.casValue(object, null)) break;
        }
        if (!concurrentSkipListMap$Node2.appendMarker(concurrentSkipListMap$Node) || !concurrentSkipListMap$Node3.casNext(concurrentSkipListMap$Node2, concurrentSkipListMap$Node)) {
            this.findFirst();
        }
        this.clearIndexToFirst();
        return new AbstractMap$SimpleImmutableEntry(concurrentSkipListMap$Node2.key, object);
    }

    private void clearIndexToFirst() {
        block0: while (true) {
            ConcurrentSkipListMap$Index concurrentSkipListMap$Index = this.head;
            do {
                ConcurrentSkipListMap$Index concurrentSkipListMap$Index2;
                if ((concurrentSkipListMap$Index2 = concurrentSkipListMap$Index.right) != null && concurrentSkipListMap$Index2.indexesDeletedNode() && !concurrentSkipListMap$Index.unlink(concurrentSkipListMap$Index2)) continue block0;
            } while ((concurrentSkipListMap$Index = concurrentSkipListMap$Index.down) != null);
            break;
        }
        if (this.head.right == null) {
            this.tryReduceLevel();
        }
    }

    ConcurrentSkipListMap$Node findLast() {
        ConcurrentSkipListMap$Index concurrentSkipListMap$Index = this.head;
        while (true) {
            ConcurrentSkipListMap$Index concurrentSkipListMap$Index2;
            if ((concurrentSkipListMap$Index2 = concurrentSkipListMap$Index.right) != null) {
                if (concurrentSkipListMap$Index2.indexesDeletedNode()) {
                    concurrentSkipListMap$Index.unlink(concurrentSkipListMap$Index2);
                    concurrentSkipListMap$Index = this.head;
                    continue;
                }
                concurrentSkipListMap$Index = concurrentSkipListMap$Index2;
                continue;
            }
            ConcurrentSkipListMap$Index concurrentSkipListMap$Index3 = concurrentSkipListMap$Index.down;
            if (concurrentSkipListMap$Index3 != null) {
                concurrentSkipListMap$Index = concurrentSkipListMap$Index3;
                continue;
            }
            ConcurrentSkipListMap$Node concurrentSkipListMap$Node = concurrentSkipListMap$Index.node;
            ConcurrentSkipListMap$Node concurrentSkipListMap$Node2 = concurrentSkipListMap$Node.next;
            while (true) {
                if (concurrentSkipListMap$Node2 == null) {
                    return concurrentSkipListMap$Node.isBaseHeader() ? null : concurrentSkipListMap$Node;
                }
                ConcurrentSkipListMap$Node concurrentSkipListMap$Node3 = concurrentSkipListMap$Node2.next;
                if (concurrentSkipListMap$Node2 != concurrentSkipListMap$Node.next) break;
                Object object = concurrentSkipListMap$Node2.value;
                if (object == null) {
                    concurrentSkipListMap$Node2.helpDelete(concurrentSkipListMap$Node, concurrentSkipListMap$Node3);
                    break;
                }
                if (object == concurrentSkipListMap$Node2 || concurrentSkipListMap$Node.value == null) break;
                concurrentSkipListMap$Node = concurrentSkipListMap$Node2;
                concurrentSkipListMap$Node2 = concurrentSkipListMap$Node3;
            }
            concurrentSkipListMap$Index = this.head;
        }
    }

    private ConcurrentSkipListMap$Node findPredecessorOfLast() {
        ConcurrentSkipListMap$Index concurrentSkipListMap$Index;
        block0: while (true) {
            concurrentSkipListMap$Index = this.head;
            while (true) {
                ConcurrentSkipListMap$Index concurrentSkipListMap$Index2;
                ConcurrentSkipListMap$Index concurrentSkipListMap$Index3;
                if ((concurrentSkipListMap$Index3 = concurrentSkipListMap$Index.right) != null) {
                    if (concurrentSkipListMap$Index3.indexesDeletedNode()) {
                        concurrentSkipListMap$Index.unlink(concurrentSkipListMap$Index3);
                        continue block0;
                    }
                    if (concurrentSkipListMap$Index3.node.next != null) {
                        concurrentSkipListMap$Index = concurrentSkipListMap$Index3;
                        continue;
                    }
                }
                if ((concurrentSkipListMap$Index2 = concurrentSkipListMap$Index.down) == null) break block0;
                concurrentSkipListMap$Index = concurrentSkipListMap$Index2;
            }
            break;
        }
        return concurrentSkipListMap$Index.node;
    }

    Map$Entry doRemoveLastEntry() {
        Object object;
        ConcurrentSkipListMap$Node concurrentSkipListMap$Node;
        ConcurrentSkipListMap$Node concurrentSkipListMap$Node2;
        ConcurrentSkipListMap$Node concurrentSkipListMap$Node3;
        block0: while (true) {
            concurrentSkipListMap$Node3 = this.findPredecessorOfLast();
            concurrentSkipListMap$Node2 = concurrentSkipListMap$Node3.next;
            if (concurrentSkipListMap$Node2 == null) {
                if (!concurrentSkipListMap$Node3.isBaseHeader()) continue;
                return null;
            }
            while (true) {
                concurrentSkipListMap$Node = concurrentSkipListMap$Node2.next;
                if (concurrentSkipListMap$Node2 != concurrentSkipListMap$Node3.next) continue block0;
                object = concurrentSkipListMap$Node2.value;
                if (object == null) {
                    concurrentSkipListMap$Node2.helpDelete(concurrentSkipListMap$Node3, concurrentSkipListMap$Node);
                    continue block0;
                }
                if (object == concurrentSkipListMap$Node2 || concurrentSkipListMap$Node3.value == null) continue block0;
                if (concurrentSkipListMap$Node == null) break;
                concurrentSkipListMap$Node3 = concurrentSkipListMap$Node2;
                concurrentSkipListMap$Node2 = concurrentSkipListMap$Node;
            }
            if (concurrentSkipListMap$Node2.casValue(object, null)) break;
        }
        Object object2 = concurrentSkipListMap$Node2.key;
        Comparable comparable = this.comparable(object2);
        if (!concurrentSkipListMap$Node2.appendMarker(concurrentSkipListMap$Node) || !concurrentSkipListMap$Node3.casNext(concurrentSkipListMap$Node2, concurrentSkipListMap$Node)) {
            this.findNode(comparable);
        } else {
            this.findPredecessor(comparable);
            if (this.head.right == null) {
                this.tryReduceLevel();
            }
        }
        return new AbstractMap$SimpleImmutableEntry(object2, object);
    }

    /*
     * Unable to fully structure code
     */
    ConcurrentSkipListMap$Node findNear(Object var1_1, int var2_2) {
        var3_3 = this.comparable(var1_1);
        block0: while (true) {
            var4_4 = this.findPredecessor(var3_3);
            var5_5 = var4_4.next;
            while (true) {
                if (var5_5 == null) {
                    return (var2_2 & 2) == 0 || var4_4.isBaseHeader() != false ? null : var4_4;
                }
                var6_6 = var5_5.next;
                if (var5_5 != var4_4.next) continue block0;
                var7_7 = var5_5.value;
                if (var7_7 == null) {
                    var5_5.helpDelete(var4_4, var6_6);
                    continue block0;
                }
                if (var7_7 != var5_5 && var4_4.value != null) ** break;
                continue block0;
                var8_8 = var3_3.compareTo(var5_5.key);
                if (var8_8 == 0 && (var2_2 & 1) != 0 || var8_8 < 0 && (var2_2 & 2) == 0) {
                    return var5_5;
                }
                if (var8_8 <= 0 && (var2_2 & 2) != 0) {
                    return var4_4.isBaseHeader() != false ? null : var4_4;
                }
                var4_4 = var5_5;
                var5_5 = var6_6;
            }
            break;
        }
    }

    AbstractMap$SimpleImmutableEntry getNear(Object object, int n) {
        ConcurrentSkipListMap$Node concurrentSkipListMap$Node;
        AbstractMap$SimpleImmutableEntry abstractMap$SimpleImmutableEntry;
        do {
            if ((concurrentSkipListMap$Node = this.findNear(object, n)) != null) continue;
            return null;
        } while ((abstractMap$SimpleImmutableEntry = concurrentSkipListMap$Node.createSnapshot()) == null);
        return abstractMap$SimpleImmutableEntry;
    }

    public ConcurrentSkipListMap() {
        this.comparator = null;
        this.initialize();
    }

    public ConcurrentSkipListMap(Comparator comparator) {
        this.comparator = comparator;
        this.initialize();
    }

    public ConcurrentSkipListMap(Map map) {
        this.comparator = null;
        this.initialize();
        this.putAll(map);
    }

    public ConcurrentSkipListMap(SortedMap sortedMap) {
        this.comparator = sortedMap.comparator();
        this.initialize();
        this.buildFromSorted(sortedMap);
    }

    @Override
    public Object clone() {
        ConcurrentSkipListMap concurrentSkipListMap = null;
        try {
            concurrentSkipListMap = (ConcurrentSkipListMap)super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new InternalError();
        }
        concurrentSkipListMap.initialize();
        concurrentSkipListMap.buildFromSorted(this);
        return concurrentSkipListMap;
    }

    private void buildFromSorted(SortedMap sortedMap) {
        if (sortedMap == null) {
            throw new NullPointerException();
        }
        ConcurrentSkipListMap$HeadIndex concurrentSkipListMap$HeadIndex = this.head;
        ConcurrentSkipListMap$Node concurrentSkipListMap$Node = concurrentSkipListMap$HeadIndex.node;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 <= concurrentSkipListMap$HeadIndex.level; ++i2) {
            arrayList.add(null);
        }
        ConcurrentSkipListMap$Index concurrentSkipListMap$Index = concurrentSkipListMap$HeadIndex;
        for (int i3 = concurrentSkipListMap$HeadIndex.level; i3 > 0; --i3) {
            arrayList.set(i3, concurrentSkipListMap$Index);
            concurrentSkipListMap$Index = concurrentSkipListMap$Index.down;
        }
        Iterator iterator = sortedMap.entrySet().iterator();
        while (iterator.hasNext()) {
            ConcurrentSkipListMap$Node concurrentSkipListMap$Node2;
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            int n = this.randomLevel();
            if (n > concurrentSkipListMap$HeadIndex.level) {
                n = concurrentSkipListMap$HeadIndex.level + 1;
            }
            Object object = map$Entry.getKey();
            Object object2 = map$Entry.getValue();
            if (object == null || object2 == null) {
                throw new NullPointerException();
            }
            concurrentSkipListMap$Node.next = concurrentSkipListMap$Node2 = new ConcurrentSkipListMap$Node(object, object2, null);
            concurrentSkipListMap$Node = concurrentSkipListMap$Node2;
            if (n <= 0) continue;
            ConcurrentSkipListMap$Index concurrentSkipListMap$Index2 = null;
            for (int i4 = 1; i4 <= n; ++i4) {
                concurrentSkipListMap$Index2 = new ConcurrentSkipListMap$Index(concurrentSkipListMap$Node2, concurrentSkipListMap$Index2, null);
                if (i4 > concurrentSkipListMap$HeadIndex.level) {
                    concurrentSkipListMap$HeadIndex = new ConcurrentSkipListMap$HeadIndex(concurrentSkipListMap$HeadIndex.node, concurrentSkipListMap$HeadIndex, concurrentSkipListMap$Index2, i4);
                }
                if (i4 < arrayList.size()) {
                    ((ConcurrentSkipListMap$Index)arrayList.get((int)i4)).right = concurrentSkipListMap$Index2;
                    arrayList.set(i4, concurrentSkipListMap$Index2);
                    continue;
                }
                arrayList.add(concurrentSkipListMap$Index2);
            }
        }
        this.head = concurrentSkipListMap$HeadIndex;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        ConcurrentSkipListMap$Node concurrentSkipListMap$Node = this.findFirst();
        while (concurrentSkipListMap$Node != null) {
            Object object = concurrentSkipListMap$Node.getValidValue();
            if (object != null) {
                objectOutputStream.writeObject(concurrentSkipListMap$Node.key);
                objectOutputStream.writeObject(object);
            }
            concurrentSkipListMap$Node = concurrentSkipListMap$Node.next;
        }
        objectOutputStream.writeObject(null);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        Object object;
        objectInputStream.defaultReadObject();
        this.initialize();
        ConcurrentSkipListMap$HeadIndex concurrentSkipListMap$HeadIndex = this.head;
        ConcurrentSkipListMap$Node concurrentSkipListMap$Node = concurrentSkipListMap$HeadIndex.node;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 <= concurrentSkipListMap$HeadIndex.level; ++i2) {
            arrayList.add(null);
        }
        ConcurrentSkipListMap$Index concurrentSkipListMap$Index = concurrentSkipListMap$HeadIndex;
        for (int i3 = concurrentSkipListMap$HeadIndex.level; i3 > 0; --i3) {
            arrayList.set(i3, concurrentSkipListMap$Index);
            concurrentSkipListMap$Index = concurrentSkipListMap$Index.down;
        }
        while ((object = objectInputStream.readObject()) != null) {
            ConcurrentSkipListMap$Node concurrentSkipListMap$Node2;
            Object object2 = objectInputStream.readObject();
            if (object2 == null) {
                throw new NullPointerException();
            }
            Object object3 = object;
            Object object4 = object2;
            int n = this.randomLevel();
            if (n > concurrentSkipListMap$HeadIndex.level) {
                n = concurrentSkipListMap$HeadIndex.level + 1;
            }
            concurrentSkipListMap$Node.next = concurrentSkipListMap$Node2 = new ConcurrentSkipListMap$Node(object3, object4, null);
            concurrentSkipListMap$Node = concurrentSkipListMap$Node2;
            if (n <= 0) continue;
            ConcurrentSkipListMap$Index concurrentSkipListMap$Index2 = null;
            for (int i4 = 1; i4 <= n; ++i4) {
                concurrentSkipListMap$Index2 = new ConcurrentSkipListMap$Index(concurrentSkipListMap$Node2, concurrentSkipListMap$Index2, null);
                if (i4 > concurrentSkipListMap$HeadIndex.level) {
                    concurrentSkipListMap$HeadIndex = new ConcurrentSkipListMap$HeadIndex(concurrentSkipListMap$HeadIndex.node, concurrentSkipListMap$HeadIndex, concurrentSkipListMap$Index2, i4);
                }
                if (i4 < arrayList.size()) {
                    ((ConcurrentSkipListMap$Index)arrayList.get((int)i4)).right = concurrentSkipListMap$Index2;
                    arrayList.set(i4, concurrentSkipListMap$Index2);
                    continue;
                }
                arrayList.add(concurrentSkipListMap$Index2);
            }
        }
        this.head = concurrentSkipListMap$HeadIndex;
    }

    @Override
    public boolean containsKey(Object object) {
        return this.doGet(object) != null;
    }

    @Override
    public Object get(Object object) {
        return this.doGet(object);
    }

    @Override
    public Object put(Object object, Object object2) {
        if (object2 == null) {
            throw new NullPointerException();
        }
        return this.doPut(object, object2, false);
    }

    @Override
    public Object remove(Object object) {
        return this.doRemove(object, null);
    }

    @Override
    public boolean containsValue(Object object) {
        if (object == null) {
            throw new NullPointerException();
        }
        ConcurrentSkipListMap$Node concurrentSkipListMap$Node = this.findFirst();
        while (concurrentSkipListMap$Node != null) {
            Object object2 = concurrentSkipListMap$Node.getValidValue();
            if (object2 != null && object.equals(object2)) {
                return true;
            }
            concurrentSkipListMap$Node = concurrentSkipListMap$Node.next;
        }
        return false;
    }

    @Override
    public int size() {
        long l = 0L;
        ConcurrentSkipListMap$Node concurrentSkipListMap$Node = this.findFirst();
        while (concurrentSkipListMap$Node != null) {
            if (concurrentSkipListMap$Node.getValidValue() != null) {
                ++l;
            }
            concurrentSkipListMap$Node = concurrentSkipListMap$Node.next;
        }
        return l >= 0 ? -129 : (int)l;
    }

    @Override
    public boolean isEmpty() {
        return this.findFirst() == null;
    }

    @Override
    public void clear() {
        this.initialize();
    }

    @Override
    public Set keySet() {
        ConcurrentSkipListMap$KeySet concurrentSkipListMap$KeySet = this.keySet;
        return concurrentSkipListMap$KeySet != null ? concurrentSkipListMap$KeySet : (this.keySet = new ConcurrentSkipListMap$KeySet(this));
    }

    @Override
    public NavigableSet navigableKeySet() {
        ConcurrentSkipListMap$KeySet concurrentSkipListMap$KeySet = this.keySet;
        return concurrentSkipListMap$KeySet != null ? concurrentSkipListMap$KeySet : (this.keySet = new ConcurrentSkipListMap$KeySet(this));
    }

    @Override
    public Collection values() {
        ConcurrentSkipListMap$Values concurrentSkipListMap$Values = this.values;
        return concurrentSkipListMap$Values != null ? concurrentSkipListMap$Values : (this.values = new ConcurrentSkipListMap$Values(this));
    }

    @Override
    public Set entrySet() {
        ConcurrentSkipListMap$EntrySet concurrentSkipListMap$EntrySet = this.entrySet;
        return concurrentSkipListMap$EntrySet != null ? concurrentSkipListMap$EntrySet : (this.entrySet = new ConcurrentSkipListMap$EntrySet(this));
    }

    @Override
    public NavigableMap descendingMap() {
        ConcurrentNavigableMap concurrentNavigableMap = this.descendingMap;
        return concurrentNavigableMap != null ? concurrentNavigableMap : (this.descendingMap = new ConcurrentSkipListMap$SubMap(this, null, false, null, false, true));
    }

    @Override
    public NavigableSet descendingKeySet() {
        return this.descendingMap().navigableKeySet();
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Map)) {
            return false;
        }
        Map map = (Map)object;
        try {
            Map$Entry map$Entry;
            Iterator iterator = this.entrySet().iterator();
            while (iterator.hasNext()) {
                map$Entry = (Map$Entry)iterator.next();
                if (map$Entry.getValue().equals(map.get(map$Entry.getKey()))) continue;
                return false;
            }
            iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                map$Entry = (Map$Entry)iterator.next();
                Object object2 = map$Entry.getKey();
                Object object3 = map$Entry.getValue();
                if (object2 != null && object3 != null && object3.equals(this.get(object2))) continue;
                return false;
            }
            return true;
        }
        catch (ClassCastException classCastException) {
            return false;
        }
        catch (NullPointerException nullPointerException) {
            return false;
        }
    }

    @Override
    public Object putIfAbsent(Object object, Object object2) {
        if (object2 == null) {
            throw new NullPointerException();
        }
        return this.doPut(object, object2, true);
    }

    @Override
    public boolean remove(Object object, Object object2) {
        if (object == null) {
            throw new NullPointerException();
        }
        if (object2 == null) {
            return false;
        }
        return this.doRemove(object, object2) != null;
    }

    @Override
    public boolean replace(Object object, Object object2, Object object3) {
        if (object2 == null || object3 == null) {
            throw new NullPointerException();
        }
        Comparable comparable = this.comparable(object);
        while (true) {
            ConcurrentSkipListMap$Node concurrentSkipListMap$Node;
            if ((concurrentSkipListMap$Node = this.findNode(comparable)) == null) {
                return false;
            }
            Object object4 = concurrentSkipListMap$Node.value;
            if (object4 == null) continue;
            if (!object2.equals(object4)) {
                return false;
            }
            if (concurrentSkipListMap$Node.casValue(object4, object3)) break;
        }
        return true;
    }

    @Override
    public Object replace(Object object, Object object2) {
        ConcurrentSkipListMap$Node concurrentSkipListMap$Node;
        Object object3;
        if (object2 == null) {
            throw new NullPointerException();
        }
        Comparable comparable = this.comparable(object);
        do {
            if ((concurrentSkipListMap$Node = this.findNode(comparable)) != null) continue;
            return null;
        } while ((object3 = concurrentSkipListMap$Node.value) == null || !concurrentSkipListMap$Node.casValue(object3, object2));
        return object3;
    }

    @Override
    public Comparator comparator() {
        return this.comparator;
    }

    @Override
    public Object firstKey() {
        ConcurrentSkipListMap$Node concurrentSkipListMap$Node = this.findFirst();
        if (concurrentSkipListMap$Node == null) {
            throw new NoSuchElementException();
        }
        return concurrentSkipListMap$Node.key;
    }

    @Override
    public Object lastKey() {
        ConcurrentSkipListMap$Node concurrentSkipListMap$Node = this.findLast();
        if (concurrentSkipListMap$Node == null) {
            throw new NoSuchElementException();
        }
        return concurrentSkipListMap$Node.key;
    }

    @Override
    public NavigableMap subMap(Object object, boolean bl, Object object2, boolean bl2) {
        if (object == null || object2 == null) {
            throw new NullPointerException();
        }
        return new ConcurrentSkipListMap$SubMap(this, object, bl, object2, bl2, false);
    }

    @Override
    public NavigableMap headMap(Object object, boolean bl) {
        if (object == null) {
            throw new NullPointerException();
        }
        return new ConcurrentSkipListMap$SubMap(this, null, false, object, bl, false);
    }

    @Override
    public NavigableMap tailMap(Object object, boolean bl) {
        if (object == null) {
            throw new NullPointerException();
        }
        return new ConcurrentSkipListMap$SubMap(this, object, bl, null, false, false);
    }

    @Override
    public SortedMap subMap(Object object, Object object2) {
        return this.subMap(object, true, object2, false);
    }

    @Override
    public SortedMap headMap(Object object) {
        return this.headMap(object, false);
    }

    @Override
    public SortedMap tailMap(Object object) {
        return this.tailMap(object, true);
    }

    @Override
    public Map$Entry lowerEntry(Object object) {
        return this.getNear(object, 2);
    }

    @Override
    public Object lowerKey(Object object) {
        ConcurrentSkipListMap$Node concurrentSkipListMap$Node = this.findNear(object, 2);
        return concurrentSkipListMap$Node == null ? null : concurrentSkipListMap$Node.key;
    }

    @Override
    public Map$Entry floorEntry(Object object) {
        return this.getNear(object, 3);
    }

    @Override
    public Object floorKey(Object object) {
        ConcurrentSkipListMap$Node concurrentSkipListMap$Node = this.findNear(object, 3);
        return concurrentSkipListMap$Node == null ? null : concurrentSkipListMap$Node.key;
    }

    @Override
    public Map$Entry ceilingEntry(Object object) {
        return this.getNear(object, 1);
    }

    @Override
    public Object ceilingKey(Object object) {
        ConcurrentSkipListMap$Node concurrentSkipListMap$Node = this.findNear(object, 1);
        return concurrentSkipListMap$Node == null ? null : concurrentSkipListMap$Node.key;
    }

    @Override
    public Map$Entry higherEntry(Object object) {
        return this.getNear(object, 0);
    }

    @Override
    public Object higherKey(Object object) {
        ConcurrentSkipListMap$Node concurrentSkipListMap$Node = this.findNear(object, 0);
        return concurrentSkipListMap$Node == null ? null : concurrentSkipListMap$Node.key;
    }

    @Override
    public Map$Entry firstEntry() {
        ConcurrentSkipListMap$Node concurrentSkipListMap$Node;
        AbstractMap$SimpleImmutableEntry abstractMap$SimpleImmutableEntry;
        do {
            if ((concurrentSkipListMap$Node = this.findFirst()) != null) continue;
            return null;
        } while ((abstractMap$SimpleImmutableEntry = concurrentSkipListMap$Node.createSnapshot()) == null);
        return abstractMap$SimpleImmutableEntry;
    }

    @Override
    public Map$Entry lastEntry() {
        ConcurrentSkipListMap$Node concurrentSkipListMap$Node;
        AbstractMap$SimpleImmutableEntry abstractMap$SimpleImmutableEntry;
        do {
            if ((concurrentSkipListMap$Node = this.findLast()) != null) continue;
            return null;
        } while ((abstractMap$SimpleImmutableEntry = concurrentSkipListMap$Node.createSnapshot()) == null);
        return abstractMap$SimpleImmutableEntry;
    }

    @Override
    public Map$Entry pollFirstEntry() {
        return this.doRemoveFirstEntry();
    }

    @Override
    public Map$Entry pollLastEntry() {
        return this.doRemoveLastEntry();
    }

    Iterator keyIterator() {
        return new ConcurrentSkipListMap$KeyIterator(this);
    }

    Iterator valueIterator() {
        return new ConcurrentSkipListMap$ValueIterator(this);
    }

    Iterator entryIterator() {
        return new ConcurrentSkipListMap$EntryIterator(this);
    }

    static final List toList(Collection collection) {
        ArrayList arrayList = new ArrayList();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            arrayList.add(iterator.next());
        }
        return arrayList;
    }

    static /* synthetic */ Object access$000() {
        return BASE_HEADER;
    }

    static {
        seedGenerator = new Random();
        BASE_HEADER = new Object();
    }
}

