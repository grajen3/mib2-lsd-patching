/*
 * Decompiled with CFR 0.152.
 */
package java.text;

import com.ibm.oti.util.Msg;
import java.text.CharacterIterator;

final class RuleBasedBreakIterator$SafeCharIterator
implements CharacterIterator,
Cloneable {
    private CharacterIterator base;
    private int rangeStart;
    private int rangeLimit;
    private int currentIndex;

    RuleBasedBreakIterator$SafeCharIterator(CharacterIterator characterIterator) {
        this.base = characterIterator;
        this.rangeStart = characterIterator.getBeginIndex();
        this.rangeLimit = characterIterator.getEndIndex();
        this.currentIndex = characterIterator.getIndex();
    }

    @Override
    public char first() {
        return this.setIndex(this.rangeStart);
    }

    @Override
    public char last() {
        return this.setIndex(this.rangeLimit - 1);
    }

    @Override
    public char current() {
        if (this.currentIndex < this.rangeStart || this.currentIndex >= this.rangeLimit) {
            return '\uffff0000';
        }
        return this.base.setIndex(this.currentIndex);
    }

    @Override
    public char next() {
        ++this.currentIndex;
        if (this.currentIndex >= this.rangeLimit) {
            this.currentIndex = this.rangeLimit;
            return '\uffff0000';
        }
        return this.base.setIndex(this.currentIndex);
    }

    @Override
    public char previous() {
        --this.currentIndex;
        if (this.currentIndex < this.rangeStart) {
            this.currentIndex = this.rangeStart;
            return '\uffff0000';
        }
        return this.base.setIndex(this.currentIndex);
    }

    @Override
    public char setIndex(int n) {
        if (n < this.rangeStart || n > this.rangeLimit) {
            throw new IllegalArgumentException(Msg.getString("K0022"));
        }
        this.currentIndex = n;
        return this.current();
    }

    @Override
    public int getBeginIndex() {
        return this.rangeStart;
    }

    @Override
    public int getEndIndex() {
        return this.rangeLimit;
    }

    @Override
    public int getIndex() {
        return this.currentIndex;
    }

    @Override
    public Object clone() {
        CharacterIterator characterIterator;
        RuleBasedBreakIterator$SafeCharIterator ruleBasedBreakIterator$SafeCharIterator = null;
        try {
            ruleBasedBreakIterator$SafeCharIterator = (RuleBasedBreakIterator$SafeCharIterator)super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new Error(Msg.getString("K0023", cloneNotSupportedException));
        }
        ruleBasedBreakIterator$SafeCharIterator.base = characterIterator = (CharacterIterator)this.base.clone();
        return ruleBasedBreakIterator$SafeCharIterator;
    }
}

