package com.alexnine.config;

import com.blade.Blade;
import com.blade.loader.BladeLoader;
import io.github.biezhi.anima.Anima;
import lombok.extern.slf4j.Slf4j;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import static io.github.biezhi.anima.Anima.select;

/**
 * @author alexnine
 * Date 2019/5/30 17:18
 * loader类
 */
@Slf4j
public class MyBladeLoader implements BladeLoader {

    @Override
    public void load(Blade blade) {
        blade.corsMiddleware();
        InputStream in = MyBladeLoader.class.getClassLoader().getResourceAsStream("app.properties");
        Properties props = new Properties();
        try {
            log.info("Database Connecting.....");
            props.load(in);
            Anima.open(props.getProperty("mysql.url"), props.getProperty("mysql.username"), props.getProperty("mysql.password"));
            //执行测试语句
            select().bySQL(String.class,"select database();");
            log.info("Database Connect Successful.....");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
