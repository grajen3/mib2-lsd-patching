/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.effect.shader.variable;

import de.vw.mib.graphics.internal.effect.shader.variable.ShaderEffectVariable;
import de.vw.mib.graphics.math.Tuple2f;
import de.vw.mib.graphics.math.Tuple3f;
import de.vw.mib.graphics.math.Tuple4f;
import de.vw.mib.graphics.math.algebra.Matrix2f;
import de.vw.mib.graphics.math.algebra.Matrix3f;
import de.vw.mib.graphics.math.algebra.Matrix4f;
import de.vw.mib.graphics.shader.ShaderProgram;
import de.vw.mib.graphics.shader.ShaderVariable;
import de.vw.mib.util.StringBuilder;

public abstract class AbstractShaderEffectVariable
implements ShaderEffectVariable {
    private final ShaderProgram shaderProgram;
    private final ShaderVariable shaderVariable;
    private final int type;
    private final String name;
    private final int dataType;
    private final int count;
    private final int index;
    protected final boolean setAlways;

    public AbstractShaderEffectVariable(ShaderProgram shaderProgram, int n, String string, int n2, int n3) {
        this.shaderProgram = shaderProgram;
        this.type = n;
        this.name = string;
        this.dataType = n2;
        this.count = n3;
        switch (n) {
            case 1: {
                this.shaderVariable = shaderProgram.getUniform(string);
                break;
            }
            case 0: {
                this.shaderVariable = shaderProgram.getVertexAttribute(string);
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid type");
            }
        }
        this.index = this.shaderVariable != null ? this.shaderVariable.getLocation() : -1;
        this.setAlways = n == 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[type=").append(this.type);
        stringBuilder.append(",name=").append(this.name);
        stringBuilder.append(",dataType=").append(this.dataType);
        stringBuilder.append(",count=").append(this.count);
        stringBuilder.append(",index=").append(this.index);
        stringBuilder.append(",setAlways=").append(this.setAlways);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public final int getType() {
        return this.type;
    }

    @Override
    public final String getName() {
        return this.name;
    }

    @Override
    public int getDataType() {
        return this.dataType;
    }

    @Override
    public int getCount() {
        return this.count;
    }

    public int getLocation() {
        return this.index;
    }

    @Override
    public final ShaderVariable getShaderVariable() {
        return this.shaderVariable;
    }

    @Override
    public final boolean isCompatible() {
        return this.shaderVariable != null && this.shaderVariable.getDataType() == this.dataType && this.shaderVariable.getCount() == this.count;
    }

    protected final void setShaderParameter(boolean bl) {
        if (this.index != -1) {
            switch (this.type) {
                case 1: {
                    this.shaderProgram.setUniform(this.index, bl);
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Invalid type");
                }
            }
        }
    }

    protected final void setShaderParameter(int n) {
        if (this.index != -1) {
            switch (this.type) {
                case 1: {
                    this.shaderProgram.setUniform(this.index, n);
                    break;
                }
                case 0: {
                    this.shaderProgram.setVertexAttribute(this.index, n);
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Invalid type");
                }
            }
        }
    }

    protected final void setShaderParameter(int[] nArray) {
        if (this.index != -1) {
            switch (this.type) {
                case 1: {
                    this.shaderProgram.setUniform(this.index, nArray);
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Invalid type");
                }
            }
        }
    }

    protected final void setShaderParameter(int n, int n2) {
        if (this.index != -1) {
            switch (this.type) {
                case 1: {
                    this.shaderProgram.setUniform(this.index, n, n2);
                    break;
                }
                case 0: {
                    this.shaderProgram.setVertexAttribute(this.index, n, n2);
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Invalid type");
                }
            }
        }
    }

    protected final void setShaderParameter(int n, int n2, int n3) {
        if (this.index != -1) {
            switch (this.type) {
                case 1: {
                    this.shaderProgram.setUniform(this.index, n, n2, n3);
                    break;
                }
                case 0: {
                    this.shaderProgram.setVertexAttribute(this.index, n, n2, n3);
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Invalid type");
                }
            }
        }
    }

    protected final void setShaderParameter(int n, int n2, int n3, int n4) {
        if (this.index != -1) {
            switch (this.type) {
                case 1: {
                    this.shaderProgram.setUniform(this.index, n, n2, n3, n4);
                    break;
                }
                case 0: {
                    this.shaderProgram.setVertexAttribute(this.index, n, n2, n3, n4);
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Invalid type");
                }
            }
        }
    }

    protected final void setShaderParameter(float f2) {
        if (this.index != -1) {
            switch (this.type) {
                case 1: {
                    this.shaderProgram.setUniform(this.index, f2);
                    break;
                }
                case 0: {
                    this.shaderProgram.setVertexAttribute(this.index, f2);
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Invalid type");
                }
            }
        }
    }

    protected final void setShaderParameter(float[] fArray) {
        if (this.index != -1) {
            switch (this.type) {
                case 1: {
                    this.shaderProgram.setUniform(this.index, fArray);
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Invalid type");
                }
            }
        }
    }

    protected final void setShaderParameter(float f2, float f3) {
        if (this.index != -1) {
            switch (this.type) {
                case 1: {
                    this.shaderProgram.setUniform(this.index, f2, f3);
                    break;
                }
                case 0: {
                    this.shaderProgram.setVertexAttribute(this.index, f2, f3);
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Invalid type");
                }
            }
        }
    }

    protected final void setShaderParameter(Tuple2f tuple2f) {
        if (this.index != -1) {
            switch (this.type) {
                case 1: {
                    this.shaderProgram.setUniform(this.index, tuple2f);
                    break;
                }
                case 0: {
                    this.shaderProgram.setVertexAttribute(this.index, tuple2f);
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Invalid type");
                }
            }
        }
    }

    protected final void setShaderParameter(Tuple2f[] tuple2fArray) {
        if (this.index != -1) {
            switch (this.type) {
                case 1: {
                    this.shaderProgram.setUniform(this.index, tuple2fArray);
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Invalid type");
                }
            }
        }
    }

    protected final void setShaderParameter(float f2, float f3, float f4) {
        if (this.index != -1) {
            switch (this.type) {
                case 1: {
                    this.shaderProgram.setUniform(this.index, f2, f3, f4);
                    break;
                }
                case 0: {
                    this.shaderProgram.setVertexAttribute(this.index, f2, f3, f4);
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Invalid type");
                }
            }
        }
    }

    protected final void setShaderParameter(Tuple3f tuple3f) {
        if (this.index != -1) {
            switch (this.type) {
                case 1: {
                    this.shaderProgram.setUniform(this.index, tuple3f);
                    break;
                }
                case 0: {
                    this.shaderProgram.setVertexAttribute(this.index, tuple3f);
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Invalid type");
                }
            }
        }
    }

    protected final void setShaderParameter(Tuple3f[] tuple3fArray) {
        if (this.index != -1) {
            switch (this.type) {
                case 1: {
                    this.shaderProgram.setUniform(this.index, tuple3fArray);
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Invalid type");
                }
            }
        }
    }

    protected final void setShaderParameter(float f2, float f3, float f4, float f5) {
        if (this.index != -1) {
            switch (this.type) {
                case 1: {
                    this.shaderProgram.setUniform(this.index, f2, f3, f4, f5);
                    break;
                }
                case 0: {
                    this.shaderProgram.setVertexAttribute(this.index, f2, f3, f4, f5);
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Invalid type");
                }
            }
        }
    }

    protected final void setShaderParameter(Tuple4f tuple4f) {
        if (this.index != -1) {
            switch (this.type) {
                case 1: {
                    this.shaderProgram.setUniform(this.index, tuple4f);
                    break;
                }
                case 0: {
                    this.shaderProgram.setVertexAttribute(this.index, tuple4f);
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Invalid type");
                }
            }
        }
    }

    protected final void setShaderParameter(Tuple4f[] tuple4fArray) {
        if (this.index != -1) {
            switch (this.type) {
                case 1: {
                    this.shaderProgram.setUniform(this.index, tuple4fArray);
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Invalid type");
                }
            }
        }
    }

    protected final void setShaderParameter(Matrix2f matrix2f) {
        if (this.index != -1) {
            switch (this.type) {
                case 1: {
                    this.shaderProgram.setUniform(this.index, matrix2f);
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Invalid type");
                }
            }
        }
    }

    protected final void setShaderParameter(Matrix2f[] matrix2fArray) {
        if (this.index != -1) {
            switch (this.type) {
                case 1: {
                    this.shaderProgram.setUniform(this.index, matrix2fArray);
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Invalid type");
                }
            }
        }
    }

    protected final void setShaderParameter(Matrix3f matrix3f) {
        if (this.index != -1) {
            switch (this.type) {
                case 1: {
                    this.shaderProgram.setUniform(this.index, matrix3f);
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Invalid type");
                }
            }
        }
    }

    protected final void setShaderParameter(Matrix3f[] matrix3fArray) {
        if (this.index != -1) {
            switch (this.type) {
                case 1: {
                    this.shaderProgram.setUniform(this.index, matrix3fArray);
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Invalid type");
                }
            }
        }
    }

    protected final void setShaderParameter(Matrix4f matrix4f) {
        if (this.index != -1) {
            switch (this.type) {
                case 1: {
                    this.shaderProgram.setUniform(this.index, matrix4f);
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Invalid type");
                }
            }
        }
    }

    protected final void setShaderParameter(Matrix4f[] matrix4fArray) {
        if (this.index != -1) {
            switch (this.type) {
                case 1: {
                    this.shaderProgram.setUniform(this.index, matrix4fArray);
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Invalid type");
                }
            }
        }
    }
}

