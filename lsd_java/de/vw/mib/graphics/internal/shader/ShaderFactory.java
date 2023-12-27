/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.shader;

import de.vw.mib.graphics.internal.shader.ShaderFactory$ShaderSource;
import de.vw.mib.graphics.internal.shader.ShaderFactory$ShaderSourceCache;
import de.vw.mib.util.StringBuilder;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public final class ShaderFactory {
    private final ShaderFactory$ShaderSourceCache shaderSourceCache = new ShaderFactory$ShaderSourceCache();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String readShaderSourceFromFile(String string) {
        long l = string.hashCode();
        ShaderFactory$ShaderSource shaderFactory$ShaderSource = (ShaderFactory$ShaderSource)this.shaderSourceCache.get(l);
        if (shaderFactory$ShaderSource == null) {
            InputStream inputStream = super.getClass().getResourceAsStream(string);
            if (inputStream == null) {
                inputStream = new FileInputStream(string);
            }
            try {
                int n;
                int n2 = 4096;
                StringBuilder stringBuilder = new StringBuilder(4096);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] cArray = new char[4096];
                while ((n = bufferedReader.read(cArray, 0, cArray.length)) != -1) {
                    stringBuilder.append(cArray, 0, n);
                }
                shaderFactory$ShaderSource = new ShaderFactory$ShaderSource(stringBuilder.toString());
                this.shaderSourceCache.put(l, shaderFactory$ShaderSource);
            }
            finally {
                if (inputStream != null) {
                    inputStream.close();
                }
            }
        }
        return shaderFactory$ShaderSource.source;
    }
}

