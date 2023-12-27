/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.objectweb.asm.Opcodes
 *  org.objectweb.asm.Type
 *  org.objectweb.asm.commons.Method
 */
package de.vw.mib.reflection.impl;

import de.vw.mib.reflection.impl.Constants$1;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.Method;

public interface Constants
extends Opcodes {
    public static final int TARGET_JAVA_VERSION;
    public static final String BASE_PACKAGE;
    public static final int CONST_AF;
    public static final Type INT_ASM_T;
    public static final Type BOOL_ASM_T;
    public static final Type J_METHOD_ASM_T;
    public static final Type J_METHOD_A_ASM_T;
    public static final Type OBJ_ASM_T;
    public static final Type OBJ_A_ASM_T;
    public static final Type RU_ASM_T;
    public static final Type INV_T_EXC_ASM_T;
    public static final Type RT_EXC_ASM_T;
    public static final Type THR_ASM_T;
    public static final String INT_ASM_T_D;
    public static final String J_METHOD_A_ASM_T_D;
    public static final String OBJ_A_ASM_T_D;
    public static final Method RU_BUILD_KEY_STR_ASM_M;
    public static final Method RU_BUILD_KEY_CLASS_A_ASM_M;
    public static final Method RU_V_OF_BL_ASM_M;
    public static final Method RU_V_OF_CH_ASM_M;
    public static final Method RU_V_OF_B_ASM_M;
    public static final Method RU_V_OF_S_ASM_M;
    public static final Method RU_V_OF_I_ASM_M;
    public static final Method RU_V_OF_L_ASM_M;
    public static final Method RU_V_OF_D_ASM_M;
    public static final Method RU_V_OF_F_ASM_M;
    public static final Method RU_G_M_ASM_M;
    public static final Method INV_T_EXC_C_ASM_M;

    static {
        BASE_PACKAGE = new StringBuffer().append((Constants$1.class$de$vw$mib$reflection$LightReflection == null ? (Constants$1.class$de$vw$mib$reflection$LightReflection = Constants$1.class$("de.vw.mib.reflection.LightReflection")) : Constants$1.class$de$vw$mib$reflection$LightReflection).getPackage().getName()).append(".").toString();
        INT_ASM_T = Type.INT_TYPE;
        BOOL_ASM_T = Type.BOOLEAN_TYPE;
        J_METHOD_ASM_T = Type.getType((String)"Ljava/lang/reflect/Method;");
        J_METHOD_A_ASM_T = Type.getType((String)"[Ljava/lang/reflect/Method;");
        OBJ_ASM_T = Type.getType((String)"Ljava/lang/Object;");
        OBJ_A_ASM_T = Type.getType((String)"[Ljava/lang/Object;");
        RU_ASM_T = Type.getType((String)"Lde/vw/mib/reflection/RuntimeUtil;");
        INV_T_EXC_ASM_T = Type.getType((String)"Ljava/lang/reflect/InvocationTargetException;");
        RT_EXC_ASM_T = Type.getType((String)"Ljava/lang/RuntimeException;");
        THR_ASM_T = Type.getType((String)"Ljava/lang/Throwable;");
        INT_ASM_T_D = INT_ASM_T.getDescriptor();
        J_METHOD_A_ASM_T_D = J_METHOD_A_ASM_T.getDescriptor();
        OBJ_A_ASM_T_D = OBJ_A_ASM_T.getDescriptor();
        RU_BUILD_KEY_STR_ASM_M = Method.getMethod((String)"int buildKey(String)");
        RU_BUILD_KEY_CLASS_A_ASM_M = Method.getMethod((String)"int buildKey(Class[])");
        RU_V_OF_BL_ASM_M = Method.getMethod((String)"Boolean valueOf(boolean)");
        RU_V_OF_CH_ASM_M = Method.getMethod((String)"Character valueOf(char)");
        RU_V_OF_B_ASM_M = Method.getMethod((String)"Byte valueOf(byte)");
        RU_V_OF_S_ASM_M = Method.getMethod((String)"Short valueOf(short)");
        RU_V_OF_I_ASM_M = Method.getMethod((String)"Integer valueOf(int)");
        RU_V_OF_L_ASM_M = Method.getMethod((String)"Long valueOf(long)");
        RU_V_OF_D_ASM_M = Method.getMethod((String)"Double valueOf(double)");
        RU_V_OF_F_ASM_M = Method.getMethod((String)"Float valueOf(float)");
        RU_G_M_ASM_M = Method.getMethod((String)"java.lang.reflect.Method getMethod ( int, java.lang.reflect.Method[], String, int, int )");
        INV_T_EXC_C_ASM_M = new Method("<init>", "(Ljava/lang/Throwable;)V");
    }
}

