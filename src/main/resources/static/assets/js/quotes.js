var $lstItem = $('.lst-item');
var $quoteLstColors = ["rgb(255, 255, 255)","rgb(10,11,15)"];
var $authorLstColors = ["rgb(255, 119, 68)","rgb(0,0,0)"];
var $backgroundLstColors = ["rgb(255, 255, 255)","rgb(100, 100, 100)","rgb(255, 192, 109)","rgb(61, 203, 138)","rgb(61, 139, 195)"];
var $variableColor = "";
var $heightColumnOne = 0;
var $heightColumnTwo = 0;
var $heightColumnThree = 0;

$(function() {
//    setHeight();
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

function setHeight(page=1) {
   itemList = document.getElementsByClassName('item');
   for (var i = (60*(page-1)); i < itemList.length; i+=3) {
   		$heightColumnOne += itemList[i].offsetHeight;
   		$heightColumnTwo += itemList[i+1] ? itemList[i+1].offsetHeight : 0;
   		$heightColumnThree += itemList[i+2] ? itemList[i+2].offsetHeight : 0;
   }
   var height = Math.max($heightColumnOne, $heightColumnTwo, $heightColumnThree);
   var rows = (itemList.length % 3) ? (Math.floor(itemList.length/3) + 1) : (itemList.length/3)
   var margin = rows*40;
   $(".lst-item").css('height', (height + margin));
}

/**
 * Calculate the masonry
 *
 * Calculate the average of heights of masonry-bricks and then
 * set it as the height of the masonry element.	
 *
 * @param grid       Object  The Masonry Element 
 * @param gridCell   Object  The Masonry bricks
 * @param gridGutter Integer The Vertical Space between bricks 
 * @param dGridCol   Integer Number of columns on big screens
 * @param tGridCol   Integer Number of columns on medium-sized screens
 * @param mGridCol   Integer Number of columns on small screens
 */
function masonry(grid, gridCell, gridGutter, dGridCol, tGridCol, mGridCol) {
	var g = document.querySelector(grid),
		gc = document.querySelectorAll(gridCell),
		gcLength = gc.length, // Total number of cells in the masonry
		gHeight = 0, // Initial height of our masonry
		i; // Loop counter
	
	// Calculate the net height of all the cells in the masonry
	for(i=0; i<gcLength; ++i) {
	  gHeight+=gc[i].offsetHeight+parseInt(gridGutter);
	}
	
	/*
	 * Calculate and set the masonry height based on the columns
	 * provided for big, medium, and small screen devices.
	 */ 
	if(window.screen.width >= 1024) {
	  g.style.height = gHeight/dGridCol + gHeight/(gcLength+1) + "px";
	} else if(window.screen.width < 1024 && window.screen.width >= 768) {
	  g.style.height = gHeight/tGridCol + gHeight/(gcLength+1) + "px";
	} else {
	  g.style.height = gHeight/mGridCol + gHeight/(gcLength+1) + "px";
	}
}

/**
 * Reform the masonry
 *
 * Rebuild the masonry grid on every resize and load event after making sure 
 * all the images in the grid are completely loaded.
 */
["resize", "load"].forEach(function(event) {
	// Follow below steps every time the window is loaded or resized
	window.addEventListener(event, function() {
		/*
		* A maonsry grid with 40px gutter, with 3 columns on desktop,
		* 2 on tablet, and 1 column on mobile devices.
		*/
		masonry(".lst-item", ".item", 40, 3, 2, 1);
	});
});

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
						+ '<div><section class="icon-box">\n'
						+ '<h4 class="quote-content">' + data[i].content + '</h4>\n'
						+ '<p class="quote-author">' + data[i].author.name + '</p></section>\n'
						+ '<footer><button class="share-button">\n'
						+ '<i class="fa fa-share-alt fa-x"></i></button>\n'
						+ '<button class="exclam-button">\n'
						+ '<i class="fa fa-exclamation-circle fa-x"></i></button></footer></div></div>\n';
			}
			$lstItem.append(message);
			// setHeight(page);
			setRandomColor(page);
	    },
		error: function(jqXHR, textStatus, errorThrown){
			console.log(errorThrown);
        }
	});
}