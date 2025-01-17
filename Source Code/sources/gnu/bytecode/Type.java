package gnu.bytecode;

import com.google.appinventor.components.common.PropertyTypeConstants;
import gnu.kawa.util.AbstractWeakHashTable;
import gnu.text.PrettyWriter;
import java.io.PrintWriter;
import java.util.HashMap;

public abstract class Type implements java.lang.reflect.Type {
    public static final PrimType booleanType = new PrimType(PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN, "Z", 1, Boolean.TYPE);
    public static final Method booleanValue_method = javalangBooleanType.addMethod("booleanValue", typeArray0, (Type) booleanType, 1);
    public static final ClassType boolean_ctype = javalangBooleanType;
    public static final PrimType boolean_type = booleanType;
    public static final PrimType byteType = new PrimType("byte", "B", 1, Byte.TYPE);
    public static final PrimType byte_type = byteType;
    public static final PrimType charType = new PrimType("char", "C", 2, Character.TYPE);
    public static final PrimType char_type = charType;
    public static final Method clone_method = Method.makeCloneMethod(objectType);
    public static final PrimType doubleType = new PrimType("double", "D", 8, Double.TYPE);
    public static final Method doubleValue_method = javalangNumberType.addMethod("doubleValue", typeArray0, (Type) doubleType, 1);
    public static final PrimType double_type = doubleType;
    public static final ObjectType errorType = new ClassType("(error type)");
    public static final PrimType floatType = new PrimType(PropertyTypeConstants.PROPERTY_TYPE_FLOAT, "F", 4, Float.TYPE);
    public static final Method floatValue_method = javalangNumberType.addMethod("floatValue", typeArray0, (Type) floatType, 1);
    public static final PrimType float_type = floatType;
    public static final PrimType intType = new PrimType("int", "I", 4, Integer.TYPE);
    public static final Method intValue_method = javalangNumberType.addMethod("intValue", typeArray0, (Type) intType, 1);
    public static final PrimType int_type = intType;
    public static final ClassType java_lang_Class_type = javalangClassType;
    public static final ClassType javalangBooleanType = ClassType.make("java.lang.Boolean");
    public static final ClassType javalangClassType = ClassType.make("java.lang.Class");
    public static final ClassType javalangNumberType = ClassType.make("java.lang.Number");
    public static final ClassType javalangObjectType = ClassType.make("java.lang.Object");
    public static ClassType javalangStringType = ClassType.make("java.lang.String");
    public static final ClassType javalangThrowableType = ClassType.make("java.lang.Throwable");
    public static final PrimType longType = new PrimType("long", "J", 8, Long.TYPE);
    public static final Method longValue_method = javalangNumberType.addMethod("longValue", typeArray0, (Type) longType, 1);
    public static final PrimType long_type = longType;
    static ClassToTypeMap mapClassToType;
    static HashMap<String, Type> mapNameToType = new HashMap<>();
    public static final PrimType neverReturnsType = new PrimType(voidType);
    public static final ObjectType nullType = new ObjectType("(type of null)");
    public static final ClassType number_type = javalangNumberType;
    public static final ClassType objectType = javalangObjectType;
    public static final ClassType pointer_type = javalangObjectType;
    public static final PrimType shortType = new PrimType("short", "S", 2, Short.TYPE);
    public static final PrimType short_type = shortType;
    public static final ClassType string_type = javalangStringType;
    public static final ClassType throwable_type = javalangThrowableType;
    public static final ClassType toStringType = new ClassType("java.lang.String");
    public static final Method toString_method = objectType.getDeclaredMethod("toString", 0);
    public static final ClassType tostring_type = toStringType;
    public static final Type[] typeArray0 = new Type[0];
    public static final PrimType voidType = new PrimType("void", "V", 0, Void.TYPE);
    public static final PrimType void_type = voidType;
    ArrayType array_type;
    protected Class reflectClass;
    String signature;
    int size;
    String this_name;

    static class ClassToTypeMap extends AbstractWeakHashTable<Class, Type> {
        ClassToTypeMap() {
        }

