// when opening modal, need to set default statuses
$("#modal-container").on('show.bs.modal', function(){
  $(".fa.fa-th-list").css("color", "#f74");
  $(".btn.all").css({"border-bottom-color": "#f74",
                    "border-bottom-width": "3px",
                    "border-bottom-style": "solid"});
  $(".customize-result").text("ALL RESULTS (0)");
  $(".empty-result").text("No results found.");
});

function setInitialStatusForFilterOption() {
  $(".filter-option.btn").css({"border-bottom-color": "#fff",
                              "border-bottom-width": "3px",
                              "border-bottom-style": "solid"});
  $(".filter-option.btn.fa").css('color', '');
}

function getAllResults() {
  setInitialStatusForFilterOption();
  $(".fa.fa-th-list").css("color", "#f74");
  $(".btn.all").css({"border-bottom-color": "#f74",
                    "border-bottom-width": "3px",
                    "border-bottom-style": "solid"});
}

function filterByAuthors() {
  setInitialStatusForFilterOption();
  $(".fa.fa-user").css("color", "#f74");
  $(".btn.authors").css({"border-bottom-color": "#f74",
                        "border-bottom-width": "3px",
                        "border-bottom-style": "solid"});
}

function filterByCollections() {
  setInitialStatusForFilterOption();
  $(".fa.fa-star").css("color", "#f74");
  $(".btn.collections").css({"border-bottom-color": "#f74",
                            "border-bottom-width": "3px",
                            "border-bottom-style": "solid"});
}

function filterByQuotes() {
  setInitialStatusForFilterOption();
  $(".fa.fa-quote-right").css("color", "#f74");
  $(".btn.quotes").css({"border-bottom-color": "#f74",
                        "border-bottom-width": "3px",
                        "border-bottom-style": "solid"});
}

function filterByTopics() {
  setInitialStatusForFilterOption();
  $(".fa.fa-folder").css("color", "#f74");
  $(".btn.topics").css({"border-bottom-color": "#f74",
                        "border-bottom-width": "3px",
                        "border-bottom-style": "solid"});
}