var $lstItem = $('.lst-item');
var $quoteLstColors = ["rgb(255, 255, 255)","rgb(10,11,15)"];
var $authorLstColors = ["rgb(255, 119, 68)","rgb(0,0,0)"];
var $backgroundLstColors = ["rgb(255, 255, 255)","rgb(100, 100, 100)","rgb(255, 192, 109)","rgb(61, 203, 138)","rgb(61, 139, 195)"];
var $variableColor = "";
var $heightColumnOne = 0;
var $heightColumnTwo = 0;
var $heightColumnThree = 0;

$(function() {
   setHeight();
   setRandomColor();
});

function getRandomColor(colors) {
  return colors[Math.floor(Math.random() * colors.length)];
}
 
function setRandomColor(page=1) {
   boxList = document.getElementsByClassName('icon-box');
   for (var i = (60*(page-1)); i < boxList.length; i++) {
   		author = boxList[i].querySelector('.author-id');
   		quote = boxList[i].querySelector('.quote-id');
   		
   		var temp = getRandomColor($backgroundLstColors);
		while ($variableColor === temp) {
			temp = getRandomColor($backgroundLstColors);
		}
		
		if ($backgroundLstColors.slice(2).includes(temp)) {
			quote.style.color = $quoteLstColors[0];
   			author.style.color = $authorLstColors[1];
		} else if (temp === "rgb(100, 100, 100)") {
			quote.style.color = $quoteLstColors[0];
			author.style.color = $authorLstColors[0];
		} else {
			quote.style.color = $quoteLstColors[1];
			author.style.color = $authorLstColors[0];
		}
		
		boxList[i].style.backgroundColor = temp;
		$variableColor = temp;
   }
}

function setHeight(page=1) {
   itemList = document.getElementsByClassName('item');
   for (var i = (60*(page-1)); i < itemList.length; i+=3) {
   		$heightColumnOne += itemList[i].offsetHeight;
   		$heightColumnTwo += itemList[i+1] ? itemList[i+1].offsetHeight : 0;
   		$heightColumnThree += itemList[i+2] ? itemList[i+2].offsetHeight : 0;
   }
   var height = Math.max($heightColumnOne, $heightColumnTwo, $heightColumnThree);
   var margin = (itemList.length % 3) ? (Math.floor(itemList.length/3) + 1)*40 : (itemList.length/3)*40;
   $(".lst-item").css('height', (height + margin));
}

$(window).scroll(function() {
	if($(window).scrollTop() == $(document).height() - $(window).height()) {
		// get page number
		var page = ($('.icon-box').length / 60) + 1;
		getQuotes(page);
    }
});

function getQuotes(page) {
	$.ajax({
		type: "GET",
		url: "/quote/v1/quotes?page=" + page + "&per_page=",
		contentType: "application/json",
		success: function(data, textStatus, jqXHR) {
			var message = '';
			for (var i = 0; i < data.length; i++) {
				message = message
						+ '<div class="item" style="margin-bottom: 2.5em">\n'
						+ '<div class="icon-box">\n'
						+ '<h4><a class="quote-id" href="">' + data[i].content + '</a></h4>\n'
						+ '<p class="author-id">' + data[i].author.name + '</p></div></div>\n';
			}
			$lstItem.append(message);
			setHeight(page);
			setRandomColor(page);
	    },
		error: function(jqXHR, textStatus, errorThrown){
			console.log(errorThrown);
        }
	});
}
