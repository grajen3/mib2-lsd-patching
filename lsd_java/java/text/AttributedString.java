/*
 * Decompiled with CFR 0.152.
 */
package java.text;

import com.ibm.oti.util.Msg;
import java.text.Annotation;
import java.text.AttributedCharacterIterator;
import java.text.AttributedCharacterIterator$Attribute;
import java.text.AttributedString$AttributedIterator;
import java.text.AttributedString$Range;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;

public class AttributedString {
    String text;
    Map attributeMap;

    public AttributedString(AttributedCharacterIterator attributedCharacterIterator) {
        StringBuffer stringBuffer = new StringBuffer();
        while (attributedCharacterIterator.current() != '\uffff0000') {
            stringBuffer.append(attributedCharacterIterator.current());
            attributedCharacterIterator.next();
        }
        this.text = stringBuffer.toString();
        Set set = attributedCharacterIterator.getAllAttributeKeys();
        this.attributeMap = new HashMap(set.size() * 4 / 3 + 1);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            AttributedCharacterIterator$Attribute attributedCharacterIterator$Attribute = (AttributedCharacterIterator$Attribute)iterator.next();
            attributedCharacterIterator.setIndex(0);
            while (attributedCharacterIterator.current() != '\uffff0000') {
                int n = attributedCharacterIterator.getRunStart(attributedCharacterIterator$Attribute);
                int n2 = attributedCharacterIterator.getRunLimit(attributedCharacterIterator$Attribute);
                Object object = attributedCharacterIterator.getAttribute(attributedCharacterIterator$Attribute);
                if (object != null) {
                    this.addAttribute(attributedCharacterIterator$Attribute, object, n, n2);
                }
                attributedCharacterIterator.setIndex(n2);
            }
        }
    }

    private AttributedString(AttributedCharacterIterator attributedCharacterIterator, int n, int n2, Set set) {
        if (n < attributedCharacterIterator.getBeginIndex() || n2 > attributedCharacterIterator.getEndIndex() || n > n2) {
            throw new IllegalArgumentException();
        }
        StringBuffer stringBuffer = new StringBuffer();
        attributedCharacterIterator.setIndex(n);
        while (attributedCharacterIterator.getIndex() < n2) {
            stringBuffer.append(attributedCharacterIterator.current());
            attributedCharacterIterator.next();
        }
        this.text = stringBuffer.toString();
        this.attributeMap = new HashMap(set.size() * 4 / 3 + 1);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            AttributedCharacterIterator$Attribute attributedCharacterIterator$Attribute = (AttributedCharacterIterator$Attribute)iterator.next();
            attributedCharacterIterator.setIndex(n);
            while (attributedCharacterIterator.getIndex() < n2) {
                Object object = attributedCharacterIterator.getAttribute(attributedCharacterIterator$Attribute);
                int n3 = attributedCharacterIterator.getRunStart(attributedCharacterIterator$Attribute);
                int n4 = attributedCharacterIterator.getRunLimit(attributedCharacterIterator$Attribute);
                if (object instanceof Annotation && n3 >= n && n4 <= n2 || object != null && !(object instanceof Annotation)) {
                    this.addAttribute(attributedCharacterIterator$Attribute, object, (n3 < n ? n : n3) - n, (n4 > n2 ? n2 : n4) - n);
                }
                attributedCharacterIterator.setIndex(n4);
            }
        }
    }

    public AttributedString(AttributedCharacterIterator attributedCharacterIterator, int n, int n2) {
        this(attributedCharacterIterator, n, n2, attributedCharacterIterator.getAllAttributeKeys());
    }

    public AttributedString(AttributedCharacterIterator attributedCharacterIterator, int n, int n2, AttributedCharacterIterator$Attribute[] attributedCharacterIterator$AttributeArray) {
        this(attributedCharacterIterator, n, n2, new HashSet(Arrays.asList(attributedCharacterIterator$AttributeArray)));
    }

    public AttributedString(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.text = string;
        this.attributeMap = new HashMap(11);
    }

    public AttributedString(String string, Map map) {
        if (string == null) {
            throw new NullPointerException();
        }
        if (string.length() == 0 && !map.isEmpty()) {
            throw new IllegalArgumentException(Msg.getString("K000e"));
        }
        this.text = string;
        this.attributeMap = new HashMap(map.size() * 4 / 3 + 1);
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(new AttributedString$Range(0, this.text.length(), map$Entry.getValue()));
            this.attributeMap.put(map$Entry.getKey(), arrayList);
        }
    }

    public void addAttribute(AttributedCharacterIterator$Attribute attributedCharacterIterator$Attribute, Object object) {
        if (attributedCharacterIterator$Attribute == null) {
            throw new NullPointerException();
        }
        if (this.text.length() == 0) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = (ArrayList)this.attributeMap.get(attributedCharacterIterator$Attribute);
        if (arrayList == null) {
            arrayList = new ArrayList(1);
            this.attributeMap.put(attributedCharacterIterator$Attribute, arrayList);
        } else {
            arrayList.clear();
        }
        arrayList.add(new AttributedString$Range(0, this.text.length(), object));
    }

    public void addAttribute(AttributedCharacterIterator$Attribute attributedCharacterIterator$Attribute, Object object, int n, int n2) {
        if (attributedCharacterIterator$Attribute == null) {
            throw new NullPointerException();
        }
        if (n < 0 || n2 > this.text.length() || n >= n2) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = (ArrayList)this.attributeMap.get(attributedCharacterIterator$Attribute);
        if (arrayList == null) {
            arrayList = new ArrayList(1);
            arrayList.add(new AttributedString$Range(n, n2, object));
            this.attributeMap.put(attributedCharacterIterator$Attribute, arrayList);
            return;
        }
        ListIterator listIterator = arrayList.listIterator();
        while (listIterator.hasNext()) {
            AttributedString$Range attributedString$Range = (AttributedString$Range)listIterator.next();
            if (n2 <= attributedString$Range.start) {
                listIterator.previous();
                break;
            }
            if (n >= attributedString$Range.end && (n != attributedString$Range.end || !(object == null ? attributedString$Range.value == null : object.equals(attributedString$Range.value)))) continue;
            AttributedString$Range attributedString$Range2 = null;
            listIterator.remove();
            attributedString$Range2 = new AttributedString$Range(attributedString$Range.start, n, attributedString$Range.value);
            AttributedString$Range attributedString$Range3 = new AttributedString$Range(n2, attributedString$Range.end, attributedString$Range.value);
            while (n2 > attributedString$Range.end && listIterator.hasNext()) {
                attributedString$Range = (AttributedString$Range)listIterator.next();
                if (n2 <= attributedString$Range.end) {
                    if (n2 <= attributedString$Range.start && (n2 != attributedString$Range.start || !(object == null ? attributedString$Range.value == null : object.equals(attributedString$Range.value)))) continue;
                    listIterator.remove();
                    attributedString$Range3 = new AttributedString$Range(n2, attributedString$Range.end, attributedString$Range.value);
                    break;
                }
                listIterator.remove();
            }
            if (object == null ? attributedString$Range2.value == null : object.equals(attributedString$Range2.value)) {
                if (object == null ? attributedString$Range3.value == null : object.equals(attributedString$Range3.value)) {
                    listIterator.add(new AttributedString$Range(attributedString$Range2.start < n ? attributedString$Range2.start : n, attributedString$Range3.end > n2 ? attributedString$Range3.end : n2, attributedString$Range2.value));
                } else {
                    listIterator.add(new AttributedString$Range(attributedString$Range2.start < n ? attributedString$Range2.start : n, n2, attributedString$Range2.value));
                    if (attributedString$Range3.start < attributedString$Range3.end) {
                        listIterator.add(attributedString$Range3);
                    }
                }
            } else if (object == null ? attributedString$Range3.value == null : object.equals(attributedString$Range3.value)) {
                if (attributedString$Range2.start < attributedString$Range2.end) {
                    listIterator.add(attributedString$Range2);
                }
                listIterator.add(new AttributedString$Range(n, attributedString$Range3.end > n2 ? attributedString$Range3.end : n2, attributedString$Range3.value));
            } else {
                if (attributedString$Range2.start < attributedString$Range2.end) {
                    listIterator.add(attributedString$Range2);
                }
                listIterator.add(new AttributedString$Range(n, n2, object));
                if (attributedString$Range3.start < attributedString$Range3.end) {
                    listIterator.add(attributedString$Range3);
                }
            }
            return;
        }
        listIterator.add(new AttributedString$Range(n, n2, object));
    }

    public void addAttributes(Map map, int n, int n2) {
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            this.addAttribute((AttributedCharacterIterator$Attribute)map$Entry.getKey(), map$Entry.getValue(), n, n2);
        }
    }

    public AttributedCharacterIterator getIterator() {
        return new AttributedString$AttributedIterator(this);
    }

    public AttributedCharacterIterator getIterator(AttributedCharacterIterator$Attribute[] attributedCharacterIterator$AttributeArray) {
        return new AttributedString$AttributedIterator(this, attributedCharacterIterator$AttributeArray, 0, this.text.length());
    }

    public AttributedCharacterIterator getIterator(AttributedCharacterIterator$Attribute[] attributedCharacterIterator$AttributeArray, int n, int n2) {
        return new AttributedString$AttributedIterator(this, attributedCharacterIterator$AttributeArray, n, n2);
    }
}

