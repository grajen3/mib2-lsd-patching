/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.shader;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.util.StringBuilder;

public final class ShaderVariable {
    public static final int SHADERVARIABLE_TYPE_VERTEX_ATTRIBUTE;
    public static final int SHADERVARIABLE_TYPE_UNIFORM;
    public static final int SHADERVARIABLE_DATATYPE_FLOAT_SCALAR;
    public static final int SHADERVARIABLE_DATATYPE_FLOAT_VEC2;
    public static final int SHADERVARIABLE_DATATYPE_FLOAT_VEC3;
    public static final int SHADERVARIABLE_DATATYPE_FLOAT_VEC4;
    public static final int SHADERVARIABLE_DATATYPE_FLOAT_MAT2;
    public static final int SHADERVARIABLE_DATATYPE_FLOAT_MAT3;
    public static final int SHADERVARIABLE_DATATYPE_FLOAT_MAT4;
    public static final int SHADERVARIABLE_DATATYPE_INT_SCALAR;
    public static final int SHADERVARIABLE_DATATYPE_INT_VEC2;
    public static final int SHADERVARIABLE_DATATYPE_INT_VEC3;
    public static final int SHADERVARIABLE_DATATYPE_INT_VEC4;
    public static final int SHADERVARIABLE_DATATYPE_BOOL_SCALAR;
    public static final int SHADERVARIABLE_DATATYPE_BOOL_VEC2;
    public static final int SHADERVARIABLE_DATATYPE_BOOL_VEC3;
    public static final int SHADERVARIABLE_DATATYPE_BOOL_VEC4;
    public static final int SHADERVARIABLE_DATATYPE_SAMPLER_2D;
    public static final int SHADERVARIABLE_DATATYPE_SAMPLER_CUBE;
    private final int type;
    private final String name;
    private final int dataType;
    private final int count;
    private final int location;

    public ShaderVariable(int n, String string, int n2, int n3, int n4) {
        this.type = n;
        this.name = string;
        this.dataType = n2;
        this.count = n3;
        this.location = n4;
    }

    public int hashCode() {
        HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
        hashCodeBuilder.append(this.type);
        hashCodeBuilder.append(this.name);
        hashCodeBuilder.append(this.dataType);
        hashCodeBuilder.append(this.count);
        hashCodeBuilder.append(this.location);
        return hashCodeBuilder.hashCode();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object != null && super.getClass() == object.getClass()) {
            ShaderVariable shaderVariable = (ShaderVariable)object;
            return this.type == shaderVariable.type && this.name.equals(shaderVariable.name) && this.dataType == shaderVariable.dataType && this.count == shaderVariable.count && this.location == shaderVariable.location;
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[type=").append(this.type);
        stringBuilder.append(",name=").append(this.name);
        stringBuilder.append(",dataType=").append(this.dataType);
        stringBuilder.append(",count=").append(this.count);
        stringBuilder.append(",location=").append(this.location);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public int getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public int getDataType() {
        return this.dataType;
    }

    public String getDataTypeName() {
        switch (this.dataType) {
            case 0: {
                return "float";
            }
            case 1: {
                return "vec2";
            }
            case 2: {
                return "vec3";
            }
            case 3: {
                return "vec4";
            }
            case 4: {
                return "mat2";
            }
            case 5: {
                return "mat3";
            }
            case 6: {
                return "mat4";
            }
            case 7: {
                return "int";
            }
            case 8: {
                return "ivec2";
            }
            case 9: {
                return "ivec3";
            }
            case 10: {
                return "ivec4";
            }
            case 11: {
                return "bool";
            }
            case 12: {
                return "bvec2";
            }
            case 13: {
                return "bvec3";
            }
            case 14: {
                return "bvec4";
            }
            case 15: {
                return "sampler2D";
            }
            case 16: {
                return "samplerCube";
            }
        }
        return new StringBuilder("0x").append(Integer.toHexString(this.dataType)).toString();
    }

    public int getCount() {
        return this.count;
    }

    public int getLocation() {
        return this.location;
    }

    public boolean isArray() {
        return this.count > 1;
    }
}

