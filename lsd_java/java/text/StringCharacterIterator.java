/*
 * Decompiled with CFR 0.152.
 */
package java.text;

import java.text.CharacterIterator;

public final class StringCharacterIterator
implements CharacterIterator {
    String string;
    int start;
    int end;
    int offset;

    public StringCharacterIterator(String string) {
        this.string = string;
        this.offset = 0;
        this.start = 0;
        this.end = this.string.length();
    }

    public StringCharacterIterator(String string, int n) {
        this.string = string;
        this.start = 0;
        this.end = this.string.length();
        if (n < 0 || n > this.end) {
            throw new IllegalArgumentException();
        }
        this.offset = n;
    }

    public StringCharacterIterator(String string, int n, int n2, int n3) {
        this.string = string;
        if (n < 0 || n2 > this.string.length() || n > n2 || n3 < n || n3 > n2) {
            throw new IllegalArgumentException();
        }
        this.start = n;
        this.end = n2;
        this.offset = n3;
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            return null;
        }
    }

    @Override
    public char current() {
        if (this.offset == this.end) {
            return '\uffff0000';
        }
        return this.string.charAt(this.offset);
    }

    public boolean equals(Object object) {
        if (!(object instanceof StringCharacterIterator)) {
            return false;
        }
        StringCharacterIterator stringCharacterIterator = (StringCharacterIterator)object;
        return this.string.equals(stringCharacterIterator.string) && this.start == stringCharacterIterator.start && this.end == stringCharacterIterator.end && this.offset == stringCharacterIterator.offset;
    }

    @Override
    public char first() {
        if (this.start == this.end) {
            return '\uffff0000';
        }
        this.offset = this.start;
        return this.string.charAt(this.offset);
    }

    @Override
    public int getBeginIndex() {
        return this.start;
    }

    @Override
    public int getEndIndex() {
        return this.end;
    }

    @Override
    public int getIndex() {
        return this.offset;
    }

    public int hashCode() {
        return this.string.hashCode() + this.start + this.end + this.offset;
    }

    @Override
    public char last() {
        if (this.start == this.end) {
            return '\uffff0000';
        }
        this.offset = this.end - 1;
        return this.string.charAt(this.offset);
    }

    @Override
    public char next() {
        if (this.offset >= this.end - 1) {
            this.offset = this.end;
            return '\uffff0000';
        }
        return this.string.charAt(++this.offset);
    }

    @Override
    public char previous() {
        if (this.offset == this.start) {
            return '\uffff0000';
        }
        return this.string.charAt(--this.offset);
    }

    @Override
    public char setIndex(int n) {
        if (n < this.start || n > this.end) {
            throw new IllegalArgumentException();
        }
        this.offset = n;
        if (this.offset == this.end) {
            return '\uffff0000';
        }
        return this.string.charAt(this.offset);
    }

    public void setText(String string) {
        this.string = string;
        this.offset = 0;
        this.start = 0;
        this.end = string.length();
    }
}

