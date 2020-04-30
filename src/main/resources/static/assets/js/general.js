var $lstItem = $('.lst-item');

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

/**
 * Apply getting slugName from the link
 * 
 */
function getSlugNameFromLink(path) {
	var lastIndex = path.lastIndexOf("/");
	var nearLastIndex = path.lastIndexOf("/", lastIndex - 1);

	return path.substring(nearLastIndex + 1, lastIndex);
}
