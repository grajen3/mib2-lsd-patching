/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.io;

import com.ibm.oti.io.CharacterConverterSimple;

class CharacterConverter_CP858
extends CharacterConverterSimple {
    private static final String byteTable;
    private static final String charKeys;
    private static final String charValues;

    CharacterConverter_CP858() {
    }

    @Override
    String byteTable() {
        return "\u00c7\u00fc\u00e9\u00e2\u00e4\u00e0\u00e5\u00e7\u00ea\u00eb\u00e8\u00ef\u00ee\u00ec\u00c4\u00c5\u00c9\u00e6\u00c6\u00f4\u00f6\u00f2\u00fb\u00f9\u00ff\u00d6\u00dc\u00f8\u00a3\u00d8\u00d7\u0192\u00e1\u00ed\u00f3\u00fa\u00f1\u00d1\u00aa\u00ba\u00bf\u00ae\u00ac\u00bd\u00bc\u00a1\u00ab\u00bb\u2591\u2592\u2593\u2502\u2524\u00c1\u00c2\u00c0\u00a9\u2563\u2551\u2557\u255d\u00a2\u00a5\u2510\u2514\u2534\u252c\u251c\u2500\u253c\u00e3\u00c3\u255a\u2554\u2569\u2566\u2560\u2550\u256c\u00a4\u00f0\u00d0\u00ca\u00cb\u00c8\u20ac\u00cd\u00ce\u00cf\u2518\u250c\u2588\u2584\u00a6\u00cc\u2580\u00d3\u00df\u00d4\u00d2\u00f5\u00d5\u00b5\u00fe\u00de\u00da\u00db\u00d9\u00fd\u00dd\u00af\u00b4\u00ad\u00b1\u2017\u00be\u00b6\u00a7\u00f7\u00b8\u00b0\u00a8\u00b7\u00b9\u00b3\u00b2\u25a0\u00a0";
    }

    @Override
    String charKeys() {
        return "\u00a0\u00a1\u00a2\u00a3\u00a4\u00a5\u00a6\u00a7\u00a8\u00a9\u00aa\u00ab\u00ac\u00ad\u00ae\u00af\u00b0\u00b1\u00b2\u00b3\u00b4\u00b5\u00b6\u00b7\u00b8\u00b9\u00ba\u00bb\u00bc\u00bd\u00be\u00bf\u00c0\u00c1\u00c2\u00c3\u00c4\u00c5\u00c6\u00c7\u00c8\u00c9\u00ca\u00cb\u00cc\u00cd\u00ce\u00cf\u00d0\u00d1\u00d2\u00d3\u00d4\u00d5\u00d6\u00d7\u00d8\u00d9\u00da\u00db\u00dc\u00dd\u00de\u00df\u00e0\u00e1\u00e2\u00e3\u00e4\u00e5\u00e6\u00e7\u00e8\u00e9\u00ea\u00eb\u00ec\u00ed\u00ee\u00ef\u00f0\u00f1\u00f2\u00f3\u00f4\u00f5\u00f6\u00f7\u00f8\u00f9\u00fa\u00fb\u00fc\u00fd\u00fe\u00ff\u0192\u2017\u20ac\u2500\u2502\u250c\u2510\u2514\u2518\u251c\u2524\u252c\u2534\u253c\u2550\u2551\u2554\u2557\u255a\u255d\u2560\u2563\u2566\u2569\u256c\u2580\u2584\u2588\u2591\u2592\u2593\u25a0";
    }

    @Override
    String charValues() {
        return "\u00ff\u00ad\u00bd\u009c\u00cf\u00be\u00dd\u00f5\u00f9\u00b8\u00a6\u00ae\u00aa\u00f0\u00a9\u00ee\u00f8\u00f1\u00fd\u00fc\u00ef\u00e6\u00f4\u00fa\u00f7\u00fb\u00a7\u00af\u00ac\u00ab\u00f3\u00a8\u00b7\u00b5\u00b6\u00c7\u008e\u008f\u0092\u0080\u00d4\u0090\u00d2\u00d3\u00de\u00d6\u00d7\u00d8\u00d1\u00a5\u00e3\u00e0\u00e2\u00e5\u0099\u009e\u009d\u00eb\u00e9\u00ea\u009a\u00ed\u00e8\u00e1\u0085\u00a0\u0083\u00c6\u0084\u0086\u0091\u0087\u008a\u0082\u0088\u0089\u008d\u00a1\u008c\u008b\u00d0\u00a4\u0095\u00a2\u0093\u00e4\u0094\u00f6\u009b\u0097\u00a3\u0096\u0081\u00ec\u00e7\u0098\u009f\u00f2\u00d5\u00c4\u00b3\u00da\u00bf\u00c0\u00d9\u00c3\u00b4\u00c2\u00c1\u00c5\u00cd\u00ba\u00c9\u00bb\u00c8\u00bc\u00cc\u00b9\u00cb\u00ca\u00ce\u00df\u00dc\u00db\u00b0\u00b1\u00b2\u00fe";
    }
}

