$(window).scroll(function() {
	if($(window).scrollTop() == $(document).height() - $(window).height()) {
		// get page number
		var page = ($('.icon-box').length / 60) + 1;
		getCollections(page);
    }
});

function getCollections(page) {
	$.ajax({
		type: "GET",
		url: "/quote/v1/collections?page=" + page + "&per_page=",
		contentType: "application/json",
		success: function(data, textStatus, jqXHR) {
			var message = '';
			for (var i = 0; i < data.length; i++) {
				message = message
						+ '<div class="item"><div class="item-content">\n'
						+ '<section class="section-box" style="background-image:url(' + data[i].image + ');">\n'
						+ '<a href="/' + data[i].link + '" class="icon-box">\n'
						+ '<div class="icon-box-content">\n'
						+ '<h4 class="author-name">' + data[i].name + '</h4>\n'
						+ '<hr>\n'
						+ '<p class="quote-num">' + data[i].count + ' quotes</p></div></a></section>\n'
						+ '<footer><button class="share-button">\n'
						+ '<i class="fa fa-share-alt fa-x"></i></button>\n'
						+ '<button class="exclam-button">\n'
						+ '<i class="fa fa-exclamation-circle fa-x"></i></button></footer></div></div>\n';
			}
			$lstItem.append(message);
			resizeAllMasonryItems();
	    },
		error: function(jqXHR, textStatus, errorThrown){
			console.log(errorThrown);
        }
	});
}
