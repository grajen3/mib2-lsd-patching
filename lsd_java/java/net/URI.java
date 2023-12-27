/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import com.ibm.oti.util.Msg;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URI$Helper;
import java.net.URIEncoderDecoder;
import java.net.URISyntaxException;
import java.net.URL;

public final class URI
implements Comparable,
Serializable {
    private static final long serialVersionUID;
    static final String unreserved;
    static final String punct;
    static final String reserved;
    static final String someLegal;
    static final String allLegal;
    private String string = null;
    private transient String scheme = null;
    private transient String schemespecificpart = null;
    private transient String authority = null;
    private transient String userinfo = null;
    private transient String host = null;
    private transient int port = -1;
    private transient String path = null;
    private transient String query = null;
    private transient String fragment = null;
    private transient boolean opaque;
    private transient boolean absolute;
    private transient boolean serverAuthority = false;
    private transient int hash = -1;

    private URI() {
    }

    public URI(String string) {
        URI$Helper.access$0(new URI$Helper(this), string, false);
    }

    public URI(String string, String string2, String string3) {
        StringBuffer stringBuffer = new StringBuffer();
        if (string != null) {
            stringBuffer.append(string);
            stringBuffer.append(':');
        }
        if (string2 != null) {
            stringBuffer.append(this.quoteComponent(string2, "_-!.~'()*,;:$&+=?/[]@"));
        }
        if (string3 != null) {
            stringBuffer.append('#');
            stringBuffer.append(this.quoteComponent(string3, "_-!.~'()*,;:$&+=?/[]@"));
        }
        URI$Helper.access$0(new URI$Helper(this), stringBuffer.toString(), false);
    }

    public URI(String string, String string2, String string3, int n, String string4, String string5, String string6) {
        if (string != null && string4 != null && string4.length() > 0 && string4.charAt(0) != '/') {
            throw new URISyntaxException(string4, Msg.getString("K0302"));
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (string != null) {
            stringBuffer.append(string);
            stringBuffer.append(':');
        }
        if (string2 != null || string3 != null || n != -1) {
            stringBuffer.append("//");
        }
        if (string2 != null) {
            stringBuffer.append(this.quoteComponent(string2, "_-!.~'()*,;:$&+="));
            stringBuffer.append('@');
        }
        if (string3 != null) {
            if (string3.indexOf(58) != -1 && string3.indexOf(93) == -1 && string3.indexOf(91) == -1) {
                string3 = new StringBuffer("[").append(string3).append("]").toString();
            }
            stringBuffer.append(string3);
        }
        if (n != -1) {
            stringBuffer.append(':');
            stringBuffer.append(n);
        }
        if (string4 != null) {
            stringBuffer.append(this.quoteComponent(string4, "/@_-!.~'()*,;:$&+="));
        }
        if (string5 != null) {
            stringBuffer.append('?');
            stringBuffer.append(this.quoteComponent(string5, "_-!.~'()*,;:$&+=?/[]@"));
        }
        if (string6 != null) {
            stringBuffer.append('#');
            stringBuffer.append(this.quoteComponent(string6, "_-!.~'()*,;:$&+=?/[]@"));
        }
        URI$Helper.access$0(new URI$Helper(this), stringBuffer.toString(), true);
    }

    public URI(String string, String string2, String string3, String string4) {
        this(string, null, string2, -1, string3, null, string4);
    }

    public URI(String string, String string2, String string3, String string4, String string5) {
        if (string != null && string3 != null && string3.length() > 0 && string3.charAt(0) != '/') {
            throw new URISyntaxException(string3, Msg.getString("K0302"));
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (string != null) {
            stringBuffer.append(string);
            stringBuffer.append(':');
        }
        if (string2 != null) {
            stringBuffer.append("//");
            stringBuffer.append(this.quoteComponent(string2, "@[]_-!.~'()*,;:$&+="));
        }
        if (string3 != null) {
            stringBuffer.append(this.quoteComponent(string3, "/@_-!.~'()*,;:$&+="));
        }
        if (string4 != null) {
            stringBuffer.append('?');
            stringBuffer.append(this.quoteComponent(string4, "_-!.~'()*,;:$&+=?/[]@"));
        }
        if (string5 != null) {
            stringBuffer.append('#');
            stringBuffer.append(this.quoteComponent(string5, "_-!.~'()*,;:$&+=?/[]@"));
        }
        URI$Helper.access$0(new URI$Helper(this), stringBuffer.toString(), false);
    }

    private String quoteComponent(String string, String string2) {
        try {
            return URIEncoderDecoder.quoteIllegal(string, string2);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new RuntimeException(unsupportedEncodingException);
        }
    }

    @Override
    public int compareTo(Object object) {
        if (!(object instanceof URI)) {
            throw new ClassCastException();
        }
        URI uRI = (URI)object;
        int n = 0;
        if (this.scheme == null && uRI.scheme != null) {
            return -1;
        }
        if (this.scheme != null && uRI.scheme == null) {
            return 1;
        }
        if (this.scheme != null && uRI.scheme != null && (n = this.scheme.compareToIgnoreCase(uRI.scheme)) != 0) {
            return n;
        }
        if (!this.opaque && uRI.opaque) {
            return -1;
        }
        if (this.opaque && !uRI.opaque) {
            return 1;
        }
        if (this.opaque && uRI.opaque) {
            n = this.schemespecificpart.compareTo(uRI.schemespecificpart);
            if (n != 0) {
                return n;
            }
        } else {
            if (this.authority != null && uRI.authority == null) {
                return 1;
            }
            if (this.authority == null && uRI.authority != null) {
                return -1;
            }
            if (this.authority != null && uRI.authority != null) {
                if (this.host != null && uRI.host != null) {
                    if (this.userinfo != null && uRI.userinfo == null) {
                        return 1;
                    }
                    if (this.userinfo == null && uRI.userinfo != null) {
                        return -1;
                    }
                    if (this.userinfo != null && uRI.userinfo != null && (n = this.userinfo.compareTo(uRI.userinfo)) != 0) {
                        return n;
                    }
                    n = this.host.compareToIgnoreCase(uRI.host);
                    if (n != 0) {
                        return n;
                    }
                    if (this.port != uRI.port) {
                        return this.port - uRI.port;
                    }
                } else {
                    n = this.authority.compareTo(uRI.authority);
                    if (n != 0) {
                        return n;
                    }
                }
            }
            if ((n = this.path.compareTo(uRI.path)) != 0) {
                return n;
            }
            if (this.query != null && uRI.query == null) {
                return 1;
            }
            if (this.query == null && uRI.query != null) {
                return -1;
            }
            if (this.query != null && uRI.query != null && (n = this.query.compareTo(uRI.query)) != 0) {
                return n;
            }
        }
        if (this.fragment != null && uRI.fragment == null) {
            return 1;
        }
        if (this.fragment == null && uRI.fragment != null) {
            return -1;
        }
        if (this.fragment != null && uRI.fragment != null && (n = this.fragment.compareTo(uRI.fragment)) != 0) {
            return n;
        }
        return 0;
    }

    public static URI create(String string) {
        URI uRI = null;
        try {
            uRI = new URI(string);
        }
        catch (URISyntaxException uRISyntaxException) {
            throw new IllegalArgumentException(uRISyntaxException.getMessage());
        }
        return uRI;
    }

    private URI duplicate() {
        URI uRI = new URI();
        uRI.absolute = this.absolute;
        uRI.authority = this.authority;
        uRI.fragment = this.fragment;
        uRI.host = this.host;
        uRI.opaque = this.opaque;
        uRI.path = this.path;
        uRI.port = this.port;
        uRI.query = this.query;
        uRI.scheme = this.scheme;
        uRI.schemespecificpart = this.schemespecificpart;
        uRI.userinfo = this.userinfo;
        uRI.serverAuthority = this.serverAuthority;
        return uRI;
    }

    private String convertHexToLowerCase(String string) {
        StringBuffer stringBuffer = new StringBuffer("");
        if (string.indexOf(37) == -1) {
            return string;
        }
        int n = 0;
        int n2 = 0;
        while ((n = string.indexOf(37, n2)) != -1) {
            stringBuffer.append(string.substring(n2, n + 1));
            stringBuffer.append(string.substring(n + 1, n + 3).toLowerCase());
            n2 = n += 3;
        }
        return stringBuffer.toString();
    }

    private boolean equalsHexCaseInsensitive(String string, String string2) {
        if (string.indexOf(37) != string2.indexOf(37)) {
            return string.equals(string2);
        }
        int n = 0;
        int n2 = 0;
        while ((n = string.indexOf(37, n2)) != -1 && string2.indexOf(37, n2) == n) {
            boolean bl = string.substring(n2, n).equals(string2.substring(n2, n));
            if (!bl) {
                return false;
            }
            bl = string.substring(n + 1, n + 3).equalsIgnoreCase(string2.substring(n + 1, n + 3));
            if (!bl) {
                return false;
            }
            n2 = n += 3;
        }
        return string.substring(n2).equals(string2.substring(n2));
    }

    public boolean equals(Object object) {
        if (!(object instanceof URI)) {
            return false;
        }
        URI uRI = (URI)object;
        if (uRI.fragment == null && this.fragment != null || uRI.fragment != null && this.fragment == null) {
            return false;
        }
        if (uRI.fragment != null && this.fragment != null && !this.equalsHexCaseInsensitive(uRI.fragment, this.fragment)) {
            return false;
        }
        if (uRI.scheme == null && this.scheme != null || uRI.scheme != null && this.scheme == null) {
            return false;
        }
        if (uRI.scheme != null && this.scheme != null && !uRI.scheme.equalsIgnoreCase(this.scheme)) {
            return false;
        }
        if (uRI.opaque && this.opaque) {
            return this.equalsHexCaseInsensitive(uRI.schemespecificpart, this.schemespecificpart);
        }
        if (!uRI.opaque && !this.opaque) {
            if (!this.equalsHexCaseInsensitive(this.path, uRI.path)) {
                return false;
            }
            if (uRI.query != null && this.query == null || uRI.query == null && this.query != null) {
                return false;
            }
            if (uRI.query != null && this.query != null && !this.equalsHexCaseInsensitive(uRI.query, this.query)) {
                return false;
            }
            if (uRI.authority != null && this.authority == null || uRI.authority == null && this.authority != null) {
                return false;
            }
            if (uRI.authority != null && this.authority != null) {
                if (uRI.host != null && this.host == null || uRI.host == null && this.host != null) {
                    return false;
                }
                if (uRI.host == null && this.host == null) {
                    return this.equalsHexCaseInsensitive(uRI.authority, this.authority);
                }
                if (!this.host.equalsIgnoreCase(uRI.host)) {
                    return false;
                }
                if (this.port != uRI.port) {
                    return false;
                }
                if (uRI.userinfo != null && this.userinfo == null || uRI.userinfo == null && this.userinfo != null) {
                    return false;
                }
                if (uRI.userinfo != null && this.userinfo != null) {
                    return this.equalsHexCaseInsensitive(this.userinfo, uRI.userinfo);
                }
                return true;
            }
            return true;
        }
        return false;
    }

    public String getAuthority() {
        return this.decode(this.authority);
    }

    public String getFragment() {
        return this.decode(this.fragment);
    }

    public String getHost() {
        return this.host;
    }

    public String getPath() {
        return this.decode(this.path);
    }

    public int getPort() {
        return this.port;
    }

    public String getQuery() {
        return this.decode(this.query);
    }

    public String getRawAuthority() {
        return this.authority;
    }

    public String getRawFragment() {
        return this.fragment;
    }

    public String getRawPath() {
        return this.path;
    }

    public String getRawQuery() {
        return this.query;
    }

    public String getRawSchemeSpecificPart() {
        return this.schemespecificpart;
    }

    public String getRawUserInfo() {
        return this.userinfo;
    }

    public String getScheme() {
        return this.scheme;
    }

    public String getSchemeSpecificPart() {
        return this.decode(this.schemespecificpart);
    }

    public String getUserInfo() {
        return this.decode(this.userinfo);
    }

    public int hashCode() {
        if (this.hash == -1) {
            this.hash = this.getHashString().hashCode();
        }
        return this.hash;
    }

    public boolean isAbsolute() {
        return this.absolute;
    }

    public boolean isOpaque() {
        return this.opaque;
    }

    private String normalize(String string) {
        int n = string.indexOf(58);
        int n2 = string.indexOf(47);
        StringBuffer stringBuffer = new StringBuffer();
        n = 0;
        n2 = 0;
        int n3 = string.length();
        n = -1;
        int n4 = 0;
        if (n3 > 0 && string.charAt(0) != '/') {
            ++n4;
        }
        while ((n = string.indexOf(47, n + 1)) != -1) {
            if (n + 1 >= n3 || string.charAt(n + 1) == '/') continue;
            ++n4;
        }
        String[] stringArray = new String[n4];
        boolean[] blArray = new boolean[n4];
        int n5 = 0;
        n = n3 > 0 && string.charAt(0) == '/' ? 1 : 0;
        while ((n2 = string.indexOf(47, n + 1)) != -1) {
            stringArray[n5++] = string.substring(n, n2);
            n = n2 + 1;
        }
        if (n5 < n4) {
            stringArray[n5] = string.substring(n);
        }
        int n6 = 0;
        while (n6 < n4) {
            blArray[n6] = true;
            if (stringArray[n6].equals("..")) {
                int n7 = n6 - 1;
                while (n7 > -1 && !blArray[n7]) {
                    --n7;
                }
                if (n7 > -1 && !stringArray[n7].equals("..")) {
                    blArray[n7] = false;
                    blArray[n6] = false;
                }
            } else if (stringArray[n6].equals(".")) {
                blArray[n6] = false;
            }
            ++n6;
        }
        stringBuffer = new StringBuffer();
        if (string.startsWith("/")) {
            stringBuffer.append('/');
        }
        n6 = 0;
        while (n6 < stringArray.length) {
            if (blArray[n6]) {
                stringBuffer.append(stringArray[n6]);
                stringBuffer.append('/');
            }
            ++n6;
        }
        if (!string.endsWith("/") && stringArray.length > 0 && blArray[stringArray.length - 1]) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        String string2 = stringBuffer.toString();
        n = string2.indexOf(58);
        n2 = string2.indexOf(47);
        if (n != -1 && (n < n2 || n2 == -1)) {
            stringBuffer.insert(0, "./");
            string2 = stringBuffer.toString();
        }
        return string2;
    }

    public URI normalize() {
        if (this.opaque) {
            return this;
        }
        String string = this.normalize(this.path);
        if (this.path.equals(string)) {
            return this;
        }
        URI uRI = this.duplicate();
        uRI.path = string;
        uRI.setSchemeSpecificPart();
        return uRI;
    }

    public URI parseServerAuthority() {
        if (!this.serverAuthority) {
            URI$Helper.access$1(new URI$Helper(this), true);
        }
        return this;
    }

    public URI relativize(URI uRI) {
        if (uRI.opaque || this.opaque) {
            return uRI;
        }
        if (this.scheme == null ? uRI.scheme != null : !this.scheme.equals(uRI.scheme)) {
            return uRI;
        }
        if (this.authority == null ? uRI.authority != null : !this.authority.equals(uRI.authority)) {
            return uRI;
        }
        String string = null;
        string = this.path.endsWith("/") ? this.path : new StringBuffer(String.valueOf(this.path)).append("/").toString();
        String string2 = this.normalize(uRI.path);
        if (!string2.startsWith(string = this.normalize(string))) {
            return uRI;
        }
        URI uRI2 = new URI();
        uRI2.fragment = uRI.fragment;
        uRI2.query = uRI.query;
        uRI2.path = string2.substring(string.length());
        return uRI2;
    }

    public URI resolve(URI uRI) {
        URI uRI2;
        if (uRI.absolute || this.opaque) {
            return uRI;
        }
        if (uRI.path.equals("") && uRI.scheme == null && uRI.authority == null && uRI.query == null && uRI.fragment != null) {
            URI uRI3 = this.duplicate();
            uRI3.fragment = uRI.fragment;
            return uRI3;
        }
        if (uRI.authority != null) {
            uRI2 = uRI.duplicate();
            uRI2.scheme = this.scheme;
            uRI2.absolute = this.absolute;
        } else {
            uRI2 = this.duplicate();
            uRI2.fragment = uRI.fragment;
            uRI2.query = uRI.query;
            if (uRI.path.startsWith("/")) {
                uRI2.path = uRI.path;
            } else {
                int n = this.path.lastIndexOf(47) + 1;
                uRI2.path = this.normalize(new StringBuffer(String.valueOf(this.path.substring(0, n))).append(uRI.path).toString());
            }
            uRI2.setSchemeSpecificPart();
        }
        return uRI2;
    }

    private void setSchemeSpecificPart() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.authority != null) {
            stringBuffer.append(new StringBuffer("//").append(this.authority).toString());
        }
        if (this.path != null) {
            stringBuffer.append(this.path);
        }
        if (this.query != null) {
            stringBuffer.append(new StringBuffer("?").append(this.query).toString());
        }
        this.schemespecificpart = stringBuffer.toString();
        this.string = null;
    }

    public URI resolve(String string) {
        return this.resolve(URI.create(string));
    }

    private String encodeOthers(String string) {
        try {
            return URIEncoderDecoder.encodeOthers(string);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new RuntimeException(unsupportedEncodingException);
        }
    }

    private String decode(String string) {
        if (string == null) {
            return string;
        }
        try {
            return URIEncoderDecoder.decode(string);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new RuntimeException(unsupportedEncodingException);
        }
    }

    public String toASCIIString() {
        return this.encodeOthers(this.toString());
    }

    public String toString() {
        if (this.string == null) {
            StringBuffer stringBuffer = new StringBuffer();
            if (this.scheme != null) {
                stringBuffer.append(this.scheme);
                stringBuffer.append(':');
            }
            if (this.opaque) {
                stringBuffer.append(this.schemespecificpart);
            } else {
                if (this.authority != null) {
                    stringBuffer.append("//");
                    stringBuffer.append(this.authority);
                }
                if (this.path != null) {
                    stringBuffer.append(this.path);
                }
                if (this.query != null) {
                    stringBuffer.append('?');
                    stringBuffer.append(this.query);
                }
            }
            if (this.fragment != null) {
                stringBuffer.append('#');
                stringBuffer.append(this.fragment);
            }
            this.string = stringBuffer.toString();
        }
        return this.string;
    }

    private String getHashString() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.scheme != null) {
            stringBuffer.append(this.scheme.toLowerCase());
            stringBuffer.append(':');
        }
        if (this.opaque) {
            stringBuffer.append(this.schemespecificpart);
        } else {
            if (this.authority != null) {
                stringBuffer.append("//");
                if (this.host == null) {
                    stringBuffer.append(this.authority);
                } else {
                    if (this.userinfo != null) {
                        stringBuffer.append(new StringBuffer(String.valueOf(this.userinfo)).append("@").toString());
                    }
                    stringBuffer.append(this.host.toLowerCase());
                    if (this.port != -1) {
                        stringBuffer.append(new StringBuffer(":").append(this.port).toString());
                    }
                }
            }
            if (this.path != null) {
                stringBuffer.append(this.path);
            }
            if (this.query != null) {
                stringBuffer.append('?');
                stringBuffer.append(this.query);
            }
        }
        if (this.fragment != null) {
            stringBuffer.append('#');
            stringBuffer.append(this.fragment);
        }
        return this.convertHexToLowerCase(stringBuffer.toString());
    }

    public URL toURL() {
        if (!this.absolute) {
            throw new IllegalArgumentException(new StringBuffer(String.valueOf(Msg.getString("K0312"))).append(": ").append(this.toString()).toString());
        }
        return new URL(this.toString());
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        try {
            URI$Helper.access$0(new URI$Helper(this), this.string, false);
        }
        catch (URISyntaxException uRISyntaxException) {
            throw new IOException(uRISyntaxException.toString());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        this.toString();
        objectOutputStream.defaultWriteObject();
    }

    static /* synthetic */ void access$0(URI uRI, String string) {
        uRI.string = string;
    }

    static /* synthetic */ void access$1(URI uRI, String string) {
        uRI.fragment = string;
    }

    static /* synthetic */ String access$2(URI uRI) {
        return uRI.fragment;
    }

    static /* synthetic */ void access$3(URI uRI, boolean bl) {
        uRI.absolute = bl;
    }

    static /* synthetic */ void access$4(URI uRI, String string) {
        uRI.scheme = string;
    }

    static /* synthetic */ String access$5(URI uRI) {
        return uRI.scheme;
    }

    static /* synthetic */ void access$6(URI uRI, String string) {
        uRI.schemespecificpart = string;
    }

    static /* synthetic */ String access$7(URI uRI) {
        return uRI.schemespecificpart;
    }

    static /* synthetic */ void access$8(URI uRI, boolean bl) {
        uRI.opaque = bl;
    }

    static /* synthetic */ void access$9(URI uRI, String string) {
        uRI.query = string;
    }

    static /* synthetic */ String access$10(URI uRI) {
        return uRI.query;
    }

    static /* synthetic */ void access$11(URI uRI, String string) {
        uRI.authority = string;
    }

    static /* synthetic */ void access$12(URI uRI, String string) {
        uRI.path = string;
    }

    static /* synthetic */ String access$13(URI uRI) {
        return uRI.authority;
    }

    static /* synthetic */ String access$14(URI uRI) {
        return uRI.path;
    }

    static /* synthetic */ void access$15(URI uRI, String string) {
        uRI.userinfo = string;
    }

    static /* synthetic */ void access$16(URI uRI, String string) {
        uRI.host = string;
    }

    static /* synthetic */ void access$17(URI uRI, int n) {
        uRI.port = n;
    }

    static /* synthetic */ void access$18(URI uRI, boolean bl) {
        uRI.serverAuthority = bl;
    }
}

