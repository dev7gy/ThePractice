package me.ygunna;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
1. componentscan
2. autoconfiguratiosn
 */

//Bean이 없을때만 이걸 이용해서 등록해라 라는 어노테이션
@Configuration
@EnableConfigurationProperties(HolomanProperties.class)
public class HolomanConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public Holoman holoman(HolomanProperties properties) {
        Holoman holoman = new Holoman();
        holoman.setHowLong(properties.getHowLong());
        holoman.setName(properties.getName());
        return holoman;
    }
}