        /* access modifiers changed from: protected */
        public Class getKeyFromValue(Type type) {
            return type.reflectClass;
        }

        /* access modifiers changed from: protected */
        public boolean matches(Class oldValue, Class newValue) {
            return oldValue == newValue;
        }
    }

    public abstract Object coerceFromObject(Object obj);

    public abstract int compare(Type type);

    protected Type() {
    }

    public Type getImplementationType() {
        return this;
    }

    public Type getRealType() {
        return this;
    }

    public boolean isExisting() {
        return true;
    }

    public static Type lookupType(String name) {
        Type type;
        HashMap<String, Type> map = mapNameToType;
        synchronized (map) {
            type = (Type) map.get(name);
        }
        return type;
    }

    public static Type getType(String name) {
        Type type;
        Object obj;
        HashMap<String, Type> map = mapNameToType;
        synchronized (map) {
            type = (Type) map.get(name);
            if (type == 0) {
                if (name.endsWith("[]")) {
                    obj = ArrayType.make(name);
                } else {
                    ClassType cl = new ClassType(name);
                    cl.flags |= 16;
                    obj = cl;
                }
                map.put(name, obj);
                type = obj;
            }
        }
        return type;
    }

    public static synchronized void registerTypeForClass(Class clas, Type type) {
        synchronized (Type.class) {
            ClassToTypeMap map = mapClassToType;
            if (map == null) {
                map = new ClassToTypeMap();
                mapClassToType = map;
            }
            type.reflectClass = clas;
            map.put(clas, type);
        }
    }

    /* JADX WARNING: type inference failed for: r4v1, types: [gnu.bytecode.Type] */
    /* JADX WARNING: type inference failed for: r4v2 */
    /* JADX WARNING: type inference failed for: r0v0, types: [gnu.bytecode.ClassType] */
    /* JADX WARNING: type inference failed for: r4v3, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r4v4, types: [gnu.bytecode.Type] */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r4v5, types: [gnu.bytecode.ArrayType] */
    /* JADX WARNING: type inference failed for: r3v1, types: [gnu.bytecode.Type] */
    /* JADX WARNING: type inference failed for: r3v3, types: [gnu.bytecode.Type] */
    /* JADX WARNING: type inference failed for: r4v6 */
    /* JADX WARNING: type inference failed for: r4v7 */
    /* JADX WARNING: type inference failed for: r4v8 */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000f, code lost:
        if (r3 != 0) goto L_0x0011;
     */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r4v2
  assigns: []
  uses: []
  mth insns count: 49
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 6 */
    public static synchronized Type make(Class reflectClass2) {
        ? r4;
        ? r42;
        ? r3;
        synchronized (Type.class) {
            if (mapClassToType != null) {
                r3 = (Type) mapClassToType.get(reflectClass2);
            }
            if (reflectClass2.isArray()) {
                r42 = ArrayType.make(make(reflectClass2.getComponentType()));
            } else if (reflectClass2.isPrimitive()) {
                throw new Error("internal error - primitive type not found");
            } else {
                String name = reflectClass2.getName();
                HashMap<String, Type> map = mapNameToType;
                synchronized (map) {
                    r4 = (Type) map.get(name);
                    if (r4 == 0 || !(r4.reflectClass == reflectClass2 || r4.reflectClass == null)) {
                        ? classType = new ClassType(name);
                        classType.flags |= 16;
                        ? r43 = classType;
                        mapNameToType.put(name, r43);
                        r4 = r43;
                    }
                }
                r42 = r4;
            }
            registerTypeForClass(reflectClass2, r42);
            r3 = r42;
        }
        return r3;
    }

    public String getSignature() {
        return this.signature;
    }

    /* access modifiers changed from: protected */
    public void setSignature(String sig) {
        this.signature = sig;
    }

    Type(String nam, String sig) {
        this.this_name = nam;
        this.signature = sig;
    }

