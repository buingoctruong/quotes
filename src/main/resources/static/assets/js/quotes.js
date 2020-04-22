var $rowQuotes = $('.rowQuotes');
var $quoteColors = ["rgb(255, 255, 255)","rgb(10,11,15)"];
var $authorColors = ["rgb(255, 119, 68)","rgb(0,0,0)"];
var $backgroundColors = ["rgb(255, 255, 255)","rgb(87, 92, 126)", "rgb(100, 100, 100)"];

$(function() {
   boxList = document.getElementsByClassName('icon-box');
   for (var i = 0; i < boxList.length; i++) {
   		author = boxList[i].querySelector('.author-id');
   		quote = boxList[i].querySelector('.quote-id');
   		
   		color = getRandomColor($quoteColors);
   		quote.style.color = color;
   		
   		if (color === "rgb(255, 255, 255)") {
   			author.style.color = getRandomColor($authorColors);
   			boxList[i].style.backgroundColor = getRandomColor($backgroundColors.slice(1));
   		} else {
   			author.style.color = "rgb(255, 119, 68)";
   			boxList[i].style.backgroundColor = getRandomColor($backgroundColors.slice(0,-1));
   		}
   }
 });

$(window).scroll(function() {
	if($(window).scrollTop() == $(document).height() - $(window).height()) {
		var page = ($('.icon-box').length / 50) + 1;
		//console.log($rowQuotes.html());
		getQuotes(page.toString());
    }
});

function getQuotes(page) {
	$.ajax({
		type: "GET",
		url: "/quote/v1/quotes?page=" + page + "&per_page=",
		contentType: "application/json",
		success: function(data, textStatus, jqXHR) {
			var message = $rowQuotes.html();
			
			for (var i = 0; i < data.length; i++) {
				message = message
						+ '<div class="align-items-stretch" style="margin-bottom: 2.5em">\n'
						+ '<div class="icon-box">\n'
						+ '<h4><a class="quote-id" href="">' + data[i].content + '</a></h4>\n'
						+ '<p class="author-id">' + data[i].author.nam + '</p></div></div>\n'
			}
			$rowQuotes.html(message);			
	    },
		error: function(jqXHR, textStatus, errorThrown){
			console.log("========> " + errorThrown);
        }
	});
}

function getRandomColor(colors) {
  return colors[Math.floor(Math.random() * colors.length)];
}

