/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.japan;

public final class RomajiFreeTextConverter {
    public static final int CONVERSION_FULL_MATCH_KANAS;
    public static final int CONVERSION_VALID_ROMAJI_INDEX;
    private static final String STRING_AEIOU;
    private static final String STRING_AEIOUY;
    private static final String STRING_ALL_CHARS;

    public static void convertRomajis(String string, String[] stringArray) {
        String string2 = "abcdefghijklmnopqrstuvwxyz";
        String string3 = null;
        int n = string.length();
        if (n > 0) {
            block0 : switch (string.charAt(0)) {
                case 'A': {
                    string3 = "\u3042";
                    break;
                }
                case 'B': {
                    if (n > 1) {
                        switch (string.charAt(1)) {
                            case 'A': {
                                string3 = "\u3070";
                                break block0;
                            }
                            case 'B': {
                                if (n > 2) {
                                    switch (string.charAt(2)) {
                                        case 'A': {
                                            string3 = "\u3063\u3070";
                                            break block0;
                                        }
                                        case 'E': {
                                            string3 = "\u3063\u3079";
                                            break block0;
                                        }
                                        case 'I': {
                                            string3 = "\u3063\u3073";
                                            break block0;
                                        }
                                        case 'O': {
                                            string3 = "\u3063\u307c";
                                            break block0;
                                        }
                                        case 'U': {
                                            string3 = "\u3063\u3076";
                                            break block0;
                                        }
                                        case 'Y': {
                                            if (n > 3) {
                                                switch (string.charAt(3)) {
                                                    case 'A': {
                                                        string3 = "\u3063\u3073\u3083";
                                                        break block0;
                                                    }
                                                    case 'E': {
                                                        string3 = "\u3063\u3073\u3047";
                                                        break block0;
                                                    }
                                                    case 'I': {
                                                        string3 = "\u3063\u3073\u3043";
                                                        break block0;
                                                    }
                                                    case 'O': {
                                                        string3 = "\u3063\u3073\u3087";
                                                        break block0;
                                                    }
                                                    case 'U': {
                                                        string3 = "\u3063\u3073\u3085";
                                                        break block0;
                                                    }
                                                }
                                                break block0;
                                            }
                                            string2 = "aeiou";
                                            break block0;
                                        }
                                    }
                                    break block0;
                                }
                                string2 = "aeiouy";
                                break block0;
                            }
                            case 'E': {
                                string3 = "\u3079";
                                break block0;
                            }
                            case 'I': {
                                string3 = "\u3073";
                                break block0;
                            }
                            case 'O': {
                                string3 = "\u307c";
                                break block0;
                            }
                            case 'U': {
                                string3 = "\u3076";
                                break block0;
                            }
                            case 'Y': {
                                if (n > 2) {
                                    switch (string.charAt(2)) {
                                        case 'A': {
                                            string3 = "\u3073\u3083";
                                            break block0;
                                        }
                                        case 'E': {
                                            string3 = "\u3073\u3047";
                                            break block0;
                                        }
                                        case 'I': {
                                            string3 = "\u3073\u3043";
                                            break block0;
                                        }
                                        case 'O': {
                                            string3 = "\u3073\u3087";
                                            break block0;
                                        }
                                        case 'U': {
                                            string3 = "\u3073\u3085";
                                            break block0;
                                        }
                                    }
                                    break block0;
                                }
                                string2 = "aeiou";
                                break block0;
                            }
                        }
                        break;
                    }
                    string2 = "abeiouy";
                    break;
                }
                case 'C': {
                    if (n > 1) {
                        switch (string.charAt(1)) {
                            case 'A': {
                                string3 = "\u304b";
                                break block0;
                            }
                            case 'C': {
                                if (n > 2) {
                                    switch (string.charAt(2)) {
                                        case 'A': {
                                            string3 = "\u3063\u304b";
                                            break block0;
                                        }
                                        case 'E': {
                                            string3 = "\u3063\u305b";
                                            break block0;
                                        }
                                        case 'H': {
                                            if (n > 3) {
                                                switch (string.charAt(3)) {
                                                    case 'A': {
                                                        string3 = "\u3063\u3061\u3083";
                                                        break block0;
                                                    }
                                                    case 'E': {
                                                        string3 = "\u3063\u3061\u3047";
                                                        break block0;
                                                    }
                                                    case 'I': {
                                                        string3 = "\u3063\u3061";
                                                        break block0;
                                                    }
                                                    case 'O': {
                                                        string3 = "\u3063\u3061\u3087";
                                                        break block0;
                                                    }
                                                    case 'U': {
                                                        string3 = "\u3063\u3061\u3085";
                                                        break block0;
                                                    }
                                                }
                                                break block0;
                                            }
                                            string2 = "aeiou";
                                            break block0;
                                        }
                                        case 'I': {
                                            string3 = "\u3063\u3057";
                                            break block0;
                                        }
                                        case 'O': {
                                            string3 = "\u3063\u3053";
                                            break block0;
                                        }
                                        case 'U': {
                                            string3 = "\u3063\u304f";
                                            break block0;
                                        }
                                        case 'Y': {
                                            if (n > 3) {
                                                switch (string.charAt(3)) {
                                                    case 'A': {
                                                        string3 = "\u3063\u3061\u3083";
                                                        break block0;
                                                    }
                                                    case 'E': {
                                                        string3 = "\u3063\u3061\u3047";
                                                        break block0;
                                                    }
                                                    case 'I': {
                                                        string3 = "\u3063\u3061\u3043";
                                                        break block0;
                                                    }
                                                    case 'O': {
                                                        string3 = "\u3063\u3061\u3087";
                                                        break block0;
                                                    }
                                                    case 'U': {
                                                        string3 = "\u3063\u3061\u3085";
                                                        break block0;
                                                    }
                                                }
                                                break block0;
                                            }
                                            string2 = "aeiou";
                                            break block0;
                                        }
                                    }
                                    break block0;
                                }
                                string2 = "aehiouy";
                                break block0;
                            }
                            case 'E': {
                                string3 = "\u305b";
                                break block0;
                            }
                            case 'H': {
                                if (n > 2) {
                                    switch (string.charAt(2)) {
                                        case 'A': {
                                            string3 = "\u3061\u3083";
                                            break block0;
                                        }
                                        case 'E': {
                                            string3 = "\u3061\u3047";
                                            break block0;
                                        }
                                        case 'I': {
                                            string3 = "\u3061";
                                            break block0;
                                        }
                                        case 'O': {
                                            string3 = "\u3061\u3087";
                                            break block0;
                                        }
                                        case 'U': {
                                            string3 = "\u3061\u3085";
                                            break block0;
                                        }
                                    }
                                    break block0;
                                }
                                string2 = "aeiou";
                                break block0;
                            }
                            case 'I': {
                                string3 = "\u3057";
                                break block0;
                            }
                            case 'O': {
                                string3 = "\u3053";
                                break block0;
                            }
                            case 'U': {
                                string3 = "\u304f";
                                break block0;
                            }
                            case 'Y': {
                                if (n > 2) {
                                    switch (string.charAt(2)) {
                                        case 'A': {
                                            string3 = "\u3061\u3083";
                                            break block0;
                                        }
                                        case 'E': {
                                            string3 = "\u3061\u3047";
                                            break block0;
                                        }
                                        case 'I': {
                                            string3 = "\u3061\u3043";
                                            break block0;
                                        }
                                        case 'O': {
                                            string3 = "\u3061\u3087";
                                            break block0;
                                        }
                                        case 'U': {
                                            string3 = "\u3061\u3085";
                                            break block0;
                                        }
                                    }
                                    break block0;
                                }
                                string2 = "aeiou";
                                break block0;
                            }
                        }
                        break;
                    }
                    string2 = "acehiouy";
                    break;
                }
                case 'D': {
                    if (n > 1) {
                        switch (string.charAt(1)) {
                            case 'A': {
                                string3 = "\u3060";
                                break block0;
                            }
                            case 'D': {
                                if (n > 2) {
                                    switch (string.charAt(2)) {
                                        case 'A': {
                                            string3 = "\u3063\u3060";
                                            break block0;
                                        }
                                        case 'E': {
                                            string3 = "\u3063\u3067";
                                            break block0;
                                        }
                                        case 'H': {
                                            if (n > 3) {
                                                switch (string.charAt(3)) {
                                                    case 'A': {
                                                        string3 = "\u3063\u3067\u3083";
                                                        break block0;
                                                    }
                                                    case 'E': {
                                                        string3 = "\u3063\u3067\u3047";
                                                        break block0;
                                                    }
                                                    case 'I': {
                                                        string3 = "\u3063\u3067\u3043";
                                                        break block0;
                                                    }
                                                    case 'O': {
                                                        string3 = "\u3063\u3067\u3087";
                                                        break block0;
                                                    }
                                                    case 'U': {
                                                        string3 = "\u3063\u3067\u3085";
                                                        break block0;
                                                    }
                                                }
                                                break block0;
                                            }
                                            string2 = "aeiou";
                                            break block0;
                                        }
                                        case 'I': {
                                            string3 = "\u3063\u3062";
                                            break block0;
                                        }
                                        case 'O': {
                                            string3 = "\u3063\u3069";
                                            break block0;
                                        }
                                        case 'U': {
                                            string3 = "\u3063\u3065";
                                            break block0;
                                        }
                                        case 'W': {
                                            if (n > 3) {
                                                switch (string.charAt(3)) {
                                                    case 'A': {
                                                        string3 = "\u3063\u3069\u3041";
                                                        break block0;
                                                    }
                                                    case 'E': {
                                                        string3 = "\u3063\u3069\u3047";
                                                        break block0;
                                                    }
                                                    case 'I': {
                                                        string3 = "\u3063\u3069\u3043";
                                                        break block0;
                                                    }
                                                    case 'O': {
                                                        string3 = "\u3063\u3069\u3049";
                                                        break block0;
                                                    }
                                                    case 'U': {
                                                        string3 = "\u3063\u3069\u3045";
                                                        break block0;
                                                    }
                                                }
                                                break block0;
                                            }
                                            string2 = "aeiou";
                                            break block0;
                                        }
                                        case 'Y': {
                                            if (n > 3) {
                                                switch (string.charAt(3)) {
                                                    case 'A': {
                                                        string3 = "\u3063\u3062\u3083";
                                                        break block0;
                                                    }
                                                    case 'E': {
                                                        string3 = "\u3063\u3062\u3047";
                                                        break block0;
                                                    }
                                                    case 'I': {
                                                        string3 = "\u3063\u3062\u3043";
                                                        break block0;
                                                    }
                                                    case 'O': {
                                                        string3 = "\u3063\u3062\u3087";
                                                        break block0;
                                                    }
                                                    case 'U': {
                                                        string3 = "\u3063\u3062\u3085";
                                                        break block0;
                                                    }
                                                }
                                                break block0;
                                            }
                                            string2 = "aeiou";
                                            break block0;
                                        }
                                    }
                                    break block0;
                                }
                                string2 = "aehiouwy";
                                break block0;
                            }
                            case 'E': {
                                string3 = "\u3067";
                                break block0;
                            }
                            case 'H': {
                                if (n > 2) {
                                    switch (string.charAt(2)) {
                                        case 'A': {
                                            string3 = "\u3067\u3083";
                                            break block0;
                                        }
                                        case 'E': {
                                            string3 = "\u3067\u3047";
                                            break block0;
                                        }
                                        case 'I': {
                                            string3 = "\u3067\u3043";
                                            break block0;
                                        }
                                        case 'O': {
                                            string3 = "\u3067\u3087";
                                            break block0;
                                        }
                                        case 'U': {
                                            string3 = "\u3067\u3085";
                                            break block0;
                                        }
                                    }
                                    break block0;
                                }
                                string2 = "aeiou";
                                break block0;
                            }
                            case 'I': {
                                string3 = "\u3062";
                                break block0;
                            }
                            case 'O': {
                                string3 = "\u3069";
                                break block0;
                            }
                            case 'U': {
                                string3 = "\u3065";
                                break block0;
                            }
                            case 'W': {
                                if (n > 2) {
                                    switch (string.charAt(2)) {
                                        case 'A': {
                                            string3 = "\u3069\u3041";
                                            break block0;
                                        }
                                        case 'E': {
                                            string3 = "\u3069\u3047";
                                            break block0;
                                        }
                                        case 'I': {
                                            string3 = "\u3069\u3043";
                                            break block0;
                                        }
                                        case 'O': {
                                            string3 = "\u3069\u3049";
                                            break block0;
                                        }
                                        case 'U': {
                                            string3 = "\u3069\u3045";
                                            break block0;
                                        }
                                    }
                                    break block0;
                                }
                                string2 = "aeiou";
                                break block0;
                            }
                            case 'Y': {
                                if (n > 2) {
                                    switch (string.charAt(2)) {
                                        case 'A': {
                                            string3 = "\u3062\u3083";
                                            break block0;
                                        }
                                        case 'E': {
                                            string3 = "\u3062\u3047";
                                            break block0;
                                        }
                                        case 'I': {
                                            string3 = "\u3062\u3043";
                                            break block0;
                                        }
                                        case 'O': {
                                            string3 = "\u3062\u3087";
                                            break block0;
                                        }
                                        case 'U': {
                                            string3 = "\u3062\u3085";
                                            break block0;
                                        }
                                    }
                                    break block0;
                                }
                                string2 = "aeiou";
                                break block0;
                            }
                        }
                        break;
                    }
                    string2 = "adehiouwy";
                    break;
                }
                case 'E': {
                    string3 = "\u3048";
                    break;
                }
                case 'F': {
                    if (n > 1) {
                        switch (string.charAt(1)) {
                            case 'A': {
                                string3 = "\u3075\u3041";
                                break block0;
                            }
                            case 'E': {
                                string3 = "\u3075\u3047";
                                break block0;
                            }
                            case 'F': {
                                if (n > 2) {
                                    switch (string.charAt(2)) {
                                        case 'A': {
                                            string3 = "\u3063\u3075\u3041";
                                            break block0;
                                        }
                                        case 'E': {
                                            string3 = "\u3063\u3075\u3047";
                                            break block0;
                                        }
                                        case 'I': {
                                            string3 = "\u3063\u3075\u3043";
                                            break block0;
                                        }
                                        case 'O': {
                                            string3 = "\u3063\u3075\u3049";
                                            break block0;
                                        }
                                        case 'U': {
                                            string3 = "\u3063\u3075";
                                            break block0;
                                        }
                                        case 'W': {
                                            if (n > 3) {
                                                switch (string.charAt(3)) {
                                                    case 'A': {
                                                        string3 = "\u3063\u3075\u3041";
                                                        break block0;
                                                    }
                                                    case 'E': {
                                                        string3 = "\u3063\u3075\u3047";
                                                        break block0;
                                                    }
                                                    case 'I': {
                                                        string3 = "\u3063\u3075\u3043";
                                                        break block0;
                                                    }
                                                    case 'O': {
                                                        string3 = "\u3063\u3075\u3049";
                                                        break block0;
                                                    }
                                                    case 'U': {
                                                        string3 = "\u3063\u3075\u3045";
                                                        break block0;
                                                    }
                                                }
                                                break block0;
                                            }
                                            string2 = "aeiou";
                                            break block0;
                                        }
                                        case 'Y': {
                                            if (n > 3) {
                                                switch (string.charAt(3)) {
                                                    case 'A': {
                                                        string3 = "\u3063\u3075\u3083";
                                                        break block0;
                                                    }
                                                    case 'E': {
                                                        string3 = "\u3063\u3075\u3047";
                                                        break block0;
                                                    }
                                                    case 'I': {
                                                        string3 = "\u3063\u3075\u3043";
                                                        break block0;
                                                    }
                                                    case 'O': {
                                                        string3 = "\u3063\u3075\u3087";
                                                        break block0;
                                                    }
                                                    case 'U': {
                                                        string3 = "\u3063\u3075\u3085";
                                                        break block0;
                                                    }
                                                }
                                                break block0;
                                            }
                                            string2 = "aeiou";
                                            break block0;
                                        }
                                    }
                                    break block0;
                                }
                                string2 = "aeiouwy";
                                break block0;
                            }
                            case 'I': {
                                string3 = "\u3075\u3043";
                                break block0;
                            }
                            case 'O': {
                                string3 = "\u3075\u3049";
                                break block0;
                            }
                            case 'U': {
                                string3 = "\u3075";
                                break block0;
                            }
                            case 'W': {
                                if (n > 2) {
                                    switch (string.charAt(2)) {
                                        case 'A': {
                                            string3 = "\u3075\u3041";
                                            break block0;
                                        }
                                        case 'E': {
                                            string3 = "\u3075\u3047";
                                            break block0;
                                        }
                                        case 'I': {
                                            string3 = "\u3075\u3043";
                                            break block0;
                                        }
                                        case 'O': {
                                            string3 = "\u3075\u3049";
                                            break block0;
                                        }
                                        case 'U': {
                                            string3 = "\u3075\u3045";
                                            break block0;
                                        }
                                    }
                                    break block0;
                                }
                                string2 = "aeiou";
                                break block0;
                            }
                            case 'Y': {
                                if (n > 2) {
                                    switch (string.charAt(2)) {
                                        case 'A': {
                                            string3 = "\u3075\u3083";
                                            break block0;
                                        }
                                        case 'E': {
                                            string3 = "\u3075\u3047";
                                            break block0;
                                        }
                                        case 'I': {
                                            string3 = "\u3075\u3043";
                                            break block0;
                                        }
                                        case 'O': {
                                            string3 = "\u3075\u3087";
                                            break block0;
                                        }
                                        case 'U': {
                                            string3 = "\u3075\u3085";
                                            break block0;
                                        }
                                    }
                                    break block0;
                                }
                                string2 = "aeiou";
                                break block0;
                            }
                        }
                        break;
                    }
                    string2 = "aefiouwy";
                    break;
                }
                case 'G': {
                    if (n > 1) {
                        switch (string.charAt(1)) {
                            case 'A': {
                                string3 = "\u304c";
                                break block0;
                            }
                            case 'E': {
                                string3 = "\u3052";
                                break block0;
                            }
                            case 'G': {
                                if (n > 2) {
                                    switch (string.charAt(2)) {
                                        case 'A': {
                                            string3 = "\u3063\u304c";
                                            break block0;
                                        }
                                        case 'E': {
                                            string3 = "\u3063\u3052";
                                            break block0;
                                        }
                                        case 'I': {
                                            string3 = "\u3063\u304e";
                                            break block0;
                                        }
                                        case 'O': {
                                            string3 = "\u3063\u3054";
                                            break block0;
                                        }
                                        case 'U': {
                                            string3 = "\u3063\u3050";
                                            break block0;
                                        }
                                        case 'W': {
                                            if (n > 3) {
                                                switch (string.charAt(3)) {
                                                    case 'A': {
                                                        string3 = "\u3063\u3050\u3041";
                                                        break block0;
                                                    }
                                                    case 'E': {
                                                        string3 = "\u3063\u3050\u3047";
                                                        break block0;
                                                    }
                                                    case 'I': {
                                                        string3 = "\u3063\u3050\u3043";
                                                        break block0;
                                                    }
                                                    case 'O': {
                                                        string3 = "\u3063\u3050\u3049";
                                                        break block0;
                                                    }
                                                    case 'U': {
                                                        string3 = "\u3063\u3050\u3045";
                                                        break block0;
                                                    }
                                                }
                                                break block0;
                                            }
                                            string2 = "aeiou";
                                            break block0;
                                        }
                                        case 'Y': {
                                            if (n > 3) {
                                                switch (string.charAt(3)) {
                                                    case 'A': {
                                                        string3 = "\u3063\u304e\u3083";
                                                        break block0;
                                                    }
                                                    case 'E': {
                                                        string3 = "\u3063\u304e\u3047";
                                                        break block0;
                                                    }
                                                    case 'I': {
                                                        string3 = "\u3063\u304e\u3043";
                                                        break block0;
                                                    }
                                                    case 'O': {
                                                        string3 = "\u3063\u304e\u3087";
                                                        break block0;
                                                    }
                                                    case 'U': {
                                                        string3 = "\u3063\u304e\u3085";
                                                        break block0;
                                                    }
                                                }
                                                break block0;
                                            }
                                            string2 = "aeiou";
                                            break block0;
                                        }
                                    }
                                    break block0;
                                }
                                string2 = "aeiouwy";
                                break block0;
                            }
                            case 'I': {
                                string3 = "\u304e";
                                break block0;
                            }
                            case 'O': {
                                string3 = "\u3054";
                                break block0;
                            }
                            case 'U': {
                                string3 = "\u3050";
                                break block0;
                            }
                            case 'W': {
                                if (n > 2) {
                                    switch (string.charAt(2)) {
                                        case 'A': {
                                            string3 = "\u3050\u3041";
                                            break block0;
                                        }
                                        case 'E': {
                                            string3 = "\u3050\u3047";
                                            break block0;
                                        }
                                        case 'I': {
                                            string3 = "\u3050\u3043";
                                            break block0;
                                        }
                                        case 'O': {
                                            string3 = "\u3050\u3049";
                                            break block0;
                                        }
                                        case 'U': {
                                            string3 = "\u3050\u3045";
                                            break block0;
                                        }
                                    }
                                    break block0;
                                }
                                string2 = "aeiou";
                                break block0;
                            }
                            case 'Y': {
                                if (n > 2) {
                                    switch (string.charAt(2)) {
                                        case 'A': {
                                            string3 = "\u304e\u3083";
                                            break block0;
                                        }
                                        case 'E': {
                                            string3 = "\u304e\u3047";
                                            break block0;
                                        }
                                        case 'I': {
                                            string3 = "\u304e\u3043";
                                            break block0;
                                        }
                                        case 'O': {
                                            string3 = "\u304e\u3087";
                                            break block0;
                                        }
                                        case 'U': {
                                            string3 = "\u304e\u3085";
                                            break block0;
                                        }
                                    }
                                    break block0;
                                }
                                string2 = "aeiou";
                                break block0;
                            }
                        }
                        break;
                    }
                    string2 = "aegiouwy";
                    break;
                }
                case 'H': {
                    if (n > 1) {
                        switch (string.charAt(1)) {
                            case 'A': {
                                string3 = "\u306f";
                                break block0;
                            }
                            case 'E': {
                                string3 = "\u3078";
                                break block0;
                            }
                            case 'H': {
                                if (n > 2) {
                                    switch (string.charAt(2)) {
                                        case 'A': {
                                            string3 = "\u3063\u306f";
                                            break block0;
                                        }
                                        case 'E': {
                                            string3 = "\u3063\u3078";
                                            break block0;
                                        }
                                        case 'I': {
                                            string3 = "\u3063\u3072";
                                            break block0;
                                        }
                                        case 'O': {
                                            string3 = "\u3063\u307b";
                                            break block0;
                                        }
                                        case 'U': {
                                            string3 = "\u3063\u3075";
                                            break block0;
                                        }
                                        case 'Y': {
                                            if (n > 3) {
                                                switch (string.charAt(3)) {
                                                    case 'A': {
                                                        string3 = "\u3063\u3072\u3083";
                                                        break block0;
                                                    }
                                                    case 'E': {
                                                        string3 = "\u3063\u3072\u3047";
                                                        break block0;
                                                    }
                                                    case 'I': {
                                                        string3 = "\u3063\u3072\u3043";
                                                        break block0;
                                                    }
                                                    case 'O': {
                                                        string3 = "\u3063\u3072\u3087";
                                                        break block0;
                                                    }
                                                    case 'U': {
                                                        string3 = "\u3063\u3072\u3085";
                                                        break block0;
                                                    }
                                                }
                                                break block0;
                                            }
                                            string2 = "aeiou";
                                            break block0;
                                        }
                                    }
                                    break block0;
                                }
                                string2 = "aeiouy";
                                break block0;
                            }
                            case 'I': {
                                string3 = "\u3072";
                                break block0;
                            }
                            case 'O': {
                                string3 = "\u307b";
                                break block0;
                            }
                            case 'U': {
                                string3 = "\u3075";
                                break block0;
                            }
                            case 'Y': {
                                if (n > 2) {
                                    switch (string.charAt(2)) {
                                        case 'A': {
                                            string3 = "\u3072\u3083";
                                            break block0;
                                        }
                                        case 'E': {
                                            string3 = "\u3072\u3047";
                                            break block0;
                                        }
                                        case 'I': {
                                            string3 = "\u3072\u3043";
                                            break block0;
                                        }
                                        case 'O': {
                                            string3 = "\u3072\u3087";
                                            break block0;
                                        }
                                        case 'U': {
                                            string3 = "\u3072\u3085";
                                            break block0;
                                        }
                                    }
                                    break block0;
                                }
                                string2 = "aeiou";
                                break block0;
                            }
                        }
                        break;
                    }
                    string2 = "aehiouy";
                    break;
                }
                case 'I': {
                    string3 = "\u3044";
                    break;
                }
                case 'J': {
                    if (n > 1) {
                        switch (string.charAt(1)) {
                            case 'A': {
                                string3 = "\u3058\u3083";
                                break block0;
                            }
                            case 'E': {
                                string3 = "\u3058\u3047";
                                break block0;
                            }
                            case 'I': {
                                string3 = "\u3058";
                                break block0;
                            }
                            case 'J': {
                                if (n > 2) {
                                    switch (string.charAt(2)) {
                                        case 'A': {
                                            string3 = "\u3063\u3058\u3083";
                                            break block0;
                                        }
                                        case 'E': {
                                            string3 = "\u3063\u3058\u3047";
                                            break block0;
                                        }
                                        case 'I': {
                                            string3 = "\u3063\u3058";
                                            break block0;
                                        }
                                        case 'O': {
                                            string3 = "\u3063\u3058\u3087";
                                            break block0;
                                        }
                                        case 'U': {
                                            string3 = "\u3063\u3058\u3085";
                                            break block0;
                                        }
                                        case 'Y': {
                                            if (n > 3) {
                                                switch (string.charAt(3)) {
                                                    case 'A': {
                                                        string3 = "\u3063\u3058\u3083";
                                                        break block0;
                                                    }
                                                    case 'E': {
                                                        string3 = "\u3063\u3058\u3047";
                                                        break block0;
                                                    }
                                                    case 'I': {
                                                        string3 = "\u3063\u3058\u3043";
                                                        break block0;
                                                    }
                                                    case 'O': {
                                                        string3 = "\u3063\u3058\u3087";
                                                        break block0;
                                                    }
                                                    case 'U': {
                                                        string3 = "\u3063\u3058\u3085";
                                                        break block0;
                                                    }
                                                }
                                                break block0;
                                            }
                                            string2 = "aeiou";
                                            break block0;
                                        }
                                    }
                                    break block0;
                                }
                                string2 = "aeiouy";
                                break block0;
                            }
                            case 'O': {
                                string3 = "\u3058\u3087";
                                break block0;
                            }
                            case 'U': {
                                string3 = "\u3058\u3085";
                                break block0;
                            }
                            case 'Y': {
                                if (n > 2) {
                                    switch (string.charAt(2)) {
                                        case 'A': {
                                            string3 = "\u3058\u3083";
                                            break block0;
                                        }
                                        case 'E': {
                                            string3 = "\u3058\u3047";
                                            break block0;
                                        }
                                        case 'I': {
                                            string3 = "\u3058\u3043";
                                            break block0;
                                        }
                                        case 'O': {
                                            string3 = "\u3058\u3087";
                                            break block0;
                                        }
                                        case 'U': {
                                            string3 = "\u3058\u3085";
                                            break block0;
                                        }
                                    }
                                    break block0;
                                }
                                string2 = "aeiou";
                                break block0;
                            }
                        }
                        break;
                    }
                    string2 = "aeijouy";
                    break;
                }
                case 'K': {
                    if (n > 1) {
                        switch (string.charAt(1)) {
                            case 'A': {
                                string3 = "\u304b";
                                break block0;
                            }
                            case 'E': {
                                string3 = "\u3051";
                                break block0;
                            }
                            case 'I': {
                                string3 = "\u304d";
                                break block0;
                            }
                            case 'K': {
                                if (n > 2) {
                                    switch (string.charAt(2)) {
                                        case 'A': {
                                            string3 = "\u3063\u304b";
                                            break block0;
                                        }
                                        case 'E': {
                                            string3 = "\u3063\u3051";
                                            break block0;
                                        }
                                        case 'I': {
                                            string3 = "\u3063\u304d";
                                            break block0;
                                        }
                                        case 'O': {
                                            string3 = "\u3063\u3053";
                                            break block0;
                                        }
                                        case 'U': {
                                            string3 = "\u3063\u304f";
                                            break block0;
                                        }
                                        case 'W': {
                                            string3 = "\u3063\u304f\u3041";
                                            break block0;
                                        }
                                        case 'Y': {
                                            if (n > 3) {
                                                switch (string.charAt(3)) {
                                                    case 'A': {
                                                        string3 = "\u3063\u304d\u3083";
                                                        break block0;
                                                    }
                                                    case 'E': {
                                                        string3 = "\u3063\u304d\u3047";
                                                        break block0;
                                                    }
                                                    case 'I': {
                                                        string3 = "\u3063\u304d\u3043";
                                                        break block0;
                                                    }
                                                    case 'O': {
                                                        string3 = "\u3063\u304d\u3087";
                                                        break block0;
                                                    }
                                                    case 'U': {
                                                        string3 = "\u3063\u304d\u3085";
                                                        break block0;
                                                    }
                                                }
                                                break block0;
                                            }
                                            string2 = "aeiou";
                                            break block0;
                                        }
                                    }
                                    break block0;
                                }
                                string2 = "aeiouwy";
                                break block0;
                            }
                            case 'O': {
                                string3 = "\u3053";
                                break block0;
                            }
                            case 'U': {
                                string3 = "\u304f";
                                break block0;
                            }
                            case 'W': {
                                string3 = "\u304f\u3041";
                                break block0;
                            }
                            case 'Y': {
                                if (n > 2) {
                                    switch (string.charAt(2)) {
                                        case 'A': {
                                            string3 = "\u304d\u3083";
                                            break block0;
                                        }
                                        case 'E': {
                                            string3 = "\u304d\u3047";
                                            break block0;
                                        }
                                        case 'I': {
                                            string3 = "\u304d\u3043";
                                            break block0;
                                        }
                                        case 'O': {
                                            string3 = "\u304d\u3087";
                                            break block0;
                                        }
                                        case 'U': {
                                            string3 = "\u304d\u3085";
                                            break block0;
                                        }
                                    }
                                    break block0;
                                }
                                string2 = "aeiou";
                                break block0;
                            }
                        }
                        break;
                    }
                    string2 = "aeikouwy";
                    break;
                }
                case 'L': {
                    if (n > 1) {
                        switch (string.charAt(1)) {
                            case 'A': {
                                string3 = "\u3041";
                                break block0;
                            }
                            case 'E': {
                                string3 = "\u3047";
                                break block0;
                            }
                            case 'I': {
                                string3 = "\u3043";
                                break block0;
                            }
                            case 'K': {
                                if (n > 2) {
                                    switch (string.charAt(2)) {
                                        case 'A': {
                                            string3 = "\u30f5";
                                            break block0;
                                        }
                                        case 'E': {
                                            string3 = "\u30f6";
                                            break block0;
                                        }
                                    }
                                    break block0;
                                }
                                string2 = "ae";
                                break block0;
                            }
                            case 'L': {
                                if (n > 2) {
                                    switch (string.charAt(2)) {
                                        case 'A': {
                                            string3 = "\u3063\u3041";
                                            break block0;
                                        }
                                        case 'E': {
                                            string3 = "\u3063\u3047";
                                            break block0;
                                        }
                                        case 'I': {
                                            string3 = "\u3063\u3043";
                                            break block0;
                                        }
                                        case 'K': {
                                            if (n > 3) {
                                                switch (string.charAt(3)) {
                                                    case 'A': {
                                                        string3 = "\u3063\u30f5";
                                                        break block0;
                                                    }
                                                    case 'E': {
                                                        string3 = "\u3063\u30f6";
                                                        break block0;
                                                    }
                                                }
                                                break block0;
                                            }
                                            string2 = "ae";
                                            break block0;
                                        }
                                        case 'O': {
                                            string3 = "\u3063\u3049";
                                            break block0;
                                        }
                                        case 'T': {
                                            string3 = "\u3063\u3063";
                                            break block0;
                                        }
                                        case 'U': {
                                            string3 = "\u3063\u3045";
                                            break block0;
                                        }
                                        case 'Y': {
                                            if (n > 3) {
                                                switch (string.charAt(3)) {
                                                    case 'A': {
                                                        string3 = "\u3063\u3083";
                                                        break block0;
                                                    }
                                                    case 'E': {
                                                        string3 = "\u3063\u3047";
                                                        break block0;
                                                    }
                                                    case 'I': {
                                                        string3 = "\u3063\u3043";
                                                        break block0;
                                                    }
                                                    case 'O': {
                                                        string3 = "\u3063\u3087";
                                                        break block0;
                                                    }
                                                    case 'U': {
                                                        string3 = "\u3063\u3085";
                                                        break block0;
                                                    }
                                                }
                                                break block0;
                                            }
                                            string2 = "aeiou";
                                            break block0;
                                        }
                                    }
                                    break block0;
                                }
                                string2 = "aeikotuy";
                                break block0;
                            }
                            case 'O': {
                                string3 = "\u3049";
                                break block0;
                            }
                            case 'T': {
                                string3 = "\u3063";
                                break block0;
                            }
                            case 'U': {
                                string3 = "\u3045";
                                break block0;
                            }
                            case 'Y': {
                                if (n > 2) {
                                    switch (string.charAt(2)) {
                                        case 'A': {
                                            string3 = "\u3083";
                                            break block0;
                                        }
                                        case 'E': {
                                            string3 = "\u3047";
                                            break block0;
                                        }
                                        case 'I': {
                                            string3 = "\u3043";
                                            break block0;
                                        }
                                        case 'O': {
                                            string3 = "\u3087";
                                            break block0;
                                        }
                                        case 'U': {
                                            string3 = "\u3085";
                                            break block0;
                                        }
                                    }
                                    break block0;
                                }
                                string2 = "aeiou";
                                break block0;
                            }
                        }
                        break;
                    }
                    string2 = "aeiklotuy";
                    break;
                }
                case 'M': {
                    if (n > 1) {
                        switch (string.charAt(1)) {
                            case 'A': {
                                string3 = "\u307e";
                                break block0;
                            }
                            case 'E': {
                                string3 = "\u3081";
                                break block0;
                            }
                            case 'I': {
                                string3 = "\u307f";
                                break block0;
                            }
                            case 'M': {
                                if (n > 2) {
                                    switch (string.charAt(2)) {
                                        case 'A': {
                                            string3 = "\u3063\u307e";
                                            break block0;
                                        }
                                        case 'E': {
                                            string3 = "\u3063\u3081";
                                            break block0;
                                        }
                                        case 'I': {
                                            string3 = "\u3063\u307f";
                                            break block0;
                                        }
                                        case 'O': {
                                            string3 = "\u3063\u3082";
                                            break block0;
                                        }
                                        case 'U': {
                                            string3 = "\u3063\u3080";
                                            break block0;
                                        }
                                        case 'Y': {
                                            if (n > 3) {
                                                switch (string.charAt(3)) {
                                                    case 'A': {
                                                        string3 = "\u3063\u307f\u3083";
                                                        break block0;
                                                    }
                                                    case 'E': {
                                                        string3 = "\u3063\u307f\u3047";
                                                        break block0;
                                                    }
                                                    case 'I': {
                                                        string3 = "\u3063\u307f\u3043";
                                                        break block0;
                                                    }
                                                    case 'O': {
                                                        string3 = "\u3063\u307f\u3087";
                                                        break block0;
                                                    }
                                                    case 'U': {
                                                        string3 = "\u3063\u307f\u3085";
                                                        break block0;
                                                    }
                                                }
                                                break block0;
                                            }
                                            string2 = "aeiou";
                                            break block0;
                                        }
                                    }
                                    break block0;
                                }
                                string2 = "aeiouy";
                                break block0;
                            }
                            case 'O': {
                                string3 = "\u3082";
                                break block0;
                            }
                            case 'U': {
                                string3 = "\u3080";
                                break block0;
                            }
                            case 'Y': {
                                if (n > 2) {
                                    switch (string.charAt(2)) {
                                        case 'A': {
                                            string3 = "\u307f\u3083";
                                            break block0;
                                        }
                                        case 'E': {
                                            string3 = "\u307f\u3047";
                                            break block0;
                                        }
                                        case 'I': {
                                            string3 = "\u307f\u3043";
                                            break block0;
                                        }
                                        case 'O': {
                                            string3 = "\u307f\u3087";
                                            break block0;
                                        }
                                        case 'U': {
                                            string3 = "\u307f\u3085";
                                            break block0;
                                        }
                                    }
                                    break block0;
                                }
                                string2 = "aeiou";
                                break block0;
                            }
                        }
                        break;
                    }
                    string2 = "aeimouy";
                    break;
                }
                case 'N': {
                    if (n > 1) {
                        switch (string.charAt(1)) {
                            case 'A': {
                                string3 = "\u306a";
                                break block0;
                            }
                            case 'E': {
                                string3 = "\u306d";
                                break block0;
                            }
                            case 'I': {
                                string3 = "\u306b";
                                break block0;
                            }
                            case 'N': {
                                string3 = "\u3093";
                                break block0;
                            }
                            case 'O': {
                                string3 = "\u306e";
                                break block0;
                            }
                            case 'U': {
                                string3 = "\u306c";
                                break block0;
                            }
                            case 'Y': {
                                if (n > 2) {
                                    switch (string.charAt(2)) {
                                        case 'A': {
                                            string3 = "\u306b\u3083";
                                            break block0;
                                        }
                                        case 'E': {
                                            string3 = "\u306b\u3047";
                                            break block0;
                                        }
                                        case 'I': {
                                            string3 = "\u306b\u3043";
                                            break block0;
                                        }
                                        case 'O': {
                                            string3 = "\u306b\u3087";
                                            break block0;
                                        }
                                        case 'U': {
                                            string3 = "\u306b\u3085";
                                            break block0;
                                        }
                                    }
                                    break block0;
                                }
                                string2 = "aeiou";
                                break block0;
                            }
                        }
                        break;
                    }
                    string2 = "aeinouy'";
                    break;
                }
                case 'O': {
                    string3 = "\u304a";
                    break;
                }
                case 'P': {
                    if (n > 1) {
                        switch (string.charAt(1)) {
                            case 'A': {
                                string3 = "\u3071";
                                break block0;
                            }
                            case 'E': {
                                string3 = "\u307a";
                                break block0;
                            }
                            case 'I': {
                                string3 = "\u3074";
                                break block0;
                            }
                            case 'O': {
                                string3 = "\u307d";
                                break block0;
                            }
                            case 'P': {
                                if (n > 2) {
                                    switch (string.charAt(2)) {
                                        case 'A': {
                                            string3 = "\u3063\u3071";
                                            break block0;
                                        }
                                        case 'E': {
                                            string3 = "\u3063\u307a";
                                            break block0;
                                        }
                                        case 'I': {
                                            string3 = "\u3063\u3074";
                                            break block0;
                                        }
                                        case 'O': {
                                            string3 = "\u3063\u307d";
                                            break block0;
                                        }
                                        case 'U': {
                                            string3 = "\u3063\u3077";
                                            break block0;
                                        }
                                        case 'Y': {
                                            if (n > 3) {
                                                switch (string.charAt(3)) {
                                                    case 'A': {
                                                        string3 = "\u3063\u3074\u3083";
                                                        break block0;
                                                    }
                                                    case 'E': {
                                                        string3 = "\u3063\u3074\u3047";
                                                        break block0;
                                                    }
                                                    case 'I': {
                                                        string3 = "\u3063\u3074\u3043";
                                                        break block0;
                                                    }
                                                    case 'O': {
                                                        string3 = "\u3063\u3074\u3087";
                                                        break block0;
                                                    }
                                                    case 'U': {
                                                        string3 = "\u3063\u3074\u3085";
                                                        break block0;
                                                    }
                                                }
                                                break block0;
                                            }
                                            string2 = "aeiou";
                                            break block0;
                                        }
                                    }
                                    break block0;
                                }
                                string2 = "aeiouy";
                                break block0;
                            }
                            case 'U': {
                                string3 = "\u3077";
                                break block0;
                            }
                            case 'Y': {
                                if (n > 2) {
                                    switch (string.charAt(2)) {
                                        case 'A': {
                                            string3 = "\u3074\u3083";
                                            break block0;
                                        }
                                        case 'E': {
                                            string3 = "\u3074\u3047";
                                            break block0;
                                        }
                                        case 'I': {
                                            string3 = "\u3074\u3043";
                                            break block0;
                                        }
                                        case 'O': {
                                            string3 = "\u3074\u3087";
                                            break block0;
                                        }
                                        case 'U': {
                                            string3 = "\u3074\u3085";
                                            break block0;
                                        }
                                    }
                                    break block0;
                                }
                                string2 = "aeiou";
                                break block0;
                            }
                        }
                        break;
                    }
                    string2 = "aeiopuy";
                    break;
                }
                case 'Q': {
                    if (n > 1) {
                        switch (string.charAt(1)) {
                            case 'A': {
                                string3 = "\u304f\u3041";
                                break block0;
                            }
                            case 'E': {
                                string3 = "\u304f\u3047";
                                break block0;
                            }
                            case 'I': {
                                string3 = "\u304f\u3043";
                                break block0;
                            }
                            case 'O': {
                                string3 = "\u304f\u3049";
                                break block0;
                            }
                            case 'Q': {
                                if (n > 2) {
                                    switch (string.charAt(2)) {
                                        case 'A': {
                                            string3 = "\u3063\u304f\u3041";
                                            break block0;
                                        }
                                        case 'E': {
                                            string3 = "\u3063\u304f\u3047";
                                            break block0;
                                        }
                                        case 'I': {
                                            string3 = "\u3063\u304f\u3043";
                                            break block0;
                                        }
                                        case 'O': {
                                            string3 = "\u3063\u304f\u3049";
                                            break block0;
                                        }
                                        case 'U': {
                                            string3 = "\u3063\u304f";
                                            break block0;
                                        }
                                        case 'W': {
                                            if (n > 3) {
                                                switch (string.charAt(3)) {
                                                    case 'A': {
                                                        string3 = "\u3063\u304f\u3041";
                                                        break block0;
                                                    }
                                                    case 'E': {
                                                        string3 = "\u3063\u304f\u3047";
                                                        break block0;
                                                    }
                                                    case 'I': {
                                                        string3 = "\u3063\u304f\u3043";
                                                        break block0;
                                                    }
                                                    case 'O': {
                                                        string3 = "\u3063\u304f\u3049";
                                                        break block0;
                                                    }
                                                    case 'U': {
                                                        string3 = "\u3063\u304f\u3045";
                                                        break block0;
                                                    }
                                                }
                                                break block0;
                                            }
                                            string2 = "aeiou";
                                            break block0;
                                        }
                                        case 'Y': {
                                            if (n > 3) {
                                                switch (string.charAt(3)) {
                                                    case 'A': {
                                                        string3 = "\u3063\u304f\u3083";
                                                        break block0;
                                                    }
                                                    case 'E': {
                                                        string3 = "\u3063\u304f\u3047";
                                                        break block0;
                                                    }
                                                    case 'I': {
                                                        string3 = "\u3063\u304f\u3043";
                                                        break block0;
                                                    }
                                                    case 'O': {
                                                        string3 = "\u3063\u304f\u3087";
                                                        break block0;
                                                    }
                                                    case 'U': {
                                                        string3 = "\u3063\u304f\u3085";
                                                        break block0;
                                                    }
                                                }
                                                break block0;
                                            }
                                            string2 = "aeiou";
                                            break block0;
                                        }
                                    }
                                    break block0;
                                }
                                string2 = "aeiouwy";
                                break block0;
                            }
                            case 'U': {
                                string3 = "\u304f";
                                break block0;
                            }
                            case 'W': {
                                if (n > 2) {
                                    switch (string.charAt(2)) {
                                        case 'A': {
                                            string3 = "\u304f\u3041";
                                            break block0;
                                        }
                                        case 'E': {
                                            string3 = "\u304f\u3047";
                                            break block0;
                                        }
                                        case 'I': {
                                            string3 = "\u304f\u3043";
                                            break block0;
                                        }
                                        case 'O': {
                                            string3 = "\u304f\u3049";
                                            break block0;
                                        }
                                        case 'U': {
                                            string3 = "\u304f\u3045";
                                            break block0;
                                        }
                                    }
                                    break block0;
                                }
                                string2 = "aeiou";
                                break block0;
                            }
                            case 'Y': {
                                if (n > 2) {
                                    switch (string.charAt(2)) {
                                        case 'A': {
                                            string3 = "\u304f\u3083";
                                            break block0;
                                        }
                                        case 'E': {
                                            string3 = "\u304f\u3047";
                                            break block0;
                                        }
                                        case 'I': {
                                            string3 = "\u304f\u3043";
                                            break block0;
                                        }
                                        case 'O': {
                                            string3 = "\u304f\u3087";
                                            break block0;
                                        }
                                        case 'U': {
                                            string3 = "\u304f\u3085";
                                            break block0;
                                        }
                                    }
                                    break block0;
                                }
                                string2 = "aeiou";
                                break block0;
                            }
                        }
                        break;
                    }
                    string2 = "aeioquwy";
                    break;
                }
                case 'R': {
                    if (n > 1) {
                        switch (string.charAt(1)) {
                            case 'A': {
                                string3 = "\u3089";
                                break block0;
                            }
                            case 'E': {
                                string3 = "\u308c";
                                break block0;
                            }
                            case 'I': {
                                string3 = "\u308a";
                                break block0;
                            }
                            case 'O': {
                                string3 = "\u308d";
                                break block0;
                            }
                            case 'R': {
                                if (n > 2) {
                                    switch (string.charAt(2)) {
                                        case 'A': {
                                            string3 = "\u3063\u3089";
                                            break block0;
                                        }
                                        case 'E': {
                                            string3 = "\u3063\u308c";
                                            break block0;
                                        }
                                        case 'I': {
                                            string3 = "\u3063\u308a";
                                            break block0;
                                        }
                                        case 'O': {
                                            string3 = "\u3063\u308d";
                                            break block0;
                                        }
                                        case 'U': {
                                            string3 = "\u3063\u308b";
                                            break block0;
                                        }
                                        case 'Y': {
                                            if (n > 3) {
                                                switch (string.charAt(3)) {
                                                    case 'A': {
                                                        string3 = "\u3063\u308a\u3083";
                                                        break block0;
                                                    }
                                                    case 'E': {
                                                        string3 = "\u3063\u308a\u3047";
                                                        break block0;
                                                    }
                                                    case 'I': {
                                                        string3 = "\u3063\u308a\u3043";
                                                        break block0;
                                                    }
                                                    case 'O': {
                                                        string3 = "\u3063\u308a\u3087";
                                                        break block0;
                                                    }
                                                    case 'U': {
                                                        string3 = "\u3063\u308a\u3085";
                                                        break block0;
                                                    }
                                                }
                                                break block0;
                                            }
                                            string2 = "aeiou";
                                            break block0;
                                        }
                                    }
                                    break block0;
                                }
                                string2 = "aeiouy";
                                break block0;
                            }
                            case 'U': {
                                string3 = "\u308b";
                                break block0;
                            }
                            case 'Y': {
                                if (n > 2) {
                                    switch (string.charAt(2)) {
                                        case 'A': {
                                            string3 = "\u308a\u3083";
                                            break block0;
                                        }
                                        case 'E': {
                                            string3 = "\u308a\u3047";
                                            break block0;
                                        }
                                        case 'I': {
                                            string3 = "\u308a\u3043";
                                            break block0;
                                        }
                                        case 'O': {
                                            string3 = "\u308a\u3087";
                                            break block0;
                                        }
                                        case 'U': {
                                            string3 = "\u308a\u3085";
                                            break block0;
                                        }
                                    }
                                    break block0;
                                }
                                string2 = "aeiou";
                                break block0;
                            }
                        }
                        break;
                    }
                    string2 = "aeioruy";
                    break;
                }
                case 'S': {
                    if (n > 1) {
                        switch (string.charAt(1)) {
                            case 'A': {
                                string3 = "\u3055";
                                break block0;
                            }
                            case 'E': {
                                string3 = "\u305b";
                                break block0;
                            }
                            case 'H': {
                                if (n > 2) {
                                    switch (string.charAt(2)) {
                                        case 'A': {
                                            string3 = "\u3057\u3083";
                                            break block0;
                                        }
                                        case 'E': {
                                            string3 = "\u3057\u3047";
                                            break block0;
                                        }
                                        case 'I': {
                                            string3 = "\u3057";
                                            break block0;
                                        }
                                        case 'O': {
                                            string3 = "\u3057\u3087";
                                            break block0;
                                        }
                                        case 'U': {
                                            string3 = "\u3057\u3085";
                                            break block0;
                                        }
                                    }
                                    break block0;
                                }
                                string2 = "aeiou";
                                break block0;
                            }
                            case 'I': {
                                string3 = "\u3057";
                                break block0;
                            }
                            case 'O': {
                                string3 = "\u305d";
                                break block0;
                            }
                            case 'S': {
                                if (n > 2) {
                                    switch (string.charAt(2)) {
                                        case 'A': {
                                            string3 = "\u3063\u3055";
                                            break block0;
                                        }
                                        case 'E': {
                                            string3 = "\u3063\u305b";
                                            break block0;
                                        }
                                        case 'H': {
                                            if (n > 3) {
                                                switch (string.charAt(3)) {
                                                    case 'A': {
                                                        string3 = "\u3063\u3057\u3083";
                                                        break block0;
                                                    }
                                                    case 'E': {
                                                        string3 = "\u3063\u3057\u3047";
                                                        break block0;
                                                    }
                                                    case 'I': {
                                                        string3 = "\u3063\u3057";
                                                        break block0;
                                                    }
                                                    case 'O': {
                                                        string3 = "\u3063\u3057\u3087";
                                                        break block0;
                                                    }
                                                    case 'U': {
                                                        string3 = "\u3063\u3057\u3085";
                                                        break block0;
                                                    }
                                                }
                                                break block0;
                                            }
                                            string2 = "aeiou";
                                            break block0;
                                        }
                                        case 'I': {
                                            string3 = "\u3063\u3057";
                                            break block0;
                                        }
                                        case 'O': {
                                            string3 = "\u3063\u305d";
                                            break block0;
                                        }
                                        case 'U': {
                                            string3 = "\u3063\u3059";
                                            break block0;
                                        }
                                        case 'W': {
                                            if (n > 3) {
                                                switch (string.charAt(3)) {
                                                    case 'A': {
                                                        string3 = "\u3063\u3059\u3041";
                                                        break block0;
                                                    }
                                                    case 'E': {
                                                        string3 = "\u3063\u3059\u3047";
                                                        break block0;
                                                    }
                                                    case 'I': {
                                                        string3 = "\u3063\u3059\u3043";
                                                        break block0;
                                                    }
                                                    case 'O': {
                                                        string3 = "\u3063\u3059\u3049";
                                                        break block0;
                                                    }
                                                    case 'U': {
                                                        string3 = "\u3063\u3059\u3045";
                                                        break block0;
                                                    }
                                                }
                                                break block0;
                                            }
                                            string2 = "aeiou";
                                            break block0;
                                        }
                                        case 'Y': {
                                            if (n > 3) {
                                                switch (string.charAt(3)) {
                                                    case 'A': {
                                                        string3 = "\u3063\u3057\u3083";
                                                        break block0;
                                                    }
                                                    case 'E': {
                                                        string3 = "\u3063\u3057\u3047";
                                                        break block0;
                                                    }
                                                    case 'I': {
                                                        string3 = "\u3063\u3057\u3043";
                                                        break block0;
                                                    }
                                                    case 'O': {
                                                        string3 = "\u3063\u3057\u3087";
                                                        break block0;
                                                    }
                                                    case 'U': {
                                                        string3 = "\u3063\u3057\u3085";
                                                        break block0;
                                                    }
                                                }
                                                break block0;
                                            }
                                            string2 = "aeiou";
                                            break block0;
                                        }
                                    }
                                    break block0;
                                }
                                string2 = "aehiouwy";
                                break block0;
                            }
                            case 'U': {
                                string3 = "\u3059";
                                break block0;
                            }
                            case 'W': {
                                if (n > 2) {
                                    switch (string.charAt(2)) {
                                        case 'A': {
                                            string3 = "\u3059\u3041";
                                            break block0;
                                        }
                                        case 'E': {
                                            string3 = "\u3059\u3047";
                                            break block0;
                                        }
                                        case 'I': {
                                            string3 = "\u3059\u3043";
                                            break block0;
                                        }
                                        case 'O': {
                                            string3 = "\u3059\u3049";
                                            break block0;
                                        }
                                        case 'U': {
                                            string3 = "\u3059\u3045";
                                            break block0;
                                        }
                                    }
                                    break block0;
                                }
                                string2 = "aeiou";
                                break block0;
                            }
                            case 'Y': {
                                if (n > 2) {
                                    switch (string.charAt(2)) {
                                        case 'A': {
                                            string3 = "\u3057\u3083";
                                            break block0;
                                        }
                                        case 'E': {
                                            string3 = "\u3057\u3047";
                                            break block0;
                                        }
                                        case 'I': {
                                            string3 = "\u3057\u3043";
                                            break block0;
                                        }
                                        case 'O': {
                                            string3 = "\u3057\u3087";
                                            break block0;
                                        }
                                        case 'U': {
                                            string3 = "\u3057\u3085";
                                            break block0;
                                        }
                                    }
                                    break block0;
                                }
                                string2 = "aeiou";
                                break block0;
                            }
                        }
                        break;
                    }
                    string2 = "aehiosuwy";
                    break;
                }
                case 'T': {
                    if (n > 1) {
                        switch (string.charAt(1)) {
                            case 'A': {
                                string3 = "\u305f";
                                break block0;
                            }
                            case 'E': {
                                string3 = "\u3066";
                                break block0;
                            }
                            case 'H': {
                                if (n > 2) {
                                    switch (string.charAt(2)) {
                                        case 'A': {
                                            string3 = "\u3066\u3083";
                                            break block0;
                                        }
                                        case 'E': {
                                            string3 = "\u3066\u3047";
                                            break block0;
                                        }
                                        case 'I': {
                                            string3 = "\u3066\u3043";
                                            break block0;
                                        }
                                        case 'O': {
                                            string3 = "\u3066\u3087";
                                            break block0;
                                        }
                                        case 'U': {
                                            string3 = "\u3066\u3085";
                                            break block0;
                                        }
                                    }
                                    break block0;
                                }
                                string2 = "aeiou";
                                break block0;
                            }
                            case 'I': {
                                string3 = "\u3061";
                                break block0;
                            }
                            case 'O': {
                                string3 = "\u3068";
                                break block0;
                            }
                            case 'S': {
                                if (n > 2) {
                                    switch (string.charAt(2)) {
                                        case 'A': {
                                            string3 = "\u3064\u3041";
                                            break block0;
                                        }
                                        case 'E': {
                                            string3 = "\u3064\u3047";
                                            break block0;
                                        }
                                        case 'I': {
                                            string3 = "\u3064\u3043";
                                            break block0;
                                        }
                                        case 'O': {
                                            string3 = "\u3064\u3049";
                                            break block0;
                                        }
                                        case 'U': {
                                            string3 = "\u3064";
                                            break block0;
                                        }
                                    }
                                    break block0;
                                }
                                string2 = "aeiou";
                                break block0;
                            }
                            case 'T': {
                                if (n > 2) {
                                    switch (string.charAt(2)) {
                                        case 'A': {
                                            string3 = "\u3063\u305f";
                                            break block0;
                                        }
                                        case 'E': {
                                            string3 = "\u3063\u3066";
                                            break block0;
                                        }
                                        case 'H': {
                                            if (n > 3) {
                                                switch (string.charAt(3)) {
                                                    case 'A': {
                                                        string3 = "\u3063\u3066\u3083";
                                                        break block0;
                                                    }
                                                    case 'E': {
                                                        string3 = "\u3063\u3066\u3047";
                                                        break block0;
                                                    }
                                                    case 'I': {
                                                        string3 = "\u3063\u3066\u3043";
                                                        break block0;
                                                    }
                                                    case 'O': {
                                                        string3 = "\u3063\u3066\u3087";
                                                        break block0;
                                                    }
                                                    case 'U': {
                                                        string3 = "\u3063\u3066\u3085";
                                                        break block0;
                                                    }
                                                }
                                                break block0;
                                            }
                                            string2 = "aeiou";
                                            break block0;
                                        }
                                        case 'I': {
                                            string3 = "\u3063\u3061";
                                            break block0;
                                        }
                                        case 'O': {
                                            string3 = "\u3063\u3068";
                                            break block0;
                                        }
                                        case 'S': {
                                            if (n > 3) {
                                                switch (string.charAt(3)) {
                                                    case 'A': {
                                                        string3 = "\u3063\u3064\u3041";
                                                        break block0;
                                                    }
                                                    case 'E': {
                                                        string3 = "\u3063\u3064\u3047";
                                                        break block0;
                                                    }
                                                    case 'I': {
                                                        string3 = "\u3063\u3064\u3043";
                                                        break block0;
                                                    }
                                                    case 'O': {
                                                        string3 = "\u3063\u3064\u3049";
                                                        break block0;
                                                    }
                                                    case 'U': {
                                                        string3 = "\u3063\u3064";
                                                        break block0;
                                                    }
                                                }
                                                break block0;
                                            }
                                            string2 = "aeiou";
                                            break block0;
                                        }
                                        case 'U': {
                                            string3 = "\u3063\u3064";
                                            break block0;
                                        }
                                        case 'W': {
                                            if (n > 3) {
                                                switch (string.charAt(3)) {
                                                    case 'A': {
                                                        string3 = "\u3063\u3068\u3041";
                                                        break block0;
                                                    }
                                                    case 'E': {
                                                        string3 = "\u3063\u3068\u3047";
                                                        break block0;
                                                    }
                                                    case 'I': {
                                                        string3 = "\u3063\u3068\u3043";
                                                        break block0;
                                                    }
                                                    case 'O': {
                                                        string3 = "\u3063\u3068\u3049";
                                                        break block0;
                                                    }
                                                    case 'U': {
                                                        string3 = "\u3063\u3068\u3045";
                                                        break block0;
                                                    }
                                                }
                                                break block0;
                                            }
                                            string2 = "aeiou";
                                            break block0;
                                        }
                                        case 'Y': {
                                            if (n > 3) {
                                                switch (string.charAt(3)) {
                                                    case 'A': {
                                                        string3 = "\u3063\u3061\u3083";
                                                        break block0;
                                                    }
                                                    case 'E': {
                                                        string3 = "\u3063\u3061\u3047";
                                                        break block0;
                                                    }
                                                    case 'I': {
                                                        string3 = "\u3063\u3061\u3043";
                                                        break block0;
                                                    }
                                                    case 'O': {
                                                        string3 = "\u3063\u3061\u3087";
                                                        break block0;
                                                    }
                                                    case 'U': {
                                                        string3 = "\u3063\u3061\u3085";
                                                        break block0;
                                                    }
                                                }
                                                break block0;
                                            }
                                            string2 = "aeiou";
                                            break block0;
                                        }
                                    }
                                    break block0;
                                }
                                string2 = "aehiosuwy";
                                break block0;
                            }
                            case 'U': {
                                string3 = "\u3064";
                                break block0;
                            }
                            case 'W': {
                                if (n > 2) {
                                    switch (string.charAt(2)) {
                                        case 'A': {
                                            string3 = "\u3068\u3041";
                                            break block0;
                                        }
                                        case 'E': {
                                            string3 = "\u3068\u3047";
                                            break block0;
                                        }
                                        case 'I': {
                                            string3 = "\u3068\u3043";
                                            break block0;
                                        }
                                        case 'O': {
                                            string3 = "\u3068\u3049";
                                            break block0;
                                        }
                                        case 'U': {
                                            string3 = "\u3068\u3045";
                                            break block0;
                                        }
                                    }
                                    break block0;
                                }
                                string2 = "aeiou";
                                break block0;
                            }
                            case 'Y': {
                                if (n > 2) {
                                    switch (string.charAt(2)) {
                                        case 'A': {
                                            string3 = "\u3061\u3083";
                                            break block0;
                                        }
                                        case 'E': {
                                            string3 = "\u3061\u3047";
                                            break block0;
                                        }
                                        case 'I': {
                                            string3 = "\u3061\u3043";
                                            break block0;
                                        }
                                        case 'O': {
                                            string3 = "\u3061\u3087";
                                            break block0;
                                        }
                                        case 'U': {
                                            string3 = "\u3061\u3085";
                                            break block0;
                                        }
                                    }
                                    break block0;
                                }
                                string2 = "aeiou";
                                break block0;
                            }
                        }
                        break;
                    }
                    string2 = "aehiostuwy";
                    break;
                }
                case 'U': {
                    string3 = "\u3046";
                    break;
                }
                case 'V': {
                    if (n > 1) {
                        switch (string.charAt(1)) {
                            case 'A': {
                                string3 = "\u30f4\u3041";
                                break block0;
                            }
                            case 'E': {
                                string3 = "\u30f4\u3047";
                                break block0;
                            }
                            case 'I': {
                                string3 = "\u30f4\u3043";
                                break block0;
                            }
                            case 'O': {
                                string3 = "\u30f4\u3049";
                                break block0;
                            }
                            case 'U': {
                                string3 = "\u30f4";
                                break block0;
                            }
                            case 'V': {
                                if (n > 2) {
                                    switch (string.charAt(2)) {
                                        case 'A': {
                                            string3 = "\u3063\u30f4\u3041";
                                            break block0;
                                        }
                                        case 'E': {
                                            string3 = "\u3063\u30f4\u3047";
                                            break block0;
                                        }
                                        case 'I': {
                                            string3 = "\u3063\u30f4\u3043";
                                            break block0;
                                        }
                                        case 'O': {
                                            string3 = "\u3063\u30f4\u3049";
                                            break block0;
                                        }
                                        case 'U': {
                                            string3 = "\u3063\u30f4";
                                            break block0;
                                        }
                                        case 'Y': {
                                            if (n > 3) {
                                                switch (string.charAt(3)) {
                                                    case 'A': {
                                                        string3 = "\u3063\u30f4\u3083";
                                                        break block0;
                                                    }
                                                    case 'E': {
                                                        string3 = "\u3063\u30f4\u3047";
                                                        break block0;
                                                    }
                                                    case 'I': {
                                                        string3 = "\u3063\u30f4\u3043";
                                                        break block0;
                                                    }
                                                    case 'O': {
                                                        string3 = "\u3063\u30f4\u3087";
                                                        break block0;
                                                    }
                                                    case 'U': {
                                                        string3 = "\u3063\u30f4\u3085";
                                                        break block0;
                                                    }
                                                }
                                                break block0;
                                            }
                                            string2 = "aeiou";
                                            break block0;
                                        }
                                    }
                                    break block0;
                                }
                                string2 = "aeiouy";
                                break block0;
                            }
                            case 'Y': {
                                if (n > 2) {
                                    switch (string.charAt(2)) {
                                        case 'A': {
                                            string3 = "\u30f4\u3083";
                                            break block0;
                                        }
                                        case 'E': {
                                            string3 = "\u30f4\u3047";
                                            break block0;
                                        }
                                        case 'I': {
                                            string3 = "\u30f4\u3043";
                                            break block0;
                                        }
                                        case 'O': {
                                            string3 = "\u30f4\u3087";
                                            break block0;
                                        }
                                        case 'U': {
                                            string3 = "\u30f4\u3085";
                                            break block0;
                                        }
                                    }
                                    break block0;
                                }
                                string2 = "aeiou";
                                break block0;
                            }
                        }
                        break;
                    }
                    string2 = "aeiouvy";
                    break;
                }
                case 'W': {
                    if (n > 1) {
                        switch (string.charAt(1)) {
                            case 'A': {
                                string3 = "\u308f";
                                break block0;
                            }
                            case 'E': {
                                string3 = "\u3046\u3047";
                                break block0;
                            }
                            case 'H': {
                                if (n > 2) {
                                    switch (string.charAt(2)) {
                                        case 'A': {
                                            string3 = "\u3046\u3041";
                                            break block0;
                                        }
                                        case 'E': {
                                            string3 = "\u3046\u3047";
                                            break block0;
                                        }
                                        case 'I': {
                                            string3 = "\u3046\u3043";
                                            break block0;
                                        }
                                        case 'O': {
                                            string3 = "\u3046\u3049";
                                            break block0;
                                        }
                                        case 'U': {
                                            string3 = "\u3046";
                                            break block0;
                                        }
                                    }
                                    break block0;
                                }
                                string2 = "aeiou";
                                break block0;
                            }
                            case 'I': {
                                string3 = "\u3046\u3047";
                                break block0;
                            }
                            case 'O': {
                                string3 = "\u3092";
                                break block0;
                            }
                            case 'U': {
                                string3 = "\u3046";
                                break block0;
                            }
                            case 'W': {
                                if (n > 2) {
                                    switch (string.charAt(2)) {
                                        case 'A': {
                                            string3 = "\u3063\u308f";
                                            break block0;
                                        }
                                        case 'E': {
                                            string3 = "\u3063\u3046\u3047";
                                            break block0;
                                        }
                                        case 'H': {
                                            if (n > 3) {
                                                switch (string.charAt(3)) {
                                                    case 'A': {
                                                        string3 = "\u3063\u3046\u3041";
                                                        break block0;
                                                    }
                                                    case 'E': {
                                                        string3 = "\u3063\u3046\u3047";
                                                        break block0;
                                                    }
                                                    case 'I': {
                                                        string3 = "\u3063\u3046\u3043";
                                                        break block0;
                                                    }
                                                    case 'O': {
                                                        string3 = "\u3063\u3046\u3049";
                                                        break block0;
                                                    }
                                                    case 'U': {
                                                        string3 = "\u3063\u3046";
                                                        break block0;
                                                    }
                                                }
                                                break block0;
                                            }
                                            string2 = "aeiou";
                                            break block0;
                                        }
                                        case 'I': {
                                            string3 = "\u3063\u3073";
                                            break block0;
                                        }
                                        case 'O': {
                                            string3 = "\u3063\u3092";
                                            break block0;
                                        }
                                        case 'U': {
                                            string3 = "\u3063\u3046";
                                            break block0;
                                        }
                                    }
                                    break block0;
                                }
                                string2 = "aehiou";
                                break block0;
                            }
                        }
                        break;
                    }
                    string2 = "aehiouw";
                    break;
                }
                case 'X': {
                    if (n > 1) {
                        switch (string.charAt(1)) {
                            case 'A': {
                                string3 = "\u3041";
                                break block0;
                            }
                            case 'E': {
                                string3 = "\u3047";
                                break block0;
                            }
                            case 'I': {
                                string3 = "\u3043";
                                break block0;
                            }
                            case 'K': {
                                if (n > 2) {
                                    switch (string.charAt(2)) {
                                        case 'A': {
                                            string3 = "\u30f5";
                                            break block0;
                                        }
                                        case 'E': {
                                            string3 = "\u30f6";
                                            break block0;
                                        }
                                    }
                                    break block0;
                                }
                                string2 = "ae";
                                break block0;
                            }
                            case 'N': {
                                string3 = "\u3093";
                                break block0;
                            }
                            case 'O': {
                                string3 = "\u3049";
                                break block0;
                            }
                            case 'T': {
                                string3 = "\u3063";
                                break block0;
                            }
                            case 'U': {
                                string3 = "\u3045";
                                break block0;
                            }
                            case 'X': {
                                if (n > 2) {
                                    switch (string.charAt(2)) {
                                        case 'A': {
                                            string3 = "\u3063\u3041";
                                            break block0;
                                        }
                                        case 'E': {
                                            string3 = "\u3063\u3047";
                                            break block0;
                                        }
                                        case 'I': {
                                            string3 = "\u3063\u3043";
                                            break block0;
                                        }
                                        case 'K': {
                                            if (n > 3) {
                                                switch (string.charAt(3)) {
                                                    case 'A': {
                                                        string3 = "\u3063\u30f5";
                                                        break block0;
                                                    }
                                                    case 'E': {
                                                        string3 = "\u3063\u30f6";
                                                        break block0;
                                                    }
                                                }
                                                break block0;
                                            }
                                            string2 = "ae";
                                            break block0;
                                        }
                                        case 'N': {
                                            string3 = "\u3063\u3093";
                                            break block0;
                                        }
                                        case 'O': {
                                            string3 = "\u3063\u3049";
                                            break block0;
                                        }
                                        case 'T': {
                                            string3 = "\u3063\u3063";
                                            break block0;
                                        }
                                        case 'U': {
                                            string3 = "\u3063\u3045";
                                            break block0;
                                        }
                                        case 'Y': {
                                            if (n > 3) {
                                                switch (string.charAt(3)) {
                                                    case 'A': {
                                                        string3 = "\u3063\u3083";
                                                        break block0;
                                                    }
                                                    case 'E': {
                                                        string3 = "\u3063\u3047";
                                                        break block0;
                                                    }
                                                    case 'I': {
                                                        string3 = "\u3063\u3043";
                                                        break block0;
                                                    }
                                                    case 'O': {
                                                        string3 = "\u3063\u3087";
                                                        break block0;
                                                    }
                                                    case 'U': {
                                                        string3 = "\u3063\u3085";
                                                        break block0;
                                                    }
                                                }
                                                break block0;
                                            }
                                            string2 = "aeiou";
                                            break block0;
                                        }
                                    }
                                    break block0;
                                }
                                string2 = "aeiknotuy";
                                break block0;
                            }
                            case 'Y': {
                                if (n > 2) {
                                    switch (string.charAt(2)) {
                                        case 'A': {
                                            string3 = "\u3083";
                                            break block0;
                                        }
                                        case 'E': {
                                            string3 = "\u3047";
                                            break block0;
                                        }
                                        case 'I': {
                                            string3 = "\u3043";
                                            break block0;
                                        }
                                        case 'O': {
                                            string3 = "\u3087";
                                            break block0;
                                        }
                                        case 'U': {
                                            string3 = "\u3085";
                                            break block0;
                                        }
                                    }
                                    break block0;
                                }
                                string2 = "aeiou";
                                break block0;
                            }
                        }
                        break;
                    }
                    string2 = "aeiknotuxy";
                    break;
                }
                case 'Y': {
                    if (n > 1) {
                        switch (string.charAt(1)) {
                            case 'A': {
                                string3 = "\u3084";
                                break block0;
                            }
                            case 'E': {
                                string3 = "\u3043\u3047";
                                break block0;
                            }
                            case 'I': {
                                string3 = "\u3044";
                                break block0;
                            }
                            case 'O': {
                                string3 = "\u3088";
                                break block0;
                            }
                            case 'U': {
                                string3 = "\u3086";
                                break block0;
                            }
                            case 'Y': {
                                if (n > 2) {
                                    switch (string.charAt(2)) {
                                        case 'A': {
                                            string3 = "\u3063\u3084";
                                            break block0;
                                        }
                                        case 'E': {
                                            string3 = "\u3063\u3043\u3047";
                                            break block0;
                                        }
                                        case 'I': {
                                            string3 = "\u3063\u3044";
                                            break block0;
                                        }
                                        case 'O': {
                                            string3 = "\u3063\u3088";
                                            break block0;
                                        }
                                        case 'U': {
                                            string3 = "\u3063\u3086";
                                            break block0;
                                        }
                                    }
                                    break block0;
                                }
                                string2 = "aeiou";
                                break block0;
                            }
                        }
                        break;
                    }
                    string2 = "aeiouy";
                    break;
                }
                case 'Z': {
                    if (n > 1) {
                        switch (string.charAt(1)) {
                            case 'A': {
                                string3 = "\u3056";
                                break block0;
                            }
                            case 'E': {
                                string3 = "\u305c";
                                break block0;
                            }
                            case 'I': {
                                string3 = "\u3058";
                                break block0;
                            }
                            case 'O': {
                                string3 = "\u305e";
                                break block0;
                            }
                            case 'U': {
                                string3 = "\u305a";
                                break block0;
                            }
                            case 'Y': {
                                if (n > 2) {
                                    switch (string.charAt(2)) {
                                        case 'A': {
                                            string3 = "\u3058\u3083";
                                            break block0;
                                        }
                                        case 'E': {
                                            string3 = "\u3058\u3047";
                                            break block0;
                                        }
                                        case 'I': {
                                            string3 = "\u3058\u3043";
                                            break block0;
                                        }
                                        case 'O': {
                                            string3 = "\u3058\u3087";
                                            break block0;
                                        }
                                        case 'U': {
                                            string3 = "\u3058\u3085";
                                            break block0;
                                        }
                                    }
                                    break block0;
                                }
                                string2 = "aeiou";
                                break block0;
                            }
                            case 'Z': {
                                if (n > 2) {
                                    switch (string.charAt(2)) {
                                        case 'A': {
                                            string3 = "\u3063\u3056";
                                            break block0;
                                        }
                                        case 'E': {
                                            string3 = "\u3063\u305c";
                                            break block0;
                                        }
                                        case 'I': {
                                            string3 = "\u3063\u3058";
                                            break block0;
                                        }
                                        case 'O': {
                                            string3 = "\u3063\u305e";
                                            break block0;
                                        }
                                        case 'U': {
                                            string3 = "\u3063\u305a";
                                            break block0;
                                        }
                                        case 'Y': {
                                            if (n > 3) {
                                                switch (string.charAt(3)) {
                                                    case 'A': {
                                                        string3 = "\u3063\u3058\u3083";
                                                        break block0;
                                                    }
                                                    case 'E': {
                                                        string3 = "\u3063\u3058\u3047";
                                                        break block0;
                                                    }
                                                    case 'I': {
                                                        string3 = "\u3063\u3058\u3043";
                                                        break block0;
                                                    }
                                                    case 'O': {
                                                        string3 = "\u3063\u3058\u3087";
                                                        break block0;
                                                    }
                                                    case 'U': {
                                                        string3 = "\u3063\u3058\u3085";
                                                        break block0;
                                                    }
                                                }
                                                break block0;
                                            }
                                            string2 = "aeiou";
                                            break block0;
                                        }
                                    }
                                    break block0;
                                }
                                string2 = "aeiouy";
                                break block0;
                            }
                        }
                        break;
                    }
                    string2 = "aeiouyz";
                    break;
                }
            }
        }
        stringArray[0] = string2.toUpperCase();
        stringArray[1] = string3;
    }

    private RomajiFreeTextConverter() {
    }
}

