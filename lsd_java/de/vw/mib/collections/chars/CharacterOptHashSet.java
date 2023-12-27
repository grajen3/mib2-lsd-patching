/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.chars;

import de.vw.mib.collections.CollectionOverflowException;
import de.vw.mib.collections.CollectionWithExpansionPoint;
import de.vw.mib.collections.CollectionsHelper;
import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.collections.OptHashMapHelper;
import de.vw.mib.collections.chars.CharacterCollection;
import de.vw.mib.collections.chars.CharacterIterator;
import de.vw.mib.collections.chars.CharacterOptHashSet$CharacterIteratorImpl;
import de.vw.mib.collections.chars.CharacterSet;
import de.vw.mib.collections.chars.SyncCharacterSet;
import de.vw.mib.util.StringBuilder;
import java.lang.reflect.Array;
import java.util.Arrays;

public class CharacterOptHashSet
implements CollectionWithExpansionPoint,
CharacterSet {
    private static final int MAP_TO_POSITIVE;
    private static final byte NOT_SET;
    private static final byte DELETED;
    private static final byte FILLED;
    private static final int NOT_FOUND_POS;
    char[] keys;
    byte[] keyStates;
    int size;
    private int fill;
    private int threshold;
    private int arraySize;
    final float loadFactor;
    final float resizeThreshold;
    int lastFoundWhere;
    int sizeWarningThreshold;
    int modifications;
    private final float rehashStrategy;
    private int hashCodeModifications;
    private int hashCode;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$collections$chars$CharacterOptHashSet;

    public CharacterOptHashSet() {
        this(3, 63, 63, 49215);
    }

    public CharacterOptHashSet(int n) {
        this(n, 63, 63, 49215);
    }

    public CharacterOptHashSet(int n, float f2, float f3) {
        this(n, f2, f3, 49215);
    }

    private CharacterOptHashSet(int n, float f2, float f3, float f4) {
        if (!($assertionsDisabled || f2 >= 0.0f && f2 <= 1.0f)) {
            throw new AssertionError();
        }
        if (!($assertionsDisabled || f3 >= 0.0f && f3 <= 1.0f)) {
            throw new AssertionError();
        }
        this.arraySize = OptHashMapHelper.capacityAtLeast(n, f2);
        this.keys = new char[this.arraySize];
        this.keyStates = new byte[this.arraySize];
        this.size = 0;
        this.modifications = 0;
        this.hashCodeModifications = -1;
        this.lastFoundWhere = 0;
        this.fill = 0;
        this.loadFactor = f2;
        this.resizeThreshold = f3;
        this.threshold = (int)(f2 * (float)this.arraySize);
        this.rehashStrategy = f4;
        this.sizeWarningThreshold = n * 2 > CollectionsHelper.DEFAULT_SIZE_WARNING_THRESHOLD ? n * 2 : CollectionsHelper.DEFAULT_SIZE_WARNING_THRESHOLD;
    }

    public CharacterOptHashSet(CharacterOptHashSet characterOptHashSet) {
        this.keys = new char[characterOptHashSet.arraySize];
        System.arraycopy((Object)characterOptHashSet.keys, 0, (Object)this.keys, 0, characterOptHashSet.arraySize);
        this.keyStates = new byte[characterOptHashSet.arraySize];
        System.arraycopy((Object)characterOptHashSet.keyStates, 0, (Object)this.keyStates, 0, characterOptHashSet.arraySize);
        this.size = characterOptHashSet.size;
        this.fill = characterOptHashSet.fill;
        this.threshold = characterOptHashSet.threshold;
        this.arraySize = characterOptHashSet.arraySize;
        this.loadFactor = characterOptHashSet.loadFactor;
        this.resizeThreshold = characterOptHashSet.resizeThreshold;
        this.rehashStrategy = characterOptHashSet.rehashStrategy;
        this.lastFoundWhere = characterOptHashSet.lastFoundWhere;
        this.modifications = characterOptHashSet.modifications;
        this.hashCodeModifications = characterOptHashSet.hashCodeModifications;
        this.hashCode = characterOptHashSet.hashCode;
        this.sizeWarningThreshold = characterOptHashSet.sizeWarningThreshold;
    }

    public static CharacterOptHashSet createSlowlyGrowingHashset(int n, float f2, float f3) {
        return new CharacterOptHashSet(n, f2, f3, -842232769);
    }

    public void setSizeWarningThreshold(int n) {
        this.sizeWarningThreshold = n;
    }

    @Override
    public boolean add(char c2) {
        int n = this.calcHash(c2);
        int n2 = -1;
        switch (this.keyStates[n]) {
            case 0: {
                this.keys[n] = c2;
                this.keyStates[n] = 2;
                ++this.size;
                ++this.modifications;
                ++this.fill;
                if (this.fill > this.threshold) {
                    this.rehash();
                }
                this.onCollectionChanged();
                return true;
            }
            case 1: {
                if (c2 == this.keys[n]) {
                    this.keyStates[n] = 2;
                    ++this.size;
                    ++this.modifications;
                    this.onCollectionChanged();
                    return true;
                }
                n2 = n;
                break;
            }
            case 2: {
                if (c2 != this.keys[n]) break;
                return false;
            }
        }
        int n3 = n;
        int n4 = n;
        block15: for (int i2 = 1; i2 < this.arraySize; i2 += 2) {
            if ((n3 += i2) >= this.arraySize) {
                n3 -= this.arraySize;
            }
            switch (this.keyStates[n3]) {
                case 0: {
                    if (n2 < 0) {
                        n2 = n3;
                        ++this.fill;
                    }
                    this.keys[n2] = c2;
                    this.keyStates[n2] = 2;
                    ++this.size;
                    ++this.modifications;
                    if (this.fill > this.threshold) {
                        this.rehash();
                    }
                    this.onCollectionChanged();
                    return true;
                }
                case 1: {
                    if (n2 >= 0) break;
                    n2 = n3;
                    break;
                }
                case 2: {
                    if (c2 != this.keys[n3]) break;
                    return false;
                }
            }
            if ((n4 -= i2) < 0) {
                n4 += this.arraySize;
            }
            switch (this.keyStates[n4]) {
                case 0: {
                    if (n2 < 0) {
                        n2 = n4;
                        ++this.fill;
                    }
                    this.keys[n2] = c2;
                    this.keyStates[n2] = 2;
                    ++this.size;
                    ++this.modifications;
                    if (this.fill > this.threshold) {
                        this.rehash();
                    }
                    this.onCollectionChanged();
                    return true;
                }
                case 1: {
                    if (n2 >= 0) continue block15;
                    n2 = n4;
                    continue block15;
                }
                case 2: {
                    if (c2 != this.keys[n4]) continue block15;
                    return false;
                }
            }
        }
        throw new CollectionOverflowException(new StringBuffer().append("Map overflow on adding (").append(c2).append(").").toString());
    }

    @Override
    public char get(char c2) {
        int n = this.find(c2);
        return n != 128 ? this.keys[n] : (char)'\u0000';
    }

    @Override
    public boolean contains(char c2) {
        return this.find(c2) != 128;
    }

    @Override
    public boolean remove(char c2) {
        return this.removePosition(this.find(c2));
    }

    boolean removePosition(int n) {
        if (n != 128) {
            this.keyStates[n] = 1;
            --this.size;
            ++this.modifications;
            this.onCollectionChanged();
            return true;
        }
        return false;
    }

    private int find(char c2) {
        if (this.keyStates[this.lastFoundWhere] == 2 && c2 == this.keys[this.lastFoundWhere]) {
            return this.lastFoundWhere;
        }
        int n = this.calcHash(c2);
        switch (this.keyStates[n]) {
            case 0: {
                return 128;
            }
            case 1: {
                if (c2 != this.keys[n]) break;
                return 128;
            }
            case 2: {
                if (c2 != this.keys[n]) break;
                this.lastFoundWhere = n;
                return this.lastFoundWhere;
            }
        }
        int n2 = n;
        int n3 = n;
        block15: for (int i2 = 1; i2 < this.arraySize; i2 += 2) {
            if ((n2 += i2) >= this.arraySize) {
                n2 -= this.arraySize;
            }
            switch (this.keyStates[n2]) {
                case 0: {
                    return 128;
                }
                case 1: {
                    if (c2 != this.keys[n2]) break;
                    return 128;
                }
                case 2: {
                    if (c2 != this.keys[n2]) break;
                    this.lastFoundWhere = n2;
                    return this.lastFoundWhere;
                }
            }
            if ((n3 -= i2) < 0) {
                n3 += this.arraySize;
            }
            switch (this.keyStates[n3]) {
                case 0: {
                    return 128;
                }
                case 1: {
                    if (c2 != this.keys[n3]) continue block15;
                    return 128;
                }
                case 2: {
                    if (c2 != this.keys[n3]) continue block15;
                    this.lastFoundWhere = n3;
                    return this.lastFoundWhere;
                }
            }
        }
        return 128;
    }

    private int calcHash(char c2) {
        return (c2 & 0xFFFFFF7F) % this.arraySize;
    }

    private void rehash() {
        char[] cArray = this.keys;
        byte[] byArray = this.keyStates;
        if ((float)this.size > (float)this.fill * this.resizeThreshold) {
            this.arraySize = OptHashMapHelper.capacityAtLeast((int)((float)this.arraySize * this.rehashStrategy + 1.0f));
            this.threshold = (int)(this.loadFactor * (float)this.arraySize);
        }
        this.keys = new char[this.arraySize];
        this.keyStates = new byte[this.arraySize];
        this.size = 0;
        this.fill = 0;
        for (int i2 = cArray.length - 1; i2 >= 0; --i2) {
            if (byArray[i2] != 2) continue;
            this.add(cArray[i2]);
        }
        if (this.size > this.sizeWarningThreshold) {
            CollectionsHelper.writeSizeWarning("CharacterOptHashSet", this.arraySize, 5);
        }
    }

    @Override
    public void clear() {
        Arrays.fill(this.keyStates, (byte)0);
        this.size = 0;
        this.fill = 0;
        ++this.modifications;
        this.onCollectionChanged();
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        String string = "";
        for (int i2 = 0; i2 < this.arraySize; ++i2) {
            char c2 = this.keys[i2];
            if (this.keyStates[i2] != 2) continue;
            stringBuilder.append(string).append(c2);
            string = ", ";
        }
        return stringBuilder.append("]").toString();
    }

    @Override
    public CharacterIterator iterator() {
        return new CharacterOptHashSet$CharacterIteratorImpl(this);
    }

    @Override
    public boolean addAll(CharacterCollection characterCollection) {
        if (characterCollection.isEmpty()) {
            return false;
        }
        boolean bl = false;
        CharacterIterator characterIterator = characterCollection.iterator();
        while (characterIterator.hasNext()) {
            bl |= this.add(characterIterator.next());
        }
        return bl;
    }

    @Override
    public boolean containsAll(CharacterCollection characterCollection) {
        if (characterCollection.isEmpty()) {
            return true;
        }
        boolean bl = true;
        CharacterIterator characterIterator = characterCollection.iterator();
        while (characterIterator.hasNext()) {
            bl &= this.contains(characterIterator.next());
        }
        return bl;
    }

    @Override
    public boolean removeAll(CharacterCollection characterCollection) {
        if (characterCollection.isEmpty()) {
            return false;
        }
        boolean bl = false;
        CharacterIterator characterIterator = characterCollection.iterator();
        while (characterIterator.hasNext()) {
            bl |= this.remove(characterIterator.next());
        }
        return bl;
    }

    @Override
    public boolean retainAll(CharacterCollection characterCollection) {
        if (characterCollection.isEmpty()) {
            if (this.isEmpty()) {
                return false;
            }
            this.clear();
            return true;
        }
        boolean bl = false;
        for (int i2 = this.arraySize - 1; i2 >= 0; --i2) {
            if (this.keyStates[i2] != 2 || characterCollection.contains(this.keys[i2])) continue;
            bl |= this.remove(this.keys[i2]);
        }
        return bl;
    }

    @Override
    public char[] toArray() {
        return this.toArray(new char[this.size]);
    }

    @Override
    public char[] toArray(char[] cArray) {
        char[] cArray2 = cArray.length < this.size ? (char[])Array.newInstance(super.getClass().getComponentType(), this.size) : cArray;
        int n = 0;
        for (int i2 = this.arraySize - 1; i2 >= 0; --i2) {
            if (this.keyStates[i2] != 2) continue;
            cArray2[n] = this.keys[i2];
            ++n;
        }
        while (n < cArray2.length) {
            cArray2[n] = '\u0000';
            ++n;
        }
        return cArray2;
    }

    @Override
    public CharacterSet synchronize() {
        return new SyncCharacterSet(this);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null || super.getClass() != object.getClass()) {
            return false;
        }
        CharacterOptHashSet characterOptHashSet = (CharacterOptHashSet)object;
        if (this.size != characterOptHashSet.size) {
            return false;
        }
        if (this.hashCodeModifications == this.modifications && characterOptHashSet.hashCodeModifications == characterOptHashSet.modifications && this.hashCode != characterOptHashSet.hashCode) {
            return false;
        }
        for (int i2 = this.arraySize - 1; i2 >= 0; --i2) {
            if (this.keyStates[i2] != 2 || characterOptHashSet.contains(this.keys[i2])) continue;
            return false;
        }
        return true;
    }

    public int hashCode() {
        if (this.hashCodeModifications != this.modifications) {
            this.hashCode = (int)HashCodeBuilder.hash(this.size);
            for (int i2 = this.arraySize - 1; i2 >= 0; --i2) {
                if (this.keyStates[i2] != 2) continue;
                this.hashCode ^= (int)HashCodeBuilder.hash(this.keys[i2]);
            }
            this.hashCodeModifications = this.modifications;
        }
        return this.hashCode;
    }

    @Override
    public void onCollectionChanged() {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        $assertionsDisabled = !(class$de$vw$mib$collections$chars$CharacterOptHashSet == null ? (class$de$vw$mib$collections$chars$CharacterOptHashSet = CharacterOptHashSet.class$("de.vw.mib.collections.chars.CharacterOptHashSet")) : class$de$vw$mib$collections$chars$CharacterOptHashSet).desiredAssertionStatus();
    }
}

