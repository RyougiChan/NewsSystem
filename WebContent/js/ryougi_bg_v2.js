/**
 * Created by RyougiChan on 2016/06/27
 * First edited by RyougiChan on 2016/06/27
 * Corresponding author: RyougiChan
 * Email: ryougi.chan.fire@gmail.com
 */

(function () {
    "use strict"
    /**
     * Initialize container and element
     */
    var mainBg = document.getElementById('main_bg');
    var bgList = document.querySelectorAll('#main_bg>ul>li');
    var mainBgItem0 = document.getElementById('main_bg_item0');
    var mainBgItem1 = document.getElementById('main_bg_item1');
    var mainBgItem2 = document.getElementById('main_bg_item2');

    var mainBgItem = new Array(mainBgItem0, mainBgItem1, mainBgItem2);
    var bgOpacity;
    var FRAG = 2;
    var returnDeVal;
    /**
     * Change value of opacity from "1" to "0" of a li element in 3000ms;
     * @param FRAG_DECREASE the specific li element to be set value of opacity
     */
    var setMainBgOpacityDecrease = function (FRAG_DECREASE) {

        bgOpacity = 101;

        returnDeVal = setInterval(function () {
            if (bgOpacity > 0) {
                bgOpacity--;
                mainBgItem[FRAG_DECREASE].style.opacity = bgOpacity / 100 + "";
            } else {
                clearInterval(returnDeVal);
            }
        }, 30);

    };
    /**
     * To make all li element visiable by setting value of opacity to "1"
     */
    var setAllBgVisiable = function () {
        mainBgItem2.style.opacity = "1";
        mainBgItem1.style.opacity = "1";
        mainBgItem0.style.opacity = "1";
    }
    /**
     * Select current visiable li element to change its value of opacity from "1" to "0" by calling setMainBgOpacityDecrease(FRAG).
     * FRAG == 0 means the last visable li element, when a setAllBgVisiable method should be called to set all li element's 
     * value of opacity to "1" to complete a cicle. There are 4500ms delay to make sure that the last li element's opacity has been
     * set to "0".
     * FRAG == 2 means the first visable li element.
     */
    var fragSelect = function () {
        return function () {
            switch (FRAG) {
                case 0:
                    setMainBgOpacityDecrease(0);
                    FRAG = 2;
                    setTimeout(setAllBgVisiable, 4500);
                    break;
                case 1:
                    setMainBgOpacityDecrease(1);
                    FRAG = 0;
                    break;
                case 2:
                    setMainBgOpacityDecrease(2);
                    FRAG = 1;
                    break;
                default:
                    break;
            }
        }
    }
    /**
     * Using a setInterval(func,delay) to simulate a cicle.
     */
    var bgChangeHandler = function () {
        setInterval(fragSelect(), 5000);
    };

    bgChangeHandler();

})();