package com.test.utils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class CustomClassLoader extends URLClassLoader {
    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        synchronized (getClassLoadingLock(name)) {
            // 1. 检查类是否已加载
            Class<?> loadedClass = findLoadedClass(name);
            if (loadedClass != null) {
                return loadedClass;
            }

            try {
                // 2. 优先从当前 JAR 加载（子类加载器优先）
                return findClass(name);
            } catch (ClassNotFoundException e) {
                // 3. 如果 JAR 中找不到，再委托给父类加载器（本地项目的类加载器）
                return super.loadClass(name, resolve);
            }
        }
    }

    public CustomClassLoader(URL[] urls) {
        super(urls);
    }

    public CustomClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    public void addJar(String jarFile) {
        try {
            super.addURL(new File(jarFile).toURI().toURL());
        } catch (MalformedURLException e) {
        }
    }

    public void addJar(URL url) {
        super.addURL(url);
    }
}