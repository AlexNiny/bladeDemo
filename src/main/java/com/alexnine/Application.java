package com.alexnine;

import com.alexnine.config.MyBladeLoader;
import com.alexnine.config.MyListener;
import com.alexnine.exception.MyExceptionHandler;
import com.blade.Blade;
import com.blade.event.EventType;
import com.blade.security.web.cors.CorsConfiger;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author alexnine
 * Date 2019/5/28 14:52
 */
public class Application {
    public static void main(String[] args) {
        Blade.of()
                .addLoader(new MyBladeLoader())
                .enableCors(true, corsConfig())
                .event(EventType.SERVER_STARTED, new MyListener())
                .exceptionHandler(new MyExceptionHandler())
                .start(Application.class, args);
    }

    private static CorsConfiger corsConfig() {
        return CorsConfiger.builder()
                .allowedMethods(Stream.of("GET", "OPTIONS", "HEAD", "PUT", "POST", "DELETE").collect(Collectors.toList()))
                .allowedHeaders(Stream.of("Origin", "X-Requested-With", "Access-Control-Allow-Origin","Content-Type", "Accept",
                        "Connection", "User-Agent", "Cookie", "Cache-Control").collect(Collectors.toList()))
                .maxAge(1300L)
                .allowCredentials(Boolean.TRUE)
                .build();
    }
}
