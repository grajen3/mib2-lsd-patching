/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.chars;

import de.vw.mib.collections.chars.CharacterCollection;
import de.vw.mib.collections.chars.CharacterIterator;
import de.vw.mib.collections.chars.CharacterSet;

public class SyncCharacterSet
implements CharacterSet {
    private final Object mutex;
    private final CharacterSet set;

    public SyncCharacterSet(CharacterSet characterSet) {
        this.set = characterSet;
        this.mutex = this;
    }

    public SyncCharacterSet(CharacterSet characterSet, Object object) {
        this.set = characterSet;
        this.mutex = object;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean add(char c2) {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.add(c2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean contains(char c2) {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.contains(c2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public char get(char c2) {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.get(c2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean remove(char c2) {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.remove(c2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void clear() {
        Object object = this.mutex;
        synchronized (object) {
            this.set.clear();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean isEmpty() {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.isEmpty();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int size() {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.size();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String toString() {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.toString();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public CharacterIterator iterator() {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.iterator();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean addAll(CharacterCollection characterCollection) {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.addAll(characterCollection);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean containsAll(CharacterCollection characterCollection) {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.containsAll(characterCollection);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean removeAll(CharacterCollection characterCollection) {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.removeAll(characterCollection);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean retainAll(CharacterCollection characterCollection) {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.retainAll(characterCollection);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public char[] toArray() {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.toArray();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public char[] toArray(char[] cArray) {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.toArray(cArray);
        }
    }

    @Override
    public CharacterSet synchronize() {
        return this;
    }
}

