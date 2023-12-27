/*
 * Decompiled with CFR 0.152.
 */
package java.text;

import java.text.AttributedCharacterIterator$Attribute;
import java.text.CharacterIterator;
import java.util.Map;
import java.util.Set;

public interface AttributedCharacterIterator
extends CharacterIterator {
    default public Set getAllAttributeKeys() {
    }

    default public Object getAttribute(AttributedCharacterIterator$Attribute attributedCharacterIterator$Attribute) {
    }

    default public Map getAttributes() {
    }

    default public int getRunLimit() {
    }

    default public int getRunLimit(AttributedCharacterIterator$Attribute attributedCharacterIterator$Attribute) {
    }

    default public int getRunLimit(Set set) {
    }

    default public int getRunStart() {
    }

    default public int getRunStart(AttributedCharacterIterator$Attribute attributedCharacterIterator$Attribute) {
    }

    default public int getRunStart(Set set) {
    }
}

