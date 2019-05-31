package com.alexnine.config;

import com.blade.event.Event;
import com.blade.event.EventListener;
import lombok.extern.slf4j.Slf4j;

/**
 * @author AlexNine
 * Date 2019/5/31 11:04
 * 事件监听
 */
@Slf4j
public class MyListener implements EventListener {
    @Override
    public void trigger(Event event) {
      log.info("Server started!!!");
    }
}
