var $quoteLstColors = ["rgb(255, 255, 255)","rgb(10,11,15)"];
var $authorLstColors = ["rgb(255, 119, 68)","rgb(0,0,0)"];
var $backgroundLstColors = ["rgb(255, 255, 255)","rgb(100, 100, 100)","rgb(255, 192, 109)","rgb(61, 203, 138)","rgb(61, 139, 195)"];
var $variableColor = "";

$(function() {
   setRandomColor();
});

function getRandomColor(colors) {
  return colors[Math.floor(Math.random() * colors.length)];
}
 
function setRandomColor(page=1) {
   boxList = document.getElementsByClassName('icon-box');
   for (var i = (60*(page-1)); i < boxList.length; i++) {
   		author = boxList[i].querySelector('.quote-author');
   		quote = boxList[i].querySelector('.quote-content');
   		
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
						+ '<div class="item">\n'
						+ '<div class="item-content"><section class="icon-box">\n'
						+ '<h4 class="quote-content">' + data[i].content + '</h4>\n'
						+ '<p class="quote-author">' + data[i].author + '</p></section>\n'
						+ '<footer><button class="share-button">\n'
						+ '<i class="fa fa-share-alt fa-x"></i></button>\n'
						+ '<button class="exclam-button">\n'
						+ '<i class="fa fa-exclamation-circle fa-x"></i></button></footer></div></div>\n';
			}
			$lstItem.append(message);
			resizeAllMasonryItems();
			setRandomColor(page);
	    },
		error: function(jqXHR, textStatus, errorThrown){
			console.log(errorThrown);
        }
	});
}