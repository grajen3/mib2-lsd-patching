/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.io;

import com.ibm.oti.io.CharacterConverterSimple;

class CharacterConverter_CP1255
extends CharacterConverterSimple {
    private static final String byteTable;
    private static final String charKeys;
    private static final String charValues;

    CharacterConverter_CP1255() {
    }

    @Override
    String byteTable() {
        return "\u20ac\ufffd\u201a\u0192\u201e\u2026\u2020\u2021\u02c6\u2030\ufffd\u2039\ufffd\ufffd\ufffd\ufffd\ufffd\u2018\u2019\u201c\u201d\u2022\u2013\u2014\u02dc\u2122\ufffd\u203a\ufffd\ufffd\ufffd\ufffd\u00a0\u00a1\u00a2\u00a3\u20aa\u00a5\u00a6\u00a7\u00a8\u00a9\u00d7\u00ab\u00ac\u00ad\u00ae\u00af\u00b0\u00b1\u00b2\u00b3\u00b4\u00b5\u00b6\u00b7\u00b8\u00b9\u00f7\u00bb\u00bc\u00bd\u00be\u00bf\u05b0\u05b1\u05b2\u05b3\u05b4\u05b5\u05b6\u05b7\u05b8\u05b9\ufffd\u05bb\u05bc\u05bd\u05be\u05bf\u05c0\u05c1\u05c2\u05c3\u05f0\u05f1\u05f2\u05f3\u05f4\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\u05d0\u05d1\u05d2\u05d3\u05d4\u05d5\u05d6\u05d7\u05d8\u05d9\u05da\u05db\u05dc\u05dd\u05de\u05df\u05e0\u05e1\u05e2\u05e3\u05e4\u05e5\u05e6\u05e7\u05e8\u05e9\u05ea\ufffd\ufffd\u200e\u200f\ufffd";
    }

    @Override
    String charKeys() {
        return "\u00a0\u00a1\u00a2\u00a3\u00a5\u00a6\u00a7\u00a8\u00a9\u00ab\u00ac\u00ad\u00ae\u00af\u00b0\u00b1\u00b2\u00b3\u00b4\u00b5\u00b6\u00b7\u00b8\u00b9\u00bb\u00bc\u00bd\u00be\u00bf\u00d7\u00f7\u0192\u02c6\u02dc\u05b0\u05b1\u05b2\u05b3\u05b4\u05b5\u05b6\u05b7\u05b8\u05b9\u05bb\u05bc\u05bd\u05be\u05bf\u05c0\u05c1\u05c2\u05c3\u05d0\u05d1\u05d2\u05d3\u05d4\u05d5\u05d6\u05d7\u05d8\u05d9\u05da\u05db\u05dc\u05dd\u05de\u05df\u05e0\u05e1\u05e2\u05e3\u05e4\u05e5\u05e6\u05e7\u05e8\u05e9\u05ea\u05f0\u05f1\u05f2\u05f3\u05f4\u200e\u200f\u2013\u2014\u2018\u2019\u201a\u201c\u201d\u201e\u2020\u2021\u2022\u2026\u2030\u2039\u203a\u20aa\u20ac\u2122";
    }

    @Override
    String charValues() {
        return "\u00a0\u00a1\u00a2\u00a3\u00a5\u00a6\u00a7\u00a8\u00a9\u00ab\u00ac\u00ad\u00ae\u00af\u00b0\u00b1\u00b2\u00b3\u00b4\u00b5\u00b6\u00b7\u00b8\u00b9\u00bb\u00bc\u00bd\u00be\u00bf\u00aa\u00ba\u0083\u0088\u0098\u00c0\u00c1\u00c2\u00c3\u00c4\u00c5\u00c6\u00c7\u00c8\u00c9\u00cb\u00cc\u00cd\u00ce\u00cf\u00d0\u00d1\u00d2\u00d3\u00e0\u00e1\u00e2\u00e3\u00e4\u00e5\u00e6\u00e7\u00e8\u00e9\u00ea\u00eb\u00ec\u00ed\u00ee\u00ef\u00f0\u00f1\u00f2\u00f3\u00f4\u00f5\u00f6\u00f7\u00f8\u00f9\u00fa\u00d4\u00d5\u00d6\u00d7\u00d8\u00fd\u00fe\u0096\u0097\u0091\u0092\u0082\u0093\u0094\u0084\u0086\u0087\u0095\u0085\u0089\u008b\u009b\u00a4\u0080\u0099";
    }
}
