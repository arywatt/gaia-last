/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


jQuery.noConflict();
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
    
    if (typeof (FileReader) !== "undefined") {
            var preview = jQuery("#mediaZone .grid");
            var regex = /^([a-zA-Z0-9\s_\\.\-:])+(.jpg|.jpeg|.gif|.png|.bmp)$/;
             jQuery(jQuery(this)[0].files).each(function () {
                var file = jQuery(this);
                if (regex.test(file[0].name.toLowerCase())) {
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
                } else {
                    alert(file[0].name + " is not a valid image file.");
                    preview.html("");
                    return false;
                }    
            });
            jQuery("#viewPanel").slideToggle("slow",function(){});
    } else {
            alert("This browser does not support HTML5 FileReader.");
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
            var v = jQuery("<video>");
            v.attr("class","col-lg-12");
            v.attr("id","video");
            preview.append(v);
            jQuery("#viewPanel").slideToggle("slow",function(){});
            var url = window.URL || window.webkitURL;
            var createSrc = window.URL ? window.URL.createObjectURL : function(stream) {return stream;};
            
            v = jQuery("#video");
            //v.src = createSrc(stream); 
            //v.src = url ? url.createObjectURL(stream) : stream; 
            v.attr("src",createSrc(stream));          
            v.get(0).play();

        },
        function(err) {
           console.log("The following error occured: " + err.name);
        }
     );
  } else {
     console.log("getUserMedia not supported");
  }

});


            jQuery("#vidPicker").change(function(){

                        var preview = jQuery("#mediaZone .grid");
                        var v = jQuery("<video>");
                        v.attr("class","col-lg-12");
                        v.attr("id","video");
                        preview.append(v);
                        jQuery("#viewPanel").slideToggle("slow",function(){});

                        var createSrc = window.URL ? window.URL.createObjectURL : function(stream) {return stream;};

                        v = jQuery("#video");
                        var stream = jQuery("#vidPicker").get(0).files[0];
                        v.attr("src",createSrc(stream));          
                        v.get(0).play();

            });

/*navigator.getUserMedia = navigator.getUserMedia ||
                         navigator.webkitGetUserMedia ||
                         navigator.mozGetUserMedia;

if (navigator.getUserMedia) {
   navigator.getUserMedia({ audio: true, video: { width: 1280, height: 720 } },
      function(stream) {
         var video = document.querySelector('video');
         video.src = window.URL.createObjectURL(stream);
         video.onloadedmetadata = function(e) {
           video.play();
         };
      },
      function(err) {
         console.log("The following error occured: " + err.name);
      }
   );
} else {
   console.log("getUserMedia not supported");
}*/


/*
	var video = document.getElementById('video');
	var obj_url = window.URL.createObjectURL(blob);
	video.src = obj_url;
	video.play()
	window.URL.revokeObjectURL(obj_url);

*/



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





function showsite() {
    jQuery("#map").animate({
        width: "toggle",
        height: "toggle"
    },
    {duration: 1000}

    );

    // jQuery("#mapTrigger").css("display","none");
}

function selecPicture() {
    jQuery(document).load("http://localhost/gaia/template/picture");

}

function loadPosts() {
    jQuery('#posts').load('http://localhost/gaia/index.php/home/allPosts');
}
;

function loadmenus() {
    jQuery('#menu').load('http://localhost/gaia/index.php/menus/allmenus');
}
;


var contentLoader = (function (url, elt, mode) {
    var contentUrl = url;
    var element = elt;
    var mode = mode;
    var items = jQuery("#myFeature li");
    var container = jQuery("<div class='container'></div>");
    var currentItem = null;
    var urlBase = "/foo.php?item=";

    var createContainer = function () {
        var item = jQuery(this);
        var _container = container.clone().appendTo(item);
        item.data("container", _container);
    };

    var buildUrl = function () {
        return urlBase + currentItem.attr("id");
    };

    var showItem = function () {
        currentItem = jQuery(this);
        getContent(showContent);
    };

    var showItemByIndex = function (idx) {
        jQuery.proxy(showItem, items.get(idx));
    };

    var getContent = function (callback) {
        currentItem.data("container").load(buildUrl(), callback);
    };

    var showContent = function () {
        currentItem.data("container").show();
        hideContent();
    };

    var hideContent = function () {
        currentItem.siblings().each(function () {
            jQuery(this).data("container").hide();
        });
    };

    items.each(createContainer).click(showItem);

    return {
        showItemByIndex: showItemByIndex
    };


})();

contentLoader.showItemByIndex(0);

function alertBuilder(key) {

    jQuery("#message-block").load(baseUrl() + 'message/get/' + key);
    jQuery("#message-block").fadeIn('slow', function () {


    });
}
;

function baseUrl() {
    return 'http://localhost/gaia/index.php/';
}









