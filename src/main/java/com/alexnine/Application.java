package com.alexnine;

import com.alexnine.config.MyBladeLoader;
import com.alexnine.config.MyListener;
import com.alexnine.exception.MyExceptionHandler;
import com.blade.Blade;
import com.blade.event.EventType;

/**
 * @author alexnine
 * Date 2019/5/28 14:52
 */
public class Application {
    public static void main(String[] args) {
        Blade.of()
                .addLoader(new MyBladeLoader())
                .event(EventType.SERVER_STARTED,new MyListener())
                .exceptionHandler(new MyExceptionHandler())
                .start(Application.class, args);
    }
}
