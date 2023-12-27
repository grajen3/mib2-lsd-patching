/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.chars;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.collections.chars.CharacterArrayList;
import de.vw.mib.collections.chars.CharacterCollection;
import de.vw.mib.collections.chars.CharacterIterator;
import de.vw.mib.collections.chars.CharacterReadOnlyIterator;

public class CharacterReadOnlyArrayList
implements CharacterCollection {
    public static final CharacterCollection EMPTY = new CharacterReadOnlyArrayList();
    private final CharacterArrayList backingList;

    public CharacterReadOnlyArrayList(CharacterArrayList characterArrayList) {
        this.backingList = characterArrayList;
    }

    private CharacterReadOnlyArrayList() {
        this.backingList = new CharacterArrayList(0);
    }

    @Override
    public boolean add(char c2) {
        throw this.writeError();
    }

    @Override
    public void clear() {
        throw this.writeError();
    }

    @Override
    public boolean contains(char c2) {
        return this.backingList.contains(c2);
    }

    @Override
    public boolean isEmpty() {
        return this.backingList.isEmpty();
    }

    @Override
    public CharacterIterator iterator() {
        return new CharacterReadOnlyIterator(this.backingList.iterator());
    }

    @Override
    public boolean remove(char c2) {
        throw this.writeError();
    }

    @Override
    public int size() {
        return this.backingList.size();
    }

    @Override
    public boolean addAll(CharacterCollection characterCollection) {
        throw this.writeError();
    }

    @Override
    public boolean containsAll(CharacterCollection characterCollection) {
        return this.backingList.containsAll(characterCollection);
    }

    @Override
    public boolean removeAll(CharacterCollection characterCollection) {
        throw this.writeError();
    }

    @Override
    public boolean retainAll(CharacterCollection characterCollection) {
        throw this.writeError();
    }

    @Override
    public char[] toArray() {
        return this.backingList.toArray();
    }

    @Override
    public char[] toArray(char[] cArray) {
        return this.backingList.toArray(cArray);
    }

    private RuntimeException writeError() {
        return new UnsupportedOperationException(new StringBuffer().append("No write to ").append(super.getClass()).append(" allowed.").toString());
    }

    public String toString() {
        return this.backingList.toString();
    }

    public int hashCode() {
        return (int)HashCodeBuilder.hash(this.backingList);
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
        CharacterReadOnlyArrayList characterReadOnlyArrayList = (CharacterReadOnlyArrayList)object;
        return !(this.backingList == null ? characterReadOnlyArrayList.backingList != null : !this.backingList.equals(characterReadOnlyArrayList.backingList));
    }
}

