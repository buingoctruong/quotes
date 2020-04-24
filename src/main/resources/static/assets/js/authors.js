var $lstItem = $('.lst-item');
var $heightColumnOne = 0;
var $heightColumnTwo = 0;
var $heightColumnThree = 0;

$(function() {
   setHeight();
});

function setHeight() {
   itemList = document.getElementsByClassName('item');
   var heightPerItem = itemList[0].offsetHeight;
   var rows = (itemList.length % 3) ? (Math.floor(itemList.length/3) + 1) : (itemList.length/3)
   var height = heightPerItem * rows;
   var margin = rows*40;
   $(".lst-item").css('height', (height + margin));
}

$(window).scroll(function() {
	if($(window).scrollTop() == $(document).height() - $(window).height()) {
		// get page number
		var page = ($('.icon-box').length / 60) + 1;
		getAuthors(page);
    }
});

function getAuthors(page) {
	$.ajax({
		type: "GET",
		url: "/quote/v1/authors?page=" + page + "&per_page=",
		contentType: "application/json",
		success: function(data, textStatus, jqXHR) {
			var message = '';
			for (var i = 0; i < data.length; i++) {
				message = message
						+ '<div class="item" style="background-image:url(' + data[i].avatar + ');">\n'
						+ '<div class="icon-box">\n'
						+ '<div class="content">\n'
						+ '<h4 class="author-name">' + data[i].name + '</h4>\n'
						+ '<p class="quote-num">' + data[i].numQuotes + ' quotes</p></div></div></div>\n';
			}
			$lstItem.append(message);
			setHeight();
	    },
		error: function(jqXHR, textStatus, errorThrown){
			console.log(errorThrown);
        }
	});
}
