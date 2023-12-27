/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.chars;

import de.vw.mib.collections.chars.CharacterCollection;
import de.vw.mib.collections.chars.CharacterIterator;
import de.vw.mib.collections.chars.CharacterReadOnlyIterator;

public class CharacterReadOnlyCollection
implements CharacterCollection {
    protected final CharacterCollection backing;

    public CharacterReadOnlyCollection(CharacterCollection characterCollection) {
        this.backing = characterCollection;
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
        return this.backing.contains(c2);
    }

    @Override
    public boolean isEmpty() {
        return this.backing.isEmpty();
    }

    @Override
    public CharacterIterator iterator() {
        return new CharacterReadOnlyIterator(this.backing.iterator());
    }

    @Override
    public boolean remove(char c2) {
        throw this.writeError();
    }

    @Override
    public int size() {
        return this.backing.size();
    }

    @Override
    public boolean addAll(CharacterCollection characterCollection) {
        throw this.writeError();
    }

    @Override
    public boolean containsAll(CharacterCollection characterCollection) {
        return this.backing.containsAll(characterCollection);
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
        return this.backing.toArray();
    }

    @Override
    public char[] toArray(char[] cArray) {
        return this.backing.toArray(cArray);
    }

    protected UnsupportedOperationException writeError() {
        return new UnsupportedOperationException("Read only view to a collection: operation not allowed.");
    }
}

