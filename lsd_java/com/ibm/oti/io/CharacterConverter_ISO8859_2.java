/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.io;

import com.ibm.oti.io.CharacterConverterSimple;

class CharacterConverter_ISO8859_2
extends CharacterConverterSimple {
    private static final String byteTable;
    private static final String charKeys;
    private static final String charValues;

    CharacterConverter_ISO8859_2() {
    }

    @Override
    String byteTable() {
        return "\u0080\u0081\u0082\u0083\u0084\u0085\u0086\u0087\u0088\u0089\u008a\u008b\u008c\u008d\u008e\u008f\u0090\u0091\u0092\u0093\u0094\u0095\u0096\u0097\u0098\u0099\u009a\u009b\u009c\u009d\u009e\u009f\u00a0\u0104\u02d8\u0141\u00a4\u013d\u015a\u00a7\u00a8\u0160\u015e\u0164\u0179\u00ad\u017d\u017b\u00b0\u0105\u02db\u0142\u00b4\u013e\u015b\u02c7\u00b8\u0161\u015f\u0165\u017a\u02dd\u017e\u017c\u0154\u00c1\u00c2\u0102\u00c4\u0139\u0106\u00c7\u010c\u00c9\u0118\u00cb\u011a\u00cd\u00ce\u010e\u0110\u0143\u0147\u00d3\u00d4\u0150\u00d6\u00d7\u0158\u016e\u00da\u0170\u00dc\u00dd\u0162\u00df\u0155\u00e1\u00e2\u0103\u00e4\u013a\u0107\u00e7\u010d\u00e9\u0119\u00eb\u011b\u00ed\u00ee\u010f\u0111\u0144\u0148\u00f3\u00f4\u0151\u00f6\u00f7\u0159\u016f\u00fa\u0171\u00fc\u00fd\u0163\u02d9";
    }

    @Override
    String charKeys() {
        return "\u0080\u0081\u0082\u0083\u0084\u0085\u0086\u0087\u0088\u0089\u008a\u008b\u008c\u008d\u008e\u008f\u0090\u0091\u0092\u0093\u0094\u0095\u0096\u0097\u0098\u0099\u009a\u009b\u009c\u009d\u009e\u009f\u00a0\u00a4\u00a7\u00a8\u00ad\u00b0\u00b4\u00b8\u00c1\u00c2\u00c4\u00c7\u00c9\u00cb\u00cd\u00ce\u00d3\u00d4\u00d6\u00d7\u00da\u00dc\u00dd\u00df\u00e1\u00e2\u00e4\u00e7\u00e9\u00eb\u00ed\u00ee\u00f3\u00f4\u00f6\u00f7\u00fa\u00fc\u00fd\u0102\u0103\u0104\u0105\u0106\u0107\u010c\u010d\u010e\u010f\u0110\u0111\u0118\u0119\u011a\u011b\u0139\u013a\u013d\u013e\u0141\u0142\u0143\u0144\u0147\u0148\u0150\u0151\u0154\u0155\u0158\u0159\u015a\u015b\u015e\u015f\u0160\u0161\u0162\u0163\u0164\u0165\u016e\u016f\u0170\u0171\u0179\u017a\u017b\u017c\u017d\u017e\u02c7\u02d8\u02d9\u02db\u02dd";
    }

    @Override
    String charValues() {
        return "\u0080\u0081\u0082\u0083\u0084\u0085\u0086\u0087\u0088\u0089\u008a\u008b\u008c\u008d\u008e\u008f\u0090\u0091\u0092\u0093\u0094\u0095\u0096\u0097\u0098\u0099\u009a\u009b\u009c\u009d\u009e\u009f\u00a0\u00a4\u00a7\u00a8\u00ad\u00b0\u00b4\u00b8\u00c1\u00c2\u00c4\u00c7\u00c9\u00cb\u00cd\u00ce\u00d3\u00d4\u00d6\u00d7\u00da\u00dc\u00dd\u00df\u00e1\u00e2\u00e4\u00e7\u00e9\u00eb\u00ed\u00ee\u00f3\u00f4\u00f6\u00f7\u00fa\u00fc\u00fd\u00c3\u00e3\u00a1\u00b1\u00c6\u00e6\u00c8\u00e8\u00cf\u00ef\u00d0\u00f0\u00ca\u00ea\u00cc\u00ec\u00c5\u00e5\u00a5\u00b5\u00a3\u00b3\u00d1\u00f1\u00d2\u00f2\u00d5\u00f5\u00c0\u00e0\u00d8\u00f8\u00a6\u00b6\u00aa\u00ba\u00a9\u00b9\u00de\u00fe\u00ab\u00bb\u00d9\u00f9\u00db\u00fb\u00ac\u00bc\u00af\u00bf\u00ae\u00be\u00b7\u00a2\u00ff\u00b2\u00bd";
    }
}

