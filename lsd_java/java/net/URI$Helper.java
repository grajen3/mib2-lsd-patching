/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import com.ibm.oti.util.Msg;
import java.net.URI;
import java.net.URIEncoderDecoder;
import java.net.URISyntaxException;
import java.util.StringTokenizer;

class URI$Helper {
    final /* synthetic */ URI this$0;

    URI$Helper(URI uRI) {
        this.this$0 = uRI;
    }

    private void parseURI(String string, boolean bl) {
        int n;
        String string2 = string;
        URI.access$0(this.this$0, string);
        int n2 = string2.indexOf(35);
        if (n2 != -1) {
            URI.access$1(this.this$0, string2.substring(n2 + 1));
            this.validateFragment(string, URI.access$2(this.this$0), n2 + 1);
            string2 = string2.substring(0, n2);
        }
        n2 = n = string2.indexOf(58);
        int n3 = string2.indexOf(47);
        int n4 = string2.indexOf(63);
        if (!(n2 == -1 || n3 < n2 && n3 != -1 || n4 < n2 && n4 != -1)) {
            URI.access$3(this.this$0, true);
            URI.access$4(this.this$0, string2.substring(0, n2));
            if (URI.access$5(this.this$0).length() == 0) {
                throw new URISyntaxException(string, Msg.getString("K0342"), n2);
            }
            this.validateScheme(string, URI.access$5(this.this$0), 0);
            URI.access$6(this.this$0, string2.substring(n2 + 1));
            if (URI.access$7(this.this$0).length() == 0) {
                throw new URISyntaxException(string, Msg.getString("K0303"), n2 + 1);
            }
        } else {
            URI.access$3(this.this$0, false);
            URI.access$6(this.this$0, string2);
        }
        if (URI.access$5(this.this$0) == null || URI.access$7(this.this$0).length() > 0 && URI.access$7(this.this$0).charAt(0) == '/') {
            URI.access$8(this.this$0, false);
            string2 = URI.access$7(this.this$0);
            n2 = string2.indexOf(63);
            if (n2 != -1) {
                URI.access$9(this.this$0, string2.substring(n2 + 1));
                string2 = string2.substring(0, n2);
                this.validateQuery(string, URI.access$10(this.this$0), n3 + 1 + n2);
            }
            if (string2.startsWith("//")) {
                n2 = string2.indexOf(47, 2);
                if (n2 != -1) {
                    URI.access$11(this.this$0, string2.substring(2, n2));
                    URI.access$12(this.this$0, string2.substring(n2));
                } else {
                    URI.access$11(this.this$0, string2.substring(2));
                    if (URI.access$13(this.this$0).length() == 0 && URI.access$10(this.this$0) == null && URI.access$2(this.this$0) == null) {
                        throw new URISyntaxException(string, Msg.getString("K0304"), string.length());
                    }
                    URI.access$12(this.this$0, "");
                }
                if (URI.access$13(this.this$0).length() == 0) {
                    URI.access$11(this.this$0, null);
                } else {
                    this.validateAuthority(string, URI.access$13(this.this$0), n + 3);
                }
            } else {
                URI.access$12(this.this$0, string2);
            }
            int n5 = 0;
            if (n3 > -1) {
                n5 += n3;
            }
            if (n2 > -1) {
                n5 += n2;
            }
            this.validatePath(string, URI.access$14(this.this$0), n5);
        } else {
            URI.access$8(this.this$0, true);
            this.validateSsp(string, URI.access$7(this.this$0), n3 + 2 + n2);
        }
        this.parseAuthority(bl);
    }

    private void validateScheme(String string, String string2, int n) {
        char c2 = string2.charAt(0);
        if (!(c2 >= 'a' && c2 <= 'z' || c2 >= 'A' && c2 <= 'Z')) {
            throw new URISyntaxException(string, Msg.getString("K0305"), 0);
        }
        try {
            URIEncoderDecoder.validateSimple(string2, "+-.");
        }
        catch (URISyntaxException uRISyntaxException) {
            throw new URISyntaxException(string, Msg.getString("K0305"), n + uRISyntaxException.getIndex());
        }
    }

    private void validateSsp(String string, String string2, int n) {
        try {
            URIEncoderDecoder.validate(string2, "_-!.~'()*,;:$&+=?/[]@");
        }
        catch (URISyntaxException uRISyntaxException) {
            throw new URISyntaxException(string, Msg.getString("K0306", uRISyntaxException.getReason()), n + uRISyntaxException.getIndex());
        }
    }

