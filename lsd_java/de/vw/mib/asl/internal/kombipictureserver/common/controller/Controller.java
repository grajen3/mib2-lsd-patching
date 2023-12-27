/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.kombipictureserver.common.controller;

import de.vw.mib.asl.internal.kombipictureserver.common.category.Category;
import de.vw.mib.asl.internal.kombipictureserver.common.sequence.Sequence;

public interface Controller {
    default public Category getCategory(int n) {
    }

    default public Sequence getSequence(int n) {
    }
}

