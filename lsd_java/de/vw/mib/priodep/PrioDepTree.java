/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.priodep;

import de.vw.mib.priodep.DependencyCycleException;
import de.vw.mib.priodep.DependencyNotAddedException;
import de.vw.mib.priodep.TreeSealingException;
import de.vw.mib.util.StringBuilder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;

public class PrioDepTree {
    public static final Object[] NO_DEPENDENCIES = new Object[0];
    private boolean sealed = false;
    private final Map prios = new HashMap();
    private final Map dependencies = new HashMap();
    private Object[] objects;
    private int length;
    private boolean hasToAddUpPrios = true;
    private int size;

    public void add(int n, Object object, Object[] objectArray) {
        this.mustNotBeSealed();
        this.mustNotBeAlreadyInTree(object);
        this.setPrio(object, n);
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            Object object2 = objectArray[i2];
            if (object2 == object) {
                throw new DependencyCycleException(object2.toString());
            }
            Set set = this.getDependingObjects(object2);
            set.add(object);
        }
    }

    public void dontAddUpPrios() {
        this.mustNotBeSealed();
        this.hasToAddUpPrios = false;
    }

    public synchronized void seal() {
        this.mustNotBeSealed();
        this.sealed = true;
        this.cleanUpDependencies();
        this.buildObjectArray();
        this.checkPriosOfAllObjects();
        this.dependencySort();
        if (this.hasToAddUpPrios) {
            this.addUpPrios();
        }
        this.prioritySort();
    }

    public synchronized boolean hasNext() {
        this.mustBeSealed();
        return this.size > 0;
    }

    public synchronized int size() {
        this.mustBeSealed();
        return this.size;
    }

    public synchronized Object[] next() {
        this.mustBeSealed();
        Object[] objectArray = new Object[this.length];
        System.arraycopy((Object)this.objects, 0, (Object)objectArray, 0, this.length);
        int n = this.removeDependants(objectArray);
        Object[] objectArray2 = new Object[n];
        int n2 = 0;
        for (int i2 = 0; i2 < this.length; ++i2) {
            if (null == objectArray[i2]) continue;
            objectArray2[n2] = objectArray[i2];
            ++n2;
        }
        return objectArray2;
    }

    private void cleanUpDependencies() {
        Set set = this.dependencies.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            if (this.prios.containsKey(map$Entry.getKey())) continue;
            iterator.remove();
        }
    }

    private int removeDependants(Object[] objectArray) {
        int n = this.length;
        for (int i2 = 0; i2 < this.length; ++i2) {
            if (null == this.objects[i2]) {
                --n;
                continue;
            }
            int n2 = 0;
            if (this.hasToAddUpPrios) {
                n2 = i2 + 1;
            }
            for (int i3 = n2; i3 < this.length; ++i3) {
                if (objectArray[i3] == null || !this.isDependendOn(i3, i2)) continue;
                objectArray[i3] = null;
                --n;
            }
        }
        return n;
    }

    private Object setPrio(Object object, int n) {
        if (n <= 0) {
            throw new IllegalArgumentException(new StringBuffer().append("prio must be positive, but is ").append(n).toString());
        }
        return this.prios.put(object, new Integer(n));
    }

    private void mustNotBeAlreadyInTree(Object object) {
        if (this.prios.containsKey(object)) {
            throw new IllegalArgumentException(new StringBuffer().append("Already in prio dependency tree: ").append(object).toString());
        }
        if (null == object) {
            throw new IllegalArgumentException("null object now allowed in tree.");
        }
    }

    private Set getDependingObjects(Object object) {
        Set set = (Set)this.dependencies.get(object);
        if (null == set) {
            set = new HashSet();
            this.dependencies.put(object, set);
        }
        return set;
    }

    private void mustNotBeSealed() {
        if (this.sealed) {
            throw new TreeSealingException("Tree must not be sealed for this operation.");
        }
    }

    private void mustBeSealed() {
        if (!this.sealed) {
            throw new TreeSealingException("Tree must be sealed for this operation.");
        }
    }

    private void buildObjectArray() {
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.dependencies.keySet());
        hashSet.addAll(this.prios.keySet());
        this.objects = hashSet.toArray();
        this.size = this.length = this.objects.length;
    }

    private void checkPriosOfAllObjects() {
        for (int i2 = this.length - 1; i2 >= 0; --i2) {
            if (this.prios.containsKey(this.objects[i2])) continue;
            throw new DependencyNotAddedException(this.objects[i2].toString());
        }
    }

    private void dependencySort() {
        int n = 0;
        int n2 = 0;
        while (n2 < this.length) {
            if (this.pushIfDependend(n2)) {
                ++n;
            } else {
                ++n2;
            }
            if (n <= this.length) continue;
            throw new DependencyCycleException();
        }
    }

    private boolean pushIfDependend(int n) {
        for (int i2 = this.length - 1; i2 > n; --i2) {
            if (!this.isDependendOn(n, i2)) continue;
            this.pushAfter(n, i2);
            return true;
        }
        return false;
    }

    private boolean isDependendOn(int n, int n2) {
        return this.getDependingObjects(this.objects[n2]).contains(this.objects[n]);
    }

    private void pushAfter(int n, int n2) {
        Object object = this.objects[n];
        for (int i2 = n; i2 < n2; ++i2) {
            this.objects[i2] = this.objects[i2 + 1];
        }
        this.objects[n2] = object;
    }

    private void prioritySort() {
        int n = 0;
        while (n < this.length) {
            if (this.pushIfLowerPrio(n)) continue;
            ++n;
        }
    }

    private boolean pushIfLowerPrio(int n) {
        for (int i2 = this.length - 1; i2 > n; --i2) {
            if (this.getPrio(n) >= this.getPrio(i2)) continue;
            this.pushAfter(n, i2);
            return true;
        }
        return false;
    }

    private int getPrio(int n) {
        return this.getPrio(this.objects[n]);
    }

    final int getPrio(Object object) {
        return (Integer)this.prios.get(object);
    }

    private void addUpPrios() {
        for (int i2 = this.length - 1; i2 >= 0; --i2) {
            Object object = this.objects[i2];
            int n = this.getPrio(object);
            Iterator iterator = this.getDependingObjects(object).iterator();
            while (iterator.hasNext()) {
                Object object2 = iterator.next();
                n += this.getPrio(object2);
            }
            this.setPrio(object, n);
        }
    }

    public synchronized void setReady(Object object) {
        this.mustBeSealed();
        if (!this.prios.containsKey(object)) {
            throw new IllegalArgumentException(new StringBuffer().append("Object ").append(object).append(" not in prio dependency tree.").toString());
        }
        for (int i2 = this.length - 1; i2 >= 0; --i2) {
            if (this.objects[i2] != object) continue;
            this.objects[i2] = null;
            --this.size;
            return;
        }
        throw new IllegalArgumentException(new StringBuffer().append("Object ").append(object).append(" already ready.").toString());
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        String string = "";
        if (this.sealed) {
            for (int i2 = 0; i2 < this.length; ++i2) {
                stringBuilder.append(string).append(this.objects[i2]).append("/").append(this.prios.get(this.objects[i2]));
                string = ", ";
            }
        } else {
            stringBuilder.append(this.prios).append(", ").append(this.dependencies);
        }
        return stringBuilder.append("]").toString();
    }
}

