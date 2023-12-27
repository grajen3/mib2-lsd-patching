/*
 * Decompiled with CFR 0.152.
 */
package java.text;

import com.ibm.oti.util.Msg;
import java.text.CharSet$Enumeration;
import java.util.Hashtable;

class CharSet
implements Cloneable {
    private String chars;
    private static Hashtable expressionCache = null;
    private static final String[][] categoryMap = new String[][]{{"Ll", "az\u00aa\u00aa\u00b5\u00b5\u00ba\u00ba\u00df\u00f6\u00f8\u00ff\u0101\u0101\u0103\u0103\u0105\u0105\u0107\u0107\u0109\u0109\u010b\u010b\u010d\u010d\u010f\u010f\u0111\u0111\u0113\u0113\u0115\u0115\u0117\u0117\u0119\u0119\u011b\u011b\u011d\u011d\u011f\u011f\u0121\u0121\u0123\u0123\u0125\u0125\u0127\u0127\u0129\u0129\u012b\u012b\u012d\u012d\u012f\u012f\u0131\u0131\u0133\u0133\u0135\u0135\u0137\u0138\u013a\u013a\u013c\u013c\u013e\u013e\u0140\u0140\u0142\u0142\u0144\u0144\u0146\u0146\u0148\u0149\u014b\u014b\u014d\u014d\u014f\u014f\u0151\u0151\u0153\u0153\u0155\u0155\u0157\u0157\u0159\u0159\u015b\u015b\u015d\u015d\u015f\u015f\u0161\u0161\u0163\u0163\u0165\u0165\u0167\u0167\u0169\u0169\u016b\u016b\u016d\u016d\u016f\u016f\u0171\u0171\u0173\u0173\u0175\u0175\u0177\u0177\u017a\u017a\u017c\u017c\u017e\u0180\u0183\u0183\u0185\u0185\u0188\u0188\u018c\u018d\u0192\u0192\u0195\u0195\u0199\u019b\u019e\u019e\u01a1\u01a1\u01a3\u01a3\u01a5\u01a5\u01a8\u01a8\u01aa\u01ab\u01ad\u01ad\u01b0\u01b0\u01b4\u01b4\u01b6\u01b6\u01b9\u01ba\u01bd\u01bf\u01c6\u01c6\u01c9\u01c9\u01cc\u01cc\u01ce\u01ce\u01d0\u01d0\u01d2\u01d2\u01d4\u01d4\u01d6\u01d6\u01d8\u01d8\u01da\u01da\u01dc\u01dd\u01df\u01df\u01e1\u01e1\u01e3\u01e3\u01e5\u01e5\u01e7\u01e7\u01e9\u01e9\u01eb\u01eb\u01ed\u01ed\u01ef\u01f0\u01f3\u01f3\u01f5\u01f5\u01f9\u01f9\u01fb\u01fb\u01fd\u01fd\u01ff\u01ff\u0201\u0201\u0203\u0203\u0205\u0205\u0207\u0207\u0209\u0209\u020b\u020b\u020d\u020d\u020f\u020f\u0211\u0211\u0213\u0213\u0215\u0215\u0217\u0217\u0219\u0219\u021b\u021b\u021d\u021d\u021f\u021f\u0223\u0223\u0225\u0225\u0227\u0227\u0229\u0229\u022b\u022b\u022d\u022d\u022f\u022f\u0231\u0231\u0233\u0233\u0250\u02ad\u0390\u0390\u03ac\u03ce\u03d0\u03d1\u03d5\u03d7\u03db\u03db\u03dd\u03dd\u03df\u03df\u03e1\u03e1\u03e3\u03e3\u03e5\u03e5\u03e7\u03e7\u03e9\u03e9\u03eb\u03eb\u03ed\u03ed\u03ef\u03f3\u0430\u045f\u0461\u0461\u0463\u0463\u0465\u0465\u0467\u0467\u0469\u0469\u046b\u046b\u046d\u046d\u046f\u046f\u0471\u0471\u0473\u0473\u0475\u0475\u0477\u0477\u0479\u0479\u047b\u047b\u047d\u047d\u047f\u047f\u0481\u0481\u048d\u048d\u048f\u048f\u0491\u0491\u0493\u0493\u0495\u0495\u0497\u0497\u0499\u0499\u049b\u049b\u049d\u049d\u049f\u049f\u04a1\u04a1\u04a3\u04a3\u04a5\u04a5\u04a7\u04a7\u04a9\u04a9\u04ab\u04ab\u04ad\u04ad\u04af\u04af\u04b1\u04b1\u04b3\u04b3\u04b5\u04b5\u04b7\u04b7\u04b9\u04b9\u04bb\u04bb\u04bd\u04bd\u04bf\u04bf\u04c2\u04c2\u04c4\u04c4\u04c8\u04c8\u04cc\u04cc\u04d1\u04d1\u04d3\u04d3\u04d5\u04d5\u04d7\u04d7\u04d9\u04d9\u04db\u04db\u04dd\u04dd\u04df\u04df\u04e1\u04e1\u04e3\u04e3\u04e5\u04e5\u04e7\u04e7\u04e9\u04e9\u04eb\u04eb\u04ed\u04ed\u04ef\u04ef\u04f1\u04f1\u04f3\u04f3\u04f5\u04f5\u04f9\u04f9\u0561\u0587\u1e01\u1e01\u1e03\u1e03\u1e05\u1e05\u1e07\u1e07\u1e09\u1e09\u1e0b\u1e0b\u1e0d\u1e0d\u1e0f\u1e0f\u1e11\u1e11\u1e13\u1e13\u1e15\u1e15\u1e17\u1e17\u1e19\u1e19\u1e1b\u1e1b\u1e1d\u1e1d\u1e1f\u1e1f\u1e21\u1e21\u1e23\u1e23\u1e25\u1e25\u1e27\u1e27\u1e29\u1e29\u1e2b\u1e2b\u1e2d\u1e2d\u1e2f\u1e2f\u1e31\u1e31\u1e33\u1e33\u1e35\u1e35\u1e37\u1e37\u1e39\u1e39\u1e3b\u1e3b\u1e3d\u1e3d\u1e3f\u1e3f\u1e41\u1e41\u1e43\u1e43\u1e45\u1e45\u1e47\u1e47\u1e49\u1e49\u1e4b\u1e4b\u1e4d\u1e4d\u1e4f\u1e4f\u1e51\u1e51\u1e53\u1e53\u1e55\u1e55\u1e57\u1e57\u1e59\u1e59\u1e5b\u1e5b\u1e5d\u1e5d\u1e5f\u1e5f\u1e61\u1e61\u1e63\u1e63\u1e65\u1e65\u1e67\u1e67\u1e69\u1e69\u1e6b\u1e6b\u1e6d\u1e6d\u1e6f\u1e6f\u1e71\u1e71\u1e73\u1e73\u1e75\u1e75\u1e77\u1e77\u1e79\u1e79\u1e7b\u1e7b\u1e7d\u1e7d\u1e7f\u1e7f\u1e81\u1e81\u1e83\u1e83\u1e85\u1e85\u1e87\u1e87\u1e89\u1e89\u1e8b\u1e8b\u1e8d\u1e8d\u1e8f\u1e8f\u1e91\u1e91\u1e93\u1e93\u1e95\u1e9b\u1ea1\u1ea1\u1ea3\u1ea3\u1ea5\u1ea5\u1ea7\u1ea7\u1ea9\u1ea9\u1eab\u1eab\u1ead\u1ead\u1eaf\u1eaf\u1eb1\u1eb1\u1eb3\u1eb3\u1eb5\u1eb5\u1eb7\u1eb7\u1eb9\u1eb9\u1ebb\u1ebb\u1ebd\u1ebd\u1ebf\u1ebf\u1ec1\u1ec1\u1ec3\u1ec3\u1ec5\u1ec5\u1ec7\u1ec7\u1ec9\u1ec9\u1ecb\u1ecb\u1ecd\u1ecd\u1ecf\u1ecf\u1ed1\u1ed1\u1ed3\u1ed3\u1ed5\u1ed5\u1ed7\u1ed7\u1ed9\u1ed9\u1edb\u1edb\u1edd\u1edd\u1edf\u1edf\u1ee1\u1ee1\u1ee3\u1ee3\u1ee5\u1ee5\u1ee7\u1ee7\u1ee9\u1ee9\u1eeb\u1eeb\u1eed\u1eed\u1eef\u1eef\u1ef1\u1ef1\u1ef3\u1ef3\u1ef5\u1ef5\u1ef7\u1ef7\u1ef9\u1ef9\u1f00\u1f07\u1f10\u1f15\u1f20\u1f27\u1f30\u1f37\u1f40\u1f45\u1f50\u1f57\u1f60\u1f67\u1f70\u1f7d\u1f80\u1f87\u1f90\u1f97\u1fa0\u1fa7\u1fb0\u1fb4\u1fb6\u1fb7\u1fbe\u1fbe\u1fc2\u1fc4\u1fc6\u1fc7\u1fd0\u1fd3\u1fd6\u1fd7\u1fe0\u1fe7\u1ff2\u1ff4\u1ff6\u1ff7\u207f\u207f\u210a\u210a\u210e\u210f\u2113\u2113\u212f\u212f\u2134\u2134\u2139\u2139\ufb00\ufb06\ufb13\ufb17\uff41\uff5a"}, {"Lu", "AZ\u00c0\u00d6\u00d8\u00de\u0100\u0100\u0102\u0102\u0104\u0104\u0106\u0106\u0108\u0108\u010a\u010a\u010c\u010c\u010e\u010e\u0110\u0110\u0112\u0112\u0114\u0114\u0116\u0116\u0118\u0118\u011a\u011a\u011c\u011c\u011e\u011e\u0120\u0120\u0122\u0122\u0124\u0124\u0126\u0126\u0128\u0128\u012a\u012a\u012c\u012c\u012e\u012e\u0130\u0130\u0132\u0132\u0134\u0134\u0136\u0136\u0139\u0139\u013b\u013b\u013d\u013d\u013f\u013f\u0141\u0141\u0143\u0143\u0145\u0145\u0147\u0147\u014a\u014a\u014c\u014c\u014e\u014e\u0150\u0150\u0152\u0152\u0154\u0154\u0156\u0156\u0158\u0158\u015a\u015a\u015c\u015c\u015e\u015e\u0160\u0160\u0162\u0162\u0164\u0164\u0166\u0166\u0168\u0168\u016a\u016a\u016c\u016c\u016e\u016e\u0170\u0170\u0172\u0172\u0174\u0174\u0176\u0176\u0178\u0179\u017b\u017b\u017d\u017d\u0181\u0182\u0184\u0184\u0186\u0187\u0189\u018b\u018e\u0191\u0193\u0194\u0196\u0198\u019c\u019d\u019f\u01a0\u01a2\u01a2\u01a4\u01a4\u01a6\u01a7\u01a9\u01a9\u01ac\u01ac\u01ae\u01af\u01b1\u01b3\u01b5\u01b5\u01b7\u01b8\u01bc\u01bc\u01c4\u01c4\u01c7\u01c7\u01ca\u01ca\u01cd\u01cd\u01cf\u01cf\u01d1\u01d1\u01d3\u01d3\u01d5\u01d5\u01d7\u01d7\u01d9\u01d9\u01db\u01db\u01de\u01de\u01e0\u01e0\u01e2\u01e2\u01e4\u01e4\u01e6\u01e6\u01e8\u01e8\u01ea\u01ea\u01ec\u01ec\u01ee\u01ee\u01f1\u01f1\u01f4\u01f4\u01f6\u01f8\u01fa\u01fa\u01fc\u01fc\u01fe\u01fe\u0200\u0200\u0202\u0202\u0204\u0204\u0206\u0206\u0208\u0208\u020a\u020a\u020c\u020c\u020e\u020e\u0210\u0210\u0212\u0212\u0214\u0214\u0216\u0216\u0218\u0218\u021a\u021a\u021c\u021c\u021e\u021e\u0222\u0222\u0224\u0224\u0226\u0226\u0228\u0228\u022a\u022a\u022c\u022c\u022e\u022e\u0230\u0230\u0232\u0232\u0386\u0386\u0388\u038a\u038c\u038c\u038e\u038f\u0391\u03a1\u03a3\u03ab\u03d2\u03d4\u03da\u03da\u03dc\u03dc\u03de\u03de\u03e0\u03e0\u03e2\u03e2\u03e4\u03e4\u03e6\u03e6\u03e8\u03e8\u03ea\u03ea\u03ec\u03ec\u03ee\u03ee\u0400\u042f\u0460\u0460\u0462\u0462\u0464\u0464\u0466\u0466\u0468\u0468\u046a\u046a\u046c\u046c\u046e\u046e\u0470\u0470\u0472\u0472\u0474\u0474\u0476\u0476\u0478\u0478\u047a\u047a\u047c\u047c\u047e\u047e\u0480\u0480\u048c\u048c\u048e\u048e\u0490\u0490\u0492\u0492\u0494\u0494\u0496\u0496\u0498\u0498\u049a\u049a\u049c\u049c\u049e\u049e\u04a0\u04a0\u04a2\u04a2\u04a4\u04a4\u04a6\u04a6\u04a8\u04a8\u04aa\u04aa\u04ac\u04ac\u04ae\u04ae\u04b0\u04b0\u04b2\u04b2\u04b4\u04b4\u04b6\u04b6\u04b8\u04b8\u04ba\u04ba\u04bc\u04bc\u04be\u04be\u04c0\u04c1\u04c3\u04c3\u04c7\u04c7\u04cb\u04cb\u04d0\u04d0\u04d2\u04d2\u04d4\u04d4\u04d6\u04d6\u04d8\u04d8\u04da\u04da\u04dc\u04dc\u04de\u04de\u04e0\u04e0\u04e2\u04e2\u04e4\u04e4\u04e6\u04e6\u04e8\u04e8\u04ea\u04ea\u04ec\u04ec\u04ee\u04ee\u04f0\u04f0\u04f2\u04f2\u04f4\u04f4\u04f8\u04f8\u0531\u0556\u10a0\u10c5\u1e00\u1e00\u1e02\u1e02\u1e04\u1e04\u1e06\u1e06\u1e08\u1e08\u1e0a\u1e0a\u1e0c\u1e0c\u1e0e\u1e0e\u1e10\u1e10\u1e12\u1e12\u1e14\u1e14\u1e16\u1e16\u1e18\u1e18\u1e1a\u1e1a\u1e1c\u1e1c\u1e1e\u1e1e\u1e20\u1e20\u1e22\u1e22\u1e24\u1e24\u1e26\u1e26\u1e28\u1e28\u1e2a\u1e2a\u1e2c\u1e2c\u1e2e\u1e2e\u1e30\u1e30\u1e32\u1e32\u1e34\u1e34\u1e36\u1e36\u1e38\u1e38\u1e3a\u1e3a\u1e3c\u1e3c\u1e3e\u1e3e\u1e40\u1e40\u1e42\u1e42\u1e44\u1e44\u1e46\u1e46\u1e48\u1e48\u1e4a\u1e4a\u1e4c\u1e4c\u1e4e\u1e4e\u1e50\u1e50\u1e52\u1e52\u1e54\u1e54\u1e56\u1e56\u1e58\u1e58\u1e5a\u1e5a\u1e5c\u1e5c\u1e5e\u1e5e\u1e60\u1e60\u1e62\u1e62\u1e64\u1e64\u1e66\u1e66\u1e68\u1e68\u1e6a\u1e6a\u1e6c\u1e6c\u1e6e\u1e6e\u1e70\u1e70\u1e72\u1e72\u1e74\u1e74\u1e76\u1e76\u1e78\u1e78\u1e7a\u1e7a\u1e7c\u1e7c\u1e7e\u1e7e\u1e80\u1e80\u1e82\u1e82\u1e84\u1e84\u1e86\u1e86\u1e88\u1e88\u1e8a\u1e8a\u1e8c\u1e8c\u1e8e\u1e8e\u1e90\u1e90\u1e92\u1e92\u1e94\u1e94\u1ea0\u1ea0\u1ea2\u1ea2\u1ea4\u1ea4\u1ea6\u1ea6\u1ea8\u1ea8\u1eaa\u1eaa\u1eac\u1eac\u1eae\u1eae\u1eb0\u1eb0\u1eb2\u1eb2\u1eb4\u1eb4\u1eb6\u1eb6\u1eb8\u1eb8\u1eba\u1eba\u1ebc\u1ebc\u1ebe\u1ebe\u1ec0\u1ec0\u1ec2\u1ec2\u1ec4\u1ec4\u1ec6\u1ec6\u1ec8\u1ec8\u1eca\u1eca\u1ecc\u1ecc\u1ece\u1ece\u1ed0\u1ed0\u1ed2\u1ed2\u1ed4\u1ed4\u1ed6\u1ed6\u1ed8\u1ed8\u1eda\u1eda\u1edc\u1edc\u1ede\u1ede\u1ee0\u1ee0\u1ee2\u1ee2\u1ee4\u1ee4\u1ee6\u1ee6\u1ee8\u1ee8\u1eea\u1eea\u1eec\u1eec\u1eee\u1eee\u1ef0\u1ef0\u1ef2\u1ef2\u1ef4\u1ef4\u1ef6\u1ef6\u1ef8\u1ef8\u1f08\u1f0f\u1f18\u1f1d\u1f28\u1f2f\u1f38\u1f3f\u1f48\u1f4d\u1f59\u1f59\u1f5b\u1f5b\u1f5d\u1f5d\u1f5f\u1f5f\u1f68\u1f6f\u1fb8\u1fbb\u1fc8\u1fcb\u1fd8\u1fdb\u1fe8\u1fec\u1ff8\u1ffb\u2102\u2102\u2107\u2107\u210b\u210d\u2110\u2112\u2115\u2115\u2119\u211d\u2124\u2124\u2126\u2126\u2128\u2128\u212a\u212d\u2130\u2131\u2133\u2133\uff21\uff3a"}, {"Lt", "\u01c5\u01c5\u01c8\u01c8\u01cb\u01cb\u01f2\u01f2\u1f88\u1f8f\u1f98\u1f9f\u1fa8\u1faf\u1fbc\u1fbc\u1fcc\u1fcc\u1ffc\u1ffc"}, {"Lo", "\u01bb\u01bb\u01c0\u01c3\u05d0\u05ea\u05f0\u05f2\u0621\u063a\u0641\u064a\u0671\u06d3\u06d5\u06d5\u06fa\u06fc\u0710\u0710\u0712\u072c\u0780\u07a5\u0905\u0939\u093d\u093d\u0950\u0950\u0958\u0961\u0985\u098c\u098f\u0990\u0993\u09a8\u09aa\u09b0\u09b2\u09b2\u09b6\u09b9\u09dc\u09dd\u09df\u09e1\u09f0\u09f1\u0a05\u0a0a\u0a0f\u0a10\u0a13\u0a28\u0a2a\u0a30\u0a32\u0a33\u0a35\u0a36\u0a38\u0a39\u0a59\u0a5c\u0a5e\u0a5e\u0a72\u0a74\u0a85\u0a8b\u0a8d\u0a8d\u0a8f\u0a91\u0a93\u0aa8\u0aaa\u0ab0\u0ab2\u0ab3\u0ab5\u0ab9\u0abd\u0abd\u0ad0\u0ad0\u0ae0\u0ae0\u0b05\u0b0c\u0b0f\u0b10\u0b13\u0b28\u0b2a\u0b30\u0b32\u0b33\u0b36\u0b39\u0b3d\u0b3d\u0b5c\u0b5d\u0b5f\u0b61\u0b85\u0b8a\u0b8e\u0b90\u0b92\u0b95\u0b99\u0b9a\u0b9c\u0b9c\u0b9e\u0b9f\u0ba3\u0ba4\u0ba8\u0baa\u0bae\u0bb5\u0bb7\u0bb9\u0c05\u0c0c\u0c0e\u0c10\u0c12\u0c28\u0c2a\u0c33\u0c35\u0c39\u0c60\u0c61\u0c85\u0c8c\u0c8e\u0c90\u0c92\u0ca8\u0caa\u0cb3\u0cb5\u0cb9\u0cde\u0cde\u0ce0\u0ce1\u0d05\u0d0c\u0d0e\u0d10\u0d12\u0d28\u0d2a\u0d39\u0d60\u0d61\u0d85\u0d96\u0d9a\u0db1\u0db3\u0dbb\u0dbd\u0dbd\u0dc0\u0dc6\u0e01\u0e30\u0e32\u0e33\u0e40\u0e45\u0e81\u0e82\u0e84\u0e84\u0e87\u0e88\u0e8a\u0e8a\u0e8d\u0e8d\u0e94\u0e97\u0e99\u0e9f\u0ea1\u0ea3\u0ea5\u0ea5\u0ea7\u0ea7\u0eaa\u0eab\u0ead\u0eb0\u0eb2\u0eb3\u0ebd\u0ebd\u0ec0\u0ec4\u0edc\u0edd\u0f00\u0f00\u0f40\u0f47\u0f49\u0f6a\u0f88\u0f8b\u1000\u1021\u1023\u1027\u1029\u102a\u1050\u1055\u10d0\u10f6\u1100\u1159\u115f\u11a2\u11a8\u11f9\u1200\u1206\u1208\u1246\u1248\u1248\u124a\u124d\u1250\u1256\u1258\u1258\u125a\u125d\u1260\u1286\u1288\u1288\u128a\u128d\u1290\u12ae\u12b0\u12b0\u12b2\u12b5\u12b8\u12be\u12c0\u12c0\u12c2\u12c5\u12c8\u12ce\u12d0\u12d6\u12d8\u12ee\u12f0\u130e\u1310\u1310\u1312\u1315\u1318\u131e\u1320\u1346\u1348\u135a\u13a0\u13f4\u1401\u166c\u166f\u1676\u1681\u169a\u16a0\u16ea\u1780\u17b3\u1820\u1842\u1844\u1877\u1880\u18a8\u2135\u2138\u3006\u3006\u3041\u3094\u30a1\u30fa\u3105\u312c\u3131\u318e\u31a0\u31b7\u3400\u4db5\u4e00\u9fa5\ua000\ua48c\uac00\ud7a3\uf900\ufa2d\ufb1d\ufb1d\ufb1f\ufb28\ufb2a\ufb36\ufb38\ufb3c\ufb3e\ufb3e\ufb40\ufb41\ufb43\ufb44\ufb46\ufbb1\ufbd3\ufd3d\ufd50\ufd8f\ufd92\ufdc7\ufdf0\ufdfb\ufe70\ufe72\ufe74\ufe74\ufe76\ufefc\uff66\uff6f\uff71\uff9d\uffa0\uffbe\uffc2\uffc7\uffca\uffcf\uffd2\uffd7\uffda\uffdc"}, {"Lm", "\u02b0\u02b8\u02bb\u02c1\u02d0\u02d1\u02e0\u02e4\u02ee\u02ee\u037a\u037a\u0559\u0559\u0640\u0640\u06e5\u06e6\u0e46\u0e46\u0ec6\u0ec6\u1843\u1843\u3005\u3005\u3031\u3035\u309d\u309e\u30fc\u30fe\uff70\uff70\uff9e\uff9f"}, {"Nd", "09\u0660\u0669\u06f0\u06f9\u0966\u096f\u09e6\u09ef\u0a66\u0a6f\u0ae6\u0aef\u0b66\u0b6f\u0be7\u0bef\u0c66\u0c6f\u0ce6\u0cef\u0d66\u0d6f\u0e50\u0e59\u0ed0\u0ed9\u0f20\u0f29\u1040\u1049\u1369\u1371\u17e0\u17e9\u1810\u1819\uff10\uff19"}, {"Nl", "\u2160\u2183\u3007\u3007\u3021\u3029\u3038\u303a"}, {"No", "\u00b2\u00b3\u00b9\u00b9\u00bc\u00be\u09f4\u09f9\u0bf0\u0bf2\u0f2a\u0f33\u1372\u137c\u16ee\u16f0\u2070\u2070\u2074\u2079\u2080\u2089\u2153\u215f\u2460\u249b\u24ea\u24ea\u2776\u2793\u3192\u3195\u3220\u3229\u3280\u3289"}, {"Ps", "(([[{{\u0f3a\u0f3a\u0f3c\u0f3c\u169b\u169b\u201a\u201a\u201e\u201e\u2045\u2045\u207d\u207d\u208d\u208d\u2329\u2329\u3008\u3008\u300a\u300a\u300c\u300c\u300e\u300e\u3010\u3010\u3014\u3014\u3016\u3016\u3018\u3018\u301a\u301a\u301d\u301d\ufd3e\ufd3e\ufe35\ufe35\ufe37\ufe37\ufe39\ufe39\ufe3b\ufe3b\ufe3d\ufe3d\ufe3f\ufe3f\ufe41\ufe41\ufe43\ufe43\ufe59\ufe59\ufe5b\ufe5b\ufe5d\ufe5d\uff08\uff08\uff3b\uff3b\uff5b\uff5b\uff62\uff62"}, {"Pe", "))]]}}\u0f3b\u0f3b\u0f3d\u0f3d\u169c\u169c\u2046\u2046\u207e\u207e\u208e\u208e\u232a\u232a\u3009\u3009\u300b\u300b\u300d\u300d\u300f\u300f\u3011\u3011\u3015\u3015\u3017\u3017\u3019\u3019\u301b\u301b\u301e\u301f\ufd3f\ufd3f\ufe36\ufe36\ufe38\ufe38\ufe3a\ufe3a\ufe3c\ufe3c\ufe3e\ufe3e\ufe40\ufe40\ufe42\ufe42\ufe44\ufe44\ufe5a\ufe5a\ufe5c\ufe5c\ufe5e\ufe5e\uff09\uff09\uff3d\uff3d\uff5d\uff5d\uff63\uff63"}, {"Pi", "\u00ab\u00ab\u2018\u2018\u201b\u201c\u201f\u201f\u2039\u2039"}, {"Pf", "\u00bb\u00bb\u2019\u2019\u201d\u201d\u203a\u203a"}, {"Pd", "--\u00ad\u00ad\u058a\u058a\u1806\u1806\u2010\u2015\u301c\u301c\u3030\u3030\ufe31\ufe32\ufe58\ufe58\ufe63\ufe63\uff0d\uff0d"}, {"Pc", "__\u203f\u2040\u30fb\u30fb\ufe33\ufe34\ufe4d\ufe4f\uff3f\uff3f\uff65\uff65"}, {"Po", "!#%'**,,./:;?@\\\\\u00a1\u00a1\u00b7\u00b7\u00bf\u00bf\u037e\u037e\u0387\u0387\u055a\u055f\u0589\u0589\u05be\u05be\u05c0\u05c0\u05c3\u05c3\u05f3\u05f4\u060c\u060c\u061b\u061b\u061f\u061f\u066a\u066d\u06d4\u06d4\u0700\u070d\u0964\u0965\u0970\u0970\u0df4\u0df4\u0e4f\u0e4f\u0e5a\u0e5b\u0f04\u0f12\u0f85\u0f85\u104a\u104f\u10fb\u10fb\u1361\u1368\u166d\u166e\u16eb\u16ed\u17d4\u17da\u17dc\u17dc\u1800\u1805\u1807\u180a\u2016\u2017\u2020\u2027\u2030\u2038\u203b\u203e\u2041\u2043\u2048\u204d\u3001\u3003\ufe30\ufe30\ufe49\ufe4c\ufe50\ufe52\ufe54\ufe57\ufe5f\ufe61\ufe68\ufe68\ufe6a\ufe6b\uff01\uff03\uff05\uff07\uff0a\uff0a\uff0c\uff0c\uff0e\uff0f\uff1a\uff1b\uff1f\uff20\uff3c\uff3c\uff61\uff61\uff64\uff64"}, {"Sc", "$$\u00a2\u00a5\u09f2\u09f3\u0e3f\u0e3f\u17db\u17db\u20a0\u20af\ufe69\ufe69\uff04\uff04\uffe0\uffe1\uffe5\uffe6"}, {"Sm", "++<>||~~\u00ac\u00ac\u00b1\u00b1\u00d7\u00d7\u00f7\u00f7\u2044\u2044\u207a\u207c\u208a\u208c\u2190\u2194\u219a\u219b\u21a0\u21a0\u21a3\u21a3\u21a6\u21a6\u21ae\u21ae\u21ce\u21cf\u21d2\u21d2\u21d4\u21d4\u2200\u22f1\u2308\u230b\u2320\u2321\u25b7\u25b7\u25c1\u25c1\u266f\u266f\ufb29\ufb29\ufe62\ufe62\ufe64\ufe66\uff0b\uff0b\uff1c\uff1e\uff5c\uff5c\uff5e\uff5e\uffe2\uffe2\uffe9\uffec"}, {"So", "\u00a6\u00a7\u00a9\u00a9\u00ae\u00ae\u00b0\u00b0\u00b6\u00b6\u0482\u0482\u06e9\u06e9\u06fd\u06fe\u09fa\u09fa\u0b70\u0b70\u0f01\u0f03\u0f13\u0f17\u0f1a\u0f1f\u0f34\u0f34\u0f36\u0f36\u0f38\u0f38\u0fbe\u0fc5\u0fc7\u0fcc\u0fcf\u0fcf\u2100\u2101\u2103\u2106\u2108\u2109\u2114\u2114\u2116\u2118\u211e\u2123\u2125\u2125\u2127\u2127\u2129\u2129\u212e\u212e\u2132\u2132\u213a\u213a\u2195\u2199\u219c\u219f\u21a1\u21a2\u21a4\u21a5\u21a7\u21ad\u21af\u21cd\u21d0\u21d1\u21d3\u21d3\u21d5\u21f3\u2300\u2307\u230c\u231f\u2322\u2328\u232b\u237b\u237d\u239a\u2400\u2426\u2440\u244a\u249c\u24e9\u2500\u2595\u25a0\u25b6\u25b8\u25c0\u25c2\u25f7\u2600\u2613\u2619\u266e\u2670\u2671\u2701\u2704\u2706\u2709\u270c\u2727\u2729\u274b\u274d\u274d\u274f\u2752\u2756\u2756\u2758\u275e\u2761\u2767\u2794\u2794\u2798\u27af\u27b1\u27be\u2800\u28ff\u2e80\u2e99\u2e9b\u2ef3\u2f00\u2fd5\u2ff0\u2ffb\u3004\u3004\u3012\u3013\u3020\u3020\u3036\u3037\u303e\u303f\u3190\u3191\u3196\u319f\u3200\u321c\u322a\u3243\u3260\u327b\u327f\u327f\u328a\u32b0\u32c0\u32cb\u32d0\u32fe\u3300\u3376\u337b\u33dd\u33e0\u33fe\ua490\ua4a1\ua4a4\ua4b3\ua4b5\ua4c0\ua4c2\ua4c4\ua4c6\ua4c6\uffe4\uffe4\uffe8\uffe8\uffed\uffee\ufffc\ufffd"}, {"Mn", "\u0300\u034e\u0360\u0362\u0483\u0486\u0591\u05a1\u05a3\u05b9\u05bb\u05bd\u05bf\u05bf\u05c1\u05c2\u05c4\u05c4\u064b\u0655\u0670\u0670\u06d6\u06dc\u06df\u06e4\u06e7\u06e8\u06ea\u06ed\u0711\u0711\u0730\u074a\u07a6\u07b0\u0901\u0902\u093c\u093c\u0941\u0948\u094d\u094d\u0951\u0954\u0962\u0963\u0981\u0981\u09bc\u09bc\u09c1\u09c4\u09cd\u09cd\u09e2\u09e3\u0a02\u0a02\u0a3c\u0a3c\u0a41\u0a42\u0a47\u0a48\u0a4b\u0a4d\u0a70\u0a71\u0a81\u0a82\u0abc\u0abc\u0ac1\u0ac5\u0ac7\u0ac8\u0acd\u0acd\u0b01\u0b01\u0b3c\u0b3c\u0b3f\u0b3f\u0b41\u0b43\u0b4d\u0b4d\u0b56\u0b56\u0b82\u0b82\u0bc0\u0bc0\u0bcd\u0bcd\u0c3e\u0c40\u0c46\u0c48\u0c4a\u0c4d\u0c55\u0c56\u0cbf\u0cbf\u0cc6\u0cc6\u0ccc\u0ccd\u0d41\u0d43\u0d4d\u0d4d\u0dca\u0dca\u0dd2\u0dd4\u0dd6\u0dd6\u0e31\u0e31\u0e34\u0e3a\u0e47\u0e4e\u0eb1\u0eb1\u0eb4\u0eb9\u0ebb\u0ebc\u0ec8\u0ecd\u0f18\u0f19\u0f35\u0f35\u0f37\u0f37\u0f39\u0f39\u0f71\u0f7e\u0f80\u0f84\u0f86\u0f87\u0f90\u0f97\u0f99\u0fbc\u0fc6\u0fc6\u102d\u1030\u1032\u1032\u1036\u1037\u1039\u1039\u1058\u1059\u17b7\u17bd\u17c6\u17c6\u17c9\u17d3\u18a9\u18a9\u20d0\u20dc\u20e1\u20e1\u302a\u302f\u3099\u309a\ufb1e\ufb1e\ufe20\ufe23"}, {"Mc", "\u0903\u0903\u093e\u0940\u0949\u094c\u0982\u0983\u09be\u09c0\u09c7\u09c8\u09cb\u09cc\u09d7\u09d7\u0a3e\u0a40\u0a83\u0a83\u0abe\u0ac0\u0ac9\u0ac9\u0acb\u0acc\u0b02\u0b03\u0b3e\u0b3e\u0b40\u0b40\u0b47\u0b48\u0b4b\u0b4c\u0b57\u0b57\u0b83\u0b83\u0bbe\u0bbf\u0bc1\u0bc2\u0bc6\u0bc8\u0bca\u0bcc\u0bd7\u0bd7\u0c01\u0c03\u0c41\u0c44\u0c82\u0c83\u0cbe\u0cbe\u0cc0\u0cc4\u0cc7\u0cc8\u0cca\u0ccb\u0cd5\u0cd6\u0d02\u0d03\u0d3e\u0d40\u0d46\u0d48\u0d4a\u0d4c\u0d57\u0d57\u0d82\u0d83\u0dcf\u0dd1\u0dd8\u0ddf\u0df2\u0df3\u0f3e\u0f3f\u0f7f\u0f7f\u102c\u102c\u1031\u1031\u1038\u1038\u1056\u1057\u17b4\u17b6\u17be\u17c5\u17c7\u17c8"}, {"Me", "\u0488\u0489\u06dd\u06de\u20dd\u20e0\u20e2\u20e3"}, {"Zl", "\u2028\u2028"}, {"Zp", "\u2029\u2029"}, {"Zs", "  \u00a0\u00a0\u1680\u1680\u2000\u200b\u202f\u202f\u3000\u3000"}, {"Cc", "\u0000\u001f\u007f\u009f"}, {"Cf", "\u070f\u070f\u180b\u180e\u200c\u200f\u202a\u202e\u206a\u206f\ufeff\ufeff\ufff9\ufffb"}};

    public static CharSet parseString(String string) {
        CharSet charSet = null;
        if (expressionCache != null) {
            charSet = (CharSet)expressionCache.get(string);
        }
        if (charSet == null) {
            charSet = CharSet.doParseString(string);
            if (expressionCache == null) {
                expressionCache = new Hashtable();
            }
            expressionCache.put(string, charSet);
        }
        charSet = (CharSet)charSet.clone();
        return charSet;
    }

    private static CharSet doParseString(String string) {
        CharSet charSet = new CharSet();
        int n = 0;
        boolean bl = false;
        boolean bl2 = false;
        boolean bl3 = false;
        char c2 = '\u0000';
        while (n < string.length()) {
            int n2;
            char c3 = string.charAt(n);
            if (c3 == '[') {
                if (bl3) {
                    charSet.internalUnion(new CharSet(c2));
                }
                n2 = 1;
                int n3 = n + 1;
                while (n2 != 0) {
                    if (n3 >= string.length()) {
                        throw new IllegalArgumentException(Msg.getString("K0010", Integer.toString(n), string));
                    }
                    switch (string.charAt(n3)) {
                        case '\\': {
                            ++n3;
                            break;
                        }
                        case '[': {
                            ++n2;
                            break;
                        }
                        case ']': {
                            --n2;
                        }
                    }
                    ++n3;
                }
                --n3;
                if (!bl2) {
                    charSet.internalUnion(CharSet.parseString(string.substring(n + 1, n3)));
                } else {
                    charSet.internalDifference(CharSet.parseString(string.substring(n + 1, n3)));
                }
                bl2 = false;
                bl = false;
                bl3 = false;
                n = n3 + 1;
                continue;
            }
            if (c3 == ':') {
                if (bl3) {
                    charSet.internalUnion(new CharSet(c2));
                }
                if ((n2 = string.indexOf(58, n + 1)) == -1) {
                    throw new IllegalArgumentException(Msg.getString("K0010", Integer.toString(n), string));
                }
                if (!bl2) {
                    charSet.internalUnion(CharSet.charSetForCategory(string.substring(n + 1, n2)));
                } else {
                    charSet.internalDifference(CharSet.charSetForCategory(string.substring(n + 1, n2)));
                }
                bl2 = false;
                bl = false;
                bl3 = false;
                n = n2 + 1;
                continue;
            }
            if (c3 == '-') {
                if (bl3) {
                    bl = true;
                }
                ++n;
                continue;
            }
            if (c3 == '^') {
                if (bl3) {
                    charSet.internalUnion(new CharSet(c2));
                    bl3 = false;
                }
                bl2 = true;
                ++n;
                if (!charSet.empty()) continue;
                charSet.internalComplement();
                continue;
            }
            if (c3 >= ' ' && c3 < '\u007f' && !Character.isLetter(c3) && !Character.isDigit(c3) && c3 != '\\') {
                throw new IllegalArgumentException(Msg.getString("K0010", Integer.toString(n), string));
            }
            if (c3 == '\\') {
                ++n;
            }
            if (bl) {
                if (string.charAt(n) < c2) {
                    throw new IllegalArgumentException(Msg.getString("K0011", Integer.toHexString(string.charAt(n)), Integer.toHexString(c2)));
                }
                if (!bl2) {
                    charSet.internalUnion(new CharSet(c2, string.charAt(n++)));
                } else {
                    charSet.internalDifference(new CharSet(c2, string.charAt(n++)));
                }
                bl = false;
                bl2 = false;
                bl3 = false;
                continue;
            }
            if (bl2) {
                charSet.internalDifference(new CharSet(string.charAt(n++)));
                bl2 = false;
                bl3 = false;
                continue;
            }
            if (bl3) {
                charSet.internalUnion(new CharSet(c2));
                c2 = string.charAt(n++);
                bl3 = true;
                continue;
            }
            c2 = string.charAt(n++);
            bl3 = true;
        }
        if (bl3) {
            charSet.internalUnion(new CharSet(c2));
        }
        return charSet;
    }

    private static CharSet charSetForCategory(String string) {
        if (string.length() == 0 || string.length() >= 3) {
            throw new IllegalArgumentException(Msg.getString("K0012", string));
        }
        if (string.length() == 2) {
            int n = 0;
            while (n < categoryMap.length) {
                if (categoryMap[n][0].equals(string)) {
                    return new CharSet(categoryMap[n][1]);
                }
                ++n;
            }
            throw new IllegalArgumentException(Msg.getString("K0012", string));
        }
        if (string.length() == 1) {
            CharSet charSet = new CharSet();
            int n = 0;
            while (n < categoryMap.length) {
                if (categoryMap[n][0].startsWith(string)) {
                    charSet = charSet.union(new CharSet(categoryMap[n][1]));
                }
                ++n;
            }
            if (charSet.empty()) {
                throw new IllegalArgumentException(Msg.getString("K0012", string));
            }
            return charSet;
        }
        return new CharSet();
    }

    public static Hashtable releaseExpressionCache() {
        Hashtable hashtable = expressionCache;
        expressionCache = null;
        return hashtable;
    }

    public CharSet() {
        this.chars = "";
    }

    public CharSet(char c2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(c2);
        stringBuffer.append(c2);
        this.chars = stringBuffer.toString();
    }

    public CharSet(char c2, char c3) {
        StringBuffer stringBuffer = new StringBuffer();
        if (c2 <= c3) {
            stringBuffer.append(c2);
            stringBuffer.append(c3);
        } else {
            stringBuffer.append(c3);
            stringBuffer.append(c2);
        }
        this.chars = stringBuffer.toString();
    }

    private CharSet(String string) {
        this.chars = string;
    }

    public CharSet union(CharSet charSet) {
        return new CharSet(this.doUnion(charSet.chars).toString());
    }

    private void internalUnion(CharSet charSet) {
        this.chars = this.doUnion(charSet.chars).toString();
    }

    /*
     * Unable to fully structure code
     */
    private StringBuffer doUnion(String var1_1) {
        var2_2 = new StringBuffer();
        var3_3 = 0;
        var4_4 = 0;
        while (var3_3 < this.chars.length() && var4_4 < var1_1.length()) {
            if (this.chars.charAt(var3_3) < var1_1.charAt(var4_4)) {
                var2_2.append(this.chars.charAt(var3_3));
                var5_5 = this.chars.charAt(++var3_3);
            } else {
                var2_2.append(var1_1.charAt(var4_4));
                var5_5 = var1_1.charAt(++var4_4);
            }
            ** GOTO lbl30
            {
                ++var3_3;
                do {
                    if (var3_3 < this.chars.length() && this.chars.charAt(var3_3) <= var5_5 + '\u0001') continue block1;
                    if (var3_3 % 2 == 1) {
                        var5_5 = this.chars.charAt(var3_3);
                    } else if (var3_3 > 0 && this.chars.charAt(var3_3 - 1) > var5_5) {
                        var5_5 = this.chars.charAt(var3_3 - 1);
                    }
                    while (var4_4 < var1_1.length() && var1_1.charAt(var4_4) <= var5_5 + '\u0001') {
                        ++var4_4;
                    }
                    if (var4_4 % 2 == 1) {
                        var5_5 = var1_1.charAt(var4_4);
                        continue;
                    }
                    if (var4_4 <= 0 || var1_1.charAt(var4_4 - 1) <= var5_5) continue;
                    var5_5 = var1_1.charAt(var4_4 - 1);
lbl30:
                    // 5 sources

                } while (var3_3 % 2 == 1 || var4_4 % 2 == 1 || var3_3 < this.chars.length() && this.chars.charAt(var3_3) <= var5_5 + '\u0001');
            }
            var2_2.append(var5_5);
        }
        if (var3_3 < this.chars.length()) {
            var2_2.append(this.chars.substring(var3_3));
        }
        if (var4_4 < var1_1.length()) {
            var2_2.append(var1_1.substring(var4_4));
        }
        return var2_2;
    }

    public CharSet intersection(CharSet charSet) {
        return new CharSet(this.doIntersection(charSet.chars).toString());
    }

    private void internalIntersection(CharSet charSet) {
        this.chars = this.doIntersection(charSet.chars).toString();
    }

    private StringBuffer doIntersection(String string) {
        StringBuffer stringBuffer = new StringBuffer();
        int n = 0;
        int n2 = 0;
        while (n < this.chars.length() && n2 < string.length()) {
            if (n < this.chars.length() && n % 2 == 0) {
                while (n2 < string.length() && string.charAt(n2) < this.chars.charAt(n)) {
                    ++n2;
                }
                if (n2 < string.length() && n2 % 2 == 0 && string.charAt(n2) == this.chars.charAt(n)) {
                    ++n2;
                }
            }
            int n3 = n;
            while (n2 % 2 == 1 && n < this.chars.length() && this.chars.charAt(n) <= string.charAt(n2)) {
                ++n;
            }
            stringBuffer.append(this.chars.substring(n3, n));
            int n4 = n2;
            while (n % 2 == 1 && n2 < string.length() && string.charAt(n2) <= this.chars.charAt(n)) {
                ++n2;
            }
            stringBuffer.append(string.substring(n4, n2));
            if (n2 >= string.length() || n2 % 2 != 0) continue;
            while (n < this.chars.length() && this.chars.charAt(n) < string.charAt(n2)) {
                ++n;
            }
            if (n >= this.chars.length() || n % 2 != 0 || string.charAt(n2) != this.chars.charAt(n)) continue;
            ++n;
        }
        return stringBuffer;
    }

    public CharSet difference(CharSet charSet) {
        return new CharSet(this.doIntersection(charSet.doComplement().toString()).toString());
    }

    private void internalDifference(CharSet charSet) {
        this.chars = this.doIntersection(charSet.doComplement().toString()).toString();
    }

    public CharSet complement() {
        return new CharSet(this.doComplement().toString());
    }

    private void internalComplement() {
        this.chars = this.doComplement().toString();
    }

    private StringBuffer doComplement() {
        if (this.empty()) {
            return new StringBuffer("\u0000\uffff");
        }
        StringBuffer stringBuffer = new StringBuffer();
        int n = 0;
        if (this.chars.charAt(0) != '\u0000') {
            stringBuffer.append('\u0000');
        }
        while (n < this.chars.length()) {
            if (this.chars.charAt(n) != '\u0000') {
                stringBuffer.append((char)(this.chars.charAt(n) - '\u0001'));
            }
            if (this.chars.charAt(n + 1) != '\uffff0000') {
                stringBuffer.append((char)(this.chars.charAt(n + 1) + '\u0001'));
            }
            n += 2;
        }
        if (this.chars.charAt(this.chars.length() - 1) != '\uffff0000') {
            stringBuffer.append('\uffff0000');
        }
        return stringBuffer;
    }

    public boolean contains(char c2) {
        int n = 1;
        while (n < this.chars.length() && this.chars.charAt(n) < c2) {
            n += 2;
        }
        if (n == this.chars.length()) {
            return false;
        }
        return this.chars.charAt(n - 1) <= c2;
    }

    public boolean equals(Object object) {
        return object instanceof CharSet && this.chars.equals(((CharSet)object).chars);
    }

    public Object clone() {
        return new CharSet(this.chars);
    }

    public boolean empty() {
        return this.chars.length() == 0;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('[');
        int n = 0;
        while (n < this.chars.length()) {
            if (this.chars.charAt(n) == this.chars.charAt(n + 1)) {
                stringBuffer.append(this.chars.charAt(n));
            } else {
                stringBuffer.append(new StringBuffer(String.valueOf(this.chars.charAt(n))).append("-").append(this.chars.charAt(n + 1)).toString());
            }
            n += 2;
        }
        stringBuffer.append(']');
        return stringBuffer.toString();
    }

    public String getRanges() {
        return this.chars;
    }

    public CharSet$Enumeration getChars() {
        return new CharSet$Enumeration(this, this);
    }

    static /* synthetic */ String access$0(CharSet charSet) {
        return charSet.chars;
    }
}

