/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller;

import de.vw.mib.graphics.Dimension;
import de.vw.mib.graphics.Point;
import de.vw.mib.widgets.speller.SeparatorElement;
import de.vw.mib.widgets.speller.SpellerElement;

public interface Alphabet {
    default public void addElement(SpellerElement spellerElement) {
    }

    default public void addSeparator(SeparatorElement separatorElement) {
    }

    default public SpellerElement getElement(int n) {
    }

    default public int getElementCount() {
    }

    default public int getElementCount(boolean bl) {
    }

    default public String getFileName() {
    }

    default public Point getLocation() {
    }

    default public String getName() {
    }

    default public SpellerElement getParent() {
    }

    default public SeparatorElement getSeparator(int n) {
    }

    default public int getSeparatorCount() {
    }

    default public Dimension getSize() {
    }

    default public void init() {
    }

    default public void setLocation(int n, int n2) {
    }

    default public void setLocation(Point point) {
    }

    default public void setParent(SpellerElement spellerElement) {
    }

    default public void setSize(Dimension dimension) {
    }
}

