/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.io;

import com.ibm.oti.io.CharacterConverterSimple;

class CharacterConverter_ISO8859_16
extends CharacterConverterSimple {
    private static final String byteTable;
    private static final String charKeys;
    private static final String charValues;

    CharacterConverter_ISO8859_16() {
    }

    @Override
    String byteTable() {
        return "\u0080\u0081\u0082\u0083\u0084\u0085\u0086\u0087\u0088\u0089\u008a\u008b\u008c\u008d\u008e\u008f\u0090\u0091\u0092\u0093\u0094\u0095\u0096\u0097\u0098\u0099\u009a\u009b\u009c\u009d\u009e\u009f\u00a0\u0104\u0105\u0141\u20ac\u201e\u0160\u00a7\u0161\u00a9\u0218\u00ab\u0179\u00ad\u017a\u017b\u00b0\u00b1\u010c\u0142\u017d\u201d\u00b6\u00b7\u017e\u010d\u0219\u00bb\u0152\u0153\u0178\u017c\u00c0\u00c1\u00c2\u0102\u00c4\u0106\u00c6\u00c7\u00c8\u00c9\u00ca\u00cb\u00cc\u00cd\u00ce\u00cf\u0110\u0143\u00d2\u00d3\u00d4\u0150\u00d6\u015a\u0170\u00d9\u00da\u00db\u00dc\u0118\u021a\u00df\u00e0\u00e1\u00e2\u0103\u00e4\u0107\u00e6\u00e7\u00e8\u00e9\u00ea\u00eb\u00ec\u00ed\u00ee\u00ef\u0111\u0144\u00f2\u00f3\u00f4\u0151\u00f6\u015b\u0171\u00f9\u00fa\u00fb\u00fc\u0119\u021b\u00ff";
    }

    @Override
    String charKeys() {
        return "\u0080\u0081\u0082\u0083\u0084\u0085\u0086\u0087\u0088\u0089\u008a\u008b\u008c\u008d\u008e\u008f\u0090\u0091\u0092\u0093\u0094\u0095\u0096\u0097\u0098\u0099\u009a\u009b\u009c\u009d\u009e\u009f\u00a0\u00a7\u00a9\u00ab\u00ad\u00b0\u00b1\u00b6\u00b7\u00bb\u00c0\u00c1\u00c2\u00c4\u00c6\u00c7\u00c8\u00c9\u00ca\u00cb\u00cc\u00cd\u00ce\u00cf\u00d2\u00d3\u00d4\u00d6\u00d9\u00da\u00db\u00dc\u00df\u00e0\u00e1\u00e2\u00e4\u00e6\u00e7\u00e8\u00e9\u00ea\u00eb\u00ec\u00ed\u00ee\u00ef\u00f2\u00f3\u00f4\u00f6\u00f9\u00fa\u00fb\u00fc\u00ff\u0102\u0103\u0104\u0105\u0106\u0107\u010c\u010d\u0110\u0111\u0118\u0119\u0141\u0142\u0143\u0144\u0150\u0151\u0152\u0153\u015a\u015b\u0160\u0161\u0170\u0171\u0178\u0179\u017a\u017b\u017c\u017d\u017e\u0218\u0219\u021a\u021b\u201d\u201e\u20ac";
    }

    @Override
    String charValues() {
        return "\u0080\u0081\u0082\u0083\u0084\u0085\u0086\u0087\u0088\u0089\u008a\u008b\u008c\u008d\u008e\u008f\u0090\u0091\u0092\u0093\u0094\u0095\u0096\u0097\u0098\u0099\u009a\u009b\u009c\u009d\u009e\u009f\u00a0\u00a7\u00a9\u00ab\u00ad\u00b0\u00b1\u00b6\u00b7\u00bb\u00c0\u00c1\u00c2\u00c4\u00c6\u00c7\u00c8\u00c9\u00ca\u00cb\u00cc\u00cd\u00ce\u00cf\u00d2\u00d3\u00d4\u00d6\u00d9\u00da\u00db\u00dc\u00df\u00e0\u00e1\u00e2\u00e4\u00e6\u00e7\u00e8\u00e9\u00ea\u00eb\u00ec\u00ed\u00ee\u00ef\u00f2\u00f3\u00f4\u00f6\u00f9\u00fa\u00fb\u00fc\u00ff\u00c3\u00e3\u00a1\u00a2\u00c5\u00e5\u00b2\u00b9\u00d0\u00f0\u00dd\u00fd\u00a3\u00b3\u00d1\u00f1\u00d5\u00f5\u00bc\u00bd\u00d7\u00f7\u00a6\u00a8\u00d8\u00f8\u00be\u00ac\u00ae\u00af\u00bf\u00b4\u00b8\u00aa\u00ba\u00de\u00fe\u00b5\u00a5\u00a4";
    }
}

