/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.chars;

import de.vw.mib.collections.chars.CharacterReadOnlyCollection;
import de.vw.mib.collections.chars.CharacterSet;

public class CharacterReadOnlySet
extends CharacterReadOnlyCollection
implements CharacterSet {
    public CharacterReadOnlySet(CharacterSet characterSet) {
        super(characterSet);
    }

    @Override
    public CharacterSet synchronize() {
        return new CharacterReadOnlySet(((CharacterSet)this.backing).synchronize());
    }

    @Override
    public char get(char c2) {
        return ((CharacterSet)this.backing).get(c2);
    }
}

