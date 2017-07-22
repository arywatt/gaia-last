/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.security.spi;

import java.io.Serializable;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 *
 * @author komilo
 */
@Configuration
@ImportResource("classpath:com/gaia/security/spi/applicationContext.xml")
public class SecuritySpringConfig implements Serializable {
    
}
