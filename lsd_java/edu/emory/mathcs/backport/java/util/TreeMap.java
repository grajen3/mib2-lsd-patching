/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import edu.emory.mathcs.backport.java.util.AbstractMap;
import edu.emory.mathcs.backport.java.util.AbstractMap$SimpleImmutableEntry;
import edu.emory.mathcs.backport.java.util.Collections;
import edu.emory.mathcs.backport.java.util.NavigableMap;
import edu.emory.mathcs.backport.java.util.NavigableSet;
import edu.emory.mathcs.backport.java.util.TreeMap$AscendingKeySet;
import edu.emory.mathcs.backport.java.util.TreeMap$AscendingSubMap;
import edu.emory.mathcs.backport.java.util.TreeMap$DescendingSubMap;
import edu.emory.mathcs.backport.java.util.TreeMap$Entry;
import edu.emory.mathcs.backport.java.util.TreeMap$EntrySet;
import edu.emory.mathcs.backport.java.util.TreeMap$IOIterator;
import edu.emory.mathcs.backport.java.util.TreeMap$IteratorIOException;
import edu.emory.mathcs.backport.java.util.TreeMap$IteratorNoClassException;
import edu.emory.mathcs.backport.java.util.TreeMap$KeySet;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map$Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;

public class TreeMap
extends AbstractMap
implements NavigableMap,
Serializable {
    private static final long serialVersionUID;
    private final Comparator comparator;
    private transient TreeMap$Entry root;
    private transient int size = 0;
    private transient int modCount = 0;
    private transient TreeMap$EntrySet entrySet;
    private transient TreeMap$KeySet navigableKeySet;
    private transient NavigableMap descendingMap;
    private transient Comparator reverseComparator;

    public TreeMap() {
        this.comparator = null;
    }

    public TreeMap(Comparator comparator) {
        this.comparator = comparator;
    }

    public TreeMap(SortedMap sortedMap) {
        this.comparator = sortedMap.comparator();
        this.buildFromSorted(sortedMap.entrySet().iterator(), sortedMap.size());
    }

    public TreeMap(Map map) {
        this.comparator = null;
        this.putAll(map);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        this.root = null;
        this.size = 0;
        ++this.modCount;
    }

    @Override
    public Object clone() {
        TreeMap treeMap;
        try {
            treeMap = (TreeMap)super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new InternalError();
        }
        treeMap.root = null;
        treeMap.size = 0;
        treeMap.modCount = 0;
        if (!this.isEmpty()) {
            treeMap.buildFromSorted(this.entrySet().iterator(), this.size);
        }
        return treeMap;
    }

    @Override
    public Object put(Object object, Object object2) {
        if (this.root == null) {
            this.root = new TreeMap$Entry(object, object2);
            ++this.size;
            ++this.modCount;
            return null;
        }
        TreeMap$Entry treeMap$Entry = this.root;
        while (true) {
            int n;
            if ((n = TreeMap.compare(object, treeMap$Entry.getKey(), this.comparator)) == 0) {
                return treeMap$Entry.setValue(object2);
            }
            if (n <= 0) {
                if (TreeMap$Entry.access$000(treeMap$Entry) != null) {
                    treeMap$Entry = TreeMap$Entry.access$000(treeMap$Entry);
                    continue;
                }
                ++this.size;
                ++this.modCount;
                TreeMap$Entry treeMap$Entry2 = new TreeMap$Entry(object, object2);
                TreeMap$Entry.access$102(treeMap$Entry2, treeMap$Entry);
                TreeMap$Entry.access$002(treeMap$Entry, treeMap$Entry2);
                this.fixAfterInsertion(treeMap$Entry2);
                return null;
            }
            if (TreeMap$Entry.access$200(treeMap$Entry) == null) break;
            treeMap$Entry = TreeMap$Entry.access$200(treeMap$Entry);
        }
        ++this.size;
        ++this.modCount;
        TreeMap$Entry treeMap$Entry3 = new TreeMap$Entry(object, object2);
        TreeMap$Entry.access$102(treeMap$Entry3, treeMap$Entry);
        TreeMap$Entry.access$202(treeMap$Entry, treeMap$Entry3);
        this.fixAfterInsertion(treeMap$Entry3);
        return null;
    }

    @Override
    public Object get(Object object) {
        TreeMap$Entry treeMap$Entry = this.getEntry(object);
        return treeMap$Entry == null ? null : treeMap$Entry.getValue();
    }

    @Override
    public boolean containsKey(Object object) {
        return this.getEntry(object) != null;
    }

    @Override
    public Set entrySet() {
        if (this.entrySet == null) {
            this.entrySet = new TreeMap$EntrySet(this);
        }
        return this.entrySet;
    }

    private static TreeMap$Entry successor(TreeMap$Entry treeMap$Entry) {
        if (TreeMap$Entry.access$200(treeMap$Entry) != null) {
            treeMap$Entry = TreeMap$Entry.access$200(treeMap$Entry);
            while (TreeMap$Entry.access$000(treeMap$Entry) != null) {
                treeMap$Entry = TreeMap$Entry.access$000(treeMap$Entry);
            }
            return treeMap$Entry;
        }
        TreeMap$Entry treeMap$Entry2 = TreeMap$Entry.access$100(treeMap$Entry);
        while (treeMap$Entry2 != null && treeMap$Entry == TreeMap$Entry.access$200(treeMap$Entry2)) {
            treeMap$Entry = treeMap$Entry2;
            treeMap$Entry2 = TreeMap$Entry.access$100(treeMap$Entry2);
        }
        return treeMap$Entry2;
    }

    private static TreeMap$Entry predecessor(TreeMap$Entry treeMap$Entry) {
        if (TreeMap$Entry.access$000(treeMap$Entry) != null) {
            treeMap$Entry = TreeMap$Entry.access$000(treeMap$Entry);
            while (TreeMap$Entry.access$200(treeMap$Entry) != null) {
                treeMap$Entry = TreeMap$Entry.access$200(treeMap$Entry);
            }
            return treeMap$Entry;
        }
        TreeMap$Entry treeMap$Entry2 = TreeMap$Entry.access$100(treeMap$Entry);
        while (treeMap$Entry2 != null && treeMap$Entry == TreeMap$Entry.access$000(treeMap$Entry2)) {
            treeMap$Entry = treeMap$Entry2;
            treeMap$Entry2 = TreeMap$Entry.access$100(treeMap$Entry2);
        }
        return treeMap$Entry2;
    }

    private TreeMap$Entry getEntry(Object object) {
        TreeMap$Entry treeMap$Entry = this.root;
        if (this.comparator != null) {
            while (true) {
                if (treeMap$Entry == null) {
                    return null;
                }
                int n = this.comparator.compare(object, TreeMap$Entry.access$400(treeMap$Entry));
                if (n == 0) {
                    return treeMap$Entry;
                }
                treeMap$Entry = n < 0 ? TreeMap$Entry.access$000(treeMap$Entry) : TreeMap$Entry.access$200(treeMap$Entry);
            }
        }
        Comparable comparable = (Comparable)object;
        while (treeMap$Entry != null) {
            int n = comparable.compareTo(TreeMap$Entry.access$400(treeMap$Entry));
            if (n == 0) {
                return treeMap$Entry;
            }
            treeMap$Entry = n < 0 ? TreeMap$Entry.access$000(treeMap$Entry) : TreeMap$Entry.access$200(treeMap$Entry);
        }
        return null;
    }

    private TreeMap$Entry getHigherEntry(Object object) {
        TreeMap$Entry treeMap$Entry = this.root;
        if (treeMap$Entry == null) {
            return null;
        }
        while (true) {
            int n;
            if ((n = TreeMap.compare(object, TreeMap$Entry.access$400(treeMap$Entry), this.comparator)) < 0) {
                if (TreeMap$Entry.access$000(treeMap$Entry) != null) {
                    treeMap$Entry = TreeMap$Entry.access$000(treeMap$Entry);
                    continue;
                }
                return treeMap$Entry;
            }
            if (TreeMap$Entry.access$200(treeMap$Entry) == null) break;
            treeMap$Entry = TreeMap$Entry.access$200(treeMap$Entry);
        }
        TreeMap$Entry treeMap$Entry2 = TreeMap$Entry.access$100(treeMap$Entry);
        while (treeMap$Entry2 != null && treeMap$Entry == TreeMap$Entry.access$200(treeMap$Entry2)) {
            treeMap$Entry = treeMap$Entry2;
            treeMap$Entry2 = TreeMap$Entry.access$100(treeMap$Entry2);
        }
        return treeMap$Entry2;
    }

    private TreeMap$Entry getFirstEntry() {
        TreeMap$Entry treeMap$Entry = this.root;
        if (treeMap$Entry == null) {
            return null;
        }
        while (TreeMap$Entry.access$000(treeMap$Entry) != null) {
            treeMap$Entry = TreeMap$Entry.access$000(treeMap$Entry);
        }
        return treeMap$Entry;
    }

    private TreeMap$Entry getLastEntry() {
        TreeMap$Entry treeMap$Entry = this.root;
        if (treeMap$Entry == null) {
            return null;
        }
        while (TreeMap$Entry.access$200(treeMap$Entry) != null) {
            treeMap$Entry = TreeMap$Entry.access$200(treeMap$Entry);
        }
        return treeMap$Entry;
    }

    private TreeMap$Entry getCeilingEntry(Object object) {
        TreeMap$Entry treeMap$Entry;
        block5: {
            treeMap$Entry = this.root;
            if (treeMap$Entry == null) {
                return null;
            }
            while (true) {
                int n;
                if ((n = TreeMap.compare(object, TreeMap$Entry.access$400(treeMap$Entry), this.comparator)) < 0) {
                    if (TreeMap$Entry.access$000(treeMap$Entry) != null) {
                        treeMap$Entry = TreeMap$Entry.access$000(treeMap$Entry);
                        continue;
                    }
                    return treeMap$Entry;
                }
                if (n <= 0) break block5;
                if (TreeMap$Entry.access$200(treeMap$Entry) == null) break;
                treeMap$Entry = TreeMap$Entry.access$200(treeMap$Entry);
            }
            TreeMap$Entry treeMap$Entry2 = TreeMap$Entry.access$100(treeMap$Entry);
            while (treeMap$Entry2 != null && treeMap$Entry == TreeMap$Entry.access$200(treeMap$Entry2)) {
                treeMap$Entry = treeMap$Entry2;
                treeMap$Entry2 = TreeMap$Entry.access$100(treeMap$Entry2);
            }
            return treeMap$Entry2;
        }
        return treeMap$Entry;
    }

    private TreeMap$Entry getLowerEntry(Object object) {
        TreeMap$Entry treeMap$Entry = this.root;
        if (treeMap$Entry == null) {
            return null;
        }
        while (true) {
            int n;
            if ((n = TreeMap.compare(object, TreeMap$Entry.access$400(treeMap$Entry), this.comparator)) > 0) {
                if (TreeMap$Entry.access$200(treeMap$Entry) != null) {
                    treeMap$Entry = TreeMap$Entry.access$200(treeMap$Entry);
                    continue;
                }
                return treeMap$Entry;
            }
            if (TreeMap$Entry.access$000(treeMap$Entry) == null) break;
            treeMap$Entry = TreeMap$Entry.access$000(treeMap$Entry);
        }
        TreeMap$Entry treeMap$Entry2 = TreeMap$Entry.access$100(treeMap$Entry);
        while (treeMap$Entry2 != null && treeMap$Entry == TreeMap$Entry.access$000(treeMap$Entry2)) {
            treeMap$Entry = treeMap$Entry2;
            treeMap$Entry2 = TreeMap$Entry.access$100(treeMap$Entry2);
        }
        return treeMap$Entry2;
    }

    private TreeMap$Entry getFloorEntry(Object object) {
        TreeMap$Entry treeMap$Entry;
        block5: {
            treeMap$Entry = this.root;
            if (treeMap$Entry == null) {
                return null;
            }
            while (true) {
                int n;
                if ((n = TreeMap.compare(object, TreeMap$Entry.access$400(treeMap$Entry), this.comparator)) > 0) {
                    if (TreeMap$Entry.access$200(treeMap$Entry) != null) {
                        treeMap$Entry = TreeMap$Entry.access$200(treeMap$Entry);
                        continue;
                    }
                    return treeMap$Entry;
                }
                if (n >= 0) break block5;
                if (TreeMap$Entry.access$000(treeMap$Entry) == null) break;
                treeMap$Entry = TreeMap$Entry.access$000(treeMap$Entry);
            }
            TreeMap$Entry treeMap$Entry2 = TreeMap$Entry.access$100(treeMap$Entry);
            while (treeMap$Entry2 != null && treeMap$Entry == TreeMap$Entry.access$000(treeMap$Entry2)) {
                treeMap$Entry = treeMap$Entry2;
                treeMap$Entry2 = TreeMap$Entry.access$100(treeMap$Entry2);
            }
            return treeMap$Entry2;
        }
        return treeMap$Entry;
    }

    void buildFromSorted(Iterator iterator, int n) {
        ++this.modCount;
        this.size = n;
        int n2 = 0;
        int n3 = 1;
        while (n3 - 1 < n) {
            ++n2;
            n3 <<= 1;
        }
        this.root = TreeMap.createFromSorted(iterator, n, 0, n2);
    }

    private static TreeMap$Entry createFromSorted(Iterator iterator, int n, int n2, int n3) {
        ++n2;
        if (n == 0) {
            return null;
        }
        int n4 = n - 1 >> 1;
        int n5 = n - 1 - n4;
        TreeMap$Entry treeMap$Entry = TreeMap.createFromSorted(iterator, n4, n2, n3);
        Map$Entry map$Entry = (Map$Entry)iterator.next();
        TreeMap$Entry treeMap$Entry2 = TreeMap.createFromSorted(iterator, n5, n2, n3);
        TreeMap$Entry treeMap$Entry3 = new TreeMap$Entry(map$Entry.getKey(), map$Entry.getValue());
        if (treeMap$Entry != null) {
            TreeMap$Entry.access$002(treeMap$Entry3, treeMap$Entry);
            TreeMap$Entry.access$102(treeMap$Entry, treeMap$Entry3);
        }
        if (treeMap$Entry2 != null) {
            TreeMap$Entry.access$202(treeMap$Entry3, treeMap$Entry2);
            TreeMap$Entry.access$102(treeMap$Entry2, treeMap$Entry3);
        }
        if (n2 == n3) {
            TreeMap$Entry.access$502(treeMap$Entry3, false);
        }
        return treeMap$Entry3;
    }

    private void delete(TreeMap$Entry treeMap$Entry) {
        TreeMap$Entry treeMap$Entry2;
        if (TreeMap$Entry.access$000(treeMap$Entry) == null && TreeMap$Entry.access$200(treeMap$Entry) == null && TreeMap$Entry.access$100(treeMap$Entry) == null) {
            this.root = null;
            this.size = 0;
            ++this.modCount;
            return;
        }
        if (TreeMap$Entry.access$000(treeMap$Entry) != null && TreeMap$Entry.access$200(treeMap$Entry) != null) {
            treeMap$Entry2 = TreeMap.successor(treeMap$Entry);
            TreeMap$Entry.access$402(treeMap$Entry, TreeMap$Entry.access$400(treeMap$Entry2));
            TreeMap$Entry.access$602(treeMap$Entry, TreeMap$Entry.access$600(treeMap$Entry2));
            treeMap$Entry = treeMap$Entry2;
        }
        if (TreeMap$Entry.access$000(treeMap$Entry) == null && TreeMap$Entry.access$200(treeMap$Entry) == null) {
            if (TreeMap$Entry.access$500(treeMap$Entry)) {
                this.fixAfterDeletion(treeMap$Entry);
            }
            if (TreeMap$Entry.access$100(treeMap$Entry) != null) {
                if (treeMap$Entry == TreeMap$Entry.access$000(TreeMap$Entry.access$100(treeMap$Entry))) {
                    TreeMap$Entry.access$002(TreeMap$Entry.access$100(treeMap$Entry), null);
                } else if (treeMap$Entry == TreeMap$Entry.access$200(TreeMap$Entry.access$100(treeMap$Entry))) {
                    TreeMap$Entry.access$202(TreeMap$Entry.access$100(treeMap$Entry), null);
                }
                TreeMap$Entry.access$102(treeMap$Entry, null);
            }
        } else {
            treeMap$Entry2 = TreeMap$Entry.access$000(treeMap$Entry);
            if (treeMap$Entry2 == null) {
                treeMap$Entry2 = TreeMap$Entry.access$200(treeMap$Entry);
            }
            TreeMap$Entry.access$102(treeMap$Entry2, TreeMap$Entry.access$100(treeMap$Entry));
            if (TreeMap$Entry.access$100(treeMap$Entry) == null) {
                this.root = treeMap$Entry2;
            } else if (treeMap$Entry == TreeMap$Entry.access$000(TreeMap$Entry.access$100(treeMap$Entry))) {
                TreeMap$Entry.access$002(TreeMap$Entry.access$100(treeMap$Entry), treeMap$Entry2);
            } else {
                TreeMap$Entry.access$202(TreeMap$Entry.access$100(treeMap$Entry), treeMap$Entry2);
            }
            TreeMap$Entry.access$002(treeMap$Entry, null);
            TreeMap$Entry.access$202(treeMap$Entry, null);
            TreeMap$Entry.access$102(treeMap$Entry, null);
            if (TreeMap$Entry.access$500(treeMap$Entry)) {
                this.fixAfterDeletion(treeMap$Entry2);
            }
        }
        --this.size;
        ++this.modCount;
    }

    static boolean colorOf(TreeMap$Entry treeMap$Entry) {
        return treeMap$Entry == null ? true : TreeMap$Entry.access$500(treeMap$Entry);
    }

    static TreeMap$Entry parentOf(TreeMap$Entry treeMap$Entry) {
        return treeMap$Entry == null ? null : TreeMap$Entry.access$100(treeMap$Entry);
    }

    private static void setColor(TreeMap$Entry treeMap$Entry, boolean bl) {
        if (treeMap$Entry != null) {
            TreeMap$Entry.access$502(treeMap$Entry, bl);
        }
    }

    private static TreeMap$Entry leftOf(TreeMap$Entry treeMap$Entry) {
        return treeMap$Entry == null ? null : TreeMap$Entry.access$000(treeMap$Entry);
    }

    private static TreeMap$Entry rightOf(TreeMap$Entry treeMap$Entry) {
        return treeMap$Entry == null ? null : TreeMap$Entry.access$200(treeMap$Entry);
    }

    private final void rotateLeft(TreeMap$Entry treeMap$Entry) {
        TreeMap$Entry treeMap$Entry2 = TreeMap$Entry.access$200(treeMap$Entry);
        TreeMap$Entry.access$202(treeMap$Entry, TreeMap$Entry.access$000(treeMap$Entry2));
        if (TreeMap$Entry.access$000(treeMap$Entry2) != null) {
            TreeMap$Entry.access$102(TreeMap$Entry.access$000(treeMap$Entry2), treeMap$Entry);
        }
        TreeMap$Entry.access$102(treeMap$Entry2, TreeMap$Entry.access$100(treeMap$Entry));
        if (TreeMap$Entry.access$100(treeMap$Entry) == null) {
            this.root = treeMap$Entry2;
        } else if (TreeMap$Entry.access$000(TreeMap$Entry.access$100(treeMap$Entry)) == treeMap$Entry) {
            TreeMap$Entry.access$002(TreeMap$Entry.access$100(treeMap$Entry), treeMap$Entry2);
        } else {
            TreeMap$Entry.access$202(TreeMap$Entry.access$100(treeMap$Entry), treeMap$Entry2);
        }
        TreeMap$Entry.access$002(treeMap$Entry2, treeMap$Entry);
        TreeMap$Entry.access$102(treeMap$Entry, treeMap$Entry2);
    }

    private final void rotateRight(TreeMap$Entry treeMap$Entry) {
        TreeMap$Entry treeMap$Entry2 = TreeMap$Entry.access$000(treeMap$Entry);
        TreeMap$Entry.access$002(treeMap$Entry, TreeMap$Entry.access$200(treeMap$Entry2));
        if (TreeMap$Entry.access$200(treeMap$Entry2) != null) {
            TreeMap$Entry.access$102(TreeMap$Entry.access$200(treeMap$Entry2), treeMap$Entry);
        }
        TreeMap$Entry.access$102(treeMap$Entry2, TreeMap$Entry.access$100(treeMap$Entry));
        if (TreeMap$Entry.access$100(treeMap$Entry) == null) {
            this.root = treeMap$Entry2;
        } else if (TreeMap$Entry.access$200(TreeMap$Entry.access$100(treeMap$Entry)) == treeMap$Entry) {
            TreeMap$Entry.access$202(TreeMap$Entry.access$100(treeMap$Entry), treeMap$Entry2);
        } else {
            TreeMap$Entry.access$002(TreeMap$Entry.access$100(treeMap$Entry), treeMap$Entry2);
        }
        TreeMap$Entry.access$202(treeMap$Entry2, treeMap$Entry);
        TreeMap$Entry.access$102(treeMap$Entry, treeMap$Entry2);
    }

    private final void fixAfterInsertion(TreeMap$Entry treeMap$Entry) {
        TreeMap$Entry.access$502(treeMap$Entry, false);
        TreeMap$Entry treeMap$Entry2 = treeMap$Entry;
        while (treeMap$Entry2 != null && treeMap$Entry2 != this.root && !TreeMap$Entry.access$500(TreeMap$Entry.access$100(treeMap$Entry2))) {
            TreeMap$Entry treeMap$Entry3;
            if (TreeMap.parentOf(treeMap$Entry2) == TreeMap.leftOf(TreeMap.parentOf(TreeMap.parentOf(treeMap$Entry2)))) {
                treeMap$Entry3 = TreeMap.rightOf(TreeMap.parentOf(TreeMap.parentOf(treeMap$Entry2)));
                if (!TreeMap.colorOf(treeMap$Entry3)) {
                    TreeMap.setColor(TreeMap.parentOf(treeMap$Entry2), true);
                    TreeMap.setColor(treeMap$Entry3, true);
                    TreeMap.setColor(TreeMap.parentOf(TreeMap.parentOf(treeMap$Entry2)), false);
                    treeMap$Entry2 = TreeMap.parentOf(TreeMap.parentOf(treeMap$Entry2));
                    continue;
                }
                if (treeMap$Entry2 == TreeMap.rightOf(TreeMap.parentOf(treeMap$Entry2))) {
                    treeMap$Entry2 = TreeMap.parentOf(treeMap$Entry2);
                    this.rotateLeft(treeMap$Entry2);
                }
                TreeMap.setColor(TreeMap.parentOf(treeMap$Entry2), true);
                TreeMap.setColor(TreeMap.parentOf(TreeMap.parentOf(treeMap$Entry2)), false);
                if (TreeMap.parentOf(TreeMap.parentOf(treeMap$Entry2)) == null) continue;
                this.rotateRight(TreeMap.parentOf(TreeMap.parentOf(treeMap$Entry2)));
                continue;
            }
            treeMap$Entry3 = TreeMap.leftOf(TreeMap.parentOf(TreeMap.parentOf(treeMap$Entry2)));
            if (!TreeMap.colorOf(treeMap$Entry3)) {
                TreeMap.setColor(TreeMap.parentOf(treeMap$Entry2), true);
                TreeMap.setColor(treeMap$Entry3, true);
                TreeMap.setColor(TreeMap.parentOf(TreeMap.parentOf(treeMap$Entry2)), false);
                treeMap$Entry2 = TreeMap.parentOf(TreeMap.parentOf(treeMap$Entry2));
                continue;
            }
            if (treeMap$Entry2 == TreeMap.leftOf(TreeMap.parentOf(treeMap$Entry2))) {
                treeMap$Entry2 = TreeMap.parentOf(treeMap$Entry2);
                this.rotateRight(treeMap$Entry2);
            }
            TreeMap.setColor(TreeMap.parentOf(treeMap$Entry2), true);
            TreeMap.setColor(TreeMap.parentOf(TreeMap.parentOf(treeMap$Entry2)), false);
            if (TreeMap.parentOf(TreeMap.parentOf(treeMap$Entry2)) == null) continue;
            this.rotateLeft(TreeMap.parentOf(TreeMap.parentOf(treeMap$Entry2)));
        }
        TreeMap$Entry.access$502(this.root, true);
    }

    private final TreeMap$Entry fixAfterDeletion(TreeMap$Entry treeMap$Entry) {
        TreeMap$Entry treeMap$Entry2 = treeMap$Entry;
        while (treeMap$Entry2 != this.root && TreeMap.colorOf(treeMap$Entry2)) {
            TreeMap$Entry treeMap$Entry3;
            if (treeMap$Entry2 == TreeMap.leftOf(TreeMap.parentOf(treeMap$Entry2))) {
                treeMap$Entry3 = TreeMap.rightOf(TreeMap.parentOf(treeMap$Entry2));
                if (!TreeMap.colorOf(treeMap$Entry3)) {
                    TreeMap.setColor(treeMap$Entry3, true);
                    TreeMap.setColor(TreeMap.parentOf(treeMap$Entry2), false);
                    this.rotateLeft(TreeMap.parentOf(treeMap$Entry2));
                    treeMap$Entry3 = TreeMap.rightOf(TreeMap.parentOf(treeMap$Entry2));
                }
                if (TreeMap.colorOf(TreeMap.leftOf(treeMap$Entry3)) && TreeMap.colorOf(TreeMap.rightOf(treeMap$Entry3))) {
                    TreeMap.setColor(treeMap$Entry3, false);
                    treeMap$Entry2 = TreeMap.parentOf(treeMap$Entry2);
                    continue;
                }
                if (TreeMap.colorOf(TreeMap.rightOf(treeMap$Entry3))) {
                    TreeMap.setColor(TreeMap.leftOf(treeMap$Entry3), true);
                    TreeMap.setColor(treeMap$Entry3, false);
                    this.rotateRight(treeMap$Entry3);
                    treeMap$Entry3 = TreeMap.rightOf(TreeMap.parentOf(treeMap$Entry2));
                }
                TreeMap.setColor(treeMap$Entry3, TreeMap.colorOf(TreeMap.parentOf(treeMap$Entry2)));
                TreeMap.setColor(TreeMap.parentOf(treeMap$Entry2), true);
                TreeMap.setColor(TreeMap.rightOf(treeMap$Entry3), true);
                this.rotateLeft(TreeMap.parentOf(treeMap$Entry2));
                treeMap$Entry2 = this.root;
                continue;
            }
            treeMap$Entry3 = TreeMap.leftOf(TreeMap.parentOf(treeMap$Entry2));
            if (!TreeMap.colorOf(treeMap$Entry3)) {
                TreeMap.setColor(treeMap$Entry3, true);
                TreeMap.setColor(TreeMap.parentOf(treeMap$Entry2), false);
                this.rotateRight(TreeMap.parentOf(treeMap$Entry2));
                treeMap$Entry3 = TreeMap.leftOf(TreeMap.parentOf(treeMap$Entry2));
            }
            if (TreeMap.colorOf(TreeMap.rightOf(treeMap$Entry3)) && TreeMap.colorOf(TreeMap.leftOf(treeMap$Entry3))) {
                TreeMap.setColor(treeMap$Entry3, false);
                treeMap$Entry2 = TreeMap.parentOf(treeMap$Entry2);
                continue;
            }
            if (TreeMap.colorOf(TreeMap.leftOf(treeMap$Entry3))) {
                TreeMap.setColor(TreeMap.rightOf(treeMap$Entry3), true);
                TreeMap.setColor(treeMap$Entry3, false);
                this.rotateLeft(treeMap$Entry3);
                treeMap$Entry3 = TreeMap.leftOf(TreeMap.parentOf(treeMap$Entry2));
            }
            TreeMap.setColor(treeMap$Entry3, TreeMap.colorOf(TreeMap.parentOf(treeMap$Entry2)));
            TreeMap.setColor(TreeMap.parentOf(treeMap$Entry2), true);
            TreeMap.setColor(TreeMap.leftOf(treeMap$Entry3), true);
            this.rotateRight(TreeMap.parentOf(treeMap$Entry2));
            treeMap$Entry2 = this.root;
        }
        TreeMap.setColor(treeMap$Entry2, true);
        return this.root;
    }

    private TreeMap$Entry getMatchingEntry(Object object) {
        if (!(object instanceof Map$Entry)) {
            return null;
        }
        Map$Entry map$Entry = (Map$Entry)object;
        TreeMap$Entry treeMap$Entry = this.getEntry(map$Entry.getKey());
        return treeMap$Entry != null && TreeMap.eq(treeMap$Entry.getValue(), map$Entry.getValue()) ? treeMap$Entry : null;
    }

    private static boolean eq(Object object, Object object2) {
        return object == null ? object2 == null : object.equals(object2);
    }

    private static int compare(Object object, Object object2, Comparator comparator) {
        return comparator == null ? ((Comparable)object).compareTo(object2) : comparator.compare(object, object2);
    }

    @Override
    public Map$Entry lowerEntry(Object object) {
        TreeMap$Entry treeMap$Entry = this.getLowerEntry(object);
        return treeMap$Entry == null ? null : new AbstractMap$SimpleImmutableEntry(treeMap$Entry);
    }

    @Override
    public Object lowerKey(Object object) {
        TreeMap$Entry treeMap$Entry = this.getLowerEntry(object);
        return treeMap$Entry == null ? null : treeMap$Entry.getKey();
    }

    @Override
    public Map$Entry floorEntry(Object object) {
        TreeMap$Entry treeMap$Entry = this.getFloorEntry(object);
        return treeMap$Entry == null ? null : new AbstractMap$SimpleImmutableEntry(treeMap$Entry);
    }

    @Override
    public Object floorKey(Object object) {
        TreeMap$Entry treeMap$Entry = this.getFloorEntry(object);
        return treeMap$Entry == null ? null : TreeMap$Entry.access$400(treeMap$Entry);
    }

    @Override
    public Map$Entry ceilingEntry(Object object) {
        TreeMap$Entry treeMap$Entry = this.getCeilingEntry(object);
        return treeMap$Entry == null ? null : new AbstractMap$SimpleImmutableEntry(treeMap$Entry);
    }

    @Override
    public Object ceilingKey(Object object) {
        TreeMap$Entry treeMap$Entry = this.getCeilingEntry(object);
        return treeMap$Entry == null ? null : TreeMap$Entry.access$400(treeMap$Entry);
    }

    @Override
    public Map$Entry higherEntry(Object object) {
        TreeMap$Entry treeMap$Entry = this.getHigherEntry(object);
        return treeMap$Entry == null ? null : new AbstractMap$SimpleImmutableEntry(treeMap$Entry);
    }

    @Override
    public Object higherKey(Object object) {
        TreeMap$Entry treeMap$Entry = this.getHigherEntry(object);
        return treeMap$Entry == null ? null : TreeMap$Entry.access$400(treeMap$Entry);
    }

    @Override
    public Map$Entry firstEntry() {
        TreeMap$Entry treeMap$Entry = this.getFirstEntry();
        return treeMap$Entry == null ? null : new AbstractMap$SimpleImmutableEntry(treeMap$Entry);
    }

    @Override
    public Map$Entry lastEntry() {
        TreeMap$Entry treeMap$Entry = this.getLastEntry();
        return treeMap$Entry == null ? null : new AbstractMap$SimpleImmutableEntry(treeMap$Entry);
    }

    @Override
    public Map$Entry pollFirstEntry() {
        TreeMap$Entry treeMap$Entry = this.getFirstEntry();
        if (treeMap$Entry == null) {
            return null;
        }
        AbstractMap$SimpleImmutableEntry abstractMap$SimpleImmutableEntry = new AbstractMap$SimpleImmutableEntry(treeMap$Entry);
        this.delete(treeMap$Entry);
        return abstractMap$SimpleImmutableEntry;
    }

    @Override
    public Map$Entry pollLastEntry() {
        TreeMap$Entry treeMap$Entry = this.getLastEntry();
        if (treeMap$Entry == null) {
            return null;
        }
        AbstractMap$SimpleImmutableEntry abstractMap$SimpleImmutableEntry = new AbstractMap$SimpleImmutableEntry(treeMap$Entry);
        this.delete(treeMap$Entry);
        return abstractMap$SimpleImmutableEntry;
    }

    @Override
    public NavigableMap descendingMap() {
        NavigableMap navigableMap = this.descendingMap;
        if (navigableMap == null) {
            this.descendingMap = navigableMap = new TreeMap$DescendingSubMap(this, true, null, true, true, null, true);
        }
        return navigableMap;
    }

    @Override
    public NavigableSet descendingKeySet() {
        return this.descendingMap().navigableKeySet();
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
    public NavigableMap subMap(Object object, boolean bl, Object object2, boolean bl2) {
        return new TreeMap$AscendingSubMap(this, false, object, bl, false, object2, bl2);
    }

    @Override
    public NavigableMap headMap(Object object, boolean bl) {
        return new TreeMap$AscendingSubMap(this, true, null, true, false, object, bl);
    }

    @Override
    public NavigableMap tailMap(Object object, boolean bl) {
        return new TreeMap$AscendingSubMap(this, false, object, bl, true, null, true);
    }

    @Override
    public Comparator comparator() {
        return this.comparator;
    }

    final Comparator reverseComparator() {
        if (this.reverseComparator == null) {
            this.reverseComparator = Collections.reverseOrder(this.comparator);
        }
        return this.reverseComparator;
    }

    @Override
    public Object firstKey() {
        TreeMap$Entry treeMap$Entry = this.getFirstEntry();
        if (treeMap$Entry == null) {
            throw new NoSuchElementException();
        }
        return TreeMap$Entry.access$400(treeMap$Entry);
    }

    @Override
    public Object lastKey() {
        TreeMap$Entry treeMap$Entry = this.getLastEntry();
        if (treeMap$Entry == null) {
            throw new NoSuchElementException();
        }
        return TreeMap$Entry.access$400(treeMap$Entry);
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean containsValue(Object object) {
        if (this.root == null) {
            return false;
        }
        return object == null ? TreeMap.containsNull(this.root) : TreeMap.containsValue(this.root, object);
    }

    private static boolean containsNull(TreeMap$Entry treeMap$Entry) {
        if (TreeMap$Entry.access$600(treeMap$Entry) == null) {
            return true;
        }
        if (TreeMap$Entry.access$000(treeMap$Entry) != null && TreeMap.containsNull(TreeMap$Entry.access$000(treeMap$Entry))) {
            return true;
        }
        return TreeMap$Entry.access$200(treeMap$Entry) != null && TreeMap.containsNull(TreeMap$Entry.access$200(treeMap$Entry));
    }

    private static boolean containsValue(TreeMap$Entry treeMap$Entry, Object object) {
        if (object.equals(TreeMap$Entry.access$600(treeMap$Entry))) {
            return true;
        }
        if (TreeMap$Entry.access$000(treeMap$Entry) != null && TreeMap.containsValue(TreeMap$Entry.access$000(treeMap$Entry), object)) {
            return true;
        }
        return TreeMap$Entry.access$200(treeMap$Entry) != null && TreeMap.containsValue(TreeMap$Entry.access$200(treeMap$Entry), object);
    }

    @Override
    public Object remove(Object object) {
        TreeMap$Entry treeMap$Entry = this.getEntry(object);
        if (treeMap$Entry == null) {
            return null;
        }
        Object object2 = treeMap$Entry.getValue();
        this.delete(treeMap$Entry);
        return object2;
    }

    @Override
    public void putAll(Map map) {
        SortedMap sortedMap;
        if (map instanceof SortedMap && TreeMap.eq(this.comparator, (sortedMap = (SortedMap)map).comparator())) {
            this.buildFromSorted(sortedMap.entrySet().iterator(), map.size());
            return;
        }
        super.putAll(map);
    }

    @Override
    public Set keySet() {
        return this.navigableKeySet();
    }

    @Override
    public NavigableSet navigableKeySet() {
        if (this.navigableKeySet == null) {
            this.navigableKeySet = new TreeMap$AscendingKeySet(this);
        }
        return this.navigableKeySet;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.size);
        TreeMap$Entry treeMap$Entry = this.getFirstEntry();
        while (treeMap$Entry != null) {
            objectOutputStream.writeObject(TreeMap$Entry.access$400(treeMap$Entry));
            objectOutputStream.writeObject(TreeMap$Entry.access$600(treeMap$Entry));
            treeMap$Entry = TreeMap.successor(treeMap$Entry);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        int n = objectInputStream.readInt();
        try {
            this.buildFromSorted(new TreeMap$IOIterator(objectInputStream, n), n);
        }
        catch (TreeMap$IteratorIOException treeMap$IteratorIOException) {
            throw treeMap$IteratorIOException.getException();
        }
        catch (TreeMap$IteratorNoClassException treeMap$IteratorNoClassException) {
            throw treeMap$IteratorNoClassException.getException();
        }
    }

    static /* synthetic */ boolean access$300(Object object, Object object2) {
        return TreeMap.eq(object, object2);
    }

    static /* synthetic */ int access$700(TreeMap treeMap) {
        return treeMap.modCount;
    }

    static /* synthetic */ TreeMap$Entry access$800(TreeMap$Entry entry) {
        return TreeMap.successor(entry);
    }

    static /* synthetic */ TreeMap$Entry access$900(TreeMap$Entry entry) {
        return TreeMap.predecessor(entry);
    }

    static /* synthetic */ void access$1000(TreeMap treeMap, TreeMap$Entry entry) {
        treeMap.delete(entry);
    }

    static /* synthetic */ TreeMap$Entry access$1100(TreeMap treeMap) {
        return treeMap.getFirstEntry();
    }

    static /* synthetic */ TreeMap$Entry access$1200(TreeMap treeMap, Object object) {
        return treeMap.getMatchingEntry(object);
    }

    static /* synthetic */ TreeMap$Entry access$1300(TreeMap treeMap) {
        return treeMap.getLastEntry();
    }

    static /* synthetic */ TreeMap$Entry access$1400(TreeMap treeMap, Object object) {
        return treeMap.getEntry(object);
    }

    static /* synthetic */ Comparator access$1500(TreeMap treeMap) {
        return treeMap.comparator;
    }

    static /* synthetic */ int access$1600(Object object, Object object2, Comparator comparator) {
        return TreeMap.compare(object, object2, comparator);
    }

    static /* synthetic */ TreeMap$Entry access$1700(TreeMap treeMap, Object object) {
        return treeMap.getCeilingEntry(object);
    }

    static /* synthetic */ TreeMap$Entry access$1800(TreeMap treeMap, Object object) {
        return treeMap.getHigherEntry(object);
    }

    static /* synthetic */ TreeMap$Entry access$1900(TreeMap treeMap, Object object) {
        return treeMap.getFloorEntry(object);
    }

    static /* synthetic */ TreeMap$Entry access$2000(TreeMap treeMap, Object object) {
        return treeMap.getLowerEntry(object);
    }
}

