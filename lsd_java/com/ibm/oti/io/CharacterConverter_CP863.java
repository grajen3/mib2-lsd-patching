/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.io;

import com.ibm.oti.io.CharacterConverterSimple;

class CharacterConverter_CP863
extends CharacterConverterSimple {
    private static final String byteTable;
    private static final String charKeys;
    private static final String charValues;

    CharacterConverter_CP863() {
    }

    @Override
    String byteTable() {
        return "\u00c7\u00fc\u00e9\u00e2\u00c2\u00e0\u00b6\u00e7\u00ea\u00eb\u00e8\u00ef\u00ee\u2017\u00c0\u00a7\u00c9\u00c8\u00ca\u00f4\u00cb\u00cf\u00fb\u00f9\u00a4\u00d4\u00dc\u00a2\u00a3\u00d9\u00db\u0192\u00a6\u00b4\u00f3\u00fa\u00a8\u00b8\u00b3\u00af\u00ce\u2310\u00ac\u00bd\u00bc\u00be\u00ab\u00bb\u2591\u2592\u2593\u2502\u2524\u2561\u2562\u2556\u2555\u2563\u2551\u2557\u255d\u255c\u255b\u2510\u2514\u2534\u252c\u251c\u2500\u253c\u255e\u255f\u255a\u2554\u2569\u2566\u2560\u2550\u256c\u2567\u2568\u2564\u2565\u2559\u2558\u2552\u2553\u256b\u256a\u2518\u250c\u2588\u2584\u258c\u2590\u2580\u03b1\u00df\u0393\u03c0\u03a3\u03c3\u00b5\u03c4\u03a6\u0398\u03a9\u03b4\u221e\u03c6\u03b5\u2229\u2261\u00b1\u2265\u2264\u2320\u2321\u00f7\u2248\u00b0\u2219\u00b7\u221a\u207f\u00b2\u25a0\u00a0";
    }

    @Override
    String charKeys() {
        return "\u00a0\u00a2\u00a3\u00a4\u00a6\u00a7\u00a8\u00ab\u00ac\u00af\u00b0\u00b1\u00b2\u00b3\u00b4\u00b5\u00b6\u00b7\u00b8\u00bb\u00bc\u00bd\u00be\u00c0\u00c2\u00c7\u00c8\u00c9\u00ca\u00cb\u00ce\u00cf\u00d4\u00d9\u00db\u00dc\u00df\u00e0\u00e2\u00e7\u00e8\u00e9\u00ea\u00eb\u00ee\u00ef\u00f3\u00f4\u00f7\u00f9\u00fa\u00fb\u00fc\u0192\u0393\u0398\u03a3\u03a6\u03a9\u03b1\u03b4\u03b5\u03c0\u03c3\u03c4\u03c6\u2017\u207f\u2219\u221a\u221e\u2229\u2248\u2261\u2264\u2265\u2310\u2320\u2321\u2500\u2502\u250c\u2510\u2514\u2518\u251c\u2524\u252c\u2534\u253c\u2550\u2551\u2552\u2553\u2554\u2555\u2556\u2557\u2558\u2559\u255a\u255b\u255c\u255d\u255e\u255f\u2560\u2561\u2562\u2563\u2564\u2565\u2566\u2567\u2568\u2569\u256a\u256b\u256c\u2580\u2584\u2588\u258c\u2590\u2591\u2592\u2593\u25a0";
    }

    @Override
    String charValues() {
        return "\u00ff\u009b\u009c\u0098\u00a0\u008f\u00a4\u00ae\u00aa\u00a7\u00f8\u00f1\u00fd\u00a6\u00a1\u00e6\u0086\u00fa\u00a5\u00af\u00ac\u00ab\u00ad\u008e\u0084\u0080\u0091\u0090\u0092\u0094\u00a8\u0095\u0099\u009d\u009e\u009a\u00e1\u0085\u0083\u0087\u008a\u0082\u0088\u0089\u008c\u008b\u00a2\u0093\u00f6\u0097\u00a3\u0096\u0081\u009f\u00e2\u00e9\u00e4\u00e8\u00ea\u00e0\u00eb\u00ee\u00e3\u00e5\u00e7\u00ed\u008d\u00fc\u00f9\u00fb\u00ec\u00ef\u00f7\u00f0\u00f3\u00f2\u00a9\u00f4\u00f5\u00c4\u00b3\u00da\u00bf\u00c0\u00d9\u00c3\u00b4\u00c2\u00c1\u00c5\u00cd\u00ba\u00d5\u00d6\u00c9\u00b8\u00b7\u00bb\u00d4\u00d3\u00c8\u00be\u00bd\u00bc\u00c6\u00c7\u00cc\u00b5\u00b6\u00b9\u00d1\u00d2\u00cb\u00cf\u00d0\u00ca\u00d8\u00d7\u00ce\u00df\u00dc\u00db\u00dd\u00de\u00b0\u00b1\u00b2\u00fe";
    }
}

