/**
 * Created by RyougiChan on 2016/06/27
 * First edited by RyougiChan on 2016/06/27
 * Corresponding author: RyougiChan
 * Email: ryougi.chan.fire@gmail.com
 */

(function () {
    "use strict"
    /**
     *Initialize container and element
     */
    var mainContainer = document.getElementById('main_container');

    var bgImage =new Array("url(img/Tsukihime.full.1277383.jpg)", "url(img/Tsukihime.full.1369291.jpg)", "url(img/Tsukihime.full.1896863.jpg)");
    /**
     * Set background of main_container
     */
    var setMainContainerBg = function (url) {
        return function() {
            mainContainer.style.background = url + " no-repeat";
            mainContainer.style.backgroundSize = "cover";
        }
    };
    /**
     * Using setInterval(func, delay) method to simulate a cicle.
     */
	var bgChangeHandler = function () {
        var FRAG = 0;
		setInterval(function() {
            switch(FRAG) {
                case 0:
                    setTimeout(setMainContainerBg(bgImage[1]), 0);
                    FRAG = 1;
                break;
                case 1:
                    setTimeout(setMainContainerBg(bgImage[2]), 0);
                    FRAG = 2;
                break;
                case 2:
                    setTimeout(setMainContainerBg(bgImage[0]), 0);
                    FRAG = 0;
                break;
                default:
                    setTimeout(setMainContainerBg(bgImage[0]), 0);
                    FRAG = 0;
                break;
            }
        }, 5000);
	};

    bgChangeHandler();
    
})();