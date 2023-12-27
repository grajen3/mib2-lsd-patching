/*
 * Decompiled with CFR 0.152.
 */
package java.net;

public final class PasswordAuthentication {
    private String userName;
    private char[] password;

    public PasswordAuthentication(String string, char[] cArray) {
        this.userName = string;
        this.password = (char[])cArray.clone();
    }

    public char[] getPassword() {
        return (char[])this.password.clone();
    }

    public String getUserName() {
        return this.userName;
    }
}

