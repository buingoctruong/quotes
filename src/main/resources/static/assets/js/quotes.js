var $lstItem = $('.lst-item');
var $quoteLstColors = ["rgb(255, 255, 255)","rgb(10,11,15)"];
var $authorLstColors = ["rgb(255, 119, 68)","rgb(0,0,0)"];
var $backgroundLstColors = ["rgb(255, 255, 255)","rgb(100, 100, 100)","rgb(255, 192, 109)","rgb(61, 203, 138)","rgb(61, 139, 195)"];
var $variableColor = "";
var $heightColumnOne = 0;
var $heightColumnTwo = 0;
var $heightColumnThree = 0;

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

/**
 * Set appropriate spanning to any masonry item
 *
 * Get different properties we already set for the masonry, calculate 
 * height or spanning for any cell of the masonry grid based on its 
 * content-wrapper's height, the (row) gap of the grid, and the size 
 * of the implicit row tracks.
 *
 * @param item Object A brick/tile/cell inside the masonry
 */
function resizeMasonryItem(item){
	/* Get the grid object, its row-gap, and the size of its implicit rows */
	var grid = document.getElementsByClassName('lst-item')[0],
		rowGap = parseInt(window.getComputedStyle(grid).getPropertyValue('grid-row-gap')),
		rowHeight = parseInt(window.getComputedStyle(grid).getPropertyValue('grid-auto-rows'));
  
	/*
	 * Spanning for any brick = S
	 * Grid's row-gap = G
	 * Size of grid's implicitly create row-track = R
	 * Height of item content = H
	 * Net height of the item = H1 = H + G
	 * Net height of the implicit row-track = T = G + R
	 * S = H1 / T
	 */
	var rowSpan = Math.ceil((item.querySelector('.item-content').getBoundingClientRect().height+rowGap)/(rowHeight+rowGap));
  
	/* Set the spanning as calculated above (S) */
	item.style.gridRowEnd = 'span '+rowSpan;
}

/**
 * Apply spanning to all the masonry items
 *
 * Loop through all the items and apply the spanning to them using 
 * `resizeMasonryItem()` function.
 *
 * @uses resizeMasonryItem
 */
function resizeAllMasonryItems(){
	// Get all item class objects in one list
	var allItems = document.getElementsByClassName('item');
  
	/*
	 * Loop through the above list and execute the spanning function to
	 * each list-item (i.e. each masonry item)
	 */
	for(var i=0;i<allItems.length;i++){
	  resizeMasonryItem(allItems[i]);
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
	window.addEventListener(event, resizeAllMasonryItems);
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