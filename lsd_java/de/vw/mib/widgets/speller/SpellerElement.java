/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.graphics.Point;
import de.vw.mib.util.StringBuilder;
import de.vw.mib.widgets.speller.Alphabet;

public final class SpellerElement {
    private final int id;
    private final int index;
    private int x;
    private int y;
    private int width;
    private int height;
    private final String templateId;
    private final String graphRep;
    private final String graphRep2;
    private final String returnValue;
    private final String returnFunction;
    private Alphabet subAlphabet;
    private SpellerElement leftSpellerElement;
    private SpellerElement rightSpellerElement;
    private SpellerElement subSpellerElement;
    private Alphabet alphabet;

    public SpellerElement(int n, int n2, int n3, int n4, String string, String string2, String string3, String string4, String string5) {
        this(-1, -1, n, n2, n3, n4, string, string2, string3, string4, string5);
    }

    public SpellerElement(int n, int n2, int n3, int n4, int n5, int n6, String string, String string2, String string3, String string4, String string5) {
        this.id = n;
        this.index = n2;
        this.x = n3;
        this.y = n4;
        this.width = n5;
        this.height = n6;
        this.templateId = string;
        this.graphRep = string2;
        this.graphRep2 = string3;
        this.returnValue = string4;
        this.returnFunction = string5;
        this.subAlphabet = null;
        this.leftSpellerElement = null;
        this.rightSpellerElement = null;
        this.subSpellerElement = null;
    }

    public int getId() {
        return this.id;
    }

    public int getIndex() {
        return this.index;
    }

    public int getAbsX() {
        Point point;
        if (this.alphabet != null && (point = this.alphabet.getLocation()) != null) {
            return this.x + point.x;
        }
        return this.x;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int n) {
        this.x = n;
    }

    public int getAbsY() {
        Point point;
        if (this.alphabet != null && (point = this.alphabet.getLocation()) != null) {
            return this.y + point.y;
        }
        return this.y;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int n) {
        this.y = n;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int n) {
        this.width = n;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int n) {
        this.height = n;
    }

    public String getTemplateId() {
        return this.templateId;
    }

    public String getGraphRep() {
        return this.graphRep;
    }

    public String getGraphRep2() {
        return this.graphRep2;
    }

    public String getReturnValue() {
        if (this.subSpellerElement != null) {
            return this.subSpellerElement.getReturnValue();
        }
        return this.returnValue;
    }

    public String getReturnFunction() {
        return this.returnFunction;
    }

    public Alphabet getSubAlphabet() {
        return this.subAlphabet;
    }

    public void setSubAlphabet(Alphabet alphabet) {
        this.subAlphabet = alphabet;
    }

    public SpellerElement getLeftSpellerElement() {
        return this.leftSpellerElement;
    }

    public void setLeftSpellerElement(SpellerElement spellerElement) {
        this.leftSpellerElement = spellerElement;
    }

    public SpellerElement getRightSpellerElement() {
        return this.rightSpellerElement;
    }

    public void setRightSpellerElement(SpellerElement spellerElement) {
        this.rightSpellerElement = spellerElement;
    }

    public boolean hasSubSpellerElement() {
        return this.subSpellerElement != null;
    }

    public SpellerElement getSubSpellerElement() {
        return this.subSpellerElement;
    }

    public void setSubSpellerElement(SpellerElement spellerElement) {
        this.subSpellerElement = spellerElement;
    }

    public Alphabet getAlphabet() {
        return this.alphabet;
    }

    public void setAlphabet(Alphabet alphabet) {
        this.alphabet = alphabet;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object != null && super.getClass() == object.getClass()) {
            SpellerElement spellerElement = (SpellerElement)object;
            boolean bl = this.id == spellerElement.id && this.index == spellerElement.index && this.x == spellerElement.x && this.y == spellerElement.y && this.width == spellerElement.width && this.height == spellerElement.height;
            bl = bl && this.templateId != null && this.templateId.equals(spellerElement.templateId);
            bl = bl && this.graphRep != null && this.graphRep.equals(spellerElement.graphRep);
            bl = bl && this.graphRep2 != null && this.graphRep2.equals(spellerElement.graphRep2);
            bl = bl && this.returnValue != null && this.returnValue.equals(spellerElement.returnValue);
            bl = bl && this.returnFunction != null && this.returnFunction.equals(spellerElement.returnFunction);
            return bl;
        }
        return false;
    }

    public int hashCode() {
        HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
        hashCodeBuilder.append(this.id);
        hashCodeBuilder.append(this.index);
        hashCodeBuilder.append(this.x);
        hashCodeBuilder.append(this.y);
        hashCodeBuilder.append(this.width);
        hashCodeBuilder.append(this.height);
        hashCodeBuilder.append(this.templateId);
        hashCodeBuilder.append(this.graphRep);
        hashCodeBuilder.append(this.graphRep2);
        hashCodeBuilder.append(this.returnValue);
        hashCodeBuilder.append(this.returnFunction);
        return hashCodeBuilder.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SpellerElement").append("[");
        if (this.templateId != null) {
            stringBuilder.append("templateId='").append(this.templateId).append("'");
        }
        if (this.graphRep != null && this.graphRep.length() > 0) {
            stringBuilder.append(", ");
            stringBuilder.append("graphRep='").append(this.graphRep).append("'");
        }
        if (this.graphRep2 != null && this.graphRep2.length() > 0) {
            stringBuilder.append(", ");
            stringBuilder.append("graphRep2='").append(this.graphRep2).append("'");
        }
        if (this.returnValue != null && this.returnValue.length() > 0) {
            stringBuilder.append(", ");
            stringBuilder.append("returnValue='").append(this.returnValue).append("'");
        }
        if (this.returnFunction != null && this.returnFunction.length() > 0) {
            stringBuilder.append(", ");
            stringBuilder.append("returnFunction='").append(this.returnFunction).append("'");
        }
        stringBuilder.append(", ");
        stringBuilder.append("x=").append(this.x).append(", y=").append(this.y).append(", width=").append(this.width).append(", height=").append(this.height);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

