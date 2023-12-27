/*
 * Decompiled with CFR 0.152.
 */
package java.text;

import java.text.Annotation;
import java.text.AttributedCharacterIterator;
import java.text.AttributedCharacterIterator$Attribute;
import java.text.AttributedString;
import java.text.AttributedString$Range;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;

class AttributedString$AttributedIterator
implements AttributedCharacterIterator {
    private int begin;
    private int end;
    private int offset;
    private AttributedString attrString;
    private HashSet attributesAllowed;
    private static Object marker = new Object();

    AttributedString$AttributedIterator(AttributedString attributedString) {
        this.attrString = attributedString;
        this.begin = 0;
        this.end = attributedString.text.length();
        this.offset = 0;
    }

    AttributedString$AttributedIterator(AttributedString attributedString, AttributedCharacterIterator$Attribute[] attributedCharacterIterator$AttributeArray, int n, int n2) {
        if (n < 0 || n2 > attributedString.text.length() || n > n2) {
            throw new IllegalArgumentException();
        }
        this.begin = n;
        this.end = n2;
        this.offset = n;
        this.attrString = attributedString;
        if (attributedCharacterIterator$AttributeArray != null) {
            HashSet hashSet = new HashSet(attributedCharacterIterator$AttributeArray.length * 4 / 3 + 1);
            int n3 = attributedCharacterIterator$AttributeArray.length;
            while (--n3 >= 0) {
                hashSet.add(attributedCharacterIterator$AttributeArray[n3]);
            }
            this.attributesAllowed = hashSet;
        }
    }

    @Override
    public Object clone() {
        try {
            AttributedString$AttributedIterator attributedString$AttributedIterator = (AttributedString$AttributedIterator)super.clone();
            if (this.attributesAllowed != null) {
                attributedString$AttributedIterator.attributesAllowed = (HashSet)this.attributesAllowed.clone();
            }
            return attributedString$AttributedIterator;
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
        return this.attrString.text.charAt(this.offset);
    }

    @Override
    public char first() {
        if (this.begin == this.end) {
            return '\uffff0000';
        }
        this.offset = this.begin;
        return this.attrString.text.charAt(this.offset);
    }

    @Override
    public int getBeginIndex() {
        return this.begin;
    }

    @Override
    public int getEndIndex() {
        return this.end;
    }

    @Override
    public int getIndex() {
        return this.offset;
    }

    private boolean inRange(AttributedString$Range attributedString$Range) {
        if (!(attributedString$Range.value instanceof Annotation)) {
            return true;
        }
        return attributedString$Range.start >= this.begin && attributedString$Range.start < this.end && attributedString$Range.end > this.begin && attributedString$Range.end <= this.end;
    }

    private boolean inRange(ArrayList arrayList) {
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            AttributedString$Range attributedString$Range = (AttributedString$Range)iterator.next();
            if (attributedString$Range.start >= this.begin && attributedString$Range.start < this.end) {
                return !(attributedString$Range.value instanceof Annotation) || attributedString$Range.end > this.begin && attributedString$Range.end <= this.end;
            }
            if (attributedString$Range.end <= this.begin || attributedString$Range.end > this.end) continue;
            return !(attributedString$Range.value instanceof Annotation) || attributedString$Range.start >= this.begin && attributedString$Range.start < this.end;
        }
        return false;
    }

    @Override
    public Set getAllAttributeKeys() {
        if (this.begin == 0 && this.end == this.attrString.text.length() && this.attributesAllowed == null) {
            return this.attrString.attributeMap.keySet();
        }
        HashSet hashSet = new HashSet(this.attrString.attributeMap.size() * 4 / 3 + 1);
        Iterator iterator = this.attrString.attributeMap.entrySet().iterator();
        while (iterator.hasNext()) {
            ArrayList arrayList;
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            if (this.attributesAllowed != null && !this.attributesAllowed.contains(map$Entry.getKey()) || !this.inRange(arrayList = (ArrayList)map$Entry.getValue())) continue;
            hashSet.add(map$Entry.getKey());
        }
        return hashSet;
    }

    private Object currentValue(ArrayList arrayList, boolean bl) {
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            AttributedString$Range attributedString$Range = (AttributedString$Range)iterator.next();
            if (this.offset < attributedString$Range.start || this.offset >= attributedString$Range.end) continue;
            return this.inRange(attributedString$Range) ? attributedString$Range.value : (bl ? marker : null);
        }
        return bl ? marker : null;
    }

    @Override
    public Object getAttribute(AttributedCharacterIterator$Attribute attributedCharacterIterator$Attribute) {
        if (this.attributesAllowed != null && !this.attributesAllowed.contains(attributedCharacterIterator$Attribute)) {
            return null;
        }
        ArrayList arrayList = (ArrayList)this.attrString.attributeMap.get(attributedCharacterIterator$Attribute);
        if (arrayList == null) {
            return null;
        }
        return this.currentValue(arrayList, false);
    }

    @Override
    public Map getAttributes() {
        HashMap hashMap = new HashMap(this.attrString.attributeMap.size() * 4 / 3 + 1);
        Iterator iterator = this.attrString.attributeMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Object object;
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            if (this.attributesAllowed != null && !this.attributesAllowed.contains(map$Entry.getKey()) || (object = this.currentValue((ArrayList)map$Entry.getValue(), true)) == marker) continue;
            hashMap.put(map$Entry.getKey(), object);
        }
        return hashMap;
    }

    @Override
    public int getRunLimit() {
        return this.getRunLimit(this.getAllAttributeKeys());
    }

    private int runLimit(ArrayList arrayList) {
        int n = this.end;
        ListIterator listIterator = arrayList.listIterator(arrayList.size());
        while (listIterator.hasPrevious()) {
            AttributedString$Range attributedString$Range = (AttributedString$Range)listIterator.previous();
            if (attributedString$Range.value == null) continue;
            if (attributedString$Range.end <= this.begin) break;
            if (this.offset >= attributedString$Range.start && this.offset < attributedString$Range.end) {
                return this.inRange(attributedString$Range) ? attributedString$Range.end : n;
            }
            if (this.offset >= attributedString$Range.end) break;
            n = attributedString$Range.start;
        }
        return n;
    }

    @Override
    public int getRunLimit(AttributedCharacterIterator$Attribute attributedCharacterIterator$Attribute) {
        if (this.attributesAllowed != null && !this.attributesAllowed.contains(attributedCharacterIterator$Attribute)) {
            return this.end;
        }
        ArrayList arrayList = (ArrayList)this.attrString.attributeMap.get(attributedCharacterIterator$Attribute);
        if (arrayList == null) {
            return this.end;
        }
        return this.runLimit(arrayList);
    }

    @Override
    public int getRunLimit(Set set) {
        int n = this.end;
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            AttributedCharacterIterator$Attribute attributedCharacterIterator$Attribute = (AttributedCharacterIterator$Attribute)iterator.next();
            int n2 = this.getRunLimit(attributedCharacterIterator$Attribute);
            if (n2 >= n) continue;
            n = n2;
        }
        return n;
    }

    @Override
    public int getRunStart() {
        return this.getRunStart(this.getAllAttributeKeys());
    }

    private int runStart(ArrayList arrayList) {
        int n = this.begin;
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            AttributedString$Range attributedString$Range = (AttributedString$Range)iterator.next();
            if (attributedString$Range.start >= this.end) break;
            if (this.offset >= attributedString$Range.start && this.offset < attributedString$Range.end) {
                return this.inRange(attributedString$Range) ? attributedString$Range.start : n;
            }
            if (this.offset < attributedString$Range.start) break;
            n = attributedString$Range.end;
        }
        return n;
    }

    @Override
    public int getRunStart(AttributedCharacterIterator$Attribute attributedCharacterIterator$Attribute) {
        if (this.attributesAllowed != null && !this.attributesAllowed.contains(attributedCharacterIterator$Attribute)) {
            return this.begin;
        }
        ArrayList arrayList = (ArrayList)this.attrString.attributeMap.get(attributedCharacterIterator$Attribute);
        if (arrayList == null) {
            return this.begin;
        }
        return this.runStart(arrayList);
    }

    @Override
    public int getRunStart(Set set) {
        int n = this.begin;
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            AttributedCharacterIterator$Attribute attributedCharacterIterator$Attribute = (AttributedCharacterIterator$Attribute)iterator.next();
            int n2 = this.getRunStart(attributedCharacterIterator$Attribute);
            if (n2 <= n) continue;
            n = n2;
        }
        return n;
    }

    @Override
    public char last() {
        if (this.begin == this.end) {
            return '\uffff0000';
        }
        this.offset = this.end - 1;
        return this.attrString.text.charAt(this.offset);
    }

    @Override
    public char next() {
        if (this.offset >= this.end - 1) {
            this.offset = this.end;
            return '\uffff0000';
        }
        return this.attrString.text.charAt(++this.offset);
    }

    @Override
    public char previous() {
        if (this.offset == this.begin) {
            return '\uffff0000';
        }
        return this.attrString.text.charAt(--this.offset);
    }

    @Override
    public char setIndex(int n) {
        if (n < this.begin || n > this.end) {
            throw new IllegalArgumentException();
        }
        this.offset = n;
        if (this.offset == this.end) {
            return '\uffff0000';
        }
        return this.attrString.text.charAt(this.offset);
    }
}

