var $rowQuotes = $('.rowQuotes');
var $container = $('.container');
var $quoteLstColors = ["rgb(255, 255, 255)","rgb(10,11,15)"];
var $authorLstColors = ["rgb(255, 119, 68)","rgb(0,0,0)"];
var $backgroundLstColors = ["rgb(255, 255, 255)","rgb(100, 100, 100)","rgb(255, 192, 109)","rgb(61, 203, 138)","rgb(61, 139, 195)"];
var $variableColor = "";

$(function() {
   boxList = document.getElementsByClassName('icon-box');
   for (var i = 0; i < boxList.length; i++) {
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
 });

$(window).scroll(function() {
	if($(window).scrollTop() == $(document).height() - $(window).height()) {
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
						+ '<div class="align-items-stretch" style="margin-bottom: 2.5em">\n'
						+ '<div class="icon-box">\n'
						+ '<h4><a class="quote-id" href="">' + data[i].content + '</a></h4>\n'
						+ '<p class="author-id">' + data[i].author.name + '</p></div></div>\n';
			}
			$rowQuotes.append(message);
	    },
		error: function(jqXHR, textStatus, errorThrown){
			console.log("========> " + errorThrown);
        }
	});
}

function getRandomColor(colors) {
  return colors[Math.floor(Math.random() * colors.length)];
}