    private void validateAuthority(String string, String string2, int n) {
        try {
            URIEncoderDecoder.validate(string2, "@[]_-!.~'()*,;:$&+=");
        }
        catch (URISyntaxException uRISyntaxException) {
            throw new URISyntaxException(string, Msg.getString("K0307", uRISyntaxException.getReason()), n + uRISyntaxException.getIndex());
        }
    }

    private void validatePath(String string, String string2, int n) {
        try {
            URIEncoderDecoder.validate(string2, "/@_-!.~'()*,;:$&+=");
        }
        catch (URISyntaxException uRISyntaxException) {
            throw new URISyntaxException(string, Msg.getString("K0308", uRISyntaxException.getReason()), n + uRISyntaxException.getIndex());
        }
    }

    private void validateQuery(String string, String string2, int n) {
        try {
            URIEncoderDecoder.validate(string2, "_-!.~'()*,;:$&+=?/[]@");
        }
        catch (URISyntaxException uRISyntaxException) {
            throw new URISyntaxException(string, Msg.getString("K0309", uRISyntaxException.getReason()), n + uRISyntaxException.getIndex());
        }
    }

    private void validateFragment(String string, String string2, int n) {
        try {
            URIEncoderDecoder.validate(string2, "_-!.~'()*,;:$&+=?/[]@");
        }
        catch (URISyntaxException uRISyntaxException) {
            throw new URISyntaxException(string, Msg.getString("K030a", uRISyntaxException.getReason()), n + uRISyntaxException.getIndex());
        }
    }

    private void parseAuthority(boolean bl) {
        int n;
        int n2;
        String string;
        String string2;
        block11: {
            if (URI.access$13(this.this$0) == null) {
                return;
            }
            string2 = null;
            string = null;
            n2 = 0;
            n = -1;
            String string3 = URI.access$13(this.this$0);
            int n3 = string3.indexOf(64);
            if (n3 != -1) {
                string2 = string3.substring(0, n3);
                this.validateUserinfo(URI.access$13(this.this$0), string2, 0);
                string3 = string3.substring(n3 + 1);
                n2 = n3 + 1;
            }
            n3 = string3.lastIndexOf(58);
            int n4 = string3.indexOf(93);
            if (n3 != -1 && n4 < n3) {
                string = string3.substring(0, n3);
                try {
                    n = Integer.parseInt(string3.substring(n3 + 1));
                    if (n < 0) {
                        if (bl) {
                            throw new URISyntaxException(URI.access$13(this.this$0), Msg.getString("K00b1"), n2 + n3 + 1);
                        }
                        return;
                    }
                    break block11;
                }
                catch (NumberFormatException numberFormatException) {
                    if (bl) {
                        throw new URISyntaxException(URI.access$13(this.this$0), Msg.getString("K00b1"), n2 + n3 + 1);
                    }
                    return;
                }
            }
            string = string3;
        }
        if (string.equals("")) {
            if (bl) {
                throw new URISyntaxException(URI.access$13(this.this$0), Msg.getString("K030c"), n2);
            }
            return;
        }
        if (!this.isValidHost(bl, string)) {
            return;
        }
        URI.access$15(this.this$0, string2);
        URI.access$16(this.this$0, string);
        URI.access$17(this.this$0, n);
        URI.access$18(this.this$0, true);
    }

    private void validateUserinfo(String string, String string2, int n) {
        int n2 = 0;
        while (n2 < string2.length()) {
            char c2 = string2.charAt(n2);
            if (c2 == ']' || c2 == '[') {
                throw new URISyntaxException(string, Msg.getString("K030d"), n + n2);
            }
            ++n2;
        }
    }

    private boolean isValidHost(boolean bl, String string) {
        if (string.charAt(0) == '[') {
            if (string.charAt(string.length() - 1) != ']') {
                throw new URISyntaxException(string, Msg.getString("K030e"), 0);
            }
            if (!this.isValidIP6Address(string)) {
                throw new URISyntaxException(string, Msg.getString("K030f"));
            }
            return true;
        }
        if (string.indexOf(91) != -1 || string.indexOf(93) != -1) {
            throw new URISyntaxException(string, Msg.getString("K0310"), 0);
        }
        int n = string.lastIndexOf(46);
        if (n < 0 || n == string.length() - 1 || !Character.isDigit(string.charAt(n + 1))) {
            if (this.isValidDomainName(string)) {
                return true;
            }
            if (bl) {
                throw new URISyntaxException(string, Msg.getString("K0310"), 0);
            }
            return false;
        }
        if (this.isValidIPv4Address(string)) {
            return true;
        }
        if (bl) {
            throw new URISyntaxException(string, Msg.getString("K0311"), 0);
        }
        return false;
    }