    public Type(Type type) {
        this.this_name = type.this_name;
        this.signature = type.signature;
        this.size = type.size;
        this.reflectClass = type.reflectClass;
    }

    public Type promote() {
        return this.size < 4 ? intType : this;
    }

    public final int getSize() {
        return this.size;
    }

    public int getSizeInWords() {
        return this.size > 4 ? 2 : 1;
    }

    public final boolean isVoid() {
        return this.size == 0;
    }

    public static PrimType signatureToPrimitive(char sig) {
        switch (sig) {
            case 'B':
                return byteType;
            case 'C':
                return charType;
            case 'D':
                return doubleType;
            case PrettyWriter.NEWLINE_FILL /*70*/:
                return floatType;
            case 'I':
                return intType;
            case 'J':
                return longType;
            case PrettyWriter.NEWLINE_SPACE /*83*/:
                return shortType;
            case 'V':
                return voidType;
            case 'Z':
                return booleanType;
            default:
                return null;
        }
    }

    public static Type signatureToType(String sig, int off, int len) {
        if (len == 0) {
            return null;
        }
        char c = sig.charAt(off);
        if (len == 1) {
            PrimType signatureToPrimitive = signatureToPrimitive(c);
            if (signatureToPrimitive != null) {
                return signatureToPrimitive;
            }
        }
        if (c == '[') {
            Type type = signatureToType(sig, off + 1, len - 1);
            if (type != null) {
                return ArrayType.make(type);
            }
            return null;
        } else if (c == 'L' && len > 2 && sig.indexOf(59, off) == (len - 1) + off) {
            return ClassType.make(sig.substring(off + 1, (len - 1) + off).replace('/', '.'));
        } else {
            return null;
        }
    }

    public static Type signatureToType(String sig) {
        return signatureToType(sig, 0, sig.length());
    }

    public static void printSignature(String sig, int off, int len, PrintWriter out) {
        if (len != 0) {
            char c = sig.charAt(off);
            if (len == 1) {
                Type type = signatureToPrimitive(c);
                if (type != null) {
                    out.print(type.getName());
                }
            } else if (c == '[') {
                printSignature(sig, off + 1, len - 1, out);
                out.print("[]");
            } else if (c == 'L' && len > 2 && sig.indexOf(59, off) == (len - 1) + off) {
                out.print(sig.substring(off + 1, (len - 1) + off).replace('/', '.'));
            } else {
                out.append(sig, off, len - off);
            }
        }
    }

    public static int signatureLength(String sig, int pos) {
        if (sig.length() <= pos) {
            return -1;
        }
        char c = sig.charAt(pos);
        int arrays = 0;
        while (c == '[') {
            arrays++;
            pos++;
            c = sig.charAt(pos);
        }
        if (signatureToPrimitive(c) != null) {
            return arrays + 1;
        }
        if (c != 'L') {
            return -1;
        }
        int end = sig.indexOf(59, pos);
        if (end > 0) {
            return ((arrays + end) + 1) - pos;
        }
        return -1;
    }

    public static int signatureLength(String sig) {
        return signatureLength(sig, 0);
    }

    public static String signatureToName(String sig) {
        int len = sig.length();
        if (len == 0) {
            return null;
        }
        char c = sig.charAt(0);
        if (len == 1) {
            Type type = signatureToPrimitive(c);
            if (type != null) {
                return type.getName();
            }
        }
        if (c == '[') {
            int arrays = 1;
            if (1 < len && sig.charAt(1) == '[') {
                arrays = 1 + 1;
            }
            String sig2 = signatureToName(sig.substring(arrays));
            if (sig2 == null) {
                return null;
            }
            StringBuffer buf = new StringBuffer(50);
            buf.append(sig2);
            while (true) {
                arrays--;
                if (arrays < 0) {
                    return buf.toString();
                }
                buf.append("[]");
            }
        } else if (c == 'L' && len > 2 && sig.indexOf(59) == len - 1) {
            return sig.substring(1, len - 1).replace('/', '.');
        } else {
            return null;
        }
    }

    public final String getName() {
        return this.this_name;
    }

