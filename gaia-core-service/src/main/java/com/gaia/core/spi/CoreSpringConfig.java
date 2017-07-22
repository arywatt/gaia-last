/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.core.spi;

import java.io.Serializable;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 *
 * @author komilo
 */
@Configuration
@ImportResource("classpath:com/gaia/core/spi/applicationContext.xml")
public class CoreSpringConfig implements Serializable {
    
}
