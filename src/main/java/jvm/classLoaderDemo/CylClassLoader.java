package jvm.classLoaderDemo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Description 自定义classLoader
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/7/18
 */
public class CylClassLoader extends ClassLoader {
    //定义默认的class路径
    private final static Path DEFAULT_CLASS_DIR =Paths.get("D:","classloader1");
    private final Path classDir;

    public CylClassLoader() {
        super();
        this.classDir = DEFAULT_CLASS_DIR;
    }

    public CylClassLoader(String classDir) {
        super();
        this.classDir = Paths.get(classDir);
    }

    public CylClassLoader(ClassLoader parent, String  classDir) {
        super(parent);
        this.classDir = Paths.get(classDir);
    }

    //重写findClass方法， 这是至关重要的步骤

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
       //读取class的二进制数据
        byte[] classBytes = this.readClassBytes(name);

        // 如果数据为null， 或者没有读取到任何信息，则抛出ClassNotFoundException
        if (classBytes == null || classBytes.length == 0) {
            throw new ClassNotFoundException(">> Can not load the class " + name);
        }
        //调用difineClass方法定义Class
        return this.defineClass(name, classBytes, 0, classBytes.length);
    }

    private byte[] readClassBytes(String name) throws ClassNotFoundException {
        // 将包名分隔符转化为文件路径分隔符
        String classPath = name.replace(".","/");
        Path fullPath = classDir.resolve(Paths.get(classPath + ".class"));
        if (!fullPath.toFile().exists()) {
            throw new ClassNotFoundException(">> The class: " + name + "not found.");
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            Files.copy(fullPath, baos);
            return baos.toByteArray();
        } catch (IOException e) {
            throw new ClassNotFoundException(">> Load the class:" + name + " occur error.");
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        CylClassLoader cylClassLoader = new CylClassLoader();
        cylClassLoader.loadClass("jvm.classLoaderDemo.HelloWorld");
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        contextClassLoader.loadClass("sss");
    }
}
