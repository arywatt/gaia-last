package com.gaia.core.web;

import com.gaia.core.web.pages.HomePage;
import com.gaia.entity.utils.SpringApplicationContextHolder;
import com.gaia.module.service.IModuleService;
import org.apache.wicket.Page;
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.apache.wicket.spring.injection.annot.SpringBean;

import org.apache.wicket.spring.injection.annot.SpringComponentInjector;



/**
 *
 * @author komilo
 */


public class GaiaApplication extends WebApplication {

   
    private IModuleService moduleService;

    public GaiaApplication() {        
         
    }
    
    
    @Override
    protected void init() {
        super.init();
    
        this.getComponentInstantiationListeners().add(new SpringComponentInjector(this));
        
 
        // load modules
      this.moduleService = SpringApplicationContextHolder.getContext().getBean(IModuleService.class);
        moduleService.loadModules();
    }

    @Override
    public Class<? extends Page> getHomePage() {
        return HomePage.class;
//        return BasePage.class;
    }

//    protected IRequestCycleProcessor newRequestCycleProcessor() {
//        return new WebRequestCycleProcessor() {
//
//            @Override
//            protected IRequestCodingStrategy newRequestCodingStrategy() {
//                return new CryptedUrlWebRequestCodingStrategy(
//                        new WebRequestCodingStrategy());
//            }
//        };
//    }

    @Override
    public Session newSession(Request request, Response response) {
        return new GaiaSession(request);
    }
    
//    public  getPicturesUploadFolder(){
//        
//    }
}