    private boolean isValidDomainName(String string) {
        char c2;
        try {
            URIEncoderDecoder.validateSimple(string, "-.");
        }
        catch (URISyntaxException uRISyntaxException) {
            return false;
        }
        String string2 = null;
        StringTokenizer stringTokenizer = new StringTokenizer(string, ".");
        while (stringTokenizer.hasMoreTokens()) {
            string2 = stringTokenizer.nextToken();
            if (!string2.startsWith("-") && !string2.endsWith("-")) continue;
            return false;
        }
        return string2.equals(string) || (c2 = string2.charAt(0)) < '0' || c2 > '9';
    }

    private boolean isValidIPv4Address(String string) {
        try {
            int n = string.indexOf(46);
            int n2 = Integer.parseInt(string.substring(0, n));
            if (n2 < 0 || n2 > 255) {
                return false;
            }
            int n3 = string.indexOf(46, n + 1);
            n2 = Integer.parseInt(string.substring(n + 1, n3));
            if (n2 < 0 || n2 > 255) {
                return false;
            }
            n = string.indexOf(46, n3 + 1);
            n2 = Integer.parseInt(string.substring(n3 + 1, n));
            if (n2 < 0 || n2 > 255) {
                return false;
            }
            n2 = Integer.parseInt(string.substring(n + 1));
            if (n2 < 0 || n2 > 255) {
                return false;
            }
        }
        catch (Exception exception) {
            return false;
        }
        return true;
    }

    private boolean isValidIP6Address(String string) {
        int n = string.length();
        boolean bl = false;
        int n2 = 0;
        int n3 = 0;
        String string2 = "";
        char c2 = '\u0000';
        char c3 = '\u0000';
        int n4 = 0;
        if (n < 2) {
            return false;
        }
        int n5 = 0;
        while (n5 < n) {
            c3 = c2;
            c2 = string.charAt(n5);
            switch (c2) {
                case '[': {
                    if (n5 != 0) {
                        return false;
                    }
                    if (string.charAt(n - 1) != ']') {
                        return false;
                    }
                    n4 = 1;
                    if (n >= 4) break;
                    return false;
                }
                case ']': {
                    if (n5 != n - 1) {
                        return false;
                    }
                    if (string.charAt(0) == '[') break;
                    return false;
                }
                case '.': {
                    if (++n3 > 3) {
                        return false;
                    }
                    if (!this.isValidIP4Word(string2)) {
                        return false;
                    }
                    if (n2 != 6 && !bl) {
                        return false;
                    }
                    if (n2 == 7 && string.charAt(0 + n4) != ':' && string.charAt(1 + n4) != ':') {
                        return false;
                    }
                    string2 = "";
                    break;
                }
                case ':': {
                    if (++n2 > 7) {
                        return false;
                    }
                    if (n3 > 0) {
                        return false;
                    }
                    if (c3 == ':') {
                        if (bl) {
                            return false;
                        }
                        bl = true;
                    }
                    string2 = "";
                    break;
                }
                default: {
                    if (string2.length() > 3) {
                        return false;
                    }
                    if (!this.isValidHexChar(c2)) {
                        return false;
                    }
                    string2 = new StringBuffer(String.valueOf(string2)).append(c2).toString();
                }
            }
            ++n5;
        }
        if (n3 > 0) {
            if (n3 != 3 || !this.isValidIP4Word(string2)) {
                return false;
            }
        } else {
            if (n2 != 7 && !bl) {
                return false;
            }
            if (string2 == "" && string.charAt(n - 1 - n4) != ':' && string.charAt(n - 2 - n4) != ':') {
                return false;
            }
        }
        return true;
    }

    private boolean isValidIP4Word(String string) {
        if (string.length() < 1 || string.length() > 3) {
            return false;
        }
        int n = 0;
        while (n < string.length()) {
            char c2 = string.charAt(n);
            if (c2 < '0' || c2 > '9') {
                return false;
            }
            ++n;
        }
        return Integer.parseInt(string) <= 255;
    }

    private boolean isValidHexChar(char c2) {
        return c2 >= '0' && c2 <= '9' || c2 >= 'A' && c2 <= 'F' || c2 >= 'a' && c2 <= 'f';
    }

    static /* synthetic */ void access$0(URI$Helper uRI$Helper, String string, boolean bl) {
        uRI$Helper.parseURI(string, bl);
    }

    static /* synthetic */ void access$1(URI$Helper uRI$Helper, boolean bl) {
        uRI$Helper.parseAuthority(bl);
    }
}

