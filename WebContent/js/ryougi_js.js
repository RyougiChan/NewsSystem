/*
 * Created by RyougiChan on 2016/06/15
 * First edited by RyougiChan on 2016/06/15
 * Corresponding author: RyougiChan
 * Email: ryougi.chan.fire@gmail.com
 */

(function () {
    "use strict"
    /*
    Initialize container and element
    */
    var documentWidth = document.body.clientWidth;
    var documentHeight = document.body.clientHeight;
    var screenAvailWidth = window.screen.availWidth;
    var screenAvailHeight = window.screen.availHeight;
    var windowInnerWidth = window.innerWidth;
    var windowInnerHeight = window.innerHeight;
    var screenWidth = window.screen.width;
    var screenHeight = window.screen.height;
    
    var mainContainer = document.getElementById('main_container');
    var main = document.getElementById('main');
    var mainBlock = document.getElementById('main_block');
    /*
    Resize event function
    */
    var addEvent = function(object, type, callback) {
	    if (object == null || typeof(object) == 'undefined') return;
	    if (object.addEventListener) {
	        object.addEventListener(type, callback, false);
	    } else if (object.attachEvent) {
	        object.attachEvent("on" + type, callback);
	    } else {
	        object["on"+type] = callback;
	    }
	};
    /*
    Size control operation
    */
    mainContainer.style.height = windowInnerHeight.toString() + "px";
    main.style.height = (window.innerHeight - 180).toString() + "px";
    mainBlock.style.margin = ((window.innerHeight - 554)/2).toString() + "px" + " 0" + " 0 " + ((window.innerWidth - 740)/2).toString() + "px";
    addEvent(window, "resize", function (event) {
        mainContainer.style.height = (window.innerHeight).toString() + "px";
        main.style.height = (window.innerHeight - 180).toString() + "px";
        mainBlock.style.margin = ((window.innerHeight - 554)/2).toString() + "px" + " 0" + " 0 " + ((window.innerWidth - 740)/2).toString() + "px";
    });
    
})();