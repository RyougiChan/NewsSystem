/**
 * Created by RyougiChan on 2016/06/27
 * First edited by RyougiChan on 2016/06/27
 * Corresponding author: RyougiChan
 * Email: ryougi.chan.fire@gmail.com
 */

(function () {
    "use strict"
    /**
     * Get some value of width and height in common.
     */
    var documentWidth = document.body.clientWidth;
    var documentHeight = document.body.clientHeight;
    var screenAvailWidth = window.screen.availWidth;
    var screenAvailHeight = window.screen.availHeight;
    var windowInnerWidth = window.innerWidth;
    var windowInnerHeight = window.innerHeight;
    var screenWidth = window.screen.width;
    var screenHeight = window.screen.height;
    /**
     * Initialize container and element.
     */
    var mainContainer = document.getElementById('main_container');
    var main = document.getElementById('main');
    var mainBlock = document.getElementById('main_block');
    var mainBgItem0 = document.getElementById('main_bg_item0');
    var mainBgItem1 = document.getElementById('main_bg_item1');
    var mainBgItem2 = document.getElementById('main_bg_item2');
    var mainBgBottom = document.getElementById('main_bg_bottom');
    /**
     * Resize event function.
     */
    var addEvent = function (object, type, callback) {
        if (object == null || typeof (object) == 'undefined') return;
        if (object.addEventListener) {
            object.addEventListener(type, callback, false);
        } else if (object.attachEvent) {
            object.attachEvent("on" + type, callback);
        } else {
            object["on" + type] = callback;
        }
    };
    /**
     * Style: size control code.
     */
    mainContainer.style.height = windowInnerHeight.toString() + "px";
    main.style.height = (window.innerHeight - 180).toString() + "px";
    mainBlock.style.margin = ((window.innerHeight - 554) / 2).toString() + "px" + " 0" + " 0 " + ((window.innerWidth - 740) / 2).toString() + "px";

    mainBgItem0.style.height = window.innerHeight.toString() + "px";
    mainBgItem1.style.height = window.innerHeight.toString() + "px";
    mainBgItem2.style.height = window.innerHeight.toString() + "px";
    mainBgBottom.style.height = window.innerHeight.toString() + "px";

    addEvent(window, "resize", function (event) {
        mainContainer.style.height = (window.innerHeight).toString() + "px";
        main.style.height = (window.innerHeight - 180).toString() + "px";
        mainBlock.style.margin = ((window.innerHeight - 554) / 2).toString() + "px" + " 0" + " 0 " + ((window.innerWidth - 740) / 2).toString() + "px";
        mainBgItem0.style.height = window.innerHeight.toString() + "px";
        mainBgItem1.style.height = window.innerHeight.toString() + "px";
        mainBgItem2.style.height = window.innerHeight.toString() + "px";
        mainBgBottom.style.height = window.innerHeight.toString() + "px";
    });
    /**
     * Style definition code, to set all li element's background style.
     */
    var bgImage = new Array("url(img/Tsukihime.full.1277383.jpg)", "url(img/Tsukihime.full.1369291.jpg)", "url(img/Tsukihime.full.1896863.jpg)");
    mainBgItem0.style.background = bgImage[0] + " no-repeat";
    mainBgItem1.style.background = bgImage[1] + " no-repeat";
    mainBgItem2.style.background = bgImage[2] + " no-repeat";
    
})();