var $authorSlugName;

$(function() {
	$authorSlugName = getSlugNameFromLink(window.location.pathname);
});

$(window).scroll(function() {
	if($(window).scrollTop() == $(document).height() - $(window).height()) {
		// get page number
		var page = ($('.icon-box').length / 60) + 1;

		getQuotesByAuthor(page);
    }
});

function getQuotesByAuthor(page) {
	$.ajax({
		type: "GET",
		url: "/quote/v1/quotes?author=" +  $authorSlugName + "&page=" + page + "&per_page=",
		contentType: "application/json",
		success: function(data, textStatus, jqXHR) {
			var message = '';
			for (var i = 0; i < data.length; i++) {
				message = message
						+ '<div class="item">\n'
						+ '<div class="item-content"><section class="icon-box">\n'
						+ '<h4 class="quote-content">' + data[i].content + '</h4>\n'
						+ '<p class="quote-author">' + data[i].author.name + '</p></section>\n'
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
