(function () {
    var addGoodsFunc = function () {
		var submitBtn = document.getElementById('submitBtn');
		var addGoodsBtn = document.getElementById('inputBtn');
		var gName = document.querySelector('#gName > span > input');
		var gPrice = document.querySelector('#gPrice > span > input');
        submitBtn.addEventListener('mouseover', function () {
            console.log('mouseover');
            addGoodsBtn.style.background = "#027daa";
            if (gName.value.trim() === "" || gPrice.value.trim() === "") {
                addGoodsBtn.setAttribute("disabled", "disabled");
            }
        });
        submitBtn.addEventListener('mouseout', function () {
            console.log('mouseout');
            addGoodsBtn.removeAttribute("disabled");
            addGoodsBtn.style.background = "red";
        });
        submitBtn.addEventListener('mousedown', function () {
            console.log('mousedown');
            addGoodsBtn.style.background = "#027dff";
        });
        submitBtn.addEventListener('mouseup', function () {
            console.log('mouseup');
            addGoodsBtn.style.background = "#027daa";
        });
    }
    window.onload = function () {
        addGoodsFunc();
    }
})()