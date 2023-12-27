/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.chars;

import de.vw.mib.collections.chars.CharacterIterator;
import de.vw.mib.collections.chars.CharacterOptHashSet;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

final class CharacterOptHashSet$CharacterIteratorImpl
implements CharacterIterator {
    int where;
    int which;
    int expectedWrites;
    private final /* synthetic */ CharacterOptHashSet this$0;

    public CharacterOptHashSet$CharacterIteratorImpl(CharacterOptHashSet characterOptHashSet) {
        this.this$0 = characterOptHashSet;
        this.reset();
    }

    @Override
    public void reset() {
        this.where = -1;
        this.which = 0;
        this.expectedWrites = this.this$0.modifications;
        this.this$0.onCollectionChanged();
    }

    @Override
    public boolean hasNext() {
        this.checkModifications();
        return this.which < this.this$0.size;
    }

    private void checkModifications() {
        if (this.this$0.modifications != this.expectedWrites) {
            throw new ConcurrentModificationException();
        }
    }

    @Override
    public char next() {
        byte by;
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        do {
            ++this.where;
        } while ((by = this.this$0.keyStates[this.where]) != 2);
        ++this.which;
        this.this$0.lastFoundWhere = this.where;
        return this.this$0.keys[this.where];
    }

    @Override
    public void remove() {
        this.checkModifications();
        if (this.where < 0 || this.this$0.keyStates[this.where] == 1) {
            throw new IllegalStateException();
        }
        this.this$0.removePosition(this.where);
        --this.which;
        ++this.expectedWrites;
    }
}

