/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


jQuery.noConflict();

var lastTrigger;
var postInProgress = true;



jQuery(document).ready(function () {


jQuery("#menuTrigger").click(function(){
        showLeftMenu();
});

jQuery("#imgPickerLink").click(function(){                    
     
      jQuery("#imgPicker").click();
});

jQuery("#vidPickerLink").click(function(){
            jQuery("#vidPicker").click(); 
      
});

jQuery("#imgPicker").change(function(){
            if(!lastTrigger) { 
                    setLastTrigger(this)
             }else{
                  if(!getLastTrigger().is(this)) { jQuery("#mediaZone .grid").empty();}
             }
            
    var files = jQuery(this)[0].files;
    if(files){
        if (typeof (FileReader) !== "undefined") {
                var preview = jQuery("#mediaZone .grid");
//                var regex = /^([a-zA-Z0-9\s_\\.\-:])+(.jpg|.jpeg|.gif|.png|.bmp)$/;
                 jQuery(files).each(function () {
                    var file = jQuery(this);
//                    if (regex.test(file[0].name.toLowerCase())) {
                        var reader = new FileReader();
                        reader.onload = function (e) {
                            var gridItem = jQuery("<div />");
                            gridItem.attr("class","grid-item col-lg-12 ");
                            //gridItem.append("<span class=\"close\" >x</span>");
                            var img = jQuery("<img/>");
                            var caret = jQuery("<span>");                      
                            img.attr("src", e.target.result);
                            img.attr("class","img-responsive");
                            gridItem.append(img);
                            preview.append(gridItem);
                        };
                        reader.readAsDataURL(file[0]);
//                    } else {
//                        alert(file[0].name + " is not a valid image file.");
//                        preview.html("");
//                        return false;
//                    }    
                });

                setLastTrigger(jQuery(this));
                 if(jQuery("#viewPanel").css("display")==="none"){
                        jQuery("#viewPanel").slideToggle("fast",function(){});
                 }
        } else {
                alert("This browser does not support HTML5 FileReader.");
        }
  }else{
      if(jQuery("#viewPanel").css("display")!=="none"){
                        jQuery("#viewPanel").slideToggle("fast",function(){});
      }
  }
    
});

jQuery("#camPickerLink").click(function(){
    navigator.getUserMedia = navigator.getUserMedia ||
                         navigator.webkitGetUserMedia ||
                         navigator.mozGetUserMedia;

    if (navigator.getUserMedia) {
      navigator.getUserMedia({ audio: true, video: true },
      function(stream) {
            var preview = jQuery("#mediaZone .grid");
            preview.empty();
            var v = jQuery("<video>");
            v.attr("class","col-lg-12");
            v.attr("id","video");
            preview.append(v);
            
            var url = window.URL || window.webkitURL;
            var createSrc = window.URL ? window.URL.createObjectURL : function(stream) {return stream;};            
            v = jQuery("#video");
            v.attr("src",createSrc(stream));          
            v.get(0).play();

        },
        function(err) {
           console.log("The following error occured: " + err.name);
        }
     );
     
     setLastTrigger(jQuery(this));  
     if(jQuery("#viewPanel").css("display")==="none"){
        jQuery("#viewPanel").slideToggle("fast",function(){});
     }
  } else {
     console.log("getUserMedia not supported");
  }

});

jQuery(document).unload(function(){
    if(postInProgress){    
      alert(" Post unfinished");
    }


});


jQuery("#vidPicker").change(function(){
            if(!lastTrigger) { 
                    setLastTrigger(this)
             }else{
                 //  if(getLastTrigger().is(this)) { jQuery("#mediaZone .grid").empty();}
             }
            
            var file = jQuery("#vidPicker").get(0).files[0];
            if(file){
                
                var preview = jQuery("#mediaZone .grid");
                preview.empty();
                var v = jQuery("<video controls>");
                v.attr("class","col-lg-12");
                v.attr("id","video");
                preview.append(v);
                //var createSrc = window.URL ? window.URL.createObjectURL : function(stream) {return stream;};

                //v = jQuery("#video");
                var stream = file;
                var src = window.URL.createObjectURL(stream);
                v.attr("src",src);          
                v.get(0).play();
                setLastTrigger(jQuery(this));
                if(jQuery("#viewPanel").css("display")==="none"){
                    jQuery("#viewPanel").slideToggle("fast",function(){});
                }
                
                 
           }else{
               if(jQuery("#viewPanel").css("display")!=="none"){
                    jQuery("#viewPanel").slideToggle("fast",function(){});
                }
           }
           // window.URL.revokeObjectURL(src);

});


jQuery("#littleCommentLink").click(function(){   
      jQuery("#littleComment").slideToggle("slow",function(){});                
});

});


function showLeftMenu() {
    jQuery("#left-block-menu").animate({
        width: "toggle"
//        height: "toggle"
    },
    {duration: 1000}

    );

    // jQuery("#mapTrigger").css("display","none");
}

function menuToggle(){
    jQuery(".accordion h4:first").addClass("active");
        jQuery(".accordion h3:last").addClass("active")
	jQuery(".accordion ul:not(:first)").hide();

	jQuery(".accordion h4").click(function(){
		jQuery(this).next("ul").slideToggle("slow")
		.siblings("ul:visible").slideUp("slow");
		jQuery(this).toggleClass("active");
		jQuery(this).siblings("h4").removeClass("active");
	});
        /*jQuery("#reset").click(function(){
		jQuery("#pharma").hide();
	});*/
}




function setLastTrigger(trigger){
   lastTrigger = trigger;
}

function getLastTrigger(trigger){
   return lastTrigger ;
}



function showsite() {
    jQuery("#map").animate({
        width: "toggle",
        height: "toggle"
    },
    {duration: 1000}

    );

   
}











