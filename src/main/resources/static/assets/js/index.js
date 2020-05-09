$(document).ready(function(){
  $(".filter-option .btn").hover(function(){
    $(this).css("border-bottom", "3px solid #f74");
    }, function(){
    $(this).css("border-bottom", "3px solid #fff");
  });
});

// when opening modal, need to set default statuses
$("#modal-container").on('show.bs.modal', function(){
  setInitialStatusForFilterOption();
  $(".fa.fa-th-list").css("color", "#f74");
  $(".customize-result").text("ALL RESULTS (0)");
  $(".empty-result").text("No results found.");
});

// Set initial statuses for filter options
function setInitialStatusForFilterOption() {
  $(".filter-option .btn .fa").css('color', '');
}

function getAllResults() {
  setInitialStatusForFilterOption();
  $(".fa.fa-th-list").css("color", "#f74");
}

function filterByAuthors() {
  setInitialStatusForFilterOption();
  $(".fa.fa-user").css("color", "#f74");
}

function filterByCollections() {
  setInitialStatusForFilterOption();
  $(".fa.fa-star").css("color", "#f74");
}

function filterByQuotes() {
  setInitialStatusForFilterOption();
  $(".fa.fa-quote-right").css("color", "#f74");
}

function filterByTopics() {
  setInitialStatusForFilterOption();
  $(".fa.fa-folder").css("color", "#f74");
}

function search() {
  var searchContent = document.getElementById("search-content").value;
  console.log('truong truong');

  $.ajax({
		type: "GET",
		url: "/quote/v1/search?search=" + searchContent,
		contentType: "application/json",
		success: function(data, textStatus, jqXHR) {
      console.log('success');
			console.log("====> data " + data);
	  },
		error: function(jqXHR, textStatus, errorThrown){
      console.log('fail');
			console.log(errorThrown);
    }
	});
}