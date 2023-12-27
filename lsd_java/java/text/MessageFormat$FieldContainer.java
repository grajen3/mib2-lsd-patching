/*
 * Decompiled with CFR 0.152.
 */
package java.text;

import java.text.AttributedCharacterIterator$Attribute;

class MessageFormat$FieldContainer {
    int start;
    int end;
    AttributedCharacterIterator$Attribute attribute;
    Object value;

    public MessageFormat$FieldContainer(int n, int n2, AttributedCharacterIterator$Attribute attributedCharacterIterator$Attribute, Object object) {
        this.start = n;
        this.end = n2;
        this.attribute = attributedCharacterIterator$Attribute;
        this.value = object;
    }
}

