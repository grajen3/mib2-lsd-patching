/*
 * Decompiled with CFR 0.152.
 */
package java.text;

import java.io.InputStream;
import java.text.BreakDictionary;
import java.text.CharacterIterator;
import java.text.DictionaryBasedBreakIterator$Builder;
import java.text.RuleBasedBreakIterator;
import java.text.RuleBasedBreakIterator$Builder;
import java.util.Stack;
import java.util.Vector;

class DictionaryBasedBreakIterator
extends RuleBasedBreakIterator {
    private BreakDictionary dictionary;
    private boolean[] categoryFlags;
    private int dictionaryCharCount;
    private int[] cachedBreakPositions;
    private int positionInCache;

    public DictionaryBasedBreakIterator(String string, InputStream inputStream) {
        super(string);
        this.dictionary = new BreakDictionary(inputStream);
    }

    @Override
    protected RuleBasedBreakIterator$Builder makeBuilder() {
        return new DictionaryBasedBreakIterator$Builder(this);
    }

    @Override
    public void setText(CharacterIterator characterIterator) {
        super.setText(characterIterator);
        this.cachedBreakPositions = null;
        this.dictionaryCharCount = 0;
        this.positionInCache = 0;
    }

    @Override
    public int first() {
        this.cachedBreakPositions = null;
        this.dictionaryCharCount = 0;
        this.positionInCache = 0;
        return super.first();
    }

    @Override
    public int last() {
        this.cachedBreakPositions = null;
        this.dictionaryCharCount = 0;
        this.positionInCache = 0;
        return super.last();
    }

    @Override
    public int previous() {
        CharacterIterator characterIterator = this.getText();
        if (this.cachedBreakPositions != null && this.positionInCache > 0) {
            --this.positionInCache;
            characterIterator.setIndex(this.cachedBreakPositions[this.positionInCache]);
            return this.cachedBreakPositions[this.positionInCache];
        }
        this.cachedBreakPositions = null;
        int n = super.previous();
        if (this.cachedBreakPositions != null) {
            this.positionInCache = this.cachedBreakPositions.length - 2;
        }
        return n;
    }

    @Override
    public int preceding(int n) {
        CharacterIterator characterIterator = this.getText();
        DictionaryBasedBreakIterator.checkOffset(n, characterIterator);
        if (this.cachedBreakPositions == null || n <= this.cachedBreakPositions[0] || n > this.cachedBreakPositions[this.cachedBreakPositions.length - 1]) {
            this.cachedBreakPositions = null;
            return super.preceding(n);
        }
        this.positionInCache = 0;
        while (this.positionInCache < this.cachedBreakPositions.length && n > this.cachedBreakPositions[this.positionInCache]) {
            ++this.positionInCache;
        }
        --this.positionInCache;
        characterIterator.setIndex(this.cachedBreakPositions[this.positionInCache]);
        return characterIterator.getIndex();
    }

    @Override
    public int following(int n) {
        CharacterIterator characterIterator = this.getText();
        DictionaryBasedBreakIterator.checkOffset(n, characterIterator);
        if (this.cachedBreakPositions == null || n < this.cachedBreakPositions[0] || n >= this.cachedBreakPositions[this.cachedBreakPositions.length - 1]) {
            this.cachedBreakPositions = null;
            return super.following(n);
        }
        this.positionInCache = 0;
        while (this.positionInCache < this.cachedBreakPositions.length && n >= this.cachedBreakPositions[this.positionInCache]) {
            ++this.positionInCache;
        }
        characterIterator.setIndex(this.cachedBreakPositions[this.positionInCache]);
        return characterIterator.getIndex();
    }

    @Override
    protected int handleNext() {
        CharacterIterator characterIterator = this.getText();
        if (this.cachedBreakPositions == null || this.positionInCache == this.cachedBreakPositions.length - 1) {
            int n = characterIterator.getIndex();
            this.dictionaryCharCount = 0;
            int n2 = super.handleNext();
            if (this.dictionaryCharCount > 1 && n2 - n > 1) {
                this.divideUpDictionaryRange(n, n2);
            } else {
                this.cachedBreakPositions = null;
                return n2;
            }
        }
        if (this.cachedBreakPositions != null) {
            ++this.positionInCache;
            characterIterator.setIndex(this.cachedBreakPositions[this.positionInCache]);
            return this.cachedBreakPositions[this.positionInCache];
        }
        return -9999;
    }

    @Override
    protected int lookupCategory(char c2) {
        int n = super.lookupCategory(c2);
        if (n != -1 && this.categoryFlags[n]) {
            ++this.dictionaryCharCount;
        }
        return n;
    }

    private void divideUpDictionaryRange(int n, int n2) {
        CharacterIterator characterIterator = this.getText();
        characterIterator.setIndex(n);
        char c2 = characterIterator.current();
        int n3 = this.lookupCategory(c2);
        while (n3 == -1 || !this.categoryFlags[n3]) {
            c2 = characterIterator.next();
            n3 = this.lookupCategory(c2);
        }
        Stack stack = new Stack();
        Stack stack2 = new Stack();
        Vector vector = new Vector();
        int n4 = 0;
        int n5 = characterIterator.getIndex();
        Stack stack3 = null;
        c2 = characterIterator.current();
        while (true) {
            if (this.dictionary.at(n4, 0) == -1) {
                stack2.push(new Integer(characterIterator.getIndex()));
            }
            if ((n4 = (int)this.dictionary.at(n4, c2)) == -1) {
                stack.push(new Integer(characterIterator.getIndex()));
                break;
            }
            if (n4 == 0 || characterIterator.getIndex() >= n2) {
                if (characterIterator.getIndex() > n5) {
                    n5 = characterIterator.getIndex();
                    stack3 = (Stack)stack.clone();
                }
                while (!stack2.isEmpty() && vector.contains(stack2.peek())) {
                    stack2.pop();
                }
                if (stack2.isEmpty()) {
                    if (stack3 != null) {
                        stack = stack3;
                        if (n5 >= n2) break;
                        characterIterator.setIndex(n5 + 1);
                    } else {
                        if ((stack.size() == 0 || ((Integer)stack.peek()).intValue() != characterIterator.getIndex()) && characterIterator.getIndex() != n) {
                            stack.push(new Integer(characterIterator.getIndex()));
                        }
                        characterIterator.next();
                        stack.push(new Integer(characterIterator.getIndex()));
                    }
                } else {
                    Integer n6 = (Integer)stack2.pop();
                    Object object = null;
                    while (!stack.isEmpty() && n6 < (Integer)stack.peek()) {
                        object = stack.pop();
                        vector.addElement(object);
                    }
                    stack.push(n6);
                    characterIterator.setIndex((Integer)stack.peek());
                }
                c2 = characterIterator.current();
                if (characterIterator.getIndex() < n2) continue;
                break;
            }
            c2 = characterIterator.next();
        }
        if (!stack.isEmpty()) {
            stack.pop();
        }
        stack.push(new Integer(n2));
        this.cachedBreakPositions = new int[stack.size() + 1];
        this.cachedBreakPositions[0] = n;
        int n7 = 0;
        while (n7 < stack.size()) {
            this.cachedBreakPositions[n7 + 1] = (Integer)stack.elementAt(n7);
            ++n7;
        }
        this.positionInCache = 0;
    }

    static /* synthetic */ void access$0(DictionaryBasedBreakIterator dictionaryBasedBreakIterator, boolean[] blArray) {
        dictionaryBasedBreakIterator.categoryFlags = blArray;
    }

    static /* synthetic */ boolean[] access$1(DictionaryBasedBreakIterator dictionaryBasedBreakIterator) {
        return dictionaryBasedBreakIterator.categoryFlags;
    }
}

