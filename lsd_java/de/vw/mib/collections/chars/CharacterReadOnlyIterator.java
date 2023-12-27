/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.chars;

import de.vw.mib.collections.chars.CharacterIterator;

public class CharacterReadOnlyIterator
implements CharacterIterator {
    private final CharacterIterator backing;

    public CharacterReadOnlyIterator(CharacterIterator characterIterator) {
        this.backing = characterIterator;
    }

    @Override
    public boolean hasNext() {
        return this.backing.hasNext();
    }

    @Override
    public char next() {
        return this.backing.next();
    }

    @Override
    public void remove() {
        throw this.writeError();
    }

    @Override
    public void reset() {
        this.backing.reset();
    }

    private UnsupportedOperationException writeError() {
        return new UnsupportedOperationException("Read only view to CharacterIterator: operation not allowed.");
    }
}

