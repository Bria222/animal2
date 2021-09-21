$(document).ready(function(){
// Animations init
new WOW().init();

var typed=new Typed(`#type`,{
     strings:[" Lets track our wildlife "," app developed by mary muthoni allows tracking of wildlife sightings . "],
     backSpeed:70,
     typeSpeed:80,
     smartBackspace:true,
     loop: true,
   })
   var typed =new Typed(`#msg`,{
        strings:[" Animal has been saved  "],
        backSpeed:70,
        typeSpeed:80,
        smartBackspace:true,
      })
})


function secondClick(){
timer:4000
Swal.fire(
  'View Animals?',
)
}

function firstClick(){
timer:4000
Swal.fire(
  'Add endangered?',

)
}
function thirdClick(){
timer:4000
Swal.fire(
  'Add Sighting?',

)
}







// Animations init
new WOW().init();