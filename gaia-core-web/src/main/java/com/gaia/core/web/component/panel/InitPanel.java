/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.core.web.component.panel;

import com.gaia.basedata.entities.Post;
import com.gaia.basedata.entities.PostItem;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.upload.FileUpload;
import org.apache.wicket.markup.html.form.upload.FileUploadField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

/**
 *
 * @author watt
 */
public class InitPanel extends Panel{
    
    private Label itemContainer;
    private FileUploadField imgPicker, vidPicker;
    private Form initPanelForm;
    
    public InitPanel(String id) {
        super(id);
        initPanel();
    }
    
    private void initPanel(){
        
        initPanelForm = new Form("initPanelForm" );
        imgPicker = new FileUploadField("imgPicker");
        vidPicker = new FileUploadField("vidPicker");
       
//        AjaxLink imgPickerLink = new AjaxLink("imgPickerLink") {
//            @Override
//            public void onClick(AjaxRequestTarget art) {
//                art.appendJavaScript(
//                        "jQuery('#imgPicker').click(function(){"+                    // jQuery("#imgSelect").click();   
//                         "jQuery('#viewPanel').slideToggle('slow',function(){}); "+               
//                         "});"
//                      );
//            }
//            
//        };
//        imgPickerLink.add(new  AjaxEventBehavior("click") {
//            @Override
//            protected void onEvent(AjaxRequestTarget art) {
//                art.appendJavaScript(
//                        "jQuery('#imgPicker').click(function(){"+                    // jQuery("#imgSelect").click();   
//                         "jQuery('#viewPanel').slideToggle('slow',function(){}); "+               
//                         "});"
//                      );
//                
//            
//            }
//        });
        TextArea littleComment= new TextArea("littleComment",new Model<String>());
        itemContainer = new Label("itemContainer", new Model<String>());
        Button psubmit = new Button("psubmit"){
            @Override
            public void onSubmit() {
                String markup = itemContainer.getDefaultModel().getObject().toString();
                if(markup.equalsIgnoreCase(imgPicker.getId())){
                    
                }else{
                    
                }
            }
            
        };
      
        
        
        initPanelForm.add(imgPicker);
        initPanelForm.add(vidPicker);
        initPanelForm.setMultiPart(true);
        initPanelForm.add(littleComment);
        initPanelForm.add(itemContainer);
        this.add(initPanelForm);

    }
    
    private boolean validatePost(){
        return true;
    }
    
     private boolean processImagePost(){
        // create a new post
        Post post = new Post();
        
        //retrives the posted file
        FileUpload file = imgPicker.getFileUpload();
        PostItem item = new PostItem();
        item.setName(file.getClientFileName());
//        item.setPath();
        
        return true;
     }
     
     private boolean processVideoPost(){
        return true;
     }
    
}
