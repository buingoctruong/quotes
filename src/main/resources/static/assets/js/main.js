var prevScrollpos = window.pageYOffset;

window.onscroll = function() {
  var currentScrollPos = window.pageYOffset;
  if (prevScrollpos > currentScrollPos) {
    document.getElementById("header").style.top = "0";
  } else {
    document.getElementById("header").style.top = "-50px";
  }
  prevScrollpos = currentScrollPos;
}

// Show dropdown social medial
// $( document ).ready(function() {

//   $('.social').prepend('<i class="fa fa-plus social-toggle"></i>');

//   // dropdown social medial
//   $('.social-toggle').click(function(){
//     $(this).toggleClass('fa-plus fa-minus');
//     $(".social-drop").slideToggle("200");
//   })

// });