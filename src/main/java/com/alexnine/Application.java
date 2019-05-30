package com.alexnine;

import com.alexnine.config.MyBladeLoader;
import com.blade.Blade;

/**
 * @author alexnine
 * Date 2019/5/28 14:52
 */
public class Application {
    public static void main(String[] args) {
        Blade.of().addLoader(new MyBladeLoader()).start(Application.class, args);
    }
}