    /* access modifiers changed from: protected */
    public void setName(String name) {
        this.this_name = name;
    }

    public static boolean isValidJavaTypeName(String name) {
        boolean in_name = false;
        int len = name.length();
        while (len > 2 && name.charAt(len - 1) == ']' && name.charAt(len - 2) == '[') {
            len -= 2;
        }
        int i = 0;
        while (i < len) {
            char ch = name.charAt(i);
            if (ch != '.') {
                if (in_name) {
                    if (!Character.isJavaIdentifierPart(ch)) {
                        return false;
                    }
                } else if (!Character.isJavaIdentifierStart(ch)) {
                    return false;
                }
                in_name = true;
            } else if (!in_name) {
                return false;
            } else {
                in_name = false;
            }
            i++;
        }
        if (i == len) {
            return true;
        }
        return false;
    }

    public boolean isInstance(Object obj) {
        return getReflectClass().isInstance(obj);
    }

    public final boolean isSubtype(Type other) {
        int comp = compare(other);
        return comp == -1 || comp == 0;
    }

    public static Type lowestCommonSuperType(Type t1, Type t2) {
        if (t1 == neverReturnsType) {
            return t2;
        }
        if (t2 == neverReturnsType) {
            return t1;
        }
        if (t1 == null || t2 == null) {
            return null;
        }
        if (!(t1 instanceof PrimType) || !(t2 instanceof PrimType)) {
            if (t1.isSubtype(t2)) {
                return t2;
            }
            if (t2.isSubtype(t1)) {
                return t1;
            }
            if (!(t1 instanceof ClassType) || !(t2 instanceof ClassType)) {
                return objectType;
            }
            ClassType c1 = (ClassType) t1;
            ClassType c2 = (ClassType) t2;
            if (c1.isInterface() || c2.isInterface()) {
                return objectType;
            }
            return lowestCommonSuperType(c1.getSuperclass(), c2.getSuperclass());
        } else if (t1 == t2) {
            return t1;
        } else {
            Type t12 = ((PrimType) t1).promotedType();
            if (t12 != ((PrimType) t2).promotedType()) {
                return null;
            }
            return t12;
        }
    }

    protected static int swappedCompareResult(int code) {
        if (code == 1) {
            return -1;
        }
        if (code == -1) {
            return 1;
        }
        return code;
    }

    public static boolean isMoreSpecific(Type[] t1, Type[] t2) {
        if (t1.length != t2.length) {
            return false;
        }
        int i = t1.length;
        do {
            i--;
            if (i < 0) {
                return true;
            }
        } while (t1[i].isSubtype(t2[i]));
        return false;
    }

    public void emitIsInstance(CodeAttr code) {
        code.emitInstanceof(this);
    }

    public Object coerceToObject(Object obj) {
        return obj;
    }

    public void emitConvertFromPrimitive(Type stackType, CodeAttr code) {
        stackType.emitCoerceToObject(code);
    }

    public void emitCoerceToObject(CodeAttr code) {
    }

    public void emitCoerceFromObject(CodeAttr code) {
        throw new Error("unimplemented emitCoerceFromObject for " + this);
    }

    static {
        mapNameToType.put("byte", byteType);
        mapNameToType.put("short", shortType);
        mapNameToType.put("int", intType);
        mapNameToType.put("long", longType);
        mapNameToType.put(PropertyTypeConstants.PROPERTY_TYPE_FLOAT, floatType);
        mapNameToType.put("double", doubleType);
        mapNameToType.put(PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN, booleanType);
        mapNameToType.put("char", charType);
        mapNameToType.put("void", voidType);
        neverReturnsType.this_name = "(never-returns)";
    }

    public Class getReflectClass() {
        return this.reflectClass;
    }

    public void setReflectClass(Class rclass) {
        this.reflectClass = rclass;
    }

    public String toString() {
        return "Type " + getName();
    }

    public int hashCode() {
        String name = toString();
        if (name == null) {
            return 0;
        }
        return name.hashCode();
    }
}
